/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QByteArray>
#include <QString>
#include <deque>
#include <functional>
#include <mutex>

namespace QGBA {

/**
 * The GBoy 26.10.18 link session, a C++ port of the Android GBoyLinkSession
 * (which itself was ported from the official client):
 *
 * The official client keeps every console of a match alive in ONE process
 * (`Link` owns up to four `Console`s) so SIO never leaves the device; only key
 * masks cross the network, broadcast once every five frames (12 Hz at 60 fps).
 * The frame loop calls onLocalFrame() once per frame, the network layer feeds
 * onFrameBody(), and the console for a remote player reads keysForSlot().
 * Advancing the cores stays with the front end, because the mGBA native link
 * driver needs one execution thread per core.
 */
class GBoyLinkSession {
public:
	/** Official `Link` allocates its console list with capacity four. */
	static constexpr int MAX_CONSOLES = 4;
	/** The official counter starts at 5 and decrements once per frame. */
	static constexpr int KEY_SEND_INTERVAL_FRAMES = 5;
	/** Beyond this many queued key frames the peer is ahead; drop the oldest. */
	static constexpr int BACKLOG_LIMIT = 2;
	/** Local handshake value of the socket transport (type 1, int 6). */
	static constexpr int SOCKET_HANDSHAKE_VALUE = 6;

	/** Sends one complete wire frame (length + type + payload). */
	using Transport = std::function<void(const QByteArray&)>;

	/** Session-level events the front end has to act on. */
	struct Events {
		/** A TYPE_RESET arrived: reset every local console. */
		std::function<void()> onReset;
		/** A TYPE_STATE arrived with the save-state blob. */
		std::function<void(const QByteArray& state)> onState;
		/** The peer finished the handshake. */
		std::function<void()> onReady;
		/** Diagnostic text. */
		std::function<void(const QString& text)> onStatus;
	};

	GBoyLinkSession(Transport transport, Events events, int localSlot, int playerCount);

	/**
	 * Called once per local frame (the cloud serve loop drives it on the 50 ms
	 * wall-clock tick, the same 12 Hz cadence the official client keeps). Every
	 * fifth call it samples one queued key mask for each remote console and
	 * broadcasts the local mask; the four frames in between keep the last
	 * sampled mask. Returns the frame sent, or a null array.
	 */
	QByteArray onLocalFrame(long frame, int localKeys);

	/** Key mask the frame loop must inject into the console of {@code slot}. */
	int keysForSlot(int slot);

	/**
	 * Handles one complete frame body (type followed by payload) from a peer.
	 * {@code senderSlot} is the slot of the console owned by that peer; a bare
	 * TYPE_KEYS frame therefore targets that slot, while TYPE_INPUT_2/3/4
	 * target the slot named by the type when several consoles are in play.
	 */
	void onFrameBody(const QByteArray& body, int senderSlot);

	/** Uses the default sender slot: slot 2 for a slot-1 device in 3/4-player sessions. */
	void onFrameBody(const QByteArray& body);

	/**
	 * Feeds a raw wire frame (u32 length + u16 type + payload), which is what a
	 * socket or WebSocket transport actually hands over. The length is
	 * validated before the body is dispatched, so a truncated or corrupt frame
	 * cannot be mistaken for a key mask.
	 */
	void onWireFrame(const QByteArray& wire, int senderSlot);
	void onWireFrame(const QByteArray& wire);

	/** Official cloud registration: ten byte body, see GBoyFrames::registerFrame. */
	void sendRegistration(int baseStateCount);

	/** Official socket handshake: type 1 carrying int 6. */
	void sendSocketHandshake();

	/** TYPE_STATE = int length followed by the save-state blob. */
	void sendState(const QByteArray& state);

	/** Extracts the save-state blob out of a TYPE_STATE body. */
	static QByteArray stateOf(const QByteArray& body);

	void sendReset();
	void sendFps(int fps);

	long frameNo();
	bool isReady();
	int remoteCounter();
	int remoteFps();
	long droppedFrames();

	/** 第 index 个镜像核代表的全局槽位；三端共用同一套布局规则。 */
	static int mirrorSlotFor(int localSlot, int playerCount, int index);

	int localSlot() const { return m_localSlot; }
	int playerCount() const { return m_playerCount; }

private:
	QByteArray keyFrameForLocalSlot(int keys);
	int defaultSenderSlot();
	void pushKeys(int slot, int keys);

	Transport m_transport;
	Events m_events;
	int m_localSlot;
	int m_playerCount;

	mutable std::mutex m_mutex;
	std::deque<int> m_pending[MAX_CONSOLES + 1];
	int m_currentKeys[MAX_CONSOLES + 1] = {0};

	long m_frameNo = 0;
	int m_sampleCountdown = 1;
	bool m_ready = false;
	int m_remoteCounter = -1;
	int m_remoteFps = -1;
	int m_lastLocalKeys = 0;
	/** 上一次真正发出去的按键掩码；边沿立即发送靠它判变化（-1 = 强制首帧）。 */
	int m_lastSentKeys = -1;
	int m_sentFrames = 0;
	long m_droppedFrames = 0;
};

}
