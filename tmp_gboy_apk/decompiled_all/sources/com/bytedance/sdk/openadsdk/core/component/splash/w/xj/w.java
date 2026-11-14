package com.bytedance.sdk.openadsdk.core.component.splash.w.xj;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends xj {
    private String c;
    private int d;
    private int f = 1;
    private y kd;
    private boolean p;
    private com.bytedance.sdk.openadsdk.zg.w.w.hf tf;
    public f u;
    private Context y;

    public w(Context context, String str, y yVar, f fVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        this.y = context;
        this.c = str;
        this.kd = yVar;
        this.p = yVar.kd();
        this.hf = yVar.hf();
        this.u = fVar;
        this.tf = hfVar;
    }

    public com.bytedance.sdk.openadsdk.zg.w.w.hf c() {
        return this.tf;
    }

    public boolean d() {
        return this.p;
    }

    public int f() {
        return this.d;
    }

    public Context getContext() {
        return this.y;
    }

    public f kd() {
        return this.u;
    }

    public y u() {
        return this.kd;
    }

    public String y() {
        return this.c;
    }
}
