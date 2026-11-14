package com.czhj.volley;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import J3FDQU.A2egSU;
import android.os.SystemClock;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class VolleyLog {
    public static boolean DEBUG = false;
    public static String TAG = "Sigmob-Volley";

    /* renamed from: a, reason: collision with root package name */
    private static final String f10634a = "com.czhj.volley.VolleyLog";

    public static class MarkerLog {
        public static final boolean ENABLED = VolleyLog.DEBUG;

        /* renamed from: a, reason: collision with root package name */
        private static final long f10635a = 0;
        private final List<Marker> b = new ArrayList();
        private boolean c = false;

        public static class Marker {
            public final String name;
            public final long thread;
            public final long time;

            public Marker(String str, long j, long j2) {
                this.name = str;
                this.thread = j;
                this.time = j2;
            }
        }

        static {
            voDmmv();
        }

        private long a() {
            if (this.b.size() == 0) {
                return 0L;
            }
            return ((Marker) A2egSU.AlLFFp(this.b, 1)).time - this.b.get(0).time;
        }

        private static /* synthetic */ void voDmmv() {
            char[] charArray = "\b\u0004\u0006E\f\n\u0006\u000eE\t\u0004\u0012E\u0018\u0003\u000e\u0007\u0007E!\u0005\u0002)\u0019\u0002\u000f\f\u000e".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'k');
            }
            String str = new String(charArray);
            char[] charArray2 = "\b\u0007\u0002\u0005\u0002\u001f".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'k');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public synchronized void add(String str, long j) {
            if (this.c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.b.add(new Marker(str, j, SystemClock.elapsedRealtime()));
        }

        public void finalize() {
            if (this.c) {
                return;
            }
            finish("Request on the loose");
            VolleyLog.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public synchronized void finish(String str) {
            this.c = true;
            long a2 = a();
            if (a2 <= 0) {
                return;
            }
            long j = this.b.get(0).time;
            VolleyLog.d("(%-4d ms) %s", Long.valueOf(a2), str);
            for (Marker marker : this.b) {
                long j2 = marker.time;
                VolleyLog.d("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(marker.thread), marker.name);
                j = j2;
            }
        }
    }

    private static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null && objArr.length != 0) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i].getClassName().equals(f10634a)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                StringBuilder A5SV6n2 = AYUAbz.A5SV6n(substring.substring(substring.lastIndexOf(36) + 1), ".");
                A5SV6n2.append(stackTrace[i].getMethodName());
                str2 = A5SV6n2.toString();
                break;
            }
            i++;
        }
        Locale locale = Locale.US;
        long id = Thread.currentThread().getId();
        StringBuilder sb = new StringBuilder("[");
        sb.append(id);
        sb.append("] ");
        sb.append(str2);
        return CtFAbx.B25kr6(sb, ": ", str);
    }

    public static void d(String str, Object... objArr) {
        if (DEBUG) {
            a(str, objArr);
        }
    }

    public static void e(String str, Object... objArr) {
        a(str, objArr);
    }

    public static void setTag(String str) {
        d("Changing log tag to %s", str);
        TAG = str;
    }

    public static void v(String str, Object... objArr) {
        if (DEBUG) {
            a(str, objArr);
        }
    }

    public static void wtf(String str, Object... objArr) {
        Log.wtf(TAG, a(str, objArr));
    }

    public static void e(Throwable th, String str, Object... objArr) {
        a(str, objArr);
    }

    public static void wtf(Throwable th, String str, Object... objArr) {
        Log.wtf(TAG, a(str, objArr), th);
    }
}
