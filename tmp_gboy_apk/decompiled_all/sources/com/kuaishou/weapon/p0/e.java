package com.kuaishou.weapon.p0;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.UnknownHostException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final int f12280a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = -1;
    public static int f = -1;
    static ThreadLocal<StringBuilder> g = new ThreadLocal<>();
    private static int h;

    static {
        umNZB();
    }

    private static void a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length < 3) {
            return;
        }
        String fileName = stackTrace[2].getFileName();
        int lineNumber = stackTrace[2].getLineNumber();
        String methodName = stackTrace[2].getMethodName();
        if (fileName.length() > 5) {
            fileName = CtFAbx.AMqCpz(5, 0, fileName);
        }
        StringBuilder sb = g.get();
        if (sb == null) {
            sb = new StringBuilder();
            g.set(sb);
        }
        synchronized (sb) {
            sb.setLength(0);
            sb.append("[");
            sb.append(h);
            sb.append("][");
            sb.append(fileName);
            sb.append(':');
            sb.append(lineNumber);
            sb.append('.');
            sb.append(methodName);
            sb.append("] ");
            sb.append(str);
            h++;
        }
    }

    public static void b(String str) {
        int i = f;
        if (i == -1 || i == 0 || i == 1) {
            a(1, str);
        }
    }

    public static void c(String str) {
        int i = f;
        if (i == -1 || i == 0 || i == 1 || i == 2) {
            a(2, str);
        }
    }

    public static void d(String str) {
    }

    private static /* synthetic */ void umNZB() {
        char[] charArray = "YUW\u0014][W_\u0014XUC\u0014IR_VV\u0014pTSxHS^]_".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ':');
        }
        String str = new String(charArray);
        char[] charArray2 = "YVSTSN".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ':');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void b(String str, Throwable th) {
        int i = f;
        if (i == -1 || i == 0 || i == 1) {
            StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str, "\n");
            A5SV6n2.append(a(th));
            a(1, A5SV6n2.toString());
        }
    }

    public static void c(String str, Throwable th) {
        int i = f;
        if (i == -1 || i == 0 || i == 1 || i == 2) {
            StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str, "\n");
            A5SV6n2.append(a(th));
            a(2, A5SV6n2.toString());
        }
    }

    public static void a(String str) {
        int i = f;
        if (i == -1 || i == 0) {
            a(0, str);
        }
    }

    public static void a(String str, Throwable th) {
        int i = f;
        if (i == -1 || i == 0) {
            StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str, "\n");
            A5SV6n2.append(a(th));
            a(0, A5SV6n2.toString());
        }
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
