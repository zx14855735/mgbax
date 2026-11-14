/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "BtLink.h"

#include "GBoyFrames.h"

#include <QDateTime>
#include <QHostAddress>
#include <QThread>

#include <cstring>

/* ---------------------------------------------------------------------------
 * 平台闸门
 *
 * 官方蓝牙走 Android 的 BluetoothAdapter / createRfcommSocketToServiceRecord。
 * PC 上对应的原生接口是 Winsock 的 AF_BTH + BTHPROTO_RFCOMM（ws2bth.h）。
 * 本机 SDK 没有这些头时整块退化成「永远返回不支持」的桩，保证跨平台编译
 * 不受影响——蓝牙只是显式开启的可选通道，绝不能因此让 mgba-qt 编译失败。
 * ------------------------------------------------------------------------- */
#if defined(_WIN32) && defined(__has_include)
#  if __has_include(<ws2bth.h>) && __has_include(<bluetoothapis.h>)
#    define MGBAX_HAVE_BTH 1
#  endif
#endif

#ifdef MGBAX_HAVE_BTH

#include <winsock2.h>
#include <ws2bth.h>
#include <ws2tcpip.h>

using namespace QGBA;

namespace {

/** 官方 B25kr6.f4349AcNBzu。 */
const GUID kServiceGuid = {
	0x3a1f7b2e, 0x8d45, 0x4c92, {0xbf, 0x60, 0x5e, 0x3c, 0x21, 0xa9, 0x8d, 0x47}
};
/** 官方服务名（A2egSU(listenUsingRfcommWithServiceRecord("GBoy", uuid))）。 */
const wchar_t kServiceName[] = L"GBoy";

void put32(char* p, quint32 v) {
	p[0] = char((v >> 24) & 0xFF);
	p[1] = char((v >> 16) & 0xFF);
	p[2] = char((v >> 8) & 0xFF);
	p[3] = char(v & 0xFF);
}

bool wouldBlock(int code) {
	return code == WSAEWOULDBLOCK || code == WSAEINPROGRESS || code == WSAEINTR;
}

/**
 * 最小 SDP 记录：只放四个官方需要的属性，够 Android 侧按 UUID 找到服务。
 *
 *   0x0000 ServiceRecordHandle = 0
 *   0x0001 ServiceClassIDList  = { 3a1f7b2e-8d45-4c92-bf60-5e3c21a98d47 }
 *   0x0004 ProtocolDescriptorList = L2CAP + RFCOMM(channel)
 *   0x0005 BrowseGroupList     = PublicBrowseRoot（让「浏览服务」也能看到）
 *   0x0100 ServiceName         = "GBoy"
 */
QByteArray buildSdpRecord(quint8 channel) {
	QByteArray body;
	body += QByteArray::fromHex("0900000A00000000"); // 0x0000 handle = 0
	// 0x0001 ServiceClassIDList：SEQ(UUID128)，元素 17 字节
	body += QByteArray::fromHex("090001");
	body.append(char(0x35));
	body.append(char(0x11));
	body.append(char(0x1C));
	body += QByteArray::fromHex("3a1f7b2e8d454c92bf605e3c21a98d47");
	// 0x0004 ProtocolDescriptorList：SEQ(SEQ(L2CAP 0x0100), SEQ(RFCOMM 0x0003 + ch))
	body += QByteArray::fromHex("090004");
	body.append(char(0x35));
	body.append(char(0x0C));
	body += QByteArray::fromHex("3503190100");
	body += QByteArray::fromHex("350519000308");
	body.append(char(channel));
	// 0x0005 BrowseGroupList：SEQ(UUID16 PublicBrowseRoot = 0x1002)
	body += QByteArray::fromHex("0900053503191002");
	// 0x0100 ServiceName："GBoy"
	body += QByteArray::fromHex("090100");
	body.append(char(0x25));
	body.append(char(4));
	body += QByteArray("GBoy", 4);

	QByteArray record;
	record.append(char(0x35));
	record.append(char(body.size())); // 记录总长 < 256，一字节长度足够
	record += body;
	return record;
}

bool parseBtAddress(const QString& text, BTH_ADDR* out) {
	QString cleaned = text;
	cleaned.remove(QLatin1Char(':'));
	cleaned.remove(QLatin1Char('-'));
	if (cleaned.size() != 12) {
		return false;
	}
	bool ok = false;
	const qulonglong value = cleaned.toULongLong(&ok, 16);
	if (!ok) {
		return false;
	}
	*out = BTH_ADDR(value);
	return true;
}

} // namespace

BtLink::~BtLink() {
	close();
}

bool BtLink::supported() {
	return true;
}

bool BtLink::openHost(int timeoutMs, QString* error) {
	static bool wsaReady = false;
	if (!wsaReady) {
		WSADATA data;
		WSAStartup(MAKEWORD(2, 2), &data);
		wsaReady = true;
	}
	SOCKET listener = WSASocket(AF_BTH, SOCK_STREAM, BTHPROTO_RFCOMM, nullptr, 0,
	                            WSA_FLAG_OVERLAPPED);
	if (listener == INVALID_SOCKET) {
		if (error) {
			*error = QStringLiteral("无法创建蓝牙 RFCOMM 套接字");
		}
		return false;
	}
	// 官方 listenUsingRfcommWithServiceRecord：端口由协议栈分配（BT_PORT_ANY）。
	SOCKADDR_BTH local;
	std::memset(&local, 0, sizeof(local));
	local.addressFamily = AF_BTH;
	local.btAddr = 0; // 本机任意蓝牙适配器
	local.port = BT_PORT_ANY;
	if (::bind(listener, reinterpret_cast<sockaddr*>(&local), sizeof(local)) != 0) {
		closesocket(listener);
		if (error) {
			*error = QStringLiteral("无法绑定蓝牙 RFCOMM 端口（适配器未就绪？）");
		}
		return false;
	}
	socklen_t len = sizeof(local);
	if (getsockname(listener, reinterpret_cast<sockaddr*>(&local), &len) != 0
	    || local.port == BT_PORT_ANY || local.port > 0xFF) {
		closesocket(listener);
		if (error) {
			*error = QStringLiteral("无法取得蓝牙 RFCOMM 通道号");
		}
		return false;
	}
	if (::listen(listener, 1) != 0) {
		closesocket(listener);
		if (error) {
			*error = QStringLiteral("蓝牙 RFCOMM 监听失败");
		}
		return false;
	}

	// 注册 SDP：对方按 UUID 查到通道号才能连进来。
	m_sdpRecord = buildSdpRecord(quint8(local.port));
	SOCKADDR_BTH advertised;
	std::memset(&advertised, 0, sizeof(advertised));
	advertised.addressFamily = AF_BTH;
	advertised.btAddr = 0;
	advertised.port = local.port;
	CSADDR_INFO csaddr;
	std::memset(&csaddr, 0, sizeof(csaddr));
	csaddr.LocalAddr.lpSockaddr = reinterpret_cast<sockaddr*>(&advertised);
	csaddr.LocalAddr.iSockaddrLength = sizeof(advertised);
	csaddr.iSocketType = SOCK_STREAM;
	csaddr.iProtocol = BTHPROTO_RFCOMM;
	WSAQUERYSETW query;
	std::memset(&query, 0, sizeof(query));
	query.dwSize = sizeof(query);
	query.lpServiceClassId = const_cast<GUID*>(&kServiceGuid);
	query.lpServiceName = const_cast<wchar_t*>(kServiceName);
	query.dwNameSpace = NS_BTH;
	query.dwNumberOfCsAddrs = 1;
	query.lpcsaBuffer = &csaddr;
	BLOB blob;
	blob.cbSize = ULONG(m_sdpRecord.size());
	blob.pBlobData = reinterpret_cast<BYTE*>(m_sdpRecord.data());
	query.lpBlob = &blob;
	if (WSASetServiceW(&query, RNRSERVICE_REGISTER, 0) != 0) {
		closesocket(listener);
		if (error) {
			*error = QStringLiteral("蓝牙 SDP 注册失败");
		}
		return false;
	}
	m_sdpRegistered = true;
	m_listener = intptr_t(listener);

	fd_set rset;
	FD_ZERO(&rset);
	FD_SET(listener, &rset);
	timeval tv{timeoutMs / 1000, (timeoutMs % 1000) * 1000};
	if (select(0, &rset, nullptr, nullptr, &tv) <= 0) {
		close();
		if (error) {
			*error = QStringLiteral("等待蓝牙对端超时");
		}
		return false;
	}
	SOCKADDR_BTH peer;
	socklen_t peerLen = sizeof(peer);
	std::memset(&peer, 0, sizeof(peer));
	SOCKET fd = accept(listener, reinterpret_cast<sockaddr*>(&peer), &peerLen);
	if (fd == INVALID_SOCKET) {
		close();
		if (error) {
			*error = QStringLiteral("蓝牙连接接受失败");
		}
		return false;
	}
	m_socket = intptr_t(fd);
	m_peerText = QStringLiteral("%1").arg(qulonglong(peer.btAddr), 12, 16, QLatin1Char('0'));
	// 官方 accept 之后 setSoTimeout(500)。
	DWORD rcvTimeout = 500;
	setsockopt(fd, SOL_SOCKET, SO_RCVTIMEO, reinterpret_cast<const char*>(&rcvTimeout),
	           sizeof(rcvTimeout));
	m_thread = std::thread([this]() { readerLoop(); });
	m_threadStarted = true;
	return true;
}

bool BtLink::openClient(const QString& address, int timeoutMs, QString* error) {
	static bool wsaReady = false;
	if (!wsaReady) {
		WSADATA data;
		WSAStartup(MAKEWORD(2, 2), &data);
		wsaReady = true;
	}
	BTH_ADDR target = 0;
	if (!parseBtAddress(address, &target)) {
		if (error) {
			*error = QStringLiteral("MGBAX_BT 应为 host 或 AA:BB:CC:DD:EE:FF");
		}
		return false;
	}
	SOCKET fd = WSASocket(AF_BTH, SOCK_STREAM, BTHPROTO_RFCOMM, nullptr, 0, WSA_FLAG_OVERLAPPED);
	if (fd == INVALID_SOCKET) {
		if (error) {
			*error = QStringLiteral("无法创建蓝牙 RFCOMM 套接字");
		}
		return false;
	}
	SOCKADDR_BTH remote;
	std::memset(&remote, 0, sizeof(remote));
	remote.addressFamily = AF_BTH;
	remote.btAddr = target;
	remote.port = 0;
	// createRfcommSocketToServiceRecord(uuid)：协议栈按 GUID 做 SDP 查通道。
	remote.serviceClassId = kServiceGuid;

	u_long nonBlocking = 1;
	ioctlsocket(fd, FIONBIO, &nonBlocking);
	int rc = ::connect(fd, reinterpret_cast<sockaddr*>(&remote), sizeof(remote));
	if (rc != 0 && !wouldBlock(WSAGetLastError())) {
		closesocket(fd);
		if (error) {
			*error = QStringLiteral("蓝牙连接 %1 失败（未配对或不在范围内）").arg(address);
		}
		return false;
	}
	if (rc != 0) {
		fd_set wset;
		FD_ZERO(&wset);
		FD_SET(fd, &wset);
		timeval tv{timeoutMs / 1000, (timeoutMs % 1000) * 1000};
		if (select(0, nullptr, &wset, nullptr, &tv) <= 0) {
			closesocket(fd);
			if (error) {
				*error = QStringLiteral("蓝牙连接 %1 超时").arg(address);
			}
			return false;
		}
		int soError = 0;
		socklen_t len = sizeof(soError);
		getsockopt(fd, SOL_SOCKET, SO_ERROR, reinterpret_cast<char*>(&soError), &len);
		if (soError != 0) {
			closesocket(fd);
			if (error) {
				*error = QStringLiteral("蓝牙连接 %1 失败（错误 %2）").arg(address).arg(soError);
			}
			return false;
		}
	}
	nonBlocking = 0;
	ioctlsocket(fd, FIONBIO, &nonBlocking);
	DWORD rcvTimeout = 500;
	setsockopt(fd, SOL_SOCKET, SO_RCVTIMEO, reinterpret_cast<const char*>(&rcvTimeout),
	           sizeof(rcvTimeout));
	m_socket = intptr_t(fd);
	m_peerText = address;
	m_thread = std::thread([this]() { readerLoop(); });
	m_threadStarted = true;
	return true;
}

int BtLink::readSomeLocked(int timeoutMs, bool* dropped) {
	*dropped = false;
	if (m_socket < 0) {
		*dropped = true;
		return 0;
	}
	fd_set rset;
	FD_ZERO(&rset);
	FD_SET(SOCKET(m_socket), &rset);
	timeval tv{timeoutMs / 1000, (timeoutMs % 1000) * 1000};
	if (select(0, &rset, nullptr, nullptr, &tv) <= 0) {
		return 0;
	}
	char buffer[1024];
	int n = int(recv(SOCKET(m_socket), buffer, sizeof(buffer), 0));
	if (n == 0) {
		*dropped = true;
		return 0;
	}
	if (n < 0) {
		if (wouldBlock(WSAGetLastError())) {
			return 0;
		}
		*dropped = true;
		return 0;
	}
	m_buffer.append(buffer, n);
	return n;
}

void BtLink::drainFrames() {
	while (m_buffer.size() >= 4) {
		quint32 length = GBoyFrames::getInt(m_buffer, 0);
		if (length < 2 || length > GBoyFrames::maxFrameLength) {
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

void BtLink::readerLoop() {
	while (!m_closed.load(std::memory_order_relaxed)) {
		bool dropped = false;
		readSomeLocked(200, &dropped);
		if (dropped) {
			// RFCOMM 不像 TCP 那样容易在掉线后原地重连（要重新 SDP），
			// 官方客户端也是整条链路重建；这里直接判定结束，让上层回落。
			break;
		}
		drainFrames();
	}
	m_closed.store(true, std::memory_order_relaxed);
	m_inboxCv.notify_all();
}

bool BtLink::writeAll(const QByteArray& bytes) {
	std::lock_guard<std::mutex> locker(m_sendMutex);
	if (m_socket < 0) {
		return false;
	}
	const char* p = bytes.constData();
	int remaining = bytes.size();
	while (remaining > 0) {
		int n = int(::send(SOCKET(m_socket), p, remaining, 0));
		if (n > 0) {
			p += n;
			remaining -= n;
			continue;
		}
		return false;
	}
	return true;
}

void BtLink::send(const QByteArray& wireFrame) {
	if (m_closed.load(std::memory_order_relaxed) || wireFrame.isEmpty()) {
		return;
	}
	if (!writeAll(wireFrame)) {
		dropSocket();
	}
}

void BtLink::dropSocket() {
	std::lock_guard<std::mutex> locker(m_sendMutex);
	if (m_socket >= 0) {
		closesocket(SOCKET(m_socket));
		m_socket = -1;
	}
	m_buffer.clear();
}

bool BtLink::recv(QByteArray* out, int timeoutMs) {
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

bool BtLink::isClosed() const {
	return m_closed.load(std::memory_order_relaxed);
}

void BtLink::close() {
	m_closed.store(true, std::memory_order_relaxed);
	if (m_socket >= 0) {
		shutdown(SOCKET(m_socket), SD_BOTH);
		closesocket(SOCKET(m_socket));
		m_socket = -1;
	}
	if (m_listener >= 0) {
		closesocket(SOCKET(m_listener));
		m_listener = -1;
	}
	if (m_sdpRegistered && !m_sdpRecord.isEmpty()) {
		SOCKADDR_BTH advertised;
		std::memset(&advertised, 0, sizeof(advertised));
		advertised.addressFamily = AF_BTH;
		CSADDR_INFO csaddr;
		std::memset(&csaddr, 0, sizeof(csaddr));
		csaddr.LocalAddr.lpSockaddr = reinterpret_cast<sockaddr*>(&advertised);
		csaddr.LocalAddr.iSockaddrLength = sizeof(advertised);
		csaddr.iSocketType = SOCK_STREAM;
		csaddr.iProtocol = BTHPROTO_RFCOMM;
		WSAQUERYSETW query;
		std::memset(&query, 0, sizeof(query));
		query.dwSize = sizeof(query);
		query.lpServiceClassId = const_cast<GUID*>(&kServiceGuid);
		query.lpServiceName = const_cast<wchar_t*>(kServiceName);
		query.dwNameSpace = NS_BTH;
		query.dwNumberOfCsAddrs = 1;
		query.lpcsaBuffer = &csaddr;
		BLOB blob;
		blob.cbSize = ULONG(m_sdpRecord.size());
		blob.pBlobData = reinterpret_cast<BYTE*>(m_sdpRecord.data());
		query.lpBlob = &blob;
		WSASetServiceW(&query, RNRSERVICE_DELETE, 0);
		m_sdpRegistered = false;
	}
	if (m_threadStarted && m_thread.joinable()) {
		m_thread.join();
		m_threadStarted = false;
	}
	m_inboxCv.notify_all();
}

#else // !MGBAX_HAVE_BTH

/* 没有 BTH 头（非 Windows，或 SDK 没带蓝牙）：保留接口形状，永远不启用。 */
using namespace QGBA;

BtLink::~BtLink() {
}

bool BtLink::supported() {
	return false;
}

bool BtLink::openHost(int, QString* error) {
	if (error) {
		*error = QStringLiteral("本机不支持蓝牙 RFCOMM（缺少 ws2bth.h）");
	}
	return false;
}

bool BtLink::openClient(const QString&, int, QString* error) {
	if (error) {
		*error = QStringLiteral("本机不支持蓝牙 RFCOMM（缺少 ws2bth.h）");
	}
	return false;
}

void BtLink::send(const QByteArray&) {
}

bool BtLink::recv(QByteArray*, int) {
	return false;
}

bool BtLink::isClosed() const {
	return true;
}

void BtLink::close() {
}

void BtLink::readerLoop() {
}

int BtLink::readSomeLocked(int, bool* dropped) {
	if (dropped) {
		*dropped = true;
	}
	return 0;
}

void BtLink::drainFrames() {
}

bool BtLink::writeAll(const QByteArray&) {
	return false;
}

void BtLink::dropSocket() {
}

#endif
