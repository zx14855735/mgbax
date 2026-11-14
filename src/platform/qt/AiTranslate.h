/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QImage>
#include <QList>
#include <QNetworkAccessManager>
#include <QObject>
#include <QRectF>
#include <QString>
#include <QWidget>

namespace QGBA {

/**
 * AI 截图翻译（对齐 Android AiTranslate.java）：
 * 把当前帧 PNG 上传到 Gemini，模型返回若干文本块（归一化坐标 + 译文），
 * PC 侧用 Qt Network 发请求，结果画在画面上的半透明浮层里。
 * 不引入新依赖（Qt Network 已在链）。
 */
class AiTranslate : public QObject {
Q_OBJECT

public:
	struct Block {
		QRectF rect;   // 归一化 0..1
		QString text;
	};

	explicit AiTranslate(QObject* parent = nullptr);

	/** 异步翻译；同一时间只保留最后一次请求。 */
	void translate(const QImage& frame, const QString& apiKey, const QString& targetLang);

signals:
	void finished(const QList<QGBA::AiTranslate::Block>& blocks, const QString& error);

private:
	static QList<Block> parseBlocks(const QString& text);

	QNetworkAccessManager m_net;
};

/** 半透明译文浮层：画在画面控件之上，鼠标穿透。 */
class AiOverlay : public QWidget {
Q_OBJECT

public:
	explicit AiOverlay(QWidget* parent = nullptr);
	void setBlocks(const QList<AiTranslate::Block>& blocks);
	void setStatus(const QString& status);
	void clear();

protected:
	void paintEvent(QPaintEvent*) override;

private:
	QList<AiTranslate::Block> m_blocks;
	QString m_status;
};

}
