/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "Filters.h"

#include <QColor>
#include <QDir>
#include <QFile>
#include <QtMath>

#include <algorithm>
#include <cmath>

using namespace QGBA;

namespace {

const char* const s_names[] = {
	"None",
	"GBA color",
	"Grayscale",
	"HQ2x",
	"HQ4x",
	"2xBR",
	"4xBR",
	"Dot matrix",
	"LCD3x",
	"Scanlines",
	"Quilez",
};

/** 每种滤镜的 GLSL 主体：定义 vec3 filterColor()，其余（亮度/对比度/扫描线）由公共尾巴处理。 */
const char* glslBody(int id) {
	switch (id) {
	case Filters::FILTER_GBA_COLOR:
		return R"GLSL(
vec3 filterColor() {
    vec3 c = texture2D(tex, texCoord).rgb;
    c = pow(c, vec3(2.2));
    mat3 tone = mat3(0.82, 0.24, -0.06,
                     0.125, 0.665, 0.21,
                     0.195, 0.075, 0.73);
    c = clamp(tone * c, 0.0, 1.0) * 0.94;
    return pow(c, vec3(1.0 / 2.2));
}
)GLSL";
	case Filters::FILTER_GRAYSCALE:
		return R"GLSL(
vec3 filterColor() {
    vec3 c = texture2D(tex, texCoord).rgb;
    return vec3(dot(c, vec3(0.299, 0.587, 0.114)));
}
)GLSL";
	case Filters::FILTER_HQ2X:
		return R"GLSL(
vec3 fetch(vec2 off) { return texture2D(tex, texCoord + off / texSize).rgb; }
vec3 filterColor() {
    vec3 c11 = texture2D(tex, texCoord).rgb;
    vec3 c01 = fetch(vec2(-1.0, 0.0));
    vec3 c21 = fetch(vec2(1.0, 0.0));
    vec3 c10 = fetch(vec2(0.0, -1.0));
    vec3 c12 = fetch(vec2(0.0, 1.0));
    vec3 c00 = fetch(vec2(-1.0, -1.0));
    vec3 c20 = fetch(vec2(1.0, -1.0));
    vec3 c02 = fetch(vec2(-1.0, 1.0));
    vec3 c22 = fetch(vec2(1.0, 1.0));
    float dMain = luma(abs(c00 - c22));
    float dAnti = luma(abs(c02 - c20));
    vec4 w;
    w.x = luma(abs(c22 - c11)) * dAnti;
    w.y = luma(abs(c02 - c11)) * dMain;
    w.z = luma(abs(c00 - c11)) * dAnti;
    w.w = luma(abs(c20 - c11)) * dMain;
    float sumW = dot(w, vec4(1.0));
    float peak = max(max(w.x, w.y), max(w.z, w.w)) + 0.001;
    vec3 mixed = (w.x * c00 + w.y * c20 + w.z * c22 + w.w * c02 + peak * c11) / (sumW + peak);
    vec4 nw;
    nw.x = clamp(0.4 - 0.45 * luma(abs(mixed - c10)), 0.0, 0.4);
    nw.y = clamp(0.4 - 0.45 * luma(abs(mixed - c21)), 0.0, 0.4);
    nw.z = clamp(0.4 - 0.45 * luma(abs(mixed - c12)), 0.0, 0.4);
    nw.w = clamp(0.4 - 0.45 * luma(abs(mixed - c01)), 0.0, 0.4);
    return nw.x * c10 + nw.y * c21 + nw.z * c12 + nw.w * c01
            + (1.0 - dot(nw, vec4(1.0))) * mixed;
}
)GLSL";
	case Filters::FILTER_HQ4X:
		return R"GLSL(
vec3 fetch(vec2 off) { return texture2D(tex, texCoord + off / texSize).rgb; }
vec3 filterColor() {
    vec3 c11 = texture2D(tex, texCoord).rgb;
    vec3 c00 = fetch(vec2(-1.0, -1.0));
    vec3 c20 = fetch(vec2(1.0, -1.0));
    vec3 c02 = fetch(vec2(-1.0, 1.0));
    vec3 c22 = fetch(vec2(1.0, 1.0));
    float dMain = luma(abs(c00 - c22));
    float dAnti = luma(abs(c02 - c20));
    vec4 w;
    w.x = luma(abs(c22 - c11)) * dAnti;
    w.y = luma(abs(c02 - c11)) * dMain;
    w.z = luma(abs(c00 - c11)) * dAnti;
    w.w = luma(abs(c20 - c11)) * dMain;
    float sumW = dot(w, vec4(1.0));
    float peak = max(max(w.x, w.y), max(w.z, w.w)) + 0.001;
    vec3 mixed = (w.x * c00 + w.y * c20 + w.z * c22 + w.w * c02 + peak * c11) / (sumW + peak);
    vec2 fp = fract(texCoord * texSize) - 0.5;
    vec3 e11 = mix(mixed, c11, clamp((abs(fp.x) + abs(fp.y)) * 2.0, 0.0, 1.0));
    vec3 corner = (w.x * c00 + w.y * c20 + w.z * c22 + w.w * c02) / max(sumW, 0.001);
    vec3 e15 = mix(corner, mixed, 0.5);
    float m = max(abs(fp.x), abs(fp.y)) * 2.0;
    float n = min(abs(fp.x), abs(fp.y)) * 2.0;
    return m > 0.5 ? (n > 0.5 ? e15 : e11) : c11;
}
)GLSL";
	case Filters::FILTER_XBR2:
		return R"GLSL(
vec3 fetch(vec2 off) { return texture2D(tex, texCoord + off / texSize).rgb; }
bool edge(vec3 e, vec3 a1, vec3 a2, vec3 b1, vec3 b2) {
    return (luma(a1) == luma(b1) && luma(a1) != luma(e))
        && ((luma(e) == luma(a2) && luma(a1) == luma(b2))
         || (luma(e) == luma(b2) && luma(a1) == luma(a2)));
}
vec3 filterColor() {
    vec3 e = texture2D(tex, texCoord).rgb;
    vec3 b = fetch(vec2(0.0, -1.0));
    vec3 f = fetch(vec2(1.0, 0.0));
    vec3 h = fetch(vec2(0.0, 1.0));
    vec3 g = fetch(vec2(-1.0, 1.0));
    vec3 c = fetch(vec2(-1.0, -1.0));
    vec3 i = fetch(vec2(1.0, 1.0));
    float blend = (edge(e, h, g, f, i) || edge(e, h, c, f, b)) ? 0.5 : 0.0;
    return mix(e, f, blend);
}
)GLSL";
	case Filters::FILTER_XBR4:
		return R"GLSL(
vec3 fetch(vec2 off) { return texture2D(tex, texCoord + off / texSize).rgb; }
bool edge(vec3 e, vec3 a1, vec3 a2, vec3 b1, vec3 b2) {
    return (luma(a1) == luma(b1) && luma(a1) != luma(e))
        && ((luma(e) == luma(a2) && luma(a1) == luma(b2))
         || (luma(e) == luma(b2) && luma(a1) == luma(a2)));
}
vec3 filterColor() {
    vec3 e = texture2D(tex, texCoord).rgb;
    vec3 b = fetch(vec2(0.0, -1.0));
    vec3 f = fetch(vec2(1.0, 0.0));
    vec3 h = fetch(vec2(0.0, 1.0));
    vec3 g = fetch(vec2(-1.0, 1.0));
    vec3 c = fetch(vec2(-1.0, -1.0));
    vec3 i = fetch(vec2(1.0, 1.0));
    vec3 e11 = e;
    vec3 e15 = e;
    if (edge(e, h, g, f, i) || edge(e, h, c, f, b)) {
        e11 = mix(e, f, 0.5);
        e15 = f;
    }
    vec2 fp = abs(fract(texCoord * texSize) - 0.5) * 2.0;
    float outer = max(fp.x, fp.y);
    float inner = min(fp.x, fp.y);
    return outer > 0.5 ? (inner > 0.5 ? e15 : e11) : e;
}
)GLSL";
	case Filters::FILTER_DOT:
		return R"GLSL(
const float GAMMA = 2.4;
const float SHINE = 0.05;
const float BLEND = 0.65;
float bloom(vec3 color) {
    float bright = dot(color, vec3(0.30, 0.59, 0.11));
    return mix(1.0 + SHINE, 1.0 - SHINE, bright);
}
vec3 tap(vec2 pixelNo, float dx, float dy, vec3 color) {
    vec2 delta = fract(pixelNo) - vec2(dx, dy) - vec2(0.5);
    return color * exp(-GAMMA * dot(delta, delta) * bloom(color));
}
vec3 filterColor() {
    vec2 pixelNo = texCoord * texSize;
    vec2 d = 1.0 / texSize;
    vec3 mid = tap(pixelNo, 0.0, 0.0, texture2D(tex, texCoord).rgb);
    vec3 color = vec3(0.0);
    color += tap(pixelNo, -1.0, -1.0, texture2D(tex, texCoord + vec2(-d.x, -d.y)).rgb);
    color += tap(pixelNo, 0.0, -1.0, texture2D(tex, texCoord + vec2(0.0, -d.y)).rgb);
    color += tap(pixelNo, 1.0, -1.0, texture2D(tex, texCoord + vec2(d.x, -d.y)).rgb);
    color += tap(pixelNo, -1.0, 0.0, texture2D(tex, texCoord + vec2(-d.x, 0.0)).rgb);
    color += mid;
    color += tap(pixelNo, 1.0, 0.0, texture2D(tex, texCoord + vec2(d.x, 0.0)).rgb);
    color += tap(pixelNo, -1.0, 1.0, texture2D(tex, texCoord + vec2(-d.x, d.y)).rgb);
    color += tap(pixelNo, 0.0, 1.0, texture2D(tex, texCoord + vec2(0.0, d.y)).rgb);
    color += tap(pixelNo, 1.0, 1.0, texture2D(tex, texCoord + vec2(d.x, d.y)).rgb);
    return mix(1.2 * mid, color, BLEND);
}
)GLSL";
	case Filters::FILTER_LCD3X:
		return R"GLSL(
const float BRIGHTEN_SCAN = 16.0;
const float BRIGHTEN_LCD = 4.0;
vec3 filterColor() {
    vec2 angle = texCoord * 6.28318530 * texSize;
    vec3 offsets = 3.14159265 * vec3(0.5, 0.5 - 2.0 / 3.0, 0.5 - 4.0 / 3.0);
    float y = (BRIGHTEN_SCAN + sin(angle.y)) / (BRIGHTEN_SCAN + 1.0);
    vec3 x = (BRIGHTEN_LCD + sin(angle.x + offsets)) / (BRIGHTEN_LCD + 1.0);
    return y * x * texture2D(tex, texCoord).rgb;
}
)GLSL";
	case Filters::FILTER_SCANLINES:
		return R"GLSL(
const float BASE = 0.95;
const vec2 SINE = vec2(0.05, 0.15);
vec3 filterColor() {
    vec4 c = texture2D(tex, texCoord);
    vec2 omega = vec2(3.1415 * outputSize.x, 2.0 * 3.1415 * texSize.y);
    vec3 scan = c.rgb * (BASE + dot(SINE * sin(texCoord * omega), vec2(1.0)));
    return clamp(scan, 0.0, 1.0);
}
)GLSL";
	case Filters::FILTER_QUILEZ:
		return R"GLSL(
vec3 filterColor() {
    vec2 p = texCoord * texSize + 0.5;
    vec2 i = floor(p);
    vec2 f = p - i;
    f = f * f * f * (f * (f * 6.0 - 15.0) + 10.0);
    p = i + f;
    return texture2D(tex, (p - 0.5) / texSize).rgb;
}
)GLSL";
	default:
		return R"GLSL(
vec3 filterColor() { return texture2D(tex, texCoord).rgb; }
)GLSL";
	}
}

QString shaderSource(int id, float brightness, float contrast, float scanlines) {
	QString prelude = QStringLiteral(
	    "#ifdef GL_FRAGMENT_PRECISION_HIGH\n"
	    "precision highp float;\n"
	    "#else\n"
	    "precision mediump float;\n"
	    "#endif\n"
	    "uniform sampler2D tex;\n"
	    "uniform vec2 texSize;\n"
	    "uniform vec2 outputSize;\n"
	    "varying vec2 texCoord;\n"
	    "const float kBrightness = %1;\n"
	    "const float kContrast = %2;\n"
	    "const float kScan = %3;\n"
	    "float luma(vec3 c) { return dot(c, vec3(0.299, 0.587, 0.114)); }\n")
	    .arg(brightness, 0, 'f', 4)
	    .arg(contrast, 0, 'f', 4)
	    .arg(scanlines, 0, 'f', 4);
	QString tail = QStringLiteral(
	    "void main() {\n"
	    "    vec3 c = filterColor() * kBrightness;\n"
	    "    c = (c - 0.5) * kContrast + 0.5;\n"
	    "    c *= 1.0 - 0.4 * kScan * (1.0 - step(0.5, mod(floor(gl_FragCoord.y), 2.0)));\n"
	    "    gl_FragColor = vec4(clamp(c, 0.0, 1.0), 1.0);\n"
	    "}\n");
	return prelude + QString::fromUtf8(glslBody(id)) + tail;
}

/* ---------------------------------------------------------------- CPU 侧 */

struct Rgb {
	float r;
	float g;
	float b;
};

inline Rgb operator+(const Rgb& a, const Rgb& b) { return {a.r + b.r, a.g + b.g, a.b + b.b}; }
inline Rgb operator-(const Rgb& a, const Rgb& b) { return {a.r - b.r, a.g - b.g, a.b - b.b}; }
inline Rgb operator*(const Rgb& a, float s) { return {a.r * s, a.g * s, a.b * s}; }
inline Rgb operator*(float s, const Rgb& a) { return a * s; }
inline Rgb& operator+=(Rgb& a, const Rgb& b) { a.r += b.r; a.g += b.g; a.b += b.b; return a; }

inline float luma(const Rgb& c) { return 0.299f * c.r + 0.587f * c.g + 0.114f * c.b; }
inline Rgb absv(const Rgb& c) { return {std::fabs(c.r), std::fabs(c.g), std::fabs(c.b)}; }
inline Rgb mixv(const Rgb& a, const Rgb& b, float t) { return a * (1.f - t) + b * t; }
inline float clampf(float v, float lo, float hi) { return v < lo ? lo : (v > hi ? hi : v); }

class Sampler {
public:
	Sampler(const QImage& image)
		: m_image(image.convertToFormat(QImage::Format_RGB32))
		, m_w(m_image.width())
		, m_h(m_image.height())
	{
	}

	Rgb nearest(float u, float v) const {
		int x = int(u * m_w);
		int y = int(v * m_h);
		x = std::max(0, std::min(m_w - 1, x));
		y = std::max(0, std::min(m_h - 1, y));
		QRgb p = reinterpret_cast<const QRgb*>(m_image.constScanLine(y))[x];
		return {qRed(p) / 255.f, qGreen(p) / 255.f, qBlue(p) / 255.f};
	}

	Rgb bilinear(float u, float v) const {
		float px = u * m_w - 0.5f;
		float py = v * m_h - 0.5f;
		int x0 = int(std::floor(px));
		int y0 = int(std::floor(py));
		float fx = px - x0;
		float fy = py - y0;
		Rgb c00 = texel(x0, y0);
		Rgb c10 = texel(x0 + 1, y0);
		Rgb c01 = texel(x0, y0 + 1);
		Rgb c11 = texel(x0 + 1, y0 + 1);
		return mixv(mixv(c00, c10, fx), mixv(c01, c11, fx), fy);
	}

	int width() const { return m_w; }
	int height() const { return m_h; }

private:
	Rgb texel(int x, int y) const {
		x = std::max(0, std::min(m_w - 1, x));
		y = std::max(0, std::min(m_h - 1, y));
		QRgb p = reinterpret_cast<const QRgb*>(m_image.constScanLine(y))[x];
		return {qRed(p) / 255.f, qGreen(p) / 255.f, qBlue(p) / 255.f};
	}

	QImage m_image;
	int m_w;
	int m_h;
};

inline float fractf(float v) { return v - std::floor(v); }

Rgb applyOne(const Sampler& sampler, int id, float u, float v, int outWidth) {
	const int w = sampler.width();
	const int h = sampler.height();
	auto fetch = [&](float ox, float oy) {
		return sampler.nearest(u + ox / w, v + oy / h);
	};
	switch (id) {
	case Filters::FILTER_GBA_COLOR: {
		Rgb c = sampler.nearest(u, v);
		auto gamma = [](float x) { return std::pow(std::max(0.f, x), 2.2f); };
		c = {gamma(c.r), gamma(c.g), gamma(c.b)};
		/* GLSL mat3 是列主序：三列分别为 tone 的 (0.82,0.24,-0.06) 等。 */
		Rgb out;
		out.r = 0.82f * c.r + 0.125f * c.g + 0.195f * c.b;
		out.g = 0.24f * c.r + 0.665f * c.g + 0.075f * c.b;
		out.b = -0.06f * c.r + 0.21f * c.g + 0.73f * c.b;
		out = {clampf(out.r, 0.f, 1.f) * 0.94f, clampf(out.g, 0.f, 1.f) * 0.94f, clampf(out.b, 0.f, 1.f) * 0.94f};
		auto invGamma = [](float x) { return std::pow(std::max(0.f, x), 1.f / 2.2f); };
		return {invGamma(out.r), invGamma(out.g), invGamma(out.b)};
	}
	case Filters::FILTER_GRAYSCALE: {
		Rgb c = sampler.nearest(u, v);
		return {luma(c), luma(c), luma(c)};
	}
	case Filters::FILTER_HQ2X: {
		Rgb c11 = sampler.nearest(u, v);
		Rgb c01 = fetch(-1, 0);
		Rgb c21 = fetch(1, 0);
		Rgb c10 = fetch(0, -1);
		Rgb c12 = fetch(0, 1);
		Rgb c00 = fetch(-1, -1);
		Rgb c20 = fetch(1, -1);
		Rgb c02 = fetch(-1, 1);
		Rgb c22 = fetch(1, 1);
		float dMain = luma(absv(c00 - c22));
		float dAnti = luma(absv(c02 - c20));
		float wx = luma(absv(c22 - c11)) * dAnti;
		float wy = luma(absv(c02 - c11)) * dMain;
		float wz = luma(absv(c00 - c11)) * dAnti;
		float ww = luma(absv(c20 - c11)) * dMain;
		float sumW = wx + wy + wz + ww;
		float peak = std::max(std::max(wx, wy), std::max(wz, ww)) + 0.001f;
		Rgb mixed = (c00 * wx + c20 * wy + c22 * wz + c02 * ww + c11 * peak) * (1.f / (sumW + peak));
		float nwx = clampf(0.4f - 0.45f * luma(absv(mixed - c10)), 0.f, 0.4f);
		float nwy = clampf(0.4f - 0.45f * luma(absv(mixed - c21)), 0.f, 0.4f);
		float nwz = clampf(0.4f - 0.45f * luma(absv(mixed - c12)), 0.f, 0.4f);
		float nww = clampf(0.4f - 0.45f * luma(absv(mixed - c01)), 0.f, 0.4f);
		return c10 * nwx + c21 * nwy + c12 * nwz + c01 * nww + mixed * (1.f - (nwx + nwy + nwz + nww));
	}
	case Filters::FILTER_HQ4X: {
		Rgb c11 = sampler.nearest(u, v);
		Rgb c00 = fetch(-1, -1);
		Rgb c20 = fetch(1, -1);
		Rgb c02 = fetch(-1, 1);
		Rgb c22 = fetch(1, 1);
		float dMain = luma(absv(c00 - c22));
		float dAnti = luma(absv(c02 - c20));
		float wx = luma(absv(c22 - c11)) * dAnti;
		float wy = luma(absv(c02 - c11)) * dMain;
		float wz = luma(absv(c00 - c11)) * dAnti;
		float ww = luma(absv(c20 - c11)) * dMain;
		float sumW = wx + wy + wz + ww;
		float peak = std::max(std::max(wx, wy), std::max(wz, ww)) + 0.001f;
		Rgb mixed = (c00 * wx + c20 * wy + c22 * wz + c02 * ww + c11 * peak) * (1.f / (sumW + peak));
		float fpx = fractf(u * w) - 0.5f;
		float fpy = fractf(v * h) - 0.5f;
		Rgb e11 = mixv(mixed, c11, clampf((std::fabs(fpx) + std::fabs(fpy)) * 2.f, 0.f, 1.f));
		Rgb corner = (c00 * wx + c20 * wy + c22 * wz + c02 * ww) * (1.f / std::max(sumW, 0.001f));
		Rgb e15 = mixv(corner, mixed, 0.5f);
		float m = std::max(std::fabs(fpx), std::fabs(fpy)) * 2.f;
		float n = std::min(std::fabs(fpx), std::fabs(fpy)) * 2.f;
		if (m > 0.5f) {
			return n > 0.5f ? e15 : e11;
		}
		return c11;
	}
	case Filters::FILTER_XBR2:
	case Filters::FILTER_XBR4: {
		Rgb e = sampler.nearest(u, v);
		Rgb b = fetch(0, -1);
		Rgb f = fetch(1, 0);
		Rgb hh = fetch(0, 1);
		Rgb g = fetch(-1, 1);
		Rgb c = fetch(-1, -1);
		Rgb i = fetch(1, 1);
		auto edge = [](const Rgb& ec, const Rgb& a1, const Rgb& a2, const Rgb& b1, const Rgb& b2) {
			return (luma(a1) == luma(b1) && luma(a1) != luma(ec))
			    && ((luma(ec) == luma(a2) && luma(a1) == luma(b2))
			        || (luma(ec) == luma(b2) && luma(a1) == luma(a2)));
		};
		bool hasEdge = edge(e, hh, g, f, i) || edge(e, hh, c, f, b);
		if (id == Filters::FILTER_XBR2) {
			return hasEdge ? mixv(e, f, 0.5f) : e;
		}
		Rgb e11 = e;
		Rgb e15 = e;
		if (hasEdge) {
			e11 = mixv(e, f, 0.5f);
			e15 = f;
		}
		float fpx = std::fabs(fractf(u * w) - 0.5f) * 2.f;
		float fpy = std::fabs(fractf(v * h) - 0.5f) * 2.f;
		float outer = std::max(fpx, fpy);
		float inner = std::min(fpx, fpy);
		if (outer > 0.5f) {
			return inner > 0.5f ? e15 : e11;
		}
		return e;
	}
	case Filters::FILTER_DOT: {
		const float GAMMA = 2.4f;
		const float SHINE = 0.05f;
		const float BLEND = 0.65f;
		float pixelX = u * w;
		float pixelY = v * h;
		auto bloom = [](const Rgb& color) {
			float bright = 0.30f * color.r + 0.59f * color.g + 0.11f * color.b;
			return 1.0f + SHINE - 2.0f * SHINE * bright;
		};
		auto tap = [&](float dx, float dy, const Rgb& color) {
			float ddx = fractf(pixelX) - dx - 0.5f;
			float ddy = fractf(pixelY) - dy - 0.5f;
			return color * std::exp(-GAMMA * (ddx * ddx + ddy * ddy) * bloom(color));
		};
		Rgb mid = tap(0, 0, sampler.nearest(u, v));
		Rgb color{0.f, 0.f, 0.f};
		color += tap(-1, -1, fetch(-1, -1));
		color += tap(0, -1, fetch(0, -1));
		color += tap(1, -1, fetch(1, -1));
		color += tap(-1, 0, fetch(-1, 0));
		color += mid;
		color += tap(1, 0, fetch(1, 0));
		color += tap(-1, 1, fetch(-1, 1));
		color += tap(0, 1, fetch(0, 1));
		color += tap(1, 1, fetch(1, 1));
		return mixv(mid * 1.2f, color, BLEND);
	}
	case Filters::FILTER_LCD3X: {
		const float BRIGHTEN_SCAN = 16.f;
		const float BRIGHTEN_LCD = 4.f;
		float ax = u * 6.28318530f * w;
		float ay = v * 6.28318530f * h;
		float yv = (BRIGHTEN_SCAN + std::sin(ay)) / (BRIGHTEN_SCAN + 1.f);
		Rgb c = sampler.nearest(u, v);
		float xr = (BRIGHTEN_LCD + std::sin(ax + 3.14159265f * 0.5f)) / (BRIGHTEN_LCD + 1.f);
		float xg = (BRIGHTEN_LCD + std::sin(ax + 3.14159265f * (0.5f - 2.f / 3.f))) / (BRIGHTEN_LCD + 1.f);
		float xb = (BRIGHTEN_LCD + std::sin(ax + 3.14159265f * (0.5f - 4.f / 3.f))) / (BRIGHTEN_LCD + 1.f);
		return {c.r * yv * xr, c.g * yv * xg, c.b * yv * xb};
	}
	case Filters::FILTER_SCANLINES: {
		Rgb c = sampler.nearest(u, v);
		/* 与 GLSL 一致：横向用 outputSize.x（屏幕宽），纵向用 texSize.y。 */
		float omegaX = 3.1415f * float(outWidth);
		float omegaY = 2.f * 3.1415f * float(h);
		float mod = 0.95f + 0.05f * std::sin(u * omegaX) + 0.15f * std::sin(v * omegaY);
		return {clampf(c.r * mod, 0.f, 1.f), clampf(c.g * mod, 0.f, 1.f), clampf(c.b * mod, 0.f, 1.f)};
	}
	case Filters::FILTER_QUILEZ: {
		float px = u * w + 0.5f;
		float py = v * h + 0.5f;
		float ix = std::floor(px);
		float iy = std::floor(py);
		float fx = px - ix;
		float fy = py - iy;
		fx = fx * fx * fx * (fx * (fx * 6.f - 15.f) + 10.f);
		fy = fy * fy * fy * (fy * (fy * 6.f - 15.f) + 10.f);
		return sampler.bilinear((ix + fx - 0.5f) / w, (iy + fy - 0.5f) / h);
	}
	default:
		return sampler.nearest(u, v);
	}
}

}

QStringList Filters::names() {
	QStringList out;
	for (const char* name : s_names) {
		out.append(QString::fromLatin1(name));
	}
	return out;
}

bool Filters::buildShaderDir(int id, const QString& dir, float brightness, float contrast, float scanlines, QString* error) {
	if (id <= FILTER_NONE || id >= FILTER_COUNT) {
		if (error) {
			*error = QStringLiteral("unknown filter");
		}
		return false;
	}
	QDir out(dir);
	if (!out.mkpath(QStringLiteral("."))) {
		if (error) {
			*error = QStringLiteral("cannot create %1").arg(dir);
		}
		return false;
	}
	QFile fs(out.absoluteFilePath(QStringLiteral("shader.fs")));
	if (!fs.open(QIODevice::WriteOnly | QIODevice::Truncate | QIODevice::Text)) {
		if (error) {
			*error = QStringLiteral("cannot write shader.fs");
		}
		return false;
	}
	fs.write(shaderSource(id, brightness, contrast, scanlines).toUtf8());
	fs.close();

	QString manifest = QStringLiteral(
	    "[shader]\n"
	    "name=%1\n"
	    "author=mGBA\n"
	    "description=Built-in screen filter\n"
	    "passes=1\n"
	    "\n"
	    "[pass.0]\n"
	    "fragmentShader=shader.fs\n"
	    "blend=0\n"
	    "width=-2\n"
	    "height=-2\n").arg(Filters::names().value(id, QStringLiteral("Filter")));
	QFile ini(out.absoluteFilePath(QStringLiteral("manifest.ini")));
	if (!ini.open(QIODevice::WriteOnly | QIODevice::Truncate | QIODevice::Text)) {
		if (error) {
			*error = QStringLiteral("cannot write manifest.ini");
		}
		return false;
	}
	ini.write(manifest.toUtf8());
	ini.close();
	return true;
}

QImage Filters::applyCpu(const QImage& src, int id, const QSize& outSize, float brightness, float contrast, float scanlines) {
	if (src.isNull() || outSize.width() < 1 || outSize.height() < 1) {
		return QImage();
	}
	if (id <= FILTER_NONE || id >= FILTER_COUNT) {
		return src.scaled(outSize, Qt::IgnoreAspectRatio, Qt::FastTransformation)
		    .convertToFormat(QImage::Format_RGB32);
	}
	QImage out(outSize, QImage::Format_RGB32);
	Sampler sampler(src);
	const int ow = outSize.width();
	const int oh = outSize.height();
	for (int y = 0; y < oh; ++y) {
		QRgb* line = reinterpret_cast<QRgb*>(out.scanLine(y));
		const float v = (y + 0.5f) / oh;
		const float scanMul = 1.f - 0.4f * scanlines * ((y % 2) == 0 ? 1.f : 0.f);
		for (int x = 0; x < ow; ++x) {
			const float u = (x + 0.5f) / ow;
			Rgb c = applyOne(sampler, id, u, v, ow);
			c = c * brightness;
			c = (c - Rgb{0.5f, 0.5f, 0.5f}) * contrast + Rgb{0.5f, 0.5f, 0.5f};
			c = c * scanMul;
			line[x] = qRgb(int(clampf(c.r, 0.f, 1.f) * 255.f + 0.5f),
			               int(clampf(c.g, 0.f, 1.f) * 255.f + 0.5f),
			               int(clampf(c.b, 0.f, 1.f) * 255.f + 0.5f));
		}
	}
	return out;
}
