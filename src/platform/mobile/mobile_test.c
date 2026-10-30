/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "link_net.h"
#include "mgba_mobile.h"
#include "remote_link.h"

#include <mgba/core/core.h>
#include <mgba/internal/arm/arm.h>
#include <mgba/internal/gba/gba.h>
#include <mgba/internal/gba/io.h>
#include <mgba/internal/gba/memory.h>
#include <mgba/internal/gba/video.h>
#include <mgba-util/vfs.h>
#include <mgba-util/image.h>

#include <fcntl.h>

/* Synthetic clock hook owned by mgba_mobile.c: 音乐原速 paces its output by
 * elapsed real time, and this test runs emulation as fast as it can. */
extern double (*mgbaMobileAudioClock)(void);

/* TEMP PROBE: IRQ 派发链路计数器（gba.c / arm.c）。 */
extern uint32_t mgbaStatTestIrq;
extern uint32_t mgbaStatIrqEvent;
extern uint32_t mgbaStatRaiseIrq;
extern uint32_t mgbaStatIrqSkipSched;
extern uint32_t mgbaStatRaiseIrqMasked;
extern uint32_t mgbaStatKeyReads;
extern uint32_t mgbaStatKeyLast;
extern uint32_t mgbaRom64Ws1Same;

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

static int copyFile(const char* from, const char* to) {
	FILE* src = fopen(from, "rb");
	FILE* dst;
	char buffer[65536];
	size_t got;
	if (!src) {
		return 0;
	}
	dst = fopen(to, "wb");
	if (!dst) {
		fclose(src);
		return 0;
	}
	while ((got = fread(buffer, 1, sizeof(buffer), src)) > 0) {
		if (fwrite(buffer, 1, got, dst) != got) {
			fclose(src);
			fclose(dst);
			return 0;
		}
	}
	fclose(src);
	fclose(dst);
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

/* A GB ROM that plays a 512 Hz square wave on channel 1 forever. */
static int writeAudioRom(const char* dir, char* path, size_t pathLen) {
	unsigned char* rom = (unsigned char*) calloc(1, 32768);
	int ok;
	if (!rom) {
		return 0;
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
	rom[0x160] = 0x3E; rom[0x161] = 0x80; rom[0x162] = 0xE0; rom[0x163] = 0x11;
	rom[0x164] = 0x3E; rom[0x165] = 0x00; rom[0x166] = 0xE0; rom[0x167] = 0x13;
	rom[0x168] = 0x3E; rom[0x169] = 0x87; rom[0x16A] = 0xE0; rom[0x16B] = 0x14;
	rom[0x16C] = 0x18; rom[0x16D] = 0xFE;
	snprintf(path, pathLen, "%s/audio.gb", dir);
	ok = writeFile(path, rom, 32768);
	free(rom);
	return ok;
}

/* Collected pitch windows are this long, measured after PITCH_SKIP_FRAMES. */
#define PITCH_WINDOW_FRAMES 16384
#define PITCH_SKIP_FRAMES 4096

/*
 * Frequency of the square wave in resampled audio. Counting sign flips is not
 * enough: the sinc interpolator rings around each edge, and the wave's own
 * period is only about a hundred samples. Rising edges alone, taken with a
 * quarter-amplitude threshold so the ringing never crosses back in, count one
 * period each.
 */
static double audioPitchHz(const int16_t* samples, int frames, int rate) {
	int peak = 0;
	int threshold;
	int above = 0;
	int cooldown = 0;
	int edges = 0;
	int i;
	for (i = 0; i < frames; ++i) {
		int value = samples[i * 2];
		if (value < 0) {
			value = -value;
		}
		if (value > peak) {
			peak = value;
		}
	}
	if (peak < 500) {
		return 0.0;
	}
	threshold = peak / 4;
	for (i = 0; i < frames; ++i) {
		int value = samples[i * 2];
		if (cooldown > 0) {
			--cooldown;
		}
		if (!above && value >= threshold) {
			if (!cooldown) {
				++edges;
				cooldown = 8;
			}
			above = 1;
		} else if (above && value <= 0) {
			above = 0;
		}
	}
	if (frames <= 0) {
		return 0.0;
	}
	return edges * (double) rate / frames;
}

/* Runs the emulator until exactly the requested output frames were collected. */
static int collectAudio(struct MgbaMobile* emu, int16_t* out, int frames, int speed, float drift) {
	int total = 0;
	int guard = 0;
	while (total < frames && guard++ < 8192) {
		int rounds = 0;
		mgbaMobileRunFrames(emu, 1);
		while (rounds++ < 16 && total < frames) {
			int got = mgbaMobileReadAudioOut(emu, out + total * 2, frames - total, speed, drift);
			if (got <= 0) {
				break;
			}
			total += got;
		}
	}
	return total;
}

/*
 * Runs gameFrames emulated frames per pump but drives the resampler at
 * audioSpeed. This is how the front end separates the fast-forward factor
 * from the audio rate: tape style passes the same 4 for both, while 不变速
 * runs the game at 4 and keeps the resampler at 1 so the music holds its own
 * pitch and the surplus samples the fast game produces are dropped.
 */
static int collectAudioSplit(struct MgbaMobile* emu, int16_t* out, int frames, int gameFrames, double audioSpeed, float drift) {
	int total = 0;
	int guard = 0;
	while (total < frames && guard++ < 8192) {
		int rounds = 0;
		mgbaMobileRunFrames(emu, gameFrames);
		while (rounds++ < 16 && total < frames) {
			int got = mgbaMobileReadAudioOut(emu, out + total * 2, frames - total, audioSpeed, drift);
			if (got <= 0) {
				break;
			}
			total += got;
		}
	}
	return total;
}

static void testAudioOut(const char* dir) {
	char path[512];
	struct MgbaMobile* emu;
	int16_t* out;
	int plain;
	int fast;
	int slow;
	int total;
	expect(writeAudioRom(dir, path, sizeof(path)), "write audio rom");
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
	// many output frames, or the playback buffer would slowly run dry. A
	// single reading can just as well be a stall (the front end was loading a
	// ROM or the system paused it), so only a slow-down that repeats for a
	// second window is followed.
	plain = drainAudio(emu, 30, out, 8192, 1, 0.0f);
	mgbaMobileSetAudioPaceFps(emu, 30.0);
	slow = drainAudio(emu, 30, out, 8192, 1, 0.0f);
	expect((double) slow / plain > 0.98 && (double) slow / plain < 1.02, "one slow window is not followed");
	mgbaMobileSetAudioPaceFps(emu, 30.0);
	slow = drainAudio(emu, 30, out, 8192, 1, 0.0f);
	expect((double) slow / plain > 1.9 && (double) slow / plain < 2.1, "half pace doubles the stream");
	// Readings inside the deadband are left to the playback buffer's drift
	// control: following them would modulate the pitch once per second.
	mgbaMobileSetAudioPaceFps(emu, 30.1);
	mgbaMobileSetAudioPaceFps(emu, 29.9);
	total = drainAudio(emu, 30, out, 8192, 1, 0.0f);
	expect((double) total / slow > 0.98 && (double) total / slow < 1.02, "jitter inside the deadband is ignored");
	// Out-of-range measurements are clamped instead of trusted: 1 fps is read
	// as the 15 fps floor, a quarter of the pace, so four times the output.
	mgbaMobileSetAudioPaceFps(emu, 1.0);
	mgbaMobileSetAudioPaceFps(emu, 1.0);
	fast = drainAudio(emu, 30, out, 8192, 1, 0.0f);
	expect((double) fast / plain > 3.8 && (double) fast / plain < 4.2, "out-of-range pace is clamped");
	mgbaMobileSetAudioPaceFps(emu, 60.0);
	mgbaMobileSetAudioPaceFps(emu, 60.0);
	total = drainAudio(emu, 30, out, 8192, 1, 0.0f);
	expect((double) total / plain > 0.98 && (double) total / plain < 1.02, "pace returns to nominal");
	plain = total;
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

/*
 * The pitch the player hears must follow the game's real speed, not the noise
 * of the front end's one-second pacing windows. A window dragged down by
 * something that is not pacing - loading a ROM takes hundreds of milliseconds
 * inside one window, the system can pause the thread, a garbage collection can
 * run - used to move the resampler ratio immediately and detune the music for
 * a second or more. Here the same readings are fed to the pace feedback while
 * the resampled square wave is measured. The first frames of a window can
 * still hold audio the resampler queued before the pace changed, so the
 * measurement skips them and reads the steady state.
 */
static void testAudioPitch(const char* dir) {
	char path[512];
	struct MgbaMobile* emu;
	int16_t* out;
	double base;
	double pitch;
	expect(writeAudioRom(dir, path, sizeof(path)), "write pitch rom");
	emu = mgbaMobileCreate(dir, dir, "test");
	expect(mgbaMobileLoad(emu, path), "load pitch rom");
	out = (int16_t*) calloc(PITCH_WINDOW_FRAMES * 2, sizeof(int16_t));
	expect(out != NULL, "pitch buffer");
	if (!out) {
		mgbaMobileDestroy(emu);
		return;
	}
	expect(mgbaMobileSetAudioOutput(emu, 48000), "pitch resampler");
	expect(collectAudio(emu, out, PITCH_WINDOW_FRAMES, 1, 0.0f) == PITCH_WINDOW_FRAMES, "pitch audio collected");
	base = audioPitchHz(out + PITCH_SKIP_FRAMES * 2, PITCH_WINDOW_FRAMES - PITCH_SKIP_FRAMES, 48000);
	printf("pitch baseline %.1f Hz\n", base);
	expect(base > 480.0 && base < 545.0, "square wave plays at its own frequency");
	// One slow window: the pitch must not move.
	mgbaMobileSetAudioPaceFps(emu, 30.0);
	collectAudio(emu, out, PITCH_WINDOW_FRAMES, 1, 0.0f);
	pitch = audioPitchHz(out + PITCH_SKIP_FRAMES * 2, PITCH_WINDOW_FRAMES - PITCH_SKIP_FRAMES, 48000);
	printf("pitch after one slow window %.1f Hz\n", pitch);
	expect(pitch > base * 0.97 && pitch < base * 1.03, "one slow window keeps the pitch");
	// A front end that stays slow is followed: the music slows down with the
	// game, like a tape played slower.
	mgbaMobileSetAudioPaceFps(emu, 30.0);
	collectAudio(emu, out, PITCH_WINDOW_FRAMES, 1, 0.0f);
	pitch = audioPitchHz(out + PITCH_SKIP_FRAMES * 2, PITCH_WINDOW_FRAMES - PITCH_SKIP_FRAMES, 48000);
	printf("pitch at sustained half pace %.1f Hz\n", pitch);
	expect(pitch > base * 0.45 && pitch < base * 0.55, "sustained half pace halves the pitch");
	// Back at full speed: two windows of readings and the pitch returns.
	mgbaMobileSetAudioPaceFps(emu, 59.73);
	mgbaMobileSetAudioPaceFps(emu, 59.73);
	collectAudio(emu, out, PITCH_WINDOW_FRAMES, 1, 0.0f);
	pitch = audioPitchHz(out + PITCH_SKIP_FRAMES * 2, PITCH_WINDOW_FRAMES - PITCH_SKIP_FRAMES, 48000);
	printf("pitch after recovery %.1f Hz\n", pitch);
	expect(pitch > base * 0.97 && pitch < base * 1.03, "pitch returns at full speed");
	// Loading a game resets the feedback: a reading from just before the load
	// must not combine with one from after it to look like a confirmed change,
	// or a slow window around a ROM change would detune the new game.
	mgbaMobileSetAudioPaceFps(emu, 30.0);
	expect(mgbaMobileLoad(emu, path), "reload pitch rom");
	mgbaMobileSetAudioPaceFps(emu, 30.0);
	collectAudio(emu, out, PITCH_WINDOW_FRAMES, 1, 0.0f);
	pitch = audioPitchHz(out + PITCH_SKIP_FRAMES * 2, PITCH_WINDOW_FRAMES - PITCH_SKIP_FRAMES, 48000);
	printf("pitch after reload %.1f Hz\n", pitch);
	expect(pitch > base * 0.97 && pitch < base * 1.03, "reload drops a pending pace change");
	free(out);
	mgbaMobileDestroy(emu);
}

/*
 * 不变速 (constant pitch) fast-forward. The game runs at 4x but the resampler
 * is still driven at 1x: the music must keep its own pitch while the surplus
 * samples the fast game produces are dropped. Tape style - the resampler
 * following the game at 4x - must still pitch the music up by 4.
 */
static void testAudioConstPitch(const char* dir) {
	char path[512];
	struct MgbaMobile* emu;
	int16_t* out;
	double base;
	double pitch;
	expect(writeAudioRom(dir, path, sizeof(path)), "write const pitch rom");
	emu = mgbaMobileCreate(dir, dir, "test");
	expect(mgbaMobileLoad(emu, path), "load const pitch rom");
	out = (int16_t*) calloc(PITCH_WINDOW_FRAMES * 2, sizeof(int16_t));
	expect(out != NULL, "const pitch buffer");
	if (!out) {
		mgbaMobileDestroy(emu);
		return;
	}
	expect(mgbaMobileSetAudioOutput(emu, 48000), "const pitch resampler");
	// The front end always paces at the console frame rate, no matter how
	// many emulated frames each slice runs.
	mgbaMobileSetAudioPaceFps(emu, 59.73);
	expect(collectAudio(emu, out, PITCH_WINDOW_FRAMES, 1, 0.0f) == PITCH_WINDOW_FRAMES, "const pitch baseline collected");
	base = audioPitchHz(out + PITCH_SKIP_FRAMES * 2, PITCH_WINDOW_FRAMES - PITCH_SKIP_FRAMES, 48000);
	printf("const pitch baseline %.1f Hz\n", base);
	expect(base > 480.0 && base < 545.0, "square wave at its own frequency");

	// Tape style: game at 4x and the resampler following it -> 4x pitch.
	mgbaMobileSetAudioPaceFps(emu, 59.73);
	collectAudioSplit(emu, out, PITCH_WINDOW_FRAMES, 4, 4.0, 0.0f);
	pitch = audioPitchHz(out + PITCH_SKIP_FRAMES * 2, PITCH_WINDOW_FRAMES - PITCH_SKIP_FRAMES, 48000);
	printf("tape 4x pitch %.1f Hz (base %.1f)\n", pitch, base);
	expect(pitch > base * 3.2 && pitch < base * 4.8, "tape style pitches the music up 4x");

	// 不变速: game at 4x, resampler held at 1x -> the music keeps its pitch.
	mgbaMobileSetAudioPaceFps(emu, 59.73);
	collectAudioSplit(emu, out, PITCH_WINDOW_FRAMES, 4, 1.0, 0.0f);
	pitch = audioPitchHz(out + PITCH_SKIP_FRAMES * 2, PITCH_WINDOW_FRAMES - PITCH_SKIP_FRAMES, 48000);
	printf("不变速 4x pitch %.1f Hz (base %.1f)\n", pitch, base);
	expect(pitch > base * 0.85 && pitch < base * 1.15, "不变速 keeps the music at its own pitch at 4x");
	free(out);
	mgbaMobileDestroy(emu);
}

/*
 * Share of edge intervals that stray more than a quarter from the median.
 * A tune played in one continuous run has evenly spaced edges, so this stays
 * near zero; audio shredded by a ring that overflows every few milliseconds
 * still measures the right average pitch but its edges scatter, which is
 * exactly why it stops sounding like music.
 */
static double audioEdgeJitter(const int16_t* samples, int frames) {
	int peak = 0;
	int threshold;
	int above = 0;
	int cooldown = 0;
	int i;
	int count = 0;
	long prev = -1;
	static long gaps[8192];
	for (i = 0; i < frames; ++i) {
		int value = samples[i * 2];
		if (value < 0) {
			value = -value;
		}
		if (value > peak) {
			peak = value;
		}
	}
	if (peak < 500) {
		return 1.0;
	}
	threshold = peak / 4;
	for (i = 0; i < frames && count < 8192; ++i) {
		int value = samples[i * 2];
		if (cooldown > 0) {
			--cooldown;
		}
		if (!above && value >= threshold) {
			if (prev >= 0) {
				gaps[count++] = i - prev;
			}
			prev = i;
			cooldown = 8;
			above = 1;
		} else if (above && value < -threshold) {
			above = 0;
		}
	}
	if (count < 16) {
		return 1.0;
	}
	long median = gaps[count / 2];
	if (median <= 0) {
		return 1.0;
	}
	int bad = 0;
	for (i = 0; i < count; ++i) {
		long d = gaps[i] - median;
		if (d < 0) {
			d = -d;
		}
		if (d * 4 > median) {
			++bad;
		}
	}
	return (double) bad / (double) count;
}

/*
 * Models the playback loop the way a device actually runs it: the front end
 * paces at the console frame rate and the audio device drains a fixed number
 * of output frames per slice (outRate/slicesPerSec), no matter how many
 * emulated frames the game ran in that slice. Anything the game produces
 * beyond that has to be dropped somewhere, so this is the only model that
 * shows what 不变速 really sounds like - the earlier fixed-size collection
 * filled its buffer as fast as the resampler would go and therefore never
 * exercised the surplus at all.
 */
static int collectRealtimeAudio(struct MgbaMobile* emu, int16_t* out, int slices,
		int perSlice, int gameFrames, double audioSpeed) {
	int16_t* tmp = (int16_t*) calloc(8192 * 2, sizeof(int16_t));
	int total = 0;
	int slice;
	if (!tmp) {
		return 0;
	}
	for (slice = 0; slice < slices; ++slice) {
		int want = perSlice;
		int guard = 0;
		mgbaMobileRunFrames(emu, gameFrames);
		while (want > 0 && guard++ < 64) {
			int got = mgbaMobileReadAudioOut(emu, tmp, want > 8192 ? 8192 : want,
					audioSpeed, 0.0f);
			if (got <= 0) {
				break;
			}
			if (total + got > slices * perSlice) {
				got = slices * perSlice - total;
			}
			memcpy(out + total * 2, tmp, (size_t) got * 2 * sizeof(int16_t));
			total += got;
			want -= got;
		}
	}
	free(tmp);
	return total;
}

static void testAudioConstPitchRealtime(const char* dir) {
	const int OUT_RATE = 48000;
	const double SLICES_PER_SEC = 59.73;
	const int SLICES = 300;
	const int PER_SLICE = (int) (OUT_RATE / SLICES_PER_SEC) + 1;
	const int CAP = SLICES * PER_SLICE;
	char path[512];
	struct MgbaMobile* emu;
	int16_t* out;
	double base;
	double pitch;
	double shredded;
	double held;
	int total;
	expect(writeAudioRom(dir, path, sizeof(path)), "write realtime rom");
	emu = mgbaMobileCreate(dir, dir, "test");
	expect(mgbaMobileLoad(emu, path), "load realtime rom");
	out = (int16_t*) calloc((size_t) CAP * 2 + 2, sizeof(int16_t));
	expect(out != NULL, "realtime buffer");
	if (!out) {
		mgbaMobileDestroy(emu);
		return;
	}
	expect(mgbaMobileSetAudioOutput(emu, OUT_RATE), "realtime resampler");

	// 1x: one emulated frame per slice, resampler at 1.
	mgbaMobileResetAudioPace(emu);
	mgbaMobileClearAudio(emu);
	mgbaMobileSetAudioPaceFps(emu, SLICES_PER_SEC);
	total = collectRealtimeAudio(emu, out, SLICES, PER_SLICE, 1, 1.0);
	base = audioPitchHz(out, total, OUT_RATE);
	printf("realtime 1x: %d/%d frames, %.1f Hz\n", total, CAP, base);
	expect(base > 480.0 && base < 545.0, "realtime 1x plays at its own frequency");

	// Tape style: 4 emulated frames per slice, resampler following at 4.
	mgbaMobileResetAudioPace(emu);
	mgbaMobileClearAudio(emu);
	memset(out, 0, ((size_t) CAP * 2 + 2) * sizeof(int16_t));
	mgbaMobileSetAudioPaceFps(emu, SLICES_PER_SEC);
	total = collectRealtimeAudio(emu, out, SLICES, PER_SLICE, 4, 4.0);
	pitch = audioPitchHz(out, total, OUT_RATE);
	printf("realtime tape 4x: %d/%d frames, %.1f Hz (base %.1f, %.2fx)\n",
			total, CAP, pitch, base, base > 0.0 ? pitch / base : 0.0);
	expect(pitch > base * 3.2 && pitch < base * 4.8, "realtime tape 4x pitches up 4x");

	// 不变速: 4 emulated frames per slice, resampler held at 1. The surplus
	// has to be dropped, but what reaches the device must keep its pitch.
	mgbaMobileResetAudioPace(emu);
	mgbaMobileClearAudio(emu);
	memset(out, 0, ((size_t) CAP * 2 + 2) * sizeof(int16_t));
	mgbaMobileSetAudioPaceFps(emu, SLICES_PER_SEC);
	total = collectRealtimeAudio(emu, out, SLICES, PER_SLICE, 4, 1.0);
	pitch = audioPitchHz(out, total, OUT_RATE);
	printf("realtime 不变速 4x: %d/%d frames, %.1f Hz (base %.1f, %.2fx), jitter %.3f\n",
			total, CAP, pitch, base, base > 0.0 ? pitch / base : 0.0,
			audioEdgeJitter(out, total));
	expect(pitch > base * 0.85 && pitch < base * 1.15, "realtime 不变速 4x keeps the pitch");
	shredded = audioEdgeJitter(out, total);

	// Same again with the surplus time-stretched (WSOLA) instead of dropped:
	// the pitch is unchanged and the music plays continuously at its own tempo,
	// covering the whole track (no section skipped).
	mgbaMobileResetAudioPace(emu);
	mgbaMobileSetAudioConstantPitch(emu, true, 4.0);
	mgbaMobileClearAudio(emu);
	memset(out, 0, ((size_t) CAP * 2 + 2) * sizeof(int16_t));
	mgbaMobileSetAudioPaceFps(emu, SLICES_PER_SEC);
	total = collectRealtimeAudio(emu, out, SLICES, PER_SLICE, 4, 1.0);
	pitch = audioPitchHz(out, total, OUT_RATE);
	held = audioEdgeJitter(out, total);
	printf("realtime 不变速 4x WSOLA: %d/%d frames, %.1f Hz (%.2fx), jitter %.3f (scatter was %.3f)\n",
			total, CAP, pitch, base > 0.0 ? pitch / base : 0.0, held, shredded);
	expect(pitch > base * 0.85 && pitch < base * 1.15, "WSOLA 不变速 4x keeps the pitch");
	expect(total >= CAP * 0.8, "WSOLA 不变速 4x plays the whole track (no 3/4 dropped)");
	expect(held < 0.10 && held < shredded * 0.7,
			"WSOLA 不变速 4x is far more continuous than the shredded path (no section jump)");
	mgbaMobileAudioClock = NULL;
	mgbaMobileSetAudioConstantPitch(emu, false, 1.0);
	free(out);
	mgbaMobileDestroy(emu);
}

/*
 * Models the Android front end's audio pump as closely as it can be modelled
 * off-device, because the differences matter:
 *
 *  - pumpAudio() asks for a large fixed block (AUDIO_READ_FRAMES = 8192) and
 *    drains up to eight of those, stopping at the first short one.
 *  - The emulation loop splits a slice into steps of AUDIO_STEP_FRAMES = 4
 *    game frames and pumps after each step, so at 16x a slice feeds the
 *    stretcher four small bursts instead of one big one.
 *  - syncFastAudio() runs at the top of every slice and republishes the mode,
 *    so mgbaMobileSetAudioConstantPitch() is called about 60 times a second.
 *
 * That last one is fatal if it arms a clear: the next read then throws away
 * the parked input and the analysis cursor, and at 16x the stretcher - which
 * needs Ha + N samples before it can emit even one hop - never accumulates
 * enough input to keep up, so the music comes out chopped.
 */

/* One pumpAudio() call. */
static void devicePump(struct MgbaMobile* emu, int16_t* out, int* total, int cap,
		int16_t* tmp, double audioSpeed, int64_t* delivered) {
	int round;
	for (round = 0; round < 8; ++round) {
		int got = mgbaMobileReadAudioOut(emu, tmp, 8192, audioSpeed, 0.0f);
		if (got <= 0) {
			break;
		}
		*delivered += got;
		if (*total < cap) {
			int keep = got;
			if (*total + keep > cap) {
				keep = cap - *total;
			}
			memcpy(out + *total * 2, tmp, (size_t) keep * 2 * sizeof(int16_t));
			*total += keep;
		}
		if (got < 8192) {
			break;
		}
	}
}

/* One paced slice: run gameFrames in steps of four (AUDIO_STEP_FRAMES), pumping
 * after each step exactly like the emulation loop does. */
static void deviceSlice(struct MgbaMobile* emu, int gameFrames, int16_t* out, int* total,
		int cap, int16_t* tmp, double audioSpeed, int64_t* delivered) {
	int done = 0;
	int step = (gameFrames + 3) / 4;
	while (done < gameFrames) {
		int n = gameFrames - done;
		if (n > step) {
			n = step;
		}
		mgbaMobileRunFrames(emu, n);
		devicePump(emu, out, total, cap, tmp, audioSpeed, delivered);
		done += n;
	}
}

static void testAudioConstPitchDevicePump(const char* dir) {
	const int OUT_RATE = 48000;
	const double SLICES_PER_SEC = 59.73;
	const int SLICES = 300;
	const int PER_SLICE = (int) (OUT_RATE / SLICES_PER_SEC) + 1;
	const int CAP = SLICES * PER_SLICE;
	const int BLOCK = 8192;      /* EmulatorActivity.AUDIO_READ_FRAMES */
	static const double STRETCHES[] = { 4.0, 16.0 };
	char path[512];
	struct MgbaMobile* emu;
	int16_t* out;
	int16_t* tmp;
	double base;
	int s;

	expect(writeAudioRom(dir, path, sizeof(path)), "write device-pump rom");
	emu = mgbaMobileCreate(dir, dir, "test");
	expect(mgbaMobileLoad(emu, path), "load device-pump rom");
	out = (int16_t*) calloc((size_t) CAP * 2 + 2, sizeof(int16_t));
	tmp = (int16_t*) calloc((size_t) BLOCK * 2, sizeof(int16_t));
	expect(out != NULL && tmp != NULL, "device-pump buffers");
	if (!out || !tmp) {
		free(out);
		free(tmp);
		mgbaMobileDestroy(emu);
		return;
	}
	expect(mgbaMobileSetAudioOutput(emu, OUT_RATE), "device-pump resampler");

	/* Baseline at 1x with the same block size and pump rhythm. */
	mgbaMobileResetAudioPace(emu);
	mgbaMobileClearAudio(emu);
	mgbaMobileSetAudioPaceFps(emu, SLICES_PER_SEC);
	{
		int total = 0;
		int64_t delivered = 0;
		int slice;
		for (slice = 0; slice < SLICES; ++slice) {
			deviceSlice(emu, 1, out, &total, CAP, tmp, 1.0, &delivered);
		}
		base = audioPitchHz(out, total, OUT_RATE);
		printf("device pump 1x: %d/%d frames, %.1f Hz\n", total, CAP, base);
		expect(base > 480.0 && base < 545.0, "device pump 1x plays at its own frequency");
	}

	for (s = 0; s < (int) (sizeof(STRETCHES) / sizeof(STRETCHES[0])); ++s) {
		double stretch = STRETCHES[s];
		int gameFrames = (int) stretch;
		int total = 0;
		int64_t delivered = 0;
		int slice;
		int firstSec = 0;
		double pitch;
		double head;
		size_t dropped;
		char what[128];

		/* 1) Fast-forward on the tape path first. This is the usual state
		 *    before the user ticks 不变速, and it leaves the device-throughput
		 *    memory holding a reading taken at this multiplier. */
		mgbaMobileSetAudioConstantPitch(emu, false, 1.0);
		mgbaMobileResetAudioPace(emu);
		mgbaMobileClearAudio(emu);
		mgbaMobileSetAudioPaceFps(emu, SLICES_PER_SEC);
		{
			int throwaway = 0;
			int64_t tapeDelivered = 0;
			for (slice = 0; slice < 90; ++slice) {
				deviceSlice(emu, gameFrames, out, &throwaway, 0, tmp, stretch, &tapeDelivered);
				if (slice == 0) {
					/* One feedback window: locks the pace and stores the
					 * throughput at this speed. */
					mgbaMobileSetAudioPaceFps(emu, SLICES_PER_SEC);
				}
			}
		}

		/* 2) The user ticks 不变速 mid fast-forward. The front end drops the
		 *    pace estimate (resetAudio) but the throughput memory survives,
		 *    and no fresh reading arrives for a whole second. */
		mgbaMobileSetAudioConstantPitch(emu, true, stretch);
		mgbaMobileResetAudioPace(emu);
		mgbaMobileClearAudio(emu);
		memset(out, 0, ((size_t) CAP * 2 + 2) * sizeof(int16_t));
		for (slice = 0; slice < SLICES; ++slice) {
			/* syncFastAudio() republishes the mode on every slice. */
			mgbaMobileSetAudioConstantPitch(emu, true, stretch);
			deviceSlice(emu, gameFrames, out, &total, CAP, tmp, 1.0, &delivered);
			if (slice == 59) {
				firstSec = total;
				mgbaMobileSetAudioPaceFps(emu, SLICES_PER_SEC);
			}
		}
		pitch = audioPitchHz(out, total, OUT_RATE);
		head = audioPitchHz(out, firstSec, OUT_RATE);
		dropped = mgbaMobileWsolaDropped(emu);
		printf("device pump 不变速 %.0fx WSOLA: %d/%d frames (delivered %lld), %.1f Hz (%.2fx),"
				" first second %.1f Hz (%.2fx), dropped %zu\n",
				stretch, total, CAP, (long long) delivered, pitch,
				base > 0.0 ? pitch / base : 0.0, head, base > 0.0 ? head / base : 0.0, dropped);

		snprintf(what, sizeof(what), "device pump WSOLA %.0fx keeps the pitch", stretch);
		expect(pitch > base * 0.85 && pitch < base * 1.15, what);
		snprintf(what, sizeof(what), "device pump WSOLA %.0fx keeps the pitch right after the toggle", stretch);
		expect(head > base * 0.85 && head < base * 1.15, what);
		snprintf(what, sizeof(what), "device pump WSOLA %.0fx keeps up with the device", stretch);
		expect(total >= CAP * 0.85, what);
		snprintf(what, sizeof(what), "device pump WSOLA %.0fx never discards a synthesis hop", stretch);
		expect(dropped == 0, what);
	}

	mgbaMobileSetAudioConstantPitch(emu, false, 1.0);
	free(out);
	free(tmp);
	mgbaMobileDestroy(emu);
}

/* Largest single-sample step in a stream. A hard splice between two unrelated
 * sections of music lands as a near full-scale step - the click; a cross-fade
 * does not. */
static int audioMaxStep(const int16_t* buf, int frames) {
	int worst = 0;
	int i;
	for (i = 1; i < frames; ++i) {
		int c;
		for (c = 0; c < 2; ++c) {
			int d = (int) buf[i * 2 + c] - (int) buf[(i - 1) * 2 + c];
			if (d < 0) {
				d = -d;
			}
			if (d > worst) {
				worst = d;
			}
		}
	}
	return worst;
}

/*
 * 音乐原速 (MOBILE_AUDIO_HOLD_NATIVE): the score plays at its own tempo and
 * pitch - exactly what 1x emits - and the sections in between are skipped.
 *
 * The skip is not optional: at 4x the console hands over four seconds of music
 * per second of real time while the speaker can emit one. What can be checked
 * without ears is that the pitch is the 1x pitch, that the stream never breaks
 * up, and that the splices do not step the waveform hard enough to click.
 */
/* 音乐原速 hands audio out by elapsed real time, but this test runs emulation
 * as fast as it can - no wall time passes between reads. The synthetic clock
 * below advances one slice per deviceSlice() call site, so every read inside a
 * slice sees the same timestamp and the hold's output budget accrues from real
 * elapsed time only - exactly what the device does. (Advancing per readAudioOut
 * call instead over-credits the budget once the harness pumps per 4-frame step:
 * at 4x the credited budget then matches production, no surplus ever piles up,
 * and the test cannot see the cutting policy at all.) */
static double g_fakeAudioNow;

static double fakeAudioClock(void) {
	return g_fakeAudioNow;
}

/* One slice of wall time, called where deviceSlice() models one front-end tick. */
static void advanceFakeSlice(void) {
	g_fakeAudioNow += 1.0 / 59.73;
}

static void testAudioNativeHold(const char* dir) {
	const int OUT_RATE = 48000;
	const double SLICES_PER_SEC = 59.73;
	const int SLICES = 300;
	const int PER_SLICE = (int) (OUT_RATE / SLICES_PER_SEC) + 1;
	const int CAP = SLICES * PER_SLICE;
	const int BLOCK = 8192;
	static const double STRETCHES[] = { 4.0, 16.0 };
	char path[512];
	struct MgbaMobile* emu;
	int16_t* out;
	int16_t* tmp;
	int16_t* baseline;
	double base;
	int baseStep = 0;
	int baseFrames = 0;
	int s;

	expect(writeAudioRom(dir, path, sizeof(path)), "write native-hold rom");
	emu = mgbaMobileCreate(dir, dir, "test");
	expect(mgbaMobileLoad(emu, path), "load native-hold rom");
	out = (int16_t*) calloc((size_t) CAP * 2 + 2, sizeof(int16_t));
	tmp = (int16_t*) calloc((size_t) BLOCK * 2, sizeof(int16_t));
	baseline = (int16_t*) calloc((size_t) CAP * 2 + 2, sizeof(int16_t));
	expect(out != NULL && tmp != NULL && baseline != NULL, "native-hold buffers");
	if (!out || !tmp || !baseline) {
		free(out);
		free(tmp);
		free(baseline);
		mgbaMobileDestroy(emu);
		return;
	}
	expect(mgbaMobileSetAudioOutput(emu, OUT_RATE), "native-hold resampler");
	g_fakeAudioNow = 0.0;
	mgbaMobileAudioClock = fakeAudioClock;

	mgbaMobileResetAudioPace(emu);
	mgbaMobileClearAudio(emu);
	mgbaMobileSetAudioPaceFps(emu, SLICES_PER_SEC);
	{
		int total = 0;
		int64_t delivered = 0;
		int slice;
		for (slice = 0; slice < SLICES; ++slice) {
			advanceFakeSlice();
			deviceSlice(emu, 1, baseline, &total, CAP, tmp, 1.0, &delivered);
		}
		baseFrames = total;
		base = audioPitchHz(baseline, total, OUT_RATE);
		baseStep = audioMaxStep(baseline, total);
		printf("native hold 1x baseline: %d/%d frames, %.1f Hz, max step %d\n",
				total, CAP, base, baseStep);
	}

	for (s = 0; s < (int) (sizeof(STRETCHES) / sizeof(STRETCHES[0])); ++s) {
		double stretch = STRETCHES[s];
		int gameFrames = (int) stretch;
		int total = 0;
		int64_t delivered = 0;
		int slice;
		double pitch;
		int step;
		size_t dropped;
		size_t cuts;
		char what[128];

		/* Leave the throughput memory holding a tape reading, as a user who
		 * fast-forwards first and then ticks 音乐原速 would. */
		mgbaMobileSetAudioHoldMode(emu, 0);
		mgbaMobileSetAudioConstantPitch(emu, false, 1.0);
		mgbaMobileResetAudioPace(emu);
		mgbaMobileClearAudio(emu);
		mgbaMobileSetAudioPaceFps(emu, SLICES_PER_SEC);
		{
			int throwaway = 0;
			int64_t tapeDelivered = 0;
			for (slice = 0; slice < 90; ++slice) {
				advanceFakeSlice();
				deviceSlice(emu, gameFrames, out, &throwaway, 0, tmp, stretch, &tapeDelivered);
				if (slice == 0) {
					mgbaMobileSetAudioPaceFps(emu, SLICES_PER_SEC);
				}
			}
		}

		mgbaMobileSetAudioHoldMode(emu, 1);
		mgbaMobileSetAudioConstantPitch(emu, true, stretch);
		mgbaMobileResetAudioPace(emu);
		mgbaMobileClearAudio(emu);
		memset(out, 0, ((size_t) CAP * 2 + 2) * sizeof(int16_t));
		for (slice = 0; slice < SLICES; ++slice) {
			/* syncFastAudio() republishes the mode on every slice. */
			mgbaMobileSetAudioConstantPitch(emu, true, stretch);
			advanceFakeSlice();
			deviceSlice(emu, gameFrames, out, &total, CAP, tmp, 1.0, &delivered);
			if (slice == 59) {
				mgbaMobileSetAudioPaceFps(emu, SLICES_PER_SEC);
			}
		}
		pitch = audioPitchHz(out, total, OUT_RATE);
		step = audioMaxStep(out, total);
		dropped = mgbaMobileWsolaDropped(emu);
		cuts = mgbaMobileNativeHoldCuts(emu);
		printf("native hold 音乐原速 %.0fx: %d/%d frames (delivered %lld), %.1f Hz (%.2fx),"
				" max step %d (1x %d), dropped %zu, cuts %zu\n",
				stretch, total, CAP, (long long) delivered, pitch,
				base > 0.0 ? pitch / base : 0.0, step, baseStep, dropped, cuts);

		snprintf(what, sizeof(what), "音乐原速 %.0fx plays at the 1x pitch", stretch);
		expect(pitch > base * 0.85 && pitch < base * 1.15, what);
		snprintf(what, sizeof(what), "音乐原速 %.0fx keeps up with the device", stretch);
		expect(total >= CAP * 0.85, what);
		snprintf(what, sizeof(what), "音乐原速 %.0fx plays without a click", stretch);
		expect(step < baseStep * 2 + 2000, what);
		/* The surplus must leave in whole section cuts, a couple per second at
		 * most - shaving it frame-by-frame (the first implementation) re-samples
		 * the tune at 1/stretch and plays it back at the fast-forward rate, with
		 * a cut after every pump. 4x expects ~2 cuts in 5 s, 16x ~15. */
		snprintf(what, sizeof(what), "音乐原速 %.0fx cuts sections, not frames (%zu cuts)", stretch, cuts);
		expect(cuts >= 1 && cuts <= (stretch > 8.0 ? 90 : 12), what);
	}
	(void) baseFrames;

	mgbaMobileSetAudioConstantPitch(emu, false, 1.0);
	mgbaMobileSetAudioHoldMode(emu, 0);
	free(out);
	free(tmp);
	free(baseline);
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

/*
 * 连点B (turbo B) against a real game.
 *
 * Two front-end features drive the same key: the dedicated 连发 key on screen
 * pulses B into the held keys, and the hold-B auto-turbo arms at the same time
 * and pulses B through the core's turbo mask. While both are active the key
 * must still come up on the turbo's off frames - if it does not, the game sees
 * B held on every frame, and a game that runs while B is held never lets go
 * (跑步卡死).
 *
 * The key state is read back through the console's own key register, so what
 * is checked is exactly what the game sees.
 */
#define TURBO_B_BIT (1u << 1)

/* What the front end publishes as held on frame i, per scenario. */
#define TURBO_PULSE 0
#define TURBO_HOLD 1
#define TURBO_NONE 2

struct TurboTrace {
	int pressed;
	int released;
	int stuck;
	int maxStuck;
};

static uint32_t turboHeldMask(int scenario, int i) {
	if (scenario == TURBO_PULSE) {
		/* The 连发 key pulses B into the held keys on its own cadence. */
		return (i & 1) ? TURBO_B_BIT : 0u;
	}
	if (scenario == TURBO_HOLD) {
		return TURBO_B_BIT;
	}
	return 0u;
}

static void turboTraceRun(struct MgbaMobile* emu, struct TurboTrace* trace, int scenario, int frames, int printFirst) {
	int i;
	for (i = 0; i < frames; ++i) {
		mgbaMobileSetKeys(emu, turboHeldMask(scenario, i));
		mgbaMobileRunFrames(emu, 1);
		/* B is bit 1 of the active-low key register: clear means pressed. */
		uint16_t keys = mgbaMobileLastKeys(emu);
		if (keys & TURBO_B_BIT) {
			++trace->released;
			trace->stuck = 0;
		} else {
			++trace->pressed;
			++trace->stuck;
			if (trace->stuck > trace->maxStuck) {
				trace->maxStuck = trace->stuck;
			}
		}
		if (printFirst > 0) {
			printf("  frame %3d: B %s (reg 0x%04X)\n", i, (keys & TURBO_B_BIT) ? "up  " : "down", keys);
			--printFirst;
		}
	}
}

static void testTurboB(const char* dir) {
	const char* romPath = getenv("MGBA_TEST_ROM");
	char path[512];
	struct MgbaMobile* emu;
	struct TurboTrace trace;
	if (!romPath) {
		romPath = "D:/gen8/rom.gba";
	}
	snprintf(path, sizeof(path), "%s/turbo_rom.gba", dir);
	/* Copy the ROM next to the test so a run can never touch a real save
	 * file sitting next to the original. */
	if (!copyFile(romPath, path)) {
		printf("skip turboB: no rom at %s\n", romPath);
		return;
	}
	emu = mgbaMobileCreate(dir, dir, "test");
	expect(emu != NULL, "turboB create emu");
	if (!emu) {
		return;
	}
	expect(mgbaMobileLoad(emu, path), "turboB load rom");
	printf("turboB rom %s\n", path);

	/*
	 * The 连点B case: the 连发 key pulses B into the held keys while the
	 * hold-B auto-turbo is armed and pulses B through the core's turbo mask.
	 * B has to come up on the turbo's off frames, otherwise the game sees it
	 * held on every frame and the character runs forever (跑步卡死).
	 */
	memset(&trace, 0, sizeof(trace));
	mgbaMobileSetTurbo(emu, TURBO_B_BIT);
	turboTraceRun(emu, &trace, TURBO_PULSE, 240, 12);
	mgbaMobileSetTurbo(emu, 0);
	printf("turboB 连点B: pressed=%d released=%d longestHeldRun=%d\n", trace.pressed, trace.released, trace.maxStuck);
	expect(trace.released > 0, "turboB: B is released on the turbo off frames");
	expect(trace.pressed > 0, "turboB: B is pressed on the turbo on frames");
	expect(trace.maxStuck < 240, "turboB: B is not pinned on for every frame");

	/* Only the 连发 key, no auto-turbo: B still pulses on the key's cadence. */
	memset(&trace, 0, sizeof(trace));
	turboTraceRun(emu, &trace, TURBO_PULSE, 60, 0);
	printf("turboB 连发键: pressed=%d released=%d\n", trace.pressed, trace.released);
	expect(trace.pressed > 0 && trace.released > 0, "turboB: the 连发 key alone pulses B");

	/* A plain held B stays down on every frame. */
	memset(&trace, 0, sizeof(trace));
	turboTraceRun(emu, &trace, TURBO_HOLD, 60, 0);
	printf("turboB 按住B: pressed=%d released=%d\n", trace.pressed, trace.released);
	expect(trace.pressed == 60 && trace.released == 0, "turboB: a held B stays down");

	/* And letting go brings it up again and keeps it up (松开即停). */
	memset(&trace, 0, sizeof(trace));
	turboTraceRun(emu, &trace, TURBO_NONE, 60, 0);
	printf("turboB 松手: pressed=%d released=%d\n", trace.pressed, trace.released);
	expect(trace.released == 60 && trace.pressed == 0, "turboB: releasing B lets it up for good");

	mgbaMobileDestroy(emu);
}

/*
 * Oversized romhacks (64 MiB) reach their second half through the WS1 window
 * at 0x0A000000, which is what the 64M hack scene and My Boy both do. A plain
 * 32 MiB image has to keep mirroring WS0 there, so the two cases are checked
 * side by side: the window is only "the second half" when the file really is
 * bigger than the 32 MiB the GBA bus maps through WS0.
 */
static unsigned char rom64Byte(size_t offset) {
	return (unsigned char) (0x5A ^ ((offset >> 16) & 0xFF) ^ (offset & 0xFF));
}

static int writePatternedRom(const char* path, size_t size) {
	unsigned char* img = (unsigned char*) malloc(size);
	int ok;
	size_t i;
	if (!img) {
		return 0;
	}
	for (i = 0; i < size; ++i) {
		img[i] = rom64Byte(i);
	}
	/* A minimal GBA header so the loader treats the image as a cartridge. */
	memset(img, 0, 0x200);
	img[0] = 0x04;
	img[3] = 0xEA; /* b 0x10 */
	memcpy(img + 0xA0, "MGBAROM64", 9);
	memcpy(img + 0xAC, "ATST", 4); /* not 'M': not a Classic NES/Matrix image */
	ok = writeFile(path, img, size);
	free(img);
	return ok;
}

/* Loads an image through the real core so every init path runs, and hands
 * back the GBA board so the bus can be probed directly. */
static struct GBA* loadRomForBusTest(const char* path, struct mCore** outCore) {
	struct mCore* core = mCoreCreate(mPLATFORM_GBA);
	if (!core) {
		return NULL;
	}
	core->init(core);
	if (!mCoreLoadFile(core, path)) {
		core->deinit(core);
		return NULL;
	}
	*outCore = core;
	return (struct GBA*) core->board;
}

static void unloadRomForBusTest(struct mCore* core) {
	core->deinit(core);
}

static void testRom64(const char* dir) {
	char path[512];
	struct mCore* core = NULL;
	struct GBA* gba;
	int cycles = 0;
	uint32_t lo, hi, mirror, word, wantWord;

	/* 64 MiB: WS0 is the first half, WS1 the second, WS2 mirrors WS0. */
	snprintf(path, sizeof(path), "%s/rom64.gba", dir);
	expect(writePatternedRom(path, 0x04000000), "write 64MB rom");
	gba = loadRomForBusTest(path, &core);
	expect(gba != NULL, "load 64MB rom");
	if (!gba) {
		return;
	}
	expect(gba->memory.romSize == 0x04000000u, "64MB rom keeps its whole image");
	expect(gba->memory.romMask == 0x03FFFFFFu, "64MB rom mask spans both halves");
	if (gba->cpu) {
		lo = GBALoad8(gba->cpu, 0x08001234u, &cycles);
		hi = GBALoad8(gba->cpu, 0x0A001234u, &cycles);
		mirror = GBALoad8(gba->cpu, 0x0C001234u, &cycles);
		expect(lo == rom64Byte(0x1234), "WS0 reads the first 32 MiB");
		expect(hi == rom64Byte(0x02000000u + 0x1234u), "WS1 reads the second 32 MiB");
		expect(mirror == lo, "WS2 still mirrors WS0");
		word = GBALoad32(gba->cpu, 0x0A001000u, &cycles);
		wantWord = rom64Byte(0x02001000u) | (rom64Byte(0x02001001u) << 8) |
		           (rom64Byte(0x02001002u) << 16) | ((uint32_t) rom64Byte(0x02001003u) << 24);
		expect(word == wantWord, "a WS1 word lands in the second 32 MiB");
	}
	unloadRomForBusTest(core);
	core = NULL;
	remove(path);

	/* An oversized image that is not a power of two is padded up, not clipped. */
	snprintf(path, sizeof(path), "%s/rom33.gba", dir);
	expect(writePatternedRom(path, 0x02100000), "write 33MB rom");
	gba = loadRomForBusTest(path, &core);
	expect(gba != NULL, "load 33MB rom");
	if (!gba) {
		return;
	}
	expect(gba->memory.romSize == 0x04000000u, "33MB rom is padded up to 64 MiB");
	expect(gba->memory.romMask == 0x03FFFFFFu, "33MB rom mask covers the padded image");
	if (gba->cpu) {
		expect(GBALoad8(gba->cpu, 0x0A001234u, &cycles) == rom64Byte(0x02000000u + 0x1234u),
		       "the padded 33MB rom still reads through WS1");
		expect(GBALoad8(gba->cpu, 0x0B000000u, &cycles) == 0xFF,
		       "past the end of a padded rom reads as open bus 0xFF");
	}
	unloadRomForBusTest(core);
	core = NULL;
	remove(path);

	/* 32 MiB: unchanged behaviour, WS1 mirrors WS0. */
	snprintf(path, sizeof(path), "%s/rom32.gba", dir);
	expect(writePatternedRom(path, 0x02000000), "write 32MB rom");
	gba = loadRomForBusTest(path, &core);
	expect(gba != NULL, "load 32MB rom");
	if (!gba) {
		return;
	}
	expect(gba->memory.romSize == 0x02000000u, "32MB rom size");
	expect(gba->memory.romMask == 0x01FFFFFFu, "32MB rom mask");
	if (gba->cpu) {
		lo = GBALoad8(gba->cpu, 0x08001234u, &cycles);
		hi = GBALoad8(gba->cpu, 0x0A001234u, &cycles);
		expect(lo == rom64Byte(0x1234), "32MB WS0 reads the rom");
		expect(hi == lo, "32MB WS1 mirrors WS0");
	}
	unloadRomForBusTest(core);
	core = NULL;
	remove(path);
}

/* TEMP RENDER PROBE (rom64): deterministically run a real ROM for many frames
 * and report how many framebuffer pixels are non-black at the title and after
 * pressing START then A. Used to settle whether "black screen" is a mapping
 * regression or just an animation/cut-scene timing issue on-device. */
static int _rom64NonBlack(mColor* b) {
	int c = 0;
	for (int i = 0; i < 240 * 160; ++i) {
		uint32_t p = b[i];
		if ((p & 0xFFFFFFu) != 0) {
			++c;
		}
	}
	return c;
}

static int _rom64Diff(mColor* a, mColor* b) {
	int c = 0;
	for (int i = 0; i < 240 * 160; ++i) {
		if (a[i] != b[i]) {
			++c;
		}
	}
	return c;
}

static void _rom64Run(struct mCore* core, uint32_t keys, int frames) {
	core->setKeys(core, keys);
	for (int i = 0; i < frames; ++i) {
		core->runFrame(core);
	}
	core->setKeys(core, 0);
}

static void testRom64Render(const char* rompath) {
	struct mCore* core = mCoreCreate(mPLATFORM_GBA);
	if (!core) {
		fprintf(stderr, "render: no core\n");
		return;
	}
	if (!core->init(core)) {
		fprintf(stderr, "render: init failed\n");
		return;
	}
	mCoreInitConfig(core, "probe");
	mCoreConfigSetOverrideIntValue(&core->config, "skipBios", 1);
	mCoreConfigSetOverrideIntValue(&core->config, "useBios", 0);
	mCoreConfigSetOverrideIntValue(&core->config, "audioSync", 0);
	mCoreConfigSetOverrideIntValue(&core->config, "videoSync", 0);
	mCoreConfigSetOverrideIntValue(&core->config, "frameskip", 0);
	mCoreConfigSetOverrideIntValue(&core->config, "volume", 0x100);
	if (!mCoreLoadFile(core, rompath)) {
		fprintf(stderr, "render: load failed: %s\n", rompath);
		core->deinit(core);
		return;
	}
	mColor* buf = (mColor*) calloc((size_t) 240 * 160, sizeof(mColor));
	mColor* prev = (mColor*) calloc((size_t) 240 * 160, sizeof(mColor));
	core->setVideoBuffer(core, buf, 240);
	core->reset(core);

	struct GBA* g = (struct GBA*) core->board;
	/* P_MIRROR=1: 让 WS1 退回 32MB 镜像语义，用于判断上半段数据是否相关。 */
	if (getenv("P_MIRROR")) {
		g->memory.romMask = 0x01FFFFFF;
		fprintf(stderr, "render: forcing 32MB mirror mask\n");
	}
	fprintf(stderr, "render: %s romSize=%08zX romMask=%08X savedata=%d hwdev=%02X unl=%d matrix=%zu vba=%d idle=%d\n", rompath,
	        g->memory.romSize, g->memory.romMask, (int) g->memory.savedata.type, g->memory.hw.devices,
	        (int) g->memory.unl.type, g->memory.matrix.size, (int) g->vbaBugCompat, (int) g->idleOptimization);

	FILE* fp;
#define DUMPFB(name) do { if ((fp = fopen(name, "wb"))) { fwrite(buf, sizeof(mColor), 240 * 160, fp); fclose(fp); } } while (0)

	/* 1) 跑到标题画面 */
	_rom64Run(core, 0, 800);
	fprintf(stderr, "render: TITLE nonblack=%d/38400\n", _rom64NonBlack(buf));
	DUMPFB("fb_title.raw");

	/* 2) START 进入自制主菜单 */
	_rom64Run(core, 1u << 3, 2);
	_rom64Run(core, 0, 60);
	fprintf(stderr, "render: MENU nonblack=%d/38400\n", _rom64NonBlack(buf));
	DUMPFB("fb_menu.raw");

	/* 3) A 选中第一项「从头开始」 */
	mgbaPcSampleMask = 0;
	mgbaPcSampleReset();
	mgbaIrqHandlerHits = 0;
	mgbaPcSampleOn = 1;
	_rom64Run(core, 1u << 0, 2);
	for (int i = 0; i < 40; ++i) {
		core->runFrame(core);
	}
	mgbaPcSampleOn = 0;
	fprintf(stderr, "render: --- PC profile right after NEW GAME ---\n");
	mgbaPcSampleDump(30);
	fprintf(stderr, "render: --- selected NEW GAME, observing ---\n");

	/* 4) 观察 30 秒游戏时间，期间不按键（让过场自己走） */
	for (int s = 0; s < 30; ++s) {
		memcpy(prev, buf, (size_t) 240 * 160 * sizeof(mColor));
		_rom64Run(core, 0, 60);
		int nb = _rom64NonBlack(buf);
		int dl = _rom64Diff(buf, prev);
		uint32_t pc = g->cpu->gprs[15];
		if (s < 8 || s % 5 == 4) {
			fprintf(stderr, "render: t=%2ds nonblack=%5d delta=%5d pc=%08X gpio=%u/%04X\n", s + 1, nb, dl, pc,
			        mgbaGpioWrites, mgbaGpioLastValue);
		}
		if (s == 0 || s == 1 || s == 2 || s == 4 || s == 9 || s == 19 || s == 29) {
			char nm[64];
			snprintf(nm, sizeof(nm), "fb_t%02d.raw", s + 1);
			DUMPFB(nm);
		}
		if (s == 4) {
			GBARom64ProbeDump();
			/* 校验启动时从 0x0B132D7C 拷进 IWRAM 的 IRQ 处理器是否与 ROM 一致。 */
			{
				int bad = 0;
				int k;
				fprintf(stderr, "state: romptr=%p romSize=%zX alloc=%zX\n", (void*) g->memory.rom,
				        g->memory.romSize, g->memory.romAllocSize);
				fflush(stderr);
				for (k = 0; k < 0x198; ++k) {
					if (((const uint8_t*) g->memory.iwram)[k] != ((const uint8_t*) g->memory.rom)[0x3132D7C + k]) {
						++bad;
					}
				}
				fprintf(stderr, "state: iwram-irq-copy mismatches=%d\n", bad);
			}
			/* 在 EWRAM/IWRAM 中搜索 ROM 上半段的特征数据，验证 ROM->RAM 搬运是否正确。 */
			{
				static const uint32_t probes[] = {0x2F20000, 0x2F4B650, 0x2F1A780, 0x3132D7C};
				const uint8_t* rp = (const uint8_t*) g->memory.rom;
				int pi2;
				for (pi2 = 0; pi2 < 4; ++pi2) {
					const uint8_t* pat = rp + probes[pi2];
					int foundW = 0;
					int foundI = 0;
					size_t o;
					for (o = 0; o + 16 <= GBA_SIZE_EWRAM; ++o) {
						if (!memcmp(((const uint8_t*) g->memory.wram) + o, pat, 16)) {
							++foundW;
							if (foundW == 1) {
								fprintf(stderr, "state: rom[%07X] found in EWRAM @%05zX\n", probes[pi2], o);
							}
						}
					}
					for (o = 0; o + 16 <= GBA_SIZE_IWRAM; ++o) {
						if (!memcmp(((const uint8_t*) g->memory.iwram) + o, pat, 16)) {
							++foundI;
						}
					}
					if (!foundW && !foundI) {
						fprintf(stderr, "state: rom[%07X] data NOT found in RAM (%02X %02X %02X %02X)\n",
						        probes[pi2], pat[0], pat[1], pat[2], pat[3]);
					} else {
						fprintf(stderr, "state: rom[%07X] hits ewram=%d iwram=%d\n", probes[pi2], foundW, foundI);
					}
				}
			}
			if ((fp = fopen("iwram_black.bin", "wb"))) {
				fwrite(g->memory.iwram, 1, GBA_SIZE_IWRAM, fp);
				fclose(fp);
			}
			if ((fp = fopen("ewram_black.bin", "wb"))) {
				fwrite(g->memory.wram, 1, GBA_SIZE_EWRAM, fp);
				fclose(fp);
			}
		}
	}

	/* 5) 每秒敲一次 A，看能否推进（区分「等输入」与「真挂起」） */
	for (int s = 0; s < 10; ++s) {
		memcpy(prev, buf, (size_t) 240 * 160 * sizeof(mColor));
		_rom64Run(core, 1u << 0, 2);
		_rom64Run(core, 0, 58);
		fprintf(stderr, "render: A-tap %2d nonblack=%5d delta=%5d pc=%08X gpio=%u/%04X\n", s + 1,
		        _rom64NonBlack(buf), _rom64Diff(buf, prev), g->cpu->gprs[15], mgbaGpioWrites, mgbaGpioLastValue);
	}
	DUMPFB("fb_end.raw");
	/* 黑屏状态快照：显示寄存器 / 调色板 / VRAM / IWRAM 代码。 */
	{
		fprintf(stderr, "state: dispcnt=%04X bg0=%04X bg1=%04X bg2=%04X bg3=%04X bldcnt=%04X bldy=%02X\n",
		        g->memory.io[0x00], g->memory.io[0x08], g->memory.io[0x0A], g->memory.io[0x0C], g->memory.io[0x0E],
		        g->memory.io[0x50], g->memory.io[0x54]);
		fprintf(stderr, "state: pal:");
		int pi;
		for (pi = 0; pi < 16; ++pi) {
			fprintf(stderr, " %04X", g->video.palette[pi]);
		}
		fprintf(stderr, "\nstate: vram:");
		for (pi = 0; pi < 16; ++pi) {
			fprintf(stderr, " %04X", ((uint16_t*) g->video.vram)[pi]);
		}
		fprintf(stderr, "\nstate: io4x=%04X%04X%04X%04X\n", g->memory.io[0x40 >> 1], g->memory.io[0x42 >> 1],
		        g->memory.io[0x44 >> 1], g->memory.io[0x46 >> 1]);
		if ((fp = fopen("iwram.bin", "wb"))) {
			fwrite(g->memory.iwram, 1, GBA_SIZE_IWRAM, fp);
			fclose(fp);
		}
	}
	GBARom64ProbeDump();
#undef DUMPFB

	free(buf);
	free(prev);
	core->deinit(core);
}

static void dbgTasks(struct GBA* g, const char* tag) {
	if (!g) {
		return;
	}
	const uint8_t* iw = (const uint8_t*) g->memory.iwram;
	fprintf(stderr, "mobile: tasks[%s] base=%08X (func@+0 isActive@+4)\n", tag, 0x03005B54);
	for (int t = 0; t < 16; ++t) {
		const uint8_t* p = iw + 0x5B54 + t * 40;
		if (p[0] || p[1] || p[2] || p[3] || p[4]) {
			const int16_t* d = (const int16_t*) (p + 8);
			fprintf(stderr, "  t%02d func=%08X act=%d m5=%02X next=%02X prio=%02X d0=%d d1=%d d2=%d d3=%d\n", t,
			        (unsigned) (p[0] | (p[1] << 8) | (p[2] << 16) | ((uint32_t) p[3] << 24)), p[4], p[5], p[6], p[7],
			        d[0], d[1], d[2], d[3]);
		}
	}
}

/* MOBILE-LAYER PROBE (rom64): replays the exact user flow
 * "标题 -> 主菜单 -> 从头开始" and logs per-frame game state, so the black-screen
 * hang can be pinned to a concrete frame and task function. */
static void testNewGame(const char* dir, const char* rompath) {
	struct MgbaMobile* emu = mgbaMobileCreate(dir, dir, "probe");
	if (!emu) {
		fprintf(stderr, "ng: create failed\n");
		return;
	}
	mgbaMobileSetRtc(emu, 0, (int64_t) time(NULL), 0);
	if (!mgbaMobileLoad(emu, rompath)) {
		fprintf(stderr, "ng: load failed\n");
		mgbaMobileDestroy(emu);
		return;
	}
	struct mCore* mcore = mgbaMobileDebugCore(emu);
	struct GBA* mg = mcore ? (struct GBA*) mcore->board : NULL;
	if (!mg) {
		fprintf(stderr, "ng: no board\n");
		mgbaMobileDestroy(emu);
		return;
	}
	uint32_t* buf = (uint32_t*) calloc(240 * 160, sizeof(uint32_t));
	const uint8_t* iw = (const uint8_t*) mg->memory.iwram;

#define NG_STATE(f, tag) do { \
		int _act = 0; \
		int _first = -1; \
		for (int _t = 0; _t < 16; ++_t) { \
			if (iw[0x5B58 + _t * 40]) { \
				if (_first < 0) { \
					_first = _t; \
				} \
				++_act; \
			} \
		} \
		int _pnz = 0; \
		for (int _k = 0; _k < 512; ++_k) { \
			if (mg->video.palette[_k]) { \
				++_pnz; \
			} \
		} \
		const uint16_t* _g = (const uint16_t*) (iw + 0x5608); \
		fprintf(stderr, "ng: %s f%03d cb2=%08X tasks=%2d cnt=%04X pnz=%3d hk=%04X nk=%04X key=%04X s15=%02X s16=%02X", \
		        tag, f, ((const uint32_t*) iw)[(0x030055E4 - 0x03000000) >> 2], _act, \
		        mg->memory.io[GBA_REG_DISPCNT >> 1], _pnz, _g[2], _g[3], \
		        mg->memory.io[GBA_REG_KEYINPUT >> 1], \
		        ((const uint8_t*) mg->memory.wram)[0x951C + 0x15], ((const uint8_t*) mg->memory.wram)[0x951C + 0x16]); \
		if (_first >= 0) { \
			const uint8_t* _tp = iw + 0x5B54 + _first * 40; \
			const int16_t* _d = (const int16_t*) (_tp + 8); \
			fprintf(stderr, " t%d.fn=%08X d0=%d d1=%d d2=%d d3=%d d4=%d d5=%d", _first, \
			        (unsigned) (_tp[0] | (_tp[1] << 8) | (_tp[2] << 16) | ((uint32_t) _tp[3] << 24)), \
			        _d[0], _d[1], _d[2], _d[3], _d[4], _d[5]); \
		} \
		fprintf(stderr, "\n"); \
		if (getenv("P_DUMPF")) { \
			char _nm[64]; \
			mgbaMobileCopyVideo(emu, buf, 240); \
			snprintf(_nm, sizeof(_nm), "ng_%s_%03d.raw", tag, f); \
			FILE* _fp = fopen(_nm, "wb"); \
			if (_fp) { \
				fwrite(buf, 4, 240 * 160, _fp); \
				fclose(_fp); \
			} \
		} \
	} while (0)

#define NG_RUN(n) do { \
		for (int _i = 0; _i < (n); ++_i) { \
			mgbaMobileRunFrames(emu, 1); \
		} \
	} while (0)
#define NG_TAP(k) do { \
		mgbaMobileSetKeys(emu, (k)); \
		NG_RUN(2); \
		mgbaMobileSetKeys(emu, 0); \
		NG_RUN(30); \
	} while (0)

	if (getenv("P_TASK")) {
		extern int mgbaSidLogOn;
		mgbaSidLogOn = 1; /* 从开机开始记录该 EWRAM 结构的所有写入 */
	}
	NG_RUN(800);
	NG_STATE(0, "boot");
	NG_TAP(1u << 0); /* 标题上按 A -> 进入主菜单 */
	NG_STATE(31, "menu");
	if (getenv("P_GGAME")) {
		/* 自适应导航：标题->主菜单（按 A），等菜单稳定后反复按 A，直到场景离开主菜单（确认「从头开始」生效）。 */
		const uint32_t MAINMENU_CB2 = 0x081B21CD;
		NG_TAP(1u << 0); /* 标题 -> 主菜单 */
		int atMenu = 0;
		for (int w = 0; w < 80; ++w) {
			NG_RUN(20);
			uint32_t cb2 = ((const uint32_t*) iw)[(0x030055E4 - 0x03000000) >> 2];
			if (cb2 == MAINMENU_CB2) { atMenu = 1; break; }
		}
		fprintf(stderr, "ng: atMenu=%d\n", atMenu);
		int started = 0;
		if (atMenu) {
			/* 在主菜单上逐个条目尝试：按 A，若没离开菜单则下移光标再试。 */
			for (int item = 0; item < 6 && !started; ++item) {
				mgbaMobileSetKeys(emu, 1u << 0);
				NG_RUN(3);
				mgbaMobileSetKeys(emu, 0);
				NG_RUN(25);
				uint32_t cb2 = ((const uint32_t*) iw)[(0x030055E4 - 0x03000000) >> 2];
				if (cb2 != MAINMENU_CB2) {
					fprintf(stderr, "ng: newgame started at item %d cb2=%08X\n", item, cb2);
					started = 1;
					break;
				}
				/* 下移光标，准备试下一个条目 */
				mgbaMobileSetKeys(emu, 1u << 4);
				NG_RUN(3);
				mgbaMobileSetKeys(emu, 0);
				NG_RUN(15);
			}
		}
		if (!started) fprintf(stderr, "ng: !! newgame did NOT start !!\n");
	} else {
		NG_TAP(1u << 0); /* 主菜单「从头开始」上按 A */
	}
	{
		extern int mgbaProbeFrame;
		extern int mgbaTaskLogOn;
		extern int mgbaSidLogOn;
		/* 只要 P_TASK 打开，就从这一帧起全程记录（之前窗口太窄导致漏写）。 */
		mgbaTaskLogOn = !!getenv("P_TASK");
		mgbaSidLogOn = !!getenv("P_TASK");
		mgbaProbeFrame = 0;
		fprintf(stderr, "ng: --- probe armed (task+sid, full run) ---\n");
	}
	int ngMax = 300;
	{ const char* nm = getenv("P_NMAX"); if (nm) { int v = atoi(nm); if (v > 0) ngMax = v; } }
	for (int f = 0; f < ngMax; ++f) {
		static int ringLo = -1, ringHi = -1;
		if (ringLo < 0) {
			const char* rs = getenv("P_RINGF");
			ringLo = 126;
			ringHi = 140;
			if (rs) {
				int a = 0, b = 0;
				if (sscanf(rs, "%d,%d", &a, &b) == 2) {
					ringLo = a;
					ringHi = b;
				}
			}
		}
		int ringThis = getenv("P_RING3") && f >= ringLo && f <= ringHi;
		{
			extern int mgbaProbeFrame;
			mgbaProbeFrame = f;
		}
		if (ringThis) {
			mgbaPcRingReset();
			mgbaPcRingOn = 1;
		}
		if (getenv("P_MASH") && (f % 30) == 29) {
			mgbaMobileSetKeys(emu, 1u << 0);
			mgbaMobileRunFrames(emu, 2);
			mgbaMobileSetKeys(emu, 0);
		}
		NG_RUN(1);
		if (getenv("P_FORCE")) {
			/* 实验：若任务 0 的 func 指向 ROM 但 isActive 被清 0，强制复活。 */
			uint8_t* t0 = (uint8_t*) iw + 0x5B54;
			uint32_t fn = (uint32_t) t0[0] | (t0[1] << 8) | (t0[2] << 16) | ((uint32_t) t0[3] << 24);
			if (t0[4] == 0 && fn >= 0x08000000 && fn < 0x0C000000) {
				t0[4] = 1;
				fprintf(stderr, "ng: *** revived task0 func=%08X at f%d ***\n", fn, f);
			}
		}
		if (ringThis) {
			mgbaPcRingOn = 0;
			fprintf(stderr, "ng: --- RING3 f%03d ---\n", f);
			mgbaPcRingDump(16384);
			fprintf(stderr, "ng: --- RING3 f%03d end ---\n", f);
		}
		if (getenv("P_EDUMP") && f >= 11 && f <= 17) {
			char _nm[64];
			snprintf(_nm, sizeof(_nm), "wram_%03d.bin", f);
			FILE* _fp = fopen(_nm, "wb");
			if (_fp) {
				fwrite(mg->memory.wram, 1, 0x40000, _fp);
				fclose(_fp);
			}
		}
		NG_STATE(f, "ng");
		{
			static int _sceneDumped = 0;
			if (!_sceneDumped) {
				uint32_t _cb2 = ((const uint32_t*) iw)[(0x030055E4 - 0x03000000) >> 2];
				if (_cb2 != 0x081B21CD && _cb2 != 0x08272389) {
					int _pnz = 0;
					for (int _k = 0; _k < 512; ++_k) {
						if (mg->video.palette[_k]) ++_pnz;
					}
					if (_pnz > 100) {
						mgbaMobileCopyVideo(emu, buf, 240);
						FILE* _fp = fopen("ng_scene.raw", "wb");
						if (_fp) {
							fwrite(buf, 4, 240 * 160, _fp);
							fclose(_fp);
						}
						fprintf(stderr, "ng: scene dump at f%d cb2=%08X pnz=%d\n", f, _cb2, _pnz);
						_sceneDumped = 1;
					}
				}
			}
		}
		if (getenv("P_FINALF") && f == ngMax - 1) {
			mgbaMobileCopyVideo(emu, buf, 240);
			FILE* _fp = fopen("ng_final.raw", "wb");
			if (_fp) {
				fwrite(buf, 4, 240 * 160, _fp);
				fclose(_fp);
			}
		}
	}
#undef NG_STATE
#undef NG_RUN
#undef NG_TAP
	{
		extern uint32_t mgbaDispcntLogPc[32];
		extern uint32_t mgbaDispcntLogVal[32];
		extern uint32_t mgbaDispcntLogN;
		uint32_t n = mgbaDispcntLogN < 32 ? mgbaDispcntLogN : 32;
		fprintf(stderr, "ng: --- DISPCNT writes (last %u of %u) ---\n", n, mgbaDispcntLogN);
		for (uint32_t i = 0; i < n; ++i) {
			uint32_t s = (mgbaDispcntLogN - n + i) & 31;
			fprintf(stderr, "ng:   DISPCNT=%04X pc=%08X\n", mgbaDispcntLogVal[s], mgbaDispcntLogPc[s]);
		}
	}
	free(buf);
	mgbaMobileDestroy(emu);
}

/* MOBILE-LAYER PROBE (rom64): drive the exact code path the Android app uses
 * (mgbaMobileLoad/RunFrames/CopyVideo) so a device-only regression can be
 * reproduced and bisected on the desktop. */
static void testRom64Mobile(const char* dir, const char* rompath) {
	struct MgbaMobile* emu = mgbaMobileCreate(dir, dir, "probe");
	if (!emu) {
		fprintf(stderr, "mobile: create failed\n");
		return;
	}
	/* 与 EmulatorActivity 默认一致：RTC 用真实时间（mode 0）。 */
	mgbaMobileSetRtc(emu, 0, (int64_t) time(NULL), 0);
	const char* saveEnv = getenv("P_SAVE");
	if (saveEnv) {
		mgbaMobileSetSaveType(emu, atoi(saveEnv));
		fprintf(stderr, "mobile: forcing save type %d\n", atoi(saveEnv));
	}
	if (!mgbaMobileLoad(emu, rompath)) {
		fprintf(stderr, "mobile: load failed\n");
		mgbaMobileDestroy(emu);
		return;
	}
	fprintf(stderr, "mobile: %s width=%d height=%d frameNanos=%lld\n", rompath,
	        mgbaMobileWidth(emu), mgbaMobileHeight(emu), (long long) mgbaMobileFrameNanos(emu));
	struct mCore* mcore = mgbaMobileDebugCore(emu);
	struct GBA* mg = mcore ? (struct GBA*) mcore->board : NULL;
	if (mg && getenv("P_IDLE")) {
		mg->idleOptimization = IDLE_LOOP_IGNORE;
		mg->idleLoop = 0;
		fprintf(stderr, "mobile: idle loop optimization disabled (was %08X)\n", mg->idleLoop);
	}

	uint32_t* buf = (uint32_t*) calloc(240 * 160, sizeof(uint32_t));
	uint32_t* prev = (uint32_t*) calloc(240 * 160, sizeof(uint32_t));
	FILE* fp;
#define DUMPMB(name) do { if ((fp = fopen(name, "wb"))) { fwrite(buf, 4, 240 * 160, fp); fclose(fp); } } while (0)

#define RUNMB(k, n) do { mgbaMobileSetKeys(emu, (k)); for (int _i = 0; _i < (n); ++_i) { mgbaMobileRunFrames(emu, 1); } mgbaMobileSetKeys(emu, 0); mgbaMobileCopyVideo(emu, buf, 240); } while (0)

	RUNMB(0, 800);
	{
		int nb = 0;
		for (int i = 0; i < 240 * 160; ++i) {
			if ((buf[i] & 0xFFFFFFu) != 0) {
				++nb;
			}
		}
		fprintf(stderr, "mobile: TITLE nonblack=%d/38400\n", nb);
		DUMPMB("mfb_title.raw");
		dbgTasks(mg, "title");
		if (mg) {
			fprintf(stderr, "mobile: TITLE cb2=%08X vbl=%08X\n",
			        ((const uint32_t*) mg->memory.iwram)[(0x030055E4 - 0x03000000) >> 2],
			        ((const uint32_t*) mg->memory.iwram)[(0x030055EC - 0x03000000) >> 2]);
		}
	}
	if (getenv("P_CONTACT")) {
		/* 时间轴缩略图：每 60 帧一帧，共 30 帧（30 秒）。 */
		FILE* cf = fopen("contact.bin", "wb");
		for (int i = 0; i < 30 * 60; ++i) {
			if (mgbaMobileRunFrames(emu, 1)) {
				mgbaMobileCopyVideo(emu, buf, 240);
				if ((i % 60) == 59 && cf) {
					int nb = 0;
					for (int k = 0; k < 240 * 160; ++k) {
						if ((buf[k] & 0xFFFFFFu) != 0) {
							++nb;
						}
					}
					fprintf(stderr, "mobile: contact t=%02ds nb=%d\n", (i + 1) / 60, nb);
					fwrite(buf, 4, 240 * 160, cf);
				}
			}
		}
		if (cf) {
			fclose(cf);
		}
		DUMPMB("mfb_contact_end.raw");
	}

	GBARom64ProbeReset(); /* phase 1: 标题 */
	RUNMB(1u << 3, 2);
	RUNMB(0, 60);
	DUMPMB("mfb_menu.raw");
	if (mg) {
		dbgTasks(mg, "menu");
		fprintf(stderr, "mobile: MENU gMain.cb2=%08X gMain.cb1=%08X gMain+0C=%08X\n",
		        ((const uint32_t*) mg->memory.iwram)[(0x030055E4 - 0x03000000) >> 2],
		        ((const uint32_t*) mg->memory.iwram)[(0x030055E0 - 0x03000000) >> 2],
		        ((const uint32_t*) mg->memory.iwram)[(0x030055EC - 0x03000000) >> 2]);
	}
	GBARom64ProbeReset(); /* phase 2: 菜单 -> 选中新游戏 */
	RUNMB(1u << 0, 2);
	fprintf(stderr, "mobile: --- selected NEW GAME ---\n");
	/* 逐帧追踪过渡：cb2 / 活跃任务数 / DISPCNT / 调色板非零数。 */
	if (mg) {
		for (int f = 0; f < 240; ++f) {
			int ringThis = getenv("P_RING2") && f >= 30 && f <= 39;
			if (ringThis) {
				mgbaPcRingReset();
				mgbaPcRingOn = 1;
			}
			if (getenv("P_AAT") && (f == 100 || f == 180)) {
				mgbaMobileSetKeys(emu, 1u << 0);
			}
			mgbaMobileRunFrames(emu, 1);
			if (getenv("P_AAT") && (f == 101 || f == 181)) {
				mgbaMobileSetKeys(emu, 0);
			}
			if (ringThis) {
				mgbaPcRingOn = 0;
				fprintf(stderr, "mobile: --- RING2 f%02d ---\n", f);
				mgbaPcRingDump(16384);
				fprintf(stderr, "mobile: --- RING2 f%02d end ---\n", f);
			}
			int act = 0;
			int firstT = -1;
			const uint8_t* iw = (const uint8_t*) mg->memory.iwram;
			for (int t = 0; t < 16; ++t) {
				if (iw[0x5B58 + t * 40]) {
					if (firstT < 0) {
						firstT = t;
					}
					++act;
				}
			}
			int pnz = 0;
			for (int k = 0; k < 512; ++k) {
				if (mg->video.palette[k]) {
					++pnz;
				}
			}
			fprintf(stderr, "mobile: f%03d cb2=%08X tasks=%2d cnt=%04X pnz=%3d state=%d", f,
			        ((const uint32_t*) iw)[(0x030055E4 - 0x03000000) >> 2], act,
			        mg->memory.io[GBA_REG_DISPCNT >> 1], pnz, iw[0x5A18 - 0x0000]);
			{
				const uint16_t* g = (const uint16_t*) (iw + 0x5608);
				fprintf(stderr, " hkraw=%04X nkraw=%04X hk=%04X nk=%04X keyio=%04X",
				        g[0], g[1], g[2], g[3], mg->memory.io[GBA_REG_KEYINPUT >> 1]);
			}
			if (firstT >= 0) {
				const uint8_t* tp = iw + 0x5B54 + firstT * 40;
				const int16_t* d = (const int16_t*) (tp + 8);
				fprintf(stderr, " t%d.func=%08X d0=%d d1=%d d2=%d d3=%d d4=%d",
				        firstT, (unsigned) (tp[0] | (tp[1] << 8) | (tp[2] << 16) | ((uint32_t) tp[3] << 24)),
				        d[0], d[1], d[2], d[3], d[4]);
			}
			fprintf(stderr, "\n");
			if (getenv("P_DUMPF")) {
				char nm[64];
				mgbaMobileCopyVideo(emu, buf, 240);
				snprintf(nm, sizeof(nm), "mfd_f%03d.raw", f);
				DUMPMB(nm);
			}
		}
	}
	for (int s = 0, sN = getenv("P_FAST") ? 0 : 180; s < sN; ++s) {
		memcpy(prev, buf, 240 * 160 * 4);
		GBARom64ProbeReset();
		mgbaIoLogOn = s < 6 ? 2 : 0;
		fprintf(stderr, "mobile: === sec %d ===\n", s + 1);
		if (getenv("P_MASH")) {
			/* 交替连按 A / B：判断“冻结”是否只是卡在等按键。 */
			const char* mk = getenv("P_MASH");
			for (int sub = 0; sub < 10; ++sub) {
				uint32_t k = mk[0] == 'A' ? (1u << 0) : (mk[0] == 'B' ? (1u << 1) : ((sub & 1) ? (1u << 1) : (1u << 0)));
				mgbaMobileSetKeys(emu, k);
				mgbaMobileRunFrames(emu, 2);
				mgbaMobileSetKeys(emu, 0);
				mgbaMobileRunFrames(emu, 4);
			}
		} else {
			mgbaMobileRunFrames(emu, 60);
		}
		mgbaIoLogOn = 0;
		mgbaMobileCopyVideo(emu, buf, 240);
		int nb = 0;
		int dl = 0;
		for (int i = 0; i < 240 * 160; ++i) {
			if ((buf[i] & 0xFFFFFFu) != 0) {
				++nb;
			}
			if (buf[i] != prev[i]) {
				++dl;
			}
		}
		if (s < 10 || s % 10 == 9) {
			fprintf(stderr, "mobile: t=%3ds nonblack=%5d delta=%5d ws1=%u irq=%u\n", s + 1, nb, dl, GBARom64ProbePhaseCount(), mgbaIrqHandlerHits);
		}
		if (mg && (s < 12 || s == 29 || s == 59)) {
			int pnz = 0;
			for (int k = 0; k < 512; ++k) {
				if (mg->video.palette[k]) {
					++pnz;
				}
			}
			fprintf(stderr, "mobile:   st pc=%08X cpsr=%08X hlt=%d ime=%04X ie=%04X if=%04X dst=%04X cnt=%04X fc=%u vc=%3d pnz=%3d p0=%04X p1=%04X romsz=%08X rmask=%08X\n",
			        mg->cpu->gprs[15], (uint32_t) mg->cpu->cpsr.packed, mg->cpu->halted,
			        mg->memory.io[GBA_REG_IME >> 1], mg->memory.io[GBA_REG_IE >> 1],
			        mg->memory.io[GBA_REG_IF >> 1], mg->memory.io[GBA_REG_DISPSTAT >> 1],
			        mg->memory.io[GBA_REG_DISPCNT >> 1], mg->video.frameCounter, mg->video.vcount,
			        pnz, mg->video.palette[0], mg->video.palette[1],
			        mg->memory.romSize, mg->memory.romMask);
			fprintf(stderr, "mobile:   cb2=%08X cbc=%08X\n",
			        ((const uint32_t*) mg->memory.iwram)[(0x030055E4 - 0x03000000) >> 2],
			        ((const uint32_t*) mg->memory.iwram)[(0x030055EC - 0x03000000) >> 2]);
			fprintf(stderr, "mobile:   irqchain testIrq=%u sched=%u evt=%u skip=%u raise=%u masked=%u key=%u@%08X\n",
			        mgbaStatTestIrq, mgbaStatTestIrq - mgbaStatIrqSkipSched, mgbaStatIrqEvent,
			        mgbaStatIrqSkipSched, mgbaStatRaiseIrq, mgbaStatRaiseIrqMasked,
			        mgbaStatKeyReads, mgbaStatKeyLast);
		}
		if (s == 0 || s == 4 || s == 9 || s == 29) {
			char nm[64];
			snprintf(nm, sizeof(nm), "mfb_t%02d.raw", s + 1);
			DUMPMB(nm);
		}
	}
	/* 逐帧观察：黑屏状态是否在循环（白/黑闪烁）。 */
	{
		int run = 0;
		int lastNb = -1;
		for (int i = 0; i < 400; ++i) {
			mgbaMobileRunFrames(emu, 1);
			mgbaMobileCopyVideo(emu, buf, 240);
			int nb = 0;
			for (int k = 0; k < 240 * 160; ++k) {
				if ((buf[k] & 0xFFFFFFu) != 0) {
					++nb;
				}
			}
			if (nb != lastNb) {
				if (run) {
					fprintf(stderr, "mobile: frame-run len=%d nb=%d\n", run, lastNb);
				}
				run = 0;
				lastNb = nb;
			}
			++run;
		}
		fprintf(stderr, "mobile: frame-run len=%d nb=%d (end)\n", run, lastNb);
	}

	/* 按键扫描：黑屏时各按键是否有任何反应。 */
	{
		static const char* names[] = {"A", "B", "START", "SELECT", "UP", "DOWN", "LEFT", "RIGHT", "L", "R"};
		static const uint32_t bits[] = {1u << 0, 1u << 1, 1u << 3, 1u << 2, 1u << 6, 1u << 7, 1u << 5, 1u << 4, 1u << 9, 1u << 8};
		for (int b = 0; b < 10; ++b) {
			memcpy(prev, buf, 240 * 160 * 4);
			mgbaMobileSetKeys(emu, bits[b]);
			mgbaMobileRunFrames(emu, 8);
			uint16_t keyReg = mg ? mg->memory.io[GBA_REG_KEYINPUT >> 1] : 0;
			mgbaMobileSetKeys(emu, 0);
			mgbaMobileRunFrames(emu, 40);
			mgbaMobileCopyVideo(emu, buf, 240);
			int nb = 0;
			int dl = 0;
			for (int i = 0; i < 240 * 160; ++i) {
				if ((buf[i] & 0xFFFFFFu) != 0) {
					++nb;
				}
				if (buf[i] != prev[i]) {
					++dl;
				}
			}
			fprintf(stderr, "mobile: key %-6s nonblack=%5d delta=%5d ws1=%u same=%u keyreg=%04X\n", names[b], nb, dl,
			        GBARom64ProbePhaseCount(), mgbaRom64Ws1Same, keyReg);
		}
		GBARom64ProbeDump();
	}

	/* 黑屏期：抓一帧的 IO 写序列。 */
	mgbaIoLogOn = 1;
	mgbaMobileRunFrames(emu, 1);
	mgbaIoLogOn = 0;

	/* 黑屏期 PC 采样：找出卡住的循环。 */
	mgbaPcSampleMask = 3;
	mgbaPcSampleReset();
	mgbaPcSampleOn = 1;
	for (int i = 0; i < 30; ++i) {
		mgbaMobileRunFrames(emu, 1);
	}
	mgbaPcSampleOn = 0;
	dbgTasks(mg, "black");
	fprintf(stderr, "mobile: --- black-phase PC profile ---\n");
	mgbaPcSampleDump(24);

	/* 顺序执行轨迹：抓一帧的完整 PC 流，用于还原卡死的循环体。 */
	if (getenv("P_RING")) {
		mgbaPcRingReset();
		mgbaPcRingOn = 1;
		mgbaMobileRunFrames(emu, 1);
		mgbaPcRingOn = 0;
		fprintf(stderr, "mobile: --- RING trace (last frame, %u insns) ---\n", mgbaPcRingTotal);
		mgbaPcRingDump(16384);
		fprintf(stderr, "mobile: --- RING end ---\n");
	}

	if (mg) {
		FILE* df = fopen("miwram.bin", "wb");
		if (df) {
			fwrite(mg->memory.iwram, 1, 0x8000, df);
			fclose(df);
		}
		df = fopen("mewram.bin", "wb");
		if (df) {
			fwrite(mg->memory.wram, 1, 0x40000, df);
			fclose(df);
		}
		df = fopen("mvram.bin", "wb");
		if (df) {
			fwrite(mg->video.vram, 1, 0x18000, df);
			fclose(df);
		}
		fprintf(stderr, "mobile: dumped miwram/mewram/mvram\n");
	}

	if (mg) {
		/* ROM 完整性：内存中的 ROM 副本是否被游戏写坏（bank 切换常用写 ROM 地址）。 */
		FILE* rf = fopen("C:/Users/lenovo/Desktop/soulgold.gba", "rb");
		if (rf && mg->memory.rom) {
			uint8_t* file = (uint8_t*) malloc(0x4000000);
			size_t got = fread(file, 1, 0x4000000, rf);
			fclose(rf);
			const uint8_t* mem = (const uint8_t*) mg->memory.rom;
			size_t diff = 0;
			int shown = 0;
			fprintf(stderr, "mobile: --- ROM integrity (file=%u) ---\n", (unsigned) got);
			for (size_t off = 0; off + 2 <= got; off += 2) {
				if (file[off] != mem[off] || file[off + 1] != mem[off + 1]) {
					++diff;
					if (shown < 24) {
						fprintf(stderr, "  dif %08X file=%02X%02X mem=%02X%02X\n", (unsigned) off,
						        file[off + 1], file[off], mem[off + 1], mem[off]);
						++shown;
					}
				}
			}
			fprintf(stderr, "mobile: ROM differing halfwords = %u\n", (unsigned) diff);
			free(file);
		}
	}

	if (mg) {
		uint32_t sp = mg->cpu->gprs[13];
		fprintf(stderr, "mobile: --- stack @ %08X (ROM return addrs marked) ---\n", sp);
		for (int i = 0; i < 96; ++i) {
			uint32_t a = sp + i * 4;
			uint32_t v = 0;
			if (a >= 0x03000000 && a < 0x03008000) {
				v = ((const uint32_t*) mg->memory.iwram)[(a - 0x03000000) >> 2];
			} else if (a >= 0x02000000 && a < 0x02040000) {
				v = ((const uint32_t*) mg->memory.wram)[(a - 0x02000000) >> 2];
			}
			if (v) {
				fprintf(stderr, "  [%08X] %08X%s\n", a, v,
				        (v >= 0x08000000 && v < 0x0E000000) ? "   <== ROM" : "");
			}
		}
	}

	for (int s = 0; s < 10; ++s) {
		memcpy(prev, buf, 240 * 160 * 4);
		RUNMB(1u << 0, 2);
		mgbaMobileRunFrames(emu, 58);
		mgbaMobileCopyVideo(emu, buf, 240);
		int nb = 0;
		int dl = 0;
		for (int i = 0; i < 240 * 160; ++i) {
			if ((buf[i] & 0xFFFFFFu) != 0) {
				++nb;
			}
			if (buf[i] != prev[i]) {
				++dl;
			}
		}
		fprintf(stderr, "mobile: A-tap %2d nonblack=%5d delta=%5d\n", s + 1, nb, dl);
	}
	DUMPMB("mfb_end.raw");
#undef DUMPMB
#undef RUNMB
	GBARom64ProbeDump();
	free(buf);
	free(prev);
	mgbaMobileDestroy(emu);
}

int main(int argc, char** argv) {
	char dir[512];
#ifdef _WIN32
	WSADATA data;
	WSAStartup(MAKEWORD(2, 2), &data);
#endif
	if (argc >= 2 && strcmp(argv[1], "--render") == 0) {
		testRom64Render(argc > 2 ? argv[2] : "C:/Users/lenovo/Desktop/soulgold.gba");
		return 0;
	}
	if (argc >= 2 && strcmp(argv[1], "--ng") == 0) {
		testNewGame(argc > 3 ? argv[3] : ".", argc > 2 ? argv[2] : "rom.gba");
		return 0;
	}
	if (argc >= 2 && strcmp(argv[1], "--mobile") == 0) {
		testRom64Mobile(argc > 3 ? argv[3] : ".", argc > 2 ? argv[2] : "rom.gba");
		return 0;
	}
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
	testRom64(dir);
	testTurboB(dir);
	testAudioOut(dir);
	testAudioPitch(dir);
	testAudioConstPitch(dir);
	testAudioConstPitchRealtime(dir);
	testAudioConstPitchDevicePump(dir);
	testAudioNativeHold(dir);
	testLink();
	testRelay();
	if (g_failed) {
		fprintf(stderr, "mobile tests failed\n");
		return 1;
	}
	printf("mobile tests passed\n");
	return 0;
}
