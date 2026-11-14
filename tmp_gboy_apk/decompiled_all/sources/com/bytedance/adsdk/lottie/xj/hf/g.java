package com.bytedance.adsdk.lottie.xj.hf;

import android.graphics.Path;
import com.bytedance.adsdk.lottie.xj.xj.v;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class g extends xj<com.bytedance.adsdk.lottie.model.hf.am, Path> {
    private final Path kd;
    private final com.bytedance.adsdk.lottie.model.hf.am u;
    private List<v> y;

    public g(List<com.bytedance.adsdk.lottie.y.xj<com.bytedance.adsdk.lottie.model.hf.am>> list) {
        super(list);
        this.u = new com.bytedance.adsdk.lottie.model.hf.am();
        this.kd = new Path();
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public Path xj(com.bytedance.adsdk.lottie.y.xj<com.bytedance.adsdk.lottie.model.hf.am> xjVar, float f) {
        this.u.xj(xjVar.xj, xjVar.hf, f);
        com.bytedance.adsdk.lottie.model.hf.am amVar = this.u;
        List<v> list = this.y;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                amVar = this.y.get(size).xj(amVar);
            }
        }
        com.bytedance.adsdk.lottie.kd.f.xj(amVar, this.kd);
        return this.kd;
    }

    public void xj(List<v> list) {
        this.y = list;
    }
}
