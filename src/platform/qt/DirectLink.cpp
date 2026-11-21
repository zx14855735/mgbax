/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "DirectLink.h"
#include "GbCloud.h"

#ifdef _WIN32
#include <winsock2.h>
#include <ws2tcpip.h>
typedef SOCKET socket_t;
#else
#include <arpa/inet.h>
#include <netdb.h>
#include <netinet/in.h>
#include <sys/select.h>
#include <sys/socket.h>
#include <unistd.h>
typedef int socket_t;
static void closesocket(socket_t s) {
	close(s);
}
#endif

#include <QDateTime>
#include <QHostAddress>
#include <QNetworkInterface>
#include <QRandomGenerator>
#include <QStringList>
#include <QThread>

#include <cstring>

using namespace QGBA;

namespace {

constexpr char MAGIC[4] = {'M', 'B', 'L', 'D'};
constexpr quint8 VERSION = 1;
constexpr int HEADER_BYTES = 18;
/** 打洞阶段探针间隔。 */
constexpr qint64 PROBE_MS = 100;
/** 连通后的保活间隔（同时维持 NAT 映射）。 */
constexpr qint64 KEEPALIVE_MS = 1000;
/**
 * 连通后多久收不到任何包就判定直连已死。保活是 1 秒一发，正常只会丢
 * 三五包，6 秒还没东西回来基本可以断定对端真的不可达了。
 */
/* 宝可梦进入对战时会先转场、加载双方队伍数据，期间游戏有几秒完全不发
 * SIO 字。原来 6s 的空闲看门狗会把它误判成掉线，一端先回落隧道、另一端
 * 还在直连，两边通道就此错开，游戏随即报「通信错误」。30s 足够覆盖转场，
 * PROBE 心跳每 1s 一次仍会持续给 NAT 映射保活。 */
constexpr qint64 IDLE_CLOSE_MS = 30000;

void put16(char* p, quint16 v) {
	p[0] = char((v >> 8) & 0xFF);
	p[1] = char(v & 0xFF);
}

void put32(char* p, quint32 v) {
	p[0] = char((v >> 24) & 0xFF);
	p[1] = char((v >> 16) & 0xFF);
	p[2] = char((v >> 8) & 0xFF);
	p[3] = char(v & 0xFF);
}

quint16 get16(const char* p) {
	return quint16((quint8(p[0]) << 8) | quint8(p[1]));
}

quint32 get32(const char* p) {
	return (quint32(quint8(p[0])) << 24) | (quint32(quint8(p[1])) << 16)
	     | (quint32(quint8(p[2])) << 8) | quint32(quint8(p[3]));
}

QString candidateText(quint32 ip, quint16 port) {
	in_addr addr;
	addr.s_addr = ip;
	char buf[INET_ADDRSTRLEN] = {0};
	inet_ntop(AF_INET, &addr, buf, sizeof(buf));
	return QStringLiteral("%1:%2").arg(QString::fromLatin1(buf)).arg(port);
}

/**
 * 候选地址优先级（数字越小越优先）。公告侧 candidates() 与接收侧
 * setPeerCandidates() 必须用**同一把尺子**，否则会出 11-16 实测的那次
 * 死锁：本机公告按 192.168 优先发出，但两端各自枚举网卡/STUN 时机不同，
 * 对端实际收到的顺序被打乱（B 发 192.168 在前，A 收到却是 172.18 在前）。
 * 打洞是「第一个 RESP 到达即锁定」，两端各按自己看到的顺序打，就锁到了
 * 不同网卡（A→172.18 虚拟网卡、B→192.168 内网），此后互相的包全被
 * 「忽略来自…」丢弃 ⇒ pushIn=0、联机 pc 永远停在 0。
 *
 * 收侧按同一规则重排后，两端都会优先打 192.168，锁到同一地址。
 * 网段判断用**主机字节序**（ntohl 还原），不能用网络序去比掩码 ——
 * 小端机上网络序的 192.168.1.5 是 0x0501A8C0，掩码永不匹配（11-15 踩过）。
 */
int candidatePriority(quint32 ipNetworkOrder) {
	const quint32 host = ntohl(ipNetworkOrder);
	if ((host & 0xFFFF0000u) == 0xC0A80000u) { // 192.168/16
		return 0;
	}
	if ((host & 0xFF000000u) == 0x0A000000u) { // 10/8
		return 1;
	}
	if ((host & 0xFFF00000u) == 0xAC100000u) { // 172.16/12（容器/虚拟机网卡）
		return 3;
	}
	return 2; // 其它（公网网卡 / STUN 映射）
}

bool parseCandidate(const QString& text, quint32* ip, quint16* port) {
	int colon = text.lastIndexOf(':');
	if (colon <= 0) {
		return false;
	}
	bool ok = false;
	int value = text.mid(colon + 1).toInt(&ok);
	if (!ok || value <= 0 || value > 65535) {
		return false;
	}
	QHostAddress address(text.left(colon));
	if (address.isNull() || address.protocol() != QAbstractSocket::IPv4Protocol) {
		return false;
	}
	// QHostAddress 给的是主机字节序，内部一律按网络字节序存
	*ip = htonl(address.toIPv4Address());
	*port = quint16(value);
	return *ip != 0;
}

/**
 * STUN binding request -> XOR-MAPPED-ADDRESS. 大厅隧道只负责交换地址，公网
 * 映射地址必须问 STUN；国内 stun.miwifi.com 通常 <100ms，拿到即停。
 */
bool stunLookup(socket_t sock, const char* host, quint16 port, quint32* ip, quint16* mappedPort) {
	addrinfo hints;
	std::memset(&hints, 0, sizeof(hints));
	hints.ai_family = AF_INET;
	hints.ai_socktype = SOCK_DGRAM;
	addrinfo* result = nullptr;
	if (getaddrinfo(host, nullptr, &hints, &result) != 0 || !result) {
		return false;
	}
	sockaddr_in target;
	std::memset(&target, 0, sizeof(target));
	std::memcpy(&target, result->ai_addr, sizeof(target));
	target.sin_port = htons(port);
	freeaddrinfo(result);

	char request[20];
	std::memset(request, 0, sizeof(request));
	put16(request, 0x0001);
	put16(request + 2, 0);
	put32(request + 4, 0x2112A442u);
	for (int i = 8; i < 20; ++i) {
		request[i] = char(QRandomGenerator::global()->bounded(256));
	}
	if (sendto(sock, request, sizeof(request), 0, reinterpret_cast<sockaddr*>(&target),
	           sizeof(target)) < 0) {
		return false;
	}

	qint64 deadline = QDateTime::currentMSecsSinceEpoch() + 900;
	while (QDateTime::currentMSecsSinceEpoch() < deadline) {
		fd_set rset;
		FD_ZERO(&rset);
		FD_SET(sock, &rset);
		timeval tv{0, 100 * 1000};
		if (select(int(sock) + 1, &rset, nullptr, nullptr, &tv) <= 0) {
			continue;
		}
		char buffer[512];
		sockaddr_in from;
		socklen_t fromLen = sizeof(from);
		int n = int(recvfrom(sock, buffer, sizeof(buffer), 0,
		                     reinterpret_cast<sockaddr*>(&from), &fromLen));
		if (n < 20 || get16(buffer) != 0x0101) {
			continue;
		}
		int offset = 20;
		while (offset + 4 <= n) {
			quint16 type = get16(buffer + offset);
			quint16 length = get16(buffer + offset + 2);
			if (offset + 4 + length > n) {
				break;
			}
			if ((type == 0x0020 || type == 0x0001) && length >= 8) {
				const char* value = buffer + offset + 4;
				quint16 mapped = get16(value + 2);
				quint32 address = get32(value + 4);
				if (type == 0x0020) {
					mapped = quint16(mapped ^ 0x2112);
					address ^= 0x2112A442u;
				}
				// 解析出来的数值是"大端写法的地址"，内部统一按网络字节序存
				*ip = htonl(address);
				*mappedPort = mapped;
				return address != 0;
			}
			offset += 4 + length + ((length % 4) ? (4 - length % 4) : 0);
		}
	}
	return false;
}

}

DirectLink::DirectLink() {
	m_tag = QRandomGenerator::global()->generate();
}

DirectLink::~DirectLink() {
	close();
	if (m_sock >= 0) {
		closesocket(socket_t(m_sock));
		m_sock = -1;
	}
}

qint64 DirectLink::nowMs() const {
	return QDateTime::currentMSecsSinceEpoch();
}

bool DirectLink::bind(QString* error) {
	if (m_sock >= 0) {
		return true;
	}
#ifdef _WIN32
	static bool wsaReady = false;
	if (!wsaReady) {
		WSADATA data;
		WSAStartup(MAKEWORD(2, 2), &data);
		wsaReady = true;
	}
#endif
	socket_t sock = socket(AF_INET, SOCK_DGRAM, 0);
	if (sock == socket_t(-1)) {
		if (error) {
			*error = QStringLiteral("无法创建直连 UDP 套接字");
		}
		return false;
	}
	sockaddr_in local;
	std::memset(&local, 0, sizeof(local));
	local.sin_family = AF_INET;
	local.sin_addr.s_addr = INADDR_ANY;
	local.sin_port = 0;
	if (::bind(sock, reinterpret_cast<sockaddr*>(&local), sizeof(local)) != 0) {
		closesocket(sock);
		if (error) {
			*error = QStringLiteral("无法绑定直连 UDP 端口");
		}
		return false;
	}
	socklen_t len = sizeof(local);
	if (getsockname(sock, reinterpret_cast<sockaddr*>(&local), &len) == 0) {
		m_localPort = ntohs(local.sin_port);
	}
	m_sock = intptr_t(sock);
	return true;
}

QStringList DirectLink::candidates() {
	QStringList local;
	if (m_sock < 0 && !bind()) {
		return local;
	}
	// 本机网卡地址：同局域网时这是最快路径（1-3ms），也顺手覆盖"公网打洞
	// 失败但两台机器其实在同一台路由器后面"的情况。
	//
	// 【排序要按"这条路径实际有多快"来】枚举顺序是随机的，机器上常见的
	// 172.16/12 地址（Hyper-V / WSL / Docker 的虚拟网卡）会排到真正的
	// 192.168.x 前面；打洞是"第一个 RESP 到达即锁定对端"，于是两端会锁在
	// 虚拟网卡上——实测 172.18.0.1 路径 RTT 22~74ms，而同一台机器的
	// 192.168.1.5 只有 1~3ms。这里按网段给优先级：
	//   192.168/16 与 10/8 是真局域网 → 最前
	//   其它（公网网卡）           → 中间
	//   172.16/12                  → 最后（几乎总是容器/虚拟机虚拟网卡）
	const auto addresses = QNetworkInterface::allAddresses();
	QList<QPair<int, QString>> ranked;
	for (const QHostAddress& address : addresses) {
		if (address.protocol() != QAbstractSocket::IPv4Protocol || address.isLoopback()) {
			continue;
		}
		quint32 ip = htonl(address.toIPv4Address());
		if (ip == 0) {
			continue;
		}
		// 用与接收侧共用的同一把尺子排序（网段判断在 candidatePriority 内，
		// 内部按主机字节序还原；详见该函数注释里 11-16 的死锁根因）。
		ranked.append(qMakePair(candidatePriority(ip), candidateText(ip, m_localPort)));
	}
	std::stable_sort(ranked.begin(), ranked.end(),
	                 [](const QPair<int, QString>& a, const QPair<int, QString>& b) {
		                 return a.first < b.first;
	                 });
	for (const auto& entry : ranked) {
		if (!local.contains(entry.second)) {
			local.append(entry.second);
		}
		if (local.size() >= 3) {
			break;
		}
	}
	// STUN 的公网映射地址放最前面：跨网联机只认它（候选只发两条，不能把它
	// 挤掉）；同局域网时它通常打不通（路由器不支持回环），对端会自动落到
	// 第二条网卡地址上。
	QStringList list;
	quint32 mappedIp = 0;
	quint16 mappedPort = 0;
	if (stunLookup(socket_t(m_sock), "stun.miwifi.com", 3478, &mappedIp, &mappedPort)
	    || stunLookup(socket_t(m_sock), "stun.l.google.com", 19302, &mappedIp, &mappedPort)) {
		// 同机/同局域网测试（MGBAX_DIRECT_LOCAL_FIRST=1）：把本机网卡地址
		// 排到公网映射前面。打洞是「第一个 RESP 到达即锁定对端」，默认把
		// STUN 放首位会让同一台机器上的两端绕公网反射地址（实测 50ms、
		// 抖动到 200ms+），而本机网卡路径是 1-3ms。跨网生产环境不设此开关，
		// 行为完全不变；本机地址打不通时公网映射仍在列表里作兜底。
		if (qEnvironmentVariableIsEmpty("MGBAX_DIRECT_LOCAL_FIRST")) {
			list.append(candidateText(mappedIp, mappedPort));
		}
	}
	for (const QString& text : local) {
		if (!list.contains(text)) {
			list.append(text);
		}
	}
	if (mappedIp && !qEnvironmentVariableIsEmpty("MGBAX_DIRECT_LOCAL_FIRST")) {
		QString stun = candidateText(mappedIp, mappedPort);
		if (!list.contains(stun)) {
			list.append(stun);
		}
	}
	return list;
}

void DirectLink::setPeerCandidates(const QStringList& list) {
	m_peerCandidates.clear();
	for (const QString& text : list) {
		quint32 ip = 0;
		quint16 port = 0;
		if (parseCandidate(text, &ip, &port)) {
			Candidate candidate;
			candidate.ip = ip;
			candidate.port = port;
			m_peerCandidates.append(candidate);
		}
	}
	/* 【11-16 死锁修复】必须按与公告侧 candidates() 相同的规则重排。
	 * 原实现原样保留收到的顺序就打洞，而两端枚举网卡/STUN 的时机不同，
	 * 对端实际收到的顺序会和它本地公告的不一致：B 本地发的是
	 * 192.168 在前，A 收到的却是 172.18 在前。打洞「第一个 RESP 锁定」，
	 * 于是 A 锁 172.18、B 锁 192.168，之后互相的包全被「忽略来自…」丢弃，
	 * pushIn=0、联机 pc 永远 0（所有历史 flow 都卡在这里）。
	 * 两端都用 candidatePriority 重排后，都会优先打 192.168，锁同一地址。
	 * stable_sort 保留同优先级候选的原有相对顺序（如多块 192.168 网卡）。 */
	std::stable_sort(m_peerCandidates.begin(), m_peerCandidates.end(),
	                 [](const Candidate& a, const Candidate& b) {
		                 return candidatePriority(a.ip) < candidatePriority(b.ip);
	                 });
	m_sendTargets = m_peerCandidates;
	/* 机器可读的排序结果：下一次 P2P 死锁排查只要看这一行就能确认两端
	 * 是否都把 192.168/10 排在前、172.16 虚拟网卡垫底（F7 的现场证据）。 */
	GbCloud::debugLog(QStringLiteral("[direct] 对端候选排序 n=%1 sorted=%2")
	                          .arg(m_peerCandidates.size())
	                          .arg(sendTargetsText().join(QLatin1Char(','))));
}

QStringList DirectLink::sendTargetsText() const {
	QStringList out;
	for (const Candidate& c : m_sendTargets) {
		out.append(candidateText(c.ip, c.port));
	}
	return out;
}

QString DirectLink::diagnosticsText() const {
	const bool active = m_connected && m_havePeer && !m_closed;
	const int avgMs = (m_rttUs + 500) / 1000;
	return QStringLiteral("via=%1 avg=%2ms peerCandidates=%3 direct=%4 ignored=%5 peer=%6")
	    .arg(active ? QStringLiteral("p2p") : QStringLiteral("tunnel"))
	    .arg(avgMs)
	    .arg(m_peerCandidates.size())
	    .arg(active ? 1 : 0)
	    .arg(m_ignoredFromCount)
	    .arg(m_peerText.isEmpty() ? QStringLiteral("-") : m_peerText);
}

void DirectLink::startPunching() {
	if (m_sock < 0) {
		return;
	}
	m_punching = true;
	m_punchStart = nowMs();
	m_lastProbe = 0;
}

void DirectLink::sendPacket(Type type, quint16 seq, const QByteArray& payload, const Candidate& to) {
	if (m_sock < 0 || to.ip == 0 || to.port == 0) {
		return;
	}
	QByteArray packet;
	packet.resize(HEADER_BYTES + payload.size());
	char* p = packet.data();
	std::memcpy(p, MAGIC, 4);
	p[4] = char(VERSION);
	p[5] = char(type);
	put16(p + 6, seq);
	put16(p + 8, m_ackSeen ? m_ackSeq : quint16(0));
	put32(p + 10, m_ackSeen ? m_ackBits : 0);
	put32(p + 14, m_tag);
	if (!payload.isEmpty()) {
		std::memcpy(p + HEADER_BYTES, payload.constData(), size_t(payload.size()));
	}
	sockaddr_in target;
	std::memset(&target, 0, sizeof(target));
	target.sin_family = AF_INET;
	target.sin_addr.s_addr = to.ip;
	target.sin_port = htons(to.port);
	sendto(socket_t(m_sock), packet.constData(), packet.size(), 0,
	       reinterpret_cast<sockaddr*>(&target), sizeof(target));
}

void DirectLink::sendControl(const Candidate& to) {
	sendPacket(TYPE_CTRL, 0, QByteArray(), to);
}

void DirectLink::noteReceived(quint16 seq) {
	if (!m_ackSeen) {
		m_ackSeen = true;
		m_ackSeq = seq;
		m_ackBits = 0;
		return;
	}
	int delta = int(qint16(seq - m_ackSeq));
	if (delta > 0) {
		m_ackBits = (delta >= 32) ? 0 : (m_ackBits << delta);
		if (delta <= 32) {
			m_ackBits |= (1u << (delta - 1));
		}
		m_ackSeq = seq;
	} else if (delta < 0 && -delta <= 32) {
		m_ackBits |= (1u << (-delta - 1));
	}
}

void DirectLink::noteAck(quint16 ackSeq, quint32 ackBits) {
	if (m_outgoing.isEmpty()) {
		return;
	}
	qint64 now = nowMs();
	QQueue<Outgoing> keep;
	while (!m_outgoing.isEmpty()) {
		Outgoing out = m_outgoing.dequeue();
		int delta = int(qint16(ackSeq - out.seq));
		bool acked = delta >= 0;
		if (!acked && -delta <= 32) {
			acked = (ackBits & (1u << (-delta - 1))) != 0;
		}
		if (acked) {
			if (out.firstSent > 0) {
				int sample = int((now - out.firstSent) * 1000);
				m_rttUs = m_rttUs ? (m_rttUs * 3 + sample) / 4 : sample;
			}
			continue;
		}
		keep.append(out);
	}
	m_outgoing = keep;
	pumpSend(); // 腾出的窗口立刻给压着的分片
}

void DirectLink::handlePacket(const char* data, int len, const Candidate& from) {
	if (len < HEADER_BYTES || std::memcmp(data, MAGIC, 4) != 0 || quint8(data[4]) != VERSION) {
		return;
	}
	Type type = Type(quint8(data[5]));
	quint16 seq = get16(data + 6);
	quint16 ackSeq = get16(data + 8);
	quint32 ackBits = get32(data + 10);
	QByteArray payload(data + HEADER_BYTES, len - HEADER_BYTES);

	if (type == TYPE_BYE) {
		GbCloud::debugLog(QStringLiteral("[direct] 收到对端 BYE（seq=%1）→ 直连关闭").arg(seq));
		m_closed = true;
		return;
	}
	if (type == TYPE_PROBE) {
		// 收到探针只代表"对端发出的包能到我们"，还不能断定反向也通，
		// 所以先回 RESP，连通判定留给 RESP/DATA。
		// payload 原样回带：里面是发方写的时间戳，用来在还没有任何联机
		// 数据时就量出真实往返时延（决定要不要真的从隧道切过来）。
		sendPacket(TYPE_RESP, seq, payload, from);
		return;
	}
	if (!m_connected
	    && (type == TYPE_RESP || type == TYPE_DATA || type == TYPE_CTRL || type == TYPE_FRAG)) {
		m_connected = true;
		m_punching = false;
		m_peer = from;
		m_peerText = candidateText(from.ip, from.port);
		m_havePeer = true;
		m_lastRecv = nowMs();
		pumpSend(); // 打通前攒下的消息（含整份存档的分片）立刻放行
		GbCloud::debugLog(QStringLiteral("[direct] P2P 已启用 %1").arg(diagnosticsText()));
	} else if (m_connected && (from.ip != m_peer.ip || from.port != m_peer.port)) {
		/* 【连通后不再跟随来源地址】原来这里无条件 `m_peer = from;`，
		 * 任何来源的包都会把对端改指过去。两台在同一局域网时，对端会
		 * 同时出现在「内网地址」和「公网回环地址」两处，于是流量会在
		 * 一次 RTT 抖动后悄悄从内网 1~3ms 迁到公网回环几十上百毫秒上，
		 * 而界面上仍显示「直连已启用」——11-15 实测 PC↔模拟器 P2P
		 * 每轮 72~159ms（真机同 Wi-Fi 只有 6~11ms），根因就在这里。
		 * NAT 重绑定极少见，且换地址时对端会重新发 PROBE/CTRL 走新
		 * 候选；真需要换地址时上面的 !m_connected 分支会接住。 */
		++m_ignoredFromCount;
		GbCloud::debugLog(QStringLiteral("[direct] 忽略来自 %1 的包（已连 %2） ignored=%3")
		                          .arg(candidateText(from.ip, from.port))
		                          .arg(m_peerText)
		                          .arg(m_ignoredFromCount));
		m_lastRecv = nowMs();
	} else {
		m_lastRecv = nowMs();
	}

	if (type == TYPE_RESP) {
		if (payload.size() >= 4) {
			qint64 sent = qint64(get32(payload.constData()));
			qint64 sample = ((nowMs() & 0xFFFFFFFFLL) - sent) & 0xFFFFFFFFLL;
			if (sample < 5000) {
				int us = int(sample * 1000);
				m_rttUs = m_rttUs ? (m_rttUs * 3 + us) / 4 : us;
			}
		}
		return;
	}

	noteAck(ackSeq, ackBits);

	if (type == TYPE_DATA || type == TYPE_FRAG) {
		noteReceived(seq);
		if (!m_rcvStarted) {
			m_rcvStarted = true;
			m_rcvNext = seq;
		}
		int delta = int(qint16(seq - m_rcvNext));
		if (delta >= 0 && !m_incoming.contains(seq)) {
			Incoming item;
			item.kind = quint8(type);
			item.payload = payload;
			m_incoming.insert(seq, item);
		}
		while (m_incoming.contains(m_rcvNext)) {
			const Incoming item = m_incoming.take(m_rcvNext);
			deliverFrame(item.kind, item.payload);
			++m_rcvNext;
		}
		// 立刻单独回一个控制包：联机线是一问一答，这个 ACK 直接决定
		// 下一回合多快能开始。
		sendControl(from);
	}
}

bool DirectLink::waitReadable(int timeoutMs) {
	if (m_sock < 0) {
		return false;
	}
	fd_set rset;
	FD_ZERO(&rset);
	FD_SET(socket_t(m_sock), &rset);
	timeval tv;
	tv.tv_sec = timeoutMs / 1000;
	tv.tv_usec = (timeoutMs % 1000) * 1000;
	return select(int(socket_t(m_sock)) + 1, &rset, nullptr, nullptr, &tv) > 0;
}

bool DirectLink::readSocket(int timeoutMs) {
	if (!waitReadable(timeoutMs)) {
		return false;
	}
	bool got = false;
	for (int guard = 0; guard < 32; ++guard) {
		char buffer[2048];
		sockaddr_in from;
		socklen_t fromLen = sizeof(from);
		int n = int(recvfrom(socket_t(m_sock), buffer, sizeof(buffer), 0,
		                     reinterpret_cast<sockaddr*>(&from), &fromLen));
		if (n <= 0) {
			break;
		}
		Candidate candidate;
		candidate.ip = from.sin_addr.s_addr;
		candidate.port = ntohs(from.sin_port);
		handlePacket(buffer, n, candidate);
		got = true;
		if (!waitReadable(0)) {
			break;
		}
	}
	return got;
}

void DirectLink::flushRetransmits(qint64 now) {
	if (m_outgoing.isEmpty() || !m_havePeer) {
		return;
	}
	int rto = m_rttUs ? qMax(20, (m_rttUs / 1000) * 3 / 2) : 50;
	rto = qMin(rto, 200);
	for (Outgoing& out : m_outgoing) {
		if (now - out.lastSent < rto) {
			continue;
		}
		if (++out.tries > 40) {
			/* 排障必需：重传超限是「直连悄悄消失」最常见的原因，但原来只把
			 * m_closed 置真，日志里只剩上层一句「隧道连接已断开」，看不出是
			 * 哪个分片、多大、RTT 多少。 */
			GbCloud::debugLog(QStringLiteral(
			        "[direct] 重传超限 → 关闭：seq=%1 kind=%2 %3B 待确认=%4 rtt=%5us")
			                          .arg(out.seq)
			                          .arg(int(out.kind))
			                          .arg(out.payload.size())
			                          .arg(m_outgoing.size())
			                          .arg(m_rttUs));
			m_closed = true;
			return;
		}
		sendPacket(Type(out.kind), out.seq, out.payload, m_peer);
		out.lastSent = now;
		if (!out.firstSent) {
			out.firstSent = now;
		}
	}
}

bool DirectLink::pump(int timeoutMs) {
	if (m_sock < 0 || m_closed) {
		if (timeoutMs > 0) {
			QThread::msleep(ulong(timeoutMs));
		}
		return false;
	}
	bool got = readSocket(timeoutMs);
	qint64 now = nowMs();
	if (!m_connected && m_punching && !m_sendTargets.isEmpty()) {
		if (now - m_lastProbe >= PROBE_MS) {
			m_lastProbe = now;
			QByteArray stamp(4, '\0');
			put32(stamp.data(), quint32(now & 0xFFFFFFFFLL));
			for (const Candidate& candidate : m_sendTargets) {
				sendPacket(TYPE_PROBE, ++m_probeSeq, stamp, candidate);
			}
		}
	} else if (m_connected && now - m_lastKeepalive >= KEEPALIVE_MS) {
		m_lastKeepalive = now;
		QByteArray stamp(4, '\0');
		put32(stamp.data(), quint32(now & 0xFFFFFFFFLL));
		sendPacket(TYPE_PROBE, 0, stamp, m_peer);
	}
	flushRetransmits(now);
	/* 每 10 秒把机器可读的 P2P 状态落盘一次：avg= 是握手段快慢的唯一
	 * 现场量（ADR-003 §6 / §7 R-2），direct=1 + ignored>0 用来证明 F5
	 * 真的生效，而不是界面显示「直连已启用」的假象。 */
	if (m_connected && now - m_lastDiagLog >= 10000) {
		m_lastDiagLog = now;
		GbCloud::debugLog(QStringLiteral("[direct] p2p-rtt %1").arg(diagnosticsText()));
	}
	// 空闲看门狗：对端掉线（切基站、NAT 表被清、程序退出）时 UDP 不会
	// 报错，只会在重传里越耗越久。超过 IDLE_CLOSE_MS 一个包都没收到就
	// 主动关掉，让上层回落到服务器隧道——总比游戏卡在等对端强。
	if (m_connected && m_lastRecv && now - m_lastRecv > IDLE_CLOSE_MS) {
		GbCloud::debugLog(QStringLiteral("[direct] %1ms 无入站包 → 空闲关闭").arg(now - m_lastRecv));
		m_closed = true;
	}
	return got;
}

void DirectLink::send(const QByteArray& payload) {
	if (m_closed || m_sock < 0) {
		return;
	}
	enqueue(TYPE_DATA, payload);
}

/** 拆片入队。GBoy 的 KCP 在 512 MTU 上做同样的事（frg 字段），这里由
 *  DirectLink 自己的可靠层按序交付，所以分片只需「先 START 带总长，再 CONT」。
 *  单包消息（按键、节奏、联机线 20 字节包）仍走 TYPE_DATA，延迟特性不变。 */
void DirectLink::enqueue(quint8 kind, const QByteArray& payload) {
	if (payload.size() <= FRAG_CHUNK) {
		Outgoing out;
		out.seq = m_nextSeq++;
		out.kind = kind;
		out.payload = payload;
		m_pending.append(out);
		pumpSend();
		return;
	}
	const int total = payload.size();
	int offset = 0;
	bool start = true;
	while (offset < total) {
		const int head = start ? FRAG_HEAD : FRAG_HEAD_CONT;
		const int take = qMin(FRAG_CHUNK, total - offset);
		QByteArray chunk(head + take, '\0');
		chunk[0] = char(start ? FRAG_START : FRAG_CONT);
		if (start) {
			put32(chunk.data() + 1, quint32(total));
		}
		std::memcpy(chunk.data() + head, payload.constData() + offset, size_t(take));
		Outgoing out;
		out.seq = m_nextSeq++;
		out.kind = TYPE_FRAG;
		out.payload = chunk;
		m_pending.append(out);
		offset += take;
		start = false;
	}
	pumpSend();
}

void DirectLink::pumpSend() {
	if (!m_havePeer) {
		return; // 还没打通：包先攒着，连通后一起放行
	}
	while (!m_pending.isEmpty() && m_outgoing.size() < SEND_WINDOW) {
		Outgoing out = m_pending.dequeue();
		out.firstSent = 0;
		out.lastSent = nowMs();
		out.tries = 1;
		m_outgoing.append(out);
		sendPacket(Type(out.kind), out.seq, out.payload, m_peer);
	}
}

/** 按序交付：小消息直接进 inbox；分片拼进 m_fragBuf，攒够 total 才交付。
 *  重排缓存保证了分片严格按发送顺序到达这里，因此不需要偏移量。 */
void DirectLink::deliverFrame(quint8 kind, const QByteArray& payload) {
	if (kind != TYPE_FRAG) {
		m_inbox.append(payload);
		return;
	}
	if (payload.isEmpty()) {
		return;
	}
	const quint8 flag = quint8(payload[0]);
	if (flag == FRAG_START) {
		if (payload.size() < FRAG_HEAD) {
			return;
		}
		m_fragTotal = int(get32(payload.constData() + 1));
		m_fragBuf = payload.mid(FRAG_HEAD);
	} else {
		m_fragBuf.append(payload.mid(FRAG_HEAD_CONT));
	}
	if (m_fragTotal > 0 && m_fragBuf.size() >= m_fragTotal) {
		QByteArray whole = m_fragBuf.left(m_fragTotal);
		m_fragBuf.clear();
		m_fragTotal = 0;
		m_inbox.append(whole);
	}
}

bool DirectLink::recv(QByteArray* out, int timeoutMs) {
	if (!m_inbox.isEmpty()) {
		*out = m_inbox.dequeue();
		return true;
	}
	qint64 deadline = nowMs() + qMax(timeoutMs, 0);
	while (true) {
		qint64 remaining = deadline - nowMs();
		qint64 slice = remaining > 20 ? 20 : (remaining > 0 ? remaining : 1);
		pump(int(slice));
		if (!m_inbox.isEmpty()) {
			*out = m_inbox.dequeue();
			return true;
		}
		if (m_closed || nowMs() >= deadline) {
			return false;
		}
	}
}

void DirectLink::close() {
	if (m_closed) {
		return;
	}
	if (m_sock >= 0 && m_havePeer) {
		sendPacket(TYPE_BYE, 0, QByteArray(), m_peer);
	}
	m_closed = true;
	m_punching = false;
}
