package com.bytedance.adsdk.lottie;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.os.Trace;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.io.File;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    private static int c = 0;
    private static com.bytedance.adsdk.lottie.w.y d = null;
    private static int f = 0;
    private static boolean hf = false;
    private static String[] kd = null;
    private static volatile com.bytedance.adsdk.lottie.w.f p = null;

    /* renamed from: pl, reason: collision with root package name */
    private static volatile com.bytedance.adsdk.lottie.w.c f10042pl = null;
    private static com.bytedance.adsdk.lottie.w.kd tf = null;
    private static boolean u = true;
    private static boolean w = true;
    public static boolean xj;
    private static long[] y;

    public static float hf(String str) {
        int i = f;
        if (i > 0) {
            f = i - 1;
            return 0.0f;
        }
        if (!hf) {
            return 0.0f;
        }
        int i2 = c - 1;
        c = i2;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (!str.equals(kd[i2])) {
            throw new IllegalStateException(CtFAbx.B25kr6(CtFAbx.B3GDIM("Unbalanced trace call ", str, ". Expected "), kd[c], "."));
        }
        Trace.endSection();
        return (System.nanoTime() - y[c]) / 1000000.0f;
    }

    public static void xj(String str) {
        if (hf) {
            int i = c;
            if (i == 20) {
                f++;
                return;
            }
            kd[i] = str;
            y[i] = System.nanoTime();
            Trace.beginSection(str);
            c++;
        }
    }

    public static com.bytedance.adsdk.lottie.w.f xj(Context context) {
        com.bytedance.adsdk.lottie.w.f fVar;
        com.bytedance.adsdk.lottie.w.f fVar2 = p;
        if (fVar2 != null) {
            return fVar2;
        }
        synchronized (com.bytedance.adsdk.lottie.w.f.class) {
            try {
                fVar = p;
                if (fVar == null) {
                    com.bytedance.adsdk.lottie.w.c hf2 = hf(context);
                    com.bytedance.adsdk.lottie.w.y yVar = d;
                    if (yVar == null) {
                        yVar = new com.bytedance.adsdk.lottie.w.hf();
                    }
                    fVar = new com.bytedance.adsdk.lottie.w.f(hf2, yVar);
                    p = fVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public static boolean xj() {
        return u;
    }

    public static com.bytedance.adsdk.lottie.w.c hf(Context context) {
        com.bytedance.adsdk.lottie.w.c cVar;
        if (!w) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        com.bytedance.adsdk.lottie.w.c cVar2 = f10042pl;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (com.bytedance.adsdk.lottie.w.c.class) {
            try {
                cVar = f10042pl;
                if (cVar == null) {
                    com.bytedance.adsdk.lottie.w.kd kdVar = tf;
                    if (kdVar == null) {
                        kdVar = new com.bytedance.adsdk.lottie.w.kd() { // from class: com.bytedance.adsdk.lottie.kd.1
                            @Override // com.bytedance.adsdk.lottie.w.kd
                            public File xj() {
                                return new File(com.bytedance.sdk.openadsdk.api.plugin.hf.hf(applicationContext), "lottie_network_cache");
                            }
                        };
                    }
                    cVar = new com.bytedance.adsdk.lottie.w.c(kdVar);
                    f10042pl = cVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }
}
