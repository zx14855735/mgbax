/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QByteArray>
#include <QString>
#include <QThread>
#include <atomic>

#include "platform/mobile/mgba_mobile.h"

namespace QGBA {

class GBoyLinkSession;

/**
 * The hidden second console of the official GBoy cloud layout, a PC port of
 * the Android GBoyConsoleSet (one mirror for 2P).
 *
 * The mirror loads the same ROM over a copy of the local save, joins the
 * visible core's native link driver over 127.0.0.1 (primary linkHost, mirror
 * linkJoin - the SIO conversation never leaves the process), and replays the
 * remote player's key masks into its own core at ~60 fps. Only key masks (and
 * one TYPE_STATE seed) cross the network, which is what lets both sides run at
 * full single-player speed over the gboy.top servers.
 */
class GBoyMirror : public QThread {
Q_OBJECT

public:
	explicit GBoyMirror(QObject* parent = nullptr);
	/**
	 * Copies {@code primarySavePath} into {@code mirrorRoot}, loads the ROM and
	 * joins the primary's loopback listener. {@code session} supplies the peer
	 * key masks (slot 2). Returns false with {@code error} set on failure.
	 */
	/**
	 * @param slot       按键取自会话的哪个槽位（2/3/4）。
	 * @param players    SIO 房间人数，必须与可见核的 sioHostPlayers 一致。
	 * @param navIdx     busgame 导航的四人座位编号 1/2/3；负数 = 不启用脚本
	 *                   （正常玩家联机绝不能被脚本接管）。
	 */
	bool start(const QString& romPath, const QString& primarySavePath,
	           const QString& mirrorRoot, quint16 primaryPort,
	           GBoyLinkSession* session, int slot, int players,
	           int navIdx, int navMenuAt, int navModeDowns,
	           const QByteArray& saveSnapshot, QString* error);

	/** Closes the loopback link, stops the pump thread and destroys the core. */
	void stopMirror();

	/** Applies a peer TYPE_STATE blob to the mirror core (thread safe). */
	bool applyRemoteState(const QByteArray& state);

	bool isRunningMirror() const { return m_running.load(std::memory_order_relaxed); }

protected:
	void run() override;

private:
	struct MgbaMobile* m_emu = nullptr;
	GBoyLinkSession* m_session = nullptr;
	int m_slot = 2;
	int m_players = 2;
	std::atomic<bool> m_running{false};
};

}
