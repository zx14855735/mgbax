/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#ifndef MGBA_QT_SIO_LINK_H
#define MGBA_QT_SIO_LINK_H

#include <stddef.h>
#include <stdint.h>
#include <stdbool.h>

struct mCore;
struct GBA;

/**
 * LAN SIO link cable for the Qt port, a faithful port of the Android/iOS
 * mobile-layer GbaLinkDriver (src/platform/mobile/mgba_mobile.c) on top of
 * link_net.c. Everything here runs on the core thread: the driver vtable is
 * invoked by the GBA SIO core during runFrame, and sioLinkPump tops the
 * polling up once per frame. The three mobile fixes are preserved:
 *
 *   1. the frame barrier is never used in a cable session (it deadlocks
 *      against the per-round takePeerWord backpressure);
 *   2. SIOCNT terminal bits (Slave/Ready/Id) and the 115200 baud bits are
 *      rewritten by the driver, because the core's GBASIOWriteSIOCNT sticks
 *      the old bits back in;
 *   3. after a core reset the driver is re-attached on the next pump
 *      (the reset clears sio.driver but not the attached flag).
 */
struct SioLink;

#ifdef __cplusplus
extern "C" {
#endif

struct SioLink* sioLinkCreate(void);
void sioLinkDestroy(struct SioLink* sio);

/** Start listening (host, 1P) or connect (join, 2P); port 18765 by default.
 *
 * players: 2 走原来的两人直连（行为一字未变）；3/4 走星型总线 —— 主机
 * accept 最多 players-1 个从机，每轮收齐所有从机的字后连同自己的字一次广播
 * （见 link_net.c 的总线段）。两边的 players 必须一致，否则包格式不同、
 * TCP 连得上但解不出任何包。 */
bool sioLinkHost(struct SioLink* sio, int port);
bool sioLinkHostPlayers(struct SioLink* sio, int port, int players);
/* 进程内总线（同进程 N 核）：不建 socket，用共享内存回合屏障。 */
bool sioLinkHostPlayersLocal(struct SioLink* sio, int key, int players);
bool sioLinkJoinPlayersLocal(struct SioLink* sio, int key);
/* 占用指定链路槽位（0 归 host）；多设备各跑 N 核时可见核用它占自己的槽位。 */
bool sioLinkJoinPlayersLocalSlot(struct SioLink* sio, int key, int slot);
bool sioLinkJoin(struct SioLink* sio, const char* host, int port);
bool sioLinkJoinPlayers(struct SioLink* sio, const char* host, int port, int players);
void sioLinkClose(struct SioLink* sio);

/** 0 off, 1 listening, 2 connected, 3 peer dropped. */
int sioLinkState(const struct SioLink* sio);
int sioLinkPlayer(const struct SioLink* sio);
/** 本局目标人数（含自己）：总线房是开房时定的人数，两人直连恒为 2。 */
int sioLinkPlayerCount(const struct SioLink* sio);
void sioLinkStatusText(const struct SioLink* sio, char* out, size_t outLen);

/** Per-frame top-up on the core thread; attaches/detaches the SIO driver as
 * the link state changes (and re-attaches after a core reset). */
void sioLinkPump(struct SioLink* sio, struct mCore* core);

/** 只读的菜单/联机状态诊断，不依赖任何 SioLink 对象。挂到 CoreController
 * 的每帧回调上，联机链路还没建立（甚至还没建房）时就能落盘 [diag]/[room]，
 * 供自动化脚本用游戏内存判定入场；MGBAX_LINK_DIAG 未设置时开销为零。 */
void sioLinkDiagCore(struct mCore* core);

/** 快帧门的纯判据（见 sio_link.c 的注释）：供 `test-gboylink --fastgate` 断言。 */
bool sioFastGateReady(bool disabled, uint32_t ok, unsigned gLinkState, unsigned gLinkPlayerCount);

/** 可配置最小轮次的快帧门：minOk 是「会话建立后至少跑够多少轮才允许快帧」。
 * 默认 256 与 sioFastGateReady 等价；path A 云端握手期链路会在 n≈34 因
 * 每帧 SIO 中断不足被 LAG_MASTER 拆掉，远早于 256 —— A/B 时可用环境变量
 * MGBAX_FAST_MIN_OK 把它降到握手后立即生效（如 8），验证能否救回链路。 */
bool sioFastGateReadyEx(bool disabled, uint32_t ok, unsigned gLinkState, unsigned gLinkPlayerCount, uint32_t minOk);

/** 档1 B 有状态预测回滚自测探针（仅 MGBAX_PRED_SELFTEST=1 && MGBAX_ROLLBACK_ENABLE=1
 * 时定义在 sio_link.c；门关目标不引用本符号）。类型定义见 gboy_netparty_abi.h，
 * 此处仅前置声明 struct tag，避免引入整个共享头。零注入 CROSSED 不靠本探针产出。 */
struct GnpPredSelfTestReq;
struct GnpPredSelfTestRes;
int gnpPredRollbackSelfTest(const struct GnpPredSelfTestReq* req, struct GnpPredSelfTestRes* res);

/** Diagnostics: smoothed RTT in µs (0 = unknown) and peer queue counters. */
uint32_t sioLinkRttUs(const struct SioLink* sio);
void sioLinkPeerStats(const struct SioLink* sio, uint32_t* stale, uint32_t* drops);
/** Words queued from the peer but not consumed yet. */
int sioLinkPeerPending(const struct SioLink* sio);
/** The underlying NetLink pointer, for cross-checking diagnostics. */
const void* sioLinkHandle(const struct SioLink* sio);

/* S2：PC 源端只读导出本机 gPlayerParty -> 500B GNP 邮槽镜像（writer=ROM，host 零写游戏态）。 */
bool sioNetPartyMailboxOn(void);
size_t sioBuildNetPartyMailbox(struct GBA* gba, uint8_t* out, size_t cap);

#ifdef __cplusplus
}
#endif

#endif
