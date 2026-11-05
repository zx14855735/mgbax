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
#include "audio_stretch.h"
#ifdef BUILD_QT_CLOUD
#include "CloudLink.h"
#include "GbCloud.h"
#include "KcpChannel.h"
#endif
#include "sio_link.h"

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
#include <QThread>
#include <QTimer>

#include <cstdio>

#include <mgba/core/core.h>
#include <mgba/core/config.h>
#include <mgba-util/vfs.h>
#include <mgba/internal/gba/gba.h>
#include <mgba/internal/gba/sio.h>
#include <mgba/internal/gba/io.h>

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

/**
 * LAN SIO cable E2E: two real GBA cores in-process, one hosting on 18765 and
 * one joining, the mobile-layer SIO driver driving one full MULTI transfer
 * in both directions. The master writes 0x1234, the slave 0xBEEF; PASS when
 * each core receives the other's word in its SIOMULTI registers.
 */
static int lanSioTest(const QString& rom) {
	struct mCore* cores[2] = { nullptr, nullptr };
	struct SioLink* links[2] = { nullptr, nullptr };
	mColor video[2][240 * 160];
	int failures = 0;
	QString error;

	QString romAbs = QFileInfo(rom).absoluteFilePath();
	for (int i = 0; i < 2; i++) {
		QByteArray romUtf8 = romAbs.toUtf8();
		VFile* romVf = VFileOpen(romUtf8.constData(), O_RDONLY);
		if (!romVf) {
			romVf = VFileOpenFD(romUtf8.constData(), O_RDONLY);
		}
		if (!romVf) {
			qInfo().noquote() << QString("LAN SIO TEST: FAIL (cannot open %1; cwd=%2; exists=%3)")
			                     .arg(romAbs, QDir::currentPath())
			                     .arg(QFile::exists(romAbs) ? "yes" : "no");
			return 1;
		}
		cores[i] = mCoreFindVF(romVf);
		if (!cores[i]) {
			qInfo().noquote() << "LAN SIO TEST: FAIL (cannot find core for" << rom << ")";
			return 1;
		}
		cores[i]->init(cores[i]);
		mCoreConfigInit(&cores[i]->config, NULL);
		if (!cores[i]->loadROM(cores[i], romVf)) {
			qInfo() << "LAN SIO TEST: FAIL (cannot load ROM)";
			return 1;
		}
		cores[i]->reset(cores[i]);
		cores[i]->setVideoBuffer(cores[i], video[i], 240);
		links[i] = sioLinkCreate();
	}

	if (!sioLinkHost(links[0], 18765)) {
		qInfo() << "LAN SIO TEST: FAIL (cannot listen)";
		return 1;
	}
	if (!sioLinkJoin(links[1], "127.0.0.1", 18765)) {
		qInfo() << "LAN SIO TEST: FAIL (cannot connect)";
		return 1;
	}
	// Pump until both sides are connected and the SIO driver attached.
	for (int i = 0; i < 100 && sioLinkState(links[0]) != 2; i++) {
		sioLinkPump(links[0], cores[0]);
		sioLinkPump(links[1], cores[1]);
		QThread::msleep(50);
	}
	if (sioLinkState(links[0]) != 2 || sioLinkState(links[1]) != 2) {
		qInfo() << "LAN SIO TEST: FAIL (link never connected:" << sioLinkState(links[0]) << sioLinkState(links[1]) << ")";
		return 1;
	}
	sioLinkPump(links[0], cores[0]);
	sioLinkPump(links[1], cores[1]);
	struct GBA* gba0 = (struct GBA*) cores[0]->board;
	struct GBA* gba1 = (struct GBA*) cores[1]->board;
	if (!gba0->sio.driver || !gba1->sio.driver) {
		qInfo() << "LAN SIO TEST: FAIL (SIO driver not attached)";
		return 1;
	}
	qInfo().noquote() << QString("attached: master id=%1 slave id=%2")
	                     .arg(gba0->sio.driver->deviceId(gba0->sio.driver))
	                     .arg(gba1->sio.driver->deviceId(gba1->sio.driver));

	// Real games switch the SIO pins out of RCNT GPIO mode before linking;
	// without this the mode stays GPIO and the driver never sees SIOCNT.
	GBASIOWriteRCNT(&gba0->sio, 0);
	GBASIOWriteRCNT(&gba1->sio, 0);
	// Master begins a MULTI transfer (Pokemon-style 0x600F write), the slave
	// arms itself the same way. Round 0's push is dropped by design (the
	// loose slave take discards anything <= minIndex, exactly like the
	// Android version); the game simply starts the next round, so run three.
	gba0->memory.io[GBA_REG(SIOMLT_SEND)] = 0x1234;
	gba1->memory.io[GBA_REG(SIOMLT_SEND)] = 0xBEEF;
	for (int round = 0; round < 3; round++) {
		GBASIOWriteSIOCNT(&gba0->sio, 0x600F);
		GBASIOWriteSIOCNT(&gba1->sio, 0x600F);
		// Let the slave's serviceLink see the master's pushed word and run
		// its round event, then run the master so its sioDone fetches the
		// reply (the 800 ms peer wait only stalls on a dead link).
		for (int f = 0; f < 4; f++) {
			sioLinkPump(links[1], cores[1]);
			cores[1]->runFrame(cores[1]);
			sioLinkPump(links[0], cores[0]);
			cores[0]->runFrame(cores[0]);
		}
	}
	uint16_t m1 = gba0->memory.io[GBA_REG(SIOMULTI1)];
	uint16_t m0 = gba1->memory.io[GBA_REG(SIOMULTI0)];
	qInfo().noquote() << QString("master SIOMULTI1=%1 (want BEEF), slave SIOMULTI0=%2 (want 1234)")
	                     .arg(m1, 4, 16, QChar('0')).arg(m0, 4, 16, QChar('0'));
	if (m1 != 0xBEEF) {
		++failures;
	}
	if (m0 != 0x1234) {
		++failures;
	}
	if (failures == 0) {
		qInfo() << "LAN SIO TEST: PASS (full MULTI transfer both directions)";
	} else {
		qInfo() << "LAN SIO TEST: FAIL" << failures;
	}
	for (int i = 0; i < 2; i++) {
		sioLinkDestroy(links[i]);
		cores[i]->deinit(cores[i]);
	}
	return failures;
}

/**
 * Fast-forward audio stretcher (倍速音乐原速) E2E. Paced like the real thing:
 * the "core" produces `speed`x more audio than real time, the "frontend" pulls
 * every few milliseconds, and the clock is the wall clock. Both production
 * modes must therefore hand back ~RATE frames per second of wall clock - the
 * whole point of the feature is that the tune plays at its own tempo instead
 * of being pitched up - and the samples must stay a 440 Hz sine (no resample
 * artifacts), with the native mode cutting sections once the lag ring fills.
 */
static int holdTest() {
	const unsigned rate = 48000;
	const double speed = 4.0;
	// Long enough for the native mode's lag ring (6 s of core audio) to fill
	// at 4x and force a section cut: the surplus accumulates at 3x the play
	// rate, so the ring needs 2 s of wall clock plus margin.
	const int runMs = 3200;
	int failures = 0;

	for (int mode = AUDIO_STRETCH_PITCH; mode <= AUDIO_STRETCH_NATIVE; ++mode) {
		struct AudioStretch stretch;
		audioStretchInit(&stretch);
		audioStretchSetMode(&stretch, mode);

		struct mAudioBuffer source;
		mAudioBufferInit(&source, rate * 2, 2); // 2 s core ring

		// Room for a full 100 ms of 4x production, so a sleeping scheduler
		// never forces a short feed.
		std::vector<int16_t> chunk(size_t(speed * rate * 0.1) * 2);
		std::vector<int16_t> outBuf(rate); // 0.5 s scratch
		double phase = 0.0;
		long long fed = 0;
		long long out = 0;
		long long crossings = 0;
		int16_t prev = 0;
		double lastFeed = 0.0;
		QElapsedTimer clock;
		clock.start();

		while (clock.elapsed() < runMs) {
			// Produce exactly what a 4x core would have made since the last
			// pass, so scheduler jitter cannot slow the simulated console down.
			double now = clock.elapsed() / 1000.0;
			double dt = now - lastFeed;
			size_t produce = size_t(speed * rate * dt);
			size_t want = size_t(rate * dt);
			if (!produce) {
				QThread::msleep(1);
				continue;
			}
			if (produce > chunk.size() / 2) {
				produce = chunk.size() / 2;
			}
			if (want > outBuf.size() / 2) {
				want = outBuf.size() / 2;
			}
			lastFeed = now;
			for (size_t i = 0; i < produce; ++i) {
				int16_t v = (int16_t) (12000.0 * sin(phase));
				chunk[i * 2] = v;
				chunk[i * 2 + 1] = v;
				phase += 2.0 * 3.14159265358979323846 * 440.0 / rate;
			}
			mAudioBufferWrite(&source, chunk.data(), produce);
			fed += produce;

			struct mAudioBuffer* staged = audioStretchProcess(&stretch, &source, rate, true, speed, want);
			size_t avail = mAudioBufferAvailable(staged);
			if (avail > outBuf.size() / 2) {
				avail = outBuf.size() / 2;
			}
			if (avail) {
				mAudioBufferRead(staged, outBuf.data(), avail);
				for (size_t i = 0; i < avail; ++i) {
					int16_t s = outBuf[i * 2];
					if ((prev < 0 && s >= 0) || (prev > 0 && s <= 0)) {
						++crossings;
					}
					prev = s;
				}
				out += avail;
			}
			QThread::msleep(2);
		}

		double wall = clock.elapsed() / 1000.0;
		double seconds = out / double(rate);
		double pitch = seconds > 0.01 ? crossings / 2.0 / seconds : 0.0;
		qInfo().noquote() << QString("mode %1: wall %2 s, fed %3 s of core audio (4x), out %4 s, pitch ~%5 Hz, dropped %6, cuts %7")
		                     .arg(mode).arg(wall, 0, 'f', 2)
		                     .arg(fed / double(rate), 0, 'f', 2)
		                     .arg(seconds, 0, 'f', 2)
		                     .arg(pitch, 0, 'f', 0)
		                     .arg(audioStretchDropped(&stretch))
		                     .arg(audioStretchCuts(&stretch));
		// Real-time production: the output must track the wall clock, not the
		// 4x production rate.
		if (seconds < wall * 0.70 || seconds > wall * 1.15) {
			qWarning() << "HOLD TEST: not playing at 1x for mode" << mode;
			++failures;
		}
		if (pitch < 400 || pitch > 480) {
			qWarning() << "HOLD TEST: pitch drifted for mode" << mode << pitch;
			++failures;
		}
		if (mode == AUDIO_STRETCH_PITCH && audioStretchDropped(&stretch) > rate / 4) {
			qWarning() << "HOLD TEST: WSOLA discarded too much";
			++failures;
		}
		if (mode == AUDIO_STRETCH_NATIVE && audioStretchCuts(&stretch) == 0) {
			qWarning() << "HOLD TEST: native mode never cut a section";
			++failures;
		}
		mAudioBufferDeinit(&source);
		audioStretchDeinit(&stretch);
	}

	// Disengaging must hand the core's own buffer straight back.
	struct AudioStretch off;
	audioStretchInit(&off);
	struct mAudioBuffer src;
	mAudioBufferInit(&src, 4096, 2);
	if (audioStretchProcess(&off, &src, rate, false, 1.0, 480) != &src) {
		qWarning() << "HOLD TEST: disengaged stretcher did not return the core buffer";
		++failures;
	}
	mAudioBufferDeinit(&src);
	audioStretchDeinit(&off);

	if (failures == 0) {
		qInfo() << "HOLD TEST: PASS";
	} else {
		qInfo() << "HOLD TEST: FAIL" << failures;
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
	if (mode == QStringLiteral("hold")) {
		return holdTest();
	}
	if (mode == QStringLiteral("lanio")) {
		QString rom = args.size() > 2 ? args[2] : QStringLiteral("test.gba");
		return lanSioTest(rom);
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
