package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d {
    private String c;
    private final ws hf;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.u kd;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.kd u;
    private com.bytedance.sdk.openadsdk.core.pl.hf.w w;
    private final Context xj;
    private View y;

    public d(Context context, ws wsVar, View view, String str) {
        this.c = "rewarded_video";
        this.hf = wsVar;
        this.xj = context;
        this.y = view;
        if (TextUtils.isEmpty(str)) {
            this.c = wo.hf(wo.f(wsVar));
        } else {
            this.c = str;
        }
        if (wsVar.vw() == 4) {
            this.w = com.bytedance.sdk.openadsdk.core.pl.f.xj(context, wsVar, this.c, false);
        }
        String str2 = this.c;
        com.bytedance.sdk.openadsdk.core.nativeexpress.kd kdVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.kd(context, wsVar, str2, wo.hf(str2));
        this.u = kdVar;
        kdVar.xj(this.y);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.u.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.w);
        String str3 = this.c;
        com.bytedance.sdk.openadsdk.core.nativeexpress.u uVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.u(context, wsVar, str3, wo.hf(str3));
        this.kd = uVar;
        uVar.xj(this.y);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.kd.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.w);
    }

    public void xj(int i, com.bytedance.sdk.openadsdk.core.ra.ra raVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.u uVar;
        if (i == -1 || raVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ra.tf tfVar = new com.bytedance.sdk.openadsdk.core.ra.tf();
        tfVar.xj(raVar.xj);
        tfVar.hf(raVar.hf);
        tfVar.w(raVar.w);
        tfVar.u(raVar.u);
        tfVar.xj(raVar.qt);
        tfVar.xj(raVar.zg);
        if (i != 1) {
            if (i == 2 && (uVar = this.kd) != null) {
                uVar.xj(raVar);
                this.kd.xj(tfVar);
                this.kd.xj(this.y, tfVar);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.kd kdVar = this.u;
        if (kdVar != null) {
            kdVar.xj(raVar);
            this.u.xj(tfVar);
            this.u.xj(this.y, tfVar);
        }
    }
}
