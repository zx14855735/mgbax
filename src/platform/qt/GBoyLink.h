/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QByteArray>
#include <QThread>
#include <atomic>
#include <memory>

namespace QGBA {

/**
 * GBoy / My Boy "联机大厅" Wi-Fi protocol, a Qt port of the Android GBoyLink
 * and the iOS GBoyLink.swift: plain TCP with big-endian framing, every packet
 * is `[u32 payload length][payload]` and the payload starts with a `u16`
 * message type.
 *
 *   1 HELLO   u16 type + u32 6; the client sends it first, the server echoes.
 *   2 ROMINFO u16 type + 32-byte ASCII MD5 of the ROM + u16 name length + name.
 *   3 READY   u16 type only, sent once the local console is loaded.
 *   4 KEYS    u16 type + u32 GBA key mask (same bit layout mGBA uses).
 *   5 RESET   u16 type only.
 *   6 STATE   u16 type + u32 size + zlib-compressed GBASTATE v4 image.
 *
 * After the handshake each side sends its key mask about every five frames
 * (~83 ms) and applies the mask it receives. This port uses the merged-keys
 * mode of the Android version: the remote mask is OR-ed into the local input,
 * there is no second console, and the synthesized STATE image only satisfies
 * the handshake (each side keeps its own progress).
 */
class GBoyLink : public QThread {
Q_OBJECT

public:
	enum Mode { HOST, JOIN };

	struct Config {
		Mode mode = HOST;
		QString ip; // JOIN only
		quint16 port = 6374;
		QString romPath;
	};

	GBoyLink(QObject* parent = nullptr);
	~GBoyLink();

	void startLink(const Config& config);
	void stopLink();
	void sendReset();
	void setLocalKeys(int keys) { m_localKeys.store(keys, std::memory_order_relaxed); }

signals:
	void statusMessage(const QString& message);
	void remoteKeys(int mask);
	void remoteReset();
	void linkEnded(const QString& message);

protected:
	void run() override;

private:
	bool handshake(intptr_t fd, bool asHost, QString* note);
	bool expectHello(intptr_t fd, bool asHost);
	bool sendFrame(intptr_t fd, const QByteArray& payload);
	// 1 = frame in out, 0 = timed out (no full frame yet), -1 = error/disconnect
	int readFrame(intptr_t fd, QByteArray* rxBuf, QByteArray* out, int timeoutMs);
	bool readUntil(intptr_t fd, QByteArray* rxBuf, int want, QByteArray* out, int timeoutMs);

	QByteArray romInfoFrame() const;
	QByteArray keysFrame(int keys) const;
	QByteArray stateFrame() const;

	static QByteArray frame(int type);
	static QByteArray helloFrame();

	Config m_config;
	std::atomic<bool> m_aborted{false};
	std::atomic<bool> m_sendReset{false};
	std::atomic<int> m_localKeys{0};
};

}
