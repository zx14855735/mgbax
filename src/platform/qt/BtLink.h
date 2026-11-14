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
 * 蓝牙 RFCOMM 通道，照抄官方客户端（KpHwm4.B25kr6.java:21 与 A2egSU.java）：
 *
 *   - 服务名 {@code GBoy}
 *   - 服务类 UUID {@code 3a1f7b2e-8d45-4c92-bf60-5e3c21a98d47}
 *     （B25kr6.f4349AcNBzu，服务端 SDP 注册、客户端 SDP 查找都用它）
 *   - 服务端 {@code listenUsingRfcommWithServiceRecord} 等价物 = bind 到
 *     BT_PORT_ANY + WSASetService 注册 SDP + accept
 *   - 客户端 {@code createRfcommSocketToServiceRecord} 等价物 = connect 到
 *     SOCKADDR_BTH{btAddr, serviceClassId}，由协议栈自己走 SDP
 *   - 字节流上仍是「4B 大端长度 + u16 type + payload」那套帧
 *
 * 只在 Windows 上真正可用（{@code AF_BTH} + {@code BTHPROTO_RFCOMM}）；
 * 非 Windows 或本机 SDK 缺 {@code ws2bth.h} 时 {@link supported()} 为 false，
 * 所有 open 调用都返回失败——不会让整体编译失败，也不会悄悄改变联机行为。
 *
 * ILink 载荷约定与 DirectLink / TcpDirectLink 一致：一整条线帧（含长度头）。
 */
class BtLink : public ILink {
public:
	~BtLink() override;

	/** 本机（Windows + 有 ws2bth.h）是否支持 RFCOMM。 */
	static bool supported();

	/** 服务端：注册 SDP 记录（服务名 GBoy）并等待一个对端连接。 */
	bool openHost(int timeoutMs, QString* error = nullptr);

	/** 客户端：连接 BT 地址（"AA:BB:CC:DD:EE:FF"），按服务 UUID 走 SDP。 */
	bool openClient(const QString& address, int timeoutMs, QString* error = nullptr);

	void send(const QByteArray& wireFrame) override;
	bool recv(QByteArray* out, int timeoutMs) override;
	bool isClosed() const override;
	void close() override;

	QString peerText() const { return m_peerText; }

private:
	void readerLoop();
	int readSomeLocked(int timeoutMs, bool* dropped);
	void drainFrames();
	bool writeAll(const QByteArray& bytes);
	void dropSocket();

	intptr_t m_socket = -1;
	intptr_t m_listener = -1;
	/** 服务端注册的 SDP 记录（关闭时要拿同一份去反注册）。 */
	QByteArray m_sdpRecord;
	bool m_sdpRegistered = false;

	QByteArray m_buffer;
	QString m_peerText;

	mutable std::mutex m_mutex;
	std::deque<QByteArray> m_inbox;
	std::condition_variable m_inboxCv;
	std::mutex m_sendMutex;

	std::atomic<bool> m_closed{false};
	std::thread m_thread;
	bool m_threadStarted = false;
};

}
