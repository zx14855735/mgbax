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
    private final int localSlot;   /* 本机可见核在全局会话里的槽位，1..players */
    private final boolean useLockstep;  /* 默认 false，保持共享内存总线不变 */

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
    /* start() 里实际生效的锁步模式：beginFrame/endFrame 的 Java 帧栅栏只服务
     * 共享内存总线（它就是那种模式下的同步手段）；native 锁步自己会在 SIO
     * 轮次会合，帧栅栏会把镜像门成每帧一停、可见核每帧吃满超时。 */
    private boolean lockstepActive;
    /* beginFrame 传入的是 activity 启动以来的全局帧号（可达数万），而镜像从
     * -1 起步：不重基线的话镜像要空追上万帧，追上之前 endFrame 每帧都吃满
     * FRAME_WAIT_MS 超时（外观就是 8fps + 镜像几百 fps 空转）。 */
    private long frameEpoch = -1L;

    /** Two-player session (original behaviour, unchanged). */
    public GBoyConsoleSet(File rom, File saveDir, File stateDir, int basePort) {
        this(rom, saveDir, stateDir, basePort, 2);
    }

    /** @param players 2..4 consoles in this process; 3/4 use the star bus. */
    public GBoyConsoleSet(File rom, File saveDir, File stateDir, int basePort, int players) {
        this(rom, saveDir, stateDir, basePort, players, 1);
    }

    /**
     * @param players 2..4 consoles in this process; 3/4 use the in-process bus.
     * @param localSlot slot owned by this device's visible core (1..players).
     *                  Devices in a multi-device session must use distinct
     *                  slots; the visible core joins that exact link slot so
     *                  the game identifies it as the right player.
     */
    public GBoyConsoleSet(File rom, File saveDir, File stateDir, int basePort,
                          int players, int localSlot) {
        this(rom, saveDir, stateDir, basePort, players, localSlot, false);
    }

    /** @param useLockstep 3/4 人时改用进程内锁步 SIO（默认 false 走共享内存总线）。 */
    public GBoyConsoleSet(File rom, File saveDir, File stateDir, int basePort,
                          int players, int localSlot, boolean useLockstep) {
        if (rom == null || saveDir == null || stateDir == null) {
            throw new IllegalArgumentException("rom and save directories are required");
        }
        if (basePort < 1 || basePort > 65535 - PORT_ATTEMPTS) {
            throw new IllegalArgumentException("invalid loopback port: " + basePort);
        }
        if (players < 2 || players > MAX_CONSOLES) {
            throw new IllegalArgumentException("invalid console count: " + players);
        }
        if (localSlot < 1 || localSlot > players) {
            throw new IllegalArgumentException("invalid local slot: " + localSlot);
        }
        this.rom = rom;
        this.saveDir = saveDir;
        this.stateDir = stateDir;
        this.basePort = basePort;
        this.players = players;
        this.localSlot = localSlot;
        this.useLockstep = useLockstep;
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

        /* 锁步对任意人数都有意义（协调器就是 N 人的）；旧判断把两人静默
         * 降级回环回 TCP 总线，use_lockstep 开关看似无效。localBus 仍只描述
         * 「非锁步时 3/4 人走共享内存总线、两人走环回直连」这一既有分工。 */
        final boolean localBus = players > 2;
        final boolean lockstepMode = useLockstep;
        lockstepActive = lockstepMode;
        final int busKey = basePort;
        /* localSlot > 1 时可见核必须占它自己的链路槽位，而 host 恒占槽位 0，
         * 所以让第一个镜像核当 host（代表全局槽位 1），可见核 join 到
         * localSlot - 1。localSlot == 1 时保持原样：可见核就是 host。 */
        final int hostMirrorIndex = (!lockstepMode && localBus && localSlot > 1) ? 0 : -1;
        int port = -1;
        if (lockstepMode) {
            /* 进程内锁步：所有核共享一个 GBASIOLockstepCoordinator。
             * 槽位必须显式分配（协调器不自动排号）：host 恒 0，本机可见核
             * 占 localSlot-1，其余按空闲槽位填。host 必须先建房间，否则
             * join 找不到 key。 */
            final int cores = players;   // primary + mirrors
            int[] slotOf = new int[cores];
            boolean[] taken = new boolean[players];
            int hostIdx = (localSlot > 1) ? 1 : 0;  // 0=primary, 1..=mirrors
            slotOf[hostIdx] = 0;
            taken[0] = true;
            if (hostIdx != 0) {
                slotOf[0] = localSlot - 1;
                taken[localSlot - 1] = true;
            }
            int next = 1;
            for (int k = 0; k < cores; ++k) {
                if (k == hostIdx || (k == 0 && hostIdx != 0)) {
                    continue;
                }
                while (next < players && taken[next]) {
                    ++next;
                }
                slotOf[k] = next;
                taken[next] = true;
            }
            MgbaCore hostCore = (hostIdx == 0) ? primary : mirrors[hostIdx - 1];
            boolean ok = hostCore.linkHostLockstep(busKey, players, 0);
            for (int k = 0; k < cores && ok; ++k) {
                if (k == hostIdx) {
                    continue;
                }
                MgbaCore c = (k == 0) ? primary : mirrors[k - 1];
                ok = c.linkJoinLockstep(busKey, slotOf[k]);
            }
            if (ok) {
                port = busKey;
            }
        } else if (localBus) {
            MgbaCore host = hostMirrorIndex >= 0 ? mirrors[hostMirrorIndex] : primary;
            if (host.linkHostLocal(busKey, players)) {
                if (hostMirrorIndex < 0
                        || primary.linkJoinLocal(busKey, localSlot - 1)) {
                    port = busKey;
                }
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
            return fail(lockstepMode ? "进程内锁步创建失败: key=" + busKey + " slot=" + localSlot
                        : localBus ? "进程内总线创建失败: key=" + busKey + " slot=" + localSlot
                                   : "环回监听端口不可用: " + basePort);
        }
        linkPort = port;

        for (int i = 0; i < count; ++i) {
            if (lockstepMode || i == hostMirrorIndex) {
                continue;   // 锁步模式已在上面逐个 attach 完；否则跳过 host
            }
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
            frameEpoch = -1L;
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

    /** Publishes a frame to every mirror core. Call before the visible core runs it.
     *  锁步模式下是空操作：native 协调器已经在 SIO 轮次上把各核会合，镜像线程
     *  自由推进即可，这里再按帧放行反而把镜像门成每帧一停。 */
    public void beginFrame(long frame) {
        if (state != State.READY || lockstepActive) {
            return;
        }
        synchronized (lock) {
            long rel = relativeFrame(frame);
            if (rel > targetFrame) {
                targetFrame = rel;
                lock.notifyAll();
            }
        }
    }

    /**
     * Waits until every mirror core has executed the same frame. A timeout is
     * recorded but never freezes the visible loop.
     */
    public void endFrame(long frame) {
        if (state != State.READY || lockstepActive || mirrorFrames == null) {
            return;
        }
        long rel = relativeFrame(frame);
        synchronized (lock) {
            long deadline = System.currentTimeMillis() + FRAME_WAIT_MS;
            while (slowestMirror() < rel && state == State.READY
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
            if (slowestMirror() < rel) {
                ++frameTimeouts;
            }
        }
    }

    /** 把全局帧号折算成本会话内的相对帧号；第一次调用定纪元。 */
    private long relativeFrame(long frame) {
        if (frameEpoch < 0) {
            frameEpoch = frame;
        }
        long rel = frame - frameEpoch;
        return rel < 0 ? 0 : rel;
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

    /**
     * 第 index 个镜像核代表的全局槽位：跳过本机 localSlot 后的第 index 个。
     * localSlot == 1 时结果恒为 index + 2，与原来的固定映射完全一致。
     * 静态纯函数，便于 JVM 单测覆盖四台设备的所有槽位组合。
     */
    public static int mirrorSlotFor(int localSlot, int players, int index) {
        return GBoyLinkSession.mirrorSlotFor(localSlot, players, index);
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
        if (lockstepActive) {
            /* native 锁步：协调器在 SIO 轮次上会合各核，镜像线程自由推进即可
             * （跑太快会在下一个 SIO 轮被 park 住等可见核，正是锁步语义）。
             * 走 beginFrame/endFrame 的逐帧放行会让可见核的 native 帧永远
             * 等不到已入睡的镜像到场，每帧退化成一次超时。 */
            while (state == State.READY) {
                MgbaCore core = mirrors == null ? null : mirrors[index];
                if (core == null) {
                    return;
                }
                GBoyLinkSession net = session;
                int keys = net != null ? net.keysForSlot(mirrorSlotFor(localSlot, players, index)) : 0;
                core.setKeys(keys);
                core.pumpLink();
                core.runFrames(keys, 1);
            }
            return;
        }
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
            int keys = net != null ? net.keysForSlot(mirrorSlotFor(localSlot, players, index)) : 0;
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
