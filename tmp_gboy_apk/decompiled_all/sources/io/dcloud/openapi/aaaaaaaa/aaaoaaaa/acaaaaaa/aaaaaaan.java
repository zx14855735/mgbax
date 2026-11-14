package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaan {
    private static aaaaaaan aaaaaaa0;
    ThreadPoolExecutor aaaaaaaa = new ThreadPoolExecutor(3, 6, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());

    private aaaaaaan() {
    }

    public static aaaaaaan aaaaaaaa() {
        if (aaaaaaa0 == null) {
            synchronized (aaaaaaan.class) {
                try {
                    if (aaaaaaa0 == null) {
                        aaaaaaa0 = new aaaaaaan();
                    }
                } finally {
                }
            }
        }
        return aaaaaaa0;
    }

    public void aaaaaaaa(Runnable runnable) {
        this.aaaaaaaa.execute(runnable);
    }
}
