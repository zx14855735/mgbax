/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "WebDavView.h"

#include "ConfigController.h"
#include "CoreController.h"
#include "WebDavSync.h"
#include "Window.h"

#include <QFileInfo>
#include <QFormLayout>
#include <QLineEdit>
#include <QPlainTextEdit>
#include <QPushButton>
#include <QSettings>
#include <QThread>
#include <QVBoxLayout>

using namespace QGBA;

namespace {

QSettings& syncSettings() {
	static QSettings settings(QStringLiteral("mGBAx"), QStringLiteral("sync"));
	return settings;
}

}

WebDavView::WebDavView(Window* window, QWidget* parent)
	: QDialog(parent, Qt::WindowTitleHint | Qt::WindowSystemMenuHint | Qt::WindowCloseButtonHint)
	, m_window(window)
{
	setWindowTitle(tr("WebDAV 存档同步"));

	QVBoxLayout* layout = new QVBoxLayout;
	QFormLayout* form = new QFormLayout;
	m_url = new QLineEdit(syncSettings().value("sync_url", WebDavSync::DEFAULT_URL).toString());
	m_dir = new QLineEdit(syncSettings().value("sync_dir", WebDavSync::DEFAULT_DIR).toString());
	m_user = new QLineEdit(syncSettings().value("sync_user").toString());
	m_pass = new QLineEdit(syncSettings().value("sync_pass").toString());
	m_pass->setEchoMode(QLineEdit::Password);
	m_pass->setPlaceholderText(tr("坚果云应用密码"));
	form->addRow(tr("服务器"), m_url);
	form->addRow(tr("远程目录"), m_dir);
	form->addRow(tr("用户"), m_user);
	form->addRow(tr("密码"), m_pass);
	layout->addLayout(form);

	m_sync = new QPushButton(tr("立即同步"));
	layout->addWidget(m_sync);
	m_status = new QPlainTextEdit;
	m_status->setReadOnly(true);
	m_status->setMaximumHeight(160);
	layout->addWidget(m_status);
	setLayout(layout);

	connect(m_sync, &QAbstractButton::clicked, this, &WebDavView::syncNow);
}

void WebDavView::status(const QString& text) {
	m_status->appendPlainText(text);
}

void WebDavView::syncNow() {
	WebDavSync::Config config;
	config.url = m_url->text().trimmed();
	config.dir = m_dir->text().trimmed();
	config.user = m_user->text().trimmed();
	config.pass = m_pass->text();
	if (config.url.isEmpty() || config.user.isEmpty() || config.pass.isEmpty()) {
		status(tr("请填写服务器、用户名和密码"));
		return;
	}
	syncSettings().setValue("sync_url", config.url);
	syncSettings().setValue("sync_dir", config.dir);
	syncSettings().setValue("sync_user", config.user);
	syncSettings().setValue("sync_pass", config.pass);

	// The battery saves live next to the current game's save file; sync that
	// directory. Android syncs its whole saves dir, this is its equivalent.
	QString saveDir;
	if (m_window && m_window->controller()) {
		QString savePath = m_window->controller()->savePath();
		if (!savePath.isEmpty()) {
			saveDir = QFileInfo(savePath).absolutePath();
		}
	}
	if (saveDir.isEmpty()) {
		status(tr("请先打开一个游戏（存档在当前游戏的存档目录里）"));
		return;
	}

	m_sync->setDisabled(true);
	status(tr("正在同步 %1 …").arg(saveDir));

	// Sync on a one-shot worker so the dialog stays responsive.
	QThread* worker = new QThread(this);
	QString dir = saveDir;
	connect(worker, &QThread::started, worker, [this, worker, dir, config]() {
		WebDavSync::Result result;
		QString error;
		if (WebDavSync::run(dir, config, &result, &error)) {
			if (result.errors.isEmpty()) {
				status(tr("同步完成：上传 %1，下载 %2").arg(result.uploaded).arg(result.downloaded));
			} else {
				status(tr("同步完成（上传 %1，下载 %2），失败文件：%3")
				       .arg(result.uploaded).arg(result.downloaded).arg(result.errors.join(", ")));
			}
		} else {
			status(error == QStringLiteral("config") ? tr("配置不完整") : tr("同步失败：%1").arg(error));
		}
		worker->quit();
	});
	connect(worker, &QThread::finished, worker, &QObject::deleteLater);
	connect(this, &QObject::destroyed, worker, &QThread::quit);
	worker->start();
}
