/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

/*
 * Metal sources for the screen filters, a port of the Android GLSL ES
 * (Shaders.java). Every filter is a single fragment pass over the native
 * frame evaluated at screen resolution; the vertex stage is shared.
 *
 * The LCD-style filters (DOT, LCD3X, SCANLINES) adapt public-domain
 * libretro shaders by Themaister and Gigaherz. The interpolation filters
 * (HQ2X, HQ4X, XBR2, XBR4) implement the well-known published algorithms
 * (luma-equality edge rules) written from scratch; QUILEZ is the sharp
 * bilinear scheme from Iñigo Quílez's "Improved texture interpolation".
 * The remaining color/blur filters are original.
 */

#include <metal_stdlib>
using namespace metal;

struct FilterUniforms {
    float2 texSize;
    float2 outSize;
    float brightness;
    /* Contrast around mid gray; 1 leaves the colors alone. */
    float contrast;
    /* Passthrough only: the Canvas scanline overlay flag, 0 elsewhere. */
    float scanlines;
};

struct FilterVaryings {
    float4 position [[position]];
    float2 texCoord;
};

vertex FilterVaryings filterVertex(uint vid [[vertex_id]]) {
    // Full-screen strip; uv (0,0) is the frame's top row, matching Metal's
    // top-left texture origin so the GL sources translate 1:1.
    const float2 positions[4] = { float2(-1.0, 1.0), float2(1.0, 1.0), float2(-1.0, -1.0), float2(1.0, -1.0) };
    const float2 coords[4] = { float2(0.0, 0.0), float2(1.0, 0.0), float2(0.0, 1.0), float2(1.0, 1.0) };
    FilterVaryings out;
    out.position = float4(positions[vid], 0.0, 1.0);
    out.texCoord = coords[vid];
    return out;
}

static inline float lumaOf(float3 c) {
    return dot(c, float3(0.299, 0.587, 0.114));
}

/* Scales around mid gray, the same matrix the Android ColorMatrix uses. */
static inline float3 applyContrast(float3 c, float amount) {
    return saturate((c - 0.5) * amount + 0.5);
}

static inline float3 fetchTex(texture2d<float> tex, sampler s, float2 uv, float2 off, float2 texSize) {
    return tex.sample(s, uv + off / texSize).rgb;
}

/*
 * Plain blit used when nothing (or a broken program) filters the frame and a
 * capture must match what the player sees. uScanlines reproduces the software
 * scanline overlay by darkening every second output row.
 */
fragment float4 filterPassthrough(FilterVaryings in [[stage_in]],
                                  texture2d<float> uTex [[texture(0)]],
                                  sampler s [[sampler(0)]],
                                  constant FilterUniforms &u [[buffer(0)]]) {
    float3 c = uTex.sample(s, in.texCoord).rgb;
    float scan = 1.0 - 0.4 * u.scanlines * (1.0 - step(0.5, fmod(floor(in.position.y), 2.0)));
    return float4(applyContrast(c * scan * u.brightness, u.contrast), 1.0);
}

// 1: GBA 色彩
fragment float4 filterGbaColor(FilterVaryings in [[stage_in]],
                               texture2d<float> uTex [[texture(0)]],
                               sampler s [[sampler(0)]],
                               constant FilterUniforms &u [[buffer(0)]]) {
    float3 c = uTex.sample(s, in.texCoord).rgb;
    c = pow(c, float3(2.2));
    // GBA LCD tone matrix: muted primaries with slight bleed.
    float3x3 tone = float3x3(float3(0.82, 0.24, -0.06),
                             float3(0.125, 0.665, 0.21),
                             float3(0.195, 0.075, 0.73));
    c = saturate(tone * c) * 0.94;
    return float4(applyContrast(pow(c, float3(1.0 / 2.2)) * u.brightness, u.contrast), 1.0);
}

// 2: 灰度
fragment float4 filterGrayscale(FilterVaryings in [[stage_in]],
                                texture2d<float> uTex [[texture(0)]],
                                sampler s [[sampler(0)]],
                                constant FilterUniforms &u [[buffer(0)]]) {
    float3 c = uTex.sample(s, in.texCoord).rgb;
    float g = dot(c, float3(0.299, 0.587, 0.114));
    return float4(applyContrast(float3(g) * u.brightness, u.contrast), 1.0);
}

/*
 * HQ2x/HQ4x: the classic edge-direction blending. The 3x3 neighborhood is
 * compared by luminance; the four diagonal gradients decide an intermediate
 * color, which is then softened toward the cross neighbors. HQ4X adds the
 * 4x4 sub-pixel select on top, giving corner pixels a crisper diagonal.
 */

// 3: HQ2x
fragment float4 filterHq2x(FilterVaryings in [[stage_in]],
                           texture2d<float> uTex [[texture(0)]],
                           sampler s [[sampler(0)]],
                           constant FilterUniforms &u [[buffer(0)]]) {
    float3 c11 = uTex.sample(s, in.texCoord).rgb;
    float3 c01 = fetchTex(uTex, s, in.texCoord, float2(-1.0, 0.0), u.texSize);
    float3 c21 = fetchTex(uTex, s, in.texCoord, float2(1.0, 0.0), u.texSize);
    float3 c10 = fetchTex(uTex, s, in.texCoord, float2(0.0, -1.0), u.texSize);
    float3 c12 = fetchTex(uTex, s, in.texCoord, float2(0.0, 1.0), u.texSize);
    float3 c00 = fetchTex(uTex, s, in.texCoord, float2(-1.0, -1.0), u.texSize);
    float3 c20 = fetchTex(uTex, s, in.texCoord, float2(1.0, -1.0), u.texSize);
    float3 c02 = fetchTex(uTex, s, in.texCoord, float2(-1.0, 1.0), u.texSize);
    float3 c22 = fetchTex(uTex, s, in.texCoord, float2(1.0, 1.0), u.texSize);
    float dMain = lumaOf(abs(c00 - c22));
    float dAnti = lumaOf(abs(c02 - c20));
    float4 w;
    w.x = lumaOf(abs(c22 - c11)) * dAnti;
    w.y = lumaOf(abs(c02 - c11)) * dMain;
    w.z = lumaOf(abs(c00 - c11)) * dAnti;
    w.w = lumaOf(abs(c20 - c11)) * dMain;
    float sumW = dot(w, float4(1.0));
    float peak = max(max(w.x, w.y), max(w.z, w.w)) + 0.001;
    float3 mixed = (w.x * c00 + w.y * c20 + w.z * c22 + w.w * c02 + peak * c11) / (sumW + peak);
    // Neighbors that look like the blend absorb it; different ones let go.
    float4 nw;
    nw.x = clamp(0.4 - 0.45 * lumaOf(abs(mixed - c10)), 0.0, 0.4);
    nw.y = clamp(0.4 - 0.45 * lumaOf(abs(mixed - c21)), 0.0, 0.4);
    nw.z = clamp(0.4 - 0.45 * lumaOf(abs(mixed - c12)), 0.0, 0.4);
    nw.w = clamp(0.4 - 0.45 * lumaOf(abs(mixed - c01)), 0.0, 0.4);
    float3 result = nw.x * c10 + nw.y * c21 + nw.z * c12 + nw.w * c01
            + (1.0 - dot(nw, float4(1.0))) * mixed;
    return float4(applyContrast(result * u.brightness, u.contrast), 1.0);
}

// 4: HQ4x
fragment float4 filterHq4x(FilterVaryings in [[stage_in]],
                           texture2d<float> uTex [[texture(0)]],
                           sampler s [[sampler(0)]],
                           constant FilterUniforms &u [[buffer(0)]]) {
    float3 c11 = uTex.sample(s, in.texCoord).rgb;
    float3 c00 = fetchTex(uTex, s, in.texCoord, float2(-1.0, -1.0), u.texSize);
    float3 c20 = fetchTex(uTex, s, in.texCoord, float2(1.0, -1.0), u.texSize);
    float3 c02 = fetchTex(uTex, s, in.texCoord, float2(-1.0, 1.0), u.texSize);
    float3 c22 = fetchTex(uTex, s, in.texCoord, float2(1.0, 1.0), u.texSize);
    float dMain = lumaOf(abs(c00 - c22));
    float dAnti = lumaOf(abs(c02 - c20));
    float4 w;
    w.x = lumaOf(abs(c22 - c11)) * dAnti;
    w.y = lumaOf(abs(c02 - c11)) * dMain;
    w.z = lumaOf(abs(c00 - c11)) * dAnti;
    w.w = lumaOf(abs(c20 - c11)) * dMain;
    float sumW = dot(w, float4(1.0));
    float peak = max(max(w.x, w.y), max(w.z, w.w)) + 0.001;
    float3 mixed = (w.x * c00 + w.y * c20 + w.z * c22 + w.w * c02 + peak * c11) / (sumW + peak);
    // Where we are inside the texel picks between the texel color,
    // the edge blend and the diagonal continuation.
    float2 fp = fract(in.texCoord * u.texSize) - 0.5;
    float3 e11 = mix(mixed, c11, clamp((abs(fp.x) + abs(fp.y)) * 2.0, 0.0, 1.0));
    float3 corner = (w.x * c00 + w.y * c20 + w.z * c22 + w.w * c02) / max(sumW, 0.001);
    float3 e15 = mix(corner, mixed, 0.5);
    float m = max(abs(fp.x), abs(fp.y)) * 2.0;
    float n = min(abs(fp.x), abs(fp.y)) * 2.0;
    float3 result = m > 0.5 ? (n > 0.5 ? e15 : e11) : c11;
    return float4(applyContrast(result * u.brightness, u.contrast), 1.0);
}

/*
 * 2xBR/4xBR: the classic xBR corner rule. When the left and right
 * neighbors match each other but not the center, and the diagonal chain
 * through the center continues, the corner color bleeds halfway in. 4XBR
 * spreads the two blend colors over a 4x4 sub-pixel grid.
 */
static inline bool xbrEdge(float3 e, float3 a1, float3 a2, float3 b1, float3 b2) {
    return (lumaOf(a1) == lumaOf(b1) && lumaOf(a1) != lumaOf(e))
        && ((lumaOf(e) == lumaOf(a2) && lumaOf(a1) == lumaOf(b2))
         || (lumaOf(e) == lumaOf(b2) && lumaOf(a1) == lumaOf(a2)));
}

// 5: 2xBR
fragment float4 filterXbr2(FilterVaryings in [[stage_in]],
                           texture2d<float> uTex [[texture(0)]],
                           sampler s [[sampler(0)]],
                           constant FilterUniforms &u [[buffer(0)]]) {
    float3 e = uTex.sample(s, in.texCoord).rgb;
    float3 b = fetchTex(uTex, s, in.texCoord, float2(0.0, -1.0), u.texSize);
    float3 d = fetchTex(uTex, s, in.texCoord, float2(-1.0, 0.0), u.texSize);
    float3 f = fetchTex(uTex, s, in.texCoord, float2(1.0, 0.0), u.texSize);
    float3 h = fetchTex(uTex, s, in.texCoord, float2(0.0, 1.0), u.texSize);
    float3 g = fetchTex(uTex, s, in.texCoord, float2(-1.0, 1.0), u.texSize);
    float3 c = fetchTex(uTex, s, in.texCoord, float2(-1.0, -1.0), u.texSize);
    float3 i = fetchTex(uTex, s, in.texCoord, float2(1.0, 1.0), u.texSize);
    float blend = (xbrEdge(e, h, g, f, i) || xbrEdge(e, h, c, f, b)) ? 0.5 : 0.0;
    float3 result = mix(e, f, blend);
    return float4(applyContrast(result * u.brightness, u.contrast), 1.0);
}

// 6: 4xBR
fragment float4 filterXbr4(FilterVaryings in [[stage_in]],
                           texture2d<float> uTex [[texture(0)]],
                           sampler s [[sampler(0)]],
                           constant FilterUniforms &u [[buffer(0)]]) {
    float3 e = uTex.sample(s, in.texCoord).rgb;
    float3 b = fetchTex(uTex, s, in.texCoord, float2(0.0, -1.0), u.texSize);
    float3 d = fetchTex(uTex, s, in.texCoord, float2(-1.0, 0.0), u.texSize);
    float3 f = fetchTex(uTex, s, in.texCoord, float2(1.0, 0.0), u.texSize);
    float3 h = fetchTex(uTex, s, in.texCoord, float2(0.0, 1.0), u.texSize);
    float3 g = fetchTex(uTex, s, in.texCoord, float2(-1.0, 1.0), u.texSize);
    float3 c = fetchTex(uTex, s, in.texCoord, float2(-1.0, -1.0), u.texSize);
    float3 i = fetchTex(uTex, s, in.texCoord, float2(1.0, 1.0), u.texSize);
    float3 e11 = e;
    float3 e15 = e;
    if (xbrEdge(e, h, g, f, i) || xbrEdge(e, h, c, f, b)) {
        e11 = mix(e, f, 0.5);
        e15 = f;
    }
    float2 fp = abs(fract(in.texCoord * u.texSize) - 0.5) * 2.0;
    float outer = max(fp.x, fp.y);
    float inner = min(fp.x, fp.y);
    float3 result = outer > 0.5 ? (inner > 0.5 ? e15 : e11) : e;
    return float4(applyContrast(result * u.brightness, u.contrast), 1.0);
}

/*
 * LCD ghosting: blends the current frame with the previous seven, each
 * weighed by a power of the response time, the way a slow LCD panel
 * smears moving sprites.
 */

// 7: 残影
fragment float4 filterMotionBlur(FilterVaryings in [[stage_in]],
                                 texture2d<float> uTex [[texture(0)]],
                                 texture2d<float> uHistory0 [[texture(1)]],
                                 texture2d<float> uHistory1 [[texture(2)]],
                                 texture2d<float> uHistory2 [[texture(3)]],
                                 texture2d<float> uHistory3 [[texture(4)]],
                                 texture2d<float> uHistory4 [[texture(5)]],
                                 texture2d<float> uHistory5 [[texture(6)]],
                                 texture2d<float> uHistory6 [[texture(7)]],
                                 sampler s [[sampler(0)]],
                                 constant FilterUniforms &u [[buffer(0)]]) {
    const float RT = 0.444;
    float4 color = uTex.sample(s, in.texCoord);
    color += (uHistory0.sample(s, in.texCoord) - color) * RT;
    color += (uHistory1.sample(s, in.texCoord) - color) * pow(RT, 2.0);
    color += (uHistory2.sample(s, in.texCoord) - color) * pow(RT, 3.0);
    color += (uHistory3.sample(s, in.texCoord) - color) * pow(RT, 4.0);
    color += (uHistory4.sample(s, in.texCoord) - color) * pow(RT, 5.0);
    color += (uHistory5.sample(s, in.texCoord) - color) * pow(RT, 6.0);
    color += (uHistory6.sample(s, in.texCoord) - color) * pow(RT, 7.0);
    return float4(applyContrast(color.rgb * u.brightness, u.contrast), 1.0);
}

/* Dot matrix, adapted from Themaister's public domain libretro shader. */

static inline float dotBloom(float3 color) {
    const float SHINE = 0.05;
    float bright = dot(color, float3(0.30, 0.59, 0.11));
    return mix(1.0 + SHINE, 1.0 - SHINE, bright);
}

static inline float3 dotTap(float2 pixelNo, float dx, float dy, float3 color) {
    const float GAMMA = 2.4;
    float2 delta = fract(pixelNo) - float2(dx, dy) - float2(0.5);
    return color * exp(-GAMMA * dot(delta, delta) * dotBloom(color));
}

// 8: 点阵
fragment float4 filterDot(FilterVaryings in [[stage_in]],
                          texture2d<float> uTex [[texture(0)]],
                          sampler s [[sampler(0)]],
                          constant FilterUniforms &u [[buffer(0)]]) {
    const float BLEND = 0.65;
    float2 pixelNo = in.texCoord * u.texSize;
    float2 d = 1.0 / u.texSize;
    float3 mid = dotTap(pixelNo, 0.0, 0.0, uTex.sample(s, in.texCoord).rgb);
    float3 color = float3(0.0);
    color += dotTap(pixelNo, -1.0, -1.0, uTex.sample(s, in.texCoord + float2(-d.x, -d.y)).rgb);
    color += dotTap(pixelNo, 0.0, -1.0, uTex.sample(s, in.texCoord + float2(0.0, -d.y)).rgb);
    color += dotTap(pixelNo, 1.0, -1.0, uTex.sample(s, in.texCoord + float2(d.x, -d.y)).rgb);
    color += dotTap(pixelNo, -1.0, 0.0, uTex.sample(s, in.texCoord + float2(-d.x, 0.0)).rgb);
    color += mid;
    color += dotTap(pixelNo, 1.0, 0.0, uTex.sample(s, in.texCoord + float2(d.x, 0.0)).rgb);
    color += dotTap(pixelNo, -1.0, 1.0, uTex.sample(s, in.texCoord + float2(-d.x, d.y)).rgb);
    color += dotTap(pixelNo, 0.0, 1.0, uTex.sample(s, in.texCoord + float2(0.0, d.y)).rgb);
    color += dotTap(pixelNo, 1.0, 1.0, uTex.sample(s, in.texCoord + float2(d.x, d.y)).rgb);
    return float4(applyContrast(mix(1.2 * mid, color, BLEND) * u.brightness, u.contrast), 1.0);
}

// 9: LCD3x, adapted from Gigaherz's public domain libretro shader.
fragment float4 filterLcd3x(FilterVaryings in [[stage_in]],
                            texture2d<float> uTex [[texture(0)]],
                            sampler s [[sampler(0)]],
                            constant FilterUniforms &u [[buffer(0)]]) {
    const float BRIGHTEN_SCAN = 16.0;
    const float BRIGHTEN_LCD = 4.0;
    float2 angle = in.texCoord * 6.28318530 * u.texSize;
    float3 offsets = 3.14159265 * float3(0.5, 0.5 - 2.0 / 3.0, 0.5 - 4.0 / 3.0);
    float y = (BRIGHTEN_SCAN + sin(angle.y)) / (BRIGHTEN_SCAN + 1.0);
    float3 x = (BRIGHTEN_LCD + sin(angle.x + offsets)) / (BRIGHTEN_LCD + 1.0);
    return float4(applyContrast(y * x * uTex.sample(s, in.texCoord).rgb * u.brightness, u.contrast), 1.0);
}

// 10: 扫描线（平滑）, adapted from Themaister's public domain libretro shader.
fragment float4 filterScanlines(FilterVaryings in [[stage_in]],
                                texture2d<float> uTex [[texture(0)]],
                                sampler s [[sampler(0)]],
                                constant FilterUniforms &u [[buffer(0)]]) {
    const float BASE = 0.95;
    const float2 SINE = float2(0.05, 0.15);
    float4 c = uTex.sample(s, in.texCoord);
    // Vertical bands follow the screen columns; the horizontal
    // sine puts one dark band on every source row.
    float2 omega = float2(3.1415 * u.outSize.x, 2.0 * 3.1415 * u.texSize.y);
    float3 scan = c.rgb * (BASE + dot(SINE * sin(in.texCoord * omega), float2(1.0)));
    return float4(applyContrast(clamp(scan, 0.0, 1.0) * u.brightness, u.contrast), 1.0);
}

/*
 * 11: 锐利插值 — sharp bilinear after Iñigo Quílez's "Improved texture
 * interpolation": a quintic ease snaps linear sampling back to the texel
 * centers, giving clean pixels while keeping non-integer scaling smooth.
 */
fragment float4 filterQuilez(FilterVaryings in [[stage_in]],
                             texture2d<float> uTex [[texture(0)]],
                             sampler s [[sampler(0)]],
                             constant FilterUniforms &u [[buffer(0)]]) {
    float2 p = in.texCoord * u.texSize + 0.5;
    float2 i = floor(p);
    float2 f = p - i;
    f = f * f * f * (f * (f * 6.0 - 15.0) + 10.0);
    p = i + f;
    float3 c = uTex.sample(s, (p - 0.5) / u.texSize).rgb;
    return float4(applyContrast(c * u.brightness, u.contrast), 1.0);
}
