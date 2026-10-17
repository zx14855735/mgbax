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
 * Resampled read at the configured output rate. speed is the fast-forward
 * factor (>= 1) and drift a small ratio adjustment (about +/-0.02) used to
 * keep the front end's playback buffer at its target level.
 */
int mgbaMobileReadAudioOut(struct MgbaMobile* emu, int16_t* out, int maxFrames, int speed, float drift);
void mgbaMobileClearAudio(struct MgbaMobile* emu);
int mgbaMobileWidth(const struct MgbaMobile* emu);
int mgbaMobileHeight(const struct MgbaMobile* emu);
int mgbaMobileSampleRate(const struct MgbaMobile* emu);
bool mgbaMobileCopyVideo(struct MgbaMobile* emu, uint32_t* pixels, int stride);
bool mgbaMobileSaveState(struct MgbaMobile* emu, int slot);
bool mgbaMobileLoadState(struct MgbaMobile* emu, int slot);
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

/* Linear resample used by the iOS audio path. pos is carried between calls. */
int mgbaMobileResample(const int16_t* in, int inFrames, int inRate, int outRate, int16_t* out, int maxOutFrames, double* pos);

/* Same BIOS filename rules as the Android importer. */
void mgbaMobileBiosFileName(const char* name, long size, char* out, size_t outLen);

#ifdef __cplusplus
}
#endif

#endif
