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

#include <QComboBox>
#include <QBuffer>
#include <QDir>
#include <QFileInfo>
#include <QHBoxLayout>
#include <QLabel>
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

	/* C0 / ADR-002：联机模式显式入口。历史上 PC 默认 A、Android 默认 B，
	 * 全仓只有环境变量 / 私有 pref 能改，两套帧格式同流曾耗死读线程。
	 * 这里补一个大厅可见下拉框（AUTO / A / B），选择写进 QSettings；
	 * 环境变量 MGBAX_LINK_MODE 仍可作为无人值守脚手架的覆盖入口。 */
	QWidget* modeRow = new QWidget(this);
	QHBoxLayout* modeLayout = new QHBoxLayout(modeRow);
	modeLayout->setContentsMargins(0, 0, 0, 0);
	modeLayout->addWidget(new QLabel(tr("联机模式："), modeRow));
	QComboBox* modeCombo = new QComboBox(modeRow);
	modeCombo->setObjectName(QStringLiteral("linkModeCombo"));
	modeCombo->addItem(tr("AUTO（2P→A / 3·4P→B）"), GBoyFrames::LINK_MODE_UNKNOWN);
	modeCombo->addItem(tr("A：每端 1 核 + SIO 包中继"), GBoyFrames::LINK_MODE_A);
	modeCombo->addItem(tr("B：本机多核 + 网络只传按键"), GBoyFrames::LINK_MODE_B);
	const QString savedMode = cloudSettings().value(QStringLiteral("link_mode"),
	                                                QStringLiteral("AUTO")).toString();
	if (savedMode == QStringLiteral("A")) {
		modeCombo->setCurrentIndex(1);
	} else if (savedMode == QStringLiteral("B")) {
		modeCombo->setCurrentIndex(2);
	}
	connect(modeCombo, QOverload<int>::of(&QComboBox::currentIndexChanged), this,
	        [modeCombo](int) {
		        const int value = modeCombo->currentData().toInt();
		        const QString key = value == GBoyFrames::LINK_MODE_A ? QStringLiteral("A")
		                            : value == GBoyFrames::LINK_MODE_B ? QStringLiteral("B")
		                                                               : QStringLiteral("AUTO");
		        cloudSettings().setValue(QStringLiteral("link_mode"), key);
	        });
	modeLayout->addWidget(modeCombo, 1);
	if (layout()) {
		layout()->addWidget(modeRow);
	}

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
	/* C0：把大厅下拉框的选择下发到 CloudLink；AUTO 时由 CloudLink 按房间人数
	 * 解析（2P→A、3/4P→B）。两端必须一致，不一致由 CloudLink 在分派前 fail。 */
	QComboBox* modeCombo = findChild<QComboBox*>(QStringLiteral("linkModeCombo"));
	if (modeCombo) {
		const int chosen = modeCombo->currentData().toInt();
		/* AUTO 时不覆盖 CloudLink 构造器从 MGBAX_LINK_MODE /
		 * MGBAX_OFFICIAL_LINK 读到的显式值，保留 flow.sh 等无人值守脚手架的
		 * 兼容入口；只有用户在大厅里显式选了 A/B 才覆盖。 */
		if (chosen == GBoyFrames::LINK_MODE_A || chosen == GBoyFrames::LINK_MODE_B) {
			m_link->setLinkMode(chosen);
		}
	}
	m_link->setAllowLegacyPeer(qgetenv("MGBAX_LINK_ALLOW_LEGACY").toInt() != 0);
	m_link->setController(m_controller.get());
	/* PC cloud-arm 的种子：type-6 要发的是可见核的 state。AUTOLINK 那条路
	 * 在 Window.cpp 里早已接了同样的 provider，大厅这条路以前**没接**——
	 * 于是 maybeSendInitialState() 永远拿不到字节，对端的镜像核收不到本机
	 * 存档，这就是 2P 云端 BATTLE=0 的直接原因之一。 */
	m_link->setStateSnapshotProvider([this]() -> QByteArray {
		if (!m_controller) {
			return QByteArray();
		}
		QBuffer buffer;
		buffer.open(QIODevice::WriteOnly);
		m_controller->saveState(&buffer);
		return buffer.data();
	});
	/* S2 TYPE_PARTY：只读 provider；门默认关时 sendPartyMailboxSync 不会调用它。 */
	m_link->setPartyMailboxProvider([this]() -> QByteArray {
		return m_controller ? m_controller->readNetPartyMailbox() : QByteArray();
	});
	connect(m_link, &CloudLink::statusMessage, this, &LobbyView::status);
	connect(m_link, &CloudLink::linkEnded, this, &LobbyView::ended);
	connect(m_link, &CloudLink::remoteKeys, m_controller.get(), &CoreController::setRemoteKeys);
	connect(m_link, &CloudLink::remoteReset, m_controller.get(), &CoreController::reset);
	connect(m_link, &CloudLink::remoteSpeedChanged, this, &LobbyView::applyNetSpeed);
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
		/* 断开后回到 1x，否则下一次单机会带着上一局的 4x/0.5x 起来。 */
		m_controller->setNetSpeed(1.f);
		m_controller.reset();
	}
	if (m_window) {
		m_window->reflectNetSpeed(0);
	}
	m_ui.status->appendPlainText(tr("已断开"));
	updateRunning();
}

void LobbyView::sendNetSpeed(int wireValue) {
	if (m_link) {
		m_link->sendSpeed(wireValue);
	}
}

void LobbyView::applyNetSpeed(int wireValue) {
	/* 官方 9 的线上值 → 实际倍率；0 = 未收到 → 1x。 */
	float speed = 1.f;
	if (wireValue == -1) {
		speed = 0.5f;
	} else if (wireValue == 2 || wireValue == 4) {
		speed = float(wireValue);
	}
	if (m_controller) {
		m_controller->setNetSpeed(speed);
	}
	if (m_window) {
		m_window->reflectNetSpeed(wireValue);
	}
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
