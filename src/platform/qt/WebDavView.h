/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QDialog>
#include <QPointer>

class QLineEdit;
class QPlainTextEdit;
class QPushButton;

namespace QGBA {

class Window;

/**
 * WebDAV battery-save sync dialog (a Qt port of the Android WebDavSync):
 * server/user/password/remote directory + a manual "sync now" button.
 */
class WebDavView : public QDialog {
Q_OBJECT

public:
	WebDavView(Window* window, QWidget* parent = nullptr);

private slots:
	void syncNow();

private:
	void status(const QString& text);

	QPointer<Window> m_window;
	QLineEdit* m_url = nullptr;
	QLineEdit* m_dir = nullptr;
	QLineEdit* m_user = nullptr;
	QLineEdit* m_pass = nullptr;
	QPushButton* m_sync = nullptr;
	QPlainTextEdit* m_status = nullptr;
};

}
