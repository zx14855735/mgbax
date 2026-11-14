package com.bytedance.sdk.component.f.hf.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.sdk.component.f.xj.kd;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static volatile xj u = null;
    private static int w = 3000;
    private volatile Handler hf = null;
    private Looper kd;
    private volatile HandlerThread xj;

    private xj(kd kdVar) {
        this.xj = null;
        this.kd = null;
        if (kdVar != null && kdVar.u() != null && kdVar.u().qt() != null) {
            this.kd = kdVar.u().qt();
        } else {
            this.xj = new HandlerThread("csj_ad_log", 10);
            this.xj.start();
        }
    }

    public static xj xj(kd kdVar) {
        if (u == null) {
            synchronized (xj.class) {
                try {
                    if (u == null) {
                        u = new xj(kdVar);
                    }
                } finally {
                }
            }
        }
        return u;
    }

    public int hf() {
        if (w <= 0) {
            w = 3000;
        }
        return w;
    }

    public Handler xj() {
        if (this.kd != null) {
            if (this.hf == null) {
                synchronized (xj.class) {
                    try {
                        if (this.hf == null) {
                            this.hf = new Handler(this.kd);
                        }
                    } finally {
                    }
                }
            }
        } else if (this.xj != null && this.xj.isAlive()) {
            if (this.hf == null) {
                synchronized (xj.class) {
                    try {
                        if (this.hf == null) {
                            this.hf = new Handler(this.xj.getLooper());
                        }
                    } finally {
                    }
                }
            }
        } else {
            synchronized (xj.class) {
                try {
                    if (this.xj != null) {
                        if (!this.xj.isAlive()) {
                        }
                    }
                    this.xj = new HandlerThread("csj_init_handle", -1);
                    this.xj.start();
                    this.hf = new Handler(this.xj.getLooper());
                } finally {
                }
            }
        }
        return this.hf;
    }
}
