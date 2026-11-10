/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "LobbyView.h"
#include "moc_LobbyView.cpp"

#include "CloudLink.h"
#include "CoreController.h"
#include "GbCloud.h"
#include "Window.h"

#include <QDir>
#include <QFileInfo>
#include <QRandomGenerator>
#include <QSettings>
#include <QTimer>

using namespace QGBA;

namespace {

constexpr const char* SETTING_EMAIL = "cloud_email";
constexpr const char* SETTING_USER = "cloud_user";
constexpr const char* SETTING_PASS = "cloud_pass";

QSettings& cloudSettings() {
	static QSettings settings(QStringLiteral("mGBAx"), QStringLiteral("cloud"));
	return settings;
}

bool looksAlreadyRegistered(const QString& message) {
	// Server texts, verified live against gboy.top (see PROTOCOL notes).
	return message.contains(QStringLiteral("已注册")) || message.contains(QStringLiteral("已被注册"))
	       || message.contains(QStringLiteral("已存在")) || message.contains(QStringLiteral("已使用"))
	       || message.contains(QStringLiteral("已绑定"));
}

QString deriveUsername(const QString& email) {
	QString base = email.section('@', 0, 0).toLower();
	QString clean;
	for (const QChar& c : base) {
		if (c.isLetterOrNumber()) {
			clean.append(c);
		}
	}
	while (clean.size() < 2) {
		clean.append('u');
	}
	if (clean.size() > 10) {
		clean = clean.left(10);
	}
	return clean;
}

QString randomPassword() {
	QString out;
	for (int i = 0; i < 3; i++) {
		out.append(QString::number(QRandomGenerator::global()->generate(), 16));
	}
	return out.left(16);
}

}

LobbyView::LobbyView(Window* window, QWidget* parent)
	: QDialog(parent, Qt::WindowTitleHint | Qt::WindowSystemMenuHint | Qt::WindowCloseButtonHint)
	, m_window(window)
{
	m_ui.setupUi(this);

	connect(window, &QObject::destroyed, this, &QWidget::close);
	connect(m_ui.sendCode, &QAbstractButton::clicked, this, &LobbyView::sendCode);
	connect(m_ui.codeLogin, &QAbstractButton::clicked, this, &LobbyView::codeLogin);
	connect(m_ui.directLogin, &QAbstractButton::clicked, this, &LobbyView::directLogin);
	connect(m_ui.createRoom, &QAbstractButton::clicked, this, [this]() { startRoom(true); });
	connect(m_ui.joinRoom, &QAbstractButton::clicked, this, [this]() { startRoom(false); });
	connect(m_ui.disconnect, &QAbstractButton::clicked, this, &LobbyView::disconnect);
	connect(m_ui.sendReset, &QAbstractButton::clicked, this, [this]() {
		if (m_link) {
			m_link->sendReset();
		}
	});

	m_ui.email->setText(cloudSettings().value(SETTING_EMAIL).toString());
	QString savedUser = cloudSettings().value(SETTING_USER).toString();
	QString savedPass = cloudSettings().value(SETTING_PASS).toString();
	if (!savedUser.isEmpty() && !savedPass.isEmpty()) {
		m_ui.password->setText(savedPass);
		m_ui.status->appendPlainText(tr("已保存账号 %1，可直接建房/加入").arg(savedUser));
	}
}

void LobbyView::sendCode() {
	QString email = m_ui.email->text().trimmed();
	if (email.isEmpty()) {
		m_ui.status->appendPlainText(tr("请先填写邮箱"));
		return;
	}
	QString error;
	QString message = GbCloud::sendVerificationCode(email, &error);
	if (!message.isEmpty()) {
		m_ui.status->appendPlainText(message);
	} else {
		m_ui.status->appendPlainText(error);
	}
}

void LobbyView::codeLogin() {
	QString email = m_ui.email->text().trimmed();
	QString code = m_ui.code->text().trimmed();
	if (email.isEmpty()) {
		m_ui.status->appendPlainText(tr("请先填写邮箱"));
		return;
	}
	QString savedPass = cloudSettings().value(SETTING_PASS).toString();
	QString password = m_ui.password->text();

	if (code.isEmpty()) {
		// No code: straight login with whatever password is available.
		if (password.isEmpty()) {
			m_ui.status->appendPlainText(tr("请填写密码或先获取验证码"));
			return;
		}
		QString error;
		QString token = GbCloud::login(email, password, &error);
		if (!token.isEmpty()) {
			saveCredentials(email, password);
			m_ui.status->appendPlainText(tr("登录成功"));
			return;
		}
		m_ui.status->appendPlainText(error);
		return;
	}

	// First use registers straight from the code (username is derived from the
	// email prefix, retrying with a random suffix if the name is taken).
	QString passwordToUse = password.isEmpty() ? savedPass : password;
	if (passwordToUse.isEmpty()) {
		passwordToUse = randomPassword();
	}
	QString error;
	QString token = GbCloud::registerAccount(deriveUsername(email), email, passwordToUse, code, &error);
	if (!token.isEmpty()) {
		saveCredentials(email, passwordToUse);
		m_ui.password->setText(passwordToUse);
		m_ui.status->appendPlainText(tr("注册并登录成功，账号信息已保存"));
		return;
	}
	if (looksAlreadyRegistered(error) && !savedPass.isEmpty()) {
		// The mail address is taken; fall back to a plain login with the
		// password that was saved on this device.
		token = GbCloud::login(email, savedPass, &error);
		if (!token.isEmpty()) {
			saveCredentials(email, savedPass);
			m_ui.status->appendPlainText(tr("已直接登录（邮箱早已注册）"));
			return;
		}
	}
	m_ui.status->appendPlainText(error);
}

void LobbyView::directLogin() {
	QString email = m_ui.email->text().trimmed();
	QString password = m_ui.password->text();
	if (email.isEmpty() || password.isEmpty()) {
		m_ui.status->appendPlainText(tr("请填写邮箱和密码"));
		return;
	}
	QString error;
	QString token = GbCloud::login(email, password, &error);
	if (!token.isEmpty()) {
		saveCredentials(email, password);
		m_ui.status->appendPlainText(tr("登录成功"));
		return;
	}
	m_ui.status->appendPlainText(error);
}

void LobbyView::saveCredentials(const QString& email, const QString& password) {
	// The room server only accepts the full email as the login identifier
	// (the bare prefix / derived username it rejects with "用户名或密码错误"),
	// so the lobby re-login in CloudLink must use exactly the address that
	// already succeeded here - not the email prefix we once stored.
	const QString key = email.trimmed();
	cloudSettings().setValue(SETTING_EMAIL, key);
	cloudSettings().setValue(SETTING_USER, key);
	cloudSettings().setValue(SETTING_PASS, password);
	m_tokenUser = key;
	m_tokenPassword = password;
}

bool LobbyView::ensureLoggedIn() {
	// Prefer the email field (pre-filled with the saved address); the room
	// server only accepts the full email as the login identifier, so this is
	// what the lobby re-login in CloudLink must use. Previously the stored
	// "user" was the email prefix, which the server rejects.
	QString email = m_ui.email->text().trimmed();
	QString savedPass = cloudSettings().value(SETTING_PASS).toString();
	if (!email.isEmpty() && !savedPass.isEmpty()) {
		m_tokenUser = email;
		m_tokenPassword = savedPass;
		return true;
	}
	// Fall back to a stored username + password when the email field is empty.
	QString savedUser = cloudSettings().value(SETTING_USER).toString();
	if (!savedUser.isEmpty() && !savedPass.isEmpty()) {
		m_tokenUser = savedUser;
		m_tokenPassword = savedPass;
		return true;
	}
	m_ui.status->appendPlainText(tr("请先登录（直接登录或验证码注册）"));
	return false;
}

void LobbyView::startRoom(bool asHost) {
	if (!ensureLoggedIn()) {
		return;
	}
	if (m_link) {
		disconnect();
	}
	if (!m_window || !m_window->controller()) {
		m_ui.status->appendPlainText(tr("请先打开一个游戏"));
		return;
	}
	if (m_window->controller()->platform() != mPLATFORM_GBA) {
		m_ui.status->appendPlainText(tr("云端联机目前只支持 GBA 游戏"));
		return;
	}

	CloudLink::Config config;
	config.user = m_tokenUser;
	config.password = m_tokenPassword;
	config.roomId = asHost ? QString() : m_ui.roomId->text().trimmed();
	// path() 可能只是文件名（媒体库/VFile 加载），绝对位置在 baseDirectory；
	// 官方镜像模式（MGBAX_OFFICIAL_LINK=1）的镜像核要拿它们重新加载 ROM。
	QString romPath = m_window->controller()->path();
	QString base = m_window->controller()->baseDirectory();
	if (!QFileInfo::exists(romPath) && !base.isEmpty()) {
		romPath = QDir(base).filePath(romPath);
	}
	config.romPath = romPath;
	QString savePath = m_window->controller()->savePath();
	if (!QFileInfo::exists(savePath) && !base.isEmpty()) {
		savePath = QDir(base).filePath(savePath);
	}
	config.savePath = savePath;

	m_controller = m_window->controller();
	m_link = new CloudLink(this);
	m_link->setController(m_controller.get());
	connect(m_link, &CloudLink::statusMessage, this, &LobbyView::status);
	connect(m_link, &CloudLink::linkEnded, this, &LobbyView::ended);
	connect(m_link, &CloudLink::remoteKeys, m_controller.get(), &CoreController::setRemoteKeys);
	connect(m_link, &CloudLink::remoteReset, m_controller.get(), &CoreController::reset);
	connect(m_controller.get(), &CoreController::stopping, this, &LobbyView::disconnect);
	m_link->startLink(config);

	// Feed the current local key mask to the worker at its own cadence; the
	// timer is a child of the link object and dies with it.
	QTimer* pump = new QTimer(m_link);
	connect(pump, &QTimer::timeout, m_link, [this]() {
		if (m_link && m_controller) {
			m_link->setLocalKeys(m_controller->localKeys());
		}
	});
	pump->start(40);

	m_ui.status->appendPlainText(asHost ? tr("正在创建房间…") : tr("正在加入房间 %1…").arg(config.roomId));
	updateRunning();
}

void LobbyView::disconnect() {
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
	m_ui.status->appendPlainText(tr("已断开"));
	updateRunning();
}

void LobbyView::status(const QString& message) {
	m_ui.status->appendPlainText(message);
}

void LobbyView::ended(const QString& message) {
	if (!message.isEmpty()) {
		m_ui.status->appendPlainText(message);
	}
	disconnect();
}

void LobbyView::updateRunning() {
	bool running = m_link != nullptr;
	m_ui.createRoom->setDisabled(running);
	m_ui.joinRoom->setDisabled(running);
	m_ui.disconnect->setEnabled(running);
	m_ui.sendReset->setEnabled(running);
	m_ui.roomId->setDisabled(running);
}
