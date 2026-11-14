package com.bytedance.sdk.openadsdk.core.hf;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.ra.tf;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends u {
    protected final String hf;
    protected com.bytedance.sdk.openadsdk.core.hf.xj.w kd;
    public int u;
    protected final int w;
    protected final ws xj;

    public hf(Context context, ws wsVar, String str, int i) {
        super(context);
        this.u = 1;
        this.xj = wsVar;
        this.hf = str;
        this.w = i;
        kd();
    }

    private void kd() {
        com.bytedance.sdk.openadsdk.core.hf.xj.w xj = this.f.xj(this.xj, this.y, this, xj());
        this.kd = xj;
        xj.xj(this.c);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(this.hf);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.hf);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.w);
        if (xj()) {
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).u(true);
        }
    }

    public tf hf() {
        return this.c;
    }

    public void u(int i) {
        this.c.hf(i);
    }

    public void w(int i) {
        this.c.w(i);
    }

    public boolean xj() {
        return false;
    }

    public void hf(View view) {
        this.c.xj(view);
    }

    public void xj(int i) {
        this.u = i;
        tf tfVar = this.c;
        if (tfVar != null) {
            tfVar.xj(i);
        }
    }

    public void hf(int i) {
        this.c.u(i);
    }

    public void xj(tf tfVar) {
        this.c = tfVar;
    }

    public void xj(View view) {
        this.c.hf(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.hf.u
    public void xj(View view, tf tfVar) {
        if (ws.kd(this.xj)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).kd());
        this.kd.xj(view);
        if (tfVar == null) {
            tfVar = new tf();
        }
        this.kd.xj(tfVar);
        this.kd.xj();
        ws.y(this.xj);
    }
}
