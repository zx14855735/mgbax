package com.bytedance.sdk.openadsdk.core.component.splash;

import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.openadsdk.core.kd.kd;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    public kd.xj kd;
    public int u;
    public f.w y;
    public int xj = 0;
    public long hf = 0;
    public int w = -1;

    public boolean hf() {
        f.w wVar;
        if (this.hf <= 0 || this.xj != 3) {
            return false;
        }
        kd.xj xjVar = this.kd;
        hf((xjVar == null || (wVar = this.y) == null) ? -1 : xjVar.xj(wVar.kd(), this.y));
        this.w = 2;
        return true;
    }

    public int xj(int i) {
        int w;
        double d;
        this.u = i;
        int d2 = pz.hf().d(i);
        if (d2 > 0 && d2 <= 3) {
            f.hf xj = com.bytedance.sdk.openadsdk.core.ra.f.xj();
            int f = xj == null ? 0 : xj.f();
            f.w tf = xj == null ? null : xj.tf();
            this.y = tf;
            if (tf != null && f == 5) {
                if (tf.hf() > 0) {
                    try {
                        d = Double.parseDouble(com.bytedance.sdk.openadsdk.core.x.xj.xj().xj("DeviceRate", "bytebench_value"));
                    } catch (Exception unused) {
                        d = 0.0d;
                    }
                    if (d > 0.0d && d < this.y.hf()) {
                        this.xj = 1;
                        return 1;
                    }
                }
                if (this.y.w() > 0 && ((w = am.w(pz.getContext())) == 2 ? (this.y.w() & 1) != 0 : !(w == 3 ? (this.y.w() & 2) == 0 : w == 4 ? (this.y.w() & 16) == 0 : w == 5 ? (this.y.w() & 4) == 0 : w != 6 || (this.y.w() & 8) == 0))) {
                    this.xj = 2;
                    return 1;
                }
                this.kd = com.bytedance.sdk.openadsdk.core.kd.kd.xj(String.valueOf(i), this.y);
                if (this.y.u() > 0) {
                    this.xj = 3;
                    this.kd.xj(this.y);
                    int xj2 = this.kd.xj(this.y.u(), this.y);
                    if (xj2 > 0) {
                        this.hf = System.currentTimeMillis() - (xj2 * 60000);
                        return 1;
                    }
                    if (xj2 == 0) {
                        return 1;
                    }
                }
                this.xj = 4;
                hf(this.kd.xj(this.y.kd(), this.y));
                return 2;
            }
        }
        return d2;
    }

    private void hf(int i) {
        if (i > 0) {
            this.hf = System.currentTimeMillis() - (i * 60000);
        } else if (i == 0) {
            this.hf = 0L;
        } else {
            this.hf = System.currentTimeMillis();
        }
    }

    public static void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        f.hf xj = com.bytedance.sdk.openadsdk.core.ra.f.xj();
        if (xj == null || hfVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kd.kd.xj(hfVar.u(), xj.tf()).hf(xj.tf());
    }

    public boolean xj() {
        return this.xj == 4;
    }
}
