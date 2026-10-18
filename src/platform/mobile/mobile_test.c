/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "link_net.h"
#include "mgba_mobile.h"
#include "remote_link.h"

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#ifdef _WIN32
#include <winsock2.h>
#include <ws2tcpip.h>
#include <windows.h>
#include <direct.h>
#define test_close closesocket
#else
#include <arpa/inet.h>
#include <errno.h>
#include <netinet/in.h>
#include <poll.h>
#include <sys/socket.h>
#include <sys/stat.h>
#include <unistd.h>
#define test_close close
#endif

static int g_failed;

static void expect(int cond, const char* message) {
	if (!cond) {
		fprintf(stderr, "FAIL %s\n", message);
		g_failed = 1;
	} else {
		printf("ok %s\n", message);
	}
}

static void testBios(void) {
	char name[32];
	mgbaMobileBiosFileName("GBA_BIOS.BIN", 10, name, sizeof(name));
	expect(strcmp(name, "gba_bios.bin") == 0, "bios gba by name");
	mgbaMobileBiosFileName("boot.bin", 16384, name, sizeof(name));
	expect(strcmp(name, "gba_bios.bin") == 0, "bios gba by size");
	mgbaMobileBiosFileName("cgb_boot.bin", 10, name, sizeof(name));
	expect(strcmp(name, "gbc_bios.bin") == 0, "bios gbc by name");
	mgbaMobileBiosFileName("boot.bin", 2304, name, sizeof(name));
	expect(strcmp(name, "gbc_bios.bin") == 0, "bios gbc by size");
	mgbaMobileBiosFileName("sgb_bios.bin", 10, name, sizeof(name));
	expect(strcmp(name, "sgb_bios.bin") == 0, "bios sgb");
	mgbaMobileBiosFileName("dmg.bin", 256, name, sizeof(name));
	expect(strcmp(name, "gb_bios.bin") == 0, "bios gb fallback");
}

static void testResample(void) {
	int16_t in[4] = { 0, 0, 100, 50 };
	int16_t out[8];
	double pos = 0;
	int frames = mgbaMobileResample(in, 2, 2, 4, out, 4, &pos);
	expect(frames == 4, "resample frame count");
	expect(out[0] == 0 && out[1] == 0, "resample first");
	expect(out[2] == 50 && out[3] == 25, "resample mid");
	expect(out[4] == 100 && out[5] == 50, "resample second");
	expect(pos == 0, "resample position wraps");
}

static int writeFile(const char* path, const unsigned char* data, size_t size) {
	FILE* file = fopen(path, "wb");
	if (!file) {
		return 0;
	}
	if (fwrite(data, 1, size, file) != size) {
		fclose(file);
		return 0;
	}
	fclose(file);
	return 1;
}

static void testGb(const char* dir) {
	unsigned char* rom;
	char path[512];
	char title[32];
	char save[1200];
	struct MgbaMobile* emu;
	uint32_t* pixels;
	int i;
	int lit = 0;
	snprintf(path, sizeof(path), "%s/test.gb", dir);
	rom = (unsigned char*) calloc(1, 32768);
	expect(rom != NULL, "gb rom buffer");
	if (!rom) {
		return;
	}
	rom[0x100] = 0x00;
	rom[0x101] = 0xC3;
	rom[0x102] = 0x50;
	rom[0x103] = 0x01;
	rom[0x104] = 0xCE;
	rom[0x105] = 0xED;
	rom[0x106] = 0x66;
	rom[0x107] = 0x66;
	memcpy(rom + 0x134, "TESTROM", 7);
	rom[0x150] = 0x3E;
	rom[0x151] = 0xE4;
	rom[0x152] = 0xE0;
	rom[0x153] = 0x47;
	rom[0x154] = 0x3E;
	rom[0x155] = 0x91;
	rom[0x156] = 0xE0;
	rom[0x157] = 0x40;
	rom[0x158] = 0x18;
	rom[0x159] = 0xFE;
	expect(writeFile(path, rom, 32768), "write gb rom");
	free(rom);
	emu = mgbaMobileCreate(dir, dir, "test");
	expect(emu != NULL, "create emu");
	expect(mgbaMobileFrameNanos(emu) == 0, "no frame time without rom");
	expect(!mgbaMobileLoad(emu, "missing.gb"), "reject missing rom");
	expect(mgbaMobileLoad(emu, path), "load gb");
	expect(mgbaMobileWidth(emu) == 160 && mgbaMobileHeight(emu) == 144, "gb dimensions");
	expect(mgbaMobileSampleRate(emu) > 0, "gb sample rate");
	// The console's own frame time (about 59.73 fps), so front ends can pace
	// at hardware speed instead of a rounded 60 that plays audio sharp.
	expect(mgbaMobileFrameNanos(emu) > 16740000 && mgbaMobileFrameNanos(emu) < 16750000, "gb frame time");
	mgbaMobileTitle(emu, title, sizeof(title));
	expect(strstr(title, "TESTROM") != NULL, "gb title");
	mgbaMobileSetKeys(emu, 1u << 0);
	mgbaMobileSetTurbo(emu, 1u << 1);
	expect(mgbaMobileRunFrames(emu, 8), "run gb frames");
	mgbaMobileSetTurbo(emu, 0);
	mgbaMobileSetFrameskip(emu, 2);
	mgbaMobileSetInterframe(emu, true);
	pixels = (uint32_t*) calloc(160 * 144, sizeof(uint32_t));
	expect(pixels && mgbaMobileCopyVideo(emu, pixels, 160), "copy gb video");
	if (pixels) {
		for (i = 0; i < 160 * 144; ++i) {
			if ((pixels[i] & 0x00FFFFFFu) != 0) {
				lit = 1;
				break;
			}
		}
		free(pixels);
	}
	expect(lit, "gb picture is not blank");
	expect(mgbaMobileSaveState(emu, 1), "save state 1");
	expect(mgbaMobileLoadState(emu, 1), "load state 1");
	expect(!mgbaMobileLoadState(emu, 9), "missing state 9");
	mgbaMobileSaveFile(emu, save, sizeof(save));
	expect(strstr(save, ".sav") != NULL, "gb save path");
	mgbaMobileClearAudio(emu);
	mgbaMobileReset(emu);
	expect(mgbaMobileIsLoaded(emu), "still loaded after reset");
	mgbaMobileDestroy(emu);
}

static void testGba(const char* dir) {
	unsigned char rom[2048];
	char path[512];
	char save[1200];
	struct MgbaMobile* emu;
	memset(rom, 0, sizeof(rom));
	rom[0] = 0xFE;
	rom[1] = 0xFF;
	rom[2] = 0xFF;
	rom[3] = 0xEA;
	rom[0xB2] = 0x96;
	snprintf(path, sizeof(path), "%s/test.gba", dir);
	expect(writeFile(path, rom, sizeof(rom)), "write gba rom");
	emu = mgbaMobileCreate(dir, dir, "test");
	expect(mgbaMobileLoad(emu, path), "load gba");
	expect(mgbaMobileWidth(emu) == 240 && mgbaMobileHeight(emu) == 160, "gba dimensions");
	expect(mgbaMobileFrameNanos(emu) > 16740000 && mgbaMobileFrameNanos(emu) < 16750000, "gba frame time");
	expect(mgbaMobileRunFrames(emu, 2), "run gba frames");
	mgbaMobileSaveFile(emu, save, sizeof(save));
	expect(strstr(save, ".sav") != NULL, "gba save path");
	mgbaMobileDestroy(emu);
}

/* Runs frames in bursts of at most step frames, draining between bursts. */
static int drainBurst(struct MgbaMobile* emu, int frames, int step, int16_t* out, int maxFrames, int speed, float drift) {
	int total = 0;
	while (frames > 0) {
		int got;
		int rounds = 0;
		int n = step < frames ? step : frames;
		mgbaMobileRunFrames(emu, n);
		frames -= n;
		while (rounds++ < 16 && (got = mgbaMobileReadAudioOut(emu, out, maxFrames, speed, drift)) > 0) {
			total += got;
		}
	}
	return total;
}

static int drainAudio(struct MgbaMobile* emu, int frames, int16_t* out, int maxFrames, int speed, float drift) {
	return drainBurst(emu, frames, 1, out, maxFrames, speed, drift);
}

static int audioSignal(const int16_t* samples, int frames) {
	int i;
	for (i = 0; i < frames * 2; ++i) {
		if (samples[i] != 0) {
			return 1;
		}
	}
	return 0;
}

static void testAudioOut(const char* dir) {
	unsigned char* rom;
	char path[512];
	struct MgbaMobile* emu;
	int16_t* out;
	int plain;
	int fast;
	int slow;
	int total;
	snprintf(path, sizeof(path), "%s/audio.gb", dir);
	rom = (unsigned char*) calloc(1, 32768);
	expect(rom != NULL, "audio rom buffer");
	if (!rom) {
		return;
	}
	rom[0x100] = 0x00;
	rom[0x101] = 0xC3;
	rom[0x102] = 0x50;
	rom[0x103] = 0x01;
	rom[0x104] = 0xCE;
	rom[0x105] = 0xED;
	rom[0x106] = 0x66;
	rom[0x107] = 0x66;
	memcpy(rom + 0x134, "AUDIOTEST", 9);
	/* Sound on, both outputs at max, then a square wave on channel 1. */
	rom[0x150] = 0x3E; rom[0x151] = 0x80; rom[0x152] = 0xE0; rom[0x153] = 0x26;
	rom[0x154] = 0x3E; rom[0x155] = 0x77; rom[0x156] = 0xE0; rom[0x157] = 0x24;
	rom[0x158] = 0x3E; rom[0x159] = 0xFF; rom[0x15A] = 0xE0; rom[0x15B] = 0x25;
	rom[0x15C] = 0x3E; rom[0x15D] = 0xF0; rom[0x15E] = 0xE0; rom[0x15F] = 0x12;
	rom[0x160] = 0x3E; rom[0x161] = 0x00; rom[0x162] = 0xE0; rom[0x163] = 0x13;
	rom[0x164] = 0x3E; rom[0x165] = 0x87; rom[0x166] = 0xE0; rom[0x167] = 0x14;
	rom[0x168] = 0x18; rom[0x169] = 0xFE;
	expect(writeFile(path, rom, 32768), "write audio rom");
	free(rom);
	emu = mgbaMobileCreate(dir, dir, "test");
	expect(mgbaMobileLoad(emu, path), "load audio rom");
	out = (int16_t*) calloc(8192 * 2, sizeof(int16_t));
	expect(out != NULL, "audio out buffer");
	if (!out) {
		mgbaMobileDestroy(emu);
		return;
	}
	expect(mgbaMobileSetAudioOutput(emu, 48000), "enable audio output resampler");
	// 120 paced frames are two seconds of emulated audio; converting to 48 kHz
	// makes that two seconds of output whatever rate the core itself runs at.
	total = drainAudio(emu, 120, out, 8192, 1, 0.0f);
	expect(total > 94000 && total < 98000, "audio output is two seconds long");
	memset(out, 0, 8192 * 2 * sizeof(int16_t));
	total = drainAudio(emu, 5, out, 8192, 1, 0.0f);
	expect(total > 0 && audioSignal(out, 8192), "audio output carries a signal");
	plain = drainAudio(emu, 30, out, 8192, 1, 0.0f);
	fast = drainAudio(emu, 30, out, 8192, 1, 0.02f);
	slow = drainAudio(emu, 30, out, 8192, 1, -0.02f);
	// Positive drift makes the resampler consume its input faster, so the same
	// amount of emulated audio turns into fewer output frames.
	expect(fast < plain && plain < slow, "drift moves the output rate");
	expect((double) plain / fast > 1.015 && (double) plain / fast < 1.025, "positive drift drains");
	expect((double) slow / plain > 1.015 && (double) slow / plain < 1.025, "negative drift fills");
	// The pace feedback stretches the same emulated audio into more output: a
	// front end that only manages half the slices per second needs twice as
	// many output frames, or the playback buffer would slowly run dry.
	plain = drainAudio(emu, 30, out, 8192, 1, 0.0f);
	mgbaMobileSetAudioPaceFps(emu, 30.0);
	slow = drainAudio(emu, 30, out, 8192, 1, 0.0f);
	expect((double) slow / plain > 1.9 && (double) slow / plain < 2.1, "half pace doubles the stream");
	// Out-of-range measurements are clamped instead of trusted.
	mgbaMobileSetAudioPaceFps(emu, 1.0);
	fast = drainAudio(emu, 30, out, 8192, 1, 0.0f);
	expect((double) fast / plain > 3.8 && (double) fast / plain < 4.2, "out-of-range pace is clamped");
	mgbaMobileSetAudioPaceFps(emu, 60.0);
	total = drainAudio(emu, 30, out, 8192, 1, 0.0f);
	expect((double) total / plain > 0.98 && (double) total / plain < 1.02, "pace returns to nominal");
	total = drainAudio(emu, 30, out, 8192, 4, 0.0f);
	expect((double) plain / total > 3.8 && (double) plain / total < 4.2, "speed scales the output rate");
	// Fast-forward must be run in small steps: the core's audio buffer holds
	// only a few frames' worth, so one big burst would silently drop samples.
	plain = drainAudio(emu, 16, out, 8192, 16, 0.0f);
	total = drainBurst(emu, 16, 4, out, 8192, 16, 0.0f);
	expect((double) total / plain > 0.98 && (double) total / plain < 1.02, "stepped fast-forward keeps audio");
	// A single burst does not: the core's audio buffer is smaller than 16 frames
	// of samples, and it drops whatever does not fit. Front ends must step.
	total = drainBurst(emu, 16, 16, out, 8192, 16, 0.0f);
	expect((double) total / plain < 0.9, "one big burst drops audio");
	mgbaMobileClearAudio(emu);
	total = drainAudio(emu, 5, out, 8192, 1, 0.0f);
	expect(total > 0, "audio flows again after clear");
	expect(mgbaMobileSetAudioOutput(emu, 44100), "switch audio output rate");
	total = drainAudio(emu, 30, out, 8192, 1, 0.0f);
	expect(total > 21400 && total < 22600, "audio follows the output rate");
	expect(!mgbaMobileSetAudioOutput(emu, 0), "disable audio output resampler");
	total = drainAudio(emu, 2, out, 8192, 1, 0.0f);
	expect(total > 2000, "raw audio keeps the core rate");
	free(out);
	mgbaMobileDestroy(emu);
}

struct ExArgs {
	struct NetLink* link;
	uint32_t value;
	uint32_t got;
	int ok;
};

static void* exchangeThread(void* arg) {
	struct ExArgs* ex = (struct ExArgs*) arg;
	ex->ok = netLinkExchange(ex->link, 1, ex->value, &ex->got, 2000);
	return NULL;
}

static void testLink(void) {
	struct NetLink* host = netLinkCreate();
	struct NetLink* guest = netLinkCreate();
	struct ExArgs a;
	struct ExArgs b;
	pthread_t ta;
	pthread_t tb;
	char status[128];
	int port = 18771;
	expect(netLinkHost(host, port), "link host");
	{
		int tries;
		int joined = 0;
		for (tries = 0; tries < 50 && !joined; ++tries) {
			joined = netLinkJoin(guest, "127.0.0.1", port);
			if (!joined) {
#ifdef _WIN32
				Sleep(20);
#else
				usleep(20000);
#endif
			}
		}
		expect(joined, "link join");
	}
	{
		int tries;
		int connected = 0;
		for (tries = 0; tries < 50; ++tries) {
			netLinkStatusText(host, status, sizeof(status));
			if (status[0] == '2') {
				connected = 1;
				break;
			}
#ifdef _WIN32
			Sleep(20);
#else
			usleep(20000);
#endif
		}
		expect(connected, "link host connected");
	}
	a.link = host;
	a.value = 0x1111;
	b.link = guest;
	b.value = 0x2222;
	pthread_create(&ta, NULL, exchangeThread, &a);
	pthread_create(&tb, NULL, exchangeThread, &b);
	pthread_join(ta, NULL);
	pthread_join(tb, NULL);
	expect(a.ok && b.ok, "link exchange");
	expect(a.got == 0x2222 && b.got == 0x1111, "link exchanged values");
	netLinkDestroy(host);
	netLinkDestroy(guest);
}

struct RelayFake {
	pthread_mutex_t mu;
	pthread_cond_t cv;
	int listenFd;
	int hostFd;
	int guestFd;
	char status[512];
	char code[16];
	char advertise[160];
	int ready1p;
	int ready2p;
};

static struct RelayFake* fakeFrom(void* user) {
	return (struct RelayFake*) user;
}

static void onStatus(void* user, const char* text) {
	struct RelayFake* fake = fakeFrom(user);
	pthread_mutex_lock(&fake->mu);
	snprintf(fake->status, sizeof(fake->status), "%s", text ? text : "");
	if (text && strstr(text, "你是 1P")) {
		fake->ready1p = 1;
	}
	if (text && strstr(text, "你是 2P")) {
		fake->ready2p = 1;
	}
	pthread_cond_broadcast(&fake->cv);
	pthread_mutex_unlock(&fake->mu);
	printf("status %s\n", text ? text : "");
}

static void onRoom(void* user, const char* code, const char* advertise) {
	struct RelayFake* fake = fakeFrom(user);
	pthread_mutex_lock(&fake->mu);
	snprintf(fake->code, sizeof(fake->code), "%s", code ? code : "");
	snprintf(fake->advertise, sizeof(fake->advertise), "%s", advertise ? advertise : "");
	pthread_cond_broadcast(&fake->cv);
	pthread_mutex_unlock(&fake->mu);
}

static bool hostLink(void* user, int port) {
	struct RelayFake* fake = fakeFrom(user);
	struct sockaddr_in addr;
	int one = 1;
	int fd = (int) socket(AF_INET, SOCK_STREAM, 0);
	if (fd < 0) {
		return false;
	}
	setsockopt(fd, SOL_SOCKET, SO_REUSEADDR, (const char*) &one, sizeof(one));
	memset(&addr, 0, sizeof(addr));
	addr.sin_family = AF_INET;
	addr.sin_port = htons((uint16_t) port);
	addr.sin_addr.s_addr = htonl(INADDR_LOOPBACK);
	if (bind(fd, (struct sockaddr*) &addr, sizeof(addr)) < 0 || listen(fd, 1) < 0) {
		test_close(fd);
		return false;
	}
	fake->listenFd = fd;
	return true;
}

static bool joinLink(void* user, const char* host, int port) {
	struct RelayFake* fake = fakeFrom(user);
	struct sockaddr_in addr;
	int fd = (int) socket(AF_INET, SOCK_STREAM, 0);
	if (fd < 0 || !host) {
		return false;
	}
	memset(&addr, 0, sizeof(addr));
	addr.sin_family = AF_INET;
	addr.sin_port = htons((uint16_t) port);
	inet_pton(AF_INET, host, &addr.sin_addr);
	if (connect(fd, (struct sockaddr*) &addr, sizeof(addr)) < 0) {
		test_close(fd);
		return false;
	}
	pthread_mutex_lock(&fake->mu);
	fake->guestFd = fd;
	pthread_cond_broadcast(&fake->cv);
	pthread_mutex_unlock(&fake->mu);
	return true;
}

static void closeLink(void* user) {
	(void) user;
}

static int waitFlag(struct RelayFake* fake, int (*ready)(struct RelayFake*), int seconds) {
	struct timespec ts;
	int ok = 0;
	pthread_mutex_lock(&fake->mu);
	ts.tv_sec = time(NULL) + seconds;
	ts.tv_nsec = 0;
	while (!ready(fake)) {
		if (pthread_cond_timedwait(&fake->cv, &fake->mu, &ts) == ETIMEDOUT) {
			break;
		}
	}
	ok = ready(fake);
	pthread_mutex_unlock(&fake->mu);
	return ok;
}

static int codeReady(struct RelayFake* fake) {
	return fake->code[0] != '\0';
}

static int guestReady(struct RelayFake* fake) {
	return fake->ready2p && fake->guestFd >= 0;
}

static void testRelay(void) {
	struct RelayFake hostFake;
	struct RelayFake guestFake;
	struct MobileRelayHooks hostHooks;
	struct MobileRelayHooks guestHooks;
	struct MobileRelay* host;
	struct MobileRelay* guest;
	char relay[160];
	char got[8];
	int n;
	memset(&hostFake, 0, sizeof(hostFake));
	memset(&guestFake, 0, sizeof(guestFake));
	hostFake.listenFd = -1;
	hostFake.hostFd = -1;
	hostFake.guestFd = -1;
	guestFake.listenFd = -1;
	guestFake.hostFd = -1;
	guestFake.guestFd = -1;
	pthread_mutex_init(&hostFake.mu, NULL);
	pthread_cond_init(&hostFake.cv, NULL);
	pthread_mutex_init(&guestFake.mu, NULL);
	pthread_cond_init(&guestFake.cv, NULL);
	memset(&hostHooks, 0, sizeof(hostHooks));
	memset(&guestHooks, 0, sizeof(guestHooks));
	hostHooks.user = &hostFake;
	hostHooks.onStatus = onStatus;
	hostHooks.onRoom = onRoom;
	hostHooks.hostLink = hostLink;
	hostHooks.joinLink = joinLink;
	hostHooks.closeLink = closeLink;
	guestHooks.user = &guestFake;
	guestHooks.onStatus = onStatus;
	guestHooks.onRoom = onRoom;
	guestHooks.hostLink = hostLink;
	guestHooks.joinLink = joinLink;
	guestHooks.closeLink = closeLink;
	host = mobileRelayCreate(hostHooks);
	guest = mobileRelayCreate(guestHooks);
	mobileRelayCreateRoom(host, "", "127.0.0.1");
	expect(waitFlag(&hostFake, codeReady, 5), "relay room code");
	snprintf(relay, sizeof(relay), "%s", hostFake.advertise);
	mobileRelayJoinRoom(guest, relay, hostFake.code);
	expect(waitFlag(&guestFake, guestReady, 8), "relay guest connected");
	expect(hostFake.ready1p, "relay host connected");
	if (hostFake.listenFd >= 0) {
#ifdef _WIN32
		fd_set set;
		struct timeval tv;
		FD_ZERO(&set);
		FD_SET((SOCKET) hostFake.listenFd, &set);
		tv.tv_sec = 2;
		tv.tv_usec = 0;
		if (select(0, &set, NULL, NULL, &tv) > 0) {
			hostFake.hostFd = (int) accept(hostFake.listenFd, NULL, NULL);
		}
#else
		struct pollfd pfd;
		pfd.fd = hostFake.listenFd;
		pfd.events = POLLIN;
		if (poll(&pfd, 1, 2000) > 0) {
			hostFake.hostFd = (int) accept(hostFake.listenFd, NULL, NULL);
		}
#endif
	}
	expect(hostFake.hostFd >= 0 && guestFake.guestFd >= 0, "relay local sockets");
	if (hostFake.hostFd >= 0 && guestFake.guestFd >= 0) {
		expect(send(hostFake.hostFd, "PING", 4, 0) == 4, "relay send");
		n = (int) recv(guestFake.guestFd, got, 4, 0);
		expect(n == 4 && memcmp(got, "PING", 4) == 0, "relay received ping");
	}
	mobileRelayDestroy(guest);
	mobileRelayDestroy(host);
	if (hostFake.hostFd >= 0) {
		test_close(hostFake.hostFd);
	}
	if (hostFake.listenFd >= 0) {
		test_close(hostFake.listenFd);
	}
	if (guestFake.guestFd >= 0) {
		test_close(guestFake.guestFd);
	}
	pthread_mutex_destroy(&hostFake.mu);
	pthread_cond_destroy(&hostFake.cv);
	pthread_mutex_destroy(&guestFake.mu);
	pthread_cond_destroy(&guestFake.cv);
}

int main(int argc, char** argv) {
	char dir[512];
#ifdef _WIN32
	WSADATA data;
	WSAStartup(MAKEWORD(2, 2), &data);
#endif
	if (argc >= 2 && strcmp(argv[1], "--join-relay") == 0) {
		fprintf(stderr, "join-relay is covered by the in-process relay test\n");
		return 2;
	}
	snprintf(dir, sizeof(dir), "%s", argc > 1 ? argv[1] : ".");
#ifdef _WIN32
	_mkdir(dir);
#else
	mkdir(dir, 0755);
#endif
	testBios();
	testResample();
	testGb(dir);
	testGba(dir);
	testAudioOut(dir);
	testLink();
	testRelay();
	if (g_failed) {
		fprintf(stderr, "mobile tests failed\n");
		return 1;
	}
	printf("mobile tests passed\n");
	return 0;
}
