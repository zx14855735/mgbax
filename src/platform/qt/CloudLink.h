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

/* P0 / 脏 seed 干净重发：默认关（=1 开启）。开时 arm 重发 / sync_state 复用缓存
 * 的首份 seed 字节，不再生成含 st4/8FFF/B9A0 运行时态的即时快照。与三端同名
 * 同值（iOS UserDefaults mgbax.link.seed_clean_resend / prop 由 driver 下发）。 */
#ifndef MGBAX_SEED_CLEAN_RESEND
#define MGBAX_SEED_CLEAN_RESEND 0
#endif

/* S2 / MGBAX_NET_PARTY_MAILBOX：三端同名同值，默认关（PC 侧只用 env）。
 * 与 sio_link.c 同名同值、各自 #ifndef 卫哨（不同 TU，无重定义冲突）。 */
#ifndef MGBAX_NET_PARTY_MAILBOX
#define MGBAX_NET_PARTY_MAILBOX 0
#endif
#if MGBAX_NET_PARTY_MAILBOX != 0 && MGBAX_NET_PARTY_MAILBOX != 1
#error "MGBAX_NET_PARTY_MAILBOX must be 0 or 1"
#endif
#define MGBAX_NET_PARTY_MAILBOX_ENV "MGBAX_NET_PARTY_MAILBOX"

/**
 * 测试专用探针（`test-gboylink --gatetest`，定义在 test/gboylink_test.cpp 里）。
 *
 * 存在的唯一理由：协商门（`negotiateLinkMode`）的失败分支只有在
 * 「对端能力位已就位」时才会走到，而把能力位放进去的那两个入口
 * （type-1 注册帧 / WSS hello 标记）都是 private，测试没有别的正当路径。
 * 它不做任何绕过 —— 内部调用的就是生产代码的 `notePeerLinkMode()` 与
 * `negotiateLinkMode()`，没有第二套判定逻辑。
 *
 * 用 friend 而不是公开方法：生产二进制里不该留下可调用的测试入口，
 * friend 声明是编译期的东西，零运行时成本、零 API 暴露。
 */
struct CloudLinkGateProbe;

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
	/**
	 * C0 / ADR-002：显式指定联机架构。mode 取 GBoyFrames::LINK_MODE_A /
	 * LINK_MODE_B，或 GBoyFrames::LINK_MODE_UNKNOWN(-1) = AUTO（按房间人数：
	 * 2P→A、3/4P→B）。必须在 startLink() 之前调用；默认值也可由环境变量
	 * MGBAX_LINK_MODE=A|B|AUTO 设置（MGBAX_OFFICIAL_LINK=1 等价于 B，兼容旧脚手架）。
	 * 两端必须一致，不一致直接 fail 并在大厅给出可见提示，绝不静默降级。
	 */
	void setLinkMode(int mode) { m_modeOverride = mode; }
	/**
	 * 显式许可「对端未声明能力位」（官方 APK / 旧客户端）时按 B 互通。
	 * 默认关闭 —— 未知模式一律拒绝，避免两套帧格式同流。
	 */
	void setAllowLegacyPeer(bool allow) { m_allowLegacyPeer = allow; }
	/** 当前已生效的模式（startLink 后可能随房间人数变化）。 */
	int currentLinkMode() const { return m_linkMode.load(std::memory_order_relaxed); }
	/** A / B / AUTO / UNKNOWN 的文案，用于大厅状态与失败提示。 */
	static QString modeName(int mode);
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
	/** S2：提供本机 500B GNP 邮槽镜像（只读 builder 的产物）；门默认关时不被调用。 */
	void setPartyMailboxProvider(std::function<QByteArray()> provider) { m_partyMailbox = provider; }

signals:
	void statusMessage(const QString& message);
	void remoteKeys(int mask);
	void remoteReset();
	/** 对端倍速变化（官方 type 9 的线上值：1/-1/2/4；0 = 复位到 1x）。 */
	void remoteSpeedChanged(int wireValue);
	/** Peer sent a save-state blob; the UI loads it into the local core. */
	void remoteState(const QByteArray& state);
	/** 对端发来 500B GNP 邮槽镜像；PC 侧仅记日志，不触发 remoteState/不写游戏态。 */
	void remotePartyMailbox(const QByteArray& mb);
	void linkEnded(const QString& message);
	void connected(bool asHost);

protected:
	void run() override;

private:
	/** `test-gboylink --gatetest` 的探针（见文件头注释）。只驱动生产代码路径，
	 *  不复制判定逻辑；生产构建里没有任何调用点。 */
	friend struct ::CloudLinkGateProbe;

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
	/** S2：经现有 relay 发一帧 TYPE_PARTY（500B 邮槽镜像）；门默认关/provider 空即 false。 */
	bool sendPartyMailboxSync(const std::function<void(const QByteArray&)>& send);
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
	/**
	 * 机器可读诊断：把「这一轮到底跑的是哪条路径 / 帧格式 / 快帧门配置」
	 * 一次写进 %TEMP%/mgba_lobby_debug.log。历史事故里
	 * `MGBAX_OFFICIAL_LINK=1` 残留把 2 人房悄悄拽成 path B，读日志时无法
	 * 判定跑的是哪条路；这两行把路径、模式、环境变量来源全部落盘。
	 */
	void logPathDiag(const QString& path, const QString& transport, const QString& frameEnc);
	/** Processes Qt events (socket callbacks) for ms while checking abort. */
	bool waitAndProcess(int ms);
	void cleanupChannel();
	/** AUTO：2P→A（SIO 包中继），3/4P→B（本机多核 + 按键）；显式 override 优先。
	 *  判定实现在 GBoyFrames::resolveLinkMode()，本函数只把自己的 override 传进去
	 *  （同一份逻辑也被 test-gboylink --c0 直接断言）。 */
	int resolveLinkMode(int playerCount) const;
	/**
	 * 在分派到具体数据路径之前绑定本端模式，并把对端能力位与本端比对。
	 * 返回 false 时**本次或更早**已调用过 fail()（已 fail 过则直接返回、不重复
	 * fail），调用方必须立即 return，不得继续发任何游戏帧。
	 */
	bool negotiateLinkMode(Room* room, const QString& where);
	/**
	 * 记录对端能力位（来源：type-1 注册帧 / WSS hello|accept 标记）。
	 * 若本地模式已绑定且不一致，立刻 fail，阻止两套帧格式同流。
	 */
	void notePeerLinkMode(int mode, const QString& source);

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
	std::function<QByteArray()> m_partyMailbox;   // S2 TYPE_PARTY provider（默认空）
	/** PC cloud-arm：可见核 reload 到帧 0 之后取的起点快照，作为 type-6 首包
	 *  （对端镜像核因此也停在帧 0，而不是我们进菜单时的状态）。空 = 没开 arm。 */
	QByteArray m_armSeedState;
	/* P0：首发那一帧的字节缓存（帧 0 干净态不可用时的退化方案）。arm 重发 /
	 * sync_state 在 MGBAX_SEED_CLEAN_RESEND 门开时复用它，避免推脏 seed 造成
	 * 幻影 st4 乒乓。仅缓存字节、不生成新快照、不写游戏态。 */
	QByteArray m_firstSeedState;
	std::atomic<bool> m_initialStateSent{false};

	/** Official GBoy layout (MGBAX_OFFICIAL_LINK=1 / path B): mirror console + keys. */
	bool m_officialMode = false;
	/* ---- C0 能力协商位（ADR-002）----------------------------------------
	 * m_linkMode      = 本端已绑定的模式（A/B）
	 * m_modeOverride  = UI / 环境变量显式指定；LINK_MODE_UNKNOWN(-1) = AUTO
	 * m_peerLinkMode  = 对端声明的模式（-1 = 尚未收到 / 未声明）
	 * m_modeRejected  = 已 fail 过，禁止后续循环再偷偷放行
	 * 两套帧格式（path A 裸 20 字节 netLink 包 / path B GBoy 帧）绝不能同流。 */
	std::atomic<int> m_linkMode{GBoyFrames::LINK_MODE_A};
	int m_modeOverride = GBoyFrames::LINK_MODE_UNKNOWN;
	bool m_allowLegacyPeer = false;
	std::atomic<int> m_peerLinkMode{GBoyFrames::LINK_MODE_UNKNOWN};
	/** 本端模式是否已经绑定到某个具体房间（绑定前不拿默认值去误判对端）。 */
	std::atomic<bool> m_modeBound{false};
	std::atomic<bool> m_modeRejected{false};
	/**
	 * 协商门等待期的空闲泵 —— **仅测试注入**（`test-gboylink --gatetest`，
	 * 见 CloudLink.h 文件头的探针说明）。生产路径永远是空的。
	 *
	 * 未设置时维持原分支逻辑，一字不变：
	 *   信令可用 → `drainSignaling(session, slice)`；不可用 → `waitAndProcess(slice)`。
	 *
	 * 为什么需要它：真机上实际会走的「信令可用 → drainSignaling() 提前返回」
	 * 那条分支，只有活的 WSS 会话才能触发，而 **B1**（对端 hello 稍后到）与
	 * **F7**（2s 被静默缩成 1.2s）都只在那条分支上成立。泵让这条分支的
	 * **时序**可被断言，而不必连真房间。
	 *
	 * 入参是本轮分配的切片毫秒；返回值是「本轮实际耗时」，**只用于诊断** ——
	 * 控制流只认 deadline，注入方谎报耗时绕不过 2000ms 上界。
	 */
	std::function<int(int)> m_gatePump;
	GBoyLinkSession* m_gboySession = nullptr;
	/* 与 Android GBoyConsoleSet 对称：1 可见核 + 3 镜像核凑满 4 人多人对战。
	 * 游戏要求 4 名玩家才放开球场走位并进入 battle_main.o，2 核会把角色
	 * 锁在原地（11-14 实测 2 核 st=4 pc=2 后 pos 恒 5,8/6,8、cb2 恒 08170A81，
	 * 两端模拟线程同时 park）。网络仍然只传按键。 */
	static constexpr int MIRROR_COUNT = 3;
	GBoyMirror* m_mirrors[MIRROR_COUNT] = {nullptr};
	/** 本局真正创建的镜像核数 = 房间人数 - 1（2P→1、3P→2、4P→3）。
	 *  MIRROR_COUNT 只是数组上限；默认取上限以保持首局之前的行为不变。
	 *  由 startOfficialMatch() 在起点按 room->playerCount 写入，同一线程读。 */
	int m_mirrorCount = MIRROR_COUNT;
	quint16 m_mirrorSioPort = 0;
	/** path B 进程内总线 key（0 = 未启用/走 TCP）。每局重新生成，避免复用
	 *  上一局残留的 LocalBus 状态。 */
	int m_mirrorLocalKey = 0;
	/** path B 用进程内锁步房间（已证明能 4 核进对战）；false = LocalBus。 */
	bool m_mirrorLockstep = false;
	long m_officialFrame = 0;
	/** 上一次已上报给前端的倍速线上值，避免每 tick 重复 emit。 */
	int m_lastSpeedWire = 0;
	/** 镜像核载入对端 type 6 的结果（0 = 无错误；-5 = 尺寸不符；1 = 其它失败）。
	 *  镜像线程写入，serveOfficial 循环在下一 tick 按官方语义断链。 */
	std::atomic<int> m_mirrorStateError{0};

	GbCloud::Session* m_session = nullptr;
	KcpChannel* m_channel = nullptr;
	ILink* m_activeLink = nullptr;   /* B2: 当前活跃数据 link（各建链路径汇聚点赋值），供 party 带外帧用 */
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
