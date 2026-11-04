/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QJsonObject>
#include <QString>

class QWebSocket;

namespace QGBA {

/**
 * gboy.top room signalling: HTTPS authentication plus the WebSocket room
 * commands, a Qt port of the Android GbCloud. Only the matching half lives
 * here - the actual link bytes travel over KCP in KcpChannel.
 */
namespace GbCloud {

const QString& api();
const QString& wsHost();
int wsPort();

/** Rewrites the upstream brand name the lobby server bakes into its replies. */
QString lobby(QString text);

/** Signs in and returns the token every room command has to carry. */
QString login(const QString& user, const QString& password, QString* error);

/** Asks gboy.top to mail a verification code; returns the server message. */
QString sendVerificationCode(const QString& email, QString* error);

/** Registers from an emailed code; the reply carries the token right away. */
QString registerAccount(const QString& username, const QString& email,
                        const QString& password, const QString& code, QString* error);

/** api.php sometimes echoes notices before the JSON line. */
QJsonObject lastJsonObject(const QString& raw, bool* ok);

/** Minimal WebSocket room session (Qt's QWebSocket, TLS errors ignored). */
class Session {
public:
	Session();
	~Session();

	/** Always true on Qt: the expired gboy.top certificate is ignored. */
	bool insecureTls() const { return m_insecure; }

	bool open(int timeoutMs, QString* error);
	void close();
	bool isOpen() const;

	bool sendText(const QString& text, QString* error = nullptr);

	/**
	 * Next text frame, or empty when nothing arrives in time. Qt answers the
	 * server's pings by itself, which keeps the room alive.
	 */
	QString recv(int timeoutMs);

private:
	void onText(const QString& text);

	QWebSocket* m_socket = nullptr;
	bool m_insecure = true;
	bool m_gotText = false;
	QString m_lastText;
};

}
}
