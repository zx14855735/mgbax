/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include "ui_LinkView.h"

#include <QPointer>
#include <memory>

namespace QGBA {

class CoreController;
class GBoyLink;
class Window;

/**
 * WiFi link-cable dialog (GBoy / My Boy compatible, merged key masks).
 * The remote player's key mask is OR-ed into the local input through
 * CoreController::setRemoteKeys, mirroring the Android lobby behavior.
 */
class LinkView : public QDialog {
Q_OBJECT

public:
	LinkView(Window* window, QWidget* parent = nullptr);

public slots:
	void startLink();
	void stopLink();
	void sendReset();

private slots:
	void status(const QString& message);
	void ended(const QString& message);
	void updateRunning();

private:
	Ui::LinkView m_ui;
	QPointer<Window> m_window;
	std::shared_ptr<CoreController> m_controller;
	GBoyLink* m_link = nullptr;
	bool m_lanActive = false;
	QTimer* m_lanTimer = nullptr;
};

}
