/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package io.mgba.android;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * C0 能力协商门的**端到端**自检（Android 侧对齐 PC 的 {@code test-gboylink --gatetest}）。
 *
 * <p>{@link C0LinkModeTest} 测的是纯决策表 {@link GBoyCloudLink#decideLinkMode}；
 * 本类驱动**门本体** {@code GBoyCloudLink.negotiateLinkMode()} 与对端模式回写
 * {@code notePeerLinkMode()}，断言 {@code linkMode()} / {@code officialMode()} /
 * {@code modeRejected} 这些**真实可见量**，而不只是「返回 false」。</p>
 *
 * <h3>为什么用反射</h3>
 * 两个方法都是 {@code private}（生产代码本轮**一个字不改** —— 主理人明确要求，
 * 不为可测性改产品行为）。代价：测试与私有方法名/字段名耦合，重命名会让它硬失败。
 * <b>这是刻意的</b>：宁可硬失败，也不要静默失效（静默失效等于假绿）。
 *
 * <h3>它额外覆盖的三条结构性事实（两端都曾缺）</h3>
 * <ol>
 *   <li><b>早退先于判定</b>：一旦 {@code modeRejected} 为真（例如先前收到过畸形
 *       能力位），{@code negotiateLinkMode()} 必须在**顶部**短路返回 false —— 不得
 *       再解析本端模式、不得改写 {@code peerLinkMode}、不得再产生一条状态文案。</li>
 *   <li><b>畸形分支必须真的可执行</b>：生产路径上 {@code peerLinkMode} 永远不会是
 *       {@code LINK_MODE_INVALID}（{@code notePeerLinkMode()} 遇 INVALID 只置
 *       {@code modeRejected} + fail 然后 return，不写回 {@code peerLinkMode}），
 *       于是 {@code decideLinkMode} 的 4 号码是「写了但永不执行」的候选死代码。
 *       本类清掉 {@code modeRejected} 后**直接把 {@code peerLinkMode} 置为 -2**，
 *       强制走到 4 号分支并断言拒绝文案 —— 将来谁删掉那个分支，这里必红。</li>
 *   <li><b>「未声明」/「冲突」两条分支有意不幂等</b>：它们是顶部短路被误删时的
 *       报警器（再报一条文案），所以本类用「门运行到一半才立起拒绝位」的时序把
 *       「会重复报」钉死。谁把这两条改成 {@code if (!modeRejected)} 幂等，
 *       报警器就没了，用例必红 —— 这是刻意保留的不一致，不是待清理的重复代码。</li>
 * </ol>
 *
 * <p>运行时依赖 {@code src/test/java/android/util/Log.java} 手写桩（纯 JVM 无
 * android.jar，门会走 {@code Log.d} / {@code GbCloud.trace}）。</p>
 */
public final class C0GateTest {

    private static final int A = GBoyFrames.LINK_MODE_A;
    private static final int B = GBoyFrames.LINK_MODE_B;
    private static final int UNKNOWN = GBoyFrames.LINK_MODE_UNKNOWN;
    private static final int INVALID = GBoyFrames.LINK_MODE_INVALID;

    private static int passed;
    private static int failed;

    /* ---- 反射入口（一次性解析，失败即整体失败：宁可炸在开头也不要静默跳过） ---- */
    private static Class<?> roomClass;
    private static Constructor<?> roomCtor;
    private static Field roomPlayerCount;
    private static Method negotiate;
    private static Method notePeerMethod;

    private static final Map<String, Field> FIELDS = new HashMap<>();

    private static FakeHooks hooks;

    public static void main(String[] args) throws Exception {
        resolveGate();
        acceptsMatchingModes();
        fallsBackForLegacyPeer();
        rejectsUndeclaredWithoutLegacy();
        rejectsConflictEvenWithLegacy();
        undeclaredRejectionReemitsWhenLatchArrivesMidGate();
        conflictRejectionReemitsWhenLatchArrivesMidGate();
        malformedBranchIsReachable();
        rejectedShortCircuitsBeforeJudging();
        malformedWriteBackSurvivesRemovedShortCircuit();
        autoModeFollowsPlayerCount();

        int total = passed + failed;
        if (failed == 0) {
            System.out.println(total + "/" + total + " PASS");
            return;
        }
        System.out.println(passed + "/" + total + " PASS, " + failed + " FAIL");
        System.exit(1);
    }

    /** 解析私有入口与私有字段；任何一步失败都直接抛出（不掩盖）。 */
    private static void resolveGate() throws Exception {
        Class<?> linkInterface = Class.forName("io.mgba.android.GBoyCloudLink$Link");
        roomClass = Class.forName("io.mgba.android.GBoyCloudLink$Room");
        roomCtor = roomClass.getDeclaredConstructor();
        roomCtor.setAccessible(true);
        roomPlayerCount = roomClass.getDeclaredField("playerCount");
        roomPlayerCount.setAccessible(true);

        negotiate = GBoyCloudLink.class.getDeclaredMethod(
                "negotiateLinkMode", roomClass, String.class, linkInterface);
        negotiate.setAccessible(true);
        notePeerMethod = GBoyCloudLink.class.getDeclaredMethod(
                "notePeerLinkMode", int.class, String.class);
        notePeerMethod.setAccessible(true);

        for (String name : new String[]{"modeRejected", "peerLinkMode", "linkMode",
                "officialMode", "allowLegacyPeer", "modeBound", "modeOverride", "closed"}) {
            Field field = GBoyCloudLink.class.getDeclaredField(name);
            field.setAccessible(true);
            FIELDS.put(name, field);
        }
    }

    // ---------------------------------------------------------------- 用例

    /**
     * 类别 0 · 两端一致：按本端模式接受，且给出可见的成功文案。
     * 2 人房 AUTO 解析为 A（{@code resolveLinkMode}：3 人以上才 B）。
     */
    private static void acceptsMatchingModes() throws Exception {
        GBoyCloudLink link = fresh();
        set("peerLinkMode", link, A);
        Object room = room(2);

        check(gate(link, room), "matching modes (A+A) are accepted: gate returns true");
        check(link.linkMode() == A, "matching modes keep linkMode() = A");
        check(!link.officialMode(), "mode A leaves officialMode() false");
        check(!getBoolean("modeRejected", link), "accepting never marks the gate rejected");
        String status = lastStatus();
        check(status.contains("联机模式协商通过"), "acceptance reports the success text (协商通过)");
        check(status.contains("2 人房"), "acceptance reports the room size (2 players)");
        check(status.contains("C0GateTest"), "acceptance reports where the gate ran");
    }

    /**
     * 类别 1 · 对端未声明 + allowLegacy=true：回落 B，且文案里明确写出这是
     * 「显式许可的回落」而不是静默降级。
     */
    private static void fallsBackForLegacyPeer() throws Exception {
        GBoyCloudLink link = fresh();
        set("allowLegacyPeer", link, true);
        Object room = room(2);

        check(gate(link, room), "undeclared peer with allowLegacy=true is accepted (fallback)");
        check(link.linkMode() == B, "fallback switches linkMode() to B");
        check(link.officialMode(), "fallback switches officialMode() to true");
        check(!getBoolean("modeRejected", link), "fallback does not mark the gate rejected");
        String status = lastStatus();
        check(status.contains("警告"), "fallback is announced as a warning, not a silent downgrade");
        check(status.contains("allow_legacy=true"), "fallback text names the explicit switch");
    }

    /**
     * 类别 2 · 对端未声明 + 无 allowLegacy：拒绝（默认行为，禁止静默降级）。
     */
    private static void rejectsUndeclaredWithoutLegacy() throws Exception {
        GBoyCloudLink link = fresh();
        Object room = room(2);

        check(!gate(link, room), "undeclared peer without allowLegacy is rejected");
        check(getBoolean("modeRejected", link), "rejection latches modeRejected");
        check(getInt("peerLinkMode", link) == UNKNOWN,
                "an undeclared peer never gets written into peerLinkMode");
        String status = lastStatus();
        check(status.contains("对端未声明联机模式"), "rejection names the cause (peer undeclared)");
        check(status.contains("本机为"), "rejection names the local mode (local is ...)");
        check(status.contains("allow_legacy=true"), "rejection tells the user how to opt in");
        check(link.linkMode() == A, "rejection keeps the local mode it had resolved (A)");
    }

    /**
     * 类别 3 · 两端冲突 + **allowLegacy=true 也不得放行**（负向断言：
     * allowLegacy 只对「未声明」有效，绝不能把冲突救回来）。
     */
    private static void rejectsConflictEvenWithLegacy() throws Exception {
        GBoyCloudLink link = fresh();
        set("allowLegacyPeer", link, true);
        set("peerLinkMode", link, B);
        Object room = room(2); /* 本端解析为 A，与对端 B 冲突 */

        check(!gate(link, room), "conflicting modes are rejected even with allowLegacy=true");
        check(getBoolean("modeRejected", link), "conflict latches modeRejected");
        check(link.linkMode() == A, "conflict does not silently switch the local mode");
        String status = lastStatus();
        check(status.contains("本机="), "conflict text names the local mode (local=)");
        check(status.contains("对端="), "conflict text names the peer mode (peer=)");
        check(status.contains("GBOY_LINK_MODE"), "conflict text names the ADB switch (how to fix)");
    }

    /**
     * 报警器 a · 「未声明拒绝」分支**有意不幂等**（承重，禁止「统一成幂等」）。
     *
     * <p>Android 的三条失败分支幂等性不一致，而且这个不一致是**故意的**：
     * 4 号畸形分支用 {@code if (!modeRejected)} 守卫（幂等），但「未声明」与
     * 「冲突」两条是裸的 {@code modeRejected = true; fail(...)}。一旦有人把
     * {@code negotiateLinkMode()} 顶部那条 {@code if (modeRejected) return false;}
     * 误删，4 号分支会静默、这两条会**再报一次** —— 用户看到第二条文案，就是
     * 「短路没了」的现场信号。给这两条补上 {@code if (!modeRejected)} 等于把
     * 报警器关掉，所以本用例专门把它们钉成「会重复报」。</p>
     *
     * <h3>为什么不能简单地「再调一次门」</h3>
     * 直接第二次调门只会命中顶部短路（实测：第二次调用 {@code statuses} 不变），
     * 观察到的是幂等而不是非幂等；把 {@code modeRejected} 清掉再调也观测不出
     * 差别（守卫看到 false 一样会报）。要复现「短路失效」那一刻，必须让门**在
     * 顶部检查之后、分支判定之前**看到已经立起来的拒绝位 —— 下面的假 Link 正是
     * 干这个：{@code recv()} 被调用时（门已经过了顶部检查，正在有界等待里）
     * 注入 {@code modeRejected = true} 与 {@code closed = true}，等价于「另一条
     * 路径刚刚判了一次失败」。</p>
     */
    private static void undeclaredRejectionReemitsWhenLatchArrivesMidGate() throws Exception {
        GBoyCloudLink link = fresh();
        check(!getBoolean("modeRejected", link), "the gate starts with no rejection latched");
        int before = hooks.status.size();

        check(!gate(link, room(2), midGateLatch(link, null)),
                "the undeclared branch still returns false when the latch is already set");
        check(hooks.status.size() == before + 1,
                "undeclared rejection re-emits when the latch is already set "
                        + "(load-bearing alarm: do NOT add `if (!modeRejected)` here)");
        check(lastStatus().contains("对端未声明联机模式"),
                "the re-emitted line really is the undeclared-rejection text");
    }

    /**
     * 报警器 b · 「冲突拒绝」分支同上：{@code modeRejected = true; fail(...)} 不带
     * 守卫，短路失效时会再报一条。构造方式与 a 相同，只是注入时连对端模式一起
     * 置成 B —— 等价于「有界等待期间另一条路径记下了冲突」。
     */
    private static void conflictRejectionReemitsWhenLatchArrivesMidGate() throws Exception {
        GBoyCloudLink link = fresh();
        int before = hooks.status.size();

        check(!gate(link, room(2), midGateLatch(link, B)),
                "the conflict branch still returns false when the latch is already set");
        check(hooks.status.size() == before + 1,
                "conflict rejection re-emits when the latch is already set "
                        + "(load-bearing alarm: do NOT add `if (!modeRejected)` here)");
        check(lastStatus().contains("对端=")
                        && lastStatus().contains("两套帧格式不能同流"),
                "the re-emitted line really is the conflict-rejection text");
    }

    /**
     * 类别 4 · 畸形能力位：清掉 {@code modeRejected} 后直接把 {@code peerLinkMode}
     * 置为 -2，强制走到 {@code decideLinkMode} 的 4 号分支（生产路径上不可达，
     * 见类注释），断言拒绝且文案含「畸形」。allowLegacy=true 也不得救回。
     */
    private static void malformedBranchIsReachable() throws Exception {
        GBoyCloudLink link = fresh();
        set("allowLegacyPeer", link, true);
        set("peerLinkMode", link, INVALID);
        set("modeRejected", link, false);
        Object room = room(2);

        check(!gate(link, room), "malformed capability is rejected by the gate");
        check(getBoolean("modeRejected", link), "malformed latches modeRejected");
        String status = lastStatus();
        check(status.contains("能力位畸形"), "malformed text says capability is malformed");
        check(status.contains("已断开"), "malformed text says the link was closed");
        /* F9 三要素：本机模式 / 对端畸形（这里用 where，不是来源）/ 改法。
         * 断言一律用关键短语而不是整句相等 —— 文案是契约，但不该锁死措辞。 */
        check(status.contains("本机="), "malformed text names the local mode (本机=)");
        check(status.contains("两端使用相同版本"), "malformed text tells the user how to fix it");
        check(status.contains("（C0GateTest）"), "malformed text tags the gate where it ran");
        check(!status.contains("来源"),
                "the 4th-branch text carries no source tag (that is how it differs "
                        + "from notePeerLinkMode's message)");
        check(link.linkMode() == A, "malformed never switches the local mode");
    }

    /**
     * 顺序断言 a · 早退先于判定：{@code modeRejected} 已为真时，门必须在**顶部**
     * 短路 —— 不重新解析本端模式、不改写 {@code peerLinkMode}、不再多一条状态文案。
     *
     * <p>构造方式：先手工把 {@code linkMode} 置成 B（与 2 人房 AUTO 会解析出的 A
     * 故意不同），再喂一条畸形能力位（{@code notePeerLinkMode} 置 rejected + fail），
     * 最后调门。若门先做解析与判定，{@code linkMode} 会被改回 A、并多一条文案。</p>
     */
    private static void rejectedShortCircuitsBeforeJudging() throws Exception {
        GBoyCloudLink link = fresh();
        set("linkMode", link, B);
        set("peerLinkMode", link, A);
        notePeer(link, INVALID);
        check(getBoolean("modeRejected", link),
                "notePeerLinkMode(INVALID) latches modeRejected immediately");
        /* 与 PC F8 对齐：畸形必须**回写** peerLinkMode（状态反映事实）。
         * 这条断言同时是「回写被删」的守卫。 */
        check(getInt("peerLinkMode", link) == INVALID,
                "a malformed capability is written back into peerLinkMode (peer state = INVALID)");
        check(GBoyCloudLink.decideLinkMode(getInt("linkMode", link),
                        getInt("peerLinkMode", link), true) == 4,
                "the written-back INVALID decides as 4 (malformed), not 1 (legacy fallback)");
        int statusesAfterNote = hooks.status.size();
        check(statusesAfterNote == 1, "the malformed note produced exactly one status line");
        String noteText = lastStatus();
        check(noteText.contains("本机=尚未绑定（AUTO）"),
                "an early malformed note reports the local mode as not-yet-bound");
        check(noteText.contains("来源 C0GateTest"),
                "the notePeerLinkMode text carries its source tag");

        check(!gate(link, room(2)), "a rejected gate returns false");
        check(hooks.status.size() == statusesAfterNote,
                "the rejected gate short-circuits: no second status line is produced");
        check(link.linkMode() == B,
                "the rejected gate does not re-resolve linkMode (stays B, not the AUTO A)");
        check(getInt("peerLinkMode", link) == INVALID,
                "the rejected gate keeps the written-back INVALID and does not rewrite it");
        /* 幂等：再调一次仍拒绝、仍不多一条文案（对齐 PC --gatetest「只报一次」）。 */
        check(!gate(link, room(2)), "a second call after rejection still returns false");
        check(hooks.status.size() == statusesAfterNote,
                "a second call after rejection emits no duplicate fail text");
    }

    /**
     * 回写的真正价值：即使「顶部短路」被删掉（一次看起来无害的重构），门也必须
     * **干净拒绝**，不能因为 {@code peerLinkMode} 还停在 UNKNOWN 而落到「未声明」
     * 分支、在 {@code allowLegacy=true} 下返回 true 回落 B（「已判失败却返回成功」）。
     *
     * <p>构造即模拟那个重构：先喂畸形让它 fail + 回写，再手工清掉 {@code modeRejected}
     * （等价于短路不生效），然后带着 {@code allowLegacy=true} 调门。</p>
     */
    private static void malformedWriteBackSurvivesRemovedShortCircuit() throws Exception {
        GBoyCloudLink link = fresh();
        set("allowLegacyPeer", link, true);
        notePeer(link, INVALID);
        check(getInt("peerLinkMode", link) == INVALID,
                "write-back is present before the simulated refactor");
        int statusesAfterNote = hooks.status.size();

        /* 模拟「短路被删」：rejected 不再为真，门会继续往下判。 */
        set("modeRejected", link, false);
        check(!gate(link, room(2)),
                "with the short-circuit gone the gate still refuses (no allowLegacy pass-through)");
        check(link.linkMode() == A,
                "the refusal does not silently switch the local mode to B");
        check(hooks.status.size() == statusesAfterNote + 1,
                "the refusal comes from the 4th branch (exactly one new status line)");
        check(lastStatus().contains("能力位畸形"),
                "the new status line is the malformed one, not the undeclared one");
        check(getBoolean("modeRejected", link),
                "the 4th branch re-latches modeRejected");
    }

    /**
     * AUTO 映射：3/4 人房解析为 B，2 人房解析为 A（与 ADR-002 D4 一致）。
     * 顺带钉住「4 人房 + 对端声明 B」这条正常路径。
     */
    private static void autoModeFollowsPlayerCount() throws Exception {
        GBoyCloudLink four = fresh();
        set("peerLinkMode", four, B);
        check(gate(four, room(4)), "4-player room with peer B is accepted");
        check(four.linkMode() == B, "4-player AUTO resolves to B");
        check(four.officialMode(), "4-player room runs official (path B) mode");

        GBoyCloudLink one = fresh();
        set("peerLinkMode", one, A);
        check(gate(one, room(1)), "1-player room with peer A is accepted");
        check(one.linkMode() == A, "1-player AUTO resolves to A");
    }

    // ---------------------------------------------------------------- 基础设施

    /** 假的 Hooks：只记录状态文案，不碰核心/文件/UI。 */
    private static final class FakeHooks implements GBoyCloudLink.Hooks {
        final List<String> status = new ArrayList<>();

        @Override
        public String romPath() {
            return null; /* 不读文件：协商门不需要 ROM 身份 */
        }

        @Override
        public MgbaCore core() {
            /* 必须返回 null 且全程不触碰核心：MgbaCore 的静态块会
             * System.loadLibrary("mgba_jni")，纯 JVM 里没有这个库。 */
            return null;
        }

        @Override
        public int localKeys() {
            return 0;
        }

        @Override
        public void onRemoteKeys(int keys) {
        }

        @Override
        public void onStatus(String text) {
            status.add(text);
        }

        @Override
        public void onConnected(boolean asHost, String note) {
        }

        @Override
        public void onDisconnected() {
        }

        @Override
        public void onRemoteState(byte[] state) {
        }

        @Override
        public void onRemoteReset() {
        }
    }

    private static GBoyCloudLink fresh() {
        hooks = new FakeHooks();
        return new GBoyCloudLink(hooks);
    }

    private static String lastStatus() {
        return hooks.status.isEmpty() ? "" : hooks.status.get(hooks.status.size() - 1);
    }

    private static Object room(int playerCount) throws Exception {
        Object room = roomCtor.newInstance();
        roomPlayerCount.setInt(room, playerCount);
        return room;
    }

    /** 调门本体；{@code link} 传 null —— 有界等待对 null 立即返回，用例保持毫秒级。 */
    private static boolean gate(GBoyCloudLink link, Object room) throws Exception {
        return gate(link, room, null);
    }

    /** 带假 Link 调门：Link 非 null 才会走进有界等待，注入点就在那段等待里。 */
    private static boolean gate(GBoyCloudLink link, Object room, GBoyCloudLink.Link transport)
            throws Exception {
        return (Boolean) negotiate.invoke(link, room, "C0GateTest", transport);
    }

    /**
     * 造一条假 Link：门已经过了顶部短路检查、进到有界等待之后，第一次
     * {@code recv()} 才注入「拒绝位已经立起来」（等价于另一条路径刚判过一次失败，
     * 也就是顶部短路被删掉时会出现的时序）。{@code peerMode} 非 null 时连对端
     * 模式一起写，用来分别命中「未声明」与「冲突」两条分支。
     *
     * <p>注入同时置 {@code closed = true}（{@code fail()} 的真实副作用）：等待循环
     * 下一轮立刻退出，用例不会真花 2 秒等超时。</p>
     */
    private static GBoyCloudLink.Link midGateLatch(final GBoyCloudLink link,
            final Integer peerMode) {
        return new FakeLink(new Runnable() {
            @Override
            public void run() {
                try {
                    if (peerMode != null) {
                        set("peerLinkMode", link, peerMode);
                    }
                    set("modeRejected", link, true);
                    set("closed", link, true);
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }
        });
    }

    /** 假 Link：不连任何东西，只在第一次 {@code recv()} 时跑一次注入。 */
    private static final class FakeLink implements GBoyCloudLink.Link {
        private final Runnable once;
        private boolean fired;

        FakeLink(Runnable once) {
            this.once = once;
        }

        @Override
        public void send(byte[] frame) {
        }

        @Override
        public byte[] recv(long timeoutMs) {
            if (!fired) {
                fired = true;
                once.run();
            }
            return null;
        }

        @Override
        public boolean isClosed() {
            return false;
        }

        @Override
        public void close() {
        }
    }

    private static void notePeer(GBoyCloudLink link, int mode) throws Exception {
        notePeerMethod.invoke(link, mode, "C0GateTest");
    }

    private static Field field(String name) {
        return FIELDS.get(name);
    }

    private static void set(String name, Object target, Object value) throws Exception {
        field(name).set(target, value);
    }

    private static int getInt(String name, Object target) throws Exception {
        return field(name).getInt(target);
    }

    private static boolean getBoolean(String name, Object target) throws Exception {
        return field(name).getBoolean(target);
    }

    private static void check(boolean ok, String message) {
        if (ok) {
            ++passed;
            return;
        }
        ++failed;
        System.out.println("FAIL: " + message);
    }
}
