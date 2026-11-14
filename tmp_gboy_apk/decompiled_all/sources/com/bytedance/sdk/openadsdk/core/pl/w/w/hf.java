package com.bytedance.sdk.openadsdk.core.pl.w.w;

import com.bytedance.sdk.openadsdk.core.ra.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends xj {
    private boolean kd = false;
    private int y = 0;
    private boolean c = false;

    public void hf(boolean z) {
        this.kd = z;
    }

    public void w(boolean z) {
        this.c = z;
    }

    public void xj(int i) {
        this.y = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.w.xj
    public boolean w() {
        this.w = 1;
        boolean z = y.u;
        int pl2 = jk.pl(this.hf);
        if (z) {
            pl2 = 0;
            y.u = false;
        }
        if (this.c) {
            return u();
        }
        if (this.kd) {
            int i = this.y;
            if (i == 2) {
                return u();
            }
            if (pl2 == 2 && i == 1) {
                return u();
            }
        }
        if (pl2 == 0) {
            return u();
        }
        return true;
    }
}
