/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "CloudLink.h"
#include "moc_CloudLink.cpp"

#include "GbCloud.h"
#include "GBoyFrames.h"
#include "GBoyLinkSession.h"

#include "ScriptedControl.h"
#include "GBoyMirror.h"
#include "DirectLink.h"
#include "KcpChannel.h"
#include "SioLinkHost.h"

#include <QDir>
#include <QFileInfo>

#include <QCoreApplication>
#include <QCryptographicHash>
#include <QDeadlineTimer>
#include <QEventLoop>
#include <QFile>
#include <QJsonArray>
#include <QJsonDocument>
#include <QJsonObject>
#include <QRandomGenerator>

#include <stdexcept>

#ifdef _WIN32
#include <winsock2.h>
#include <ws2tcpip.h>
#else
#include <arpa/inet.h>
#include <netinet/in.h>
#include <sys/socket.h>
#include <unistd.h>
typedef int SOCKET;
static void closesocket(int s) {
	close(s);
}
#endif

using namespace QGBA;

namespace {

constexpr int STEP_WAIT_MS = 20000;
constexpr int ROOM_WAIT_MS = 15000;
/** Public relay slots are recycled slowly; keep retrying for a while. */
constexpr int RELAY_WAIT_MS = 300000;
/**
 * How long to knock on the UDP relay node before giving up on it. The gboy.top
 * node only answers once both players have registered, but its ports have been
 * dead server-side for a while, so after this window the link falls back to
 * the websocket tunnel and play proceeds anyway.
 */
/* 12 秒只够「对方已经在房间里等」的情况；实测加入方从收到房号到连上
 * node 要 15~25 秒（大包 app 冷启动 + WS 建会话），房主早就放弃中继退回
 * 隧道了。这里放宽到 120 秒，让房主一直敲节点等对方来。 */
constexpr qint64 RELAY_WINDOW_MS = 120000;
/** Tunnel hello markers are re-sent at this pace until the peer answers. */
constexpr qint64 TUNNEL_HELLO_MS = 2000;
/** 紧凑信封单条最大载荷：20 字节 → 40 hex，整条 84 字符 < 100 字符上限。 */
constexpr int TUNNEL_CHUNK_BYTES = 20;
/** How long to wait for the peer's first key state before starting anyway. */
constexpr int PEER_KEY_WAIT_MS = 4000;

quint32 randomConv() {
	return QRandomGenerator::global()->generate() & 0x7FFFFFFF;
}

QJsonObject json(const QString& action, const QString& token, const QString& roomId) {
	QJsonObject object;
	object.insert("action", action);
	object.insert("token", token);
	if (!roomId.isEmpty()) {
		object.insert("room_id", roomId);
	}
	return object;
}

QJsonObject settingsJson(const QString& token, const QString& roomId) {
	QJsonObject object = json(QStringLiteral("update_room_settings"), token, roomId);
	object.insert("multi_game", 1);
	object.insert("is_udp", 1);
	object.insert("sync_modes", 1);
	object.insert("game_speed", 100);
	object.insert("network_buffer", 100);
	return object;
}

QJsonObject sendMessageJson(const QString& token, const QString& uuid, const QString& message) {
	QJsonObject object;
	object.insert("action", QStringLiteral("send_message"));
	object.insert("token", token);
	object.insert("message", message);
	object.insert("uuid", uuid);
	return object;
}

QJsonObject createJson(const QString& token, const QString& roomName) {
	QJsonObject object;
	object.insert("action", QStringLiteral("create_game_room"));
	object.insert("token", token);
	// create_game_room without game_name is dropped in silence by the room
	// server (no error frame comes back), which looks exactly like a dead
	// socket. Name the room after the loaded ROM.
	object.insert("room_name", roomName);
	return object;
}

QString wsText(const QJsonObject& object) {
	return QString::fromUtf8(QJsonDocument(object).toJson(QJsonDocument::Compact));
}

/**
 * The room server reports a rejected request as {"success":false,"error":"..."}.
 * Ignoring that field is what made a refused request look like a dead socket:
 * the client sat there waiting for a room id that was never going to come.
 */
QString serverError(const QJsonObject& object) {
	if (object.value("success").toBool(true)) {
		return QString();
	}
	QString message = object.value("error").toString().trimmed();
	if (message.isEmpty()) {
		message = object.value("message").toString().trimmed();
	}
	if (message.isEmpty()) {
		return QStringLiteral("服务器拒绝了请求");
	}
	// "您已有房间" is not a failure: that answer carries the old room id and
	// its node, and the caller needs it to dissolve the stale room.
	if (message.contains(QStringLiteral("已有房间"))) {
		return QString();
	}
	return message;
}

/** First non empty string among the given keys. */
QString firstString(const QJsonObject& object, const QStringList& keys) {
	for (const QString& key : keys) {
		QString value = object.value(key).toString().trimmed();
		if (!value.isEmpty()) {
			return value;
		}
	}
	return QString();
}

/** First positive integer among the given keys. */
int firstInt(const QJsonObject& object, const QStringList& keys) {
	for (const QString& key : keys) {
		QJsonValue value = object.value(key);
		if (value.isDouble()) {
			int number = value.toInt(0);
			if (number > 0) {
				return number;
			}
		}
	}
	return 0;
}

// ---- local loopback sockets for the SIO bridge (分开控制) ----

#ifdef _WIN32

void sockInit() {
	static bool done = []() {
		WSADATA data;
		return WSAStartup(MAKEWORD(2, 2), &data) == 0;
	}();
	(void)done;
}

#else

void sockInit() {
}

#endif

void sockClose(intptr_t s) {
	closesocket(static_cast<SOCKET>(s));
}

/** Blocks until a local host:port accepts, or ms passes. Returns the socket or -1. */
intptr_t sockConnectLocal(const char* host, quint16 port, int ms) {
	sockInit();
#ifdef _WIN32
	intptr_t s = static_cast<intptr_t>(socket(AF_INET, SOCK_STREAM, IPPROTO_TCP));
#else
	intptr_t s = static_cast<intptr_t>(socket(AF_INET, SOCK_STREAM, 0));
#endif
	if (s < 0) {
		return -1;
	}
	sockaddr_in addr;
	memset(&addr, 0, sizeof(addr));
	addr.sin_family = AF_INET;
	addr.sin_port = htons(port);
	inet_pton(AF_INET, host, &addr.sin_addr);
#ifdef _WIN32
	// Non-blocking connect with a select() wait, so a dead port fails fast.
	u_long mode = 1;
	ioctlsocket(static_cast<SOCKET>(s), FIONBIO, &mode);
	int rc = connect(static_cast<SOCKET>(s), reinterpret_cast<sockaddr*>(&addr), sizeof(addr));
	if (rc != 0) {
		fd_set wset;
		FD_ZERO(&wset);
		FD_SET(static_cast<SOCKET>(s), &wset);
		timeval tv{ms / 1000, (ms % 1000) * 1000};
		if (select(0, nullptr, &wset, nullptr, &tv) <= 0) {
			sockClose(s);
			return -1;
		}
	}
	mode = 0;
	ioctlsocket(static_cast<SOCKET>(s), FIONBIO, &mode);
#else
	timeval tv{ms / 1000, (ms % 1000) * 1000};
	if (setsockopt(static_cast<int>(s), SOL_SOCKET, SO_SNDTIMEO, &tv, sizeof(tv)) != 0) {
		sockClose(s);
		return -1;
	}
	if (connect(static_cast<int>(s), reinterpret_cast<sockaddr*>(&addr), sizeof(addr)) != 0) {
		sockClose(s);
		return -1;
	}
#endif
	return s;
}

/** Listens on 127.0.0.1:port; returns the listener socket or -1. */
intptr_t sockListenLocal(quint16 port) {
	sockInit();
#ifdef _WIN32
	intptr_t s = static_cast<intptr_t>(socket(AF_INET, SOCK_STREAM, IPPROTO_TCP));
#else
	intptr_t s = static_cast<intptr_t>(socket(AF_INET, SOCK_STREAM, 0));
#endif
	if (s < 0) {
		return -1;
	}
	int one = 1;
	setsockopt(static_cast<SOCKET>(s), SOL_SOCKET, SO_REUSEADDR,
	           reinterpret_cast<const char*>(&one), sizeof(one));
	sockaddr_in addr;
	memset(&addr, 0, sizeof(addr));
	addr.sin_family = AF_INET;
	addr.sin_port = htons(port);
	inet_pton(AF_INET, "127.0.0.1", &addr.sin_addr);
	if (bind(static_cast<SOCKET>(s), reinterpret_cast<sockaddr*>(&addr), sizeof(addr)) != 0
	    || listen(static_cast<SOCKET>(s), 1) != 0) {
		sockClose(s);
		return -1;
	}
	return s;
}

/** Blocks up to ms waiting for one connection on the listener. */
intptr_t sockAccept(intptr_t listener, int ms) {
	fd_set rset;
	FD_ZERO(&rset);
	FD_SET(static_cast<SOCKET>(listener), &rset);
	timeval tv{ms / 1000, (ms % 1000) * 1000};
	if (select(static_cast<int>(listener) + 1, &rset, nullptr, nullptr, &tv) <= 0) {
		return -1;
	}
#ifdef _WIN32
	return static_cast<intptr_t>(accept(static_cast<SOCKET>(listener), nullptr, nullptr));
#else
	return static_cast<intptr_t>(accept(static_cast<int>(listener), nullptr, nullptr));
#endif
}

/** Sends the whole buffer over the (blocking) socket. */
bool sockSendAll(intptr_t s, const uint8_t* data, size_t len) {
	size_t off = 0;
	while (off < len) {
#ifdef _WIN32
		int n = send(static_cast<SOCKET>(s), reinterpret_cast<const char*>(data + off),
		             static_cast<int>(len - off), 0);
#else
		ssize_t n = send(static_cast<int>(s), data + off, len - off, 0);
#endif
		if (n <= 0) {
			return false;
		}
		off += static_cast<size_t>(n);
	}
	return true;
}

/**
 * 隧道载荷解码：新版发十六进制，旧版发 base64。两种都认，省得一边升级一边断。
 * 纯 [0-9a-f] 且偶数长度 → 十六进制；否则按 base64 解。
 */
static QByteArray decodeTunnelPayload(const QByteArray& text) {
	if (text.isEmpty()) {
		return QByteArray();
	}
	bool hex = (text.size() % 2) == 0;
	for (char c : text) {
		bool isHex = (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
		if (!isHex) {
			hex = false;
			break;
		}
	}
	return hex ? QByteArray::fromHex(text) : QByteArray::fromBase64(text);
}

/**
 * Tunnel transport over the room signalling websocket: every GBoy frame
 * travels as a base64 JSON marker in a send_message broadcast, the same
 * channel that already carries the relay advertisement. TCP is ordered and
 * reliable, so no acks or retransmits are needed; the shared GBoyFrames reader
 * turns messages back into frames for expect() and serve().
 *
 * All reads happen on the worker thread, so the session stays single-consumer.
 */
class WsLink : public ILink {
public:
	WsLink(GbCloud::Session* sig, const QString& token, const QString& uuid,
	       const QString& roomTag, const QString& nonce)
		: m_sig(sig)
		, m_token(token)
		, m_uuid(uuid)
		, m_roomTag(roomTag)
		, m_nonce(nonce)
	{
	}

	bool peerSeen() const { return m_peerSeen; }

	QString errorText() const { return m_error; }

	void send(const QByteArray& payload) override {
		if (m_closed) {
			return;
		}
		m_lastFrameSend = QDateTime::currentMSecsSinceEpoch();
		// 两层服务器限制，信封必须同时绕开：
		// 1) 关键词过滤（"请勿发送违规内容。"）：随机 base64 迟早拼出 "sb"/"ass"
		//    片段，那一帧被吞、两端错位，游戏报「连接发生了错误」。十六进制只含
		//    [0-9a-f]，不可能命中含 s/b 等字母的词。
		// 2) 长度限制（"聊天内容超过100字符。"）：hex 是 40 字符，套长信封
		//    （gboy_ws/from/room 全拼出来）超过 100 字符，服务器整条拒收——
		//    13:41 那版就是这么全军覆没的。所以 hex 必须走短键名信封。
		// 短信封只在双方都是新版时使用（hello/accept 里的 "c":1 协商）：老版本
		// 只认长键名。老版本在场时退回 base64 长信封——能通，但保留关键词风险
		//（与老版本对老版本一致），这是唯一能让新旧互通的格式。
		QJsonObject marker;
		if (m_peerCompact) {
			marker.insert(QStringLiteral("w"), QStringLiteral("f"));
			if (!m_roomTag.isEmpty()) {
				marker.insert(QStringLiteral("r"), m_roomTag);
			}
			marker.insert(QStringLiteral("o"), m_nonce);
			// SIO 层可能一次吐出多帧拼在一起的载荷（实测两帧 40 字节 → 80 个
			// hex 字符 → 整条 124 字符被服务器拒收）。信道有序可靠，按 20 字节
			// 切片分条发送，对端把字节按到达顺序喂回流式拆包器即可无损还原。
			for (int off = 0; off < payload.size(); off += TUNNEL_CHUNK_BYTES) {
				QJsonObject chunk = marker;
				chunk.insert(QStringLiteral("d"), QString::fromLatin1(
				                                    payload.mid(off, TUNNEL_CHUNK_BYTES).toHex()));
				QString error;
				if (!m_sig->sendText(wsText(sendMessageJson(m_token, m_uuid, wsText(chunk))), &error)) {
					m_closed = true;
					m_error = QStringLiteral("服务器隧道发送失败：%1").arg(error);
					return;
				}
			}
			return;
		}
		marker.insert(QStringLiteral("gboy_ws"), QStringLiteral("f"));
		if (!m_roomTag.isEmpty()) {
			marker.insert(QStringLiteral("room"), m_roomTag);
		}
		marker.insert(QStringLiteral("from"), m_nonce);
		// base64 路径同样切片：多帧拼包时 28 字符会变 56，长信封也会破 100。
		// 每片独立 base64，对端逐条解码后按顺序喂回流式拆包器。
		for (int off = 0; off < payload.size(); off += TUNNEL_CHUNK_BYTES) {
			QJsonObject chunk = marker;
			chunk.insert(QStringLiteral("d"), QString::fromLatin1(
			                                    payload.mid(off, TUNNEL_CHUNK_BYTES).toBase64()));
			QString error;
			if (!m_sig->sendText(wsText(sendMessageJson(m_token, m_uuid, wsText(chunk))), &error)) {
				m_closed = true;
				m_error = QStringLiteral("服务器隧道发送失败：%1").arg(error);
				return;
			}
		}
	}

	bool recv(QByteArray* out, int timeoutMs) override {
		if (!m_inbox.isEmpty()) {
			*out = m_inbox.takeFirst();
			return true;
		}
		qint64 deadline = QDateTime::currentMSecsSinceEpoch() + qMax(timeoutMs, 1);
		while (!m_closed && m_sig->isOpen()) {
			qint64 remaining = deadline - QDateTime::currentMSecsSinceEpoch();
			if (remaining <= 0) {
				break;
			}
			maybeHello();
			QString text = m_sig->recv(int(qMin<qint64>(200, remaining)));
			if (text.isEmpty()) {
				continue;
			}
			demux(text);
			if (!m_inbox.isEmpty()) {
				*out = m_inbox.takeFirst();
				return true;
			}
		}
		if (!m_closed && !m_sig->isOpen()) {
			m_closed = true;
			m_error = QStringLiteral("服务器隧道连接中断");
		}
		return false;
	}

	bool isClosed() const override { return m_closed || !m_sig->isOpen(); }

	void close() override { m_closed = true; }

private:
	/** Greets every 2 seconds until the peer shows up. */
	void maybeHello() {
		qint64 now = QDateTime::currentMSecsSinceEpoch();
		if (m_peerSeen || m_closed || now - m_lastHello < TUNNEL_HELLO_MS) {
			return;
		}
		m_lastHello = now;
		sendMarker(QStringLiteral("hello"));
	}

	/** Parses one signalling push: tunnel data into the reader, greets answered. */
	void demux(const QString& text) {

		const auto objects = GbCloud::jsonObjects(text);
		for (const QJsonObject& object : objects) {
			// 服务器拒收我们的推流（关键词过滤/长度限制/限流）。这一帧就丢了，
			// 联机线随即错位，游戏会报「连接发生了错误」。与其让它悄悄烂掉，
			// 不如记下来、连挂三帧就带明确文案收尾。只统计紧跟在隧道帧发送
			// 之后 3 秒内的失败应答，免得用户手聊触发的错误误杀隧道。
			if (object.contains(QStringLiteral("success"))
			    && !object.value("success").toBool(true)) {
				QString err = object.value("error").toString();
				bool ours = QDateTime::currentMSecsSinceEpoch() - m_lastFrameSend < 3000;
				if (ours
				    && (err.contains(QStringLiteral("违规")) || err.contains(QStringLiteral("频繁"))
				        || err.contains(QStringLiteral("过快")) || err.contains(QStringLiteral("超过")))) {
					GbCloud::debugLog(QStringLiteral("tunnel push refused: ") + err);
					if (++m_refused >= 3 && !m_closed) {
						m_closed = true;
						m_error = QStringLiteral("联机数据被大厅服务器过滤（%1），请换个房间重试").arg(err);
					}
				}
				continue;
			}
			if (object.value("type").toString() != QStringLiteral("send_message")) {
				continue; // other pushes do not matter once data is flowing
			}
			QString message = object.value("message").toString();
			// 短信封数据帧没有 gboy_ws 键，只认它会把新版流量全漏掉；
			// 直连候选交换/切换标记同样只有短键名（"w":"p"/"s"…）。
			if (!message.contains(QStringLiteral("gboy_ws"))
			    && !message.contains(QStringLiteral("\"w\":\""))) {
				continue;
			}
			bool ok = false;
			QJsonObject marker = GbCloud::lastJsonObject(message, &ok);
			if (!ok) {
				continue;
			}
			QString kind = marker.value(QStringLiteral("gboy_ws")).toString();
			if (kind.isEmpty()) {
				kind = marker.value(QStringLiteral("w")).toString();
			}
			QString tagged = marker.value(QStringLiteral("room")).toString();
			if (tagged.isEmpty()) {
				tagged = marker.value(QStringLiteral("r")).toString();
			}
			if (!m_roomTag.isEmpty() && !tagged.isEmpty() && tagged != m_roomTag) {
				continue; // someone else's room
			}
			QString from = marker.value(QStringLiteral("from")).toString();
			if (from.isEmpty()) {
				from = marker.value(QStringLiteral("o")).toString();
			}
			if (!from.isEmpty() && (from == m_nonce || m_nonce.startsWith(from))) {
				continue; // the server echoed our own push back to us
			}
			if (kind != QStringLiteral("f")) {
				GbCloud::debugLog(QStringLiteral("[mark] me=%1 kind=%2 from=%3 tagged=%4 room=%5")
				                          .arg(m_nonce, kind, from, tagged, m_roomTag));
			}
			// 对端标记带 "c":1 说明它也是新版：能解十六进制、也认短键名信封，
			// 之后改发 hex 短信封。老版本没有这个键，保持 base64 长信封。
			if (marker.value(QStringLiteral("c")).toInt() == 1) {
				m_peerCompact = true;
			}
			if (kind == QStringLiteral("f")) {
				QByteArray frame = decodeTunnelPayload(
				        marker.value(QStringLiteral("d")).toString().toLatin1());
				if (!frame.isEmpty()) {
					m_inbox.append(frame);
				}
			} else if (kind == QStringLiteral("hello")) {
				m_peerSeen = true;
				qint64 now = QDateTime::currentMSecsSinceEpoch();
				if (now - m_lastAccept >= 1000) {
					m_lastAccept = now;
					sendMarker(QStringLiteral("accept"));
				}
			} else if (kind == QStringLiteral("accept")) {
				m_peerSeen = true;
			} else if (!kind.isEmpty()) {
				// 直连协商标记（候选地址 / 切换指令）：交给工作线程处理。
				GbCloud::debugLog(QStringLiteral("[demux] w=%1 o=%2 me=%3").arg(kind, from, m_nonce));
				m_control.append(qMakePair(kind, marker));
			}
		}
	}

public:
	/**
	 * 发一条自定义短键名标记（直连候选交换走这里）。载荷必须 ≤100 字符，
	 * 否则大厅服务器整条拒收。
	 */
	void sendRawMarker(const QJsonObject& marker) {
		if (!m_sig || !m_sig->isOpen()) {
			return;
		}
		m_sig->sendText(wsText(sendMessageJson(m_token, m_uuid, wsText(marker))));
	}

	/** 取一条待处理的直连协商标记；没有则返回 false。 */
	bool takeControl(QString* kind, QJsonObject* payload) {
		if (m_control.isEmpty()) {
			return false;
		}
		const auto pair = m_control.dequeue();
		*kind = pair.first;
		*payload = pair.second;
		return true;
	}

private:

	void sendMarker(const QString& kind) {
		QJsonObject marker;
		marker.insert(QStringLiteral("gboy_ws"), kind);
		if (!m_roomTag.isEmpty()) {
			marker.insert(QStringLiteral("room"), m_roomTag);
		}
		marker.insert(QStringLiteral("from"), m_nonce);
		// 能力协商：带 "c":1 表示"新版——能解十六进制、也认短键名信封"。
		// 不能再带 "e":"h"：13:41 那版看到对端 e:h 会把自己改发成超长 hex
		// 长信封（>100 字符），被服务器整条吞掉；新版靠 c:1 识别彼此，
		// 老版本一律回落 base64 长信封。
		marker.insert(QStringLiteral("c"), 1);
		m_sig->sendText(wsText(sendMessageJson(m_token, m_uuid, wsText(marker))));
	}

	GbCloud::Session* m_sig;
	QString m_token;
	QString m_uuid;
	QString m_roomTag;
	QString m_nonce;
	QQueue<QByteArray> m_inbox;
	QQueue<QPair<QString, QJsonObject>> m_control;
	bool m_closed = false;
	bool m_peerSeen = false;
	bool m_peerCompact = false;
	int m_refused = 0;
	QString m_error;
	qint64 m_lastHello = 0;
	qint64 m_lastAccept = 0;
	qint64 m_lastFrameSend = 0;
};

}

namespace QGBA {

static intptr_t attachDriverLoopback(SioLinkHost* cc, bool asHost, QString* error);

CloudLink::CloudLink(QObject* parent)
	: QThread(parent)
{
	m_remoteKeysEnabled = qgetenv("MGBAX_REMOTE_KEYS").toInt() != 0;
	// 官方 GBoy 布局：本机多核（可见核 + 隐藏镜像核走回环 SIO），网络只传
	// 按键掩码。安卓端默认开启（gboy_official_link=true），PC 端由环境变量
	// 打开——两端必须一致，否则同一条隧道上跑两套帧格式（现场教训：PC 发
	// 裸 MBL1 包、安卓发 GBoy 帧，9470 个碎片包把读线程活活耗死）。
	m_officialMode = qgetenv("MGBAX_OFFICIAL_LINK").toInt() != 0;
}

CloudLink::~CloudLink() {
	stopLink();
	wait(3000);
}

void CloudLink::startLink(const Config& config) {
	stopLink();
	m_config = config;
	m_closed.store(false, std::memory_order_relaxed);
	m_sendReset.store(false, std::memory_order_relaxed);
	m_initialStateSent.store(false, std::memory_order_relaxed);
	start();
}

void CloudLink::stopLink() {
	m_closed.store(true, std::memory_order_relaxed);
	if (!isRunning()) {
		return;
	}
	wait(5000);
	if (isRunning()) {
		terminate();
		wait(3000);
	}
	emit remoteKeys(0);
}

void CloudLink::sendReset() {
	m_sendReset.store(true, std::memory_order_relaxed);
}

void CloudLink::cleanupChannel() {
	if (m_channel) {
		m_channel->close();
		delete m_channel;
		m_channel = nullptr;
	}
}

bool CloudLink::waitAndProcess(int ms) {
	QDeadlineTimer deadline{qint64(ms)};
	while (!deadline.hasExpired()) {
		QCoreApplication::processEvents(QEventLoop::AllEvents, 20);
		if (m_closed.load(std::memory_order_relaxed)) {
			return false;
		}
		QThread::msleep(5);
	}
	return !m_closed.load(std::memory_order_relaxed);
}

void CloudLink::run() {
	// The room dance throws std::runtime_error when the server does not answer
	// in time. Letting that escape QThread::run() calls std::terminate and
	// takes the whole emulator down with it, so every failure is turned into
	// a readable status line instead.
	try {
		runLobby();
	} catch (const std::exception& e) {
		cleanupTunnel();
		stopOfficialMatch();
		m_session = nullptr;
		fail(QStringLiteral("联机流程中断：%1").arg(QString::fromUtf8(e.what())));
	} catch (...) {
		cleanupTunnel();
		stopOfficialMatch();
		m_session = nullptr;
		fail(QStringLiteral("联机流程出现未知错误"));
	}
}

void CloudLink::runLobby() {
	GbCloud::Session sig;
	if (m_config.roomId.startsWith(QStringLiteral("DBGJ:")) || m_config.roomId.startsWith(QStringLiteral("NODE2:"))) {
		runManual(m_config.roomId.mid(m_config.roomId.indexOf(':') + 1), false);
		return;
	}
	if (m_config.roomId.startsWith(QStringLiteral("DBG:")) || m_config.roomId.startsWith(QStringLiteral("NODE:"))) {
		runManual(m_config.roomId.mid(m_config.roomId.indexOf(':') + 1), true);
		return;
	}
	bool asHost = m_config.roomId.trimmed().isEmpty();
	status(QStringLiteral("正在登录联机大厅…"));
	QString error;
	QString token = GbCloud::login(m_config.user, m_config.password, &error);
	if (token.isEmpty()) {
		fail(error.isEmpty() ? QStringLiteral("登录失败") : error);
		return;
	}
	m_authToken = token;
	GbCloud::debugLog(QStringLiteral("login ok"));
	if (m_closed.load(std::memory_order_relaxed)) {
		return;
	}

	status(QStringLiteral("正在连接房间服务器…"));
	if (!sig.open(8000, &error)) {
		fail(error);
		return;
	}
	m_session = &sig;
	GbCloud::debugLog(QStringLiteral("websocket connected"));
	status(QStringLiteral("注意：联机大厅端口证书已过期，已降级连接"));
	if (m_closed.load(std::memory_order_relaxed)) {
		m_session = nullptr;
		return;
	}

	// The server binds the websocket session to a game identity only after an
	// explicit send_message carrying "GAME_CODE,ROM_MD5"; without it the room
	// server ignores everything that follows.
	QString uuid = gameUuid();
	m_wsNonce = QStringLiteral("%1").arg(QRandomGenerator::global()->generate(), 8, 16, QChar('0'));
	status(QStringLiteral("正在上传游戏身份…"));
	GbCloud::debugLog(QStringLiteral("upload identity ") + uuid);
	sig.sendText(wsText(sendMessageJson(token, uuid, QStringLiteral("go"))));
	waitAndProcess(1200);

	Room room;
	if (asHost) {
		// Order matters and was verified against the live server: the relay
		// node is NOT part of the first create_game_room answer. It only shows
		// up once the room has been joined, marked ready and switched to
		// multiplayer by update_room_settings.
		hostCreateRoom(&sig, token, uuid, &room);
	} else {
		status(QStringLiteral("正在加入房间 %1…").arg(m_config.roomId.trimmed()));
		sig.sendText(wsText(json(QStringLiteral("join_room"), token, m_config.roomId.trimmed())));
		waitAndProcess(1800);
		sig.sendText(wsText(json(QStringLiteral("ready"), token, QString())));
		waitAndProcess(1200);
		// The room server normally only tells the creator where the relay
		// lives, so the host advertises it over the broadcast channel instead.
		// Watch for that for a generous window.
		room.roomId = m_config.roomId.trimmed();
		waitForRoom(&sig, &room, room.roomId, 20000);
		if (room.nodeAddress.isEmpty() || room.nodePort <= 0) {
			// A missing relay address is no longer fatal: the data stage falls
			// back to the websocket tunnel, which needs no node at all.
			status(QStringLiteral("未获取到对方的中继地址，将使用服务器隧道模式"));
		}
	}
	if (m_closed.load(std::memory_order_relaxed)) {
		m_session = nullptr;
		return;
	}

	m_currentRoom = room;
	m_hostRole = asHost;
	m_advertiserUuid = uuid;
	// The host keeps re-broadcasting its relay endpoint so the joiner finds it
	// automatically; the worker-side pollSignaling does that every 2 seconds.
	m_isAdvertising = asHost;
	connectRelay(&sig, token, uuid, &m_currentRoom, asHost);
	m_session = nullptr;
}

void CloudLink::hostCreateRoom(GbCloud::Session* sig, const QString& token, const QString& uuid, Room* room) {
	// The room is bound to the account, so any stale room has to be dissolved
	// first: its relay node is a recycled port from the public pool and simply
	// times out (which looks like "the relay never answers"). leave_room only
	// works once the session has entered a room, hence the dance:
	//   create (asks for the old room id) -> join -> leave (room dissolves)
	//   -> create (fresh room + fresh node) -> join/ready/settings
	//   -> create (asks again, this time the answer carries the relay node)
	status(QStringLiteral("正在创建房间，等待服务器回应…"));
	GbCloud::debugLog(QStringLiteral("host: create room, game=") + gameName());
	sig->sendText(wsText(createJson(token, gameName())));
	waitAndProcess(2500);
	waitForRoomId(sig, room, 5000);
	if (!room->roomId.isEmpty()) {
		// A room left over from an earlier session has to be dissolved first:
		// its relay node is a recycled port from the public pool and simply
		// times out (which looks like "the relay never answers").
		status(QStringLiteral("正在清理上一次遗留的房间…"));
		GbCloud::debugLog(QStringLiteral("host: stale room ") + room->roomId);
		sig->sendText(wsText(json(QStringLiteral("join_room"), token, room->roomId)));
		waitAndProcess(1500);
		sig->sendText(wsText(json(QStringLiteral("leave_room"), token, QString())));
		waitAndProcess(1500);
		// The server dissolves the room when the host leaves; wait for it to
		// release the old node.
		waitAndProcess(800);
	}
	Room fresh;
	// The room server drops a create_game_room without game_name in silence,
	// so a create that does not come back is retried instead of being fatal.
	for (int attempt = 1; attempt <= 3 && fresh.roomId.isEmpty(); attempt++) {
		GbCloud::debugLog(QStringLiteral("host: create attempt %1").arg(attempt));
		sig->sendText(wsText(createJson(token, gameName())));
		waitAndProcess(2500);
		waitForRoomId(sig, &fresh, 6000);
	}
	if (fresh.roomId.isEmpty()) {
		throw std::runtime_error("服务器没有创建房间（已重试 3 次）");
	}
	room->roomId = fresh.roomId;
	room->nodeAddress.clear();
	room->nodePort = 0;
	GbCloud::debugLog(QStringLiteral("host: room ") + room->roomId);
	status(QStringLiteral("房间已创建，正在初始化联机设置…"));
	sig->sendText(wsText(json(QStringLiteral("join_room"), token, room->roomId)));
	waitAndProcess(1500);
	sig->sendText(wsText(json(QStringLiteral("ready"), token, QString())));
	waitAndProcess(1200);
	sig->sendText(wsText(settingsJson(token, room->roomId)));
	waitAndProcess(1500);
	status(QStringLiteral("正在获取中继节点…"));
	sig->sendText(wsText(createJson(token, gameName())));
	waitAndProcess(2500);
	waitForRoom(sig, room, QString(), ROOM_WAIT_MS);
	if (room->nodeAddress.isEmpty() || room->nodePort <= 0) {
		throw std::runtime_error("服务器没有返回中继节点");
	}
	GbCloud::debugLog(QStringLiteral("host: node ") + room->nodeAddress + QStringLiteral(":")
	                  + QString::number(room->nodePort));
}

void CloudLink::connectRelay(GbCloud::Session* sig, const QString& token, const QString& uuid,
                             Room* room, bool asHost) {
	status((asHost ? QStringLiteral("房间已创建，房号 ") : QStringLiteral("已加入房间 "))
	       + (room->roomId.isEmpty() ? QString() : room->roomId)
	       + (room->nodeAddress.isEmpty()
	              ? QString()
	              : QStringLiteral("\n中继 ") + room->nodeAddress + ":" + QString::number(room->nodePort))
	       + QStringLiteral("\n正在连接数据通道，等待对方…"));
	// Ask once for the current node: public nodes get recycled by the server,
	// the room may still exist but the node may have changed. When the peer is
	// already waiting on the tunnel, skip straight there.
	if (!m_tunnelPeerSeen) {
		QString fresh = currentNode(sig, token, room, asHost);
		if (!fresh.isEmpty()) {
			int colon = fresh.lastIndexOf(':');
			if (colon > 0) {
				bool ok = false;
				int port = fresh.mid(colon + 1).trimmed().toInt(&ok);
				if (ok) {
					room->nodeAddress = fresh.left(colon);
					room->nodePort = port;
				}
			}
		}
	}
	KcpChannel* link = nullptr;
	// 中继只试一次。以前"握不上就解散房间重建拿新节点"的玩法有两个致命副作用：
	//   1) 房主重建房间会把已经在房间里等着的对方踢出去（服务器直接解散旧房间）；
	//   2) 房号变了，两端的隧道 hello 打的是各自的房号，配对因此永远对不上。
	// 公共节点时好时坏是常态，拿不到节点或节点不应答就直接走服务器隧道——
	// 隧道不依赖节点，跨网一定能通，只是延迟比中继高一点。
	if (!room->nodeAddress.isEmpty() && room->nodePort > 0) {
		link = startRelayLink(room->nodeAddress, room->nodePort, room, sig, token, uuid, asHost,
		                      RELAY_WINDOW_MS);
	} else {
		status(QStringLiteral("没有可用的中继地址，直接使用服务器隧道模式"));
	}
	if (m_closed.load(std::memory_order_relaxed)) {
		if (link) {
			link->close();
			delete link;
		}
		return;
	}
	if (!link) {
		runTunnel(sig, token, room, asHost);
		return;
	}
	// 官方 KCP 中继活着：officialMode 走镜像按键布局（网络只传按键，
	// 两端各自全速跑），否则 SIO 分开控制模式把联机线字节过中继
	// （netLink 包封在 type-6 帧里），RTT 比 WS 隧道低 3-7 倍。
	if (m_officialMode) {
		startOfficialMatch(link, room);
		return;
	}
	QString error;
	intptr_t local = attachDriverLoopback(m_controller, asHost, &error);
	if (m_closed.load(std::memory_order_relaxed)) {
		if (local >= 0) {
			sockClose(local);
		}
		return;
	}
	if (local < 0) {
		link->close();
		delete link;
		m_channel = nullptr;
		fail(error.isEmpty() ? QStringLiteral("本机联机线建立失败") : error);
		return;
	}
	m_sioSock = local;
	status(QStringLiteral("SIO 链路已建立（官方中继，分开控制）\n")
	       + QStringLiteral("各自操作各自的画面，游戏内联机（交换/对战）走联机线\n")
	       + QStringLiteral("中继 ") + room->nodeAddress + ":" + QString::number(room->nodePort)
	       + QStringLiteral("\n云端联机已连接，你是 ")
	       + (asHost ? QStringLiteral("1P") : QStringLiteral("2P")));
	emit connected(asHost);
	startSioRelayBridge(link, local, sig, token, room, asHost);
}

QString CloudLink::currentNode(GbCloud::Session* sig, const QString& token, Room* room, bool creator) {
	Room probe;
	try {
		if (creator) {
			// The host asks the server directly for the current node.
			sig->sendText(wsText(createJson(token, gameName())));
			waitAndProcess(2000);
			waitForRoom(sig, &probe, room->roomId, 10000);
		} else {
			/* 加入方只能等房主的广播：房主进隧道等待后仍会每 8 秒广播一次
			 * 中继地址（降到 8 秒是为了不被判刷屏），所以窗口必须盖住它，
			 * 否则永远拿不到节点、只能退回 100 字符的聊天隧道。 */
			waitForRoom(sig, &probe, room->roomId, 14000);
		}
	} catch (...) {
		return QString();
	}
	if (probe.nodeAddress.isEmpty() || probe.nodePort <= 0) {
		return QString();
	}
	return probe.nodeAddress + ":" + QString::number(probe.nodePort);
}

/**
 * Connects to the public relay and completes the GBoy handshake.
 *
 * - The very same session (one conversation id, one UDP port) is reused for
 *   every retry; a retry that builds a brand new session fills the node's
 *   session table with half-open leftovers.
 * - The node only answers once the second player has registered, so the first
 *   handshake waits for the opponent. windowMs bounds how long we knock with
 *   no answer at all: past it the caller falls back to the websocket tunnel
 *   (returns null). Once the node did answer (HK), we stay on it and keep
 *   waiting as before.
 * - A node can be recycled by the server at any time, so every 30 seconds we
 *   re-resolve the node and switch over when it changed. While waiting we also
 *   watch the signalling stream for the peer's tunnel hello - seeing it means
 *   the peer has given up on the node, so there is no point in finishing the
 *   window.
 *
 * @return the connected link, or null when the node never answered and the
 *         caller should use the websocket tunnel instead.
 */
KcpChannel* CloudLink::startRelayLink(const QString& host, int port, Room* room,
                                      GbCloud::Session* sig, const QString& token,
                                      const QString& uuid, bool creator, qint64 windowMs) {
	qint64 deadline = QDateTime::currentMSecsSinceEpoch() + RELAY_WAIT_MS;
	qint64 windowEnd = QDateTime::currentMSecsSinceEpoch() + windowMs;
	qint64 started = QDateTime::currentMSecsSinceEpoch();
	qint64 nextQuery = 0;
	qint64 lastNotice = 0;
	qint64 lastHello = 0;
	qint64 firstTunnelPeer = 0;
	QString currentHost = host;
	int currentPort = port;
	KcpChannel* link = nullptr;
	bool registered = false;
	QString error;
	while (!m_closed.load(std::memory_order_relaxed) && QDateTime::currentMSecsSinceEpoch() < deadline) {
		if (!link) {
			link = KcpChannel::open(currentHost, quint16(currentPort), randomConv(), &error);
			if (!link) {
				if (QDateTime::currentMSecsSinceEpoch() >= windowEnd) {
					return nullptr;
				}
				waitAndProcess(1000);
				continue;
			}
			m_channel = link;
			registered = false;
		}
		if (link->retryHandshake(3000, &error)) {
			if (!registered) {
				sendRegister(link, room);
				registered = true;
			}
			try {
				// Short probe: the node answered HK but the peer may not have
				// registered, and a 20 s block here would make this side deaf
				// to the signalling stream - the peer could sit on the tunnel
				// (sending hellos this side never reads) until the 5 min
				// deadline. Probe for a few seconds, then greet and re-check.
				handshake(link, room, 4000);
				return link;
			} catch (std::exception& e) {
				// Already talking to the relay, but the peer has not registered
				// yet: keep the same session and keep waiting. Fall through so
				// the loop below still greets and watches for the tunnel peer.
				GbCloud::debugLog(QStringLiteral("relay handshake pending: ") + e.what());
			}
		}
		if (m_closed.load(std::memory_order_relaxed)) {
			break;
		}
		// Greet over the signalling channel and listen for the peer while the
		// window lasts; if the peer is already waiting on the tunnel there is
		// no point in finishing the window.
		qint64 now = QDateTime::currentMSecsSinceEpoch();
		if (sig && now - lastHello >= TUNNEL_HELLO_MS) {
			lastHello = now;
			sendWsMarker(sig, token, uuid, QStringLiteral("hello"), room->roomId);
			/* 房主在等对方期间必须继续广播中继地址。广播原来只写在 serve() 里，
			 * 而 serve() 要等数据通道建好才跑 —— 房主卡在 startRelayLink() 的
			 * 整段时间里没人广播，加入方拿不到 node_address，只能退回 WS 隧道；
			 * 房主又看到对方的隧道 hello 也退回隧道。两边互相礼让，永远用不上
			 * 低延迟中继（实测隧道 95~215ms，节点只有 30~38ms）。 */
			if (!room->nodeAddress.isEmpty() && room->nodePort > 0) {
				QJsonObject node;
				node.insert(QStringLiteral("gboy_node"),
				            room->nodeAddress + ":" + QString::number(room->nodePort));
				if (!room->roomId.isEmpty()) {
					node.insert(QStringLiteral("room"), room->roomId);
				}
				sig->sendText(wsText(sendMessageJson(token, uuid, wsText(node))));
			}
		}
		drainSignaling(sig, 120);
		if (m_tunnelPeerSeen) {
			/* 对端在隧道上发过 hello，只说明它的 hello 先到了，**不代表它
			 * 不肯连中继**：房主每 2 秒广播一次 node，加入方拿到广播后会自己
			 * 连上来。原来这里一看到 hello 就关掉中继、退回 WS 隧道，两端于是
			 * 互相礼让，永远停在高延迟通道上（实测 WS 隧道 95~215ms，而节点
			 * 只有 30~38ms）。改成给一段宽限窗口：窗口内对端连上中继就直接
			 * 用中继，过了还没连上再退回隧道。 */
			qint64 now2 = QDateTime::currentMSecsSinceEpoch();
			if (!firstTunnelPeer) {
				firstTunnelPeer = now2;
				GbCloud::debugLog(QStringLiteral("relay: peer hello on tunnel, grace window"));
			} else if (now2 - firstTunnelPeer > 8000) {
				status(QStringLiteral("对方已在服务器隧道上等待，放弃直连中继"));
				link->close();
				delete link;
				m_channel = nullptr;
				return nullptr;
			}
		}
		if (now >= windowEnd) {
			status(QStringLiteral("中继节点没有回应，自动切换到服务器隧道模式"));
			link->close();
			delete link;
			m_channel = nullptr;
			return nullptr;
		}
		// The node may have been recycled; re-resolve it periodically.
		if (sig && QDateTime::currentMSecsSinceEpoch() >= nextQuery) {
			nextQuery = QDateTime::currentMSecsSinceEpoch() + 30000;
			QString fresh = currentNode(sig, token, room, creator);
			if (!fresh.isEmpty()) {
				int colon = fresh.lastIndexOf(':');
				if (colon > 0) {
					bool ok = false;
					int freshPort = fresh.mid(colon + 1).trimmed().toInt(&ok);
					QString freshHost = fresh.left(colon);
					if (ok && (freshHost != currentHost || freshPort != currentPort)) {
						status(QStringLiteral("中继节点已更新为 ") + fresh + QStringLiteral("，正在切换…"));
						link->close();
						delete link;
						link = nullptr;
						m_channel = nullptr;
						currentHost = freshHost;
						currentPort = freshPort;
						room->nodeAddress = freshHost;
						room->nodePort = freshPort;
						continue;
					}
				}
			}
		}
		if (QDateTime::currentMSecsSinceEpoch() - lastNotice >= 5000) {
			lastNotice = QDateTime::currentMSecsSinceEpoch();
			long waited = long((QDateTime::currentMSecsSinceEpoch() - started) / 1000);
			status(QStringLiteral("房号 ") + (room->roomId.isEmpty() ? QString() : room->roomId)
			       + QStringLiteral("\n中继还没有回应（已等待 ") + QString::number(waited) + QStringLiteral(" 秒）\n")
			       + QStringLiteral("稍后将自动改用服务器隧道（跨网可联）"));
		}
		waitAndProcess(1000);
	}
	if (link) {
		link->close();
		delete link;
		m_channel = nullptr;
	}
	return nullptr;
}

// ---- websocket tunnel ----

/**
 * UDP 中继连不上时的数据通道：直接复用与信令服务器的 websocket 会话。
 * WS 是出站 TCP，不受 NAT/UDP 限制，跨网天然可用；代价是延迟略高。
 *
 * 配对时序：双方互发 hello（room 标记过滤），见到对方即回 accept。配对后
 * 进入 SIO 联机线模式（分开控制）：按键不再通过网络合并，每台设备只控制
 * 自己的画面；两台设备的游戏通过 native 联机线驱动（sioLinkHost/Join，本机
 * TCP 环回 + 这条隧道透传字节）互联，游戏内交换/对战走真正的 SIO。
 */
/**
 * 直连加速（P2P）：隧道已经配对上之后，先花几秒试试两个玩家之间能不能
 * 直接通 UDP，而不是把每个字节都绕一趟 gboy.top。
 *
 * 为什么要做：实测大厅隧道单向 89 ms、一个 SIO 回合（1P 发字 → 2P 回字）
 * 165 ms（`tunnel_rtt.py`）。联机线是严格一问一答，165 ms 的回合直接把
 * 游戏变成慢放。直连把服务器这一跳砍掉。
 *
 * 时序（双方都在新版才走）：
 *   - 各自把候选地址（网卡 + STUN 公网映射）用 "w":"p" 标记发给对端；
 *   - 收到对方候选后开始打洞（每 100 ms 一个 PROBE，收到 RESP 即双向可达）；
 *   - 1P 打通并且 RTT 明显好于隧道 → 发 "s"(switch)；2P 收到且自身也通 →
 *     回 "s2" 并切换；1P 收到 "s2" 切换。拿不到 "s2" 就发 "s3" 放弃，
 *     留在隧道里（老版本对端根本不会回 "p"，2.5 秒内直接放弃）。
 */
ILink* CloudLink::tryDirectLink(GbCloud::Session* sig, const QString& token, Room* room,
                                ILink* tunnelLink, bool asHost) {
	Q_UNUSED(sig);
	Q_UNUSED(token);
	// 协商是对称的：谁先打通谁先发 s，另一方打通后补 s2。
	Q_UNUSED(asHost);
	// 排障开关：设了 MGBAX_NO_DIRECT=1 就只用服务器隧道（对称 NAT、
	// 企业网、或者怀疑直连有问题时用）。
	if (!qEnvironmentVariableIsEmpty("MGBAX_NO_DIRECT")) {
		return nullptr;
	}
	WsLink* tunnel = dynamic_cast<WsLink*>(tunnelLink);
	if (!tunnel) {
		return nullptr;
	}
	DirectLink* direct = new DirectLink();
	QString error;
	if (!direct->bind(&error)) {
		delete direct;
		return nullptr;
	}
	const QStringList mine = direct->candidates();
	const QString tag = m_wsNonce.left(4);
	GbCloud::debugLog(QStringLiteral("[direct] me=%1 候选 %2 / 本地端口 %3")
	                          .arg(m_wsNonce, mine.join(QLatin1Char(',')))
	                          .arg(direct->localPort()));
	status(QStringLiteral("正在协商直连加速（P2P，避开服务器中转）…"));

	auto sendMarker = [&](const QString& kind, const QString& payload) {
		QJsonObject marker;
		marker.insert(QStringLiteral("w"), kind);
		marker.insert(QStringLiteral("o"), tag);
		if (!room->roomId.isEmpty()) {
			marker.insert(QStringLiteral("r"), room->roomId);
		}
		if (!payload.isEmpty()) {
			marker.insert(QStringLiteral("a"), payload);
		}
		if (wsText(marker).size() > 94) {
			// 服务器对聊天内容有 100 字符上限：退到最短信封
			marker.remove(QStringLiteral("r"));
		}
		tunnel->sendRawMarker(marker);
	};

	qint64 started = QDateTime::currentMSecsSinceEpoch();
	qint64 deadline = started + 9000;
	qint64 lastAnnounce = 0;
	qint64 lastSwitch = 0;
	qint64 connectedAt = 0;
	int announceCount = 0;
	bool peerCandidates = false;
	bool peerWants = false;    // 对端发过 s：它已经打通，愿意切过来
	bool peerAgreed = false;   // 对端发过 s2：它已经收到我们的 s
	bool switchSent = false;
	bool approved = false;
	bool aborted = false;
	QByteArray discard;
	while (!m_closed.load(std::memory_order_relaxed)) {
		qint64 now = QDateTime::currentMSecsSinceEpoch();
		if (now >= deadline) {
			break;
		}
		tunnel->recv(&discard, 20);
		QString kind;
		QJsonObject marker;
		while (tunnel->takeControl(&kind, &marker)) {
			if (kind == QStringLiteral("p")) {
				if (!peerCandidates) {
					QStringList peer = marker.value(QStringLiteral("a")).toString()
					                       .split(QLatin1Char(','), Qt::SkipEmptyParts);
					if (!peer.isEmpty()) {
						GbCloud::debugLog(QStringLiteral("[direct] me=%1 对端候选 %2")
						                          .arg(m_wsNonce, peer.join(QLatin1Char(','))));
						direct->setPeerCandidates(peer);
						direct->startPunching();
						peerCandidates = true;
					}
				}
			} else if (kind == QStringLiteral("s")) {
				// 对端已打通并请求切过来；我们打通了就立刻答应
				peerWants = true;
				if (direct->connected()) {
					sendMarker(QStringLiteral("s2"), QString());
				}
			} else if (kind == QStringLiteral("s2")) {
				peerAgreed = true;
			} else if (kind == QStringLiteral("s3")) {
				aborted = true;
			}
		}
		if (aborted) {
			break;
		}
		if (!peerCandidates && now - started > 6000) {
			// 对端是老版本，不认识直连协商：不要拖住开局
			aborted = true;
			break;
		}
		// 候选公告一直发到决定切换为止：单条 send_message 可能因为对端当时
		// 正在做 STUN（几百毫秒不读 socket）而错过，只发一次就会双方僵住。
		// 每轮把候选顺序轮换一位，一是内容不同避免被服务器当重复消息丢掉，
		// 二是让不同网段优先级轮流试一遍（打洞对所有候选并发，顺序只影响取舍）。
		if (now - started <= 4000 && now - lastAnnounce >= 600) {
			lastAnnounce = now;
			QStringList kept = mine.mid(0, 3);
			if (kept.size() > 1) {
				int rot = announceCount++ % kept.size();
				for (int i = 0; i < rot; i++) {
					kept.append(kept.takeFirst());
				}
			}
			sendMarker(QStringLiteral("p"), kept.join(QLatin1Char(',')));
		}
		if (direct->connected()) {
			if (!connectedAt) {
				connectedAt = now;
			}
			// 双方都连通、且至少有一方表态过，才真切换：
			// 对称握手，任一条消息丢了下一轮还能补上。
			if ((peerWants || peerAgreed) && now - connectedAt >= 150) {
				approved = true;
			}
			// RTT 反而更差就留在隧道（例如一端挂着绕远的 VPN）
			bool better = direct->rttUs() == 0 || direct->rttUs() < 150000;
			if (!approved && better && now - lastSwitch >= 500) {
				lastSwitch = now;
				switchSent = true;
				sendMarker(QStringLiteral("s"), QString());
			}
		}
		if (approved) {
			break;
		}
		direct->pump(peerCandidates ? 20 : 5);
	}
	if (!approved) {
		GbCloud::debugLog(QStringLiteral("[direct] me=%1 放弃直连：peerCandidates=%2 connected=%3 switchSent=%4 peerWants=%5 peerAgreed=%6 aborted=%7")
		                          .arg(m_wsNonce).arg(peerCandidates).arg(direct->connected())
		                          .arg(switchSent).arg(peerWants).arg(peerAgreed).arg(aborted));
		if (switchSent) {
			sendMarker(QStringLiteral("s3"), QString());
		}
		direct->close();
		delete direct;
		return nullptr;
	}
	if (!approved) {
		GbCloud::debugLog(QStringLiteral("[direct] me=%1 放弃直连：peerCandidates=%2 connected=%3 switchSent=%4 aborted=%5")
		                          .arg(m_wsNonce).arg(peerCandidates).arg(direct->connected())
		                          .arg(switchSent).arg(aborted));
		if (asHost && switchSent) {
			sendMarker(QStringLiteral("s3"), QString());
		}
		direct->close();
		delete direct;
		return nullptr;
	}
	int rttMs = (direct->rttUs() + 500) / 1000;
	status(QStringLiteral("直连加速已启用（P2P %1，RTT %2 ms）\n")
	               .arg(direct->peerText())
	               .arg(rttMs)
	       + QStringLiteral("数据不再经过服务器中转，延迟比隧道低一个数量级"));
	return direct;
}

void CloudLink::runTunnel(GbCloud::Session* sig, const QString& token, Room* room, bool asHost) {
	const QString tag = room->roomId;
	status(QStringLiteral("正在通过服务器隧道等待对方进入（跨网可联）…"));
	WsLink* link = new WsLink(sig, token, m_advertiserUuid, tag, m_wsNonce);
	m_tunnel = link;
	m_tunnelUp = true;
	m_tunnelPeerSeen = false;
	qint64 deadline = QDateTime::currentMSecsSinceEpoch() + RELAY_WAIT_MS;
	qint64 lastNotice = 0;
	qint64 lastAdvertise = 0;
	QByteArray discard;
	while (!m_closed.load(std::memory_order_relaxed) && !link->isClosed() && !link->peerSeen()
	       && QDateTime::currentMSecsSinceEpoch() < deadline) {
		link->recv(&discard, 1000);
		qint64 now = QDateTime::currentMSecsSinceEpoch();
		// 房主在隧道等待期间继续广播中继地址，让加入方有机会走官方中继（快 3-7 倍）
		if (m_isAdvertising && sig && now - lastAdvertise >= 2000) {
			lastAdvertise = now;
			pollSignaling(sig, token, m_advertiserUuid, room);
		}
		if (!link->peerSeen() && now - lastNotice >= 10000) {
			lastNotice = now;
			status(QStringLiteral("隧道已就绪，等待对方进入（房号 %1）…").arg(tag));
		}
	}
	if (m_closed.load(std::memory_order_relaxed)) {
		cleanupTunnel();
		return;
	}
	if (!link->peerSeen()) {
		QString detail = link->errorText().isEmpty() ? QStringLiteral("隧道等待对方超时")
		                                             : link->errorText();
		cleanupTunnel();
		m_tunnelUp = false;
		fail(detail);
		return;
	}
	if (m_officialMode) {
		// 镜像按键布局不搞 P2P 直连：按键流走隧道就已经是全速，不值得为
		// 它再开一条直连（MGBAX_NO_DIRECT 场景下也不允许）。
		startOfficialMatch(link, room);
		cleanupTunnel();
		m_tunnelUp = false;
		return;
	}
	ILink* chosen = link;
	DirectLink* direct = static_cast<DirectLink*>(tryDirectLink(sig, token, room, link, asHost));
	if (direct) {
		chosen = direct;
	}
	startSioBridge(chosen, asHost);
	if (direct) {
		direct->close();
		delete direct;
	}
	cleanupTunnel();
	m_tunnelUp = false;
}

/**
 * 分开控制的 SIO 数据阶段：把 native 联机线驱动（NetLink）的字节流原样搬过
 * 隧道。本机侧用 127.0.0.1 环回与驱动对接，native 完全不用改：
 *
 *   1P: controller->lanLinkHost(P)   native 在本机监听 → 本线程连上去当客户端
 *   2P: 本线程监听 127.0.0.1:P       controller->lanLinkJoin("127.0.0.1", P) 连出来
 *   桥: 本地 socket 字节 ↔ WsLink('f' 标记 base64 块) ↔ 对端
 *
 * 桥不解析内容——两端 NetLink 自己握手、自己控节奏；隧道有序可靠，固定
 * 20 字节的 Packet 流原样到达。sioLinkPump 已在核心线程每帧驱动 SIO。
 * 整个泵跑在 CloudLink 工作线程上：QWebSocket 只能由创建它的线程使用。
 */
/** 本机回环：把 native 联机线驱动挂到 127.0.0.1 的 TCP 对上，返回驱动侧套接字。 */
static intptr_t attachDriverLoopback(SioLinkHost* cc, bool asHost, QString* error) {
	if (!cc) {
		if (error) {
			*error = QStringLiteral("模拟核心未就绪");
		}
		return -1;
	}
	constexpr quint16 SIO_PORT_BASE = 18765;
	constexpr int SIO_PORT_TRIES = 8;
	intptr_t local = -1;
	if (asHost) {
		for (int t = 0; t < SIO_PORT_TRIES && local < 0; t++) {
			quint16 port = quint16(SIO_PORT_BASE + t);
			if (!cc->sioHost(port)) {
				continue;
			}
			local = sockConnectLocal("127.0.0.1", port, 3000);
			if (local < 0) {
				cc->sioClose();
			}
		}
	} else {
		intptr_t listener = -1;
		quint16 port = 0;
		for (int t = 0; t < SIO_PORT_TRIES; t++) {
			port = quint16(SIO_PORT_BASE + t);
			listener = sockListenLocal(port);
			if (listener >= 0) {
				break;
			}
		}
		if (listener < 0) {
			if (error) {
				*error = QStringLiteral("本机联机线端口被占用");
			}
			return -1;
		}
		if (!cc->sioJoin(QStringLiteral("127.0.0.1"), port)) {
			sockClose(listener);
			if (error) {
				*error = QStringLiteral("无法启动本机联机线");
			}
			return -1;
		}
		local = sockAccept(listener, 10000); // native linkJoin 会连进来
		sockClose(listener);
	}
	if (local < 0 && error) {
		*error = QStringLiteral("本机联机线建立失败");
	}
	return local;
}

void CloudLink::startSioBridge(ILink* link, bool asHost) {
	QString error;
	intptr_t local = attachDriverLoopback(m_controller, asHost, &error);
	if (local < 0) {
		fail(error.isEmpty() ? QStringLiteral("本机联机线建立失败") : error);
		return;
	}
	m_sioSock = local;
	status(QStringLiteral("SIO 链路已建立（分开控制）\n")
	       + QStringLiteral("各自操作各自的画面，对方按键不再进入你的游戏\n")
	       + QStringLiteral("游戏内联机（交换/对战）走联机线\n")
	       + QStringLiteral("云端联机已连接，你是 ") + (asHost ? QStringLiteral("1P") : QStringLiteral("2P")));
	emit connected(asHost);
	// 单线程泵：select 本地 socket（出向）+ 短超时收对端（入向）。
	// 顺带量真实回合延迟：联机线严格一问一答，"本地发出去"到"对端下一块
	// 数据回到本地"的间隔就是玩家感知的那个延迟，直连和隧道用同一把尺子。
	qint64 lastTunnelPump = 0;
	qint64 lastSentMs = 0;
	qint64 gapSum = 0;
	int gapCount = 0;
	int gapPeak = 0;
	// 隧道片计数器：用来判定「PC 端对端队列恒为 0」到底是没收到字节，
	// 还是收到了但 20 字节包边界错位（netLink 读线程会打印 desync）。
	quint64 txBytes = 0;
	quint64 rxBytes = 0;
	int txShort = 0;
	int rxShort = 0;
	qint64 lastReport = QDateTime::currentMSecsSinceEpoch();
	// 直连是"锦上添花"层：它断了不该让整局游戏结束。下面的 cur 指向当前
	// 真正在用的通道，直连被看门狗关掉时自动滑回服务器隧道，本地驱动那
	// 个 socket 一直开着，对游戏来说只是变慢，不是断线。
	ILink* cur = link;
	while (!m_closed.load(std::memory_order_relaxed) && m_sioSock >= 0) {
		if (cur->isClosed()) {
			if (cur != m_tunnel && m_tunnel && !m_tunnel->isClosed()) {
				GbCloud::debugLog(QStringLiteral("[sio-bridge] me=%1 直连已断开，回落到服务器隧道")
				                          .arg(m_wsNonce));
				status(QStringLiteral("直连已断开，已自动回落到服务器隧道\n")
				       + QStringLiteral("联机不会中断，只是延迟会变高"));
				cur = m_tunnel;
				continue;
			}
			break;
		}
		fd_set rset;
		FD_ZERO(&rset);
		FD_SET(static_cast<SOCKET>(local), &rset);
		timeval tv{0, 0};
		if (select(static_cast<int>(local) + 1, &rset, nullptr, nullptr, &tv) > 0) {
			uint8_t buf[2048];
#ifdef _WIN32
			int n = recv(static_cast<SOCKET>(local), reinterpret_cast<char*>(buf), sizeof(buf), 0);
#else
			int n = int(recv(static_cast<int>(local), buf, sizeof(buf), 0));
#endif
			if (n <= 0) {
				break;
			}
			if (!lastSentMs) {
				lastSentMs = QDateTime::currentMSecsSinceEpoch();
			}
			QByteArray payload(reinterpret_cast<const char*>(buf), n);
			txBytes += static_cast<quint64>(n);
			if (n % TUNNEL_CHUNK_BYTES != 0) {
				++txShort;
			}
			cur->send(payload);
		}
		QByteArray pkt;
		if (cur->recv(&pkt, 20)) {
			rxBytes += static_cast<quint64>(pkt.size());
			if (pkt.size() % TUNNEL_CHUNK_BYTES != 0) {
				++rxShort;
			}
			if (lastSentMs) {
				int gap = int(QDateTime::currentMSecsSinceEpoch() - lastSentMs);
				lastSentMs = 0;
				if (gap >= 0 && gap < 3000) {
					gapSum += gap;
					if (gap > gapPeak) {
						gapPeak = gap;
					}
					++gapCount;
				}
			}
			if (!sockSendAll(local, reinterpret_cast<const uint8_t*>(pkt.constData()),
			                 static_cast<size_t>(pkt.size()))) {
				break;
			}
		}
		{
			qint64 now = QDateTime::currentMSecsSinceEpoch();
			if (now - lastReport >= 5000 && gapCount > 0) {
				GbCloud::debugLog(QStringLiteral("[sio-rtt] me=%1 n=%2 avg=%3ms peak=%4ms via=%5")
				                          .arg(m_wsNonce).arg(gapCount).arg(gapSum / gapCount)
				                          .arg(gapPeak)
				                          .arg(cur != m_tunnel ? QStringLiteral("p2p")
				                                               : QStringLiteral("tunnel")));
				GbCloud::debugLog(QStringLiteral("[sio-io] me=%1 tx=%2B rx=%3B short(tx/rx)=%4/%5")
				                          .arg(m_wsNonce).arg(txBytes).arg(rxBytes)
				                          .arg(txShort).arg(rxShort));
				lastReport = now;
				gapSum = 0;
				gapCount = 0;
				gapPeak = 0;
			}
		}
		// 走直连时隧道本身没人读，定期排空一下，别让服务器认为我们掉线
		// （大厅会踢掉不响应心跳的连接，而直连断开时要靠隧道继续玩）。
		if (m_tunnel && m_tunnel != cur) {
			qint64 now = QDateTime::currentMSecsSinceEpoch();
			if (now - lastTunnelPump >= 500) {
				lastTunnelPump = now;
				QByteArray junk;
				m_tunnel->recv(&junk, 0);
			}
		}
	}
	closeSio();
	if (!m_closed.load(std::memory_order_relaxed)) {
		fail(QStringLiteral("联机线连接已断开"));
	}
}

/**
 * SIO 分开控制模式走**官方 KCP 中继**时的桥：本地驱动的 netLink 包（20 字节）
 * 逐个封进 type-6（STATE）帧经中继转发给对方——官方中继对 type 1..6 是透明
 * 转发，两条客户端之间它就是一条字节管道。相比 WS 隧道，官方中继（阿里云
 * 上海）的 RTT 低 3-7 倍。
 *
 * <p>房主侧顺带保留节点广播（新加入方要靠它拿中继地址），并监听对方的隧道
 * hello——对方的中继不可达时会切到 WS 隧道，本端跟随切换。</p>
 */
void CloudLink::startSioRelayBridge(KcpChannel* link, intptr_t local,
                                    GbCloud::Session* sig, const QString& token,
                                    Room* room, bool asHost) {
	GBoyFrames::Reader relayReader;
	status(QStringLiteral("SIO 链路已建立（官方中继，分开控制）\n")
	       + QStringLiteral("各自操作各自的画面，游戏内联机（交换/对战）走联机线\n")
	       + QStringLiteral("中继 ") + room->nodeAddress + ":" + QString::number(room->nodePort)
	       + QStringLiteral("\n云端联机已连接，你是 ")
	       + (asHost ? QStringLiteral("1P") : QStringLiteral("2P")));
	emit connected(asHost);
	maybeSendInitialState([link](const QByteArray& frame) { link->send(frame); }, asHost);
	qint64 lastDrain = 0;
	while (!m_closed.load(std::memory_order_relaxed) && !link->isClosed() && m_sioSock >= 0) {
		// 出向：驱动包 → type-6 帧（套接字上有数据才发，select 探测）
		fd_set rset;
		FD_ZERO(&rset);
		FD_SET(static_cast<SOCKET>(local), &rset);
		timeval tv{0, 0};
		if (select(static_cast<int>(local) + 1, &rset, nullptr, nullptr, &tv) > 0) {
			uint8_t buf[2048];
#ifdef _WIN32
			int n = recv(static_cast<SOCKET>(local), reinterpret_cast<char*>(buf), sizeof(buf), 0);
#else
			int n = int(recv(static_cast<int>(local), buf, sizeof(buf), 0));
#endif
			if (n <= 0) {
				break;
			}
			// The receive side below expects a TYPE_STATE frame, so the send
			// side must wrap the raw netLink packet in one too. Sending bare
			// bytes (the old code) meant the peer's Reader saw them as a frame
			// length and dropped the whole stream.
			link->send(GBoyFrames::frame(GBoyFrames::TYPE_STATE,
			                            QByteArray(reinterpret_cast<const char*>(buf), n)));
		}
		// 入向：type-6 帧 → 还原驱动包 → 本地套接字
		QByteArray message;
		if (link->recv(&message, 20)) {
			relayReader.append(message.constData(), message.size());
			QByteArray body;
			while (!(body = relayReader.next()).isNull()) {
				if (GBoyFrames::typeOf(body) != GBoyFrames::TYPE_STATE) {
					continue; // 中继的握手残留/心跳推送：忽略
				}
				QByteArray packet = GBoyFrames::payloadOf(body);
				if (!packet.isEmpty()
				    && !sockSendAll(local, reinterpret_cast<const uint8_t*>(packet.constData()),
				                    static_cast<size_t>(packet.size()))) {
					break;
				}
			}
		}
		// 房主的节点广播 + 对方的隧道 hello 检测（跟随切隧道）
		qint64 now = QDateTime::currentMSecsSinceEpoch();
		if (now - lastDrain >= 400) {
			lastDrain = now;
			if (m_isAdvertising && sig) {
				pollSignaling(sig, token, m_advertiserUuid, room);
			}
			drainSignaling(sig, 20);
			if (m_tunnelPeerSeen) {
				status(QStringLiteral("对方中继不可达，切换到服务器隧道模式…"));
				closeSio();
				link->close();
				runTunnel(sig, token, room, asHost);
				return;
			}
		}
	}
	closeSio();
	if (!m_closed.load(std::memory_order_relaxed)) {
		fail(QStringLiteral("联机线连接已断开"));
	}
}

void CloudLink::closeSio() {
	intptr_t s = m_sioSock.exchange(-1);
	if (s >= 0) {
		sockClose(s);
	}
	if (m_controller) {
		m_controller->sioClose();
	}
}

/**
 * 官方 GBoy 布局（officialMode）的比赛循环：
 *
 *   本机：可见核 linkHost(127.0.0.1:P) ← 镜像核 linkJoin —— SIO 完全本地，
 *         游戏内联机（有线俱乐部/对战）就是两颗本地核在跑，零网络锁步
 *   网络：每 5 帧(12Hz)一把按键掩码 + 1Hz FPS + 一把 TYPE_STATE 开局快照
 *
 * 镜像核由 GBoyMirror 自己的线程推进（60fps，pumpLink 每帧），本地按键由
 * 前端的 pump 定时器喂进 m_localKeys，远端按键经 GBoyLinkSession 12Hz 采样
 * 后由镜像线程读走——两端各自全速跑，这就是「帧率和单机一样」的来源。
 */
void CloudLink::startOfficialMatch(ILink* link, Room* room) {
	const bool asHost = m_hostRole;
	status((asHost ? QStringLiteral("房间已创建，房号 ") : QStringLiteral("已加入房间 "))
	       + (room->roomId.isEmpty() ? QString() : room->roomId)
	       + QStringLiteral("\n官方镜像联机（本机多核，网络仅传按键）\n正在启动镜像核心…"));
	if (!m_controller) {
		fail(QStringLiteral("模拟核心未就绪"));
		return;
	}
	// 可见核当 1P 主机监听环回端口（finishFrame 每帧 pump 它），镜像核连进来。
	quint16 port = 0;
	for (int t = 0; t < 8; ++t) {
		quint16 candidate = quint16(18781 + t);
		if (m_controller->sioHost(candidate)) {
			port = candidate;
			break;
		}
	}
	if (!port) {
		fail(QStringLiteral("本机联机线端口被占用"));
		return;
	}
	m_mirrorSioPort = port;
	GBoyLinkSession::Events events;
	events.onReset = [this]() { emit remoteReset(); };
	events.onState = [this](const QByteArray& state) {
		// 官方语义：TYPE_STATE 只灌进镜像核（对方的控制台在本机的映像），
		// 绝不能灌进可见核——后者是玩家自己的进度。
		if (!m_mirror || !m_mirror->applyRemoteState(state)) {
			GbCloud::debugLog(QStringLiteral("TYPE_STATE not applied (no mirror console)"));
		}
	};
	events.onReady = [this]() { status(QStringLiteral("对方已就绪")); };
	events.onStatus = [this](const QString& text) {
		GbCloud::debugLog(QStringLiteral("[gboy-session] ") + text);
	};
	m_gboySession = new GBoyLinkSession(
	        [this, link](const QByteArray& frame) {
		        if (!m_closed.load(std::memory_order_relaxed) && !link->isClosed()) {
			        link->send(frame);
		        }
	        },
	        events, 1, 2);
	emit connected(asHost);
	m_mirror = new GBoyMirror(this);
	QString savePath = m_config.savePath;
	{
		// savePath 可能是目录（核心存档路径尚未定型）或为空：一律退化成
		// ROM 旁边的 <rom>.sav，那正是 updatePlayerSave 最终要写的地方。
		QFileInfo saveInfo(savePath);
		if (savePath.isEmpty() || !saveInfo.isFile()) {
			savePath = QFileInfo(m_config.romPath).dir().filePath(
			        QFileInfo(m_config.romPath).completeBaseName() + QStringLiteral(".sav"));
		}
	}
	QString mirrorRoot = QFileInfo(savePath).dir().filePath(QStringLiteral("mirror1"));
	QString error;
	if (!m_mirror->start(m_config.romPath, savePath, mirrorRoot, port, m_gboySession, &error)) {
		stopOfficialMatch();
		fail(error);
		return;
	}
	status(QStringLiteral("SIO 链路已建立（官方镜像，环回 %1）\n").arg(port)
	       + QStringLiteral("各自操作各自的画面，游戏内联机（交换/对战）走本机联机线\n")
	       + QStringLiteral("云端联机已连接，你是 ") + (asHost ? QStringLiteral("1P") : QStringLiteral("2P")));
	serveOfficial(link, room);
	stopOfficialMatch();
}

void CloudLink::serveOfficial(ILink* link, Room* room) {
	// 官方 12Hz 摇键节奏：onLocalFrame 按帧调用（这里用 ~60Hz 墙钟模拟帧
	// 节拍，等价安卓的 onLocalFrame 帧驱动），GBoyLinkSession 内部每 5 帧
	// 发一把本地按键并采样一把远端按键——正是官方客户端的 cadence。
	qint64 lastTick = 0;
	qint64 lastFps = 0;
	qint64 lastAdvertise = 0;
	// 每分钟一次的会话自检：对端按键积压/掉帧从会话里捞出来打日志。
	qint64 lastDiag = 0;
	/* 状态补发节奏：官方镜像模式下两端各自跑两个核，镜像核只靠对端按键复现
	 * 对方的进度，一旦某一方在菜单/连机里多走一步，两核就再也不会回到同一
	 * 子状态（实测 pc 恒 0）。官方客户端用 case 6 周期纠偏，这里照做。 */
	qint64 lastStateSync = 0;
	qint64 lastStatePoll = 0;
	while (!m_closed.load(std::memory_order_relaxed) && !link->isClosed()) {
		qint64 now = QDateTime::currentMSecsSinceEpoch();
		maybeSendInitialState([link](const QByteArray& frame) { link->send(frame); }, m_hostRole);
		/* 状态补发走「按需触发」而不是定时：整份存档几百 KB，经大厅 WS 隧道
		 * 传一次就会把本循环拖到 0.6fps（实测），周期发不可行。测试脚本在
		 * MGBAX_SCRIPT_DIR 下放 sync_state 文件即触发一次，发完删掉。 */
		if (now - lastStatePoll >= 250) {
			lastStatePoll = now;
			const QString dir = qEnvironmentVariable("MGBAX_SCRIPT_DIR");
			if (!dir.isEmpty()) {
				QFile trigger(dir + QStringLiteral("/sync_state"));
				if (trigger.exists()) {
					trigger.remove();
					if (sendStateSync([link](const QByteArray& frame) { link->send(frame); })) {
						GbCloud::debugLog(QStringLiteral("[gboy] state sync sent"));
					}
				}
			}
		}
		if (now - lastTick >= 16) {
			lastTick = now;
			/* 脚本注入（MGBAX_SCRIPT_DIR/keys）走的是 ScriptedControl 的
			 * addKey/clearKey，不进本对象的 m_localKeys（GUI 的 keyFeed 喂的
			 * 可能是另一个实例）。这里并进进程级掩码，保证线上帧带着真实按键。 */
			int keys = m_localKeys.load(std::memory_order_relaxed)
			         | ScriptedControl::globalMask();
			{
				static qint64 lastDiagKeys = 0;
				if (now - lastDiagKeys >= 500) {
					lastDiagKeys = now;
					QFile f(QStringLiteral("D:/mgba-android-version/.zcode-tmp/cloud2p/serve_keys.log"));
					if (f.open(QIODevice::Append | QIODevice::Text)) {
						f.write(QStringLiteral("frame=%1 local=%2 scripted=%3 keys=%4\n")
						            .arg(m_officialFrame).arg(m_localKeys.load())
						            .arg(ScriptedControl::globalMask()).arg(keys).toUtf8());
					}
				}
			}
			m_gboySession->onLocalFrame(++m_officialFrame, keys);
		}
		if (now - lastFps >= 1000) {
			lastFps = now;
			m_gboySession->sendFps(60);
		}
		if (m_sendReset.exchange(false, std::memory_order_relaxed)) {
			m_gboySession->sendReset();
		}
		// Host side: keep the signalling socket alive and re-broadcast the
		// relay endpoint (same duty cycle as the merged-keys serve()).
		if (m_isAdvertising && m_session && !m_tunnelUp && now - lastAdvertise >= 2000) {
			lastAdvertise = now;
			pollSignaling(m_session, m_authToken, m_advertiserUuid, room);
		}
		if (now - lastDiag >= 60000) {
			if (lastDiag) {
				GbCloud::debugLog(QStringLiteral("[gboy-io] frames=%1 dropped=%2 ready=%3")
				                          .arg(m_officialFrame)
				                          .arg(m_gboySession->droppedFrames())
				                          .arg(m_gboySession->isReady() ? 1 : 0));
			}
			lastDiag = now;
		}
		QByteArray message;
		if (!link->recv(&message, 30)) {
			continue;
		}
		m_reader.append(message.constData(), message.size());
		QByteArray body;
		while (!(body = m_reader.next()).isNull()) {
			m_gboySession->onFrameBody(body);
		}
	}
	if (link->isClosed() && !m_closed.load(std::memory_order_relaxed)) {
		fail(m_tunnelUp ? QStringLiteral("服务器隧道连接已断开") : QStringLiteral("中继连接已断开"));
	}
}

void CloudLink::stopOfficialMatch() {
	if (m_mirror) {
		m_mirror->stopMirror();
		delete m_mirror;
		m_mirror = nullptr;
	}
	if (m_gboySession) {
		delete m_gboySession;
		m_gboySession = nullptr;
	}
	if (m_mirrorSioPort) {
		m_mirrorSioPort = 0;
		if (m_controller) {
			m_controller->sioClose();
		}
	}
}

void CloudLink::cleanupTunnel() {
	if (m_tunnel) {
		m_tunnel->close();
		delete m_tunnel;
		m_tunnel = nullptr;
	}
}

void CloudLink::sendWsMarker(GbCloud::Session* sig, const QString& token, const QString& uuid,
                             const QString& kind, const QString& roomId) {
	if (!sig || !sig->isOpen()) {
		return;
	}
	QJsonObject marker;
	marker.insert(QStringLiteral("gboy_ws"), kind);
	if (!roomId.isEmpty()) {
		marker.insert(QStringLiteral("room"), roomId);
	}
	marker.insert(QStringLiteral("from"), m_wsNonce);
	marker.insert(QStringLiteral("c"), 1); // 新版能力协商（十六进制 + 短信封）
	sig->sendText(wsText(sendMessageJson(token, uuid, wsText(marker))));
}

void CloudLink::drainSignaling(GbCloud::Session* sig, int ms) {
	if (!sig || !sig->isOpen()) {
		return;
	}
	qint64 end = QDateTime::currentMSecsSinceEpoch() + ms;
	while (QDateTime::currentMSecsSinceEpoch() < end) {
		QString text = sig->recv(60);
		if (text.isEmpty()) {
			return;
		}
		if (isTunnelMarkerText(text)) {
			m_tunnelPeerSeen = true;
		}
	}
}

bool CloudLink::isTunnelMarkerText(const QString& text) {
	const auto objects = GbCloud::jsonObjects(text);
	for (const QJsonObject& object : objects) {
		if (object.value("type").toString() != QStringLiteral("send_message")) {
			continue;
		}
		QString message = object.value("message").toString();
		// 新版数据帧是短键名信封（"w":"f"），没有 gboy_ws 键
		if (!message.contains(QStringLiteral("gboy_ws"))
		    && !message.contains(QStringLiteral("\"w\":\"f\""))) {
			continue;
		}
		bool ok = false;
		QJsonObject marker = GbCloud::lastJsonObject(message, &ok);
		if (!ok) {
			continue;
		}
		QString from = marker.value(QStringLiteral("from")).toString();
		if (from.isEmpty()) {
			from = marker.value(QStringLiteral("o")).toString();
		}
		if (from.isEmpty() || from != m_wsNonce) {
			return true;
		}
	}
	return false;
}

void CloudLink::sendRegister(ILink* link, Room* room) {
	int players = qMax(1, room->playerCount);
	link->send(GBoyFrames::registerFrame(players, room->baseStateCount));
}

void CloudLink::handshake(ILink* link, Room* room, int waitMs) {
	// The cloud handshake of the official client:
	//   -> type 1, body: int playerCount, short 0, int baseStateCount
	//   <- type 3, body: int playerCount
	//   -> type 3, body: empty
	//   <- type 0, body: int (first key state of the peer)
	//   -> type 1, body: empty (acknowledgement)
	QByteArray count = expect(link, GBoyFrames::TYPE_READY, waitMs);
	int reported = GBoyFrames::intOf(count);
	if (reported > 0) {
		status(QStringLiteral("中继报告 %1 名玩家在线").arg(reported));
	}
	status(QStringLiteral("已注册到中继，等待对方…"));

	link->send(GBoyFrames::frame(GBoyFrames::TYPE_READY));
	// The node only pushes the peer's first key state once a second player has
	// registered, so blocking on it would make the host time out while it is
	// simply waiting for an opponent. Treat it as optional.
	try {
		expect(link, GBoyFrames::TYPE_KEYS, PEER_KEY_WAIT_MS);
	} catch (...) {
		// peer key not ready yet, continuing
	}
	link->send(GBoyFrames::frame(GBoyFrames::TYPE_REGISTER));
}

QByteArray CloudLink::expect(ILink* link, int type, int timeoutMs) {
	qint64 deadline = QDateTime::currentMSecsSinceEpoch() + timeoutMs;
	while (true) {
		QByteArray body = m_reader.next();
		if (!body.isNull()) {
			if (GBoyFrames::typeOf(body) == type) {
				return body;
			}
			handle(body);
			continue;
		}
		QByteArray message;
		int waitMs = int(qMax<qint64>(50, deadline - QDateTime::currentMSecsSinceEpoch()));
		if (!link->recv(&message, qMin(waitMs, 200))) {
			if (QDateTime::currentMSecsSinceEpoch() >= deadline) {
				throw std::runtime_error("等待中继回应超时");
			}
			continue;
		}
		m_reader.append(message.constData(), message.size());
	}
}

void CloudLink::serve(ILink* link) {
	qint64 lastKey = 0;
	qint64 lastFps = 0;
	qint64 lastAdvertise = 0;
	int sentKeys = -1;
	while (!m_closed.load(std::memory_order_relaxed) && !link->isClosed()) {
		qint64 now = QDateTime::currentMSecsSinceEpoch();
		maybeSendInitialState([link](const QByteArray& frame) { link->send(frame); }, m_hostRole);
		if (now - lastKey >= KEY_INTERVAL_MS) {
			int keys = m_localKeys.load(std::memory_order_relaxed);
			if (keys != sentKeys || now - lastKey >= 500) {
				sentKeys = keys;
				lastKey = now;
				link->send(GBoyFrames::frame(GBoyFrames::TYPE_KEYS, keys));
			}
		}
		if (now - lastFps >= 1000) {
			lastFps = now;
			link->send(GBoyFrames::frame(GBoyFrames::TYPE_FPS, 60));
		}
		if (m_sendReset.exchange(false, std::memory_order_relaxed)) {
			link->send(GBoyFrames::frame(GBoyFrames::TYPE_RESET, 0));
		}
		// Host side: keep the signalling socket alive and re-broadcast the
		// relay endpoint so the joiner can find it without manual entry. Not
		// on the tunnel - there WsLink::recv is the only reader of the socket.
		if (m_isAdvertising && m_session && !m_tunnelUp && now - lastAdvertise >= 2000) {
			lastAdvertise = now;
			pollSignaling(m_session, m_authToken, m_advertiserUuid, &m_currentRoom);
		}
		QByteArray message;
		if (!link->recv(&message, 50)) {
			continue;
		}
		m_reader.append(message.constData(), message.size());
		QByteArray body;
		while (!(body = m_reader.next()).isNull()) {
			handle(body);
		}
	}
	if (link->isClosed() && !m_closed.load(std::memory_order_relaxed)) {
		fail(m_tunnelUp ? QStringLiteral("服务器隧道连接已断开") : QStringLiteral("中继连接已断开"));
	}
}

void CloudLink::handle(const QByteArray& body) {
	int type = GBoyFrames::typeOf(body);
	if (type == GBoyFrames::TYPE_KEYS || type == GBoyFrames::TYPE_KEYS_LOCAL) {
		int keys = GBoyFrames::intOf(body);
		// See m_remoteKeysEnabled: keep receiving the frame (the relay uses it
		// to confirm the peer is alive) but never feed it to our own core.
		emit remoteKeys(m_remoteKeysEnabled ? keys : 0);
	} else if (type == GBoyFrames::TYPE_RESET) {
		emit remoteReset();
	} else if (type == GBoyFrames::TYPE_STATE) {
		// The SIO relay bridge also uses type 6 with a raw netLink packet and
		// no length header; stateOf() rejects those instead of loading garbage.
		QByteArray state = GBoyFrames::stateOf(body);
		if (!state.isEmpty()) {
			emit remoteState(state);
		}
	}
}

bool CloudLink::maybeSendInitialState(const std::function<void(const QByteArray&)>& send, bool asHost) {	if (!asHost || !m_stateSnapshot || m_initialStateSent.load(std::memory_order_relaxed)) {
		return false;
	}
	QByteArray state = m_stateSnapshot();
	if (state.isEmpty()) {
		return false;   // core not ready yet; retry on the next tick
	}
	m_initialStateSent.store(true, std::memory_order_relaxed);
	send(GBoyFrames::stateFrame(state));
	return true;
}

/* 官方 case 6：把本机可见核的即时存档推给对端，让对端的镜像核（= 本机这个
 * 玩家）停在同一幕。只在连接瞬间发一次时，对端镜像核会一直停在旧画面，
 * 两台机的两个核永远进不到同一连机子状态（实测 pc 恒 0、握手字恒为等待字）。
 * 这里供官方镜像模式按周期调用，host / joiner 都要发。 */
bool CloudLink::sendStateSync(const std::function<void(const QByteArray&)>& send) {
	if (!m_stateSnapshot) {
		return false;
	}
	QByteArray state = m_stateSnapshot();
	if (state.isEmpty()) {
		return false;
	}
	send(GBoyFrames::stateFrame(state));
	return true;
}

void CloudLink::pollSignaling(GbCloud::Session* sig, const QString& token, const QString& uuid, Room* room) {
	if (!sig || !sig->isOpen()) {
		return;
	}
	// Draining the websocket answers server pings and reads pushes; every two
	// seconds it re-sends the relay marker so the joiner stays in sync when
	// the node changes.
	sig->recv(30);
	if (room->nodeAddress.isEmpty() || room->nodePort <= 0) {
		return;
	}
	QString node = room->nodeAddress + ":" + QString::number(room->nodePort);
	QJsonObject marker;
	marker.insert("gboy_node", node);
	if (!room->roomId.isEmpty()) {
		marker.insert("room", room->roomId);
	}
	sig->sendText(wsText(sendMessageJson(token, uuid, wsText(marker))));
}

void CloudLink::waitForRoom(GbCloud::Session* sig, Room* room, const QString& roomId, int timeoutMs) {
	qint64 deadline = QDateTime::currentMSecsSinceEpoch() + timeoutMs;
	while (QDateTime::currentMSecsSinceEpoch() < deadline && !m_closed.load(std::memory_order_relaxed)) {
		QString text = sig->recv(200);
		if (text.isEmpty()) {
			continue;
		}
		// One frame can carry several answers, so every object in it has to be
		// looked at - the node address may not be the last one.
		const auto objects = GbCloud::jsonObjects(text);
		for (const QJsonObject& object : objects) {
			QString type = object.value("type").toString();
			QString failure = serverError(object);
			if (type == QStringLiteral("create_game_room")) {
				QString incomingRoomId = firstString(object, {QStringLiteral("room_id"),
				                                              QStringLiteral("roomId"),
				                                              QStringLiteral("room"),
				                                              QStringLiteral("id")});
				if (!incomingRoomId.isEmpty()) {
					room->roomId = incomingRoomId;
				}
				QString address = firstString(object, {QStringLiteral("node_address"),
				                                       QStringLiteral("nodeAddress"),
				                                       QStringLiteral("address"),
				                                       QStringLiteral("ip"),
				                                       QStringLiteral("host")});
				int port = firstInt(object, {QStringLiteral("node_port"),
				                             QStringLiteral("nodePort"),
				                             QStringLiteral("port")});
				if (!address.isEmpty() && port > 0) {
					room->nodeAddress = address;
					room->nodePort = port;
				}
				if (object.value("base_list").isArray()) {
					room->baseStateCount = object.value("base_list").toArray().size();
				}
				if (!failure.isEmpty() && incomingRoomId.isEmpty() && address.isEmpty()) {
					// The server refused the request outright; there is no
					// point in waiting for an answer that already arrived.
					throw std::runtime_error(failure.toStdString());
				}
			} else if (type == QStringLiteral("player_joined")) {
				if (object.value("users").isArray()) {
					int ready = 0;
					const auto users = object.value("users").toArray();
					for (const auto& userValue : users) {
						QJsonObject user = userValue.toObject();
						QString name = user.value("username").toString();
						if (name.isEmpty()) {
							continue;
						}
						if (user.value("started").toInt(0) != 0) {
							ready++;
						}
					}
					if (ready > 0) {
						room->playerCount = ready;
					}
				}
			} else if (type == QStringLiteral("room_started") || type == QStringLiteral("game_started")) {
				QString address = firstString(object, {QStringLiteral("node_address"),
				                                       QStringLiteral("nodeAddress"),
				                                       QStringLiteral("address"),
				                                       QStringLiteral("ip"),
				                                       QStringLiteral("host")});
				int port = firstInt(object, {QStringLiteral("node_port"),
				                             QStringLiteral("nodePort"),
				                             QStringLiteral("port")});
				if (!address.isEmpty() && port > 0) {
					room->nodeAddress = address;
					room->nodePort = port;
				}
			} else if (type == QStringLiteral("send_message")) {
				// The host advertises its relay endpoint through the broadcast
				// channel as {"gboy_node":"address:port","room":"<roomId>"}.
				// A {"gboy_ws":"hello|accept"} marker instead means the peer is
				// already waiting on the websocket tunnel - remember that so
				// the relay window is cut short. Skip our own echoes (the
				// server marks them, the marker carries our nonce).
				QString message = object.value("message").toString();
				if (message.contains(QStringLiteral("gboy_ws"))) {
					bool ok = false;
					QJsonObject marker = GbCloud::lastJsonObject(message, &ok);
					QString from = ok ? marker.value(QStringLiteral("from")).toString()
					                  : QString();
					if (!object.value("self").toBool(false)
					    && (from.isEmpty() || from != m_wsNonce)) {
						m_tunnelPeerSeen = true;
					}
				}
				if (message.contains(QStringLiteral("gboy_node"))) {
					bool markerOk = false;
					QJsonObject marker = GbCloud::lastJsonObject(message, &markerOk);
					if (markerOk) {
						QString node = marker.value("gboy_node").toString();
						QString tagged = marker.value("room").toString();
						int colon = node.lastIndexOf(':');
						if (colon > 0 && (tagged.isEmpty() || tagged == roomId)) {
							bool portOk = false;
							int port = node.mid(colon + 1).toInt(&portOk);
							if (portOk && port > 0) {
								room->nodeAddress = node.left(colon);
								room->nodePort = port;
							}
						}
					}
				}
			}
			// join_room, ready and friends report failures the same way. The
			// pushes (send_message, player_joined, user_join, user_leave) are
			// excluded: they are broadcasts, not the answer to our request.
			bool isPush = type == QStringLiteral("send_message")
			              || type == QStringLiteral("player_joined")
			              || type == QStringLiteral("user_join")
			              || type == QStringLiteral("user_leave");
			if (!failure.isEmpty() && type != QStringLiteral("create_game_room") && !isPush) {
				throw std::runtime_error(failure.toStdString());
			}
		}
		if (!room->nodeAddress.isEmpty() && room->nodePort > 0) {
			return;
		}
		/* 以前看到对端的隧道 hello 就直接放弃等 node——但 hello 只说明它
		 * 先起了隧道，房主进隧道等待后仍会每 8 秒广播中继地址。提前退出
		 * 的结果是永远退回 100 字符的聊天隧道（延迟抖动 ±200ms，锁步会
		 * 互相 park 死）。现在只要没拿到 node 就等满窗口。 */
	}
}

void CloudLink::waitForRoomId(GbCloud::Session* sig, Room* room, int timeoutMs) {
	qint64 deadline = QDateTime::currentMSecsSinceEpoch() + timeoutMs;
	while (QDateTime::currentMSecsSinceEpoch() < deadline && !m_closed.load(std::memory_order_relaxed)) {
		QString text = sig->recv(200);
		if (text.isEmpty()) {
			continue;
		}
		for (const QJsonObject& object : GbCloud::jsonObjects(text)) {
			if (object.value("type").toString() != QStringLiteral("create_game_room")) {
				continue;
			}
			QString incomingRoomId = firstString(object, {QStringLiteral("room_id"),
			                                              QStringLiteral("roomId"),
			                                              QStringLiteral("room"),
			                                              QStringLiteral("id")});
			if (!incomingRoomId.isEmpty()) {
				room->roomId = incomingRoomId;
			}
			QString address = firstString(object, {QStringLiteral("node_address"),
			                                       QStringLiteral("nodeAddress"),
			                                       QStringLiteral("address"),
			                                       QStringLiteral("ip"),
			                                       QStringLiteral("host")});
			int port = firstInt(object, {QStringLiteral("node_port"),
			                             QStringLiteral("nodePort"),
			                             QStringLiteral("port")});
			if (!address.isEmpty() && port > 0) {
				room->nodeAddress = address;
				room->nodePort = port;
			}
			QString failure = serverError(object);
			if (!failure.isEmpty() && incomingRoomId.isEmpty() && address.isEmpty()) {
				throw std::runtime_error(failure.toStdString());
			}
		}
		if (!room->roomId.isEmpty()) {
			return;
		}
	}
}

void CloudLink::runManual(const QString& nodeSpecIn, bool asHost) {
	QString nodeSpec = nodeSpecIn;
	quint32 explicitConv = 0;
	bool hasConv = false;
	int hash = nodeSpec.indexOf('#');
	if (hash > 0) {
		explicitConv = quint32(nodeSpec.mid(hash + 1).trimmed().toUInt());
		hasConv = true;
		nodeSpec = nodeSpec.left(hash);
	}
	bool tcp = nodeSpec.startsWith(QStringLiteral("tcp:"), Qt::CaseInsensitive);
	if (tcp) {
		nodeSpec = nodeSpec.mid(4);
	}
	int colon = nodeSpec.lastIndexOf(':');
	if (colon < 1) {
		fail(QStringLiteral("中继地址格式应为 地址:端口"));
		return;
	}
	QString host = nodeSpec.left(colon);
	int port = nodeSpec.mid(colon + 1).toInt();
	status(QStringLiteral("手动中继：直连 ") + host + ":" + QString::number(port)
	       + (tcp ? QStringLiteral("（TCP）") : QString())
	       + (hasConv ? QStringLiteral(" conv=%1").arg(explicitConv) : QString())
	       + (asHost ? QStringLiteral("（1P）") : QStringLiteral("（2P）")));
	Room room;
	room.nodeAddress = host;
	room.nodePort = port;
	room.playerCount = 2;
	QString error;
	KcpChannel* link = nullptr;
	if (tcp) {
		// A tunnel endpoint is a plain TCP listener: no session table, no
		// silent drops, so the retry dance is unnecessary there.
		link = KcpChannel::openTcp(host, quint16(port), &error);
		if (!link) {
			fail(error);
			return;
		}
		m_channel = link;
		if (!link->handshake(3, 3000, &error)) {
			fail(error);
			return;
		}
		sendRegister(link, &room);
		try {
			handshake(link, &room);
		} catch (std::exception& e) {
			fail(QString::fromUtf8(e.what()));
			return;
		}
	} else {
		link = KcpChannel::open(host, quint16(port), hasConv ? explicitConv : randomConv(), &error);
		if (!link) {
			fail(error);
			return;
		}
		m_channel = link;
		if (!link->handshake(3, 3000, &error)) {
			fail(error);
			return;
		}
		sendRegister(link, &room);
		try {
			handshake(link, &room);
		} catch (std::exception& e) {
			fail(QString::fromUtf8(e.what()));
			return;
		}
	}
	status(QStringLiteral("云端联机已连接，你是 ") + (asHost ? QStringLiteral("1P") : QStringLiteral("2P"))
	       + QStringLiteral("（手动中继）"));
	serve(link);
	cleanupChannel();
}

QString CloudLink::gameName() const {
	QString path = m_config.romPath;
	if (path.isEmpty()) {
		return QStringLiteral("mGBA");
	}
	int slash = qMax(path.lastIndexOf('/'), path.lastIndexOf('\\'));
	QString name = slash >= 0 ? path.mid(slash + 1) : path;
	int dot = name.indexOf('.');
	if (dot > 0) {
		name = name.left(dot);
	}
	return name.isEmpty() ? QStringLiteral("mGBA") : name;
}

QString CloudLink::gameUuid() const {
	QString path = m_config.romPath;
	if (path.isEmpty()) {
		return QStringLiteral("BPEE,");
	}
	QFile rom(path);
	if (!rom.open(QIODevice::ReadOnly)) {
		return QStringLiteral("BPEE,");
	}
	// The game identity the room server expects: the four character game code
	// of the ROM header followed by the MD5 of the ROM, e.g.
	// "BPEE,55c9004420cd750f03192bc20569e1ab".
	QByteArray head;
	head.resize(0xB0);
	qint64 got = rom.read(head.data(), head.size());
	head.resize(int(got));
	QCryptographicHash hasher(QCryptographicHash::Md5);
	hasher.addData(head);
	char buffer[65536];
	qint64 n;
	while ((n = rom.read(buffer, sizeof(buffer))) > 0) {
		hasher.addData(buffer, int(n));
	}
	QString hex = QString::fromLatin1(hasher.result().toHex());
	QString code;
	for (int i = 0xAC; i < 0xB0 && i < head.size(); i++) {
		char c = head[i];
		code.append(c >= 0x20 && c < 0x7F ? QChar(c) : QChar('0'));
	}
	QString prefix = code.size() == 4 ? code : QStringLiteral("BPEE");
	return prefix + "," + hex;
}

void CloudLink::fail(const QString& text) {
	m_closed.store(true, std::memory_order_relaxed);
	emit remoteKeys(0);
	status(text);
}

void CloudLink::status(const QString& text) {
	// Server-generated texts can carry the upstream brand; never show it.
	QString shown = GbCloud::lobby(text);
	// 状态同时落到 %TEMP%/mgba_lobby_debug.log：Qt 版是 GUI 子系统程序，
	// Windows 上 stderr 抓不到，没有这一行实机联机就完全没法复盘。
	GbCloud::debugLog(QStringLiteral("[status] ") + shown.replace(QLatin1Char('\n'), QLatin1Char(' ')));
	emit statusMessage(shown);
}

}
