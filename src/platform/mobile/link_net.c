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
#include <stdarg.h>
/* 桌面端过去把 LINK_LOG 编译成空操作，PC 侧链路完全是黑盒：联机失败时
 * 看不到「读线程有没有起来 / 有没有收到 PUSH / 字节流有没有错位」。
 * 现在改成写文件，FILE* 只打开一次（每条日志都 fopen 会重演 11-07
 * 那次 0.7fps 事故）。路径由 MGBAX_LINK_LOG 指定，未设置时保持静默。 */
static FILE* s_linkLogFile;
static pthread_once_t s_linkLogOnce = PTHREAD_ONCE_INIT;
static void linkLogOpen(void) {
	const char* path = getenv("MGBAX_LINK_LOG");
	if (path && *path) {
		s_linkLogFile = fopen(path, "a");
	}
}
static void linkLogPrintf(const char* fmt, ...) {
	pthread_once(&s_linkLogOnce, linkLogOpen);
	if (!s_linkLogFile) {
		return;
	}
	va_list ap;
	va_start(ap, fmt);
	vfprintf(s_linkLogFile, fmt, ap);
	va_end(ap);
	fputc('\n', s_linkLogFile);
	fflush(s_linkLogFile);
}
#define LINK_LOG(...) linkLogPrintf(__VA_ARGS__)
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

/* 总线要同时盯 listen fd 和最多 3 个从机 fd。select 在 Windows 和 POSIX 上
 * 语义一致（poll 只有 POSIX 有），所以这里统一用 select。
 * 返回可读 fd 在数组里的下标；超时 -1，出错 -2。 */
#ifdef _WIN32
#define LINK_FD(f) ((SOCKET) (f))
#else
#define LINK_FD(f) (f)
#endif

static int waitAnyReadable(const int* fds, int n, int timeoutMs) {
	fd_set set;
	struct timeval tv;
	int maxFd = -1;
	FD_ZERO(&set);
	for (int i = 0; i < n; ++i) {
		if (fds[i] < 0) {
			continue;
		}
		FD_SET(LINK_FD(fds[i]), &set);
		if (fds[i] > maxFd) {
			maxFd = fds[i];
		}
	}
	if (maxFd < 0) {
		return -1;
	}
	tv.tv_sec = timeoutMs / 1000;
	tv.tv_usec = (timeoutMs % 1000) * 1000;
#ifdef _WIN32
	int rc = select(0, &set, NULL, NULL, &tv);
#else
	int rc = select(maxFd + 1, &set, NULL, NULL, &tv);
#endif
	if (rc == 0) {
		return -1;
	}
	if (rc < 0) {
		return errno == EINTR ? -1 : -2;
	}
	for (int i = 0; i < n; ++i) {
		if (fds[i] >= 0 && FD_ISSET(LINK_FD(fds[i]), &set)) {
			return i;
		}
	}
	return -1;
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
	PKT_PONG = 7,
	/* 总线（3/4 人）专用包，固定长度、不做可变长帧。 */
	PKT_BUS_WELCOME = 8,
	PKT_BUS_ROUND = 9
};

/* GBA 的 MULTI 最多 4 台。 */
enum { BUS_MAX_PLAYERS = 4 };

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

/* 总线连接的**唯一种**包格式：定长、按槽位带四个字。
 *
 * 总线链路上不混用 struct Packet —— 两种包长度不同，混在一起就必须做变长
 * 分帧；而总线是同一份代码的两端互连，直接统一成一种定长包最省事，也不会
 * 出现「把 PING 当 ROUND 解」这类错位。 */
struct BusPacket {
	uint32_t magic;
	uint16_t type;
	uint16_t slot;      /* 发送者槽位：0 = 主机，1..3 = 从机 */
	uint16_t index;     /* 轮次号（主机是链路的时钟源） */
	uint16_t players;   /* 玩家总数（WELCOME / ROUND 有效） */
	uint16_t word[BUS_MAX_PLAYERS];  /* ROUND：按槽位的四个字 */
	uint32_t cycles;    /* 发送方的模拟时钟戳 */
	uint32_t stamp;     /* PING 用：发送时刻（µs） */
};

struct BusPeer {
	int fd;
	int slot;
	/* 该从机最近一次推上来的字（主机侧）。valid 只在 index 命中时才算数。 */
	uint16_t index;
	uint32_t value;
	uint32_t cycles;
	bool valid;
	uint32_t stamp;
	/* 非阻塞读的半个包缓冲区：TCP 上来的可能是半个 BusPacket，先攒着。 */
	unsigned char rx[sizeof(struct BusPacket) * 2];
	size_t rxLen;
};

struct LocalBus;
static void localBusDetach(struct LocalBus* lb, bool host, int slot);

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
	/* 对端最近一次 PUSH 到达的真实时刻（nowMs）：从机用它判断「交换正在进行」
	 * （主控的轮次在密集到达），只有此时才允许阻塞等下一个字。 */
	uint32_t pushSeenAt;

	/* ---- 3/4 人总线（星型汇聚） ---------------------------------------- */
	bool bus;
	bool busHost;                /* 本机是主机（listen 端） */
	int busPlayers;              /* 目标玩家数（含本机）；2 表示走原来的直连 */
	struct BusPeer busPeers[BUS_MAX_PLAYERS - 1];
	int busPeerCount;
	/* 主机本轮自己的字：在传输开始时由 netLinkPush 记下，收齐从机的字之后
	 * 一起广播出去。 */
	uint16_t busOwnIndex;
	uint32_t busOwn;
	bool busOwnValid;
	/* 本机最后一次见到的「主机轮次号」：主机侧是它自己推的，从机侧是收到
	 * 的主机推送/广播。从机用它对齐轮次，避免刚加入时用 0 号推上去。 */
	uint16_t busHostIndex;
	bool busHostIndexValid;
	/* 从机侧：主机最近一次广播的内容与未消费次数。 */
	uint32_t busInWord[BUS_MAX_PLAYERS];
	uint16_t busInIndex;
	uint16_t busInPlayers;
	bool busInValid;
	int busInPending;
	/* 主机广播里带的模拟时钟戳：从机靠它对齐自己每帧的轮次数（与两人直连
	 * 路径用 PUSH.cycles 做的事完全一样）。 */
	uint32_t busInCycles;
	/* 轮次对齐诊断（只读，锁内累加、不打日志）：量出主机期望轮次与从机
	 * 实际 PUSH 轮次的偏差分布，判断「收不齐字」是索引错配还是真的迟到。 */
	int32_t busDiagRounds;
	int32_t busDiagFull;
	int32_t busDiagEmpty;
	int32_t busDiagStalePush;
	int32_t busDiagFuturePush;
	int32_t busDiagMinLead;
	int32_t busDiagMaxLead;
	/* 从机侧只有一条连接，半个包的缓冲区挂在链路上。 */
	unsigned char busRx[sizeof(struct BusPacket) * 2];
	size_t busRxLen;
	/* 进程内总线：同进程 N 个 NetLink 共享一块内存做回合栅栏，不碰 socket。
	 * 非空时 netLinkBusRound 走 busRoundLocal，TCP 那一整套（IO 线程/收发/
	 * 心跳）都不启动。 */
	struct LocalBus* localBus;
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

/* 总线包发送：所有总线写都走 sendMu，模拟线程（广播 ROUND）和 I/O 线程
 * （回 PONG）不会把同一个 fd 的字节写乱。 */
static bool busSend(struct NetLink* link, int fd, struct BusPacket* pkt) {
	if (fd < 0) {
		return false;
	}
	pthread_mutex_lock(&link->sendMu);
	bool ok = writeAll(fd, pkt, sizeof(*pkt));
	pthread_mutex_unlock(&link->sendMu);
	return ok;
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
	unsigned packets = 0;
	unsigned pushes = 0;
	unsigned resyncs = 0;
	int fd;
	pthread_mutex_lock(&link->mu);
	fd = link->sock;
	pthread_mutex_unlock(&link->mu);
	LINK_LOG("Link reader started fd=%d", fd);
	while (!link->stop && fd >= 0) {
		struct Packet pkt;
		if (!readAll(fd, &pkt, sizeof(pkt))) {
			break;
		}
		if (pkt.magic != kMagic) {
			/* 隧道上除了 20 字节联机包，还夹着服务端/对端的控制帧（实测每帧
			 * 10 字节、以 00 00 00 06 开头）。旧实现有两个坑：
			 *   ① 在 20 字节窗口里找不到魔数就整窗丢弃 —— 10 字节控制帧会
			 *      让边界每轮漂移 10，漂移量与 20 不互质，越丢越远；
			 *   ② resync 超过 64 次就 break，读线程自杀。游戏还没开始联机
			 *      时控制帧就能把它耗光，于是真正要联机时对端队列恒空
			 *      （现场 packets=0 / resync=65，gLink 停在 lstate=1）。
			 * 改成真正的字节流重同步：保留窗口末尾 3 字节（魔数只有 4 字节，
			 * 跨窗一定会被拼回来），再补读 17 字节重新扫描，永不因脏字节退出。 */
			unsigned char win[sizeof(struct Packet)];
			memcpy(win, &pkt, sizeof(pkt));
			int shift = -1;
			bool truncated = false;
			for (;;) {
				for (size_t i = 0; i + sizeof(uint32_t) <= sizeof(win); ++i) {
					uint32_t magic;
					memcpy(&magic, win + i, sizeof(magic));
					if (magic == kMagic) {
						shift = (int) i;
						break;
					}
				}
				if (shift >= 0) {
					break;
				}
				/* 丢掉已确认无魔数的前 17 字节，保留末尾 3 字节跨窗续接 */
				memmove(win, win + sizeof(win) - 3, 3);
				if (!readAll(fd, win + 3, sizeof(win) - 3)) {
					truncated = true;
					break;
				}
				if (++resyncs == 1 || (resyncs % 5000) == 0) {
					LINK_LOG("Link reader stray windows=%u (still scanning for MBL1)",
					         resyncs);
				}
			}
			if (truncated) {
				break;
			}
			size_t have = sizeof(win) - (size_t) shift;
			memmove(win, win + shift, have);
			if (!readAll(fd, win + have, sizeof(win) - have)) {
				break;
			}
			memcpy(&pkt, win, sizeof(pkt));
			++resyncs;
			LINK_LOG("Link reader resynced after %d stray bytes", shift);
		}
		++packets;
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
			++pushes;
			if (pushes <= 12 || (pushes % 100) == 0) {
				LINK_LOG("Link PUSH #%u seq=%u mode=%u value=%04X",
				         pushes, (unsigned) pkt.seq, (unsigned) pkt.mode,
				         (unsigned) pkt.value);
			}
			pthread_mutex_lock(&link->mu);
			link->pushSeenAt = nowMs();
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
	LINK_LOG("Link reader stopped: packets=%u pushes=%u resync=%u",
	         packets, pushes, resyncs);
	return NULL;
}

static bool startReader(struct NetLink* link) {
	if (link->threadLive) {
		return false;
	}
	int rc = pthread_create(&link->ioThread, NULL, readerMain, link);
	if (rc == 0 && !link->pingLive) {
		if (pthread_create(&link->pingThread, NULL, pingMain, link) == 0) {
			link->pingLive = true;
		}
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
		if (!link->pingLive && pthread_create(&link->pingThread, NULL, pingMain, link) == 0) {
			link->pingLive = true;
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

/* ---- 总线（3/4 人）I/O ---------------------------------------------------
 *
 * 这里的线程约定和原来的直连路径不同，刻意写清楚：
 *   - busPeers[] 只由**主机 I/O 线程**增删（accept / 掉线），所以它在别处
 *     只读；读写都先拿 link->mu。
 *   - 每个 Peer 的半个包缓冲区 rx/rxLen 只由 I/O 线程碰，不需要锁。
 *   - 广播 ROUND 由模拟线程发，PONG 由 I/O 线程回，两者都走 sendMu。
 */

/* 读一次（调用前 select 已确认可读）。返回 1 读到数据，0 对端关闭，-1 需要丢弃连接。 */
static int busReadSome(int fd, unsigned char* rx, size_t* rxLen) {
	size_t cap = sizeof(struct BusPacket) * 2;
	if (*rxLen >= cap) {
		return -1;
	}
	ssize_t n = recv(fd, (char*) rx + *rxLen, (int) (cap - *rxLen), 0);
	if (n == 0) {
		return 0;
	}
	if (n < 0) {
		return errno == EINTR ? 1 : -1;
	}
	*rxLen += (size_t) n;
	return 1;
}

static void busDropPeer(struct NetLink* link, int index) {
	int fd = -1;
	pthread_mutex_lock(&link->mu);
	if (index >= 0 && index < link->busPeerCount) {
		fd = link->busPeers[index].fd;
		for (int i = index; i + 1 < link->busPeerCount; ++i) {
			link->busPeers[i] = link->busPeers[i + 1];
		}
		--link->busPeerCount;
		memset(&link->busPeers[link->busPeerCount], 0, sizeof(link->busPeers[0]));
		link->busPeers[link->busPeerCount].fd = -1;
		if (link->busPeerCount == 0 && !link->stop) {
			link->state = link->listenFd >= 0 ? LINK_LISTEN : LINK_DOWN;
			setMessage(link, link->listenFd >= 0 ? "从机全部断开，继续等待" : "从机已断开");
		} else if (link->busPeerCount > 0) {
			setMessage(link, "有玩家断开");
		}
	}
	pthread_cond_broadcast(&link->cv);
	pthread_mutex_unlock(&link->mu);
	if (fd >= 0) {
		shutdown(fd, SHUT_RDWR);
		link_close(fd);
	}
	LINK_LOG("Link bus peer %d dropped (left=%d)", index, link->busPeerCount);
}

static void busSendPong(struct NetLink* link, int fd, const struct BusPacket* pkt, uint16_t slot) {
	struct BusPacket pong;
	memset(&pong, 0, sizeof(pong));
	pong.magic = kMagic;
	pong.type = PKT_PONG;
	pong.slot = slot;
	pong.stamp = pkt->stamp;   /* 原样带回发送时刻，接收方据此算真实 RTT */
	busSend(link, fd, &pong);
}

static void busNoteRtt(struct NetLink* link, const struct BusPacket* pkt) {
	uint32_t us = nowUs() - pkt->stamp;
	if (us > 5000000u) {
		return;
	}
	pthread_mutex_lock(&link->mu);
	int ms = (int) (us / 1000u);
	if (ms >= 0 && ms < 5000) {
		link->rttMs = link->rttMs > 0 ? (link->rttMs * 3 + ms) / 4 : ms;
	}
	link->rttUs = link->rttUs ? (link->rttUs * 3 + us) / 4 : us;
	if (us > link->rttUsMax) {
		link->rttUsMax = us;
	}
	if (((++link->rttUsN) % 8) == 0) {
		LINK_LOG("Link bus RTT avg=%uus max=%uus (last=%uus)", link->rttUs, link->rttUsMax, us);
	}
	pthread_mutex_unlock(&link->mu);
}

/* 处理一个总线包。peer 非空表示这是主机侧从某个从机收到的；为空表示从机侧
 * 从唯一那条到主机的连接上收到的。返回 false 表示这条连接该关了。 */
static bool busDispatch(struct NetLink* link, struct BusPeer* peer, int fd,
                        const struct BusPacket* pkt) {
	if (pkt->type == PKT_PING) {
		busSendPong(link, fd, pkt, (uint16_t) (peer ? peer->slot : link->player));
		return true;
	}
	if (pkt->type == PKT_PONG) {
		busNoteRtt(link, pkt);
		return true;
	}
	if (pkt->type == PKT_BYE) {
		return false;
	}
	if (!peer) {
		/* 从机侧。 */
		switch (pkt->type) {
		case PKT_BUS_WELCOME:
			pthread_mutex_lock(&link->mu);
			link->player = pkt->slot;
			if (pkt->players >= 2 && pkt->players <= BUS_MAX_PLAYERS) {
				link->busPlayers = pkt->players;
			}
			link->state = LINK_CONNECTED;
			setMessage(link, "已连接，等待主机开始");
			pthread_cond_broadcast(&link->cv);
			pthread_mutex_unlock(&link->mu);
			LINK_LOG("Link bus welcome slot=%u players=%u", (unsigned) pkt->slot, (unsigned) pkt->players);
			return true;
		case PKT_PUSH:
			/* 主机本轮自己的字（顺带把轮次号带过来给从机对齐）。 */
			pthread_mutex_lock(&link->mu);
			link->busHostIndex = pkt->index;
			link->busHostIndexValid = true;
			link->pushSeenAt = nowMs();
			pthread_cond_broadcast(&link->cv);
			pthread_mutex_unlock(&link->mu);
			return true;
		case PKT_BUS_ROUND:
			pthread_mutex_lock(&link->mu);
			for (int i = 0; i < BUS_MAX_PLAYERS; ++i) {
				link->busInWord[i] = pkt->word[i];
			}
			link->busInIndex = pkt->index;
			link->busInPlayers = pkt->players;
			link->busInCycles = pkt->cycles;
			link->busInValid = true;
			link->busInPending = 1;
			link->busHostIndex = pkt->index;
			link->busHostIndexValid = true;
			link->pushSeenAt = nowMs();
			pthread_cond_broadcast(&link->cv);
			pthread_mutex_unlock(&link->mu);
			return true;
		default:
			return true;
		}
	}
	/* 主机侧。 */
	if (pkt->type == PKT_PUSH) {
		pthread_mutex_lock(&link->mu);
		peer->index = pkt->index;
		peer->value = pkt->word[0];
		peer->cycles = pkt->cycles;
		peer->valid = true;
		peer->stamp = nowMs();
		link->busHostIndex = pkt->index;
		link->busHostIndexValid = true;
		link->pushSeenAt = peer->stamp;
		pthread_cond_broadcast(&link->cv);
		pthread_mutex_unlock(&link->mu);
		LINK_VERBOSE("bus push slot=%d index=%u value=%04X", peer->slot,
		             (unsigned) pkt->index, (unsigned) pkt->word[0]);
	}
	return true;
}

/* 解析缓冲区里所有完整的包。返回 false 表示这条连接该关了。 */
static bool busDrain(struct NetLink* link, struct BusPeer* peer, int fd,
                     unsigned char* rx, size_t* rxLen) {
	size_t off = 0;
	bool keep = true;
	while (*rxLen - off >= sizeof(struct BusPacket)) {
		struct BusPacket pkt;
		memcpy(&pkt, rx + off, sizeof(pkt));
		off += sizeof(pkt);
		if (pkt.magic != kMagic) {
			LINK_LOG("Link bus bad magic=%08X slot=%d", (unsigned) pkt.magic, peer ? peer->slot : -1);
			keep = false;
			break;
		}
		if (!busDispatch(link, peer, fd, &pkt)) {
			keep = false;
			break;
		}
	}
	if (off > 0) {
		memmove(rx, rx + off, *rxLen - off);
		*rxLen -= off;
	}
	return keep;
}

static void busHostLoop(struct NetLink* link) {
	LINK_LOG("Link bus host loop started, players=%d", link->busPlayers);
	for (;;) {
		int fds[BUS_MAX_PLAYERS];
		int kind[BUS_MAX_PLAYERS];
		int n = 0;
		pthread_mutex_lock(&link->mu);
		bool stop = link->stop;
		int listenFd = link->listenFd;
		fds[n] = listenFd;
		kind[n] = -1;
		++n;
		for (int i = 0; i < link->busPeerCount; ++i) {
			fds[n] = link->busPeers[i].fd;
			kind[n] = i;
			++n;
		}
		pthread_mutex_unlock(&link->mu);
		if (stop || listenFd < 0) {
			break;
		}
		int idx = waitAnyReadable(fds, n, 100);
		if (idx < 0 || idx >= n) {
			continue;
		}
		if (kind[idx] < 0) {
			int fd = accept(listenFd, NULL, NULL);
			if (fd < 0) {
				continue;
			}
			linkTune(fd);
			pthread_mutex_lock(&link->mu);
			if (link->busPeerCount >= link->busPlayers - 1 || link->busPeerCount >= BUS_MAX_PLAYERS - 1) {
				/* 房间满了：直接关掉，不让第 5 台挤进来。 */
				pthread_mutex_unlock(&link->mu);
				shutdown(fd, SHUT_RDWR);
				link_close(fd);
				LINK_LOG("Link bus reject: room full");
				continue;
			}
			/* 槽位取**最小的空闲号**（1..3），不能用单调递增的计数器：
			 * 4 人房里 2 号位掉线后重连时，单调递增会分配出 4 号槽 —— 而
			 * 槽位只认 0..3，4 号会被 netLinkBusRound 的边界判断静默忽略，
			 * 新连上的玩家永远收不到数据、也永远不会被报错。
			 *
			 * 先算出空号再决定是否接受：三个槽都占着就把连接挡回去，
			 * 不能先进数组再发现没号可用。 */
			int freeSlot = 0;
			for (int s = 1; s < BUS_MAX_PLAYERS && !freeSlot; ++s) {
				bool used = false;
				for (int i = 0; i < link->busPeerCount; ++i) {
					if (link->busPeers[i].slot == s) {
						used = true;
						break;
					}
				}
				if (!used) {
					freeSlot = s;
				}
			}
			if (!freeSlot) {
				pthread_mutex_unlock(&link->mu);
				shutdown(fd, SHUT_RDWR);
				link_close(fd);
				LINK_LOG("Link bus reject: no free slot");
				continue;
			}
			struct BusPeer* p = &link->busPeers[link->busPeerCount];
			memset(p, 0, sizeof(*p));
			p->fd = fd;
			p->slot = freeSlot;
			++link->busPeerCount;
			link->state = LINK_CONNECTED;
			uint16_t slot = (uint16_t) p->slot;
			uint16_t players = (uint16_t) link->busPlayers;
			int nowPlayers = link->busPeerCount + 1;
			char msg[64];
			snprintf(msg, sizeof(msg), "已连接 %d 人", nowPlayers);
			setMessage(link, msg);
			pthread_cond_broadcast(&link->cv);
			pthread_mutex_unlock(&link->mu);
			struct BusPacket welcome;
			memset(&welcome, 0, sizeof(welcome));
			welcome.magic = kMagic;
			welcome.type = PKT_BUS_WELCOME;
			welcome.slot = slot;
			welcome.players = players;
			busSend(link, fd, &welcome);
			LINK_LOG("Link bus accepted fd=%d slot=%u players=%d", fd, (unsigned) slot, nowPlayers);
			continue;
		}
		/* 某个从机可读。只有本线程碰 rx/rxLen，见上面的线程约定。 */
		struct BusPeer* p = &link->busPeers[kind[idx]];
		int fd = p->fd;
		if (fd < 0) {
			continue;
		}
		int rr = busReadSome(fd, p->rx, &p->rxLen);
		if (rr <= 0) {
			LINK_LOG("Link bus host read ended rr=%d errno=%d slot=%d", rr, errno, p->slot);
			busDropPeer(link, kind[idx]);
			continue;
		}
		if (!busDrain(link, p, fd, p->rx, &p->rxLen)) {
			busDropPeer(link, kind[idx]);
		}
	}
	LINK_LOG("Link bus host loop stopped");
}

/* 总线心跳：两人路径有 250ms 的周期 PING，总线的链路上在游戏开始交换之前
 * 是**完全空闲**的 —— 而这段空闲正好出现在「大家进了房间在等人」的时候。
 * 家用路由的 NAT 映射 30~120 秒就会过期，之后任何一端先发包都会被丢掉，
 * 表现为「人连上了但怎么都开不了局」。每秒一个 PING 把映射钉住，顺带把
 * RTT 测出来给状态栏用（`netLinkStatusText` 显示的就是它）。
 *
 * 用 200ms 的短睡眠分片，而不是 sleep(1)：`netLinkClose` 之后没有等这个
 * 线程退出，分片睡眠让它最多 200ms 就跟上 stop 标记。 */
static void* busPingMain(void* arg) {
	struct NetLink* link = (struct NetLink*) arg;
	unsigned tick = 0;
	while (!link->stop) {
		struct timespec sl;
		sl.tv_sec = 0;
		sl.tv_nsec = 200L * 1000000L;
		nanosleep(&sl, NULL);
		if (link->stop) {
			break;
		}
		if ((tick++ % 5) != 0) {
			continue;   /* 每 5 个分片（约 1 秒）发一次 */
		}
		int fds[BUS_MAX_PLAYERS - 1];
		int n = 0;
		uint16_t slot = 0;
		pthread_mutex_lock(&link->mu);
		if (link->state == LINK_CONNECTED) {
			slot = (uint16_t) link->player;
			if (link->busHost) {
				for (int i = 0; i < link->busPeerCount && n < BUS_MAX_PLAYERS - 1; ++i) {
					fds[n++] = link->busPeers[i].fd;
				}
			} else if (link->sock >= 0) {
				fds[n++] = link->sock;
			}
		}
		pthread_mutex_unlock(&link->mu);
		if (n == 0) {
			continue;
		}
		struct BusPacket ping;
		memset(&ping, 0, sizeof(ping));
		ping.magic = kMagic;
		ping.type = PKT_PING;
		ping.slot = slot;
		ping.stamp = nowUs();
		for (int i = 0; i < n; ++i) {
			busSend(link, fds[i], &ping);
		}
	}
	return NULL;
}

static void busJoinLoop(struct NetLink* link) {
	LINK_LOG("Link bus join loop started fd=%d", link->sock);
	for (;;) {
		int fd;
		pthread_mutex_lock(&link->mu);
		fd = link->sock;
		bool stop = link->stop;
		pthread_mutex_unlock(&link->mu);
		if (stop || fd < 0) {
			break;
		}
		int fds[1] = { fd };
		if (waitAnyReadable(fds, 1, 100) < 0) {
			continue;
		}
		int rr = busReadSome(fd, link->busRx, &link->busRxLen);
		if (rr <= 0) {
			LINK_LOG("Link bus join read ended rr=%d errno=%d", rr, errno);
			break;
		}
		if (!busDrain(link, NULL, fd, link->busRx, &link->busRxLen)) {
			LINK_LOG("Link bus join drain rejected");
			break;
		}
	}
	pthread_mutex_lock(&link->mu);
	if (link->sock >= 0) {
		shutdown(link->sock, SHUT_RDWR);
		link_close(link->sock);
		link->sock = -1;
	}
	if (!link->stop) {
		link->state = LINK_DOWN;
		setMessage(link, "主机已断开");
	}
	pthread_cond_broadcast(&link->cv);
	pthread_mutex_unlock(&link->mu);
	LINK_LOG("Link bus join loop stopped");
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
	int traceState = link->state;
	int traceSock = link->sock;
	int traceListen = link->listenFd;
	bool traceBus = link->bus;
	bool traceHost = link->busHost;
	int tracePeers = link->busPeerCount;
	link->stop = true;
	int sock = link->sock;
	int listenFd = link->listenFd;
	link->sock = -1;
	link->listenFd = -1;
	link->waiting = false;
	int peerFd[BUS_MAX_PLAYERS - 1];
	int peerCount = link->busPeerCount;
	for (int i = 0; i < BUS_MAX_PLAYERS - 1; ++i) {
		peerFd[i] = link->busPeers[i].fd;
		link->busPeers[i].fd = -1;
	}
	link->busPeerCount = 0;
	struct LocalBus* localBus = link->localBus;
	bool localHost = link->busHost;
	int localSlot = link->player;
	link->localBus = NULL;
	pthread_cond_broadcast(&link->cv);
	pthread_mutex_unlock(&link->mu);
	if (localBus) {
		localBusDetach(localBus, localHost, localSlot);
	}
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
	for (int i = 0; i < peerCount && i < BUS_MAX_PLAYERS - 1; ++i) {
		if (peerFd[i] >= 0) {
			shutdown(peerFd[i], SHUT_RDWR);
			link_close(peerFd[i]);
		}
	}
	if (listenFd >= 0) {
		shutdown(listenFd, SHUT_RDWR);
		link_close(listenFd);
	}
	if (link->threadLive) {
		pthread_join(link->ioThread, NULL);
		link->threadLive = false;
	}
	/* The ping thread (250 ms sleep for 2P, 200 ms slices for the bus) reads
	 * `link->stop` and locks `link->mu`. Close used to join only ioThread and
	 * then immediately reset stop to false: a ping thread waking up in that
	 * window saw "not stopping", kept running, and netLinkDestroy() freed the
	 * struct (plus its mutexes) underneath it - the intermittent use-after-free
	 * that crashed the full test suite at a random late stage. Join it before
	 * the flag is reusable. */
	if (link->pingLive) {
		pthread_join(link->pingThread, NULL);
		link->pingLive = false;
	}
	pthread_mutex_lock(&link->mu);
	link->stop = false;
	link->state = LINK_OFF;
	link->qCount = 0;
	link->peerHead = 0;
	link->peerCount = 0;
	link->bus = false;
	link->busHost = false;
	link->busPlayers = 0;
	link->busOwnValid = false;
	link->busHostIndexValid = false;
	link->busHostIndex = 0;
	link->busInValid = false;
	link->busInPending = 0;
	link->busRxLen = 0;
	setMessage(link, "");
	pthread_mutex_unlock(&link->mu);
	LINK_LOG("Link close: state=%d sock=%d listen=%d bus=%d host=%d peers=%d",
	         traceState, traceSock, traceListen, traceBus ? 1 : 0, traceHost ? 1 : 0, tracePeers);
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

/* ---- 总线（3/4 人）公开接口 -------------------------------------------- */

static void* busHostThread(void* arg) {
	busHostLoop((struct NetLink*) arg);
	return NULL;
}

static void* busJoinThread(void* arg) {
	busJoinLoop((struct NetLink*) arg);
	return NULL;
}

/* ==================== 进程内总线（同进程 N 核） ====================
 *
 * 3/4 人星型总线跑在 127.0.0.1 TCP 上时，主机「等从机同 index 的字」和从机
 * 「等主机广播」会互相等；index 一旦错位就双双吃满超时地板（实测从机
 * runFrame 198ms/帧、整机 5.6fps、full=0）。根因不是带宽，是「跨线程逐轮
 * 会合」+「轮次号各算各的」。
 *
 * 这里把同一份协议搬进进程内共享内存：**主机是唯一时钟源，由它决定本轮号**，
 * 从机永远跟随主机当前轮次（实际号由 indexOut 回带）。于是轮次天然对齐，
 * 不存在错位；会合靠 cond 广播，唤醒 µs 级，没有 2ms 超时地板。socket、
 * IO 线程、心跳一概不需要。语义与 netLinkBusRound 完全一致。
 */
#define LOCALBUS_MAX_BUSES 8

struct LocalBus {
	int players;
	int attached;                 /* 已 attach 的从机数（不含主机） */
	bool slotTaken[BUS_MAX_PLAYERS]; /* slot 0 归 host，其余可被指定槽位 join 占用 */
	pthread_mutex_t mu;
	pthread_cond_t cv;
	uint16_t index;               /* 主机当前开的轮次号 */
	bool roundOpen;
	bool roundAborted;        /* 本轮没收齐、主机放弃广播：从机立即返回 -1 */
	bool roundBroadcast;      /* 本轮是否已广播过（锁步：广播一次后等全员消费） */
	uint16_t word[BUS_MAX_PLAYERS];
	bool pushed[BUS_MAX_PLAYERS];
	uint16_t pushIdx[BUS_MAX_PLAYERS];
	uint16_t doneIdx[BUS_MAX_PLAYERS];   /* 各从机已消费到的轮次 */
	int seenGen[BUS_MAX_PLAYERS];        /* 各从机已消费的广播代数 */
	uint16_t bcastIndex;
	uint16_t bcastWord[BUS_MAX_PLAYERS];
	uint32_t bcastCycles;
	int bcastGen;
	int rounds, full, empty, stale, future, minLead, maxLead;
	int slaveCalls;               /* 从机调用 busRoundLocal 的次数（诊断） */
	uint64_t totalUs;             /* busRoundLocal 内累计墙钟（诊断） */
	bool stop;
	bool used;
	bool inited;              /* mutex/cond 已初始化：槽位复用时不得重复 init */
	int key;
};

static struct LocalBus gLocalBuses[LOCALBUS_MAX_BUSES];
static pthread_mutex_t gLocalBusMu = PTHREAD_MUTEX_INITIALIZER;

static struct LocalBus* localBusFind(int key) {
	struct LocalBus* lb = NULL;
	pthread_mutex_lock(&gLocalBusMu);
	for (int i = 0; i < LOCALBUS_MAX_BUSES; ++i) {
		if (gLocalBuses[i].used && gLocalBuses[i].key == key) {
			lb = &gLocalBuses[i];
			break;
		}
	}
	pthread_mutex_unlock(&gLocalBusMu);
	return lb;
}

static struct LocalBus* localBusCreate(int key, int players) {
	struct LocalBus* lb = NULL;
	pthread_mutex_lock(&gLocalBusMu);
	for (int i = 0; i < LOCALBUS_MAX_BUSES && !lb; ++i) {
		if (gLocalBuses[i].used && gLocalBuses[i].key == key) {
			lb = &gLocalBuses[i];
		}
	}
	for (int i = 0; i < LOCALBUS_MAX_BUSES && !lb; ++i) {
		if (!gLocalBuses[i].used) {
			lb = &gLocalBuses[i];
			if (!lb->inited) {
				pthread_mutex_init(&lb->mu, NULL);
				pthread_cond_init(&lb->cv, NULL);
				lb->inited = true;
			}
			/* 槽位复用：host 退出只清 used，mutex/cond 仍然有效。这里必须逐字段
			 * 重置数据，不能 memset 整块后再对已初始化的 mutex/cond 重复 init。 */
			lb->attached = 0;
			lb->index = 0;
			lb->roundOpen = false;
			lb->roundAborted = false;
			lb->roundBroadcast = false;
			for (int s = 0; s < BUS_MAX_PLAYERS; ++s) {
				lb->word[s] = 0;
				lb->pushed[s] = false;
				lb->pushIdx[s] = 0;
				lb->doneIdx[s] = 0;
				lb->seenGen[s] = 0;
				lb->bcastWord[s] = 0;
				lb->slotTaken[s] = false;
			}
			lb->slotTaken[0] = true;   /* 主机恒占链路槽位 0 */
			lb->bcastIndex = 0;
			lb->bcastCycles = 0;
			lb->bcastGen = 0;
			lb->rounds = 0;
			lb->full = 0;
			lb->empty = 0;
			lb->stale = 0;
			lb->future = 0;
			lb->minLead = 9999;
			lb->maxLead = -9999;
			lb->slaveCalls = 0;
			lb->totalUs = 0;
			lb->stop = false;
			lb->used = true;
			lb->key = key;
		}
	}
	if (lb) {
		lb->players = players;
	}
	pthread_mutex_unlock(&gLocalBusMu);
	return lb;
}

static void localBusDetach(struct LocalBus* lb, bool host, int slot) {
	if (!lb) {
		return;
	}
	pthread_mutex_lock(&gLocalBusMu);
	pthread_mutex_lock(&lb->mu);
	if (host) {
		/* 主机退出 = 整个会话结束：叫醒所有从机让它们 bail，释放槽位。 */
		lb->stop = true;
		lb->used = false;
	} else {
		if (slot > 0 && slot < BUS_MAX_PLAYERS) {
			lb->slotTaken[slot] = false;
		}
		int taken = 0;
		for (int s = 1; s < BUS_MAX_PLAYERS; ++s) {
			if (lb->slotTaken[s]) {
				++taken;
			}
		}
		lb->attached = taken;
	}
	pthread_cond_broadcast(&lb->cv);
	pthread_mutex_unlock(&lb->mu);
	pthread_mutex_unlock(&gLocalBusMu);
}

/* 进程内一轮聚合，契约同 netLinkBusRound。 */
static int busRoundLocal(struct NetLink* link, uint16_t index, uint32_t own,
                         uint32_t* values, int players, int timeoutMs, uint16_t* indexOut) {
	struct LocalBus* lb = link->localBus;
	int slot = link->player;
	if (!lb || slot < 0 || slot >= BUS_MAX_PLAYERS) {
		return -1;
	}
	if (players < 2 || players > BUS_MAX_PLAYERS) {
		players = lb->players;
	}
	uint32_t vals[BUS_MAX_PLAYERS];
	for (int i = 0; i < BUS_MAX_PLAYERS; ++i) {
		vals[i] = 0xFFFFu;
	}
	if (indexOut) {
		*indexOut = index;
	}
	int ret = -1;
	int budgetMs = timeoutMs > 0 ? timeoutMs : 0;
	if (link->busHost && budgetMs > 0) {
		/* 主机是屏障的另一端，必须等齐从机再广播；2ms 会让它提前甩开从机，
		 * 落后从机的 PUSH 全变 stale。默认下限 25ms 覆盖从机 µs 级响应，又
		 * 不会在「从机此刻不在 MULTI」时把整帧按死（200ms/1000ms 单独调大
		 * 实测把吞吐从 68fps 拖到 31fps 或卡 cb2=0）。
		 * MGBAX_BUS_HOST_MS 可覆盖该下限：配合硬帧栅栏（帧锁步）把主机预算
		 * 拉大，就能验证「主机不再 abort 空槽、等帧内慢从机」是否能消除
		 * empty/stale 并跑通 3 人握手。默认不设=25ms，行为不变。 */
		static int hostFloorMs = -1;
		if (hostFloorMs < 0) {
			const char* e = getenv("MGBAX_BUS_HOST_MS");
			hostFloorMs = e ? atoi(e) : 25;
			if (hostFloorMs < 1) {
				hostFloorMs = 1;
			}
		}
		if (budgetMs < hostFloorMs) {
			budgetMs = hostFloorMs;
		}
	}
	uint32_t expireAt = nowMs() + (uint32_t) budgetMs;
	/* 一次性绝对 deadline：2ms 分片轮询在 Windows 上会按 ~15ms 定时器粒度
	 * 睡满，cond 广播本可 µs 级唤醒，反而被分片钉在毫秒级。等到同一个绝对
	 * 时刻即可：广播到了立刻返回，没到才等满最终 deadline。 */
	struct timespec absDeadline;
	deadline(&absDeadline, budgetMs);
	uint32_t _busT0 = nowUs();

	pthread_mutex_lock(&lb->mu);
	if (link->busHost) {
		/* 主机 = 时钟源：用调用方的 index 开这一轮。 */
		lb->index = index;
		lb->roundOpen = true;
		lb->roundAborted = false;
		lb->roundBroadcast = false;
		lb->word[0] = (uint16_t) own;
		lb->pushed[0] = true;
		lb->pushIdx[0] = index;
		pthread_cond_broadcast(&lb->cv);
		for (;;) {
			int got = 0, consumed = 0;
			for (int s = 1; s < lb->players; ++s) {
				if (lb->pushed[s] && lb->pushIdx[s] == index) {
					++got;
				}
				if (lb->doneIdx[s] == index) {
					++consumed;
				}
			}
			if (got >= lb->attached && !lb->roundBroadcast) {
				/* 收齐即快照广播一次（缺席槽只可能是掉线的从机）。 */
				++lb->rounds;
				++lb->full;
				for (int s = 1; s < lb->players; ++s) {
					if (lb->pushed[s]) {
						int16_t lead = (int16_t) (lb->pushIdx[s] - index);
						if (lead < 0) {
							++lb->stale;
						} else if (lead > 0) {
							++lb->future;
						}
						if (lead < lb->minLead) {
							lb->minLead = lead;
						}
						if (lead > lb->maxLead) {
							lb->maxLead = lead;
						}
					}
				}
				lb->bcastIndex = index;
				for (int i = 0; i < BUS_MAX_PLAYERS; ++i) {
					bool ok = lb->pushed[i] && lb->pushIdx[i] == index;
					lb->bcastWord[i] = ok ? lb->word[i] : (uint16_t) 0xFFFFu;
				}
				lb->bcastWord[0] = (uint16_t) own;
				if (lb->bcastGen <= 3 || (lb->bcastGen % 400) == 0) {
					fprintf(stderr,
					        "BCAST gen=%d idx=%u pw=%d%d%d%d pi=%u,%u,%u w=%04X,%04X,%04X bw=%04X,%04X,%04X,%04X\n",
					        lb->bcastGen, (unsigned) index,
					        lb->pushed[0] ? 1 : 0, lb->pushed[1] ? 1 : 0,
					        lb->pushed[2] ? 1 : 0, lb->pushed[3] ? 1 : 0,
					        (unsigned) lb->pushIdx[0], (unsigned) lb->pushIdx[1],
					        (unsigned) lb->pushIdx[2],
					        lb->word[0], lb->word[1], lb->word[2],
					        lb->bcastWord[0], lb->bcastWord[1], lb->bcastWord[2], lb->bcastWord[3]);
				}
				lb->bcastCycles = __atomic_load_n(&link->pushCycles, __ATOMIC_ACQUIRE);
				++lb->bcastGen;
				lb->roundBroadcast = true;
				pthread_cond_broadcast(&lb->cv);
			}
			if (got >= lb->attached && consumed >= lb->attached) {
				/* 锁步：全员消费完这一轮，主机才返回（冻结的模拟时钟随之
				 * 放行、进下一轮）。三核因此永远在同一总线轮次上收尾，写同一
				 * 份 SIOMULTI 快照，握手不再互异（busgame 实测 f=228 起 M2
				 * 分叉即主机比从机早一轮所致）。 */
				for (int i = 0; i < BUS_MAX_PLAYERS; ++i) {
					vals[i] = lb->bcastWord[i];
				}
				vals[0] = own;
				ret = got;
				break;
			}
			/* 未收齐、或收齐了但还有从机没消费：继续等推送/消费通知。
			 * 诊断只在终止（超时/stop）时计一次，避免一轮被迭代多次计数。 */
			if (lb->stop || (int32_t) (expireAt - nowMs()) <= 0) {
				/* 终止：超时放弃本轮，返回 -1 让所有核重挂事件。 */
				++lb->rounds;
				if (got == 0) {
					++lb->empty;
				}
				for (int s = 1; s < lb->players; ++s) {
					if (lb->pushed[s]) {
						int16_t lead = (int16_t) (lb->pushIdx[s] - index);
						if (lead < 0) {
							++lb->stale;
						} else if (lead > 0) {
							++lb->future;
						}
						if (lead < lb->minLead) {
							lb->minLead = lead;
						}
						if (lead > lb->maxLead) {
							lb->maxLead = lead;
						}
					}
				}
				lb->roundAborted = true;
				ret = -1;
				pthread_cond_broadcast(&lb->cv);
				break;
			}
			pthread_cond_timedwait(&lb->cv, &lb->mu, &absDeadline);
		}
	} else {
		/* 从机：始终跟随主机当前轮次。若主机还没开新轮，**立刻返回 -1**，
		 * 不做任何墙钟等待。
		 *
		 * 这一点很关键：boot 期从机的 SIO 事件会被游戏自己的 SIO 写操作
		 * arm 起来，而主机此时并没有开轮。若这里按 timeoutMs 死等，从机
		 * 每帧会空等 ~8 次 × 数 ms（实测 busRoundLocal 内部累计 63 秒/45s，
		 * runFrame 133~194ms/帧）。返回 -1 后调用方会重新挂载事件、下一轮
		 * 再来；主机真正开轮时这里能立刻看到 want > doneIdx，同步一帧不丢。 */
		++lb->slaveCalls;
		bool have = false;
		uint16_t want = 0;
		if (!lb->stop && lb->roundOpen) {
			want = lb->index;
			if ((int16_t) (want - lb->doneIdx[slot]) > 0) {
				have = true;
			}
		}
		if (have) {
			lb->word[slot] = (uint16_t) own;
			lb->pushed[slot] = true;
			lb->pushIdx[slot] = want;
			pthread_cond_broadcast(&lb->cv);
			/* 广播可能已经先到（主机收齐**别的**从机就把这一轮发了），
			 * 那就直接消费；否则等新的一轮广播。用 bcastIndex 而不是
			 * 单增的 bcastGen 判定，否则「错过的那一轮」会永远等不到
			 * 新 gen（实测 c1 因此每帧空等满超时）。 */
			while (!lb->roundAborted
			       && !((int16_t) (lb->bcastIndex - want) >= 0 && lb->bcastGen > 0)) {
				if (lb->stop || lb->roundAborted || timeoutMs <= 0
				    || (int32_t) (expireAt - nowMs()) <= 0) {
					break;
				}
				pthread_cond_timedwait(&lb->cv, &lb->mu, &absDeadline);
			}
			if (!lb->roundAborted
			    && (int16_t) (lb->bcastIndex - want) >= 0 && lb->bcastGen > 0) {
				int got = 0;
				for (int i = 0; i < BUS_MAX_PLAYERS; ++i) {
					vals[i] = lb->bcastWord[i];
				}
				vals[slot] = (uint16_t) own;
				for (int i = 0; i < BUS_MAX_PLAYERS; ++i) {
					if (i != slot && i < players && vals[i] != 0xFFFFu) {
						++got;
					}
				}
				lb->doneIdx[slot] = lb->bcastIndex;
				lb->seenGen[slot] = lb->bcastGen;
				/* 刚消费完这一轮：唤醒可能在 cond_wait 里等「全员消费」
				 * 的主机，避免主机等到 deadline 才看到（否则每轮白付墙钟）。 */
				pthread_cond_broadcast(&lb->cv);
				if (indexOut) {
					*indexOut = lb->bcastIndex;
				}
				ret = got;
			}
		}
	}
	lb->totalUs += (uint64_t) (nowUs() - _busT0);
	pthread_mutex_unlock(&lb->mu);
	if (values) {
		for (int i = 0; i < BUS_MAX_PLAYERS; ++i) {
			values[i] = vals[i];
		}
	}
	return ret;
}

bool netLinkBusHostLocal(struct NetLink* link, int key, int players) {
	if (!link) {
		return false;
	}
	if (players < 3) {
		players = 3;
	}
	if (players > BUS_MAX_PLAYERS) {
		players = BUS_MAX_PLAYERS;
	}
	struct LocalBus* lb = localBusCreate(key, players);
	if (!lb) {
		return false;
	}
	pthread_mutex_lock(&link->mu);
	link->localBus = lb;
	link->bus = true;
	link->busHost = true;
	link->busPlayers = players;
	link->player = 0;
	link->state = LINK_CONNECTED;
	pthread_mutex_unlock(&link->mu);
	pthread_mutex_lock(&lb->mu);
	lb->slotTaken[0] = true;   /* 主机恒占链路槽位 0 */
	lb->roundOpen = false;
	lb->roundAborted = false;
	lb->stop = false;
	pthread_mutex_unlock(&lb->mu);
	LINK_LOG("Link LOCAL bus host key=%d players=%d", key, players);
	return true;
}

/* requestedSlot < 0 时按空闲槽位自动分配；否则占用指定槽位。 */
static bool localBusJoin(struct NetLink* link, int key, int requestedSlot) {
	if (!link) {
		return false;
	}
	struct LocalBus* lb = localBusFind(key);
	if (!lb) {
		return false;
	}
	pthread_mutex_lock(&lb->mu);
	int slot = requestedSlot;
	if (slot < 0) {
		slot = -1;
		for (int s = 1; s < lb->players && s < BUS_MAX_PLAYERS; ++s) {
			if (!lb->slotTaken[s]) {
				slot = s;
				break;
			}
		}
	}
	if (slot < 1 || slot >= lb->players || slot >= BUS_MAX_PLAYERS
	    || lb->slotTaken[slot]) {
		pthread_mutex_unlock(&lb->mu);
		return false;
	}
	lb->slotTaken[slot] = true;
	int taken = 0;
	for (int s = 1; s < BUS_MAX_PLAYERS; ++s) {
		if (lb->slotTaken[s]) {
			++taken;
		}
	}
	lb->attached = taken;
	lb->pushed[slot] = false;
	lb->doneIdx[slot] = 0;
	lb->seenGen[slot] = 0;
	pthread_mutex_unlock(&lb->mu);
	pthread_mutex_lock(&link->mu);
	link->localBus = lb;
	link->bus = true;
	link->busHost = false;
	link->busPlayers = lb->players;
	link->player = slot;
	link->state = LINK_CONNECTED;
	pthread_mutex_unlock(&link->mu);
	LINK_LOG("Link LOCAL bus join key=%d slot=%d players=%d", key, slot, lb->players);
	return true;
}

bool netLinkBusJoinLocal(struct NetLink* link, int key) {
	return localBusJoin(link, key, -1);
}

bool netLinkBusJoinLocalSlot(struct NetLink* link, int key, int slot) {
	/* slot 是链路层 0-based 编号：全局槽位 N 对应 slot N-1。 */
	return localBusJoin(link, key, slot);
}

bool netLinkBusIsLocal(struct NetLink* link) {
	return link && link->localBus != NULL;
}

int netLinkBusLocalSlot(struct NetLink* link) {
	return link ? link->player : -1;
}

bool netLinkBusHost(struct NetLink* link, int port, int players) {
	if (!link || port < 1 || port > 65535) {
		return false;
	}
	if (players <= 2) {
		/* 两人不启用总线：直连路径一字不动。 */
		return netLinkHost(link, port);
	}
	if (players > BUS_MAX_PLAYERS) {
		players = BUS_MAX_PLAYERS;
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
	link->bus = true;
	link->busHost = true;
	link->busPlayers = players;
	link->busPeerCount = 0;
	for (int i = 0; i < BUS_MAX_PLAYERS - 1; ++i) {
		memset(&link->busPeers[i], 0, sizeof(link->busPeers[i]));
		link->busPeers[i].fd = -1;
	}
	link->listenFd = fd;
	link->port = port;
	link->player = 0;
	link->state = LINK_LISTEN;
	link->stop = false;
	link->busOwnValid = false;
	link->busHostIndexValid = false;
	char msg[64];
	snprintf(msg, sizeof(msg), "等待 %d 人加入", players);
	setMessage(link, msg);
	pthread_mutex_unlock(&link->mu);
	if (pthread_create(&link->ioThread, NULL, busHostThread, link) != 0) {
		netLinkClose(link);
		return false;
	}
	link->threadLive = true;
	if (!link->pingLive && pthread_create(&link->pingThread, NULL, busPingMain, link) == 0) {
		link->pingLive = true;
	}
	LINK_LOG("Link bus hosting on %d for %d players", port, players);
	return true;
}

bool netLinkBusJoin(struct NetLink* link, const char* host, int port) {
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
		setMessage(link, "连不上主机");
		pthread_mutex_unlock(&link->mu);
		return false;
	}
	linkTune(fd);
	pthread_mutex_lock(&link->mu);
	link->sock = fd;
	link->bus = true;
	link->busHost = false;
	link->busPlayers = 2;   /* 收到 WELCOME 后由主机告知真实人数与槽位 */
	link->player = 0;
	link->state = LINK_LISTEN;   /* 还没拿到槽位，不算「已连接」 */
	link->stop = false;
	link->busRxLen = 0;
	link->busInValid = false;
	link->busInPending = 0;
	link->busHostIndexValid = false;
	link->busOwnValid = false;
	setMessage(link, "已连上主机，等待分配槽位");
	pthread_mutex_unlock(&link->mu);
	if (pthread_create(&link->ioThread, NULL, busJoinThread, link) != 0) {
		netLinkClose(link);
		return false;
	}
	link->threadLive = true;
	if (!link->pingLive && pthread_create(&link->pingThread, NULL, busPingMain, link) == 0) {
		link->pingLive = true;
	}
	LINK_LOG("Link bus joining %s:%d", host, port);
	return true;
}

bool netLinkBusActive(struct NetLink* link) {
	if (!link) {
		return false;
	}
	pthread_mutex_lock(&link->mu);
	bool bus = link->bus || link->localBus != NULL;
	pthread_mutex_unlock(&link->mu);
	return bus;
}

int netLinkBusPlayers(struct NetLink* link) {
	if (!link) {
		return 0;
	}
	int n = 0;
	pthread_mutex_lock(&link->mu);
	if (link->bus) {
		if (link->localBus) {
			n = link->busPlayers;
		} else if (link->busHost) {
			n = link->busPeerCount + 1;
		} else if (link->state == LINK_CONNECTED) {
			n = link->busPlayers;
		}
	}
	pthread_mutex_unlock(&link->mu);
	return n;
}

void netLinkBusSlots(const uint32_t* values, int players, int me, uint16_t own, uint16_t out[4]) {
	for (int i = 0; i < BUS_MAX_PLAYERS; ++i) {
		if (values && i < players) {
			out[i] = (uint16_t) values[i];
		} else {
			out[i] = 0xFFFF;
		}
	}
	if (me >= 0 && me < BUS_MAX_PLAYERS) {
		out[me] = own;
	}
}

/* Read-only star-bus round counters (7 ints, see the struct for the order). */
void netLinkBusDiag(struct NetLink* link, int32_t* out) {
	for (int i = 0; i < 7; ++i) {
		out[i] = 0;
	}
	if (!link) {
		return;
	}
	struct LocalBus* lb = link->localBus;
	if (lb) {
		pthread_mutex_lock(&lb->mu);
		out[0] = lb->rounds;
		out[1] = lb->full;
		out[2] = lb->empty;
		out[3] = lb->stale;
		out[4] = lb->future;
		out[5] = lb->minLead;
		out[6] = lb->maxLead;
		pthread_mutex_unlock(&lb->mu);
		return;
	}
	pthread_mutex_lock(&link->mu);
	out[0] = link->busDiagRounds;
	out[1] = link->busDiagFull;
	out[2] = link->busDiagEmpty;
	out[3] = link->busDiagStalePush;
	out[4] = link->busDiagFuturePush;
	out[5] = link->busDiagMinLead;
	out[6] = link->busDiagMaxLead;
	pthread_mutex_unlock(&link->mu);
}

/* 进程内总线的墙钟诊断单独走这里，不占 netLinkBusDiag 的 7 项契约。
 * totalUs 是 busRoundLocal 内部累计墙钟（所有核累加），用来验证「没有每轮
 * 2ms 超时地板」；slaveCalls 是从机调用次数。非本地总线返回 0。 */
void netLinkBusDiagTiming(struct NetLink* link, uint64_t* totalUs, int* slaveCalls) {
	if (totalUs) {
		*totalUs = 0;
	}
	if (slaveCalls) {
		*slaveCalls = 0;
	}
	struct LocalBus* lb = link ? link->localBus : NULL;
	if (!lb) {
		return;
	}
	pthread_mutex_lock(&lb->mu);
	if (totalUs) {
		*totalUs = lb->totalUs;
	}
	if (slaveCalls) {
		*slaveCalls = lb->slaveCalls;
	}
	pthread_mutex_unlock(&lb->mu);
}

uint16_t netLinkBusRoundIndex(struct NetLink* link) {
	if (!link) {
		return 0;
	}
	uint16_t index = 0;
	pthread_mutex_lock(&link->mu);
	if (link->busHostIndexValid) {
		index = link->busHostIndex;
	}
	pthread_mutex_unlock(&link->mu);
	return index;
}

uint32_t netLinkBusRoundCycles(struct NetLink* link) {
	if (!link) {
		return 0;
	}
	struct LocalBus* lb = link->localBus;
	if (lb) {
		uint32_t c;
		pthread_mutex_lock(&lb->mu);
		c = lb->bcastCycles;
		pthread_mutex_unlock(&lb->mu);
		return c;
	}
	pthread_mutex_lock(&link->mu);
	uint32_t cycles = link->busInCycles;
	pthread_mutex_unlock(&link->mu);
	return cycles;
}

int netLinkBusRound(struct NetLink* link, uint16_t index, uint32_t own,
                    uint32_t* values, int players, int timeoutMs, uint16_t* indexOut) {
	if (values) {
		for (int i = 0; i < BUS_MAX_PLAYERS; ++i) {
			values[i] = 0xFFFFu;
		}
	}
	if (indexOut) {
		*indexOut = index;
	}
	if (!link) {
		return 0;
	}
	if (link->localBus) {
		return busRoundLocal(link, index, own, values, players, timeoutMs, indexOut);
	}
	if (players < 2 || players > BUS_MAX_PLAYERS) {
		players = BUS_MAX_PLAYERS;
	}
	int got = 0;
	int ret = -1;
	uint32_t vals[BUS_MAX_PLAYERS] = { 0xFFFFu, 0xFFFFu, 0xFFFFu, 0xFFFFu };
	vals[0] = own;

	pthread_mutex_lock(&link->mu);
	if (!link->bus || link->state != LINK_CONNECTED) {
		pthread_mutex_unlock(&link->mu);
		return -1;
	}
	if (link->busHost) {
		/* 主机：等所有**已连接**从机把 index 这一轮的字推上来。缺席的从机
		 * （没连上 / 掉线）按空槽 0xFFFF 处理，和真机上没插机的槽一致。 */
		int wantPeers = link->busPeerCount;
		uint32_t expireAt = nowMs() + (uint32_t) (timeoutMs > 0 ? timeoutMs : 0);
		link->busOwn = own;
		link->busOwnIndex = index;
		link->busOwnValid = true;
		link->busHostIndex = index;
		link->busHostIndexValid = true;
		for (;;) {
			got = 0;
			vals[0] = own;
			for (int i = 1; i < BUS_MAX_PLAYERS; ++i) {
				vals[i] = 0xFFFFu;
			}
			for (int i = 0; i < link->busPeerCount; ++i) {
				struct BusPeer* p = &link->busPeers[i];
				if (p->valid && p->index == index && p->slot > 0 && p->slot < BUS_MAX_PLAYERS) {
					vals[p->slot] = p->value;
					++got;
				}
			}
			if (got >= wantPeers || timeoutMs <= 0 || link->stop) {
				break;
			}
		if ((int32_t) (expireAt - nowMs()) <= 0) {
			break;
		}
		int32_t remain = (int32_t) (expireAt - nowMs());
		if (remain > 20) {
			remain = 20;
		}
		struct timespec ts;
		deadline(&ts, remain > 0 ? remain : 1);
		pthread_cond_timedwait(&link->cv, &link->mu, &ts);
	}
	/* 轮次对齐诊断：统计每个从机最后一次 PUSH 的轮次号相对本轮的偏差。 */
		for (int i = 0; i < link->busPeerCount; ++i) {
			struct BusPeer* p = &link->busPeers[i];
			if (!p->valid) {
				continue;
			}
			int16_t lead = (int16_t) (p->index - index);
			if (lead < 0) {
				++link->busDiagStalePush;
			} else if (lead > 0) {
				++link->busDiagFuturePush;
			}
			if (link->busDiagRounds == 0 || lead < link->busDiagMinLead) {
				link->busDiagMinLead = lead;
			}
			if (link->busDiagRounds == 0 || lead > link->busDiagMaxLead) {
				link->busDiagMaxLead = lead;
			}
		}
		++link->busDiagRounds;
		if (got >= wantPeers) {
			++link->busDiagFull;
		}
		if (got == 0) {
			++link->busDiagEmpty;
		}
		/* 收集到的字数（0..players）留给广播。 */
		ret = got;
		int fds[BUS_MAX_PLAYERS - 1];
		int n = 0;
		for (int i = 0; i < link->busPeerCount; ++i) {
			fds[n++] = link->busPeers[i].fd;
		}
		pthread_mutex_unlock(&link->mu);
		struct BusPacket round;
		memset(&round, 0, sizeof(round));
		round.magic = kMagic;
		round.type = PKT_BUS_ROUND;
		round.slot = 0;
		round.index = index;
		round.players = (uint16_t) players;
		round.cycles = __atomic_load_n(&link->pushCycles, __ATOMIC_ACQUIRE);
		for (int i = 0; i < BUS_MAX_PLAYERS; ++i) {
			round.word[i] = (uint16_t) vals[i];
		}
		for (int i = 0; i < n; ++i) {
			busSend(link, fds[i], &round);
		}
		LINK_VERBOSE("bus round host idx=%u got=%d/%d", (unsigned) index, got, wantPeers);
	} else {
		/* 从机：先把自己的字推给主机（主机收齐所有从机才广播），再等广播。
		 *
		 * 轮次号取「调用方请求的」和「最后一次从主机看到的」中**较新**的那个：
		 *   - 本机落后（刚加入，自己的计数器还是 0，主机已经几十轮）→ 跟随主机；
		 *   - 本机已经跟上（游戏按上一轮主机的号继续递增）→ 用调用方的号，
		 *     否则每一轮都会拿上一轮的旧号去推，主机永远匹配不上。 */
		uint16_t useIndex = index;
		if (link->busHostIndexValid && (int16_t) (index - link->busHostIndex) < 0) {
			useIndex = link->busHostIndex;
		}
		uint16_t slot = (uint16_t) link->player;
		uint16_t playersNow = (uint16_t) link->busPlayers;
		int fd = link->sock;
		link->busOwn = own;
		link->busOwnIndex = useIndex;
		link->busOwnValid = true;
		pthread_mutex_unlock(&link->mu);
		struct BusPacket push;
		memset(&push, 0, sizeof(push));
		push.magic = kMagic;
		push.type = PKT_PUSH;
		push.slot = slot;
		push.index = useIndex;
		push.players = playersNow;
		push.word[0] = (uint16_t) own;
		busSend(link, fd, &push);
		if (indexOut) {
			*indexOut = useIndex;
		}
		pthread_mutex_lock(&link->mu);
		uint32_t expireAt = nowMs() + (uint32_t) (timeoutMs > 0 ? timeoutMs : 0);
		for (;;) {
			if (link->busInValid && (int16_t) (link->busInIndex - useIndex) >= 0) {
				break;
			}
			if (timeoutMs <= 0 || link->stop || link->state != LINK_CONNECTED) {
				break;
			}
		if ((int32_t) (expireAt - nowMs()) <= 0) {
			break;
		}
		int32_t remain = (int32_t) (expireAt - nowMs());
		if (remain > 20) {
			remain = 20;
		}
		struct timespec ts;
		deadline(&ts, remain > 0 ? remain : 1);
		pthread_cond_timedwait(&link->cv, &link->mu, &ts);
	}
	if (link->busInValid && (int16_t) (link->busInIndex - useIndex) >= 0) {
			got = 0;
			for (int i = 0; i < BUS_MAX_PLAYERS; ++i) {
				vals[i] = link->busInWord[i];
			}
			/* 自己那一槽一定用本机这轮的字：广播里的自己那份也是它，但万一
			 * 主机晚了半拍，本机仍应以自己算出来的字为准。 */
			if (slot < BUS_MAX_PLAYERS) {
				vals[slot] = own;
			}
			for (int i = 0; i < BUS_MAX_PLAYERS; ++i) {
				if (i != slot && vals[i] != 0xFFFFu && i < players) {
					++got;
				}
			}
			if (indexOut) {
				*indexOut = link->busInIndex;
			}
			link->busInPending = 0;
			link->busInValid = false;
			ret = got;
		}
		pthread_mutex_unlock(&link->mu);
		LINK_VERBOSE("bus round slave slot=%d idx=%u got=%d", slot, (unsigned) useIndex, got);
	}
	if (values) {
		for (int i = 0; i < BUS_MAX_PLAYERS; ++i) {
			values[i] = vals[i];
		}
	}
	return ret;
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
	if (link->bus) {
		/* 总线连接只认定长 BusPacket。这个函数发的是两人路径的
		 * struct Packet（20 字节），混进去会把对端的解析流冲成乱码
		 * （现场：主机报 bad magic=00000000 后掉线）。总线的心跳由
		 * busPingMain 负责，这里必须直接返回。 */
		pthread_mutex_unlock(&link->mu);
		return;
	}
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
	if (link->bus) {
		/* 两人路径的节拍栅栏；总线每轮自带同步，不需要也不能用它。 */
		pthread_mutex_unlock(&link->mu);
		return false;
	}
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

uint32_t netLinkRttUs(struct NetLink* link) {
	if (!link) {
		return 0;
	}
	return __atomic_load_n(&link->rttUs, __ATOMIC_ACQUIRE);
}

bool netLinkExchange(struct NetLink* link, uint16_t mode, uint32_t local, uint32_t* remoteOut, int timeoutMs) {	if (remoteOut) {
		*remoteOut = 0xFFFFFFFFu;
	}
	if (!link) {
		return false;
	}
	pthread_mutex_lock(&link->mu);
	if (link->bus) {
		/* 总线的字由 netLinkBusRound 汇聚，请求-应答通道不参与。 */
		pthread_mutex_unlock(&link->mu);
		return false;
	}
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
	bool bus;
	bool host;
	int fds[BUS_MAX_PLAYERS - 1];
	int n = 0;
	uint16_t players = 0;
	pthread_mutex_lock(&link->mu);
	bus = link->bus;
	host = link->busHost;
	if (bus && host) {
		/* 主机把本轮自己的字推给所有从机：从机要靠它知道「交换正在进
		 * 行」才会挂上自己的轮次事件，也顺便拿到主机的轮次号。 */
		link->busOwn = local;
		link->busOwnIndex = index;
		link->busOwnValid = true;
		link->busHostIndex = index;
		link->busHostIndexValid = true;
		players = (uint16_t) link->busPlayers;
		for (int i = 0; i < link->busPeerCount && n < BUS_MAX_PLAYERS - 1; ++i) {
			fds[n++] = link->busPeers[i].fd;
		}
	}
	pthread_mutex_unlock(&link->mu);
	if (!bus) {
		sendPacket(link, PKT_PUSH, index, mode, local);
		return;
	}
	if (!host) {
		/* 从机的推送由 netLinkBusRound 在「先推后等广播」这一步发出，
		 * 这里不能重复发，否则主机把同一轮算两次。 */
		return;
	}
	struct BusPacket push;
	memset(&push, 0, sizeof(push));
	push.magic = kMagic;
	push.type = PKT_PUSH;
	push.slot = 0;
	push.index = index;
	push.players = players;
	push.word[0] = (uint16_t) local;
	push.cycles = cycles;
	for (int i = 0; i < n; ++i) {
		busSend(link, fds[i], &push);
	}
}

/* 从队列里取对端的一个字。
 *
 * strict = true  —— 严格按轮次号匹配（主机用）：比 want 老的丢弃，比 want 新的
 *                   原地等（不动队首）直到本轮到达或等待窗耗尽后按恢复路径取走。
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
		bool ahead = false;
		while (link->peerCount > 0) {
			struct PeerWord w = link->peerQ[link->peerHead];
			if (strict) {
				int16_t d = (int16_t) (w.index - want);
				if (d < 0) {
					/* 比本轮还老的推送：本机早就超时收尾过了，丢掉，
					 * 否则后面的每一轮都会被这条拖慢一格。 */
					link->peerHead = (link->peerHead + 1) % PEER_QUEUE;
					--link->peerCount;
					++link->peerStale;
					continue;
				}
				if (d > 0) {
					/* 队首是**后续**轮次：本轮的字还在路上。以前这里
					 * 直接把后续轮次交出去（只记 misorder 不拦），按帧
					 * 流水线一帧批量到达时，训练家卡片块交换的数据片段
					 * 就被喂进了错轮次 —— 游戏校验不过，块接收状态
					 * brs 恒 0000、进房间路径不执行、ST 4->0 断开。
					 * 现在原地不动它，等本轮的字到达（真机语义：这一
					 * 轮没到，线就不动）。 */
					ahead = true;
					break;
				}
			} else if ((int16_t) (w.index - minIndex) <= 0) {
				/* 已经消费过的轮次（含启动阶段堆积的旧推送）。丢掉，
				 * 从机只跟随主机给的、还没见过的轮次。 */
				link->peerHead = (link->peerHead + 1) % PEER_QUEUE;
				--link->peerCount;
				++link->peerStale;
				continue;
			}
			/* 命中：消费掉队首。 */
			link->peerHead = (link->peerHead + 1) % PEER_QUEUE;
			--link->peerCount;
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
			/* 等待窗耗尽：若队首是后续轮次，说明对端已经跳过去了（它自己
			 * 超时收尾过、或从机刚加入时对齐），本轮永远不会再来。这时把
			 * 队首交出去（调用方记一次 misorder）比死等/喂空槽都好 ——
			 * 既不会卡住整条链路，也不会用 0 破坏游戏的块校验。 */
			if (ahead && link->peerCount > 0) {
				struct PeerWord w = link->peerQ[link->peerHead];
				link->peerHead = (link->peerHead + 1) % PEER_QUEUE;
				--link->peerCount;
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
			}
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
	int n;
	if (link->bus) {
		/* 从机：主机的广播还没消费，或者主机至少推过一次字（交换正在
		 * 进行）。主机自己不看这个数。 */
		n = link->busHost ? 1 : (link->busInPending + (link->busHostIndexValid ? 1 : 0));
	} else {
		n = link->peerCount;
	}
	pthread_mutex_unlock(&link->mu);
	return n;
}

void netLinkPeerHeadInfo(struct NetLink* link, int* count, unsigned* headIndex) {
	if (count) {
		*count = 0;
	}
	if (headIndex) {
		*headIndex = 0;
	}
	if (!link) {
		return;
	}
	pthread_mutex_lock(&link->mu);
	if (count) {
		*count = link->peerCount;
	}
	if (headIndex && link->peerCount > 0) {
		*headIndex = link->peerQ[link->peerHead].index;
	}
	pthread_mutex_unlock(&link->mu);
}

uint32_t netLinkPushAgeMs(struct NetLink* link) {
	if (!link) {
		return 0xFFFFFFFFu;
	}
	pthread_mutex_lock(&link->mu);
	uint32_t seen = link->pushSeenAt;
	pthread_mutex_unlock(&link->mu);
	if (!seen) {
		return 0xFFFFFFFFu;
	}
	uint32_t now = nowMs();
	return now >= seen ? now - seen : 0;
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
