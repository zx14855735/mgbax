/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "ExternalShader.h"

#include <QDir>
#include <QFile>
#include <QFileInfo>
#include <QRegularExpression>
#include <QSet>
#include <QTextStream>

using namespace QGBA;

namespace {

const QStringList OUR_UNIFORMS = {
	QStringLiteral("tex"), QStringLiteral("texSize"), QStringLiteral("texCoord"), QStringLiteral("outputSize")
};

/** Maps RetroArch size uniforms onto ours; empty keeps the declaration. */
QString vec2Alias(const QString& name) {
	if (name == QStringLiteral("TextureSize") || name == QStringLiteral("InputSize")
	    || name == QStringLiteral("uInputSize") || name == QStringLiteral("textureSize")) {
		return QStringLiteral("texSize");
	}
	if (name == QStringLiteral("OutputSize") || name == QStringLiteral("uOutputSize")
	    || name == QStringLiteral("OutSize")) {
		return QStringLiteral("outputSize");
	}
	return QString();
}

bool usesIdentifier(const QString& source, const QString& name) {
	static const QRegularExpression pattern(QStringLiteral("\\b%1\\b").arg(QRegularExpression::escape(name)));
	return pattern.match(source).hasMatch();
}

bool usesCall(const QString& source, const QString& name) {
	static const QRegularExpression version(QStringLiteral("\\b%1\\s*\\(").arg(QRegularExpression::escape(name)));
	return version.match(source).hasMatch();
}

bool matches(const QRegularExpression& re, const QString& line) {
	return re.match(line).hasMatch();
}

}

namespace QGBA {
namespace ExternalShader {

QString adaptExternal(const QString& sourceIn) {
	if (sourceIn.trimmed().isEmpty()) {
		return QString();
	}
	QString source = sourceIn;
	source.replace(QStringLiteral("\r\n"), QStringLiteral("\n")).replace('\r', '\n');
	QStringList lines = source.split('\n');

	static const QRegularExpression pVersion(QStringLiteral("^\\s*#version.*"));
	static const QRegularExpression pAttribute(QStringLiteral("^\\s*attribute\\b.*"));
	static const QRegularExpression pVaryingTex(QStringLiteral("^\\s*varying\\b.*\\bvTexCoord\\b.*"));
	static const QRegularExpression pPragmaVertex(QStringLiteral("^\\s*#pragma\\s+stage\\s+vertex.*"));
	static const QRegularExpression pUniform(QStringLiteral("^\\s*uniform\\b.*"));
	static const QRegularExpression pUniformName(QStringLiteral("^\\s*uniform\\s+\\w+\\s+(\\w+)\\s*.*"));
	static const QRegularExpression pSampler(QStringLiteral("^\\s*uniform\\s+sampler2D\\s+(\\w+)\\s*;"));
	static const QRegularExpression pDefine(QStringLiteral("^\\s*#define\\s+(\\w+)"));

	// A single-file RetroArch .glsl carries both stages; keep the fragment one.
	int fragmentStage = -1;
	for (int i = 0; i < lines.size(); i++) {
		if (lines[i].contains(QStringLiteral("#pragma stage fragment"))) {
			fragmentStage = i;
		}
	}
	if (fragmentStage >= 0) {
		lines = lines.mid(fragmentStage + 1);
	}

	QStringList body;
	QStringList aliases;
	for (const QString& line : lines) {
		if (matches(pVersion, line) || matches(pAttribute, line) || matches(pVaryingTex, line)
		    || matches(pPragmaVertex, line)) {
			continue;
		}
		if (matches(pUniform, line)) {
			QRegularExpressionMatch nameMatch = pUniformName.match(line);
			QString name = nameMatch.hasMatch() ? nameMatch.captured(1) : QString();
			if (name.isEmpty()) {
				body.append(line);
				continue;
			}
			if (OUR_UNIFORMS.contains(name)) {
				continue; // ours wins; the renderer sets the same value
			}
			QRegularExpressionMatch sampler = pSampler.match(line);
			if (sampler.hasMatch() && sampler.captured(1) != QStringLiteral("tex")) {
				// Their sampler is never bound; point the name at ours.
				aliases.append(QStringLiteral("#define %1 tex").arg(sampler.captured(1)));
				continue;
			}
			QString target = vec2Alias(name);
			if (!target.isEmpty()) {
				aliases.append(QStringLiteral("#define %1 %2").arg(name, target));
				continue;
			}
			body.append(line);
			continue;
		}
		body.append(line);
	}
	QString rest = body.join('\n') + '\n';
	QStringList defines;
	for (const QString& alias : aliases) {
		QString name = alias.mid(8, alias.indexOf(' ', 8) - 8);
		if (!rest.contains(QStringLiteral("#define ") + name) && usesIdentifier(rest, name)) {
			defines.append(alias);
		}
	}
	// The vertex shader is ours, so the RetroArch varying name maps onto it.
	if (usesIdentifier(rest, QStringLiteral("vTexCoord")) && !rest.contains(QStringLiteral("#define vTexCoord"))) {
		defines.append(QStringLiteral("#define vTexCoord texCoord"));
	}
	// RetroArch compat macro, aliased only when the body uses it.
	if (usesIdentifier(rest, QStringLiteral("COMPAT_TEXTURE")) && !rest.contains(QStringLiteral("#define COMPAT_TEXTURE"))) {
		defines.append(QStringLiteral("#define COMPAT_TEXTURE(a,b) texture2D(a,b)"));
	}
	if (usesCall(rest, QStringLiteral("texture")) && !rest.contains(QStringLiteral("#define texture"))) {
		defines.append(QStringLiteral("#define texture texture2D"));
	}

	QString prelude = QStringLiteral(
	    "#ifdef GL_FRAGMENT_PRECISION_HIGH\n"
	    "precision highp float;\n"
	    "#else\n"
	    "precision mediump float;\n"
	    "#endif\n"
	    "uniform sampler2D tex;\n"
	    "uniform vec2 texSize;\n"
	    "uniform vec2 outputSize;\n"
	    "varying vec2 texCoord;\n");
	return prelude + defines.join('\n') + (defines.isEmpty() ? QString() : QStringLiteral("\n")) + rest;
}

bool convert(const QString& glslPath, const QString& outDir, QString* error) {
	QFile input(glslPath);
	if (!input.open(QIODevice::ReadOnly | QIODevice::Text)) {
		if (error) {
			*error = QStringLiteral("无法读取 %1").arg(glslPath);
		}
		return false;
	}
	QString source = QString::fromUtf8(input.readAll());
	QString adapted = adaptExternal(source);
	if (adapted.isEmpty()) {
		if (error) {
			*error = QStringLiteral("着色器内容为空");
		}
		return false;
	}
	QString name = QFileInfo(glslPath).completeBaseName();
	if (name.isEmpty()) {
		name = QStringLiteral("external");
	}
	QDir dir(outDir);
	if (!dir.mkpath(".")) {
		if (error) {
			*error = QStringLiteral("无法创建目录 %1").arg(outDir);
		}
		return false;
	}
	QFile fs(dir.absoluteFilePath(QStringLiteral("shader.fs")));
	if (!fs.open(QIODevice::WriteOnly | QIODevice::Truncate | QIODevice::Text)) {
		if (error) {
			*error = QStringLiteral("无法写入 shader.fs");
		}
		return false;
	}
	fs.write(adapted.toUtf8());
	fs.close();

	QString manifest = QStringLiteral(
	    "[shader]\n"
	    "name=%1\n"
	    "author=External\n"
	    "description=Imported from .glsl\n"
	    "passes=1\n"
	    "\n"
	    "[pass.0]\n"
	    "fragmentShader=shader.fs\n"
	    "blend=0\n"
	    "width=-2\n"
	    "height=-2\n").arg(name);
	QFile ini(dir.absoluteFilePath(QStringLiteral("manifest.ini")));
	if (!ini.open(QIODevice::WriteOnly | QIODevice::Truncate | QIODevice::Text)) {
		if (error) {
			*error = QStringLiteral("无法写入 manifest.ini");
		}
		return false;
	}
	ini.write(manifest.toUtf8());
	ini.close();
	return true;
}

}
}
