/* Copyright (c) 2013-2024 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#ifndef MGBA_MOBILE_LINK_LOCKSTEP_H
#define MGBA_MOBILE_LINK_LOCKSTEP_H

#include <stdbool.h>
#include <stddef.h>

/* 只当不透明指针用：不 include <mgba/core/core.h>，避免 iOS 桥接头
 * （HEADER_SEARCH_PATHS 没有 include/ 根）解析失败。 */
struct mCore;

/* link_lockstep.c 按 C 编译；Qt/PC harness（C++）直接调用这里的函数时
 * 缺了 C linkage 会按 mangled name 链接失败（mgbaLockstepSetAbort）。 */
#ifdef __cplusplus
extern "C" {
#endif

/*
 * 进程内锁步 SIO 通道。
 *
 * 与 netLinkBusHostLocal（共享内存 + cond 轮次广播）不同，这里直接复用 mGBA
 * 官方的 GBASIOLockstepCoordinator：它在 SIO 传输轮次粒度会合各核，没有
 * 每轮墙钟超时、没有轮次索引配对、不占任何端口。PC 侧 busgame-lockstep
 * 已用它让 4 核 gen8 multi-battle 真正进对战并稳定维持（BattleMainCB2）。
 *
 * 关键约束：核必须用 runLoop 小步推进，不能用 runFrame。协调器通过
 * mLockstepUser.sleep() 请求某核暂停；被暂停的核线程必须在 runLoop 之后
 * 自我 park，直到 wake() 通知。runFrame 会在帧内忙等并破坏锁步。
 */
struct MgbaLockstepRoom;
struct MgbaLockstepSlot;

/* key 为进程内唯一标识；players 2..4。Host 创建房间，Join 拿到同一房间。
 * 两者都按 key 索引，不监听端口、不建 socket。失败返回 NULL。 */
struct MgbaLockstepRoom* mgbaLockstepHost(int key, int players);
struct MgbaLockstepRoom* mgbaLockstepJoin(int key);

/* 把 core 挂到房间的指定槽位（0 恒为主机）。所有核都创建完之后再逐个挂。
 * 内部完成 DriverCreate / CoordinatorAttach / setPeripheral。 */
struct MgbaLockstepSlot* mgbaLockstepAttach(struct MgbaLockstepRoom* room,
                                           struct mCore* core, int slot);

/* 小步驱动一帧：协调器 sleep 时本线程在 runLoop 之后自我 park。
 * 只能用于已 Attach 的 GBA core。 */
void mgbaLockstepRunFrame(struct MgbaLockstepSlot* slot, struct mCore* core);

/* 拆离：先让 core 卸下驱动（触发 driver deinit → _removePlayer），再释放 slot。
 * 调用前必须已停止该核的线程。 */
void mgbaLockstepDetach(struct MgbaLockstepSlot* slot);

/* 释放一次 Host/Join 引用；引用归零时销毁房间。 */
void mgbaLockstepRelease(struct MgbaLockstepRoom* room);

/* 诊断 / 单元测试 */
size_t mgbaLockstepAttached(struct MgbaLockstepRoom* room);
int mgbaLockstepSlotId(struct MgbaLockstepSlot* slot);
bool mgbaLockstepPaused(struct MgbaLockstepSlot* slot);
void mgbaLockstepUserSleep(struct MgbaLockstepSlot* slot);
void mgbaLockstepUserWake(struct MgbaLockstepSlot* slot);

/* 看门狗：置 1 后 mgbaLockstepRunFrame 在 park 等待与每帧循环里立即返回，
 * 避免测试线程被永久 park 在 cond_wait 里。仅用于测试/诊断。 */
void mgbaLockstepSetAbort(int abort);

#ifdef __cplusplus
}
#endif

#endif
