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
 *   test-gboylink bus <rom> [3|4]   N real cores, star bus, scripted SIO writes
 *   test-gboylink busgame <rom> <sav> [3|4]
 *                                N real cores on the star bus running the
 *                                actual game's cable-club script (LINKUP proof)
 *   test-gboylink --c0           C0 / ADR-002 capability-bit assertions (decode,
 *                                byte-exact encode, AUTO mapping); no ROM needed
 *   test-gboylink --gatetest     C0 negotiation gate end to end: drives the real
 *                                CloudLink::negotiateLinkMode() over all five
 *                                outcomes; no ROM / network / thread needed
 *
 * The wifi mode exercises the same frames GBoy/My Boy speak, the cloud modes
 * exercise the same signalling path the Android lobby uses.
 */
#include "GBoyFrames.h"
#include "GBoyLink.h"
#include "GBoyLinkSession.h"
#include "ExternalShader.h"
#include "WebDavSync.h"
#include "audio_stretch.h"
#ifdef BUILD_QT_CLOUD
#include "CloudLink.h"
#include "DirectLink.h"
#include "GbCloud.h"
#include "KcpChannel.h"
#include "SioLinkHost.h"
#include "TcpDirectLink.h"
#endif
#include "sio_link.h"
#include "../mobile/link_net.h"
#include "../mobile/link_lockstep.h"
#include "../mobile/mgba_mobile.h"

#include <atomic>
#include <cctype>
#include <chrono>
#include <condition_variable>
#include <cstdarg>
#include <cstring>
#include <mutex>
#include <thread>
#include <vector>

/* GBA 真锁步（验证 mGBA 自带 GBASIOLockstepCoordinator 能否解决 3/4 人
 * SerialCB 不同相位的问题）。走 mCoreThread + mLockstepThreadUser，
 * 与 mGBA 官方 MultiplayerController 同一套机制。 */
#include <mgba/core/core.h>
#include <mgba/core/thread.h>
#include <mgba/core/lockstep.h>
#include <mgba/internal/gba/sio/lockstep.h>

#include <QCoreApplication>
#include <QCryptographicHash>
#include <QDateTime>
#include <QDir>
#include <QElapsedTimer>
#include <QEventLoop>
#include <QFile>
#include <QFileInfo>
#include <QMutex>
#include <QMutexLocker>
#include <QRegularExpression>
#include <QTcpServer>
#include <QTcpSocket>
#include <QThread>
#include <QTime>
#include <QTimer>
#include <QWaitCondition>

#include <atomic>
#include <chrono>
#include <condition_variable>
#include <cstdio>
#include <mutex>
#include <thread>
#include <vector>

#ifdef _WIN32
#include <winsock2.h>
#include <ws2tcpip.h>
#include <windows.h>
#else
#include <arpa/inet.h>
#include <sys/socket.h>
#include <unistd.h>
#endif

#include <cstdlib>

#include <mgba/core/core.h>
#include <mgba/core/config.h>
#include <mgba-util/audio-resampler.h>
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
 * Bare sio_link backend for the cloud SIO bridge: no core, but the NetLink
 * inside comes up, which is what the 分开控制 E2E asserts on.
 */
class TestSioHost : public QGBA::SioLinkHost {
public:
	~TestSioHost() override {
		if (m_sio) {
			sioLinkDestroy(m_sio);
		}
	}

	bool sioHost(quint16 port) override {
		if (!m_sio) {
			m_sio = sioLinkCreate();
		}
		return m_sio && sioLinkHost(m_sio, int(port));
	}

	bool sioJoin(const QString& host, quint16 port) override {
		if (!m_sio) {
			m_sio = sioLinkCreate();
		}
		return m_sio && sioLinkJoin(m_sio, host.toUtf8().constData(), int(port));
	}

	void sioClose() override {
		if (m_sio) {
			sioLinkDestroy(m_sio);
			m_sio = nullptr;
		}
	}

	struct SioLink* m_sio = nullptr;
};

/**
 * Two-instance room test: the host creates a room and writes its id to
 * roomFile; the joiner waits for the file, joins, and both PASS once the SIO
 * link comes up through the tunnel (分开控制: no keys are merged any more).
 */
static int cloudPairTest(const QString& user, const QString& password,
                         const QString& roomFile, const QString& role, const QString& rom) {
	int failures = 0;
	CloudLink link;
	TestSioHost sio;
	link.setController(&sio);
	QEventLoop loop;
	QStringList log;
	bool relayConnected = false;

	QObject::connect(&link, &CloudLink::statusMessage, [&](const QString& m) {
		log << m;
		if (m.contains(QStringLiteral("SIO 链路已建立"))) {
			relayConnected = true;
		}
		if (role == QStringLiteral("host")) {
			// Publish the room id as soon as the server hands it over. Digits
			// only: tunnel status lines like "（房号 100002）…" would otherwise
			// leak their closing bracket into the file.
			static QRegularExpression roomRe(QStringLiteral("房号\\s*(\\d+)"));
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

	// Toggle the local key mask so both sides see a non-zero remote key state
	// once the link is up - otherwise neither side ever presses anything and
	// the "keys flowing" assertion could never fire.
	QTimer keysTimer;
	bool keyPhase = false;
	QObject::connect(&keysTimer, &QTimer::timeout, [&]() {
		keyPhase = !keyPhase;
		link.setLocalKeys(keyPhase ? 0x0001 : 0x0000);
	});
	keysTimer.start(1500);

	QTimer::singleShot(role == QStringLiteral("host") ? 120000 : 90000, &loop, &QEventLoop::quit);
	loop.exec();
	keysTimer.stop();
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
/**
 * A TCP pipe that forwards bytes with a fixed per-direction delay, standing in
 * for the cloud tunnel's RTT so the SIO driver can be exercised against real
 * network latency in-process. Two reader threads enqueue chunks with a due
 * time; one sender thread releases them in order when due.
 */
class DelayPipe {
public:
	explicit DelayPipe(int delayMs)
		: m_delay(delayMs)
	{
	}

	bool start(int listenPort, const char* connectHost, int connectPort) {
		sockInitOnce();
		auto listenSock = listenLocal(listenPort);
		if (listenSock < 0) {
			qInfo().noquote() << QString("proxy: listen %1 failed wsa=%2").arg(listenPort).arg(WSAGetLastError());
			return false;
		}
		auto up = connectTo(connectHost, connectPort);
		if (up < 0) {
			qInfo().noquote() << QString("proxy: connect %1:%2 failed wsa=%3").arg(connectHost).arg(connectPort).arg(WSAGetLastError());
			closeSock(listenSock);
			return false;
		}
		// The joiner connects only after this returns; accept on a side thread.
		m_threads.emplace_back([this, up, listenSock]() {
			auto down = acceptOne(listenSock);
			closeSock(listenSock);
			if (down < 0) {
				qInfo().noquote() << "proxy: accept timed out";
				closeSock(up);
				return;
			}
			m_threads.emplace_back([this, up, down]() { reader(up, down); });
			m_threads.emplace_back([this, down, up]() { reader(down, up); });
			m_threads.emplace_back([this]() { sender(); });
		});
		return true;
	}

	~DelayPipe() {
		for (auto& t : m_threads) {
			t.detach(); // sockets and queue die with the process; test exit is fine
		}
	}

private:
	void sockInitOnce() {
#ifdef _WIN32
		static bool done = []() {
			WSADATA data;
			return WSAStartup(MAKEWORD(2, 2), &data) == 0;
		}();
		(void)done;
#endif
	}

	void reader(intptr_t from, intptr_t to) {
		uint8_t buf[4096];
		int seen = 0;
		while (true) {
#ifdef _WIN32
			int n = recv(static_cast<SOCKET>(from), reinterpret_cast<char*>(buf), sizeof(buf), 0);
#else
			int n = int(recv(static_cast<int>(from), buf, sizeof(buf), 0));
#endif
			if (n <= 0) {
				return;
			}
			++seen;
			// packet-level trace: first 40 chunks per direction, then any
			// PUSH-looking packet (magic "MBL1" at offset 0, type at 4)
			if (seen <= 40 || (n >= 6 && buf[0] == 'M' && buf[1] == 'B' && buf[2] == 'L' && buf[3] == '1')) {
				uint16_t type = n >= 6 ? (uint16_t)(buf[4] | (buf[5] << 8)) : 0;
				qInfo().noquote() << QString("proxy %1 %2->%3 #%4 %5B type=%6")
				                     .arg(QTime::currentTime().toString("hh:mm:ss.zzz"))
				                     .arg(from).arg(to).arg(seen).arg(n).arg(type);
			}
			QMutexLocker lock(&m_mu);
			m_queue.push_back({QDateTime::currentMSecsSinceEpoch() + quint64(m_delay), from, to,
			                   QByteArray(reinterpret_cast<const char*>(buf), n)});
			m_cond.wakeOne();
		}
	}

	void sender() {
		while (true) {
			QByteArray chunk;
			intptr_t to = 0;
			{
				QMutexLocker lock(&m_mu);
				while (m_queue.isEmpty()) {
					m_cond.wait(&m_mu);
				}
				quint64 now = QDateTime::currentMSecsSinceEpoch();
				int due = -1;
				for (int i = 0; i < m_queue.size(); i++) {
					if (m_queue[i].due <= now) {
						due = i;
						break;
					}
				}
				if (due < 0) {
					// earliest item still waiting: sleep out the remainder
					quint64 wait = m_queue[0].due - now;
					m_cond.wait(&m_mu, unsigned(qMin<quint64>(wait, 50)));
					continue;
				}
				chunk = m_queue[due].data;
				to = m_queue[due].to;
				m_queue.removeAt(due);
			}
			size_t off = 0;
			bool sent = true;
			while (off < size_t(chunk.size())) {
#ifdef _WIN32
				int n = send(static_cast<SOCKET>(to), chunk.constData() + off,
				             int(chunk.size() - off), 0);
#else
				ssize_t n = send(static_cast<int>(to), chunk.constData() + off, chunk.size() - off, 0);
#endif
				if (n <= 0) {
					sent = false;
					break;
				}
				off += size_t(n);
			}
			if (!sent || (chunk.size() >= 6 && chunk[0] == 'M' && chunk[1] == 'B'
			              && chunk[2] == 'L' && chunk[3] == '1' && chunk[4] == 5)) {
				uint16_t type = chunk.size() >= 6 ? (uint16_t)(chunk[4] | (chunk[5] << 8)) : 0;
				qInfo().noquote() << QString("proxy SENT %1 to=%2 %3B type=%4 ok=%5")
				                     .arg(QTime::currentTime().toString("hh:mm:ss.zzz"))
				                     .arg(to).arg(chunk.size()).arg(type).arg(sent ? 1 : 0);
			}
		}
	}

	static intptr_t listenLocal(int port) {
#ifdef _WIN32
		auto s = static_cast<intptr_t>(socket(AF_INET, SOCK_STREAM, IPPROTO_TCP));
#else
		auto s = static_cast<intptr_t>(socket(AF_INET, SOCK_STREAM, 0));
#endif
		if (s < 0) {
			return -1;
		}
		sockaddr_in addr;
		memset(&addr, 0, sizeof(addr));
		addr.sin_family = AF_INET;
		addr.sin_port = htons(quint16(port));
		inet_pton(AF_INET, "127.0.0.1", &addr.sin_addr);
		int one = 1;
		setsockopt(static_cast<SOCKET>(s), SOL_SOCKET, SO_REUSEADDR,
		           reinterpret_cast<const char*>(&one), sizeof(one));
		if (bind(static_cast<SOCKET>(s), reinterpret_cast<sockaddr*>(&addr), sizeof(addr)) != 0
		    || listen(static_cast<SOCKET>(s), 1) != 0) {
			closeSock(s);
			return -1;
		}
		return s;
	}

	static intptr_t connectTo(const char* host, int port) {
#ifdef _WIN32
		auto s = static_cast<intptr_t>(socket(AF_INET, SOCK_STREAM, IPPROTO_TCP));
#else
		auto s = static_cast<intptr_t>(socket(AF_INET, SOCK_STREAM, 0));
#endif
		if (s < 0) {
			return -1;
		}
		sockaddr_in addr;
		memset(&addr, 0, sizeof(addr));
		addr.sin_family = AF_INET;
		addr.sin_port = htons(quint16(port));
		inet_pton(AF_INET, host, &addr.sin_addr);
		if (connect(static_cast<SOCKET>(s), reinterpret_cast<sockaddr*>(&addr), sizeof(addr)) != 0) {
			closeSock(s);
			return -1;
		}
		return s;
	}

	static intptr_t acceptOne(intptr_t listener) {
		fd_set rset;
		FD_ZERO(&rset);
		FD_SET(static_cast<SOCKET>(listener), &rset);
		timeval tv{5, 0};
		if (select(static_cast<int>(listener) + 1, &rset, nullptr, nullptr, &tv) <= 0) {
			return -1;
		}
		return static_cast<intptr_t>(accept(static_cast<SOCKET>(listener), nullptr, nullptr));
	}

	static void closeSock(intptr_t s) {
#ifdef _WIN32
		closesocket(static_cast<SOCKET>(s));
#else
		close(static_cast<int>(s));
#endif
	}

	int m_delay;
	QMutex m_mu;
	QWaitCondition m_cond;
	struct Item {
		quint64 due;
		intptr_t from;
		intptr_t to;
		QByteArray data;
	};
	QList<Item> m_queue;
	std::vector<std::thread> m_threads;
};

/* ---- 动态 battle_main.o 判据窗口（T-03 补做 / ADR-002 R7）---------------
 * 历史判据把 battle_main.o .text 写死为 0x08099848..0x080A30FD，它只对某个
 * 特定 ROM 构建成立。/d/gen8 的 decomp 工程重编译后整段代码平移到
 * 0x080B19E4..0x080BB297，cb2trace 30 项均匀 +0x16E64；明明进了
 * BattleMainCB2（13:51 构建里是 0x080B3169）仍被判 BATTLE=NO。
 * 详见 production/sprint-2p/T-03-busgame-root-cause.md。
 *
 * 现在改为按 ROM 身份动态解析：
 *   1) 从 .map 读 `.text <start> <size> src/battle_main.o` 和 `BattleMainCB2`；
 *      由此推导「符号在段内偏移」与「段长」——这两个是**相对几何量**，多次
 *      重编译中恒定（0x1784 / 0x98B4），不再是绝对地址常量。
 *   2) 没有相邻 .map 的旧 ROM 用工作区 syms.txt 的 `0809afcd BattleMainCB2`
 *      配合同一套相对几何，算出该 ROM 自己的段区间。
 *   3) 每个候选区间都用**当前 ROM 自身的字节**校验：battle_main.o 段首 12 字节
 *      Thumb 序言在所有构建里相同（06 4B 1B 78 00 20 02 2B 06 D1 05 4A）。
 *      校验通过才认定属于这个 ROM，彻底绑定 ROM 身份，不做任何猜测。
 *   4) 找不到 .map / 符号，或全部候选都与 ROM 字节不符 → STALE_BATTLE_WINDOW
 *      并明确报错退出；**绝不静默退回旧常量**。
 * 覆盖入口：BUSGAME_BATTLE_MAP=<path> 显式指定（路径不存在即报错，用于构造
 * 「.map 缺失」场景）；未设时自动找 ROM 同目录 *.map → D:/gen8/rom.map →
 * D:/gen8/syms.txt。
 */
struct BattleWindow {
	uint32_t lo = 0;
	uint32_t hi = 0;   // exclusive
	QString source;
	QString romMd5;
	QString romMtime;
	bool valid = false;
	QString error;
};
static BattleWindow g_battleWindow;

static bool inBattleWindow(uint32_t cb2) {
	return g_battleWindow.valid && cb2 >= g_battleWindow.lo && cb2 < g_battleWindow.hi;
}

static QString romIdentity(const QString& romPath, QString* mtimeOut) {
	QFileInfo fi(romPath);
	*mtimeOut = fi.lastModified().toString(QStringLiteral("yyyy-MM-dd HH:mm:ss"));
	QFile f(romPath);
	if (!f.open(QIODevice::ReadOnly)) {
		return QString();
	}
	QCryptographicHash hash(QCryptographicHash::Md5);
	char buf[65536];
	qint64 n;
	while ((n = f.read(buf, sizeof(buf))) > 0) {
		hash.addData(buf, int(n));
	}
	return QString::fromLatin1(hash.result().toHex());
}

struct MapGeom {
	bool haveSection = false;
	uint32_t sectionStart = 0;
	uint32_t sectionSize = 0;
	bool haveSymbol = false;
	uint32_t symbol = 0;
};

static QStringList splitTokens(const QByteArray& line) {
	QStringList out;
	int i = 0;
	while (i < line.size()) {
		while (i < line.size() && std::isspace(static_cast<unsigned char>(line[i]))) {
			++i;
		}
		const int start = i;
		while (i < line.size() && !std::isspace(static_cast<unsigned char>(line[i]))) {
			++i;
		}
		if (i > start) {
			out << QString::fromLatin1(line.constData() + start, i - start);
		}
	}
	return out;
}

static uint32_t parseHexToken(const QString& token, bool* ok) {
	QString t = token;
	if (t.startsWith(QStringLiteral("0x"), Qt::CaseInsensitive)) {
		t = t.mid(2);
	}
	return t.toUInt(ok, 16);
}

static MapGeom parseMapGeom(const QString& path) {
	MapGeom g;
	QFile f(path);
	if (!f.open(QIODevice::ReadOnly)) {
		return g;
	}
	const QByteArray data = f.read(16 * 1024 * 1024);
	int off = 0;
	while (off < data.size()) {
		int eol = data.indexOf('\n', off);
		if (eol < 0) {
			eol = data.size();
		}
		const QByteArray line = QByteArray::fromRawData(data.constData() + off, eol - off).trimmed();
		off = eol + 1;
		if (line.isEmpty()) {
			continue;
		}
		const QStringList t = splitTokens(line);
		if (t.size() >= 4 && t[0] == QStringLiteral(".text")
		    && t[3].contains(QStringLiteral("battle_main.o"))) {
			bool ok1 = false, ok2 = false;
			const uint32_t start = parseHexToken(t[1], &ok1);
			const uint32_t size = parseHexToken(t[2], &ok2);
			if (ok1 && ok2 && start >= 0x08000000u && size > 0) {
				g.haveSection = true;
				g.sectionStart = start;
				g.sectionSize = size;
			}
		} else if (line.contains("BattleMainCB2")) {
			for (const QString& tok : t) {
				bool ok = false;
				const uint32_t addr = parseHexToken(tok, &ok);
				if (ok && addr >= 0x08000000u && addr < 0x09000000u) {
					g.haveSymbol = true;
					g.symbol = addr;
					break;
				}
			}
		}
	}
	return g;
}

/* battle_main.o 段首 AiPlayHandlesDialogue 的 12 字节序言；在旧零售布局
 * (0x08099848) 与 13:51 重编译布局 (0x080B19E4) 逐字节相同，是布局无关的
 * 内容指纹，用来把候选窗口绑定到当前 ROM。 */
static const unsigned char kBattleMainPrologue[12] = {
	0x06, 0x4B, 0x1B, 0x78, 0x00, 0x20, 0x02, 0x2B, 0x06, 0xD1, 0x05, 0x4A
};

static bool prologueAt(const QString& romPath, uint32_t addr) {
	if (addr < 0x08000000u) {
		return false;
	}
	QFile f(romPath);
	if (!f.open(QIODevice::ReadOnly)) {
		return false;
	}
	if (!f.seek(static_cast<qint64>(addr - 0x08000000u))) {
		return false;
	}
	const QByteArray head = f.read(12);
	return head.size() == 12
	       && std::memcmp(head.constData(), kBattleMainPrologue, 12) == 0;
}

static BattleWindow resolveBattleWindow(const QString& romPath) {
	BattleWindow w;
	w.romMd5 = romIdentity(romPath, &w.romMtime);
	if (w.romMd5.isEmpty()) {
		w.error = QStringLiteral("无法读取 ROM 计算 md5: ") + romPath;
		return w;
	}

	const QByteArray explicitMap = qgetenv("BUSGAME_BATTLE_MAP");
	const bool explicitOnly = !explicitMap.isEmpty();
	QStringList maps;
	if (explicitOnly) {
		maps << QString::fromLocal8Bit(explicitMap);
	} else {
		QDir dir(QFileInfo(romPath).absolutePath());
		maps << dir.absoluteFilePath(QStringLiteral("rom.map"));
		const QStringList extra = dir.entryList(QStringList() << QStringLiteral("*.map"),
		                                        QDir::Files, QDir::Name);
		for (const QString& name : extra) {
			const QString p = dir.absoluteFilePath(name);
			if (!maps.contains(p)) {
				maps << p;
			}
		}
		maps << QStringLiteral("D:/gen8/rom.map");
		maps << QStringLiteral("D:/gen8/syms.txt");
	}

	struct MapEntry { QString path; MapGeom geom; };
	QList<MapEntry> entries;
	QString tried;
	for (const QString& p : maps) {
		if (!QFile::exists(p)) {
			tried += p + QStringLiteral("(missing) ");
			continue;
		}
		const MapGeom g = parseMapGeom(p);
		entries.append(MapEntry{p, g});
		tried += p + (g.haveSection ? QStringLiteral("(section) ") : QString())
		         + (g.haveSymbol ? QStringLiteral("(symbol) ") : QString());
	}
	if (explicitOnly && entries.isEmpty()) {
		w.error = QStringLiteral("显式 BUSGAME_BATTLE_MAP 不存在或不可解析: ")
		          + QString::fromLocal8Bit(explicitMap);
		return w;
	}

	/* 相对几何：符号在段内的偏移 + 段长。两者从同一个 .map 推导，不是常量。 */
	uint32_t symOffset = 0, secSize = 0;
	for (const MapEntry& e : entries) {
		if (e.geom.haveSection && e.geom.haveSymbol && e.geom.sectionSize > 0
		    && (e.geom.symbol & ~1u) > e.geom.sectionStart) {
			symOffset = (e.geom.symbol & ~1u) - e.geom.sectionStart;
			secSize = e.geom.sectionSize;
			break;
		}
	}

	struct WindowCand { uint32_t lo; uint32_t hi; QString src; };
	std::vector<WindowCand> cands;
	for (const MapEntry& e : entries) {
		if (e.geom.haveSection && e.geom.sectionSize > 0) {
			cands.push_back(WindowCand{e.geom.sectionStart,
			                           e.geom.sectionStart + e.geom.sectionSize,
			                           e.path + QStringLiteral(" (.text)")});
		}
		if (e.geom.haveSymbol && symOffset > 0 && secSize > 0) {
			const uint32_t func = e.geom.symbol & ~1u;
			if (func > symOffset) {
				const uint32_t lo = func - symOffset;
				cands.push_back(WindowCand{lo, lo + secSize,
				                           e.path + QStringLiteral(" (BattleMainCB2-offset)")});
			}
		}
	}
	for (const WindowCand& c : cands) {
		if (c.hi <= c.lo || c.lo < 0x08000000u) {
			continue;
		}
		if (!prologueAt(romPath, c.lo)) {
			continue;   // 这个候选属于别的 ROM 构建，不能用
		}
		w.lo = c.lo;
		w.hi = c.hi;
		w.source = c.src;
		w.valid = true;
		return w;
	}
	w.error = QStringLiteral("没有候选 battle_main.o 窗口与当前 ROM 字节匹配；已尝试: ")
	          + tried
	          + QStringLiteral("；相对几何 symOffset=%1 secSize=%2 候选数=%3")
	                .arg(symOffset).arg(secSize).arg(int(cands.size()));
	return w;
}

/**
 * The LAN SIO test under a tunnel-like RTT: both directions delayed by
 * delayMs, so the round trip is 2x. Everything else matches lanSioTest - real
 * MULTI transfers between two cores, asserted on the SIOMULTI registers.
 */
/* 双核心基线（GBoy 架构的可行性验证）
 *
 * 一台设备里跑**两个** mGBA 核心，两者用 127.0.0.1 环回 SIO 互联（0.1ms 级），
 * 外网只传按键掩码。这一步要回答的是：两个核心在本机环回下能不能真的走完
 * 「大竞技场 → 单打 → LINKUP → 训练家卡片块交换 → 站位 → 进对战」。
 *
 * 帧驱动：每帧先跑从机再跑主机（与 lanSioTest 相同的顺序，避免主机先跑把
 * 从机的 serviceLink 关在门外），每帧两边各 pump 一次环回链路。
 * 按键脚本用帧号切分，帧号可通过环境变量微调，不用重编。
 */
static int dualTest(const QString& rom, const QString& sav) {
	/* T-03 补做：判据窗口按当前 ROM 动态解析。dual 模式默认用合成 ROM
	 * (test.gba)，没有 .map 时只打 STALE_BATTLE_WINDOW 警告并让 battleSeen
	 * 保持 0 —— 不静默套用旧常量，也不让无关的基线用例硬失败。 */
	g_battleWindow = resolveBattleWindow(rom);
	if (!g_battleWindow.valid) {
		fprintf(stderr, "STALE_BATTLE_WINDOW: %s (dualTest: battleSeen stays 0)\n",
		        qPrintable(g_battleWindow.error));
	} else {
		fprintf(stderr, "BATTLE_WINDOW: [%08X,%08X) source=%s romMd5=%s romMtime=%s\n",
		        g_battleWindow.lo, g_battleWindow.hi,
		        qPrintable(g_battleWindow.source), qPrintable(g_battleWindow.romMd5),
		        qPrintable(g_battleWindow.romMtime));
	}
	fflush(stderr);
	struct mCore* cores[2] = { nullptr, nullptr };
	struct SioLink* links[2] = { nullptr, nullptr };
	static mColor video[2][240 * 160];
	int failures = 0;

	const uint32_t A = 1, START = 8, RIGHT = 16, LEFT = 32, UP = 64, DOWN = 128;
	auto envInt = [](const char* k, int dflt) {
		bool ok = false;
		int v = qEnvironmentVariableIntValue(k, &ok);
		return ok ? v : dflt;
	};

	QString romAbs = QFileInfo(rom).absoluteFilePath();
	QString savAbs = QFileInfo(sav).absoluteFilePath();
	for (int i = 0; i < 2; i++) {
		QByteArray romUtf8 = romAbs.toUtf8();
		VFile* romVf = VFileOpen(romUtf8.constData(), O_RDONLY);
		if (!romVf) {
			romVf = VFileOpenFD(romUtf8.constData(), O_RDONLY);
		}
		if (!romVf) {
			qInfo().noquote() << "DUAL TEST: FAIL (cannot open rom)";
			return 1;
		}
		cores[i] = mCoreFindVF(romVf);
		if (!cores[i]) {
			qInfo() << "DUAL TEST: FAIL (no core)";
			return 1;
		}
		cores[i]->init(cores[i]);
		mCoreConfigInit(&cores[i]->config, NULL);
		/* 默认 filter 是 mLOG_ALL，一次完整对局能刷出 47MB 日志，两个线程
		 * 的 stderr 还会互相插行。只保留 WARN 以上，基线输出才可读。 */
		mCoreConfigSetIntValue(&cores[i]->config, "logLevel", mLOG_WARN);
		if (!cores[i]->loadROM(cores[i], romVf)) {
			qInfo() << "DUAL TEST: FAIL (loadROM)";
			return 1;
		}
		/* 两个核心必须从同一份存档起步（GBoy 的 STATE 同步等价物）。 */
		if (QFile::exists(savAbs)) {
			VFile* sv = VFileOpen(savAbs.toUtf8().constData(), O_RDWR);
			if (sv && !cores[i]->loadSave(cores[i], sv)) {
				qInfo() << "DUAL TEST: WARN (loadSave failed)";
			}
		}
		cores[i]->reset(cores[i]);
		cores[i]->setVideoBuffer(cores[i], video[i], 240);
		links[i] = sioLinkCreate();
	}

	const quint16 port = (quint16) envInt("DUAL_PORT", 18791);
	if (!sioLinkHost(links[0], port)) {
		qInfo() << "DUAL TEST: FAIL (cannot listen)";
		return 1;
	}
	if (!sioLinkJoin(links[1], "127.0.0.1", port)) {
		qInfo() << "DUAL TEST: FAIL (cannot connect)";
		return 1;
	}
	for (int i = 0; i < 100 && sioLinkState(links[0]) != 2; i++) {
		sioLinkPump(links[0], cores[0]);
		sioLinkPump(links[1], cores[1]);
		QThread::msleep(20);
	}
	if (sioLinkState(links[0]) != 2 || sioLinkState(links[1]) != 2) {
		qInfo() << "DUAL TEST: FAIL (link never connected)";
		return 1;
	}

	struct GBA* gba[2] = { (struct GBA*) cores[0]->board, (struct GBA*) cores[1]->board };
	GBASIOWriteRCNT(&gba[0]->sio, 0);
	GBASIOWriteRCNT(&gba[1]->sio, 0);

	/* 帧脚本（默认值按 60fps 估）：boot → START×2 → A 连打进场 → 菜单 DOWN+A
	 * → 战斗模式 UP/LEFT 钳到单打 → A → 存档确认 A 连打 → 等待连接 A 连打 */
	int bootFrames = envInt("DUAL_BOOT", 240);
	int menuAt = envInt("DUAL_MENU_AT", 1500);   /* 到达联机菜单的帧号 */
	int saveAt = envInt("DUAL_SAVE_AT", menuAt + 240);
	int totalFrames = envInt("DUAL_FRAMES", 12000);

	/* 两个核心必须各跑一个线程。
	 *
	 * 单线程轮流 runFrame 会死锁：主机在 sioDone 里阻塞等对端字时，从机核心
	 * 根本没在跑（实测卡在 want=42，retries 一路涨到 33）。真机/产品形态本来
	 * 就是「两个核心、两条执行流，SIO 锁步自然把它们对齐」，这里照抄该结构。
	 */
	struct Side {
		struct mCore* core;
		struct SioLink* link;
		std::atomic<int>* frames;
		int total;
		int boot, menuAt, saveAt;
		int tx, ty;      /* 座位格：1P=(3,5) 2P=(10,5) */
		int dir;
		int stuck;
		int lastX, lastY;
	};
	static std::atomic<bool> gStop(false);
	/* 两端都站上座位后才允许按 A。23:46 基线里 1P 先到 (3,5) 就立刻连打 A，
	 * 此时 2P 还在 (8,6) 走位，进程在约 12000 帧处直接消失。真机驱动是
	 * 「两端都到位，再由主机按 A」，这里照抄，避免用未同步的座位状态开打。 */
	static std::atomic<int> gSeated(0);
	std::atomic<int> frames[2];
	frames[0] = 0;
	frames[1] = 0;
	gStop = false;
	gSeated = 0;

	Side sides[2] = {
		{ cores[0], links[0], &frames[0], totalFrames, bootFrames, menuAt, saveAt, 3, 5, 0, 0, -1, -1 },
		{ cores[1], links[1], &frames[1], totalFrames, bootFrames, menuAt, saveAt, 10, 5, 0, 0, -1, -1 },
	};
	auto body = [](Side* sd) {
		int hold = 0;
		int phase = 0;   /* 0=菜单脚本，1=闭环走位，2=按 A 收尾 */
		for (int f = 0; f < sd->total && !gStop; f++) {
			uint32_t keys = 0;
			struct GBA* g = (struct GBA*) sd->core->board;
			uint32_t sb = GBAView32(g->cpu, 0x03004964u);
			int px = 0, py = 0;
			if (sb >= 0x02000000u && sb < 0x03000000u) {
				px = (int16_t) GBAView16(g->cpu, sb);
				py = (int16_t) GBAView16(g->cpu, sb + 2);
			}
			uint16_t ts = GBAView16(g->cpu, 0x03004A10u);
			int cnt = (GBAView16(g->cpu, 0x03004A38u) >> 8) & 0xFF;
			/* 触发点：LINKUP 一成功（cnt>=2）就开始走位，不要等卡片交换跑完
			 * （ts=0x80）。ts=80 时游戏已经进了竞技场房间的 standby 脚本，
			 * 方向键会被锁住 —— 21:10/21:14 两轮 px/py 死死停在 (5,8) 就是这个
			 * 原因；而真机流程本来就是「先站到座位，再等卡片交换完成」。 */
			if (phase == 0 && cnt >= 2 && (ts & 0xFF) == 0x80) {
				phase = 1;   /* 卡片交换完成、已被 warp 进竞技场，此时才可自由行走 */
			}
			/* 菜单脚本只能在 phase 0 生效。此前这里没有条件，saveAt 之后的
			 * A 连打会覆盖 phase 1 刚设好的方向键，两端因此永远停在 (5,8)/
			 * (6,8)（23:32 基线实测：cnt=2、ts=8080，但坐标 40 秒不动）。 */
			if (phase == 0) {
				if (f >= sd->boot && f < sd->boot + 6) {
					keys = 8;                       /* START */
				} else if (f >= sd->boot + 10 && f < sd->boot + 16) {
					keys = 8;
				} else if (f >= sd->boot + 20 && f < sd->menuAt) {
					keys = ((f % 45) < 30) ? 1u : 0u;   /* A 连打 */
				} else if (f >= sd->menuAt && f < sd->menuAt + 8) {
					keys = 128;                     /* DOWN：交换中心 → 大竞技场 */
				} else if (f >= sd->menuAt + 30 && f < sd->menuAt + 40) {
					keys = 1;
				} else if (f >= sd->menuAt + 40 && f < sd->menuAt + 60) {
					keys = 64;                      /* UP：钳到单打 */
				} else if (f >= sd->menuAt + 60 && f < sd->menuAt + 80) {
					keys = 32;                      /* LEFT：钳到单打 */
				} else if (f >= sd->menuAt + 80 && f < sd->menuAt + 92) {
					keys = 1;
				} else if (f >= sd->saveAt) {
					keys = ((f % 40) < 25) ? 1u : 0u;
				}
			}
			if (phase == 1 || phase == 2) {
				if (px == sd->tx && py == sd->ty) {
					if (phase != 2) {
						phase = 2;
						gSeated.fetch_add(1);
					}
				} else if (hold > 0) {
					hold--;
					keys = sd->dir;   /* 维持当前方向键 */
				} else {
					/* 先按差得多的轴走；连续两次没位移就换另一个轴。
					 * 21:39 实测：站在 (5,8) 时正上方是柜台，固定先走 Y 轴会
					 * 一直顶着柜台不动（px/py 整轮不变），而真机路线是
					 * 先横移到空列再上。 */
					if (px != sd->lastX || py != sd->lastY) {
						sd->stuck = 0;
						sd->lastX = px;
						sd->lastY = py;
					} else if (sd->stuck < 4) {
						sd->stuck++;
					}
					bool preferX = sd->stuck >= 2;
					if (preferX ? (px != sd->tx) : (py == sd->ty)) {
						sd->dir = (px > sd->tx) ? 32 : 16;      /* LEFT / RIGHT */
					} else if (preferX) {
						sd->dir = (py > sd->ty) ? 64 : 128;     /* UP / DOWN */
					} else {
						sd->dir = (py > sd->ty) ? 64 : 128;
					}
					hold = 40;   /* 一格走路动画约 16 帧，留足余量 */
					keys = sd->dir;
				}
				if (phase == 2 && gSeated.load() >= 2) {
					keys = ((f % 40) < 20) ? 1u : 0u;   /* 两端都到位后按 A 开打 */
				}
			}
			sd->core->setKeys(sd->core, keys);
			sioLinkPump(sd->link, sd->core);
			sd->core->runFrame(sd->core);
			*sd->frames = f + 1;
		}
	};
	std::thread t1(body, &sides[0]);
	std::thread t2(body, &sides[1]);

	int cntSeen = 0, battleSeen = 0, printed = 0;
	for (int guard = 0; guard < totalFrames * 40; guard++) {
		int a = frames[0].load();
		int b = frames[1].load();
		if ((a >= totalFrames && b >= totalFrames) || (a == 0 && b == 0 && guard > 300)) {
			break;
		}
		if (printed < 200 && (a / 60) != (printed)) {
			/* 每 60 帧打一次（以主机帧号为准） */
			uint16_t l0 = GBAView16(gba[0]->cpu, 0x03002AF4u);
			uint16_t l1 = GBAView16(gba[0]->cpu, 0x03002AF6u);
			uint16_t lidcnt = GBAView16(gba[0]->cpu, 0x03004A38u);
			uint16_t ts = GBAView16(gba[0]->cpu, 0x03004A10u);
			uint16_t brs = GBAView16(gba[0]->cpu, 0x03002A40u);
			/* gMain.callback2 在 0x02029118；0x03002AD4 是 gLinkCallback，
			 * 不是 callback2。旧判据 0x0809A241 也已作废（BattleMainCB2+1
			 * = 0x0809AFCD，battle_main.o .text = 0x08099848..0x080A30FC）。 */
			uint32_t cb2 = GBAView32(gba[0]->cpu, 0x02029118u);
			uint32_t sb1 = GBAView32(gba[0]->cpu, 0x03004964u);
			int px = 0, py = 0;
			if (sb1 >= 0x02000000u && sb1 < 0x03000000u) {
				px = (int16_t) GBAView16(gba[0]->cpu, sb1);
				py = (int16_t) GBAView16(gba[0]->cpu, sb1 + 2);
			}
			uint32_t ic0 = (uint32_t) GBAView16(gba[0]->cpu, 0x03004A14u) |
			               ((uint32_t) GBAView16(gba[0]->cpu, 0x03004A16u) << 16);
			/* 从机侧同项，用来判断两端是否停在同一个游戏状态 */
			uint32_t ts1v = GBAView16(gba[1]->cpu, 0x03004A10u);
			uint32_t ic1 = (uint32_t) GBAView16(gba[1]->cpu, 0x03004A14u) |
			               ((uint32_t) GBAView16(gba[1]->cpu, 0x03004A16u) << 16);
			int cnt1 = (GBAView16(gba[1]->cpu, 0x03004A38u) >> 8) & 0xFF;
			uint32_t sbB = GBAView32(gba[1]->cpu, 0x03004964u);
			int qx = 0, qy = 0;
			if (sbB >= 0x02000000u && sbB < 0x03000000u) {
				qx = (int16_t) GBAView16(gba[1]->cpu, sbB);
				qy = (int16_t) GBAView16(gba[1]->cpu, sbB + 2);
			}
			fprintf(stderr, "f=%d/%d P1[lst=%u lid=%u pc=%u cnt=%d ts=%04X ic=%08X cb=%08X %d,%d]"
			        " P2[cnt=%d ts=%04X ic=%08X %d,%d]\n",
			        a, b, (l0 >> 8) & 0xFF, l1 & 0xFF, GBAView8(gba[0]->cpu, 0x03002AF7u),
			        (lidcnt >> 8) & 0xFF, ts, ic0, cb2, px, py,
			        cnt1, ts1v, ic1, qx, qy);
			fflush(stderr);
			printed = a / 60;
			if (((lidcnt >> 8) & 0xFF) >= 2) {
				cntSeen = 1;
			}
			/* T-03 补做：窗口由当前 ROM 的 .map/符号 + ROM 字节校验动态解析，
			 * 不再写死旧布局常量；解析失败时 inBattleWindow() 恒 false 并已在
			 * 入口打印 STALE_BATTLE_WINDOW，不会静默退回旧常量。 */
			if (inBattleWindow(cb2)) {
				battleSeen = 1;
			}
		}
		QThread::msleep(30);
	}
	gStop = true;
	t1.join();
	t2.join();

	{
		uint16_t lidcnt = GBAView16(gba[0]->cpu, 0x03004A38u);
		if (((lidcnt >> 8) & 0xFF) >= 2) {
			cntSeen = 1;
		}
	}
	uint32_t cb2 = GBAView32(gba[0]->cpu, 0x02029118u);
	if (inBattleWindow(cb2)) {
		battleSeen = 1;
	}
	qInfo().noquote() << QString("DUAL TEST: cnt=%1 battle=%2 final cb2=%3")
	                     .arg(cntSeen).arg(battleSeen)
	                     .arg(cb2, 8, 16, QChar('0'));
	fprintf(stderr, "DUAL TEST: cnt=%d battle=%d final cb2=%08X\n", cntSeen, battleSeen, cb2);
	fflush(stderr);
	if (!cntSeen) {
		++failures;
	}
	for (int i = 0; i < 2; i++) {
		sioLinkDestroy(links[i]);
		cores[i]->deinit(cores[i]);
	}
	qInfo() << (failures ? "DUAL TEST: FAIL" : "DUAL TEST: PASS (2 cores linked on loopback)");
	fprintf(stderr, "DUAL TEST: %s\n", failures ? "FAIL" : "PASS (2 cores linked on loopback)");
	fflush(stderr);
	return failures;
}


/**
 * 3/4 人总线端到端：N 个真实内核、各占一个线程，主机每轮起一次 MULTI 传输。
 *
 * 与 lanSioTest 的区别：两人用例是单线程交替 pump（谁都不会阻塞太久）；总线里
 * 从机的轮次事件要等主机的广播，单线程交替必然在某一端空等满窗口，所以必须
 * 一个内核一个线程 —— 和安卓那边「双核心必须两核两线程」是同一条硬约束。
 *
 * 断言：
 *   1. N 条链路全部 state==2、SIO 驱动全部挂上、设备号 0..N-1；
 *   2. 每个从机的 SIOMULTI0 里是**主机某一轮的字**（0x7000..0x7007）——
 *      这就是「主机广播真的过了总线、进了游戏的接收寄存器」。
 */
/* 进程内总线的指定槽位 join：PC/Qt 与 Android 共用同一份 link_net.c，
 * 这里验证 Qt 侧入口把 slot 正确透传；C 层的会合语义由 mobile_test 覆盖。 */
static int busLocalSlotTest(void) {
	const int key = 18770;
	struct SioLink* links[4];
	struct SioLink* spare = sioLinkCreate();
	int failures = 0;
	for (int i = 0; i < 4; ++i) {
		links[i] = sioLinkCreate();
	}
	auto check = [&](bool ok, const char* what) {
		if (!ok) {
			fprintf(stderr, "BUSLOCAL TEST: FAIL %s\n", what);
			++failures;
		}
	};
	check(sioLinkHostPlayersLocal(links[0], key, 4), "local host up");
	check(sioLinkPlayer(links[0]) == 0, "host owns link slot 0");
	check(sioLinkJoinPlayersLocalSlot(links[2], key, 2), "join slot 2 out of order");
	check(sioLinkPlayer(links[2]) == 2, "slot 2 recorded on the Qt side");
	check(!sioLinkJoinPlayersLocalSlot(spare, key, 2), "duplicate slot rejected");
	check(!sioLinkJoinPlayersLocalSlot(spare, key, 0), "host slot reserved");
	check(!sioLinkJoinPlayersLocalSlot(spare, key, 4), "slot beyond players rejected");
	check(sioLinkJoinPlayersLocalSlot(links[1], key, 1), "join slot 1");
	check(sioLinkJoinPlayersLocalSlot(links[3], key, 3), "join slot 3");
	check(sioLinkPlayerCount(links[0]) == 4, "all four slots attached");
	if (!failures) {
		fprintf(stderr, "BUSLOCAL TEST: PASS (slot-tagged local bus join)\n");
	}
	sioLinkDestroy(spare);
	for (int i = 1; i < 4; ++i) {
		sioLinkDestroy(links[i]);
	}
	sioLinkDestroy(links[0]);
	return failures;
}

/* PC 会话层与 Android GBoyLinkSession.java / iOS LobbyLink.swift 的槽位规则
 * 必须一致：3/4 人时按本机槽位发带槽位帧（11/12/17）；裸 TYPE_KEYS 代表
 * 「对端那台设备」，落点由 defaultSenderSlot() 决定 —— 云端 4 核两端都用
 * localSlot=1，所以裸键帧固定落 slot 2；其它本机槽位落 slot 1。 */
static int gboySessionSlotTest(void) {
	int failures = 0;
	auto check = [&](bool ok, const char* what) {
		if (!ok) {
			fprintf(stderr, "SESSIONSLOT TEST: FAIL %s\n", what);
			++failures;
		}
	};
	const int expected[4] = {GBoyFrames::TYPE_KEYS, GBoyFrames::TYPE_INPUT_2,
	                         GBoyFrames::TYPE_INPUT_3, GBoyFrames::TYPE_INPUT_4};
	for (int slot = 1; slot <= 4; ++slot) {
		QByteArray sent;
		GBoyLinkSession::Events ev;
		ev.onReset = []() {};
		ev.onState = [](const QByteArray&) {};
		ev.onReady = []() {};
		ev.onStatus = [](const QString&) {};
		GBoyLinkSession session([&](const QByteArray& f) { sent = f; }, ev, slot, 4);
		QByteArray wire = session.onLocalFrame(0, 0x100 + slot);
		check(!wire.isNull(), "session broadcasts on frame 0");
		check(GBoyFrames::getInt(wire, 0) == 6, "key frame keeps the 10 byte layout");
		check((int) GBoyFrames::getShort(wire, 4) == expected[slot - 1],
		      "PC session uses the slot-tagged frame type");
		check((int) GBoyFrames::getInt(wire, 6) == 0x100 + slot,
		      "PC session carries its own key mask");
	}
	{
		QByteArray sent;
		GBoyLinkSession::Events ev;
		ev.onReset = []() {};
		ev.onState = [](const QByteArray&) {};
		ev.onReady = []() {};
		ev.onStatus = [](const QString&) {};
		GBoyLinkSession two([&](const QByteArray& f) { sent = f; }, ev, 2, 2);
		QByteArray wire = two.onLocalFrame(0, 0x55);
		check(GBoyFrames::getShort(wire, 4) == GBoyFrames::TYPE_KEYS,
		      "two-player session still sends TYPE_KEYS");
	}
	{
		QByteArray sent;
		GBoyLinkSession::Events ev;
		ev.onReset = []() {};
		ev.onState = [](const QByteArray&) {};
		ev.onReady = []() {};
		ev.onStatus = [](const QString&) {};
		GBoyLinkSession peer([&](const QByteArray& f) { sent = f; }, ev, 2, 4);
		/* 会话层在 ready 之前会忽略按键帧（官方 type 0 在握手期是节奏信号），
		 * 先补一条 type 3 把对端标成就绪，再验槽位路由。 */
		peer.onWireFrame(GBoyFrames::frame(GBoyFrames::TYPE_READY, 0));
		peer.onWireFrame(GBoyFrames::frame(GBoyFrames::TYPE_KEYS, 0x5A));
		for (int f = 1; f <= 5; ++f) {
			peer.onLocalFrame(f, 0);
		}
		check(peer.keysForSlot(1) == 0x5A,
		      "localSlot=2 (4-player) sends a bare key frame to slot 1");
	}
	/* 云端 4 核的真实构造是两端都 localSlot=1：裸 TYPE_KEYS 必须落 slot 2
	 * （对端那台设备），不能盖到自己的可见核上。 */
	{
		GBoyLinkSession::Events ev;
		ev.onReset = []() {};
		ev.onState = [](const QByteArray&) {};
		ev.onReady = []() {};
		ev.onStatus = [](const QString&) {};
		GBoyLinkSession peer([](const QByteArray&) {}, ev, 1, 4);
		peer.onWireFrame(GBoyFrames::frame(GBoyFrames::TYPE_READY, 0));
		peer.onWireFrame(GBoyFrames::frame(GBoyFrames::TYPE_KEYS, 0x3C));
		check(peer.keysForSlot(2) == 0x3C,
		      "cloud 4-core layout (localSlot=1) routes bare keys to slot 2");
	}
	/* 直连 / TCP / 蓝牙在官方模式下只靠 type 1 互置 ready（B25kr6:122/128）。
	 * 两会话互喂 sendSocketHandshake 后必须都 ready，且键帧能落进按键表；
	 * 这条路径不会被 frames/buslocal 的其它用例覆盖。 */
	{
		QByteArray fromA;
		QByteArray fromB;
		GBoyLinkSession::Events ev;
		ev.onReset = []() {};
		ev.onState = [](const QByteArray&) {};
		ev.onReady = []() {};
		ev.onStatus = [](const QString&) {};
		GBoyLinkSession a([&fromA](const QByteArray& f) { fromA = f; }, ev, 1, 2);
		GBoyLinkSession b([&fromB](const QByteArray& f) { fromB = f; }, ev, 2, 2);
		a.sendSocketHandshake();
		b.sendSocketHandshake();
		check(!fromA.isEmpty() && !fromB.isEmpty(),
		      "both ends emit the type 1 handshake");
		check(GBoyFrames::typeOf(fromA.mid(4)) == GBoyFrames::TYPE_REGISTER
		      && GBoyFrames::intOf(fromA.mid(4)) == 6,
		      "the handshake is type 1 carrying int 6");
		a.onWireFrame(fromB);
		b.onWireFrame(fromA);
		check(a.isReady() && b.isReady(),
		      "type 1 handshake marks both peers ready");
		a.onWireFrame(GBoyFrames::frame(GBoyFrames::TYPE_KEYS, 0x21));
		check(a.keysForSlot(2) == 0x21,
		      "keys flow after the type 1 handshake on the direct path");
		/* 握手第三步的 type3 带 int 0，不能把 remoteRtt 从 -1 改成 0。 */
		check(a.remoteRtt() == -1, "a zero-rtt handshake frame is not recorded");
		a.onWireFrame(GBoyFrames::frame(GBoyFrames::TYPE_READY, 37));
		check(a.remoteRtt() == 37, "a real type 3 rtt is recorded");
	}
	/* 官方 9 = 倍速、5 = 复位（NETPLAY_AUDIT.md C1/C3）。 */
	{
		bool reset = false;
		GBoyLinkSession::Events ev;
		ev.onReset = [&reset]() { reset = true; };
		ev.onState = [](const QByteArray&) {};
		ev.onReady = []() {};
		ev.onStatus = [](const QString&) {};
		GBoyLinkSession peer([](const QByteArray&) {}, ev, 1, 4);
		check(peer.remoteSpeed() == 0, "type 9 is unset (1x) before the peer sends one");
		peer.onWireFrame(GBoyFrames::frame(GBoyFrames::TYPE_SPEED, 2));
		check(peer.remoteSpeed() == 2, "type 9 records the peer speed multiplier");
		/* 官方帧闸 nanos = 1e9/(speed*60)：1x/0.5x/2x/4x。 */
		check(qAbs(GBoyLinkSession::tickMsForSpeed(1) - 16.667) < 0.05,
		      "1x frame gate is 16.7 ms");
		check(qAbs(GBoyLinkSession::tickMsForSpeed(-1) - 33.333) < 0.05,
		      "-1 (0.5x) frame gate is 33.3 ms");
		check(qAbs(GBoyLinkSession::tickMsForSpeed(2) - 8.333) < 0.05,
		      "2x frame gate is 8.3 ms");
		check(qAbs(GBoyLinkSession::tickMsForSpeed(4) - 4.167) < 0.05,
		      "4x frame gate is 4.2 ms");
		check(GBoyLinkSession::effectiveSpeed(0) == 1.0
		      && GBoyLinkSession::effectiveSpeed(7) == 1.0,
		      "an unset or invalid speed falls back to 1x");
		/* 菜单四个值 → 实际倍率（0.5x/1x/2x/4x）。 */
		check(GBoyLinkSession::effectiveSpeed(-1) == 0.5
		      && GBoyLinkSession::effectiveSpeed(1) == 1.0
		      && GBoyLinkSession::effectiveSpeed(2) == 2.0
		      && GBoyLinkSession::effectiveSpeed(4) == 4.0,
		      "0.5x/1x/2x/4x map to the official multipliers");
		peer.onWireFrame(GBoyFrames::frame(GBoyFrames::TYPE_RESET, 0));
		check(reset, "type 5 is a reset, not a ready ack");
		reset = false;
		peer.onWireFrame(GBoyFrames::frame(GBoyFrames::TYPE_RESET_LEGACY, 0));
		check(reset, "the legacy type 13 still resets old clients");
	}
	/* 会话层握手 → ready → 按键放行的最小闭环。
	 *
	 * 这条是为一类真实回归守门的：直连路径曾经一次 type 1 都不发，于是两端
	 * m_ready 永远为 false，`case TYPE_KEYS` 的握手期门控把**每一帧** type 0
	 * 都当「节奏信号」丢掉 —— 现象是对端按键全无响应，而 buslocal/frames
	 * 都不跑 serveOfficial，测不出来。 */
	{
		QByteArray emitted;
		bool ready = false;
		GBoyLinkSession::Events ev;
		ev.onReady = [&ready]() { ready = true; };
		ev.onReset = []() {};
		ev.onState = [](const QByteArray&) {};
		ev.onStatus = [](const QString&) {};
		GBoyLinkSession me([&emitted](const QByteArray& f) { emitted = f; }, ev, 1, 4);
		me.sendSocketHandshake();
		check(!emitted.isNull(), "socket handshake emits a frame");
		check(!me.isReady(), "session is not ready before the peer answers");
		me.onWireFrame(emitted);
		check(me.isReady(), "type 1 handshake marks the session ready");
		check(ready, "onReady fires once the handshake lands");
		me.onWireFrame(GBoyFrames::frame(GBoyFrames::TYPE_KEYS, 1));
		check(me.keysForSlot(2) == 1, "keys pass through after ready");
	}

	/* 镜像核槽位映射必须与 Android / iOS 逐项一致。 */
	const int expectedMap[4][3] = {
		{2, 3, 4}, {1, 3, 4}, {1, 2, 4}, {1, 2, 3}
	};
	for (int slot = 1; slot <= 4; ++slot) {
		for (int index = 0; index < 3; ++index) {
			check(GBoyLinkSession::mirrorSlotFor(slot, 4, index) == expectedMap[slot - 1][index],
			      "PC mirror slot map matches the other clients");
		}
	}
	check(GBoyLinkSession::mirrorSlotFor(2, 3, 0) == 1,
	      "PC three-player mirror map matches");
	check(GBoyLinkSession::mirrorSlotFor(1, 2, 0) == 2,
	      "PC two-player mirror map is unchanged");
	check(GBoyLinkSession::mirrorSlotFor(3, 2, 0) == 0,
	      "PC rejects an out of range slot");
	if (!failures) {
		fprintf(stderr, "SESSIONSLOT TEST: PASS (PC session slot routing)\n");
	}
	return failures;
}

static int busSioTest(const QString& rom, int players) {
	if (players < 3) {
		players = 3;
	}
	if (players > 4) {
		players = 4;
	}
	const int port = 18766;
	struct mCore* cores[4] = { nullptr, nullptr, nullptr, nullptr };
	struct SioLink* links[4] = { nullptr, nullptr, nullptr, nullptr };
	static mColor video[4][240 * 160];
	int failures = 0;

	const QByteArray romUtf8 = QFileInfo(rom).absoluteFilePath().toUtf8();
	for (int i = 0; i < players; i++) {
		VFile* romVf = VFileOpen(romUtf8.constData(), O_RDONLY);
		if (!romVf) {
			romVf = VFileOpenFD(romUtf8.constData(), O_RDONLY);
		}
		if (!romVf) {
			qInfo().noquote() << "BUS TEST: FAIL (cannot open" << rom << ")";
			return 1;
		}
		cores[i] = mCoreFindVF(romVf);
		if (!cores[i]) {
			qInfo().noquote() << "BUS TEST: FAIL (cannot find core)";
			return 1;
		}
		cores[i]->init(cores[i]);
		mCoreConfigInit(&cores[i]->config, NULL);
		if (!cores[i]->loadROM(cores[i], romVf)) {
			qInfo() << "BUS TEST: FAIL (cannot load ROM)";
			return 1;
		}
		cores[i]->reset(cores[i]);
		cores[i]->setVideoBuffer(cores[i], video[i], 240);
		links[i] = sioLinkCreate();
	}

	if (!sioLinkHostPlayers(links[0], port, players)) {
		qInfo() << "BUS TEST: FAIL (cannot listen)";
		return 1;
	}
	for (int i = 1; i < players; i++) {
		if (!sioLinkJoinPlayers(links[i], "127.0.0.1", port, players)) {
			qInfo().noquote() << QString("BUS TEST: FAIL (cannot connect %1)").arg(i);
			return 1;
		}
	}
	for (int k = 0; k < 300; k++) {
		bool all = true;
		for (int i = 0; i < players; i++) {
			sioLinkPump(links[i], cores[i]);
			if (sioLinkState(links[i]) != 2) {
				all = false;
			}
		}
		if (all) {
			break;
		}
		QThread::msleep(20);
	}
	for (int i = 0; i < players; i++) {
		sioLinkPump(links[i], cores[i]);
		if (sioLinkState(links[i]) != 2) {
			qInfo().noquote() << QString("BUS TEST: FAIL (link %1 state %2)").arg(i).arg(sioLinkState(links[i]));
			++failures;
		}
		struct GBA* gba = (struct GBA*) cores[i]->board;
		if (!gba->sio.driver) {
			qInfo().noquote() << QString("BUS TEST: FAIL (driver not attached on %1)").arg(i);
			++failures;
			continue;
		}
		gba->sio.rcnt = 0;   /* 真 ROM 会先写 RCNT 把引脚切出 GPIO */
		int id = gba->sio.driver->deviceId(gba->sio.driver);
		if (id != i) {
			qInfo().noquote() << QString("BUS TEST: FAIL (core %1 got device id %2)").arg(i).arg(id);
			++failures;
		}
	}
	if (failures) {
		return failures;
	}
	qInfo().noquote() << QString("BUS TEST: all %1 links up, device ids 0..%2").arg(players).arg(players - 1);

	/* 每个内核都要先切到 MULTI 模式：从机的轮次事件只在 mode==GBA_SIO_MULTI
	 * 时才跑（sioSlaveDoneEvent 开头就 return）。只让主机写 SIOCNT 的话从机
	 * 永远停在 NORMAL/GPIO，一个字都不会推上来 —— 现场就是主机 got=0、2.5 秒
	 * 只起了 2 轮。两人用例里从机也写过这一句，这里是同样的事。 */
	for (int i = 0; i < players; i++) {
		struct GBA* gba = (struct GBA*) cores[i]->board;
		GBASIOWriteSIOCNT(&gba->sio, 0x600F);
	}

	std::atomic<bool> stop(false);
	std::atomic<int> rounds(0);
	std::vector<std::thread> threads;
	for (int i = 0; i < players; i++) {
		threads.emplace_back([&, i]() {
			while (!stop.load()) {
				sioLinkPump(links[i], cores[i]);
				cores[i]->runFrame(cores[i]);
				if (i == 0) {
					/* 主机自己起传输：0x600F = MULTI + IRQ + 115200。 */
					struct GBA* gba = (struct GBA*) cores[0]->board;
					int r = rounds.load();
					gba->memory.io[GBA_REG(SIOMLT_SEND)] = (uint16_t) (0x7000 + (r & 7));
					GBASIOWriteSIOCNT(&gba->sio, 0x600F);
					rounds.fetch_add(1);
				}
			}
		});
	}
	QThread::msleep(2500);
	stop.store(true);
	for (auto& t : threads) {
		t.join();
	}

	int gotRounds = rounds.load();
	if (gotRounds < 4) {
		qInfo().noquote() << QString("BUS TEST: FAIL (host only started %1 rounds)").arg(gotRounds);
		++failures;
	}
	/* 从机侧：SIOMULTI0 必须是主机某一轮的字。 */
	for (int i = 1; i < players; i++) {
		struct GBA* gba = (struct GBA*) cores[i]->board;
		uint16_t w = gba->memory.io[GBA_REG(SIOMULTI0)];
		if (w < 0x7000 || w > 0x7007) {
			qInfo().noquote() << QString("BUS TEST: FAIL (core %1 SIOMULTI0=%2, want 0x7000..0x7007)")
			                         .arg(i).arg(w, 4, 16, QChar('0'));
			++failures;
		} else if (sioLinkState(links[i]) != 2) {
			qInfo().noquote() << QString("BUS TEST: FAIL (core %1 dropped during rounds)").arg(i);
			++failures;
		}
	}
	if (failures == 0) {
		qInfo().noquote() << QString("BUS TEST: PASS (%1 players, %2 rounds, host word reached every slave)")
		                         .arg(players).arg(gotRounds);
	} else {
		qInfo() << "BUS TEST: FAIL" << failures;
	}
	for (int i = 0; i < players; i++) {
		sioLinkDestroy(links[i]);
		cores[i]->deinit(cores[i]);
	}
	return failures;
}

/**
 * 3/4 人真实 ROM 对局：N 个内核 + 星型总线 + 由游戏自己发起 MULTI 轮次。
 *
 * busSioTest 用空 ROM 直写 SIO 寄存器，只证明链路层；这里让 gen8 自己跑
 * 「进俱乐部 → 联机」，读 gFieldLinkPlayerCount 和训练家卡片状态判 LINKUP。
 * LINKUP 本身必须靠游戏每帧 9 轮 MULTI 握手达成，所以这是「游戏侧 MULTI
 * 轮次真的被总线驱动」的直接证据（11-10 日志里列的开放项）。
 *
 * 每个内核一个线程：总线从机要等主机广播，单线程轮流跑必然互等。所有内核
 * 同一份存档、同一套按键脚本，保证同时进房。带墙钟超时，绝不挂死。
 *
 * 2026-11-10 实测：3 人房 LINKUP 仍未达成（总线从机在游戏还没发起 MULTI
 * 时被轮次事件拖住），此模式保留为**诊断入口**，不进默认测试套件。返回非 0
 * 表示「游戏侧 3/4 人对局未跑通」，不是链路层回归失败；链路层请看 bus 模式。
 */
static int busGameTest(const QString& rom, const QString& sav, int players) {
	if (players < 3) {
		players = 3;
	}
	if (players > 4) {
		players = 4;
	}
	auto envInt = [](const char* k, int dflt) {
		bool ok = false;
		int v = qEnvironmentVariableIntValue(k, &ok);
		return ok ? v : dflt;
	};
	const int port = 18767;
	const int maxFrames = envInt("BUSGAME_FRAMES", 6000);
	const int wallLimitMs = envInt("BUSGAME_TIMEOUT_MS", 45000);
	/* GBoyConsoleSet 的 N 核路线靠帧栅栏让所有镜像核与可见核同步推进。
	 * 打开后每个核心跑完一帧必须等齐其他核心，模拟安卓本机多核的形态。
	 * 只用于默认 45s 短窗口诊断：45s 实测三核帧号完全一致、lead=[0,0]；
	 * 把 BUSGAME_TIMEOUT_MS 拉到 330s 时进程会挂死在 join，不要那样跑。 */
	const bool frameBarrier = envInt("BUSGAME_BARRIER", 0) != 0;
	/* GBoyConsoleSet.endFrame() times out instead of freezing the visible loop;
	 * the harness must do the same, or one slow core stalls all of them. */
	const int barrierWaitMs = envInt("BUSGAME_BARRIER_MS", 50);
	const int menuAt = envInt("BUSGAME_MENU_AT", 1500);
	/* BIOS 的多启动(multiboot)探测阶段**不能挂链接驱动**：一挂上，BIOS 就
	 * 认为有线缆在对端应答，卡在探测循环里永不 boot ROM（实测 f=5400 仍是
	 * `MULTI m=494E`、`im=0 pc=0`、cb2=0）。等过了 BIOS 再 pump/attach。 */
	const int attachAt = envInt("BUSGAME_ATTACH_AT", 0);
	/* 对战模式列表（MultichoiceList_BattleMode）：
	 *   1 Single Battle(2人) / 2 Double Battle(2人) / 3 Multi Battle(3~4人)
	 * 3/4 人必须选第 3 项；选 1 会得到 LINKUP_WRONG_NUM_PLAYERS、cnt 恒 0。
	 * 值为「确认前按几次 DOWN」，默认 0 = 保持原来的首项(Single)行为。 */
	const int modeDowns = envInt("BUSGAME_MODE_DOWNS", 0);
	struct mCore* cores[4] = { nullptr, nullptr, nullptr, nullptr };
	struct SioLink* links[4] = { nullptr, nullptr, nullptr, nullptr };
	static mColor video[4][240 * 160];
	/* 逐帧三核对齐采样：只在 SIO 视图上比对（SIOCNT + SIOMULTI0..3）。
	 * SIOMLT_SEND 是各核自己的发送缓冲，isMaster/playerCount 本就该不同，
	 * 都不参与「是否分叉」的判定，只打印出来做上下文。 */
	enum { SMP_FRAMES = 2048 };
	static uint16_t smp[4][SMP_FRAMES][6];
	memset(smp, 0, sizeof(smp));

	const QByteArray romUtf8 = QFileInfo(rom).absoluteFilePath().toUtf8();
	/* Each core gets its own copy of the battery save. Three VFileOpen(...,
	 * O_RDWR) handles on one file can lock each other out on Windows, leaving
	 * the later cores booted from an empty save (cb2 stays 0). */
	QString savCopy[4];
	for (int i = 0; i < players; ++i) {
		savCopy[i] = sav + QStringLiteral(".busgame%1").arg(i);
		QFile::remove(savCopy[i]);
		QFile::copy(sav, savCopy[i]);
	}
	for (int i = 0; i < players; i++) {
		VFile* romVf = VFileOpen(romUtf8.constData(), O_RDONLY);
		if (!romVf) {
			romVf = VFileOpenFD(romUtf8.constData(), O_RDONLY);
		}
		if (!romVf) {
			fprintf(stderr, "BUSGAME: FAIL (cannot open rom %s)\n", romUtf8.constData());
			return 1;
		}
		cores[i] = mCoreFindVF(romVf);
		if (!cores[i]) {
			fprintf(stderr, "BUSGAME: FAIL (cannot find core)\n");
			return 1;
		}
		cores[i]->init(cores[i]);
		mCoreConfigInit(&cores[i]->config, NULL);
		mCoreConfigSetIntValue(&cores[i]->config, "logLevel", mLOG_WARN);
		if (!cores[i]->loadROM(cores[i], romVf)) {
			fprintf(stderr, "BUSGAME: FAIL (cannot load rom)\n");
			return 1;
		}
		const QByteArray savUtf8 = savCopy[i].toUtf8();
		VFile* sv = VFileOpen(savUtf8.constData(), O_RDWR);
		if (sv && !cores[i]->loadSave(cores[i], sv)) {
			fprintf(stderr, "BUSGAME: WARN (core %d loadSave failed)\n", i);
		}
		cores[i]->reset(cores[i]);
		cores[i]->setVideoBuffer(cores[i], video[i], 240);
		links[i] = sioLinkCreate();
	}

	const bool localBus = envInt("BUSGAME_LOCAL_BUS", 0) != 0;
	if (localBus) {
		/* 进程内总线：同进程共享内存回合屏障，主机是唯一时钟源。
		 * 这条路径才是 3/4 人真正可玩的形态（无 socket、无每轮 2ms 地板）。 */
		if (!sioLinkHostPlayersLocal(links[0], port, players)) {
			fprintf(stderr, "BUSGAME: FAIL (cannot local-host)\n");
			return 1;
		}
		for (int i = 1; i < players; ++i) {
			if (!sioLinkJoinPlayersLocal(links[i], port)) {
				fprintf(stderr, "BUSGAME: FAIL (cannot local-join %d)\n", i);
				return 1;
			}
		}
	} else if (!sioLinkHostPlayers(links[0], port, players)) {
		fprintf(stderr, "BUSGAME: FAIL (cannot listen)\n");
		return 1;
	} else {
		for (int i = 1; i < players; ++i) {
			if (!sioLinkJoinPlayers(links[i], "127.0.0.1", port, players)) {
				fprintf(stderr, "BUSGAME: FAIL (cannot connect %d)\n", i);
				return 1;
			}
		}
	}
	for (int k = 0; k < 300; ++k) {
		bool all = true;
		for (int i = 0; i < players; ++i) {
			/* 本地总线建链即 state=2，不需要靠 pump 推进；且这里 pump 会在
			 * 帧 0 之前就 align 驱动，让 BIOS 多启动循环把 ROM 卡死。 */
			if (!localBus) {
				sioLinkPump(links[i], cores[i]);
			}
			if (sioLinkState(links[i]) != 2) {
				all = false;
			}
		}
		if (all) {
			break;
		}
		QThread::msleep(20);
	}
	for (int i = 0; i < players; ++i) {
		struct GBA* gba = (struct GBA*) cores[i]->board;
		GBASIOWriteRCNT(&gba->sio, 0);
		/* 本地总线故意延迟到 attachAt 才挂驱动（避开 BIOS 多启动），
		 * 所以这里只校验链路状态，驱动在帧循环里挂。 */
		if (sioLinkState(links[i]) != 2 || (!localBus && !gba->sio.driver)) {
			fprintf(stderr, "BUSGAME: FAIL (core %d link state %d driver %p)\n",
			        i, sioLinkState(links[i]), (void*) gba->sio.driver);
			return 1;
		}
	}

	std::atomic<bool> stop(false);
	std::atomic<int> finished(0);
	std::atomic<int> maxCnt[4];
	std::atomic<int> sawCards[4];
	std::atomic<int> sawBattle[4];
	std::atomic<uint32_t> lastCb2[4];
	std::atomic<int> lastFrame[4];
	std::atomic<int> frameProgress[4];
	std::atomic<uint64_t> coreStepUs[4];
	std::atomic<uint64_t> pumpUs[4], runUs[4];
	/* 链路状态迁移追踪（BUSGAME_TRACE=1）：每当某核的 (pc,st,cb2) 变化就打一条，
	 * 用来精确定位「链路何时建立(pc=3)、何时崩(st=2→4→1, cb2→0)」以及与按键的
	 * 时序关系。默认关，零开销。 */
	const bool traceOn = envInt("BUSGAME_TRACE", 0) != 0;
	/* 握手内部量追踪（BUSGAME_H2=1）：gLink.isMaster/state/playerCount/
	 * handshakeAsMaster(+0x0e)、gShouldAdvanceLinkState、gLinkStatus、tempRecvBuffer[0]。
	 * 用来定位『主机为何不发 MASTER_HANDSHAKE(0x8FFF)』。 */
	const bool h2On = envInt("BUSGAME_H2", 0) != 0;
	std::atomic<int> prevH2[4];
	std::atomic<int> prevPc[4], prevSt[4], prevCb[4];
	for (int i = 0; i < players; ++i) {
		prevH2[i].store(-1);
		maxCnt[i].store(0);
		sawCards[i].store(0);
		sawBattle[i].store(0);
		lastCb2[i].store(0);
		lastFrame[i].store(-1);
		frameProgress[i].store(-1);
		coreStepUs[i].store(0);
		pumpUs[i].store(0);
		runUs[i].store(0);
		prevPc[i].store(-1);
		prevSt[i].store(-1);
		prevCb[i].store(0);
	}
	/* 帧栅栏用对称并行模式：所有核并行跑同一帧，见下方 worker 内注释。
	 * barrierDone[i] 记录每个核最后跑完的帧号，全部追平 f-1 才放行 f。 */
	std::mutex barrierMu;
	std::condition_variable barrierCv;
	std::vector<int> barrierDone(players, -1);
	std::atomic<uint64_t> hostStepUs(0), hostWaitUs(0);
	std::vector<std::thread> threads;
	for (int i = 0; i < players; ++i) {
		threads.emplace_back([&, i]() {
			const uint32_t A = 1, START = 8, LEFT = 32, UP = 64, DOWN = 128;
			const int boot = 240;
			const int saveAt = menuAt + 240;
			struct GBA* g = (struct GBA*) cores[i]->board;
			auto step = [&](int f) {
				auto _s0 = std::chrono::steady_clock::now();
				uint32_t keys = 0;
				if (f >= boot && f < boot + 6) {
					keys = START;
				} else if (f >= boot + 10 && f < boot + 16) {
					keys = START;
				} else if (f >= boot + 20 && f < menuAt) {
					keys = ((f % 45) < 30) ? A : 0u;
				} else if (f >= menuAt && f < menuAt + 8) {
					keys = DOWN;
				} else if (f >= menuAt + 30 && f < menuAt + 40) {
					keys = A;
				} else if (f >= menuAt + 40 && f < menuAt + 60) {
					keys = UP;
				} else if (f >= menuAt + 60 && f < menuAt + 80) {
					keys = LEFT;
				} else if (modeDowns > 0
				           && f >= menuAt + 80
				           && f < menuAt + 80 + modeDowns * 14) {
					/* 键位钳到首项后，按 modeDowns 次 DOWN 走到目标对战模式。 */
					keys = (((f - menuAt - 80) % 14) < 4) ? DOWN : 0u;
				} else if (f >= menuAt + 80 + modeDowns * 14
				           && f < menuAt + 92 + modeDowns * 14) {
					keys = A;
				} else if (f >= saveAt) {
					keys = ((f % 40) < 25) ? A : 0u;
				}
				cores[i]->setKeys(cores[i], keys);
				auto _p0 = std::chrono::steady_clock::now();
				if (!localBus || f >= attachAt) {
					/* 本地总线：过了 BIOS 多启动探测阶段才挂驱动；TCP 路径保持原样。 */
					sioLinkPump(links[i], cores[i]);
				}
				auto _p1 = std::chrono::steady_clock::now();
				cores[i]->runFrame(cores[i]);
				auto _p2 = std::chrono::steady_clock::now();
				pumpUs[i].fetch_add((uint64_t) std::chrono::duration_cast<std::chrono::microseconds>(_p1 - _p0).count());
				runUs[i].fetch_add((uint64_t) std::chrono::duration_cast<std::chrono::microseconds>(_p2 - _p1).count());
				int cnt = (GBAView16(g->cpu, 0x03004A38u) >> 8) & 0xFF;
				uint16_t ts = GBAView16(g->cpu, 0x03004A10u);
				uint32_t cb2 = (uint32_t) GBAView16(g->cpu, 0x03002AD4u)
				             | ((uint32_t) GBAView16(g->cpu, 0x03002AD6u) << 16);
				/* 三核对齐取证：同一帧内 SIOMULTI0..3 三核应完全一致（MULTI 的
				 * 语义就是人人看到相同的四个槽）。若不一致＝desync；一致但游戏
				 * 不推进＝格式/时序。每 300 帧采样一次，供事后逐帧比对。 */
				bool dense = (f >= 1180 && f <= 1360 && (f % 10) == 0) || (f % 300) == 0;
				if (dense) {
					fprintf(stderr,
					        "MULTI f=%d c=%d sio=%04X rcnt=%04X m=%04X,%04X,%04X,%04X im=%d lc=%d pc=%d st=%d res=%d cnt=%d cb2=%08X pc32=%08X\n",
					        f, i,
					        GBAView16(g->cpu, 0x04000128u), GBAView16(g->cpu, 0x04000134u),
					        GBAView16(g->cpu, 0x04000120u), GBAView16(g->cpu, 0x04000122u),
					        GBAView16(g->cpu, 0x04000124u), GBAView16(g->cpu, 0x04000126u),
					        GBAView8(g->cpu, 0x03002AF4u), GBAView8(g->cpu, 0x03002AF6u),
					        GBAView8(g->cpu, 0x03002AF7u),
					        GBAView8(g->cpu, 0x03002AF5u),
					        GBAView16(g->cpu, 0x020219ACu),
					        cnt, cb2, (unsigned) g->cpu->gprs[15]);
				}
				if (traceOn) {
					int _im = GBAView8(g->cpu, 0x03002AF4u);
					int _lc = GBAView8(g->cpu, 0x03002AF6u);
					int _pc = GBAView8(g->cpu, 0x03002AF7u);
					int _st = GBAView8(g->cpu, 0x03002AF5u);
					int _pca = prevPc[i].exchange(_pc);
					int _sta = prevSt[i].exchange(_st);
					int _cba = prevCb[i].exchange((int) cb2);
					if (_pca != _pc || _sta != _st || _cba != (int) cb2) {
						fprintf(stderr,
						        "TRACE f=%d c=%d keys=%02X im=%d lc=%d pc=%d st=%d cnt=%d cb2=%08X m=%04X,%04X,%04X,%04X\n",
						        f, i, keys, _im, _lc, _pc, _st, cnt, cb2,
						        GBAView16(g->cpu, 0x04000120u), GBAView16(g->cpu, 0x04000122u),
						        GBAView16(g->cpu, 0x04000124u), GBAView16(g->cpu, 0x04000126u));
					}
				}
				if (h2On) {
					int _h2im = GBAView8(g->cpu, 0x03002AF4u);
					int _h2st = GBAView8(g->cpu, 0x03002AF5u);
					int _h2pc = GBAView8(g->cpu, 0x03002AF7u);
					int _h2hsm = GBAView8(g->cpu, 0x03002B02u);
					int _h2adv = GBAView8(g->cpu, 0x03002AD8u);
					uint32_t _h2gs = (uint32_t) GBAView16(g->cpu, 0x03002A9Cu)
					               | ((uint32_t) GBAView16(g->cpu, 0x03002A9Eu) << 16);
					uint16_t _h2tr0 = GBAView16(g->cpu, 0x03002AF8u);
					int _h2sig = _h2im | (_h2st << 4) | (_h2pc << 8) | (_h2hsm << 12)
					           | (_h2adv << 16) | (((int) (_h2tr0 & 0xFFFFu)) << 20);
					int _h2prev = prevH2[i].exchange(_h2sig);
					if (_h2prev != _h2sig) {
						fprintf(stderr,
						        "H2 f=%d c=%d im=%d st=%d pc=%d hsm=%d sadv=%d gstat=%08X tr0=%04X tr=%04X,%04X,%04X,%04X\n",
						        f, i, _h2im, _h2st, _h2pc, _h2hsm, _h2adv, _h2gs, _h2tr0,
						        GBAView16(g->cpu, 0x03002AF8u), GBAView16(g->cpu, 0x03002AFAu),
						        GBAView16(g->cpu, 0x03002AFCu), GBAView16(g->cpu, 0x03002AFEu));
					}
				}
				if (f < SMP_FRAMES) {
					smp[i][f][0] = GBAView16(g->cpu, 0x04000128u);  /* SIOCNT */
					smp[i][f][1] = GBAView16(g->cpu, 0x0400012Au);  /* SIOMLT_SEND */
					smp[i][f][2] = GBAView16(g->cpu, 0x04000120u);
					smp[i][f][3] = GBAView16(g->cpu, 0x04000122u);
					smp[i][f][4] = GBAView16(g->cpu, 0x04000124u);
					smp[i][f][5] = GBAView16(g->cpu, 0x04000126u);
				}
				if (cnt > maxCnt[i].load()) {
					maxCnt[i].store(cnt);
				}
				if ((ts & 0xFF) == 0x80) {
					sawCards[i].store(1);
				}
				if ((cb2 & 0xFFFF0000u) == 0x08090000u) {
					sawBattle[i].store(1);
				}
				lastCb2[i].store(cb2);
				lastFrame[i].store(f);
				frameProgress[i].store(f);
				auto _s1 = std::chrono::steady_clock::now();
				coreStepUs[i].fetch_add((uint64_t) std::chrono::duration_cast<std::chrono::microseconds>(_s1 - _s0).count());
			};
			{
				/* 对称并行栅栏：**所有核（含主机）并行跑同一帧 step(f)**，再一起
				 * 报 done，齐了才进下一帧。总线上主机的广播与从机的等待因此真正
				 * 重叠。串行顺序——无论主机先行还是从机先行——都会让一方等另一方：
				 * 从机在 runFrame 里为 MULTI 轮次等主机广播，主机却在栅栏等从机，
				 * 从机每帧付上百次 2ms 超时，实测 runFrame 198ms/帧、整机 5.6fps。 */
				for (int f = 0; f < maxFrames && !stop.load(); ++f) {
					auto t1 = std::chrono::steady_clock::now();
					if (frameBarrier) {
						std::unique_lock<std::mutex> lk(barrierMu);
						auto ready = [&]() {
							for (int j = 0; j < players; ++j) {
								if (barrierDone[j] < f - 1) {
									return false;
								}
							}
							return true;
						};
						while (!stop.load() && !ready()) {
							barrierCv.wait_for(lk, std::chrono::milliseconds(barrierWaitMs));
						}
						if (stop.load()) {
							break;
						}
					}
					auto t0 = std::chrono::steady_clock::now();
					step(f);
					auto t3 = std::chrono::steady_clock::now();
					if (i == 0) {
						hostStepUs.fetch_add((uint64_t) std::chrono::duration_cast<std::chrono::microseconds>(t3 - t0).count());
						hostWaitUs.fetch_add((uint64_t) std::chrono::duration_cast<std::chrono::microseconds>(t0 - t1).count());
					}
					if (frameBarrier) {
						std::unique_lock<std::mutex> lk(barrierMu);
						barrierDone[i] = f;
						barrierCv.notify_all();
					}
				}
			}
			finished.fetch_add(1);
		});
	}
	for (int tick = 0; tick < wallLimitMs / 100 && finished.load() < players; ++tick) {
		QThread::msleep(100);
	}
	stop.store(true);
	/* Wake every slave parked in the barrier so join() cannot hang. */
	barrierCv.notify_all();
	for (auto& t : threads) {
		t.join();
	}

	int failures = 0;
	fprintf(stderr, "BUSGAME: players=%d frames=%d finished=%d/%d barrier=%d local=%d\n",
	        players, maxFrames, finished.load(), players, frameBarrier ? 1 : 0, localBus ? 1 : 0);
	fprintf(stderr, "BUSGAME timing(host): step=%llums wait=%llums\n",
	        (unsigned long long) (hostStepUs.load() / 1000),
	        (unsigned long long) (hostWaitUs.load() / 1000));
	{
		char buf[256];
		int n = snprintf(buf, sizeof(buf), "BUSGAME timing(core):");
		for (int i = 0; i < players; ++i) {
			n += snprintf(buf + n, sizeof(buf) - n, " c%d=%llums", i,
			              (unsigned long long) (coreStepUs[i].load() / 1000));
		}
		fprintf(stderr, "%s\n", buf);
		{
			int m = snprintf(buf, sizeof(buf), "BUSGAME timing(split):");
			for (int i = 0; i < players; ++i) {
				m += snprintf(buf + m, sizeof(buf) - m, " c%d[pump=%llu run=%llu]", i,
				              (unsigned long long) (pumpUs[i].load() / 1000),
				              (unsigned long long) (runUs[i].load() / 1000));
			}
			fprintf(stderr, "%s\n", buf);
		}
	}
	{
		/* 找三核 SIO 视图第一次不一致的帧（跳过 SIOMLT_SEND：各核自己的发送
		 * 缓冲，本来就不该相同）。这一帧就是游戏级分叉的起点。 */
		int firstDiv = -1;
		int divK = -1;
		for (int f = 0; f < SMP_FRAMES && firstDiv < 0; ++f) {
			for (int k = 0; k < 6; ++k) {
				/* 0=SIOCNT：主机/从机的 ID 与 slave 位本就应该不同（真实线缆
				 * 也如此），不是分叉；1=SIOMLT_SEND：各核自己的发送缓冲。
				 * 只比 2..5 = SIOMULTI0..3，这三者三核必须完全一致。 */
				if (k < 2) {
					continue;
				}
				uint16_t v0 = smp[0][f][k];
				for (int c = 1; c < players; ++c) {
					if (smp[c][f][k] != v0) {
						firstDiv = f;
						divK = k;
						break;
					}
				}
				if (firstDiv >= 0) {
					break;
				}
			}
		}
		if (firstDiv < 0) {
			fprintf(stderr, "BUSGAME align: NO SIO divergence in first %d frames\n", (int) SMP_FRAMES);
		} else {
			static const char* kn[] = { "SIOCNT", "SEND", "M0", "M1", "M2", "M3" };
			fprintf(stderr, "BUSGAME align: FIRST DIVERGENCE f=%d field=%s\n",
			        firstDiv, kn[divK >= 0 ? divK : 0]);
			for (int f = (firstDiv > 0 ? firstDiv - 1 : 0); f <= firstDiv; ++f) {
				for (int c = 0; c < players; ++c) {
					fprintf(stderr, "  f=%d c=%d CNT=%04X SEND=%04X M=%04X,%04X,%04X,%04X\n",
					        f, c, smp[c][f][0], smp[c][f][1], smp[c][f][2],
					        smp[c][f][3], smp[c][f][4], smp[c][f][5]);
				}
			}
		}
	}
	for (int i = 0; i < players; ++i) {
		int cnt = maxCnt[i].load();
		fprintf(stderr, "  core %d: frame=%d/%d maxCnt=%d cards=%d battle=%d cb2=%08X state=%d\n",
		        i, lastFrame[i].load(), maxFrames - 1, cnt, sawCards[i].load(),
		        sawBattle[i].load(), lastCb2[i].load(), sioLinkState(links[i]));
		if (cnt < players) {
			fprintf(stderr, "BUSGAME: FAIL (core %d never reached LINKUP with %d players)\n", i, players);
			++failures;
		}
	}
	if (!failures) {
		fprintf(stderr, "BUSGAME: PASS (%d cores linked up through the star bus)\n", players);
	}
	{
		int32_t diag[7] = {0, 0, 0, 0, 0, 0, 0};
		netLinkBusDiag((struct NetLink*) sioLinkHandle(links[0]), diag);
		fprintf(stderr,
		        "BUSGAME diag host: rounds=%d full=%d empty=%d stalePush=%d futurePush=%d lead=[%d,%d]\n",
		        diag[0], diag[1], diag[2], diag[3], diag[4], diag[5], diag[6]);
	}
	for (int i = 0; i < players; ++i) {
		sioLinkDestroy(links[i]);
		cores[i]->deinit(cores[i]);
		QFile::remove(savCopy[i]);
	}
	return failures;
}

/* ---- GBA 真锁步原型（busgame-lockstep）----------------------------------
 * 目标：用 mGBA 自带 GBASIOLockstepCoordinator 把 N 个核在 SIO 层真正锁步
 * 推进（共享时钟/事件队列/硬同步），验证它能否解决 3/4 人「SerialCB 不同
 * 相位 → 主机独通握手、从机落空」的问题。这是 PC 参考实现，跑通后同一套
 * 机制移植到 native（Android/iOS）。
 *
 * 结构：每核包一层 mCoreThread（提供 sleep/wake 的挂起/恢复），挂
 * GBASIOLockstepDriver；全核共享一个 GBASIOLockstepCoordinator。按键脚本
 * 在 frameCallback 里按帧号注入（与 busgame 同一套），BIOS 多启动期不挂
 * 驱动（attachAt 帧之后才挂），避免卡 boot。
 */
namespace {
struct LsCtx {
	int idx;
	std::atomic<int>* frame;
	int menuAt;
	int modeDowns;
};

/* 自定义 mLockstepUser：等价于官方 mLockstepThreadUser（后者绑定 mCoreThread，
 * 在本 harness 的 mCoreThreadStart 反复崩溃）。关键语义（与官方一致）：sleep /
 * wake 是「请求某核暂停 / 恢复」的非阻塞原语，不阻塞调用方；真正的挂起由该核
 * 自己的 worker 在 runLoop 后检查 pauseRequested 并自我 park。二者用独立
 * mutex，不会与 coordinator->mutex 死锁。 */
struct LsUser {
	struct mLockstepUser d;
	int id;
	std::mutex m;
	std::condition_variable c;
	bool pauseRequested;
};

/* 菜单光标导航的统计（诊断用）。见 lsInjectKeys 里的 BUSGAME_FORCE_MULTI。 */
static std::atomic<int> g_forceMultiWrites(0);
static std::atomic<int> g_menuMaxSeen(0);
static std::atomic<int> g_menuMaxPerCore[4];
static std::atomic<int> g_walkDbg[4];   /* idx<<24 | px<<16 | py<<8 | keys */
/* ChooseHalfPartyForBattle 队伍菜单诊断：
 * gPartyMenu @0x02032A88，menuType(低4bit) @+8 =0x02032AC0（4=CHOOSE_HALF）；
 * gSelectedOrderFromParty @0x02032B00，前两字节非 0 表示已选 2 只。 */
static std::atomic<int> g_partyType[4];
static std::atomic<int> g_selOrder[4];   /* (s0<<8)|s1 */
static std::atomic<int> g_partySlot[4];  /* gPartyMenu.slotId */
/* 走位停滞检测：实测 4 核会一起卡在 (9,1) 不动（y 方向被柜台/NPC 挡住），
 * 此时切换成水平优先绕行。各核独立，threaded/serial 下均无跨线程写同一槽。 */
static int g_lastPX[4] = {-1, -1, -1, -1};
static int g_lastPY[4] = {-1, -1, -1, -1};
static int g_stall[4] = {0, 0, 0, 0};
static int g_detour[4] = {0, 0, 0, 0};
/* 联机房间按键码握手：sPlayerTradingStates @0x03004A10 (4×u8)，
 * 0x82=PLAYER_TRADING_STATE_UNK_2(已准备)；gFieldLinkPlayerCount @0x03004A39。
 * sub_8087214() 要全员 0x82 才让 Task_EnterCableClubSeat 推进到开战。 */
static std::atomic<uint32_t> g_tradeStates[4];
static std::atomic<int> g_fieldPc(0);
/* host(core0) 的 gMain.callback2 变化轨迹，诊断游戏到底走过哪些主回调。 */
static uint32_t g_cb2Trace[64];
static int g_cb2TraceN = 0;
/** 打一条 cb2trace 相对序列辅助判据：与 ROM 绝对布局无关，换构建不该变。
 *  T-03 补做：保留相对序列作为动态窗口之外的交叉校验（不参与退出码）。 */
static QString cb2RelativeAux() {
	uint32_t first = 0, last = 0;
	for (int i = 0; i < g_cb2TraceN; ++i) {
		if (g_cb2Trace[i] != 0) {
			if (first == 0) {
				first = g_cb2Trace[i];
			}
			last = g_cb2Trace[i];
		}
	}
	const int64_t delta = int64_t(last) - int64_t(first);
	return QStringLiteral("LS cb2rel: firstNonZero=%1 last=%2 delta=%3 relOK=%4\n")
	        .arg(first, 8, 16, QChar('0'))
	        .arg(last, 8, 16, QChar('0'))
	        .arg(delta)
	        .arg((delta < -0x90000 && delta > -0xC0000) ? QStringLiteral("YES")
	                                                     : QStringLiteral("NO"));
}
/* 终态画面 dump：把 4 核的 video buffer 写成 PPM，转 PNG 后直接看游戏停在
 * 哪个界面，比继续猜内存快。（早先按帧号 dump 会因窗口内没跑到该帧而落空。） */
static mColor (*g_lsVideo)[240 * 160] = nullptr;
static void lsDumpPPM(int idx) {
	if (!g_lsVideo) { return; }
	char path[64];
	snprintf(path, sizeof(path), "ls_core%d.ppm", idx);
	FILE* fp = fopen(path, "wb");
	if (!fp) { return; }
	fprintf(fp, "P6\n240 160\n255\n");
	for (int y = 0; y < 160; ++y) {
		for (int x = 0; x < 240; ++x) {
			uint32_t c = (uint32_t) g_lsVideo[idx][y * 240 + x];
			unsigned char rgb[3] = {
				(unsigned char) (c & 0xFFu),
				(unsigned char) ((c >> 8) & 0xFFu),
				(unsigned char) ((c >> 16) & 0xFFu)
			};
			fwrite(rgb, 1, 3, fp);
		}
	}
	fclose(fp);
}

/* 产品 MgbaMobile 在 core init 时就绑定了默认 logger，创建之后再改
 * logLevel 已来不及；这里装一个只放行 WARN 以上的默认 logger，压掉每轮
 * SIO/BIOS 的 DEBUG 刷屏（4 核并发时足以把帧循环拖慢数倍）。 */
static void lsSilentLog(struct mLogger* logger, int category, enum mLogLevel level,
                        const char* format, va_list args) {
	(void) logger;
	(void) category;
	if (level & (mLOG_FATAL | mLOG_ERROR | mLOG_WARN | mLOG_GAME_ERROR)) {
		vfprintf(stderr, format, args);
		fputc('\n', stderr);
	}
}
static struct mLogger s_lsSilentLogger = { lsSilentLog, NULL };

uint32_t lsInjectKeys(struct mCore* core, int idx, int f, int menuAt, int modeDowns) {
	struct GBA* g = (struct GBA*) core->board;
	/* 不要把「st>=4 后停手」加回来：st=4 在联机中心握手（f≈1365）就会出现，
	 * 远早于菜单导航（menuAt=1500）。一旦那时停手，导航到 multi-battle 的
	 * DOWN/A/UP/LEFT/modeDowns 按键全被跳过，游戏永远进不了对战。实测加过
	 * 该逻辑后 gstat=0x370 与 tr0=8FFF 全部消失（假 LINKUP）。 */
	const uint32_t A = 1, START = 8, RIGHT = 16, LEFT = 32, UP = 64, DOWN = 128;
	const int boot = 240;
	uint32_t keys = 0;
	if (f >= boot && f < boot + 6) {
		keys = START;
	} else if (f >= boot + 10 && f < boot + 16) {
		keys = START;
	} else if (f >= boot + 20 && f < menuAt) {
		keys = ((f % 45) < 30) ? A : 0u;
	} else if (f >= menuAt && f < menuAt + 8) {
		keys = DOWN;
	} else if (f >= menuAt + 30 && f < menuAt + 40) {
		keys = A;
	} else if (f >= menuAt + 40 && f < menuAt + 60) {
		keys = UP;
	} else if (f >= menuAt + 60 && f < menuAt + 80) {
		keys = LEFT;
	} else if (modeDowns > 0 && f >= menuAt + 80
	           && f < menuAt + 80 + modeDowns * 14) {
		keys = (((f - menuAt - 80) % 14) < 4) ? DOWN : 0u;
	} else if (f >= menuAt + 80 + modeDowns * 14
	           && f < menuAt + 92 + modeDowns * 14) {
		keys = A;
	} else if (f >= menuAt + 240) {
		/* 只有 4 核都确认了「多人模式」(var8004=5, gLinkType=0x2255) 之后才
		 * 开始走位。菜单/握手阶段继续按 A；过早给方向键会在菜单未确认时移动
		 * 光标，把 3 个核的选择打乱（实测 var8004=[0,5,0,0]）。 */
		int v8 = GBAView16(g->cpu, 0x0202199Cu);
		int lt = GBAView16(g->cpu, 0x02027BB2u);
		/* gFieldLinkPlayerCount @0x03004A39：LINKUP 确认完成、玩家进房后
		 * 才由游戏赋值（两人路径实测 2）。实测它恒为 0 且 trade 全 0，
		 * 说明 TryBattleLinkup 的 waitstate 还没过 —— 玩家被锁在原地，
		 * 此时给方向键/选队键全无意义。必须持续按 A 完成 LINKUP 确认。 */
		int fpc = GBAView8(g->cpu, 0x03004A39u);
		if (v8 != 5 || (lt != 0x2255 && lt != 0x2211) || fpc < 4) {
			keys = ((f % 40) < 25) ? A : 0u;
		} else {
			/* 文本框优先级最高：CableClub_EventScript_Tutorial 用
			 * lockall + 两个 msgbox(MSGBOX_DEFAULT) 锁住移动，进房后必须先按 A
			 * 关掉；Task_EnterCableClubSeat 的 "Please wait for link" 也是文本框。
			 * sFieldMessageBoxMode @0x02021A00，0=FIELD_MESSAGE_BOX_HIDDEN。 */
			int mb = GBAView8(g->cpu, 0x02021A00u);
			if (mb != 0) {
				keys = ((f % 20) < 8) ? A : 0u;   /* 脉冲产生 JOY_NEW */
			} else {
			/* 座位触发后弹出的 ChooseHalfPartyForBattle 队伍菜单：
			 * gPartyMenu.menuType==4 (PARTY_MENU_TYPE_CHOOSE_HALF)；
			 * gSelectedOrderFromParty 前两字节非 0 表示已选够 2 只。
			 * Task_HandleChooseMonInput：A 选怪 / START→MoveCursorToConfirm；
			 * 选够后 A → Task_ValidateChosenHalfParty → Task_ClosePartyMenu
			 * → 回脚本 ColosseumPlayerSpotTriggered → 开战。
			 * 用内存状态驱动，每 24 帧一个「按下 8 帧 / 松开 16 帧」脉冲产生
			 * JOY_NEW，不盲按。 */
			int ptype = GBAView8(g->cpu, 0x02032AC0u) & 0x0Fu;
			int s0 = GBAView8(g->cpu, 0x02032B00u);
			int s1 = GBAView8(g->cpu, 0x02032B01u);
			g_partyType[idx].store(ptype);
			g_selOrder[idx].store((s0 << 8) | s1);
			if (ptype == 4) {
				/* 选怪状态机。按 A 会先弹「Enter/No Entry」小窗口，需两次 A
				 * 才写入一只；且在同一 slot 再按 A 会触发 CursorCb_NoEntry
				 * 取消选择（实测 sel 在 0/1 只间震荡）。gPartyMenu.slotId
				 * @0x02032AC1。选满 2 只后游戏自动 MoveCursorToConfirm()，
				 * 再按 A 即验证关闭菜单。每个动作只按 1 帧产生单次 JOY_NEW。 */
			int slot = (int8_t) GBAView8(g->cpu, 0x02032AC1u);
			g_partySlot[idx].store(slot);
			{
				static int _pd = 0;
				if (idx == 0 && (_pd++ % 8) == 0) {
					fprintf(stderr, "PARTY f=%d s0=%d s1=%d slot=%d keys=%02X mb=%d\n",
					        f, s0, s1, slot, keys, (int) GBAView8(g->cpu, 0x02021A00u));
				}
			}
			/* 内存旁路完成「选 2 只」这一 UI 步骤：写 gSelectedOrderFromParty
			 * [0..1]={1,2}，并把 slotId 置为 PARTY_SIZE(6)=确认位。校验
			 * (Task_ValidateChosenHalfParty)、关闭菜单、后续开战仍由游戏自己的
			 * 代码执行，不绕过任何游戏逻辑；只填「已选」让 A 在 CONFIRM 位时
			 * 走 HandleChooseMonSelection→slotPtr==PARTY_SIZE→校验关菜单。
			 * 仅当未填好时才写，避免每帧覆写打断校验流程（之前每帧写 slotId=6
			 * 会粘住校验、菜单永不关闭）。 */
			if (s0 == 0 || s1 == 0 || slot != 6) {
				int cc = 0;
				if (s0 == 0) { GBAStore8(g->cpu, 0x02032B00u, (int8_t) 1, &cc); }
				if (s1 == 0) { GBAStore8(g->cpu, 0x02032B01u, (int8_t) 2, &cc); }
				if (slot != 6) { GBAStore8(g->cpu, 0x02032AC1u, (int8_t) 6, &cc); }
			}
			keys = ((f % 12) < 2) ? A : 0u;
			} else {
				/* 队伍菜单未弹出：闭环走位到 4P 座位（后备）。 */
				static const int seatX[4] = {3, 10, 3, 10};
				static const int seatY[4] = {4, 4, 6, 6};
				uint32_t sb1 = GBAView32(g->cpu, 0x03004964u);
				int px = -1, py = -1;
				if (sb1 >= 0x02000000u && sb1 < 0x03000000u) {
					px = (int16_t) GBAView16(g->cpu, sb1 + 0u);
					py = (int16_t) GBAView16(g->cpu, sb1 + 2u);
				}
				if (px < 0) {
					keys = ((f % 40) < 25) ? A : 0u;
				} else if (py > seatY[idx]) {
					keys = UP;
				} else if (py < seatY[idx]) {
					keys = DOWN;
				} else if (px > seatX[idx]) {
					keys = LEFT;
				} else if (px < seatX[idx]) {
					keys = RIGHT;
				} else {
					keys = ((f % 40) < 25) ? A : 0u;
				}
			g_walkDbg[idx].store((idx << 24) | ((px & 0xFF) << 16)
			                     | ((py & 0xFF) << 8) | (keys & 0xFF));
			}
			}   /* 闭合「无文本框」分支 */
		}       /* 闭合「已进房」分支 */
	}           /* 闭合 f>=menuAt+240 分支 */
	core->setKeys(core, keys);
	/* 内存驱动的确定性导航（BUSGAME_FORCE_MULTI，默认开）。
	 * 菜单刚弹出时 sProcessInputDelay 会吃掉 DOWN，盲按 modeDowns 次常常一次都
	 * 不生效 —— 实测 4 核 var8004 全停在 1(USING_SINGLE_BATTLE)、multiTypeMask=0，
	 * 于是 4 个玩家按 2 人单打项目比对，f≈2393 掉线。
	 * 关键区分：联机服务菜单 4 项（maxCursorPos=3），战斗模式菜单 5 项
	 * （MultichoiceList_BattleMode，maxCursorPos=4）。只在 max==4 时把
	 * sMenu.cursorPos @0x020296F2 钳到 2（第 2 项「多人/4P」）。第一版无此
	 * 区分，把服务菜单也钳到 2，结果 4 核一致进了「记录角」(var8004=4,
	 * linkType=0x3311)。VAR_RESULT=2 仍由游戏脚本自己转成
	 * VAR_0x8004=USING_MULTI_BATTLE(5)，不绕过任何游戏逻辑。 */
	static int forceMulti = -1;
	if (forceMulti < 0) {
		bool ok = false;
		int v = qEnvironmentVariableIntValue("BUSGAME_FORCE_MULTI", &ok);
		forceMulti = ok ? v : 1;
	}
	/* 不设上界：菜单实际弹出/确认比固定帧窗口晚，早退会让光标回落到 0，
	 * 导致 4 核 var8004 不一致（实测 [0,5,0,0]）。 */
	if (forceMulti && f >= menuAt) {
		int mx = GBAView8(g->cpu, 0x020296F4u);
		if (mx > g_menuMaxSeen.load()) { g_menuMaxSeen.store(mx); }
		if (mx > g_menuMaxPerCore[idx].load()) { g_menuMaxPerCore[idx].store(mx); }
		if (mx == 4) {
			int cur = GBAView8(g->cpu, 0x020296F2u);
			if (cur != 2) {
				int cc = 0;
				GBAStore8(g->cpu, 0x020296F2u, (int8_t) 2, &cc);
				g_forceMultiWrites.fetch_add(1);
			}
		}
	}
	/* 仅给 0 号核（主机）补 SD/Ready(bit3)：gen8 用 (SIOCNT & 0xC)==0x8 判主机。
	 * 只置 bit3、不碰 bit2(SI/主从，协调器已置 0)、bit7(START，协调器管理)。 */
	if (idx == 0) {
		g->sio.siocnt |= 0x0008u;
	}
	if ((f % 100) == 0) {
		fprintf(stderr, "LST f=%d c=%d pc=%d st=%d im=%d lc=%d hm=%d tr=%04X,%04X,%04X,%04X sio=%04X m=%04X,%04X,%04X,%04X cb2=%08X\n",
		        f, idx,
		        GBAView8(g->cpu, 0x03002AF7u), GBAView8(g->cpu, 0x03002AF5u),
		        GBAView8(g->cpu, 0x03002AF4u), GBAView8(g->cpu, 0x03002AF6u),
		        GBAView8(g->cpu, 0x03002B02u),
		        GBAView16(g->cpu, 0x03002AF8u), GBAView16(g->cpu, 0x03002AFAu),
		        GBAView16(g->cpu, 0x03002AFCu), GBAView16(g->cpu, 0x03002AFEu),
		        GBAView16(g->cpu, 0x04000128u),
		        GBAView16(g->cpu, 0x04000120u), GBAView16(g->cpu, 0x04000122u),
		        GBAView16(g->cpu, 0x04000124u), GBAView16(g->cpu, 0x04000126u),
		        (unsigned) (GBAView16(g->cpu, 0x03002AD4u)
		                    | ((uint32_t) GBAView16(g->cpu, 0x03002AD6u) << 16)));
	}
	/* 主机握手逐帧追踪：看 gShouldAdvanceLinkState 是否到 1、gLinkStatus 是否带
	 * MASTER(0x20) 与 playerCount(bits2-4)。 */
	{
		static int hslOn = -1;
		if (hslOn < 0) { hslOn = qEnvironmentVariableIntValue("BUSGAME_HSL", nullptr) ? 1 : 0; }
		if (hslOn && idx == 0) {
			int st = GBAView8(g->cpu, 0x03002AF5u);
			if (st == 2 || st == 4) {
				uint32_t gs = GBAView32(g->cpu, 0x03002A9Cu);
				uint8_t sa = GBAView8(g->cpu, 0x03002AD8u);
				fprintf(stderr, "HSL f=%d st=%d pc=%d im=%d hm=%d sa=%d gstat=%08X(M=%d pc=%d) sio=%04X tr0=%04X\n",
				        f, st, GBAView8(g->cpu, 0x03002AF7u),
				        GBAView8(g->cpu, 0x03002AF4u), GBAView8(g->cpu, 0x03002B02u),
				        (int) sa, gs, (int)((gs & 0x20u) ? 1 : 0),
				        (int)((gs & 0x1Cu) >> 2),
				        GBAView16(g->cpu, 0x04000128u),
				        GBAView16(g->cpu, 0x03002AF8u));
			}
		}
	}
	/* 产品路径需要把同一份按键掩码交给 mgbaMobileSetKeys（产品帧循环会用
	 * beginFrameKeys 重设 core 按键），原路径忽略返回值即可。 */
	return keys;
}

static void lsUserSleep(struct mLockstepUser* u) {
	LsUser* lu = (LsUser*) u;
	std::unique_lock<std::mutex> lk(lu->m);
	lu->pauseRequested = true;
}
static void lsUserWake(struct mLockstepUser* u) {
	LsUser* lu = (LsUser*) u;
	{
		std::unique_lock<std::mutex> lk(lu->m);
		lu->pauseRequested = false;
	}
	lu->c.notify_one();
}
static int lsUserRequestedId(struct mLockstepUser* u) {
	return ((LsUser*) u)->id;
}
} // namespace

static int busGameLockstepTest(const QString& rom, const QString& sav, int players) {
	/* gen8 没有 3 人战斗模式：单打/双打=2 人、多人(multi-battle)=4 人。
	 * 3 核测试本质无效（主机 linkPlayerCount=3 < tMinPlayers=4 → 永不
	 * SaveLinkPlayers → 握手不触发）。这里强制 4 核，对应 multi-battle。 */
	if (players < 4) {
		players = 4;
	}
	if (players > 4) {
		players = 4;
	}
	/* T-03 补做 / ADR-002 R7：判据窗口必须绑定当前 ROM，绝不写死旧布局常量。
	 * 解析失败时明确报 STALE_BATTLE_WINDOW 并以退出码 2 结束（不启动 4 核、
	 * 不烧 4 分钟、也不静默给 BATTLE=NO）。 */
	g_battleWindow = resolveBattleWindow(rom);
	if (!g_battleWindow.valid) {
		const QString text = QStringLiteral("STALE_BATTLE_WINDOW: %1\n")
		                             .arg(g_battleWindow.error);
		const QByteArray err = text.toUtf8();
		fputs(err.constData(), stderr);
		fputs(err.constData(), stdout);
		FILE* rf = fopen("ls_result.txt", "w");
		if (rf) {
			fprintf(rf, "LS: FAIL BATTLE=NO (STALE_BATTLE_WINDOW)\n");
			fputs(err.constData(), rf);
			fprintf(rf, "LS rom: md5=%s mtime=%s\n",
			        qPrintable(g_battleWindow.romMd5),
			        qPrintable(g_battleWindow.romMtime));
			fclose(rf);
		}
		fflush(stderr);
		fflush(stdout);
		return 2;
	}
	fprintf(stderr, "BATTLE_WINDOW: [%08X,%08X) source=%s romMd5=%s romMtime=%s\n",
	        g_battleWindow.lo, g_battleWindow.hi,
	        qPrintable(g_battleWindow.source), qPrintable(g_battleWindow.romMd5),
	        qPrintable(g_battleWindow.romMtime));
	fflush(stderr);
	auto envInt = [](const char* k, int dflt) {
		bool ok = false;
		int v = qEnvironmentVariableIntValue(k, &ok);
		return ok ? v : dflt;
	};
	/* 进战斗稳定发生在 f≈3073~3090（三条独立落盘日志：battleFrames=[3073,5340]、
	 * [3090,5515]、[3077,4478]）。旧默认 3000 帧 / 45s 窗口必然跑不到那一帧，
	 * 是确定性假阴性，故把默认窗口对齐历史上验证过的 9000 帧 / 260s。
	 * 注意：窗口对齐只是必要条件，不是充分条件 —— 本用例还依赖存档起始状态
	 * （直接传 D:/gen8/rom.sav 时运行会回写它）与机器负载，属 long/flaky 诊断套件。
	 * 可重复入口见 tools/busgame-lockstep.sh；环境变量仍可覆盖默认值。 */
	const int wallLimitMs = envInt("BUSGAME_TIMEOUT_MS", 260000);
	const int maxFrames = envInt("BUSGAME_FRAMES", 9000);
	const int menuAt = envInt("BUSGAME_MENU_AT", 1500);
	const int modeDowns = envInt("BUSGAME_MODE_DOWNS", 2);
	/* 挂锁步驱动的帧号，默认 10。曾试过推迟到 300 规避 BIOS 阶段 SIO 模式
	 * 洪泛导致的 "No free events" 段错误，但会让 4 核帧号发散(frameSpread
	 * 2→10~15)、降低进对战成功率。该崩溃已在 src/gba/sio/lockstep.c 的
	 * _enqueueEvent 里根治（池满复用最老事件），故无需再推迟。
	 * 可用 BUSGAME_ATTACH_AT 覆盖做 A/B。 */
	const int attachThreshold = envInt("BUSGAME_ATTACH_AT", 10);
	/* BUSGAME_PRODUCT=1（或 busgame-product 入口）：4 核改用产品侧 MgbaMobile
	 * + mgbaMobileLinkHostLockstep/JoinLockstep + mgbaMobileRunFrames，其余
	 * 按键/内存判据脚本完全复用。默认 0，保持已验证的底层协调器路径不变。 */
	const bool productMode = envInt("BUSGAME_PRODUCT", 0) != 0;
	struct MgbaMobile* emus[4] = {};

	const QByteArray romUtf8 = QFileInfo(rom).absoluteFilePath().toUtf8();
	QString savCopy[4];
	for (int i = 0; i < players; ++i) {
		savCopy[i] = sav + QStringLiteral(".lslock%1").arg(i);
		QFile::remove(savCopy[i]);
		QFile::copy(sav, savCopy[i]);
	}

	static mColor video[4][240 * 160];
	g_lsVideo = video;
	struct mCore* cores[4] = {};
	if (productMode) {
		mLogSetDefaultLogger(&s_lsSilentLogger);
		/* 每核独立存档目录：MgbaMobile 按 <rom>.sav 自动加载电池存档。 */
		QString savName = QFileInfo(rom).completeBaseName() + QStringLiteral(".sav");
		QString root = QFileInfo(sav).absolutePath();
		for (int i = 0; i < players; ++i) {
			QString dir = root + QStringLiteral("/product_ls_%1").arg(i);
			QDir().mkpath(dir);
			QString dst = dir + QStringLiteral("/") + savName;
			QFile::remove(dst);
			QFile::copy(savCopy[i], dst);
			QByteArray dirUtf8 = dir.toUtf8();
			emus[i] = mgbaMobileCreate(dirUtf8.constData(), dirUtf8.constData(), "pcproductgame");
			if (!emus[i] || !mgbaMobileLoad(emus[i], romUtf8.constData())) {
				fprintf(stderr, "LS: FAIL (product core %d load)\n", i);
				return 1;
			}
			cores[i] = mgbaMobileDebugCore(emus[i]);
			if (!cores[i]) {
				fprintf(stderr, "LS: FAIL (product core %d debug core)\n", i);
				return 1;
			}
			cores[i]->setVideoBuffer(cores[i], video[i], 240);
			mCoreConfigSetIntValue(&cores[i]->config, "logLevel",
			                       envInt("BUSGAME_LOGLEVEL", mLOG_WARN));
			/* BIOS 阶段先不挂驱动，跑满 attachThreshold 帧再接房间。 */
			for (int f = 0; f < attachThreshold; ++f) {
				mgbaMobileRunFrames(emus[i], 1);
			}
		}
		if (!mgbaMobileLinkHostLockstep(emus[0], 0x4C53, players, 0)) {
			fprintf(stderr, "LS: FAIL (product lockstep host)\n");
			return 1;
		}
		for (int i = 1; i < players; ++i) {
			if (!mgbaMobileLinkJoinLockstep(emus[i], 0x4C53, i)) {
				fprintf(stderr, "LS: FAIL (product lockstep join %d)\n", i);
				return 1;
			}
		}
		fprintf(stderr, "LS: product lockstep attached %d cores after %d boot frames\n",
		        players, attachThreshold);
	} else {
		for (int i = 0; i < players; ++i) {
			VFile* romVf = VFileOpen(romUtf8.constData(), O_RDONLY);
			if (!romVf) {
				romVf = VFileOpenFD(romUtf8.constData(), O_RDONLY);
			}
			if (!romVf) {
				fprintf(stderr, "LS: FAIL (cannot open rom)\n");
				return 1;
			}
			cores[i] = mCoreFindVF(romVf);
			if (!cores[i]) {
				fprintf(stderr, "LS: FAIL (cannot find core)\n");
				return 1;
			}
			cores[i]->init(cores[i]);
			mCoreConfigInit(&cores[i]->config, NULL);
			int lvl = envInt("BUSGAME_LOGLEVEL", mLOG_WARN);
			mCoreConfigSetIntValue(&cores[i]->config, "logLevel", lvl);
			if (!cores[i]->loadROM(cores[i], romVf)) {
				fprintf(stderr, "LS: FAIL (cannot load rom)\n");
				return 1;
			}
			const QByteArray savUtf8 = savCopy[i].toUtf8();
			VFile* sv = VFileOpen(savUtf8.constData(), O_RDWR);
			if (sv && !cores[i]->loadSave(cores[i], sv)) {
				fprintf(stderr, "LS: WARN (core %d loadSave failed)\n", i);
			}
			cores[i]->reset(cores[i]);
			cores[i]->setVideoBuffer(cores[i], video[i], 240);
		}
	}

	struct GBASIOLockstepCoordinator coord;
	GBASIOLockstepCoordinatorInit(&coord);

	std::atomic<int> frames[4];
	LsCtx pctx[4];
	struct GBASIOLockstepDriver nodes[4];
	LsUser users[4];
	std::thread threads[4];
	std::atomic<bool> hold[4];
	std::atomic<bool> held[4];
	std::atomic<bool> stop(false);
	/* 驱动模型开关。threaded（默认）= 4 线程自由竞争，已验证 LINKUP 可达但
	 * 有 OS 分时抖动；serial = 单一调度线程严格轮转驱动 4 核，sleep/wake 退化
	 * 为纯标志（无线程挂起、无分时），推进顺序完全确定。依据：协调器源码里
	 * 没有任何阻塞/condvar 等待，共享状态仅一把短 mutex，全靠 user->sleep/wake
	 * 暂停恢复各核，故单线程轮转在语义上等价且更确定。 */
	const bool serialDriver = envInt("BUSGAME_DRIVER_SERIAL", 0) != 0;
	for (int i = 0; i < players; ++i) {
		frames[i].store(0);
		hold[i].store(false);
		held[i].store(false);
		pctx[i].idx = i;
		pctx[i].frame = &frames[i];
		pctx[i].menuAt = menuAt;
		pctx[i].modeDowns = modeDowns;
		memset(&nodes[i], 0, sizeof(nodes[i]));
		users[i].id = i;
		users[i].pauseRequested = false;
		users[i].d.sleep = lsUserSleep;
		users[i].d.wake = lsUserWake;
		users[i].d.requestedId = lsUserRequestedId;
		users[i].d.playerIdChanged = nullptr;
	}

	/* 全程峰值追踪：监控线程在锁步跑动期间持续采样各核 gLink 状态，
	 * 记录“到过的最高 pc / 最高 st / 是否见过 0x8FFF 主握手字”。终态掉线
	 * 时仍能区分“全员曾连上后掉”与“个别核从未连上”。 */
	std::atomic<int> maxSt[4];
	std::atomic<int> maxPc[4];
	std::atomic<bool> saw8FFF[4];
	std::atomic<bool> monitorStop(false);
	/* 4 核帧号离散度峰值：量化调度抖动。serial 下恒为 0（严格同步）。 */
	std::atomic<int> maxFrameSpread(0);
	/* 严格 LINKUP 判据：必须观察到「游戏态 st==4 且 pc==players」。
	 * 单看 tr0==0x8FFF 会假阳性——握手过程中主握手字会短暂出现在接收缓冲，
	 * 但游戏并未把状态推进到 4（实测：8FFF 见过而 gstat=0x370 从未出现）。
	 * 真 LINKUP 的硬标志是 gLinkStatus 带 0x100 且 st=4。 */
	std::atomic<int> st4Samples(0);
	std::atomic<int> firstSt4Frame(-1);
	std::atomic<int> lastSt4Frame(-1);
	/* 真正的终点判据：进入对战。gMain.callback2 在 0x02029118
	 * （gMain=0x02029114，struct Main 偏移 +4）。BattleMainCB2 与
	 * battle_main.o 的 .text 窗口**由 rom.map 动态解析**（见 resolveBattleWindow），
	 * 不用写死常数 —— ROM 一重新链接代码段就整体平移，写死必过期。
	 * 注意 LST 里打印的 0x03002AD4 是 gLinkCallback，不是 callback2。 */
	std::atomic<int> battleSamples(0);
	std::atomic<int> firstBattleFrame(-1);
	std::atomic<int> lastBattleFrame(-1);
	std::atomic<uint32_t> lastCb2(0);
	/* 菜单选择结果（gen8 实测地址）：
	 * gSpecialVar_0x8004 @0x0202199C 须为 5 (USING_MULTI_BATTLE)；
	 * gLinkType         @0x02027BB2 须为 0x2255 (LINKTYPE_MULTI_BATTLE)；
	 * gSpecialVar_Result@0x020219AC 1=SUCCESS 3=项目不一致。
	 * 用内存判定「4 核是否都选中多人模式」，避免靠盲按帧号猜。 */
	std::atomic<int> lastLinkType[4];
	std::atomic<int> lastVar8004[4];
	std::atomic<int> lastResult[4];
	std::atomic<int> multiTypeMask(0);
	std::atomic<int> varMultiMask(0);
	/* 玩家格坐标（gSaveBlock1Ptr @0x03004964 → SaveBlock1.pos，x@+0 y@+2）。
	 * 4P 竞技场座位 (3,4)/(10,4)/(3,6)/(10,6)，warp 点是 (5,8)。 */
	std::atomic<int> lastPosX[4];
	std::atomic<int> lastPosY[4];
	for (int i = 0; i < players; ++i) {
		maxSt[i].store(0);
		maxPc[i].store(0);
		saw8FFF[i].store(false);
		lastLinkType[i].store(0);
		lastVar8004[i].store(0);
		lastResult[i].store(0);
		lastPosX[i].store(-1);
		lastPosY[i].store(-1);
	}

	/* 两种驱动模型：
	 * threaded（默认）：每核一个 std::thread，runLoop 按真实帧推进。一次
	 *   runLoop 只跑到下一个 timing 事件（小步），避免 runFrame 一次跑
	 *   ~28 万周期把单核冲到前面、睡死其它核。锁步靠协调器 sleep/wake
	 *   跨线程会合。已验证能让 4 核 LINKUP，但每帧上百次 park/unpark +
	 *   4 线程自由竞争带来 OS 分时抖动。
	 * serial：单一调度线程严格轮转驱动全部 4 核，每轮对「未被 sleep 的核」
	 *   各调一次 runLoop。协调器的 sleep/wake 退化为纯标志，无线程挂起、
	 *   无内核调度、无分时竞争 —— 推进顺序 100% 确定。协调器内不做任何
	 *   阻塞等待（源码确认），故此模型语义等价且更确定。
	 */
	if (productMode) {
		/* 产品帧循环：整帧调用 mgbaMobileRunFrames（内部走 mgbaLockstepRunFrame
		 * 的小步 runLoop + 自我 park）。按键必须先交给 mgbaMobileSetKeys，
		 * 否则产品循环的 beginFrameKeys 会把脚本按键覆盖成 0。 */
		for (int i = 0; i < players; ++i) {
			threads[i] = std::thread([&, i]() {
				int f = attachThreshold;
				while (!stop.load()) {
					if (hold[i].load()) {
						held[i].store(true);
						while (hold[i].load() && !stop.load()) {
							std::this_thread::yield();
						}
						held[i].store(false);
						continue;
					}
					frames[i].store(++f);
					uint32_t keys = lsInjectKeys(cores[i], i, f,
					                             pctx[i].menuAt, pctx[i].modeDowns);
					mgbaMobileSetKeys(emus[i], keys);
					mgbaMobileRunFrames(emus[i], 1);
				}
			});
		}
	} else if (serialDriver) {
		threads[0] = std::thread([&]() {
			bool serAttached = false;
			int f = 0;
			while (f < maxFrames) {
				++f;
				/* 帧首：所有核按同一帧号注入按键（严格同步，无先后差）。 */
				for (int k = 0; k < players; ++k) {
					frames[k].store(f);
					lsInjectKeys(cores[k], k, f, pctx[k].menuAt, pctx[k].modeDowns);
				}
				uint32_t base[4];
				for (int k = 0; k < players; ++k) {
					base[k] = ((struct GBA*) cores[k]->board)->video.frameCounter;
				}
				/* 帧内：严格轮转小步，直到所有核都进帧。被协调器 sleep 的核
				 * 本轮跳过（等价于它 park），wake 后下一轮恢复。 */
				int guard = 0;
				int allPaused = 0;
				while (guard++ < 500000) {
					int ran = 0;
					for (int k = 0; k < players; ++k) {
						if (users[k].pauseRequested) {
							continue;
						}
						cores[k]->runLoop(cores[k]);
						++ran;
					}
					if (ran == 0) {
						if (++allPaused > 2000) {
							fprintf(stderr, "LS: serial DEADLOCK (all %d cores asleep at frame %d)\n",
							        players, f);
							break;
						}
						std::this_thread::yield();
					} else {
						allPaused = 0;
					}
					bool all = true;
					for (int k = 0; k < players; ++k) {
						if (((struct GBA*) cores[k]->board)->video.frameCounter == base[k]) {
							all = false;
							break;
						}
					}
					if (all) {
						break;
					}
				}
				/* 第 10 帧后挂锁步驱动：单线程、且此刻无 runLoop 在跑，
				 * 无需 threaded 路径的 hold 暂停协议。 */
				if (!serAttached && f >= attachThreshold) {
					for (int k = 0; k < players; ++k) {
						GBASIOLockstepDriverCreate(&nodes[k], &users[k].d);
						GBASIOLockstepCoordinatorAttach(&coord, &nodes[k]);
						cores[k]->setPeripheral(cores[k], mPERIPH_GBA_LINK_PORT, &nodes[k].d);
					}
					serAttached = true;
					fprintf(stderr, "LS: serial attached %d cores at frame %d\n", players, f);
				}
			}
			fprintf(stderr, "LS: serial driver finished at frame %d\n", f);
		});
	} else {
		for (int i = 0; i < players; ++i) {
		threads[i] = std::thread([&, i]() {
			struct mCore* core = cores[i];
			struct GBA* gba = (struct GBA*) core->board;
			int f = 0;
			while (!stop.load()) {
				if (hold[i].load()) {
					held[i].store(true);
					while (hold[i].load() && !stop.load()) {
						std::this_thread::yield();
					}
					held[i].store(false);
					continue;
				}
				f = frames[i].fetch_add(1) + 1;
				lsInjectKeys(core, i, f, pctx[i].menuAt, pctx[i].modeDowns);
				uint32_t startFc = gba->video.frameCounter;
				do {
					/* 锁步暂停：协调器通过 sleep 置 pauseRequested（非阻塞），
					 * 本核在 runLoop 后自我 park，直到 wake 清标志并通知。 */
					{
						std::unique_lock<std::mutex> lk(users[i].m);
						if (users[i].pauseRequested) {
							users[i].c.wait(lk, [&] { return !users[i].pauseRequested; });
						}
					}
					core->runLoop(core);
					if (gba->video.frameCounter == startFc) {
						std::this_thread::yield();
					}
				} while (gba->video.frameCounter == startFc
				         && !stop.load() && !hold[i].load());
			}
		});
		}
	}

	auto t0 = std::chrono::steady_clock::now();
	auto elapsedMs = [&]() {
		return (int) std::chrono::duration_cast<std::chrono::milliseconds>(
		    std::chrono::steady_clock::now() - t0).count();
	};

	bool attached = false;
	/* 等所有核跑到 attachThreshold 帧再挂锁步驱动（避开 BIOS 的 SIO 模式
	 * 抖动洪泛）。挂驱动前用 hold 干净暂停所有 worker。 */
	while (elapsedMs() < wallLimitMs) {
		bool all = true;
		for (int i = 0; i < players; ++i) {
			if (frames[i].load() < attachThreshold) {
				all = false;
			}
		}
		if (all) {
			attached = true;
			break;
		}
		QThread::msleep(2);
	}
	/* serial 路径已在自己的调度线程内、且无 runLoop 在跑时完成 attach，
	 * 主线程不得重复挂驱动（会破坏协调器 player 表）。 */
	if (productMode) {
		/* 产品路径在创建阶段已 attach 完毕，这里绝不能再挂底层 driver，
		 * 否则会覆盖产品 MgbaMobile 的 SIO 外设。 */
		fprintf(stderr, attached ? "LS: product attach already done at startup\n"
		                         : "LS: FAIL (product cores never started)\n");
	} else if (attached && serialDriver) {
		fprintf(stderr, "LS: serial attach handled inside driver thread\n");
	} else if (attached) {
		for (int i = 0; i < players; ++i) {
			hold[i].store(true);
		}
		int waited = 0;
		while (waited++ < 5000) {
			bool allHeld = true;
			for (int i = 0; i < players; ++i) {
				if (!held[i].load()) {
					allHeld = false;
				}
			}
			if (allHeld) {
				break;
			}
			QThread::msleep(2);
		}
		for (int i = 0; i < players; ++i) {
			GBASIOLockstepDriverCreate(&nodes[i], &users[i].d);
			GBASIOLockstepCoordinatorAttach(&coord, &nodes[i]);
			cores[i]->setPeripheral(cores[i], mPERIPH_GBA_LINK_PORT, &nodes[i].d);
		}
		for (int i = 0; i < players; ++i) {
			hold[i].store(false);
		}
		fprintf(stderr, "LS: attached %d cores at frame>=%d\n", players, attachThreshold);
	} else {
		fprintf(stderr, "LS: FAIL (never reached attach frame %d)\n", attachThreshold);
	}

	/* 监控线程：锁步跑动期间持续采样各核 gLink 峰值。读内存是只读的、
	 * 诊断用途，偶发撕裂读不影响峰值判定（数千次采样必然覆盖峰值）。 */
	std::thread monitor([&]() {
		while (!monitorStop.load()) {
			bool anySt4 = false;
			for (int i = 0; i < players; ++i) {
				struct GBA* gba = (struct GBA*) cores[i]->board;
				int pc = GBAView8(gba->cpu, 0x03002AF7u);
				int st = GBAView8(gba->cpu, 0x03002AF5u);
				int tr0 = GBAView16(gba->cpu, 0x03002AF8u);
				if (pc > maxPc[i].load()) { maxPc[i].store(pc); }
				if (st > maxSt[i].load()) { maxSt[i].store(st); }
				if (tr0 == 0x8FFF) { saw8FFF[i].store(true); }
				if (st == 4 && pc == players) { anySt4 = true; }
			}
			/* 严格 LINKUP：游戏态 st==4 且 pc==players，记录首末帧与采样数。 */
			int nowFrame = frames[0].load();
			if (anySt4) {
				if (firstSt4Frame.load() < 0) { firstSt4Frame.store(nowFrame); }
				lastSt4Frame.store(nowFrame);
				st4Samples.fetch_add(1);
			}
			/* 进对战：任一核 gMain.callback2 落在 battle_main.o .text 段。
			 * 同时采 4 核的菜单选择结果（gLinkType / var8004 / result）。 */
			bool anyBattle = false;
			for (int i = 0; i < players; ++i) {
				struct GBA* gba = (struct GBA*) cores[i]->board;
				uint32_t cb2 = GBAView32(gba->cpu, 0x02029118u);
				lastCb2.store(cb2);
				/* T-03 补做：动态窗口（见 resolveBattleWindow 注释）。
				 * 换 ROM 构建后地址整体平移也能正确判定，不再假阴性。 */
				if (inBattleWindow(cb2)) {
					anyBattle = true;
				}
				int lt = GBAView16(gba->cpu, 0x02027BB2u);
				int v8 = GBAView16(gba->cpu, 0x0202199Cu);
				int rs = GBAView16(gba->cpu, 0x020219ACu);
				lastLinkType[i].store(lt);
				lastVar8004[i].store(v8);
				lastResult[i].store(rs);
				if (lt == 0x2255) { multiTypeMask.fetch_or(1 << i); }
				if (v8 == 5) { varMultiMask.fetch_or(1 << i); }
				uint32_t sb1 = GBAView32(gba->cpu, 0x03004964u);
				if (sb1 >= 0x02000000u && sb1 < 0x03000000u) {
					lastPosX[i].store((int16_t) GBAView16(gba->cpu, sb1 + 0u));
					lastPosY[i].store((int16_t) GBAView16(gba->cpu, sb1 + 2u));
				}
				uint32_t ts = (uint32_t) GBAView8(gba->cpu, 0x03004A10u)
				              | ((uint32_t) GBAView8(gba->cpu, 0x03004A11u) << 8)
				              | ((uint32_t) GBAView8(gba->cpu, 0x03004A12u) << 16)
				              | ((uint32_t) GBAView8(gba->cpu, 0x03004A13u) << 24);
				g_tradeStates[i].fetch_or(ts);   /* 累积曾出现过的状态位 */
				if (i == 0) {
					int fpc = GBAView8(gba->cpu, 0x03004A39u);
					if (fpc > g_fieldPc.load()) { g_fieldPc.store(fpc); }
					if (g_cb2TraceN == 0 || g_cb2Trace[g_cb2TraceN - 1] != cb2) {
						if (g_cb2TraceN < 64) { g_cb2Trace[g_cb2TraceN++] = cb2; }
					}
				}
			}
			if (anyBattle) {
				if (firstBattleFrame.load() < 0) { firstBattleFrame.store(nowFrame); }
				lastBattleFrame.store(nowFrame);
				battleSamples.fetch_add(1);
			}
			/* 帧号离散度：量化 4 核推进错位。serial 下恒 0（严格同步）。 */
			int lo = frames[0].load(), hi = lo;
			for (int j = 1; j < players; ++j) {
				int v = frames[j].load();
				if (v < lo) { lo = v; }
				if (v > hi) { hi = v; }
			}
			int spread = hi - lo;
			if (spread > maxFrameSpread.load()) { maxFrameSpread.store(spread); }
			QThread::msleep(25);
		}
	});

	while (elapsedMs() < wallLimitMs) {
		bool all = true;
		for (int i = 0; i < players; ++i) {
			if (frames[i].load() < maxFrames) {
				all = false;
			}
		}
		if (all) {
			break;
		}
		QThread::msleep(50);
	}

	monitorStop.store(true);
	if (monitor.joinable()) {
		monitor.join();
	}
	/* 终态画面：4 核各写一张 PPM，供转 PNG 后直接观察游戏界面。 */
	for (int i = 0; i < players; ++i) {
		lsDumpPPM(i);
	}
	/* serial 路径只有 1 个调度线程且会自然跑完，join 后收集更干净；
	 * threaded 路径的核仍卡在锁步 wait，不 join（见文件尾 _Exit 说明）。 */
	if (serialDriver && threads[0].joinable()) {
		threads[0].join();
	}

	int terminalPc[4] = {0, 0, 0, 0};
	int failures = 0;
	int everLinked = 0;
	for (int i = 0; i < players; ++i) {
		struct GBA* gba = (struct GBA*) cores[i]->board;
		int pc = GBAView8(gba->cpu, 0x03002AF7u);
		int st = GBAView8(gba->cpu, 0x03002AF5u);
		int im = GBAView8(gba->cpu, 0x03002AF4u);
		int lc = GBAView8(gba->cpu, 0x03002AF6u);
		terminalPc[i] = pc;
		if (maxPc[i].load() < players) {
			++failures;
		}
		if (saw8FFF[i].load()) {
			++everLinked;
		}
		fprintf(stderr, "LS core %d: frame=%d im=%d lc=%d pc=%d st=%d "
		        "peakPc=%d peakSt=%d saw8FFF=%d\n",
		        i, frames[i].load(), im, lc, pc, st,
		        maxPc[i].load(), maxSt[i].load(), saw8FFF[i].load() ? 1 : 0);
	}

	/* 两层判据：
	 * linkedUp  = 联机层握手达成（游戏态 st==4 且 pc==players）。仅 8FFF/pc
	 *             峰值会假阳性，必须看 st。
	 * inBattle  = 真正进入对战（gMain.callback2 落在 battle_main.o），这才是
	 *             3/4 人联机要跑通的目标。退出码以 inBattle 为准。 */
	bool linkedUp = (failures == 0) && (everLinked > 0) && (st4Samples.load() > 0);
	bool inBattle = (battleSamples.load() > 0);
	/* stdout/stderr 都有 GBA 内核日志且无缓冲，逐字段 fprintf 会被交错截断。
	 * 先把两行结论拼进单个缓冲，再一次性写出；同时落到独立结果文件，
	 * 供脚本可靠读取（文件写入是一次 fputs，不会被别的输出插队）。 */
	char report[2048];
	snprintf(report, sizeof(report),
	        "LS: %s BATTLE=%s driver=%s frameSpread=%d "
	        "st4Samples=%d st4Frames=[%d,%d] battleSamples=%d battleFrames=[%d,%d] "
	        "lastCb2=%08X (%d/%d cores reached playerCount=%d, %d cores saw 8FFF, "
	        "terminal pc=[%d,%d,%d,%d])\n"
	        "LS menu: linkType=[%04X,%04X,%04X,%04X] "
	        "var8004=[%d,%d,%d,%d] result=[%d,%d,%d,%d] "
	        "multiTypeMask=%X varMultiMask=%X forceWrites=%d menuMaxSeen=%d\n"
	        "LS field: pos=[(%d,%d),(%d,%d),(%d,%d),(%d,%d)]\n"
	        "LS dbg: menuMax=[%d,%d,%d,%d] walk=[%08X,%08X,%08X,%08X]\n"
	        "LS party: type=[%d,%d,%d,%d] sel=[%04X,%04X,%04X,%04X] "
	        "slot=[%d,%d,%d,%d]\n"
	        "LS room: tradeEver=[%08X,%08X,%08X,%08X] maxFieldPc=%d\n"
	        "LS rom: md5=%s mtime=%s battleWindow=[%08X,%08X) source=%s\n",
	        linkedUp ? "LINKUP-ACHIEVED" : "FAIL",
	        inBattle ? "YES" : "NO",
	        serialDriver ? "serial" : "threaded", maxFrameSpread.load(),
	        st4Samples.load(), firstSt4Frame.load(), lastSt4Frame.load(),
	        battleSamples.load(), firstBattleFrame.load(), lastBattleFrame.load(),
	        lastCb2.load(),
	        players - failures, players, players, everLinked,
	        terminalPc[0], terminalPc[1], terminalPc[2], terminalPc[3],
	        lastLinkType[0].load(), lastLinkType[1].load(),
	        lastLinkType[2].load(), lastLinkType[3].load(),
	        lastVar8004[0].load(), lastVar8004[1].load(),
	        lastVar8004[2].load(), lastVar8004[3].load(),
	        lastResult[0].load(), lastResult[1].load(),
	        lastResult[2].load(), lastResult[3].load(),
	        multiTypeMask.load(), varMultiMask.load(),
	        g_forceMultiWrites.load(), g_menuMaxSeen.load(),
	        lastPosX[0].load(), lastPosY[0].load(),
	        lastPosX[1].load(), lastPosY[1].load(),
	        lastPosX[2].load(), lastPosY[2].load(),
	        lastPosX[3].load(), lastPosY[3].load(),
	        g_menuMaxPerCore[0].load(), g_menuMaxPerCore[1].load(),
	        g_menuMaxPerCore[2].load(), g_menuMaxPerCore[3].load(),
	        g_walkDbg[0].load(), g_walkDbg[1].load(),
	        g_walkDbg[2].load(), g_walkDbg[3].load(),
	        g_partyType[0].load(), g_partyType[1].load(),
	        g_partyType[2].load(), g_partyType[3].load(),
	        g_selOrder[0].load(), g_selOrder[1].load(),
	        g_selOrder[2].load(), g_selOrder[3].load(),
	        g_partySlot[0].load(), g_partySlot[1].load(),
	        g_partySlot[2].load(), g_partySlot[3].load(),
	        g_tradeStates[0].load(), g_tradeStates[1].load(),
	        g_tradeStates[2].load(), g_tradeStates[3].load(),
	        g_fieldPc.load(),
	        qPrintable(g_battleWindow.romMd5), qPrintable(g_battleWindow.romMtime),
	        g_battleWindow.lo, g_battleWindow.hi, qPrintable(g_battleWindow.source));
	fputs(report, stdout);
	fflush(stdout);
	const QByteArray aux = cb2RelativeAux().toUtf8();
	FILE* rf = fopen("ls_result.txt", "w");
	if (rf) {
		fputs(report, rf);
		fprintf(rf, "LS cb2trace (%d):", g_cb2TraceN);
		for (int i = 0; i < g_cb2TraceN; ++i) {
			fprintf(rf, " %08X", g_cb2Trace[i]);
		}
		fputc('\n', rf);
		/* 相对序列辅助判据：地址随 ROM 重编译整体平移时它保持不变，
		 * 可用来交叉核对动态窗口是否用对了构建。 */
		fputs(aux.constData(), rf);
		fclose(rf);
	}
	fputs(aux.constData(), stdout);
	fflush(stderr);

	/* 核仍卡在锁步 wait 里，逐一 End/Join + deinit 会与协调器互相等待而
	 * 段错误（实测 139）。这是一次性诊断进程，直接 _Exit 让 OS 回收，
	 * 避免脆弱的拆解顺序。退出码：真正进对战=0，否则=1。 */
	_Exit(inBattle ? 0 : 1);
	return inBattle ? 0 : 1;
}


/**
 * 帧长上限：一个 GBA 状态约 790 KiB，必须能完整穿过 Reader。
 *
 * 原来的上限是 65535，状态帧被判成「不是我们认识的帧」后整段流被丢弃 ——
 * 后面所有帧（含按键帧）都从错位的偏移解析，表现为一批假的按键输入、以及
 * 对端永远收不到状态。安卓 / iOS / PC 的 KcpChannel 与 GBoyFrames 都有同一个
 * 上限，这里把 PC 侧的行为钉住。
 */
static int framesTest() {
	int failures = 0;

	/* 官方类型号（NETPLAY_AUDIT.md §0 / A.13 / C1–C3）：0 = 按键掩码、
	 * 9 = 速度倍率、5 = 复位。早先 0/9 对调过一次，整条输入通道语义反了，
	 * 这里把数值钉死，谁再换回来测试就先红。
	 * 依据：按键发送点 p1.txt 0x348364（AaHO0E 模拟线程 ARc23Z(0,4)），
	 * 倍速发送点 B25kr6.java:253-258（AZOQYO(int) → type 9），
	 * 复位发送点 EmulatorActivity.java:1333（BmvVmW → type 5）。 */
	if (int(GBoyFrames::TYPE_KEYS) != 0 || int(GBoyFrames::TYPE_SPEED) != 9
	    || int(GBoyFrames::TYPE_RESET) != 5 || int(GBoyFrames::TYPE_REGISTER) != 1
	    || int(GBoyFrames::TYPE_NAME) != 2 || int(GBoyFrames::TYPE_READY) != 3
	    || int(GBoyFrames::TYPE_STATE) != 6) {
		qInfo().noquote() << QString("FRAMES TEST: FAIL (official type map drifted: "
		                             "keys=%1 speed=%2 reset=%3)")
		                         .arg(int(GBoyFrames::TYPE_KEYS))
		                         .arg(int(GBoyFrames::TYPE_SPEED))
		                         .arg(int(GBoyFrames::TYPE_RESET));
		++failures;
	}
	/* 官方注册帧（AmA8tU:173-178 + A5SV6n 的 `write(array())`）：`ARc23Z(1,10)`
	 * 恒分配 16 字节、长度字段恒为 12，发送线程写整个 backing array，所以**线上
	 * 永远是 16 字节**；playerCount==1 只是把尾部 6 字节填上（short 0 + listSize），
	 * 否则尾部保持 0。早先按「多人房只发 10 字节」理解是误读了 fill 与 not-fill。 */
	if (GBoyFrames::registerFrame(2, 0).size() != 16
	    || GBoyFrames::registerFrame(4, 0).size() != 16
	    || GBoyFrames::registerFrame(1, 3).size() != 16) {
		qInfo().noquote() << QString("FRAMES TEST: FAIL (register frame length: pc2=%1 pc1=%2)")
		                         .arg(GBoyFrames::registerFrame(2, 0).size())
		                         .arg(GBoyFrames::registerFrame(1, 3).size());
		++failures;
	}

	// 256 KiB 的载荷，按 2048 字节一片喂进去（模拟真实 TCP/KCP 分片）。
	const int blobSize = 256 * 1024;
	QByteArray blob(blobSize, '\0');
	for (int i = 0; i < blobSize; ++i) {
		blob[i] = char((i * 37 + (i >> 8)) & 0xFF);
	}
	QByteArray big = GBoyFrames::frame(GBoyFrames::TYPE_STATE, blob);
	if (big.size() != blobSize + 6) {
		qInfo().noquote() << QString("FRAMES TEST: FAIL (encoded %1 bytes, want %2)")
		                         .arg(big.size()).arg(blobSize + 6);
		return 1;
	}

	GBoyFrames::Reader reader;
	QByteArray got;
	for (int off = 0; off < big.size(); off += 2048) {
		reader.append(big.constData() + off, qMin(2048, big.size() - off));
		QByteArray body;
		while (!(body = reader.next()).isEmpty()) {
			got = body;
		}
	}
	if (got.isEmpty()) {
		qInfo() << "FRAMES TEST: FAIL (reader never emitted the large frame)";
		++failures;
	} else if (GBoyFrames::typeOf(got) != GBoyFrames::TYPE_STATE) {
		qInfo().noquote() << QString("FRAMES TEST: FAIL (type %1, want %2)")
		                         .arg(GBoyFrames::typeOf(got)).arg(int(GBoyFrames::TYPE_STATE));
		++failures;
	} else if (GBoyFrames::payloadOf(got) != blob) {
		qInfo().noquote() << QString("FRAMES TEST: FAIL (payload %1 bytes, want %2)")
		                         .arg(GBoyFrames::payloadOf(got).size()).arg(blobSize);
		++failures;
	}

	// 大帧之后紧跟一个小帧：流必须仍然对齐（旧上限的另一个症状就是这里错位）。
	QByteArray small = GBoyFrames::frame(GBoyFrames::TYPE_KEYS, 0x0A0B);
	reader.append(small.constData(), small.size());
	QByteArray after = reader.next();
	if (after.isEmpty()) {
		qInfo() << "FRAMES TEST: FAIL (small frame after the large one was lost)";
		++failures;
	} else if (GBoyFrames::typeOf(after) != GBoyFrames::TYPE_KEYS
	           || GBoyFrames::intOf(after) != 0x0A0B) {
		qInfo().noquote() << QString("FRAMES TEST: FAIL (framing broke: type %1 int %2)")
		                         .arg(GBoyFrames::typeOf(after)).arg(GBoyFrames::intOf(after));
		++failures;
	}

	// TYPE_STATE 帧：u32 长度头 + blob，发送端/接收端必须严格往返。
	QByteArray snapshot("GBASTATE-test-blob");
	QByteArray stateWire = GBoyFrames::stateFrame(snapshot);
	GBoyFrames::Reader stateReader;
	stateReader.append(stateWire.constData(), stateWire.size());
	QByteArray stateBody = stateReader.next();
	if (stateBody.isEmpty() || GBoyFrames::typeOf(stateBody) != GBoyFrames::TYPE_STATE
	    || GBoyFrames::stateOf(stateBody) != snapshot) {
		qInfo() << "FRAMES TEST: FAIL (TYPE_STATE send/receive round trip lost the save blob)";
		++failures;
	}
	// SIO 中继桥也用 type 6，但 body 是 20 字节裸包（没有长度头），不能被当成存档。
	QByteArray bridge = GBoyFrames::frame(GBoyFrames::TYPE_STATE, QByteArray(20, '\x01'));
	if (!GBoyFrames::stateOf(bridge.mid(4)).isEmpty()) {
		qInfo() << "FRAMES TEST: FAIL (a raw SIO bridge packet was parsed as a save state)";
		++failures;
	}
	// 长度头越界必须拒绝，而不是按它去切 payload。
	QByteArray truncated;
	truncated.resize(2 + 4);
	truncated[0] = 0;
	truncated[1] = char(GBoyFrames::TYPE_STATE);
	GBoyFrames::putInt(&truncated, 2, 9999);
	if (!GBoyFrames::stateOf(truncated).isEmpty()) {
		qInfo() << "FRAMES TEST: FAIL (an over-long TYPE_STATE length header was accepted)";
		++failures;
	}

	// 超过上限的帧必须被拒绝：Reader 丢弃整段流，而不会试着去分配那个长度。
	// 注意顺序：putInt 直接往 data() 里写，缓冲区必须先有 4 个字节。
	QByteArray over;
	over.resize(4);
	GBoyFrames::putInt(&over, 0, GBoyFrames::maxFrameLength + 1);
	GBoyFrames::Reader guard;
	guard.append(over.constData(), over.size());
	if (!guard.next().isEmpty()) {
		qInfo() << "FRAMES TEST: FAIL (a frame above maxFrameLength was accepted)";
		++failures;
	}

	if (failures == 0) {
		qInfo().noquote() << QString("FRAMES TEST: PASS (256 KiB state frame survives, stream stays aligned, %1 MiB ceiling enforced)")
		                         .arg(GBoyFrames::maxFrameLength / (1024 * 1024));
	}
	return failures;
}

/**
 * C0 / ADR-002 能力协商位的独立断言（`test-gboylink --c0`）。
 *
 * 背景：C0 的编码（`wire[15]` = 能力位，`0x40` 已声明 / bit0 = mode）此前
 * **零自动化断言** —— grep 不到 `linkModeOf` / `LINK_CAP_MAGIC` /
 * `negotiateLinkMode` 任何一个符号，2P 云端交付门因此判 FAIL。这里把协议
 * 面钉成三组可执行断言：
 *
 *   1. 解码：`linkModeOf()` 对 6 类输入的返回值（A / B / UNKNOWN / INVALID ×
 *      3 参数帧、2 参数官方帧、裸 20 字节 SIO 包）；
 *   2. 编码：`registerFrame()` 2 参数与官方 16 字节**逐字节**一致（期望字节是
 *      写死的常量数组，不是自己再算一遍）；3 参数只在 `playerCount != 1` 时写
 *      `wire[15]`，单人房输出与 2 参数完全相同；
 *   3. AUTO 映射：1/2 人 → A，3/4 人 → B，显式 override 优先。
 *
 * 第 3 组断言的是 `GBoyFrames::autoLinkMode()` / `GBoyFrames::resolveLinkMode()`，
 * 也就是 `CloudLink::resolveLinkMode()` 转调的那份实现（测试里实例化
 * `CloudLink` 需要 session + 事件循环，硬造只会测出假东西）。
 *
 * 输出格式与 `mobile_test --link/--bus` 一致：逐项 `ok`/`FAIL`，末尾汇总，
 * 有 FAIL 则返回非零。
 */
static int c0Test() {
	int checks = 0;
	int failed = 0;
	auto expect = [&checks, &failed](bool cond, const char* what) {
		++checks;
		if (cond) {
			printf("ok c0: %s\n", what);
		} else {
			++failed;
			printf("FAIL c0: %s\n", what);
		}
		fflush(stdout);
	};

	/* ---- 1. linkModeOf() 解码 ------------------------------------------- */

	// 枚举值本身是协议面：A=0 / B=1 / UNKNOWN=-1 / INVALID=-2，Android 侧按同一
	// 组数值判定，谁改了测试先红。
	expect(int(GBoyFrames::LINK_MODE_A) == 0, "enum LINK_MODE_A == 0");
	expect(int(GBoyFrames::LINK_MODE_B) == 1, "enum LINK_MODE_B == 1");
	expect(int(GBoyFrames::LINK_MODE_UNKNOWN) == -1, "enum LINK_MODE_UNKNOWN == -1");
	expect(int(GBoyFrames::LINK_MODE_INVALID) == -2, "enum LINK_MODE_INVALID == -2");
	expect(GBoyFrames::LINK_CAP_MAGIC == 0x40, "LINK_CAP_MAGIC == 0x40");
	expect(GBoyFrames::LINK_CAP_MODE_BIT == 0x01, "LINK_CAP_MODE_BIT == 0x01");

	/* registerFrame() 返回的是**整帧**（4 字节长度头 + 12 字节 body），
	 * linkModeOf() 吃的是 body（type + payload，无长度头），所以断言前先
	 * 去掉 4 字节长度头 —— 这与线上路径完全一致：Reader 交出来的就是 body。 */
	auto bodyOf = [](const QByteArray& wire) { return wire.mid(4); };
	auto capByte = [](const QByteArray& wire) {
		return quint8(uchar(wire.at(15)));   // wire[15] == body[11]
	};

	const QByteArray registerA = GBoyFrames::registerFrame(2, 0, GBoyFrames::LINK_MODE_A);
	const QByteArray registerB = GBoyFrames::registerFrame(2, 0, GBoyFrames::LINK_MODE_B);
	const QByteArray registerUnknown = GBoyFrames::registerFrame(2, 0, GBoyFrames::LINK_MODE_UNKNOWN);
	const QByteArray registerOfficial = GBoyFrames::registerFrame(2, 0);

	expect(registerA.size() == 16, "3-arg register frame stays 16 bytes (mode A)");
	expect(bodyOf(registerA).size() == 12,
	       "register body is 12 bytes (2 type + 4 playerCount + 6 tail), cap at body[11]");

	expect(GBoyFrames::linkModeOf(bodyOf(registerA)) == GBoyFrames::LINK_MODE_A,
	       "linkModeOf(3-arg cap 0x40) == A");
	expect(GBoyFrames::linkModeOf(bodyOf(registerB)) == GBoyFrames::LINK_MODE_B,
	       "linkModeOf(3-arg cap 0x41) == B");
	expect(GBoyFrames::linkModeOf(bodyOf(registerUnknown)) == GBoyFrames::LINK_MODE_UNKNOWN,
	       "linkModeOf(3-arg LINK_MODE_UNKNOWN, cap 0x00) == UNKNOWN");

	// 未声明：能力位恒为 0（旧客户端 / 官方 APK 的形态）。
	QByteArray capZero = registerA;
	capZero[15] = char(0x00);
	expect(GBoyFrames::linkModeOf(bodyOf(capZero)) == GBoyFrames::LINK_MODE_UNKNOWN,
	       "linkModeOf(cap 0x00) == UNKNOWN");

	// 畸形：magic 不匹配（0x42 = 只有 bit1）与保留位非 0（0xFF）都必须 INVALID，
	// 不许「猜一个最像的」。
	QByteArray capBad42 = registerA;
	capBad42[15] = char(0x42);
	expect(GBoyFrames::linkModeOf(bodyOf(capBad42)) == GBoyFrames::LINK_MODE_INVALID,
	       "linkModeOf(cap 0x42, no magic) == INVALID");
	QByteArray capBadFF = registerA;
	capBadFF[15] = char(0xFF);
	expect(GBoyFrames::linkModeOf(bodyOf(capBadFF)) == GBoyFrames::LINK_MODE_INVALID,
	       "linkModeOf(cap 0xFF, reserved bits set) == INVALID");

	// 2 参数（官方）注册帧：能力位 0，必须判成「未声明」而不是 A（A 也是 0）。
	expect(capByte(registerOfficial) == 0x00, "2-arg register frame leaves wire[15] == 0x00");
	expect(GBoyFrames::linkModeOf(bodyOf(registerOfficial)) == GBoyFrames::LINK_MODE_UNKNOWN,
	       "linkModeOf(2-arg official register frame) == UNKNOWN");

	// 非 type-1：能力位那个字节就算长得像 0x40 也不能被当成注册帧。
	QByteArray notRegister = bodyOf(registerA);
	notRegister[0] = char(0x00);
	notRegister[1] = char(GBoyFrames::TYPE_READY);   // type 3
	expect(GBoyFrames::linkModeOf(notRegister) == GBoyFrames::LINK_MODE_UNKNOWN,
	       "linkModeOf(type 3 body with 0x40 at body[11]) == UNKNOWN");

	// 截断帧（body < 12 字节）不能被越界读成能力位。
	expect(GBoyFrames::linkModeOf(bodyOf(registerA).left(11)) == GBoyFrames::LINK_MODE_UNKNOWN,
	       "linkModeOf(11-byte truncated body) == UNKNOWN");

	/* 裸 20 字节 SIO 包（path A 的 type-6 借壳）：第一个 int 是 netLink 的
	 * magic 0x314C424D，远大于 payload.size()-4，所以 stateOf() 必须拒绝；
	 * 类型号不是 1，linkModeOf() 必须 UNKNOWN —— 两类帧绝不能互相认错。 */
	QByteArray sioPacket(20, '\0');
	GBoyFrames::putInt(&sioPacket, 0, 0x314C424Du);   // link_net.c 的 kMagic
	QByteArray sioBody = bodyOf(GBoyFrames::frame(GBoyFrames::TYPE_STATE, sioPacket));
	expect(sioBody.size() == 22, "bare SIO packet wraps into a 22-byte type-6 body");
	expect(GBoyFrames::typeOf(sioBody) == GBoyFrames::TYPE_STATE, "bare SIO packet stays type 6");
	expect(GBoyFrames::linkModeOf(sioBody) == GBoyFrames::LINK_MODE_UNKNOWN,
	       "linkModeOf(bare 20-byte SIO packet) == UNKNOWN");
	expect(GBoyFrames::stateOf(sioBody).isEmpty(),
	       "stateOf(bare 20-byte SIO packet) rejects it (length > payload.size()-4)");

	/* ---- 2. registerFrame() 编码：与官方逐字节一致 ---------------------- */

	/* 官方 16 字节注册帧，playerCount = 2 / baseStateCount = 0：
	 *   00 00 00 0C   长度字段 = 2(type) + 10(payload) = 12
	 *   00 01         type 1
	 *   00 00 00 02   int32 playerCount
	 *   00 00 00 00 00 00   6 字节尾部：多人房官方保持 0
	 * （B25kr6.ARc23Z(1,10) 恒分配 16 字节 + A5SV6n 写整个 backing array） */
	static const quint8 kOfficialPc2[16] = {
		0x00, 0x00, 0x00, 0x0C,
		0x00, 0x01,
		0x00, 0x00, 0x00, 0x02,
		0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
	};
	/* playerCount = 1 / baseStateCount = 3：尾部被填成 short 0 + int32 3。
	 *   00 00 00 0C | 00 01 | 00 00 00 01 | 00 00 | 00 00 00 03 */
	static const quint8 kOfficialPc1[16] = {
		0x00, 0x00, 0x00, 0x0C,
		0x00, 0x01,
		0x00, 0x00, 0x00, 0x01,
		0x00, 0x00,
		0x00, 0x00, 0x00, 0x03,
	};
	/* playerCount = 4 / 能力位 B：多人房前 15 字节与官方一致，只有 wire[15] = 0x41。
	 *   00 00 00 0C | 00 01 | 00 00 00 04 | 00 00 00 00 00 41 */
	static const quint8 kOfficialPc4B[16] = {
		0x00, 0x00, 0x00, 0x0C,
		0x00, 0x01,
		0x00, 0x00, 0x00, 0x04,
		0x00, 0x00, 0x00, 0x00, 0x00, 0x41,
	};
	/* playerCount = 1 / baseStateCount = 0x40：尾部是 short 0 + int32 0x40，
	 * 最低字节 0x40 长得像能力位 A —— 但它是计数，不是能力位。
	 *   00 00 00 0C | 00 01 | 00 00 00 01 | 00 00 | 00 00 00 40 */
	static const quint8 kOfficialPc1Count40[16] = {
		0x00, 0x00, 0x00, 0x0C,
		0x00, 0x01,
		0x00, 0x00, 0x00, 0x01,
		0x00, 0x00,
		0x00, 0x00, 0x00, 0x40,
	};
	const QByteArray officialPc2(reinterpret_cast<const char*>(kOfficialPc2), 16);
	const QByteArray officialPc1(reinterpret_cast<const char*>(kOfficialPc1), 16);
	const QByteArray officialPc4B(reinterpret_cast<const char*>(kOfficialPc4B), 16);
	const QByteArray officialPc1Count40(reinterpret_cast<const char*>(kOfficialPc1Count40), 16);

	expect(GBoyFrames::registerFrame(2, 0) == officialPc2,
	       "registerFrame(2,0) is byte-identical to the official 16-byte frame");
	expect(GBoyFrames::registerFrame(1, 3) == officialPc1,
	       "registerFrame(1,3) is byte-identical to the official 16-byte frame");
	expect(GBoyFrames::registerFrame(2, 0, GBoyFrames::LINK_MODE_UNKNOWN) == officialPc2,
	       "registerFrame(2,0,UNKNOWN) falls back to the 2-arg official bytes");

	// 3 参数在多人房只在 wire[15] 上多 1 个字节，其余 15 字节必须与官方相同。
	auto onlyCapDiffers = [](const QByteArray& wire, const QByteArray& official, quint8 cap) {
		if (wire.size() != 16 || official.size() != 16) {
			return false;
		}
		for (int i = 0; i < 15; ++i) {
			if (wire.at(i) != official.at(i)) {
				return false;
			}
		}
		return quint8(uchar(wire.at(15))) == cap;
	};
	expect(onlyCapDiffers(registerA, officialPc2, 0x40),
	       "registerFrame(2,0,A) == official bytes except wire[15] = 0x40");
	expect(onlyCapDiffers(registerB, officialPc2, 0x41),
	       "registerFrame(2,0,B) == official bytes except wire[15] = 0x41");
	/* 绝对比对，不是「和另一个产物比」：4 人房的期望字节是写死的常量，
	 * 这样即便 2 参数版本同时写错也不会一起「对」上。 */
	expect(GBoyFrames::registerFrame(4, 0, GBoyFrames::LINK_MODE_B) == officialPc4B,
	       "registerFrame(4,0,B) matches the absolute 16-byte frame (wire[15] = 0x41)");

	// 单人房：尾部承载 baseStateCount，绝不能写能力位 —— 3 参数输出必须与
	// 2 参数**完全相同**（连传 B 也一样）。
	expect(GBoyFrames::registerFrame(1, 3, GBoyFrames::LINK_MODE_B) == officialPc1,
	       "registerFrame(1,3,B) is identical to the 2-arg frame (no cap bit in a 1-player room)");
	expect(GBoyFrames::linkModeOf(bodyOf(GBoyFrames::registerFrame(1, 3, GBoyFrames::LINK_MODE_B)))
	           == GBoyFrames::LINK_MODE_UNKNOWN,
	       "linkModeOf(1-player frame) == UNKNOWN (cap bit is not written there)");

	/* 这条是断言首跑抓到的**真缺陷**：单人房 body[11] 是 baseStateCount 的最低
	 * 字节，baseStateCount=1 时它等于 0x01。读侧原先只看 magic，于是把 0x01 判成
	 * INVALID（能力位畸形）→ 对端 fail。读侧必须镜像写侧「playerCount != 1 才写
	 * 能力位」的规则。 */
	expect(GBoyFrames::linkModeOf(bodyOf(GBoyFrames::registerFrame(1, 1)))
	           == GBoyFrames::LINK_MODE_UNKNOWN,
	       "linkModeOf(1-player frame, baseStateCount=1 -> body[11]==0x01) == UNKNOWN, not INVALID");

	/* F12 的第二个失败模式（Android C0LinkModeTest 同款断言，两端对称）：
	 * 单人房尾部计数若恰好长得像能力位（0x40 = 已声明 A、0x41 = 已声明 B），
	 * 读侧也不得认成「对端声明了 A/B」——人数门必须挡在**读 cap 之前**。
	 * 少了这道门，1 人房 + baseStateCount=0x40 会被读成 A，两端变成「都声明且一致」
	 * 直接放行，比误判 INVALID 更危险（静默走错路径）。 */
	expect(GBoyFrames::linkModeOf(bodyOf(GBoyFrames::registerFrame(1, 0x40)))
	           == GBoyFrames::LINK_MODE_UNKNOWN,
	       "linkModeOf(1-player frame, baseStateCount=0x40 -> body[11]==0x40) == UNKNOWN, not A");
	expect(GBoyFrames::linkModeOf(bodyOf(GBoyFrames::registerFrame(1, 0x41)))
	           == GBoyFrames::LINK_MODE_UNKNOWN,
	       "linkModeOf(1-player frame, baseStateCount=0x41 -> body[11]==0x41) == UNKNOWN, not B");
	// 写侧对称：单人房那几个字节归 baseStateCount，传 B 也不会动它。
	expect(GBoyFrames::registerFrame(1, 0x40, GBoyFrames::LINK_MODE_B) == officialPc1Count40,
	       "registerFrame(1,0x40,B) matches the absolute frame: tail keeps the count, no cap bit");

	// 无论几人，线上长度恒为 16（写整个 backing array，不按 fill 缩短）。
	{
		bool allSixteen = true;
		for (int players = 1; players <= 4; ++players) {
			allSixteen = allSixteen
			          && GBoyFrames::registerFrame(players, 0).size() == 16
			          && GBoyFrames::registerFrame(players, 0, GBoyFrames::LINK_MODE_A).size() == 16
			          && GBoyFrames::registerFrame(players, 0, GBoyFrames::LINK_MODE_B).size() == 16;
		}
		expect(allSixteen, "register frame is 16 bytes for 1..4 players, with and without a mode");
	}

	// 编码→解码闭环：两端各自编码，交叉读回来必须认得出对面。
	expect(GBoyFrames::linkModeOf(bodyOf(GBoyFrames::registerFrame(4, 0, GBoyFrames::LINK_MODE_A)))
	           == GBoyFrames::LINK_MODE_A
	       && GBoyFrames::linkModeOf(bodyOf(GBoyFrames::registerFrame(3, 0, GBoyFrames::LINK_MODE_B)))
	           == GBoyFrames::LINK_MODE_B,
	       "encode/decode round trip for 3- and 4-player rooms");

	/* ---- 3. AUTO 映射与 override --------------------------------------- */
	expect(GBoyFrames::autoLinkMode(1) == GBoyFrames::LINK_MODE_A, "AUTO: 1 player -> A");
	expect(GBoyFrames::autoLinkMode(2) == GBoyFrames::LINK_MODE_A, "AUTO: 2 players -> A");
	expect(GBoyFrames::autoLinkMode(3) == GBoyFrames::LINK_MODE_B, "AUTO: 3 players -> B");
	expect(GBoyFrames::autoLinkMode(4) == GBoyFrames::LINK_MODE_B, "AUTO: 4 players -> B");

	// resolveLinkMode() = override 优先，其余按 AUTO；这与
	// CloudLink::resolveLinkMode() 是同一份实现（后者只传自己的 m_modeOverride）。
	expect(GBoyFrames::resolveLinkMode(2, GBoyFrames::LINK_MODE_UNKNOWN) == GBoyFrames::LINK_MODE_A,
	       "resolve(2P, AUTO) -> A");
	expect(GBoyFrames::resolveLinkMode(3, GBoyFrames::LINK_MODE_UNKNOWN) == GBoyFrames::LINK_MODE_B,
	       "resolve(3P, AUTO) -> B");
	expect(GBoyFrames::resolveLinkMode(3, GBoyFrames::LINK_MODE_A) == GBoyFrames::LINK_MODE_A,
	       "override A beats the AUTO mapping (3P forced to A)");
	expect(GBoyFrames::resolveLinkMode(2, GBoyFrames::LINK_MODE_B) == GBoyFrames::LINK_MODE_B,
	       "override B beats the AUTO mapping (2P forced to B)");
	expect(GBoyFrames::resolveLinkMode(2, GBoyFrames::LINK_MODE_INVALID) == GBoyFrames::LINK_MODE_A,
	       "a malformed override falls back to AUTO instead of being used");

	if (failed == 0) {
		printf("c0 tests passed (%d ok / 0 FAIL)\n", checks);
		return 0;
	}
	printf("c0 tests failed (%d ok / %d FAIL)\n", checks - failed, failed);
	return 1;
}

#ifdef BUILD_QT_CLOUD
/**
 * `--gatetest` 的探针：真正驱动 CloudLink 的协商门本体。
 *
 * 为什么需要它 —— `--c0` 的断言全落在 GBoyFrames 纯函数层，`negotiateLinkMode()`
 * 的五条分支（一致通过 / 冲突拒绝 / 未声明+allow_legacy 回落 / 畸形拒绝 /
 * 单人房不误判）一条都没有被跑过。而它的两个输入入口（type-1 注册帧、
 * WSS hello 标记）都是 private，测试没有别的正当路径，所以这里用 friend
 * 探针（CloudLink.h 文件头有说明）。
 *
 * **它不复制任何判定逻辑**：对端能力位走真实的
 * `linkModeOf()` → `notePeerLinkMode()`（与 CloudLink.cpp 的
 * `case TYPE_REGISTER` 同两步、同来源串），判定走真实的
 * `negotiateLinkMode()`，断言读的是它真实写下的 `m_closed` /
 * `m_officialMode` / `m_linkMode` / `m_peerLinkMode` / `m_modeRejected`
 * 和真实 emit 出来的 `statusMessage` 文案。
 *
 * 诚实边界（不要把这当成全绿）：用例 1~7 下 `m_session == nullptr`，所以
 * `negotiateLinkMode()` 里「信令可用 → drainSignaling() 排空」那条分支是空的；
 * 它由用例 8/9/10 通过注入 `m_gatePump`（`CloudLink::m_gatePump`，生产恒为空）
 * 复刻时序来覆盖 —— **注入的是排空的时序语义，不是真网络**。真机主路径仍
 * 未做真实云端时序实测（需要活账号 + 房间）。
 */
struct CloudLinkGateProbe {
	struct Result {
		bool accepted = false;                                       // negotiateLinkMode() 返回值
		bool officialMode = false;                                   // 结果是否为 path B
		bool closed = false;                                         // fail() 是否置了 m_closed
		bool rejected = false;                                       // m_modeRejected
		int linkMode = GBoyFrames::LINK_MODE_UNKNOWN;                // 本端绑定结果
		int peerMode = GBoyFrames::LINK_MODE_UNKNOWN;                // 回写后的对端值
		qint64 elapsedMs = 0;                                        // 协商门耗时（有界等待证据）
		/** 第二次调用协商门的结果。secondCallDone=false 表示探针**没调**（见 run() 的条件），
		 *  断言助手必须把它当失败处理，否则 accepted 场景下默认值恰好成立 → 假阴性。 */
		bool secondCallDone = false;
		bool secondAccepted = false;
		qint64 secondElapsedMs = 0;
		int secondStatusCount = 0;       // 第二次调用新 emit 的文案条数
		/** 第二次调用新 emit 的**失败**文案条数（接受路径会重发一次「协商通过」状态，
		 *  那是允许的；但任何失败文案都不允许重复）。 */
		int secondFailCount = 0;
		QStringList statuses;

		/** 协商期间 emit 了多少条「联机模式协商失败」文案（重复报错检测）。 */
		int failCount() const {
			int n = 0;
			const QString want = QStringLiteral("联机模式协商失败");
			for (const QString& line : statuses) {
				if (line.contains(want)) {
					++n;
				}
			}
			return n;
		}

		/** 协商期间是否出现过含 needle 的状态/失败文案。 */
		bool said(const char* needle) const {
			const QString want = QString::fromUtf8(needle);
			for (const QString& line : statuses) {
				if (line.contains(want)) {
					return true;
				}
			}
			return false;
		}
	};

	/**
	 * @param playerCount      房间人数（决定 AUTO 映射）
	 * @param localOverride    本端显式模式；LINK_MODE_UNKNOWN = AUTO
	 * @param peerRegisterWire 对端发来的**完整**线上注册帧（含 4 字节长度头）；
	 *                         空 = 对端没发过注册帧（= 对端能力位仍为 UNKNOWN）
	 * @param allowLegacy      MGBAX_LINK_ALLOW_LEGACY 的等价开关
	 * @param pumpFactory      可选：注入 `m_gatePump`，用来模拟「信令可用但
	 *                         drainSignaling() 提前返回」的那条分支（用例 8/9/10）。
	 *                         不注入时走生产逻辑（m_session == nullptr → waitAndProcess）。
	 * @param forceInvalidBranch  用例 11 专用：跳过 notePeerLinkMode()（它遇 INVALID 会
	 *                         早退并置 m_modeRejected），直接把 m_peerLinkMode 设成
	 *                         INVALID、rejected 保持 false —— 这是 negotiateLinkMode() 里
	 *                         `peer == INVALID` 那条分支**唯一**能被走到的构造方式。
	 */
	using PumpFactory = std::function<std::function<int(int)>(QGBA::CloudLink&)>;
	/** presetLocalMode 哨兵：不改写本端已绑定模式（默认行为）。 */
	static constexpr int kNoPreset = 0x7FFFFFFF;
	static Result run(int playerCount, int localOverride, const QByteArray& peerRegisterWire,
	                  bool allowLegacy, const PumpFactory& pumpFactory = PumpFactory(),
	                  bool forceInvalidBranch = false, int presetLocalMode = kNoPreset);

	/** 泵/用例里往 CloudLink 写状态用（探针是 friend，测试代码本身不是）。 */
	static void pokePeerMode(QGBA::CloudLink& link, int mode);
	static void pokeClosed(QGBA::CloudLink& link);
};

void CloudLinkGateProbe::pokePeerMode(QGBA::CloudLink& link, int mode) {
	link.m_peerLinkMode.store(mode, std::memory_order_relaxed);
}

void CloudLinkGateProbe::pokeClosed(QGBA::CloudLink& link) {
	link.m_closed.store(true, std::memory_order_relaxed);
}

CloudLinkGateProbe::Result CloudLinkGateProbe::run(int playerCount, int localOverride,
                                                   const QByteArray& peerRegisterWire,
                                                   bool allowLegacy,
                                                   const PumpFactory& pumpFactory,
                                                   bool forceInvalidBranch,
                                                   int presetLocalMode) {
	Result result;
	/* 不 startLink()：本测试只驱动协商门，不起线程、不连网。 */
	QGBA::CloudLink link;
	QGBA::CloudLink::Room room;
	room.playerCount = playerCount;
	room.baseStateCount = 0;

	link.m_modeOverride = localOverride;
	link.m_allowLegacyPeer = allowLegacy;
	/* 与 startLink() 的「每次连接重新协商」语义对齐：上次的绑定/拒绝不得泄漏。 */
	link.m_peerLinkMode.store(GBoyFrames::LINK_MODE_UNKNOWN, std::memory_order_relaxed);
	link.m_modeBound.store(false, std::memory_order_relaxed);
	link.m_modeRejected.store(false, std::memory_order_relaxed);
	link.m_closed.store(false, std::memory_order_relaxed);
	if (pumpFactory) {
		/* 仅测试：注入等待期空闲泵（生产路径 m_gatePump 恒为空）。 */
		link.m_gatePump = pumpFactory(link);
	}

	/* statusMessage 在同一线程 emit，DirectConnection 即可同步收进 result。 */
	QObject::connect(&link, &QGBA::CloudLink::statusMessage, &link,
	                 [&result](const QString& text) { result.statuses.append(text); },
	                 Qt::DirectConnection);

	if (presetLocalMode != kNoPreset) {
		/* 用例 12 专用：先手工绑定本端模式（模拟「上一次协商已把本端定成 B」），
		 * 再看协商门是否**原样保留**它 —— 用来钉「顶部短路先于重新绑定」这条顺序。 */
		link.m_linkMode.store(presetLocalMode, std::memory_order_relaxed);
		link.m_modeBound.store(true, std::memory_order_relaxed);
	}
	if (forceInvalidBranch) {
		/* 用例 11：绕过 notePeerLinkMode()，直接把对端值放到 INVALID 且 rejected 仍为
		 * false，让 negotiateLinkMode() 里的 `peer == INVALID` 分支真的被执行一次。
		 * 生产里这条路被顶部短路挡着（INVALID 只能经 notePeerLinkMode 进来，而那里
		 * 已经把 rejected 置位），所以本用例测的是「第二道锁本身能不能锁住」。 */
		pokePeerMode(link, GBoyFrames::LINK_MODE_INVALID);
	} else if (!peerRegisterWire.isEmpty()) {
		/* CloudLink.cpp 的 case TYPE_REGISTER 就是这两步，来源串也一样。 */
		link.notePeerLinkMode(GBoyFrames::linkModeOf(peerRegisterWire.mid(4)),
		                      QStringLiteral("type-1 注册帧"));
	}

	QElapsedTimer timer;
	timer.start();
	result.accepted = link.negotiateLinkMode(&room, QStringLiteral("gatetest"));
	result.elapsedMs = timer.elapsed();

	result.officialMode = link.m_officialMode;
	result.linkMode = link.m_linkMode.load(std::memory_order_relaxed);
	result.peerMode = link.m_peerLinkMode.load(std::memory_order_relaxed);
	result.closed = link.m_closed.load(std::memory_order_relaxed);
	result.rejected = link.m_modeRejected.load(std::memory_order_relaxed);
	/* 何时再调一次：
	 *  - 第一次**拒绝了**（任何原因）→ 再调，验证 m_modeRejected 短路；
	 *  - 第一次**很快接受**了（< 500ms，说明对端能力位已知、没走有界等待）→ 再调，
	 *    验证幂等接受（不重等、不重复报错）。
	 *  - 第一次**等满窗口才接受**（allowLegacy 回落，用例 3/5b）→ **不调**：那会再等
	 *    2s、并再 emit 一次「警告…回落」，那是生产只调一次时不可达的行为，不该被
	 *    冻成契约。这类用例显式断言 secondCallDone == false，把「故意不覆盖」写出来。
	 */
	if (!result.accepted || result.elapsedMs < 500) {
		/* 第二次调用：畸形 / 冲突 / 未声明拒绝之后，协商门必须靠
		 * `if (m_modeRejected) return false;` 立刻短路 —— 不重新等 2s、不重复
		 * emit 失败文案。这才是失败类用例**真正的安全层**；
		 * `peer == INVALID` 那条分支是第二道锁（INVALID 送到
		 * notePeerLinkMode() 时 rejected 已被置位，走不到那里）。 */
		const int before = result.statuses.size();
		const int beforeFails = result.failCount();
		QElapsedTimer second;
		second.start();
		result.secondAccepted = link.negotiateLinkMode(&room, QStringLiteral("gatetest(2)"));
		result.secondElapsedMs = second.elapsed();
		result.secondStatusCount = result.statuses.size() - before;
		result.secondFailCount = result.failCount() - beforeFails;
		result.secondCallDone = true;
	}
	return result;
}

/**
 * 协商门端到端断言（`test-gboylink --gatetest`）。
 *
 * 覆盖的五类结果与 Android `GBoyCloudLink.decideLinkMode()` 的返回码一一对应：
 *   0 一致接受        → 用例 1 / 6
 *   1 未声明+回落 B    → 用例 3
 *   2 未声明拒绝      → 用例 5（F12 回归：单人房不得被当成畸形）
 *   3 冲突拒绝        → 用例 2
 *   4 畸形拒绝        → 用例 4 / 7（**这两条走的是早退**：INVALID 送到
 *                        notePeerLinkMode() 时已 fail() 并置 m_modeRejected，
 *                        negotiateLinkMode() 顶部短路直接返回。它们证明的是
 *                        「早退在，所以轮不到判定」，**不是**「4 号码不放行」。）
 *                      → 用例 11（**强制**把 rejected 清成 false、peer 设成 INVALID，
 *                        让 negotiateLinkMode() 自己的 `peer == INVALID` 分支真的
 *                        执行一次：返回 false / m_closed / 文案含「能力位畸形」且
 *                        **不含「来源」**（区分它不来自 notePeerLinkMode）/ 只报一次）
 *
 * 失败类用例（2/4/5/7/8/10）还会把协商门**再调一次**，断言它被
 * `if (m_modeRejected) return false;` 立刻短路：不重新等 2s、不重复 emit 失败文案。
 * 这条短路才是失败路径真正的安全层，单看「第一次返回 false」证明不了它。
 *
 * 用例 8/9/10 补的是**时序**（B1 与 F7 只在这条分支上成立）：通过注入
 * `m_gatePump` 复刻「信令可用但 drainSignaling() 提前返回」的语义 ——
 *   8 泵立即返回且永不设对端 → 等待必须仍是 ≈2s（旧代码这里是 20×60ms≈1.2s）
 *   9 第 3 轮对端能力位到达   → 必须等到它并接受，而不是等满窗口才判未声明
 *  10 第 2 轮 close          → 必须立刻退出，不硬等
 * 外加一条不变量：任何用例的等待总时长都不得 > 2400ms（有界性的上界证明）。
 *
 * **PC / Android 判定顺序差异（已核对等价，不要"修"回去）**：
 * Android `decideLinkMode()` 是「peer==local → INVALID → UNKNOWN」，
 * PC `negotiateLinkMode()` 是「INVALID → peer==local → UNKNOWN」。
 * 因为本端（local）只可能是 A(0) / B(1)，当 peer == INVALID(-2) 时
 * `peer == local` 恒假，所以两条顺序对全部五类输入的结果集合完全相同。
 * 用例 4 / 7 就是这条等价的实测证据（畸形在两种顺序下都必须被拒绝）。
 */
static int gateTest() {
	int checks = 0;
	int failed = 0;
	auto expect = [&checks, &failed](bool cond, const char* what) {
		++checks;
		if (cond) {
			printf("ok gatetest: %s\n", what);
		} else {
			++failed;
			printf("FAIL gatetest: %s\n", what);
		}
		fflush(stdout);
	};
	/* 有界等待的实测上界：2000ms 目标 + 单轮 100ms 粒度 + 事件循环抖动。 */
	const qint64 kWaitFloorMs = 1800;
	const qint64 kWaitCeilMs = 2400;
	/* 每例的真实耗时都收进来，末尾用来证明「任何用例都没突破上界」。 */
	std::vector<qint64> elapsedAll;
	/* 把每例的真实耗时打出来：这是 F7「有界等待」唯一能落地成数字的证据。 */
	auto note = [&elapsedAll](const char* what, const CloudLinkGateProbe::Result& r) {
		printf("     gatetest timing: %s = %lld ms\n", what, static_cast<long long>(r.elapsedMs));
		fflush(stdout);
		elapsedAll.push_back(r.elapsedMs);
	};

	/* 第二次调用的断言助手（**(b) 参数化 + 非空转**）：
	 *  - expectShortCircuit=true ：第一次拒绝后再调，必须立刻短路（不重等、不重复报错）；
	 *  - expectShortCircuit=false：第一次快速接受后再调，必须**幂等接受**（同样不重等、
	 *    不重复报错）。
	 * 两种情况都要求 `r.secondCallDone`：探针若没真的调过，一律算失败。
	 * 旧版是「无条件断言 !secondAccepted && <50ms && count==0」——在 accepted 场景下
	 * 这三个字段还是默认值（false/0/0），于是必然绿，属于**假阴性断言**
	 * （删除顶部短路时它也不会红）。参数化后两类场景都有效力。 */
	auto expectSecondCall = [&expect](const char* what, const CloudLinkGateProbe::Result& r,
	                                bool expectShortCircuit) {
		/* 两种场景都必须：真调过（secondCallDone）、不重新等（<50ms）、不重复报**失败**。
		 * 差别在结果与「新增文案」的判据：
		 *  - 短路场景：必须仍拒绝，且**一条新文案都不许有**（连成功文案也不该出现在拒绝路径）；
		 *  - 幂等接受场景：必须仍接受，允许重发一次「协商通过」状态（那是状态不是错误），
		 *    但 secondFailCount 必须为 0。 */
		const bool base = r.secondCallDone && r.secondElapsedMs < 50 && r.secondFailCount == 0;
		if (expectShortCircuit) {
			expect(base && !r.secondAccepted && r.secondStatusCount == 0, what);
		} else {
			expect(base && r.secondAccepted, what);
		}
	};

	/* 对端注册帧：完整线上帧（16 字节，含长度头）。 */
	auto peerWire = [](int players, int capacity) {
		QByteArray wire = GBoyFrames::registerFrame(players, 0,
		                                           players == 1 ? GBoyFrames::LINK_MODE_UNKNOWN : capacity);
		return wire;
	};

	{	/* 用例 1：两端都是 A → 通过，且不得切到 path B。 */
		const CloudLinkGateProbe::Result r =
			CloudLinkGateProbe::run(2, GBoyFrames::LINK_MODE_A,
			                        peerWire(2, GBoyFrames::LINK_MODE_A), false);
		expect(r.accepted, "1) A vs A: negotiateLinkMode() accepts");
		expect(r.officialMode == false, "1) A vs A: officialMode stays false (path A)");
		expect(r.linkMode == GBoyFrames::LINK_MODE_A, "1) A vs A: local mode bound to A");
		expect(r.peerMode == GBoyFrames::LINK_MODE_A, "1) A vs A: peer mode recorded as A");
		expect(!r.closed && !r.rejected, "1) A vs A: nothing was failed or rejected");
		expect(r.said("联机模式协商通过"), "1) A vs A: status says 联机模式协商通过");
		/* 对端能力位已就位时不该走有界等待。 */
		expect(r.elapsedMs < 500, "1) A vs A: no bounded wait when the peer bit is already known");
		/* 接受之后**再调一次**必须幂等接受：不重等、不重复报错。这里是参数化助手在「接受」场景的效力（旧版在此场景是空转绿）。 */
		expectSecondCall("1) A vs A: second call is idempotent (accepts again, no extra wait/text)", r, false);
		note("1) A vs A", r);
	}

	{	/* 用例 2：一端 A 一端 B → 拒绝，文案必须含本机/对端/改法。 */
		const CloudLinkGateProbe::Result r =
			CloudLinkGateProbe::run(2, GBoyFrames::LINK_MODE_A,
			                        peerWire(2, GBoyFrames::LINK_MODE_B), false);
		expect(!r.accepted, "2) A vs B: negotiateLinkMode() refuses");
		expect(r.closed, "2) A vs B: fail() closed the link (m_closed)");
		expect(r.rejected, "2) A vs B: m_modeRejected set, no later re-entry");
		expect(r.peerMode == GBoyFrames::LINK_MODE_B, "2) A vs B: peer mode recorded as B");
		expect(r.said("本机="), "2) A vs B: message names the local mode (本机=)");
		expect(r.said("对端="), "2) A vs B: message names the peer mode (对端=)");
		expect(r.said("MGBAX_LINK_MODE=A|B"), "2) A vs B: message tells how to fix it");
		note("2) A vs B", r);
		expectSecondCall("2) A vs B: second call short-circuits on m_modeRejected (no re-wait, no duplicate fail)", r, true);
	}

	{	/* 用例 3：对端发 2 参数官方帧（无能力位）+ allow_legacy → 回落 B。 */
		const CloudLinkGateProbe::Result r =
			CloudLinkGateProbe::run(2, GBoyFrames::LINK_MODE_A,
			                        GBoyFrames::registerFrame(2, 0), true);
		expect(r.accepted, "3) undeclared + allow_legacy: fallback accepted");
		expect(r.officialMode == true, "3) undeclared + allow_legacy: officialMode = true (path B)");
		expect(r.linkMode == GBoyFrames::LINK_MODE_B, "3) undeclared + allow_legacy: mode rebound to B");
		expect(r.peerMode == GBoyFrames::LINK_MODE_UNKNOWN, "3) undeclared: peer mode stays UNKNOWN");
		expect(r.said("警告") && r.said("回落"), "3) undeclared + allow_legacy: warning says 回落");
		expect(!r.said("畸形"), "3) undeclared: never reported as 畸形");
		/* F7 的实测证据：这条分支（m_session == nullptr）真的等满有界窗口。 */
		expect(r.elapsedMs >= kWaitFloorMs, "3) undeclared: bounded wait actually ran (>= 1800ms)");
		expect(r.elapsedMs <= kWaitCeilMs, "3) undeclared: bounded wait stays bounded (<= 2400ms)");
		/* 回落路径下**不**再调一次：会重新等一轮 2s 并再 emit 一次「警告…回落」，而生产里每个房间只协商一次，那种行为不该被冻成契约。这条断言把「故意不覆盖」写出来，避免以后有人误以为这里已验证幂等。 */
		expect(!r.secondCallDone, "3) undeclared + allow_legacy: second call intentionally NOT exercised (fallback would re-wait)");
		note("3) undeclared + allow_legacy", r);
	}

	{	/* 用例 4：对端能力位 0x42（magic 不匹配）→ 畸形拒绝。 */
		QByteArray bad = peerWire(2, GBoyFrames::LINK_MODE_A);
		bad[15] = char(0x42);
		const CloudLinkGateProbe::Result r =
			CloudLinkGateProbe::run(2, GBoyFrames::LINK_MODE_A, bad, false);
		expect(!r.accepted, "4) cap 0x42: negotiateLinkMode() refuses");
		expect(r.closed, "4) cap 0x42: link closed");
		expect(r.said("畸形"), "4) cap 0x42: message says 畸形");
		expect(r.said("本机="), "4) cap 0x42: message names the local mode (F9)");
		/* F8：畸形值必须回写 m_peerLinkMode，重读不能还是 UNKNOWN。 */
		expect(r.peerMode == GBoyFrames::LINK_MODE_INVALID,
		       "4) cap 0x42: INVALID is written back to m_peerLinkMode (F8)");
		note("4) cap 0x42", r);		/* 注意本用例验证的是什么（别读成「4 号码被覆盖」）：INVALID 送到
		 * notePeerLinkMode() 时就已被 fail() 置位 m_modeRejected，所以这里是
		 * **早退路径**在拒绝；4 号码由用例 11 强制覆盖。 */
		expect(r.rejected, "4) cap 0x42: m_modeRejected set by the early exit (case 11 covers the 4th branch)");
		expect(r.failCount() == 1, "4) cap 0x42: exactly one failure message (no double report)");
		expectSecondCall("4) cap 0x42: second call short-circuits on m_modeRejected", r, true);
	}

	{	/* 用例 5：1 人房 + baseStateCount=1（F12 回归）→ UNKNOWN 未声明，不得误判畸形。 */
		const CloudLinkGateProbe::Result r =
			CloudLinkGateProbe::run(1, GBoyFrames::LINK_MODE_A,
			                        GBoyFrames::registerFrame(1, 1), false);
		expect(!r.accepted, "5) 1-player frame: refused as undeclared (default policy)");
		expect(!r.said("畸形"), "5) 1-player frame (body[11]==0x01): NOT reported as 畸形 (F12)");
		expect(r.said("未声明"), "5) 1-player frame: reported as 未声明 instead");
		expect(r.peerMode == GBoyFrames::LINK_MODE_UNKNOWN, "5) 1-player frame: peer mode stays UNKNOWN");
		expect(r.elapsedMs >= kWaitFloorMs, "5) 1-player frame: bounded wait ran (>= 1800ms)");
		note("5) 1-player frame (baseStateCount=1)", r);
		expectSecondCall("5) 1-player frame: second call short-circuits on m_modeRejected", r, true);
	}

	{	/* 用例 5b：同上但 allow_legacy → 应回落 B（证明吃到的是 UNKNOWN 分支）。 */
		const CloudLinkGateProbe::Result r =
			CloudLinkGateProbe::run(1, GBoyFrames::LINK_MODE_A,
			                        GBoyFrames::registerFrame(1, 1), true);
		expect(r.accepted && r.officialMode && r.linkMode == GBoyFrames::LINK_MODE_B,
		       "5b) 1-player frame + allow_legacy: falls back to B (UNKNOWN branch, not 畸形)");
		expect(!r.secondCallDone, "5b) 1-player frame + allow_legacy: second call intentionally NOT exercised");
		note("5b) 1-player frame + allow_legacy", r);
	}

	{	/* 用例 6：3 人房 + AUTO → 本端解析为 B，对端也是 B → 通过。 */
		const CloudLinkGateProbe::Result r =
			CloudLinkGateProbe::run(3, GBoyFrames::LINK_MODE_UNKNOWN,
			                        peerWire(3, GBoyFrames::LINK_MODE_B), false);
		expect(r.accepted, "6) 3P AUTO vs B: accepts");
		expect(r.linkMode == GBoyFrames::LINK_MODE_B, "6) 3P AUTO resolves to B inside the gate");
		expect(r.officialMode == true, "6) 3P AUTO: officialMode = true");
		expectSecondCall("6) 3P AUTO vs B: second call is idempotent (accepts again)", r, false);
		note("6) 3P AUTO vs B", r);
	}

	{	/* 用例 7：畸形 + allow_legacy=true —— 畸形绝不能被 allow_legacy 放行。
		 * 这一条正是 F8 的价值：不回写 INVALID 时，peer 仍是 UNKNOWN，
		 * 会走进「显式许可回落 B」并 return true，把畸形能力位放行成能跑的路。 */
		QByteArray bad = peerWire(2, GBoyFrames::LINK_MODE_A);
		bad[15] = char(0xFF);
		const CloudLinkGateProbe::Result r =
			CloudLinkGateProbe::run(2, GBoyFrames::LINK_MODE_A, bad, true);
		expect(!r.accepted, "7) cap 0xFF + allow_legacy: still refused (allow_legacy cannot rescue 畸形)");
		expect(r.closed, "7) cap 0xFF + allow_legacy: link closed");
		expect(r.said("畸形"), "7) cap 0xFF + allow_legacy: message says 畸形");
		expect(!r.said("回落"), "7) cap 0xFF + allow_legacy: no 回落 wording");
		note("7) cap 0xFF + allow_legacy", r);		expect(r.rejected, "7) cap 0xFF: m_modeRejected set by the early exit");
		expect(r.failCount() == 1, "7) cap 0xFF: exactly one failure message");
		/* 用例 7 的真正机制（2026-11 修正，原注释归因错了）：畸形没有被 allow_legacy
		 * 救回，靠的是 notePeerLinkMode() 里 exchange(true) 置 m_modeRejected →
		 * negotiateLinkMode() 顶部短路，而**不是** F8 的回写、也不是
		 * peer == INVALID 那条分支（后者走不到：INVALID 到达时 rejected 已置位）。
		 * 变异证据：去掉 F8 的 store 后重跑，本用例三条仍然全绿，只有用例 4 的
		 * 「INVALID is written back」变红。 */
		expect(r.secondCallDone && !r.secondAccepted, "7) cap 0xFF: second call still refused");
		expect(r.secondCallDone && r.secondElapsedMs < 50, "7) cap 0xFF: second call short-circuits, no second 2s window");
		expect(r.secondCallDone && r.secondFailCount == 0 && r.secondStatusCount == 0, "7) cap 0xFF: second call emits no duplicate fail text");
	}

	/* ---- 用例 8/9/10：注入 m_gatePump，覆盖「信令可用 → drainSignaling()
	 * 提前返回」那条分支的**时序**。这条分支是真机主路径，也是 B1 与 F7 唯一
	 * 成立的地方：不注入就只能靠活的 WSS 会话，无法在 CI 里断言。
	 * 注入的泵就是「排空」语义本身 —— 它想返回多快就返回多快，跟旧
	 * drainSignaling() 打到一个空队列时的行为一样。 ---- */

	{	/* 用例 8：泵立即返回 0ms、永不设对端能力位。
		 * 旧代码在这里只会等 20 × 60ms ≈ 1.2s（F7 的根因）；现在必须仍是 ≈2s。
		 * 这一条**直接钉死 F7**：泵提前返回不再把 2s 缩水。 */
		int pumpRounds = 0;
		const CloudLinkGateProbe::Result r = CloudLinkGateProbe::run(
			2, GBoyFrames::LINK_MODE_A, QByteArray(), false,
			[&pumpRounds](QGBA::CloudLink&) {
				return std::function<int(int)>([&pumpRounds](int) {
					++pumpRounds;
					return 0;   // 排空立刻就「没数据」，一毫秒也不花
				});
			});
		expect(r.elapsedMs >= 1900, "8) instant pump: bounded wait still ~2s (F7, >= 1900ms)");
		expect(r.elapsedMs <= 2400, "8) instant pump: bounded wait stays bounded (<= 2400ms)");
		expect(pumpRounds >= 15, "8) instant pump: re-entered every slice (no early exit)");
		expect(!r.accepted, "8) instant pump: undeclared peer is refused");
		expect(r.said("未声明"), "8) instant pump: refused as 未声明");
		expect(!r.said("畸形"), "8) instant pump: never 畸形");
		note("8) instant pump, peer stays UNKNOWN", r);
		expectSecondCall("8) instant pump: second call short-circuits (no second 2s window)", r, true);
	}

	{	/* 用例 9：第 3 轮才把对端能力位设成 A —— 复刻 B1「对端 hello 稍后到」。
		 * 必须**等到它**并且接受，而不是等到窗口结束才判未声明。 */
		int pumpRounds = 0;
		const CloudLinkGateProbe::Result r = CloudLinkGateProbe::run(
			2, GBoyFrames::LINK_MODE_A, QByteArray(), false,
			[&pumpRounds](QGBA::CloudLink& link) {
				return std::function<int(int)>([&pumpRounds, &link](int) {
					++pumpRounds;
					if (pumpRounds == 3) {
						CloudLinkGateProbe::pokePeerMode(link, GBoyFrames::LINK_MODE_A);
					}
					return 0;
				});
			});
		expect(r.accepted, "9) late peer bit: negotiation accepts (B1)");
		expect(r.peerMode == GBoyFrames::LINK_MODE_A, "9) late peer bit: peer mode recorded as A");
		expect(r.linkMode == GBoyFrames::LINK_MODE_A, "9) late peer bit: local mode is A");
		expect(!r.closed, "9) late peer bit: link not failed");
		expect(r.elapsedMs < 800, "9) late peer bit: exits early, no full-window wait (B1)");
		expect(pumpRounds == 3, "9) late peer bit: loop stopped on the round it arrived");
		note("9) peer bit arrives on round 3", r);
	}

	{	/* 用例 10：第 2 轮 close —— 必须立刻退出，不硬等满 2s。 */
		int pumpRounds = 0;
		const CloudLinkGateProbe::Result r = CloudLinkGateProbe::run(
			2, GBoyFrames::LINK_MODE_A, QByteArray(), false,
			[&pumpRounds](QGBA::CloudLink& link) {
				return std::function<int(int)>([&pumpRounds, &link](int) {
					++pumpRounds;
					if (pumpRounds == 2) {
						CloudLinkGateProbe::pokeClosed(link);
					}
					return 0;
				});
			});
		expect(!r.accepted, "10) closed mid-wait: negotiateLinkMode() returns false");
		expect(r.elapsedMs < 500, "10) closed mid-wait: exits immediately, no 2s stall");
		expect(r.closed, "10) closed mid-wait: m_closed stays set");
		note("10) link closed on round 2", r);
		expectSecondCall("10) closed mid-wait: second call short-circuits", r, true);
	}

	{	/* 用例 11：**强制**走到 negotiateLinkMode() 自己的 `peer == INVALID` 分支。
		 *
		 * 为什么必须单独做：生产里 INVALID 只能经 notePeerLinkMode() 进来，而那里
		 * 已经把 m_modeRejected 置位，所以 negotiateLinkMode() 顶部的
		 * `if (m_modeRejected) return false;` 会先短路 —— 用例 4/7 因此走的是早退，
		 * 这条分支在生产路径上**永远不会执行**。它的定位是「短路被误删时的第二道锁」，
		 * 所以必须有一条断言证明它真的锁得住，而且只报一次错。
		 *
		 * 区分文案来源的唯一可靠特征：notePeerLinkMode() 那条带「来源 <source>」，
		 * negotiateLinkMode() 这条不带来源串。所以断言「含能力位畸形」且「不含 来源」。 */
		const CloudLinkGateProbe::Result r = CloudLinkGateProbe::run(
			2, GBoyFrames::LINK_MODE_A, QByteArray(), false,
			CloudLinkGateProbe::PumpFactory(), true);
		expect(!r.accepted, "11) forced INVALID: negotiateLinkMode() refuses (4th branch really ran)");
		expect(r.closed, "11) forced INVALID: fail() closed the link");
		expect(r.rejected, "11) forced INVALID: m_modeRejected set by the branch itself");
		expect(r.said("能力位畸形"), "11) forced INVALID: message says 能力位畸形");
		expect(!r.said("来源"), "11) forced INVALID: message has no 来源 (came from negotiateLinkMode, not notePeerLinkMode)");
		expect(r.failCount() == 1, "11) forced INVALID: exactly one failure message");
		expect(r.peerMode == GBoyFrames::LINK_MODE_INVALID, "11) forced INVALID: peer value stays INVALID");
		expectSecondCall("11) forced INVALID: second call short-circuits, no duplicate text", r, true);
		note("11) forced INVALID branch", r);
	}

	{	/* 用例 12（与 Android C0GateTest 的「顺序断言 a」对称）：**顶部短路先于重新绑定本端模式**。
		 *
		 * 构造：本端 AUTO（2 人房本来是 A），但先用探针把已绑定模式手工置成 **B**
		 * （模拟「上一次协商已把本端定成 B」）；然后喂一个畸形能力位 —— notePeerLinkMode()
		 * 会 fail 并置 m_modeRejected；再调协商门。
		 * 断言：门必须**原样保留** B，不能被重新解析成 A。
		 *
		 * 钉的是什么：如果有人把 `if (m_modeRejected) return false;` 挪到
		 * `m_linkMode.store(resolveLinkMode(...))` **之后**，本端模式就会被静默改写
		 * （B→A）——两端从此跑在不同架构上，而其它用例全都还是绿的。
		 * 变异验证：把绑定代码挪到短路之前，只有本用例变红。 */
		QByteArray bad = peerWire(2, GBoyFrames::LINK_MODE_A);
		bad[15] = char(0x42);
		const CloudLinkGateProbe::Result r = CloudLinkGateProbe::run(
			2, GBoyFrames::LINK_MODE_UNKNOWN, bad, false,
			CloudLinkGateProbe::PumpFactory(), false, GBoyFrames::LINK_MODE_B);
		expect(!r.accepted, "12) early exit before rebinding: negotiateLinkMode() refuses");
		expect(r.rejected, "12) early exit before rebinding: m_modeRejected was already set");
		expect(r.linkMode == GBoyFrames::LINK_MODE_B,
		       "12) early exit before rebinding: local mode stays B (not silently re-resolved to A)");
		expect(r.failCount() == 1, "12) early exit before rebinding: no extra failure text from the gate");
		/* PC 与 Android 的**有意差异**：PC 在 notePeerLinkMode() 里会回写 INVALID（F8），
		 * Android 不回写。两者最终都拒绝，只是 PC 多留一份可观测状态。 */
		expect(r.peerMode == GBoyFrames::LINK_MODE_INVALID,
		       "12) early exit before rebinding: peer value is INVALID on PC (F8 write-back; Android differs)");
		note("12) early exit before rebinding", r);
	}

	{	/* 不变量：**任何**用例的等待总时长都不得突破 2400ms。
		 * 这是「有界」这二字的证明 —— 单看某一例通过，证明不了没有别的路径会超时。 */
		qint64 worst = 0;
		for (size_t i = 0; i < elapsedAll.size(); ++i) {
			worst = qMax(worst, elapsedAll[i]);
		}
		printf("     gatetest timing: worst-case bounded wait over %d cases = %lld ms\n",
		       int(elapsedAll.size()), static_cast<long long>(worst));
		fflush(stdout);
		expect(!elapsedAll.empty() && worst <= 2400,
		       "invariant: no case ever exceeded the 2400ms bound");
	}

	if (failed == 0) {
		printf("gatetest passed (%d ok / 0 FAIL)\n", checks);
		return 0;
	}
	printf("gatetest failed (%d ok / %d FAIL)\n", checks - failed, failed);
	return 1;
}
#endif  // BUILD_QT_CLOUD

/**
 * KcpChannel 的 TCP 传输有自己一套帧循环（streamLoop），和 GBoyFrames 是两处
 * 独立实现、曾经是同一个 65535 上限。这里用本机 TCP 环回实测：一个 256 KiB
 * 的载荷必须完整到达，紧随其后的小载荷也必须能收到（验证流没有错位）。
 */
static int kcpFrameTest() {
	int failures = 0;
	QTcpServer server;
	if (!server.listen(QHostAddress::LocalHost, 0)) {
		qInfo() << "KCP FRAME TEST: FAIL (cannot listen)";
		return 1;
	}
	const quint16 port = server.serverPort();
	QString error;
	KcpChannel* channel = KcpChannel::openTcp(QStringLiteral("127.0.0.1"), port, &error);
	if (!channel) {
		qInfo().noquote() << QString("KCP FRAME TEST: FAIL (openTcp: %1)").arg(error);
		return 1;
	}
	if (!server.waitForNewConnection(5000)) {
		qInfo() << "KCP FRAME TEST: FAIL (no inbound connection)";
		channel->close();
		delete channel;
		return 1;
	}
	QTcpSocket* peer = server.nextPendingConnection();
	if (!peer) {
		qInfo() << "KCP FRAME TEST: FAIL (no peer socket)";
		channel->close();
		delete channel;
		return 1;
	}

	auto sendPayload = [peer](const QByteArray& payload) {
		QByteArray head;
		head.resize(4);
		GBoyFrames::putInt(&head, 0, quint32(payload.size()));
		peer->write(head);
		peer->write(payload);
		peer->flush();
		peer->waitForBytesWritten(5000);
	};

	const int blobSize = 256 * 1024;
	QByteArray blob(blobSize, '\0');
	for (int i = 0; i < blobSize; ++i) {
		blob[i] = char((i * 7 + (i >> 9)) & 0xFF);
	}
	sendPayload(blob);
	QByteArray got;
	if (!channel->recv(&got, 8000)) {
		qInfo() << "KCP FRAME TEST: FAIL (large payload never arrived)";
		++failures;
	} else if (got.size() != blobSize) {
		qInfo().noquote() << QString("KCP FRAME TEST: FAIL (got %1 bytes, want %2)")
		                         .arg(got.size()).arg(blobSize);
		++failures;
	} else if (got != blob) {
		qInfo() << "KCP FRAME TEST: FAIL (payload bytes differ)";
		++failures;
	}

	QByteArray small("after-big", 9);
	sendPayload(small);
	QByteArray got2;
	if (!channel->recv(&got2, 8000)) {
		qInfo() << "KCP FRAME TEST: FAIL (small payload after the large one was lost)";
		++failures;
	} else if (got2 != small) {
		qInfo().noquote() << QString("KCP FRAME TEST: FAIL (framing broke: got '%1')")
		                         .arg(QString::fromLatin1(got2));
		++failures;
	}

	peer->disconnectFromHost();
	peer->deleteLater();
	channel->close();
	delete channel;
	if (failures == 0) {
		qInfo().noquote() << "KCP FRAME TEST: PASS (256 KiB payload over TCP, stream stays aligned)";
	}
	return failures;
}

/**
 * 官方断线重连握手包（KpHwm4.AmA8tU.java:263-272）：
 * {@code int32 6 + int16 100 + int32 rtt}，10 字节；它同时是一条合法线帧
 * （长度 6 = 2 字节类型 + 4 字节 RTT），接收侧必须按握手处理。
 */
static int reconnectFrameTest() {
	int failures = 0;
	auto check = [&](bool ok, const char* what) {
		if (!ok) {
			fprintf(stderr, "RECONNECT TEST: FAIL %s\n", what);
			++failures;
		}
	};
	QByteArray wire = GBoyFrames::reconnectFrame(37);
	check(wire.size() == 10, "reconnect handshake is a bare 10 byte frame");
	check(GBoyFrames::getInt(wire, 0) == 6, "length field is 6 (type 2 + rtt 4)");
	check((int) GBoyFrames::getShort(wire, 4) == GBoyFrames::TYPE_RECONNECT,
	      "type is 100");
	check((int) GBoyFrames::getInt(wire, 6) == 37, "payload carries the last RTT");

	GBoyFrames::Reader reader;
	reader.append(wire.constData(), wire.size());
	QByteArray body = reader.next();
	check(!body.isNull(), "the reader still frames it instead of desyncing");
	check(GBoyFrames::typeOf(body) == GBoyFrames::TYPE_RECONNECT,
	      "reader reports type 100");

	// 接收侧语义：收到就当对端已经重连完成（ready + RTT），不能落进 unknown。
	bool ready = false;
	int unknown = 0;
	GBoyLinkSession::Events events;
	events.onReady = [&ready]() { ready = true; };
	events.onStatus = [&unknown](const QString& text) {
		if (text.contains(QStringLiteral("unknown"))) {
			++unknown;
		}
	};
	GBoyLinkSession session([](const QByteArray&) {}, events, 1, 4);
	check(!session.isReady(), "session starts not ready");
	session.onWireFrame(wire);
	check(session.isReady(), "a reconnect frame marks the peer ready");
	check(session.remoteRtt() == 37, "the reconnect RTT is recorded");
	check(ready, "onReady fires on the reconnect handshake");
	check(unknown == 0, "a reconnect frame is not reported as an unknown type");

	if (failures == 0) {
		fprintf(stderr, "RECONNECT TEST: PASS (10 byte handshake recognised as a handshake)\n");
	}
	return failures;
}

/**
 * TcpDirectLink：官方 WiFi 直连的 TCP 版。本机环回实测
 *   1) 帧按「4B 大端长度 + 类型 + 载荷」双向完整到达（含 800 KiB 存档帧）；
 *   2) 对端掉线后客户端自己重连，并先补 10 字节重连握手包。
 */
static int tcpDirectLinkTest() {
	int failures = 0;
	auto check = [&](bool ok, const char* what) {
		if (!ok) {
			fprintf(stderr, "TCPDIRECT TEST: FAIL %s\n", what);
			++failures;
		}
	};
	// 借 QTcpServer 拿一个空闲端口，再交给 TcpDirectLink 自己 listen。
	quint16 port = 0;
	{
		QTcpServer probe;
		if (probe.listen(QHostAddress::LocalHost, 0)) {
			port = probe.serverPort();
			probe.close();
		}
	}
	if (!port) {
		qInfo() << "TCPDIRECT TEST: FAIL (no free port)";
		return 1;
	}

	TcpDirectLink host;
	QString hostError;
	std::atomic<bool> hostUp{false};
	std::thread hostThread([&]() { hostUp = host.listenAndAccept(port, 5000, &hostError); });

	TcpDirectLink client;
	QString clientError;
	bool connected = false;
	for (int i = 0; i < 50 && !connected; ++i) {
		connected = client.connectTo(QStringLiteral("127.0.0.1"), port, 1000, &clientError);
		if (!connected) {
			QThread::msleep(100);
		}
	}
	if (hostThread.joinable()) {
		hostThread.join();
	}
	if (!connected || !hostUp) {
		qInfo().noquote() << QString("TCPDIRECT TEST: FAIL (connect=%1 listen=%2 %3 %4)")
		                         .arg(connected).arg(hostUp.load()).arg(clientError, hostError);
		client.close();
		host.close();
		return 1;
	}

	// 1) 普通按键帧：双向完整。
	QByteArray keys = GBoyFrames::frame(GBoyFrames::TYPE_KEYS, 0x0A0B);
	client.send(keys);
	QByteArray got;
	check(host.recv(&got, 3000), "client frame reaches the host");
	check(got == keys, "the key frame survives byte for byte");

	// 2) 800 KiB 存档帧（官方 type 6 的真实尺寸）：分帧拼接、不截断。
	const int blobSize = 800 * 1024;
	QByteArray blob(blobSize, '\0');
	for (int i = 0; i < blobSize; ++i) {
		blob[i] = char((i * 31 + (i >> 7)) & 0xFF);
	}
	QByteArray state = GBoyFrames::stateFrame(blob);
	host.send(state);
	QByteArray stateGot;
	check(client.recv(&stateGot, 10000), "the 800 KiB state frame arrives");
	check(stateGot.size() == state.size(), "the state frame keeps its length");
	check(stateGot == state, "the state frame keeps its bytes");
	check(!GBoyFrames::stateOf(stateGot.mid(4)).isEmpty(), "the state blob is recoverable");

	// 3) 连续两帧：流不能错位。
	QByteArray one = GBoyFrames::frame(GBoyFrames::TYPE_COUNTER, 1);
	QByteArray two = GBoyFrames::frame(GBoyFrames::TYPE_EVENT, 2);
	client.send(one);
	client.send(two);
	QByteArray first;
	QByteArray second;
	check(host.recv(&first, 3000), "first of two back-to-back frames arrives");
	check(host.recv(&second, 3000), "second of two back-to-back frames arrives");
	check(first == one && second == two, "back-to-back frames stay aligned");

	// 4) 掉线重连：客户端应自己连回来，并先补一个重连握手包。
	const int connectsBefore = client.connectCount();
	host.close();
	TcpDirectLink host2;
	QString host2Error;
	std::atomic<bool> host2Up{false};
	std::thread host2Thread([&]() { host2Up = host2.listenAndAccept(port, 15000, &host2Error); });
	QByteArray reconnect;
	bool sawReconnect = host2.recv(&reconnect, 12000);
	if (host2Thread.joinable()) {
		host2Thread.join();
	}
	check(host2Up.load(), "the host listens again on the same port");
	check(sawReconnect, "the client reconnects on its own");
	check(reconnect.size() == 10, "the reconnect frame is 10 bytes");
	check(GBoyFrames::typeOf(reconnect.mid(4)) == GBoyFrames::TYPE_RECONNECT,
	      "the reconnect frame carries type 100");
	check(client.connectCount() == connectsBefore + 1, "the client counted one reconnect");

	client.close();
	host2.close();
	if (failures == 0) {
		fprintf(stderr, "TCPDIRECT TEST: PASS (framing, 800 KiB state, auto reconnect + 10 byte handshake)\n");
	}
	return failures;
}

static int lanSioLatTest(const QString& rom, int delayMs) {
	struct mCore* cores[2] = { nullptr, nullptr };
	struct SioLink* links[2] = { nullptr, nullptr };
	mColor video[2][240 * 160];
	int failures = 0;

	QString romAbs = QFileInfo(rom).absoluteFilePath();
	for (int i = 0; i < 2; i++) {
		QByteArray romUtf8 = romAbs.toUtf8();
		VFile* romVf = VFileOpen(romUtf8.constData(), O_RDONLY);
		if (!romVf) {
			romVf = VFileOpenFD(romUtf8.constData(), O_RDONLY);
		}
		if (!romVf) {
			qInfo().noquote() << "LAN SIO LAT TEST: FAIL (cannot open rom)";
			return 1;
		}
		cores[i] = mCoreFindVF(romVf);
		if (!cores[i]) {
			qInfo() << "LAN SIO LAT TEST: FAIL (cannot find core)";
			return 1;
		}
		cores[i]->init(cores[i]);
		mCoreConfigInit(&cores[i]->config, NULL);
		if (!cores[i]->loadROM(cores[i], romVf)) {
			qInfo() << "LAN SIO LAT TEST: FAIL (cannot load ROM)";
			return 1;
		}
		cores[i]->reset(cores[i]);
		cores[i]->setVideoBuffer(cores[i], video[i], 240);
		links[i] = sioLinkCreate();
	}

	// master link listens privately; the proxy fronts it on the joiner's port
	if (!sioLinkHost(links[0], 18767)) {
		qInfo() << "LAN SIO LAT TEST: FAIL (cannot listen)";
		return 1;
	}
	DelayPipe pipe(delayMs);
	if (!pipe.start(18766, "127.0.0.1", 18767)) {
		qInfo() << "LAN SIO LAT TEST: FAIL (proxy could not start)";
		return 1;
	}
	if (!sioLinkJoin(links[1], "127.0.0.1", 18766)) {
		qInfo() << "LAN SIO LAT TEST: FAIL (cannot connect)";
		return 1;
	}
	for (int i = 0; i < 200 && sioLinkState(links[0]) != 2; i++) {
		sioLinkPump(links[0], cores[0]);
		sioLinkPump(links[1], cores[1]);
		QThread::msleep(50);
	}
	if (sioLinkState(links[0]) != 2 || sioLinkState(links[1]) != 2) {
		qInfo() << "LAN SIO LAT TEST: FAIL (link never connected)";
		return 1;
	}
	sioLinkPump(links[0], cores[0]);
	sioLinkPump(links[1], cores[1]);
	struct GBA* gba0 = (struct GBA*) cores[0]->board;
	struct GBA* gba1 = (struct GBA*) cores[1]->board;
	if (!gba0->sio.driver || !gba1->sio.driver) {
		qInfo() << "LAN SIO LAT TEST: FAIL (SIO driver not attached)";
		return 1;
	}

	GBASIOWriteRCNT(&gba0->sio, 0);
	GBASIOWriteRCNT(&gba1->sio, 0);
	gba0->memory.io[GBA_REG(SIOMLT_SEND)] = 0x1234;
	gba1->memory.io[GBA_REG(SIOMLT_SEND)] = 0xBEEF;
	// Two cores on two threads, like two real devices: the master's blocking
	// peer wait must never starve the slave (single-threaded loops deadlock
	// exactly the way a tunnel RTT makes them). Time-bounded: each blocking
	// take freezes that core's thread for up to the adaptive window, so the
	// wall clock budget has to live on the main thread.
	std::atomic<bool> stop{false};
	auto worker = [&](int i) {
		struct GBA* gba = (struct GBA*) cores[i]->board;
		int f = 0;
		// No frame cap: the slave's clock races ahead while it spins waiting
		// for the master's next round (2048-cycle retries), so frame counts
		// are meaningless under latency - only `stop` ends this loop.
		while (!stop.load(std::memory_order_relaxed)) {
			qint64 frameStart = QDateTime::currentMSecsSinceEpoch();
			sioLinkPump(links[i], cores[i]);
			qint64 pumpMs = QDateTime::currentMSecsSinceEpoch() - frameStart;
			bool wrote = f % 25 == 5;
			if (wrote) {
				// the game starts a MULTI round periodically
				GBASIOWriteSIOCNT(&gba->sio, 0x600F);
			}
			qint64 writeMs = QDateTime::currentMSecsSinceEpoch() - frameStart - pumpMs;
			cores[i]->runFrame(cores[i]);
			qint64 frameMs = QDateTime::currentMSecsSinceEpoch() - frameStart;
			++f;
			if (frameMs > 400) {
				qInfo().noquote() << QString("worker%1 SLOW f=%2 pump=%3 write=%4 frame=%5ms mode=%6")
				                     .arg(i).arg(f).arg(pumpMs).arg(writeMs)
				                     .arg(frameMs - pumpMs - writeMs).arg((int) gba->sio.mode);
			}
		}
		qInfo().noquote() << QString("worker%1 EXIT f=%2").arg(i).arg(f);
	};
	std::thread ta(worker, 0);
	std::thread tb(worker, 1);
	bool ok = false;
	for (int s = 0; s < 300; s++) {
		QThread::msleep(100);
		uint16_t a = gba0->memory.io[GBA_REG(SIOMULTI1)];
		uint16_t b = gba1->memory.io[GBA_REG(SIOMULTI0)];
		if (a == 0xBEEF && b == 0x1234) {
			ok = true;
			break;
		}
	}
	stop.store(true, std::memory_order_relaxed);
	ta.join();
	tb.join();
	uint16_t m1 = gba0->memory.io[GBA_REG(SIOMULTI1)];
	uint16_t m0 = gba1->memory.io[GBA_REG(SIOMULTI0)];
	uint32_t stale0 = 0, drops0 = 0, stale1 = 0, drops1 = 0;
	sioLinkPeerStats(links[0], &stale0, &drops0);
	sioLinkPeerStats(links[1], &stale1, &drops1);
	qInfo().noquote() << QString("rtt master=%1us slave=%2us; stale m=%3 s=%4; drops m=%5 s=%6; pending m=%7 s=%8; link m=%9 s=%10")
	                     .arg(sioLinkRttUs(links[0])).arg(sioLinkRttUs(links[1]))
	                     .arg(stale0).arg(stale1).arg(drops0).arg(drops1)
	                     .arg(sioLinkPeerPending(links[0])).arg(sioLinkPeerPending(links[1]))
	                     .arg((quintptr) sioLinkHandle(links[0]), 0, 16)
	                     .arg((quintptr) sioLinkHandle(links[1]), 0, 16);
	qInfo().noquote() << QString("lat=%1ms master SIOMULTI1=%2 (want BEEF), slave SIOMULTI0=%3 (want 1234)")
	                     .arg(delayMs * 2).arg(m1, 4, 16, QChar('0')).arg(m0, 4, 16, QChar('0'));
	if (m1 != 0xBEEF) {
		++failures;
	}
	if (m0 != 0x1234) {
		++failures;
	}
	if (failures == 0) {
		qInfo() << "LAN SIO LAT TEST: PASS (MULTI transfer survived the delay)";
	} else {
		qInfo() << "LAN SIO LAT TEST: FAIL" << failures;
	}
	for (int i = 0; i < 2; i++) {
		sioLinkDestroy(links[i]);
		cores[i]->deinit(cores[i]);
	}
	QThread::msleep(100); // let the proxy's detached pumps see the closed sockets
	return failures;
}

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
			lastFeed = now;			for (size_t i = 0; i < produce; ++i) {
				int16_t v = (int16_t) (12000.0 * sin(phase));
				chunk[i * 2] = v;
				chunk[i * 2 + 1] = v;
				phase += 2.0 * 3.14159265358979323846 * 440.0 / rate;
			}
			mAudioBufferWrite(&source, chunk.data(), produce);
			fed += produce;

			struct mAudioBuffer* staged = audioStretchProcess(&stretch, &source, rate, true, speed, 1.0, want);
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

	/* Engine-only check of a 2x music rate (stretch 2x instead of 4x). NOTE:
	 * this deliberately stops BEFORE the resampler. In the real full pipeline
	 * the resampler's source rate is coreRate * musicRate, so the same 2x rate
	 * comes out an OCTAVE UP (880 Hz) - see audioFfTest CASE_4X_RATE2. That is
	 * why 2x must not be the default of a pitch-holding feature. What this case
	 * verifies: the WSOLA engine itself keeps the pitch and doubles its output
	 * rate without underruns. The main loop above hard-codes a 1.0 music rate
	 * and would never catch a regression on this path. */
	{
		const double musicRate = 2.0;
		const double stretchFactor = speed / musicRate; // 2x
		struct AudioStretch stretch;
		audioStretchInit(&stretch);
		audioStretchSetMode(&stretch, AUDIO_STRETCH_PITCH);
		struct mAudioBuffer source;
		mAudioBufferInit(&source, rate * 2, 2);
		std::vector<int16_t> chunk(size_t(speed * rate * 0.1) * 2);
		std::vector<int16_t> outBuf(rate * 2); // 1 s scratch
		double phase = 0.0;
		long long out = 0;
		long long crossings = 0;
		int16_t prev = 0;
		double lastFeed = 0.0;
		QElapsedTimer clock;
		clock.start();
		while (clock.elapsed() < runMs) {
			double now = clock.elapsed() / 1000.0;
			double dt = now - lastFeed;
			size_t produce = size_t(speed * rate * dt);
			size_t want = size_t(rate * musicRate * dt);
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
			struct mAudioBuffer* staged = audioStretchProcess(&stretch, &source, rate, true, stretchFactor, musicRate, want);
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
		qInfo().noquote() << QString("2x music rate (stretch %1): wall %2 s, out %3 s (expect ~%4 s), pitch ~%5 Hz, dropped %6")
		                     .arg(stretchFactor, 0, 'f', 1).arg(wall, 0, 'f', 2)
		                     .arg(seconds, 0, 'f', 2).arg(wall * musicRate, 0, 'f', 2)
		                     .arg(pitch, 0, 'f', 0).arg(audioStretchDropped(&stretch));
		if (seconds < wall * musicRate * 0.70 || seconds > wall * musicRate * 1.15) {
			qWarning() << "HOLD TEST: 2x music rate did not play at 2x";
			++failures;
		}
		if (pitch < 400 || pitch > 480) {
			qWarning() << "HOLD TEST: 2x music rate changed the pitch" << pitch;
			++failures;
		}
		if (audioStretchDropped(&stretch) > rate / 4) {
			qWarning() << "HOLD TEST: 2x music rate discarded too much";
			++failures;
		}
		mAudioBufferDeinit(&source);
		audioStretchDeinit(&stretch);
	}

	/* Spectral check for the "低沉 / muffled" complaint. A 440 Hz tone with
	 * 4 kHz and 8 kHz overtones is stretched by 4x (the shipped 4x fast-forward
	 * at music rate 1x) and by 2x. If the overlap-add phase reference is wrong,
	 * the high components cancel in the cross-fade and the 8k/440 ratio
	 * collapses - that is exactly what "dull" sounds like. The 2x case is an
	 * internal control: less stretching must not lose MORE highs. */
	{
		const double toneFs[] = { 440.0, 4000.0, 8000.0 };
		const double stretchFactors[] = { 4.0, 2.0 };
		for (double stretchFactor : stretchFactors) {
			struct AudioStretch stretch;
			audioStretchInit(&stretch);
			audioStretchSetMode(&stretch, AUDIO_STRETCH_PITCH);
			struct mAudioBuffer source;
			mAudioBufferInit(&source, rate * 2, 2);
			std::vector<int16_t> chunk(size_t(rate * 0.4) * 2);
			std::vector<int16_t> outBuf(rate * 2);
			std::vector<int16_t> captured;
			double phases[3] = { 0.0, 0.0, 0.0 };
			double lastFeed = 0.0;
			QElapsedTimer clock;
			clock.start();
			const int runSpectrumMs = 1600;
			while (clock.elapsed() < runSpectrumMs) {
				double now = clock.elapsed() / 1000.0;
				double dt = now - lastFeed;
				size_t produce = size_t(stretchFactor * rate * dt);
				if (!produce) {
					QThread::msleep(1);
					continue;
				}
				if (produce > chunk.size() / 2) {
					produce = chunk.size() / 2;
				}
				lastFeed = now;
				for (size_t i = 0; i < produce; ++i) {
					double v = 0.0;
					for (int t = 0; t < 3; ++t) {
						v += 3800.0 * sin(phases[t]);
						phases[t] += 2.0 * 3.14159265358979323846 * toneFs[t] / rate;
					}
					int16_t s = (int16_t) v;
					chunk[i * 2] = s;
					chunk[i * 2 + 1] = s;
				}
				mAudioBufferWrite(&source, chunk.data(), produce);
				struct mAudioBuffer* staged = audioStretchProcess(&stretch, &source, rate, true, stretchFactor, 1.0, 2048);
				size_t avail = mAudioBufferAvailable(staged);
				if (avail > outBuf.size() / 2) {
					avail = outBuf.size() / 2;
				}
				if (avail) {
					mAudioBufferRead(staged, outBuf.data(), avail);
					captured.insert(captured.end(), outBuf.data(), outBuf.data() + avail * 2);
				}
				QThread::msleep(2);
			}
			/* Short-window DFT, averaged over blocks. A single long Goertzel
			 * recurrence is numerically unstable here (its pole sits near 1 for
			 * low frequencies) and reported spurious 8x high/low ratios for an
			 * equal-amplitude input. Fixed 2048-frame blocks keep the reading
			 * sane; all tones get the same leakage, so the ratio comparison and
			 * the 4x-vs-2x comparison are both meaningful. */
			auto mag = [&](double f) {
				const size_t win = 2048;
				size_t n = captured.size() / 2;
				double sum = 0.0;
				size_t blocks = 0;
				for (size_t start = 0; start + win <= n; start += win) {
					double re = 0.0, im = 0.0;
					for (size_t k = 0; k < win; ++k) {
						double s = captured[(start + k) * 2] / 32768.0;
						double a = 2.0 * 3.14159265358979323846 * f * double(k) / rate;
						re += s * cos(a);
						im -= s * sin(a);
					}
					sum += sqrt(re * re + im * im) * 2.0 / double(win);
					++blocks;
				}
				return blocks ? sum / double(blocks) : 0.0;
			};
			double a440 = mag(toneFs[0]);
			double a4k = mag(toneFs[1]);
			double a8k = mag(toneFs[2]);
			qInfo().noquote() << QString("SPECTRUM stretch %1x: frames %2, 440=%3, 4k/440=%4, 8k/440=%5 (input ratios ~1.0)")
			                     .arg(stretchFactor, 0, 'f', 1).arg(captured.size() / 2)
			                     .arg(a440, 0, 'f', 1)
			                     .arg(a440 > 0 ? a4k / a440 : 0.0, 0, 'f', 3)
			                     .arg(a440 > 0 ? a8k / a440 : 0.0, 0, 'f', 3);
			if (captured.size() / 2 < size_t(rate / 2)) {
				qWarning() << "SPECTRUM: stretcher produced too little signal";
				++failures;
			}
			mAudioBufferDeinit(&source);
			audioStretchDeinit(&stretch);
		}
	}

	// Disengaging must hand the core's own buffer straight back.
	struct AudioStretch off;
	audioStretchInit(&off);
	struct mAudioBuffer src;
	mAudioBufferInit(&src, 4096, 2);
	if (audioStretchProcess(&off, &src, rate, false, 1.0, 1.0, 480) != &src) {
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

/*
 * Full-pipeline check for 倍速声音不变: a synthetic tone is pushed through
 * the exact chain the Qt frontend uses - the core's ring -> the fast-forward
 * stretcher -> the resampler -> the playback buffer - and the pitch of what
 * comes out is measured.
 *
 * At 1x the tone must come out at its original pitch. At 4x, with the
 * stretcher engaged, it must STILL come out at the original pitch (that is
 * the whole point of the feature). At 4x without the stretcher the same
 * stream must come out four times higher - that is the "music speeds up"
 * complaint, and it is measured here as the baseline that proves this test
 * can tell the two apart.
 *
 * The last scenario switches from 1x to 4x+stretcher mid-run, which is what
 * the frontend actually does when fast-forward starts: the resampler keeps
 * its fractional timestamp across the source switch, and a stale timestamp
 * there silently swallows the start of the music.
 */
static int audioFfTest() {
	const unsigned coreRate = 32768;
	const unsigned deviceRate = 48000;
	const double speed = 4.0;
	const int runMs = 2400;
	int failures = 0;

	enum {
		CASE_1X = 0,
		CASE_4X_PLAIN = 1,
		CASE_4X_STRETCH = 2,
		CASE_SWITCH = 3,
		CASE_4X_NATIVE = 4,
		CASE_4X_RATE2 = 5,
	};

	for (int scenario = CASE_1X; scenario <= CASE_4X_RATE2; ++scenario) {
		struct mAudioBuffer coreRing;
		mAudioBufferInit(&coreRing, coreRate * 4, 2);
		struct mAudioBuffer out;
		mAudioBufferInit(&out, 0x4000, 2);
		struct mAudioResampler resampler;
		mAudioResamplerInit(&resampler, mINTERPOLATOR_SINC);
		struct AudioStretch stretch;
		audioStretchInit(&stretch);
		audioStretchSetMode(&stretch, scenario == CASE_4X_NATIVE ? AUDIO_STRETCH_NATIVE : AUDIO_STRETCH_PITCH);

		std::vector<int16_t> chunk(size_t(coreRate * 0.2) * 2);
		std::vector<int16_t> drain(size_t(deviceRate * 0.2) * 2);
		double phase = 0.0;
		long long outSamples = 0;
		long long crossings = 0;
		int16_t prev = 0;
		double lastFeed = 0.0;
		double switchAt = runMs / 2000.0 / 2.0;
		QElapsedTimer clock;
		clock.start();

		while (clock.elapsed() < runMs) {
			double now = clock.elapsed() / 1000.0;
			double dt = now - lastFeed;
			if (dt <= 0.0) {
				QThread::msleep(1);
				continue;
			}
			lastFeed = now;
			bool stretched = (scenario == CASE_4X_STRETCH)
			                 || (scenario == CASE_4X_NATIVE)
			                 || (scenario == CASE_4X_RATE2)
			                 || (scenario == CASE_SWITCH && now >= switchAt);
			double factor = (scenario == CASE_1X || (scenario == CASE_SWITCH && !stretched)) ? 1.0 : speed;			size_t produce = size_t(factor * coreRate * dt);
			if (produce > chunk.size() / 2) {
				produce = chunk.size() / 2;
			}
			for (size_t i = 0; i < produce; ++i) {
				int16_t v = (int16_t) (12000.0 * sin(phase));
				chunk[i * 2] = v;
				chunk[i * 2 + 1] = v;
				phase += 2.0 * 3.14159265358979323846 * 440.0 / coreRate;
			}
			mAudioBufferWrite(&coreRing, chunk.data(), produce);

			struct mAudioBuffer* src = &coreRing;
			/* The music's own playback rate: 1 = its own tempo, 2 = twice as
			 * fast (which is what the tune sounds like when the surplus is
			 * only compressed by half of the fast-forward factor). */
			double musicRate = (scenario == CASE_4X_RATE2) ? 2.0 : 1.0;
			if (stretched) {
				src = audioStretchProcess(&stretch, &coreRing, coreRate, true,
				                         speed / musicRate, musicRate, 4096);
			}
			/* The frontend's destination rate: 1x while the stretcher is on
			 * (the staged audio is already at the console's own rate), and
			 * the fast-forward ratio otherwise - which is what makes a plain
			 * 4x fast-forward come out four times higher. */
			double destRate = deviceRate;
			if (scenario == CASE_4X_PLAIN) {
				destRate = deviceRate / speed;
			}
			mAudioResamplerSetSource(&resampler, src, coreRate * (stretched ? musicRate : 1.0), true);
			mAudioResamplerSetDestination(&resampler, &out, destRate);
			mAudioResamplerProcess(&resampler);

			// The device drains the playback buffer at its own rate.
			size_t want = size_t(deviceRate * dt);
			if (want > drain.size() / 2) {
				want = drain.size() / 2;
			}
			size_t avail = mAudioBufferAvailable(&out);
			if (avail > want) {
				avail = want;
			}
			if (avail) {
				mAudioBufferRead(&out, drain.data(), avail);
				// Only measure the part of the run that matters: after the
				// switch, the first scenario's samples would skew the pitch.
				bool measure = (scenario != CASE_SWITCH) || stretched;
				for (size_t i = 0; i < avail; ++i) {
					int16_t s = drain[i * 2];
					if (measure && ((prev < 0 && s >= 0) || (prev > 0 && s <= 0))) {
						++crossings;
					}
					prev = s;
				}
				if (measure) {
					outSamples += avail;
				}
			}
			QThread::msleep(2);
		}

		double seconds = outSamples / double(deviceRate);
		double pitch = seconds > 0.01 ? crossings / 2.0 / seconds : 0.0;
		const char* names[] = { "1x", "4x plain", "4x stretcher", "1x->4x switch", "4x native", "4x rate 2x" };
		qInfo().noquote() << QString("AUDIO FF: %1: out %2 s, pitch ~%3 Hz, cuts %4")
		                     .arg(names[scenario]).arg(seconds, 0, 'f', 2).arg(pitch, 0, 'f', 0)
		                     .arg(audioStretchCuts(&stretch));
		double expect = 440.0;
		if (scenario == CASE_4X_PLAIN) {
			expect = 440.0 * speed;
		} else if (scenario == CASE_4X_RATE2) {
			expect = 440.0 * 2.0;
		}
		if (pitch < expect * 0.9 || pitch > expect * 1.1) {
			qWarning().noquote() << QString("AUDIO FF: %1 pitched %2 Hz, expected ~%3 Hz")
			                        .arg(names[scenario]).arg(pitch, 0, 'f', 0).arg(expect, 0, 'f', 0);
			++failures;
		}
		mAudioBufferDeinit(&coreRing);
		mAudioBufferDeinit(&out);
		mAudioResamplerDeinit(&resampler);
		audioStretchDeinit(&stretch);
	}

	if (failures == 0) {
		qInfo() << "AUDIO FF: PASS";
	} else {
		qInfo() << "AUDIO FF: FAIL" << failures;
	}
	return failures;
}

/**
 * 直连通道自测：两个 DirectLink 在同一进程里互相打洞（用 127.0.0.1 当候选，
 * 绕开路由器回环限制），验证可达性判定、可靠层和时延。
 */
/**
 * 接收侧候选排序回归（11-16 P2P 死锁钉死用例）。
 * 两端枚举/转发候选的顺序可能不同（B 发 192.168 在前，A 收到却是 172 在前）。
 * 打洞「第一个 RESP 锁定」，顺序不一致会让两端锁到不同网卡、互相忽略包。
 * 这里给一个故意乱序的候选表，断言 setPeerCandidates 按网段重排为
 * 192.168 → 10 → 其它公网 → 172.16，保证两端锁定同一地址。
 */
static int directCandidateOrderTest() {
	int failures = 0;
	DirectLink link;
	link.setPeerCandidates({
		QStringLiteral("172.18.0.1:6000"),   // 虚拟网卡，最末
		QStringLiteral("36.251.93.252:26394"), // 公网/STUN，中间
		QStringLiteral("10.0.0.5:6000"),     // 10/8
		QStringLiteral("192.168.1.5:6000"),  // 192.168/16，最前
	});
	const QStringList got = link.sendTargetsText();
	const QStringList want = {
		QStringLiteral("192.168.1.5:6000"),
		QStringLiteral("10.0.0.5:6000"),
		QStringLiteral("36.251.93.252:26394"),
		QStringLiteral("172.18.0.1:6000"),
	};
	auto check = [&](bool ok, const QString& what) {
		fprintf(stderr, "DIRECT-ORDER: %s %s\n", ok ? "ok" : "FAIL", qPrintable(what));
		if (!ok) {
			++failures;
		}
	};
	check(got == want,
	      QStringLiteral("乱序候选重排为 192.168→10→公网→172；got=%1").arg(got.join(QLatin1Char(','))));

	// 同一组地址以另一种乱序进入，结果必须完全一致（两端对称性）。
	link.setPeerCandidates({
		QStringLiteral("192.168.1.5:6000"),
		QStringLiteral("172.18.0.1:6000"),
		QStringLiteral("36.251.93.252:26394"),
		QStringLiteral("10.0.0.5:6000"),
	});
	check(link.sendTargetsText() == want,
	      QStringLiteral("另一乱序得到相同结果（两端锁同一地址）；got=%1")
	          .arg(link.sendTargetsText().join(QLatin1Char(','))));

	fprintf(stderr, "DIRECT-ORDER: %s\n", failures ? "FAIL" : "PASS");
	return failures;
}

static int directLinkTest() {
	fprintf(stderr, "DIRECT: binding two peers\n");
	DirectLink a;
	DirectLink b;
	QString error;
	if (!a.bind(&error) || !b.bind(&error)) {
		fprintf(stderr, "DIRECT: bind failed %s\n", qPrintable(error));
		return 1;
	}
	QStringList candA = a.candidates();
	QStringList candB = b.candidates();
	fprintf(stderr, "A candidates: %s (port %u)\n", qPrintable(candA.join(", ")), unsigned(a.localPort()));
	fprintf(stderr, "B candidates: %s (port %u)\n", qPrintable(candB.join(", ")), unsigned(b.localPort()));

	a.setPeerCandidates({QStringLiteral("127.0.0.1:%1").arg(b.localPort())});
	b.setPeerCandidates({QStringLiteral("127.0.0.1:%1").arg(a.localPort())});
	a.startPunching();
	b.startPunching();

	qint64 deadline = QDateTime::currentMSecsSinceEpoch() + 5000;
	while (QDateTime::currentMSecsSinceEpoch() < deadline && !(a.connected() && b.connected())) {
		a.pump(5);
		b.pump(5);
	}
	if (!a.connected() || !b.connected()) {
		fprintf(stderr, "DIRECT: FAIL - punch incomplete a=%d b=%d\n", a.connected(), b.connected());
		return 1;
	}
	fprintf(stderr, "DIRECT: punched in %lld ms (A rtt %.1f ms, peer %s)\n",
	        (long long) (QDateTime::currentMSecsSinceEpoch() - a.punchStartMs()),
	        a.rttUs() / 1000.0, qPrintable(a.peerText()));

	int failures = 0;
	const int rounds = 200;
	qint64 worstUs = 0;
	qint64 totalUs = 0;
	int received = 0;
	for (int i = 0; i < rounds; ++i) {
		QByteArray payload = QByteArray("MBL") + QByteArray::number(i).rightJustified(4, '0');
		payload.append(QByteArray(16 - payload.size(), '\0'));
		qint64 t0 = QDateTime::currentMSecsSinceEpoch();
		a.send(payload);
		qint64 roundDeadline = t0 + 500;
		bool got = false;
		while (QDateTime::currentMSecsSinceEpoch() < roundDeadline) {
			QByteArray in;
			if (b.recv(&in, 5)) {
				if (in.left(7) == payload.left(7)) {
					got = true;
					break;
				}
				continue;
			}
			if (!a.connected() || !b.connected()) {
				break;
			}
		}
		if (got) {
			qint64 us = (QDateTime::currentMSecsSinceEpoch() - t0) * 1000;
			totalUs += us;
			worstUs = qMax(worstUs, us);
			++received;
		}
	}
	fprintf(stderr, "DIRECT: %d/%d payloads, avg %lld us, worst %lld us, rtt %d us\n",
	        received, rounds, received ? (long long) (totalUs / received) : 0LL,
	        (long long) worstUs, a.rttUs());
	if (received < rounds) {
		fprintf(stderr, "DIRECT: FAIL - lost payloads\n");
		++failures;
	}
	if (a.rttUs() > 20000) {
		fprintf(stderr, "DIRECT: FAIL - loopback rtt too high\n");
		++failures;
	}
	fprintf(stderr, "DIRECT: %s\n", failures ? "FAIL" : "PASS");
	return failures;
}

#ifdef _WIN32
/* 测试进程崩溃现场：与 mGBA.exe 的 crashFilter 相同，但每个返回地址都额外
 * 记录所属模块和模块内偏移 —— Release 构建里 libmgba.dll 与 exe 各有一套
 * 地址空间，只减 exe 基址会把 DLL 帧全算错。 */
static LONG WINAPI testCrashFilter(EXCEPTION_POINTERS* info) {
	char path[MAX_PATH];
	const char* temp = getenv("TEMP");
	snprintf(path, sizeof(path), "%s\\mgba_crash_test.txt", temp ? temp : ".");
	FILE* f = fopen(path, "w");
	if (f) {
		HMODULE base = GetModuleHandle(nullptr);
		fprintf(f, "code=%08lX\n", info->ExceptionRecord ? info->ExceptionRecord->ExceptionCode : 0);
		fprintf(f, "address=%p\n", info->ExceptionRecord ? info->ExceptionRecord->ExceptionAddress : nullptr);
		fprintf(f, "base=%p\n", (void*) base);
		if (info->ExceptionRecord && info->ExceptionRecord->NumberParameters >= 2) {
			fprintf(f, "param0=%llX\nparam1=%llX\n",
			        (unsigned long long) info->ExceptionRecord->ExceptionInformation[0],
			        (unsigned long long) info->ExceptionRecord->ExceptionInformation[1]);
		}
		void* frames[40];
		USHORT count = CaptureStackBackTrace(0, 40, frames, nullptr);
		fprintf(f, "frames=%u\n", count);
		for (USHORT i = 0; i < count; ++i) {
			HMODULE mod = NULL;
			char name[MAX_PATH] = "?";
			if (GetModuleHandleExA(GET_MODULE_HANDLE_EX_FLAG_FROM_ADDRESS
			                           | GET_MODULE_HANDLE_EX_FLAG_UNCHANGED_REFCOUNT,
			                       (LPCSTR) frames[i], &mod)) {
				GetModuleFileNameA(mod, name, MAX_PATH);
			}
			fprintf(f, "frame%u=%p module=%s+%llX\n", i, frames[i], name,
			        (unsigned long long) ((uintptr_t) frames[i] - (uintptr_t) mod));
		}
		fclose(f);
	}
	return EXCEPTION_EXECUTE_HANDLER;
}
#endif

/* ---- 产品侧进程内锁步入口（product-lockstep）---------------------------
 * 与 Android GBoyConsoleSet(useLockstep=true) 走完全相同的 C API：
 * mgbaMobileLinkHostLockstep / LinkJoinLockstep + mgbaMobileRunFrames 的小步
 * runLoop 帧循环。Qt 桌面前端的可见核是 CoreController（不是 MgbaMobile），
 * 它的进程内锁步由 MultiplayerController 负责；这里给 PC 补一个显式、
 * 可运行、可回归的产品路径入口，不触碰已验证的 2P 官方镜像布局。
 *
 * 用法：test-gboylink product-lockstep [rom]
 */
struct ProductLockstepCtx {
	struct MgbaMobile* emu = nullptr;
	int slot = 0;
	uint32_t recv[4] = {0, 0, 0, 0};
	uint32_t finalFrame = 0;
	bool everClean = false;
};

static std::atomic<int> g_plsClean{0};
static std::atomic<bool> g_plsStop{false};
static std::mutex g_plsMu;
static std::condition_variable g_plsCv;

static void productLockstepWorker(ProductLockstepCtx* ctx) {
	for (int f = 0; f < 64 && !g_plsStop.load(); ++f) {
		/* 空测试 ROM 不会自己发起 MULTI：主机每帧拉起 START，模拟真实
		 * gen8 在联机中心里的每帧 MULTI 传输。 */
		if (ctx->slot == 0 && f >= 8) {
			mgbaMobilePoke16(ctx->emu, 0x04000128u, 0x2083u);
		}
		mgbaMobileRunFrames(ctx->emu, 1);
		uint32_t r[4];
		for (int i = 0; i < 4; ++i) {
			r[i] = mgbaMobilePeek16(ctx->emu, 0x04000120u + uint32_t(i) * 2u);
		}
		if (r[0] == 0x1000u && r[1] == 0x1001u && r[2] == 0x1002u && r[3] == 0x1003u) {
			/* 快照：主机下一次 START 会把 SIOMULTI 重置成 0xFFFF。 */
			memcpy(ctx->recv, r, sizeof(r));
			if (!ctx->everClean) {
				ctx->everClean = true;
				std::lock_guard<std::mutex> lock(g_plsMu);
				++g_plsClean;
				g_plsCv.notify_all();
			}
		}
	}
	ctx->finalFrame = mgbaMobileFrameCounter(ctx->emu);
}

static int productLockstepTest(const QString& rom) {
	const int players = 4;
	const int key = 0x4C53;
	ProductLockstepCtx ctx[players];
	g_plsClean.store(0);
	g_plsStop.store(false);
	mgbaLockstepSetAbort(0);
	mgbaMobileSioSetInject(true);

	for (int i = 0; i < players; ++i) {
		ctx[i].slot = i;
		ctx[i].emu = mgbaMobileCreate(".", ".", "pcproduct");
		if (!ctx[i].emu || !mgbaMobileLoad(ctx[i].emu, rom.toUtf8().constData())) {
			fprintf(stderr, "product-lockstep: ROM load failed: %s\n", rom.toUtf8().constData());
			mgbaMobileSioSetInject(false);
			return 1;
		}
		/* BIOS 阶段先不挂锁步驱动，避免多启动探测卡住。 */
		mgbaMobileRunFrames(ctx[i].emu, 60);
	}

	bool attached = mgbaMobileLinkHostLockstep(ctx[0].emu, key, players, 0);
	for (int i = 1; i < players && attached; ++i) {
		attached = mgbaMobileLinkJoinLockstep(ctx[i].emu, key, i);
	}
	if (!attached) {
		fprintf(stderr, "product-lockstep: attach failed\n");
		mgbaMobileSioSetInject(false);
		return 1;
	}
	/* BIOS 之后 rcnt=0x8000 把 SIO 留在 JOYBUS；只写 SIOCNT 不会触发
	 * _switchMode，必须再写 RCNT=0 清掉 JOYBUS 位才会进 MULTI。 */
	for (int i = 0; i < players; ++i) {
		mgbaMobilePoke16(ctx[i].emu, 0x04000128u, 0x2003u);
		mgbaMobilePoke16(ctx[i].emu, 0x04000134u, 0x0000u);
	}

	std::thread workers[players];
	for (int i = 0; i < players; ++i) {
		workers[i] = std::thread(productLockstepWorker, &ctx[i]);
	}
	{
		std::unique_lock<std::mutex> lock(g_plsMu);
		g_plsCv.wait_for(lock, std::chrono::seconds(10),
		                 []() { return g_plsClean.load() == 4; });
	}
	bool allClean = g_plsClean.load() == players;
	/* 主动收尾：空 ROM 最后一轮 MULTI 之后不会再有 SIO 事件，从机会
	 * park 等一个永远不会来的事件。 */
	g_plsStop.store(true);
	mgbaLockstepSetAbort(1);
	for (int i = 0; i < players; ++i) {
		workers[i].join();
	}
	mgbaLockstepSetAbort(0);
	mgbaMobileSioSetInject(false);

	bool ok = allClean;
	for (int i = 0; i < players; ++i) {
		for (int j = 0; j < players; ++j) {
			if (ctx[i].recv[j] != uint32_t(0x1000 + j)) {
				ok = false;
			}
		}
		if (ctx[i].finalFrame <= 30) {
			ok = false;
		}
		fprintf(stderr, "product-lockstep: core %d recv %04X %04X %04X %04X fc=%u\n",
		        i, ctx[i].recv[0], ctx[i].recv[1], ctx[i].recv[2], ctx[i].recv[3],
		        ctx[i].finalFrame);
		mgbaMobileLinkClose(ctx[i].emu);
		mgbaMobileDestroy(ctx[i].emu);
		ctx[i].emu = nullptr;
	}
	fprintf(stderr, "product-lockstep: %s (4 cores, product SIO lockstep)\n",
	        ok ? "PASS" : "FAIL");
	return ok ? 0 : 1;
}

/**
 * 快帧门判据的真值表（`test-gboylink --fastgate`）。
 *
 * 为什么必须把这道门钉死：今晚的核心修复是「RTT 高时用快帧托住帧率」，
 * 而快帧一旦在**握手期**放行，复用的旧字会把 gBlockReceivedStatus 打回 0、
 * 停在「等待连接」——表现为「两端都 LINKUP 了却一直不动」，极难从日志区分。
 * 门的判据只有三输入（ok 计数、gLink.state、gLink.playerCount）加一个开关，
 * 所以直接穷举真值表，比靠实跑观察可靠。
 */
/* ===== path A 纯逻辑契约（Agent 1/2 产品实现须与此对齐） =====
 *
 * 这一组 helper 全部无 IO、无全局状态，只用来钉死 path A 快帧修复的
 * 「判据契约」。它们不是真实会话测试（不能证明跨设备 E2E），而是给
 * Agent 1（Qt sio_link.c 从机 idx 跟随）与 Agent 2（移动端 mgba_mobile.c）
 * 一个可执行的、C/Qt 两份一致的规格：
 *   - PATH_A_FAST_MIN_OK = 8  —— MGBAX_FAST_MIN_OK=8（ADR-003 §4.2 h.6）；
 *   - MASTER 位 = 0x20       —— gLinkStatus 里的 LINK_MASTER；
 *   - idx 用 int16 新旧比较   —— 与 netLinkTakePeerWordAny 一致；
 *   - 「mis」不是故障判据     —— 从机 mis≈成功轮数是健康读数（ADR §4.2 h.3），
 *     所以陈旧字守卫只看 idx 对齐，不看 mis 是否为 0。
 *
 * 若产品实现的函数名/取值不同，请同步改这里并让 orchestrator 知晓，
 * 不要静默让测试与产品分叉。 */
static const uint32_t kPathAFastMinOk = 8u;
static const uint32_t kPathAMasterBit = 0x20u;

/* 从机应消费的 idx：主机（peer）领先时跟随其最新 idx，而不是抱着冻结的
 * localIdx 去 netLinkTakePeerWordAny 永远 miss（FASTEARLY1：slave idx=50、
 * host 已推 576 ⇒ 复用旧字 ⇒ badChecksum）。 */
static uint16_t pathAFastIdxSelect(uint16_t localIdx, uint16_t peerIdx) {
	const int delta = (int16_t) (peerIdx - localIdx);
	return delta > 0 ? peerIdx : localIdx;
}

/* 两端 idx 是否已对齐。与产品 sioFastSlaveIdxAligned /
 * mobileFastSlaveIdxAligned 逐条对齐：wrap-safe 的 min(ahead,behind) <= window，
 * 任一侧为 0（还没拿到可靠轮次基准）一律视为未对齐。 */
static bool pathAFastIdxAligned(uint16_t localIdx, uint16_t peerIdx, uint16_t tol) {
	if (localIdx == 0 || peerIdx == 0) {
		return false;
	}
	const uint16_t ahead = (uint16_t) (peerIdx - localIdx);
	const uint16_t behind = (uint16_t) (localIdx - peerIdx);
	const uint16_t gap = ahead < behind ? ahead : behind;
	return gap <= tol;
}

/* 快帧字是否可安全喂给游戏。Agent 1/2 有两种可选修法，这里都建模：
 *   followLatest=1 —— 从机跟随主机最新 idx，领先时取新字（不是冻结的 localIdx）；
 *   followLatest=0 —— 不跟随，门必须等 idx 对齐（容差 tol 内）才放行。
 * 两者都不满足 ⇒ 门保持关闭，绝不用冻结的 localIdx 取字。 */
static bool pathAFastWordSafe(uint16_t localIdx, uint16_t peerIdx, uint16_t tol, bool followLatest) {
	if (localIdx == 0 || peerIdx == 0) {
		return false;   /* 无可靠基准：哪条修法都不许放行 */
	}
	if (pathAFastIdxAligned(localIdx, peerIdx, tol)) {
		return true;
	}
	return followLatest && pathAFastIdxSelect(localIdx, peerIdx) == peerIdx;
}

/* LINKUP 真判据（ADR-003 §4.2 h.5）：lstate==4 && pc==2 && st 含 MASTER(0x20)。
 * `linkup=1` 是菜单 A 残留值，绝不能当成功 —— 那种地形 state/pc/st 都不成立，
 * 本函数对它返回 false。 */
static bool pathALinkupStable(unsigned state, unsigned pc, uint32_t st) {
	return state == 4u && pc == 2u && (st & kPathAMasterBit) != 0u;
}

static int fastGateTest() {
	int failures = 0;
	auto check = [&](const char* what, bool got, bool want) {
		if (got == want) {
			printf("ok fastgate: %s\n", what);
		} else {
			++failures;
			printf("FAIL fastgate: %s (got %d want %d)\n", what, got ? 1 : 0, want ? 1 : 0);
		}
	};

	/* 1. 开关关闭：任何状态都不放行。 */
	check("disabled+state4+pc2+ok1000 → 不放行", sioFastGateReady(true, 1000, 4, 2), false);
	/* 2. 轮次不足：即使会话已建立也不放行（开局首字不能被复用）。 */
	check("ok=255 state4 pc2 → 不放行", sioFastGateReady(false, 255, 4, 2), false);
	check("ok=256 state4 pc2 → 放行", sioFastGateReady(false, 256, 4, 2), true);
	/* 3. 握手期（state 1/2/3）与「未建立」（pc=0）必须挡住 —— 这三条是
	 *    02:03 / 11-15 两次实跑踩出来的假阳性地形，其中 state=2 那条
	 *    （`fastframe latch without fieldCount lstate=2 pc=2`）正是后来把门
	 *    从 >=2 收紧到 >=4 的直接原因：state=2 只是 HANDSHAKE 开始，块交换
	 *    还没做完，此时复用旧字会把 gBlockReceivedStatus 打回 0。 */
	check("ok1000 state1 pc0 → 不放行", sioFastGateReady(false, 1000, 1, 0), false);
	check("ok1000 state1 pc2 → 不放行", sioFastGateReady(false, 1000, 1, 2), false);
	check("ok1000 state2 pc2 → 不放行", sioFastGateReady(false, 1000, 2, 2), false);
	check("ok1000 state3 pc2 → 不放行", sioFastGateReady(false, 1000, 3, 2), false);
	check("ok1000 state4 pc0 → 不放行", sioFastGateReady(false, 1000, 4, 0), false);
	check("ok1000 state4 pc2 → 放行", sioFastGateReady(false, 1000, 4, 2), true);

	/* 4. 单调性：ok 越大越不该被挡（避免有人把阈值改成 <= 之类写反）。 */
	bool monotone = true;
	for (uint32_t ok = 0; ok < 600; ++ok) {
		const bool a = sioFastGateReady(false, ok, 4, 2);
		const bool b = sioFastGateReady(false, ok + 1, 4, 2);
		if (a && !b) {
			monotone = false;
			break;
		}
	}
	check("ok 单调不倒退", monotone, true);

	/* 5. 可配置门限 Ex：minOk 就是新的轮次门槛，其余判据（state>=4/pc>=2）
	 *    不变。path A 云端 A/B 用 MGBAX_FAST_MIN_OK=8 让握手后立即进快帧。 */
	check("Ex minOk=8 ok=7 state4 pc2 → 不放行", sioFastGateReadyEx(false, 7, 4, 2, 8), false);
	check("Ex minOk=8 ok=8 state4 pc2 → 放行", sioFastGateReadyEx(false, 8, 4, 2, 8), true);
	check("Ex minOk=8 ok=34(LINKUP) state4 pc2 → 放行", sioFastGateReadyEx(false, 34, 4, 2, 8), true);
	check("Ex minOk=8 ok=34 state2 pc2 → 不放行(握手期仍挡)", sioFastGateReadyEx(false, 34, 2, 2, 8), false);
	check("Ex minOk=8 ok=34 state4 pc0 → 不放行(未建立仍挡)", sioFastGateReadyEx(false, 34, 4, 0, 8), false);
	check("Ex disabled ok=100 state4 pc2 → 不放行", sioFastGateReadyEx(true, 100, 4, 2, 8), false);
	check("Ex minOk=256 与原始函数等价", sioFastGateReadyEx(false, 255, 4, 2, 256) == sioFastGateReady(false, 255, 4, 2), true);

	/* 6. 角色不对称（FASTEARLY1 修复的语义基础）：同一时刻两端都刚 LINKUP
	 *    (ok=38 state4 pc2)，主机门 minOk=8 放行快帧救 LAG_MASTER，从机门
	 *    固定 256 不放行——块交换期从机必须阻塞取真字，复用旧字会把
	 *    sioFastLast 当主机真字喂进逐块校验 ⇒ badChecksum 掉链。 */
	check("角色不对称 ok=38 主机(minOk=8)放行", sioFastGateReadyEx(false, 38, 4, 2, 8), true);
	check("角色不对称 ok=38 从机(minOk=256)不放行", sioFastGateReadyEx(false, 38, 4, 2, 256), false);

	/* 7. minOk 边界/单调性补钉：门槛是可配置的，边界必须随 minOk 平移，
	 *    不能有人把 8 写死进函数体。minOk=0 时 ok=0 立即放行（无预热）。 */
	check("Ex minOk=7 ok=6 state4 pc2 → 不放行", sioFastGateReadyEx(false, 6, 4, 2, 7), false);
	check("Ex minOk=7 ok=7 state4 pc2 → 放行", sioFastGateReadyEx(false, 7, 4, 2, 7), true);
	check("Ex minOk=0 ok=0 state4 pc2 → 放行", sioFastGateReadyEx(false, 0, 4, 2, 0), true);
	check("Ex minOk=0 disabled → 仍不放行", sioFastGateReadyEx(true, 100, 4, 2, 0), false);
	check("Ex minOk=8 ok=255 state4 pc2 → 仍放行", sioFastGateReadyEx(false, 255, 4, 2, 8), true);
	check("Ex minOk=8 ok=8 state4 pc1 → 不放行", sioFastGateReadyEx(false, 8, 4, 1, 8), false);
	{
		bool exMonotone = true;
		for (uint32_t ok = 0; ok < 600; ++ok) {
			const bool a = sioFastGateReadyEx(false, ok, 4, 2, kPathAFastMinOk);
			const bool b = sioFastGateReadyEx(false, ok + 1, 4, 2, kPathAFastMinOk);
			if (a && !b) {
				exMonotone = false;
				break;
			}
		}
		check("Ex ok 单调不倒退(minOk=8)", exMonotone, true);
	}

	/* 8. 从机快帧 idx 对齐规则（Agent 1 修复的纯逻辑契约）：
	 *    主机已推到 576、从机冻结在 50 —— 正确行为是跟随主机最新 idx
	 *    （或门保持关闭直到对齐），绝不是拿 50 去取字永远 miss。 */
	check("idx 主机领先时跟随最新(50→576)", pathAFastIdxSelect(50, 576), (uint16_t) 576);
	check("idx 相等时保持", pathAFastIdxSelect(50, 50), (uint16_t) 50);
	check("idx 主机落后时不回退", pathAFastIdxSelect(576, 50), (uint16_t) 576);
	check("idx 16位回绕(+32)仍判主机领先", pathAFastIdxSelect(0xFFF0u, 0x0010u), (uint16_t) 0x0010u);
	check("idx 对齐容差0 相等→对齐", pathAFastIdxAligned(50, 50, 0), true);
	check("idx 对齐容差0 差1→未对齐", pathAFastIdxAligned(50, 51, 0), false);
	check("idx 对齐容差8 差1→对齐", pathAFastIdxAligned(50, 51, 8), true);
	check("idx 对齐容差8 差526→未对齐", pathAFastIdxAligned(50, 576, 8), false);
	check("idx wrap-safe min-gap(+32)≤64→对齐", pathAFastIdxAligned(0xFFF0u, 0x0010u, 64), true);
	check("idx 任一侧0→未对齐(无可靠基准)", pathAFastIdxAligned(0, 576, 8), false);
	check("idx 任一侧0→未对齐(slave侧)", pathAFastIdxAligned(50, 0, 8), false);
	/* 与产品 sioFastSlaveIdxAligned(hostIdx, slaveIdx, window) 同参同值
	 * （Agent 1 / 0b6a96f71）：gap=26>4 挡、gap=1 放、16 位回绕 gap=2 放。 */
	check("align(576,50,4)→未对齐", pathAFastIdxAligned(576, 50, 4), false);
	check("align(100,99,4)→对齐", pathAFastIdxAligned(100, 99, 4), true);
	check("align 回绕(0xFFFF,1,4)→对齐", pathAFastIdxAligned(0xFFFFu, 1, 4), true);

	/* 9. 陈旧字/mis 守卫（只看 idx，不看 mis —— mis≈ok 是健康读数）：
	 *    领先超容差时，要么已跟随最新 idx（安全放行），否则门必须关。 */
	check("stale 主机领先526 跟随最新→安全", pathAFastWordSafe(50, 576, 8, true), true);
	check("stale 主机领先526 不跟随→关门", pathAFastWordSafe(50, 576, 8, false), false);
	check("stale 主机落后526 超容差→关门", pathAFastWordSafe(576, 50, 8, true), false);
	check("stale 两端相等→安全", pathAFastWordSafe(50, 50, 0, false), true);
	check("stale 严格容差差1 不跟随→关门", pathAFastWordSafe(50, 51, 0, false), false);
	check("stale 严格容差差1 跟随最新→安全", pathAFastWordSafe(50, 51, 0, true), true);
	check("stale 回绕+32 跟随最新→安全", pathAFastWordSafe(0xFFF0u, 0x0010u, 64, true), true);
	check("stale 任一侧0→即使跟随也不放行", pathAFastWordSafe(0, 576, 8, true), false);

	/* 10. LINKUP 真判据 + `linkup=1` 菜单残留陷阱（ADR §4.2 h.5）。 */
	check("judge st=0x228 state4 pc2 → 真成功", pathALinkupStable(4, 2, 0x228u), true);
	check("judge st=0x368 state4 pc2 → 真成功", pathALinkupStable(4, 2, 0x368u), true);
	check("judge state2 握手期 → 非成功", pathALinkupStable(2, 2, 0x228u), false);
	check("judge pc0 → 非成功", pathALinkupStable(4, 0, 0x228u), false);
	check("judge st 无 MASTER 位 → 非成功", pathALinkupStable(4, 2, 0x208u), false);
	check("judge linkup=1 菜单残留(state1 pc0 st0) → 非成功", pathALinkupStable(1, 0, 0u), false);
	check("judge 从机 st=0x209 无MASTER → 非成功", pathALinkupStable(4, 2, 0x209u), false);

	printf("FASTGATE TEST: %s (%d FAIL)\n", failures ? "FAIL" : "PASS", failures);
	return failures;
}

/* 延迟线判据 sioDelayIndex 的真值表（`test-gboylink --delayline`）。
 *
 * 为什么值得单独钉死：这条判据决定「本轮该消费对端第几轮的字」。它错一位，
 * 两端消费的字序列就不再一致 —— 8 轮一块的校验和整体错位，gen8 侧立刻
 * badChecksum(0x2000) 拆链（/d/gen8/src/link.c:2322-2355）。它本身没有
 * 任何 IO，所以直接穷举边界比实跑可靠：cur<n 必须夹到 0（不能回绕成
 * 一个巨大的轮次号，那会把整条队列判成「过期」全部丢掉）。 */
extern "C" uint32_t sioDelayIndex(uint32_t cur, uint32_t n);

static int delayLineTest() {
	int failures = 0;
	auto check = [&](const char* what, uint32_t got, uint32_t want) {
		if (got == want) {
			printf("ok delayline: %s (=%u)\n", what, (unsigned) got);
		} else {
			++failures;
			printf("FAIL delayline: %s (got %u want %u)\n", what, (unsigned) got, (unsigned) want);
		}
	};

	/* 1. N==0：恒等（关闭延迟线 = 旧 1:1 行为）。 */
	check("N=0 cur=0 → 0", sioDelayIndex(0, 0), 0);
	check("N=0 cur=1 → 1", sioDelayIndex(1, 0), 1);
	check("N=0 cur=32 → 32", sioDelayIndex(32, 0), 32);
	check("N=0 cur=0xFFFFFFFF → 0xFFFFFFFF", sioDelayIndex(0xFFFFFFFFu, 0), 0xFFFFFFFFu);

	/* 2. N=32：正常递减，且整段保持 8 的偏移（命令块边界不变）。 */
	check("N=32 cur=32 → 0", sioDelayIndex(32, 32), 0);
	check("N=32 cur=33 → 1", sioDelayIndex(33, 32), 1);
	check("N=32 cur=64 → 32", sioDelayIndex(64, 32), 32);
	check("N=32 cur=1000 → 968", sioDelayIndex(1000, 32), 968);
	for (uint32_t cur = 32; cur < 40; ++cur) {
		char buf[64];
		snprintf(buf, sizeof(buf), "N=32 步长-1 cur=%u", (unsigned) cur);
		check(buf, sioDelayIndex(cur, 32), cur - 32);
	}

	/* 3. cur<N：夹到 0（不能回绕）。 */
	check("N=32 cur=0 → 0", sioDelayIndex(0, 32), 0);
	check("N=32 cur=1 → 0", sioDelayIndex(1, 32), 0);
	check("N=32 cur=31 → 0", sioDelayIndex(31, 32), 0);

	/* 4. u32 边界：回绕只能在 cur>n 时相减，且减法本身不能溢出。 */
	check("N=1 cur=0xFFFFFFFF → 0xFFFFFFFE",
	      sioDelayIndex(0xFFFFFFFFu, 1), 0xFFFFFFFEu);
	check("N=8 cur=0x80000000 → 0x7FFFFFF8",
	      sioDelayIndex(0x80000000u, 8), 0x7FFFFFF8u);
	check("N=0xFFFFFFFF cur=0 → 0", sioDelayIndex(0, 0xFFFFFFFFu), 0);
	check("N=0xFFFFFFFF cur=0xFFFFFFFF → 0", sioDelayIndex(0xFFFFFFFFu, 0xFFFFFFFFu), 0);
	check("N=0xFFFFFFFF cur<0xFFFFFFFF → 0", sioDelayIndex(0xFFFFFFFEu, 0xFFFFFFFFu), 0);

	/* 5. 8 的整数倍：偏移前后落在同一个块相位（这是 N 取 8k 的依据）。 */
	for (uint32_t n = 8; n <= 56; n += 8) {
		uint32_t cur = 200;
		char buf[64];
		snprintf(buf, sizeof(buf), "N=%u 保持块相位 cur=%u", (unsigned) n, (unsigned) cur);
		check(buf, sioDelayIndex(cur, n) % 8, cur % 8);
	}

	printf("DELAYLINE TEST: %s (%d FAIL)\n", failures ? "FAIL" : "PASS", failures);
	return failures;
}

int main(int argc, char** argv) {
	QCoreApplication app(argc, argv);
	setvbuf(stdout, NULL, _IONBF, 0);
	setvbuf(stderr, NULL, _IONBF, 0);
#ifdef _WIN32
	if (!qEnvironmentVariableIsEmpty("MGBAX_CRASH_LOG")) {
		SetUnhandledExceptionFilter(testCrashFilter);
	}
#endif
	QStringList args = app.arguments();
	if (args.size() < 2) {
		qInfo() << "usage: test-gboylink wifi [rom] | cloud <user> <pass> [room] [rom]"
		        << "| cloud2 <user> <pass> <roomFile> <host|join> [rom]"
		        << "| product-lockstep [rom] | webdav | glsl <in.glsl> | --c0";
		return 2;
	}
	QString mode = args[1];
	if (mode == QStringLiteral("product-lockstep")) {
		QString rom = args.size() > 2 ? args[2] : QStringLiteral("test.gba");
		return productLockstepTest(rom);
	}
	if (mode == QStringLiteral("wifi")) {
		QString rom = args.size() > 2 ? args[2] : QStringLiteral("test.gba");
		return wifiTest(rom);
	}
	if (mode == QStringLiteral("webdav")) {
		return webdavTest();
	}
	if (mode == QStringLiteral("direct2")) {
		return directLinkTest();
	}
	if (mode == QStringLiteral("direct-order")) {
		return directCandidateOrderTest();
	}
	if (mode == QStringLiteral("hold")) {
		return holdTest();
	}
	if (mode == QStringLiteral("audioff")) {
		return audioFfTest();
	}
	if (mode == QStringLiteral("frames")) {
		int failures = framesTest();
		failures += kcpFrameTest();
		failures += reconnectFrameTest();
		failures += tcpDirectLinkTest();
		return failures;
	}
	if (mode == QStringLiteral("--fastgate")) {
		return fastGateTest();
	}
	/* 对称定长延迟线判据的真值表（纯函数，不需要 ROM / 网络）。 */
	if (mode == QStringLiteral("--delayline") || mode == QStringLiteral("delayline")) {
		return delayLineTest();
	}
	/* C0 能力协商位（ADR-002）的独立断言。纯字节级，不需要 ROM / 网络 / 事件
	 * 循环，也不依赖 BUILD_QT_CLOUD（断言的是 GBoyFrames 的编解码与 AUTO 映射，
	 * 也就是 CloudLink 转调的那份实现）。`c0` 作为别名一并接受。 */
	if (mode == QStringLiteral("--c0") || mode == QStringLiteral("c0")) {
		return c0Test();
	}
	if (mode == QStringLiteral("bus")) {
		QString rom = args.size() > 2 ? args[2] : QStringLiteral("test.gba");
		int players = args.size() > 3 ? args[3].toInt() : 4;
		return busSioTest(rom, players);
	}
	if (mode == QStringLiteral("buslocal")) {
		int failures = busLocalSlotTest();
		failures += gboySessionSlotTest();
		return failures;
	}
	if (mode == QStringLiteral("busgame")) {
		QString rom = args.size() > 2 ? args[2] : QStringLiteral("D:/gen8/rom.gba");
		QString sav = args.size() > 3 ? args[3] : QStringLiteral("D:/gen8/rom.sav");
		int players = args.size() > 4 ? args[4].toInt() : 3;
		return busGameTest(rom, sav, players);
	}
	if (mode == QStringLiteral("busgame-lockstep")) {
		QString rom = args.size() > 2 ? args[2] : QStringLiteral("D:/gen8/rom.gba");
		QString sav = args.size() > 3 ? args[3] : QStringLiteral("D:/gen8/rom.sav");
		int players = args.size() > 4 ? args[4].toInt() : 4;
		return busGameLockstepTest(rom, sav, players);
	}
	if (mode == QStringLiteral("busgame-product")) {
		/* 同一套 gen8 按键/内存判据，但 4 核走 MgbaMobile 产品 lockstep API。 */
		qputenv("BUSGAME_PRODUCT", "1");
		QString rom = args.size() > 2 ? args[2] : QStringLiteral("D:/mgba-android-version/rom.gba");
		QString sav = args.size() > 3 ? args[3] : QStringLiteral("D:/mgba-android-version/tmp_bus/rom.sav");
		int players = args.size() > 4 ? args[4].toInt() : 4;
		return busGameLockstepTest(rom, sav, players);
	}
	if (mode == QStringLiteral("lanio")) {
		QString rom = args.size() > 2 ? args[2] : QStringLiteral("test.gba");
		return lanSioTest(rom);
	}
	if (mode == QStringLiteral("dual")) {
		QString rom = args.size() > 2 ? args[2] : QStringLiteral("test.gba");
		QString sav = args.size() > 3 ? args[3] : rom + QStringLiteral(".sav");
		return dualTest(rom, sav);
	}
	if (mode == QStringLiteral("laniolat")) {
		QString rom = args.size() > 2 ? args[2] : QStringLiteral("test.gba");
		int delay = args.size() > 3 ? args[3].toInt() : 80;
		return lanSioLatTest(rom, delay);
	}
	if (mode == QStringLiteral("glsl")) {
		if (args.size() < 3) {
			qInfo() << "usage: test-gboylink glsl <in.glsl>";
			return 2;
		}
		return glslTest(args[2]);
	}
#ifdef BUILD_QT_CLOUD
	/* 协商门端到端：真的跑 CloudLink::negotiateLinkMode() 本体（五类分支），
	 * 不连网、不起线程。`gatetest` 作为别名一并接受。 */
	if (mode == QStringLiteral("--gatetest") || mode == QStringLiteral("gatetest")) {
		return gateTest();
	}
	// Mock-lobby support: MGBAX_CLOUD_WS=host:port and MGBAX_CLOUD_API=url
	// redirect the signalling endpoints for tests; unset for the real gboy.top.
	QString ws = qEnvironmentVariable("MGBAX_CLOUD_WS");
	if (!ws.isEmpty()) {
		int colon = ws.lastIndexOf(':');
		if (colon > 0) {
			GbCloud::overrideEndpoints(qEnvironmentVariable("MGBAX_CLOUD_API"),
			                           ws.left(colon), ws.mid(colon + 1).toInt());
			qInfo().noquote() << "signalling redirected to" << ws
			                  << "(" << qEnvironmentVariable("MGBAX_CLOUD_API") << ")";
		}
	}
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
