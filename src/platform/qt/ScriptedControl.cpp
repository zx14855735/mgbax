/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "ScriptedControl.h"

#include "CoreController.h"

#include <QDir>
#include <QFile>

using namespace QGBA;

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
		return false;
	}
	m_timer.start();
	return true;
}

void ScriptedControl::poll() {
	if (!m_controller) {
		return;
	}

	QFile keys(m_dir + QStringLiteral("/keys"));
	if (keys.open(QIODevice::ReadOnly)) {
		bool ok = false;
		const int mask = keys.readAll().trimmed().toInt(&ok);
		keys.close();
		if (ok && (!m_maskApplied || mask != m_mask)) {
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
	}
}
