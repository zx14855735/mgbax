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
	       const QString& roomTag, const QString& nonce, GBoyFrames::Reader* reader)
		: m_sig(sig)
		, m_token(token)
		, m_uuid(uuid)
		, m_roomTag(roomTag)
		, m_nonce(nonce)
		, m_reader(reader)
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
		QByteArray body = m_reader->next();
		if (!body.isNull()) {
			*out = body;
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
		}
		if (!m_closed && !m_sig->isOpen()) {
			m_closed = true;
			m_error = QStringLiteral("服务器隧道连接中断");
		}
		body = m_reader->next();
		if (!body.isNull()) {
			*out = body;
			return true;
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
					m_reader->append(frame.constData(), frame.size());
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
	GBoyFrames::Reader* m_reader;
	bool m_closed = false;
	bool m_peerSeen = false;
	QString m_error;
	qint64 m_lastHello = 0;
	qint64 m_lastAccept = 0;
};

}

namespace QGBA {

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
	QString text = asHost ? QStringLiteral("云端联机已连接，你是 1P") : QStringLiteral("云端联机已连接，你是 2P");
	status(QStringLiteral("房号 ") + (room->roomId.isEmpty() ? QString() : room->roomId)
	       + QStringLiteral("\n中继 ") + room->nodeAddress + ":" + QString::number(room->nodePort)
	       + QStringLiteral("\n") + text);
	emit connected(asHost);
	serve(link);
	cleanupChannel();
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
 * UDP 中继连不上时的数据通道：直接复用与信令服务器的 websocket 会话，把
 * GBoy 帧塞进 send_message 广播推送里发给对方。WS 是出站 TCP，不受 NAT/UDP
 * 限制，跨网天然可用；代价是延迟略高。
 *
 * 握手时序：双方互发 hello（room 标记过滤），见到对方即回 accept 并进入数据
 * 阶段。房主额外先发一帧 READY(2)——中继模式下这一帧由中继发，隧道模式下
 * 没有中继，得由房主补上，否则双方在 handshake() 里互等 READY 死锁。
 */
void CloudLink::runTunnel(GbCloud::Session* sig, const QString& token, Room* room, bool asHost) {
	const QString tag = room->roomId;
	status(QStringLiteral("正在通过服务器隧道等待对方进入（跨网可联）…"));
	WsLink* link = new WsLink(sig, token, m_advertiserUuid, tag, m_wsNonce, &m_reader);
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
	sendRegister(link, room);
	if (asHost) {
		// 中继模式下由中继发 READY(人数)，这里由房主代劳
		link->send(GBoyFrames::frame(GBoyFrames::TYPE_READY, qMax(2, room->playerCount)));
	}
	try {
		handshake(link, room);
	} catch (std::exception& e) {
		cleanupTunnel();
		m_tunnelUp = false;
		fail(QString::fromUtf8(e.what()));
		return;
	}
	status(QStringLiteral("云端联机已连接（服务器隧道），你是 ")
	       + (asHost ? QStringLiteral("1P") : QStringLiteral("2P")));
	emit connected(asHost);
	serve(link);
	cleanupTunnel();
	m_tunnelUp = false;
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
				// the relay window is cut short.
				QString message = object.value("message").toString();
				if (message.contains(QStringLiteral("gboy_ws"))) {
					m_tunnelPeerSeen = true;
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
	emit statusMessage(text);
}

}
