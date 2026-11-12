/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * GLSL ES 1.00 sources for the screen filters. Every filter is a single
 * fragment pass over the native frame evaluated at screen resolution; the
 * vertex stage is shared.
 *
 * <p>The LCD-style filters (DOT, LCD3X, SCANLINES) adapt public-domain
 * libretro shaders by Themaister and Gigaherz. The interpolation filters
 * (HQ2X, HQ4X, XBR2, XBR4) implement the well-known published algorithms
 * (luma-equality edge rules) written from scratch; QUILEZ is the sharp
 * bilinear scheme from Iñigo Quílez's "Improved texture interpolation".
 * The remaining color/blur filters are original.</p>
 */
final class Shaders {
    private Shaders() {
    }

    /** Filter ids, matching the order shown in the 画质 picker. */
    static final int FILTER_NONE = 0;
    static final int FILTER_GBA_COLOR = 1;
    static final int FILTER_GRAYSCALE = 2;
    static final int FILTER_HQ2X = 3;
    static final int FILTER_HQ4X = 4;
    static final int FILTER_2XBR = 5;
    static final int FILTER_4XBR = 6;
    static final int FILTER_MOTION_BLUR = 7;
    static final int FILTER_DOT = 8;
    static final int FILTER_LCD3X = 9;
    static final int FILTER_SCANLINES = 10;
    static final int FILTER_QUILEZ = 11;
    /** User-installed single-pass GLSL; source set via {@link #setExternalSource}. */
    static final int FILTER_EXTERNAL = 12;

    static final int FILTER_COUNT = 13;

    /** Adapted source of the installed external shader; null when none. */
    private static volatile String externalSource;
    /** Bumped on every install so the GL program cache knows to rebuild. */
    private static volatile int externalVersion;

    static void setExternalSource(String adapted) {
        externalSource = adapted;
        externalVersion++;
    }

    static String externalSource() {
        return externalSource;
    }

    static int externalVersion() {
        return externalVersion;
    }

    static final String VERTEX = ""
            + "attribute vec2 aPos;\n"
            + "attribute vec2 aTexCoord;\n"
            + "varying vec2 vTexCoord;\n"
            + "void main() {\n"
            + "    gl_Position = vec4(aPos, 0.0, 1.0);\n"
            + "    vTexCoord = aTexCoord;\n"
            + "}\n";

    /** Fragment sources indexed by filter id; index 0 stays null (no GL pass). */
    static String fragment(int filter) {
        switch (filter) {
            case FILTER_GBA_COLOR: return GBA_COLOR;
            case FILTER_GRAYSCALE: return GRAYSCALE;
            case FILTER_HQ2X: return HQ2X;
            case FILTER_HQ4X: return HQ4X;
            case FILTER_2XBR: return XBR2;
            case FILTER_4XBR: return XBR4;
            case FILTER_MOTION_BLUR: return MOTION_BLUR;
            case FILTER_DOT: return DOT;
            case FILTER_LCD3X: return LCD3X;
            case FILTER_SCANLINES: return SCANLINES;
            case FILTER_QUILEZ: return QUILEZ;
            case FILTER_EXTERNAL: return externalSource;
            default: return null;
        }
    }

    /**
     * Sampling mode of the native frame texture. Interpolation filters that
     * measure the position inside a texel (HQ/xBR/DOT/LCD3X/scanline effects)
     * need nearest sampling to stay sharp; the rest read linear.
     */
    static boolean linearSampling(int filter) {
        return filter == FILTER_QUILEZ || filter == FILTER_EXTERNAL;
    }

    /** True when the filter needs previous frames bound as history textures. */
    static int historyFrames(int filter) {
        return filter == FILTER_MOTION_BLUR ? 7 : 0;
    }

    private static final String PRELUDE = ""
            + "#ifdef GL_FRAGMENT_PRECISION_HIGH\n"
            + "precision highp float;\n"
            + "#else\n"
            + "precision mediump float;\n"
            + "#endif\n"
            + "uniform sampler2D uTex;\n"
            + "uniform vec2 uTexSize;\n"
            + "uniform vec2 uOutSize;\n"
            + "uniform float uBrightness;\n"
            + "uniform float uContrast;\n"
            + "varying vec2 vTexCoord;\n"
            + "vec3 contrast(vec3 c) { return (c - 0.5) * uContrast + 0.5; }\n";

    /**
     * Plain blit for frames without a filter, replacing the hardware Canvas
     * path so the window surface never changes producer (a Canvas takeover
     * breaks later eglCreateWindowSurface calls with EGL_BAD_ALLOC).
     * uScanlines reproduces the old Canvas scanline overlay by darkening
     * every second output row.
     */
    static final String PASSTHROUGH = PRELUDE
            + "uniform float uScanlines;\n"
            + "void main() {\n"
            + "    vec3 c = texture2D(uTex, vTexCoord).rgb;\n"
            + "    c *= 1.0 - 0.4 * uScanlines * (1.0 - step(0.5, mod(floor(gl_FragCoord.y), 2.0)));\n"
            + "    gl_FragColor = vec4(contrast(c * uBrightness), 1.0);\n"
            + "}\n";

    private static final String GBA_COLOR = PRELUDE
            + "void main() {\n"
            + "    vec3 c = texture2D(uTex, vTexCoord).rgb;\n"
            + "    c = pow(c, vec3(2.2));\n"
            + "    // GBA LCD tone matrix: muted primaries with slight bleed.\n"
            + "    mat3 tone = mat3(\n"
            + "        0.82, 0.24, -0.06,\n"
            + "        0.125, 0.665, 0.21,\n"
            + "        0.195, 0.075, 0.73);\n"
            + "    c = clamp(tone * c, 0.0, 1.0) * 0.94;\n"
            + "    gl_FragColor = vec4(contrast(pow(c, vec3(1.0 / 2.2)) * uBrightness), 1.0);\n"
            + "}\n";

    private static final String GRAYSCALE = PRELUDE
            + "void main() {\n"
            + "    vec3 c = texture2D(uTex, vTexCoord).rgb;\n"
            + "    float g = dot(c, vec3(0.299, 0.587, 0.114));\n"
            + "    gl_FragColor = vec4(contrast(vec3(g) * uBrightness), 1.0);\n"
            + "}\n";

    /*
     * HQ2x/HQ4x: the classic edge-direction blending. The 3x3 neighborhood is
     * compared by luminance; the four diagonal gradients decide an intermediate
     * color, which is then softened toward the cross neighbors. HQ4X adds the
     * 4x4 sub-pixel select on top, giving corner pixels a crisper diagonal.
     */
    private static final String HQ_COMMON = ""
            + "float luma(vec3 c) { return dot(c, vec3(0.299, 0.587, 0.114)); }\n"
            + "vec3 fetch(vec2 off) { return texture2D(uTex, vTexCoord + off / uTexSize).rgb; }\n";

    private static final String HQ2X = PRELUDE + HQ_COMMON
            + "void main() {\n"
            + "    vec3 c11 = texture2D(uTex, vTexCoord).rgb;\n"
            + "    vec3 c01 = fetch(vec2(-1.0, 0.0));\n"
            + "    vec3 c21 = fetch(vec2(1.0, 0.0));\n"
            + "    vec3 c10 = fetch(vec2(0.0, -1.0));\n"
            + "    vec3 c12 = fetch(vec2(0.0, 1.0));\n"
            + "    vec3 c00 = fetch(vec2(-1.0, -1.0));\n"
            + "    vec3 c20 = fetch(vec2(1.0, -1.0));\n"
            + "    vec3 c02 = fetch(vec2(-1.0, 1.0));\n"
            + "    vec3 c22 = fetch(vec2(1.0, 1.0));\n"
            + "    float dMain = luma(abs(c00 - c22));\n"
            + "    float dAnti = luma(abs(c02 - c20));\n"
            + "    vec4 w;\n"
            + "    w.x = luma(abs(c22 - c11)) * dAnti;\n"
            + "    w.y = luma(abs(c02 - c11)) * dMain;\n"
            + "    w.z = luma(abs(c00 - c11)) * dAnti;\n"
            + "    w.w = luma(abs(c20 - c11)) * dMain;\n"
            + "    float sumW = dot(w, vec4(1.0));\n"
            + "    float peak = max(max(w.x, w.y), max(w.z, w.w)) + 0.001;\n"
            + "    vec3 mixed = (w.x * c00 + w.y * c20 + w.z * c22 + w.w * c02 + peak * c11)\n"
            + "            / (sumW + peak);\n"
            + "    // Neighbors that look like the blend absorb it; different ones let go.\n"
            + "    vec4 nw;\n"
            + "    nw.x = clamp(0.4 - 0.45 * luma(abs(mixed - c10)), 0.0, 0.4);\n"
            + "    nw.y = clamp(0.4 - 0.45 * luma(abs(mixed - c21)), 0.0, 0.4);\n"
            + "    nw.z = clamp(0.4 - 0.45 * luma(abs(mixed - c12)), 0.0, 0.4);\n"
            + "    nw.w = clamp(0.4 - 0.45 * luma(abs(mixed - c01)), 0.0, 0.4);\n"
            + "    vec3 out1 = nw.x * c10 + nw.y * c21 + nw.z * c12 + nw.w * c01\n"
            + "            + (1.0 - dot(nw, vec4(1.0))) * mixed;\n"
            + "    gl_FragColor = vec4(contrast(out1 * uBrightness), 1.0);\n"
            + "}\n";

    private static final String HQ4X = PRELUDE + HQ_COMMON
            + "void main() {\n"
            + "    vec3 c11 = texture2D(uTex, vTexCoord).rgb;\n"
            + "    vec3 c00 = fetch(vec2(-1.0, -1.0));\n"
            + "    vec3 c20 = fetch(vec2(1.0, -1.0));\n"
            + "    vec3 c02 = fetch(vec2(-1.0, 1.0));\n"
            + "    vec3 c22 = fetch(vec2(1.0, 1.0));\n"
            + "    float dMain = luma(abs(c00 - c22));\n"
            + "    float dAnti = luma(abs(c02 - c20));\n"
            + "    vec4 w;\n"
            + "    w.x = luma(abs(c22 - c11)) * dAnti;\n"
            + "    w.y = luma(abs(c02 - c11)) * dMain;\n"
            + "    w.z = luma(abs(c00 - c11)) * dAnti;\n"
            + "    w.w = luma(abs(c20 - c11)) * dMain;\n"
            + "    float sumW = dot(w, vec4(1.0));\n"
            + "    float peak = max(max(w.x, w.y), max(w.z, w.w)) + 0.001;\n"
            + "    vec3 mixed = (w.x * c00 + w.y * c20 + w.z * c22 + w.w * c02 + peak * c11)\n"
            + "            / (sumW + peak);\n"
            + "    // Where we are inside the texel picks between the texel color,\n"
            + "    // the edge blend and the diagonal continuation.\n"
            + "    vec2 fp = fract(vTexCoord * uTexSize) - 0.5;\n"
            + "    vec3 e11 = mix(mixed, c11, clamp((abs(fp.x) + abs(fp.y)) * 2.0, 0.0, 1.0));\n"
            + "    vec3 corner = (w.x * c00 + w.y * c20 + w.z * c22 + w.w * c02)\n"
            + "            / max(sumW, 0.001);\n"
            + "    vec3 e15 = mix(corner, mixed, 0.5);\n"
            + "    float m = max(abs(fp.x), abs(fp.y)) * 2.0;\n"
            + "    float n = min(abs(fp.x), abs(fp.y)) * 2.0;\n"
            + "    vec3 res = m > 0.5 ? (n > 0.5 ? e15 : e11) : c11;\n"
            + "    gl_FragColor = vec4(contrast(res * uBrightness), 1.0);\n"
            + "}\n";

    /*
     * 2xBR/4xBR: the classic xBR corner rule. When the left and right
     * neighbors match each other but not the center, and the diagonal chain
     * through the center continues, the corner color bleeds halfway in. 4XBR
     * spreads the two blend colors over a 4x4 sub-pixel grid.
     */
    private static final String XBR_COMMON = ""
            + "float luma(vec3 c) { return dot(c, vec3(0.299, 0.587, 0.114)); }\n"
            + "vec3 fetch(vec2 off) { return texture2D(uTex, vTexCoord + off / uTexSize).rgb; }\n"
            + "bool edge(vec3 e, vec3 a1, vec3 a2, vec3 b1, vec3 b2) {\n"
            + "    return (luma(a1) == luma(b1) && luma(a1) != luma(e))\n"
            + "        && ((luma(e) == luma(a2) && luma(a1) == luma(b2))\n"
            + "         || (luma(e) == luma(b2) && luma(a1) == luma(a2)));\n"
            + "}\n";

    private static final String XBR2 = PRELUDE + XBR_COMMON
            + "void main() {\n"
            + "    vec3 e = texture2D(uTex, vTexCoord).rgb;\n"
            + "    vec3 b = fetch(vec2(0.0, -1.0));\n"
            + "    vec3 d = fetch(vec2(-1.0, 0.0));\n"
            + "    vec3 f = fetch(vec2(1.0, 0.0));\n"
            + "    vec3 h = fetch(vec2(0.0, 1.0));\n"
            + "    vec3 g = fetch(vec2(-1.0, 1.0));\n"
            + "    vec3 c = fetch(vec2(-1.0, -1.0));\n"
            + "    vec3 i = fetch(vec2(1.0, 1.0));\n"
            + "    float blend = (edge(e, h, g, f, i) || edge(e, h, c, f, b)) ? 0.5 : 0.0;\n"
            + "    vec3 res = mix(e, f, blend);\n"
            + "    gl_FragColor = vec4(contrast(res * uBrightness), 1.0);\n"
            + "}\n";

    private static final String XBR4 = PRELUDE + XBR_COMMON
            + "void main() {\n"
            + "    vec3 e = texture2D(uTex, vTexCoord).rgb;\n"
            + "    vec3 b = fetch(vec2(0.0, -1.0));\n"
            + "    vec3 d = fetch(vec2(-1.0, 0.0));\n"
            + "    vec3 f = fetch(vec2(1.0, 0.0));\n"
            + "    vec3 h = fetch(vec2(0.0, 1.0));\n"
            + "    vec3 g = fetch(vec2(-1.0, 1.0));\n"
            + "    vec3 c = fetch(vec2(-1.0, -1.0));\n"
            + "    vec3 i = fetch(vec2(1.0, 1.0));\n"
            + "    vec3 e11 = e;\n"
            + "    vec3 e15 = e;\n"
            + "    if (edge(e, h, g, f, i) || edge(e, h, c, f, b)) {\n"
            + "        e11 = mix(e, f, 0.5);\n"
            + "        e15 = f;\n"
            + "    }\n"
            + "    vec2 fp = abs(fract(vTexCoord * uTexSize) - 0.5) * 2.0;\n"
            + "    float outer = max(fp.x, fp.y);\n"
            + "    float inner = min(fp.x, fp.y);\n"
            + "    vec3 res = outer > 0.5 ? (inner > 0.5 ? e15 : e11) : e;\n"
            + "    gl_FragColor = vec4(contrast(res * uBrightness), 1.0);\n"
            + "}\n";

    /*
     * LCD ghosting: blends the current frame with the previous seven, each
     * weighed by a power of the response time, the way a slow LCD panel
     * smears moving sprites.
     */
    private static final String MOTION_BLUR = PRELUDE
            + "uniform sampler2D uHistory0;\n"
            + "uniform sampler2D uHistory1;\n"
            + "uniform sampler2D uHistory2;\n"
            + "uniform sampler2D uHistory3;\n"
            + "uniform sampler2D uHistory4;\n"
            + "uniform sampler2D uHistory5;\n"
            + "uniform sampler2D uHistory6;\n"
            + "const float RT = 0.444;\n"
            + "void main() {\n"
            + "    vec4 color = texture2D(uTex, vTexCoord);\n"
            + "    color += (texture2D(uHistory0, vTexCoord) - color) * RT;\n"
            + "    color += (texture2D(uHistory1, vTexCoord) - color) * pow(RT, 2.0);\n"
            + "    color += (texture2D(uHistory2, vTexCoord) - color) * pow(RT, 3.0);\n"
            + "    color += (texture2D(uHistory3, vTexCoord) - color) * pow(RT, 4.0);\n"
            + "    color += (texture2D(uHistory4, vTexCoord) - color) * pow(RT, 5.0);\n"
            + "    color += (texture2D(uHistory5, vTexCoord) - color) * pow(RT, 6.0);\n"
            + "    color += (texture2D(uHistory6, vTexCoord) - color) * pow(RT, 7.0);\n"
            + "    gl_FragColor = vec4(contrast(color.rgb * uBrightness), 1.0);\n"
            + "}\n";

    /* Dot matrix, adapted from Themaister's public domain libretro shader. */
    private static final String DOT = PRELUDE
            + "const float GAMMA = 2.4;\n"
            + "const float SHINE = 0.05;\n"
            + "const float BLEND = 0.65;\n"
            + "float bloom(vec3 color) {\n"
            + "    float bright = dot(color, vec3(0.30, 0.59, 0.11));\n"
            + "    return mix(1.0 + SHINE, 1.0 - SHINE, bright);\n"
            + "}\n"
            + "vec3 tap(vec2 pixelNo, float dx, float dy, vec3 color) {\n"
            + "    vec2 delta = fract(pixelNo) - vec2(dx, dy) - vec2(0.5);\n"
            + "    return color * exp(-GAMMA * dot(delta, delta) * bloom(color));\n"
            + "}\n"
            + "void main() {\n"
            + "    vec2 pixelNo = vTexCoord * uTexSize;\n"
            + "    vec2 d = 1.0 / uTexSize;\n"
            + "    vec3 mid = tap(pixelNo, 0.0, 0.0, texture2D(uTex, vTexCoord).rgb);\n"
            + "    vec3 color = vec3(0.0);\n"
            + "    color += tap(pixelNo, -1.0, -1.0, texture2D(uTex, vTexCoord + vec2(-d.x, -d.y)).rgb);\n"
            + "    color += tap(pixelNo, 0.0, -1.0, texture2D(uTex, vTexCoord + vec2(0.0, -d.y)).rgb);\n"
            + "    color += tap(pixelNo, 1.0, -1.0, texture2D(uTex, vTexCoord + vec2(d.x, -d.y)).rgb);\n"
            + "    color += tap(pixelNo, -1.0, 0.0, texture2D(uTex, vTexCoord + vec2(-d.x, 0.0)).rgb);\n"
            + "    color += mid;\n"
            + "    color += tap(pixelNo, 1.0, 0.0, texture2D(uTex, vTexCoord + vec2(d.x, 0.0)).rgb);\n"
            + "    color += tap(pixelNo, -1.0, 1.0, texture2D(uTex, vTexCoord + vec2(-d.x, d.y)).rgb);\n"
            + "    color += tap(pixelNo, 0.0, 1.0, texture2D(uTex, vTexCoord + vec2(0.0, d.y)).rgb);\n"
            + "    color += tap(pixelNo, 1.0, 1.0, texture2D(uTex, vTexCoord + vec2(d.x, d.y)).rgb);\n"
            + "    gl_FragColor = vec4(contrast(mix(1.2 * mid, color, BLEND) * uBrightness), 1.0);\n"
            + "}\n";

    /* LCD3x, adapted from Gigaherz's public domain libretro shader. */
    private static final String LCD3X = PRELUDE
            + "const float BRIGHTEN_SCAN = 16.0;\n"
            + "const float BRIGHTEN_LCD = 4.0;\n"
            + "void main() {\n"
            + "    vec2 angle = vTexCoord * 6.28318530 * uTexSize;\n"
            + "    vec3 offsets = 3.14159265 * vec3(0.5, 0.5 - 2.0 / 3.0, 0.5 - 4.0 / 3.0);\n"
            + "    float y = (BRIGHTEN_SCAN + sin(angle.y)) / (BRIGHTEN_SCAN + 1.0);\n"
            + "    vec3 x = (BRIGHTEN_LCD + sin(angle.x + offsets)) / (BRIGHTEN_LCD + 1.0);\n"
            + "    gl_FragColor = vec4(contrast(y * x * texture2D(uTex, vTexCoord).rgb * uBrightness), 1.0);\n"
            + "}\n";

    /* Scanlines, adapted from Themaister's public domain libretro shader. */
    private static final String SCANLINES = PRELUDE
            + "const float BASE = 0.95;\n"
            + "const vec2 SINE = vec2(0.05, 0.15);\n"
            + "void main() {\n"
            + "    vec4 c = texture2D(uTex, vTexCoord);\n"
            + "    // Vertical bands follow the screen columns; the horizontal\n"
            + "    // sine puts one dark band on every source row.\n"
            + "    vec2 omega = vec2(3.1415 * uOutSize.x, 2.0 * 3.1415 * uTexSize.y);\n"
            + "    vec3 scan = c.rgb * (BASE + dot(SINE * sin(vTexCoord * omega), vec2(1.0)));\n"
            + "    gl_FragColor = vec4(contrast(clamp(scan, 0.0, 1.0) * uBrightness), 1.0);\n"
            + "}\n";

    /*
     * Sharp bilinear after Iñigo Quílez's "Improved texture interpolation":
     * a quintic ease snaps linear sampling back to the texel centers, giving
     * clean pixels while keeping non-integer scaling smooth.
     */
    private static final String QUILEZ = PRELUDE
            + "void main() {\n"
            + "    vec2 p = vTexCoord * uTexSize + 0.5;\n"
            + "    vec2 i = floor(p);\n"
            + "    vec2 f = p - i;\n"
            + "    f = f * f * f * (f * (f * 6.0 - 15.0) + 10.0);\n"
            + "    p = i + f;\n"
            + "    vec3 c = texture2D(uTex, (p - 0.5) / uTexSize).rgb;\n"
            + "    gl_FragColor = vec4(contrast(c * uBrightness), 1.0);\n"
            + "}\n";

    // == External shader adaptation ========================================

    /**
     * Contract prelude for user-installed shaders: declares the uniforms and
     * varying the renderer feeds, ahead of the user's own body.
     */
    private static final String EXTERNAL_PRELUDE = ""
            + "#ifdef GL_FRAGMENT_PRECISION_HIGH\n"
            + "precision highp float;\n"
            + "#else\n"
            + "precision mediump float;\n"
            + "#endif\n"
            + "uniform sampler2D uTex;\n"
            + "uniform vec2 uTexSize;\n"
            + "uniform vec2 uOutSize;\n"
            + "uniform float uBrightness;\n"
            + "uniform float uContrast;\n"
            + "varying vec2 vTexCoord;\n";

    private static final Pattern P_VERSION = Pattern.compile("^\\s*#version.*");
    private static final Pattern P_ATTRIBUTE = Pattern.compile("^\\s*attribute\\b.*");
    private static final Pattern P_VARYING_TEX = Pattern.compile("^\\s*varying\\b.*\\bvTexCoord\\b.*");
    private static final Pattern P_UNIFORM = Pattern.compile("^\\s*uniform\\b.*");
    private static final Pattern P_UNIFORM_NAME = Pattern.compile("^\\s*uniform\\s+\\w+\\s+(\\w+)\\s*.*");
    private static final Pattern P_SAMPLER = Pattern.compile("^\\s*uniform\\s+sampler2D\\s+(\\w+)\\s*;");
    private static final Pattern P_DEFINE = Pattern.compile("^\\s*#define\\s+(\\w+)");

    /** Uniforms the renderer feeds itself; user declarations of them are dropped. */
    private static final String[] OUR_UNIFORMS = {"uTex", "uTexSize", "uOutSize", "uBrightness", "uContrast", "uScanlines"};

    /**
     * Adapts a user-provided single-pass GLSL fragment shader to the renderer's
     * uniform/varying contract. Duplicate declarations of our symbols and
     * desktop-only lines are dropped, and the common RetroArch identifiers
     * (TEXTURE/TextureSize/OutputSize/InputSize/vTexCoord/COMPAT_TEXTURE) are
     * aliased with #defines so stock single-pass shaders compile as-is. The
     * result compiles like any built-in filter; failure falls back to the
     * plain blit.
     */
    static String adaptExternal(String source) {
        if (source == null || source.trim().isEmpty()) {
            return null;
        }
        String[] lines = source.replace("\r\n", "\n").replace('\r', '\n').split("\n", -1);
        StringBuilder body = new StringBuilder();
        List<String> aliases = new ArrayList<>();
        for (String line : lines) {
            if (P_VERSION.matcher(line).matches() || P_ATTRIBUTE.matcher(line).matches()
                    || P_VARYING_TEX.matcher(line).matches()) {
                continue;
            }
            if (P_UNIFORM.matcher(line).matches()) {
                String name = null;
                Matcher nameMatch = P_UNIFORM_NAME.matcher(line);
                if (nameMatch.matches()) {
                    name = nameMatch.group(1);
                }
                if (name == null) {
                    body.append(line).append('\n');
                    continue;
                }
                if (isOurs(name)) {
                    continue; // ours wins; the renderer sets the same value
                }
                Matcher sampler = P_SAMPLER.matcher(line);
                if (sampler.matches() && !sampler.group(1).equals("uTex")) {
                    // Their sampler is never bound; point the name at ours.
                    aliases.add("#define " + sampler.group(1) + " uTex");
                    continue;
                }
                String target = vec2Alias(name);
                if (target != null) {
                    aliases.add("#define " + name + " " + target);
                    continue;
                }
                body.append(line).append('\n');
                continue;
            }
            body.append(line).append('\n');
        }
        String rest = body.toString();
        StringBuilder defines = new StringBuilder();
        for (String alias : aliases) {
            String name = alias.substring(8, alias.indexOf(' ', 8));
            if (!rest.contains("#define " + name) && usesIdentifier(rest, name)) {
                defines.append(alias).append('\n');
            }
        }
        // RetroArch compat macro, aliased only when the body uses it.
        if (usesIdentifier(rest, "COMPAT_TEXTURE") && !rest.contains("#define COMPAT_TEXTURE")) {
            defines.append("#define COMPAT_TEXTURE(a,b) texture2D(a,b)\n");
        }
        if (usesCall(rest, "texture") && !rest.contains("#define texture")) {
            defines.append("#define texture texture2D\n");
        }
        return EXTERNAL_PRELUDE + defines + rest;
    }

    private static boolean isOurs(String name) {
        for (String ours : OUR_UNIFORMS) {
            if (ours.equals(name)) {
                return true;
            }
        }
        return false;
    }

    /** Maps RetroArch size uniforms onto ours; null keeps the declaration. */
    private static String vec2Alias(String name) {
        switch (name) {
            case "TextureSize":
            case "InputSize":
            case "uInputSize":
            case "textureSize":
                return "uTexSize";
            case "OutputSize":
            case "uOutputSize":
            case "OutSize":
                return "uOutSize";
            default:
                return null;
        }
    }

    /** Word-boundary search so COMPAT_TEXTURE never counts as TEXTURE. */
    private static boolean usesIdentifier(String source, String name) {
        Matcher matcher = Pattern.compile("\\b" + Pattern.quote(name) + "\\b").matcher(source);
        return matcher.find();
    }

    private static boolean usesCall(String source, String name) {
        Matcher matcher = Pattern.compile("\\b" + Pattern.quote(name) + "\\s*\\(").matcher(source);
        return matcher.find();
    }
}
