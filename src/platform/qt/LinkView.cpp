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
	if (m_link) {
		stopLink();
	}
	if (!m_window || !m_window->controller()) {
		m_ui.status->append(tr("Open a game first."));
		return;
	}
	if (m_window->controller()->platform() != mPLATFORM_GBA) {
		m_ui.status->append(tr("WiFi link only supports GBA games."));
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
	connect(m_controller.get(), &CoreController::stopping, this, &LinkView::stopLink);
	connect(m_controller.get(), &QObject::destroyed, this, &LinkView::stopLink);
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
	bool running = m_link != nullptr;
	m_ui.start->setDisabled(running);
	m_ui.disconnect->setEnabled(running);
	m_ui.sendReset->setEnabled(running);
	m_ui.radioHost->setDisabled(running);
	m_ui.radioJoin->setDisabled(running);
	m_ui.ipAddr->setDisabled(running);
	m_ui.port->setDisabled(running);
}
