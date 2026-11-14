/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "AiTranslate.h"
#include "moc_AiTranslate.cpp"

#include <QBuffer>
#include <QJsonArray>
#include <QJsonDocument>
#include <QJsonObject>
#include <QNetworkReply>
#include <QNetworkRequest>
#include <QPainter>

#include <algorithm>

using namespace QGBA;

namespace {
const char* const ENDPOINT =
    "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=";
}

AiTranslate::AiTranslate(QObject* parent)
	: QObject(parent)
{
}

void AiTranslate::translate(const QImage& frame, const QString& apiKey, const QString& targetLang) {
	if (apiKey.trimmed().isEmpty()) {
		emit finished({}, tr("未配置 API Key（Tools → AI 翻译设置）"));
		return;
	}
	if (frame.isNull()) {
		emit finished({}, tr("没有可翻译的画面"));
		return;
	}
	/* 模型只需要读清文字，长边压到 720 省流量。 */
	QImage send = frame;
	if (send.width() > 720 || send.height() > 720) {
		send = send.scaled(720, 720, Qt::KeepAspectRatio, Qt::SmoothTransformation);
	}
	QByteArray png;
	{
		QBuffer buffer(&png);
		buffer.open(QIODevice::WriteOnly);
		send.save(&buffer, "PNG", 90);
	}
	const QString image = QString::fromLatin1(png.toBase64());

	const QString lang = targetLang.trimmed().isEmpty() ? tr("简体中文") : targetLang.trimmed();
	const QString prompt =
	    QStringLiteral("这是复古游戏机屏幕截图。找出画面中所有含游戏文字的区域(对白、菜单、提示),"
	                   "把日文或英文翻译成%1。只输出 JSON 数组,不要其它文字:每个元素格式 "
	                   "{\"x\":0..1,\"y\":0..1,\"w\":0..1,\"h\":0..1,\"t\":\"译文\"},"
	                   "x/y 是文本块左上角(相对整图宽高),w/h 是文本块大小;没有文字就输出 []。").arg(lang);

	QJsonObject textPart{{QStringLiteral("text"), prompt}};
	QJsonObject inlineData{{QStringLiteral("mime_type"), QStringLiteral("image/png")},
	                       {QStringLiteral("data"), image}};
	QJsonObject imagePart{{QStringLiteral("inline_data"), inlineData}};
	QJsonArray parts{textPart, imagePart};
	QJsonObject role{{QStringLiteral("role"), QStringLiteral("user")}, {QStringLiteral("parts"), parts}};
	QJsonArray contents{role};
	QJsonObject body{{QStringLiteral("contents"), contents}};

	QNetworkRequest request(QUrl(QString::fromLatin1(ENDPOINT) + apiKey.trimmed()));
	request.setHeader(QNetworkRequest::ContentTypeHeader, QStringLiteral("application/json"));
	QNetworkReply* reply = m_net.post(request, QJsonDocument(body).toJson(QJsonDocument::Compact));
	connect(reply, &QNetworkReply::finished, this, [this, reply]() {
		reply->deleteLater();
		if (reply->error() != QNetworkReply::NoError) {
			emit finished({}, tr("请求失败：%1").arg(reply->errorString()));
			return;
		}
		const QJsonDocument doc = QJsonDocument::fromJson(reply->readAll());
		const QJsonArray candidates = doc.object().value(QStringLiteral("candidates")).toArray();
		if (candidates.isEmpty()) {
			emit finished({}, tr("模型没有返回候选结果"));
			return;
		}
		const QJsonArray responseParts = candidates.first().toObject()
		    .value(QStringLiteral("content")).toObject()
		    .value(QStringLiteral("parts")).toArray();
		if (responseParts.isEmpty()) {
			emit finished({}, tr("模型返回内容为空"));
			return;
		}
		emit finished(parseBlocks(responseParts.first().toObject().value(QStringLiteral("text")).toString()), QString());
	});
}

QList<AiTranslate::Block> AiTranslate::parseBlocks(const QString& text) {
	QList<Block> out;
	if (text.isEmpty()) {
		return out;
	}
	const int start = text.indexOf(QLatin1Char('['));
	const int end = text.lastIndexOf(QLatin1Char(']'));
	if (start < 0 || end <= start) {
		return out;
	}
	const QJsonDocument doc = QJsonDocument::fromJson(text.mid(start, end - start + 1).toUtf8());
	if (!doc.isArray()) {
		return out;
	}
	for (const QJsonValue& value : doc.array()) {
		const QJsonObject item = value.toObject();
		Block block;
		block.rect = QRectF(item.value(QStringLiteral("x")).toDouble(),
		                    item.value(QStringLiteral("y")).toDouble(),
		                    item.value(QStringLiteral("w")).toDouble(),
		                    item.value(QStringLiteral("h")).toDouble());
		block.text = item.value(QStringLiteral("t")).toString().trimmed();
		if (!block.text.isEmpty() && block.rect.width() > 0.001 && block.rect.height() > 0.001) {
			out.append(block);
		}
	}
	return out;
}

AiOverlay::AiOverlay(QWidget* parent)
	: QWidget(parent)
{
	setAttribute(Qt::WA_TransparentForMouseEvents);
	setAttribute(Qt::WA_NoSystemBackground);
	setAttribute(Qt::WA_TranslucentBackground);
}

void AiOverlay::setBlocks(const QList<AiTranslate::Block>& blocks) {
	m_blocks = blocks;
	m_status.clear();
	update();
}

void AiOverlay::setStatus(const QString& status) {
	m_blocks.clear();
	m_status = status;
	update();
}

void AiOverlay::clear() {
	m_blocks.clear();
	m_status.clear();
	update();
}

void AiOverlay::paintEvent(QPaintEvent*) {
	QPainter painter(this);
	painter.setRenderHint(QPainter::Antialiasing);
	if (!m_status.isEmpty()) {
		QFont font = painter.font();
		font.setPointSizeF(font.pointSizeF() * 1.4);
		painter.setFont(font);
		const QString text = m_status;
		const QRect box = painter.fontMetrics().boundingRect(text).adjusted(-16, -10, 16, 10);
		QRect target(box);
		target.moveCenter(rect().center());
		painter.setPen(Qt::NoPen);
		painter.setBrush(QColor(0, 0, 0, 190));
		painter.drawRoundedRect(target, 6, 6);
		painter.setPen(Qt::white);
		painter.drawText(target, Qt::AlignCenter, text);
		return;
	}
	QFont font = painter.font();
	font.setPointSizeF(std::max(8.0, height() / 40.0));
	painter.setFont(font);
	for (const AiTranslate::Block& block : m_blocks) {
		QRectF box(block.rect.x() * width(), block.rect.y() * height(),
		           block.rect.width() * width(), block.rect.height() * height());
		box = box.intersected(QRectF(rect()));
		if (box.width() < 4 || box.height() < 4) {
			continue;
		}
		painter.setPen(Qt::NoPen);
		painter.setBrush(QColor(0, 0, 0, 170));
		painter.drawRoundedRect(box, 3, 3);
		painter.setPen(Qt::white);
		painter.drawText(box.adjusted(3, 2, -3, -2), Qt::AlignLeft | Qt::AlignVCenter | Qt::TextWordWrap, block.text);
	}
}
