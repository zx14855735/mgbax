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
 * 动辄几十毫秒，等它必然错过游戏的传输窗口）。 */
void netLinkPush(struct NetLink* link, uint16_t mode, uint32_t local, uint16_t index);

/* 取对端第 want 轮的字。对端按轮次先后推送，这里也按先后取，早于 want 的
 * 迟到推送直接丢弃（本机早已按超时收尾过那一轮）。timeoutMs > 0 时会阻塞
 * 调用线程（模拟线程），这正是联机需要的背压：等网络的时候模拟时钟不应该
 * 往前走。indexOut 回带真正取到的轮次，和 want 不等就说明中间丢过一轮。 */
bool netLinkTakePeerWord(struct NetLink* link, uint16_t want, int timeoutMs, uint32_t* value, uint16_t* indexOut);
void netLinkPeerStats(struct NetLink* link, uint32_t* stale, uint32_t* drops);

#endif
