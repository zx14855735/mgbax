/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "WebDavSync.h"

#include <QDir>
#include <QEventLoop>
#include <QFile>
#include <QFileInfo>
#include <QNetworkAccessManager>
#include <QNetworkReply>
#include <QNetworkRequest>
#include <QRegularExpression>
#include <QSettings>
#include <QTimeZone>
#include <QTimer>
#include <QUrl>

using namespace QGBA;

namespace {

constexpr int CONNECT_TIMEOUT_MS = 15000;
constexpr int READ_TIMEOUT_MS = 30000;

QByteArray basicAuth(const QString& user, const QString& pass) {
	return "Basic " + QString::fromUtf8((user + ":" + pass).toUtf8()).toLatin1().toBase64();
}

// WebDAV servers keep their own mtime; a PROPFIND right after PUT may
// disagree by seconds. The 999ms slack in the comparison absorbs it, and the
// Android version additionally mirrors the local mtime after upload.
bool isBatterySave(const QString& name) {
	QString lower = name.toLower();
	if (lower.endsWith(".sav")) {
		return true;
	}
	static const QRegularExpression saDigit(QStringLiteral("\\.sa\\d$"));
	return saDigit.match(lower).hasMatch();
}

QString encoded(const QString& segment) {
	return QString::fromUtf8(QUrl::toPercentEncoding(segment));
}

long long parseHttpDate(const QString& text) {
	if (text.isEmpty()) {
		return 0;
	}
	QDateTime date = QDateTime::fromString(text.trimmed(), Qt::RFC2822Date);
	if (!date.isValid()) {
		date = QDateTime::fromString(text.trimmed(), QStringLiteral("yyyy-MM-dd'T'HH:mm:ss'Z'"));
		date.setTimeZone(QTimeZone::utc());
	}
	if (!date.isValid()) {
		return 0;
	}
	return date.toMSecsSinceEpoch();
}

/** Performs a request with an optional body; tolerated codes gate success. */
bool request(QNetworkAccessManager* manager, const QString& method, const QUrl& url,
             const QByteArray& auth, const QByteArray& body, const QStringList& okCodes,
             QByteArray* response, int* statusCode, QString* error) {
	QNetworkRequest netRequest(url);
	netRequest.setRawHeader("Authorization", auth);
	netRequest.setTransferTimeout(READ_TIMEOUT_MS);
	if (!body.isEmpty()) {
		netRequest.setRawHeader("Content-Type", "application/octet-stream");
	}
	QNetworkReply* reply = manager->sendCustomRequest(netRequest, method.toLatin1(), body);
	QEventLoop loop;
	QObject::connect(reply, &QNetworkReply::finished, &loop, &QEventLoop::quit);
	QTimer::singleShot(READ_TIMEOUT_MS + 2000, &loop, &QEventLoop::quit);
	loop.exec();
	int code = reply->attribute(QNetworkRequest::HttpStatusCodeAttribute).toInt();
	if (statusCode) {
		*statusCode = code;
	}
	QByteArray data = reply->readAll();
	if (response) {
		*response = data;
	}
	bool ok = okCodes.contains(QString::number(code));
	if (!ok && error && error->isEmpty()) {
		*error = QStringLiteral("HTTP %1").arg(code);
	}
	reply->deleteLater();
	return ok;
}

QString extractTag(const QString& block, const QString& tag) {
	// Namespace prefixes vary between servers (D:, d:, none); match the tag
	// with an optional prefix and pull its content.
	static const QRegularExpression pattern(QStringLiteral("<(?:[A-Za-z0-9]+:)?%1(?:\\s[^>]*)?>(.*?)</(?:[A-Za-z0-9]+:)?%1>").arg(tag),
	                                        QRegularExpression::DotMatchesEverythingOption
	                                        | QRegularExpression::CaseInsensitiveOption);
	QRegularExpressionMatch match = pattern.match(block);
	if (!match.hasMatch()) {
		return QString();
	}
	return match.captured(1).trimmed();
}

}

namespace QGBA {
namespace WebDavSync {

const QString DEFAULT_URL = QStringLiteral("https://dav.jianguoyun.com/dav/");
const QString DEFAULT_DIR = QStringLiteral("mGBAx");

bool configured() {
	QSettings settings(QStringLiteral("mGBAx"), QStringLiteral("sync"));
	return !settings.value("sync_user").toString().trimmed().isEmpty()
	       && !settings.value("sync_pass").toString().trimmed().isEmpty()
	       && !settings.value("sync_url", DEFAULT_URL).toString().trimmed().isEmpty();
}

bool run(const QString& savesDir, const Config& config, Result* result, QString* error) {
	QString base = config.url.trimmed();
	QString dir = config.dir.trimmed();
	QString user = config.user.trimmed();
	QString pass = config.pass.trimmed();
	if (base.isEmpty() || dir.isEmpty() || user.isEmpty() || pass.isEmpty()) {
		if (error) {
			*error = QStringLiteral("config");
		}
		return false;
	}
	if (!base.endsWith('/')) {
		base += '/';
	}
	QString folderUrl = base + encoded(dir);
	QString folderSlash = folderUrl + "/";
	QByteArray auth = basicAuth(user, pass);

	QDir saves(savesDir);
	QFileInfoList battery;
	for (const QFileInfo& entry : saves.entryInfoList(QDir::Files)) {
		if (isBatterySave(entry.fileName())) {
			battery.append(entry);
		}
	}

	QNetworkAccessManager manager;
	QString innerError;
	QByteArray response;
	int code = 0;

	// Make sure the remote folder exists (ignore failures: it may exist).
	QStringList mkcolOk{QStringLiteral("201"), QStringLiteral("405"), QStringLiteral("301"), QStringLiteral("200")};
	request(&manager, QStringLiteral("MKCOL"), QUrl(folderUrl), auth, QByteArray(), mkcolOk, nullptr, nullptr, &innerError);
	innerError.clear();

	// PROPFIND depth-1 listing of the folder.
	QNetworkRequest propfind((QUrl(folderSlash)));
	propfind.setRawHeader("Authorization", auth);
	propfind.setRawHeader("Depth", "1");
	propfind.setRawHeader("Content-Type", "application/xml");
	propfind.setTransferTimeout(READ_TIMEOUT_MS);
	QByteArray propBody = "<?xml version=\"1.0\"?><D:propfind xmlns:D=\"DAV:\"><D:prop>"
	                      "<D:getlastmodified/><D:getcontentlength/></D:prop></D:propfind>";
	QNetworkReply* reply = manager.sendCustomRequest(propfind, "PROPFIND", propBody);
	QEventLoop loop;
	QObject::connect(reply, &QNetworkReply::finished, &loop, &QEventLoop::quit);
	QTimer::singleShot(READ_TIMEOUT_MS + 2000, &loop, &QEventLoop::quit);
	loop.exec();
	code = reply->attribute(QNetworkRequest::HttpStatusCodeAttribute).toInt();
	QByteArray body = reply->readAll();
	reply->deleteLater();
	if (code != 207 && code != 404) {
		if (error) {
			*error = QStringLiteral("HTTP %1").arg(code);
		}
		return false;
	}

	struct RemoteFile {
		QString name;
		long long mtime = 0;
	};
	QList<RemoteFile> remote;
	// Namespace prefixes vary between servers (D:, d:, none); scan the raw
	// XML for response blocks and pull the two properties we need.
	QString lower = QString::fromUtf8(body).toLower();
	QString original = QString::fromUtf8(body);
	int index = 0;
	while (true) {
		int start = lower.indexOf(QStringLiteral("<d:response>"), index);
		int startAlt = lower.indexOf(QStringLiteral("<response>"), index);
		if (startAlt >= 0 && (start < 0 || startAlt < start)) {
			start = startAlt;
		}
		if (start < 0) {
			break;
		}
		int end = lower.indexOf(QStringLiteral("</d:response>"), start);
		if (end < 0) {
			end = lower.indexOf(QStringLiteral("</response>"), start);
		}
		if (end < 0) {
			end = lower.length();
		}
		QString block = original.mid(start, qMin(end, original.length()) - start);
		QString href = extractTag(block, QStringLiteral("href"));
		if (!href.isEmpty() && !href.endsWith('/')) {
			QString name = QUrl::fromPercentEncoding(href.mid(href.lastIndexOf('/') + 1).toUtf8());
			long long mtime = parseHttpDate(extractTag(block, QStringLiteral("getlastmodified")));
			if (!name.isEmpty()) {
				remote.append({name, mtime});
			}
		}
		index = end;
	}

	for (const QFileInfo& file : battery) {
		QString localName = file.fileName();
		const RemoteFile* found = nullptr;
		for (const RemoteFile& candidate : remote) {
			if (candidate.name.compare(localName, Qt::CaseInsensitive) == 0) {
				found = &candidate;
				break;
			}
		}
		QString fileUrl = folderSlash + encoded(localName);
		if (!found) {
			// Only up: a file we never uploaded is ours.
			QFile data(file.absoluteFilePath());
			if (data.open(QIODevice::ReadOnly)
			    && request(&manager, QStringLiteral("PUT"), QUrl(fileUrl), auth, data.readAll(),
			               {QStringLiteral("200"), QStringLiteral("201"), QStringLiteral("204")}, nullptr, nullptr, &innerError)) {
				result->uploaded++;
			} else {
				result->errors.append(localName);
			}
			innerError.clear();
			continue;
		}
		if (file.lastModified().toMSecsSinceEpoch() > found->mtime + 999) {
			QFile data(file.absoluteFilePath());
			if (data.open(QIODevice::ReadOnly)
			    && request(&manager, QStringLiteral("PUT"), QUrl(fileUrl), auth, data.readAll(),
			               {QStringLiteral("200"), QStringLiteral("201"), QStringLiteral("204")}, nullptr, nullptr, &innerError)) {
				result->uploaded++;
			} else {
				result->errors.append(localName);
			}
			innerError.clear();
		} else if (found->mtime > file.lastModified().toMSecsSinceEpoch() + 999) {
			QByteArray blob;
			if (request(&manager, QStringLiteral("GET"), QUrl(fileUrl), auth, QByteArray(),
			            {QStringLiteral("200")}, &blob, nullptr, &innerError)) {
				QString tmpPath = file.absoluteFilePath() + ".sync-tmp";
				QFile tmp(tmpPath);
				if (tmp.open(QIODevice::WriteOnly | QIODevice::Truncate)) {
					tmp.write(blob);
					tmp.close();
					QFile::remove(file.absoluteFilePath());
					tmp.rename(file.absoluteFilePath());
					result->downloaded++;
				} else {
					result->errors.append(localName);
				}
			} else {
				result->errors.append(localName);
			}
			innerError.clear();
		}
	}
	// Remote saves we do not have locally yet come down (new device case).
	for (const RemoteFile& entry : remote) {
		if (!isBatterySave(entry.name)) {
			continue;
		}
		bool have = false;
		for (const QFileInfo& file : battery) {
			if (file.fileName().compare(entry.name, Qt::CaseInsensitive) == 0) {
				have = true;
				break;
			}
		}
		if (have) {
			continue;
		}
		QByteArray blob;
		QString fileUrl = folderSlash + encoded(entry.name);
		if (request(&manager, QStringLiteral("GET"), QUrl(fileUrl), auth, QByteArray(),
		            {QStringLiteral("200")}, &blob, nullptr, &innerError)) {
			QFile out(saves.absoluteFilePath(entry.name));
			if (out.open(QIODevice::WriteOnly | QIODevice::Truncate)) {
				out.write(blob);
				out.close();
				result->downloaded++;
			}
		}
		innerError.clear();
	}
	return true;
}

}
}
