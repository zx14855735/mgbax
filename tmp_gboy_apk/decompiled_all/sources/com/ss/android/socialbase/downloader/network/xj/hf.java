package com.ss.android.socialbase.downloader.network.xj;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.tf;
import com.ss.android.socialbase.downloader.tf.y;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf {
    static long hf;
    private static final Handler u;
    private static final HandlerThread w;
    static long xj;

    static {
        HandlerThread handlerThread = new HandlerThread("Downloader-preconnecter");
        w = handlerThread;
        hf();
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        u = handler;
        handler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.xj.hf.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        });
        tIyXAna();
    }

    private static void hf() {
        xj = com.ss.android.socialbase.downloader.f.xj.w().xj("preconnect_connection_outdate_time", 300000L);
        hf = com.ss.android.socialbase.downloader.f.xj.w().xj("preconnect_head_info_outdate_time", 300000L);
        xj.xj().xj(com.ss.android.socialbase.downloader.f.xj.w().xj("preconnect_max_cache_size", 3));
    }

    private static /* synthetic */ void tIyXAna() {
        char[] charArray = "dhj)`fjb)eh~)tobkk)MinEunc`b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 7);
        }
        String str = new String(charArray);
        char[] charArray2 = "dknins".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 7);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static Looper xj() {
        return w.getLooper();
    }

    public static void xj(final String str, final tf tfVar) {
        u.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.xj.hf.2
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    tf tfVar2 = tfVar;
                    if (tfVar2 != null) {
                        tfVar2.xj(null);
                        return;
                    }
                    return;
                }
                try {
                    try {
                        try {
                            List<com.ss.android.socialbase.downloader.model.w> hf2 = hf.hf(0L, null, null);
                            r1 = xj.xj().xj(str) ? xj.xj().xj(str, hf2) : null;
                            if (r1 == null) {
                                w wVar = new w(str, hf2, 0L);
                                try {
                                    wVar.xj();
                                    if (wVar.kd()) {
                                        xj.xj().xj(str, wVar);
                                    }
                                    r1 = wVar;
                                } catch (Exception e) {
                                    e = e;
                                    r1 = wVar;
                                    pl.xj(e);
                                    r1.w();
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    r1 = wVar;
                                    try {
                                        r1.w();
                                    } catch (Throwable unused) {
                                    }
                                    throw th;
                                }
                            }
                            Map<String, String> d = r1.d();
                            tf tfVar3 = tfVar;
                            if (tfVar3 != null) {
                                tfVar3.xj(d);
                            }
                            r1.w();
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<com.ss.android.socialbase.downloader.model.w> hf(long j, DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.model.w> list) {
        return y.xj(list, downloadInfo == null ? null : downloadInfo.geteTag(), j, 0L);
    }
}
