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
		if (--m_sampleCountdown <= 0) {
			m_sampleCountdown = KEY_SEND_INTERVAL_FRAMES;
			for (int slot = 1; slot <= m_playerCount; ++slot) {
				if (slot == m_localSlot) {
					continue;
				}
				std::deque<int>& queue = m_pending[slot];
				if (!queue.empty()) {
					m_currentKeys[slot] = queue.front();
					queue.pop_front();
				}
			}
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
		return GBoyFrames::frame(GBoyFrames::TYPE_READY, keys);
	case 4:
		return GBoyFrames::frame(GBoyFrames::TYPE_INPUT_4, keys);
	default:
		return GBoyFrames::frame(GBoyFrames::TYPE_KEYS, keys);
	}
}

int GBoyLinkSession::defaultSenderSlot() {
	return m_playerCount > 2 ? 1 : (m_localSlot == 2 ? 1 : 2);
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
	case GBoyFrames::TYPE_READY:
	case GBoyFrames::TYPE_INPUT_4: {
		// The official client reuses type 3: bare frame = handshake
		// READY, frame with an int = key mask for console slot 3.
		if (type == GBoyFrames::TYPE_READY && GBoyFrames::payloadOf(body).size() < 4) {
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
		int target = type == GBoyFrames::TYPE_INPUT_2 ? 2
		           : type == GBoyFrames::TYPE_READY ? 3 : 4;
		pushKeys(target, GBoyFrames::intOf(body));
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
	case GBoyFrames::TYPE_RESET:
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
	case GBoyFrames::TYPE_FPS:
	{
		std::lock_guard<std::mutex> locker(m_mutex);
		m_remoteFps = GBoyFrames::intOf(body);
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

void GBoyLinkSession::pushKeys(int slot, int keys) {
	if (slot < 1 || slot > MAX_CONSOLES) {
		return;
	}
	bool report = false;
	long total = 0;
	{
		std::lock_guard<std::mutex> locker(m_mutex);
		std::deque<int>& queue = m_pending[slot];
		queue.push_back(keys);
		if (queue.size() > BACKLOG_LIMIT) {
			queue.pop_front();
			++m_droppedFrames;
			// Two emulators rarely run at the same frame rate, so the peer
			// can be ahead on almost every key frame. Report the first few
			// and then only occasionally, exactly like the Android port.
			total = m_droppedFrames;
			report = total <= 3 || (total & 0xFFL) == 0;
		}
	}
	if (report && m_events.onStatus) {
		m_events.onStatus(QStringLiteral("peer slot %1 ahead, dropped oldest key frame (total %2)")
		                          .arg(slot).arg(total));
	}
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

void GBoyLinkSession::sendFps(int fps) {
	m_transport(GBoyFrames::frame(GBoyFrames::TYPE_FPS, fps));
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

int GBoyLinkSession::remoteFps() {
	std::lock_guard<std::mutex> locker(m_mutex);
	return m_remoteFps;
}

long GBoyLinkSession::droppedFrames() {
	std::lock_guard<std::mutex> locker(m_mutex);
	return m_droppedFrames;
}

}
