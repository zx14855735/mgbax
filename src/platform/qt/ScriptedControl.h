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
 * 脚本化控制：让外部程序（自动化测试 / 无人值守联机对局）能给模拟器喂按键，
 * 不需要窗口获得焦点，也不需要合成鼠标键盘事件。
 *
 * 只在设置了环境变量 `MGBAX_SCRIPT_DIR` 时启用，正常启动完全不参与：
 *
 *   MGBAX_SCRIPT_DIR=D:\tmp\drive
 *
 * 之后每 16 ms 读一次该目录下的 `keys` 文件，内容是一个十进制按键掩码，
 * 位序与 GBA 按键编号一致：
 *
 *   1=A 2=B 4=Select 8=Start 16=Right 32=Left 64=Up 128=Down 256=R 512=L
 *
 * 内容变化时才动，外部只要在需要的时候写一次即可；写回 0 就是松手。
 *
 * 为什么用文件而不是 socket/TCP：Windows GUI 子系统没有可用的 stdin，
 * 而文件轮询没有任何依赖，外面崩了也不会把模拟器拖下水。
 *
 * <p>截图**不在**这里做：`CoreController::screenshot()` 走
 * `mCoreThreadRunFunction`，而联机线等待时核心线程会阻塞几秒，从别的线程
 * 调它存在竞态。测试时截画面请用安卓端的 screencap。</p>
 */
class ScriptedControl : public QObject {
	Q_OBJECT

public:
	static constexpr int POLL_MS = 16;

	explicit ScriptedControl(CoreController* controller, QObject* parent = nullptr);

	/** 目录不存在时返回 false（当作没启用）。 */
	bool start();

	/** 当前脚本按住的按键掩码（没启用/没按就是 0）。
	 *  云端联机读的是 CoreController::localKeys()（只在 updateKeys() 里由
	 *  输入控制器写），脚本走的是 addKey/clearKey，两套不互通——联机时要
	 *  把这份掩码并进去，否则对端永远只收到「按键=0」。 */
	int mask() const { return m_maskApplied ? m_mask : 0; }

	/** 进程级共享的脚本按键掩码。
	 *
	 *  官方镜像联机会另起镜像核/窗口，喂给 CloudLink 的那个实例未必是
	 *  持有本对象的那个（实测 keyFeed 收到 8、线上帧里还是 0）。发送端
	 *  统一 OR 上这个静态值，跟对象的归属无关。 */
	static int globalMask();

private slots:
	void poll();

private:
	CoreController* m_controller;
	QTimer m_timer;
	QString m_dir;
	int m_mask = 0;
	bool m_maskApplied = false;
};

}
