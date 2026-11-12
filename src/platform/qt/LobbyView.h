/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include "ui_LobbyView.h"

#include <QPointer>
#include <memory>

namespace QGBA {

class CloudLink;
class CoreController;
class Window;

/**
 * gboy.top cloud lobby dialog: email + verification-code login (first use
 * registers automatically, later uses log straight in), then create or join a
 * room. The room's KEYS frames mirror the remote player's input through
 * CoreController::setRemoteKeys, same as the Android lobby.
 */
class LobbyView : public QDialog {
Q_OBJECT

public:
	LobbyView(Window* window, QWidget* parent = nullptr);

public slots:
	void disconnect();

private slots:
	void sendCode();
	void codeLogin();
	void directLogin();
	void startRoom(bool asHost);

	void status(const QString& message);
	void ended(const QString& message);
	void updateRunning();

private:
	bool ensureLoggedIn();
	void saveCredentials(const QString& user, const QString& password);

	Ui::LobbyView m_ui;
	QPointer<Window> m_window;
	std::shared_ptr<CoreController> m_controller;
	CloudLink* m_link = nullptr;
	QString m_tokenUser;
	QString m_tokenPassword;
};

}
