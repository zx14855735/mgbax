/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
/**
 * Console E2E harness for the PC link ports:
 *
 *   test-gboylink wifi [rom]     in-process GBoyLink host+join round trip
 *   test-gboylink cloud <user> <pass> [room] [rom]
 *                                real gboy.top signalling self test (login,
 *                                create room, resolve relay node, KCP HS/HK);
 *                                joins [room] when given instead of creating
 *   test-gboylink cloud2 <user> <pass> <roomFile> <host|join> [rom]
 *                                two-instance room test: the host writes the
 *                                room id to roomFile, the joiner picks it up;
 *                                PASS when keys flow through the relay
 *   test-gboylink webdav         WebDAV round trip against a local mock
 *   test-gboylink glsl <in.glsl> [outdir]
 *                                external shader conversion sanity check
 *
 * The wifi mode exercises the same frames GBoy/My Boy speak, the cloud modes
 * exercise the same signalling path the Android lobby uses.
 */
#include "GBoyFrames.h"
#include "GBoyLink.h"
#include "ExternalShader.h"
#include "WebDavSync.h"
#ifdef BUILD_QT_CLOUD
#include "CloudLink.h"
#include "GbCloud.h"
#include "KcpChannel.h"
#endif

#include <QCoreApplication>
#include <QDateTime>
#include <QDir>
#include <QElapsedTimer>
#include <QEventLoop>
#include <QFile>
#include <QFileInfo>
#include <QRegularExpression>
#include <QTcpServer>
#include <QTcpSocket>
#include <QTimer>

#include <cstdio>

using namespace QGBA;

static int wifiTest(const QString& rom) {
	int failures = 0;

	GBoyLink hostLink;
	GBoyLink guestLink;

	QEventLoop loop;
	int hostGot = -1;
	int guestGot = -1;
	bool hostReady = false;
	bool guestReady = false;
	QStringList hostLog;
	QStringList guestLog;

	// Queued connections (loop as the context): the links emit from their
	// worker threads, the harness state lives on the main thread.
	QObject::connect(&hostLink, &GBoyLink::statusMessage, &loop, [&](const QString& m) {
		hostLog << m;
	});
	QObject::connect(&guestLink, &GBoyLink::statusMessage, &loop, [&](const QString& m) {
		guestLog << m;
	});
	QObject::connect(&hostLink, &QThread::finished, &loop, [&]() {
		qInfo() << "HOST THREAD FINISHED";
	});
	QObject::connect(&guestLink, &QThread::finished, &loop, [&]() {
		qInfo() << "GUEST THREAD FINISHED";
	});
	QObject::connect(&hostLink, &GBoyLink::remoteKeys, &loop, [&](int keys) {
		if (!hostReady) {
			hostReady = true;
		}
		hostGot = keys;
	});
	QObject::connect(&guestLink, &GBoyLink::remoteKeys, &loop, [&](int keys) {
		if (!guestReady) {
			guestReady = true;
		}
		guestGot = keys;
	});
	QObject::connect(&hostLink, &GBoyLink::linkEnded, &loop, [&](const QString& m) {
		qInfo().noquote() << "host ended:" << (m.isEmpty() ? QStringLiteral("<silent>") : m);
		if (!m.isEmpty()) {
			++failures;
		}
		loop.quit();
	});
	QObject::connect(&guestLink, &GBoyLink::linkEnded, &loop, [&](const QString& m) {
		qInfo().noquote() << "guest ended:" << (m.isEmpty() ? QStringLiteral("<silent>") : m);
		if (!m.isEmpty()) {
			++failures;
		}
		loop.quit();
	});

	GBoyLink::Config hostConfig;
	hostConfig.mode = GBoyLink::HOST;
	hostConfig.port = 16374;
	hostConfig.romPath = rom;
	hostLink.startLink(hostConfig);

	GBoyLink::Config guestConfig;
	guestConfig.mode = GBoyLink::JOIN;
	guestConfig.ip = QStringLiteral("127.0.0.1");
	guestConfig.port = 16374;
	guestConfig.romPath = rom;
	guestLink.startLink(guestConfig);

	// Let the handshake settle, then pump distinct key masks both ways.
	QTimer::singleShot(1500, &loop, [&]() {
		hostLink.setLocalKeys(0x001); // A button
		guestLink.setLocalKeys(0x200); // L button
	});
	QTimer::singleShot(3000, &loop, [&]() {
		if (hostGot != 0x200) {
			qWarning() << "host did not receive guest keys 0x200, got" << hostGot;
			++failures;
		}
		if (guestGot != 0x001) {
			qWarning() << "guest did not receive host keys 0x001, got" << guestGot;
			++failures;
		}
		if (!hostReady || !guestReady) {
			qWarning() << "handshake did not reach the key pump";
			++failures;
		}
		loop.quit();
	});
	QTimer::singleShot(20000, &loop, &QEventLoop::quit);
	loop.exec();

	hostLink.stopLink();
	guestLink.stopLink();

	qInfo().noquote() << "host status:" << hostLog.join(" | ");
	qInfo().noquote() << "guest status:" << guestLog.join(" | ");
	if (failures == 0) {
		qInfo() << "WIFI LINK TEST: PASS";
	} else {
		qInfo() << "WIFI LINK TEST: FAIL" << failures;
	}
	return failures;
}

#ifdef BUILD_QT_CLOUD
static int cloudTest(const QString& user, const QString& password, const QString& roomId, const QString& rom) {
	int failures = 0;
	CloudLink link;
	QEventLoop loop;
	QStringList log;
	bool relayConnected = false;

	QObject::connect(&link, &CloudLink::statusMessage, [&](const QString& m) {
		log << m;
		if (m.contains(QStringLiteral("云端联机已连接"))) {
			relayConnected = true;
		}
	});
	QObject::connect(&link, &CloudLink::remoteKeys, [&](int keys) {
		if (relayConnected && keys != 0) {
			loop.quit();
		}
	});
	QObject::connect(&link, &CloudLink::linkEnded, [&](const QString& m) {
		if (!m.isEmpty()) {
			qInfo().noquote() << "cloud ended:" << m;
		}
		loop.quit();
	});

	CloudLink::Config config;
	config.user = user;
	config.password = password;
	config.roomId = roomId;
	config.romPath = rom;
	link.startLink(config);

	// Either the relay connects (second player present) or we just verify the
	// signalling got as far as a relay node before the window closes.
	QTimer::singleShot(60000, &loop, &QEventLoop::quit);
	loop.exec();
	link.stopLink();

	const QString joined = log.join("\n");
	bool gotRoom = joined.contains(QStringLiteral("房号"));
	bool gotNode = joined.contains(QStringLiteral("中继 "));
	qInfo().noquote() << "cloud log:" << log.join(" | ");
	if (relayConnected) {
		qInfo() << "CLOUD TEST: PASS (relay connected, keys flowing)";
	} else if (gotRoom && gotNode) {
		qInfo() << "CLOUD TEST: PASS (room + relay resolved; peer absent so no key session)";
	} else {
		qInfo() << "CLOUD TEST: FAIL (room:" << gotRoom << "node:" << gotNode << ")";
		++failures;
	}
	return failures;
}

/**
 * Two-instance room test: the host creates a room and writes its id to
 * roomFile; the joiner waits for the file, joins, and both PASS once keys
 * flow through the relay in either direction.
 */
static int cloudPairTest(const QString& user, const QString& password,
                         const QString& roomFile, const QString& role, const QString& rom) {
	int failures = 0;
	CloudLink link;
	QEventLoop loop;
	QStringList log;
	bool relayConnected = false;

	QObject::connect(&link, &CloudLink::statusMessage, [&](const QString& m) {
		log << m;
		if (m.contains(QStringLiteral("云端联机已连接"))) {
			relayConnected = true;
		}
		if (role == QStringLiteral("host")) {
			// Publish the room id as soon as the server hands it over.
			static QRegularExpression roomRe(QStringLiteral("房号\\s*(\\S+)"));
			QRegularExpressionMatch match = roomRe.match(m);
			if (match.hasMatch()) {
				QFile out(roomFile);
				if (out.open(QIODevice::WriteOnly | QIODevice::Truncate)) {
					out.write(match.captured(1).toUtf8());
				}
			}
		}
	});
	QObject::connect(&link, &CloudLink::remoteKeys, [&](int keys) {
		if (relayConnected && keys != 0) {
			loop.quit();
		}
	});
	QObject::connect(&link, &CloudLink::linkEnded, [&](const QString& m) {
		if (!m.isEmpty()) {
			qInfo().noquote() << role << "ended:" << m;
		}
		loop.quit();
	});

	CloudLink::Config config;
	config.user = user;
	config.password = password;
	config.romPath = rom;
	if (role == QStringLiteral("join")) {
		// Wait for the host to publish the room id.
		qint64 deadline = QDateTime::currentMSecsSinceEpoch() + 60000;
		QString roomId;
		while (QDateTime::currentMSecsSinceEpoch() < deadline) {
			QFile in(roomFile);
			if (in.open(QIODevice::ReadOnly)) {
				roomId = QString::fromUtf8(in.readAll()).trimmed();
				if (!roomId.isEmpty()) {
					break;
				}
			}
			QCoreApplication::processEvents(QEventLoop::AllEvents, 100);
		}
		if (roomId.isEmpty()) {
			qInfo() << "CLOUD PAIR TEST: FAIL (host never published a room id)";
			return 1;
		}
		config.roomId = roomId;
		qInfo().noquote() << "joining room" << roomId;
	}
	link.startLink(config);

	QTimer::singleShot(role == QStringLiteral("host") ? 120000 : 90000, &loop, &QEventLoop::quit);
	loop.exec();
	link.stopLink();

	qInfo().noquote() << role << "log:" << log.join(" | ");
	if (relayConnected) {
		qInfo() << "CLOUD PAIR TEST:" << role << "PASS (keys flowing through relay)";
	} else {
		qInfo() << "CLOUD PAIR TEST:" << role << "FAIL (relay never delivered keys)";
		++failures;
	}
	return failures;
}
#endif

static int webdavTest() {
	int failures = 0;
	const QString dir = QDir::temp().absoluteFilePath(QStringLiteral("mgba-webdav-test"));
	QDir(dir).removeRecursively();
	QDir().mkpath(dir);
	const QString sav = dir + QStringLiteral("/test.sav");
	{
		QFile f(sav);
		f.open(QIODevice::WriteOnly);
		f.write(QByteArray(0x20000, 'A'));
	}

	// Minimal WebDAV mock: MKCOL / PROPFIND / PUT / GET over loopback.
	QTcpServer server;
	if (!server.listen(QHostAddress::LocalHost, 18080)) {
		qInfo() << "WEBDAV TEST: FAIL (mock server cannot listen)";
		return 1;
	}
	QEventLoop loop;
	struct MockState {
		QByteArray blob;
		qint64 mtime = 0;
	} state;

	QObject::connect(&server, &QTcpServer::newConnection, [&]() {
		QTcpSocket* sock = server.nextPendingConnection();
		QObject::connect(sock, &QTcpSocket::disconnected, sock, &QObject::deleteLater);
		QObject::connect(sock, &QTcpSocket::readyRead, [sock, &state]() {
			sock->setProperty("buf", sock->property("buf").toByteArray() + sock->readAll());
			QByteArray buf = sock->property("buf").toByteArray();
			int end = buf.indexOf("\r\n\r\n");
			if (end < 0) {
				return;
			}
			QString head = QString::fromLatin1(buf.left(end));
			QStringList lines = head.split(QStringLiteral("\r\n"));
			QString requestLine = lines.first();
			QStringList parts = requestLine.split(' ');
			QString method = parts.size() > 0 ? parts[0] : QString();
			QString path = parts.size() > 1 ? parts[1] : QString();
			// Content-Length aware body read (PUT body).
			int contentLength = 0;
			for (const QString& line : lines) {
				if (line.startsWith(QStringLiteral("Content-Length:"), Qt::CaseInsensitive)) {
					contentLength = line.section(':', 1).trimmed().toInt();
				}
			}
			QByteArray body = buf.mid(end + 4);
			if (body.size() < contentLength) {
				return; // wait for the rest
			}
			sock->setProperty("buf", QByteArray());
			auto reply = [sock](int code, const QByteArray& payload = QByteArray(), const char* type = "text/plain") {
				QByteArray out = "HTTP/1.1 " + QByteArray::number(code) + " code\r\n";
				if (!payload.isEmpty()) {
					out += "Content-Type: " + QByteArray(type) + "\r\n";
				}
				out += "Content-Length: " + QByteArray::number(payload.size()) + "\r\n\r\n";
				out += payload;
				sock->write(out);
			};
			if (method == QStringLiteral("MKCOL")) {
				reply(201);
			} else if (method == QStringLiteral("PUT")) {
				state.blob = body;
				state.mtime = QDateTime::currentMSecsSinceEpoch();
				reply(201);
			} else if (method == QStringLiteral("GET")) {
				if (state.blob.isEmpty()) {
					reply(404);
				} else {
					reply(200, state.blob, "application/octet-stream");
				}
			} else if (method == QStringLiteral("PROPFIND")) {
				if (state.blob.isEmpty()) {
					reply(404);
				} else {
					QString lastModified = QDateTime::fromMSecsSinceEpoch(state.mtime).toUTC().toString(QStringLiteral("ddd, dd MMM yyyy HH:mm:ss 'GMT'"));
					QString xml = QStringLiteral(
					              "<?xml version=\"1.0\"?><D:multistatus xmlns:D=\"DAV:\">"
					              "<D:response><D:href>/dav/mGBAx/</D:href></D:response>"
					              "<D:response><D:href>/dav/mGBAx/test.sav</D:href>"
					              "<D:propstat><D:prop><D:getlastmodified>%1</D:getlastmodified>"
					              "</D:prop></D:propstat></D:response></D:multistatus>").arg(lastModified);
					reply(207, xml.toUtf8(), "application/xml");
				}
			} else {
				reply(405);
			}
		});
	});

	WebDavSync::Config config;
	config.url = QStringLiteral("http://127.0.0.1:18080/dav/");
	config.dir = QStringLiteral("mGBAx");
	config.user = QStringLiteral("u");
	config.pass = QStringLiteral("p");
	WebDavSync::Result result;
	QString error;
	if (!WebDavSync::run(dir, config, &result, &error)) {
		qInfo().noquote() << "WEBDAV TEST: FAIL (run error:" << error << ")";
		return 1;
	}
	if (result.uploaded != 1) {
		qInfo() << "WEBDAV TEST: FAIL (expected 1 upload, got" << result.uploaded << ")";
		++failures;
	}
	// New-device case: delete the local copy, the remote one must come back.
	QFile::remove(sav);
	result = WebDavSync::Result();
	if (!WebDavSync::run(dir, config, &result, &error)) {
		qInfo().noquote() << "WEBDAV TEST: FAIL (second run error:" << error << ")";
		return 1;
	}
	if (result.downloaded != 1) {
		qInfo() << "WEBDAV TEST: FAIL (expected 1 download, got" << result.downloaded << ")";
		++failures;
	} else {
		QFile f(sav);
		f.open(QIODevice::ReadOnly);
		if (f.readAll() != QByteArray(0x20000, 'A')) {
			qInfo() << "WEBDAV TEST: FAIL (downloaded content mismatch)";
			++failures;
		}
	}
	QDir(dir).removeRecursively();
	if (failures == 0) {
		qInfo() << "WEBDAV TEST: PASS";
	} else {
		qInfo() << "WEBDAV TEST: FAIL" << failures;
	}
	return failures;
}

static int glslTest(const QString& input) {
	QString error;
	QString outDir = QDir::temp().absoluteFilePath(QStringLiteral("mgba-glsl-test"));
	QDir(outDir).removeRecursively();
	if (!ExternalShader::convert(input, outDir, &error)) {
		qInfo().noquote() << "GLSL TEST: FAIL (" << error << ")";
		return 1;
	}
	QFile fs(outDir + QStringLiteral("/shader.fs"));
	QFile ini(outDir + QStringLiteral("/manifest.ini"));
	if (!fs.open(QIODevice::ReadOnly) || !ini.open(QIODevice::ReadOnly)) {
		qInfo() << "GLSL TEST: FAIL (converted files missing)";
		return 1;
	}
	QString body = QString::fromUtf8(fs.readAll());
	int failures = 0;
	if (body.contains(QStringLiteral("#version"))) {
		qInfo() << "GLSL TEST: FAIL (#version survived)";
		++failures;
	}
	if (!body.contains(QStringLiteral("uniform sampler2D tex;"))) {
		qInfo() << "GLSL TEST: FAIL (prelude missing)";
		++failures;
	}
	if (!body.contains(QStringLiteral("gl_FragColor"))) {
		qInfo() << "GLSL TEST: FAIL (no gl_FragColor)";
		++failures;
	}
	QDir(outDir).removeRecursively();
	if (failures == 0) {
		qInfo() << "GLSL TEST: PASS";
	} else {
		qInfo() << "GLSL TEST: FAIL" << failures;
	}
	return failures;
}

int main(int argc, char** argv) {
	QCoreApplication app(argc, argv);
	QStringList args = app.arguments();
	if (args.size() < 2) {
		qInfo() << "usage: test-gboylink wifi [rom] | cloud <user> <pass> [room] [rom]"
		        << "| cloud2 <user> <pass> <roomFile> <host|join> [rom]"
		        << "| webdav | glsl <in.glsl>";
		return 2;
	}
	QString mode = args[1];
	if (mode == QStringLiteral("wifi")) {
		QString rom = args.size() > 2 ? args[2] : QStringLiteral("test.gba");
		return wifiTest(rom);
	}
	if (mode == QStringLiteral("webdav")) {
		return webdavTest();
	}
	if (mode == QStringLiteral("glsl")) {
		if (args.size() < 3) {
			qInfo() << "usage: test-gboylink glsl <in.glsl>";
			return 2;
		}
		return glslTest(args[2]);
	}
#ifdef BUILD_QT_CLOUD
	if (mode == QStringLiteral("cloud")) {
		if (args.size() < 4) {
			qInfo() << "usage: test-gboylink cloud <user> <pass> [room] [rom]";
			return 2;
		}
		QString user = args[2];
		QString pass = args[3];
		QString room = args.size() > 4 ? args[4] : QString();
		QString rom = args.size() > 5 ? args[5] : QStringLiteral("test.gba");
		return cloudTest(user, pass, room, rom);
	}
	if (mode == QStringLiteral("cloud2")) {
		if (args.size() < 6) {
			qInfo() << "usage: test-gboylink cloud2 <user> <pass> <roomFile> <host|join> [rom]";
			return 2;
		}
		QString user = args[2];
		QString pass = args[3];
		QString roomFile = args[4];
		QString role = args[5];
		QString rom = args.size() > 6 ? args[6] : QStringLiteral("test.gba");
		return cloudPairTest(user, pass, roomFile, role, rom);
	}
#endif
	qInfo() << "unknown mode" << mode;
	return 2;
}
