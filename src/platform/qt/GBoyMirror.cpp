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

#include <utility>

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
                       const QByteArray& saveSnapshot, const QString& scriptDir,
                       QString* error) {
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
	m_scriptDir = scriptDir;
	m_fallbackNavMenuAt = navMenuAt > 0 ? navMenuAt : 1500;
	m_fallbackNavModeDowns = navModeDowns >= 0 ? navModeDowns : 2;
	if (navIdx >= 0) {
		/* 与 Android GBoyConsoleSet.setBusGame() 对称：四个核从同一瞬间起跑
		 * 同一份 busgame 导航，navIdx 决定 4P 座位。但这里不再立即武装脚本——
		 * 立即武装会让镜像核各自比可见核早跑几百~上千帧（start() 里还隔着 3 次
		 * ROM 加载与 LINK_CONNECTED 等待），四核一进菜单子状态就分裂。改成
		 * 记下 pending，run() 里轮询 <scriptDir>/nav_at，CloudLink 在三个镜像核
		 * 都就绪后才写它，可见核也读同一文件武装：四核同一帧起跑，相位一致。
		 * 可见核（ScriptedControl）读完 nav_at 不删文件，镜像核随后也能读到。 */
		m_pendingNavIdx = navIdx;
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
		/* 云端 4P 闭环导航的同步闸门：脚本未武装前，本核只用网络按键（本地
		 * 4 人房间中镜像核的 slot 无远端输入，等效空操作），停在标题画面等待。
		 * nav_at 一旦被 CloudLink 写好，四核（可见核 + 3 镜像）在同一次轮询窗口
		 * 内全部武装，从帧 0 同相位起跑 busgame 导航。 */
		if (m_pendingNavIdx >= 0 && !m_scriptDir.isEmpty()) {
			QFile navAt(m_scriptDir + QStringLiteral("/nav_at"));
			if (navAt.exists() && navAt.open(QIODevice::ReadOnly)) {
				const QList<QByteArray> parts = navAt.readAll().trimmed().split(' ');
				navAt.close();
				int menuAt = m_fallbackNavMenuAt;
				int modeDowns = m_fallbackNavModeDowns;
				bool ok = false;
				const int v = parts.value(0).toInt(&ok);
				if (ok) {
					menuAt = v;
				}
				if (parts.size() > 1) {
					ok = false;
					const int d = parts.value(1).toInt(&ok);
					if (ok) {
						modeDowns = d;
					}
				}
				mgbaMobileBusGameStart(m_emu, m_pendingNavIdx, menuAt, modeDowns);
				qInfo().noquote() << QStringLiteral("[GBoyMirror] nav armed idx=%1 menuAt=%2 modeDowns=%3")
				                            .arg(m_pendingNavIdx).arg(menuAt).arg(modeDowns);
				m_pendingNavIdx = -1;
			}
		}
		GBoyLinkSession* session = m_session;
		/* 对端存档：只在帧边界载入，避免与正在执行的指令流抢。
		 * 官方 case 6 是「载入 → reset(false)」，但官方的 reset 是 libgboy 的
		 * native 软复位；我们的 mgbaMobileReset 走 GBAReset → GBAMemoryReset，
		 * 会 memset 清掉 EWRAM 256K + IWRAM 32K —— load 已经完整恢复了状态，
		 * 再 reset 等于把刚载入的存档抹掉（现象：握手成功却停在开机画面）。
		 * 因此 type 6 **只载入不复位**，复位只由 type 5 / requestReset() 触发。
		 * 载入结果按官方错误码（0 / -5 / 1）回调给 CloudLink，失败要断链。 */
		QByteArray incoming;
		std::function<void(int)> stateResult;
		if (takePendingState(&incoming, &stateResult)) {
			int result = mgbaMobileLoadStateFromMemoryEx(m_emu, incoming.constData(),
			                                             size_t(incoming.size()));
			if (result == 0) {
				m_appliedStates.fetch_add(1, std::memory_order_relaxed);
				qInfo().noquote() << QStringLiteral("[GBoyMirror] applied peer state %1 bytes slot %2")
				                            .arg(incoming.size()).arg(m_slot);
			} else {
				qInfo().noquote() << QStringLiteral("[GBoyMirror] peer state rejected (%1 bytes, code %2)")
				                            .arg(incoming.size()).arg(result);
			}
			if (stateResult) {
				stateResult(result);
			}
		}
		if (m_resetRequested.exchange(false, std::memory_order_relaxed)) {
			/* 官方 type 5：reset(false)。落在 frame boundary，不打断指令流。 */
			mgbaMobileReset(m_emu);
			qInfo().noquote() << QStringLiteral("[GBoyMirror] peer reset, slot %1").arg(m_slot);
		}
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

int GBoyMirror::applyRemoteState(const QByteArray& state, std::function<void(int)> result) {
	if (!m_emu || state.isEmpty()) {
		return 1;
	}
	/* 官方 type 6 的 -5 = 状态尺寸不符。这里在入队前先按本核的 stateSize
	 * 做一次同步判定，坏包不占队列，CloudLink 可以立刻按官方语义断链。 */
	const size_t expected = mgbaMobileStateSize(m_emu);
	if (expected && size_t(state.size()) < expected) {
		return -5;
	}
	// 只入队：真正的 load 在镜像线程的帧边界执行（见 run()）。
	std::lock_guard<std::mutex> locker(m_stateMutex);
	m_pendingState = state;
	m_pendingResult = std::move(result);
	m_hasPendingState = true;
	return 0;
}

void GBoyMirror::requestReset() {
	m_resetRequested.store(true, std::memory_order_relaxed);
}

bool GBoyMirror::takePendingState(QByteArray* out, std::function<void(int)>* result) {
	std::lock_guard<std::mutex> locker(m_stateMutex);
	if (!m_hasPendingState) {
		return false;
	}
	*out = m_pendingState;
	*result = std::move(m_pendingResult);
	m_pendingResult = nullptr;
	m_pendingState.clear();
	m_hasPendingState = false;
	return true;
}
