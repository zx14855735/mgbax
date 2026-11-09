/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Local counterpart of the official {@code com/game/boy/emu/gba/Link}.
 *
 * <p>The official client keeps up to four {@code Console} cores in one process
 * and advances them with a single native {@code Link.runFrame(boolean)}; SIO
 * never crosses the network. The network carries only key masks, injected per
 * console with {@code Console.setKeys(int)}. This class reproduces that shape on
 * mGBA: the visible core is slot 1, a hidden mirror core is slot 2, and the two
 * are joined over the 127.0.0.1 loopback SIO link.</p>
 *
 * <p>mGBA's native link driver blocks waiting for the peer word, so the two
 * cores must run on separate threads - a single thread alternating
 * {@code runFrames} deadlocks. The official native {@code runFrame} hides the
 * same requirement inside the library.</p>
 *
 * <p>Key masks come from {@link GBoyLinkSession#keysForSlot(int)}, which keeps
 * the official five-frame (12 Hz) sample cadence. The current loopback link is
 * point to point, so this drives two consoles; the slot-indexed API leaves room
 * for the three- and four-player layouts.</p>
 */
public final class GBoyConsoleSet {

    public enum State { NEW, LINKING, READY, STOPPED, FAILED }

    private static final long FRAME_WAIT_MS = 250L;
    private static final int JOIN_ATTEMPTS = 50;
    private static final int JOIN_RETRY_MS = 20;
    private static final int CONNECT_TIMEOUT_MS = 3000;
    private static final int PORT_ATTEMPTS = 8;
    private static final String LOOPBACK = "127.0.0.1";
    private static final String MIRROR_DIR = "mirror";

    private final Object lock = new Object();
    private final File rom;
    private final File saveDir;
    private final File stateDir;
    private final int basePort;

    private MgbaCore primary;
    private MgbaCore mirror;
    private GBoyLinkSession session;
    private Thread mirrorThread;
    private volatile State state = State.NEW;
    private volatile String failure = "";

    private long targetFrame = -1L;
    private long mirrorFrame = -1L;
    private long frameTimeouts;
    private int linkPort;

    public GBoyConsoleSet(File rom, File saveDir, File stateDir, int basePort) {
        if (rom == null || saveDir == null || stateDir == null) {
            throw new IllegalArgumentException("rom and save directories are required");
        }
        if (basePort < 1 || basePort > 65535 - PORT_ATTEMPTS) {
            throw new IllegalArgumentException("invalid loopback port: " + basePort);
        }
        this.rom = rom;
        this.saveDir = saveDir;
        this.stateDir = stateDir;
        this.basePort = basePort;
    }

    /**
     * Creates the mirror core, copies the current battery save so both cores
     * start deterministically, connects them over loopback, then starts the
     * mirror thread. Returns false with {@link #failure()} on any error.
     */
    public boolean start(MgbaCore visible, GBoyLinkSession linkSession) {
        if (visible == null || !visible.isLoaded()) {
            return fail("主核心尚未加载 ROM");
        }
        synchronized (lock) {
            if (state == State.READY || state == State.LINKING) {
                return fail("多核心会话已在运行");
            }
        }
        primary = visible;
        session = linkSession;
        state = State.LINKING;

        File mirrorSave = new File(saveDir, MIRROR_DIR);
        File mirrorState = new File(stateDir, MIRROR_DIR);
        if (!mkdirs(mirrorSave) || !mkdirs(mirrorState)) {
            return fail("无法创建镜像存档目录");
        }
        String saveError = copyPrimarySave(primary.saveFile(), mirrorSave);
        if (saveError != null) {
            return fail(saveError);
        }

        MgbaCore second = new MgbaCore(mirrorSave, mirrorState);
        if (!second.load(rom.getAbsolutePath())) {
            second.destroy();
            return fail("镜像核心加载 ROM 失败: " + rom.getAbsolutePath());
        }
        mirror = second;

        int port = -1;
        for (int attempt = 0; attempt < PORT_ATTEMPTS && port < 0; ++attempt) {
            int candidate = basePort + attempt;
            if (primary.linkHost(candidate)) {
                port = candidate;
            }
        }
        if (port < 0) {
            return fail("环回监听端口不可用: " + basePort);
        }
        linkPort = port;

        boolean joined = false;
        for (int attempt = 0; attempt < JOIN_ATTEMPTS && !joined; ++attempt) {
            joined = mirror.linkJoin(LOOPBACK, linkPort);
            if (!joined) {
                sleep(JOIN_RETRY_MS);
            }
        }
        if (!joined) {
            return fail("镜像核心无法连上环回端口 " + linkPort);
        }

        long deadline = System.currentTimeMillis() + CONNECT_TIMEOUT_MS;
        boolean connected = false;
        while (System.currentTimeMillis() < deadline) {
            if (connectedStatus(primary) && connectedStatus(mirror)) {
                connected = true;
                break;
            }
            primary.pumpLink();
            mirror.pumpLink();
            sleep(JOIN_RETRY_MS);
        }
        if (!connected) {
            return fail("环回链路握手超时");
        }

        synchronized (lock) {
            targetFrame = -1L;
            mirrorFrame = -1L;
            frameTimeouts = 0L;
        }
        state = State.READY;
        mirrorThread = new Thread(this::mirrorLoop, "mGBA-console-2");
        mirrorThread.setPriority(Thread.MAX_PRIORITY);
        mirrorThread.start();
        return true;
    }

    /** Publishes a frame to the mirror core. Call before the visible core runs it. */
    public void beginFrame(long frame) {
        if (state != State.READY) {
            return;
        }
        synchronized (lock) {
            if (frame > targetFrame) {
                targetFrame = frame;
                lock.notifyAll();
            }
        }
    }

    /**
     * Waits until the mirror core has executed the same frame. A timeout is
     * recorded but never freezes the visible loop.
     */
    public void endFrame(long frame) {
        if (state != State.READY) {
            return;
        }
        synchronized (lock) {
            long deadline = System.currentTimeMillis() + FRAME_WAIT_MS;
            while (mirrorFrame < frame && state == State.READY
                    && System.currentTimeMillis() < deadline) {
                long left = deadline - System.currentTimeMillis();
                if (left <= 0) {
                    break;
                }
                try {
                    lock.wait(left);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            if (mirrorFrame < frame) {
                ++frameTimeouts;
            }
        }
    }

    /** Closes the loopback link, stops the mirror thread and destroys the core. */
    public void stop() {
        if (state == State.NEW || state == State.STOPPED) {
            return;
        }
        state = State.STOPPED;
        synchronized (lock) {
            lock.notifyAll();
        }
        Thread thread = mirrorThread;
        if (thread != null) {
            try {
                thread.join(FRAME_WAIT_MS * 2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            mirrorThread = null;
        }
        if (mirror != null) {
            mirror.linkClose();
            mirror.destroy();
            mirror = null;
        }
        if (primary != null) {
            primary.linkClose();
            primary = null;
        }
    }

    public State state() {
        return state;
    }

    public String failure() {
        return failure;
    }

    public int linkPort() {
        return linkPort;
    }

    public long mirrorFrame() {
        synchronized (lock) {
            return mirrorFrame;
        }
    }

    public long frameTimeouts() {
        synchronized (lock) {
            return frameTimeouts;
        }
    }

    private void mirrorLoop() {
        while (state == State.READY) {
            long frame;
            synchronized (lock) {
                while (state == State.READY && mirrorFrame >= targetFrame) {
                    try {
                        lock.wait(FRAME_WAIT_MS);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                if (state != State.READY) {
                    return;
                }
                frame = mirrorFrame + 1;
            }
            MgbaCore core = mirror;
            if (core == null) {
                return;
            }
            GBoyLinkSession net = session;
            int keys = net != null ? net.keysForSlot(2) : 0;
            core.setKeys(keys);
            core.pumpLink();
            core.runFrames(keys, 1);
            synchronized (lock) {
                mirrorFrame = frame;
                lock.notifyAll();
            }
        }
    }

    private boolean fail(String reason) {
        failure = reason;
        state = State.FAILED;
        MgbaCore second = mirror;
        if (second != null) {
            second.linkClose();
            second.destroy();
            mirror = null;
        }
        MgbaCore visible = primary;
        if (visible != null) {
            visible.linkClose();
        }
        return false;
    }

    private static boolean connectedStatus(MgbaCore core) {
        String status = core.linkStatus();
        return status != null && !status.isEmpty() && status.charAt(0) == '2';
    }

    private static boolean mkdirs(File dir) {
        return dir.isDirectory() || dir.mkdirs();
    }

    private static String copyPrimarySave(String savePath, File mirrorSave) {
        if (savePath == null || savePath.isEmpty()) {
            return null;
        }
        File source = new File(savePath);
        if (!source.isFile()) {
            return null;
        }
        File target = new File(mirrorSave, source.getName());
        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(target)) {
            byte[] buffer = new byte[8192];
            int n;
            while ((n = in.read(buffer)) > 0) {
                out.write(buffer, 0, n);
            }
            return null;
        } catch (IOException e) {
            return "复制初始存档失败: " + e.getMessage();
        }
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
