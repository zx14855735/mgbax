/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QString>

namespace QGBA {

/**
 * The SIO link driver surface the cloud bridge needs (分开控制模式). CoreController
 * implements it over sio_link.c; tests can back it with a bare sio_link so the
 * cloud SIO path stays end-to-end testable without a running core.
 */
struct SioLinkHost {
	virtual ~SioLinkHost() = default;

	/** Native listens on the local port (1P). */
	virtual bool sioHost(quint16 port) = 0;

	/** 3/4 人星型总线：主机 accept players-1 个从机并汇聚每一轮的字。
	 *  默认退回两人直连，测试用的假实现不需要跟着改。 */
	virtual bool sioHostPlayers(quint16 port, int players) {
		(void) players;
		return sioHost(port);
	}

	/** 3/4 人总线，同进程版本：key 只在本进程内标识一条总线（测试里直接用
	 *  端口号）。默认退回 TCP 版，假宿主不需要跟着改。 */
	virtual bool sioHostPlayersLocal(int key, int players) {
		return sioHostPlayers(quint16(key), players);
	}

	/** path B 锁步房间：默认退回进程内 LocalBus（测试假宿主不用改）。 */
	virtual bool sioLockstepHost(int key, int players, int slot) {
		(void) slot;
		return sioHostPlayersLocal(key, players);
	}

	/** Native connects out to a local listener (2P). */
	virtual bool sioJoin(const QString& host, quint16 port) = 0;

	virtual void sioClose() = 0;

	/**
	 * PC cloud-arm（对齐 Android EmulatorActivity 的 linkArmHold）：
	 * 锁住可见核的帧循环，让 4 个核都在第 0 帧入房。锁住期间 SIO 总线照常
	 * 由驱动自己的线程 accept/收包，只是可见核不再提交自己那一份字。
	 * 默认空实现：测试用的假宿主不需要实现。
	 */
	virtual void cloudArmHold(bool held) { (void) held; }

	/**
	 * PC cloud-arm（对齐 Android 的 restoreInitialSaveSnapshot + loadRom）：
	 * 按 {@code savePath} 的电池存档字节重新载入并复位到第 0 帧，让可见核
	 * 与镜像核从同一份字节冷启动。返回 false = 没有该能力（保持现场）。
	 */
	virtual bool cloudArmReload(const QString& savePath) {
		(void) savePath;
		return false;
	}
};

}
