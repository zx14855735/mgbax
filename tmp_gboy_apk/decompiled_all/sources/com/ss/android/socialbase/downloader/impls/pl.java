package com.ss.android.socialbase.downloader.impls;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class pl {
    private static volatile com.ss.android.socialbase.downloader.downloader.g hf;
    private static volatile com.ss.android.socialbase.downloader.downloader.g xj;

    public static com.ss.android.socialbase.downloader.downloader.g xj(boolean z) {
        if (z && com.ss.android.socialbase.downloader.downloader.w.dc()) {
            if (hf == null) {
                synchronized (pl.class) {
                    try {
                        if (hf == null) {
                            hf = com.ss.android.socialbase.downloader.downloader.w.wn().hf();
                        }
                    } finally {
                    }
                }
            }
            return hf;
        }
        if (xj == null) {
            synchronized (pl.class) {
                try {
                    if (xj == null) {
                        xj = new zg();
                    }
                } finally {
                }
            }
        }
        return xj;
    }
}
