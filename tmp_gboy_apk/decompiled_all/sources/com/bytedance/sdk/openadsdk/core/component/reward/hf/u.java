package com.bytedance.sdk.openadsdk.core.component.reward.hf;

import com.bytedance.sdk.openadsdk.core.a.ht;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    private final TTBaseVideoActivity hf;
    private kd kd;
    private hf u;
    private ws w;
    protected boolean xj;
    private boolean y = false;

    public u(TTBaseVideoActivity tTBaseVideoActivity) {
        this.hf = tTBaseVideoActivity;
    }

    public void hf() {
        if (ht.hf(this.w)) {
            if (this.u.l() || u()) {
                boolean z = !this.xj;
                this.xj = z;
                this.u.xj(z);
            }
        }
    }

    public boolean kd() {
        if (ht.w(this.w)) {
            return this.u.en();
        }
        return false;
    }

    public boolean u() {
        hf hfVar = this.u;
        if (hfVar != null) {
            return hfVar.q();
        }
        return false;
    }

    public void w() {
        this.u.x();
        this.kd.xj(this.hf.aq().qd());
    }

    public void xj(hf hfVar, ws wsVar, String str, kd kdVar) {
        if (this.y) {
            return;
        }
        this.y = true;
        this.u = hfVar;
        this.w = wsVar;
        this.kd = kdVar;
    }

    public boolean y() {
        return this.xj;
    }

    public void hf(boolean z) {
        this.u.y(z);
    }

    public void xj() {
        if (ht.hf(this.w) && !this.u.l()) {
            u();
        }
    }

    public void xj(boolean z) {
        hf hfVar = this.u;
        if (hfVar != null && hfVar.ai()) {
            this.xj = z;
            this.kd.u(z);
            this.u.xj(this.xj);
        }
    }

    public void xj(boolean z, boolean z2) {
        this.u.dk();
        xj(z);
        hf(z2);
    }

    public void xj(int i, int i2) {
        this.u.hf(i, i2);
    }

    public void xj(ws wsVar) {
        this.w = wsVar;
    }
}
