package com.bytedance.adsdk.lottie.xj.xj;

import com.bytedance.adsdk.lottie.model.hf.v;
import com.bytedance.adsdk.lottie.xj.hf.xj;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pz implements xj.InterfaceC0024xj, w {
    private final com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> c;
    private final boolean hf;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> kd;
    private final v.xj u;
    private final List<xj.InterfaceC0024xj> w = new ArrayList();
    private final String xj;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> y;

    public pz(com.bytedance.adsdk.lottie.model.layer.w wVar, com.bytedance.adsdk.lottie.model.hf.v vVar) {
        this.xj = vVar.xj();
        this.hf = vVar.kd();
        this.u = vVar.getType();
        com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xj = vVar.w().xj();
        this.kd = xj;
        com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xj2 = vVar.hf().xj();
        this.y = xj2;
        com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xj3 = vVar.u().xj();
        this.c = xj3;
        wVar.xj(xj);
        wVar.xj(xj2);
        wVar.xj(xj3);
        xj.xj(this);
        xj2.xj(this);
        xj3.xj(this);
    }

    public v.xj getType() {
        return this.u;
    }

    public com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> hf() {
        return this.kd;
    }

    public boolean kd() {
        return this.hf;
    }

    public com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> u() {
        return this.c;
    }

    public com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> w() {
        return this.y;
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.w
    public void xj(List<w> list, List<w> list2) {
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj.InterfaceC0024xj
    public void xj() {
        for (int i = 0; i < this.w.size(); i++) {
            this.w.get(i).xj();
        }
    }

    public void xj(xj.InterfaceC0024xj interfaceC0024xj) {
        this.w.add(interfaceC0024xj);
    }
}
