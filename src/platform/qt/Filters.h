/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QImage>
#include <QString>
#include <QStringList>

namespace QGBA {

/**
 * 内置画面滤镜（照抄 Android Shaders.java 的公式，PC 侧两套后端各一份实现）：
 *
 *   - OpenGL 后端：写成 mGBA `.shader` 目录（manifest.ini + shader.fs），
 *     交给 Display::setShaders()，与用户外部 shader 走同一条渲染链；
 *   - 软件后端（DisplayQt）：同一套公式在输出分辨率上做 CPU 实现，
 *     挂在 paintEvent 里，观感与 GL 路径一致。
 *
 * MOTION_BLUR 不在其中：Android 用 7 帧历史纹理，mGBA 着色器链没有 history，
 * PC 用已有的 Interframe blending 等价替代。
 */
namespace Filters {

enum Id {
	FILTER_NONE = 0,
	FILTER_GBA_COLOR,
	FILTER_GRAYSCALE,
	FILTER_HQ2X,
	FILTER_HQ4X,
	FILTER_XBR2,
	FILTER_XBR4,
	FILTER_DOT,
	FILTER_LCD3X,
	FILTER_SCANLINES,
	FILTER_QUILEZ,
	FILTER_COUNT
};

/** 菜单顺序对应的显示名，下标即 Id。 */
QStringList names();

/** 生成 mGBA 着色器目录（manifest.ini + shader.fs）。返回 false 时填 error。 */
bool buildShaderDir(int id, const QString& dir, float brightness, float contrast, float scanlines, QString* error);

/** 软件后端：把 src（原生分辨率）按 id 采样到 outSize。brightness/contrast 为倍率，scanlines 0..1。 */
QImage applyCpu(const QImage& src, int id, const QSize& outSize, float brightness, float contrast, float scanlines);

}
}
