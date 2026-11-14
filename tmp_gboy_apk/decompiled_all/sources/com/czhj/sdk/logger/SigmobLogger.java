package com.czhj.sdk.logger;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import J3FDQU.A2egSU;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SigmobLogger {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10616a = "SigmobLogger";
    private static final boolean b = true;
    private static boolean c = false;
    private static final int d = 1;
    private static final int e = 1;
    private static final int f = 4;
    private static final Set<String> g = new HashSet();

    static {
        mEXyo();
    }

    private static int a(StackTraceElement[] stackTraceElementArr) {
        for (int i = 1; i < stackTraceElementArr.length; i++) {
            if (!stackTraceElementArr[i].getClassName().split("\\$")[0].equals(SigmobLogger.class.getName())) {
                return i;
            }
        }
        return -1;
    }

    public static void addCloseClass(Class<?> cls) {
        g.add(cls.getSimpleName());
    }

    private static String b() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int a2 = a(stackTrace);
        int i = a2 + 4;
        int i2 = a2 + 5;
        if (i >= stackTrace.length) {
            i = stackTrace.length - 1;
        }
        if (i2 > stackTrace.length) {
            i2 = stackTrace.length;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            String a3 = a(stackTrace[i3]);
            sb.append((CharSequence) sb2);
            sb.append(a3);
            sb.append('\n');
            sb2.append("  ");
        }
        return sb.toString();
    }

    public static void d(String str, String str2, Object... objArr) {
        if (!c || g.contains(str)) {
            return;
        }
        b(str);
        a(format(str2, objArr));
    }

    public static void dL(String str, String str2, Object... objArr) {
        if (!c) {
            g.contains(str);
            return;
        }
        String format = format(str2, objArr);
        if (format.length() < 3000) {
            b(str);
            return;
        }
        synchronized (SigmobLogger.class) {
            int length = format.length();
            int i = 0;
            int i2 = 0;
            do {
                i += 3000;
                if (i >= length) {
                    i = length - 1;
                }
                b(str);
                format.substring(i2, i);
                i2 = i + 1;
            } while (i != length - 1);
        }
    }

    public static void debug(boolean z) {
        c = z;
    }

    public static void e(String str, String str2, Object... objArr) {
        if (!c || g.contains(str)) {
            return;
        }
        b(str);
        a(format(str2, objArr));
    }

    public static String format(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        if (!c || g.contains(str)) {
            return;
        }
        b(str);
        a(format(str2, objArr));
    }

    private static /* synthetic */ void mEXyo() {
        char[] charArray = "¡\u00ad¯ì¥£¯§ì \u00ad»ì±ª§®®ì\u0088¬«\u0080°«¦¥§".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 194);
        }
        String str = new String(charArray);
        char[] charArray2 = "¡®«¬«¶".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 194);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void w(String str, String str2, Object... objArr) {
        if (!c || g.contains(str)) {
            return;
        }
        b(str);
        a(format(str2, objArr));
    }

    private static String a() {
        return Thread.currentThread().getName();
    }

    private static String b(String str) {
        return CtFAbx.BChYOn("SigmobLogger#", str);
    }

    public static void d(String str, Throwable th, String str2, Object... objArr) {
        if (!c || g.contains(str)) {
            return;
        }
        b(str);
        a(format(str2, objArr));
    }

    public static void e(String str, Throwable th, String str2, Object... objArr) {
        if (!c || g.contains(str)) {
            return;
        }
        b(str);
        a(format(str2, objArr));
    }

    public static void i(String str, Throwable th, String str2, Object... objArr) {
        if (!c || g.contains(str)) {
            return;
        }
        b(str);
        a(format(str2, objArr));
    }

    public static void w(String str, Throwable th) {
        if (!c || g.contains(str)) {
            return;
        }
        b(str);
    }

    private static String a(StackTraceElement stackTraceElement) {
        return "(" + stackTraceElement.getFileName() + ':' + stackTraceElement.getLineNumber() + ')';
    }

    public static void w(String str, Throwable th, String str2, Object... objArr) {
        if (!c || g.contains(str)) {
            return;
        }
        b(str);
        a(format(str2, objArr));
    }

    private static String a(String str) {
        return A2egSU.B3GDIM(AYUAbz.A5SV6n(str, " ["), a(), "] ", b());
    }
}
