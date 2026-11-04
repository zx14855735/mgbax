/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QString>
#include <QStringList>

namespace QGBA {

/**
 * Battery-save sync over WebDAV, a Qt port of the Android WebDavSync
 * (坚果云 by default). Each side compares modification times and keeps the
 * newer copy: remote files newer than the local ones are downloaded, local
 * ones newer are uploaded. Only *.sav / *.saN battery saves participate;
 * states stay local.
 */
namespace WebDavSync {

extern const QString DEFAULT_URL;
extern const QString DEFAULT_DIR;

struct Result {
	int uploaded = 0;
	int downloaded = 0;
	QStringList errors;

	QString summary() const {
		return QStringLiteral("%1/%2").arg(uploaded).arg(downloaded);
	}
};

struct Config {
	QString url = DEFAULT_URL;
	QString dir = DEFAULT_DIR;
	QString user;
	QString pass;
};

bool configured();

/**
 * Runs one bidirectional sync of the battery saves in `savesDir`. Local
 * files newer than their remote twin go up, remote newer come down; files
 * only on one side are copied to the other. Returns false on error and
 * fills `error`.
 */
bool run(const QString& savesDir, const Config& config, Result* result, QString* error);

}
}
