/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "KcpChannel.h"

#include <QDateTime>
#include <QHostAddress>
#include <QRandomGenerator>
#include <QString>
#include <QThread>

#include <array>
#include <cstring>
#include <cstdio>

#ifdef _WIN32
#include <winsock2.h>
#include <ws2tcpip.h>
typedef int socklen_t;
#else
#include <arpa/inet.h>
#include <fcntl.h>
#include <netdb.h>
#include <netinet/in.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <unistd.h>
#endif

using namespace QGBA;

namespace {

constexpr int OVERHEAD = 24;
constexpr int CMD_PUSH = 81;
constexpr int CMD_ACK = 82;

// Official GBoy parameters.
constexpr int MTU = KcpChannel::UDP_MTU;
constexpr int WND = KcpChannel::UDP_WND;
constexpr int INTERVAL_MS = KcpChannel::UDP_INTERVAL_MS;

constexpr unsigned char HS[] = {'H', 'S'};
constexpr unsigned char HK[] = {'H', 'K'};
constexpr unsigned char PING[] = {'P', 'I', 'N', 'G'};
constexpr unsigned char PONG[] = {'P', 'O', 'N', 'G'};
constexpr unsigned char DISC[] = {'D', 'I', 'S', 'C'};

quint32 readInt(const QByteArray& in, int off) {
	const uchar* p = reinterpret_cast<const uchar*>(in.constData()) + off;
	return (quint32(p[0]) << 24) | (quint32(p[1]) << 16) | (quint32(p[2]) << 8) | quint32(p[3]);
}

quint32 readShort(const QByteArray& in, int off) {
	const uchar* p = reinterpret_cast<const uchar*>(in.constData()) + off;
	return (quint32(p[0]) << 8) | quint32(p[1]);
}

quint32 readInt(const char* in, int off) {
	const uchar* p = reinterpret_cast<const uchar*>(in) + off;
	return (quint32(p[0]) << 24) | (quint32(p[1]) << 16) | (quint32(p[2]) << 8) | quint32(p[3]);
}

void writeInt(QByteArray* out, int off, quint32 value) {
	uchar* p = reinterpret_cast<uchar*>(out->data()) + off;
	p[0] = uchar(value >> 24);
	p[1] = uchar(value >> 16);
	p[2] = uchar(value >> 8);
	p[3] = uchar(value);
}

void initSockets() {
#ifdef _WIN32
	static bool inited = false;
	if (!inited) {
		WSADATA data;
		WSAStartup(MAKEWORD(2, 2), &data);
		inited = true;
	}
#endif
}

void closeSocketFd(intptr_t fd) {
	if (fd < 0) {
		return;
	}
#ifdef _WIN32
	closesocket(SOCKET(fd));
#else
	::close(fd);
#endif
}

bool waitForRead(intptr_t fd, int timeoutMs) {
	fd_set set;
	FD_ZERO(&set);
#ifdef _WIN32
	FD_SET(SOCKET(fd), &set);
#else
	FD_SET(fd, &set);
#endif
	timeval tv{timeoutMs / 1000, (timeoutMs % 1000) * 1000};
	return select(int(fd) + 1, &set, nullptr, nullptr, &tv) > 0;
}

}

namespace QGBA {

QByteArray KcpChannel::Seg::encode() const {
	QByteArray out(OVERHEAD + data.size(), 0);
	writeInt(&out, 0, conv);
	out[4] = char(cmd);
	out[5] = char(frg);
	writeInt(&out, 6, quint32(wnd));
	writeInt(&out, 8, ts);
	writeInt(&out, 12, sn);
	writeInt(&out, 16, una);
	writeInt(&out, 20, quint32(data.size()));
	memcpy(out.data() + OVERHEAD, data.constData(), data.size());
	return out;
}

KcpChannel::Kcp::Kcp(quint32 c, int mtu, int interval)
	: conv(c)
	, mss(mtu - OVERHEAD)
	, intervalMs(interval)
{
}

int KcpChannel::Kcp::window() const {
	int free = WND - int(rcvQueue.size()) - int(rcvBuf.size());
	return free < 0 ? 0 : free;
}

void KcpChannel::Kcp::input(const QByteArray& data) {
	std::lock_guard<std::mutex> guard(mutex);
	if (data.size() < OVERHEAD) {
		return;
	}
	quint32 incoming = readInt(data, 0);
	if (incoming != conv) {
		return;
	}
	int cmd = uchar(data[4]);
	int frg = uchar(data[5]);
	quint32 wnd = readShort(data, 6);
	quint32 ts = readInt(data, 8);
	quint32 sn = readInt(data, 12);
	quint32 una = readInt(data, 16);
	quint32 len = readInt(data, 20);
	if (len > quint32(data.size() - OVERHEAD)) {
		return;
	}
	QByteArray payload = data.mid(OVERHEAD, int(len));
	rmtWnd = wnd;
	ackUpTo(int(una) - 1, -1);
	if (cmd == CMD_ACK) {
		ackUpTo(int(sn), int(ts));
	} else if (cmd == CMD_PUSH) {
		acks.push_back({int(sn), int(ts)});
		recvPush(sn, frg, payload);
	}
}

void KcpChannel::Kcp::ackUpTo(int uptoSn, int exactTs) {
	if (exactTs >= 0) {
		for (int i = int(sndBuf.size()) - 1; i >= 0; i--) {
			const Seg& seg = sndBuf[i];
			if (int(seg.sn) == uptoSn && int(seg.ts) == exactTs) {
				sndBuf.erase(sndBuf.begin() + i);
			}
		}
	}
	for (int i = int(sndBuf.size()) - 1; i >= 0; i--) {
		if (int(sndBuf[i].sn) <= uptoSn) {
			sndBuf.erase(sndBuf.begin() + i);
		}
	}
	if (!sndBuf.empty()) {
		sndUna = sndBuf.front().sn;
	} else {
		sndUna = sndNxt;
	}
}

void KcpChannel::Kcp::recvPush(int sn, int frg, const QByteArray& payload) {
	if (sn < rcvNxt) {
		return;
	}
	if (sn == rcvNxt) {
		deliver(sn, frg, payload);
		while (rcvBuf.count(rcvNxt)) {
			Seg seg = rcvBuf[rcvNxt];
			rcvBuf.erase(rcvNxt);
			deliver(seg.sn, seg.frg, seg.data);
		}
	} else {
		Seg seg;
		seg.sn = sn;
		seg.frg = frg;
		seg.data = payload;
		rcvBuf[sn] = seg;
	}
}

void KcpChannel::Kcp::deliver(int sn, int frg, const QByteArray& payload) {
	if (frgRemaining == 0 && frg == 0) {
		rcvQueue.push_back(payload);
		rcvNxt = sn + 1;
		return;
	}
	if (frgRemaining == 0) {
		parts.clear();
		parts.push_back(payload);
		frgRemaining = frg;
	} else {
		parts.push_back(payload);
		frgRemaining--;
	}
	if (frgRemaining == 0 && !parts.empty()) {
		QByteArray whole;
		whole.reserve(parts.size());
		for (const QByteArray& part : parts) {
			whole.append(part);
		}
		rcvQueue.push_back(whole);
		parts.clear();
	}
	rcvNxt = sn + 1;
}

void KcpChannel::Kcp::send(const QByteArray& data) {
	std::lock_guard<std::mutex> guard(mutex);
	if (data.size() <= mss) {
		sndQueue.push_back(data);
		return;
	}
	int chunks = int((data.size() + mss - 1) / mss);
	for (int i = 0; i < chunks; i++) {
		int end = int(qMin<qsizetype>(data.size(), (i + 1) * mss));
		sndQueue.push_back(data.mid(i * mss, end - i * mss));
	}
}

QByteArray KcpChannel::Kcp::recv() {
	std::lock_guard<std::mutex> guard(mutex);
	if (rcvQueue.empty()) {
		return QByteArray();
	}
	QByteArray out = rcvQueue.front();
	rcvQueue.pop_front();
	return out;
}

std::vector<QByteArray> KcpChannel::Kcp::update(qint64 now) {
	std::lock_guard<std::mutex> guard(mutex);
	std::vector<QByteArray> out;
	if (now < nextUpdate) {
		return out;
	}
	nextUpdate = now + intervalMs;
	for (const auto& ack : acks) {
		Seg seg;
		seg.conv = conv;
		seg.cmd = CMD_ACK;
		seg.sn = quint32(ack[0]);
		seg.ts = quint32(ack[1]);
		seg.wnd = window();
		seg.una = rcvNxt;
		out.push_back(seg.encode());
	}
	acks.clear();
	while (!sndQueue.empty() && sndBuf.size() < WND) {
		QByteArray data = sndQueue.front();
		sndQueue.pop_front();
		Seg seg;
		seg.conv = conv;
		seg.cmd = CMD_PUSH;
		seg.frg = 0;
		if (data.size() == mss && !sndQueue.empty()) {
			seg.frg = qMin(int(sndQueue.size()), 255);
		}
		seg.wnd = window();
		seg.ts = quint32(now & 0xFFFFFFFFLL);
		seg.sn = sndNxt;
		seg.una = rcvNxt;
		seg.data = data;
		seg.resendts = now;
		seg.rto = rto;
		sndBuf.push_back(seg);
		sndNxt++;
	}
	for (Seg& seg : sndBuf) {
		bool need;
		if (seg.xmit == 0) {
			need = true;
		} else if (now >= seg.resendts) {
			need = true;
			seg.rto = qMin<qint64>(seg.rto * 2, 5000);
			seg.resendts = now + seg.rto;
		} else {
			need = false;
		}
		if (need) {
			seg.xmit++;
			seg.wnd = window();
			seg.ts = quint32(now & 0xFFFFFFFFLL);
			seg.una = rcvNxt;
			out.push_back(seg.encode());
		}
	}
	return out;
}

KcpChannel::KcpChannel(quint32 conv, const QString& host, quint16 port, bool tcp)
	: m_conv(conv)
	, m_tcp(tcp)
	, m_host(host)
	, m_port(port)
{
	m_kcp = std::make_unique<Kcp>(conv, MTU, INTERVAL_MS);
}

KcpChannel::~KcpChannel() {
	close();
}

bool KcpChannel::resolve(const QString& host, quint16 port, Endpoint* endpoint, bool tcp, QString* error) {
	initSockets();
	QByteArray hostUtf8 = host.toUtf8();
	addrinfo hints{};
	hints.ai_family = AF_INET;
	hints.ai_socktype = tcp ? SOCK_STREAM : SOCK_DGRAM;
	addrinfo* result = nullptr;
	int rc = getaddrinfo(hostUtf8.constData(), nullptr, &hints, &result);
	if (rc != 0 || !result) {
		if (error) {
			*error = QString::fromUtf8("无法解析地址 %1").arg(host);
		}
		return false;
	}
	sockaddr_in addr{};
	memcpy(&addr, result->ai_addr, qMin<int>(result->ai_addrlen, int(sizeof(addr))));
	freeaddrinfo(result);
	endpoint->ip = addr.sin_addr.s_addr;
	endpoint->port = htons(port);
	return true;
}

KcpChannel* KcpChannel::open(const QString& host, quint16 port, quint32 conv, QString* error) {
	KcpChannel* channel = new KcpChannel(conv, host, port, false);
	if (!channel->openSockets(error)) {
		delete channel;
		return nullptr;
	}
	channel->m_running = true;
	channel->m_thread = std::thread([channel]() { channel->pumpLoop(); });
	channel->m_threadStarted = true;
	return channel;
}

KcpChannel* KcpChannel::openTcp(const QString& host, quint16 port, QString* error) {
	KcpChannel* channel = new KcpChannel(0, host, port, true);
	if (!channel->openSockets(error)) {
		delete channel;
		return nullptr;
	}
	channel->m_running = true;
	channel->m_thread = std::thread([channel]() { channel->pumpLoop(); });
	channel->m_threadStarted = true;
	return channel;
}

bool KcpChannel::openSockets(QString* error) {
	if (!resolve(m_host, m_port, &m_endpoint, m_tcp, error)) {
		return false;
	}
	sockaddr_in addr{};
	addr.sin_family = AF_INET;
	addr.sin_addr.s_addr = m_endpoint.ip;
	addr.sin_port = m_endpoint.port;
	initSockets();
	if (m_tcp) {
		intptr_t fd = intptr_t(socket(AF_INET, SOCK_STREAM, IPPROTO_TCP));
		if (fd < 0) {
			if (error) {
				*error = QString::fromUtf8("无法建立连接");
			}
			return false;
		}
		if (connect(SOCKET(fd), reinterpret_cast<sockaddr*>(&addr), sizeof(addr)) != 0) {
			closeSocketFd(fd);
			if (error) {
				*error = QString::fromUtf8("无法连接 %1").arg(m_host);
			}
			return false;
		}
		int one = 1;
#ifdef _WIN32
		setsockopt(SOCKET(fd), IPPROTO_TCP, TCP_NODELAY, reinterpret_cast<const char*>(&one), sizeof(one));
#else
		setsockopt(fd, IPPROTO_TCP, TCP_NODELAY, &one, sizeof(one));
#endif
		m_socket = fd;
	} else {
		intptr_t fd = intptr_t(socket(AF_INET, SOCK_DGRAM, 0));
		if (fd < 0) {
			if (error) {
				*error = QString::fromUtf8("无法建立连接");
			}
			return false;
		}
		m_socket = fd;
	}
	return true;
}

bool KcpChannel::handshake(int tries, int waitMs, QString* error) {
	for (int attempt = 0; attempt < tries && !m_handshakeDone; attempt++) {
		// 【裸 HS】中继的握手是裸数据报（2026-11-07 对新中继实测：裸 HS 立刻
		// 回裸 HK；KCP 段承载的 HS 反而没有回应）。数据帧仍走 KCP。
		rawDatagramSend(QByteArray(reinterpret_cast<const char*>(HS), sizeof(HS)));
		qint64 deadline = QDateTime::currentMSecsSinceEpoch() + waitMs;
		while (QDateTime::currentMSecsSinceEpoch() < deadline) {
			if (m_handshakeDone) {
				return true;
			}
			if (m_dead) {
				if (error) {
					*error = QString::fromUtf8("中继连接中断");
				}
				return false;
			}
			QThread::msleep(50);
		}
	}
	if (!m_handshakeDone) {
		if (error) {
			*error = QString::fromUtf8("中继握手超时（服务器未回应）");
		}
		close();
	}
	return m_handshakeDone;
}

bool KcpChannel::retryHandshake(int timeoutMs, QString* error) {
	qint64 deadline = QDateTime::currentMSecsSinceEpoch() + qMax(timeoutMs, 1);
	while (QDateTime::currentMSecsSinceEpoch() < deadline) {
		rawDatagramSend(QByteArray(reinterpret_cast<const char*>(HS), sizeof(HS)));
		qint64 stepEnd = qMin(deadline, QDateTime::currentMSecsSinceEpoch() + 2000);
		while (QDateTime::currentMSecsSinceEpoch() < stepEnd) {
			if (m_handshakeDone) {
				return true;
			}
			if (m_dead) {
				if (error) {
					*error = QString::fromUtf8("中继连接中断");
				}
				return false;
			}
			QThread::msleep(50);
		}
	}
	return m_handshakeDone;
}

void KcpChannel::send(const QByteArray& payload) {
	if (m_kcp) {
		m_kcp->send(payload);
		return;
	}
	tcpSend(payload);
}

void KcpChannel::rawDatagramSend(const QByteArray& payload) {
	if (m_socket < 0 || !m_running) {
		return;
	}
	if (m_tcp) {
		tcpSend(payload);
		return;
	}
	sockaddr_in addr{};
	addr.sin_family = AF_INET;
	addr.sin_addr.s_addr = m_endpoint.ip;
	addr.sin_port = m_endpoint.port;
#ifdef _WIN32
	::sendto(SOCKET(m_socket), payload.constData(), int(payload.size()), 0,
	         reinterpret_cast<const sockaddr*>(&addr), sizeof(addr));
#else
	::sendto(m_socket, payload.constData(), payload.size(), 0,
	         reinterpret_cast<const sockaddr*>(&addr), sizeof(addr));
#endif
}

bool KcpChannel::tcpSend(const QByteArray& payload) {
	if (m_socket < 0 || !m_running) {
		return false;
	}
	QByteArray head(4, 0);
	writeInt(&head, 0, quint32(payload.size()));
	QByteArray frame = head + payload;
	const char* p = frame.constData();
	int remaining = frame.size();
	int guard = 0;
	while (remaining > 0 && guard++ < 10000) {
		ssize_t n;
#ifdef _WIN32
		n = ::send(SOCKET(m_socket), p, remaining, 0);
#else
		n = ::send(m_socket, p, remaining, 0);
#endif
		if (n > 0) {
			p += n;
			remaining -= int(n);
			continue;
		}
		if (n < 0 && !waitForRead(m_socket, 1000)) {
			continue;
		}
		m_dead = true;
		m_running = false;
		return false;
	}
	return remaining == 0;
}

void KcpChannel::deliver(const QByteArray& message) {
	if (message.size() == 2 && memcmp(message.constData(), HK, 2) == 0) {
		m_handshakeDone = true;
		return;
	}
	if (message.size() == 4 && memcmp(message.constData(), PING, 4) == 0) {
		send(QByteArray(reinterpret_cast<const char*>(PONG), sizeof(PONG)));
		return;
	}
	if (message.size() == 4 && memcmp(message.constData(), PONG, 4) == 0) {
		return;
	}
	{
		std::lock_guard<std::mutex> guard(m_inboxMutex);
		m_inbox.push_back(message);
	}
	m_inboxCv.notify_one();
}

void KcpChannel::pumpLoop() {
	if (m_tcp) {
		// Framed TCP stream: read u32 length + payload.
		QByteArray pending;
		char chunk[4096];
		while (m_running && m_socket >= 0) {
			if (!waitForRead(m_socket, 200)) {
				continue;
			}
			ssize_t n;
#ifdef _WIN32
			n = ::recv(SOCKET(m_socket), chunk, sizeof(chunk), 0);
#else
			n = ::recv(m_socket, chunk, sizeof(chunk), 0);
#endif
			if (n <= 0) {
				if (m_running) {
					m_dead = true;
				}
				break;
			}
			pending.append(chunk, int(n));
			while (true) {
				if (pending.size() < 4) {
					break;
				}
				quint32 length = readInt(pending.constData(), 0);
				// MAX_FRAME_LENGTH rather than 65535: a save state is ~790 KiB
				// and the old ceiling killed the channel on the first state
				// transfer (see the header comment).
				if (length == 0 || length > MAX_FRAME_LENGTH) {
					m_dead = true;
					m_running = false;
					break;
				}
				if (pending.size() < int(4 + length)) {
					break;
				}
				QByteArray body = pending.mid(4, int(length));
				pending.remove(0, int(4 + length));
				deliver(body);
			}
			if (!m_running) {
				break;
			}
		}
		m_dead = true;
		m_running = false;
		return;
	}

	// KCP over UDP.
	char buffer[2048];
	qint64 lastPing = 0;
	while (m_running && m_socket >= 0) {
		qint64 now = QDateTime::currentMSecsSinceEpoch();
		sockaddr_in addr{};
		addr.sin_family = AF_INET;
		addr.sin_addr.s_addr = m_endpoint.ip;
		addr.sin_port = m_endpoint.port;
		if (waitForRead(m_socket, 5)) {
			sockaddr_in from{};
			socklen_t fromLen = sizeof(from);
#ifdef _WIN32
			int n = ::recvfrom(SOCKET(m_socket), buffer, sizeof(buffer), 0, reinterpret_cast<sockaddr*>(&from), &fromLen);
#else
			int n = int(::recvfrom(m_socket, buffer, sizeof(buffer), 0, reinterpret_cast<sockaddr*>(&from), &fromLen));
#endif
			if (n > 0) {
				// 【裸控制报】中继的 HS/HK/PING/PONG 是裸数据报（不是 KCP 段）：
				// 直接喂 kcp.input 会因为过不了 KCP 头解析而被静默丢弃。HK 必须
				// 在这里认领，否则握手永远完不成（2026-11-07 对新中继实测）。
				QByteArray datagram(buffer, int(n));
				if (datagram.size() == 2 && datagram.at(0) == 'H' && datagram.at(1) == 'K') {
					m_handshakeDone = true;
				} else if (datagram.size() == 4 && memcmp(datagram.constData(), PING, 4) == 0) {
					send(QByteArray(reinterpret_cast<const char*>(PONG), sizeof(PONG)));
				} else if (datagram.size() == 4 && memcmp(datagram.constData(), PONG, 4) == 0) {
					// keepalive echo; nothing to do
				} else {
					m_kcp->input(datagram);
				}
			}
		}
		QByteArray message;
		while (!(message = m_kcp->recv()).isEmpty()) {
			deliver(message);
		}
		if (m_handshakeDone && now - lastPing >= 1000) {
			lastPing = now;
			m_kcp->send(QByteArray(reinterpret_cast<const char*>(PING), sizeof(PING)));
		}
		std::vector<QByteArray> datagrams = m_kcp->update(QDateTime::currentMSecsSinceEpoch());
		for (const QByteArray& datagram : datagrams) {
			ssize_t rc;
#ifdef _WIN32
			rc = ::sendto(SOCKET(m_socket), datagram.constData(), int(datagram.size()), 0,
				reinterpret_cast<const sockaddr*>(&addr), sizeof(addr));
#else
			rc = ::sendto(m_socket, datagram.constData(), int(datagram.size()), 0,
				reinterpret_cast<const sockaddr*>(&addr), sizeof(addr));
#endif
			if (rc < 0 && m_running) {
				m_dead = true;
				m_running = false;
			}
		}
		QThread::msleep(4);
	}
}

bool KcpChannel::recv(QByteArray* out, int timeoutMs) {
	std::unique_lock<std::mutex> lock(m_inboxMutex);
	bool got = m_inboxCv.wait_for(lock, std::chrono::milliseconds(timeoutMs), [this]() {
		return !m_inbox.empty();
	});
	if (!got) {
		return false;
	}
	*out = m_inbox.front();
	m_inbox.pop_front();
	return true;
}

void KcpChannel::close() {
	// 这里原来第一行是 `if (!m_running) return;`。但 m_running 会被
	// pumpLoop / streamLoop 在对端断开时自己置成 false —— 于是「对端先断、
	// 再关房间」这条路直接返回，线程没有被 join。析构函数 ~KcpChannel() 调的
	// 也是 close()，同样 early return，最后 std::thread 析构时仍然 joinable
	// 就 std::terminate 掉整个进程（现场：terminate called without an active
	// exception）。云端联机里对端掉线后再关房间必崩，就是这个。
	//
	// 现在只用 wasRunning 决定「要不要发 DISC」，join 与资源清理无条件执行。
	bool wasRunning = m_running;
	m_running = false;
	if (wasRunning && m_kcp && m_socket >= 0) {
		m_kcp->send(QByteArray(reinterpret_cast<const char*>(DISC), sizeof(DISC)));
		std::vector<QByteArray> datagrams = m_kcp->update(QDateTime::currentMSecsSinceEpoch());
		sockaddr_in addr{};
		addr.sin_family = AF_INET;
		addr.sin_addr.s_addr = m_endpoint.ip;
		addr.sin_port = m_endpoint.port;
		for (const QByteArray& datagram : datagrams) {
#ifdef _WIN32
			::sendto(SOCKET(m_socket), datagram.constData(), int(datagram.size()), 0,
				reinterpret_cast<const sockaddr*>(&addr), sizeof(addr));
#else
			::sendto(m_socket, datagram.constData(), int(datagram.size()), 0,
				reinterpret_cast<const sockaddr*>(&addr), sizeof(addr));
#endif
		}
	}
	closeSocketFd(m_socket);
	m_socket = -1;
	if (m_threadStarted && m_thread.joinable()) {
		m_thread.join();
		m_threadStarted = false;
	}
	{
		std::lock_guard<std::mutex> guard(m_inboxMutex);
		m_inbox.clear();
	}
	m_inboxCv.notify_all();
}

}
