/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package android.util;

/**
 * {@code android.util.Log} 的**手写桩**，只服务于 {@code :app:runLinkSelfTests}
 * 这条纯 JVM 自检通道（{@code src/test/java} 下没有 JUnit，直接跑 main()）。
 *
 * <h3>1 · 为什么需要它</h3>
 * 自检的运行时 classpath 只有 {@code build/intermediates/javac/debug/.../classes}
 * 加自检类自己的输出目录，**没有 android.jar**。而协商门（{@code GBoyCloudLink}
 * 的 {@code status()} / {@code fail()}，以及 {@code GbCloud.trace()}）会走
 * {@code Log.d/Log.i}；一旦被断言驱动到那条路径，纯 JVM 会抛
 * {@code NoClassDefFoundError: android/util/Log}，门本体就再也测不到。
 * 顺带它也让 {@code GBoySocketLinkTest} 后台重连线程那串
 * {@code NoClassDefFoundError} 噪声消失（同一根因）。
 *
 * <h3>2 · 它不是 android.jar 的替代品</h3>
 * 真正的 {@code android.jar}（platform SDK 里的那个）方法体是
 * {@code throw new RuntimeException("Stub!")}，加进自检 classpath 只会把
 * {@code NoClassDefFoundError} 换成 {@code RuntimeException("Stub!")}，问题更糟。
 * 这里是**有真实行为的空实现**：不打印（不污染断言输出）、不抛异常、返回值固定
 * （调用方都没用返回值，见下方各方法）。
 *
 * <h3>3 · 只在测试运行时使用，绝不进 APK</h3>
 * 它位于 {@code src/test/java}，不参与 {@code :app:compileDebugJavaWithJavac}，
 * 因此不可能被打进 application；主源码编译时 {@code android.util.Log} 仍来自
 * 平台 android.jar。
 *
 * <p><b>约束</b>：一旦有人给自检 classpath 加上真的 android.jar（例如新增
 * {@code testImplementation files(android.jar)}），本文件就会与它构成**重复类**
 * 并以「先到先得」的随机顺序生效（→ 又变回 {@code Stub!} 异常）。要加 android.jar
 * 就必须先删掉本文件，二者不可共存。</p>
 */
public final class Log {

    /** 与 Android 一致的日志级别常量（有调用方按级别做判断时不必再改）。 */
    public static final int VERBOSE = 2;
    public static final int DEBUG = 3;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final int ERROR = 6;
    public static final int ASSERT = 7;

    private Log() {
    }

    /* 全部返回 0：Android 的返回值是「写入的字节数」，本仓库没有任何调用方
     * 读它（已 grep `Log.` 全量确认），固定 0 不会改变行为。 */

    public static int v(String tag, String msg) {
        return 0;
    }

    public static int v(String tag, String msg, Throwable tr) {
        return 0;
    }

    public static int d(String tag, String msg) {
        return 0;
    }

    public static int d(String tag, String msg, Throwable tr) {
        return 0;
    }

    public static int i(String tag, String msg) {
        return 0;
    }

    public static int i(String tag, String msg, Throwable tr) {
        return 0;
    }

    public static int w(String tag, String msg) {
        return 0;
    }

    public static int w(String tag, String msg, Throwable tr) {
        return 0;
    }

    public static int w(String tag, Throwable tr) {
        return 0;
    }

    public static int e(String tag, String msg) {
        return 0;
    }

    public static int e(String tag, String msg, Throwable tr) {
        return 0;
    }

    /** 自检里没有用到，保留以便与平台 API 形态一致（永远判定为可记录）。 */
    public static boolean isLoggable(String tag, int level) {
        return true;
    }

    /** 同上：给将来可能出现的 {@code Log.w(tag, e)} 变体留出可编译的实现。 */
    public static String getStackTraceString(Throwable tr) {
        return tr == null ? "" : String.valueOf(tr);
    }
}
