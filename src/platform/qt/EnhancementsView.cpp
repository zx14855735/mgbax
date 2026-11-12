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

#include <cmath>

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

// Controlled fast-forward multipliers offered while 倍速声音不变 is on. The
// core is paced at exactly this speed so its audio output rate is known and
// the surplus can be absorbed without dropping a single sample. 2x is the
// slowest useful value: 1x would mean "no speed-up at all" and make the
// turbo key do nothing (which is what "没效果" used to be).
const double HOLD_RATIOS[] = {2.0, 3.0, 4.0, 6.0, 8.0};

// How fast the music itself plays during fast-forward. 1x is the tune's own
// tempo (everything is stretched back to normal); higher values play the
// music faster, which needs less stretching and keeps more of the tune.
const double HOLD_RATES[] = {1.0, 1.5, 2.0, 3.0};

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
	m_hold->addItem(tr("变调（音乐随游戏加速并升调，原版行为）"));
	m_hold->addItem(tr("不变调·连续（WSOLA：音高不变，但旋律仍随游戏 4× 前进）"));
	m_hold->addItem(tr("真正 1× 原速（默认·音高与节奏都原速，会跳段）"));
	m_hold->setToolTip(tr("快进时音乐怎么办（游戏 4× 每秒产出 4 秒音乐，设备每秒只能播 1 秒，\n"
	                       "所以必须丢掉 3/4，三者无法兼得）：\n"
	                       "· 变调：连续、旋律 4×、音高升 4×。\n"
	                       "· 不变调·连续：WSOLA 均匀压缩，音高不变，但旋律仍推进 4×，\n"
	                       "  并不是 1× 原速（「音乐速度 1×」只代表音高不变）。\n"
	                       "· 真正 1× 原速：按原速播放真实采样，只在音符间隙整段跳过冗余，\n"
	                       "  音高和节奏都是 1×，代价是音乐会跳段。"));
	form->addRow(tr("快进音乐"), m_hold);
	m_ratio = new QComboBox;
	for (double ratio : HOLD_RATIOS) {
		m_ratio->addItem(tr("%1×").arg(ratio, 0, 'g', 2));
	}
	m_ratio->setToolTip(tr("开启「倍速音乐」后，游戏按此倍率受控快进（2×~8×）。\n"
	                       "倍率越低，WSOLA 拉伸量越小、音色越清亮（音乐仍严格原速原调）。\n"
	                       "不限速的快进无法保持音乐原速原调：核心产出的音频会溢出缓冲而被丢弃。"));
	form->addRow(tr("快进倍率"), m_ratio);
	m_rate = new QComboBox;
	for (double rate : HOLD_RATES) {
		QString label = tr("%1×").arg(rate, 0, 'g', 2);
		if (fabs(rate - 1.0) < 0.01) {
			label += tr("（默认·原调）");
		}
		m_rate->addItem(label);
	}
	m_rate->setToolTip(tr("音乐速度：1× = 音高不变；更高倍率会让音高随之升高。\n"
	                      "1×（默认）：不变调。2× 约升高一个八度、3× 更高。\n"
	                      "注意：它不改变旋律推进速率，那由「快进音乐」模式决定。"));
	form->addRow(tr("音乐速度"), m_rate);
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
	connect(m_ratio, QOverload<int>::of(&QComboBox::currentIndexChanged), this, &EnhancementsView::applyRatio);
	connect(m_rate, QOverload<int>::of(&QComboBox::currentIndexChanged), this, &EnhancementsView::applyRate);
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
	double ratio = m_controller->audioHoldRatio();
	// Migrate the legacy 1x fast-forward ratio (which disabled fast-forward
	// entirely and made the turbo key do nothing) back to a working 4x.
	if (ratio < 2.0 - 1e-6) {
		m_controller->setAudioHoldRatio(4.0);
		ratio = 4.0;
	}
	int ratioIndex = -1;
	for (int i = 0; i < int(sizeof(HOLD_RATIOS) / sizeof(HOLD_RATIOS[0])); ++i) {
		if (fabs(HOLD_RATIOS[i] - ratio) < 0.01) {
			ratioIndex = i;
			break;
		}
	}
	if (ratioIndex < 0) {
		ratioIndex = 2; // HOLD_RATIOS[2] == 4.0
	}
	m_ratio->setCurrentIndex(ratioIndex);
	double rate = m_controller->audioHoldRate();
	for (int i = 0; i < int(sizeof(HOLD_RATES) / sizeof(HOLD_RATES[0])); ++i) {
		if (fabs(HOLD_RATES[i] - rate) < 0.01) {
			m_rate->setCurrentIndex(i);
			break;
		}
	}
	// The 快进倍率 / 音乐速度 controls only do anything while 倍速音乐 is in a
	// hold mode (WSOLA or native cut). In "变调" mode they are ignored, so
	// grey them out and tell the user why changing them appears to do nothing.
	bool holdEnabled = m_controller->audioHoldMode() != 0;
	m_ratio->setEnabled(holdEnabled);
	m_rate->setEnabled(holdEnabled);
	m_status->setText(holdEnabled
		? tr("游戏按「快进倍率」加速；音乐效果由「快进音乐」模式决定（详见其提示）。")
		: tr("「快进音乐」当前为「变调」：游戏按常规倍速快进、音乐随游戏升调，下方两项不起作用。"));
	m_updating = false;
}

void EnhancementsView::applyHold(int index) {
	if (m_updating || !m_controller) {
		return;
	}
	m_controller->setAudioHoldMode(index);
	bool holdEnabled = index != 0;
	m_ratio->setEnabled(holdEnabled);
	m_rate->setEnabled(holdEnabled);
	m_status->setText(holdEnabled
		? tr("游戏按「快进倍率」加速；音乐效果由「快进音乐」模式决定（详见其提示）。")
		: tr("「快进音乐」当前为「变调」：游戏按常规倍速快进、音乐随游戏升调，下方两项不起作用。"));
}

void EnhancementsView::applyRatio(int index) {
	if (m_updating || !m_controller) {
		return;
	}
	if (index < 0 || index >= int(sizeof(HOLD_RATIOS) / sizeof(HOLD_RATIOS[0]))) {
		return;
	}
	m_controller->setAudioHoldRatio(HOLD_RATIOS[index]);
}

void EnhancementsView::applyRate(int index) {
	if (m_updating || !m_controller) {
		return;
	}
	if (index < 0 || index >= int(sizeof(HOLD_RATES) / sizeof(HOLD_RATES[0]))) {
		return;
	}
	m_controller->setAudioHoldRate(HOLD_RATES[index]);
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
