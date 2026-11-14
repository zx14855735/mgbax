package com.bytedance.sdk.component.f.hf.hf.w;

import android.os.Looper;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    protected final com.bytedance.sdk.component.f.xj.kd hf;
    protected final com.bytedance.sdk.component.f.hf.hf.hf w;
    private volatile u xj;

    public kd(com.bytedance.sdk.component.f.xj.kd kdVar, com.bytedance.sdk.component.f.hf.hf.hf hfVar) {
        this.hf = kdVar;
        this.w = hfVar;
    }

    public Looper c() {
        com.bytedance.sdk.component.f.xj.u u = this.hf.u();
        return (u == null || u.qt() == null) ? kd().getLooper() : u.qt();
    }

    public u kd() {
        if (this.xj == null) {
            synchronized (this) {
                try {
                    if (this.xj == null) {
                        this.xj = new u();
                    }
                } finally {
                }
            }
        }
        return this.xj;
    }

    public void w() {
    }

    public void y() {
        com.bytedance.sdk.component.f.xj.u u = this.hf.u();
        if (u != null && u.qt() != null) {
            w();
            return;
        }
        u kd = kd();
        kd.xj(this);
        kd.start();
    }
}
