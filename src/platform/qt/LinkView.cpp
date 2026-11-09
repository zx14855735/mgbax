/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "LinkView.h"
#include "moc_LinkView.cpp"

#include "CoreController.h"
#include "GBoyLink.h"
#include "Window.h"

#include <QTimer>

using namespace QGBA;

LinkView::LinkView(Window* window, QWidget* parent)
	: QDialog(parent, Qt::WindowTitleHint | Qt::WindowSystemMenuHint | Qt::WindowCloseButtonHint)
	, m_window(window)
{
	m_ui.setupUi(this);

	connect(window, &QObject::destroyed, this, &QWidget::close);
	connect(m_ui.start, &QAbstractButton::clicked, this, &LinkView::startLink);
	connect(m_ui.disconnect, &QAbstractButton::clicked, this, &LinkView::stopLink);
	connect(m_ui.sendReset, &QAbstractButton::clicked, this, &LinkView::sendReset);
}

void LinkView::startLink() {
	if (m_link || m_lanActive) {
		stopLink();
	}
	if (!m_window || !m_window->controller()) {
		m_ui.status->append(tr("请先打开游戏。"));
		return;
	}
	if (m_window->controller()->platform() != mPLATFORM_GBA) {
		m_ui.status->append(tr("WiFi 联机只支持 GBA 游戏。"));
		return;
	}
	m_controller = m_window->controller();
	connect(m_controller.get(), &CoreController::stopping, this, &LinkView::stopLink);
	connect(m_controller.get(), &QObject::destroyed, this, &LinkView::stopLink);

	if (m_ui.lanMode->isChecked()) {
		// LAN precise SIO cable: the driver lives in CoreController and pumps
		// itself per frame; the SIO attach happens once the peer connects.
		quint16 port = quint16(m_ui.port->value());
		// 人数必须两边一致：2 人是原来的直连，3/4 人走星型总线。两边填不一
		// 样时 TCP 能连上、但一个是 20 字节 struct Packet、另一个是 28 字节
		// BusPacket，谁都解不出对方的包（表现为连上就断）。
		int players = m_ui.players->value();
		bool ok;
		if (m_ui.radioHost->isChecked()) {
			ok = m_controller->lanLinkHostPlayers(port, players);
			if (players > 2) {
				m_ui.status->append(tr("LAN 总线监听端口 %1，%2 人房，等待 %3 位玩家…（你是 1P）")
				                    .arg(port).arg(players).arg(players - 1));
			} else {
				m_ui.status->append(tr("LAN 联机线监听端口 %1，等待对方…（你是 1P）").arg(port));
			}
		} else {
			QString ip = m_ui.ipAddr->text().trimmed();
			ok = m_controller->lanLinkJoinPlayers(ip, port, players);
			if (players > 2) {
				m_ui.status->append(tr("LAN 总线连接 %1:%2，%3 人房…（你是 P2 或之后接入的槽位）")
				                    .arg(ip).arg(port).arg(players));
			} else {
				m_ui.status->append(tr("LAN 联机线连接 %1:%2…（你是 2P）").arg(ip).arg(port));
			}
		}
		if (!ok) {
			m_ui.status->append(tr("LAN 联机线启动失败"));
			m_controller.reset();
			updateRunning();
			return;
		}
		m_lanActive = true;
		// Status refresh until the SIO driver reports attached play.
		m_lanTimer = new QTimer(this);
		connect(m_lanTimer, &QTimer::timeout, this, &LinkView::updateRunning);
		m_lanTimer->start(500);
		updateRunning();
		return;
	}

	// WiFi 合并按键模式是一条单管道，只合并两台的按键，没有第三、第四槽位。
	// 选了 3/4 人却勾错模式时，宁可把话说清也不要在频道里对着空气等。
	int players = m_ui.players->value();
	if (players > 2) {
		m_ui.status->append(tr("WiFi 合并按键模式只支持 2 人；3/4 人请勾选上面的「局域网精确 SIO 联机线」。"));
		m_controller.reset();
		updateRunning();
		return;
	}
	GBoyLink::Config config;
	config.mode = m_ui.radioHost->isChecked() ? GBoyLink::HOST : GBoyLink::JOIN;
	config.ip = m_ui.ipAddr->text().trimmed();
	config.port = quint16(m_ui.port->value());
	config.romPath = m_window->controller()->path();

	m_controller = m_window->controller();
	m_link = new GBoyLink(this);
	connect(m_link, &GBoyLink::statusMessage, this, &LinkView::status);
	connect(m_link, &GBoyLink::linkEnded, this, &LinkView::ended);
	connect(m_link, &GBoyLink::remoteKeys, m_controller.get(), &CoreController::setRemoteKeys);
	connect(m_link, &GBoyLink::remoteReset, m_controller.get(), &CoreController::reset);
	m_link->startLink(config);

	// The key pump runs at its own cadence; feed it the current local mask.
	// The timer is a child of the link object and dies with it.
	QTimer* pump = new QTimer(m_link);
	connect(pump, &QTimer::timeout, m_link, [this]() {
		if (m_link && m_controller) {
			m_link->setLocalKeys(m_controller->localKeys());
		}
	});
	pump->start(40);

	updateRunning();
}

void LinkView::stopLink() {
	if (m_lanActive) {
		m_lanActive = false;
		if (m_lanTimer) {
			m_lanTimer->stop();
			m_lanTimer->deleteLater();
			m_lanTimer = nullptr;
		}
		if (m_controller) {
			m_controller->lanLinkClose();
			m_controller.reset();
		}
		m_ui.status->append(tr("已断开"));
		updateRunning();
		return;
	}
	if (!m_link) {
		return;
	}
	m_link->stopLink();
	m_link->deleteLater();
	m_link = nullptr;
	if (m_controller) {
		m_controller->setRemoteKeys(0);
		m_controller.reset();
	}
	m_ui.status->append(tr("已断开"));
	updateRunning();
}

void LinkView::sendReset() {
	if (m_link) {
		m_link->sendReset();
	}
}

void LinkView::status(const QString& message) {
	m_ui.status->append(message);
}

void LinkView::ended(const QString& message) {
	if (!message.isEmpty()) {
		m_ui.status->append(message);
	}
	stopLink();
}

void LinkView::updateRunning() {
	bool running = m_link != nullptr || m_lanActive;
	m_ui.start->setDisabled(running);
	m_ui.disconnect->setEnabled(running);
	m_ui.sendReset->setEnabled(running);
	m_ui.radioHost->setDisabled(running);
	m_ui.radioJoin->setDisabled(running);
	m_ui.ipAddr->setDisabled(running);
	m_ui.port->setDisabled(running);
	m_ui.lanMode->setDisabled(running);
	m_ui.players->setDisabled(running);
	if (m_lanActive && m_controller) {
		int state = m_controller->lanLinkState();
		int player = m_controller->lanLinkPlayer();
		QString text;
		switch (state) {
		case 1:
			text = tr("监听中，等待对方接入…");
			break;
		case 2: {
			int players = m_controller->lanLinkPlayers();
			text = players > 2
				? tr("已连接，你是 P%1（%2 人总线，已接入 %3 人）")
				      .arg(player + 1).arg(players).arg(players)
				: tr("已连接，你是 P%1（SIO 驱动已就位，进游戏房间即可）").arg(player + 1);
		} break;
		case 3:
			text = tr("对方已断开");
			break;
		default:
			text = tr("离线");
			break;
		}
		m_ui.status->setPlaceholderText(text);
	}
}
