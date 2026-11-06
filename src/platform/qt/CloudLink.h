/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QByteArray>
#include <QThread>
#include <atomic>
#include <memory>

#include "GBoyFrames.h"

namespace QGBA {

class KcpChannel;
struct ILink;
struct SioLinkHost;
namespace GbCloud { class Session; }

/**
 * gboy.top cloud room link, a Qt port of the Android GBoyCloudLink.
 *
 * The room itself is matched over HTTPS + WebSocket (GbCloud); the game bytes
 * then travel through the room's relay node using KCP over UDP (KcpChannel)
 * carrying the GBoy frames of GBoyFrames. When the relay node does not answer
 * (its ports are dead server-side at the moment), the link falls back to the
 * websocket tunnel: GBoy frames ride the room signalling channel as base64
 * JSON in send_message pushes, which works across networks without any extra
 * infrastructure. The key masks are mirrored into the local console
 * (merged-keys mode), matching the Android lobby behavior.
 */
class CloudLink : public QThread {
Q_OBJECT

public:
	static constexpr long KEY_INTERVAL_MS = 50;

	struct Config {
		QString user;
		QString password;
		/** Room id; empty or null creates a room, otherwise joins it. */
		QString roomId;
		QString romPath;
	};

	CloudLink(QObject* parent = nullptr);
	~CloudLink();

	void startLink(const Config& config);
	void stopLink();
	void sendReset();
	void setLocalKeys(int keys) { m_localKeys.store(keys, std::memory_order_relaxed); }
	/** The running game's SIO driver surface (分开控制模式). */
	void setController(SioLinkHost* controller) { m_controller = controller; }

signals:
	void statusMessage(const QString& message);
	void remoteKeys(int mask);
	void remoteReset();
	void linkEnded(const QString& message);
	void connected(bool asHost);

protected:
	void run() override;

private:
	struct Room {
		QString roomId;
		QString nodeAddress;
		int nodePort = 0;
		int playerCount = 2;
		int baseStateCount = 0;
	};

	// session flow
	void runLobby();
	void runManual(const QString& nodeSpec, bool asHost);
	void hostCreateRoom(GbCloud::Session* sig, const QString& token, const QString& uuid, Room* room);
	void connectRelay(GbCloud::Session* sig, const QString& token, const QString& uuid,
	                  Room* room, bool asHost);
	QString currentNode(GbCloud::Session* sig, const QString& token, Room* room, bool creator);
	KcpChannel* startRelayLink(const QString& host, int port, Room* room,
	                           GbCloud::Session* sig, const QString& token, const QString& uuid,
	                           bool creator, qint64 windowMs);
	/** Relay unreachable: serve the match over the signalling websocket. */
	void runTunnel(GbCloud::Session* sig, const QString& token, Room* room, bool asHost);
	void cleanupTunnel();
	/** 分开控制：pipe the native SIO link bytes through the tunnel. */
	void startSioBridge(ILink* link, bool asHost);
	void closeSio();

	// wire handshake
	void sendRegister(ILink* link, Room* room);
	void handshake(ILink* link, Room* room);
	QByteArray expect(ILink* link, int type, int timeoutMs);

	// game loop
	void serve(ILink* link);
	void handle(const QByteArray& body);
	void pollSignaling(GbCloud::Session* sig, const QString& token, const QString& uuid, Room* room);

	// websocket tunnel helpers
	void sendWsMarker(GbCloud::Session* sig, const QString& token, const QString& uuid,
	                  const QString& kind, const QString& roomId);
	/** Reads pushes briefly; flags the peer's tunnel hello/accept. */
	void drainSignaling(GbCloud::Session* sig, int ms);
	bool isTunnelMarkerText(const QString& text);

	// signalling helpers
	void waitForRoom(GbCloud::Session* sig, Room* room, const QString& roomId, int timeoutMs);
	void waitForRoomId(GbCloud::Session* sig, Room* room, int timeoutMs);

	QString gameUuid() const;
	QString gameName() const;
	void fail(const QString& text);
	void status(const QString& text);
	/** Processes Qt events (socket callbacks) for ms while checking abort. */
	bool waitAndProcess(int ms);
	void cleanupChannel();

	Config m_config;
	std::atomic<bool> m_closed{false};
	std::atomic<bool> m_sendReset{false};
	std::atomic<int> m_localKeys{0};

	GbCloud::Session* m_session = nullptr;
	KcpChannel* m_channel = nullptr;
	ILink* m_tunnel = nullptr;
	SioLinkHost* m_controller = nullptr;
	/** Local loopback socket to the native SIO link driver (分开控制). */
	std::atomic<intptr_t> m_sioSock{-1};
	QString m_authToken;
	Room m_currentRoom;
	bool m_hostRole = false;
	bool m_isAdvertising = false;
	QString m_advertiserUuid;
	/** True while the match runs over the websocket tunnel instead of KCP. */
	bool m_tunnelUp = false;
	/** The peer has greeted over the tunnel; no need to finish the KCP window. */
	bool m_tunnelPeerSeen = false;
	/**
	 * Random sender tag carried by every tunnel marker: if the server echoes a
	 * send_message back to its sender, this is what tells our own hello/frames
	 * apart from the peer's (the game identity is the same on both sides).
	 */
	QString m_wsNonce;
	GBoyFrames::Reader m_reader; // reused only inside the worker thread
	int m_lastRxKeys = -1;
};

}
