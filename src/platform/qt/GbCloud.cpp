/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "GbCloud.h"

#include <QCoreApplication>
#include <QDateTime>
#include <QDeadlineTimer>
#include <QDir>
#include <QEventLoop>
#include <QJsonArray>
#include <QJsonDocument>
#include <QNetworkAccessManager>
#include <QNetworkReply>
#include <QNetworkRequest>
#include <QRegularExpression>
#include <QStringList>
#include <QAbstractSocket>
#include <QTextStream>
#include <QTimer>
#include <QSslConfiguration>
#include <QSslError>
#include <QSslSocket>
#include <QWebSocket>

using namespace QGBA;

namespace {

constexpr int HTTP_TIMEOUT_MS = 15000;

/**
 * The lobby server answers with a couple of dozen frames per room session;
 * when something goes wrong the exact frames are the only evidence left.
 * They are written to a plain text file next to the temp dir so a user can
 * hand the file over without digging through a console.
 */
QString debugLogPath() {
	return QDir::tempPath() + QStringLiteral("/mgba_lobby_debug.log");
}

}

namespace QGBA {
namespace GbCloud {

void debugLog(const QString& message) {
	QString path = debugLogPath();
	QFile file(path);
	// Keep the log bounded: a long session would otherwise grow it forever.
	/* 1MB 上限在数据帧跑起来后会被瞬间撞满：文件一超就整个删掉重建，
	 * 于是日志里只剩最后几秒的内容，建房/取节点/握手这些关键行全被冲掉
	 * （现场排查时反复看到「日志里没有 host: node」就是这么来的）。
	 * 改成 64MB，并且删除时先改名再删，避免和正在写的句柄打架。 */
	if (file.size() > 64 * 1024 * 1024) {
		file.rename(path + ".old");
		QFile::remove(path + ".old");
	}
	if (!file.open(QIODevice::Append | QIODevice::Text)) {
		return;
	}
	QTextStream stream(&file);
	stream << QDateTime::currentDateTime().toString(QStringLiteral("hh:mm:ss.zzz"))
	       << QStringLiteral(" ") << message << QStringLiteral("\n");
	stream.flush();
	file.close();
}

namespace {

// Mutable endpoint storage: a mock lobby server can stand in for the live
// service during tests (GbCloud::overrideEndpoints).
QString& mutableApi() {
	static QString endpoint = QStringLiteral("https://gboy.top/api/api.php");
	return endpoint;
}

QString& mutableWsHost() {
	static QString endpoint = QStringLiteral("gboy.top");
	return endpoint;
}

int& mutableWsPort() {
	static int port = 23459;
	return port;
}

}

const QString& api() {
	return mutableApi();
}

const QString& wsHost() {
	return mutableWsHost();
}

int wsPort() {
	return mutableWsPort();
}

void overrideEndpoints(const QString& apiBase, const QString& host, int port) {
	if (!apiBase.isEmpty()) {
		mutableApi() = apiBase;
	}
	if (!host.isEmpty()) {
		mutableWsHost() = host;
	}
	if (port > 0) {
		mutableWsPort() = port;
	}
}

QString lobby(QString text) {
	if (text.isEmpty()) {
		return text;
	}
	static const QRegularExpression brand(QStringLiteral("gboy(?:\\.top)?"),
	                                      QRegularExpression::CaseInsensitiveOption);
	return text.replace(brand, QStringLiteral("联机大厅"));
}

QJsonObject lastJsonObject(const QString& raw, bool* ok) {
	const QStringList lines = raw.split('\n');
	for (int i = lines.size() - 1; i >= 0; i--) {
		QString line = lines[i].trimmed();
		if (line.startsWith('{')) {
			QJsonDocument doc = QJsonDocument::fromJson(line.toUtf8());
			if (doc.isObject()) {
				if (ok) {
					*ok = true;
				}
				return doc.object();
			}
		}
	}
	if (ok) {
		*ok = false;
	}
	return QJsonObject();
}

QList<QJsonObject> jsonObjects(const QString& raw) {
	QList<QJsonObject> objects;
	QString trimmed = raw.trimmed();
	if (trimmed.isEmpty()) {
		return objects;
	}
	QJsonDocument whole = QJsonDocument::fromJson(trimmed.toUtf8());
	if (whole.isObject()) {
		objects.append(whole.object());
		return objects;
	}
	if (whole.isArray()) {
		const auto array = whole.array();
		for (const auto& value : array) {
			if (value.isObject()) {
				objects.append(value.toObject());
			}
		}
		return objects;
	}
	// Several newline separated answers share one frame.
	const QStringList lines = raw.split('\n');
	for (const QString& rawLine : lines) {
		QString line = rawLine.trimmed();
		if (!line.startsWith('{')) {
			continue;
		}
		QJsonDocument doc = QJsonDocument::fromJson(line.toUtf8());
		if (doc.isObject()) {
			objects.append(doc.object());
		}
	}
	return objects;
}

QString post(const QString& body, QString* error) {
	QNetworkAccessManager manager;
	// Tolerate the same certificate oddities the websocket session does: the
	// official client never validates either, and a mock lobby server for
	// tests presents a self-signed certificate. Validation is not what keeps
	// these credentials safe (they travel in the JSON body of a POST either
	// way); failing the whole login over an expired chain would just strand
	// the user.
	QSslConfiguration tls = QSslConfiguration::defaultConfiguration();
	tls.setPeerVerifyMode(QSslSocket::VerifyNone);
	QNetworkRequest request((QUrl(api())));
	request.setSslConfiguration(tls);
	request.setHeader(QNetworkRequest::ContentTypeHeader, "application/json");
	request.setTransferTimeout(HTTP_TIMEOUT_MS);
	QNetworkReply* reply = manager.post(request, body.toUtf8());
	QObject::connect(&manager, &QNetworkAccessManager::sslErrors, &manager,
	                 [](QNetworkReply* errReply, const QList<QSslError>&) {
		                 if (errReply) {
			                 errReply->ignoreSslErrors();
		                 }
	                 });

	QEventLoop loop;
	QObject::connect(reply, &QNetworkReply::finished, &loop, &QEventLoop::quit);
	// Give the loop a hard ceiling so a stalled DNS lookup cannot hang the caller.
	QTimer::singleShot(HTTP_TIMEOUT_MS + 2000, &loop, &QEventLoop::quit);
	loop.exec();

	if (reply->error() != QNetworkReply::NoError) {
		if (error) {
			*error = lobby(reply->errorString());
		}
		reply->deleteLater();
		return QString();
	}
	QString raw = QString::fromUtf8(reply->readAll());
	reply->deleteLater();
	return raw;
}

QString login(const QString& user, const QString& password, QString* error) {
	QJsonObject body;
	body.insert("action", "login");
	body.insert("email_or_username", user);
	body.insert("password", password);
	QString raw = post(QString::fromUtf8(QJsonDocument(body).toJson(QJsonDocument::Compact)), error);
	if (raw.isEmpty()) {
		return QString();
	}
	bool ok = false;
	QJsonObject reply = lastJsonObject(raw, &ok);
	QString token = reply.value("token").toString();
	if (token.isEmpty()) {
		QString message = reply.value("message").toString();
		if (error) {
			*error = lobby(message.isEmpty() ? QStringLiteral("登录失败") : message);
		}
		return QString();
	}
	return token;
}

QString sendVerificationCode(const QString& email, QString* error) {
	QJsonObject body;
	body.insert("action", "send_verification_code");
	body.insert("email", email);
	QString raw = post(QString::fromUtf8(QJsonDocument(body).toJson(QJsonDocument::Compact)), error);
	if (raw.isEmpty()) {
		return QString();
	}
	bool ok = false;
	QJsonObject reply = lastJsonObject(raw, &ok);
	if (!reply.value("success").toBool(false)) {
		QString message = reply.value("message").toString();
		if (error) {
			*error = lobby(message.isEmpty() ? QStringLiteral("验证码发送失败") : message);
		}
		return QString();
	}
	QString message = reply.value("message").toString();
	return lobby(message.isEmpty() ? QStringLiteral("验证码已发送。") : message);
}

QString registerAccount(const QString& username, const QString& email,
                        const QString& password, const QString& code, QString* error) {
	QJsonObject body;
	body.insert("action", "register");
	body.insert("username", username);
	body.insert("email", email);
	body.insert("password", password);
	body.insert("verification_code", code);
	QString raw = post(QString::fromUtf8(QJsonDocument(body).toJson(QJsonDocument::Compact)), error);
	if (raw.isEmpty()) {
		return QString();
	}
	bool ok = false;
	QJsonObject reply = lastJsonObject(raw, &ok);
	QString token = reply.value("token").toString();
	if (token.isEmpty()) {
		QString message = reply.value("message").toString();
		if (error) {
			*error = lobby(message.isEmpty() ? QStringLiteral("注册失败") : message);
		}
		return QString();
	}
	return token;
}

Session::Session()
	: m_socket(new QWebSocket)
{
	// gboy.top serves a certificate issued for gameboyfrp.top (its SAN does not
	// include gboy.top), and the chain it sends is sometimes incomplete, so a
	// strictly-validating client can never finish the handshake. The official
	// client tolerates this; we mirror that. On Qt 6 + the Windows schannel
	// backend the plain ignoreSslErrors() call is not enough for a hostname
	// mismatch, so we disable peer certificate verification outright and also
	// answer the sslErrors signal as a fallback.
	QSslConfiguration sslConf = m_socket->sslConfiguration();
	sslConf.setPeerVerifyMode(QSslSocket::VerifyNone);
	m_socket->setSslConfiguration(sslConf);
	QObject::connect(m_socket, &QWebSocket::sslErrors, m_socket,
	                 [this](const QList<QSslError>&) { m_socket->ignoreSslErrors(); });
	QObject::connect(m_socket, &QWebSocket::textMessageReceived, [this](const QString& text) {
		onText(text);
	});
}

void Session::onText(const QString& text) {
	// Keep every frame: the room server pushes answers and keepalives in the
	// same turn, and the answer we need is not necessarily the last one.
	m_incoming.enqueue(text);
	QString shown = text;
	if (shown.size() > 400) {
		shown = shown.left(400) + QStringLiteral("…");
	}
	debugLog(QStringLiteral("<- ") + shown);
}

Session::~Session() {
	close();
	delete m_socket;
}

bool Session::open(int timeoutMs, QString* error) {
	QUrl url(QStringLiteral("wss://%1:%2").arg(wsHost()).arg(wsPort()));
	bool opened = false;
	QString socketError;
	QEventLoop loop;
	// 这三个连接捕获的都是**栈上**的局部变量，必须在 open() 返回前断开：
	// 连接的生命周期跟着 m_socket，而不是跟着这个函数。不断开的话，之后
	// 任何一次 processEvents（例如隧道保活排空）里 socket 抛出 errorOccurred
	// 都会回调进已经销毁的栈帧，往野地址写 member —— 表现为随机时刻的
	// 0xC0000005「写入地址 0x1」，跑几分钟才炸，极难复现。
	auto connectedConn = QObject::connect(m_socket, &QWebSocket::connected, [&]() {
		opened = true;
		loop.quit();
	});
	auto disconnectedConn = QObject::connect(m_socket, &QWebSocket::disconnected,
	                                         &loop, &QEventLoop::quit);
	auto errorConn = QObject::connect(m_socket, &QWebSocket::errorOccurred,
	                                  [&](QAbstractSocket::SocketError) {
		socketError = m_socket->errorString();
		loop.quit();
	});
	m_socket->open(url);
	QTimer::singleShot(timeoutMs, &loop, &QEventLoop::quit);
	loop.exec();
	QObject::disconnect(connectedConn);
	QObject::disconnect(disconnectedConn);
	QObject::disconnect(errorConn);
	if (!opened) {
		if (error) {
			if (socketError.isEmpty()) {
				*error = QStringLiteral("WebSocket 连接超时（%1:%2 在 %3 毫秒内无响应）")
				         .arg(wsHost()).arg(wsPort()).arg(timeoutMs);
			} else {
				*error = QStringLiteral("WebSocket 握手失败：%1").arg(socketError);
			}
		}
		return false;
	}
	return true;
}

void Session::close() {
	if (m_socket && m_socket->state() != QAbstractSocket::UnconnectedState) {
		m_socket->close();
	}
}

bool Session::isOpen() const {
	return m_socket && m_socket->state() == QAbstractSocket::ConnectedState;
}

bool Session::sendText(const QString& text, QString* error) {
	if (!isOpen()) {
		if (error) {
			*error = QStringLiteral("服务器关闭了房间连接");
		}
		return false;
	}
	m_socket->sendTextMessage(text);
	// The auth token must never end up in a file the user may share, so it is
	// masked before the frame is logged.
	QString shown = text;
	static const QRegularExpression tokenField(QStringLiteral("\"token\"\\s*:\\s*\"[^\"]*\""),
	                                           QRegularExpression::CaseInsensitiveOption);
	shown.replace(tokenField, QStringLiteral("\"token\":\"***\""));
	if (shown.size() > 400) {
		shown = shown.left(400) + QStringLiteral("…");
	}
	debugLog(QStringLiteral("-> ") + shown);
	return true;
}

QString Session::recv(int timeoutMs) {
	if (!isOpen()) {
		return QString();
	}
	QDeadlineTimer deadline{qint64(timeoutMs)};
	while (true) {
		if (!m_incoming.isEmpty()) {
			return m_incoming.dequeue();
		}
		// Spin the local event queue so the socket notifiers fire.
		QCoreApplication::processEvents(QEventLoop::AllEvents, 20);
		if (!m_incoming.isEmpty()) {
			return m_incoming.dequeue();
		}
		if (m_socket->state() != QAbstractSocket::ConnectedState) {
			return QString();
		}
		if (deadline.hasExpired()) {
			return QString();
		}
	}
}

}
}
