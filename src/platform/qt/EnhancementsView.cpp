/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "EnhancementsView.h"

#include "ConfigController.h"
#include "CoreController.h"
#include "Window.h"

#include <QCheckBox>
#include <QComboBox>
#include <QDir>
#include <QFile>
#include <QFileDialog>
#include <QFormLayout>
#include <QGridLayout>
#include <QHBoxLayout>
#include <QLabel>
#include <QProcess>
#include <QSlider>
#include <QStringList>
#include <QVBoxLayout>

#include <mgba-util/vfs.h>

using namespace QGBA;

namespace {

// GB DMG palettes, light to dark, ported from the Android version: the same
// four colors expanded to the twelve gb.pal entries (BG, OBJ0, OBJ1).
const int32_t GB_PALETTES[][4] = {
	{0xFFFFFF, 0xA8B8A8, 0x285050, 0x000000},
	{0xFFFFFF, 0xA9A9A9, 0x545454, 0x000000},
	{0xFFFFFF, 0xAAAAAA, 0x555555, 0x000000},
	{0xF8E0C0, 0xD89058, 0xA85038, 0x381808},
	{0xF8F8D8, 0xD8B098, 0xA06848, 0x583020},
	{0xFFF8FF, 0xF8B8B8, 0xC85050, 0x680808},
	{0xFFFBE7, 0xC8D8A0, 0x789868, 0x183018},
	{0xF8FFD8, 0xB8F8B8, 0x70C078, 0x184818},
	{0xE0F8FF, 0xA0B8F8, 0x5078D8, 0x001888},
	{0xF8E8F8, 0xB8A0F0, 0x7858E8, 0x180090},
	{0xFFF0E0, 0xF8B888, 0xC07038, 0x602010},
	{0xFFF8D8, 0xF8D888, 0xC0A040, 0x604000},
	{0xFFF8F8, 0xE8C0C8, 0xC88898, 0x704858},
	{0x000000, 0x285050, 0xA8B8A8, 0xFFFFFF},
};

const char* const GB_PALETTE_NAMES[] = {
	"DMG 默认", "原版灰", "纯灰", "棕", "深棕",
	"红", "绿", "深绿", "蓝", "深蓝",
	"橙", "黄", "淡彩", "反转",
};

const char* const VOLUME_NAMES[] = {
	"通道 1（方波）", "通道 2（方波）", "通道 3（波形）", "通道 4（噪声）", "DMA A（音乐）", "DMA B（音效）",
};

}

EnhancementsView::EnhancementsView(Window* window, QWidget* parent)
	: QDialog(parent, Qt::WindowTitleHint | Qt::WindowSystemMenuHint | Qt::WindowCloseButtonHint)
	, m_window(window)
{
	setWindowTitle(tr("模拟器增强（安卓版同款）"));
	resize(420, 480);

	QVBoxLayout* layout = new QVBoxLayout;

	QGridLayout* volGrid = new QGridLayout;
	for (int i = 0; i < 6; ++i) {
		m_volumeLabels[i] = new QLabel(VOLUME_NAMES[i]);
		m_volumes[i] = new QSlider(Qt::Horizontal);
		m_volumes[i]->setRange(0, 256);
		m_volumes[i]->setValue(256);
		volGrid->addWidget(m_volumeLabels[i], i, 0);
		volGrid->addWidget(m_volumes[i], i, 1);
		connect(m_volumes[i], &QSlider::valueChanged, this, &EnhancementsView::applyVolumes);
	}
	layout->addLayout(volGrid);

	QFormLayout* form = new QFormLayout;
	m_hold = new QComboBox;
	m_hold->addItem(tr("变调（原版行为）"));
	m_hold->addItem(tr("恒定音调（WSOLA 拉伸）"));
	m_hold->addItem(tr("音乐原速（整段切割）"));
	form->addRow(tr("快进音乐"), m_hold);
	m_palette = new QComboBox;
	m_palette->addItem(tr("核心默认（不覆盖）"));
	for (int i = 0; i < 14; ++i) {
		m_palette->addItem(QString::fromUtf8(GB_PALETTE_NAMES[i]));
	}
	form->addRow(tr("GB 调色板"), m_palette);
	m_solar = new QSlider(Qt::Horizontal);
	m_solar->setRange(-1, 10);
	m_solar->setValue(-1);
	m_solarLabel = new QLabel(tr("关闭"));
	m_solarLabel->setMinimumWidth(90);
	QHBoxLayout* solarRow = new QHBoxLayout;
	solarRow->addWidget(m_solar);
	solarRow->addWidget(m_solarLabel);
	form->addRow(tr("光感太阳能"), solarRow);
	m_rumble = new QCheckBox(tr("卡带震动（转入手柄震动）"));
	form->addRow(QString(), m_rumble);
	layout->addLayout(form);

	QHBoxLayout* backupRow = new QHBoxLayout;
	m_backup = new QPushButton(tr("一键备份（设置+存档 → zip）"));
	backupRow->addWidget(m_backup);
	layout->addLayout(backupRow);

	m_status = new QLabel;
	m_status->setWordWrap(true);
	layout->addWidget(m_status);

	setLayout(layout);

	connect(m_palette, QOverload<int>::of(&QComboBox::currentIndexChanged), this, &EnhancementsView::applyPalette);
	connect(m_hold, QOverload<int>::of(&QComboBox::currentIndexChanged), this, &EnhancementsView::applyHold);
	connect(m_solar, &QSlider::valueChanged, this, &EnhancementsView::applySolar);
	connect(m_rumble, &QCheckBox::toggled, this, &EnhancementsView::applyRumble);
	connect(m_backup, &QAbstractButton::clicked, this, &EnhancementsView::backupNow);

	if (!m_window || !m_window->controller()) {
		m_status->setText(tr("请先打开一个游戏，设置才会立即生效（会保存，下次打开游戏自动恢复）。"));
		return;
	}
	m_controller = m_window->controller();

	int gains[6];
	m_controller->channelVolumes(gains);
	m_updating = true;
	for (int i = 0; i < 6; ++i) {
		m_volumes[i]->setValue(gains[i]);
	}
	if (m_controller->gbPaletteSet()) {
		int32_t pal[12];
		m_controller->gbPalette(pal);
		for (int p = 0; p < 14; ++p) {
			if (pal[0] == GB_PALETTES[p][0] && pal[1] == GB_PALETTES[p][1]
			    && pal[2] == GB_PALETTES[p][2] && pal[3] == GB_PALETTES[p][3]) {
				m_palette->setCurrentIndex(p + 1);
				break;
			}
		}
	}
	m_solar->setValue(m_controller->solarLevel());
	m_rumble->setChecked(m_controller->cartRumble());
	m_hold->setCurrentIndex(m_controller->audioHoldMode());
	m_updating = false;
}

void EnhancementsView::applyHold(int index) {
	if (m_updating || !m_controller) {
		return;
	}
	m_controller->setAudioHoldMode(index);
}

void EnhancementsView::applyVolumes() {
	if (m_updating || !m_controller) {
		return;
	}
	int gains[6];
	for (int i = 0; i < 6; ++i) {
		gains[i] = m_volumes[i]->value();
	}
	m_controller->setChannelVolumes(gains);
}

void EnhancementsView::applyPalette(int index) {
	if (m_updating || !m_controller) {
		return;
	}
	if (index <= 0) {
		m_controller->clearGbPalette();
		return;
	}
	int32_t pal[12];
	for (int i = 0; i < 12; ++i) {
		pal[i] = GB_PALETTES[index - 1][i % 4];
	}
	m_controller->setGbPalette(pal);
}

void EnhancementsView::applySolar(int value) {
	if (m_updating || !m_controller) {
		return;
	}
	m_solarLabel->setText(value < 0 ? tr("关闭") : tr("亮度 %1").arg(value));
	m_controller->setSolarLevel(value);
}

void EnhancementsView::applyRumble(bool enabled) {
	if (m_updating || !m_controller) {
		return;
	}
	m_controller->setCartRumble(enabled);
}

void EnhancementsView::backupNow() {
	QString dest = QFileDialog::getSaveFileName(this, tr("备份到"), QDir::homePath() + "/mgba-backup.zip",
	                                            tr("Zip 压缩包 (*.zip)"));
	if (dest.isEmpty()) {
		return;
	}
	QStringList sources;
	QString configDir = ConfigController::configDir();
	for (const QString& ini : { QStringLiteral("config.ini"), QStringLiteral("qt.ini") }) {
		QString iniPath = configDir + "/" + ini;
		if (QFile::exists(iniPath)) {
			sources << iniPath;
		}
	}
	if (m_window && m_window->controller()) {
		QString savePath = m_window->controller()->savePath();
		if (!savePath.isEmpty()) {
			sources << savePath; // the battery save itself
		}
	}
	if (sources.isEmpty()) {
		status(tr("没有可备份的内容（未找到配置或存档）"));
		return;
	}
	status(tr("正在备份…"));
#ifdef Q_OS_WIN
	QStringList args;
	args << "-NoProfile" << "-Command"
	     << QString("Compress-Archive -Path '%1' -DestinationPath '%2' -Force")
	        .arg(sources.join("','"), dest);
	QProcess::startDetached("powershell", args);
	status(tr("备份完成：%1").arg(dest));
#else
	// The Android version zips with java.util.zip; on this port only Windows
	// gets the one-click path, elsewhere point at the files.
	status(tr("非 Windows 平台请手动打包：%1").arg(sources.join(", ")));
#endif
}

void EnhancementsView::status(const QString& text) {
	m_status->setText(text);
}
