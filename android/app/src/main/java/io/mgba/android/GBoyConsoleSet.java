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
 * mGBA: the visible core is slot 1, and {@code players - 1} hidden mirror cores
 * occupy slots 2..N, all joined over the 127.0.0.1 loopback SIO link.</p>
 *
 * <p>mGBA's native link driver blocks waiting for the peer word, so every core
 * must run on its own thread - a single thread alternating {@code runFrames}
 * deadlocks. A frame barrier keeps the mirrors aligned with the visible loop.</p>
 *
 * <p>Two-player sessions use the original point-to-point loopback
 * ({@code linkHost(port)} / {@code linkJoin(host, port)}), the verified path,
 * left untouched. 3/4-player sessions use the in-process shared-memory bus
 * ({@code linkHostLocal(key, players)} / {@code linkJoinLocal(key)}): rounds
 * rendezvous on a cond broadcast in microseconds, with no socket and no 2 ms
 * per-round timeout floor. The host is the only clock source, so slaves always
 * adopt the host round index. The 127.0.0.1 TCP star bus remains in use by
 * {@code startBusLink()} for single-core cross-device 3/4-player sessions.</p>
 *
 * <p>Mixing the point-to-point and bus packet formats on one connection
 * silently drops every word, so {@code players} must match on all cores of the
 * set. Between devices only key masks travel over the network.</p>
 */
public final class GBoyConsoleSet {

    public enum State { NEW, LINKING, READY, STOPPED, FAILED }

    private static final long FRAME_WAIT_MS = 250L;
    private static final int JOIN_ATTEMPTS = 50;
    private static final int JOIN_RETRY_MS = 20;
    private static final int CONNECT_TIMEOUT_MS = 3000;
    private static final int PORT_ATTEMPTS = 8;
    private static final String LOOPBACK = "127.0.0.1";
    private static final String MIRROR_DIR_PREFIX = "mirror";
    private static final int MAX_CONSOLES = GBoyLinkSession.MAX_CONSOLES;

    private final Object lock = new Object();
    private final File rom;
    private final File saveDir;
    private final File stateDir;
    private final int basePort;
    private final int players;

    private MgbaCore primary;
    private MgbaCore[] mirrors;
    private Thread[] mirrorThreads;
    private long[] mirrorFrames;
    private GBoyLinkSession session;
    private volatile State state = State.NEW;
    private volatile String failure = "";

    private long targetFrame = -1L;
    private long frameTimeouts;
    private int linkPort;

    /** Two-player session (original behaviour, unchanged). */
    public GBoyConsoleSet(File rom, File saveDir, File stateDir, int basePort) {
        this(rom, saveDir, stateDir, basePort, 2);
    }

    /** @param players 2..4 consoles in this process; 3/4 use the star bus. */
    public GBoyConsoleSet(File rom, File saveDir, File stateDir, int basePort, int players) {
        if (rom == null || saveDir == null || stateDir == null) {
            throw new IllegalArgumentException("rom and save directories are required");
        }
        if (basePort < 1 || basePort > 65535 - PORT_ATTEMPTS) {
            throw new IllegalArgumentException("invalid loopback port: " + basePort);
        }
        if (players < 2 || players > MAX_CONSOLES) {
            throw new IllegalArgumentException("invalid console count: " + players);
        }
        this.rom = rom;
        this.saveDir = saveDir;
        this.stateDir = stateDir;
        this.basePort = basePort;
        this.players = players;
    }

    /**
     * Creates the mirror cores, copies the current battery save so they all
     * start deterministically, joins them over loopback, then starts one thread
     * per mirror. Returns false with {@link #failure()} on any error.
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

        final int count = players - 1;
        mirrors = new MgbaCore[count];
        mirrorThreads = new Thread[count];
        mirrorFrames = new long[count];
        for (int i = 0; i < count; ++i) {
            String dir = MIRROR_DIR_PREFIX + (i + 1);
            File mirrorSave = new File(saveDir, dir);
            File mirrorState = new File(stateDir, dir);
            if (!mkdirs(mirrorSave) || !mkdirs(mirrorState)) {
                return fail("无法创建镜像存档目录 " + dir);
            }
            String saveError = copyPrimarySave(primary.saveFile(), mirrorSave);
            if (saveError != null) {
                return fail(saveError);
            }
            MgbaCore core = new MgbaCore(mirrorSave, mirrorState);
            if (!core.load(rom.getAbsolutePath())) {
                core.destroy();
                return fail("镜像核心加载 ROM 失败: " + rom.getAbsolutePath());
            }
            mirrors[i] = core;
        }

        /* 3/4 人改走进程内共享内存总线：核间 SIO 不再经 127.0.0.1 TCP，
         * 会合靠 cond 广播（µs 级），也没有每轮 2ms 超时地板。两人路径一字
         * 不动，仍是已经验证过的环回直连。 */
        final boolean localBus = players > 2;
        final int busKey = basePort;
        int port = -1;
        if (localBus) {
            if (primary.linkHostLocal(busKey, players)) {
                port = busKey;
            }
        } else {
            for (int attempt = 0; attempt < PORT_ATTEMPTS && port < 0; ++attempt) {
                int candidate = basePort + attempt;
                if (primary.linkHost(candidate)) {
                    port = candidate;
                }
            }
        }
        if (port < 0) {
            return fail(localBus ? "进程内总线创建失败: key=" + busKey
                                 : "环回监听端口不可用: " + basePort);
        }
        linkPort = port;

        for (int i = 0; i < count; ++i) {
            boolean joined = false;
            for (int attempt = 0; attempt < JOIN_ATTEMPTS && !joined; ++attempt) {
                joined = localBus
                        ? mirrors[i].linkJoinLocal(busKey)
                        : mirrors[i].linkJoin(LOOPBACK, linkPort);
                if (!joined) {
                    sleep(JOIN_RETRY_MS);
                }
            }
            if (!joined) {
                return fail(localBus
                        ? "镜像核心 " + (i + 2) + " 无法接入进程内总线 key=" + busKey
                        : "镜像核心 " + (i + 2) + " 无法连上环回端口 " + linkPort);
            }
        }

        long deadline = System.currentTimeMillis() + CONNECT_TIMEOUT_MS;
        boolean connected = false;
        while (System.currentTimeMillis() < deadline) {
            boolean all = connectedStatus(primary);
            for (int i = 0; i < count && all; ++i) {
                all = connectedStatus(mirrors[i]);
            }
            if (all) {
                connected = true;
                break;
            }
            primary.pumpLink();
            for (int i = 0; i < count; ++i) {
                mirrors[i].pumpLink();
            }
            sleep(JOIN_RETRY_MS);
        }
        if (!connected) {
            return fail("环回链路握手超时");
        }

        synchronized (lock) {
            targetFrame = -1L;
            for (int i = 0; i < count; ++i) {
                mirrorFrames[i] = -1L;
            }
            frameTimeouts = 0L;
        }
        state = State.READY;
        for (int i = 0; i < count; ++i) {
            final int index = i;
            Thread thread = new Thread(() -> mirrorLoop(index), "mGBA-console-" + (index + 2));
            thread.setPriority(Thread.MAX_PRIORITY);
            mirrorThreads[i] = thread;
            thread.start();
        }
        return true;
    }

    /** Publishes a frame to every mirror core. Call before the visible core runs it. */
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
     * Waits until every mirror core has executed the same frame. A timeout is
     * recorded but never freezes the visible loop.
     */
    public void endFrame(long frame) {
        if (state != State.READY || mirrorFrames == null) {
            return;
        }
        synchronized (lock) {
            long deadline = System.currentTimeMillis() + FRAME_WAIT_MS;
            while (slowestMirror() < frame && state == State.READY
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
            if (slowestMirror() < frame) {
                ++frameTimeouts;
            }
        }
    }

    /** Closes the loopback link, stops every mirror thread and destroys the cores. */
    public void stop() {
        if (state == State.NEW || state == State.STOPPED) {
            return;
        }
        state = State.STOPPED;
        synchronized (lock) {
            lock.notifyAll();
        }
        if (mirrorThreads != null) {
            for (Thread thread : mirrorThreads) {
                if (thread == null) {
                    continue;
                }
                try {
                    thread.join(FRAME_WAIT_MS * 2);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            mirrorThreads = null;
        }
        if (mirrors != null) {
            for (MgbaCore core : mirrors) {
                if (core != null) {
                    core.linkClose();
                    core.destroy();
                }
            }
            mirrors = null;
        }
        if (primary != null) {
            primary.linkClose();
            primary = null;
        }
    }

    /** Snapshot of the visible core, for TYPE_STATE when a link starts. */
    public byte[] snapshotState() {
        MgbaCore visible = primary;
        return visible == null ? null : visible.saveStateToMemory();
    }

    /** Applies a peer state blob to every hidden mirror console. */
    public boolean applyRemoteState(byte[] state) {
        if (mirrors == null) {
            return false;
        }
        boolean applied = false;
        for (MgbaCore core : mirrors) {
            if (core != null && core.loadStateFromMemory(state)) {
                applied = true;
            }
        }
        return applied;
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

    public int players() {
        return players;
    }

    /** Frame number of the slowest mirror (-1 before the first frame). */
    public long mirrorFrame() {
        synchronized (lock) {
            return slowestMirror();
        }
    }

    public long frameTimeouts() {
        synchronized (lock) {
            return frameTimeouts;
        }
    }

    private long slowestMirror() {
        if (mirrorFrames == null || mirrorFrames.length == 0) {
            return -1L;
        }
        long slowest = mirrorFrames[0];
        for (int i = 1; i < mirrorFrames.length; ++i) {
            if (mirrorFrames[i] < slowest) {
                slowest = mirrorFrames[i];
            }
        }
        return slowest;
    }

    private void mirrorLoop(int index) {
        while (state == State.READY) {
            long frame;
            synchronized (lock) {
                while (state == State.READY && mirrorFrames[index] >= targetFrame) {
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
                frame = mirrorFrames[index] + 1;
            }
            MgbaCore core = mirrors == null ? null : mirrors[index];
            if (core == null) {
                return;
            }
            GBoyLinkSession net = session;
            int keys = net != null ? net.keysForSlot(index + 2) : 0;
            core.setKeys(keys);
            core.pumpLink();
            core.runFrames(keys, 1);
            synchronized (lock) {
                mirrorFrames[index] = frame;
                lock.notifyAll();
            }
        }
    }

    private boolean fail(String reason) {
        failure = reason;
        state = State.FAILED;
        if (mirrors != null) {
            for (MgbaCore core : mirrors) {
                if (core != null) {
                    core.linkClose();
                    core.destroy();
                }
            }
            mirrors = null;
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
