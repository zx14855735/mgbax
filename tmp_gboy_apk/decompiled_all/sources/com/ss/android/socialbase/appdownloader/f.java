package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.xj.xj;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f {
    private Runnable c;
    private boolean hf;
    private SoftReference<JumpUnknownSourceActivity> kd;
    private long u;
    private long w;
    private final Queue<Integer> xj;
    private Handler y;

    public static class xj {
        private static final f xj = new f();

        static {
            bAsBx();
        }

        private static /* synthetic */ void bAsBx() {
            char[] charArray = "{wu6\u007fyu}6zwa6kp}tt6RvqZjq|\u007f}".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 24);
            }
            String str = new String(charArray);
            char[] charArray2 = "{tqvql".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 24);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private f() {
        this.xj = new ArrayDeque();
        this.hf = false;
        this.y = new Handler(Looper.getMainLooper());
        this.c = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.w();
            }
        };
        com.ss.android.socialbase.downloader.xj.xj.xj().xj(new xj.InterfaceC0510xj() { // from class: com.ss.android.socialbase.appdownloader.f.2
            @Override // com.ss.android.socialbase.downloader.xj.xj.InterfaceC0510xj
            public void hf() {
                boolean hasCallbacks;
                if (f.this.xj.isEmpty()) {
                    return;
                }
                long xj2 = com.ss.android.socialbase.downloader.f.xj.w().xj("install_on_resume_install_interval", 120000L);
                long currentTimeMillis = System.currentTimeMillis() - f.this.u;
                if (currentTimeMillis >= xj2) {
                    f.this.u = System.currentTimeMillis();
                    f.this.w();
                } else {
                    hasCallbacks = f.this.y.hasCallbacks(f.this.c);
                    if (hasCallbacks) {
                        return;
                    }
                    f.this.y.postDelayed(f.this.c, xj2 - currentTimeMillis);
                }
            }

            @Override // com.ss.android.socialbase.downloader.xj.xj.InterfaceC0510xj
            public void w() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hf(Context context, int i, boolean z) {
        int hf = w.hf(context, i, z);
        if (hf == 1) {
            this.hf = true;
        }
        this.w = System.currentTimeMillis();
        return hf;
    }

    private boolean u() {
        return System.currentTimeMillis() - this.w < 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        final Integer poll;
        if (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.xj.xj.xj().hf()) {
            synchronized (this.xj) {
                poll = this.xj.poll();
            }
            this.y.removeCallbacks(this.c);
            if (poll == null) {
                this.hf = false;
                return;
            }
            final Context tj = com.ss.android.socialbase.downloader.downloader.w.tj();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.y.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hf(tj, poll.intValue(), false);
                    }
                });
            } else {
                hf(tj, poll.intValue(), false);
            }
            this.y.postDelayed(this.c, 20000L);
        }
    }

    public void xj(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        w();
    }

    public JumpUnknownSourceActivity hf() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.kd;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.kd = null;
        return jumpUnknownSourceActivity;
    }

    public static f xj() {
        return xj.xj;
    }

    public int xj(final Context context, final int i, final boolean z) {
        if (z) {
            return hf(context, i, z);
        }
        if (u()) {
            this.y.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.f.4
                @Override // java.lang.Runnable
                public void run() {
                    f.this.xj(context, i, z);
                }
            }, 1000L);
            return 1;
        }
        if (com.ss.android.socialbase.downloader.xj.xj.xj().hf()) {
            com.ss.android.socialbase.downloader.w.xj.w("leaves", "on Foreground");
            return hf(context, i, z);
        }
        if (hf.xj()) {
            return 1;
        }
        boolean z2 = Build.VERSION.SDK_INT < 29;
        if (this.xj.isEmpty() && !this.hf && z2) {
            return hf(context, i, z);
        }
        int xj2 = com.ss.android.socialbase.downloader.f.xj.w().xj("install_queue_size", 3);
        synchronized (this.xj) {
            while (this.xj.size() > xj2) {
                try {
                    this.xj.poll();
                } finally {
                }
            }
        }
        if (z2) {
            this.y.removeCallbacks(this.c);
            this.y.postDelayed(this.c, com.ss.android.socialbase.downloader.f.xj.xj(i).xj("install_queue_timeout", 20000L));
        }
        synchronized (this.xj) {
            try {
                if (!this.xj.contains(Integer.valueOf(i))) {
                    this.xj.offer(Integer.valueOf(i));
                }
            } finally {
            }
        }
        return 1;
    }

    public void xj(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.kd = new SoftReference<>(jumpUnknownSourceActivity);
    }
}
