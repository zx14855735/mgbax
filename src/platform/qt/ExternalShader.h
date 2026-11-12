/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QString>

namespace QGBA {

/**
 * Loads a user-supplied single-pass GLSL fragment shader (RetroArch-style
 * .glsl), a Qt port of the Android Shaders.adaptExternal. The body is
 * rewritten onto mGBA's native shader contract (tex / texSize / texCoord /
 * outputSize) and wrapped as a mGBA `.shader` directory (manifest.ini +
 * shader.fs), so the regular Display::setShaders pipeline can load it - and
 * so the converted directory can be persisted and reloaded on restart.
 */
namespace ExternalShader {

/**
 * Converts `glslPath` into a `.shader` directory at `outDir`. Returns false
 * and fills `error` when the input cannot be read or has no fragment stage.
 */
bool convert(const QString& glslPath, const QString& outDir, QString* error);

/**
 * Rewrites a user-provided single-pass GLSL fragment shader onto mGBA's
 * uniform/varying contract. Duplicate declarations of our symbols and
 * desktop-only lines are dropped, and the common RetroArch identifiers
 * (TEXTURE/TextureSize/OutputSize/vTexCoord/COMPAT_TEXTURE) are aliased with
 * #defines so stock single-pass shaders compile as-is.
 */
QString adaptExternal(const QString& source);

}
}
