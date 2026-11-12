/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "link_net.h"
#include "link_lockstep.h"
#include "mgba_mobile.h"
#include "remote_link.h"

#include <mgba/core/core.h>
#include <mgba/core/log.h>
#include <mgba/internal/arm/arm.h>
#include <mgba/internal/gba/gba.h>
#include <mgba/internal/gba/io.h>
#include <mgba/internal/gba/memory.h>
#include <mgba/internal/gba/sio.h>
#include <mgba/internal/gba/video.h>
#include <mgba-util/vfs.h>
#include <mgba-util/image.h>

#include <fcntl.h>
#include <pthread.h>

/* The synthetic clock is a per-instance hook (mgbaMobileSetAudioClock), so
 * two cores in one process cannot change each other's pacing. */

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
	mgbaMobileSetAudioClock(emu, NULL);
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
	mgbaMobileSetAudioClock(emu, fakeAudioClock);

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
	mgbaMobileSetAudioClock(emu, NULL);
	free(out);
	free(tmp);
	free(baseline);
	mgbaMobileDestroy(emu);
}

/* 本机双核心: two MgbaMobile instances in one process, each running its own
 * thread and SIO loopback. Function-local statics used to be shared between
 * them - the unstick one-shot latch fired on core A and core B then skipped
 * its own standby patch forever, while the streak counter was incremented by
 * both cores. Prove the state is per-instance now. */
static void testDualCoreIsolation(void) {
	struct MgbaMobile* a = mgbaMobileCreate("", "", "dual-a");
	struct MgbaMobile* b = mgbaMobileCreate("", "", "dual-b");
	struct MgbaMobile* c;
	expect(a != NULL && b != NULL, "two cores can coexist in one process");
	if (!a || !b) {
		mgbaMobileDestroy(a);
		mgbaMobileDestroy(b);
		return;
	}
	/* Interleaved rounds: a shared streak counter would arm on the third
	 * *global* match instead of each core's third own match. */
	expect(mgbaMobileUnstickStep(a, 1, true) == 0, "core A round 1 does not arm");
	expect(mgbaMobileUnstickStep(b, 1, true) == 0, "core B round 1 does not arm");
	expect(mgbaMobileUnstickStep(a, 1, true) == 0, "core A round 2 does not arm");
	expect(mgbaMobileUnstickStep(b, 1, true) == 0, "core B round 2 does not arm (streaks are separate)");
	expect(mgbaMobileUnstickStep(a, 1, true) == 1, "core A arms on its own third match");
	expect(mgbaMobileUnstickStep(b, 1, true) == 1, "core B still arms its own patch after A");
	expect(mgbaMobileUnstickStep(b, 1, true) == 0, "core B patch is a one-shot too");

	c = mgbaMobileCreate("", "", "dual-c");
	expect(c != NULL, "a third core can be created");
	if (c) {
		mgbaMobileUnstickStep(c, 1, true);
		mgbaMobileUnstickStep(c, 1, false);
		expect(mgbaMobileUnstickStep(c, 1, true) == 0, "a miss resets only that core's streak");
		expect(mgbaMobileUnstickStep(c, 1, true) == 0, "streak restarts from one");
		expect(mgbaMobileUnstickStep(c, 1, true) == 1, "core C arms after three fresh matches");
		mgbaMobileDestroy(c);
	}

	/* The synthetic audio clock is per-instance as well. */
	expect(!mgbaMobileHasSyntheticAudioClock(a), "core A starts with the real clock");
	mgbaMobileSetAudioClock(a, fakeAudioClock);
	expect(mgbaMobileHasSyntheticAudioClock(a), "core A takes the synthetic clock");
	expect(!mgbaMobileHasSyntheticAudioClock(b), "core B keeps the real clock");
	mgbaMobileSetAudioClock(a, NULL);
	mgbaMobileDestroy(a);
	expect(!mgbaMobileHasSyntheticAudioClock(b), "destroying core A does not change core B");
	mgbaMobileDestroy(b);
}

/* In-memory save state used by TYPE_STATE link synchronisation. */
static void testStateMemory(const char* dir) {
	unsigned char rom[2048];
	char path[512];
	struct MgbaMobile* emu;
	void* blob = NULL;
	void* blob2 = NULL;
	size_t size = 0;
	size_t size2 = 0;

	memset(rom, 0, sizeof(rom));
	rom[0] = 0xFE;
	rom[1] = 0xFF;
	rom[2] = 0xFF;
	rom[3] = 0xEA;
	rom[0xB2] = 0x96;
	snprintf(path, sizeof(path), "%s/state.gba", dir);
	expect(writeFile(path, rom, sizeof(rom)), "state: write gba rom");

	emu = mgbaMobileCreate(dir, dir, "state");
	expect(mgbaMobileLoad(emu, path), "state: load gba");
	expect(mgbaMobileRunFrames(emu, 4), "state: run frames before snapshot");
	expect(mgbaMobileSaveStateToMemory(emu, &blob, &size), "state: save to memory");
	expect(blob != NULL && size > 0, "state: snapshot is not empty");
	expect(mgbaMobileRunFrames(emu, 4), "state: run frames after snapshot");
	expect(mgbaMobileLoadStateFromMemory(emu, blob, size), "state: load from memory");
	expect(mgbaMobileSaveStateToMemory(emu, &blob2, &size2), "state: save again");
	expect(size2 == size, "state: snapshot size is stable across a round trip");
	expect(!mgbaMobileLoadStateFromMemory(emu, NULL, 0), "state: null blob rejected");
	expect(!mgbaMobileLoadStateFromMemory(emu, blob, 0), "state: zero length rejected");
	expect(!mgbaMobileSaveStateToMemory(NULL, &blob2, &size2), "state: null core rejected");

	mgbaMobileFreeState(blob2);
	mgbaMobileFreeState(blob);
	mgbaMobileDestroy(emu);
}

struct StateRace {
	struct MgbaMobile* emu;
	int frames;
	int completed;
};

static void* stateRaceFrames(void* arg) {
	struct StateRace* race = (struct StateRace*) arg;
	for (int i = 0; i < race->frames; ++i) {
		mgbaMobileLock(race->emu);
		mgbaMobileRunFrames(race->emu, 1);
		mgbaMobileUnlock(race->emu);
		++race->completed;
	}
	return NULL;
}

/* A TYPE_STATE frame reaches the mirror core from the socket reader thread
 * while the emulation thread is inside runFrames. Both paths go through the
 * per-instance core lock at the JNI boundary; verify the real two-thread case
 * neither deadlocks nor corrupts the state blob. */
static void testStateConcurrency(const char* dir) {
	unsigned char rom[2048];
	char path[512];
	struct MgbaMobile* emu;
	memset(rom, 0, sizeof(rom));
	rom[0] = 0xFE;
	rom[1] = 0xFF;
	rom[2] = 0xFF;
	rom[3] = 0xEA;
	rom[0xB2] = 0x96;
	snprintf(path, sizeof(path), "%s/state_race.gba", dir);
	expect(writeFile(path, rom, sizeof(rom)), "race: write gba rom");

	emu = mgbaMobileCreate(dir, dir, "race");
	expect(mgbaMobileLoad(emu, path), "race: load gba");
	struct StateRace race = { emu, 120, 0 };
	pthread_t thread;
	int started = pthread_create(&thread, NULL, stateRaceFrames, &race) == 0;
	expect(started, "race: frame thread started");

	int snapshots = 0;
	for (int i = 0; i < 12; ++i) {
		void* blob = NULL;
		size_t size = 0;
		bool ok;
		mgbaMobileLock(emu);
		ok = mgbaMobileSaveStateToMemory(emu, &blob, &size);
		if (ok && blob && size > 0) {
			ok = mgbaMobileLoadStateFromMemory(emu, blob, size);
		}
		mgbaMobileUnlock(emu);
		mgbaMobileFreeState(blob);
		if (ok) {
			++snapshots;
		}
	}
	if (started) {
		expect(pthread_join(thread, NULL) == 0, "race: frame thread joined");
	}
	expect(!started || race.completed == race.frames,
	       "race: all frames completed without deadlock");
	expect(snapshots == 12, "race: concurrent save/load round trips succeeded");
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

static void linkSleepMs(int ms) {
#ifdef _WIN32
	Sleep((DWORD) ms);
#else
	usleep((useconds_t) ms * 1000);
#endif
}

struct LockProbe {
	struct MgbaMobile* emu;
	volatile int done;
};

static void* lockProbeFrames(void* arg) {
	struct LockProbe* p = (struct LockProbe*) arg;
	mgbaMobileRunFrames(p->emu, 2);
	p->done = 1;
	return NULL;
}

/* 核心锁必须真的包住公开入口。
 *
 * 只靠「并发跑不崩」是弱证据 —— 竞态是概率性的，没崩不代表有锁。这里给确定
 * 性证据：主线程先持锁，另一线程调 mgbaMobileRunFrames 必须被挡住；主线程解锁
 * 后它才跑完。
 *
 * 守的是「iOS 直接调用 C 函数」那条路径：核心锁原来只加在 JNI 的三个入口
 * （nativeRunFrames / SaveStateToMemory / LoadStateFromMemory）上，而 iOS
 * 不经过 JNI —— 于是 iOS 上「镜像核跑帧」与「状态帧注入」从来没有互斥过。
 */
static void testCoreLockHeld(const char* dir) {
	unsigned char rom[2048];
	char path[512];
	struct MgbaMobile* emu;
	struct LockProbe probe;
	pthread_t thread;
	memset(rom, 0, sizeof(rom));
	rom[0] = 0xFE;
	rom[1] = 0xFF;
	rom[2] = 0xFF;
	rom[3] = 0xEA;
	rom[0xB2] = 0x96;
	snprintf(path, sizeof(path), "%s/lock_probe.gba", dir);
	expect(writeFile(path, rom, sizeof(rom)), "lock: write gba rom");

	emu = mgbaMobileCreate(dir, dir, "lock");
	expect(mgbaMobileLoad(emu, path), "lock: load gba");

	probe.emu = emu;
	probe.done = 0;
	mgbaMobileLock(emu);
	expect(pthread_create(&thread, NULL, lockProbeFrames, &probe) == 0,
	       "lock: probe thread started");
	linkSleepMs(250);
	expect(!probe.done, "lock: run frames blocks while the core lock is held");
	mgbaMobileUnlock(emu);
	pthread_join(thread, NULL);
	expect(probe.done, "lock: run frames finishes after the lock is released");
	mgbaMobileDestroy(emu);
}


struct BusRoundArg {
	struct NetLink* link;
	uint16_t index;
	uint32_t own;
	uint32_t values[4];
	int got;
	uint16_t used;
};

static void* busRoundThread(void* arg) {
	struct BusRoundArg* a = (struct BusRoundArg*) arg;
	/* 等待窗给足 8s：这些用例是 4 个线程在同一个进程里跑，机器满载（比如同时
	 * 在编 PC 端）时一轮里某一端晚到几百毫秒是正常的，2s 会偶发误判。等待窗
	 * 只影响「慢到异常」的那一次，判据本身不变。 */
	a->got = netLinkBusRound(a->link, a->index, a->own, a->values, 4, 8000, &a->used);
	return NULL;
}

/* 3/4 人总线（星型汇聚）回归。
 *
 * 四项断言各自对应一个真实缺陷面：
 *   1. 主机 accept 多连接、按接入顺序分配槽位 —— 原来 listen(fd, 1) 只收一个。
 *   2. 每个从机能拿到「总人数」—— 只靠 TCP 连上是拿不到的，必须主机在
 *      WELCOME 里告知。
 *   3. 每一轮四个槽位的数据在四台机器上完全一致 —— 这是 3/4 人联机能进行
 *      SIOMULTI 握手的充要条件（原来 data[2]/data[3] 永远是 0xFFFF）。
 *   4. players == 2 时不启用总线 —— 保证已验证的双人直连路径不被改动波及。 */
static void testBusPlayers(void) {
	int port = 18791;
	struct NetLink* host = netLinkCreate();
	struct NetLink* guest[3];
	struct NetLink* duo = netLinkCreate();
	int i;
	int k;
	const uint32_t base[4] = { 0x1000u, 0x1100u, 0x1200u, 0x1300u };

	expect(netLinkBusHost(host, port, 4), "bus host up for 4 players");
	for (i = 0; i < 3; ++i) {
		int ok = 0;
		int tries;
		guest[i] = netLinkCreate();
		for (tries = 0; tries < 60 && !ok; ++tries) {
			ok = netLinkBusJoin(guest[i], "127.0.0.1", port);
			if (!ok) {
				linkSleepMs(20);
			}
		}
		expect(ok, "bus join");
		{
			int seen = 0;
			for (tries = 0; tries < 300; ++tries) {
				if (netLinkBusPlayers(host) >= i + 2) {
					seen = 1;
					break;
				}
				linkSleepMs(10);
			}
			expect(seen, "bus host accepted peer");
		}
		{
			int slot = -1;
			int ready = 0;
			for (tries = 0; tries < 300; ++tries) {
				if (netLinkState(guest[i]) == 2) {
					slot = netLinkPlayer(guest[i]);
					ready = 1;
					break;
				}
				linkSleepMs(10);
			}
			expect(ready, "bus joiner welcomed");
			expect(slot == i + 1, "bus slot assigned in accept order");
			expect(netLinkBusPlayers(guest[i]) == 4, "bus joiner learns player count");
		}
	}
	expect(netLinkBusPlayers(host) == 4, "bus host sees 4 players");

	{
		int rounds = 40;
		int agree = 0;
		for (k = 0; k < rounds; ++k) {
			struct BusRoundArg args[4];
			pthread_t th[4];
			int okRound = 1;
			for (i = 0; i < 4; ++i) {
				args[i].link = i == 0 ? host : guest[i - 1];
				args[i].index = (uint16_t) k;
				args[i].own = base[i] + (uint32_t) k;
				args[i].got = 0;
				args[i].used = 0;
				for (int s = 0; s < 4; ++s) {
					args[i].values[s] = 0;
				}
				pthread_create(&th[i], NULL, busRoundThread, &args[i]);
			}
			for (i = 0; i < 4; ++i) {
				pthread_join(th[i], NULL);
			}
			for (i = 0; i < 4; ++i) {
				if (args[i].got != 3) {
					okRound = 0;
				}
				if (args[i].used != (uint16_t) k) {
					okRound = 0;
				}
				for (int s = 0; s < 4; ++s) {
					if (args[i].values[s] != base[s] + (uint32_t) k) {
						okRound = 0;
					}
				}
			}
			if (okRound) {
				++agree;
			} else if (agree + 1 == k + 1) {
				/* 只报第一轮不一致，省得 40 轮把输出刷满。 */
				fprintf(stderr, "bus round %d mismatch:", k);
				for (i = 0; i < 4; ++i) {
					fprintf(stderr, " [p%d got=%d used=%u %04X %04X %04X %04X]", i,
					        args[i].got, (unsigned) args[i].used,
					        (unsigned) args[i].values[0], (unsigned) args[i].values[1],
					        (unsigned) args[i].values[2], (unsigned) args[i].values[3]);
				}
				fprintf(stderr, "\n");
			}
		}
		expect(agree == rounds, "bus 4-player rounds agree on all four slots");
	}

	/* 两人场景必须仍然走原来的直连路径：总线模式不得被打开。 */
	expect(netLinkBusHost(duo, 18792, 2), "duo host up");
	expect(!netLinkBusActive(duo), "duo keeps the direct 2-player path off the bus");

	netLinkDestroy(duo);
	for (i = 0; i < 3; ++i) {
		netLinkDestroy(guest[i]);
	}
	netLinkDestroy(host);
}

/* ---- 进程内总线（同进程 N 核，无 socket）----------------------------------
 *
 * TCP 星型总线在 busgame 里暴露的是两个独立缺陷：full=0（从机轮次索引不
 * 收敛）和 5.6fps（每轮 2ms 超时地板）。这里的断言直接对着这两件事：
 *   - 从机故意传一个与主机完全不同的 index，仍必须每轮采用主机轮次号；
 *   - full == rounds、empty == 0、future == 0、四个槽位逐字一致；
 *   - 120 轮墙钟必须远小于「每轮都付 2ms 地板」的量级。
 * 连续三个 case 复用同一个 LocalBus 槽位，覆盖会话结束后 mutex/cond 不能
 * 被 memset 后重复 init 的边界。 */
#define LOCALBUS_TEST_MAX 4

struct LocalBusBarrier {
	pthread_mutex_t mu;
	pthread_cond_t cv;
	int need;
	int arrived;
	int gen;
};

struct LocalBusArg {
	struct NetLink* link;
	struct LocalBusBarrier* barrier;
	int slot;
	int players;
	int rounds;
	int okRounds;
	int badIndex;
	int badWords;
};

static uint64_t localBusNowMs(void) {
#ifdef _WIN32
	return (uint64_t) GetTickCount64();
#else
	struct timespec ts;
	clock_gettime(CLOCK_MONOTONIC, &ts);
	return (uint64_t) ts.tv_sec * 1000u + (uint64_t) (ts.tv_nsec / 1000000);
#endif
}

static uint32_t localBusWord(int r, int slot) {
	return 0x1000u + (uint32_t) (r * 0x10) + (uint32_t) slot;
}

/* 从机拿到 -1 表示「主机还没开这一轮」，生产路径靠重新挂载模拟时钟事件，
 * 不吃墙钟。测试里也不能 sleep 1ms，否则测得的是测试自身退避而不是会合成本。 */
static void localBusYield(void) {
#ifdef _WIN32
	SwitchToThread();
#else
	struct timespec ts = { 0, 1000L };
	nanosleep(&ts, NULL);
#endif
}

static void localBusBarrierInit(struct LocalBusBarrier* b, int need) {
	pthread_mutex_init(&b->mu, NULL);
	pthread_cond_init(&b->cv, NULL);
	b->need = need;
	b->arrived = 0;
	b->gen = 0;
}

static void localBusBarrierWait(struct LocalBusBarrier* b) {
	pthread_mutex_lock(&b->mu);
	int gen = b->gen;
	if (++b->arrived >= b->need) {
		b->arrived = 0;
		++b->gen;
		pthread_cond_broadcast(&b->cv);
	} else {
		while (gen == b->gen) {
			pthread_cond_wait(&b->cv, &b->mu);
		}
	}
	pthread_mutex_unlock(&b->mu);
}

static void* localBusThread(void* arg) {
	struct LocalBusArg* a = (struct LocalBusArg*) arg;
	int r;
	for (r = 1; r <= a->rounds; ++r) {
		uint32_t vals[LOCALBUS_TEST_MAX];
		uint16_t used = 0;
		int ret = -1;
		int tries = 0;
		/* 主机是唯一时钟源：从机传的 index 故意和主机差很远。 */
		uint16_t bogus = a->slot == 0 ? (uint16_t) r
		                              : (uint16_t) (r * 7u + 1000u);
		localBusBarrierWait(a->barrier);
		while (ret < 0 && tries++ < 20000) {
			int i;
			for (i = 0; i < LOCALBUS_TEST_MAX; ++i) {
				vals[i] = 0xDEADu;
			}
			ret = netLinkBusRound(a->link, bogus, localBusWord(r, a->slot),
			                      vals, a->players, 200, &used);
			if (ret < 0) {
				localBusYield();
			}
		}
		if (ret >= 0 && used == (uint16_t) r) {
			++a->okRounds;
		} else {
			++a->badIndex;
		}
		{
			int s;
			for (s = 0; s < LOCALBUS_TEST_MAX; ++s) {
				uint32_t want = s < a->players ? localBusWord(r, s) : 0xFFFFu;
				if (vals[s] != want) {
					++a->badWords;
				}
			}
		}
		localBusBarrierWait(a->barrier);
	}
	return NULL;
}

static void testBusLocalCase(int players, int key, int rounds) {
	struct NetLink* links[LOCALBUS_TEST_MAX];
	struct LocalBusArg args[LOCALBUS_TEST_MAX];
	pthread_t th[LOCALBUS_TEST_MAX];
	struct LocalBusBarrier barrier;
	char label[160];
	int32_t diag[7];
	uint64_t totalUs;
	uint64_t t0;
	uint64_t elapsed;
	int slaveCalls;
	int i;

	for (i = 0; i < players; ++i) {
		links[i] = netLinkCreate();
	}
	snprintf(label, sizeof(label), "local bus %dp: host up (key=%d)", players, key);
	expect(netLinkBusHostLocal(links[0], key, players), label);
	for (i = 1; i < players; ++i) {
		snprintf(label, sizeof(label), "local bus %dp: join slot %d", players, i);
		expect(netLinkBusJoinLocal(links[i], key), label);
		expect(netLinkPlayer(links[i]) == i, "local bus: slot is assigned in join order");
	}
	expect(netLinkBusActive(links[0]), "local bus: active without any socket");
	expect(netLinkBusPlayers(links[players - 1]) == players,
	       "local bus: joiner learns the player count");
	expect(netLinkState(links[0]) == 2, "local bus: state is connected");

	localBusBarrierInit(&barrier, players);
	for (i = 0; i < players; ++i) {
		args[i].link = links[i];
		args[i].barrier = &barrier;
		args[i].slot = i;
		args[i].players = players;
		args[i].rounds = rounds;
		args[i].okRounds = 0;
		args[i].badIndex = 0;
		args[i].badWords = 0;
	}
	t0 = localBusNowMs();
	for (i = 0; i < players; ++i) {
		expect(pthread_create(&th[i], NULL, localBusThread, &args[i]) == 0,
		       "local bus: worker started");
	}
	for (i = 0; i < players; ++i) {
		pthread_join(th[i], NULL);
	}
	elapsed = localBusNowMs() - t0;

	for (i = 0; i < players; ++i) {
		expect(args[i].okRounds == rounds, "local bus: every round completed");
		expect(args[i].badIndex == 0, "local bus: master round index adopted");
		expect(args[i].badWords == 0, "local bus: all slots agree");
	}
	netLinkBusDiag(links[0], diag);
	netLinkBusDiagTiming(links[0], &totalUs, &slaveCalls);
	expect(diag[0] == rounds, "local bus: diag round count");
	expect(diag[1] == rounds, "local bus: every round full");
	expect(diag[2] == 0, "local bus: no empty rounds");
	expect(diag[3] == 0, "local bus: no stale pushes");
	expect(diag[4] == 0, "local bus: no future pushes");
	expect(diag[5] == 0 && diag[6] == 0, "local bus: round lead is exactly zero");
	/* 会合内部累计墙钟按「每轮每核」摊：TCP 星型总线每轮吃满 2ms 地板，
	 * 这里必须低一个数量级。端到端 elapsed 含测试自身的 barrier / 重试退避，
	 * 只作宽松兜底。 */
	expect(totalUs < (uint64_t) rounds * (uint64_t) players * 1000u,
	       "local bus: no per-round 2ms wait floor");
	expect((int64_t) elapsed < (int64_t) rounds * 15,
	       "local bus: end-to-end rounds stay fast");
	fprintf(stderr, "[local-bus] players=%d key=%d rounds=%d elapsed=%llums inside=%lluus slaveCalls=%d diag=%d/%d/%d/%d/%d/%d/%d\n",
	        players, key, rounds, (unsigned long long) elapsed,
	        (unsigned long long) totalUs, slaveCalls,
	        diag[0], diag[1], diag[2], diag[3], diag[4], diag[5], diag[6]);

	/* 从机先退出，主机最后一个：host 的 detach 会释放槽位并叫醒所有等待者。 */
	for (i = 1; i < players; ++i) {
		netLinkDestroy(links[i]);
	}
	netLinkDestroy(links[0]);
	pthread_mutex_destroy(&barrier.mu);
	pthread_cond_destroy(&barrier.cv);
}

/* 指定槽位 join：多台设备各跑 N 核时，本机可见核必须占它在全局会话里的
 * 那个槽位。乱序占用、冲突拒绝、释放后复用都要覆盖。 */
static void testBusLocalSlots(void) {
	const int key = 91004;
	struct NetLink* links[4];
	struct NetLink* spare = netLinkCreate();
	int i;
	for (i = 0; i < 4; ++i) {
		links[i] = netLinkCreate();
	}
	expect(netLinkBusHostLocal(links[0], key, 4), "local bus: host up");
	expect(netLinkBusIsLocal(links[0]), "local bus: host reports local mode");
	expect(netLinkBusLocalSlot(links[0]) == 0, "local bus: host owns link slot 0");
	expect(netLinkBusJoinLocalSlot(links[2], key, 2),
	       "local bus: slot 2 can be claimed out of order");
	expect(netLinkBusLocalSlot(links[2]) == 2, "local bus: claimed slot recorded");
	expect(!netLinkBusJoinLocalSlot(spare, key, 2),
	       "local bus: duplicate slot is rejected");
	expect(!netLinkBusJoinLocalSlot(spare, key, 0),
	       "local bus: host slot is reserved");
	expect(!netLinkBusJoinLocalSlot(spare, key, 4),
	       "local bus: slot beyond player count is rejected");
	expect(!netLinkBusJoinLocalSlot(spare, 987654, 1),
	       "local bus: unknown key is rejected for a slot join");
	expect(netLinkBusJoinLocalSlot(links[1], key, 1),
	       "local bus: slot 1 can be claimed after slot 2");
	expect(netLinkBusJoinLocalSlot(links[3], key, 3),
	       "local bus: slot 3 can be claimed last");
	expect(netLinkBusPlayers(links[0]) == 4, "local bus: all four slots attached");
	/* 退出某个从机后，它的槽位必须能被重新占用。 */
	netLinkDestroy(links[2]);
	expect(netLinkBusJoinLocalSlot(spare, key, 2),
	       "local bus: freed slot can be reused");
	expect(netLinkBusLocalSlot(spare) == 2, "local bus: reused slot recorded");

	netLinkDestroy(spare);
	netLinkDestroy(links[1]);
	netLinkDestroy(links[3]);
	netLinkDestroy(links[0]);
}

static void testBusLocal(void) {
	struct NetLink* stray = netLinkCreate();
	expect(!netLinkBusJoinLocal(stray, 987654), "local bus: unknown key is rejected");
	netLinkDestroy(stray);
	testBusLocalCase(4, 91001, 120);
	testBusLocalCase(3, 91002, 120);
	testBusLocalCase(4, 91003, 120);
	testBusLocalSlots();
}

/* 3 人总线：人数少于 4 时，第 4 个槽位必须是空槽 0xFFFF。
 * 这条和四点用例是两件事：四点测「四个槽都能填对」，三点测「人数不足时
 * 不能把别人的字错填进多余的槽」——后者一旦错了，游戏的玩家数判定会多出
 * 一个人，握手直接失败。 */
static void testBusThree(void) {
	int port = 18793;
	struct NetLink* host = netLinkCreate();
	struct NetLink* guest[2];
	const uint32_t base[3] = { 0x2000u, 0x2100u, 0x2200u };
	int i;
	int k;

	expect(netLinkBusHost(host, port, 3), "bus host up for 3 players");
	for (i = 0; i < 2; ++i) {
		int ok = 0;
		int tries;
		guest[i] = netLinkCreate();
		for (tries = 0; tries < 60 && !ok; ++tries) {
			ok = netLinkBusJoin(guest[i], "127.0.0.1", port);
			if (!ok) {
				linkSleepMs(20);
			}
		}
		expect(ok, "bus3 join");
		for (tries = 0; tries < 300; ++tries) {
			if (netLinkState(guest[i]) == 2) {
				break;
			}
			linkSleepMs(10);
		}
		expect(netLinkBusPlayers(guest[i]) == 3, "bus3 joiner learns 3 players");
	}
	expect(netLinkBusPlayers(host) == 3, "bus3 host sees 3 players");

	{
		int okRound = 1;
		for (k = 0; k < 20; ++k) {
			struct BusRoundArg args[3];
			pthread_t th[3];
			for (i = 0; i < 3; ++i) {
				args[i].link = i == 0 ? host : guest[i - 1];
				args[i].index = (uint16_t) k;
				args[i].own = base[i] + (uint32_t) k;
				args[i].got = 0;
				args[i].used = 0;
				for (int s = 0; s < 4; ++s) {
					args[i].values[s] = 0;
				}
				pthread_create(&th[i], NULL, busRoundThread, &args[i]);
			}
			for (i = 0; i < 3; ++i) {
				pthread_join(th[i], NULL);
			}
			for (i = 0; i < 3; ++i) {
				if (args[i].got != 2) {
					okRound = 0;
				}
				if (args[i].used != (uint16_t) k) {
					okRound = 0;
				}
				for (int s = 0; s < 3; ++s) {
					if (args[i].values[s] != base[s] + (uint32_t) k) {
						okRound = 0;
					}
				}
				if (args[i].values[3] != 0xFFFFu) {
					okRound = 0;
				}
			}
		}
		expect(okRound, "bus3 third slot stays empty");
	}

	for (i = 0; i < 2; ++i) {
		netLinkDestroy(guest[i]);
	}
	netLinkDestroy(host);
}

/* 4 人房只来了 1 个从机：链路必须仍然按总线跑。
 *
 * 这条用例针对一个真实踩过的坑：如果「是否走总线」按人数判（== 2 就当成两人
 * 直连），那么 1 个从机时正好是 2 人，会掉进直连分支去 peerQ 里取字 —— 而总线
 * 的字根本不进 peerQ，对端永远「没有回字」，一轮都过不去。 */
static void testBusSinglePeer(void) {
	int port = 18794;
	struct NetLink* host = netLinkCreate();
	struct NetLink* guest = netLinkCreate();
	int i;
	int tries;
	int ok = 0;

	expect(netLinkBusHost(host, port, 4), "bus1 host up for 4 players");
	for (tries = 0; tries < 60 && !ok; ++tries) {
		ok = netLinkBusJoin(guest, "127.0.0.1", port);
		if (!ok) {
			linkSleepMs(20);
		}
	}
	expect(ok, "bus1 join");
	for (tries = 0; tries < 300; ++tries) {
		if (netLinkState(guest) == 2) {
			break;
		}
		linkSleepMs(10);
	}
	expect(netLinkBusPlayers(host) == 2, "bus1 host sees the single peer");
	expect(netLinkBusActive(host) && netLinkBusActive(guest), "bus1 stays on the bus with one peer");

	{
		int okRound = 1;
		for (i = 0; i < 10; ++i) {
			struct BusRoundArg args[2];
			pthread_t th[2];
			int k;
			for (k = 0; k < 2; ++k) {
				args[k].link = k == 0 ? host : guest;
				args[k].index = (uint16_t) i;
				args[k].own = (k == 0 ? 0x3000u : 0x3100u) + (uint32_t) i;
				args[k].got = 0;
				args[k].used = 0;
				for (int s = 0; s < 4; ++s) {
					args[k].values[s] = 0;
				}
				pthread_create(&th[k], NULL, busRoundThread, &args[k]);
			}
			for (k = 0; k < 2; ++k) {
				pthread_join(th[k], NULL);
			}
			for (k = 0; k < 2; ++k) {
				if (args[k].got != 1 || args[k].used != (uint16_t) i) {
					okRound = 0;
				}
				if (args[k].values[0] != 0x3000u + (uint32_t) i
				    || args[k].values[1] != 0x3100u + (uint32_t) i) {
					okRound = 0;
				}
				if (args[k].values[2] != 0xFFFFu || args[k].values[3] != 0xFFFFu) {
					okRound = 0;
				}
			}
		}
		expect(okRound, "bus1 round works with a single peer");
	}

	netLinkDestroy(guest);
	netLinkDestroy(host);
}

/* 总线会话里必须让两人路径的入口失效。
 *
 * `serviceLink` 每次轮询都会调 `netLinkPingTick`。总线从机的 `sock >= 0` 且
 * `state == CONNECTED`，如果不拦，它就按两人格式（20 字节 `struct Packet`）
 * 往总线连接上写 —— 对端按 28 字节 `BusPacket` 解析就读到垃圾。现场症状是
 * 主机报 `Link bus bad magic=00000000` 然后掉线，端到端表现为「连上了但一秒
 * 就断」。
 *
 * 这条用例在总线会话里持续调用这些入口，然后断言链路还活着、轮次仍然一致。 */
static void testBusIgnoresPointToPoint(void) {
	int port = 18795;
	struct NetLink* host = netLinkCreate();
	struct NetLink* guest = netLinkCreate();
	int i;
	int k;
	int tries;
	int ok = 0;
	int rejected = 1;
	int rounds = 12;
	int agree = 0;

	expect(netLinkBusHost(host, port, 3), "bus-p2p host up");
	for (tries = 0; tries < 60 && !ok; ++tries) {
		ok = netLinkBusJoin(guest, "127.0.0.1", port);
		if (!ok) {
			linkSleepMs(20);
		}
	}
	expect(ok, "bus-p2p join");
	for (tries = 0; tries < 300; ++tries) {
		if (netLinkState(host) == 2 && netLinkState(guest) == 2) {
			break;
		}
		linkSleepMs(10);
	}

	for (k = 0; k < rounds; ++k) {
		struct BusRoundArg args[2];
		pthread_t th[2];
		int okRound = 1;
		/* 模拟 serviceLink 的高频轮询：两人专用入口必须什么也不做。 */
		for (i = 0; i < 30; ++i) {
			uint32_t remote = 0;
			netLinkPingTick(host);
			netLinkPingTick(guest);
			if (netLinkExchange(host, 2, 0x1234u, &remote, 0)) {
				rejected = 0;
			}
			if (netLinkBarrier(host, 0)) {
				rejected = 0;
			}
		}
		for (i = 0; i < 2; ++i) {
			args[i].link = i == 0 ? host : guest;
			args[i].index = (uint16_t) k;
			args[i].own = (i == 0 ? 0x4000u : 0x4100u) + (uint32_t) k;
			args[i].got = 0;
			args[i].used = 0;
			for (int s = 0; s < 4; ++s) {
				args[i].values[s] = 0;
			}
			pthread_create(&th[i], NULL, busRoundThread, &args[i]);
		}
		for (i = 0; i < 2; ++i) {
			pthread_join(th[i], NULL);
		}
		for (i = 0; i < 2; ++i) {
			if (args[i].got != 1 || args[i].used != (uint16_t) k) {
				okRound = 0;
			}
			if (args[i].values[0] != 0x4000u + (uint32_t) k
			    || args[i].values[1] != 0x4100u + (uint32_t) k) {
				okRound = 0;
			}
		}
		if (okRound) {
			++agree;
		}
	}

	expect(rejected, "bus rejects point-to-point exchange and barrier");
	expect(netLinkState(host) == 2 && netLinkState(guest) == 2,
	       "bus link survives point-to-point pings");
	expect(agree == rounds, "bus rounds still agree with pings in flight");

	netLinkDestroy(guest);
	netLinkDestroy(host);
}

/* 四槽装配规则（`netLinkBusSlots`，纯函数）。
 *
 * 这是 3/4 人联机里最容易错、也最致命的一处：把不该填的槽填上，游戏会数出
 * 多余玩家；把该填的槽漏掉，玩家数就是 2 —— 正好是「只填 data[0]/data[1]」
 * 那个原始缺陷的形态。六条用例逐条钉住规则。 */
static void testBusSlots(void) {
	uint16_t out[4];
	int ok;

	{
		const uint32_t v[4] = { 0x1111u, 0x2222u, 0x3333u, 0x4444u };
		netLinkBusSlots(v, 4, 0, 0x1111, out);
		ok = out[0] == 0x1111 && out[1] == 0x2222 && out[2] == 0x3333 && out[3] == 0x4444;
		expect(ok, "bus slots: four players copy every slot");
	}
	{
		/* 第 4 个槽里塞了脏数据，但人数是 3 —— 必须被 0xFFFF 覆盖。 */
		const uint32_t v[4] = { 0x1111u, 0x2222u, 0x3333u, 0xDEADu };
		netLinkBusSlots(v, 3, 1, 0x2222, out);
		ok = out[0] == 0x1111 && out[1] == 0x2222 && out[2] == 0x3333 && out[3] == 0xFFFF;
		expect(ok, "bus slots: three players leave slot 3 empty");
	}
	{
		const uint32_t v[4] = { 0x1111u, 0x2222u, 0xDEADu, 0xDEADu };
		netLinkBusSlots(v, 2, 1, 0x2222, out);
		ok = out[0] == 0x1111 && out[1] == 0x2222 && out[2] == 0xFFFF && out[3] == 0xFFFF;
		expect(ok, "bus slots: two players leave slots 2/3 empty");
	}
	{
		/* 广播里自己那份是旧值 —— 必须被本机这一轮的字覆盖。 */
		const uint32_t v[4] = { 0x1111u, 0x2222u, 0x3333u, 0x4444u };
		netLinkBusSlots(v, 4, 2, 0x9999, out);
		ok = out[0] == 0x1111 && out[1] == 0x2222 && out[2] == 0x9999 && out[3] == 0x4444;
		expect(ok, "bus slots: own slot always uses the local word");
	}
	{
		/* 链路还没连上时 player 号可能是 -1：不许越界写，也不许改任何槽。 */
		const uint32_t v[4] = { 0x1111u, 0x2222u, 0x3333u, 0x4444u };
		netLinkBusSlots(v, 4, -1, 0x9999, out);
		ok = out[0] == 0x1111 && out[1] == 0x2222 && out[2] == 0x3333 && out[3] == 0x4444;
		expect(ok, "bus slots: invalid player id overrides nothing");
	}
	{
		const uint32_t v[4] = { 0x1111u, 0x2222u, 0x3333u, 0x4444u };
		netLinkBusSlots(v, 4, 4, 0x9999, out);
		ok = out[0] == 0x1111 && out[3] == 0x4444;
		expect(ok, "bus slots: player id 4 does not write past the array");
	}
}



/* 槽位复用：4 人房里有人掉线后重连，新玩家必须拿到空出来的槽。
 *
 * 原来槽位来自单调递增的计数器：3 个从机占满 1/2/3，2 号位掉线后重连的
 * 第 4 个连接会分到 **4 号槽**。而槽位只认 0..3，4 号会被
 * netLinkBusRound 的边界判断静默忽略 —— 新玩家连得上、握手也过，但永远
 * 收不到任何数据，也没有任何报错。 */
static void testBusSlotReuse(void) {
	int port = 18798;
	struct NetLink* host = netLinkCreate();
	struct NetLink* peer[3];
	struct NetLink* rejoin;
	int i;
	int tries;
	int ok = 0;
	int slotsOk = 1;

	expect(netLinkBusHost(host, port, 4), "bus-slot host up for 4 players");
	for (i = 0; i < 3; ++i) {
		ok = 0;
		peer[i] = netLinkCreate();
		for (tries = 0; tries < 60 && !ok; ++tries) {
			ok = netLinkBusJoin(peer[i], "127.0.0.1", port);
			if (!ok) {
				linkSleepMs(20);
			}
		}
		expect(ok, "bus-slot join");
		for (tries = 0; tries < 300; ++tries) {
			if (netLinkState(peer[i]) == 2 && netLinkBusPlayers(host) == i + 2) {
				break;
			}
			linkSleepMs(10);
		}
		if (netLinkPlayer(peer[i]) != i + 1) {
			slotsOk = 0;
		}
	}
	expect(slotsOk, "bus-slot first three peers take slots 1/2/3");

	/* 2 号位掉线。 */
	netLinkDestroy(peer[1]);
	peer[1] = NULL;
	for (tries = 0; tries < 300; ++tries) {
		if (netLinkBusPlayers(host) == 3) {
			break;
		}
		linkSleepMs(10);
	}
	expect(netLinkBusPlayers(host) == 3, "bus-slot host notices the dropped peer");

	/* 新玩家补进来，必须拿到 2 号槽。 */
	rejoin = netLinkCreate();
	ok = 0;
	for (tries = 0; tries < 60 && !ok; ++tries) {
		ok = netLinkBusJoin(rejoin, "127.0.0.1", port);
		if (!ok) {
			linkSleepMs(20);
		}
	}
	expect(ok, "bus-slot rejoin");
	for (tries = 0; tries < 300; ++tries) {
		if (netLinkState(rejoin) == 2) {
			break;
		}
		linkSleepMs(10);
	}
	expect(netLinkPlayer(rejoin) == 2, "bus-slot rejoin reuses the freed slot 2");
	expect(netLinkBusPlayers(host) == 4, "bus-slot host is back to four players");

	/* 一轮聚合验证四个槽都真的能填：掉线重连之后仍然是一局完整的 4 人。 */
	{
		struct BusRoundArg args[4];
		pthread_t th[4];
		const uint32_t base[4] = { 0x8000u, 0x8100u, 0x8200u, 0x8300u };
		int okRound = 1;
		args[0].link = host;
		args[1].link = peer[0];
		args[2].link = rejoin;
		args[3].link = peer[2];
		for (i = 0; i < 4; ++i) {
			args[i].index = 0;
			args[i].own = base[i];
			args[i].got = 0;
			args[i].used = 0;
			for (int s = 0; s < 4; ++s) {
				args[i].values[s] = 0;
			}
			pthread_create(&th[i], NULL, busRoundThread, &args[i]);
		}
		for (i = 0; i < 4; ++i) {
			pthread_join(th[i], NULL);
		}
		for (i = 0; i < 4; ++i) {
			if (args[i].got != 3) {
				okRound = 0;
			}
			for (int s = 0; s < 4; ++s) {
				if (args[i].values[s] != base[s]) {
					okRound = 0;
				}
			}
		}
		expect(okRound, "bus-slot four players still agree after a rejoin");
	}

	netLinkDestroy(rejoin);
	for (i = 0; i < 3; ++i) {
		if (peer[i]) {
			netLinkDestroy(peer[i]);
		}
	}
	netLinkDestroy(host);
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

/* 进程内锁步 SIO 的 C 层契约测试。不加载 ROM、不跑帧（游戏侧由 PC 的
 * busgame-lockstep 端到端验证）；这里钉住房共享、槽位 ID、协调器设备 ID、
 * sleep/wake 非阻塞语义、拆离与房间复用，避免产品接线时踩空。 */
static void testLockstep(const char* romPath) {
	const int key = 0x4C53;   /* "LS" */
	const int players = 4;
	struct mCore* cores[4] = {0};
	struct MgbaLockstepSlot* slots[4] = {0};
	struct MgbaLockstepRoom* rooms[4] = {0};

	for (int i = 0; i < players; ++i) {
		cores[i] = mCoreCreate(mPLATFORM_GBA);
		expect(cores[i] != NULL, "lockstep: core created");
		if (cores[i]) {
			cores[i]->init(cores[i]);
			/* 和 loadRomForBusTest 一致：不 loadROM 就 reset 会访问未初始化
			 * 的 ROM 映射而段错误。 */
			expect(mCoreLoadFile(cores[i], romPath), "lockstep: rom loaded");
		}
	}
	rooms[0] = mgbaLockstepHost(key, players);
	expect(rooms[0] != NULL, "lockstep: host created room");
	for (int i = 1; i < players; ++i) {
		rooms[i] = mgbaLockstepJoin(key);
		expect(rooms[i] == rooms[0], "lockstep: join shares the same room");
	}
	expect(mgbaLockstepJoin(key + 1) == NULL, "lockstep: unknown key rejected");
	expect(mgbaLockstepHost(key, players) == NULL, "lockstep: duplicate host rejected");

	for (int i = 0; i < players; ++i) {
		slots[i] = mgbaLockstepAttach(rooms[0], cores[i], i);
		expect(slots[i] != NULL, "lockstep: core attached");
		expect(mgbaLockstepSlotId(slots[i]) == i, "lockstep: slot id preserved");
	}
	expect(mgbaLockstepAttached(rooms[0]) == (size_t) players,
	       "lockstep: coordinator has all players");

	/* 设备 ID 由协调器按 requestedId 分配，必须是 0..3。
	 * 注意 _GBACoreGetPeripheral 没实现 mPERIPH_GBA_LINK_PORT（直接返回 NULL），
	 * 必须从 gba->sio.driver 读。 */
	for (int i = 0; i < players; ++i) {
		struct GBA* gba = (struct GBA*) cores[i]->board;
		struct GBASIODriver* d = gba->sio.driver;
		expect(d != NULL && d->deviceId && d->deviceId(d) == i,
		       "lockstep: device id matches requested slot");
	}

	/* sleep 只是非阻塞请求，wake 清除并通知，都不阻塞调用方。 */
	for (int i = 0; i < players; ++i) {
		mgbaLockstepUserSleep(slots[i]);
		expect(mgbaLockstepPaused(slots[i]), "lockstep: sleep requests pause");
		mgbaLockstepUserWake(slots[i]);
		expect(!mgbaLockstepPaused(slots[i]), "lockstep: wake clears pause");
	}

	for (int i = 0; i < players; ++i) {
		mgbaLockstepDetach(slots[i]);
	}
	expect(mgbaLockstepAttached(rooms[0]) == 0, "lockstep: detach removes all players");
	for (int i = 0; i < players; ++i) {
		mgbaLockstepRelease(rooms[i]);
	}
	struct MgbaLockstepRoom* again = mgbaLockstepHost(key, players);
	expect(again != NULL, "lockstep: room reusable after all releases");
	mgbaLockstepRelease(again);

	for (int i = 0; i < players; ++i) {
		if (cores[i]) {
			cores[i]->deinit(cores[i]);
		}
	}
}

/*
 * 产品侧集成验证：直接走 mgba_mobile.c 的锁步 API（mgbaMobileLinkHostLockstep /
 * JoinLockstep + mobileRunFramesLocked 的小步 runLoop），而不是 link_lockstep.c
 * 的底层 API。这是 4 核 GBoyConsoleSet 在设备上的真实代码路径，之前从未被任何
 * 测试驱动过。
 *
 * 验证三件事：
 *  1) 4 个 MgbaMobile 实例经 Host/Join 全部 attach，且帧循环不互相死锁（帧号都推进）。
 *  2) 真实 SIO MULTI 传输：每核写不同 SIOMLT_SEND，主机发起 START，协调器收齐后
 *     回写 SIOMULTI0..3 —— 4 核都应收到全部 4 个字。
 *  3) 拆离顺序正确（Close/Destroy 不空指针）。
 */
struct LockstepRunCtx {
	struct MgbaMobile* emu;
	int slot;
	int players;
	int frames;
	uint32_t sendWord;       /* 本核要发的字 */
	uint32_t recv[4];        /* 收齐后读到的 SIOMULTI0..3 */
	uint32_t finalFrame;     /* 跑完后的帧号 */
	int everClean;           /* 是否观察过一次 4 字全非 0xFFFF 的完整传输 */
};

/* 墙钟看门狗：到点强制结束 4 核帧循环，避免测试进程被 SIGTERM。
 * 主流程正常收尾时必须通过 g_lsrDone 提前唤醒它 —— 旧实现是无条件
 * sleep(30s) 再置 abort，导致「明明 4 核都跑完了，却因为 join 满 30s
 * 而被标记 aborted」的假失败，还让每次测试白等 30 秒。 */
static volatile int g_lsrAbort = 0;
static volatile int g_lsrDone = 0;
static volatile int g_lsrStop = 0;
static volatile int g_lsrCleanCount = 0;
static pthread_mutex_t g_lsrWdMu = PTHREAD_MUTEX_INITIALIZER;
static pthread_cond_t g_lsrWdCv = PTHREAD_COND_INITIALIZER;
static pthread_mutex_t g_lsrDataMu = PTHREAD_MUTEX_INITIALIZER;
static pthread_cond_t g_lsrDataCv = PTHREAD_COND_INITIALIZER;

static void* _lsrWatchdog(void* arg) {
	long ms = *(long*) arg;
	struct timespec ts;
	clock_gettime(CLOCK_REALTIME, &ts);
	ts.tv_sec += ms / 1000;
	ts.tv_nsec += (ms % 1000) * 1000000L;
	if (ts.tv_nsec >= 1000000000L) {
		ts.tv_nsec -= 1000000000L;
		++ts.tv_sec;
	}
	pthread_mutex_lock(&g_lsrWdMu);
	while (!g_lsrDone) {
		if (pthread_cond_timedwait(&g_lsrWdCv, &g_lsrWdMu, &ts) == ETIMEDOUT) {
			break;
		}
	}
	if (!g_lsrDone) {
		g_lsrAbort = 1;
		mgbaLockstepSetAbort(1);
	}
	pthread_mutex_unlock(&g_lsrWdMu);
	return NULL;
}

/* 压掉 mGBA 内部冗余日志（BIOS SWI / GBA_SIO DEBUG 一次能刷几 MB，把 4 个
 * 帧循环拖到超时）。mGBA 在没有任何默认 logger 时会 fallback 到 printf，所以
 * 这里直接装一个「什么都不打印」的默认 logger，彻底静音（expect 自己的
 * 输出走 fprintf，不受影响）。 */
static void _silentLog(struct mLogger* logger, int category, enum mLogLevel level,
                       const char* format, va_list args) {
	(void) logger;
	(void) category;
	/* DEBUG/STUB 每个 SIO 轮次都会刷、4 核并发能把帧循环拖垮，必须压掉；
	 * 但 WARN 以上保留，否则看不到协调器为什么拒绝/中止一次传输。 */
	if (level & (mLOG_FATAL | mLOG_ERROR | mLOG_WARN | mLOG_GAME_ERROR)) {
		vfprintf(stderr, format, args);
		fputc('\n', stderr);
	}
}
static struct mLogger _silentLogger = { _silentLog, NULL };

static void _quietLogs(void) {
	mLogSetDefaultLogger(&_silentLogger);
}

static void* _lsrThread(void* arg) {
	struct LockstepRunCtx* ctx = (struct LockstepRunCtx*) arg;
	for (int f = 0; f < ctx->frames && !g_lsrStop; ++f) {
		if (g_lsrAbort) {
			break;
		}
		if ((f & 0x1F) == 0) {
			fprintf(stderr, "lockstep-run: core %d frame %d\n", ctx->slot, f);
		}
		/* 空测试 ROM 停在 ROM 入口死循环，永远不会自己写 SIOCNT。必须由
		 * 主机持续拉起 START，协调器才有 TRANSFER_START 事件、才会调用
		 * _setData 注入并广播 4 个字。只发一次的话，从机处理完事件后会
		 * park 等下一个主机事件并一直睡到看门狗超时 —— 真实 gen8 在
		 * 联机中心里每帧都发 MULTI，所以这里也每帧发一次。 */
		if (ctx->slot == 0 && f >= 8) {
			mgbaMobilePoke16(ctx->emu, 0x04000128u, 0x2083u);  /* MULTI + START */
		}
		/* 发送字由锁步协调器的测试注入钩子直接提供（0x1000+playerId），见
		 * testLockstepRun 的 mgbaMobileSioSetInject 调用。协调器负责收齐
		 * 4 个字并回写所有核的 SIOMULTI。 */
		mgbaMobileRunFrames(ctx->emu, 1);
		/* 每帧采样一次 SIOMULTI：只认 4 个字全部等于注入值。旧判据
		 * 「全非 0xFFFF」会把空 ROM 里的全 0 残值误判成一次完整传输。 */
		uint32_t r0 = mgbaMobilePeek16(ctx->emu, 0x04000120u);
		uint32_t r1 = mgbaMobilePeek16(ctx->emu, 0x04000122u);
		uint32_t r2 = mgbaMobilePeek16(ctx->emu, 0x04000124u);
		uint32_t r3 = mgbaMobilePeek16(ctx->emu, 0x04000126u);
		if (r0 == 0x1000u && r1 == 0x1001u && r2 == 0x1002u && r3 == 0x1003u) {
			/* 记录成功交换的快照。退出瞬间 SIOMULTI 很可能已被主机下一轮
			 * START 重置成 0xFFFF，用终态做断言会产生假失败。 */
			ctx->recv[0] = r0;
			ctx->recv[1] = r1;
			ctx->recv[2] = r2;
			ctx->recv[3] = r3;
			if (!ctx->everClean) {
				ctx->everClean = 1;
				/* 4 核都拿到完整注入字后主流程就可以收尾，不必等满帧数。 */
				pthread_mutex_lock(&g_lsrDataMu);
				++g_lsrCleanCount;
				pthread_cond_broadcast(&g_lsrDataCv);
				pthread_mutex_unlock(&g_lsrDataMu);
			}
		}
	}
	/* recv 是「最后一次成功交换」的快照，不在这里用终态覆盖。 */
	ctx->finalFrame = mgbaMobileFrameCounter(ctx->emu);
	return NULL;
}

static void testLockstepRun(const char* romPath) {
	_quietLogs();
	const int key = 0x4C53;
	const int players = 4;
	struct MgbaMobile* emus[4] = {0};
	struct LockstepRunCtx ctx[4];
	pthread_t threads[4];

	for (int i = 0; i < players; ++i) {
		emus[i] = mgbaMobileCreate(".", ".", "0");
		expect(emus[i] != NULL, "lockstep-run: emu created");
		expect(mgbaMobileLoad(emus[i], romPath), "lockstep-run: rom loaded");
	}
	/* 引导阶段：先不挂锁步驱动，正常 runFrame 跑 ~60 帧让 BIOS 完成 boot。
	 * GBA BIOS 开机时会探测 SIO 链路，若此刻已挂上锁步驱动（报「已连接」），
	 * BIOS 会进入多启动等待、永远收不到多启动头而卡死。先 boot 完再挂驱动即可
	 * 绕开（参考 busGameLockstepTest 同样在帧 10 之后才 attach）。 */
	for (int i = 0; i < players; ++i) {
		mgbaMobileRunFrames(emus[i], 60);
	}
	fprintf(stderr, "lockstep-run: booted 60 frames each, attaching lockstep driver\n");

	expect(mgbaMobileLinkHostLockstep(emus[0], key, players, 0),
	       "lockstep-run: host attached");
	for (int i = 1; i < players; ++i) {
		expect(mgbaMobileLinkJoinLockstep(emus[i], key, i),
		       "lockstep-run: join attached");
	}
	expect(mgbaMobileLinkIsLockstep(emus[0]), "lockstep-run: host reports lockstep");

	/* 4 核统一进 MULTI 模式。BIOS 探测后实测 siocnt=0x2000 但 rcnt=0x8000，
	 * _switchMode 把 (rcnt&0xC000)|(siocnt&0x3000) 一起算，结果 mode=8
	 * (JOYBUS)。此时只写 SIOCNT 因 (value^siocnt)&0x3000==0 根本不触发
	 * 模式切换，写 START 也只会走 default 分支，协调器永远收不到 start。
	 * 必须再写 RCNT=0 清掉 JOYBUS 位，才会切到 MULTI(mode=2)。
	 * 4 个线程开跑前顺序做完，避免模式切换事件跨线程竞态；真实 gen8 ROM
	 * 由游戏进入联机中心时自己完成同样的配置。 */
	for (int i = 0; i < players; ++i) {
		mgbaMobilePoke16(emus[i], 0x04000128u, 0x2003u);  /* SIOCNT: MULTI, baud=3, START=0 */
		mgbaMobilePoke16(emus[i], 0x04000134u, 0x0000u);  /* RCNT: clear JOYBUS */
	}
	fprintf(stderr, "lockstep-run: SIO set to MULTI; host siocnt=%04X\n",
	        mgbaMobilePeek16(emus[0], 0x04000128u));

	/* 打开锁步发送字注入：协调器每轮直接以 0x1000+playerId 作为各核发往对端的
	 * 字，绕开真实游戏 ROM 对 SIOMLT_SEND 的改写，得到确定性 4 字 MULTI 传输。
	 * 主机在第 8 帧拉起 START（见 _lsrThread），协调器照常收齐 4 字并广播。 */
	mgbaMobileSioSetInject(true);
	fprintf(stderr, "lockstep-run: injected deterministic send words; host pc=%08X\n",
	        mgbaMobileCpuPc(emus[0]));

	for (int i = 0; i < players; ++i) {
		ctx[i].emu = emus[i];
		ctx[i].slot = i;
		ctx[i].players = players;
		ctx[i].frames = 64;
		ctx[i].recv[0] = ctx[i].recv[1] = ctx[i].recv[2] = ctx[i].recv[3] = 0;
		ctx[i].finalFrame = 0;
		ctx[i].everClean = 0;
	}

	/* 墙钟看门狗：20s 后强制结束，绝不挂死进程。 */
	g_lsrAbort = 0;
	g_lsrDone = 0;
	g_lsrStop = 0;
	g_lsrCleanCount = 0;
	mgbaLockstepSetAbort(0);
	pthread_t wd;
	long wdMs = 20000;
	pthread_create(&wd, NULL, _lsrWatchdog, &wdMs);

	for (int i = 0; i < players; ++i) {
		pthread_create(&threads[i], NULL, _lsrThread, &ctx[i]);
	}

	/* 等 4 核都观察到完整的 4 字注入（最多 10s），然后主动收尾。
	 * 空测试 ROM 在最后一次 MULTI 之后不会再发 SIO 事件；若让主机线程
	 * 先退出，从机会 park 等一个永远不会来的事件直到看门狗超时。 */
	struct timespec deadline;
	clock_gettime(CLOCK_REALTIME, &deadline);
	deadline.tv_sec += 10;
	pthread_mutex_lock(&g_lsrDataMu);
	while (g_lsrCleanCount < players && !g_lsrAbort) {
		if (pthread_cond_timedwait(&g_lsrDataCv, &g_lsrDataMu, &deadline) == ETIMEDOUT) {
			break;
		}
	}
	int allClean = (g_lsrCleanCount == players);
	pthread_mutex_unlock(&g_lsrDataMu);

	pthread_mutex_lock(&g_lsrWdMu);
	g_lsrDone = 1;
	pthread_cond_broadcast(&g_lsrWdCv);
	pthread_mutex_unlock(&g_lsrWdMu);
	g_lsrStop = 1;
	mgbaLockstepSetAbort(1);   /* 唤醒仍 park 在等事件的核，让帧循环立即返回 */
	for (int i = 0; i < players; ++i) {
		pthread_join(threads[i], NULL);
	}
	pthread_join(wd, NULL);
	mgbaLockstepSetAbort(0);
	mgbaMobileSioSetInject(false);   /* 关掉测试注入，避免影响后续拆离/销毁 */

	expect(allClean, "lockstep-run: all 4 cores saw injected MULTI transfer");
	expect(!g_lsrAbort, "lockstep-run: finished before watchdog fired");
	/* 同步：4 核帧号都应推进（无死锁，协调器把各核锁在同一步）。 */
	for (int i = 0; i < players; ++i) {
		expect(ctx[i].finalFrame > 30, "lockstep-run: core advanced frames");
	}

	/* 数据：发送字由注入钩子提供，锁步协调器每轮把
	 * multiData[0..3] = [0x1000,0x1001,0x1002,0x1003] 写回所有核 SIOMULTI。
	 * ctx.recv 记录的是「最后一次成功交换」的快照（主机每帧发起新 START
	 * 会先把 SIOMULTI 重置为 0xFFFF，退出瞬间的终态不可靠）。
	 * 既验证传输真的发生，也验证 4 核一致性。 */
	for (int i = 0; i < players; ++i) {
		fprintf(stderr, "lockstep-run: core %d pc=%08X recv %04X %04X %04X %04X fc=%u everClean=%d%s\n",
		        i, mgbaMobileCpuPc(emus[i]),
		        ctx[i].recv[0], ctx[i].recv[1], ctx[i].recv[2], ctx[i].recv[3],
		        ctx[i].finalFrame, ctx[i].everClean, g_lsrAbort ? " (aborted)" : "");
		for (int j = 0; j < players; ++j) {
			expect(ctx[i].recv[j] == (uint32_t) (0x1000 + j),
			       "lockstep-run: core received correct MULTI word");
		}
		expect(ctx[i].everClean, "lockstep-run: core saw a complete 4-word transfer");
	}

	/* 拆离：先逐个 Close（解锁步 SIO），再 Destroy。 */
	for (int i = 0; i < players; ++i) {
		mgbaMobileLinkClose(emus[i]);
	}
	for (int i = 0; i < players; ++i) {
		mgbaMobileDestroy(emus[i]);
	}
	/* 房间应随所有引用释放而销毁，可被新 host 复用。 */
	struct MgbaLockstepRoom* again = mgbaLockstepHost(key, players);
	expect(again != NULL, "lockstep-run: room reusable after shutdown");
	mgbaLockstepRelease(again);
}

int main(int argc, char** argv) {
	char dir[512];
	/* 行缓冲会随管道变成全缓冲：进程崩在下半场时，前面所有 ok 都被丢掉，
	 * 现场就只剩「0 条 ok」，没法判断崩在哪。这里强制无缓冲。 */
	setvbuf(stdout, NULL, _IONBF, 0);
	setvbuf(stderr, NULL, _IONBF, 0);
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
	if (argc >= 2 && strcmp(argv[1], "--preaudio") == 0) {
		/* 跑指定的前置用例后再跑 device pump，用来二分段错误的触发源。
		 * 第三个参数是字母集合：b=bios s=resample g=gb G=gba R=rom64 T=turboB */
		const char* set = argc > 3 ? argv[3] : "bsgGRT";
		snprintf(dir, sizeof(dir), "%s", argc > 2 ? argv[2] : ".");
#ifdef _WIN32
		_mkdir(dir);
#else
		mkdir(dir, 0755);
#endif
		if (strchr(set, 'b')) {
			testBios();
		}
		if (strchr(set, 's')) {
			testResample();
		}
		if (strchr(set, 'g')) {
			testGb(dir);
		}
		if (strchr(set, 'G')) {
			testGba(dir);
		}
		if (strchr(set, 'R')) {
			testRom64(dir);
		}
		if (strchr(set, 'T')) {
			testTurboB(dir);
		}
		if (strchr(set, 'a')) {
			testAudioOut(dir);
			testAudioPitch(dir);
			testAudioConstPitch(dir);
			testAudioConstPitchRealtime(dir);
		}
		testAudioConstPitchDevicePump(dir);
		return g_failed ? 1 : 0;
	}
	if (argc >= 2 && strcmp(argv[1], "--audioall") == 0) {
		/* 只跑音频整组，用来二分「device pump 的段错误由谁触发」。 */
		snprintf(dir, sizeof(dir), "%s", argc > 2 ? argv[2] : ".");
#ifdef _WIN32
		_mkdir(dir);
#else
		mkdir(dir, 0755);
#endif
		if (argc <= 3 || strchr(argv[3], 'o')) {
			testAudioOut(dir);
		}
		if (argc <= 3 || strchr(argv[3], 'p')) {
			testAudioPitch(dir);
		}
		if (argc <= 3 || strchr(argv[3], 'c')) {
			testAudioConstPitch(dir);
		}
		if (argc <= 3 || strchr(argv[3], 'r')) {
			testAudioConstPitchRealtime(dir);
		}
		if (argc <= 3 || strchr(argv[3], 'd')) {
			testAudioConstPitchDevicePump(dir);
		}
		return g_failed ? 1 : 0;
	}
	if (argc >= 2 && strcmp(argv[1], "--audio") == 0) {
		snprintf(dir, sizeof(dir), "%s", argc > 2 ? argv[2] : ".");
#ifdef _WIN32
		_mkdir(dir);
#else
		mkdir(dir, 0755);
#endif
		testAudioConstPitch(dir);
		testAudioConstPitchRealtime(dir);
		testAudioConstPitchDevicePump(dir);
		return g_failed ? 1 : 0;
	}
	if (argc >= 2 && strcmp(argv[1], "--bus") == 0) {
		testBusSlots();
	testBusSlotReuse();
	testBusIgnoresPointToPoint();
	testBusSinglePeer();
	testBusThree();
		testBusPlayers();
		testBusLocal();
		return g_failed ? 1 : 0;
	}
	if (argc >= 2 && strcmp(argv[1], "--link") == 0) {
		testLink();
		testBusSlots();
	testBusSlotReuse();
	testBusIgnoresPointToPoint();
	testBusSinglePeer();
	testBusThree();
		testBusPlayers();
		testBusLocal();
		return g_failed ? 1 : 0;
	}
	if (argc >= 2 && strcmp(argv[1], "--state") == 0) {
		snprintf(dir, sizeof(dir), "%s", argc > 2 ? argv[2] : ".");
#ifdef _WIN32
		_mkdir(dir);
#else
		mkdir(dir, 0755);
#endif
		testStateMemory(dir);
	testCoreLockHeld(dir);
	testStateConcurrency(dir);
		return g_failed ? 1 : 0;
	}
	if (argc >= 2 && strcmp(argv[1], "--dual") == 0) {
		testDualCoreIsolation();
		return g_failed ? 1 : 0;
	}
	if (argc >= 2 && strcmp(argv[1], "--lockstep") == 0) {
		testLockstep(argc > 2 ? argv[2] : "test.gba");
		return g_failed ? 1 : 0;
	}
	if (argc >= 2 && strcmp(argv[1], "--lockstep-run") == 0) {
		testLockstepRun(argc > 2 ? argv[2] : "test.gba");
		return g_failed ? 1 : 0;
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
	testBusSlots();
	testBusSlotReuse();
	testBusIgnoresPointToPoint();
	testBusSinglePeer();
	testBusThree();
	testBusPlayers();
	testStateMemory(dir);
	testRelay();
	testCoreLockHeld(dir);
	testStateConcurrency(dir);
	testDualCoreIsolation();
	if (g_failed) {
		fprintf(stderr, "mobile tests failed\n");
		return 1;
	}
	printf("mobile tests passed\n");
	return 0;
}
