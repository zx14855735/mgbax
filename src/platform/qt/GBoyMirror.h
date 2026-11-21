/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QByteArray>
#include <QHash>
#include <QString>
#include <QThread>
#include <atomic>
#include <functional>
#include <mutex>

#include "platform/mobile/mgba_mobile.h"

/**
 * ISYNC1 — 输入同步方向「TYPE_STATE 种子真正 applied」可回退门。
 * 三端同名同值（PC C++ / Android Java / iOS Swift 都是
 * MGBAX_ISYNC_STATE_APPLY），默认 0 = 维持既有行为；可用
 * -DMGBAX_ISYNC_STATE_APPLY=1 打开。
 *
 * 注意：载入本身**无条件**发生（applyRemoteState 把对端真实 savestate 种子
 * 灌进镜像核），门只控制三端对齐的诊断里程碑日志 `remote state loaded` 与
 * 种子块 FNV-1a hash，供跨端 E2E 判据核对。它不是伪造状态，也不放宽红线
 * （造 party / 信任位 / 伪 CROSSED 仍禁）。
 */
#ifndef MGBAX_ISYNC_STATE_APPLY
#define MGBAX_ISYNC_STATE_APPLY 0
#endif

/**
 * ISYNC-EV — 具名总门 MGBAX_ISYNC_EVIDENCE + 子开关 MGBAX_ISYNC_EVIDENCE_A1，
 * 三端同名同值（PC C++ / Android Java / iOS Swift），默认 0 = 不打 A1 埋点。
 * 独立于 MGBAX_ISYNC_STATE_APPLY。可用同名环境变量=1 打开。
 * 只启「本机发出的种子 / 落地种子」sha256+字节数的只读观测（A1-SEND/LAND），
 * 供 C5 判 land[对端] ⊆ send[本机]；绝不造 seed / party / 信任位 / 伪 CROSSED。
 */
#ifndef MGBAX_ISYNC_EVIDENCE
#define MGBAX_ISYNC_EVIDENCE 0
#endif
#ifndef MGBAX_ISYNC_EVIDENCE_A1
#define MGBAX_ISYNC_EVIDENCE_A1 0
#endif

/**
 * GENTRIAD — 代次 hygiene 独立门 MGBAX_ISYNC_SEED_FRAME_BOUNDARY
 * （三端同名同值：PC 此宏 / Android EmulatorActivity 广播 / iOS ISyncGate，
 * 默认 0 = 关；也可同名 env=1 打开）。独立于 MGBAX_ISYNC_STATE_APPLY。
 *
 * 门开 = 入队打 instanceGen 戳、帧边界消费做 stale 丢弃（SEED_DROPPED_STALE）、
 * applied_count 按 (seed hash, gen) 计；门关 = 维持既有入队/load 行为（A/B 回退）。
 * 这是语义防伪，不是内存安全守卫，也不改 load 位置、不造假里程碑。
 */
#ifndef MGBAX_ISYNC_SEED_FRAME_BOUNDARY
#define MGBAX_ISYNC_SEED_FRAME_BOUNDARY 0
#endif
/* 符号自检：门值只能是 0/1，防误配成其它值使三端口径漂移。 */
static_assert(MGBAX_ISYNC_SEED_FRAME_BOUNDARY == 0 || MGBAX_ISYNC_SEED_FRAME_BOUNDARY == 1,
              "MGBAX_ISYNC_SEED_FRAME_BOUNDARY must be 0 or 1");

namespace QGBA {

/** ISYNC-EV: A1 只读门判定（总门 && 子开关，宏或同名 env=1）。 */
bool isyncEvidenceA1Enabled();
/** ISYNC-EV: 种子 sha256 十六进制（只读诊断口径，非 native 核状态 hash）。 */
QByteArray isyncSeedSha256Hex(const QByteArray& seed);
/** ISYNC-EV: A1-SEND 单一入口——真发送点调用，仅日志观测，不碰种子本身。 */
void isyncEvidenceLogSeedSend(const QByteArray& seed, const char* path);

class GBoyLinkSession;

/**
 * The hidden second console of the official GBoy cloud layout, a PC port of
 * the Android GBoyConsoleSet (one mirror for 2P).
 *
 * The mirror loads the same ROM over a byte-for-byte copy of the local save,
 * joins the visible core's SIO bus, and replays the remote player's key masks
 * into its own core at ~60 fps. Only key masks (and one TYPE_STATE seed) cross
 * the network, which is what lets both sides run at full single-player speed
 * over the gboy.top servers.
 *
 * path B keeps all four cores in this process: by default the join uses the
 * process-local LocalBus (netLinkBusHostLocal / netLinkBusJoinLocalSlot, keyed
 * by primaryLocalKey). The old 127.0.0.1 TCP star is only reached when
 * primaryLocalKey <= 0, i.e. the MGBAX_LOCAL_BUS=0 control experiment; a
 * process-local bus has no socket and a single clock source, so the four
 * cores' SIO round numbers stay aligned.
 */
class GBoyMirror : public QThread {
Q_OBJECT

public:
	explicit GBoyMirror(QObject* parent = nullptr);
	/**
	 * Copies {@code primarySavePath} into {@code mirrorRoot}, loads the ROM and
	 * joins the primary's loopback listener. {@code session} supplies the peer
	 * key masks (slot 2). Returns false with {@code error} set on failure.
	 */
	/**
	 * @param primaryPort    TCP 总线端口（primaryLocalKey<=0 时使用，对照实验）。
	 * @param primaryLocalKey path B 进程内总线 key（>0 时优先）；镜像核按
	 *                     自己的会话槽位（2/3/4）占用总线槽位 1/2/3。
	 * @param slot       按键取自会话的哪个槽位（2/3/4）。
	 * @param players    SIO 房间人数，必须与可见核的 sioHostPlayers 一致。
	 * @param navIdx     busgame 导航的四人座位编号 1/2/3；负数 = 不启用脚本
	 *                   （正常玩家联机绝不能被脚本接管）。
	 */
	bool start(const QString& romPath, const QString& primarySavePath,
	           const QString& mirrorRoot, quint16 primaryPort, int primaryLocalKey,
	           GBoyLinkSession* session, int slot, int players, bool lockstep,
	           int navIdx, int navMenuAt, int navModeDowns,
	           const QByteArray& saveSnapshot, const QString& scriptDir,
	           QString* error);

	/** Closes the loopback link, stops the pump thread and destroys the core. */
	void stopMirror();

	/**
	 * 把对端的 TYPE_STATE 交给镜像核（线程安全）。
	 *
	 * GBoy 的 case 6 是在**联机线开始跑之前**用对端的可见核存档覆盖「代表
	 * 那个玩家的控制台」，之后两边才 arm SIO。本类有自己的帧线程，直接在
	 * CloudLink 线程里 mgbaMobileLoadStateFromMemory 会与正在跑帧的核心抢
	 * 状态（实测偶发死循环/画面花屏），所以这里只入队，真正的载入发生在
	 * 镜像线程的帧边界上。
	 *
	 * 返回值按官方 type 6 的错误码：0 = 已受理（真正载入的结果走
	 * {@code result} 回调），-5 = 尺寸不符（当场拒绝，不入队），1 = 参数
	 * 非法。载入成功**不复位**本核：mCoreLoadStateNamed 已完整恢复状态，
	 * 再 mgbaMobileReset 会 memset 掉 EWRAM/IWRAM（清零刚载入的存档）。
	 * 复位只由官方 type 5 的 requestReset() 触发。
	 */
	int applyRemoteState(const QByteArray& state, std::function<void(int)> result = {});

	/** 官方 type 5：复位本核。线程安全，真正的 reset 在帧边界执行。 */
	void requestReset();

	/** 联机倍速（1 / 0.5 / 2 / 4）：镜像核与可见核跑同一个帧闸，否则 4x 时
	 *  可见核会把镜像核甩开、SIO 立刻不同步。 */
	void setNetSpeed(float speed);

	/** 已受理并真正载入的状态包计数（诊断用）。 */
	int appliedStateCount() const { return m_appliedStates.load(std::memory_order_relaxed); }

	/**
	 * 注入「当前活动代次」读取器（三端对称；owner 换房/重建时 bump，返回 -1
	 * 表示无活动房间）。未注入时回落到本实例 m_instanceGen —— PC 无跨线程
	 * 重建，天然安全，此门只提供防伪能力，不代表 PC 存在 C3 竞态。
	 */
	void setCurrentGenReader(std::function<qint64()> reader);

	bool isRunningMirror() const { return m_running.load(std::memory_order_relaxed); }

protected:
	void run() override;

private:
	/** 取走待载入的状态、结果回调与入队时的 gen 戳；没有则返回 false。 */
	bool takePendingState(QByteArray* out, std::function<void(int)>* result, qint64* outGen);
	/** 读取 owner 注入的当前代次（不持有 m_stateMutex 时调用）。 */
	qint64 currentGen();

	struct MgbaMobile* m_emu = nullptr;
	GBoyLinkSession* m_session = nullptr;
	int m_slot = 2;
	int m_players = 2;
	std::atomic<bool> m_running{false};
	std::mutex m_stateMutex;
	QByteArray m_pendingState;
	bool m_hasPendingState = false;
	/** 入队瞬间记录的代次戳（m_stateMutex 保护）。 */
	qint64 m_pendingGen = -1;
	/** 本实例唯一单调代次（构造期 immutable；三端同名 instanceGen）。 */
	const qint64 m_instanceGen;
	/** 当前活动代次（start 置 instanceGen、stopMirror 置 -1；未注入读取器时用它）。 */
	std::atomic<qint64> m_activeGen{-1};
	/** owner 注入的当前代次读取器（m_stateMutex 保护）。 */
	std::function<qint64()> m_currentGenReader;
	std::function<void(int)> m_pendingResult;
	/** (seed hash, gen) → 真 load 次数，仅诊断门开时填充（镜像线程独占）。 */
	QHash<QString, int> m_appliedByKey;
	/** 官方 type 5：帧边界上复位本核。 */
	std::atomic<bool> m_resetRequested{false};
	/** 联机倍速；run() 每帧按它缩放帧间隔。 */
	std::atomic<float> m_netSpeed{1.f};
	std::atomic<int> m_appliedStates{0};
	/* 云端 4P 闭环导航的同步闸门：镜像核不再在 start() 里立即武装脚本，而是
	 * 记下 navIdx，等到 <scriptDir>/nav_at 出现（CloudLink 在三个镜像核都就绪
	 * 后才写该文件）才在本线程的 run() 里调用 mgbaMobileBusGameStart。这样
	 * 四个核（可见核 + 3 镜像）在 nav_at 写好的同一瞬间全部起跑，相位完全一致
	 * —— 否则镜像核各自早跑几百~上千帧，进菜单后四人子状态分裂、SIO 握手卡死。 */
	QString m_scriptDir;
	int m_pendingNavIdx = -1;
	/* 武装后 m_pendingNavIdx 会被清成 -1，[mirror] 诊断仍要报告本核座位号，
	 * 所以在 start() 里另存一份只读副本。 */
	int m_navIdx = -1;
	int m_fallbackNavMenuAt = 1500;
	int m_fallbackNavModeDowns = 2;
};

}
