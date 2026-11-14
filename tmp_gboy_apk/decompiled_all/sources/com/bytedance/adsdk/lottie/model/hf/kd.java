package com.bytedance.adsdk.lottie.model.hf;

import android.graphics.Path;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd implements w {
    private final String c;
    private final com.bytedance.adsdk.lottie.model.xj.hf d;
    private final com.bytedance.adsdk.lottie.model.xj.hf f;
    private final Path.FillType hf;
    private final com.bytedance.adsdk.lottie.model.xj.y kd;
    private final boolean tf;
    private final com.bytedance.adsdk.lottie.model.xj.u u;
    private final com.bytedance.adsdk.lottie.model.xj.w w;
    private final c xj;
    private final com.bytedance.adsdk.lottie.model.xj.y y;

    public kd(String str, c cVar, Path.FillType fillType, com.bytedance.adsdk.lottie.model.xj.w wVar, com.bytedance.adsdk.lottie.model.xj.u uVar, com.bytedance.adsdk.lottie.model.xj.y yVar, com.bytedance.adsdk.lottie.model.xj.y yVar2, com.bytedance.adsdk.lottie.model.xj.hf hfVar, com.bytedance.adsdk.lottie.model.xj.hf hfVar2, boolean z) {
        this.xj = cVar;
        this.hf = fillType;
        this.w = wVar;
        this.u = uVar;
        this.kd = yVar;
        this.y = yVar2;
        this.c = str;
        this.f = hfVar;
        this.d = hfVar2;
        this.tf = z;
    }

    public com.bytedance.adsdk.lottie.model.xj.y c() {
        return this.y;
    }

    public boolean f() {
        return this.tf;
    }

    public c hf() {
        return this.xj;
    }

    public com.bytedance.adsdk.lottie.model.xj.u kd() {
        return this.u;
    }

    public com.bytedance.adsdk.lottie.model.xj.w u() {
        return this.w;
    }

    public Path.FillType w() {
        return this.hf;
    }

    public String xj() {
        return this.c;
    }

    public com.bytedance.adsdk.lottie.model.xj.y y() {
        return this.kd;
    }

    @Override // com.bytedance.adsdk.lottie.model.hf.w
    public com.bytedance.adsdk.lottie.xj.xj.w xj(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.y yVar, com.bytedance.adsdk.lottie.model.layer.w wVar) {
        return new com.bytedance.adsdk.lottie.xj.xj.f(fVar, yVar, wVar, this);
    }
}
