/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "GBoyLinkSession.h"

#include "GBoyFrames.h"

namespace QGBA {

GBoyLinkSession::GBoyLinkSession(Transport transport, Events events, int localSlot, int playerCount)
	: m_transport(std::move(transport))
	, m_events(std::move(events))
	, m_localSlot(localSlot)
	, m_playerCount(playerCount)
{
}

QByteArray GBoyLinkSession::onLocalFrame(long frame, int localKeys) {
	QByteArray out;
	{
		std::lock_guard<std::mutex> locker(m_mutex);
		m_frameNo = frame;
		m_lastLocalKeys = localKeys;
		m_currentKeys[m_localSlot] = localKeys;
		/* 发送时机 = 5 帧心跳 ∪ 按键边沿。
		 *
		 * 官方 12Hz 纯采样会整块吞掉短按：一次 2 帧的 A 落在 5 帧网格里只有
		 * 40% 概率被采到，实测菜单期的连按大量丢失，对端的镜像核因此一直慢
		 * 一步——走到联机大厅时两边不在同一个子状态，multiboot 握手永远凑不
		 * 齐玩家（pc=0、主核一直发 0xB9A0 等待字、镜像核 SIOMLT_SEND 还是 0）。
		 * 边沿必须立刻发，采样网格只当保活心跳。 */
		bool edge = localKeys != m_lastSentKeys;
		if (--m_sampleCountdown <= 0 || edge) {
			m_sampleCountdown = KEY_SEND_INTERVAL_FRAMES;
			m_lastSentKeys = localKeys;
			out = keyFrameForLocalSlot(localKeys);
			++m_sentFrames;
		}
	}
	if (!out.isNull()) {
		m_transport(out);
	}
	return out;
}

int GBoyLinkSession::mirrorSlotFor(int localSlot, int playerCount, int index) {
	if (playerCount < 2 || playerCount > MAX_CONSOLES || localSlot < 1
	    || localSlot > playerCount || index < 0 || index >= playerCount - 1) {
		return 0;
	}
	int seen = 0;
	for (int slot = 1; slot <= playerCount; ++slot) {
		if (slot == localSlot) {
			continue;
		}
		if (seen == index) {
			return slot;
		}
		++seen;
	}
	return 0;
}

/* 3/4 人时键位帧必须自带目标槽位，与 Android 的 GBoyLinkSession.java、
 * iOS 的 LobbyLink.swift 保持同一套规则；两人会话仍发 TYPE_KEYS。 */
QByteArray GBoyLinkSession::keyFrameForLocalSlot(int keys) {
	if (m_playerCount <= 2 || m_localSlot == 1) {
		return GBoyFrames::frame(GBoyFrames::TYPE_KEYS, keys);
	}
	switch (m_localSlot) {
	case 2:
		return GBoyFrames::frame(GBoyFrames::TYPE_INPUT_2, keys);
	case 3:
		return GBoyFrames::frame(GBoyFrames::TYPE_INPUT_3, keys);
	case 4:
		return GBoyFrames::frame(GBoyFrames::TYPE_INPUT_4, keys);
	default:
		return GBoyFrames::frame(GBoyFrames::TYPE_KEYS, keys);
	}
}

int GBoyLinkSession::defaultSenderSlot() {
	if (m_playerCount > 2) {
		/* 云端 4 核房间两端都把可见核放在 localSlot=1，裸 TYPE_KEYS 不带
		 * 槽位，它代表「对端那台设备」，必须落到 slot 2（本机 4 核里代表
		 * 对端的那个镜像核）。返回 1 会把对端按键盖到自己的可见核上。 */
		return m_localSlot == 1 ? 2 : 1;
	}
	return m_localSlot == 2 ? 1 : 2;
}

int GBoyLinkSession::keysForSlot(int slot) {
	if (slot < 1 || slot > m_playerCount) {
		return 0;
	}
	std::lock_guard<std::mutex> locker(m_mutex);
	return m_currentKeys[slot];
}

void GBoyLinkSession::onFrameBody(const QByteArray& body, int senderSlot) {
	int type = GBoyFrames::typeOf(body);
	if (type < 0) {
		return;
	}
	switch (type) {
	case GBoyFrames::TYPE_KEYS:
	case GBoyFrames::TYPE_KEYS_LOCAL:
		pushKeys(senderSlot, GBoyFrames::intOf(body));
		break;
	case GBoyFrames::TYPE_INPUT_2:
	case GBoyFrames::TYPE_INPUT_3:
	case GBoyFrames::TYPE_INPUT_4: {
		int target = type == GBoyFrames::TYPE_INPUT_2 ? 2
		           : type == GBoyFrames::TYPE_INPUT_3 ? 3 : 4;
		pushKeys(target, GBoyFrames::intOf(body));
		break;
	}
	case GBoyFrames::TYPE_READY:
	case GBoyFrames::TYPE_RECONNECT:
	{
		// 官方语义：type 3 = 就绪 + RTT（int32）；type 5 是复位，不在这里。
		// type 100 = 断线重连握手包（AmA8tU.ARc23Z(Socket)），体里同样带 RTT，
		// 收到它说明对端重连上来了，按「对端已就绪」处理，不能让默认分支把
		// 它当未知类型（对端会一直以为我们没回来）。
		bool first = false;
		{
			std::lock_guard<std::mutex> locker(m_mutex);
			first = !m_ready;
			m_ready = true;
			if (GBoyFrames::payloadOf(body).size() >= 4) {
				m_remoteRtt = GBoyFrames::intOf(body);
			}
		}
		if (type == GBoyFrames::TYPE_RECONNECT && m_events.onStatus) {
			m_events.onStatus(QStringLiteral("peer reconnected (rtt %1 ms)")
			                          .arg(GBoyFrames::intOf(body)));
		}
		if (first && m_events.onReady) {
			m_events.onReady();
		}
		break;
	}
	case GBoyFrames::TYPE_REGISTER:
	{
		bool first = false;
		{
			std::lock_guard<std::mutex> locker(m_mutex);
			first = !m_ready;
			m_ready = true;
		}
		if (first && m_events.onReady) {
			m_events.onReady();
		}
		break;
	}
	case GBoyFrames::TYPE_NAME:
	{
		// 官方 type 2：32 字节定长名字 + int16 长度 + 描述串。只用于显示。
		QByteArray payload = GBoyFrames::payloadOf(body);
		if (payload.size() >= 34) {
			QByteArray name = payload.left(32);
			int at = name.indexOf('\0');
			if (at >= 0) {
				name.truncate(at);
			}
			int n = (quint8(payload[32]) << 8) | quint8(payload[33]);
			QByteArray desc = payload.mid(34, n);
			if (m_events.onStatus) {
				m_events.onStatus(QStringLiteral("peer %1 (%2)")
				                          .arg(QString::fromUtf8(name),
				                               QString::fromUtf8(desc)));
			}
		}
		break;
	}
	case GBoyFrames::TYPE_RESET:
	case GBoyFrames::TYPE_RESET_LEGACY:
		/* 官方 5 = 复位；13 是我们旧版的号，收到也照做，方便旧客户端互通。 */
		if (m_events.onReset) {
			m_events.onReset();
		}
		break;
	case GBoyFrames::TYPE_STATE:
		if (m_events.onState) {
			m_events.onState(stateOf(body));
		}
		break;
	case GBoyFrames::TYPE_COUNTER:
	{
		std::lock_guard<std::mutex> locker(m_mutex);
		m_remoteCounter = GBoyFrames::intOf(body);
		break;
	}
	case GBoyFrames::TYPE_SPEED:
	{
		/* 官方 9 = 速度倍率（1 / -1 / 2 / 4）。收下备用，不改变本机节拍：
		 * 我们的帧率由前端固定 60fps，倍速只在官方客户端 UI 里有意义。 */
		std::lock_guard<std::mutex> locker(m_mutex);
		m_remoteSpeed = GBoyFrames::intOf(body);
		break;
	}
	case GBoyFrames::TYPE_EVENT:
		if (m_events.onStatus) {
			m_events.onStatus(QStringLiteral("event %1").arg(GBoyFrames::intOf(body)));
		}
		break;
	default:
		if (m_events.onStatus) {
			m_events.onStatus(QStringLiteral("unknown frame type %1").arg(type));
		}
		break;
	}
}

void GBoyLinkSession::onFrameBody(const QByteArray& body) {
	onFrameBody(body, defaultSenderSlot());
}

void GBoyLinkSession::onWireFrame(const QByteArray& wire, int senderSlot) {
	if (wire.size() < 6) {
		return;
	}
	int length = int(GBoyFrames::getInt(wire, 0));
	if (length < 2 || length > wire.size() - 4) {
		return;
	}
	QByteArray body = wire.mid(4, length);
	onFrameBody(body, senderSlot);
}

void GBoyLinkSession::onWireFrame(const QByteArray& wire) {
	onWireFrame(wire, defaultSenderSlot());
}

void GBoyLinkSession::injectKeysForSlot(int slot, int keys) {
	pushKeys(slot, keys);
}

void GBoyLinkSession::pushKeys(int slot, int keys) {
	if (slot < 1 || slot > MAX_CONSOLES) {
		return;
	}
	/* 「最新即生效」而不是排队。
	 *
	 * 原来按 5 帧一格的节拍排队消费，对端一发边沿帧队列就会积压，镜像核拿
	 * 到的是几帧前的按键（延迟越积越大）；反过来队列被压到上限又会丢最新的
	 * 按键。镜像核每帧都读一次 keysForSlot()，直接覆盖当前值既没有延迟、也
	 * 不会漏掉任何一个按下沿：按下帧覆盖、松开帧再覆盖，中间持续多久镜像核
	 * 就看到多久。 */
	std::lock_guard<std::mutex> locker(m_mutex);
	m_currentKeys[slot] = keys;
}

void GBoyLinkSession::sendRegistration(int baseStateCount) {
	m_transport(GBoyFrames::registerFrame(m_playerCount, baseStateCount));
}

void GBoyLinkSession::sendSocketHandshake() {
	m_transport(GBoyFrames::frame(GBoyFrames::TYPE_REGISTER, SOCKET_HANDSHAKE_VALUE));
}

void GBoyLinkSession::sendState(const QByteArray& state) {
	QByteArray body(4 + state.size(), 0);
	GBoyFrames::putInt(&body, 0, quint32(state.size()));
	if (!state.isEmpty()) {
		memcpy(body.data() + 4, state.constData(), state.size());
	}
	m_transport(GBoyFrames::frame(GBoyFrames::TYPE_STATE, body));
}

QByteArray GBoyLinkSession::stateOf(const QByteArray& body) {
	QByteArray payload = GBoyFrames::payloadOf(body);
	if (payload.size() < 4) {
		return QByteArray();
	}
	int length = int(GBoyFrames::getInt(payload, 0));
	if (length < 0 || length > payload.size() - 4) {
		return QByteArray();
	}
	return payload.mid(4, length);
}

void GBoyLinkSession::sendReset() {
	m_transport(GBoyFrames::frame(GBoyFrames::TYPE_RESET, 0));
}

void GBoyLinkSession::sendSpeed(int speed) {
	m_transport(GBoyFrames::frame(GBoyFrames::TYPE_SPEED, speed));
}

long GBoyLinkSession::frameNo() {
	std::lock_guard<std::mutex> locker(m_mutex);
	return m_frameNo;
}

bool GBoyLinkSession::isReady() {
	std::lock_guard<std::mutex> locker(m_mutex);
	return m_ready;
}

int GBoyLinkSession::remoteCounter() {
	std::lock_guard<std::mutex> locker(m_mutex);
	return m_remoteCounter;
}

int GBoyLinkSession::remoteSpeed() {
	std::lock_guard<std::mutex> locker(m_mutex);
	return m_remoteSpeed;
}

int GBoyLinkSession::remoteRtt() {
	std::lock_guard<std::mutex> locker(m_mutex);
	return m_remoteRtt;
}

long GBoyLinkSession::droppedFrames() {
	std::lock_guard<std::mutex> locker(m_mutex);
	return m_droppedFrames;
}

}
