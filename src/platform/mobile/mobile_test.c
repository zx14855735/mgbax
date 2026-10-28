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
	mgbaMobileSetAudioConstantPitch(emu, false, 1.0);
	free(out);
	mgbaMobileDestroy(emu);
}

/*
 * Models the Android front end's audio pump as closely as it can be modelled
 * off-device: mgbaMobileReadAudioOut is asked for a large fixed block (the
 * front end passes AUDIO_READ_FRAMES = 8192) and drains up to eight of those
 * per paced slice, taking everything it gets.
 *
 * That big request is what exposed the staging-buffer overflow. The old
 * `produced < want * 8` bound let a single call pour tens of thousands of
 * frames into the two-second staging buffer; mAudioBufferWrite accepts short
 * writes, the remainder was dropped, and the analysis cursor still advanced -
 * whole synthesis hops vanished while the input was consumed anyway, so
 * fast-forward played chopped, gappy music instead of the stretched track. The
 * per-slice harness above only ever asks for ~800 frames, which is small enough
 * that the buffer never filled, which is exactly why it passed.
 */
static void testAudioConstPitchDevicePump(const char* dir) {
	const int OUT_RATE = 48000;
	const double SLICES_PER_SEC = 59.73;
	const int SLICES = 300;
	const int PER_SLICE = (int) (OUT_RATE / SLICES_PER_SEC) + 1;
	const int CAP = SLICES * PER_SLICE;
	const int BLOCK = 8192;   /* EmulatorActivity.AUDIO_READ_FRAMES */
	const int ROUNDS = 8;     /* pumpAudio() drain rounds per slice */
	char path[512];
	struct MgbaMobile* emu;
	int16_t* out;
	int16_t* tmp;
	int64_t delivered = 0;
	int total = 0;
	double base;
	double pitch;
	size_t dropped;
	int slice;
	int round;

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

	/* Baseline at 1x with the same block size, so the ratio is comparable. */
	mgbaMobileResetAudioPace(emu);
	mgbaMobileClearAudio(emu);
	mgbaMobileSetAudioPaceFps(emu, SLICES_PER_SEC);
	for (slice = 0; slice < SLICES; ++slice) {
		mgbaMobileRunFrames(emu, 1);
		for (round = 0; round < ROUNDS; ++round) {
			int got = mgbaMobileReadAudioOut(emu, tmp, BLOCK, 1.0, 0.0f);
			if (got <= 0) {
				break;
			}
			if (total + got > CAP) {
				got = CAP - total;
			}
			if (got <= 0) {
				break;
			}
			memcpy(out + total * 2, tmp, (size_t) got * 2 * sizeof(int16_t));
			total += got;
		}
	}
	base = audioPitchHz(out, total, OUT_RATE);
	printf("device pump 1x: %d/%d frames, %.1f Hz\n", total, CAP, base);
	expect(base > 480.0 && base < 545.0, "device pump 1x plays at its own frequency");

	/* 不变速 at 4x through the device's block size. */
	mgbaMobileResetAudioPace(emu);
	mgbaMobileSetAudioConstantPitch(emu, true, 4.0);
	mgbaMobileClearAudio(emu);
	memset(out, 0, ((size_t) CAP * 2 + 2) * sizeof(int16_t));
	total = 0;
	mgbaMobileSetAudioPaceFps(emu, SLICES_PER_SEC);
	for (slice = 0; slice < SLICES; ++slice) {
		/* The front end calls syncFastAudio() at the top of every slice, and
		 * while 不变速 is on that republishes the mode ~60 times a second. */
		mgbaMobileSetAudioConstantPitch(emu, true, 4.0);
		mgbaMobileRunFrames(emu, 4);
		for (round = 0; round < ROUNDS; ++round) {
			int got = mgbaMobileReadAudioOut(emu, tmp, BLOCK, 1.0, 0.0f);
			if (got <= 0) {
				break;
			}
			delivered += got;
			if (total >= CAP) {
				continue;
			}
			if (total + got > CAP) {
				got = CAP - total;
			}
			memcpy(out + total * 2, tmp, (size_t) got * 2 * sizeof(int16_t));
			total += got;
		}
	}
	pitch = audioPitchHz(out, total, OUT_RATE);
	dropped = mgbaMobileWsolaDropped(emu);
	printf("device pump 不变速 4x WSOLA: %d/%d frames (delivered %lld), %.1f Hz (%.2fx), dropped %zu\n",
			total, CAP, (long long) delivered, pitch, base > 0.0 ? pitch / base : 0.0, dropped);
	expect(pitch > base * 0.85 && pitch < base * 1.15, "device pump WSOLA keeps the pitch");
	expect(dropped == 0, "device pump WSOLA never discards a synthesis hop");
	/* The device drains one second of audio per second of wall clock, so a
	 * correct pump delivers about CAP frames no matter how many rounds it is
	 * allowed; far more would mean it is pushing audio the device cannot play. */
	expect(delivered <= (int64_t) (CAP * 1.25), "device pump WSOLA delivers one second per second");
	expect(total >= CAP * 0.8, "device pump WSOLA fills the whole window");

	mgbaMobileSetAudioConstantPitch(emu, false, 1.0);
	free(out);
	free(tmp);
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
	testTurboB(dir);
	testAudioOut(dir);
	testAudioPitch(dir);
	testAudioConstPitch(dir);
	testAudioConstPitchRealtime(dir);
	testAudioConstPitchDevicePump(dir);
	testLink();
	testRelay();
	if (g_failed) {
		fprintf(stderr, "mobile tests failed\n");
		return 1;
	}
	printf("mobile tests passed\n");
	return 0;
}
