/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QDialog>

class QComboBox;
class QLineEdit;
class QSpinBox;

namespace QGBA {

class ConfigController;

/**
 * 联机直连传输的可见配置入口（对齐 Android GBoyBluetoothLink 的联机页）。
 *
 * PC 端 CloudLink 早就支持蓝牙 RFCOMM 与 TCP 直连，但只认环境变量
 * （MGBAX_BT / MGBAX_TCP_PEER / MGBAX_TCP_LISTEN），普通用户无从设置。
 * 这个对话框把选择写进 qt.ini，并在启动与保存时同步成对应环境变量，
 * 联机大厅开打时 CloudLink::tryBtLink() / tryEnvTcpLink() 直接命中。
 *
 * 只改“用哪条传输通道”，不参与任何握手/线格式。
 */
class DirectTransportDialog : public QDialog {
Q_OBJECT

public:
	explicit DirectTransportDialog(ConfigController* config, QWidget* parent = nullptr);

	/**
	 * 把 qt.ini 里的 netTransport* 设置同步为 MGBAX_* 环境变量。
	 * 只有本对话框写过的值才会被清除，用户自己 export 的不动。
	 * 返回一句人类可读的状态描述（未启用时为空）。
	 */
	static QString applyToEnvironment(ConfigController* config);

private slots:
	void updateFieldStates();

private:
	void save();

	ConfigController* m_config;
	QComboBox* m_mode;
	QLineEdit* m_btPeer;
	QLineEdit* m_tcpPeer;
	QSpinBox* m_tcpPort;
};

}
