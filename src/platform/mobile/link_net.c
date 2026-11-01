/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "link_net.h"

#include <errno.h>
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#ifdef __ANDROID__
#include <android/log.h>
#define LINK_LOG(...) __android_log_print(ANDROID_LOG_INFO, "mGBA", __VA_ARGS__)
#else
#define LINK_LOG(...) ((void) 0)
#endif

/* 每条请求打一行日志会把 60 帧联机拖成幻灯片，默认关掉。 */
#ifndef MGBA_LINK_VERBOSE
#define MGBA_LINK_VERBOSE 0
#endif
#if MGBA_LINK_VERBOSE
#define LINK_VERBOSE(...) LINK_LOG(__VA_ARGS__)
#else
#define LINK_VERBOSE(...) ((void) 0)
#endif

#ifdef _WIN32
#ifndef _WIN32_WINNT
#define _WIN32_WINNT 0x0601
#endif
#include <winsock2.h>
#include <ws2tcpip.h>
#include <sys/time.h>
#include <sys/types.h>
#ifndef SHUT_RD
#define SHUT_RD SD_RECEIVE
#endif
#ifndef SHUT_WR
#define SHUT_WR SD_SEND
#endif
#ifndef SHUT_RDWR
#define SHUT_RDWR SD_BOTH
#endif
#ifndef MSG_NOSIGNAL
#define MSG_NOSIGNAL 0
#endif
#define link_close closesocket
static void linkSockInit(void) {
	static int ready;
	if (!ready) {
		WSADATA data;
		WSAStartup(MAKEWORD(2, 2), &data);
		ready = 1;
	}
}
#else
#include <arpa/inet.h>
#include <fcntl.h>
#include <netinet/in.h>
#include <netinet/tcp.h>
#include <poll.h>
#include <sys/socket.h>
#include <sys/time.h>
#include <unistd.h>
#define link_close close
static void linkSockInit(void) {
}
#endif

#ifndef MSG_NOSIGNAL
#define MSG_NOSIGNAL 0
#endif

static int waitReadable(int fd, int timeoutMs) {
#ifdef _WIN32
	fd_set set;
	struct timeval tv;
	if (fd < 0) {
		return -1;
	}
	FD_ZERO(&set);
	FD_SET((SOCKET) fd, &set);
	tv.tv_sec = timeoutMs / 1000;
	tv.tv_usec = (timeoutMs % 1000) * 1000;
	return select(0, &set, NULL, NULL, &tv);
#else
	struct pollfd pfd;
	pfd.fd = fd;
	pfd.events = POLLIN;
	pfd.revents = 0;
	return poll(&pfd, 1, timeoutMs);
#endif
}

static int setNonBlock(int fd, bool nonBlock) {
#ifdef _WIN32
	u_long mode = nonBlock ? 1 : 0;
	return ioctlsocket(fd, FIONBIO, &mode);
#else
	int flags = fcntl(fd, F_GETFL, 0);
	if (flags < 0) {
		return -1;
	}
	if (nonBlock) {
		flags |= O_NONBLOCK;
	} else {
		flags &= ~O_NONBLOCK;
	}
	return fcntl(fd, F_SETFL, flags);
#endif
}

/** Outbound connect with a hard deadline: the guest probes ports the peer may
 *  not have listening at all, and a firewalled SYN must not park the probe
 *  thread for the OS's two-minute connect timeout. */
static int connectTcp(struct sockaddr_in* addr, int timeoutMs) {
	int fd = socket(AF_INET, SOCK_STREAM, 0);
	if (fd < 0) {
		return -1;
	}
	if (setNonBlock(fd, true) < 0) {
		link_close(fd);
		return -1;
	}
	if (connect(fd, (struct sockaddr*) addr, sizeof(*addr)) < 0) {
#ifdef _WIN32
		int err = WSAGetLastError();
		if (err != WSAEWOULDBLOCK && err != WSAEINPROGRESS) {
			link_close(fd);
			return -1;
		}
#else
		if (errno != EINPROGRESS && errno != EWOULDBLOCK) {
			link_close(fd);
			return -1;
		}
#endif
		fd_set wfds;
		FD_ZERO(&wfds);
		FD_SET(fd, &wfds);
		struct timeval tv;
		tv.tv_sec = timeoutMs / 1000;
		tv.tv_usec = (timeoutMs % 1000) * 1000;
#ifdef _WIN32
		if (select(0, NULL, &wfds, NULL, &tv) <= 0) {
			link_close(fd);
			return -1;
		}
#else
		if (select(fd + 1, NULL, &wfds, NULL, &tv) <= 0) {
			link_close(fd);
			return -1;
		}
#endif
		int soErr = 0;
		socklen_t soLen = sizeof(soErr);
		if (getsockopt(fd, SOL_SOCKET, SO_ERROR, (char*) &soErr, &soLen) < 0 || soErr != 0) {
			link_close(fd);
			return -1;
		}
	}
	setNonBlock(fd, false);
	return fd;
}

static void linkTune(int fd) {
	int one = 1;
	if (fd < 0) {
		return;
	}
	setsockopt(fd, IPPROTO_TCP, TCP_NODELAY, (const char*) &one, sizeof(one));
#ifdef __APPLE__
	setsockopt(fd, SOL_SOCKET, SO_NOSIGPIPE, &one, sizeof(one));
#endif
}

enum {
	LINK_OFF = 0,
	LINK_LISTEN = 1,
	LINK_CONNECTED = 2,
	LINK_DOWN = 3
};

enum {
	PKT_REQ = 1,
	PKT_ACK = 2,
	PKT_TICK = 3,
	PKT_BYE = 4,
	PKT_PUSH = 5,
	PKT_PING = 6,
	PKT_PONG = 7
};

enum { REQ_QUEUE = 8 };

/* 对端每轮推一个字过来，本机每完成一轮取走一个字。两边都是「一轮一推一取」，
 * 所以这里必须按先来先取排队，不能只留最新一条 —— 主机跑在前面时，它已经在
 * 推第 N+1 轮了，而从机还在等第 N 轮；只留最新一条会把第 N 轮的字直接覆盖掉，
 * 从机只能拿到第 N+1 轮的字顶上去，整条流从此错位一格，送进游戏的 SIOMULTI
 * 永远是别人的上一轮数据（握手能过、checksum 必挂）。
 *
 * 队列深度 64 而不是 16：主机的推送是「一阵一阵」的 —— 战斗阶段主机靠
 * Timer3 在一帧的头 146904 个周期里连推 8 轮，然后空 133992 个周期才推
 * 下一轮（帧长 280896）。从机按自己的节奏取字，队列深度要扛得住这一阵
 * 的突发，否则队满丢最老的一条，从机就会漏掉轮次、双方错位。 */
enum { PEER_QUEUE = 64 };

struct PeerWord {
	uint16_t index;
	uint16_t mode;
	uint32_t value;
	/* 对端推送这一轮时的**模拟时钟**（mTiming 周期数）。从机靠它对齐自己的
	 * 模拟时钟速率：两台模拟器必须同速推进，否则游戏每帧入队/出队的命令
	 * 会越错越多。 */
	uint32_t cycles;
	/* 收到时刻（真实毫秒）。联机排查用：从「网络收到对端的字」到
	 * 「本机把它用掉」之间隔了多久，一眼就能看出是网络慢还是对端反应慢。 */
	uint32_t stamp;
};

struct Packet {
	uint32_t magic;
	uint16_t type;
	uint16_t seq;
	uint16_t mode;
	uint16_t player;
	uint32_t value;
	/* 发送方的模拟时钟戳（只有 PKT_PUSH 用）。 */
	uint32_t cycles;
};

struct Req {
	uint16_t seq;
	uint16_t mode;
	uint16_t player;
	uint32_t value;
	uint32_t stamp;
};

struct NetLink {
	pthread_mutex_t mu;
	pthread_cond_t cv;
	pthread_mutex_t sendMu;
	pthread_t ioThread;
	pthread_t pingThread;
	bool pingLive;
	bool threadLive;
	bool stop;
	int listenFd;
	int sock;
	int state;
	int player;
	int port;
	char message[96];

	uint32_t published;
	uint32_t publishedMode;
	uint32_t localTick;
	uint32_t peerTick;
	/* 最近一次 netLinkPush 用的模拟时钟戳，随 PUSH 包发给对端。 */
	uint32_t pushCycles;
	uint16_t nextSeq;
	bool waiting;
	uint16_t waitSeq;
	bool hasAck;
	uint16_t ackSeq;
	uint32_t ackValue;

	/* 对端在它自己那次传输开始时推过来的数据：按轮次先来先取。 */
	struct PeerWord peerQ[PEER_QUEUE];
	int peerHead;
	int peerCount;
	uint32_t peerStale;
	uint32_t peerDrops;
	/* 上一条取走的对端字的到达时刻（真实毫秒），用来量「排队时延」。 */
	uint32_t lastPeerStamp;

	struct Req queue[REQ_QUEUE];
	int qHead;
	int qCount;
	/* 联机排查：只打前几条 REQ，确认请求确实到达了 IO 线程。 */
	int reqDbg;

	/* 延迟探测：每秒一个往返。GBA 联机线是同步串行协议，两边必须同一个
	 * 节拍上交换同一个字，所以 RTT 会直接换成掉帧——异地联机前先看清这个数。 */
	uint32_t pingAt;
	uint32_t pingAtUs;
	uint32_t lastPingAt;
	uint16_t pingSeq;
	bool pingOut;
	int rttMs;
	uint32_t rttUs;
	uint32_t rttUsMax;
	uint32_t rttUsN;
};

static const uint32_t kMagic = 0x314C424Du;

static void setMessage(struct NetLink* link, const char* text) {
	snprintf(link->message, sizeof(link->message), "%s", text ? text : "");
}

static void deadline(struct timespec* ts, int timeoutMs) {
	struct timeval tv;
	gettimeofday(&tv, NULL);
	ts->tv_sec = tv.tv_sec + timeoutMs / 1000;
	ts->tv_nsec = (long) tv.tv_usec * 1000L + (long) (timeoutMs % 1000) * 1000000L;
	if (ts->tv_nsec >= 1000000000L) {
		ts->tv_sec += 1;
		ts->tv_nsec -= 1000000000L;
	}
}

static uint32_t nowMs(void) {
	struct timeval tv;
	gettimeofday(&tv, NULL);
	return (uint32_t) (tv.tv_sec * 1000u + tv.tv_usec / 1000u);
}

/* 微秒时钟：GBA 联机是「每帧至少 9 次串行中断」的同步协议，一轮往返必须
 * 压在 1ms 以内，毫秒精度看不出问题，必须 µs 级。 */
static uint32_t nowUs(void) {
	struct timeval tv;
	gettimeofday(&tv, NULL);
	return (uint32_t) (tv.tv_sec * 1000000u + tv.tv_usec);
}

static bool writeAll(int fd, const void* data, size_t len) {
	const char* p = (const char*) data;
	size_t off = 0;
	while (off < len) {
		ssize_t n = send(fd, p + off, len - off, MSG_NOSIGNAL);
		if (n < 0) {
			if (errno == EINTR) {
				continue;
			}
			return false;
		}
		if (n == 0) {
			return false;
		}
		off += (size_t) n;
	}
	return true;
}

static bool readAll(int fd, void* data, size_t len) {
	char* p = (char*) data;
	size_t off = 0;
	while (off < len) {
		ssize_t n = recv(fd, p + off, len - off, 0);
		if (n < 0) {
			if (errno == EINTR) {
				continue;
			}
			return false;
		}
		if (n == 0) {
			return false;
		}
		off += (size_t) n;
	}
	return true;
}

static bool sendPacket(struct NetLink* link, uint16_t type, uint16_t seq, uint16_t mode, uint32_t value) {
	struct Packet pkt;
	int fd;
	int player;
	memset(&pkt, 0, sizeof(pkt));
	pkt.magic = kMagic;
	pkt.type = type;
	pkt.seq = seq;
	pkt.mode = mode;
	pthread_mutex_lock(&link->mu);
	player = link->player;
	fd = link->sock;
	pthread_mutex_unlock(&link->mu);
	pkt.player = (uint16_t) (player < 0 ? 0 : player);
	pkt.value = value;
	pkt.cycles = __atomic_load_n(&link->pushCycles, __ATOMIC_ACQUIRE);
	if (fd < 0) {
		return false;
	}
	pthread_mutex_lock(&link->sendMu);
	bool ok = writeAll(fd, &pkt, sizeof(pkt));
	pthread_mutex_unlock(&link->sendMu);
	return ok;
}

static void enqueueReq(struct NetLink* link, const struct Packet* pkt) {
	if (link->qCount == REQ_QUEUE) {
		link->qHead = (link->qHead + 1) % REQ_QUEUE;
		link->qCount--;
	}
	int idx = (link->qHead + link->qCount) % REQ_QUEUE;
	link->queue[idx].seq = pkt->seq;
	link->queue[idx].mode = pkt->mode;
	link->queue[idx].player = pkt->player;
	link->queue[idx].value = pkt->value;
	link->queue[idx].stamp = nowMs();
	link->qCount++;
}

static void* readerMain(void* arg);
static void* pingMain(void* arg);

static void* readerMain(void* arg) {
	struct NetLink* link = (struct NetLink*) arg;
	int fd;
	pthread_mutex_lock(&link->mu);
	fd = link->sock;
	pthread_mutex_unlock(&link->mu);
	while (!link->stop && fd >= 0) {
		struct Packet pkt;
		if (!readAll(fd, &pkt, sizeof(pkt)) || pkt.magic != kMagic) {
			break;
		}
		if (pkt.type == PKT_BYE) {
			break;
		}
		if (pkt.type == PKT_PING) {
			/* 探针立刻原样回声，走 IO 线程，不经过模拟线程也不会被 SIO 阻塞影响。 */
			sendPacket(link, PKT_PONG, pkt.seq, 0, pkt.value);
			continue;
		}
		if (pkt.type == PKT_PONG) {
			pthread_mutex_lock(&link->mu);
			if (link->pingOut && pkt.seq == link->pingSeq) {
				/* 用对端回带的时间戳算，避免两边时钟不同步。 */
				int ms = (int) (nowMs() - pkt.value);
				uint32_t us = nowUs() - (uint32_t) pkt.value;
				link->pingOut = false;
				if (ms >= 0 && ms < 5000) {
					link->rttMs = link->rttMs > 0 ? (link->rttMs * 3 + ms) / 4 : ms;
				}
				if (us < 5000000u) {
					link->rttUs = link->rttUs ? (link->rttUs * 3 + us) / 4 : us;
					if (us > link->rttUsMax) {
						link->rttUsMax = us;
					}
					++link->rttUsN;
					if ((link->rttUsN % 4) == 0) {
						LINK_LOG("Link RTT avg=%uus max=%uus (last=%uus)",
						         link->rttUs, link->rttUsMax, us);
					}
				}
			}
			pthread_mutex_unlock(&link->mu);
			continue;
		}
		if (pkt.type == PKT_TICK) {
			pthread_mutex_lock(&link->mu);
			if (pkt.value > link->peerTick) {
				link->peerTick = pkt.value;
			}
			pthread_cond_broadcast(&link->cv);
			pthread_mutex_unlock(&link->mu);
			continue;
		}
		if (pkt.type == PKT_ACK) {
			pthread_mutex_lock(&link->mu);
			if (!link->hasAck || pkt.seq == link->waitSeq) {
				link->ackValue = pkt.value;
				link->ackSeq = pkt.seq;
				link->hasAck = true;
				pthread_cond_broadcast(&link->cv);
			}
			pthread_mutex_unlock(&link->mu);
			continue;
		}
		if (pkt.type == PKT_PUSH) {
			pthread_mutex_lock(&link->mu);
			if (link->peerCount == PEER_QUEUE) {
				/* 队列满了说明有一轮的推送永远收不到（对端多推/丢包），
				 * 丢掉最老的一条继续跑，至少别把整条链路卡死。 */
				link->peerHead = (link->peerHead + 1) % PEER_QUEUE;
				link->peerCount--;
				++link->peerDrops;
			}
			int slot = (link->peerHead + link->peerCount) % PEER_QUEUE;
			link->peerQ[slot].index = pkt.seq;
			link->peerQ[slot].mode = pkt.mode;
			link->peerQ[slot].value = pkt.value;
			link->peerQ[slot].cycles = pkt.cycles;
			link->peerQ[slot].stamp = nowMs();
			link->peerCount++;
			pthread_cond_broadcast(&link->cv);
			pthread_mutex_unlock(&link->mu);
			continue;
		}
		if (pkt.type == PKT_REQ) {
			/* 应答必须由 IO 线程立刻发出：模拟线程可能整帧都在等这个应答，
			 * 走模拟线程再回复会把一个网络往返放大成两帧的卡顿。 */
			uint32_t published = __atomic_load_n(&link->published, __ATOMIC_ACQUIRE);
			uint32_t publishedMode = __atomic_load_n(&link->publishedMode, __ATOMIC_ACQUIRE);
			sendPacket(link, PKT_ACK, pkt.seq, (uint16_t) publishedMode, published);
			/* GBA MULTI 模式只有 1P 会发起传输，从机（2P）的传输完成要靠这条
			 * 请求驱动，所以把它排给模拟线程去写 SIOMULTI/发中断。其余模式两
			 * 边各自会发起传输，排队反而会造成重复完成。 */
			if (pkt.mode == 2) {
				pthread_mutex_lock(&link->mu);
				enqueueReq(link, &pkt);
				if (link->reqDbg < 12) {
					++link->reqDbg;
					LINK_LOG("Link REQ #%d seq=%u mode=%u player=%u value=%04X q=%d",
					         link->reqDbg, pkt.seq, pkt.mode, pkt.player, pkt.value, link->qCount);
				}
				pthread_cond_broadcast(&link->cv);
				pthread_mutex_unlock(&link->mu);
			}
		}
	}
	pthread_mutex_lock(&link->mu);
	if (link->sock >= 0) {
		shutdown(link->sock, SHUT_RDWR);
		link_close(link->sock);
		link->sock = -1;
	}
	if (!link->stop) {
		link->state = link->listenFd >= 0 ? LINK_LISTEN : LINK_DOWN;
		setMessage(link, link->listenFd >= 0 ? "对方已断开，继续等待" : "对方已断开");
	}
	link->waiting = false;
	pthread_cond_broadcast(&link->cv);
	pthread_mutex_unlock(&link->mu);
	LINK_LOG("Link reader stopped");
	return NULL;
}

static bool startReader(struct NetLink* link) {
	if (link->threadLive) {
		return false;
	}
	int rc = pthread_create(&link->ioThread, NULL, readerMain, link);
	if (rc == 0 && !link->pingLive) {
		link->pingLive = true;
		pthread_create(&link->pingThread, NULL, pingMain, link);
	}
	link->threadLive = rc == 0;
	return link->threadLive;
}

/* 专用 ping 线程：RTT 探针不能挂在模拟线程上——模拟线程在联机传输时会
 * 阻塞等对端应答，探针会被一起拖住，测出来的就不是链路真实时延。 */
static void* pingMain(void* arg) {
	struct NetLink* link = (struct NetLink*) arg;
	while (!link->stop) {
		struct timespec sl;
		sl.tv_sec = 0;
		sl.tv_nsec = 250L * 1000000L;
		nanosleep(&sl, NULL);
		bool doSend = false;
		uint16_t probeSeq = 0;
		pthread_mutex_lock(&link->mu);
		if (link->state == LINK_CONNECTED && link->sock >= 0 && !link->pingOut) {
			probeSeq = ++link->pingSeq;
			link->pingOut = true;
			link->lastPingAt = nowMs();
			doSend = true;
		}
		pthread_mutex_unlock(&link->mu);
		if (doSend) {
			sendPacket(link, PKT_PING, probeSeq, 0, nowUs());
		}
	}
	return NULL;
}


static void* hostMain(void* arg) {
	struct NetLink* link = (struct NetLink*) arg;
	for (;;) {
		pthread_mutex_lock(&link->mu);
		int listenFd = link->listenFd;
		bool stop = link->stop;
		pthread_mutex_unlock(&link->mu);
		if (stop || listenFd < 0) {
			break;
		}
		int pr = waitReadable(listenFd, 200);
		pthread_mutex_lock(&link->mu);
		stop = link->stop;
		pthread_mutex_unlock(&link->mu);
		if (stop) {
			break;
		}
		if (pr <= 0) {
			continue;
		}
		int fd = accept(listenFd, NULL, NULL);
		if (fd < 0) {
			if (errno == EINTR) {
				continue;
			}
			break;
		}
		linkTune(fd);
		pthread_mutex_lock(&link->mu);
		link->sock = fd;
		link->player = 0;
		link->state = LINK_CONNECTED;
		link->localTick = 0;
		link->peerTick = 0;
		link->qHead = 0;
		link->qCount = 0;
		link->peerHead = 0;
		link->peerCount = 0;
		link->peerStale = 0;
		link->peerDrops = 0;
		setMessage(link, "已连接，你是 1P");
		pthread_mutex_unlock(&link->mu);
		LINK_LOG("Link client accepted");
		if (!link->pingLive) {
			link->pingLive = true;
			pthread_create(&link->pingThread, NULL, pingMain, link);
		}
		readerMain(link);
		if (link->stop) {
			break;
		}
		pthread_mutex_lock(&link->mu);
		if (link->listenFd >= 0 && link->state != LINK_OFF) {
			link->state = LINK_LISTEN;
			setMessage(link, "对方已断开，继续等待");
		}
		pthread_mutex_unlock(&link->mu);
	}
	return NULL;
}

static int openListen(int port) {
	int fd = socket(AF_INET, SOCK_STREAM, 0);
	if (fd < 0) {
		return -1;
	}
	int one = 1;
	setsockopt(fd, SOL_SOCKET, SO_REUSEADDR, (const char*) &one, sizeof(one));
	struct sockaddr_in addr;
	memset(&addr, 0, sizeof(addr));
	addr.sin_family = AF_INET;
	addr.sin_port = htons((uint16_t) port);
	addr.sin_addr.s_addr = htonl(INADDR_ANY);
	if (bind(fd, (struct sockaddr*) &addr, sizeof(addr)) < 0 || listen(fd, 1) < 0) {
		link_close(fd);
		return -1;
	}
	return fd;
}

struct NetLink* netLinkCreate(void) {
	linkSockInit();
	struct NetLink* link = (struct NetLink*) calloc(1, sizeof(struct NetLink));
	if (!link) {
		return NULL;
	}
	pthread_mutex_init(&link->mu, NULL);
	pthread_cond_init(&link->cv, NULL);
	pthread_mutex_init(&link->sendMu, NULL);
	link->listenFd = -1;
	link->sock = -1;
	link->player = 0;
	link->state = LINK_OFF;
	return link;
}

void netLinkClose(struct NetLink* link) {
	if (!link) {
		return;
	}
	pthread_mutex_lock(&link->mu);
	link->stop = true;
	int sock = link->sock;
	int listenFd = link->listenFd;
	link->sock = -1;
	link->listenFd = -1;
	link->waiting = false;
	pthread_cond_broadcast(&link->cv);
	pthread_mutex_unlock(&link->mu);
	if (sock >= 0) {
		struct Packet bye;
		memset(&bye, 0, sizeof(bye));
		bye.magic = kMagic;
		bye.type = PKT_BYE;
		pthread_mutex_lock(&link->sendMu);
		writeAll(sock, &bye, sizeof(bye));
		pthread_mutex_unlock(&link->sendMu);
		shutdown(sock, SHUT_RDWR);
		link_close(sock);
	}
	if (listenFd >= 0) {
		shutdown(listenFd, SHUT_RDWR);
		link_close(listenFd);
	}
	if (link->threadLive) {
		pthread_join(link->ioThread, NULL);
		link->threadLive = false;
	}
	pthread_mutex_lock(&link->mu);
	link->stop = false;
	link->state = LINK_OFF;
	link->qCount = 0;
	link->peerHead = 0;
	link->peerCount = 0;
	setMessage(link, "");
	pthread_mutex_unlock(&link->mu);
}

void netLinkDestroy(struct NetLink* link) {
	if (!link) {
		return;
	}
	netLinkClose(link);
	pthread_mutex_destroy(&link->mu);
	pthread_cond_destroy(&link->cv);
	pthread_mutex_destroy(&link->sendMu);
	free(link);
}

bool netLinkHost(struct NetLink* link, int port) {
	if (!link || port < 1 || port > 65535) {
		return false;
	}
	netLinkClose(link);
	int fd = openListen(port);
	if (fd < 0) {
		pthread_mutex_lock(&link->mu);
		link->state = LINK_DOWN;
		setMessage(link, "端口被占用");
		pthread_mutex_unlock(&link->mu);
		return false;
	}
	pthread_mutex_lock(&link->mu);
	link->listenFd = fd;
	link->port = port;
	link->player = 0;
	link->state = LINK_LISTEN;
	link->stop = false;
	setMessage(link, "等待对方加入");
	pthread_mutex_unlock(&link->mu);
	int rc = pthread_create(&link->ioThread, NULL, hostMain, link);
	if (rc != 0) {
		netLinkClose(link);
		return false;
	}
	link->threadLive = true;
	LINK_LOG("Link hosting on %d", port);
	return true;
}

bool netLinkJoin(struct NetLink* link, const char* host, int port) {
	if (!link || !host || port < 1 || port > 65535) {
		return false;
	}
	netLinkClose(link);
	struct sockaddr_in addr;
	memset(&addr, 0, sizeof(addr));
	addr.sin_family = AF_INET;
	addr.sin_port = htons((uint16_t) port);
	if (inet_pton(AF_INET, host, &addr.sin_addr) != 1) {
		pthread_mutex_lock(&link->mu);
		link->state = LINK_DOWN;
		setMessage(link, "IP 地址无效");
		pthread_mutex_unlock(&link->mu);
		return false;
	}
	int fd = connectTcp(&addr, 3000);
	if (fd < 0) {
		pthread_mutex_lock(&link->mu);
		link->state = LINK_DOWN;
		setMessage(link, "连不上对方");
		pthread_mutex_unlock(&link->mu);
		return false;
	}
	linkTune(fd);
	pthread_mutex_lock(&link->mu);
	link->sock = fd;
	link->player = 1;
	link->state = LINK_CONNECTED;
	link->localTick = 0;
	link->peerTick = 0;
	link->peerHead = 0;
	link->peerCount = 0;
	link->peerStale = 0;
	link->peerDrops = 0;
	link->stop = false;
	setMessage(link, "已连接，你是 2P");
	pthread_mutex_unlock(&link->mu);
	if (!startReader(link)) {
		netLinkClose(link);
		return false;
	}
	LINK_LOG("Link joined %s:%d", host, port);
	return true;
}

int netLinkState(struct NetLink* link) {
	if (!link) {
		return LINK_OFF;
	}
	pthread_mutex_lock(&link->mu);
	int state = link->state;
	pthread_mutex_unlock(&link->mu);
	return state;
}

int netLinkPlayer(struct NetLink* link) {
	if (!link) {
		return 0;
	}
	pthread_mutex_lock(&link->mu);
	int player = link->player;
	pthread_mutex_unlock(&link->mu);
	return player;
}

void netLinkStatusText(struct NetLink* link, char* out, size_t outLen) {
	if (!out || outLen == 0) {
		return;
	}
	out[0] = '\0';
	if (!link) {
		return;
	}
	pthread_mutex_lock(&link->mu);
	if (link->rttMs > 0) {
		snprintf(out, outLen, "%d %d %s · 延迟 %dms", link->state, link->player, link->message, link->rttMs);
	} else {
		snprintf(out, outLen, "%d %d %s", link->state, link->player, link->message);
	}
	pthread_mutex_unlock(&link->mu);
}

/* 持续 RTT 探针：由模拟线程高频调用，按 250ms 的节奏发一个 PING，
 * 回声在 IO 线程里算差值。GBA 联机的成败取决于「一轮往返能不能压进 1ms」，
 * 所以这个数必须一直有，不能只在建链阶段测一次。 */
void netLinkPingTick(struct NetLink* link) {
	if (!link) {
		return;
	}
	uint32_t now = nowMs();
	pthread_mutex_lock(&link->mu);
	if (link->state != LINK_CONNECTED || link->sock < 0) {
		pthread_mutex_unlock(&link->mu);
		return;
	}
	if (link->pingOut || (now - link->lastPingAt) < 250u) {
		pthread_mutex_unlock(&link->mu);
		return;
	}
	uint16_t probeSeq = ++link->pingSeq;
	link->pingOut = true;
	link->pingAt = now;
	link->lastPingAt = now;
	pthread_mutex_unlock(&link->mu);
	sendPacket(link, PKT_PING, probeSeq, 0, nowUs());
}

bool netLinkBarrier(struct NetLink* link, int timeoutMs) {
	if (!link) {
		return false;
	}
	pthread_mutex_lock(&link->mu);
	if (link->state != LINK_CONNECTED || link->sock < 0) {
		pthread_mutex_unlock(&link->mu);
		return false;
	}
	uint32_t mine = ++link->localTick;
	/* 每秒发一个探针量 RTT，联机状态栏直接显示，异地联机先看这个数。 */
	uint32_t now = nowMs();
	bool probe = !link->pingOut && (link->rttMs == 0 || now - link->lastPingAt >= 1000);
	uint16_t probeSeq = 0;
	if (probe) {
		probeSeq = ++link->pingSeq;
		link->pingOut = true;
		link->pingAt = now;
		link->lastPingAt = now;
	}	pthread_mutex_unlock(&link->mu);
	if (probe) {
		sendPacket(link, PKT_PING, probeSeq, 0, nowUs());
	}
	if (!sendPacket(link, PKT_TICK, (uint16_t) mine, 0, mine)) {
		return false;
	}
	struct timespec ts;
	deadline(&ts, timeoutMs);
	pthread_mutex_lock(&link->mu);
	while (link->peerTick < mine && link->state == LINK_CONNECTED && !link->stop) {
		if (pthread_cond_timedwait(&link->cv, &link->mu, &ts) == ETIMEDOUT) {
			break;
		}
	}
	bool ok = link->peerTick >= mine && link->state == LINK_CONNECTED;
	pthread_mutex_unlock(&link->mu);
	return ok;
}

bool netLinkExchange(struct NetLink* link, uint16_t mode, uint32_t local, uint32_t* remoteOut, int timeoutMs) {
	if (remoteOut) {
		*remoteOut = 0xFFFFFFFFu;
	}
	if (!link) {
		return false;
	}
	pthread_mutex_lock(&link->mu);
	if (link->state != LINK_CONNECTED || link->sock < 0) {
		pthread_mutex_unlock(&link->mu);
		return false;
	}
	__atomic_store_n(&link->published, local, __ATOMIC_RELEASE);
	uint32_t startedAt = nowMs();
	(void) startedAt;
	uint16_t seq = ++link->nextSeq;
	link->waiting = true;
	link->waitSeq = seq;
	link->hasAck = false;
	pthread_mutex_unlock(&link->mu);
	if (!sendPacket(link, PKT_REQ, seq, mode, local)) {
		pthread_mutex_lock(&link->mu);
		link->waiting = false;
		pthread_mutex_unlock(&link->mu);
		return false;
	}
	struct timespec ts;
	deadline(&ts, timeoutMs);
	pthread_mutex_lock(&link->mu);
	while (!link->hasAck && link->state == LINK_CONNECTED && !link->stop) {
		if (pthread_cond_timedwait(&link->cv, &link->mu, &ts) == ETIMEDOUT) {
			break;
		}
	}
	bool ok = link->hasAck;
	uint32_t value = link->ackValue;
	link->waiting = false;
	pthread_mutex_unlock(&link->mu);
	LINK_VERBOSE("exchange mode=%u seq=%u ok=%d ms=%u", mode, seq, ok, nowMs() - startedAt);
	if (ok && remoteOut) {
		*remoteOut = value;
	}
	return ok;
}

bool netLinkTakeRequest(struct NetLink* link, uint16_t* seq, uint16_t* mode, uint32_t* value, int* player) {
	if (!link) {
		return false;
	}
	pthread_mutex_lock(&link->mu);
	if (link->qCount <= 0) {
		pthread_mutex_unlock(&link->mu);
		return false;
	}
	struct Req req = link->queue[link->qHead];
	link->qHead = (link->qHead + 1) % REQ_QUEUE;
	link->qCount--;
	pthread_mutex_unlock(&link->mu);
	LINK_VERBOSE("req seq=%u qdelay=%ums", req.seq, nowMs() - req.stamp);
	if (seq) {
		*seq = req.seq;
	}
	if (mode) {
		*mode = req.mode;
	}
	if (value) {
		*value = req.value;
	}
	if (player) {
		*player = req.player;
	}
	return true;
}

void netLinkReply(struct NetLink* link, uint16_t seq, uint16_t mode, uint32_t value) {
	if (!link) {
		return;
	}
	__atomic_store_n(&link->published, value, __ATOMIC_RELEASE);
	sendPacket(link, PKT_ACK, seq, mode, value);
}

void netLinkPublish(struct NetLink* link, uint16_t mode, uint32_t value) {
	if (!link) {
		return;
	}
	__atomic_store_n(&link->published, value, __ATOMIC_RELEASE);
	__atomic_store_n(&link->publishedMode, mode, __ATOMIC_RELEASE);
}

void netLinkPush(struct NetLink* link, uint16_t mode, uint32_t local, uint16_t index, uint32_t cycles) {
	if (!link) {
		return;
	}
	__atomic_store_n(&link->published, local, __ATOMIC_RELEASE);
	__atomic_store_n(&link->publishedMode, mode, __ATOMIC_RELEASE);
	/* 模拟时钟戳随这一轮一起发给对端（只对 PKT_PUSH 有意义）。 */
	__atomic_store_n(&link->pushCycles, cycles, __ATOMIC_RELEASE);
	sendPacket(link, PKT_PUSH, index, mode, local);
}

/* 从队列里取对端的一个字。
 *
 * strict = true  —— 严格按轮次号匹配（主机用）。比 want 老的推送当过期丢掉。
 * strict = false —— 宽松模式（从机用）：不比 want，只要求轮次号比 minIndex 新
 *                   （即本机还没消费过的那一轮）。这样启动阶段堆积的旧推送会被
 *                   跳过，不会把从机拖慢一格；取到的轮次号由主机决定，从机直接
 *                   跟随。 */
static bool takePeerWord(struct NetLink* link, uint16_t want, bool strict, uint16_t minIndex, int timeoutMs, uint32_t* value, uint16_t* indexOut, uint32_t* cyclesOut) {
	if (!link) {
		return false;
	}
	bool ok = false;
	pthread_mutex_lock(&link->mu);
	uint32_t expireAt = nowMs() + (uint32_t) (timeoutMs > 0 ? timeoutMs : 0);
	for (;;) {
		while (link->peerCount > 0) {
			struct PeerWord w = link->peerQ[link->peerHead];
			link->peerHead = (link->peerHead + 1) % PEER_QUEUE;
			link->peerCount--;
			if (strict) {
				if ((int16_t) (w.index - want) < 0) {
					/* 比本轮还老的推送：本机早就超时收尾过了，丢掉，
					 * 否则后面的每一轮都会被这条拖慢一格。 */
					++link->peerStale;
					continue;
				}
			} else if ((int16_t) (w.index - minIndex) <= 0) {
				/* 已经消费过的轮次（含启动阶段堆积的旧推送）。丢掉，
				 * 从机只跟随主机给的、还没见过的轮次。 */
				++link->peerStale;
				continue;
			}
			if (value) {
				*value = w.value;
			}
			if (indexOut) {
				*indexOut = w.index;
			}
			if (cyclesOut) {
				*cyclesOut = w.cycles;
			}
			link->lastPeerStamp = w.stamp;
			ok = true;
			break;
		}
		if (ok || timeoutMs <= 0) {
			break;
		}
		if (link->state != LINK_CONNECTED || link->stop) {
			break;
		}
		uint32_t now = nowMs();
		if ((int32_t) (expireAt - now) <= 0) {
			break;
		}
		struct timespec ts;
		deadline(&ts, 20);
		pthread_cond_timedwait(&link->cv, &link->mu, &ts);
	}
	pthread_mutex_unlock(&link->mu);
	return ok;
}

bool netLinkTakePeerWord(struct NetLink* link, uint16_t want, int timeoutMs, uint32_t* value, uint16_t* indexOut, uint32_t* cyclesOut) {
	return takePeerWord(link, want, true, want, timeoutMs, value, indexOut, cyclesOut);
}

bool netLinkTakePeerWordAny(struct NetLink* link, uint16_t minIndex, int timeoutMs, uint32_t* value, uint16_t* indexOut, uint32_t* cyclesOut) {
	return takePeerWord(link, 0, false, minIndex, timeoutMs, value, indexOut, cyclesOut);
}

/* 对端队列里现在有几个字（只看不取）。
 *
 * 从机靠它判断「主机是不是已经在推字了」：只有主机真的推了字，从机才需要
 * 挂上自己的轮次事件。没联机时主机一个字都不推，从机就完全不用挂上 ——
 * 这正是把从机的模拟帧率从 1.4fps 救回 60fps 的关键。 */
int netLinkPeerPending(struct NetLink* link) {
	if (!link) {
		return 0;
	}
	pthread_mutex_lock(&link->mu);
	int n = link->peerCount;
	pthread_mutex_unlock(&link->mu);
	return n;
}

void netLinkPeerStats(struct NetLink* link, uint32_t* stale, uint32_t* drops) {
	if (stale) {
		*stale = 0;
	}
	if (drops) {
		*drops = 0;
	}
	if (!link) {
		return;
	}
	pthread_mutex_lock(&link->mu);
	if (stale) {
		*stale = link->peerStale;
	}
	if (drops) {
		*drops = link->peerDrops;
	}
	pthread_mutex_unlock(&link->mu);
}

/* 上一条取走的对端字在队列里待了多久（真实毫秒）。
 * 联机「等太久」的问题定位就靠它：时延大说明模拟线程没有及时把队列里的
 * 字取走（对端反应慢），时延小但主机仍然等很久则是网络或索引对不上。 */
uint32_t netLinkPeerAge(struct NetLink* link) {
	if (!link) {
		return 0;
	}
	pthread_mutex_lock(&link->mu);
	uint32_t stamp = link->lastPeerStamp;
	pthread_mutex_unlock(&link->mu);
	if (!stamp) {
		return 0;
	}
	uint32_t now = nowMs();
	return now >= stamp ? now - stamp : 0;
}

bool netLinkRequest(struct NetLink* link, uint16_t mode, uint32_t local, uint16_t* seqOut) {
	if (!link) {
		return false;
	}
	pthread_mutex_lock(&link->mu);
	if (link->state != LINK_CONNECTED || link->sock < 0) {
		pthread_mutex_unlock(&link->mu);
		return false;
	}
	__atomic_store_n(&link->published, local, __ATOMIC_RELEASE);
	__atomic_store_n(&link->publishedMode, mode, __ATOMIC_RELEASE);
	uint16_t seq = ++link->nextSeq;
	link->waitSeq = seq;
	link->hasAck = false;
	pthread_mutex_unlock(&link->mu);
	if (!sendPacket(link, PKT_REQ, seq, mode, local)) {
		return false;
	}
	if (seqOut) {
		*seqOut = seq;
	}
	return true;
}

bool netLinkTakeReply(struct NetLink* link, uint16_t seq, uint32_t* remoteOut) {
	if (!link) {
		return false;
	}
	bool ok = false;
	pthread_mutex_lock(&link->mu);
	if (link->hasAck && link->ackSeq == seq && link->state == LINK_CONNECTED) {
		if (remoteOut) {
			*remoteOut = link->ackValue;
		}
		link->hasAck = false;
		ok = true;
	}
	pthread_mutex_unlock(&link->mu);
	return ok;
}
