package com.bytedance.sdk.openadsdk.core.kd.kd;

import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.f;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    protected int hf;
    private com.bytedance.sdk.openadsdk.core.kd.xj.xj kd;
    private com.bytedance.sdk.openadsdk.core.kd.xj.xj u;
    protected com.bytedance.sdk.openadsdk.core.kd.w.xj w;
    protected f.hf xj;

    public hf(int i) {
        this.hf = i;
        this.xj = f.xj(i);
        w();
        u();
    }

    private int hf() {
        f.hf hfVar = this.xj;
        if (hfVar == null) {
            return -2;
        }
        if (hfVar.c() && pz.hf().ie()) {
            return this.xj.u();
        }
        return -1;
    }

    private void u() {
        int i = this.hf;
        if (i == 1) {
            this.kd = new com.bytedance.sdk.openadsdk.core.kd.w(this, i);
            this.u = new com.bytedance.sdk.openadsdk.core.component.xj.hf(this);
            return;
        }
        switch (i) {
            case 5:
                this.kd = new com.bytedance.sdk.openadsdk.core.kd.w(this, i);
                this.u = new com.bytedance.sdk.openadsdk.core.component.w.hf(this);
                break;
            case 6:
                this.u = new com.bytedance.sdk.openadsdk.core.component.u.hf(this);
                break;
            case 7:
                this.u = new com.bytedance.sdk.openadsdk.core.component.reward.xj.c(this);
                break;
            case 8:
                this.u = new com.bytedance.sdk.openadsdk.core.component.reward.xj.xj(this);
                break;
            case 9:
                this.kd = new com.bytedance.sdk.openadsdk.core.kd.w(this, i);
                this.u = new com.bytedance.sdk.openadsdk.core.component.hf.hf(this);
                break;
        }
    }

    private void w() {
        int hf = hf();
        if (hf == -1) {
            this.w = new com.bytedance.sdk.openadsdk.core.kd.w.w(this.hf);
            return;
        }
        if (hf == 0) {
            this.w = new com.bytedance.sdk.openadsdk.core.kd.w.hf(this.hf);
            return;
        }
        if (hf == 1) {
            this.w = new com.bytedance.sdk.openadsdk.core.kd.w.kd(this.hf);
        } else if (hf != 3) {
            this.w = xj.hf(this.hf);
        } else {
            this.w = new com.bytedance.sdk.openadsdk.core.kd.w.u(this.hf);
        }
    }

    public boolean xj(ws wsVar) {
        return com.bytedance.sdk.openadsdk.core.live.hf.xj().w(wsVar) != 3;
    }

    public com.bytedance.sdk.openadsdk.core.kd.w.xj xj() {
        return this.w;
    }

    public com.bytedance.sdk.openadsdk.core.kd.xj.xj xj(boolean z) {
        com.bytedance.sdk.openadsdk.core.kd.xj.xj xjVar;
        return (!z || (xjVar = this.kd) == null) ? this.u : xjVar;
    }
}
