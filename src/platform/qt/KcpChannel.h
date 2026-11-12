/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QByteArray>
#include <QThread>
#include <array>
#include <condition_variable>
#include <deque>
#include <map>
#include <mutex>
#include <thread>
#include <vector>

namespace QGBA {

/**
 * Minimal transport shared by the KCP relay and the websocket tunnel; the
 * cloud handshake and the game loop run unchanged over either one. The
 * signatures match KcpChannel's existing methods on purpose.
 */
struct ILink {
	virtual ~ILink() = default;

	/** Queues a payload for the peer. */
	virtual void send(const QByteArray& payload) = 0;

	/** Next payload from the peer, or false after {@code timeoutMs}. */
	virtual bool recv(QByteArray* out, int timeoutMs) = 0;

	virtual bool isClosed() const = 0;

	virtual void close() = 0;
};

/**
 * KCP over UDP - the transport gboy.top's cloud rooms use, a C++ port of the
 * Android KcpChannel. The parameters and the byte order are taken from the
 * official GBoy client:
 *
 *   - KCP header in <b>big endian</b>: conv, cmd, frg, wnd, ts, sn, una, len
 *   - MTU 512, so MSS 488
 *   - update interval 30 ms
 *   - send and receive window 128
 *   - the conversation id is a random positive int
 *
 * On top of that sits GBoy's own handshake: the client sends {@code "HS"},
 * the node answers {@code "HK"}, both retry three times with three seconds in
 * between. A one second {@code PING}/{@code PONG} heartbeat keeps the session
 * alive and {@code "DISC"} closes it.
 *
 * A TCP transport is also available for relays published through a TCP
 * tunnel (ssh -R / bore): each payload is framed with a big endian u32
 * length, bypassing KCP entirely - exactly like the Android version.
 */
class KcpChannel : public ILink {
public:
	/** Largest frame body accepted on a stream channel.
	 *
	 * 16 MiB, the same ceiling the Android `KcpChannel` and `GBoyFrames` use.
	 * The original 65535 was wrong: a GBA save state is roughly 790 KiB (the
	 * Android log measured 790663 bytes), so a state transfer tripped this check
	 * and the channel was declared dead - the cloud link could never carry a
	 * save state, and the peer never applied the host's snapshot. */
	static constexpr quint32 MAX_FRAME_LENGTH = 16u * 1024u * 1024u;
	static constexpr int UDP_MTU = 512;
	static constexpr int UDP_WND = 128;
	static constexpr int UDP_INTERVAL_MS = 30;

	~KcpChannel();

	/**
	 * Opens a session <em>without</em> the handshake, so the caller can retry
	 * on the very same conversation id and UDP port. The relay keeps a tiny,
	 * slowly recycled session table; every retry that builds a brand new
	 * session fills that table with half open leftovers, and once it is full
	 * the relay silently drops the newcomer. Retrying on one session avoids
	 * that.
	 */
	static KcpChannel* open(const QString& host, quint16 port, quint32 conv, QString* error);
	/** Same, but through a framed TCP tunnel. */
	static KcpChannel* openTcp(const QString& host, quint16 port, QString* error);

	/** Completes HS/HK; returns false when the node stayed silent. */
	bool handshake(int tries = 3, int waitMs = 3000, QString* error = nullptr);

	/** Re-sends {@code HS} on the current session and waits for {@code HK}. */
	bool retryHandshake(int timeoutMs, QString* error = nullptr);

	/** Queues a payload; the pump thread transmits it. */
	void send(const QByteArray& payload) override;

	/** Next payload from the peer, or false after {@code timeoutMs}. */
	bool recv(QByteArray* out, int timeoutMs) override;

	bool isClosed() const override { return !m_running; }

	void close() override;

private:
	/** IPv4 address (network order) + port, resolved once at open. */
	struct Endpoint {
		quint32 ip = 0;
		quint16 port = 0;
	};

	struct Seg {
		quint32 conv = 0;
		int cmd = 0;
		int frg = 0;
		int wnd = 0;
		quint32 ts = 0;
		quint32 sn = 0;
		quint32 una = 0;
		QByteArray data;
		qint64 resendts = 0;
		qint64 rto = 200;
		int xmit = 0;

		QByteArray encode() const;
	};

	class Kcp {
	public:
		Kcp(quint32 conv, int mtu, int intervalMs);

		void input(const QByteArray& data);
		void send(const QByteArray& data);
		QByteArray recv();
		std::vector<QByteArray> update(qint64 now);

		const quint32 conv;
		const int mss;
		const int intervalMs;

	private:
		int window() const;
		void ackUpTo(int uptoSn, int exactTs);
		void recvPush(int sn, int frg, const QByteArray& payload);
		void deliver(int sn, int frg, const QByteArray& payload);

		std::deque<QByteArray> sndQueue;
		std::vector<Seg> sndBuf;
		std::map<quint32, Seg> rcvBuf;
		std::deque<QByteArray> rcvQueue;
		std::vector<std::array<int, 2>> acks;
		quint32 sndNxt = 0;
		quint32 rcvNxt = 0;
		quint32 sndUna = 0;
		int rmtWnd = UDP_WND;
		qint64 rto = 200;
		qint64 nextUpdate = 0;
		int frgRemaining = 0;
		std::vector<QByteArray> parts;

	public:
		std::mutex mutex;
	};

	KcpChannel(quint32 conv, const QString& host, quint16 port, bool tcp);
	bool openSockets(QString* error);
	void pumpLoop();
	void deliver(const QByteArray& message);
	bool tcpSend(const QByteArray& payload);
	/** UDP send that bypasses KCP entirely (the relay's raw HS/HK/PING control
	 * datagrams). On the TCP transport falls back to the framed send. */
	void rawDatagramSend(const QByteArray& payload);
	void closeSocket();

	static bool resolve(const QString& host, quint16 port, Endpoint* endpoint, bool tcp, QString* error);

	quint32 m_conv;
	bool m_tcp;
	QString m_host;
	quint16 m_port;
	Endpoint m_endpoint;
	intptr_t m_socket = -1; // UDP socket or TCP stream, per m_tcp

	std::unique_ptr<Kcp> m_kcp;
	std::deque<QByteArray> m_inbox;
	std::mutex m_inboxMutex;
	std::condition_variable m_inboxCv;
	std::atomic<bool> m_running{false};
	std::atomic<bool> m_handshakeDone{false};
	std::atomic<bool> m_dead{false};
	std::thread m_thread;
	bool m_threadStarted = false;
};

}
