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

#endif
