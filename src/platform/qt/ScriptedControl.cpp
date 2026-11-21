/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "ScriptedControl.h"

#include "CoreController.h"

#include <mgba/core/core.h>
#include <mgba/core/thread.h>

#include <QByteArray>
#include <QDebug>
#include <QDir>
#include <QFile>
#include <QFileInfo>
#include <QList>

#include <atomic>

using namespace QGBA;

namespace {
std::atomic<int> g_scriptedMask{0};
/* 生效中的脚本目录（start() 成功后才非空）。CoreController 的
 * noteKeysApplied() 是静态调用，拿不到对象成员，只能共享这一份。 */
QString g_scriptDir;
}

int ScriptedControl::globalMask() {
	return g_scriptedMask.load(std::memory_order_relaxed);
}

void ScriptedControl::noteKeysApplied(int activeKeys) {
	if (g_scriptDir.isEmpty()) {
		return;
	}
	const int gm = globalMask();
	if (!gm) {
		return;
	}
	/* 每帧都会调到这里，节流到 ~0.5s 一次（60fps）：探针只在排障时看，
	 * 不能留下 fopen 热点。 */
	static int n = 0;
	if ((++n % 30) != 1) {
		return;
	}
	QFile f(g_scriptDir + QStringLiteral("/_keys_applied.txt"));
	if (f.open(QIODevice::WriteOnly | QIODevice::Text)) {
		f.write(QStringLiteral("gm=%1 active=%2").arg(gm).arg(activeKeys).toUtf8());
		f.close();
	}
}

ScriptedControl::ScriptedControl(CoreController* controller, QObject* parent)
	: QObject(parent)
	, m_controller(controller)
	, m_dir(QString::fromLocal8Bit(qgetenv("MGBAX_SCRIPT_DIR")))
{
	m_timer.setInterval(POLL_MS);
	connect(&m_timer, &QTimer::timeout, this, &ScriptedControl::poll);
}

bool ScriptedControl::start() {
	if (m_dir.isEmpty() || !QDir(m_dir).exists()) {
		/* 排障必需：以前这里静默失败，表现是「设了 MGBAX_SCRIPT_DIR 但
		 * 按键完全不动」，从外部看不出是变量没传进来还是目录不存在
		 * （MSYS 会把 D:/x 改写成 /d/x，QDir 解析不了）。 */
		/* GUI 子系统的 stderr 拿不到，改为落文件：DIR_MISSING。
		 * 目录本身不存在时只能在系统临时目录留痕。 */
		QFile bad(QDir::tempPath() + QStringLiteral("/mgba_script_dir_missing.txt"));
		if (bad.open(QIODevice::WriteOnly | QIODevice::Text)) {
			bad.write(m_dir.toUtf8());
			bad.close();
		}
		return false;
	}
	m_timer.start();
	g_scriptDir = m_dir;
	QFile ok(m_dir + QStringLiteral("/_started.txt"));
	if (ok.open(QIODevice::WriteOnly | QIODevice::Text)) {
		ok.write(QStringLiteral("started %1").arg(POLL_MS).toUtf8());
		ok.close();
	}
	return true;
}

void ScriptedControl::poll() {
	if (!m_controller) {
		/* 只写一次：poll 是 16ms 一次，无节流等于每秒 60 次 fopen。 */
		static bool wrote = false;
		if (!wrote) {
			QFile f(m_dir + QStringLiteral("/_no_controller.txt"));
			if (f.open(QIODevice::WriteOnly | QIODevice::Text)) {
				f.write("1");
				wrote = true;
			}
		}
		return;
	}

	int mask = 0;
	/* 云端 4P 对局：CloudLink 在三个镜像核都就绪后才写 <dir>/nav_at，可见核
	 * 检测到它就跑与那三个核同一份内存驱动导航（idx=0 = 主机/玩家 1）。
	 * 文件内容是 "menuAt modeDowns"，与 flow.sh 发给 Android 的广播参数一致。
	 * 之前 PC 只靠定时盲按，帧率一变就落在标题画面，两端永远不同步。 */
	const QString navAtPath = m_dir + QStringLiteral("/nav_at");
	if (!m_navArmed && !m_navDone && QFileInfo::exists(navAtPath)) {
		int menuAt = 1500;
		int modeDowns = 2;
		QFile navAt(navAtPath);
		if (navAt.open(QIODevice::ReadOnly)) {
			const QList<QByteArray> parts = navAt.readAll().trimmed().split(' ');
			navAt.close();
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
		}
		mgbaMobileBusGameNavInit(&m_nav, 0, menuAt, modeDowns);
		m_navArmed = true;
		m_navBaseSet = false;
		m_navBaseFrame = 0;
		m_lastNavFrame = 0;
		qInfo().noquote()
		    << QStringLiteral("[BUSGAME-PC] nav armed menuAt=%1 modeDowns=%2")
		           .arg(menuAt).arg(modeDowns);
	}

	if (m_navArmed && !m_navDone) {
		mCoreThread* thread = m_controller->thread();
		mCore* core = thread ? thread->core : nullptr;
		if (core && core->board && m_controller->platform() == mPLATFORM_GBA) {
			auto* gba = static_cast<struct GBA*>(core->board);
			const uint64_t fc = m_controller->frameCounter();
			if (!m_navBaseSet) {
				m_navBaseFrame = fc;
				m_navBaseSet = true;
			}
			if (fc != m_lastNavFrame) {
				/* 让导航帧号等于「核心从武装那一刻起跑过的帧数」，而不是
				 * poll 调用次数：QTimer 16ms 与 59.7fps 不严格对齐，逐 poll
				 * 自增会让可见核与三个帧精确镜像核的相位漂移，四人 SIO
				 * 握手时会按出不同选项。fc 未变时保持上一帧按键不动。 */
				m_nav.frame = uint32_t(fc - m_navBaseFrame);
				mask = int(mgbaMobileBusGameNavKeys(&m_nav, gba));
				m_lastNavFrame = fc;
				const bool inBattle = mgbaMobileBusGameInBattle(gba);
				if ((m_nav.frame % 600) == 1
				    || (inBattle && (m_nav.frame % 60) == 0)) {
					const QString line = QStringLiteral(
					        "[BUSGAME-PC] f=%1 pc=%2 var8004=%3 cb2=%4%5")
					           .arg(m_nav.frame - 1)
					           .arg(int(mgbaMobileBusGamePeek8(gba, 0x03004A39u)))
					           .arg(int(mgbaMobileBusGamePeek32(gba, 0x0202199Cu) & 0xFFFFu))
					           .arg(mgbaMobileBusGamePeek32(gba, 0x02029118u), 8, 16, QChar('0'))
					           .arg(inBattle ? QStringLiteral(" BATTLE=YES") : QString());
					qInfo().noquote() << line;
					/* 单独落一份轻量判据：PC 的 stdout/stderr 必须重定向到
					 * NUL（否则每秒数百行 GBA Serial I/O 调试日志把帧率拖到
					 * 16fps），qInfo 也就看不到了。这份文件供 flow.sh 判定
					 * PC 可见核是否进入对战区，每 600 帧或战斗区每帧一条。 */
					QFile navLog(m_dir + QStringLiteral("/pc_nav.log"));
					if (navLog.open(QIODevice::Append | QIODevice::Text)) {
						navLog.write(line.toUtf8() + "\n");
						navLog.close();
					}
				}
				if (m_nav.released) {
					m_navArmed = false;
					m_navDone = true;
					const QString done = QStringLiteral(
					        "[BUSGAME-PC] battle reached, keys released to network BATTLE=YES");
					qInfo().noquote() << done;
					QFile navLog(m_dir + QStringLiteral("/pc_nav.log"));
					if (navLog.open(QIODevice::Append | QIODevice::Text)) {
						navLog.write(done.toUtf8() + "\n");
						navLog.close();
					}
				}
			} else {
				mask = m_mask;
			}
		}
	} else {
		QFile keys(m_dir + QStringLiteral("/keys"));
		if (keys.open(QIODevice::ReadOnly)) {
			bool ok = false;
			const int v = keys.readAll().trimmed().toInt(&ok);
			keys.close();
			if (ok) {
				mask = v;
			}
		}
	}

	if (!m_maskApplied || mask != m_mask) {
		// 只动有变化的位：addKey/clearKey 各自维护 m_activeKeys 与
		// m_removedKeys，全量重设会把对面 SIO 正在读的按键抖掉。
		for (int bit = 0; bit < 10; ++bit) {
			const int value = 1 << bit;
			const bool was = m_maskApplied && (m_mask & value);
			const bool now = (mask & value);
			if (was == now) {
				continue;
			}
			if (now) {
				m_controller->addKey(bit);
			} else {
				m_controller->clearKey(bit);
			}
		}
		m_mask = mask;
		m_maskApplied = true;
	}
	/* 每次都写：CloudLink::serveOfficial() 把这份进程级掩码并进线上按键帧，
	 * 导航阶段也要把 PC 的按键送到对端镜像核，释放后自动回到真人输入。 */
	g_scriptedMask.store(mask, std::memory_order_relaxed);
	{
		static int n = 0;
		if ((++n % 16) == 0) {
			QFile f(m_dir + QStringLiteral("/_mask.txt"));
			if (f.open(QIODevice::WriteOnly | QIODevice::Text)) {
				f.write(QStringLiteral("%1").arg(mask).toUtf8());
			}
		}
	}
}
