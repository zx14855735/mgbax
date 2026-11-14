package com.bytedance.msdk.c.hf;

import android.text.TextUtils;
import com.bytedance.msdk.f.ai;
import com.bytedance.msdk.xj.kd.w;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static volatile xj hf;
    private long kd;
    private long u;
    private String y;
    private final String xj = "xj";
    private ai w = com.bytedance.msdk.c.xj.kd();

    private xj() {
    }

    public static xj xj() {
        if (hf == null) {
            synchronized (xj.class) {
                try {
                    if (hf == null) {
                        hf = new xj();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    public void c() {
        this.kd = System.currentTimeMillis();
    }

    public long d() {
        long currentTimeMillis = System.currentTimeMillis() - this.u;
        w.hf(this.xj, "SplashRequestDuration = ".concat(String.valueOf(currentTimeMillis)));
        return currentTimeMillis;
    }

    public long f() {
        long j = this.kd - this.u;
        w.hf(this.xj, "InitMethodDuration = ".concat(String.valueOf(j)));
        return j;
    }

    public long hf() {
        try {
            long hf2 = this.w.hf("first_install_time", -1L);
            if (hf2 == -1) {
                hf2 = com.bytedance.msdk.c.xj.xj().hf("first_install_time", -1L);
                if (hf2 == -1) {
                    hf2 = System.currentTimeMillis();
                }
                this.w.xj("first_install_time", hf2);
            }
            return hf2;
        } catch (Throwable th) {
            pl.xj(th);
            return 0L;
        }
    }

    public synchronized void kd() {
        this.w.xj("discard_num", 0);
    }

    public boolean p() {
        return TextUtils.isEmpty(this.y);
    }

    public boolean pl() {
        String str = this.y;
        String str2 = com.bytedance.msdk.kd.xj.w;
        boolean equals = TextUtils.equals(str, str2);
        w.hf(this.xj, "canUploadInitDuration = " + equals + " 当sessionId = " + str2 + " 存储的sessionId = " + this.y);
        return !equals;
    }

    public long tf() {
        long currentTimeMillis = System.currentTimeMillis() - this.u;
        w.hf(this.xj, "SplashFillDuration = ".concat(String.valueOf(currentTimeMillis)));
        return currentTimeMillis;
    }

    public synchronized int u() {
        return this.w.hf("discard_num", 0);
    }

    public synchronized void w() {
        this.w.xj("discard_num", this.w.hf("discard_num", 0) + 1);
    }

    public void y() {
        this.u = System.currentTimeMillis();
    }

    public void xj(long j) {
        try {
            if (this.w.hf("first_install_time", -1L) == -1) {
                long hf2 = com.bytedance.msdk.c.xj.xj().hf("first_install_time", -1L);
                if (hf2 != -1) {
                    j = hf2;
                }
                this.w.xj("first_install_time", j);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public void xj(String str) {
        this.y = str;
    }
}
