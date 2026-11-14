/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QByteArray>
#include <QThread>
#include <atomic>
#include <functional>
#include <memory>

#include "GBoyFrames.h"

namespace QGBA {

class KcpChannel;
class GBoyLinkSession;
class GBoyMirror;
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
		/**
		 * The running game's battery save; the official-mode mirror console
		 * boots from a copy of it. Empty falls back to the ROM directory.
		 */
		QString savePath;
	};

	CloudLink(QObject* parent = nullptr);
	~CloudLink();

	void startLink(const Config& config);
	void stopLink();
	void sendReset();
	/** 官方 type 9：把本机倍速广播给对端（1 / -1 / 2 / 4，-1 = 0.5x）。 */
	void sendSpeed(int speed);
	void setLocalKeys(int keys) { m_localKeys.store(keys, std::memory_order_relaxed); }
	/** 4 核/设备：把本机真人掩码同步灌进 NPC 槽位 3/4（不碰对端 slot2）。
	 *  与 Android 的 GBoyLinkSession.injectKeysForSlot(3/4) 对称。 */
	void injectNpcKeys(int keys);
	/** The running game's SIO driver surface (分开控制模式). */
	void setController(SioLinkHost* controller) { m_controller = controller; }
	/**
	 * Supplies this machine's save state for TYPE_STATE. Invoked once from the
	 * link thread when the host's session is up. Return an empty array when no
	 * state is available yet - the sender will retry on the next tick.
	 */
	void setStateSnapshotProvider(std::function<QByteArray()> provider) { m_stateSnapshot = provider; }

signals:
	void statusMessage(const QString& message);
	void remoteKeys(int mask);
	void remoteReset();
	/** 对端倍速变化（官方 type 9 的线上值：1/-1/2/4；0 = 复位到 1x）。 */
	void remoteSpeedChanged(int wireValue);
	/** Peer sent a save-state blob; the UI loads it into the local core. */
	void remoteState(const QByteArray& state);
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
	/** 隧道配对上后，尝试大厅信令之外的直连（P2P）；失败返回 nullptr。 */
	ILink* tryDirectLink(GbCloud::Session* sig, const QString& token, Room* room,
	                     ILink* tunnel, bool asHost);
	/**
	 * 环境变量指定的 TCP 直连（官方 `ServerSocket.accept` / `Socket.connect`）：
	 * `MGBAX_TCP_PEER=host:port` 当客户端，`MGBAX_TCP_LISTEN=port` 当服务端。
	 * 两个都没设时返回 nullptr——默认行为不受影响。
	 */
	ILink* tryEnvTcpLink(QString* error);
	/**
	 * 蓝牙 RFCOMM（仅 Windows）：`MGBAX_BT=host` 当服务端 / `MGBAX_BT=MAC`
	 * 当客户端。非 Windows 或没有该变量时返回 nullptr。
	 */
	ILink* tryBtLink(QString* error);
	void cleanupTunnel();
	/** 分开控制：pipe the native SIO link bytes through the tunnel. */
	void startSioBridge(ILink* link, bool asHost);
	/** 分开控制 over the official KCP relay (netLink packets in type-6 frames). */
	void startSioRelayBridge(KcpChannel* link, intptr_t local, GbCloud::Session* sig,
	                         const QString& token, Room* room, bool asHost);
	/**
	 * Official GBoy layout (officialMode): a hidden mirror console joins the
	 * visible core over loopback SIO and only key masks cross the network.
	 * Runs the session serve loop over whichever transport is live.
	 */
	void startOfficialMatch(ILink* link, Room* room);
	void serveOfficial(ILink* link, Room* room);
	void stopOfficialMatch();
	/** 把倍速同步到所有镜像核（官方 AaHO0E 帧闸对所有本机核一致）。 */
	void applyMirrorSpeed(int wireValue);
	void closeSio();

	// wire handshake
	void sendRegister(ILink* link, Room* room);
	void handshake(ILink* link, Room* room, int waitMs = 20000);
	QByteArray expect(ILink* link, int type, int timeoutMs);

	// game loop
	void serve(ILink* link);
	void handle(const QByteArray& body);
	/** One-shot host -> joiner TYPE_STATE, on whichever transport is live. */
	bool maybeSendInitialState(const std::function<void(const QByteArray&)>& send, bool asHost);
	/** 官方 case 6 的周期性状态补发：把本机可见核快照推给对端镜像核。 */
	bool sendStateSync(const std::function<void(const QByteArray&)>& send);
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
	/** 待发送的倍速（0 = 无；1 / -1 / 2 / 4 见 type 9）。 */
	std::atomic<int> m_sendSpeed{0};
	/** 当前生效的倍速线上值（0 = 1x）。本地切换与收到的 type 9 共同写它，
	 *  等价官方两端共享的 AaHO0E.f4302AZkASS。 */
	std::atomic<int> m_speedWire{0};
	std::atomic<int> m_localKeys{0};
	std::function<QByteArray()> m_stateSnapshot;
	std::atomic<bool> m_initialStateSent{false};

	/** Official GBoy layout (MGBAX_OFFICIAL_LINK=1): mirror console + keys. */
	bool m_officialMode = false;
	GBoyLinkSession* m_gboySession = nullptr;
	/* 与 Android GBoyConsoleSet 对称：1 可见核 + 3 镜像核凑满 4 人多人对战。
	 * 游戏要求 4 名玩家才放开球场走位并进入 battle_main.o，2 核会把角色
	 * 锁在原地（11-14 实测 2 核 st=4 pc=2 后 pos 恒 5,8/6,8、cb2 恒 08170A81，
	 * 两端模拟线程同时 park）。网络仍然只传按键。 */
	static constexpr int MIRROR_COUNT = 3;
	GBoyMirror* m_mirrors[MIRROR_COUNT] = {nullptr};
	quint16 m_mirrorSioPort = 0;
	long m_officialFrame = 0;
	/** 上一次已上报给前端的倍速线上值，避免每 tick 重复 emit。 */
	int m_lastSpeedWire = 0;
	/** 镜像核载入对端 type 6 的结果（0 = 无错误；-5 = 尺寸不符；1 = 其它失败）。
	 *  镜像线程写入，serveOfficial 循环在下一 tick 按官方语义断链。 */
	std::atomic<int> m_mirrorStateError{0};

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
	/**
	 * GBoy/My Boy lobbies mirror the peer's held keys into the local core so
	 * one person can drive both consoles. That is wrong for a real two-player
	 * match: the peer's KEY frame is 1 RTT behind, so after the local key is
	 * released its delayed "pressed" frame raises a SECOND press edge in the
	 * local game. The two consoles then advance their menus a different number
	 * of steps and end up picking different link modes ("伙伴做出了别的选择").
	 * Default off = 分开控制. Set MGBAX_REMOTE_KEYS=1 to restore the old mode.
	 */
	bool m_remoteKeysEnabled = false;
};

}
