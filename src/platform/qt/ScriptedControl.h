/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QObject>
#include <QString>
#include <QTimer>

namespace QGBA {

class CoreController;

/**
 * 脚本化控制：让外部程序（自动化测试 / 无人值守联机对局）能给模拟器喂按键
 * 和截图，不需要窗口获得焦点，也不需要合成鼠标键盘事件。
 *
 * 只在设置了环境变量 `MGBAX_SCRIPT_DIR` 时启用，正常启动完全不参与：
 *
 *   MGBAX_SCRIPT_DIR=D:\tmp\drive
 *
 * 之后轮询该目录里的两个文件（每 16 ms 一次，读不到就跳过）：
 *
 *   keys  —— 一个十进制按键掩码，位序与 GBA 按键编号一致
 *            1=A 2=B 4=Select 8=Start 16=Right 32=Left 64=Up 128=Down
 *            256=R 512=L
 *            内容变化时才动，所以外部只要在需要的时候写一次即可。
 *   shot  —— 一个递增序号；变了就截一张图（落在模拟器配置的截图目录里，
 *            默认是存档目录，文件名 <rom>-NNNN.png）。
 *
 * 为什么用文件而不是 socket/TCP：Windows GUI 子系统没有可用的 stdin，
 * 而文件轮询没有任何依赖，崩溃了也不会让模拟器跟着卡住。
 */
class ScriptedControl : public QObject {
	Q_OBJECT

public:
	static constexpr int POLL_MS = 16;

	explicit ScriptedControl(CoreController* controller, QObject* parent = nullptr);

	/** 目录不存在时返回 false（当作没启用）。 */
	bool start();

private slots:
	void poll();

private:
	CoreController* m_controller;
	QTimer m_timer;
	QString m_dir;
	int m_mask = 0;
	int m_shotSeq = 0;
	bool m_maskApplied = false;
};

}
