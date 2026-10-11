/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "remote_link.h"

#include <ctype.h>
#include <errno.h>
#include <pthread.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#ifdef _WIN32
#ifndef _WIN32_WINNT
#define _WIN32_WINNT 0x0601
#endif
#include <winsock2.h>
#include <ws2tcpip.h>
#ifndef SHUT_RD
#define SHUT_RD SD_RECEIVE
#endif
#ifndef SHUT_WR
#define SHUT_WR SD_SEND
#endif
#ifndef SHUT_RDWR
#define SHUT_RDWR SD_BOTH
#endif
#define relay_close closesocket
#else
#include <arpa/inet.h>
#include <netinet/in.h>
#include <netinet/tcp.h>
#include <sys/socket.h>
#include <unistd.h>
#define relay_close close
#endif

#ifndef MSG_NOSIGNAL
#define MSG_NOSIGNAL 0
#endif

#define RELAY_THREADS 24
#define RELAY_ROOMS 32

static const char* kAlphabet = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";

struct Room {
	int used;
	char code[8];
	int hostFd;
	int guestFd;
	int guestReady;
	int finished;
	pthread_mutex_t mu;
	pthread_cond_t cv;
};

struct RelayHub {
	struct MobileRelay* relay;
	struct Room rooms[RELAY_ROOMS];
	pthread_mutex_t mu;
};

struct MobileRelay {
	struct MobileRelayHooks hooks;
	pthread_mutex_t mu;
	int generation;
	int* fds;
	int fdCount;
	int fdCap;
	pthread_t threads[RELAY_THREADS];
	int threadLive[RELAY_THREADS];
	int threadCount;
	struct RelayHub* hub;
};

static void sockInit(void) {
#ifdef _WIN32
	static int ready;
	if (!ready) {
		WSADATA data;
		WSAStartup(MAKEWORD(2, 2), &data);
		ready = 1;
	}
#else
#endif
}

static void tuneFd(int fd) {
	int one = 1;
	if (fd < 0) {
		return;
	}
	setsockopt(fd, IPPROTO_TCP, TCP_NODELAY, (const char*) &one, sizeof(one));
	setsockopt(fd, SOL_SOCKET, SO_KEEPALIVE, (const char*) &one, sizeof(one));
#ifdef __APPLE__
	setsockopt(fd, SOL_SOCKET, SO_NOSIGPIPE, &one, sizeof(one));
#endif
}

static int live(struct MobileRelay* relay, int gen) {
	int ok;
	pthread_mutex_lock(&relay->mu);
	ok = gen == relay->generation;
	pthread_mutex_unlock(&relay->mu);
	return ok;
}

static void status(struct MobileRelay* relay, int gen, const char* text) {
	if (live(relay, gen) && relay->hooks.onStatus) {
		relay->hooks.onStatus(relay->hooks.user, text ? text : "");
	}
}

static void track(struct MobileRelay* relay, int gen, int fd) {
	int stale = 0;
	pthread_mutex_lock(&relay->mu);
	if (gen != relay->generation) {
		stale = 1;
	} else {
		if (relay->fdCount == relay->fdCap) {
			int cap = relay->fdCap == 0 ? 8 : relay->fdCap * 2;
			int* next = (int*) realloc(relay->fds, (size_t) cap * sizeof(int));
			if (next) {
				relay->fds = next;
				relay->fdCap = cap;
			}
		}
		if (relay->fdCount < relay->fdCap) {
			relay->fds[relay->fdCount++] = fd;
			fd = -1;
		} else {
			stale = 1;
		}
	}
	pthread_mutex_unlock(&relay->mu);
	if (stale && fd >= 0) {
		relay_close(fd);
	}
}

static int rememberThread(struct MobileRelay* relay, pthread_t thread) {
	int ok = 0;
	pthread_mutex_lock(&relay->mu);
	if (relay->threadCount < RELAY_THREADS) {
		relay->threads[relay->threadCount] = thread;
		relay->threadLive[relay->threadCount] = 1;
		relay->threadCount++;
		ok = 1;
	}
	pthread_mutex_unlock(&relay->mu);
	return ok;
}

static int writeAll(int fd, const char* data, size_t len) {
	size_t off = 0;
	while (off < len) {
		int n = (int) send(fd, data + off, (int) (len - off), MSG_NOSIGNAL);
		if (n < 0) {
			if (errno == EINTR) {
				continue;
			}
			return -1;
		}
		if (n == 0) {
			return -1;
		}
		off += (size_t) n;
	}
	return 0;
}

static int writeLine(int fd, const char* line) {
	char buf[160];
	int n = snprintf(buf, sizeof(buf), "%s\n", line);
	if (n <= 0 || n >= (int) sizeof(buf)) {
		return -1;
	}
	return writeAll(fd, buf, (size_t) n);
}

static int readLine(int fd, char* out, size_t outLen) {
	size_t n = 0;
	if (!out || outLen == 0) {
		return -1;
	}
	while (n + 1 < outLen && n < 96) {
		char b;
		int got = (int) recv(fd, &b, 1, 0);
		if (got < 0) {
			if (errno == EINTR) {
				continue;
			}
			return -1;
		}
		if (got == 0) {
			return -1;
		}
		if (b == '\n') {
			while (n > 0 && (out[n - 1] == '\r' || out[n - 1] == ' ')) {
				n--;
			}
			out[n] = '\0';
			return 0;
		}
		if (b != '\r') {
			out[n++] = b;
		}
	}
	return -1;
}

static int connectTo(const char* host, int port) {
	int fd;
	struct sockaddr_in addr;
	fd = (int) socket(AF_INET, SOCK_STREAM, 0);
	if (fd < 0) {
		return -1;
	}
	memset(&addr, 0, sizeof(addr));
	addr.sin_family = AF_INET;
	addr.sin_port = htons((uint16_t) port);
	if (inet_pton(AF_INET, host, &addr.sin_addr) != 1) {
		relay_close(fd);
		return -1;
	}
	if (connect(fd, (struct sockaddr*) &addr, sizeof(addr)) < 0) {
		relay_close(fd);
		return -1;
	}
	tuneFd(fd);
	return fd;
}

static const char* errText(const char* line) {
	if (line && strstr(line, "NO_ROOM")) {
		return "没有这个房间";
	}
	if (line && strstr(line, "FULL")) {
		return "房间已满";
	}
	if (line && strstr(line, "TIMEOUT")) {
		return "等待对方超时";
	}
	return "中继拒绝了连接";
}

static int roomCode(const char* line, const char* role, char* code, size_t codeLen) {
	const char* prefix = "MGBA1 ROOM ";
	size_t prefixLen = strlen(prefix);
	size_t roleLen;
	size_t len;
	if (!line || strncmp(line, prefix, prefixLen) != 0) {
		return -1;
	}
	roleLen = strlen(role);
	len = strlen(line);
	if (len < prefixLen + roleLen + 1 || line[len - roleLen - 1] != ' ' || strcmp(line + len - roleLen, role) != 0) {
		return -1;
	}
	len = len - roleLen - 1 - prefixLen;
	if (len == 0 || len + 1 > codeLen) {
		return -1;
	}
	memcpy(code, line + prefixLen, len);
	code[len] = '\0';
	return 0;
}

struct PumpPair {
	int src;
	int dst;
};

static void* pumpMain(void* arg) {
	struct PumpPair* pair = (struct PumpPair*) arg;
	char buf[8192];
	for (;;) {
		int n = (int) recv(pair->src, buf, sizeof(buf), 0);
		if (n < 0) {
			if (errno == EINTR) {
				continue;
			}
			break;
		}
		if (n == 0) {
			break;
		}
		if (writeAll(pair->dst, buf, (size_t) n) < 0) {
			break;
		}
	}
	shutdown(pair->dst, SHUT_WR);
	free(pair);
	return NULL;
}

static void splice(int left, int right) {
	pthread_t a;
	pthread_t b;
	struct PumpPair* up = (struct PumpPair*) calloc(1, sizeof(struct PumpPair));
	struct PumpPair* down = (struct PumpPair*) calloc(1, sizeof(struct PumpPair));
	if (!up || !down) {
		free(up);
		free(down);
		return;
	}
	up->src = left;
	up->dst = right;
	down->src = right;
	down->dst = left;
	if (pthread_create(&a, NULL, pumpMain, up) != 0) {
		free(up);
		free(down);
		return;
	}
	if (pthread_create(&b, NULL, pumpMain, down) != 0) {
		shutdown(left, SHUT_RDWR);
		shutdown(right, SHUT_RDWR);
		pthread_join(a, NULL);
		free(down);
		return;
	}
	pthread_join(a, NULL);
	pthread_join(b, NULL);
}

static void newCode(char* out) {
	int i;
	int alphabet = (int) strlen(kAlphabet);
	for (i = 0; i < 6; ++i) {
		out[i] = kAlphabet[rand() % alphabet];
	}
	out[6] = '\0';
}

static struct Room* allocRoom(struct RelayHub* hub, const char* code) {
	int i;
	pthread_mutex_lock(&hub->mu);
	for (i = 0; i < RELAY_ROOMS; ++i) {
		if (!hub->rooms[i].used) {
			struct Room* room = &hub->rooms[i];
			memset(room, 0, sizeof(*room));
			room->used = 1;
			room->hostFd = -1;
			room->guestFd = -1;
			snprintf(room->code, sizeof(room->code), "%s", code);
			pthread_mutex_init(&room->mu, NULL);
			pthread_cond_init(&room->cv, NULL);
			pthread_mutex_unlock(&hub->mu);
			return room;
		}
	}
	pthread_mutex_unlock(&hub->mu);
	return NULL;
}

static struct Room* findRoom(struct RelayHub* hub, const char* code) {
	int i;
	struct Room* found = NULL;
	pthread_mutex_lock(&hub->mu);
	for (i = 0; i < RELAY_ROOMS; ++i) {
		if (hub->rooms[i].used && strcmp(hub->rooms[i].code, code) == 0) {
			found = &hub->rooms[i];
			break;
		}
	}
	pthread_mutex_unlock(&hub->mu);
	return found;
}

static void destroyHub(struct RelayHub* hub) {
	int i;
	if (!hub) {
		return;
	}
	for (i = 0; i < RELAY_ROOMS; ++i) {
		if (hub->rooms[i].used) {
			pthread_mutex_destroy(&hub->rooms[i].mu);
			pthread_cond_destroy(&hub->rooms[i].cv);
		}
	}
	pthread_mutex_destroy(&hub->mu);
	free(hub);
}

struct RoomThread {
	struct RelayHub* hub;
	struct Room* room;
	int fd;
	int gen;
};

static int waitGuest(struct MobileRelay* relay, int gen, struct Room* room) {
	struct timespec ts;
	int spins = 0;
	while (live(relay, gen) && spins < 15 * 60 * 5) {
		pthread_mutex_lock(&room->mu);
		if (room->guestReady) {
			pthread_mutex_unlock(&room->mu);
			return 1;
		}
		ts.tv_sec = time(NULL) + 1;
		ts.tv_nsec = 0;
		pthread_cond_timedwait(&room->cv, &room->mu, &ts);
		pthread_mutex_unlock(&room->mu);
		spins++;
	}
	return 0;
}

static void finishRoom(struct Room* room) {
	pthread_mutex_lock(&room->mu);
	room->finished = 1;
	pthread_cond_broadcast(&room->cv);
	pthread_mutex_unlock(&room->mu);
}

static void* hostRoom(void* arg) {
	struct RoomThread* job = (struct RoomThread*) arg;
	struct RelayHub* hub = job->hub;
	struct Room* room = job->room;
	int fd = job->fd;
	int gen = job->gen;
	char line[96];
	free(job);
	snprintf(line, sizeof(line), "MGBA1 ROOM %s HOST", room->code);
	if (writeLine(fd, line) < 0) {
		finishRoom(room);
		return NULL;
	}
	if (!waitGuest(hub->relay, gen, room)) {
		writeLine(fd, "MGBA1 ERR TIMEOUT");
		finishRoom(room);
		return NULL;
	}
	writeLine(fd, "MGBA1 PEER");
	pthread_mutex_lock(&room->mu);
	writeLine(room->guestFd, "MGBA1 PEER");
	pthread_mutex_unlock(&room->mu);
	splice(fd, room->guestFd);
	finishRoom(room);
	return NULL;
}

static void* guestRoom(void* arg) {
	struct RoomThread* job = (struct RoomThread*) arg;
	struct Room* room = job->room;
	int fd = job->fd;
	char line[96];
	struct timespec ts;
	int spins = 0;
	free(job);
	pthread_mutex_lock(&room->mu);
	if (room->guestFd >= 0) {
		pthread_mutex_unlock(&room->mu);
		writeLine(fd, "MGBA1 ERR FULL");
		relay_close(fd);
		return NULL;
	}
	room->guestFd = fd;
	room->guestReady = 1;
	pthread_cond_broadcast(&room->cv);
	pthread_mutex_unlock(&room->mu);
	snprintf(line, sizeof(line), "MGBA1 ROOM %s GUEST", room->code);
	writeLine(fd, line);
	while (spins < 15 * 60 * 5) {
		pthread_mutex_lock(&room->mu);
		if (room->finished || !room->used) {
			pthread_mutex_unlock(&room->mu);
			break;
		}
		ts.tv_sec = time(NULL) + 1;
		ts.tv_nsec = 0;
		pthread_cond_timedwait(&room->cv, &room->mu, &ts);
		pthread_mutex_unlock(&room->mu);
		spins++;
	}
	return NULL;
}

static void* handleClient(void* arg) {
	struct RoomThread* job = (struct RoomThread*) arg;
	char line[96];
	pthread_t child;
	if (readLine(job->fd, line, sizeof(line)) < 0) {
		relay_close(job->fd);
		free(job);
		return NULL;
	}
	if (strcmp(line, "MGBA1 CREATE") == 0) {
		char code[8];
		struct Room* room;
		int tries = 0;
		do {
			newCode(code);
			room = findRoom(job->hub, code);
			tries++;
		} while (room && tries < 8);
		room = allocRoom(job->hub, code);
		if (!room) {
			writeLine(job->fd, "MGBA1 ERR FULL");
			relay_close(job->fd);
			free(job);
			return NULL;
		}
		room->hostFd = job->fd;
		job->room = room;
		if (pthread_create(&child, NULL, hostRoom, job) == 0) {
			rememberThread(job->hub->relay, child);
		} else {
			free(job);
		}
		return NULL;
	}
	if (strncmp(line, "MGBA1 JOIN ", 11) == 0) {
		char code[8];
		struct Room* room;
		size_t i;
		snprintf(code, sizeof(code), "%s", line + 11);
		for (i = 0; code[i]; ++i) {
			code[i] = (char) toupper((unsigned char) code[i]);
		}
		room = findRoom(job->hub, code);
		if (!room) {
			writeLine(job->fd, "MGBA1 ERR NO_ROOM");
			relay_close(job->fd);
			free(job);
			return NULL;
		}
		job->room = room;
		if (pthread_create(&child, NULL, guestRoom, job) == 0) {
			rememberThread(job->hub->relay, child);
		} else {
			free(job);
		}
		return NULL;
	}
	writeLine(job->fd, "MGBA1 ERR BAD");
	relay_close(job->fd);
	free(job);
	return NULL;
}

struct AcceptJob {
	struct MobileRelay* relay;
	struct RelayHub* hub;
	int fd;
	int gen;
};

static void* acceptMain(void* arg) {
	struct AcceptJob* job = (struct AcceptJob*) arg;
	struct RelayHub* hub = job->hub;
	int server = job->fd;
	int gen = job->gen;
	free(job);
	while (live(hub->relay, gen)) {
		int fd = (int) accept(server, NULL, NULL);
		pthread_t child;
		struct RoomThread* client;
		if (fd < 0) {
			break;
		}
		tuneFd(fd);
		track(hub->relay, gen, fd);
		client = (struct RoomThread*) calloc(1, sizeof(struct RoomThread));
		if (!client) {
			relay_close(fd);
			continue;
		}
		client->hub = hub;
		client->fd = fd;
		client->gen = gen;
		if (pthread_create(&child, NULL, handleClient, client) == 0) {
			rememberThread(hub->relay, child);
		} else {
			free(client);
		}
	}
	return NULL;
}

static int startEmbedded(struct MobileRelay* relay, int gen, int* portOut) {
	int port;
	for (port = MGBA_RELAY_PORT; port < MGBA_RELAY_PORT + 8; ++port) {
		int fd = (int) socket(AF_INET, SOCK_STREAM, 0);
		int one = 1;
		struct sockaddr_in addr;
		struct RelayHub* hub;
		struct AcceptJob* job;
		pthread_t thread;
		if (fd < 0) {
			continue;
		}
		setsockopt(fd, SOL_SOCKET, SO_REUSEADDR, (const char*) &one, sizeof(one));
		memset(&addr, 0, sizeof(addr));
		addr.sin_family = AF_INET;
		addr.sin_port = htons((uint16_t) port);
		addr.sin_addr.s_addr = htonl(INADDR_ANY);
		if (bind(fd, (struct sockaddr*) &addr, sizeof(addr)) < 0 || listen(fd, 8) < 0) {
			relay_close(fd);
			continue;
		}
		tuneFd(fd);
		track(relay, gen, fd);
		hub = (struct RelayHub*) calloc(1, sizeof(struct RelayHub));
		job = (struct AcceptJob*) calloc(1, sizeof(struct AcceptJob));
		if (!hub || !job) {
			free(hub);
			free(job);
			return -1;
		}
		hub->relay = relay;
		pthread_mutex_init(&hub->mu, NULL);
		relay->hub = hub;
		job->relay = relay;
		job->hub = hub;
		job->fd = fd;
		job->gen = gen;
		if (pthread_create(&thread, NULL, acceptMain, job) != 0) {
			free(job);
			free(hub);
			return -1;
		}
		rememberThread(relay, thread);
		*portOut = port;
		return 0;
	}
	return -1;
}

struct Endpoint {
	char host[128];
	int port;
	char advertise[160];
	int embedded;
};

static int parseEndpoint(const char* text, struct Endpoint* out) {
	const char* colon;
	memset(out, 0, sizeof(*out));
	colon = strrchr(text, ':');
	out->port = MGBA_RELAY_PORT;
	if (colon && colon != text && strchr(text, ':') == colon) {
		size_t hostLen = (size_t) (colon - text);
		if (hostLen >= sizeof(out->host)) {
			return -1;
		}
		memcpy(out->host, text, hostLen);
		out->host[hostLen] = '\0';
		out->port = atoi(colon + 1);
	} else {
		snprintf(out->host, sizeof(out->host), "%s", text);
	}
	if (out->host[0] == '\0' || out->port < 1 || out->port > 65535) {
		return -1;
	}
	snprintf(out->advertise, sizeof(out->advertise), "%s:%d", out->host, out->port);
	return 0;
}

static int resolveRelay(struct MobileRelay* relay, int gen, const char* relayField, const char* localIp, struct Endpoint* out) {
	char text[160];
	snprintf(text, sizeof(text), "%s", relayField ? relayField : "");
	if (text[0]) {
		return parseEndpoint(text, out);
	}
	if (!localIp) {
		return -2;
	}
	{
		int port = 0;
		if (startEmbedded(relay, gen, &port) < 0) {
			return -3;
		}
		snprintf(out->host, sizeof(out->host), "%s", "127.0.0.1");
		out->port = port;
		out->embedded = 1;
		if (localIp[0] == '\0' || strcmp(localIp, "0.0.0.0") == 0) {
			snprintf(out->advertise, sizeof(out->advertise), "端口 %d", port);
		} else {
			snprintf(out->advertise, sizeof(out->advertise), "%s:%d", localIp, port);
		}
	}
	return 0;
}

struct Session {
	struct MobileRelay* relay;
	int gen;
	char relayField[160];
	char localIp[64];
	char code[16];
	int isHost;
};

static void* sessionMain(void* arg) {
	struct Session* session = (struct Session*) arg;
	struct MobileRelay* relay = session->relay;
	int gen = session->gen;
	struct Endpoint relayEp;
	int relayFd = -1;
	char line[128];
	char code[16];
	int resolved;
	if (!live(relay, gen)) {
		free(session);
		return NULL;
	}
	if (session->isHost) {
		if (!relay->hooks.hostLink || !relay->hooks.hostLink(relay->hooks.user, MGBA_LINK_PORT)) {
			status(relay, gen, "本机联机端口被占用");
			free(session);
			return NULL;
		}
	} else if (session->code[0] == '\0') {
		status(relay, gen, "先填写房间号");
		free(session);
		return NULL;
	}
	resolved = resolveRelay(relay, gen, session->relayField, session->isHost ? session->localIp : NULL, &relayEp);
	if (resolved == -2) {
		status(relay, gen, "加入时要填写对方的中继地址");
		if (relay->hooks.closeLink) {
			relay->hooks.closeLink(relay->hooks.user);
		}
		free(session);
		return NULL;
	}
	if (resolved == -3) {
		status(relay, gen, "中继端口被占用");
		if (relay->hooks.closeLink) {
			relay->hooks.closeLink(relay->hooks.user);
		}
		free(session);
		return NULL;
	}
	if (resolved != 0) {
		status(relay, gen, resolved == -1 ? "中继地址无效" : "中继端口无效");
		if (relay->hooks.closeLink) {
			relay->hooks.closeLink(relay->hooks.user);
		}
		free(session);
		return NULL;
	}
	if (!session->isHost && relayEp.embedded) {
		status(relay, gen, "加入时要填写对方的中继地址");
		free(session);
		return NULL;
	}
	if (session->isHost) {
		char msg[200];
		snprintf(msg, sizeof(msg), "正在连接中继 %s", relayEp.advertise);
		status(relay, gen, msg);
	} else {
		char msg[80];
		snprintf(msg, sizeof(msg), "正在加入房间 %s", session->code);
		status(relay, gen, msg);
	}
	relayFd = connectTo(relayEp.host, relayEp.port);
	if (relayFd < 0) {
		char msg[200];
		snprintf(msg, sizeof(msg), "连不上中继 %s:%d", relayEp.host, relayEp.port);
		status(relay, gen, msg);
		if (live(relay, gen) && relay->hooks.closeLink) {
			relay->hooks.closeLink(relay->hooks.user);
		}
		free(session);
		return NULL;
	}
	track(relay, gen, relayFd);
	if (session->isHost) {
		int localFd;
		if (writeLine(relayFd, "MGBA1 CREATE") < 0 || readLine(relayFd, line, sizeof(line)) < 0 || roomCode(line, "HOST", code, sizeof(code)) < 0) {
			status(relay, gen, line[0] && strncmp(line, "MGBA1 ERR", 9) == 0 ? errText(line) : "中继协议不匹配");
			if (live(relay, gen) && relay->hooks.closeLink) {
				relay->hooks.closeLink(relay->hooks.user);
			}
			free(session);
			return NULL;
		}
		if (relay->hooks.onRoom && live(relay, gen)) {
			relay->hooks.onRoom(relay->hooks.user, code, relayEp.advertise);
		}
		{
			char msg[240];
			snprintf(msg, sizeof(msg), "房间 %s\n让对方把中继填成 %s\n房间号 %s", code, relayEp.advertise, code);
			status(relay, gen, msg);
		}
		if (readLine(relayFd, line, sizeof(line)) < 0 || strcmp(line, "MGBA1 PEER") != 0) {
			status(relay, gen, line[0] && strncmp(line, "MGBA1 ERR", 9) == 0 ? errText(line) : "中继协议不匹配");
			if (live(relay, gen) && relay->hooks.closeLink) {
				relay->hooks.closeLink(relay->hooks.user);
			}
			free(session);
			return NULL;
		}
		if (!live(relay, gen)) {
			free(session);
			return NULL;
		}
		localFd = connectTo("127.0.0.1", MGBA_LINK_PORT);
		if (localFd < 0) {
			status(relay, gen, "本机联机连接失败");
			if (relay->hooks.closeLink) {
				relay->hooks.closeLink(relay->hooks.user);
			}
			free(session);
			return NULL;
		}
		track(relay, gen, localFd);
		status(relay, gen, "已接通中继，你是 1P");
		splice(localFd, relayFd);
		status(relay, gen, "对方已断开");
		if (live(relay, gen) && relay->hooks.closeLink) {
			relay->hooks.closeLink(relay->hooks.user);
		}
		free(session);
		return NULL;
	}
	{
		char join[40];
		int listenFd;
		struct sockaddr_in addr;
		socklen_t addrLen = sizeof(addr);
		int localFd;
		snprintf(join, sizeof(join), "MGBA1 JOIN %s", session->code);
		if (writeLine(relayFd, join) < 0 || readLine(relayFd, line, sizeof(line)) < 0) {
			status(relay, gen, "中继已断开");
			if (live(relay, gen) && relay->hooks.closeLink) {
				relay->hooks.closeLink(relay->hooks.user);
			}
			free(session);
			return NULL;
		}
		if (strncmp(line, "MGBA1 ERR", 9) == 0) {
			status(relay, gen, errText(line));
			if (live(relay, gen) && relay->hooks.closeLink) {
				relay->hooks.closeLink(relay->hooks.user);
			}
			free(session);
			return NULL;
		}
		if (roomCode(line, "GUEST", code, sizeof(code)) < 0) {
			status(relay, gen, "中继协议不匹配");
			if (live(relay, gen) && relay->hooks.closeLink) {
				relay->hooks.closeLink(relay->hooks.user);
			}
			free(session);
			return NULL;
		}
		if (readLine(relayFd, line, sizeof(line)) < 0 || strcmp(line, "MGBA1 PEER") != 0) {
			status(relay, gen, line[0] && strncmp(line, "MGBA1 ERR", 9) == 0 ? errText(line) : "中继协议不匹配");
			if (live(relay, gen) && relay->hooks.closeLink) {
				relay->hooks.closeLink(relay->hooks.user);
			}
			free(session);
			return NULL;
		}
		listenFd = (int) socket(AF_INET, SOCK_STREAM, 0);
		memset(&addr, 0, sizeof(addr));
		addr.sin_family = AF_INET;
		addr.sin_addr.s_addr = htonl(INADDR_LOOPBACK);
		addr.sin_port = 0;
		if (listenFd < 0 || bind(listenFd, (struct sockaddr*) &addr, sizeof(addr)) < 0 || listen(listenFd, 1) < 0) {
			if (listenFd >= 0) {
				relay_close(listenFd);
			}
			status(relay, gen, "本机联机连接失败");
			free(session);
			return NULL;
		}
		tuneFd(listenFd);
		track(relay, gen, listenFd);
		if (getsockname(listenFd, (struct sockaddr*) &addr, &addrLen) < 0) {
			status(relay, gen, "本机联机连接失败");
			free(session);
			return NULL;
		}
		if (!relay->hooks.joinLink || !relay->hooks.joinLink(relay->hooks.user, "127.0.0.1", ntohs(addr.sin_port))) {
			status(relay, gen, "本机联机连接失败");
			if (relay->hooks.closeLink) {
				relay->hooks.closeLink(relay->hooks.user);
			}
			free(session);
			return NULL;
		}
		localFd = (int) accept(listenFd, NULL, NULL);
		if (localFd < 0) {
			status(relay, gen, "本机联机连接失败");
			free(session);
			return NULL;
		}
		tuneFd(localFd);
		track(relay, gen, localFd);
		status(relay, gen, "已接通中继，你是 2P");
		splice(localFd, relayFd);
		status(relay, gen, "对方已断开");
		if (live(relay, gen) && relay->hooks.closeLink) {
			relay->hooks.closeLink(relay->hooks.user);
		}
		free(session);
	}
	return NULL;
}

static int restart(struct MobileRelay* relay) {
	int* fds = NULL;
	int count = 0;
	pthread_t threads[RELAY_THREADS];
	int nthreads = 0;
	int i;
	int gen;
	pthread_t self = pthread_self();
	pthread_mutex_lock(&relay->mu);
	relay->generation++;
	fds = relay->fds;
	count = relay->fdCount;
	relay->fds = NULL;
	relay->fdCount = 0;
	relay->fdCap = 0;
	for (i = 0; i < relay->threadCount; ++i) {
		if (relay->threadLive[i] && !pthread_equal(relay->threads[i], self)) {
			threads[nthreads++] = relay->threads[i];
			relay->threadLive[i] = 0;
		}
	}
	relay->threadCount = 0;
	gen = relay->generation;
	pthread_mutex_unlock(&relay->mu);
	for (i = 0; i < count; ++i) {
		shutdown(fds[i], SHUT_RDWR);
		relay_close(fds[i]);
	}
	free(fds);
	if (relay->hooks.closeLink) {
		relay->hooks.closeLink(relay->hooks.user);
	}
	for (;;) {
		int more = 0;
		pthread_mutex_lock(&relay->mu);
		for (i = 0; i < relay->threadCount && nthreads < RELAY_THREADS; ++i) {
			if (relay->threadLive[i] && !pthread_equal(relay->threads[i], self)) {
				threads[nthreads++] = relay->threads[i];
				relay->threadLive[i] = 0;
				more = 1;
			}
		}
		relay->threadCount = 0;
		pthread_mutex_unlock(&relay->mu);
		if (!more && nthreads == 0) {
			break;
		}
		while (nthreads > 0) {
			nthreads--;
			pthread_join(threads[nthreads], NULL);
		}
	}
	if (relay->hub) {
		destroyHub(relay->hub);
		relay->hub = NULL;
	}
	return gen;
}

struct MobileRelay* mobileRelayCreate(struct MobileRelayHooks hooks) {
	struct MobileRelay* relay;
	sockInit();
	relay = (struct MobileRelay*) calloc(1, sizeof(struct MobileRelay));
	if (!relay) {
		return NULL;
	}
	relay->hooks = hooks;
	pthread_mutex_init(&relay->mu, NULL);
	srand((unsigned) time(NULL));
	return relay;
}

void mobileRelayDestroy(struct MobileRelay* relay) {
	if (!relay) {
		return;
	}
	restart(relay);
	pthread_mutex_destroy(&relay->mu);
	free(relay);
}

static void startSession(struct MobileRelay* relay, struct Session* session) {
	pthread_t thread;
	int gen = restart(relay);
	session->relay = relay;
	session->gen = gen;
	if (pthread_create(&thread, NULL, sessionMain, session) != 0) {
		free(session);
		return;
	}
	rememberThread(relay, thread);
}

void mobileRelayCreateRoom(struct MobileRelay* relay, const char* relayField, const char* localIp) {
	struct Session* session;
	if (!relay) {
		return;
	}
	session = (struct Session*) calloc(1, sizeof(struct Session));
	if (!session) {
		return;
	}
	session->isHost = 1;
	snprintf(session->relayField, sizeof(session->relayField), "%s", relayField ? relayField : "");
	snprintf(session->localIp, sizeof(session->localIp), "%s", localIp ? localIp : "");
	startSession(relay, session);
}

void mobileRelayJoinRoom(struct MobileRelay* relay, const char* relayField, const char* code) {
	struct Session* session;
	size_t i;
	if (!relay) {
		return;
	}
	session = (struct Session*) calloc(1, sizeof(struct Session));
	if (!session) {
		return;
	}
	snprintf(session->relayField, sizeof(session->relayField), "%s", relayField ? relayField : "");
	snprintf(session->code, sizeof(session->code), "%s", code ? code : "");
	for (i = 0; session->code[i]; ++i) {
		session->code[i] = (char) toupper((unsigned char) session->code[i]);
	}
	while (i > 0 && session->code[i - 1] == ' ') {
		session->code[--i] = '\0';
	}
	startSession(relay, session);
}

void mobileRelayClose(struct MobileRelay* relay) {
	if (!relay) {
		return;
	}
	restart(relay);
}
