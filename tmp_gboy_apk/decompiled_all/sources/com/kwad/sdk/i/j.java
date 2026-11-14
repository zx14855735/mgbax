package com.kwad.sdk.i;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.os.Handler;
import android.os.Looper;
import java.io.Closeable;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class j {
    private static final AtomicInteger aXZ = new AtomicInteger(1);
    private static final ExecutorService aYa = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.i.j.1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(Thread.currentThread().getThreadGroup(), runnable, "ksad-lm-thread-" + j.aXZ.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            return thread;
        }
    });
    private static final Handler aWC = new Handler(Looper.getMainLooper());

    static {
        zunbzmn();
    }

    private static String Bn() {
        return "";
    }

    public static boolean L(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static void Pc() {
    }

    public static void Pd() {
    }

    public static void a(n nVar) {
        aYa.execute(nVar);
    }

    public static void al(String str, String str2) {
        gC(str);
        el(str2);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static String el(String str) {
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str, " ");
        A5SV6n2.append(Bn());
        return A5SV6n2.toString();
    }

    private static String gC(String str) {
        return CtFAbx.BChYOn("KSAd_LM_", str);
    }

    public static double o(double d) {
        return new BigDecimal(Double.toString(1.0d)).divide(new BigDecimal(Double.toString(d)), 0, RoundingMode.HALF_UP).doubleValue();
    }

    private static /* synthetic */ void zunbzmn() {
        char[] charArray = "ÌÀÂ\u0081ÈÎÂÊ\u0081ÍÀÖ\u0081ÜÇÊÃÃ\u0081åÁÆíÝÆËÈÊ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 175);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÌÃÆÁÆÛ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 175);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void closeQuietly(URLConnection uRLConnection) {
        try {
            if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).disconnect();
            }
        } catch (Throwable unused) {
        }
    }
}
