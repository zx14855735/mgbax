/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QDialog>
#include <QPointer>

class QCheckBox;
class QComboBox;
class QLabel;
class QPushButton;
class QSlider;

namespace QGBA {

class CoreController;
class Window;

/**
 * Mobile-parity enhancements dialog: per-PSG-channel volume, GB DMG palette
 * presets, the Boktai solar sensor slider and cartridge rumble - all ported
 * from the Android version. Values apply live and persist for future games.
 */
class EnhancementsView : public QDialog {
Q_OBJECT

public:
	EnhancementsView(Window* window, QWidget* parent = nullptr);

private slots:
	void applyVolumes();
	void applyPalette(int index);
	void applyHold(int index);
	void applyRatio(int index);
	void applyRate(int index);
	void applySolar(int value);
	void applyRumble(bool enabled);
	void backupNow();

private:
	void status(const QString& text);

	QPointer<Window> m_window;
	std::shared_ptr<CoreController> m_controller;
	QSlider* m_volumes[6] = {};
	QLabel* m_volumeLabels[6] = {};
	QComboBox* m_palette = nullptr;
	QComboBox* m_hold = nullptr;
	QComboBox* m_ratio = nullptr;
	QComboBox* m_rate = nullptr;
	QSlider* m_solar = nullptr;
	QLabel* m_solarLabel = nullptr;
	QCheckBox* m_rumble = nullptr;
	QPushButton* m_backup = nullptr;
	QLabel* m_status = nullptr;
	bool m_updating = false;
};

}
