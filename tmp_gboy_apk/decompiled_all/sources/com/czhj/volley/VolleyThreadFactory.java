package com.czhj.volley;

import java.util.concurrent.ThreadFactory;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class VolleyThreadFactory implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        VolleyLog.d("Volley ThreadFactor create ,current thread num :" + Thread.activeCount(), new Object[0]);
        return new Thread(runnable) { // from class: com.czhj.volley.VolleyThreadFactory.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
            }
        };
    }
}
