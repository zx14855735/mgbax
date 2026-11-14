/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "GBoyMirror.h"

#include "GBoyLinkSession.h"

#include <QDateTime>
#include <QDir>
#include <QFile>
#include <QFileInfo>

using namespace QGBA;

namespace {

/** One mirror frame at 60 fps; the pump keeps SIO latency at one frame. */
constexpr long FRAME_INTERVAL_US = 16667;
/** How long to wait for the loopback link to come up before giving up. */
constexpr int LINK_WAIT_MS = 4000;

QString saveNameFor(const QString& romPath) {
	QString base = QFileInfo(romPath).completeBaseName();
	if (base.isEmpty()) {
		base = QStringLiteral("mirror");
	}
	return base + QStringLiteral(".sav");
}

} // namespace

GBoyMirror::GBoyMirror(QObject* parent)
	: QThread(parent)
{
}

bool GBoyMirror::start(const QString& romPath, const QString& primarySavePath,
                       const QString& mirrorRoot, quint16 primaryPort,
                       GBoyLinkSession* session, int slot, int players,
                       int navIdx, int navMenuAt, int navModeDowns,
                       const QByteArray& saveSnapshot, QString* error) {
	if (m_running.load(std::memory_order_relaxed)) {
		if (error) {
			*error = QStringLiteral("镜像控制台已在运行");
		}
		return false;
	}
	if (romPath.isEmpty() || !QFileInfo::exists(romPath)) {
		if (error) {
			*error = QStringLiteral("镜像加载失败：ROM 不存在");
		}
		return false;
	}
	QDir root(mirrorRoot);
	if (!root.mkpath(QStringLiteral("."))) {
		if (error) {
			*error = QStringLiteral("无法创建镜像目录 %1").arg(mirrorRoot);
		}
		return false;
	}
	QString stateRoot = root.filePath(QStringLiteral("state"));
	QDir().mkpath(stateRoot);
	// Determinism: every mirror boots from the SAME byte-for-byte snapshot of
	// the local save. The old code called QFile::copy() per mirror: it fails
	// when the target already exists (so a stale save from the previous session
	// was silently reused), and re-reads a source that the visible core may
	// have rewritten between iterations. Four cores with different starting
	// progress never complete the SIO handshake (Android showed this too).
	QString saveTarget = root.filePath(saveNameFor(romPath));
	if (!saveSnapshot.isEmpty()) {
		QFile::remove(saveTarget);
		QFile out(saveTarget);
		if (!out.open(QIODevice::WriteOnly)
		    || out.write(saveSnapshot) != saveSnapshot.size()) {
			if (error) {
				*error = QStringLiteral("无法把存档快照写入镜像目录：")
				         + out.errorString();
			}
			return false;
		}
	} else {
		QFile saveSource(primarySavePath);
		if (!primarySavePath.isEmpty() && saveSource.exists()) {
			QFile::remove(saveTarget);
			if (!saveSource.copy(saveTarget)) {
				if (error) {
					*error = QStringLiteral("无法复制本机存档到镜像目录：")
					         + saveSource.errorString();
				}
				return false;
			}
		}
	}
	m_session = session;
	m_slot = slot;
	m_players = players;
	m_emu = mgbaMobileCreate(root.path().toUtf8().constData(),
	                         stateRoot.toUtf8().constData(), "pcmirror");
	if (!m_emu) {
		if (error) {
			*error = QStringLiteral("镜像控制台创建失败");
		}
		return false;
	}
	if (!mgbaMobileLoad(m_emu, romPath.toUtf8().constData())) {
		mgbaMobileDestroy(m_emu);
		m_emu = nullptr;
		if (error) {
			*error = QStringLiteral("镜像核心加载 ROM 失败: ") + romPath;
		}
		return false;
	}
	if (navIdx >= 0) {
		/* 与 Android GBoyConsoleSet.setBusGame() 对称：四个核各自从 ROM 加载
		 * 后的第 0 帧起跑同一份 busgame 导航，navIdx 决定 4P 座位。native 的
		 * beginFrameKeys 在脚本激活时完全覆盖 mgbaMobileSetKeys 的值；连续
		 * 120 帧命中 battle_main.o 后脚本自释放，此后 loadHeld() 立刻拿到
		 * 这里每帧写入的网络按键，不再需要外部广播或额外 JNI。 */
		mgbaMobileBusGameStart(m_emu, navIdx, navMenuAt, navModeDowns);
	}
	// The primary listens (SioLinkHost::sioHost, pumped by the core thread's
	// finishFrame); the mirror connects out to it, same as the Android set.
	bool joined = false;
	for (int attempt = 0; attempt < 50 && !joined; ++attempt) {
		joined = mgbaMobileLinkJoin(m_emu, "127.0.0.1", int(primaryPort), m_players);
		if (!joined) {
			QThread::msleep(20);
		}
	}
	if (!joined) {
		mgbaMobileDestroy(m_emu);
		m_emu = nullptr;
		if (error) {
			*error = QStringLiteral("镜像核心无法连上环回端口 %1").arg(primaryPort);
		}
		return false;
	}
	// Wait until the loopback netLink session reports LINK_CONNECTED (2)
	// before the pump starts, so the first MULTI rounds of the game are not
	// dropped. The status text starts with the state number.
	{
		char status[256];
		qint64 deadline = QDateTime::currentMSecsSinceEpoch() + LINK_WAIT_MS;
		while (QDateTime::currentMSecsSinceEpoch() < deadline) {
			mgbaMobilePumpLink(m_emu);
			mgbaMobileLinkStatus(m_emu, status, sizeof(status));
			int state = QString::fromUtf8(status).section(' ', 0, 0).toInt();
			if (state == 2) {
				break;
			}
			QThread::msleep(20);
		}
	}
	m_running.store(true, std::memory_order_relaxed);
	QThread::start();
	return true;
}

void GBoyMirror::stopMirror() {
	if (!m_running.exchange(false, std::memory_order_relaxed)) {
		return;
	}
	wait(3000);
	if (m_emu) {
		mgbaMobileLinkClose(m_emu);
		mgbaMobileDestroy(m_emu);
		m_emu = nullptr;
	}
	m_session = nullptr;
}

void GBoyMirror::run() {
	auto nextFrame = QDateTime::currentMSecsSinceEpoch();
	while (m_running.load(std::memory_order_relaxed) && m_emu) {
		GBoyLinkSession* session = m_session;
		int keys = session ? session->keysForSlot(m_slot) : 0;
		mgbaMobileSetKeys(m_emu, quint32(keys));
		mgbaMobilePumpLink(m_emu);
		mgbaMobileRunFrames(m_emu, 1);
		nextFrame += FRAME_INTERVAL_US / 1000;
		long sleep = long(nextFrame - QDateTime::currentMSecsSinceEpoch());
		if (sleep > 0) {
			QThread::msleep(unsigned(sleep));
		} else {
			// Fell behind: resync the pace instead of bursting frames.
			nextFrame = QDateTime::currentMSecsSinceEpoch();
		}
	}
}

bool GBoyMirror::applyRemoteState(const QByteArray& state) {
	if (!m_emu || state.isEmpty()) {
		return false;
	}
	return mgbaMobileLoadStateFromMemory(m_emu, state.constData(), size_t(state.size()));
}
