/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import java.util.Arrays;

/**
 * C0 能力协商（ADR-002）的纯 JVM 自检：没有 JUnit，直接
 * {@code java io.mgba.android.C0LinkModeTest}（由 :app:runLinkSelfTests 拉起）。
 *
 * <p>覆盖三件事，全部是「能跑起来才算数」的断言，不是代码对照：</p>
 * <ol>
 *   <li>{@link GBoyFrames#linkModeOf} 六类输入（0x40 / 0x41 / 0x00 / 0x42 /
 *       0xFF / 2 参数注册帧 / 裸 20 字节 SIO 包）；</li>
 *   <li>{@link GBoyFrames#registerFrame} 逐字节布局：2 参数与官方一致、3 参数
 *       只在多人房写能力位、单人房与 2 参数完全相同；</li>
 *   <li>{@link GBoyCloudLink#decideLinkMode} 五个决策码 0/1/2/3/4 全覆盖，
 *       含 allowLegacy 的两个分支（且不得放行冲突 / 畸形）。</li>
 * </ol>
 *
 * <p>风格与 {@code GBoyLinkSessionTest} 一致（{@code check()} 逐条判定），差别
 * 只在末尾：这里自己数通过 / 失败项，打印 {@code x/y PASS}，有失败则
 * {@code System.exit(1)}，让 Gradle 拿到真实退出码。</p>
 *
 * <p>断言文案一律英文：Gradle 的任务输出走 GBK 控制台，中文会变乱码，
 * 失败信息就白写了（注释不受影响）。</p>
 */
public final class C0LinkModeTest {

    private static int passed;
    private static int failed;

    public static void main(String[] args) {
        linkModeOfSixInputs();
        singlePlayerRegisterFrameCarriesNoCapability();
        registerFrameLayout();
        decideLinkModeFiveCodes();

        int total = passed + failed;
        if (failed == 0) {
            System.out.println(total + "/" + total + " PASS");
            return;
        }
        System.out.println(passed + "/" + total + " PASS, " + failed + " FAIL");
        System.exit(1);
    }

    /**
     * {@code linkModeOf()} 六类输入。能力位编码在官方 16 字节 type-1 注册帧的
     * 最后一个保留字节（wire[15] == 12 字节 body 的 body[11]）。
     */
    private static void linkModeOfSixInputs() {
        /* 常量本身锁死：三端（PC / Android / iOS）共用 0 / 1 / -1 / -2。 */
        check(GBoyFrames.LINK_MODE_A == 0 && GBoyFrames.LINK_MODE_B == 1
                        && GBoyFrames.LINK_MODE_UNKNOWN == -1
                        && GBoyFrames.LINK_MODE_INVALID == -2,
                "mode constants stay A=0 / B=1 / UNKNOWN=-1 / INVALID=-2 (three clients)");
        check(GBoyFrames.LINK_CAP_MAGIC == 0x40 && GBoyFrames.LINK_CAP_MODE_BIT == 0x01,
                "capability bits stay bit6=declared / bit0=mode");

        /* ① 3 参数注册帧 0x40 → A。 */
        byte[] modeA = GBoyFrames.registerFrame(2, 0, GBoyFrames.LINK_MODE_A);
        check(modeA.length == 16 && (modeA[15] & 0xff) == 0x40,
                "3-arg registerFrame writes 0x40 into wire[15]");
        check(GBoyFrames.linkModeOf(bodyOf(modeA)) == GBoyFrames.LINK_MODE_A,
                "wire[15] = 0x40 -> A(0)");

        /* ② 0x41 → B。 */
        byte[] modeB = GBoyFrames.registerFrame(2, 0, GBoyFrames.LINK_MODE_B);
        check((modeB[15] & 0xff) == 0x41,
                "3-arg registerFrame writes 0x41 into wire[15] for mode B");
        check(GBoyFrames.linkModeOf(bodyOf(modeB)) == GBoyFrames.LINK_MODE_B,
                "wire[15] = 0x41 -> B(1)");

        /* ③ 2 参数注册帧 = 官方字节，能力位 0 → UNKNOWN（旧客户端 / 官方 APK）。 */
        byte[] legacy = GBoyFrames.registerFrame(2, 0);
        check((legacy[15] & 0xff) == 0x00,
                "2-arg registerFrame keeps wire[15] = 0 (official layout)");
        check(GBoyFrames.linkModeOf(bodyOf(legacy)) == GBoyFrames.LINK_MODE_UNKNOWN,
                "2-arg register frame (official 16 bytes, cap 0) -> UNKNOWN(-1)");

        /* ④ 0x42：magic 在，但 bit1 是保留位 → INVALID（禁止猜测）。 */
        byte[] reserved = GBoyFrames.registerFrame(2, 0, GBoyFrames.LINK_MODE_A);
        reserved[15] = 0x42;
        check(GBoyFrames.linkModeOf(bodyOf(reserved)) == GBoyFrames.LINK_MODE_INVALID,
                "reserved bit set (0x42) -> INVALID(-2)");

        /* ⑤ 0xFF：magic 在、保留位全 1 → INVALID。 */
        byte[] allOnes = GBoyFrames.registerFrame(2, 0, GBoyFrames.LINK_MODE_A);
        allOnes[15] = (byte) 0xFF;
        check(GBoyFrames.linkModeOf(bodyOf(allOnes)) == GBoyFrames.LINK_MODE_INVALID,
                "0xFF -> INVALID(-2)");

        /* ⑥ 裸 20 字节 SIO 包（路径 A 的 netLink struct Packet）绝不是注册帧：
         *   4B 魔数 + 2B type + 2B seq + 2B mode + 2B player + 4B value + 4B cycles。
         *   这里刻意把 player 凑成 0x0240，于是包的第 11 字节正好是 0x40 —— 若判据
         *   只看 body[11] 就会误读成 A；正确结果必须仍是 UNKNOWN。 */
        byte[] raw = rawSioPacket();
        check(raw.length == 20, "netLink struct Packet stays 20 bytes");
        check((raw[11] & 0xff) == 0x40,
                "crafted packet carries 0x40 at byte 11 (adversarial fixture)");
        check(GBoyFrames.typeOf(raw) != GBoyFrames.TYPE_REGISTER,
                "raw SIO packet type field is not 1 (0x4D42 = high half of the magic)");
        check(GBoyFrames.linkModeOf(raw) == GBoyFrames.LINK_MODE_UNKNOWN,
                "a bare 20-byte SIO packet is never read as a register frame -> UNKNOWN(-1)");

        /* 短 body / null 同样不能崩，一律 UNKNOWN。 */
        check(GBoyFrames.linkModeOf(null) == GBoyFrames.LINK_MODE_UNKNOWN,
                "null body -> UNKNOWN");
        check(GBoyFrames.linkModeOf(new byte[]{0, 1}) == GBoyFrames.LINK_MODE_UNKNOWN,
                "2-byte body (type only) -> UNKNOWN");
        check(GBoyFrames.linkModeOf(new byte[]{0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0})
                        == GBoyFrames.LINK_MODE_UNKNOWN,
                "11-byte body (one byte short of the capability) -> UNKNOWN");
    }

    /**
     * F12：单人房注册帧不承载能力位。尾部 6 字节是 {@code short 0 + int32
     * baseStateCount}，所以 body[11] 是 baseStateCount 的**最低字节**，读侧必须
     * 与写侧（只在 {@code playerCount != 1} 时写能力位）镜像同一条规则。
     *
     * <p>这是 PC/Android 两端同构的真缺陷（PC 侧 {@code test-gboylink --c0} 首跑
     * 抓到，PC 已修）：1 人房 + baseStateCount=1 时 body[11] == 0x01，magic 0x40
     * 不匹配 → 旧实现返回 INVALID → 对端按「对端能力位畸形」直接 fail 断开。
     * baseStateCount=0 时看不出来，因此是隐性坑。</p>
     */
    private static void singlePlayerRegisterFrameCarriesNoCapability() {
        /* ① baseStateCount == 1：body[11] == 0x01，必须是 UNKNOWN，绝不能是 INVALID。 */
        byte[] soloOne = GBoyFrames.registerFrame(1, 1);
        check((soloOne[15] & 0xff) == 0x01,
                "single-player baseStateCount=1 puts 0x01 into wire[15]");
        int decodedOne = GBoyFrames.linkModeOf(bodyOf(soloOne));
        check(decodedOne != GBoyFrames.LINK_MODE_INVALID,
                "single-player baseStateCount=1 is never read as malformed (INVALID)");
        check(decodedOne == GBoyFrames.LINK_MODE_UNKNOWN,
                "single-player baseStateCount=1 -> UNKNOWN(-1)");

        /* ② baseStateCount == 0：同样是 UNKNOWN（旧实现侥幸也是 UNKNOWN）。 */
        byte[] soloZero = GBoyFrames.registerFrame(1, 0);
        check((soloZero[15] & 0xff) == 0x00,
                "single-player baseStateCount=0 leaves wire[15] = 0");
        check(GBoyFrames.linkModeOf(bodyOf(soloZero)) == GBoyFrames.LINK_MODE_UNKNOWN,
                "single-player baseStateCount=0 -> UNKNOWN(-1)");

        /* ③ 其它非 0 值：0x40 也不能被当成「已声明 A」（尾巴是计数不是能力位）。 */
        check(GBoyFrames.linkModeOf(bodyOf(GBoyFrames.registerFrame(1, 0x40)))
                        == GBoyFrames.LINK_MODE_UNKNOWN,
                "single-player baseStateCount=0x40 is still UNKNOWN, not mode A");
        check(GBoyFrames.linkModeOf(bodyOf(GBoyFrames.registerFrame(1, 0x41)))
                        == GBoyFrames.LINK_MODE_UNKNOWN,
                "single-player baseStateCount=0x41 is still UNKNOWN, not mode B");

        /* ④ 写侧核对：playerCount == 1 时 3 参数与 2 参数逐字节相同。 */
        byte[] soloLegacy = GBoyFrames.registerFrame(1, 3);
        byte[] soloWithB = GBoyFrames.registerFrame(1, 3, GBoyFrames.LINK_MODE_B);
        check(Arrays.equals(soloWithB, soloLegacy),
                "registerFrame(1, 3, B) is byte-identical to registerFrame(1, 3)");
        check((soloWithB[15] & 0xff) == 0x03,
                "wire[15] of a single-player frame is baseStateCount, never a capability bit");
        check(GBoyFrames.getInt(soloWithB, 12) == 3,
                "single-player wire[12..15] still carries baseStateCount = 3");

        /* ⑤ 新判据不得破坏正常路径：3 人房带 0x40 / 0x41 仍分别是 A / B。 */
        byte[] threeA = GBoyFrames.registerFrame(3, 0, GBoyFrames.LINK_MODE_A);
        byte[] threeB = GBoyFrames.registerFrame(3, 0, GBoyFrames.LINK_MODE_B);
        check((threeA[15] & 0xff) == 0x40 && (threeB[15] & 0xff) == 0x41,
                "3-player frames still carry 0x40 / 0x41 at wire[15]");
        check(GBoyFrames.linkModeOf(bodyOf(threeA)) == GBoyFrames.LINK_MODE_A,
                "3-player frame with 0x40 -> A(0)");
        check(GBoyFrames.linkModeOf(bodyOf(threeB)) == GBoyFrames.LINK_MODE_B,
                "3-player frame with 0x41 -> B(1)");

        /* ⑥ 多人房忽略 baseStateCount：非 0 的 baseStateCount 不影响能力位。 */
        check(GBoyFrames.linkModeOf(bodyOf(GBoyFrames.registerFrame(4, 5,
                        GBoyFrames.LINK_MODE_B))) == GBoyFrames.LINK_MODE_B,
                "multi-player frames ignore baseStateCount and keep their mode");
        check(Arrays.equals(GBoyFrames.registerFrame(2, 9, GBoyFrames.LINK_MODE_A),
                        GBoyFrames.registerFrame(2, 0, GBoyFrames.LINK_MODE_A)),
                "multi-player registerFrame ignores baseStateCount byte for byte");
    }

    /**
     * {@code registerFrame()} 逐字节布局。官方（GBoy 26.10.18）是
     * {@code u32 length=12 + u16 type=1 + i32 playerCount + short 0 + i32}，
     * 固定 16 字节；多人房尾部 6 字节官方恒为 0，我们的能力位只借最后一个。
     */
    private static void registerFrameLayout() {
        /* ① 2 参数、多人房：与官方逐字节一致（尾部全 0）。 */
        byte[] official = GBoyFrames.registerFrame(2, 0);
        byte[] expectedOfficial = {
                0, 0, 0, 12,          /* u32 length = 2 (type) + 10 (payload) */
                0, 1,                 /* u16 type = 1 (TYPE_REGISTER) */
                0, 0, 0, 2,           /* i32 playerCount = 2 */
                0, 0,                 /* short 0 */
                0, 0, 0, 0,           /* i32 尾部保留，官方恒 0 */
        };
        check(Arrays.equals(official, expectedOfficial),
                "2-arg register frame is byte-identical to the official 16-byte one");

        byte[] four = GBoyFrames.registerFrame(4, 0);
        check(GBoyFrames.getInt(four, 0) == 12 && GBoyFrames.getShort(four, 4) == 1
                        && GBoyFrames.getInt(four, 6) == 4,
                "4-player register frame keeps length / type / playerCount fields");

        /* ② 3 参数、多人房：只有 wire[15] 变。 */
        byte[] withA = GBoyFrames.registerFrame(2, 0, GBoyFrames.LINK_MODE_A);
        byte[] withB = GBoyFrames.registerFrame(2, 0, GBoyFrames.LINK_MODE_B);
        check(sameExceptLastByte(official, withA),
                "3-arg mode A differs from the official frame only at wire[15]");
        check(sameExceptLastByte(official, withB),
                "3-arg mode B differs from the official frame only at wire[15]");
        check((withA[15] & 0xff) == 0x40 && (withB[15] & 0xff) == 0x41,
                "mode A writes 0x40 and mode B writes 0x41");

        /* ③ 3 参数、UNKNOWN：与 2 参数完全相同（不写能力位）。 */
        check(Arrays.equals(GBoyFrames.registerFrame(2, 0, GBoyFrames.LINK_MODE_UNKNOWN),
                        official),
                "linkMode UNKNOWN keeps the 3-arg output identical to the 2-arg one");
        check(Arrays.equals(GBoyFrames.registerFrame(2, 0, GBoyFrames.LINK_MODE_INVALID),
                        official),
                "linkMode INVALID never writes a capability bit either");

        /* ④ 单人房：尾部是 baseStateCount，根本不写能力位 —— 3 参数与 2 参数
         *    必须逐字节完全相同（官方单人房就是这么发的）。 */
        byte[] solo2 = GBoyFrames.registerFrame(1, 7);
        byte[] solo3 = GBoyFrames.registerFrame(1, 7, GBoyFrames.LINK_MODE_B);
        check(Arrays.equals(solo3, solo2),
                "playerCount == 1 makes the 3-arg output identical to the 2-arg one");
        check(GBoyFrames.getInt(solo2, 6) == 1 && GBoyFrames.getInt(solo2, 12) == 7,
                "single-player room carries baseStateCount in wire[12..15]");
        check(GBoyFrames.getShort(solo2, 10) == 0,
                "single-player room keeps wire[10..11] = 0");
    }

    /**
     * {@code decideLinkMode} 五个决策码。判定顺序必须与 PC 一致：一致 → 畸形 →
     * 未声明（唯一允许回落的分支）→ 冲突。
     */
    private static void decideLinkModeFiveCodes() {
        final int A = GBoyFrames.LINK_MODE_A;
        final int B = GBoyFrames.LINK_MODE_B;
        final int UNKNOWN = GBoyFrames.LINK_MODE_UNKNOWN;
        final int INVALID = GBoyFrames.LINK_MODE_INVALID;

        /* 0 = 两端一致，按本端接受（allowLegacy 无关）。 */
        check(GBoyCloudLink.decideLinkMode(A, A, false) == 0,
                "A + A -> 0 (accepted)");
        check(GBoyCloudLink.decideLinkMode(B, B, false) == 0,
                "B + B -> 0 (accepted)");
        check(GBoyCloudLink.decideLinkMode(A, A, true) == 0,
                "allowLegacy never changes the matching branch");

        /* 1 = 对端未声明且 allowLegacy → 回落 B。 */
        check(GBoyCloudLink.decideLinkMode(A, UNKNOWN, true) == 1,
                "A + undeclared + allowLegacy -> 1 (fall back to B)");
        check(GBoyCloudLink.decideLinkMode(B, UNKNOWN, true) == 1,
                "B + undeclared + allowLegacy -> 1 (fall back to B)");

        /* 2 = 对端未声明且不允许回落 → 拒绝（默认行为，禁止静默降级）。 */
        check(GBoyCloudLink.decideLinkMode(A, UNKNOWN, false) == 2,
                "A + undeclared without allowLegacy -> 2 (rejected)");
        check(GBoyCloudLink.decideLinkMode(B, UNKNOWN, false) == 2,
                "B + undeclared without allowLegacy -> 2 (rejected)");

        /* 3 = 两端模式冲突 → 拒绝；allowLegacy 不得把它放行。 */
        check(GBoyCloudLink.decideLinkMode(A, B, false) == 3,
                "A + B -> 3 (conflict rejected)");
        check(GBoyCloudLink.decideLinkMode(B, A, false) == 3,
                "B + A -> 3 (conflict rejected)");
        check(GBoyCloudLink.decideLinkMode(A, B, true) == 3,
                "allowLegacy never clears a conflict: A + B + allowLegacy -> 3");
        check(GBoyCloudLink.decideLinkMode(B, A, true) == 3,
                "allowLegacy never clears a conflict: B + A + allowLegacy -> 3");

        /* 4 = 对端能力位畸形 → 拒绝；allowLegacy 也不得把它当成「未声明」。 */
        check(GBoyCloudLink.decideLinkMode(A, INVALID, false) == 4,
                "A + malformed -> 4 (rejected)");
        check(GBoyCloudLink.decideLinkMode(B, INVALID, false) == 4,
                "B + malformed -> 4 (rejected)");
        check(GBoyCloudLink.decideLinkMode(A, INVALID, true) == 4,
                "allowLegacy never treats malformed as undeclared: A + malformed -> 4");

        /* 返回码必须恰好是 0..4，且五类都出现过。 */
        int[] codes = {
                GBoyCloudLink.decideLinkMode(A, A, false),
                GBoyCloudLink.decideLinkMode(A, UNKNOWN, true),
                GBoyCloudLink.decideLinkMode(A, UNKNOWN, false),
                GBoyCloudLink.decideLinkMode(A, B, false),
                GBoyCloudLink.decideLinkMode(A, INVALID, false),
        };
        boolean inRange = true;
        boolean[] seen = new boolean[5];
        for (int code : codes) {
            if (code < 0 || code > 4) {
                inRange = false;
                continue;
            }
            seen[code] = true;
        }
        check(inRange, "every decision code stays inside 0..4");
        check(seen[0] && seen[1] && seen[2] && seen[3] && seen[4],
                "all five decision codes 0/1/2/3/4 show up at least once");
    }

    /** 路径 A 的裸 SIO 包：netLink 的 {@code struct Packet}（20 字节）。 */
    private static byte[] rawSioPacket() {
        byte[] packet = new byte[20];
        GBoyFrames.putInt(packet, 0, 0x314C424D); /* "MBL1" 小端魔数 */
        GBoyFrames.putShort(packet, 4, 0x4D42);   /* type：绝不是 1 */
        GBoyFrames.putShort(packet, 6, 1);        /* seq */
        GBoyFrames.putShort(packet, 8, 0x0300);   /* mode */
        GBoyFrames.putShort(packet, 10, 0x0240);  /* player：让第 11 字节 = 0x40 */
        GBoyFrames.putInt(packet, 12, 0x12345678); /* value */
        GBoyFrames.putInt(packet, 16, 0x9ABCDEF0); /* cycles */
        return packet;
    }

    /** wire 字节 → 帧体（去掉 4 字节长度头），与 GBoyFrames 的 body 定义一致。 */
    private static byte[] bodyOf(byte[] wire) {
        return Arrays.copyOfRange(wire, 4, wire.length);
    }

    private static boolean sameExceptLastByte(byte[] a, byte[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length - 1; ++i) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
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
