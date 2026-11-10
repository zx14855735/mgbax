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
	bool start(const QString& romPath, const QString& primarySavePath,
	           const QString& mirrorRoot, quint16 primaryPort,
	           GBoyLinkSession* session, QString* error);

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
	std::atomic<bool> m_running{false};
};

}
