/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.graphics.Bitmap;

import java.io.File;

public final class MgbaCore {
    static {
        System.loadLibrary("mgba_jni");
    }

    private long handle;

    public MgbaCore(File saveDir, File stateDir) {
        handle = nativeCreate(saveDir.getAbsolutePath(), stateDir.getAbsolutePath());
        if (handle == 0) {
            throw new RuntimeException("无法创建模拟器");
        }
    }

    public void destroy() {
        if (handle != 0) {
            nativeDestroy(handle);
            handle = 0;
        }
    }

    /**
     * Chooses the folders the next ROM's battery save and save states live in.
     * Passing the ROM's own folder keeps saves beside the game; passing the
     * global folders restores the default layout.
     */
    public void setSaveDirs(String saveDir, String stateDir) {
        if (handle != 0) {
            nativeSetSaveDirs(handle, saveDir, stateDir);
        }
    }

    public boolean load(String path) {
        return handle != 0 && nativeLoad(handle, path);
    }

    public boolean isLoaded() {
        return handle != 0 && nativeIsLoaded(handle);
    }

    public boolean runFrames(int keys, int count) {
        return handle != 0 && nativeRunFrames(handle, keys, count);
    }

    public void setKeys(int keys) {
        if (handle != 0) {
            nativeSetKeys(handle, keys);
        }
    }

    public void setTurbo(int mask) {
        if (handle != 0) {
            nativeSetTurbo(handle, mask);
        }
    }

    /** Enables recording the rewind history (differential states, ~0.5 s apart). */
    public void setRewind(boolean enabled) {
        if (handle != 0) {
            nativeSetRewind(handle, enabled);
        }
    }

    /** busgame 调试脚本（PC 判据脚本的设备端移植）：idx 为脚本序号（0=主机）。 */
    public void busGameStart(int idx, int menuAt, int modeDowns) {
        if (handle != 0) {
            nativeBusGameStart(handle, idx, menuAt, modeDowns);
        }
    }

    public void busGameStop() {
        if (handle != 0) {
            nativeBusGameStop(handle);
        }
    }

    /** 镜像线程逐帧调用：推进脚本一帧，返回本帧按键掩码。idx<0 时返回 0。 */
    public int busGameTick() {
        return handle != 0 ? nativeBusGameTick(handle) : 0;
    }

    /** Rewinds by about the given number of seconds; false when history is empty. */
    public boolean rewind(int seconds) {
        return handle != 0 && nativeRewind(handle, seconds);
    }

    /**
     * Per-channel audio gains, 0-256 each (256 = full volume): PSG channels
     * 1-4 then the GBA DMA A/B FIFOs. Applies live and on every reload.
     */
    public void setChannelVolumes(int[] gains) {
        if (handle != 0 && gains != null && gains.length >= 6) {
            nativeSetChannelVolumes(handle, gains);
        }
    }

    /**
     * Configures the native audio resampler for the given output rate.
     * Returns false when the core cannot be converted to that rate.
     */
    public boolean setAudioOutput(int outRate) {
        return handle != 0 && nativeSetAudioOutput(handle, outRate);
    }

    /**
     * Reads audio already converted to the configured output rate.
     *
     * @param speed emulated frames per paced frame (0.05..64), i.e. the
     *              fast-forward or slow-motion factor
     * @param drift small ratio adjustment (about +/-0.02) for playback buffer level control
     * @return number of stereo frames written into {@code out}
     */
    public int readAudioOut(short[] out, double speed, float drift) {
        return handle == 0 ? 0 : nativeReadAudioOut(handle, out, speed, drift);
    }

    /**
     * Reports how many frames per second the emulation loop is really managing
     * so the resampler can follow the device instead of a nominal 60. Call
     * about once a second with a measured average.
     */
    public void setAudioPaceFps(float fps) {
        if (handle != 0) {
            nativeSetAudioPaceFps(handle, fps);
        }
    }

    /**
     * Turns 不变速 (constant pitch) playback on or off. While it is on, the
     * surplus audio a fast-forwarded game produces is parked and replayed at
     * the console's own rate instead of being shredded by the core's small
     * ring, so the music keeps its own speed and pitch and only jumps when
     * the park fills. The caller passes speed 1 to readAudioOut while this
     * is on.
     */
    public void setAudioConstantPitch(boolean on, double stretch) {
        if (handle != 0) {
            nativeSetAudioConstantPitch(handle, on, (float) stretch);
        }
    }

    /** Music at its own tempo and pitch, skipping sections in between. */
    public static final int HOLD_MODE_NATIVE = 1;
    /** Music at its own pitch, running at the fast-forward rate (nothing skipped). */
    public static final int HOLD_MODE_PITCH = 0;

    /**
     * Chooses how fast-forward audio is produced while {@link #setAudioConstantPitch}
     * is on. HOLD_MODE_NATIVE plays the score at its own tempo and pitch, exactly
     * as at 1x, and skips the sections in between (cut on the gaps between
     * notes); HOLD_MODE_PITCH keeps every note but runs the score at the
     * fast-forward rate.
     */
    public void setAudioHoldMode(int mode) {
        if (handle != 0) {
            nativeSetAudioHoldMode(handle, mode);
        }
    }

    /**
     * Drops the pace estimate so the resampler re-locks from the console's own
     * frame rate after a speed change, instead of carrying a stale reading that
     * detunes or starves audio for a window. Called whenever the playback
     * pipeline is reset.
     */
    public void resetAudioPace() {
        if (handle != 0) {
            nativeResetAudioPace(handle);
        }
    }

    /**
     * Whether the resampler's input rate can be trusted at the current speed:
     * a locked estimate, or a remembered device throughput to seed from. While
     * this is false (the first fast-forward on a device) the front end should
     * hold playback back until the first feedback window lands, since filling
     * the queue at the console's nominal rate would play wrong-pitch audio and
     * drain it into gaps.
     */
    public boolean isAudioPaceSeeded() {
        return handle != 0 && nativeIsAudioPaceSeeded(handle);
    }

    public void clearAudio() {
        if (handle != 0) {
            nativeClearAudio(handle);
        }
    }

    public int width() {
        return handle == 0 ? 0 : nativeWidth(handle);
    }

    public int height() {
        return handle == 0 ? 0 : nativeHeight(handle);
    }

    public int sampleRate() {
        return handle == 0 ? 0 : nativeSampleRate(handle);
    }

    /**
     * Nanoseconds per emulated frame at the console's own rate (about 59.73 Hz
     * for GBA and GB), or 0 when no core is loaded. The emulation loop paces
     * with this so game speed and audio pitch match hardware instead of a
     * rounded 60 fps.
     */
    public long frameNanos() {
        return handle == 0 ? 0 : nativeFrameNanos(handle);
    }

    public boolean copyVideo(Bitmap bitmap) {
        return handle != 0 && nativeCopyVideo(handle, bitmap);
    }

    public boolean saveState(int slot) {
        return handle != 0 && nativeSaveState(handle, slot);
    }

    public boolean loadState(int slot) {
        return handle != 0 && nativeLoadState(handle, slot);
    }

    /**
     * In-memory save state for link synchronisation (TYPE_STATE). Null when the
     * core cannot produce one. The blob is self-contained and carries no
     * screenshot, so it can be sent straight over the link.
     */
    public byte[] saveStateToMemory() {
        return handle == 0 ? null : nativeSaveStateToMemory(handle);
    }

    /** Applies a state blob produced by {@link #saveStateToMemory()}. */
    public boolean loadStateFromMemory(byte[] state) {
        return handle != 0 && state != null && state.length > 0
                && nativeLoadStateFromMemory(handle, state);
    }

    public void reset() {
        if (handle != 0) {
            nativeReset(handle);
        }
    }

    public String title() {
        return handle == 0 ? "" : nativeTitle(handle);
    }

    public void setInterframe(boolean enabled) {
        if (handle != 0) {
            nativeSetInterframe(handle, enabled);
        }
    }

    public void setFrameskip(int skip) {
        if (handle != 0) {
            nativeSetFrameskip(handle, skip);
        }
    }

    public String saveFile() {
        return handle == 0 ? "" : nativeSaveFile(handle);
    }

    public void pumpLink() {
        if (handle != 0) {
            nativePumpLink(handle);
        }
    }

    public boolean linkHost(int port) {
        return handle != 0 && nativeLinkHost(handle, port);
    }

    /** 本局人数：2 走两人直连，3/4 走星型总线（主机汇聚每一轮的字）。 */
    public boolean linkHost(int port, int players) {
        return handle != 0 && nativeLinkHostPlayers(handle, port, players);
    }

    public boolean linkJoin(String host, int port) {
        return handle != 0 && host != null && nativeLinkJoin(handle, host, port);
    }

    /** players 必须与主机一致：两边的包格式不同，混用连得上但收不到数据。 */
    public boolean linkJoin(String host, int port, int players) {
        return handle != 0 && host != null && nativeLinkJoinPlayers(handle, host, port, players);
    }

    /** 进程内共享内存总线：3/4 人本机多核专用，不开 socket、不起 IO 线程。
     *  key 只在同一进程内区分会话，主机必须先于所有镜像核建立。 */
    public boolean linkHostLocal(int key, int players) {
        return handle != 0 && nativeLinkHostLocal(handle, key, players);
    }

    public boolean linkJoinLocal(int key) {
        return handle != 0 && nativeLinkJoinLocal(handle, key);
    }

    /** 占用指定链路槽位：0 归主机，1..players-1 可由任意核指定。 */
    public boolean linkJoinLocal(int key, int slot) {
        return handle != 0 && nativeLinkJoinLocalSlot(handle, key, slot);
    }

    /** 进程内锁步 SIO（默认关闭）：3/4 人本机多核专用，用 mGBA 官方
     *  GBASIOLockstepCoordinator 在 SIO 传输轮次会合，无墙钟超时、不开 socket。
     *  启用后该核帧循环自动切到小步 runLoop。key 同一进程内唯一，slot 0 归主机。 */
    public boolean linkHostLockstep(int key, int players, int slot) {
        return handle != 0 && nativeLinkHostLockstep(handle, key, players, slot);
    }

    public boolean linkJoinLockstep(int key, int slot) {
        return handle != 0 && nativeLinkJoinLockstep(handle, key, slot);
    }

    public void linkClose() {
        if (handle != 0) {
            nativeLinkClose(handle);
        }
    }

    public String linkStatus() {
        return handle == 0 ? "" : nativeLinkStatus(handle);
    }

    /** Forces the GBA battery save type; -1 lets the core autodetect. */
    public void setSaveType(int type) {
        if (handle != 0) {
            nativeSetSaveType(handle, type);
        }
    }

    /** Auto-applies IPS/UPS/BPS patches found next to the ROM on load. */
    public void setPatches(boolean enabled) {
        if (handle != 0) {
            nativeSetPatches(handle, enabled);
        }
    }

    /** BIOS options applied on the next ROM load. */
    public void setBiosOptions(boolean useBios, boolean skipIntro) {
        if (handle != 0) {
            nativeSetBiosOptions(handle, useBios, skipIntro);
        }
    }

    /** Game clock for RTC cartridges: 0 wall clock, 1 fixed epoch, 2 wall clock + offset. */
    public void setRtc(int mode, long epoch, long offset) {
        if (handle != 0) {
            nativeSetRtc(handle, mode, epoch, offset);
        }
    }

    /** Boktai solar level 0-10, or -1 to disable the sensor. */
    public void setSolar(int level) {
        if (handle != 0) {
            nativeSetSolar(handle, level);
        }
    }

    /** Enables rumble-pak simulation; poll {@link #takeRumbles()} for pulses. */
    public void setCartRumble(boolean enabled) {
        if (handle != 0) {
            nativeSetCartRumble(handle, enabled);
        }
    }

    /** Rumble pulses accumulated since the last call. */
    public int takeRumbles() {
        return handle == 0 ? 0 : nativeTakeRumbles(handle);
    }

    /**
     * Sets the twelve GB DMG palette entries (0xRRGGBB each, for
     * gb.pal[0..11]); applies live on a running GB core and on every reload.
     */
    public void setGbPalette(int[] colors) {
        if (handle != 0 && colors != null && colors.length >= 12) {
            nativeSetGbPalette(handle, colors);
        }
    }

    /** Super Game Boy border art on SGB-capable games; applies live. */
    public void setSgbBorders(boolean enabled) {
        if (handle != 0) {
            nativeSetSgbBorders(handle, enabled);
        }
    }

    /**
     * Tilt cartridge input (WarioWare Twisted, Kirby Tilt'n'Tumble). Tilt
     * values are normalized to -1..1; gyroZ follows the same scale.
     */
    public void setRotation(float tiltX, float tiltY, float gyroZ) {
        if (handle != 0) {
            nativeSetRotation(handle, tiltX, tiltY, gyroZ);
        }
    }

    public int cheatCount() {
        return handle == 0 ? 0 : nativeCheatCount(handle);
    }

    public String cheatName(int index) {
        return handle == 0 ? "" : nativeCheatName(handle, index);
    }

    public boolean cheatEnabled(int index) {
        return handle != 0 && nativeCheatEnabled(handle, index);
    }

    public void cheatSetEnabled(int index, boolean enabled) {
        if (handle != 0) {
            nativeCheatSetEnabled(handle, index, enabled);
        }
    }

    /**
     * Adds one named cheat set. {@code lines} holds one code per line;
     * {@code type} is 0 autodetect, 1 CodeBreaker, 2 GameShark, 3 Pro Action
     * Replay, 4 VBA.
     */
    public boolean cheatAdd(String name, String lines, int type) {
        return handle != 0 && lines != null && nativeCheatAdd(handle, name, lines, type);
    }

    public boolean cheatRemove(int index) {
        return handle != 0 && nativeCheatRemove(handle, index);
    }

    /**
     * Debug memory access against the live core (memory viewer, cheat search,
     * PPU viewers). width is 8, 16 or 32; values are unsigned and the GBA bus
     * mirrors open regions exactly like hardware.
     */
    public int busRead(int width, int address) {
        return handle == 0 ? 0 : nativeBusRead(handle, width, address);
    }

    public boolean busWrite(int width, int address, int value) {
        return handle != 0 && nativeBusWrite(handle, width, address, value);
    }

    /** Byte-wise bulk read (capped at 1 MiB); empty array when unreadable. */
    public byte[] busReadBlock(int address, int size) {
        if (handle == 0) {
            return new byte[0];
        }
        byte[] out = nativeBusReadBlock(handle, address, size);
        return out == null ? new byte[0] : out;
    }

    private static native int nativeBusRead(long handle, int width, int address);

    private static native boolean nativeBusWrite(long handle, int width, int address, int value);

    private static native byte[] nativeBusReadBlock(long handle, int address, int size);

    private static native long nativeCreate(String saveDir, String stateDir);

    private static native void nativeDestroy(long handle);

    private static native boolean nativeLoad(long handle, String path);

    private static native void nativeSetSaveDirs(long handle, String saveDir, String stateDir);

    private static native boolean nativeIsLoaded(long handle);

    private static native void nativeSetKeys(long handle, int keys);

    private static native void nativeSetTurbo(long handle, int mask);

    private static native void nativeSetRewind(long handle, boolean enabled);
    private static native void nativeBusGameStart(long handle, int idx, int menuAt, int modeDowns);
    private static native void nativeBusGameStop(long handle);
    private static native int nativeBusGameTick(long handle);

    private static native boolean nativeRewind(long handle, int seconds);

    private static native void nativeSetChannelVolumes(long handle, int[] gains);

    private static native boolean nativeRunFrames(long handle, int keys, int count);

    private static native int nativeReadAudioOut(long handle, short[] out, double speed, float drift);
    private static native void nativeSetAudioPaceFps(long handle, float fps);
    private static native void nativeSetAudioConstantPitch(long handle, boolean on, float stretch);
    private static native void nativeSetAudioHoldMode(long handle, int mode);
    private static native void nativeResetAudioPace(long handle);
    private static native boolean nativeIsAudioPaceSeeded(long handle);

    private static native boolean nativeSetAudioOutput(long handle, int outRate);

    private static native void nativeClearAudio(long handle);

    private static native int nativeWidth(long handle);

    private static native int nativeHeight(long handle);

    private static native int nativeSampleRate(long handle);

    private static native long nativeFrameNanos(long handle);

    private static native boolean nativeCopyVideo(long handle, Bitmap bitmap);

    private static native boolean nativeSaveState(long handle, int slot);

    private static native boolean nativeLoadState(long handle, int slot);

    private static native void nativeReset(long handle);

    private static native String nativeTitle(long handle);

    private static native void nativeSetInterframe(long handle, boolean enabled);

    private static native void nativeSetFrameskip(long handle, int skip);

    private static native String nativeSaveFile(long handle);

    private static native void nativePumpLink(long handle);

    private static native boolean nativeLinkHost(long handle, int port);

    private static native boolean nativeLinkHostPlayers(long handle, int port, int players);

    private static native boolean nativeLinkJoin(long handle, String host, int port);

    private static native boolean nativeLinkJoinPlayers(long handle, String host, int port, int players);

    private static native boolean nativeLinkHostLocal(long handle, int key, int players);

    private static native boolean nativeLinkJoinLocal(long handle, int key);

    private static native boolean nativeLinkJoinLocalSlot(long handle, int key, int slot);

    private static native boolean nativeLinkHostLockstep(long handle, int key, int players, int slot);

    private static native boolean nativeLinkJoinLockstep(long handle, int key, int slot);

    private static native void nativeLinkClose(long handle);

    private static native String nativeLinkStatus(long handle);

    private static native void nativeSetSaveType(long handle, int type);

    private static native void nativeSetPatches(long handle, boolean enabled);

    private static native void nativeSetBiosOptions(long handle, boolean useBios, boolean skipIntro);

    private static native void nativeSetRtc(long handle, int mode, long epoch, long offset);

    private static native void nativeSetSolar(long handle, int level);

    private static native void nativeSetCartRumble(long handle, boolean enabled);

    private static native int nativeTakeRumbles(long handle);

    private static native void nativeSetGbPalette(long handle, int[] colors);

    private static native void nativeSetSgbBorders(long handle, boolean enabled);

    private static native void nativeSetRotation(long handle, float tiltX, float tiltY, float gyroZ);

    private static native int nativeCheatCount(long handle);

    private static native String nativeCheatName(long handle, int index);

    private static native boolean nativeCheatEnabled(long handle, int index);

    private static native void nativeCheatSetEnabled(long handle, int index, boolean enabled);

    private static native boolean nativeCheatAdd(long handle, String name, String lines, int type);

    private static native boolean nativeCheatRemove(long handle, int index);
    private static native byte[] nativeSaveStateToMemory(long handle);
    private static native boolean nativeLoadStateFromMemory(long handle, byte[] state);
}
