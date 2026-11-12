/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "GBoyLink.h"
#include "moc_GBoyLink.cpp"

#include <QCryptographicHash>
#include <QDateTime>
#include <QDebug>
#include <QFile>
#include <QThread>

#include <cstring>

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

constexpr quint32 FRAME_MAX = 32 * 1024 * 1024;
constexpr int MSG_HELLO = 1;
constexpr int MSG_ROMINFO = 2;
constexpr int MSG_READY = 3;
constexpr int MSG_KEYS = 4;
constexpr int MSG_RESET = 5;
constexpr int MSG_STATE = 6;

// Zero-filled body appended to the synthesized state image, in bytes (same as iOS).
constexpr int STATE_PAD = 900 * 1024;

quint32 be32(const uchar* p) {
	return (quint32(p[0]) << 24) | (quint32(p[1]) << 16) | (quint32(p[2]) << 8) | quint32(p[3]);
}

// Append-style writers: QByteArray starts empty, so writing through data()
// at fixed offsets would overflow the (empty) buffer.
void put16(QByteArray* out, quint16 v) {
	out->append(char((v >> 8) & 0xFF));
	out->append(char(v & 0xFF));
}

void put32(QByteArray* out, quint32 v) {
	out->append(char((v >> 24) & 0xFF));
	out->append(char((v >> 16) & 0xFF));
	out->append(char((v >> 8) & 0xFF));
	out->append(char(v & 0xFF));
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

/** select() based wait: QTcpSocket's waitFor* are unreliable on Windows in
 * event-loop-less worker threads, so the transport is plain sockets. */
bool waitFd(intptr_t fd, bool write, int timeoutMs) {
	fd_set set;
	FD_ZERO(&set);
#ifdef _WIN32
	FD_SET(SOCKET(fd), &set);
#else
	FD_SET(fd, &set);
#endif
	timeval tv{timeoutMs / 1000, (timeoutMs % 1000) * 1000};
	fd_set* rset = write ? nullptr : &set;
	fd_set* wset = write ? &set : nullptr;
	return select(int(fd) + 1, rset, wset, nullptr, &tv) > 0;
}

void connectFd(intptr_t fd, sockaddr* addr) {
#ifdef _WIN32
	::connect(SOCKET(fd), addr, sizeof(sockaddr_in));
#else
	::connect(fd, addr, sizeof(sockaddr_in));
#endif
}

/** True when the peer has data waiting (never blocks longer than timeout). */
bool readReady(intptr_t fd, int timeoutMs) {
	return waitFd(fd, false, timeoutMs);
}

// zlib-format stream of stored (uncompressed) deflate blocks: no compression
// library needed, and Java's Inflater / zlib inflate on the peer accept it.
QByteArray zlibStored(const QByteArray& raw) {
	QByteArray out;
	out.append(char(0x78));
	out.append(char(0x9C));
	quint32 a = 1;
	quint32 b = 0;
	int off = 0;
	do {
		int block = qMin(65535, int(raw.size()) - off);
		bool finalBlock = off + block >= raw.size();
		out.append(char(finalBlock ? 1 : 0));
		out.append(char(block & 0xFF));
		out.append(char((block >> 8) & 0xFF));
		out.append(char(~block & 0xFF));
		out.append(char((~block >> 8) & 0xFF));
		out.append(raw.mid(off, block));
		for (int i = off; i < off + block; ++i) {
			a = (a + quint32(uchar(raw[i]))) % 65521;
			b = (b + a) % 65521;
		}
		off += block;
	} while (off < raw.size());
	put32(&out, (b << 16) | a);
	return out;
}

QString utf8Name(const QString& path) {
	int slash = qMax(path.lastIndexOf('/'), path.lastIndexOf('\\'));
	return slash >= 0 ? path.mid(slash + 1) : path;
}

}

GBoyLink::GBoyLink(QObject* parent)
	: QThread(parent)
{
}

GBoyLink::~GBoyLink() {
	stopLink();
	wait(3000);
}

void GBoyLink::startLink(const Config& config) {
	stopLink();
	m_config = config;
	m_aborted.store(false, std::memory_order_relaxed);
	m_sendReset.store(false, std::memory_order_relaxed);
	start();
}

void GBoyLink::stopLink() {
	m_aborted.store(true, std::memory_order_relaxed);
	if (!isRunning()) {
		return;
	}
	wait(3000);
	if (isRunning()) {
		terminate();
		wait(3000);
	}
}

void GBoyLink::sendReset() {
	m_sendReset.store(true, std::memory_order_relaxed);
}

void GBoyLink::run() {
	initSockets();
	intptr_t sock = -1;
	int listenFd = -1;

	if (m_config.mode == HOST) {
		emit statusMessage(QObject::tr("联机大厅等待连接…\n端口 %1，你是 1P").arg(m_config.port));
		listenFd = int(socket(AF_INET, SOCK_STREAM, 0));
		if (listenFd < 0) {
			emit linkEnded(QObject::tr("联机大厅连接失败"));
			return;
		}
		int yes = 1;
		setsockopt(listenFd, SOL_SOCKET, SO_REUSEADDR, reinterpret_cast<const char*>(&yes), sizeof(yes));
		sockaddr_in addr{};
		addr.sin_family = AF_INET;
		addr.sin_port = htons(m_config.port);
		addr.sin_addr.s_addr = INADDR_ANY;
		if (bind(listenFd, reinterpret_cast<sockaddr*>(&addr), sizeof(addr)) != 0
		    || listen(listenFd, 1) != 0) {
			closeSocketFd(listenFd);
			emit linkEnded(QObject::tr("端口 %1 被占用").arg(m_config.port));
			return;
		}
		while (!m_aborted.load(std::memory_order_relaxed)) {
			if (readReady(listenFd, 250)) {
				break;
			}
		}
		if (m_aborted.load(std::memory_order_relaxed)) {
			closeSocketFd(listenFd);
			emit linkEnded(QString());
			return;
		}
		sockaddr_in from{};
		socklen_t fromLen = sizeof(from);
		sock = intptr_t(accept(listenFd, reinterpret_cast<sockaddr*>(&from), &fromLen));
		closeSocketFd(listenFd);
		listenFd = -1;
		if (sock < 0) {
			emit linkEnded(QObject::tr("联机大厅连接失败"));
			return;
		}
		emit statusMessage(QObject::tr("对方已接入，正在同步…"));
	} else {
		emit statusMessage(QObject::tr("正在连接 %1:%2…").arg(m_config.ip).arg(m_config.port));
		addrinfo hints{};
		hints.ai_family = AF_INET;
		hints.ai_socktype = SOCK_STREAM;
		hints.ai_protocol = IPPROTO_TCP;
		addrinfo* result = nullptr;
		if (getaddrinfo(m_config.ip.toUtf8().constData(), nullptr, &hints, &result) != 0 || !result) {
			emit linkEnded(QObject::tr("无法解析地址 %1").arg(m_config.ip));
			return;
		}
		sockaddr_in addr{};
		memcpy(&addr, result->ai_addr, qMin<int>(result->ai_addrlen, int(sizeof(addr))));
		addr.sin_port = htons(m_config.port);
		freeaddrinfo(result);

		sock = intptr_t(socket(AF_INET, SOCK_STREAM, 0));
		if (sock < 0) {
			emit linkEnded(QObject::tr("联机大厅连接失败"));
			return;
		}
#ifdef _WIN32
		u_long nonBlocking = 1;
		ioctlsocket(SOCKET(sock), FIONBIO, &nonBlocking);
#else
		int flags = fcntl(sock, F_GETFL, 0);
		fcntl(sock, F_SETFL, flags | O_NONBLOCK);
#endif
		connectFd(sock, reinterpret_cast<sockaddr*>(&addr));
		if (!waitFd(sock, true, 10000)) {
			closeSocketFd(sock);
			emit linkEnded(QObject::tr("无法连接 %1").arg(m_config.ip));
			return;
		}
		int err = 0;
		socklen_t errLen = sizeof(err);
		getsockopt(SOCKET(sock), SOL_SOCKET, SO_ERROR, reinterpret_cast<char*>(&err), &errLen);
		if (err != 0 || m_aborted.load(std::memory_order_relaxed)) {
			closeSocketFd(sock);
			emit linkEnded(QObject::tr("无法连接 %1").arg(m_config.ip));
			return;
		}
#ifdef _WIN32
		nonBlocking = 0;
		ioctlsocket(SOCKET(sock), FIONBIO, &nonBlocking);
#else
		flags = fcntl(sock, F_GETFL, 0);
		fcntl(sock, F_SETFL, flags & ~O_NONBLOCK);
#endif
		emit statusMessage(QObject::tr("已连上，正在同步…"));
	}

	int one = 1;
#ifdef _WIN32
	setsockopt(SOCKET(sock), IPPROTO_TCP, TCP_NODELAY, reinterpret_cast<const char*>(&one), sizeof(one));
#else
	setsockopt(sock, IPPROTO_TCP, TCP_NODELAY, &one, sizeof(one));
#endif

	QString note;
	if (!handshake(sock, m_config.mode == HOST, &note)) {
		closeSocketFd(sock);
		return;
	}

	QString text = m_config.mode == HOST ? QObject::tr("已连接，你是 1P") : QObject::tr("已连接，你是 2P");
	if (!note.isEmpty()) {
		text = note + "\n" + text;
	}
	emit statusMessage(text);

	// Steady state: one loop both pumps our key mask out and reads the peer's
	// frames (KEYS are tiny and arrive at the same cadence, so nothing backs up).
	QByteArray rxBuf;
	QByteArray rxFrame;
	qint64 lastSend = 0;
	while (!m_aborted.load(std::memory_order_relaxed)) {
		int got = readFrame(sock, &rxBuf, &rxFrame, 50);
		if (got < 0) {
			if (m_aborted.load(std::memory_order_relaxed)) {
				break;
			}
			emit linkEnded(QObject::tr("对方已断开"));
			emit remoteKeys(0);
			closeSocketFd(sock);
			return;
		}
		if (got > 0) {
			if (rxFrame.size() >= 6 && (uchar(rxFrame[0]) << 8 | uchar(rxFrame[1])) == MSG_KEYS) {
				int keys = int(be32(reinterpret_cast<const uchar*>(rxFrame.constData()) + 2));
				emit remoteKeys(keys);
			} else if (rxFrame.size() >= 2 && (uchar(rxFrame[0]) << 8 | uchar(rxFrame[1])) == MSG_RESET) {
				emit remoteReset();
			}
		}
		if (m_sendReset.exchange(false, std::memory_order_relaxed)) {
			sendFrame(sock, frame(MSG_RESET));
		}
		qint64 now = QDateTime::currentMSecsSinceEpoch();
		if (now - lastSend >= 83) {
			if (!sendFrame(sock, keysFrame(m_localKeys.load(std::memory_order_relaxed)))) {
				if (m_aborted.load(std::memory_order_relaxed)) {
					break;
				}
				emit linkEnded(QObject::tr("对方已断开"));
				emit remoteKeys(0);
				closeSocketFd(sock);
				return;
			}
			lastSend = now;
		}
	}
	closeSocketFd(sock);
	emit remoteKeys(0);
	emit linkEnded(QString());
}

bool GBoyLink::handshake(intptr_t fd, bool asHost, QString* note) {
	QByteArray rxBuf;
	QByteArray rxFrame;

	if (!asHost) {
		if (!sendFrame(fd, helloFrame())) {
			return false;
		}
	}
	if (!expectHello(fd, asHost)) {
		return false;
	}

	QByteArray info = romInfoFrame();
	if (info.isEmpty()) {
		emit linkEnded(QObject::tr("找不到当前游戏文件"));
		return false;
	}
	if (!sendFrame(fd, info)) {
		return false;
	}
	emit statusMessage(QObject::tr("已交换游戏信息…"));

	if (!readUntil(fd, &rxBuf, MSG_ROMINFO, &rxFrame, 15000)) {
		return false;
	}
	if (rxFrame.size() < 34) {
		emit linkEnded(QObject::tr("对方不是联机大厅会话"));
		return false;
	}
	QByteArray peerHash = rxFrame.mid(2, 32);
	QByteArray mine = info.mid(2, 32);
	if (peerHash.toLower() != mine.toLower()) {
		*note = QObject::tr("注意：两边的游戏不一致，联机可能无法正常同步");
	}

	if (!sendFrame(fd, frame(MSG_READY))) {
		return false;
	}
	if (!readUntil(fd, &rxBuf, MSG_READY, &rxFrame, 15000)) {
		return false;
	}

	// Both sides exchange a (synthetic) state image so GBoy/My Boy consoles
	// boot the same game; each side keeps playing its own progress.
	const QString receivedNote = QObject::tr("已收到对方即时存档（本机继续用本机进度）");
	if (asHost) {
		if (!readUntil(fd, &rxBuf, MSG_STATE, &rxFrame, 30000)) {
			return false;
		}
		*note = note->isEmpty() ? receivedNote : *note + "\n" + receivedNote;
		if (!sendFrame(fd, stateFrame())) {
			return false;
		}
	} else {
		if (!sendFrame(fd, stateFrame())) {
			return false;
		}
		if (!readUntil(fd, &rxBuf, MSG_STATE, &rxFrame, 30000)) {
			return false;
		}
		*note = note->isEmpty() ? receivedNote : *note + "\n" + receivedNote;
	}
	return true;
}

bool GBoyLink::expectHello(intptr_t fd, bool asHost) {
	QByteArray rxBuf;
	QByteArray rxFrame;
	if (!readUntil(fd, &rxBuf, MSG_HELLO, &rxFrame, 15000)) {
		return false;
	}
	if (rxFrame.size() < 6 || be32(reinterpret_cast<const uchar*>(rxFrame.constData()) + 2) != 6) {
		emit linkEnded(QObject::tr("联机大厅协议版本不符"));
		return false;
	}
	if (asHost) {
		if (!sendFrame(fd, helloFrame())) {
			return false;
		}
	}
	return true;
}

bool GBoyLink::sendFrame(intptr_t fd, const QByteArray& payload) {
	QByteArray data;
	put32(&data, payload.size());
	data.append(payload);
	const char* p = data.constData();
	int remaining = data.size();
	while (remaining > 0 && !m_aborted.load(std::memory_order_relaxed)) {
		if (!waitFd(fd, true, 15000)) {
			return false;
		}
		ssize_t n;
#ifdef _WIN32
		n = ::send(SOCKET(fd), p, remaining, 0);
#else
		n = ::send(fd, p, remaining, 0);
#endif
		if (n > 0) {
			p += n;
			remaining -= int(n);
			continue;
		}
		if (n < 0) {
			return false;
		}
	}
	return remaining == 0;
}

int GBoyLink::readFrame(intptr_t fd, QByteArray* rxBuf, QByteArray* out, int timeoutMs) {
	while (!m_aborted.load(std::memory_order_relaxed)) {
		if (rxBuf->size() >= 4) {
			quint32 len = be32(reinterpret_cast<const uchar*>(rxBuf->constData()));
			if (len < 2 || len > FRAME_MAX) {
				return -1;
			}
			if (rxBuf->size() >= int(4 + len)) {
				*out = rxBuf->mid(4, len);
				rxBuf->remove(0, int(4 + len));
				return 1;
			}
		}
		if (!readReady(fd, timeoutMs)) {
			// Quiet line. A closed peer shows up as EOF, which select reports
			// as readable, so the next round catches it via recv() == 0.
			return 0;
		}
		char chunk[4096];
		ssize_t n;
#ifdef _WIN32
		n = ::recv(SOCKET(fd), chunk, sizeof(chunk), 0);
#else
		n = ::recv(fd, chunk, sizeof(chunk), 0);
#endif
		if (n <= 0) {
			return -1; // 0 = peer closed, <0 = error
		}
		rxBuf->append(chunk, int(n));
	}
	return -1;
}

bool GBoyLink::readUntil(intptr_t fd, QByteArray* rxBuf, int want, QByteArray* out, int timeoutMs) {
	QByteArray frame;
	// The peer's key pump may already be running, so KEYS/RESET frames can
	// slip in during the handshake; they are dropped here.
	while (!m_aborted.load(std::memory_order_relaxed)) {
		int got = readFrame(fd, rxBuf, &frame, timeoutMs);
		if (got < 0) {
			emit linkEnded(m_aborted.load(std::memory_order_relaxed) ? QString() : QObject::tr("对方已断开"));
			return false;
		}
		if (got == 0) {
			emit linkEnded(QObject::tr("连接超时"));
			return false;
		}
		int type = frame.size() >= 2 ? (uchar(frame[0]) << 8 | uchar(frame[1])) : -1;
		if (type == want) {
			*out = frame;
			return true;
		}
		if (type != MSG_KEYS && type != MSG_RESET) {
			emit linkEnded(QObject::tr("对方不是联机大厅会话"));
			return false;
		}
	}
	emit linkEnded(QString());
	return false;
}

QByteArray GBoyLink::frame(int type) {
	QByteArray payload;
	put16(&payload, quint16(type));
	return payload;
}

QByteArray GBoyLink::helloFrame() {
	QByteArray payload;
	put16(&payload, quint16(MSG_HELLO));
	put32(&payload, 6);
	return payload;
}

QByteArray GBoyLink::keysFrame(int keys) const {
	QByteArray payload;
	put16(&payload, quint16(MSG_KEYS));
	put32(&payload, quint32(keys));
	return payload;
}

QByteArray GBoyLink::romInfoFrame() const {
	QFile rom(m_config.romPath);
	if (!rom.open(QIODevice::ReadOnly)) {
		return QByteArray();
	}
	QCryptographicHash hasher(QCryptographicHash::Md5);
	char chunk[65536];
	qint64 n;
	while ((n = rom.read(chunk, sizeof(chunk))) > 0) {
		hasher.addData(chunk, int(n));
	}
	QByteArray hash = hasher.result().toHex().toLower(); // 32 ASCII bytes
	QByteArray name = utf8Name(m_config.romPath).toUtf8();

	QByteArray payload;
	put16(&payload, quint16(MSG_ROMINFO));
	payload.append(hash);
	put16(&payload, quint16(name.size()));
	payload.append(name);
	return payload;
}

QByteArray GBoyLink::stateFrame() const {
	QByteArray raw(32 + STATE_PAD, char(0));
	QByteArray magic = QByteArrayLiteral("GBASTATE");
	memcpy(raw.data(), magic.constData(), magic.size());
	raw[11] = char(4); // GBASTATE version 4
	QFile rom(m_config.romPath);
	if (rom.open(QIODevice::ReadOnly)) {
		rom.seek(0xA0);
		QByteArray head = rom.read(16);
		if (head.size() == 16) {
			memcpy(raw.data() + 12, head.constData(), 16);
		}
	}
	QByteArray compressed = zlibStored(raw);

	QByteArray payload;
	put16(&payload, quint16(MSG_STATE));
	put32(&payload, quint32(compressed.size()));
	payload.append(compressed);
	return payload;
}
