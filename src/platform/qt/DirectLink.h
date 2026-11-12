/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include "KcpChannel.h"

#include <QByteArray>
#include <QList>
#include <QMap>
#include <QQueue>
#include <QString>
#include <QStringList>

#include <cstdint>

namespace QGBA {

/**
 * 直连（P2P）通道：两个玩家之间直接收发联机线字节，**不经过 gboy.top**。
 *
 * 为什么要有它：跨网联机目前只能走大厅的 send_message 隧道，实测一个 SIO
 * 回合（1P 发字 → 2P 回字）要 165 ms（本机到 gboy.top 62 ms + 服务器转发
 * 里外各 30 ms 左右）。联机线是严格一问一答，延迟直接变成游戏内慢放。
 * 直连把这一跳砍掉：
 *
 *   局域网                1-3 ms
 *   同城/同省（锥形 NAT） 10-30 ms
 *   跨省                  30-60 ms
 *
 * 建链方式（复用大厅 WS 做信令，不需要任何额外服务器）：
 *   1. 绑定一个 UDP 端口，向 STUN 拿自己的公网映射地址（srflx）；
 *   2. 把「网卡地址 + 公网映射地址」通过隧道标记发给对端，同时收对端的；
 *   3. 双方朝对方所有候选地址发 PROBE 打洞，收到回应即双向可达；
 *   4. 打通就切过来，打不通（对称 NAT / 企业网）就留在大厅隧道。
 *
 * 可靠性：联机线的 20 字节小包不能丢，所以自带一个极简可靠层（序号 +
 * 累积确认 + 超时重传 + 去重排序），重传窗口按实测 RTT 自适应。
 */
class DirectLink : public ILink {
public:
	DirectLink();
	~DirectLink() override;

	/** 绑定本地 UDP 端口（临时端口）。 */
	bool bind(QString* error = nullptr);

	/**
	 * 候选地址列表（"ip:port"）：本机所有网卡 IPv4 + STUN 拿到的公网映射。
	 * 会阻塞最多约 1 秒（STUN 超时）。
	 */
	QStringList candidates();

	/** 对端候选地址（来自隧道标记）。 */
	void setPeerCandidates(const QStringList& list);

	/** 开始打洞：周期性向所有对端候选发 PROBE。 */
	void startPunching();

	/** 收包 + 定时重传 / 探活；返回本次是否读到有效包。 */
	bool pump(int timeoutMs);

	bool connected() const { return m_connected; }
	/** 最近一次往返时延（微秒）。 */
	int rttUs() const { return m_rttUs; }
	/** 对端地址文本，用于状态提示。 */
	QString peerText() const { return m_peerText; }
	qint64 punchStartMs() const { return m_punchStart; }
	/** 本机 UDP 端口（调试用）。 */
	quint16 localPort() const { return m_localPort; }

	// ILink
	void send(const QByteArray& payload) override;
	bool recv(QByteArray* out, int timeoutMs) override;
	bool isClosed() const override { return m_closed; }
	void close() override;

private:
	enum Type {
		TYPE_PROBE = 1,
		TYPE_RESP = 2,
		TYPE_DATA = 3,
		TYPE_CTRL = 4,
		TYPE_BYE = 5,
	};

	struct Candidate {
		quint32 ip = 0; // network order
		quint16 port = 0;
	};

	struct Outgoing {
		quint16 seq = 0;
		QByteArray payload;
		qint64 firstSent = 0;
		qint64 lastSent = 0;
		int tries = 0;
	};

	qint64 nowMs() const;
	bool waitReadable(int timeoutMs);
	bool readSocket(int timeoutMs);
	void handlePacket(const char* data, int len, const Candidate& from);
	void sendPacket(Type type, quint16 seq, const QByteArray& payload, const Candidate& to);
	void sendControl(const Candidate& to);
	void flushRetransmits(qint64 now);
	void noteReceived(quint16 seq);
	void noteAck(quint16 ackSeq, quint32 ackBits);

	intptr_t m_sock = -1;
	quint16 m_localPort = 0;
	quint32 m_tag = 0;

	QList<Candidate> m_peerCandidates;
	QList<Candidate> m_sendTargets; // 打洞阶段的目标（连通后只用 m_peer）
	Candidate m_peer;
	QString m_peerText;
	bool m_havePeer = false;
	bool m_connected = false;
	bool m_closed = false;
	bool m_punching = false;
	qint64 m_punchStart = 0;
	qint64 m_lastProbe = 0;
	qint64 m_lastKeepalive = 0;
	qint64 m_lastRecv = 0;
	quint16 m_probeSeq = 0;

	quint16 m_nextSeq = 0;
	QQueue<Outgoing> m_outgoing;
	QMap<quint16, QByteArray> m_incoming; // 乱序缓存
	quint16 m_rcvNext = 0;
	bool m_rcvStarted = false;
	QQueue<QByteArray> m_inbox;

	quint16 m_ackSeq = 0;
	quint32 m_ackBits = 0;
	bool m_ackSeen = false;

	int m_rttUs = 0;
};

}
