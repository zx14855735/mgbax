/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "CloudLink.h"
#include "moc_CloudLink.cpp"

#include "GbCloud.h"
#include "GBoyFrames.h"
#include "KcpChannel.h"
#include "SioLinkHost.h"

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
constexpr qint64 RELAY_WINDOW_MS = 12000;
/** Tunnel hello markers are re-sent at this pace until the peer answers. */
constexpr qint64 TUNNEL_HELLO_MS = 2000;
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
		QJsonObject marker;
		marker.insert(QStringLiteral("gboy_ws"), QStringLiteral("f"));
		if (!m_roomTag.isEmpty()) {
			marker.insert(QStringLiteral("room"), m_roomTag);
		}
		marker.insert(QStringLiteral("from"), m_nonce);
		marker.insert(QStringLiteral("d"), QString::fromLatin1(payload.toBase64()));
		QString error;
		if (!m_sig->sendText(wsText(sendMessageJson(m_token, m_uuid, wsText(marker))), &error)) {
			m_closed = true;
			m_error = QStringLiteral("服务器隧道发送失败：%1").arg(error);
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
			if (object.value("type").toString() != QStringLiteral("send_message")) {
				continue; // other pushes do not matter once data is flowing
			}
			QString message = object.value("message").toString();
			if (!message.contains(QStringLiteral("gboy_ws"))) {
				continue;
			}
			bool ok = false;
			QJsonObject marker = GbCloud::lastJsonObject(message, &ok);
			if (!ok) {
				continue;
			}
			QString kind = marker.value(QStringLiteral("gboy_ws")).toString();
			QString tagged = marker.value(QStringLiteral("room")).toString();
			if (!m_roomTag.isEmpty() && !tagged.isEmpty() && tagged != m_roomTag) {
				continue; // someone else's room
			}
			QString from = marker.value(QStringLiteral("from")).toString();
			if (!from.isEmpty() && from == m_nonce) {
				continue; // the server echoed our own push back to us
			}
			if (kind == QStringLiteral("f")) {
				QByteArray frame = QByteArray::fromBase64(
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
			}
		}
	}

	void sendMarker(const QString& kind) {
		QJsonObject marker;
		marker.insert(QStringLiteral("gboy_ws"), kind);
		if (!m_roomTag.isEmpty()) {
			marker.insert(QStringLiteral("room"), m_roomTag);
		}
		marker.insert(QStringLiteral("from"), m_nonce);
		m_sig->sendText(wsText(sendMessageJson(m_token, m_uuid, wsText(marker))));
	}

	GbCloud::Session* m_sig;
	QString m_token;
	QString m_uuid;
	QString m_roomTag;
	QString m_nonce;
	QQueue<QByteArray> m_inbox;
	bool m_closed = false;
	bool m_peerSeen = false;
	QString m_error;
	qint64 m_lastHello = 0;
	qint64 m_lastAccept = 0;
};

}

namespace QGBA {

static intptr_t attachDriverLoopback(SioLinkHost* cc, bool asHost, QString* error);

CloudLink::CloudLink(QObject* parent)
	: QThread(parent)
{
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
		m_session = nullptr;
		fail(QStringLiteral("联机流程中断：%1").arg(QString::fromUtf8(e.what())));
	} catch (...) {
		cleanupTunnel();
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
	// 【中继节点重生】中继节点时好时坏（有时秒回有时完全不响应）。
	// 握不上不立刻放弃：解散旧房间重新创建拿新节点再试，最多 3 轮。
	for (int relayAttempt = 0; relayAttempt < 3 && !link && !m_closed.load(std::memory_order_relaxed); relayAttempt++) {
		if (relayAttempt > 0) {
			status(QStringLiteral("中继节点没有回应（第 %1 次），解散旧房间重新创建…").arg(relayAttempt));
			room->nodeAddress.clear();
			room->nodePort = 0;
			// 解散旧房间拿新节点（和 hostCreateRoom 同一支舞，但不 throw）。
			try {
				sig->sendText(wsText(createJson(token, gameName())));
				waitAndProcess(2500);
				waitForRoomId(sig, room, 5000);
				if (!room->roomId.isEmpty()) {
					sig->sendText(wsText(json(QStringLiteral("join_room"), token, room->roomId)));
					waitAndProcess(1500);
					sig->sendText(wsText(json(QStringLiteral("leave_room"), token, QString())));
					waitAndProcess(1500);
					waitAndProcess(800);
				}
				Room fresh;
				for (int attempt = 1; attempt <= 3 && fresh.roomId.isEmpty(); attempt++) {
					sig->sendText(wsText(createJson(token, gameName())));
					waitAndProcess(2500);
					waitForRoomId(sig, &fresh, 6000);
				}
				if (fresh.roomId.isEmpty()) {
					status(QStringLiteral("重试创建房间失败"));
					continue;
				}
				room->roomId = fresh.roomId;
				room->nodeAddress = fresh.nodeAddress;
				room->nodePort = fresh.nodePort;
				sig->sendText(wsText(json(QStringLiteral("join_room"), token, room->roomId)));
				waitAndProcess(1500);
				sig->sendText(wsText(json(QStringLiteral("ready"), token, QString())));
				waitAndProcess(1200);
				sig->sendText(wsText(settingsJson(token, room->roomId)));
				waitAndProcess(1500);
				sig->sendText(wsText(createJson(token, gameName())));
				waitAndProcess(2500);
				waitForRoom(sig, room, QString(), ROOM_WAIT_MS);
			} catch (const std::exception& e) {
				// 房间舞步失败不算致命：继续下一轮或回落隧道
				status(QStringLiteral("重试创建房间出错：%1").arg(QString::fromUtf8(e.what())));
				continue;
			}
			if (room->nodeAddress.isEmpty() || room->nodePort <= 0) {
				continue;
			}
			status(QStringLiteral("新中继节点 %1:%2，正在重试…")
			       .arg(room->nodeAddress).arg(room->nodePort));
		}
		if (!room->nodeAddress.isEmpty() && room->nodePort > 0) {
			link = startRelayLink(room->nodeAddress, room->nodePort, room, sig, token, uuid, asHost,
			                      RELAY_WINDOW_MS);
		} else {
			status(QStringLiteral("没有可用的中继地址，直接使用服务器隧道模式"));
		}
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
	// 官方 KCP 中继活着：SIO 分开控制模式直接把联机线字节过中继
	// （netLink 包封在 type-6 帧里），RTT 比 WS 隧道低 3-7 倍。
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
			waitForRoom(sig, &probe, room->roomId, 8000);
		} else {
			// The joiner listens to the host's broadcast and follows along.
			waitForRoom(sig, &probe, room->roomId, 4000);
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
				handshake(link, room);
				return link;
			} catch (std::exception& e) {
				// Already talking to the relay, but the peer has not registered
				// yet: keep the same session and keep waiting.
				GbCloud::debugLog(QStringLiteral("relay handshake pending: ") + e.what());
				if (!waitAndProcess(1000)) {
					break;
				}
				continue;
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
		}
		drainSignaling(sig, 120);
		if (m_tunnelPeerSeen) {
			status(QStringLiteral("对方已在服务器隧道上等待，放弃直连中继"));
			link->close();
			delete link;
			m_channel = nullptr;
			return nullptr;
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
void CloudLink::runTunnel(GbCloud::Session* sig, const QString& token, Room* room, bool asHost) {
	const QString tag = room->roomId;
	status(QStringLiteral("正在通过服务器隧道等待对方进入（跨网可联）…"));
	WsLink* link = new WsLink(sig, token, m_advertiserUuid, tag, m_wsNonce);
	m_tunnel = link;
	m_tunnelUp = true;
	m_tunnelPeerSeen = false;
	qint64 deadline = QDateTime::currentMSecsSinceEpoch() + RELAY_WAIT_MS;
	qint64 lastNotice = 0;
	QByteArray discard;
	while (!m_closed.load(std::memory_order_relaxed) && !link->isClosed() && !link->peerSeen()
	       && QDateTime::currentMSecsSinceEpoch() < deadline) {
		link->recv(&discard, 1000);
		qint64 now = QDateTime::currentMSecsSinceEpoch();
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
	startSioBridge(link, asHost);
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
	// 单线程泵：select 本地 socket（出向）+ 短超时收隧道（入向）。
	while (!m_closed.load(std::memory_order_relaxed) && !link->isClosed() && m_sioSock >= 0) {
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
			link->send(QByteArray(reinterpret_cast<const char*>(buf), n));
		}
		QByteArray pkt;
		if (link->recv(&pkt, 20)) {
			if (!sockSendAll(local, reinterpret_cast<const uint8_t*>(pkt.constData()),
			                 static_cast<size_t>(pkt.size()))) {
				break;
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
			link->send(QByteArray(reinterpret_cast<const char*>(buf), n));
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
		if (!message.contains(QStringLiteral("gboy_ws"))) {
			continue;
		}
		bool ok = false;
		QJsonObject marker = GbCloud::lastJsonObject(message, &ok);
		if (!ok) {
			continue;
		}
		QString from = marker.value(QStringLiteral("from")).toString();
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

void CloudLink::handshake(ILink* link, Room* room) {
	// The cloud handshake of the official client:
	//   -> type 1, body: int playerCount, short 0, int baseStateCount
	//   <- type 3, body: int playerCount
	//   -> type 3, body: empty
	//   <- type 0, body: int (first key state of the peer)
	//   -> type 1, body: empty (acknowledgement)
	QByteArray count = expect(link, GBoyFrames::TYPE_READY, STEP_WAIT_MS);
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
		emit remoteKeys(keys);
	} else if (type == GBoyFrames::TYPE_RESET) {
		emit remoteReset();
	}
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
		// The peer is already waiting on the websocket tunnel; no node is
		// coming, so stop listening and let the data stage use the tunnel.
		if (m_tunnelPeerSeen) {
			return;
		}
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
	emit statusMessage(GbCloud::lobby(text));
}

}
