/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "TcpDirectLink.h"

#include "GBoyFrames.h"

#include <QDateTime>
#include <QHostAddress>
#include <QThread>

#include <cstring>

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

using namespace QGBA;

namespace {

/** 官方 AmA8tU 的 connect 超时是 10 秒、重试间隔 2 秒、总窗口 50 秒。 */
constexpr int CONNECT_TIMEOUT_MS = 10000;
constexpr qint64 RETRY_INTERVAL_MS = 2000;
constexpr qint64 RETRY_WINDOW_MS = 50000;

void put32(char* p, quint32 v) {
	p[0] = char((v >> 24) & 0xFF);
	p[1] = char((v >> 16) & 0xFF);
	p[2] = char((v >> 8) & 0xFF);
	p[3] = char(v & 0xFF);
}

int lastSocketError() {
#ifdef _WIN32
	return WSAGetLastError();
#else
	return errno;
#endif
}

bool wouldBlock(int code) {
#ifdef _WIN32
	return code == WSAEWOULDBLOCK || code == WSAEINPROGRESS;
#else
	return code == EWOULDBLOCK || code == EAGAIN || code == EINPROGRESS || code == EINTR;
#endif
}

/** 带超时的阻塞 connect（官方 setSoTimeout 之外那 10 秒 connect 窗口）。 */
intptr_t connectSocketNow(const QString& host, quint16 port, int timeoutMs, QString* error) {
	QByteArray hostUtf8 = host.toUtf8();
	addrinfo hints;
	std::memset(&hints, 0, sizeof(hints));
	hints.ai_family = AF_INET;
	hints.ai_socktype = SOCK_STREAM;
	hints.ai_protocol = IPPROTO_TCP;
	addrinfo* result = nullptr;
	if (getaddrinfo(hostUtf8.constData(), nullptr, &hints, &result) != 0 || !result) {
		if (error) {
			*error = QStringLiteral("无法解析 %1").arg(host);
		}
		return -1;
	}
	sockaddr_in addr;
	std::memset(&addr, 0, sizeof(addr));
	std::memcpy(&addr, result->ai_addr, sizeof(addr));
	addr.sin_port = htons(port);
	freeaddrinfo(result);

	socket_t fd = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
	if (fd == socket_t(-1)) {
		if (error) {
			*error = QStringLiteral("无法创建 TCP 套接字");
		}
		return -1;
	}
	// 非阻塞 connect + select 等可写：官方那 10 秒窗口不能靠默认的百秒级
	// 内核超时，否则一方早已放弃、另一方还以为在连。
#ifdef _WIN32
	u_long mode = 1;
	ioctlsocket(fd, FIONBIO, &mode);
#else
	int flags = fcntl(fd, F_GETFL, 0);
	fcntl(fd, F_SETFL, flags | O_NONBLOCK);
#endif
	int rc = connect(fd, reinterpret_cast<sockaddr*>(&addr), sizeof(addr));
	if (rc != 0 && !wouldBlock(lastSocketError())) {
		closesocket(fd);
		if (error) {
			*error = QStringLiteral("无法连接 %1:%2").arg(host).arg(port);
		}
		return -1;
	}
	if (rc != 0) {
		fd_set wset;
		FD_ZERO(&wset);
		FD_SET(fd, &wset);
		timeval tv{timeoutMs / 1000, (timeoutMs % 1000) * 1000};
#ifdef _WIN32
		int ready = select(0, nullptr, &wset, nullptr, &tv);
#else
		int ready = select(int(fd) + 1, nullptr, &wset, nullptr, &tv);
#endif
		if (ready <= 0) {
			closesocket(fd);
			if (error) {
				*error = QStringLiteral("连接 %1:%2 超时").arg(host).arg(port);
			}
			return -1;
		}
		int soError = 0;
		socklen_t len = sizeof(soError);
		getsockopt(fd, SOL_SOCKET, SO_ERROR, reinterpret_cast<char*>(&soError), &len);
		if (soError != 0) {
			closesocket(fd);
			if (error) {
				*error = QStringLiteral("连接 %1:%2 失败").arg(host).arg(port);
			}
			return -1;
		}
	}
	// 回阻塞模式：读写都要能被 close()/select() 打断。
#ifdef _WIN32
	mode = 0;
	ioctlsocket(fd, FIONBIO, &mode);
	int one = 1;
	setsockopt(fd, IPPROTO_TCP, TCP_NODELAY, reinterpret_cast<const char*>(&one), sizeof(one));
	int timeout = 500;
	setsockopt(fd, SOL_SOCKET, SO_RCVTIMEO, reinterpret_cast<const char*>(&timeout), sizeof(timeout));
#else
	fcntl(fd, F_SETFL, flags);
	int one = 1;
	setsockopt(fd, IPPROTO_TCP, TCP_NODELAY, &one, sizeof(one));
	timeval rcv{0, 500 * 1000};
	setsockopt(fd, SOL_SOCKET, SO_RCVTIMEO, &rcv, sizeof(rcv));
#endif
	return intptr_t(fd);
}

QString peerTextOf(const sockaddr_in& addr) {
	char buf[INET_ADDRSTRLEN] = {0};
	inet_ntop(AF_INET, &addr.sin_addr, buf, sizeof(buf));
	return QStringLiteral("%1:%2").arg(QString::fromLatin1(buf)).arg(ntohs(addr.sin_port));
}

} // namespace

TcpDirectLink::~TcpDirectLink() {
	close();
}

void TcpDirectLink::initSockets() {
#ifdef _WIN32
	static bool wsaReady = false;
	if (!wsaReady) {
		WSADATA data;
		WSAStartup(MAKEWORD(2, 2), &data);
		wsaReady = true;
	}
#endif
}

bool TcpDirectLink::listenAndAccept(quint16 port, int timeoutMs, QString* error) {
	initSockets();
	socket_t listener = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
	if (listener == socket_t(-1)) {
		if (error) {
			*error = QStringLiteral("无法创建监听套接字");
		}
		return false;
	}
	int one = 1;
	setsockopt(listener, SOL_SOCKET, SO_REUSEADDR, reinterpret_cast<const char*>(&one), sizeof(one));
	sockaddr_in addr;
	std::memset(&addr, 0, sizeof(addr));
	addr.sin_family = AF_INET;
	addr.sin_addr.s_addr = INADDR_ANY;
	addr.sin_port = htons(port);
	if (::bind(listener, reinterpret_cast<sockaddr*>(&addr), sizeof(addr)) != 0
	    || ::listen(listener, 4) != 0) {
		closesocket(listener);
		if (error) {
			*error = QStringLiteral("无法监听端口 %1").arg(port);
		}
		return false;
	}
	socklen_t len = sizeof(addr);
	if (getsockname(listener, reinterpret_cast<sockaddr*>(&addr), &len) == 0) {
		m_localPort = ntohs(addr.sin_port);
	}
	m_listener = intptr_t(listener);
	m_mode = MODE_HOST;

	// 先同步等第一个对端，调用方才知道这次「服务端就位」是否真的有人来。
	fd_set rset;
	FD_ZERO(&rset);
	FD_SET(listener, &rset);
	timeval tv{timeoutMs / 1000, (timeoutMs % 1000) * 1000};
#ifdef _WIN32
	int ready = select(0, &rset, nullptr, nullptr, &tv);
#else
	int ready = select(int(listener) + 1, &rset, nullptr, nullptr, &tv);
#endif
	if (ready <= 0) {
		closesocket(listener);
		m_listener = -1;
		if (error) {
			*error = QStringLiteral("等待对端连接超时");
		}
		return false;
	}
	sockaddr_in peer;
	socklen_t peerLen = sizeof(peer);
	socket_t fd = accept(listener, reinterpret_cast<sockaddr*>(&peer), &peerLen);
	if (fd == socket_t(-1)) {
		closesocket(listener);
		m_listener = -1;
		if (error) {
			*error = QStringLiteral("接受连接失败");
		}
		return false;
	}
	// 官方 accept 之后 setSoTimeout(500) + setTcpNoDelay(true)（A2egSU:64-67）。
	int timeout = 500;
	setsockopt(fd, SOL_SOCKET, SO_RCVTIMEO, reinterpret_cast<const char*>(&timeout), sizeof(timeout));
	int nodelay = 1;
	setsockopt(fd, IPPROTO_TCP, TCP_NODELAY, reinterpret_cast<const char*>(&nodelay), sizeof(nodelay));
	adoptSocket(intptr_t(fd), peerTextOf(peer), false);
	m_thread = std::thread([this]() { readerLoop(); });
	m_threadStarted = true;
	return true;
}

bool TcpDirectLink::connectTo(const QString& host, quint16 port, int timeoutMs, QString* error) {
	initSockets();
	m_mode = MODE_CLIENT;
	m_host = host;
	m_port = port;
	intptr_t fd = connectSocketNow(host, port, timeoutMs, error);
	if (fd < 0) {
		return false;
	}
	sockaddr_in local;
	std::memset(&local, 0, sizeof(local));
	socklen_t len = sizeof(local);
	if (getsockname(socket_t(fd), reinterpret_cast<sockaddr*>(&local), &len) == 0) {
		m_localPort = ntohs(local.sin_port);
	}
	adoptSocket(fd, QStringLiteral("%1:%2").arg(host).arg(port), false);
	m_thread = std::thread([this]() { readerLoop(); });
	m_threadStarted = true;
	return true;
}

void TcpDirectLink::adoptSocket(intptr_t fd, const QString& peer, bool reconnect) {
	m_socket = fd;
	m_peerText = peer;
	++m_connectCount;
	m_buffer.clear();
	if (!reconnect) {
		return;
	}
	/* 官方 AmA8tU.ARc23Z(Socket)：重连成功后先补一个裸 10 字节握手包，
	 * 里面带上次测得的 RTT。对端按 TYPE_RECONNECT 识别。 */
	QByteArray frame = GBoyFrames::reconnectFrame(m_lastRtt);
	writeAll(frame);
}

void TcpDirectLink::dropSocket() {
	std::lock_guard<std::mutex> locker(m_sendMutex);
	if (m_socket >= 0) {
		shutdown(socket_t(m_socket), 2);
		closesocket(socket_t(m_socket));
		m_socket = -1;
	}
	m_buffer.clear();
}

bool TcpDirectLink::acceptOnce() {
	if (m_listener < 0) {
		return false;
	}
	fd_set rset;
	FD_ZERO(&rset);
	FD_SET(socket_t(m_listener), &rset);
	timeval tv{0, 500 * 1000};
#ifdef _WIN32
	int ready = select(0, &rset, nullptr, nullptr, &tv);
#else
	int ready = select(int(socket_t(m_listener)) + 1, &rset, nullptr, nullptr, &tv);
#endif
	if (ready <= 0) {
		// 超时不算错误：继续等，close() 会把 m_closed 置位。
		return false;
	}
	sockaddr_in peer;
	socklen_t peerLen = sizeof(peer);
	socket_t fd = accept(socket_t(m_listener), reinterpret_cast<sockaddr*>(&peer), &peerLen);
	if (fd == socket_t(-1)) {
		return false;
	}
	int timeout = 500;
	setsockopt(fd, SOL_SOCKET, SO_RCVTIMEO, reinterpret_cast<const char*>(&timeout), sizeof(timeout));
	int nodelay = 1;
	setsockopt(fd, IPPROTO_TCP, TCP_NODELAY, reinterpret_cast<const char*>(&nodelay), sizeof(nodelay));
	adoptSocket(intptr_t(fd), peerTextOf(peer), false);
	return true;
}

bool TcpDirectLink::reconnectOnce() {
	/* 官方 AmA8tU.A4TApA：connect 失败 → sleep 2s → 重试，累计 50 秒放弃；
	 * 放弃时上层判连接已断。 */
	qint64 started = QDateTime::currentMSecsSinceEpoch();
	while (!m_closed.load(std::memory_order_relaxed)) {
		QString error;
		intptr_t fd = connectSocketNow(m_host, m_port, CONNECT_TIMEOUT_MS, &error);
		if (fd >= 0) {
			sockaddr_in local;
			std::memset(&local, 0, sizeof(local));
			socklen_t len = sizeof(local);
			if (getsockname(socket_t(fd), reinterpret_cast<sockaddr*>(&local), &len) == 0) {
				m_localPort = ntohs(local.sin_port);
			}
			adoptSocket(fd, QStringLiteral("%1:%2").arg(m_host).arg(m_port), true);
			return true;
		}
		if (QDateTime::currentMSecsSinceEpoch() - started >= RETRY_WINDOW_MS) {
			return false;
		}
		for (int waited = 0; waited < RETRY_INTERVAL_MS && !m_closed.load(std::memory_order_relaxed);
		     waited += 100) {
			QThread::msleep(100);
		}
	}
	return false;
}

int TcpDirectLink::readSomeLocked(int timeoutMs, bool* dropped) {
	*dropped = false;
	if (m_socket < 0) {
		*dropped = true;
		return 0;
	}
	fd_set rset;
	FD_ZERO(&rset);
	FD_SET(socket_t(m_socket), &rset);
	timeval tv{timeoutMs / 1000, (timeoutMs % 1000) * 1000};
#ifdef _WIN32
	int ready = select(0, &rset, nullptr, nullptr, &tv);
#else
	int ready = select(int(socket_t(m_socket)) + 1, &rset, nullptr, nullptr, &tv);
#endif
	if (ready <= 0) {
		return 0;
	}
	char buffer[4096];
	int n = int(recv(socket_t(m_socket), buffer, sizeof(buffer), 0));
	if (n == 0) {
		*dropped = true;
		return 0;
	}
	if (n < 0) {
		if (wouldBlock(lastSocketError())) {
			return 0;
		}
		*dropped = true;
		return 0;
	}
	m_buffer.append(buffer, n);
	return n;
}

void TcpDirectLink::drainFrames() {
	while (m_buffer.size() >= 4) {
		quint32 length = GBoyFrames::getInt(m_buffer, 0);
		if (length < 2 || length > GBoyFrames::maxFrameLength) {
			// 不是我们能理解的流：宁可判连接坏掉，也不要在错位的边界上解析。
			m_closed.store(true, std::memory_order_relaxed);
			return;
		}
		const int total = int(4 + length);
		if (m_buffer.size() < total) {
			return;
		}
		QByteArray frame = m_buffer.left(total);
		m_buffer.remove(0, total);
		{
			std::lock_guard<std::mutex> locker(m_mutex);
			m_inbox.append(frame);
		}
		m_inboxCv.notify_one();
	}
}

void TcpDirectLink::readerLoop() {
	while (!m_closed.load(std::memory_order_relaxed)) {
		if (m_socket < 0) {
			bool ok = (m_mode == MODE_HOST) ? acceptOnce() : reconnectOnce();
			if (!ok) {
				if (m_mode == MODE_CLIENT) {
					// 官方 50 秒窗口耗尽：判定连接死掉，让上层回落到隧道。
					break;
				}
				continue;
			}
			continue;
		}
		bool dropped = false;
		readSomeLocked(200, &dropped);
		if (dropped) {
			dropSocket();
			continue;
		}
		drainFrames();
	}
	m_closed.store(true, std::memory_order_relaxed);
	m_inboxCv.notify_all();
}

void TcpDirectLink::send(const QByteArray& wireFrame) {
	if (m_closed.load(std::memory_order_relaxed) || wireFrame.isEmpty()) {
		return;
	}
	if (!writeAll(wireFrame)) {
		dropSocket(); // 由读线程负责重连；这里不阻塞调用方
	}
}

bool TcpDirectLink::writeAll(const QByteArray& bytes) {
	std::lock_guard<std::mutex> locker(m_sendMutex);
	if (m_socket < 0) {
		return false;
	}
	const char* p = bytes.constData();
	int remaining = bytes.size();
	while (remaining > 0) {
		int n = int(::send(socket_t(m_socket), p, remaining, 0));
		if (n > 0) {
			p += n;
			remaining -= n;
			continue;
		}
		if (n < 0 && wouldBlock(lastSocketError())) {
			// 发送缓冲满：等可写（最多 1 秒），超时就放弃这次写。
			fd_set wset;
			FD_ZERO(&wset);
			FD_SET(socket_t(m_socket), &wset);
			timeval tv{1, 0};
#ifdef _WIN32
			if (select(0, nullptr, &wset, nullptr, &tv) <= 0) {
#else
			if (select(int(socket_t(m_socket)) + 1, nullptr, &wset, nullptr, &tv) <= 0) {
#endif
				return false;
			}
			continue;
		}
		return false;
	}
	return true;
}

bool TcpDirectLink::recv(QByteArray* out, int timeoutMs) {
	std::unique_lock<std::mutex> lock(m_mutex);
	m_inboxCv.wait_for(lock, std::chrono::milliseconds(timeoutMs),
	                   [this]() { return !m_inbox.empty(); });
	if (m_inbox.empty()) {
		return false;
	}
	*out = m_inbox.front();
	m_inbox.pop_front();
	return true;
}

bool TcpDirectLink::isClosed() const {
	return m_closed.load(std::memory_order_relaxed);
}

void TcpDirectLink::close() {
	m_closed.store(true, std::memory_order_relaxed);
	if (m_listener >= 0) {
		closesocket(socket_t(m_listener));
		m_listener = -1;
	}
	{
		std::lock_guard<std::mutex> locker(m_sendMutex);
		if (m_socket >= 0) {
			// shutdown 让阻塞中的 recv 立刻返回，读线程才能退出并 join。
			shutdown(socket_t(m_socket), 2);
			closesocket(socket_t(m_socket));
			m_socket = -1;
		}
	}
	if (m_threadStarted && m_thread.joinable()) {
		m_thread.join();
		m_threadStarted = false;
	}
	m_inboxCv.notify_all();
}
