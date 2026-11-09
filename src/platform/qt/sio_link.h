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

/** Start listening (host, 1P) or connect (join, 2P); port 18765 by default. */
bool sioLinkHost(struct SioLink* sio, int port);
bool sioLinkJoin(struct SioLink* sio, const char* host, int port);
void sioLinkClose(struct SioLink* sio);

/** 0 off, 1 listening, 2 connected, 3 peer dropped. */
int sioLinkState(const struct SioLink* sio);
int sioLinkPlayer(const struct SioLink* sio);
void sioLinkStatusText(const struct SioLink* sio, char* out, size_t outLen);

/** Per-frame top-up on the core thread; attaches/detaches the SIO driver as
 * the link state changes (and re-attaches after a core reset). */
void sioLinkPump(struct SioLink* sio, struct mCore* core);

/** 只读的菜单/联机状态诊断，不依赖任何 SioLink 对象。挂到 CoreController
 * 的每帧回调上，联机链路还没建立（甚至还没建房）时就能落盘 [diag]/[room]，
 * 供自动化脚本用游戏内存判定入场；MGBAX_LINK_DIAG 未设置时开销为零。 */
void sioLinkDiagCore(struct mCore* core);

/** Diagnostics: smoothed RTT in µs (0 = unknown) and peer queue counters. */
uint32_t sioLinkRttUs(const struct SioLink* sio);
void sioLinkPeerStats(const struct SioLink* sio, uint32_t* stale, uint32_t* drops);
/** Words queued from the peer but not consumed yet. */
int sioLinkPeerPending(const struct SioLink* sio);
/** The underlying NetLink pointer, for cross-checking diagnostics. */
const void* sioLinkHandle(const struct SioLink* sio);

#ifdef __cplusplus
}
#endif

#endif
