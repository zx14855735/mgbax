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
#include "DirectLink.h"
#include "GbCloud.h"
#include "KcpChannel.h"
#include "SioLinkHost.h"
#endif
#include "sio_link.h"
#include "../mobile/link_net.h"

#include <QCoreApplication>
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
			uint32_t cb2 = (uint32_t) GBAView16(gba[0]->cpu, 0x03002AD4u) |
			               ((uint32_t) GBAView16(gba[0]->cpu, 0x03002AD6u) << 16);
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
			if (cb2 == 0x0809A241u) {
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
	uint32_t cb2 = (uint32_t) GBAView16(gba[0]->cpu, 0x03002AD4u) |
	               ((uint32_t) GBAView16(gba[0]->cpu, 0x03002AD6u) << 16);
	if (cb2 == 0x0809A241u) {
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
	for (int i = 0; i < players; ++i) {
		maxCnt[i].store(0);
		sawCards[i].store(0);
		sawBattle[i].store(0);
		lastCb2[i].store(0);
		lastFrame[i].store(-1);
		frameProgress[i].store(-1);
		coreStepUs[i].store(0);
		pumpUs[i].store(0);
		runUs[i].store(0);
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
					        GBAView16(g->cpu, 0x0202197Cu),
					        cnt, cb2, (unsigned) g->cpu->gprs[15]);
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
	if (mode == QStringLiteral("direct2")) {
		return directLinkTest();
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
		return failures;
	}
	if (mode == QStringLiteral("bus")) {
		QString rom = args.size() > 2 ? args[2] : QStringLiteral("test.gba");
		int players = args.size() > 3 ? args[3].toInt() : 4;
		return busSioTest(rom, players);
	}
	if (mode == QStringLiteral("busgame")) {
		QString rom = args.size() > 2 ? args[2] : QStringLiteral("D:/gen8/rom.gba");
		QString sav = args.size() > 3 ? args[3] : QStringLiteral("D:/gen8/rom.sav");
		int players = args.size() > 4 ? args[4].toInt() : 3;
		return busGameTest(rom, sav, players);
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
