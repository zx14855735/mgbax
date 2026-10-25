/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#ifndef MGBA_MOBILE_H
#define MGBA_MOBILE_H

#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>

#ifdef __cplusplus
extern "C" {
#endif

struct MgbaMobile;

struct MgbaMobile* mgbaMobileCreate(const char* saveDir, const char* stateDir, const char* port);
void mgbaMobileDestroy(struct MgbaMobile* emu);
bool mgbaMobileLoad(struct MgbaMobile* emu, const char* path);
bool mgbaMobileIsLoaded(const struct MgbaMobile* emu);
void mgbaMobileSetKeys(struct MgbaMobile* emu, uint32_t keys);
void mgbaMobileSetTurbo(struct MgbaMobile* emu, uint32_t mask);
bool mgbaMobileRunFrames(struct MgbaMobile* emu, int count);
int mgbaMobileReadAudio(struct MgbaMobile* emu, int16_t* out, int maxFrames);
/* Quality resampler to the audio device's rate; 0 disables it. */
bool mgbaMobileSetAudioOutput(struct MgbaMobile* emu, int outRate);
/*
 * Resampled read at the configured output rate. speed is the fast-forward (or
 * slow-motion) factor, 0.05..64, and drift a small ratio adjustment (about
 * +/-0.02) used to keep the front end's playback buffer at its target level.
 */
int mgbaMobileReadAudioOut(struct MgbaMobile* emu, int16_t* out, int maxFrames, double speed, float drift);
/*
 * Frames per second the front end is actually pacing emulation at (measured,
 * not nominal). Call about once a second; the resampler follows it so audio
 * stays locked to the playback device even when the front end cannot hold its
 * target rate. Values outside 15-240 are clamped. A reading close to the
 * current pace is treated as noise and ignored (the playback queue's drift
 * control absorbs it), and a larger change is only followed once a second,
 * agreeing window confirms it, so a single stall - a ROM load, a system
 * pause - cannot detune the music. After loading a game the console's own
 * frame rate is assumed until readings accumulate again.
 */
void mgbaMobileSetAudioPaceFps(struct MgbaMobile* emu, double fps);
void mgbaMobileClearAudio(struct MgbaMobile* emu);
int mgbaMobileWidth(const struct MgbaMobile* emu);
int mgbaMobileHeight(const struct MgbaMobile* emu);
int mgbaMobileSampleRate(const struct MgbaMobile* emu);
/*
 * Length of one emulated frame in nanoseconds (using the console's own frame
 * rate); 0 when no console is loaded. Front ends pace with this so game speed
 * and audio pitch match hardware instead of a rounded 60 fps.
 */
int64_t mgbaMobileFrameNanos(const struct MgbaMobile* emu);
bool mgbaMobileCopyVideo(struct MgbaMobile* emu, uint32_t* pixels, int stride);
bool mgbaMobileSaveState(struct MgbaMobile* emu, int slot);
bool mgbaMobileLoadState(struct MgbaMobile* emu, int slot);
/* Rewind history: append a differential state every ~half second while
 * enabled; rewind by about the given number of seconds of gameplay. */
void mgbaMobileSetRewind(struct MgbaMobile* emu, bool enabled);
bool mgbaMobileRewind(struct MgbaMobile* emu, int seconds);
void mgbaMobileReset(struct MgbaMobile* emu);
void mgbaMobileTitle(const struct MgbaMobile* emu, char* out, size_t outLen);
void mgbaMobileSetInterframe(struct MgbaMobile* emu, bool enabled);
void mgbaMobileSetFrameskip(struct MgbaMobile* emu, int skip);
void mgbaMobileSaveFile(const struct MgbaMobile* emu, char* out, size_t outLen);
void mgbaMobilePumpLink(struct MgbaMobile* emu);
bool mgbaMobileLinkHost(struct MgbaMobile* emu, int port);
bool mgbaMobileLinkJoin(struct MgbaMobile* emu, const char* host, int port);
void mgbaMobileLinkClose(struct MgbaMobile* emu);
void mgbaMobileLinkStatus(const struct MgbaMobile* emu, char* out, size_t outLen);

/*
 * Battery save type forced on the next GBA load. -1 lets the core autodetect;
 * other values follow enum GBASavedataType (0 none, 1 SRAM, 2 FLASH512,
 * 3 FLASH1M, 4 EEPROM, 5 EEPROM512, 6 SRAM512).
 */
void mgbaMobileSetSaveType(struct MgbaMobile* emu, int type);
/* Auto-apply IPS/UPS/BPS patches found next to the ROM (default on). */
void mgbaMobileSetPatches(struct MgbaMobile* emu, bool enabled);
/* useBios/skipBios applied on the next load. */
void mgbaMobileSetBiosOptions(struct MgbaMobile* emu, bool useBios, bool skipIntro);

/*
 * Game clock reported to RTC cartridges. mode 0 = wall clock, 1 = fixed epoch
 * (unix seconds), 2 = wall clock shifted by offset seconds.
 */
void mgbaMobileSetRtc(struct MgbaMobile* emu, int mode, int64_t epoch, int64_t offset);

/*
 * Boktai solar sensor: level 0-10 maps to the core's lux table. Also enables
 * the light-sensor cartridge device so non-Boktai games that read it work.
 */
void mgbaMobileSetSolar(struct MgbaMobile* emu, int level);
/* Rumble cartridge (e.g. Mario Golf) enable; hits are polled by the front end. */
void mgbaMobileSetCartRumble(struct MgbaMobile* emu, bool enabled);
/* Number of rumble pulses since the last call; each pulse clears on read. */
int mgbaMobileTakeRumbles(struct MgbaMobile* emu);

/*
 * GB DMG palette override: twelve 0xRRGGBB entries for gb.pal[0..11] (four
 * colors each for BG, OBJ0 and OBJ1). Applied live on a running GB core and
 * replayed on every load.
 */
void mgbaMobileSetGbPalette(struct MgbaMobile* emu, const int32_t* colors);
/* Super Game Boy border art on SGB-capable games (sgb.borders); applied live. */
void mgbaMobileSetSgbBorders(struct MgbaMobile* emu, bool enabled);
/*
 * Per-channel audio gains, 0-256 fixed point (256 = full volume): PSG
 * channels 1-4 then the GBA DMA A/B FIFOs. Applied live on the running core
 * and on every reload.
 */
void mgbaMobileSetChannelVolumes(struct MgbaMobile* emu, const int32_t* gains);
/*
 * Tilt cartridge input (WarioWare Twisted, Kirby Tilt'n'Tumble). tiltX/tiltY
 * are normalized to -1..1; gyroZ follows the same scale.
 */
void mgbaMobileSetRotation(struct MgbaMobile* emu, float tiltX, float tiltY, float gyroZ);

/* Cheats. Codes are added as one named set of newline-separated raw lines;
 * format follows the GBA cheat type codes (0 autodetect, 1 CodeBreaker,
 * 2 GameShark, 3 Pro Action Replay, 4 VBA). Sets persist to <save>/<base>.cht
 * and are reloaded with the ROM.
 */
int mgbaMobileCheatCount(const struct MgbaMobile* emu);
void mgbaMobileCheatName(const struct MgbaMobile* emu, int index, char* out, size_t outLen);
bool mgbaMobileCheatEnabled(const struct MgbaMobile* emu, int index);
void mgbaMobileCheatSetEnabled(struct MgbaMobile* emu, int index, bool enabled);
bool mgbaMobileCheatAdd(struct MgbaMobile* emu, const char* name, const char* lines, int type);
bool mgbaMobileCheatRemove(struct MgbaMobile* emu, int index);

/* Linear resample used by the iOS audio path. pos is carried between calls. */
int mgbaMobileResample(const int16_t* in, int inFrames, int inRate, int outRate, int16_t* out, int maxOutFrames, double* pos);

/* Same BIOS filename rules as the Android importer. */
void mgbaMobileBiosFileName(const char* name, long size, char* out, size_t outLen);

#ifdef __cplusplus
}
#endif

#endif
