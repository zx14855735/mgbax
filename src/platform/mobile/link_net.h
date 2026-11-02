/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#ifndef MGBA_ANDROID_LINK_NET_H
#define MGBA_ANDROID_LINK_NET_H

#include <stddef.h>
#include <stdint.h>
#include <stdbool.h>

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

#endif
