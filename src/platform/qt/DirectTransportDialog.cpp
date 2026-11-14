/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "DirectTransportDialog.h"
#include "moc_DirectTransportDialog.cpp"

#include "ConfigController.h"
#include "BtLink.h"

#include <QComboBox>
#include <QCoreApplication>
#include <QDialogButtonBox>
#include <QFormLayout>
#include <QLabel>
#include <QLineEdit>
#include <QMessageBox>
#include <QSpinBox>
#include <QVBoxLayout>

using namespace QGBA;

namespace {
const char* const TRANSPORT_AUTO = "auto";
const char* const TRANSPORT_BT_HOST = "bt-host";
const char* const TRANSPORT_BT_CLIENT = "bt-client";
const char* const TRANSPORT_TCP_CLIENT = "tcp-client";
const char* const TRANSPORT_TCP_LISTEN = "tcp-listen";

const char* const ENV_BT = "MGBAX_BT";
const char* const ENV_TCP_PEER = "MGBAX_TCP_PEER";
const char* const ENV_TCP_LISTEN = "MGBAX_TCP_LISTEN";
}

DirectTransportDialog::DirectTransportDialog(ConfigController* config, QWidget* parent)
	: QDialog(parent)
	, m_config(config)
{
	setWindowTitle(tr("联机直连传输"));
	setModal(true);

	m_mode = new QComboBox(this);
	m_mode->addItem(tr("自动（不指定，走默认：UDP 打洞 → 服务器隧道）"), QString::fromLatin1(TRANSPORT_AUTO));
	m_mode->addItem(tr("蓝牙 · 服务端（等待对端连入）"), QString::fromLatin1(TRANSPORT_BT_HOST));
	m_mode->addItem(tr("蓝牙 · 客户端（连接对端蓝牙地址）"), QString::fromLatin1(TRANSPORT_BT_CLIENT));
	m_mode->addItem(tr("TCP · 客户端（连接 host:port）"), QString::fromLatin1(TRANSPORT_TCP_CLIENT));
	m_mode->addItem(tr("TCP · 服务端（监听端口等待连入）"), QString::fromLatin1(TRANSPORT_TCP_LISTEN));

	m_btPeer = new QLineEdit(this);
	m_btPeer->setPlaceholderText(QStringLiteral("AA:BB:CC:DD:EE:FF"));

	m_tcpPeer = new QLineEdit(this);
	m_tcpPeer->setPlaceholderText(QStringLiteral("host:port"));

	m_tcpPort = new QSpinBox(this);
	m_tcpPort->setRange(1, 65535);
	m_tcpPort->setValue(5678);

	QFormLayout* form = new QFormLayout;
	form->addRow(tr("传输方式"), m_mode);
	form->addRow(tr("蓝牙地址"), m_btPeer);
	form->addRow(tr("TCP 对端"), m_tcpPeer);
	form->addRow(tr("TCP 监听端口"), m_tcpPort);

	QLabel* hint = new QLabel(tr("这里只选择「用哪条直连通道」，握手与帧格式不变。\n"
	                             "设置会立即生效，并对之后加入的联机大厅房间起作用。\n"
	                             "蓝牙需要 Windows 且对端已配对；TCP 需要一边有公网或端口映射。"),
	                          this);
	hint->setWordWrap(true);

	QDialogButtonBox* buttons = new QDialogButtonBox(QDialogButtonBox::Ok | QDialogButtonBox::Cancel, this);
	connect(buttons, &QDialogButtonBox::accepted, this, [this]() {
		this->save();
	});
	connect(buttons, &QDialogButtonBox::rejected, this, &QDialog::reject);

	QVBoxLayout* layout = new QVBoxLayout(this);
	layout->addLayout(form);
	layout->addWidget(hint);
	layout->addWidget(buttons);

	/* 读回已保存的值 */
	QString mode = m_config->getQtOption("netTransport").toString();
	if (mode.isEmpty()) {
		mode = QString::fromLatin1(TRANSPORT_AUTO);
	}
	int index = m_mode->findData(mode);
	m_mode->setCurrentIndex(index < 0 ? 0 : index);
	m_btPeer->setText(m_config->getQtOption("netBtPeer").toString());
	m_tcpPeer->setText(m_config->getQtOption("netTcpPeer").toString());
	int port = m_config->getQtOption("netTcpPort").toInt();
	if (port > 0) {
		m_tcpPort->setValue(port);
	}

	if (!BtLink::supported()) {
		m_mode->setItemText(1, tr("蓝牙 · 服务端（本机不支持 RFCOMM）"));
		m_mode->setItemText(2, tr("蓝牙 · 客户端（本机不支持 RFCOMM）"));
	}

	connect(m_mode, QOverload<int>::of(&QComboBox::currentIndexChanged), this, &DirectTransportDialog::updateFieldStates);
	updateFieldStates();
}

void DirectTransportDialog::updateFieldStates() {
	const QString mode = m_mode->currentData().toString();
	m_btPeer->setEnabled(mode == QLatin1String(TRANSPORT_BT_CLIENT));
	m_tcpPeer->setEnabled(mode == QLatin1String(TRANSPORT_TCP_CLIENT));
	m_tcpPort->setEnabled(mode == QLatin1String(TRANSPORT_TCP_LISTEN));
}

void DirectTransportDialog::save() {
	const QString mode = m_mode->currentData().toString();

	if (mode == QLatin1String(TRANSPORT_BT_CLIENT)) {
		const QString peer = m_btPeer->text().trimmed();
		if (peer.isEmpty()) {
			QMessageBox::warning(this, tr("联机直连传输"), tr("蓝牙客户端模式需要填写对端蓝牙地址。"));
			return;
		}
	} else if (mode == QLatin1String(TRANSPORT_TCP_CLIENT)) {
		const QString peer = m_tcpPeer->text().trimmed();
		const int colon = peer.lastIndexOf(QLatin1Char(':'));
		bool ok = false;
		const int port = colon > 0 ? peer.mid(colon + 1).toInt(&ok) : 0;
		if (colon <= 0 || !ok || port <= 0 || port > 65535) {
			QMessageBox::warning(this, tr("联机直连传输"), tr("TCP 对端格式应为 host:port（端口 1-65535）。"));
			return;
		}
	}

	m_config->setQtOption("netTransport", mode);
	m_config->setQtOption("netBtPeer", m_btPeer->text().trimmed());
	m_config->setQtOption("netTcpPeer", m_tcpPeer->text().trimmed());
	m_config->setQtOption("netTcpPort", m_tcpPort->value());

	accept();
}

QString DirectTransportDialog::applyToEnvironment(ConfigController* config) {
	if (!config) {
		return QString();
	}
	const QString mode = config->getQtOption("netTransport").toString();
	const bool applied = config->getQtOption("netTransportApplied").toBool();

	auto clearOwned = [&config]() {
		qunsetenv(ENV_BT);
		qunsetenv(ENV_TCP_PEER);
		qunsetenv(ENV_TCP_LISTEN);
		config->setQtOption("netTransportApplied", false);
	};

	if (mode.isEmpty() || mode == QLatin1String(TRANSPORT_AUTO)) {
		/* 用户自己 export 的变量不动：只有我们写过的才回收。 */
		if (applied) {
			clearOwned();
		}
		return QString();
	}

	clearOwned();
	if (mode == QLatin1String(TRANSPORT_BT_HOST)) {
		qputenv(ENV_BT, QByteArrayLiteral("host"));
	} else if (mode == QLatin1String(TRANSPORT_BT_CLIENT)) {
		const QByteArray peer = config->getQtOption("netBtPeer").toString().trimmed().toUtf8();
		if (peer.isEmpty()) {
			return QString();
		}
		qputenv(ENV_BT, peer);
	} else if (mode == QLatin1String(TRANSPORT_TCP_CLIENT)) {
		const QByteArray peer = config->getQtOption("netTcpPeer").toString().trimmed().toUtf8();
		if (peer.isEmpty()) {
			return QString();
		}
		qputenv(ENV_TCP_PEER, peer);
	} else if (mode == QLatin1String(TRANSPORT_TCP_LISTEN)) {
		const int port = config->getQtOption("netTcpPort").toInt();
		if (port <= 0 || port > 65535) {
			return QString();
		}
		qputenv(ENV_TCP_LISTEN, QByteArray::number(port));
	} else {
		return QString();
	}
	config->setQtOption("netTransportApplied", true);

	if (mode == QLatin1String(TRANSPORT_BT_HOST)) {
		return QCoreApplication::translate("DirectTransportDialog", "直连传输：蓝牙服务端（服务名 GBoy）");
	}
	if (mode == QLatin1String(TRANSPORT_BT_CLIENT)) {
		return QCoreApplication::translate("DirectTransportDialog", "直连传输：蓝牙客户端 %1")
		    .arg(config->getQtOption("netBtPeer").toString().trimmed());
	}
	if (mode == QLatin1String(TRANSPORT_TCP_CLIENT)) {
		return QCoreApplication::translate("DirectTransportDialog", "直连传输：TCP 客户端 %1")
		    .arg(config->getQtOption("netTcpPeer").toString().trimmed());
	}
	return QCoreApplication::translate("DirectTransportDialog", "直连传输：TCP 服务端 监听 %1")
	    .arg(config->getQtOption("netTcpPort").toInt());
}
