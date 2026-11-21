#pragma once

#include <QTranslator>

/* 按源串直接查表的中文翻译器，忽略 context（见 MgbaTranslate.cpp 顶部说明）。
 * 用法：在主窗口创建前 application.installTranslator(&translator)。 */
class SimpleTranslator : public QTranslator
{
public:
	using QTranslator::QTranslator;

	QString translate(const char* context, const char* sourceText,
	                  const char* disambiguation = nullptr, int n = -1) const override;
};
