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
/* Core serialisation for the JNI boundary: runFrames and the two in-memory
 * state calls must not touch the same mCore from different threads. */
void mgbaMobileLock(struct MgbaMobile* emu);
void mgbaMobileUnlock(struct MgbaMobile* emu);
bool mgbaMobileLoad(struct MgbaMobile* emu, const char* path);
/* Overrides the battery-save / save-state folders before the next load.
 * Passing the ROM's own folder keeps saves beside the game. */
void mgbaMobileSetSaveDirs(struct MgbaMobile* emu, const char* saveDir, const char* stateDir);
bool mgbaMobileIsLoaded(const struct MgbaMobile* emu);
void mgbaMobileSetKeys(struct MgbaMobile* emu, uint32_t keys);
void mgbaMobileSetTurbo(struct MgbaMobile* emu, uint32_t mask);
/*
 * The key state the game was last given, in the console's own active-low
 * convention: a set bit means the key is released, a clear bit means it is
 * pressed. This is what the game actually reads, which is not always the
 * mask the front end asked for - a turbo key is pulsed by the core itself,
 * one frame on and one frame off.
 */
uint16_t mgbaMobileLastKeys(struct MgbaMobile* emu);
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
 * Turns 不变速 (constant pitch) playback on or off: with it on, the surplus
 * audio a fast-forwarded game produces is parked and replayed at the console's
 * own rate instead of being shredded by the core's ring. The surplus is time-
 * stretched with WSOLA so the music keeps its own speed and pitch with no
 * skipped section. Pass speed 1 to mgbaMobileReadAudioOut while it is on;
 * stretch is the fast-forward multiplier.
 */
void mgbaMobileSetAudioConstantPitch(struct MgbaMobile* emu, bool on, double stretch);
/* 0 = keep pitch, tune runs at the fast-forward rate; 1 = keep tempo and pitch
 * by skipping sections. See MOBILE_AUDIO_HOLD_* in mgba_mobile.c. */
/* How fast-forward audio is produced when the front end asks for it: the mode
 * argument of mgbaMobileSetAudioHoldMode(). */
enum {
	/* Keep the tune at its own pitch but let it run at the fast-forward rate:
	 * nothing is dropped, the whole score plays, just faster. */
	MOBILE_AUDIO_HOLD_PITCH = 0,
	/* Keep the tune at its own tempo *and* pitch - exactly as at 1x - by
	 * skipping sections in between, cut on gaps between notes. */
	MOBILE_AUDIO_HOLD_NATIVE = 1,
};

void mgbaMobileSetAudioHoldMode(struct MgbaMobile* emu, int mode);
/*
 * Frames the time-stretcher had to discard because its staging buffer could not
 * take them. Should always be 0; a non-zero value means a hole in the music
 * (the tests use it to prove the stretcher never eats input it cannot emit).
 */
size_t mgbaMobileWsolaDropped(const struct MgbaMobile* emu);
/*
 * Section skips executed by the 音乐原速 native hold (see mobile_test.c).
 * Grows by a couple per second of fast-forward at 4x - hundreds per second
 * would mean the surplus is being shaved frame-by-frame again, which plays
 * the tune at the fast-forward rate.
 */
size_t mgbaMobileNativeHoldCuts(const struct MgbaMobile* emu);
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
void mgbaMobileResetAudioPace(struct MgbaMobile* emu);
/*
 * Whether the resampler's input rate can be trusted at the speed being read:
 * a locked estimate or a remembered device throughput to seed from. Front
 * ends defer starting playback while this is false (the first fast-forward on
 * a device) and wait out the first feedback window instead.
 */
bool mgbaMobileAudioPaceSeeded(const struct MgbaMobile* emu);
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
/*
 * In-memory save state, the equivalent of the official client's
 * Console.saveStateToMemory()/loadStateFromMemory() used by TYPE_STATE frames.
 * On success *out points to a malloc'd blob that the caller releases with
 * mgbaMobileFreeState(). Screenshot data is omitted: the state travels over
 * the link and the receiving core does not need it.
 */
bool mgbaMobileSaveStateToMemory(struct MgbaMobile* emu, void** out, size_t* outSize);
bool mgbaMobileLoadStateFromMemory(struct MgbaMobile* emu, const void* data, size_t size);
void mgbaMobileFreeState(void* state);
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
bool mgbaMobileLinkHost(struct MgbaMobile* emu, int port, int players);
bool mgbaMobileLinkJoin(struct MgbaMobile* emu, const char* host, int port, int players);

/* 进程内总线：同一进程里 N 个核心经共享内存回合屏障互联，不开 socket、不起
 * IO 线程。key 区分同一进程内的不同会话，主机必须先于从机建立。3/4 人本机
 * 多核用它，跨设备仍走 mgbaMobileLinkHost/Join。 */
bool mgbaMobileLinkHostLocal(struct MgbaMobile* emu, int key, int players);
bool mgbaMobileLinkJoinLocal(struct MgbaMobile* emu, int key);
/* 占用指定链路槽位（0 归主机）。本机可见核要占全局会话里它自己的槽位。 */
bool mgbaMobileLinkJoinLocalSlot(struct MgbaMobile* emu, int key, int slot);

/* 进程内锁步 SIO（默认关闭，显式调用才启用）。与上面的共享内存轮次总线
 * 不同，它直接挂 mGBA 官方 GBASIOLockstepCoordinator，在 SIO 传输轮次粒度
 * 会合，没有墙钟超时、没有轮次索引配对、不开 socket。
 * 启用后该核的帧循环自动切到小步 runLoop（见 mgbaLockstepRunFrame）。
 * PC 侧已用同一协调器让 4 核 gen8 multi-battle 进对战并稳定维持。 */
bool mgbaMobileLinkHostLockstep(struct MgbaMobile* emu, int key, int players, int slot);
bool mgbaMobileLinkJoinLockstep(struct MgbaMobile* emu, int key, int slot);
bool mgbaMobileLinkIsLockstep(const struct MgbaMobile* emu);

/* 测试/调试用：直接读写本核 GBA 内存（I/O 寄存器同理）。仅锁步集成测试与诊断
 * 使用，不在产品热路径上。 */
void mgbaMobilePoke16(struct MgbaMobile* emu, uint32_t addr, uint16_t value);
uint16_t mgbaMobilePeek16(struct MgbaMobile* emu, uint32_t addr);
/* 当前已渲染帧号（gba->video.frameCounter），用于验证锁步帧循环推进。 */
uint32_t mgbaMobileFrameCounter(const struct MgbaMobile* emu);

/* 测试钩子：开启后锁步多玩家传输直接注入 0x1000+playerId 作为发送字，绕开
 * 真实游戏对 SIOMLT_SEND 的改写，得到确定性传输用于验证收集/广播。仅测试使用，
 * 必须在跑锁步集成测试前打开、跑完关闭。 */
void mgbaMobileSioSetInject(bool inject);

/* 诊断：返回本核 CPU 当前 PC（gba->cpu->gprs[15]）。 */
uint32_t mgbaMobileCpuPc(struct MgbaMobile* emu);

void mgbaMobileLinkClose(struct MgbaMobile* emu);
void mgbaMobileLinkStatus(const struct MgbaMobile* emu, char* out, size_t outLen);

/*
 * Battery save type forced on the next GBA load. -1 lets the core autodetect;
 * other values follow enum GBASavedataType (0 none, 1 SRAM, 2 FLASH512,
 * 3 FLASH1M, 4 EEPROM, 5 EEPROM512, 6 SRAM512).
 */
void mgbaMobileSetSaveType(struct MgbaMobile* emu, int type);
/* TEMP PROBE */
struct mCore* mgbaMobileDebugCore(struct MgbaMobile* emu);
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

/*
 * Debug memory access for the memory viewer, cheat search and the PPU
 * viewers (they read PAL/VRAM/OAM straight off the bus). width is 8, 16 or
 * 32 bits. Reads run against the live core, the same way a debugger does;
 * callers that need stable values pause the game first.
 */
uint32_t mgbaMobileBusRead(const struct MgbaMobile* emu, int width, uint32_t address);
bool mgbaMobileBusWrite(struct MgbaMobile* emu, int width, uint32_t address, uint32_t value);
/* Byte-wise bulk read of up to size bytes starting at address; returns the
 * number of bytes written into out (capped at 1 MiB per call). */
int mgbaMobileBusReadBlock(const struct MgbaMobile* emu, uint32_t address, int size, uint8_t* out);

/* Linear resample used by the iOS audio path. pos is carried between calls. */
int mgbaMobileResample(const int16_t* in, int inFrames, int inRate, int outRate, int16_t* out, int maxOutFrames, double* pos);

/*
 * Desktop test hooks. Both are per-instance on purpose: two cores in one
 * process (本机双核心) must not share the synthetic audio clock or the link
 * unstick one-shot latch. mgbaMobileUnstickStep() returns 1 exactly on the
 * call that arms the patch; matched=false resets that core's streak.
 */
void mgbaMobileSetAudioClock(struct MgbaMobile* emu, double (*clock)(void));
bool mgbaMobileHasSyntheticAudioClock(const struct MgbaMobile* emu);
int mgbaMobileUnstickStep(struct MgbaMobile* emu, int mode, bool matched);

/* Same BIOS filename rules as the Android importer. */
void mgbaMobileBiosFileName(const char* name, long size, char* out, size_t outLen);

#ifdef __cplusplus
}
#endif

#endif
