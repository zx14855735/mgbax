/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include "KcpChannel.h"

#include <QByteArray>
#include <QString>

#include <atomic>
#include <condition_variable>
#include <deque>
#include <mutex>
#include <thread>

namespace QGBA {

/**
 * 官方 WiFi 直连的 TCP 通道：一端 {@code ServerSocket.accept()}，另一端
 * {@code Socket.connect(host, port, 10s)}（KpHwm4.A2egSU.java:56-69 与
 * KpHwm4.AmA8tU.java:86-124）。
 *
 * 字节流上就是官方那一套帧：
 *
 * <pre>
 *   +----------------+----------------+--------------------+
 *   | u32 length (BE)| u16 type (BE)  | payload ...        |
 *   +----------------+----------------+--------------------+
 * </pre>
 *
 * length 含类型那 2 字节（BTvldC.ADYaiT），与 GBoyFrames 完全一致。
 *
 * ILink 的载荷约定与 DirectLink / WsLink 相同：{@code send()} 收到的
 * 是「长度 + 类型 + 载荷」整条线帧，{@code recv()} 交出的也是整条线帧
 * （含 4 字节长度头），这样 CloudLink::serveOfficial 的 GBoyFrames::Reader
 * 可以直接复用。
 *
 * 掉线重连照抄 AmA8tU：连接失败每 2 秒重试，累计 50 秒仍连不上就判断开；
 * 重连成功后先补一个 10 字节的重连握手包（GBoyFrames::TYPE_RECONNECT），
 * 再进入正常收发。
 */
class TcpDirectLink : public ILink {
public:
	~TcpDirectLink() override;

	/**
	 * 服务端：监听 port 并接受一个连接（官方 A2egSU：accept + 500ms SO_TIMEOUT）。
	 * 监听套接字保留到 close()，对端掉线后由读线程重新 accept。
	 */
	bool listenAndAccept(quint16 port, int timeoutMs, QString* error = nullptr);

	/**
	 * 客户端：连接 host:port，超时 timeoutMs（官方是 10 秒）。
	 * 连上之后由读线程负责掉线重连，不再让上层感知。
	 */
	bool connectTo(const QString& host, quint16 port, int timeoutMs, QString* error = nullptr);

	void send(const QByteArray& wireFrame) override;
	bool recv(QByteArray* out, int timeoutMs) override;
	bool isClosed() const override;
	void close() override;

	/** 对端地址文本，用于状态提示。 */
	QString peerText() const { return m_peerText; }
	/** 监听端口（服务端）或本机端口（客户端），调试用。 */
	quint16 localPort() const { return m_localPort; }
	/** 已完成的连接次数；>1 说明发生过重连。 */
	int connectCount() const { return m_connectCount; }

private:
	enum Mode {
		MODE_NONE,
		MODE_HOST,
		MODE_CLIENT,
	};

	void readerLoop();
	/** 服务端：在监听套接字上等下一个对端。 */
	bool acceptOnce();
	/** 客户端：按官方节奏重连；成功时补发重连握手包。 */
	bool reconnectOnce();
	/** 为一条已建立的连接启动读循环用到的状态。 */
	void adoptSocket(intptr_t socket, const QString& peer, bool reconnect);
	void dropSocket();
	/** 读一次（带超时）；dropped 置位表示连接已断。返回读到的字节数。 */
	int readSomeLocked(int timeoutMs, bool* dropped);
	/** 从 m_buffer 里切出完整线帧并塞进收件箱。 */
	void drainFrames();
	bool writeAll(const QByteArray& bytes);
	void markClosed();
	static void initSockets();

	Mode m_mode = MODE_NONE;
	QString m_host;
	quint16 m_port = 0;
	quint16 m_localPort = 0;
	QString m_peerText;

	intptr_t m_listener = -1; // 服务端监听套接字
	intptr_t m_socket = -1;   // 已建立的连接

	QByteArray m_buffer;

	mutable std::mutex m_mutex;
	std::deque<QByteArray> m_inbox;
	std::condition_variable m_inboxCv;
	std::mutex m_sendMutex;

	std::atomic<bool> m_closed{false};
	std::atomic<int> m_connectCount{0};
	std::thread m_thread;
	bool m_threadStarted = false;
	/** 上一次会话测得的 RTT（毫秒）；重连握手包里回填，-1 = 没有。 */
	int m_lastRtt = -1;
};

}
