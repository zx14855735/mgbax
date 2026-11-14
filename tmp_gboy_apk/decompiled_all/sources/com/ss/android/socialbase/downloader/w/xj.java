package com.ss.android.socialbase.downloader.w;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj {
    private static AbstractC0509xj hf = null;
    private static int xj = 4;

    /* renamed from: com.ss.android.socialbase.downloader.w.xj$xj, reason: collision with other inner class name */
    public static abstract class AbstractC0509xj {
    }

    public static String hf(String str) {
        return !TextUtils.isEmpty(str) ? CtFAbx.BChYOn("Downloader-", str) : "DownloaderLogger";
    }

    public static void kd(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (xj <= 6) {
            pl.u(hf(str), str2);
        }
        if (hf != null) {
            hf(str);
        }
    }

    public static void u(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (xj <= 5) {
            pl.hf(hf(str), str2);
        }
        if (hf != null) {
            hf(str);
        }
    }

    public static void w(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (xj <= 4) {
            pl.xj(hf(str), str2);
        }
        if (hf != null) {
            hf(str);
        }
    }

    public static void xj(int i) {
        xj = i;
    }

    public static boolean xj() {
        return xj <= 3;
    }

    public static void xj(String str, String str2) {
        if (str2 == null || hf == null) {
            return;
        }
        hf(str);
    }

    public static void w(String str) {
        u("DownloaderLogger", str);
    }

    public static void xj(String str) {
        hf("DownloaderLogger", str);
    }

    public static void xj(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (xj <= 3) {
            hf(str);
        }
        if (hf != null) {
            hf(str);
        }
    }

    public static void hf(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (xj <= 3) {
            hf(str);
        }
        if (hf != null) {
            hf(str);
        }
    }

    public static void hf(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (xj <= 6) {
            pl.w(hf(str), str2, th);
        }
        if (hf != null) {
            hf(str);
        }
    }
}
