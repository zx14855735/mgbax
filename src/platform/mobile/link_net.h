/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#ifndef MGBA_ANDROID_LINK_NET_H
#define MGBA_ANDROID_LINK_NET_H

#include <stddef.h>
#include <stdint.h>
#include <stdbool.h>

/* link_net.c is compiled as C; Qt/PC harnesses include this from C++.
 * Without the C linkage the first direct call from C++ (netLinkBusDiag)
 * fails to link with a mangled name. */
#ifdef __cplusplus
extern "C" {
#endif

struct NetLink;

struct NetLink* netLinkCreate(void);
void netLinkDestroy(struct NetLink* link);

bool netLinkHost(struct NetLink* link, int port);
bool netLinkJoin(struct NetLink* link, const char* host, int port);
void netLinkClose(struct NetLink* link);

/* 0 off, 1 listening, 2 connected, 3 peer dropped */
int netLinkState(struct NetLink* link);
int netLinkPlayer(struct NetLink* link);
void netLinkStatusText(struct NetLink* link, char* out, size_t outLen);

bool netLinkBarrier(struct NetLink* link, int timeoutMs);
/* 持续 RTT 探针（µs 级）：模拟线程高频调用，按 250ms 节奏发 PING。 */
void netLinkPingTick(struct NetLink* link);
/* 平滑后的当前 RTT（µs）；还没测到时为 0。等待窗按它自适应。 */
uint32_t netLinkRttUs(struct NetLink* link);
bool netLinkExchange(struct NetLink* link, uint16_t mode, uint32_t local, uint32_t* remoteOut, int timeoutMs);
bool netLinkTakeRequest(struct NetLink* link, uint16_t* seq, uint16_t* mode, uint32_t* value, int* player);
void netLinkReply(struct NetLink* link, uint16_t seq, uint16_t mode, uint32_t value);

/* 非阻塞的请求/应答：主机在 SIO 传输开始时就把本帧数据发出去，由模拟线程在
 * 传输应当结束的时刻取回对端应答，中途不再 sleep/等待网络。 */
void netLinkPublish(struct NetLink* link, uint16_t mode, uint32_t value);
bool netLinkRequest(struct NetLink* link, uint16_t mode, uint32_t local, uint16_t* seqOut);
bool netLinkTakeReply(struct NetLink* link, uint16_t seq, uint32_t* remoteOut);

/* 「推一次就走」：本机把「第 index 轮要发的字」推给对端，不等应答。
 * 对端在自己的那一轮里取用，于是两边都不必为一个往返买单（Wi-Fi 上往返
 * 动辄几十毫秒，等它必然错过游戏的传输窗口）。
 *
 * cycles 是发送方此刻的**模拟时钟**（mTiming 周期数）。两台模拟器必须以
 * 同样的速度推进各自的模拟时钟，否则一帧里双方的帧数会越差越多，游戏的
 * 收发队列（每帧入队/出队各一条命令）就会错位，从机的 sendQueue 会被塞爆、
 * recvQueue 会被抽干。带上这个戳，从机就能按主机的节奏安排自己的轮次完成
 * 时刻，两边的模拟时钟速率严格一致。 */
void netLinkPush(struct NetLink* link, uint16_t mode, uint32_t local, uint16_t index, uint32_t cycles);

/* 取对端第 want 轮的字。对端按轮次先后推送，这里也按先后取，早于 want 的
 * 迟到推送直接丢弃（本机早已按超时收尾过那一轮）。timeoutMs > 0 时会阻塞
 * 调用线程（模拟线程），这正是联机需要的背压：等网络的时候模拟时钟不应该
 * 往前走。indexOut 回带真正取到的轮次，和 want 不等就说明中间丢过一轮。
 * cyclesOut 回带对端那一轮推送时的模拟时钟戳（对端没带就为 0）。 */
bool netLinkTakePeerWord(struct NetLink* link, uint16_t want, int timeoutMs, uint32_t* value, uint16_t* indexOut, uint32_t* cyclesOut);

/* 【宽松取字】取队列里轮次号比 minIndex 新的最早一条。
 *
 * 为什么需要它：GBA 联机的轮次号必须由**主机单方面决定**（主机是链路的
 * 时钟源）。两端的计数器如果各自独立递增，必然发散 —— 从机每轮超时也会
 * 推进自己的计数器，跑到 206 时主机才 95。此时严格匹配会把主机的每一条
 * 推送都判成「过期」丢掉，从机永远收不到 → 每轮空等 2.5s → 模拟帧率掉到
 * 0.03fps → 游戏的握手任务跑不到第 5 个 tick → 链路状态卡在 START1，
 * 双方永远进不了 HANDSHAKE。
 *
 * 从机用这个入口取字，并**直接采用主机给的轮次号**回推，于是主机那边
 * 严格匹配（want == 实收）一次都不会错位。
 * minIndex = 本机已经消费到的轮次号；比它老（或相等）的推送直接丢弃，
 * 这样启动阶段堆积的旧推送不会把从机拖慢一格。
 * cyclesOut 语义与 netLinkTakePeerWord 相同。 */
bool netLinkTakePeerWordAny(struct NetLink* link, uint16_t minIndex, int timeoutMs, uint32_t* value, uint16_t* indexOut, uint32_t* cyclesOut);
void netLinkPeerStats(struct NetLink* link, uint32_t* stale, uint32_t* drops);
uint32_t netLinkPeerAge(struct NetLink* link);

/* 对端队列里现在有几个字（不消费）。
 *
 * 从机要靠它判断「主机是不是已经在推字了」：只有主机真的推了字，从机才
 * 需要挂上自己的轮次事件。没联机的时候主机一个字都不推，从机就完全不用
 * 挂 —— 这正是把从机的模拟帧率从 1.4fps 救回 60fps 的关键。 */
int netLinkPeerPending(struct NetLink* link);
/* 诊断：原子读 {队列字数, 队头轮次号}。 */
void netLinkPeerHeadInfo(struct NetLink* link, int* count, unsigned* headIndex);
/* 距对端最近一次 PUSH 到达过了多少真实毫秒（从没收到过则返回极大值）。 */
uint32_t netLinkPushAgeMs(struct NetLink* link);

/* ---- 3/4 人总线（星型汇聚） ----------------------------------------------
 *
 * 原来的链路只有两个端点：主机 listen(fd, 1) 只接受一个连接、每轮对端只有一个
 * 字，所以 GBA 的 SIOMULTI0..3 里只有两个槽能被填上，3/4 人联机根本组不起来。
 *
 * 总线拓扑是星型：主机 accept 最多 players-1 个从机，按接入顺序把槽位 1..players-1
 * 分给它们；从机之间不直连。每一轮：
 *   1. 主机在自己这次传输开始时把「本轮自己的字」推给**所有**从机；
 *   2. 每个从机在自己的轮次里把自己的字推给主机；
 *   3. 主机收齐所有已连接从机的字后，连同自己的字**一次广播**给所有从机。
 * 于是每台机器一轮都能拿到全部槽位的字，SIOMULTI0..3 可以整块填满。
 *
 * 代价是每轮多一跳：从机的字要经过主机才能到别的从机，一轮约 1.5 个 RTT，
 * 而两人直连是 1 个 RTT。这是星型汇聚的物理成本，不是实现缺陷。
 *
 * 两人（players == 2）仍然走原来的直连路径，一行都不变；总线只在 players > 2
 * 时启用。 */
bool netLinkBusHost(struct NetLink* link, int port, int players);
bool netLinkBusJoin(struct NetLink* link, const char* host, int port);
/* 进程内总线（同进程 N 核，无 socket / IO 线程）。
 *
 * 与 netLinkBusHost/Join 语义相同，但所有 NetLink 在同一进程内共享一块内存
 * 做回合屏障：主机是唯一时钟源，从机永远跟随主机当前轮次，轮次天然对齐；
 * 会合靠 cond 广播（µs 级），没有 TCP 的 2ms 超时地板。3/4 人 N 核必须用它，
 * 否则 netLinkBusRound 会在「主机等从机 index / 从机等主机广播」上互相等满
 * 超时（实测 198ms/帧、5.6fps）。key 用来在同一进程里区分不同的会话。 */
bool netLinkBusHostLocal(struct NetLink* link, int key, int players);
bool netLinkBusJoinLocal(struct NetLink* link, int key);
/* 占用指定链路槽位（0 归主机，1..players-1 可被从机指定）。多台设备各自
 * 跑 N 核时，本机可见核必须占它在全局会话里的那个槽位，否则游戏会把它
 * 认成玩家 1。slot 已被占用或越界时返回 false。 */
bool netLinkBusJoinLocalSlot(struct NetLink* link, int key, int slot);
/* 是否处于进程内总线模式，以及本机占用的链路槽位；SIO 驱动用它把「谁起
 * 一轮 MULTI」的判据从链路 player 号切到游戏认定的主机。 */
bool netLinkBusIsLocal(struct NetLink* link);
int netLinkBusLocalSlot(struct NetLink* link);
/* 本机是否处于总线模式（players > 2 且已启动）。 */
bool netLinkBusActive(struct NetLink* link);
/* 当前已连上的玩家数（含本机）。未连上或非总线模式返回 0。 */
int netLinkBusPlayers(struct NetLink* link);
/* 主机 / 从机端口上最后一次见到的轮次号（主机自己的推送或主机的广播）。
 * 从机靠它把轮次号对齐到主机，避免刚加入时用 0 号去推、主机匹配不上。 */
uint16_t netLinkBusRoundIndex(struct NetLink* link);
/* 主机最近一次广播里带的模拟时钟戳（从机对齐轮次节奏用）；没有则为 0。 */
uint32_t netLinkBusRoundCycles(struct NetLink* link);
/* 只读轮次对齐诊断，输出 7 个 int32：
 * [轮数, 收齐轮数, 空槽轮数, 落后PUSH数, 超前PUSH数, 最小偏差, 最大偏差]。
 * 偏差 = (int16_t)(从机 PUSH 的 index - 主机本轮 index)。 */
void netLinkBusDiag(struct NetLink* link, int32_t* out);
/* 进程内总线的墙钟诊断：busRoundLocal 内部累计微秒数与从机调用次数。
 * 非本地总线时两者都返回 0。不占用 netLinkBusDiag 的 7 项契约。 */
void netLinkBusDiagTiming(struct NetLink* link, uint64_t* totalUs, int* slaveCalls);
/* 一轮聚合。values[0..players-1] 按槽位排列，缺席的槽位填 0xFFFF。
 *
 * 主机：等所有**已连接**从机把 index 这一轮的字推上来，然后广播给所有从机。
 * 从机：把 own 推给主机，等主机的广播。
 * 两边的 index 都以主机为准，从机实际采用的轮次号从 indexOut 回带。
 *
 * 返回本轮的**对端槽位数**（不含本机）：0 表示只拿到自己的字（其余槽位是
 * 0xFFFF），-1 表示这一轮根本没拿到（主机没广播 / 链路已断），调用方应当
 * 等下一轮而不是拿空槽收尾。 */
int netLinkBusRound(struct NetLink* link, uint16_t index, uint32_t own,
                    uint32_t* values, int players, int timeoutMs, uint16_t* indexOut);

/* 把一轮汇聚结果摊成 SIOMULTI0..3 的四个槽位（纯函数，不碰链路状态）。
 *
 * 规则就三条，但每一条都对应一类真实故障：
 *   1. values[i] 只有在 i < players 时才进槽 —— 人数不足的槽必须是空槽
 *      0xFFFF。填错会让游戏的玩家数判定多出一个人，握手直接失败。
 *   2. out[me] 一定用本机这一轮的字 own —— 广播里的自己那份可能因为主机
 *      晚了半拍而是旧值。
 *   3. me 不在 0..3（例如链路还没连上、player 号无效）时不做第 2 条，
 *      不能越界写。 */
void netLinkBusSlots(const uint32_t* values, int players, int me, uint16_t own, uint16_t out[4]);

#ifdef __cplusplus
}
#endif

#endif
