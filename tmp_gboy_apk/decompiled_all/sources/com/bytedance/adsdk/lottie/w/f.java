package com.bytedance.adsdk.lottie.w;

import android.content.Context;
import android.util.Pair;
import com.baidu.mobads.sdk.internal.an;
import com.bytedance.adsdk.lottie.pl;
import com.bytedance.component.sdk.annotation.RestrictTo;
import com.bytedance.component.sdk.annotation.WorkerThread;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f {
    private final y hf;
    private final c xj;

    public f(c cVar, y yVar) {
        this.xj = cVar;
        this.hf = yVar;
    }

    @WorkerThread
    private com.bytedance.adsdk.lottie.y hf(Context context, String str, String str2) {
        c cVar;
        Pair<w, InputStream> xj;
        if (str2 == null || (cVar = this.xj) == null || (xj = cVar.xj(str)) == null) {
            return null;
        }
        w wVar = (w) xj.first;
        InputStream inputStream = (InputStream) xj.second;
        pl<com.bytedance.adsdk.lottie.y> xj2 = wVar == w.ZIP ? com.bytedance.adsdk.lottie.c.xj(context, new ZipInputStream(inputStream), str2) : com.bytedance.adsdk.lottie.c.hf(inputStream, str2);
        if (xj2.xj() != null) {
            return xj2.xj();
        }
        return null;
    }

    @WorkerThread
    private pl<com.bytedance.adsdk.lottie.y> w(Context context, String str, String str2) {
        com.bytedance.adsdk.lottie.kd.kd.xj("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                u xj = this.hf.xj(str);
                if (!xj.xj()) {
                    pl<com.bytedance.adsdk.lottie.y> plVar = new pl<>(new IllegalArgumentException(xj.u()));
                    try {
                        xj.close();
                        return plVar;
                    } catch (IOException e) {
                        com.bytedance.adsdk.lottie.kd.kd.xj("LottieFetchResult close failed ", e);
                        return plVar;
                    }
                }
                pl<com.bytedance.adsdk.lottie.y> xj2 = xj(context, str, xj.hf(), xj.w(), str2);
                StringBuilder sb = new StringBuilder("Completed fetch from network. Success: ");
                sb.append(xj2.xj() != null);
                com.bytedance.adsdk.lottie.kd.kd.xj(sb.toString());
                try {
                    xj.close();
                    return xj2;
                } catch (IOException e2) {
                    com.bytedance.adsdk.lottie.kd.kd.xj("LottieFetchResult close failed ", e2);
                    return xj2;
                }
            } catch (Exception e3) {
                pl<com.bytedance.adsdk.lottie.y> plVar2 = new pl<>(e3);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e4) {
                        com.bytedance.adsdk.lottie.kd.kd.xj("LottieFetchResult close failed ", e4);
                    }
                }
                return plVar2;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                throw th;
            }
            try {
                closeable.close();
                throw th;
            } catch (IOException e5) {
                com.bytedance.adsdk.lottie.kd.kd.xj("LottieFetchResult close failed ", e5);
                throw th;
            }
        }
    }

    @WorkerThread
    public pl<com.bytedance.adsdk.lottie.y> xj(Context context, String str, String str2) {
        com.bytedance.adsdk.lottie.y hf = hf(context, str, str2);
        if (hf != null) {
            return new pl<>(hf);
        }
        com.bytedance.adsdk.lottie.kd.kd.xj("Animation for " + str + " not found in cache. Fetching from network.");
        return w(context, str, str2);
    }

    private pl<com.bytedance.adsdk.lottie.y> xj(Context context, String str, InputStream inputStream, String str2, String str3) {
        pl<com.bytedance.adsdk.lottie.y> xj;
        w wVar;
        c cVar;
        if (str2 == null) {
            str2 = an.d;
        }
        if (!str2.contains("application/zip") && !str2.contains("application/x-zip") && !str2.contains("application/x-zip-compressed") && !str.split("\\?")[0].endsWith(".lottie")) {
            com.bytedance.adsdk.lottie.kd.kd.xj("Received json response.");
            wVar = w.JSON;
            xj = xj(str, inputStream, str3);
        } else {
            com.bytedance.adsdk.lottie.kd.kd.xj("Handling zip response.");
            w wVar2 = w.ZIP;
            xj = xj(context, str, inputStream, str3);
            wVar = wVar2;
        }
        if (str3 != null && xj.xj() != null && (cVar = this.xj) != null) {
            cVar.xj(str, wVar);
        }
        return xj;
    }

    private pl<com.bytedance.adsdk.lottie.y> xj(Context context, String str, InputStream inputStream, String str2) {
        c cVar;
        if (str2 != null && (cVar = this.xj) != null) {
            return com.bytedance.adsdk.lottie.c.xj(context, new ZipInputStream(new FileInputStream(cVar.xj(str, inputStream, w.ZIP))), str);
        }
        return com.bytedance.adsdk.lottie.c.xj(context, new ZipInputStream(inputStream), (String) null);
    }

    private pl<com.bytedance.adsdk.lottie.y> xj(String str, InputStream inputStream, String str2) {
        c cVar;
        if (str2 != null && (cVar = this.xj) != null) {
            return com.bytedance.adsdk.lottie.c.hf(new FileInputStream(cVar.xj(str, inputStream, w.JSON).getAbsolutePath()), str);
        }
        return com.bytedance.adsdk.lottie.c.hf(inputStream, (String) null);
    }
}
