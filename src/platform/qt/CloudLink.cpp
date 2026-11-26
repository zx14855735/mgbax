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
#include "TcpDirectLink.h"
#ifdef _WIN32
#include "BtLink.h"
#endif

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
#include <QThread>

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

/* S2 门：编译期宏默认关；运行期仅 env==1 开启（与 sio_link.c 的 sioNetPartyMailboxOn 同值）。 */
static bool netPartyMailboxEnabled() {
	return (MGBAX_NET_PARTY_MAILBOX != 0) || (qgetenv(MGBAX_NET_PARTY_MAILBOX_ENV).toInt() == 1);
}

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
	       const QString& roomTag, const QString& nonce, int linkMode,
	       std::function<void(int)> peerModeCb)
		: m_sig(sig)
		, m_token(token)
		, m_uuid(uuid)
		, m_roomTag(roomTag)
		, m_nonce(nonce)
		, m_linkMode(linkMode)
		, m_peerModeCb(std::move(peerModeCb))
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
		/* C0：对端模式（旧客户端没有 "m"，toInt 落到 UNKNOWN，交网关判定）。 */
		if (m_peerModeCb) {
			const int peerMode = marker.value(QStringLiteral("m"))
			                         .toInt(GBoyFrames::LINK_MODE_UNKNOWN);
			if (peerMode == GBoyFrames::LINK_MODE_A || peerMode == GBoyFrames::LINK_MODE_B
			    || peerMode == GBoyFrames::LINK_MODE_INVALID) {
				m_peerModeCb(peerMode);
			}
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
		const QString wire = wsText(marker);
		QString error;
		/* 候选公告是 P2P 建链的命脉：服务器一旦拒收（关键词/长度/限流），
		 * 对端就永远拿不到候选、peerCandidates 恒 0、只能留在 120~200ms
		 * 隧道里。sendText 的无 error 重载会吞掉失败原因，显式检查并落一条
		 * 机器可读的行，免得又变成一次「静默丢候选」。 */
		if (!m_sig->sendText(wsText(sendMessageJson(m_token, m_uuid, wire)), &error)) {
			GbCloud::debugLog(QStringLiteral("[MGBAX_P2P] me=%1 event=marker-refused kind=%2 wireLen=%3 error=%4")
			                          .arg(m_nonce, marker.value(QStringLiteral("w")).toString())
			                          .arg(wire.size()).arg(error));
		}
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
		/* C0 / ADR-002：hello/accept 同时带 1 bit mode。WSS 信令是两端必然
		 * 互见的带外通道，比「中继是否转发 type-1 注册帧」可靠，作为主协商通道。 */
		if (m_linkMode == GBoyFrames::LINK_MODE_A || m_linkMode == GBoyFrames::LINK_MODE_B) {
			marker.insert(QStringLiteral("m"), m_linkMode);
		}
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
	/** C0：本端模式（随 hello/accept 广播）与对端模式回调。 */
	int m_linkMode = GBoyFrames::LINK_MODE_UNKNOWN;
	std::function<void(int)> m_peerModeCb;
};

}

namespace QGBA {

static intptr_t attachDriverLoopback(SioLinkHost* cc, bool asHost, QString* error);

CloudLink::CloudLink(QObject* parent)
	: QThread(parent)
{
	m_remoteKeysEnabled = qgetenv("MGBAX_REMOTE_KEYS").toInt() != 0;
	// 官方 GBoy 布局：本机多核（可见核 + 隐藏镜像核走回环 SIO），网络只传
	// 按键掩码。两端必须一致，否则同一条隧道上跑两套帧格式（现场教训：PC 发
	// 裸 MBL1 包、安卓发 GBoy 帧，9470 个碎片包把读线程活活耗死）。
	// C0 / ADR-002：默认不再是「PC=A / Android=B」的硬编码分叉，改为按房间
	// 人数自动对齐（2P→A、3/4P→B）；显式入口 MGBAX_LINK_MODE=A|B|AUTO、
	// MGBAX_OFFICIAL_LINK=1 兼容旧脚手架（等价 B）。两端在 type-1 握手帧和
	// WSS hello/accept 标记里各带 1 bit mode，不一致直接 fail，禁止静默降级。
	const QString explicitMode = QString::fromLatin1(qgetenv("MGBAX_LINK_MODE")).trimmed().toUpper();
	if (explicitMode == QStringLiteral("A")) {
		m_modeOverride = GBoyFrames::LINK_MODE_A;
	} else if (explicitMode == QStringLiteral("B")) {
		m_modeOverride = GBoyFrames::LINK_MODE_B;
	} else if (qgetenv("MGBAX_OFFICIAL_LINK").toInt() != 0) {
		m_modeOverride = GBoyFrames::LINK_MODE_B;   // 旧脚手架 flow.sh
	} else {
		m_modeOverride = GBoyFrames::LINK_MODE_UNKNOWN; // AUTO
	}
	m_allowLegacyPeer = qgetenv("MGBAX_LINK_ALLOW_LEGACY").toInt() != 0;
	m_officialMode = (m_modeOverride == GBoyFrames::LINK_MODE_B);
	m_linkMode.store(m_officialMode ? GBoyFrames::LINK_MODE_B : GBoyFrames::LINK_MODE_A,
	                 std::memory_order_relaxed);
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
	m_armSeedState.clear();
	m_firstSeedState.clear();   /* P0：会话级缓存，防跨房间脏 seed 泄漏 */
	/* 每次连接重新协商：上一次的绑定/拒绝不得泄漏到新房。 */
	m_peerLinkMode.store(GBoyFrames::LINK_MODE_UNKNOWN, std::memory_order_relaxed);
	m_modeBound.store(false, std::memory_order_relaxed);
	m_modeRejected.store(false, std::memory_order_relaxed);
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

void CloudLink::sendSpeed(int speed) {
	/* 只接受官方倍速菜单的值域；0 保留给「无待发送」。 */
	if (speed == 1 || speed == -1 || speed == 2 || speed == 4) {
		m_sendSpeed.store(speed, std::memory_order_relaxed);
		/* 本机切换立即生效（官方菜单同样直接写 AaHO0E），不等回环。 */
		m_speedWire.store(speed, std::memory_order_relaxed);
	}
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
	/* B2 解耦：party 带外帧不依赖 serve()/SIO 协商。waitAndProcess 在入房、握手、
	 * 协商各等待阶段都被调用，m_channel（当前 relay link）此时已可用。在这里轮询
	 * MGBAX_SCRIPT_DIR/party_mailbox，命中即用 provider 只读导出真 gPlayerParty 并
	 * 以 TYPE_PARTY 帧发出——即使 APP 还卡在座位走位、SIO 未联机也能预交换。
	 * serve() 里的同名轮询保留（幂等：marker 一次消费）。 */
	static qint64 s_lastPartyPoll = 0;
	while (!deadline.hasExpired()) {
		QCoreApplication::processEvents(QEventLoop::AllEvents, 20);
		if (m_closed.load(std::memory_order_relaxed)) {
			return false;
		}
		qint64 now = QDateTime::currentMSecsSinceEpoch();
		if (now - s_lastPartyPoll >= 250) {
			s_lastPartyPoll = now;
			const QString dir = qEnvironmentVariable("MGBAX_SCRIPT_DIR");
			if (!dir.isEmpty()) {
				QFile partyTrigger(dir + QStringLiteral("/party_mailbox"));
				if (partyTrigger.exists()) {
					partyTrigger.remove();
					sendPartyMailboxSync([this](const QByteArray& frame) {
						if (m_channel) {
							m_channel->send(frame);
						}
					});
				}
			}
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

void CloudLink::injectNpcKeys(int keys) {
	if (m_gboySession) {
		m_gboySession->injectKeysForSlot(3, keys);
		m_gboySession->injectKeysForSlot(4, keys);
	}
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
	// MGBAX_NO_RELAY 强制走服务器隧道（跳过公共 KCP 中继）：公共中继节点是
	// 回收池端口，经常只有一端能注册上（另一端 handshake 静默丢弃），导致
	// 房主提交了中继、加入方却退回隧道、两端永远碰不上。强制隧道让两端都用
	// 同一条已验证可用的信令 WS 通道，跨网必通（只是延迟比中继高一点）。
	if (QString::fromLocal8Bit(qgetenv("MGBAX_NO_RELAY")).isEmpty()
	    && (room->nodeAddress.isEmpty() || room->nodePort <= 0)) {
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
	// MGBAX_NO_RELAY 时跳过公共 KCP 中继，直接走服务器 WS 隧道（见 hostCreateRoom
	// 注释）：两端在同一个已验证可用的信令通道上互换 hello，必然碰面，不受中继
	// 回收池端口「只有一端能注册」的坑影响。
	if (QString::fromLocal8Bit(qgetenv("MGBAX_NO_RELAY")).isEmpty()
	    && !room->nodeAddress.isEmpty() && room->nodePort > 0) {
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
	/* C0 / ADR-002：分派之前先绑定两端模式，不一致直接断开并给可见提示。 */
	if (!negotiateLinkMode(room, QStringLiteral("KCP 中继"))) {
		link->close();
		delete link;
		m_channel = nullptr;
		return;
	}
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
		if (payload.isEmpty()) {
			tunnel->sendRawMarker(marker);
			return;
		}
		/* 服务器对聊天内容有 100 字符上限，超了整条拒收（不是截断）。
		 * 原实现只在超限时删掉 "r"，但真正占位的是 "a" 里的候选地址列表：
		 * 三个候选（公网映射 + 两块网卡）连 JSON 外壳约 105 字符，
		 * 删 "r" 只省 ~12 字符，仍然超限 ⇒ 对端只收到一个**没有 "a" 的
		 * "w":"p"**，直连永远起不来。现场证据：`[demux] w=p` 收到了、
		 * 但 `peerCandidates=0`，日志里一直没有 `[direct] 对端候选`。
		 * 这里改为逐条丢弃尾部队列里的候选（至少留 1 条）直到装得下；
		 * 候选是按优先级排的（本机/局域网在前，STUN 公网在后），
		 * 丢尾部正好是「先试价值最低的那个」，不影响主路径。 */
		QStringList cand = payload.split(QLatin1Char(','), Qt::SkipEmptyParts);
		int dropped = 0;
		forever {
			marker.insert(QStringLiteral("a"), cand.join(QLatin1Char(',')));
			if (wsText(marker).size() <= 94) {
				break;
			}
			if (!marker.contains(QStringLiteral("r")) && cand.size() > 1) {
				// 已经删过 "r"：从尾部再丢一个候选
				cand.removeLast();
				++dropped;
				continue;
			}
			if (marker.contains(QStringLiteral("r"))) {
				marker.remove(QStringLiteral("r"));
				continue;
			}
			break; // 只剩一条候选仍超限：照发，让对端至少拿到一个
		}
		if (dropped > 0) {
			GbCloud::debugLog(QStringLiteral("[direct] 候选过多，为满足 100 字符上限丢弃 %1 条，实发 %2")
			                          .arg(dropped)
			                          .arg(cand.join(QLatin1Char(','))));
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
	int peerCandCount = 0;     // 对端公告里的候选条数（机器可读诊断）
	bool peerWants = false;    // 对端发过 s：它已经打通，愿意切过来
	bool peerAgreed = false;   // 对端发过 s2：它已经收到我们的 s
	bool switchSent = false;
	bool approved = false;
	bool aborted = false;
	/* 机器可读的建链结论行：两端各写一条，驱动 grep 两实例日志即可看到
	 * 各自的 peerCandidates / peerCandidateCount 与 directEnabled，直接判定
	 * 「是不是一侧拿到了候选、另一侧 peerCandidates=0 卡在隧道」。 */
	auto logOutcome = [&](const QString& result) {
		const bool enabled = (result == QStringLiteral("ok"));
		GbCloud::debugLog(QStringLiteral("[MGBAX_P2P] me=%1 event=result result=%2 peerCandidates=%3 peerCandidateCount=%4 localCandidates=%5 directEnabled=%6 connected=%7 switchSent=%8 peerWants=%9 peerAgreed=%10 aborted=%11 via=%12")
		                          .arg(m_wsNonce, result)
		                          .arg(peerCandidates ? 1 : 0).arg(peerCandCount)
		                          .arg(mine.size())
		                          .arg(enabled ? 1 : 0)
		                          .arg(direct->connected() ? 1 : 0)
		                          .arg(switchSent ? 1 : 0).arg(peerWants ? 1 : 0)
		                          .arg(peerAgreed ? 1 : 0).arg(aborted ? 1 : 0)
		                          .arg(enabled ? QStringLiteral("p2p") : QStringLiteral("tunnel")));
	};
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
				QStringList peer = marker.value(QStringLiteral("a")).toString()
				                       .split(QLatin1Char(','), Qt::SkipEmptyParts);
				/* 每条 p 都落一行机器可读记录：历史现场是「[demux] w=p 有、
				 * [direct] 对端候选 没有」——收到了信封但候选被 100 字符上限
				 * 挤掉，只靠旧的人类可读行看不出这一侧到底收到几条。 */
				GbCloud::debugLog(QStringLiteral("[MGBAX_P2P] me=%1 event=peer-candidates count=%2 list=%3")
				                          .arg(m_wsNonce).arg(peer.size())
				                          .arg(peer.join(QLatin1Char(','))));
				if (!peerCandidates) {
					if (!peer.isEmpty()) {
						GbCloud::debugLog(QStringLiteral("[direct] me=%1 对端候选 %2")
						                          .arg(m_wsNonce, peer.join(QLatin1Char(','))));
						direct->setPeerCandidates(peer);
						direct->startPunching();
						peerCandidates = true;
						peerCandCount = peer.size();
					} else {
						/* 收到了 "w":"p" 却没有 "a"：说明对端信封被大厅 100 字符
						 * 上限挤掉了候选列表（曾经完全静默，表现为
						 * `peerCandidates=0` 却查不出原因）。 */
						GbCloud::debugLog(QStringLiteral("[direct] me=%1 收到对端 p 但无候选地址（信封超长？）")
						                          .arg(m_wsNonce));
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
		// 【跨设备加固】原实现只在前 4 秒公告：即便 hello 大体同步了两端，
		// STUN/信令重试仍可能把对端推迟数秒；那时我们早已停发，对端的
		// peerCandidates 恒 0、永不打洞，形成「一侧 P2P、一侧隧道」的不对称
		// 卡死。改成连通前持续按 600ms 重发（对端拿到候选后会忽略后续 p），
		// 让晚到的那一端也有机会收到我们的候选。公告窗口对齐 6s 放弃门
		// （仍是 600ms 一次），不无限发，避免触发大厅的聊天频率限制。
		if (now - started <= 6000 && now - lastAnnounce >= 600) {
			const bool firstAnnounce = (lastAnnounce == 0);
			lastAnnounce = now;
			QStringList kept = mine.mid(0, 3);
			if (kept.size() > 1) {
				int rot = announceCount++ % kept.size();
				for (int i = 0; i < rot; i++) {
					kept.append(kept.takeFirst());
				}
			}
			if (firstAnnounce) {
				GbCloud::debugLog(QStringLiteral("[MGBAX_P2P] me=%1 event=announce count=%2 list=%3")
				                          .arg(m_wsNonce).arg(kept.size())
				                          .arg(kept.join(QLatin1Char(','))));
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
		logOutcome(!peerCandidates ? QStringLiteral("no-peer-candidates")
		                           : (aborted ? QStringLiteral("peer-aborted")
		                                      : QStringLiteral("no-agree")));
		if (switchSent) {
			sendMarker(QStringLiteral("s3"), QString());
		}
		direct->close();
		delete direct;
		return nullptr;
	}
	logOutcome(QStringLiteral("ok"));
	int rttMs = (direct->rttUs() + 500) / 1000;
	status(QStringLiteral("直连加速已启用（P2P %1，RTT %2 ms）\n")
	               .arg(direct->peerText())
	               .arg(rttMs)
	       + QStringLiteral("数据不再经过服务器中转，延迟比隧道低一个数量级"));
	return direct;
}

/**
 * 官方 WiFi 直连的 TCP 版（KpHwm4.A2egSU.java / AmA8tU.java）：一端
 * accept、一端 connect，字节流上就是「4B 大端长度 + u16 type + payload」。
 *
 * 只有显式给了环境变量才启用，默认行为与以前完全一致：
 *   MGBAX_TCP_PEER=1.2.3.4:5678   作为客户端连过去
 *   MGBAX_TCP_LISTEN=5678         作为服务端监听
 * 两个都设时 PEER 优先（客户端场景更多：只有一边有公网/端口映射）。
 */
ILink* CloudLink::tryEnvTcpLink(QString* error) {
	const QString peer = qEnvironmentVariable("MGBAX_TCP_PEER").trimmed();
	const QString listenSpec = qEnvironmentVariable("MGBAX_TCP_LISTEN").trimmed();
	if (peer.isEmpty() && listenSpec.isEmpty()) {
		return nullptr;
	}
	TcpDirectLink* link = new TcpDirectLink();
	if (!peer.isEmpty()) {
		const int colon = peer.lastIndexOf(QLatin1Char(':'));
		bool ok = false;
		const int port = colon > 0 ? peer.mid(colon + 1).toInt(&ok) : 0;
		if (colon <= 0 || !ok || port <= 0 || port > 65535) {
			if (error) {
				*error = QStringLiteral("MGBAX_TCP_PEER 格式应为 host:port");
			}
			delete link;
			return nullptr;
		}
		status(QStringLiteral("正在直连 TCP 对端 %1…").arg(peer));
		if (!link->connectTo(peer.left(colon), quint16(port), 10000, error)) {
			delete link;
			return nullptr;
		}
		status(QStringLiteral("TCP 直连已建立（本机端口 %1 → %2）\n")
		               .arg(link->localPort())
		               .arg(peer));
		return link;
	}
	bool ok = false;
	const int port = listenSpec.toInt(&ok);
	if (!ok || port <= 0 || port > 65535) {
		if (error) {
			*error = QStringLiteral("MGBAX_TCP_LISTEN 应为 1-65535 的端口号");
		}
		delete link;
		return nullptr;
	}
	status(QStringLiteral("正在监听 TCP 端口 %1 等待对端…").arg(port));
	if (!link->listenAndAccept(quint16(port), 20000, error)) {
		delete link;
		return nullptr;
	}
	status(QStringLiteral("TCP 直连已建立（监听 %1，对端 %2）")
	               .arg(link->localPort())
	               .arg(link->peerText()));
	return link;
}

/**
 * 蓝牙 RFCOMM（官方 KpHwm4.A2egSU(str) 客户端 / A4TApA 服务端，服务名
 * `GBoy`、UUID 3a1f7b2e-8d45-4c92-bf60-5e3c21a98d47）。只在 Windows 上
 * 编译；没设 MGBAX_BT 时连对象都不创建。
 */
ILink* CloudLink::tryBtLink(QString* error) {
#ifdef _WIN32
	const QString spec = qEnvironmentVariable("MGBAX_BT").trimmed();
	if (spec.isEmpty()) {
		return nullptr;
	}
	if (!BtLink::supported()) {
		if (error) {
			*error = QStringLiteral("本机 SDK 未提供蓝牙 RFCOMM 支持");
		}
		return nullptr;
	}
	BtLink* link = new BtLink();
	const bool host = spec.compare(QStringLiteral("host"), Qt::CaseInsensitive) == 0;
	if (host) {
		status(QStringLiteral("正在以蓝牙服务端启动（服务名 GBoy）…"));
		if (!link->openHost(20000, error)) {
			delete link;
			return nullptr;
		}
	} else {
		status(QStringLiteral("正在连接蓝牙对端 %1…").arg(spec));
		if (!link->openClient(spec, 20000, error)) {
			delete link;
			return nullptr;
		}
	}
	status(QStringLiteral("蓝牙 RFCOMM 已连通（%1）").arg(link->peerText()));
	return link;
#else
	Q_UNUSED(error);
	return nullptr;
#endif
}

void CloudLink::runTunnel(GbCloud::Session* sig, const QString& token, Room* room, bool asHost) {
	const QString tag = room->roomId;
	status(QStringLiteral("正在通过服务器隧道等待对方进入（跨网可联）…"));
	WsLink* link = new WsLink(sig, token, m_advertiserUuid, tag, m_wsNonce,
	                          resolveLinkMode(qMax(1, room->playerCount)),
	                          [this](int mode) {
		                          notePeerLinkMode(mode, QStringLiteral("WSS 隧道 hello/accept"));
	                          });
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
	/* C0 / ADR-002：隧道分派前同样先绑定模式，禁止两套帧格式同流。 */
	if (!negotiateLinkMode(room, QStringLiteral("WSS 隧道"))) {
		cleanupTunnel();
		m_tunnelUp = false;
		return;
	}
	if (m_officialMode) {
		/* 照抄 GBoy：游戏数据一律走 P2P 直连，WSS 只负责房间信令。
		 *
		 * 原注释写「按键流走隧道就已经是全速」，那只在「网络只传按键」时成立。
		 * 官方协议的第 6 号消息是整份 savestate（约 790 KiB），握手和周期纠偏
		 * 都要用它；而大厅隧道单条消息被服务器限到 100 字符，一个状态包都发
		 * 不完，两端的镜像核永远停在不同的一幕 —— 实测就是「4P 都认到了，
		 * 一按确认就报请确认玩家数量」。直连通道自带分片与可靠层，整份状态
		 * 能完整送达；打不通（对称 NAT / 企业网）才退回隧道，此时至少按键
		 * 联机还能用。 */
		ILink* chosen = link;
		DirectLink* direct = nullptr;
		/* 候选顺序（官方模式专用，默认仍是「UDP 直连 → 隧道」不变）：
		 *   1. 蓝牙（仅当显式给了 MGBAX_BT：用户点名要用蓝牙，不该被 UDP 抢走）
		 *   2. DirectLink 的 UDP 打洞
		 *   3. TcpDirectLink（仅当显式给了 MGBAX_TCP_PEER / MGBAX_TCP_LISTEN）
		 *   4. 服务器隧道
		 */
		ILink* extra = nullptr;
		QString extraError;
		extra = tryBtLink(&extraError);
		if (extra) {
			chosen = extra;
		} else {
			if (!extraError.isEmpty()) {
				GbCloud::debugLog(QStringLiteral("[bt] %1").arg(extraError));
			}
			direct = static_cast<DirectLink*>(tryDirectLink(sig, token, room, link, asHost));
			if (direct) {
				chosen = direct;
			} else {
				extra = tryEnvTcpLink(&extraError);
				if (extra) {
					chosen = extra;
				} else if (!extraError.isEmpty()) {
					GbCloud::debugLog(QStringLiteral("[tcp-direct] %1").arg(extraError));
				}
			}
		}
		startOfficialMatch(chosen, room);
		if (extra && extra != link) {
			extra->close();
			delete extra;
		}
		if (direct) {
			direct->close();
			delete direct;
		}
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
	/* path A 的两种传输在这一点已经确定；把帧封装方式写清楚，便于核对
	 * §7.3：WS 隧道 = 裸 20 字节字节管道，KCP 中继 = type-6 包一层。 */
	logPathDiag(QStringLiteral("A"),
	            dynamic_cast<DirectLink*>(link) ? QStringLiteral("p2p") : QStringLiteral("ws-tunnel"),
	            QStringLiteral("raw-20B-netLink"));
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
		/* 本轮两向都没活干时让出 CPU（见循环尾的 usleep）：不能用阻塞收包
		 * 来让出，那会把等待平摊到每一轮 SIO 传输上。 */
		bool didWork = false;
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
			didWork = true;
		}
		QByteArray pkt;
		/* 【不许在这里阻塞】cur->recv 的 timeoutMs 是「最多等多久」，不是
		 * 「每轮固定等这么久」，但循环是单线程一问一答：给它 20ms，它就会
		 * 在没有数据的那些轮里真的睡满 20ms，而这 20ms 会原封不动加到每一
		 * 轮 SIO 传输上。实测 RTT 只有 6ms 却每轮 25ms（`[sio-rtt] n≈40/s`），
		 * 9 轮/帧 ⇒ 4.6fps；握手阶段更糟，双端要几十分钟才 st=2→4（现象就是
		 * 「卡在等待玩家准备」）。改成 0：立即返回一次 pump 的结果，没有数据
		 * 就去下面的空闲微睡眠，让出 CPU 但不拖慢下一轮。 */
		if (cur->recv(&pkt, 0)) {
			didWork = true;
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
		if (!didWork) {
			/* 两向都没数据：让出 CPU，但**不拖慢下一轮**。200µs 远小于一次
			 * SIO 传输的周期（战斗阶段 ~11ms），对延迟可忽略。 */
			QThread::usleep(200);
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
	logPathDiag(QStringLiteral("A"), QStringLiteral("kcp-relay"),
	            QStringLiteral("type6-wrapped-20B-netLink"));
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
 *   网络：每 5 帧(12Hz)一把按键掩码（type 0）+ 一把 TYPE_STATE 开局快照
 *         （官方没有 FPS/pacing 消息；type 9 只是倍速菜单，不在本循环发）
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
	/* path B 的本机核数 = 房间人数：1 可见核 + (players-1) 镜像核。
	 * room->playerCount 是权威来源（信令 player_joined 写入、默认 2），不再
	 * 用编译期 MIRROR_COUNT+1=4 硬编码——否则 2P 房会悄悄跑 4 核，总线按
	 * 4 人铺槽，2P 会话从起点就错位，且驱动断言 pathB_2p_bus_ok 恒 false。
	 * 夹到 [2,4]：少于 2 人无联机意义，超过 4 人数组放不下。 */
	const int players = qBound(2, room->playerCount, 4);
	const int mirrorCount = players - 1;
	m_mirrorCount = mirrorCount;
	GbCloud::debugLog(QStringLiteral("[MGBAX_PATH] path=B players=%1 mirrors=%2")
	                          .arg(players).arg(mirrorCount));
	logPathDiag(QStringLiteral("B"), QStringLiteral("p2p-or-tunnel"),
	            QStringLiteral("type6-savestate+12Hz-keys"));
	// 可见核当 1P 主机（finishFrame 每帧 pump 它），3 个镜像核 join 同一
	// 条总线凑满 4 人。players 必须与镜像核一致，否则总线槽位对不上。
	//
	// path B 四核全部在本进程，默认走进程内 LocalBus：主机是唯一时钟源，
	// 从机永远跟随主机当前轮次，轮次天然对齐。TCP 星型（127.0.0.1）每个核
	// 各算各的轮次号，Windows 的定时器粒度又把错位放大成 2ms 超时地板
	// （PB15：主机 m1 恒 FFFF、镜像 mis≈5700 / to≈1800），因此只保留
	// MGBAX_LOCAL_BUS=0 作对照实验。
	const bool useLocalBus = qgetenv("MGBAX_LOCAL_BUS") != "0";
	/* CoreController 锁步接入目前会在四核会合时崩溃（PB27/28 0xC0000005，
	 * 跨线程 setPeripheral 腐蚀 coordinator），默认走已验证可达真实握手字的
	 * LocalBus；只有显式 MGBAX_LOCKSTEP=1 才启用实验性的锁步路径。 */
	m_mirrorLockstep = useLocalBus && qgetenv("MGBAX_LOCKSTEP") == "1";
	quint16 port = 0;
	if (useLocalBus) {
		m_mirrorLocalKey = int(QDateTime::currentMSecsSinceEpoch() & 0x7FFFFFFF);
		if (m_mirrorLocalKey <= 0) {
			m_mirrorLocalKey = 1;
		}
		/* 锁步房间必须等 cloudArmReload/reset() 之后再挂：GBAReset 会
		 * mTimingClear + GBASIOReset 重置 SIO 驱动，先挂会被复位打坏（PB27
		 * 两端在 nav_at 一写就 0xC0000005）。所以这里只记 key，真正 mount
		 * 放在下面 arm 段之后、镜像核 start 之前。 */
		bool hosted = m_mirrorLockstep
		        || m_controller->sioHostPlayersLocal(m_mirrorLocalKey, players);
		if (!hosted) {
			m_mirrorLocalKey = 0;
			m_mirrorLockstep = false;
			fail(QStringLiteral("本机联机总线创建失败"));
			return;
		}
		GbCloud::debugLog(QStringLiteral("[arm] local SIO %1 key=%2 players=%3")
		                          .arg(m_mirrorLockstep ? QStringLiteral("lockstep")
		                                                : QStringLiteral("bus"))
		                          .arg(m_mirrorLocalKey)
		                          .arg(players));
	} else {
		for (int t = 0; t < 8; ++t) {
			quint16 candidate = quint16(18781 + t);
			if (m_controller->sioHostPlayers(candidate, players)) {
				port = candidate;
				break;
			}
		}
		if (!port) {
			fail(QStringLiteral("本机联机线端口被占用"));
			return;
		}
		m_mirrorSioPort = port;
	}
	GBoyLinkSession::Events events;
	events.onReset = [this]() {
		/* 官方 type 5（EmulatorActivity.BmvVmW:1333 → 接收侧 case 5）：
		 * reset(false) 本机可见核，并遍历所有镜像核 reset(false)。
		 * 镜像核的 reset 落在自己的帧边界（GBoyMirror::requestReset），
		 * 可见核走 GUI 线程上的 CoreController::reset（remoteReset 的既有连接）。 */
		for (int i = 0; i < m_mirrorCount; ++i) {
			if (m_mirrors[i]) {
				m_mirrors[i]->requestReset();
			}
		}
		emit remoteReset();
	};
	events.onState = [this](const QByteArray& state) {
		/* 官方语义（GBoy KpHwm4.B25kr6:144-152）：type 6 的 savestate 只灌进
		 * 「代表那个玩家的控制台」。本机布局是可见核 slot 1 + 镜像核 slot 2/3/4
		 * （GBoyLinkSession::mirrorSlotFor(1, 4, i) = i + 2），而对端按键走
		 * defaultSenderSlot() = 2，所以代表对端的就是第 0 个镜像核。
		 *
		 * slot 3/4 是本机 NPC 陪位（大竞技场要求 4 人），喂对端存档进去会把
		 * 它们的进度覆盖成对端的，四人子状态立刻分裂 —— Android 老版本
		 * 「灌全部镜像核」就是这么坏的。 */
		const int kPeerMirror = 0; // 槽位 2
		GBoyMirror* mirror = m_mirrors[kPeerMirror];
		if (!mirror) {
			GbCloud::debugLog(QStringLiteral("TYPE_STATE dropped (no mirror console)"));
			return;
		}
		/* 返回值是官方 type 6 的错误码：-5 尺寸不符、1 参数非法、0 已入队。
		 * 真正的载入在镜像线程的帧边界做，结果走回调（0 / -5 / 1）。 */
		int queued = mirror->applyRemoteState(state, [this](int result) {
			if (result == 0) {
				GbCloud::debugLog(QStringLiteral("TYPE_STATE loaded into mirror slot 2"));
				/* 官方 B25kr6:156-157 在 load 之后对两颗粒做 reset(false)，但
				 * 那是 libgboy 的 native 软复位；我们的 mgbaMobileReset 走
				 * GBAReset → GBAMemoryReset 会 memset 掉 EWRAM 256K + IWRAM 32K，
				 * 等于把刚载入的存档冲掉（实测现象：握手成功但两边停在开机画面）。
				 * 所以这里**不复位**：type 6 只负责载入，复位只由 type 5 触发。 */
			} else {
				GbCloud::debugLog(QStringLiteral("TYPE_STATE rejected by mirror (code %1)")
				                          .arg(result));
				/* 官方 -5 → 3、其它非 0 → 1，失败即断链。留到 serve 循环里
				 * 统一收口，避免在镜像线程直接拆链路。 */
				m_mirrorStateError.store(result, std::memory_order_relaxed);
			}
		});
		if (queued == 0) {
			GbCloud::debugLog(QStringLiteral("TYPE_STATE queued for mirror slot 2 (%1 bytes)")
			                          .arg(state.size()));
		} else {
			GbCloud::debugLog(QStringLiteral("TYPE_STATE rejected before queue (code %1, %2 bytes)")
			                          .arg(queued).arg(state.size()));
			m_mirrorStateError.store(queued, std::memory_order_relaxed);
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
	        /* players 槽位：本机可见核占 slot 1，其余镜像占 slot 2..players。
	         * 会话只把真人按键跨网络送出去（对端按键进 slot 2）；3/4 人房里
	         * 多余的槽位恒 0 作 NPC 陪位（大竞技场要求 4 人才放开走位）。
	         * playerCount 必须跟随房间人数，否则 2P 房取不到对端键。 */
	        events, 1, players);
	/* 【握手挪到镜像核之后】官方握手三步（1 register / 2 name / 3 ready）
	 * 现在在三个镜像核都就绪、nav_at 写完之后才发（见下方 startOfficialMatch
	 * 尾部）。原因：type 1/register 是**对端判定「我们已就绪」的唯一来源**，
	 * 对端一看到它就立刻发整份 savestate（type 6，约 46KB，DirectLink 拆成
	 * 46 个分片）。我们这边创建 3 个镜像核要 5~10 秒，如果握手还在创建前
	 * 发出，对端的 46KB 会全部堆在我们尚未开始 recv 的 UDP 缓冲里：
	 *   - 缓冲被重传的旧分片挤爆，分片永远收不齐（PB12：两端都没有任何
	 *     TYPE_STATE 日志）；
	 *   - 发送端等不到 ACK，40 次重传后 DirectLink 自行判死，2.7 秒就
	 *     「服务器隧道连接已断开」→ stopOfficialMatch() 删镜像核 + nav_at，
	 *     可见核被留在柜台前，gLink 停在 HANDSHAKE / status=0（PB12 现场）。
	 * 挪到镜像核就绪之后，register 同时成为「我方四核房间已可接收状态」的
	 * 信号，type-6 的发送窗口才真正对齐。
	 * 官方握手仍是严格顺序 1 → 2 →（3）→ 6（B25kr6:122-152）：名字帧必须
	 * 排在 type 1 之后，房主收到第一帧不是 1 会直接 return 2。 */
	emit connected(asHost);
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
	/* 无人值守回归钩子：MGBAX_SCRIPT_DIR + MGBAX_NAV_AT 同时给出时，四个核
	 * 一起跑 busgame 闭环导航。正常玩家联机没有这两个变量，navIdx=-1，
	 * 镜像核从第一帧起就只用网络按键，绝不被脚本接管。 */
	const QString scriptDir = QString::fromLocal8Bit(qgetenv("MGBAX_SCRIPT_DIR"));
	int navMenuAt = -1;
	int navModeDowns = 2;
	if (!scriptDir.isEmpty()) {
		bool ok = false;
		const int v = qgetenv("MGBAX_NAV_AT").toInt(&ok);
		if (ok && v > 0) {
			navMenuAt = v;
		}
		ok = false;
		const int d = qgetenv("MGBAX_NAV_DOWNS").toInt(&ok);
		if (ok && d >= 0) {
			navModeDowns = d;
		}
	}
	/* 三个镜像核必须拿到同一份电池存档字节：逐个 QFile::copy 会碰到已存在的
	 * 目标（沿用上一轮残留），也可能在循环期间读到可见核写回的新版本。先读
	 * 一次快照再分发，四核冷启动起点才一致。 */
	QByteArray saveSnapshot;
	if (!savePath.isEmpty() && QFileInfo(savePath).isFile()) {
		QFile src(savePath);
		if (src.open(QIODevice::ReadOnly)) {
			saveSnapshot = src.readAll();
			src.close();
		}
	}
	QString error;
	/* ---- PC cloud-arm：四核同帧 0 对齐 -------------------------------------
	 * 缺口（本文件历史上一直没做的一步）：镜像核从电池存档冷启动，可见核
	 * 保持现场（往往已经进了联机菜单几万帧）——四核起点不齐，SIO 总线永远
	 * 凑不齐同一轮，实测 2P 云端所有 flow BATTLE=0。Android 在
	 * EmulatorActivity:5467-5484（linkArmHold + suppressAutoState + reload）
	 * 与 :2588-2615（reload 后重建房间）里做的正是这一步。
	 *
	 * 顺序照抄语义（不是照抄语言）：
	 *   1. 快照：可见核 state（前端 provider，type-6 用那份）用来判定「有没有
	 *      可比对的起点」；四核真正的统一起点是**电池存档字节**——
	 *      provider 给的是 savestate，里面含 SIO/链路寄存器状态，把它灌进
	 *      刚连上环回的镜像核会把链路状态一起覆盖（Android 的注释同此结论：
	 *      四核只能从电池存档冷启动，不能从即时存档起）；
	 *   2. 可见核按同一份电池存档字节 reload 到帧 0（cloudArmReload）；
	 *   3. 锁住可见核帧循环（cloudArmHold = Android linkArmHold）；
	 *   4. 按槽位建 3 个镜像核（每个 start() 内部等到 LINK_CONNECTED）；
	 *   5. 四核都 CONNECTED 后放开帧循环。
	 * MGBAX_OFFICIAL_ARM=0 回到旧行为（可见核保持现场），便于 A/B 与回退。 */
	/* 【默认关】02:32 实测：开着 arm 时两端 reload 后 `px=0 py=0`（核心没读到
	 * 电池存档，等于新开局），比赛因此永远到不了柜台。同帧对齐的收益还没验证到，
	 * 但「读不到存档」是硬阻塞，所以默认回到旧行为；显式 =1 才能开。
	 * 待修完 reload（让重载后的核心确实装载同一份 .sav 并能读档）再评估默认值。 */
	const QByteArray armEnv = qgetenv("MGBAX_OFFICIAL_ARM");
	const bool armEnabled = !armEnv.isEmpty() && armEnv.toInt() != 0;
	const qint64 armT0 = QDateTime::currentMSecsSinceEpoch();
	bool armHeld = false;
	if (armEnabled) {
		/* 1) 快照：先看前端有没有给出可见核 state（镜像核/对端要的是同一
		 *    份字节）；没有就只靠电池存档。 */
		QByteArray snapshot;
		if (m_stateSnapshot) {
			snapshot = m_stateSnapshot();
		}
		GbCloud::debugLog(QStringLiteral("[arm] t=%1 snapshot=%2B battery=%3B save=%4")
		                          .arg(0)
		                          .arg(snapshot.size())
		                          .arg(saveSnapshot.size())
		                          .arg(savePath.isEmpty() ? QStringLiteral("<none>") : savePath));
		/* 2) 可见核 reload 到帧 0：让四核从同一份电池存档字节冷启动。
		 *    必须在 hold 之前——mCoreThreadReset 要等核心线程真正跑到
		 *    reset 请求，暂停中的线程不会接。 */
		const bool reloaded = m_controller && m_controller->cloudArmReload(savePath);
		GbCloud::debugLog(QStringLiteral("[arm] visible core reloaded=%1 (save %2B)")
		                          .arg(reloaded ? 1 : 0)
		                          .arg(saveSnapshot.size()));
		/* 3) 锁住帧循环：镜像核的 ROM 加载 + 连接握手要几百 ms，不锁的话
		 *    可见核会独自先跑几千帧，四核相位立刻错开。 */
		if (m_controller) {
			m_controller->cloudArmHold(true);
			armHeld = true;
		}
		/* 对齐后的起点快照：复位到帧 0 之后再取一次，作为 type-6 的首包，
		 * 对端镜像核因此也落在帧 0，而不是我们进菜单时的状态。 */
		if (m_stateSnapshot) {
			m_armSeedState = m_stateSnapshot();
		}
		GbCloud::debugLog(QStringLiteral("[arm] t=%1 held, seed=%2B")
		                          .arg(QDateTime::currentMSecsSinceEpoch() - armT0)
		                          .arg(m_armSeedState.size()));
	}
	if (m_mirrorLockstep) {
		/* 复位之后再把可见核挂到锁步房间：GBAReset 已经清过 timing/SIO，
		 * 此刻挂驱动才是干净起点。镜像核在下面的循环里 join 同一个 key。 */
		if (!m_controller->sioLockstepHost(m_mirrorLocalKey, players, 0)) {
			if (armHeld) {
				m_controller->cloudArmHold(false);
			}
			m_mirrorLocalKey = 0;
			m_mirrorLockstep = false;
			stopOfficialMatch();
			fail(QStringLiteral("本机锁步房间创建失败"));
			return;
		}
		GbCloud::debugLog(QStringLiteral("[arm] lockstep room mounted key=%1")
		                          .arg(m_mirrorLocalKey));
	}
	for (int i = 0; i < mirrorCount; ++i) {
		QDir mirrorDir(QFileInfo(savePath).dir().filePath(
		    QStringLiteral("mirror%1").arg(i + 1)));
		/* 槽位不再硬编码 i + 2：走 GBoyLinkSession::mirrorSlotFor，本机可见核
		 * 占 slot 1，镜像按房间人数铺开：2P→2、3P→2/3、4P→2/3/4。 */
		const int slot = GBoyLinkSession::mirrorSlotFor(1, players, i);
		GBoyMirror* mirror = new GBoyMirror(this);
		if (!mirror->start(m_config.romPath, savePath, mirrorDir.path(), port,
		                   m_mirrorLocalKey, m_gboySession, slot, players,
		                   m_mirrorLockstep,
		                   navMenuAt > 0 ? i + 1 : -1, navMenuAt, navModeDowns,
		                   saveSnapshot, scriptDir, &error)) {
			if (armHeld && m_controller) {
				m_controller->cloudArmHold(false);
			}
			mirror->stopMirror();
			delete mirror;
			stopOfficialMatch();
			fail(QStringLiteral("镜像核 %1 启动失败：").arg(slot) + error);
			return;
		}
		m_mirrors[i] = mirror;
		GbCloud::debugLog(QStringLiteral("[arm] t=%1 mirror[%2] slot=%3 LINK_CONNECTED")
		                          .arg(QDateTime::currentMSecsSinceEpoch() - armT0)
		                          .arg(i)
		                          .arg(slot));
	}
	if (navMenuAt > 0) {
		/* 镜像核已经在 start() 里武装好脚本；此刻才写 nav_at，让
		 * 可见核（ScriptedControl 每 16ms 探测该文件）在同一瞬间起跑，两核
		 * 相位一致。提前写会让可见核独自先跑几十秒，SIO 握手时两核状态
		 * 完全不同。文件内容 "menuAt modeDowns" 与 Android 广播参数一致。 */
		QFile navAt(scriptDir + QStringLiteral("/nav_at"));
		if (navAt.open(QIODevice::WriteOnly | QIODevice::Truncate)) {
			navAt.write(QByteArray::number(navMenuAt) + " "
			            + QByteArray::number(navModeDowns));
			navAt.close();
		}
	}
	/* 5) 放开帧循环：此刻可见核在帧 0、三个镜像核都 LINK_CONNECTED，
	 *    四核从同一节拍开始跑（正是 Android 的 linkArmHold = false）。 */
	if (armHeld && m_controller) {
		m_controller->cloudArmHold(false);
		GbCloud::debugLog(QStringLiteral("[arm] t=%1 released: visible f0 + %2 mirrors CONNECTED")
		                          .arg(QDateTime::currentMSecsSinceEpoch() - armT0)
		                          .arg(mirrorCount));
	}
	/* 官方握手三步（1 register / 2 name / 3 ready）必须等本机四核房间
	 * 真正建好后再发：register 是**对端判定「可以开始发 type-6 存档」的
	 * 信号**，而 type-6 是 46KB 分片 UDP。提前发 ⇒ 对端在我们还没进
	 * serveOfficial 的 recv 循环时就把分片全推过来，缓冲被重传挤爆、
	 * 40 次重传后 DirectLink 判死（PB12：两端 2.7~5.7 秒断链、gLink 停在
	 * HANDSHAKE）。放在这里，register 才真正等价于「本机镜像核已就绪」。
	 * 顺序仍是官方 1 → 2 → 3（B25kr6:122-152 的连续 getShort 校验）。 */
	m_gboySession->sendSocketHandshake();
	link->send(GBoyFrames::nameFrame(gameName().toUtf8(),
	                                 room->roomId.isEmpty() ? QByteArray() : room->roomId.toUtf8()));
	link->send(GBoyFrames::frame(GBoyFrames::TYPE_READY, 0));
	GbCloud::debugLog(QStringLiteral("[arm] handshake 1/2/3 sent after %1 mirrors CONNECTED")
	                          .arg(mirrorCount));
	status(QStringLiteral("SIO 链路已建立（%1 核本机房间，%2 %3）\n")
	               .arg(players)
	               .arg(m_mirrorLocalKey ? QStringLiteral("进程内总线 key=") : QStringLiteral("环回端口 "))
	       .arg(m_mirrorLocalKey ? QString::number(m_mirrorLocalKey) : QString::number(port))
	       + QStringLiteral("各自操作各自的画面，游戏内联机（交换/对战）走本机联机线\n")
	       + QStringLiteral("云端联机已连接，你是 ") + (asHost ? QStringLiteral("1P") : QStringLiteral("2P")));
	serveOfficial(link, room);
	stopOfficialMatch();
}

void CloudLink::serveOfficial(ILink* link, Room* room) {
	// 官方 12Hz 摇键节奏：onLocalFrame 按帧调用（这里用 ~60Hz 墙钟模拟帧
	// 节拍，等价安卓的 onLocalFrame 帧驱动），GBoyLinkSession 内部每 5 帧
	// 发一把本地按键并采样一把远端按键——正是官方客户端的 cadence。
	//
	// 节拍固定 16ms（60fps）：官方没有任何「帧率下发」消息（逐字节复核见
	// NETPLAY_AUDIT §0：type 0 是按键、type 9 才是倍速菜单），所以这里不按
	// 网络值改节拍；倍速只影响官方客户端自己的帧闸。
	qint64 lastTick = 0;
	qint64 lastAdvertise = 0;
	// 每分钟一次的会话自检：对端按键积压/掉帧从会话里捞出来打日志。
	qint64 lastDiag = 0;
	/* 状态补发节奏：官方镜像模式下两端各自跑两个核，镜像核只靠对端按键复现
	 * 对方的进度，一旦某一方在菜单/连机里多走一步，两核就再也不会回到同一
	 * 子状态（实测 pc 恒 0）。官方客户端用 case 6 周期纠偏，这里照做。 */
	qint64 lastStateSync = 0;
	qint64 lastStatePoll = 0;
	/* type-6 有界补发（cloud-arm 的一步）：isReady 之后对端的镜像核可能才刚
	 * 建好，开局那一包会打在「还没有核」的窗口上（对端日志里就是
	 * `TYPE_STATE dropped (no mirror console)`）。所以 ready 之后再补两次，
	 * 间隔 5s，**有界**——整份存档几百 KB，周期发送会把本循环拖到 0.6fps
	 * （实测），补完就只保留按需触发（sync_state 文件 / 漂移判定）。 */
	const int kArmResendMax = 2;
	const qint64 kArmResendMs = 5000;
	bool armSeedSeen = false;
	int armResends = 0;
	qint64 lastArmResend = 0;
	/* 倍速联机的无 UI 验证入口：设置 MGBAX_SPEED_9 后，把
	 * <MGBAX_SCRIPT_DIR>/speed 的内容（1 / -1 / 2 / 4）当作一次「本机切倍速」，
	 * 广播 type 9 后删除文件。正常玩家路径不受影响。 */
	const bool speedHook = qEnvironmentVariableIsSet("MGBAX_SPEED_9");
	while (!m_closed.load(std::memory_order_relaxed) && !link->isClosed()) {
		qint64 now = QDateTime::currentMSecsSinceEpoch();
		maybeSendInitialState([link](const QByteArray& frame) { link->send(frame); }, m_hostRole);
		/* 开局那一包发出去之后开始计补发窗口；只在会话 ready 后才补。 */
		if (!armSeedSeen && m_initialStateSent.load(std::memory_order_relaxed)) {
			armSeedSeen = true;
			lastArmResend = now;
		}
		if (armSeedSeen && armResends < kArmResendMax && m_gboySession->isReady()
		    && now - lastArmResend >= kArmResendMs) {
			lastArmResend = now;
			++armResends;
			if (sendStateSync([link](const QByteArray& frame) { link->send(frame); })) {
				GbCloud::debugLog(QStringLiteral("[arm] type-6 resend %1/%2 (ready)")
				                          .arg(armResends)
				                          .arg(kArmResendMax));
			}
		}
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
				/* S2 TYPE_PARTY：同样按需触发（脚本放 party_mailbox 文件），门默认关恒 false。
				 * 只经 provider 只读导出本机 gPlayerParty，零写游戏态。 */
				QFile partyTrigger(dir + QStringLiteral("/party_mailbox"));
				if (partyTrigger.exists()) {
					partyTrigger.remove();
					sendPartyMailboxSync([link](const QByteArray& frame) { link->send(frame); });
				}
				if (speedHook) {
					QFile speedFile(dir + QStringLiteral("/speed"));
					if (speedFile.exists() && speedFile.open(QIODevice::ReadOnly)) {
						bool ok = false;
						const int speed = QString::fromLatin1(speedFile.readAll()).trimmed().toInt(&ok);
						speedFile.close();
						speedFile.remove();
						if (ok && (speed == 1 || speed == -1 || speed == 2 || speed == 4)) {
							sendSpeed(speed);
							GbCloud::debugLog(QStringLiteral("[gboy] speed hook: %1").arg(speed));
						} else {
							GbCloud::debugLog(QStringLiteral("[gboy] speed hook ignored: %1")
							                          .arg(speed));
						}
					}
				}
			}
		}
	/* 官方帧闸：type 9 的倍率决定节拍（nanos = 1e9/(speed*60)）。
	 * 1x=16.7ms、0.5x=33.3ms、2x=8.3ms、4x=4.2ms。本地切换与对端 type 9
	 * 都写 m_speedWire（等价官方共享的 AaHO0E 字段），没设置时按 1x。 */
		const double tickMs = GBoyLinkSession::tickMsForSpeed(m_speedWire.load(std::memory_order_relaxed));
		if (now - lastTick >= tickMs) {
			lastTick = now;
			/* 脚本注入（MGBAX_SCRIPT_DIR/keys）走的是 ScriptedControl 的
			 * addKey/clearKey，不进本对象的 m_localKeys（GUI 的 keyFeed 喂的
			 * 可能是另一个实例）。这里并进进程级掩码，保证线上帧带着真实按键。 */
			int keys = m_localKeys.load(std::memory_order_relaxed)
#ifdef MGBAX_SCRIPTED_MASK
			         | ScriptedControl::globalMask()
#endif
			         ;
			{
				static qint64 lastDiagKeys = 0;
				if (now - lastDiagKeys >= 500) {
					lastDiagKeys = now;
					QFile f(QStringLiteral("D:/mgba-android-version/.zcode-tmp/cloud2p/serve_keys.log"));
					if (f.open(QIODevice::Append | QIODevice::Text)) {
						f.write(QStringLiteral("frame=%1 local=%2 scripted=%3 keys=%4\n")
						            .arg(m_officialFrame).arg(m_localKeys.load())
#ifdef MGBAX_SCRIPTED_MASK
						            .arg(ScriptedControl::globalMask())
#else
						            .arg(0)
#endif
									.arg(keys).toUtf8());
					}
				}
			}
			m_gboySession->onLocalFrame(++m_officialFrame, keys);
		}
		if (m_sendReset.exchange(false, std::memory_order_relaxed)) {
			m_gboySession->sendReset();
		}
		if (int speed = m_sendSpeed.exchange(0, std::memory_order_relaxed)) {
			m_gboySession->sendSpeed(speed);
			applyMirrorSpeed(speed);
			GbCloud::debugLog(QStringLiteral("[gboy] type 9 speed sent: %1").arg(speed));
		}
		/* 对端倍速变化 → 前端把 CoreController 的帧目标切过去（官方
		 * AaHO0E.f4302AZkASS 的等价物）。只在变化时 emit。 */
		{
			const int wireSpeed = m_gboySession->remoteSpeed();
			if (wireSpeed != m_lastSpeedWire) {
				m_lastSpeedWire = wireSpeed;
				m_speedWire.store(wireSpeed, std::memory_order_relaxed);
				applyMirrorSpeed(wireSpeed);
				emit remoteSpeedChanged(wireSpeed);
			}
		}
		/* 官方 type 6 失败即断链：-5（尺寸不符）对应错误码 3，其它对应 1。
		 * 镜像核在帧边界载入后写标记，这里在主循环收口。 */
		if (int stateError = m_mirrorStateError.exchange(0, std::memory_order_relaxed)) {
			fail(stateError == -5
			     ? QStringLiteral("对端存档尺寸不符（错误码 3），连接已断开")
			     : QStringLiteral("对端存档载入失败（错误码 1），连接已断开"));
			break;
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
		/* 收包等待不能超过「到下一帧还剩多久」，否则 recv 的固定 30ms 会变成
		 * 真正的节拍上限（倍速再高也跑不出来）。tickMs 是 double，先取整。 */
		const qint64 remaining = qint64(tickMs) - (now - lastTick);
		const int waitMs = int(qBound<qint64>(qint64(0), remaining, qint64(30)));
		if (!link->recv(&message, waitMs)) {
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

void CloudLink::applyMirrorSpeed(int wireValue) {
	const float speed = float(GBoyLinkSession::effectiveSpeed(wireValue));
	for (int i = 0; i < m_mirrorCount; ++i) {
		if (m_mirrors[i]) {
			m_mirrors[i]->setNetSpeed(speed);
		}
	}
}

void CloudLink::stopOfficialMatch() {
	/* 下一次连接必须重新走「镜像就绪 → 写文件 → 四核同时起跑」；残留的
	 * nav_at 会让可见核在镜像核创建之前就独自开跑，四核相位错开。 */
	m_mirrorStateError.store(0, std::memory_order_relaxed);
	m_armSeedState.clear();
	m_firstSeedState.clear();   /* P0：会话级缓存，防跨房间脏 seed 泄漏 */
	/* 倍速复位：新会话的 type 9 是 0（未收到）→ 1x，避免上一局的 4x 带进来。 */
	m_sendSpeed.store(0, std::memory_order_relaxed);
	m_speedWire.store(0, std::memory_order_relaxed);
	m_lastSpeedWire = 0;
	emit remoteSpeedChanged(0);
	const QString scriptDir = QString::fromLocal8Bit(qgetenv("MGBAX_SCRIPT_DIR"));
	if (!scriptDir.isEmpty()) {
		QFile::remove(scriptDir + QStringLiteral("/nav_at"));
	}
	/* 清理按数组上限 MIRROR_COUNT 走，覆盖所有可能创建过的镜像（2P 只占
	 * m_mirrors[0]，3/4P 占更多），空槽为 nullptr 自然跳过——比只按本局
	 * m_mirrorCount 清理更防御，绝不残留上一局的核。 */
	for (int i = 0; i < MIRROR_COUNT; ++i) {
		if (m_mirrors[i]) {
			m_mirrors[i]->stopMirror();
			delete m_mirrors[i];
			m_mirrors[i] = nullptr;
		}
	}
	if (m_gboySession) {
		delete m_gboySession;
		m_gboySession = nullptr;
	}
	if (m_mirrorSioPort || m_mirrorLocalKey) {
		m_mirrorSioPort = 0;
		m_mirrorLocalKey = 0;
		m_mirrorLockstep = false;
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
	/* C0 / ADR-002：中继阶段的 hello/accept 也带 1 bit mode。 */
	const int local = resolveLinkMode(qMax(1, m_currentRoom.playerCount));
	if (local == GBoyFrames::LINK_MODE_A || local == GBoyFrames::LINK_MODE_B) {
		marker.insert(QStringLiteral("m"), local);
	}
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
			/* C0：这是来自对端的标记，顺带取能力位。 */
			notePeerLinkMode(marker.value(QStringLiteral("m"))
			                         .toInt(GBoyFrames::LINK_MODE_UNKNOWN),
			                 QStringLiteral("WSS 信令标记"));
			return true;
		}
	}
	return false;
}

void CloudLink::sendRegister(ILink* link, Room* room) {
	int players = qMax(1, room->playerCount);
	/* C0：注册帧即握手帧，能力位必须在这里就带上，对端才有得可判。 */
	const int local = resolveLinkMode(players);
	m_linkMode.store(local, std::memory_order_relaxed);
	link->send(GBoyFrames::registerFrame(players, room->baseStateCount, local));
	GbCloud::debugLog(QStringLiteral("[C0] register mode=%1 players=%2")
	                          .arg(modeName(local), QString::number(players)));
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
	qint64 lastAdvertise = 0;
	qint64 lastPartyPoll = 0;   /* U2: path A 也要轮询 party_mailbox 触发（原只在 serveOfficial/path B） */
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
		if (m_sendReset.exchange(false, std::memory_order_relaxed)) {
			link->send(GBoyFrames::frame(GBoyFrames::TYPE_RESET, 0));
		}
		/* U2 修复：path A 的 serve() 此前完全没有 party_mailbox 脚本触发轮询
		 * （原块只在 serveOfficial/path B），导致 mode A 下 marker 永不消费、
		 * TYPE_PARTY 从不发。这里补一个独立轮询：仅 party，复用现有具名门与
		 * 只读 provider（不写 party/信任位/brs/rem/nr/st）。字节仍来自真 gPlayerParty。 */
		if (now - lastPartyPoll >= 250) {
			lastPartyPoll = now;
			const QString dir = qEnvironmentVariable("MGBAX_SCRIPT_DIR");
			if (!dir.isEmpty()) {
				QFile partyTrigger(dir + QStringLiteral("/party_mailbox"));
				if (partyTrigger.exists()) {
					partyTrigger.remove();
					sendPartyMailboxSync([link](const QByteArray& frame) { link->send(frame); });
				}
			}
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
	if (type == GBoyFrames::TYPE_REGISTER) {
		/* C0：对端 type-1 注册帧里带能力位。裸 6 字节 type-1 ack 的 body 只有
		 * 2 字节，linkModeOf() 会返回 UNKNOWN，不会误判。 */
		notePeerLinkMode(GBoyFrames::linkModeOf(body), QStringLiteral("type-1 注册帧"));
		return;
	}
	if (type == GBoyFrames::TYPE_KEYS || type == GBoyFrames::TYPE_KEYS_LOCAL) {
		int keys = GBoyFrames::intOf(body);
		// See m_remoteKeysEnabled: keep receiving the frame (the relay uses it
		// to confirm the peer is alive) but never feed it to our own core.
		emit remoteKeys(m_remoteKeysEnabled ? keys : 0);
	} else if (type == GBoyFrames::TYPE_RESET || type == GBoyFrames::TYPE_RESET_LEGACY) {
		/* 官方 5 = 复位；13 是旧版我们自己的号，继续认。 */
		emit remoteReset();
	} else if (type == GBoyFrames::TYPE_STATE) {
		// The SIO relay bridge also uses type 6 with a raw netLink packet and
		// no length header; stateOf() rejects those instead of loading garbage.
		QByteArray state = GBoyFrames::stateOf(body);
		if (!state.isEmpty()) {
			emit remoteState(state);
		}
	} else if (type == GBoyFrames::TYPE_PARTY) {
		/* S2：party 哑传输帧。PC 侧只做机械校验 + 记日志；不写任何游戏态，
		 * 不触发 remoteState/applyRemoteState；真实性只由零注入 CROSSED 裁决。 */
		QByteArray mb = GBoyFrames::partyOf(body);
		if (!mb.isEmpty()) {
			emit remotePartyMailbox(mb);
			GbCloud::debugLog(QStringLiteral("[GNP] RX TYPE_PARTY bytes=%1 (log-only)").arg(mb.size()));
		}
	}
}

/* GBoy KpHwm4.B25kr6:type 6 是**双向**的：房主和入房方各自把本机可见核的
 * 即时存档推给对端，对端灌进「代表这个玩家的镜像核」。只在房主一侧发时，
 * 房主的镜像核（= 入房方那个玩家）永远停在自己的电池存档上，两边核心从
 * 第一帧起就不在同一幕 —— 这正是实测里「对方在推、本机一帧收不到」「pc 恒 0」
 * 的直接原因。因此这里不再按角色门控，两端各发一次。 */
bool CloudLink::maybeSendInitialState(const std::function<void(const QByteArray&)>& send, bool asHost) {
	(void) asHost; /* 两端都发：见上面的 GBoy type 6 双向说明 */
	/* official case 6（u32 长度头 + 整份 savestate）只属于 path B：本机多核 +
	 * 网络只传按键，对端把它灌进代表本机的镜像核。path A（SIO 字节管道）里
	 * type 6 借壳承载的是裸 20 字节 netLink 包，startSioRelayBridge / serve 的
	 * 接收侧把 payload 原样写回本地 socket；整份 savestate 混进去会破坏 SIO
	 * 帧边界（两条路径同流还会耗死读线程，见本文件 608-610 的历史事故）。
	 * 这里一次门控覆盖 path A 的全部调用点，避免以后新增调用点再漏。 */
	if (!m_officialMode) {
		/* 机器可读证据：path A 从不把整份 savestate 塞进 type 6（那会破坏
		 * 20 字节 netLink 帧边界）。每个进程只写一次，避免每 tick 刷屏。 */
		static std::atomic<bool> s_pathASkipLogged{false};
		if (!s_pathASkipLogged.exchange(true, std::memory_order_relaxed)) {
			GbCloud::debugLog(QStringLiteral("[MGBAX_PATH] me=%1 event=initial-state-skipped path=A reason=raw-20B-sio-pipe frameIntact=1")
			                          .arg(m_wsNonce));
		}
		return false;
	}
	/* 对端必须已经把「本机镜像核已就绪」的 register（type 1）发过来，才
	 * 说明它的 serve 循环马上开始 recv。否则 46KB 的 type-6 分片会推进一个
	 * 还没人收的 UDP 缓冲：对端收不齐 → 我们 40 次重传后直连被判死
	 * （PB12 现场：initial state 发出后 2.7 秒断链）。官方客户端也是先
	 * 收到对端 1/2/3 才回灌 case 6，顺序一致。 */
	if (!m_gboySession || !m_gboySession->isReady()) {
		return false;
	}
	if (!m_stateSnapshot || m_initialStateSent.load(std::memory_order_relaxed)) {
		return false;
	}
	QByteArray state = m_armSeedState.isEmpty() ? m_stateSnapshot() : m_armSeedState;
	if (state.isEmpty()) {
		return false;   // core not ready yet; retry on the next tick
	}
	m_initialStateSent.store(true, std::memory_order_relaxed);
	/* P0：门开且尚未缓存时，缓存首份发出的字节。仅拷贝成型 QByteArray，不生成
	 * 新快照、不写游戏态；后续 arm 重发 / sync_state 复用它保持 seed 同源。 */
	if ((MGBAX_SEED_CLEAN_RESEND != 0 || qgetenv("MGBAX_SEED_CLEAN_RESEND").toInt() != 0)
	    && m_firstSeedState.isEmpty()) {
		m_firstSeedState = state;
	}
	send(GBoyFrames::stateFrame(state));
	/* ISYNC-EV/A1-SEND: 真发送点只读记录本机种子 sha256（逻辑在 GBoyMirror.cpp，
	 * 具名门 MGBAX_ISYNC_EVIDENCE + MGBAX_ISYNC_EVIDENCE_A1 默认关）。不造种子。 */
	isyncEvidenceLogSeedSend(state, "initial");
	GbCloud::debugLog(QStringLiteral("[arm] initial state sent (%1 bytes, seed=%2)")
	                          .arg(state.size())
	                          .arg(m_armSeedState.isEmpty() ? 0 : 1));
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
	/* P0 / 脏 seed 干净重发：门开时按 m_armSeedState(真帧0) > m_firstSeedState
	 * (缓存首份) > m_stateSnapshot() 选源；门关保持原即时快照行为（A/B 可逆）。
	 * 只选字节、不生成新快照、不写游戏态，避免含 st4/8FFF/B9A0 的脏 seed 造成
	 * 幻影 st4 乒乓。 */
	const bool cleanResend = (MGBAX_SEED_CLEAN_RESEND != 0
	                          || qgetenv("MGBAX_SEED_CLEAN_RESEND").toInt() != 0);
	QByteArray state;
	if (cleanResend && !m_armSeedState.isEmpty()) {
		state = m_armSeedState;
	} else if (cleanResend && !m_firstSeedState.isEmpty()) {
		state = m_firstSeedState;
	} else {
		state = m_stateSnapshot();
	}
	if (state.isEmpty()) {
		return false;
	}
	send(GBoyFrames::stateFrame(state));
	/* ISYNC-EV/A1-SEND: 周期性 state sync 同样只读记录种子 sha256（门默认关）。 */
	isyncEvidenceLogSeedSend(state, "sync");
	return true;
}

/* S2：TYPE_PARTY 发送。门默认关 / provider 空 / 帧非法都直接 false ⇒ 零回归。
 * 字节来自 provider（CoreController::readNetPartyMailbox 的只读 builder）；
 * 本函数不写游戏态、不造 party、不碰 brs/rem/nr/st。 */
bool CloudLink::sendPartyMailboxSync(const std::function<void(const QByteArray&)>& send) {
	if (!netPartyMailboxEnabled() || !m_partyMailbox) {
		GbCloud::debugLog(QStringLiteral("[GNP-DIAG] fail: gate=%1 provider=%2")
		                  .arg(netPartyMailboxEnabled() ? 1 : 0).arg(m_partyMailbox ? 1 : 0));
		return false;
	}
	QByteArray mb = m_partyMailbox();
	if (mb.isEmpty()) {
		GbCloud::debugLog(QStringLiteral("[GNP-DIAG] fail: provider returned empty mailbox"));
		return false;
	}
	QByteArray frame = GBoyFrames::partyFrame(mb);
	if (frame.isEmpty()) {
		GbCloud::debugLog(QStringLiteral("[GNP-DIAG] fail: partyFrame empty"));
		return false;
	}
	send(frame);                                    // 复用现有 relay，不新开 socket
	GbCloud::debugLog(QStringLiteral("[GNP] TX TYPE_PARTY bytes=%1 (mailbox-only)").arg(mb.size()));
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
						/* C0：建房/等节点阶段的 hello 也可能带能力位，别漏。 */
						if (ok) {
							notePeerLinkMode(marker.value(QStringLiteral("m"))
							                         .toInt(GBoyFrames::LINK_MODE_UNKNOWN),
							                 QStringLiteral("WSS 信令 hello"));
						}
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
	/* C0 / ADR-002：手动中继（含 MGBAX_AUTOLINK 测试脚手架）同样要过协商门。 */
	if (!negotiateLinkMode(&room, QStringLiteral("手动中继"))) {
		cleanupChannel();
		return;
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

void CloudLink::logPathDiag(const QString& path, const QString& transport, const QString& frameEnc) {
	const int mode = m_linkMode.load(std::memory_order_relaxed);
	const QString modeShort = mode == GBoyFrames::LINK_MODE_A ? QStringLiteral("A")
	                        : mode == GBoyFrames::LINK_MODE_B ? QStringLiteral("B")
	                                                          : QStringLiteral("UNKNOWN");
	GbCloud::debugLog(QStringLiteral("[MGBAX_PATH] me=%1 path=%2 mode=%3 officialMode=%4 transport=%5 frameEnc=%6")
	                          .arg(m_wsNonce).arg(path).arg(modeShort)
	                          .arg(m_officialMode ? 1 : 0).arg(transport).arg(frameEnc));
	/* 这些环境变量决定「握手能不能收尾」：MGBAX_LINK_REARM 每轮补
	 * handshakeAsMaster，MGBAX_FAST_MIN_OK[_SLAVE] 控制快帧提前放行。
	 * 真值在 mgba_sio.log 的 `[rearm] fired` / `[diag] lstate/pc/st` 里，
	 * 这里把「门是否打开、该去哪里读、成功签名是什么」写成机器可读的行，
	 * 避免把「门没开」误判成「门开了但没生效」。 */
	auto env = [](const char* key) {
		const QByteArray v = qgetenv(key);
		return v.isEmpty() ? QStringLiteral("<unset>") : QString::fromLatin1(v);
	};
	GbCloud::debugLog(QStringLiteral("[MGBAX_GATE] me=%1 path=%2 envLinkMode=%3 envOfficialLink=%4 envRearm=%5 fastMinOk=%6 fastMinOkSlave=%7 sioFast=%8 sioLog=%9 linkDiag=%10 hsSignature=%11 hsLog=%12 envHsBypass=%13")
	                          .arg(m_wsNonce)
	                          .arg(path)
	                          .arg(env("MGBAX_LINK_MODE"))
	                          .arg(env("MGBAX_OFFICIAL_LINK"))
	                          .arg(env("MGBAX_LINK_REARM"))
	                          .arg(env("MGBAX_FAST_MIN_OK"))
	                          .arg(env("MGBAX_FAST_MIN_OK_SLAVE"))
	                          .arg(env("MGBAX_SIO_FAST"))
	                          .arg(env("MGBAX_SIO_LOG"))
	                          .arg(env("MGBAX_LINK_DIAG"))
	                          .arg(QStringLiteral("lstate=4,pc=2,st&0x20"))
	                          .arg(QStringLiteral("mgba_sio.log:[rearm] fired,[diag]"))
	                          .arg(env("MGBAX_LINK_HSBYPASS")));
}

/* ---- C0 能力协商（ADR-002）------------------------------------------------
 * 硬约束：path A 在 type 6 上跑裸 20 字节 netLink 包，path B 在 type 6 上跑
 * 整份 savestate（u32 长度 + blob）。两者同流会破坏帧边界，CloudLink.cpp:608-610
 * 记过 9470 个碎片包耗死读线程。所以绑定必须发生在任何游戏帧之前。
 *
 * negotiateLinkMode() 的实际判定顺序（注释以代码为准，F6）：
 *   1. 已经 fail 过（m_modeRejected）        → 直接 return false，不再 fail 第二次；
 *   2. 本端绑定（resolveLinkMode + m_officialMode + m_modeBound=true）；
 *   3. 对端仍 UNKNOWN → 先有界等最多 2s 收 WSS hello/accept（F7），再重读；
 *   4. 对端 INVALID                          → fail（畸形）；
 *   5. 对端 == 本端                          → 通过；
 *   6. 对端 UNKNOWN                          → 默认 fail；仅 MGBAX_LINK_ALLOW_LEGACY=1
 *      显式许可才回落 B 并在状态栏写明「未经 2P 云端验收」；
 *   7. 其余（两端都声明且不同）              → fail，绝不挑一个「能跑的」静默降级。
 * 注意第 2 步先于第 3 步：本端模式在等待对端之前就已绑定，因此等待期间到达的
 * 对端能力位（notePeerLinkMode）能立刻与本端比对，不一致会当场 fail。
 */
QString CloudLink::modeName(int mode) {
	switch (mode) {
	case GBoyFrames::LINK_MODE_A:
		return QStringLiteral("A（每端 1 核 + SIO 包中继）");
	case GBoyFrames::LINK_MODE_B:
		return QStringLiteral("B（本机多核 + 网络只传按键）");
	case GBoyFrames::LINK_MODE_INVALID:
		return QStringLiteral("畸形能力位");
	default:
		return QStringLiteral("未声明 / AUTO");
	}
}

int CloudLink::resolveLinkMode(int playerCount) const {
	/* 判定本身在 GBoyFrames::resolveLinkMode()：那份实现同时被 test-gboylink
	 * --c0 直接断言，避免测试与线上逻辑各写一份、慢慢分叉。对外行为不变。 */
	return GBoyFrames::resolveLinkMode(playerCount, m_modeOverride);
}

void CloudLink::notePeerLinkMode(int mode, const QString& source) {
	if (mode == GBoyFrames::LINK_MODE_UNKNOWN) {
		return; // 官方 APK / 旧客户端：没有能力位
	}
	if (mode == GBoyFrames::LINK_MODE_INVALID) {
		/* F8：把 INVALID 回写，让「对端畸形」这个事实留在状态里可被重读。
		 *
		 * 注意因果（2026-11 修正，别照旧注释理解）：回写**不是**挡住
		 * 「畸形被 allow_legacy 放行」的那道锁。那道锁是紧接着的
		 * `exchange(true)` 置 m_modeRejected —— negotiateLinkMode() 顶部的
		 * `if (m_modeRejected) return false;` 会先短路，根本走不到
		 * 「对端未声明 → 显式许可回落 B」那条分支。
		 * 实测证据（变异反向验证）：临时去掉这行 store 重编，--gatetest 只红
		 * 一条 —— 用例 4 的「INVALID is written back」；用例 7「畸形 +
		 * allow_legacy=true 仍然拒绝」照旧绿。可见放行路径本来就不通。
		 *
		 * 回写的真实价值是**状态一致**：m_peerLinkMode 必须与实际发生的事一致，
		 * 后续重读/诊断不会把「畸形」误报成「未声明」，negotiateLinkMode() 里
		 * 那条 peer == INVALID 的分支也才自洽（它是第二道锁，不是第一道）。
		 *
		 * 与 Android 的差异（同一结构的两端口径）：Android
		 * GBoyCloudLink.notePeerLinkMode() 对 INVALID 不写 peerLinkMode，
		 * 它的安全同样来自 modeRejected 短路；两端结果等价，只是 PC 多留了
		 * 一份可观测状态。
		 *
		 * 另注：negotiateLinkMode() 里 peer == INVALID 那条分支曾是无条件 fail()
		 * （没有 exchange 保护），与其它分支不一致。它当前被顶部短路挡着走不到，
		 * 所以不会重复报错；但一旦有人删掉顶部短路，用户就会收到两条「畸形」文案。
		 * 现已统一为 exchange 保护，并由 --gatetest 用例 11 **强制**执行该分支来验证
		 * （强制方式：把 rejected 清成 false + peer 设成 INVALID，这是它唯一的可达构造）。 */
		m_peerLinkMode.store(mode, std::memory_order_relaxed);
		if (!m_modeRejected.exchange(true, std::memory_order_relaxed)) {
			/* F9：与其它几条协商失败文案对齐——本机=、对端=、来源、怎么改。 */
			const QString localText = m_modeBound.load(std::memory_order_relaxed)
				? modeName(m_linkMode.load(std::memory_order_relaxed))
				: QStringLiteral("尚未绑定（AUTO）");
			fail(QStringLiteral("【联机模式协商失败】本机=%1，对端能力位畸形（来源 %2）。"
			                   "畸形 = 缺少能力位标记（0x40）或保留了非 0 位，"
			                   "通常是对端版本不一致/能力位被写坏，无法确认两端帧格式一致，"
			                   "已断开以避免两套帧格式同流。请两端使用相同版本，并确认两端"
			                   "联机模式设置相同（大厅下拉框或 MGBAX_LINK_MODE=A|B）。")
			             .arg(localText, source));
		}
		return;
	}
	m_peerLinkMode.store(mode, std::memory_order_relaxed);
	GbCloud::debugLog(QStringLiteral("[C0] peer mode=%1 from %2")
	                          .arg(modeName(mode), source));
	if (!m_modeBound.load(std::memory_order_relaxed)) {
		return; // 本地还没绑定，等 negotiateLinkMode() 统一判定
	}
	const int local = m_linkMode.load(std::memory_order_relaxed);
	if (local != mode && !m_modeRejected.exchange(true, std::memory_order_relaxed)) {
		fail(QStringLiteral("【联机模式协商失败】本机=%1，对端=%2（来源 %3）。"
		                   "两套帧格式不能同流，已断开；请在两端设置相同的联机模式"
		                   "（大厅下拉框或 MGBAX_LINK_MODE=A|B）。")
		             .arg(modeName(local), modeName(mode), source));
	}
}

bool CloudLink::negotiateLinkMode(Room* room, const QString& where) {
	if (m_modeRejected.load(std::memory_order_relaxed)) {
		return false;
	}
	const int local = resolveLinkMode(qMax(1, room->playerCount));
	m_linkMode.store(local, std::memory_order_relaxed);
	m_officialMode = (local == GBoyFrames::LINK_MODE_B);
	m_modeBound.store(true, std::memory_order_relaxed);
	/* §4.2(c)：把「这一轮到底跑了哪条路」和环境变量来源一起落盘。
	 * MGBAX_OFFICIAL_LINK=1 残留曾把 2 人房悄悄拽成 B，读日志时无从分辨。 */
	logPathDiag(local == GBoyFrames::LINK_MODE_B ? QStringLiteral("B") : QStringLiteral("A"),
	            QStringLiteral("negotiating"), QStringLiteral("pending"));

	int peer = m_peerLinkMode.load(std::memory_order_relaxed);
	if (peer == GBoyFrames::LINK_MODE_UNKNOWN) {
		/* WSS hello/accept 是主协商通道，但它与 KCP 握手是两条独立时钟：
		 * 中继偶尔会先握手成功、对端 hello 稍后才到。给一个 2s 的**墙钟上界**，
		 * 期间只排空信令（数据通道此时还没开始跑，不会吃掉游戏帧）。
		 * 超过仍未知才按「未声明」处理，绝不无限等待。
		 *
		 * F7（2026-11 修正）：这里原本是 `for (i < 20) drainSignaling(session, 100)`，
		 * 注释声称 2s、实测只有 ~1.2s。根因不在循环而在 drainSignaling()：它是
		 * **排空**语义 —— 内部 `sig->recv(60)` 一返回空就 `return`，所以单次调用
		 * 只花 ~60ms（recv 自己的超时），而不是参数里的 100ms，20 × 60ms ≈ 1200ms。
		 * 只有 m_session 不可用的那条分支（waitAndProcess(100)）才真是 2s。
		 * 现在改成按 deadline 循环，drain 之后把剩余时间用 waitAndProcess() 补齐，
		 * 两条分支都真的受同一个 deadline 约束。
		 *
		 * 口径（不要误读）：这是**构造保证的 2000ms 上界**，不是实测值。
		 * 实测覆盖情况分两条分支说，别混成一句「已实测 2s」：
		 *   - `waitAndProcess()` 分支（m_session 为 nullptr）：已由 test-gboylink
		 *     --gatetest 实测 2004~2014ms（真实 negotiateLinkMode() 量出来的）；
		 *   - `drainSignaling()` 分支（信令可用，真机主路径）：**仍只有构造保证**，
		 *     未做真实云端时序实测（需要活的账号 + 房间）。该分支的时序语义
		 *     目前由 --gatetest 用例 8/9/10 通过 m_gatePump 注入模拟覆盖，
		 *     注入的是「泵提前返回 / 晚到 / 中途 close」三种时序，不是真网络。 */
		const qint64 kPeerModeWaitMs = 2000;
		const qint64 deadline = QDateTime::currentMSecsSinceEpoch() + kPeerModeWaitMs;
		while (!m_closed.load(std::memory_order_relaxed)
		       && m_peerLinkMode.load(std::memory_order_relaxed) == GBoyFrames::LINK_MODE_UNKNOWN) {
			qint64 left = deadline - QDateTime::currentMSecsSinceEpoch();
			if (left <= 0) {
				break;
			}
			const int slice = int(qMin<qint64>(left, 100));
			const bool signalling = m_session && m_session->isOpen();
			if (!signalling && !m_gatePump) {
				waitAndProcess(slice);
				continue;
			}
			if (m_gatePump) {
				/* 仅测试注入（--gatetest 用例 8/9/10）：语义等价于「信令可用但
				 * drainSignaling() 提前返回」。泵自己决定这一轮排空花多少、
				 * 期间对端能力位是否到达、要不要 close。返回值丢弃 —— 控制流
				 * 只认 deadline，否则注入方谎报耗时就能绕过上界。 */
				m_gatePump(slice);
			} else {
				drainSignaling(m_session, slice);
			}
			/* drainSignaling 只排空此刻队列里已有的信令、不保证占满 slice
			 * （见上），剩下的时间交给事件循环，等对端 hello 真正到达。
			 * 这一句也是 F7 的修复本体：泵/drain 提前返回时，靠它把时间补齐。 */
			left = deadline - QDateTime::currentMSecsSinceEpoch();
			if (left > 0) {
				waitAndProcess(int(qMin<qint64>(left, 100)));
			}
		}
		peer = m_peerLinkMode.load(std::memory_order_relaxed);
	}
	if (peer == GBoyFrames::LINK_MODE_INVALID) {
		/* 这条分支在生产路径上**不可达**：INVALID 只能经 notePeerLinkMode() 进来，
		 * 而那里已经把 m_modeRejected 置位，顶部 `if (m_modeRejected) return false;`
		 * 会先短路。它的定位是「短路被误删时的第二道锁」，由 test-gboylink
		 * --gatetest 用例 11 强制覆盖（把 rejected 清成 false + peer 设成 INVALID）。
		 *
		 * 失败文案必须是**幂等**的：与兄弟分支一致用 exchange 保护。没有它时，
		 * 一旦顶部短路被删掉，用户会收到两条「畸形」文案（一条来自
		 * notePeerLinkMode、一条来自这里）—— 用例 11 的「只报一次」断言钉的就是它。 */
		if (!m_modeRejected.exchange(true, std::memory_order_relaxed)) {
			/* F9：补齐本机模式、对端状态、来源与改法，与其余文案同等完整度。 */
			fail(QStringLiteral("【联机模式协商失败】本机=%1，对端能力位畸形（%2）。"
			                   "畸形 = 缺少能力位标记（0x40）或保留了非 0 位，"
			                   "无法确认两端帧格式一致，已断开以避免两套帧格式同流。"
			                   "请两端使用相同版本，并确认两端联机模式设置相同"
			                   "（大厅下拉框或 MGBAX_LINK_MODE=A|B）。")
			             .arg(modeName(local), where));
		}
		return false;
	}
	if (peer == local) {
		status(QStringLiteral("联机模式协商通过：%1（%2，%3 人房）")
		               .arg(modeName(local), where, QString::number(qMax(1, room->playerCount))));
		return true;
	}
	if (peer == GBoyFrames::LINK_MODE_UNKNOWN) {
		if (m_allowLegacyPeer) {
			/* 显式许可才允许回落：不是静默降级，状态栏会明确写出来。 */
			m_officialMode = true;
			m_linkMode.store(GBoyFrames::LINK_MODE_B, std::memory_order_relaxed);
			status(QStringLiteral("警告：对端未声明联机模式（旧客户端/官方 APK），"
			                     "按 MGBAX_LINK_ALLOW_LEGACY=1 显式许可回落为 %1（%2）。"
			                     "此路径未经 2P 云端验收，不建议用于交付。")
			               .arg(modeName(GBoyFrames::LINK_MODE_B), where));
			return true;
		}
		/* 刻意**不加** exchange 幂等：本分支的重复 emit 是「顶部短路被误删」时的报警信号，
		 * 用例 2/5/10 依赖 secondStatusCount == 1 才红。若要加幂等，必须同步把这三条断言
		 * 改成靠别的可观测量（例如 linkMode 被重解析）来报警，否则短路失效将无人发现。
		 * 与 INVALID 分支的区别：那条会被正常走到（用例 11 强制），防双发是正当需求；
		 * 这两条在短路健康时永不重入，所以「不幂等」在这里是**承重的**，不是遗漏。 */
		m_modeRejected.store(true, std::memory_order_relaxed);
		/* F9：这条原本只写了「本机为 X」，没给来源、也没给「两端设置相同模式」
		 * 这个最常用的改法；补齐到与其余文案同等完整度。 */
		fail(QStringLiteral("【联机模式协商失败】本机=%1，对端未声明联机模式"
		                   "（旧客户端 / 官方 APK，%2）。"
		                   "无法确认两端帧格式一致，已断开以避免同流事故。"
		                   "请两端使用相同版本的客户端，并确认两端联机模式设置相同"
		                   "（大厅下拉框或 MGBAX_LINK_MODE=A|B）；确需与旧客户端互通时，"
		                   "两端显式设置 MGBAX_LINK_ALLOW_LEGACY=1（PC）/ "
		                   "ADB allow_legacy=true（Android）。")
		             .arg(modeName(local), where));
		return false;
	}
	/* 同样刻意**不加** exchange 幂等：理由同上一条分支 —— 这里的重复 emit 是
	 * 「顶部短路被误删」的报警信号，用例 2（冲突）依赖 secondStatusCount == 1 才红。
	 * 若将来为形式一致补幂等，必须同时改造用例 2/5/10 的报警依据。 */
	m_modeRejected.store(true, std::memory_order_relaxed);
	fail(QStringLiteral("【联机模式协商失败】本机=%1，对端=%2（%3）。"
	                   "两套帧格式不能同流，已断开；请在两端设置相同的联机模式"
	                   "（大厅下拉框或 MGBAX_LINK_MODE=A|B）。")
	             .arg(modeName(local), modeName(peer), where));
	return false;
}

}
