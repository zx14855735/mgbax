/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#ifndef MGBA_REMOTE_LINK_H
#define MGBA_REMOTE_LINK_H

#include <stdbool.h>

#ifdef __cplusplus
extern "C" {
#endif

/* Wire protocol shared with the Android RemoteLink room tunnel. */
#define MGBA_LINK_PORT 18765
#define MGBA_RELAY_PORT 8766

struct MobileRelay;

struct MobileRelayHooks {
	void* user;
	void (*onStatus)(void* user, const char* text);
	void (*onRoom)(void* user, const char* code, const char* advertise);
	bool (*hostLink)(void* user, int port);
	bool (*joinLink)(void* user, const char* host, int port);
	void (*closeLink)(void* user);
};

struct MobileRelay* mobileRelayCreate(struct MobileRelayHooks hooks);
void mobileRelayDestroy(struct MobileRelay* relay);
void mobileRelayCreateRoom(struct MobileRelay* relay, const char* relayField, const char* localIp);
void mobileRelayJoinRoom(struct MobileRelay* relay, const char* relayField, const char* code);
void mobileRelayClose(struct MobileRelay* relay);

#ifdef __cplusplus
}
#endif

#endif
