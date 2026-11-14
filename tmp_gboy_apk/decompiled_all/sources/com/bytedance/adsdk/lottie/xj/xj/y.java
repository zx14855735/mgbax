package com.bytedance.adsdk.lottie.xj.xj;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.model.hf.v;
import com.bytedance.adsdk.lottie.xj.hf.xj;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y implements xj.InterfaceC0024xj, g, p {
    private boolean f;
    private final String hf;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<?, PointF> kd;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<?, PointF> u;
    private final com.bytedance.adsdk.lottie.f w;
    private final com.bytedance.adsdk.lottie.model.hf.hf y;
    private final Path xj = new Path();
    private final hf c = new hf();

    public y(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.model.layer.w wVar, com.bytedance.adsdk.lottie.model.hf.hf hfVar) {
        this.hf = hfVar.xj();
        this.w = fVar;
        com.bytedance.adsdk.lottie.xj.hf.xj<PointF, PointF> xj = hfVar.w().xj();
        this.u = xj;
        com.bytedance.adsdk.lottie.xj.hf.xj<PointF, PointF> xj2 = hfVar.hf().xj();
        this.kd = xj2;
        this.y = hfVar;
        wVar.xj(xj);
        wVar.xj(xj2);
        xj.xj(this);
        xj2.xj(this);
    }

    private void hf() {
        this.f = false;
        this.w.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.g
    public Path u() {
        if (this.f) {
            return this.xj;
        }
        this.xj.reset();
        if (this.y.kd()) {
            this.f = true;
            return this.xj;
        }
        PointF c = this.u.c();
        float f = c.x / 2.0f;
        float f2 = c.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.xj.reset();
        if (this.y.u()) {
            float f5 = -f2;
            this.xj.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.xj.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.xj.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.xj.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.xj.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.xj.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.xj.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.xj.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.xj.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.xj.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF c2 = this.kd.c();
        this.xj.offset(c2.x, c2.y);
        this.xj.close();
        this.c.xj(this.xj);
        this.f = true;
        return this.xj;
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj.InterfaceC0024xj
    public void xj() {
        hf();
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.w
    public void xj(List<w> list, List<w> list2) {
        for (int i = 0; i < list.size(); i++) {
            w wVar = list.get(i);
            if (wVar instanceof pz) {
                pz pzVar = (pz) wVar;
                if (pzVar.getType() == v.xj.SIMULTANEOUSLY) {
                    this.c.xj(pzVar);
                    pzVar.xj(this);
                }
            }
        }
    }
}
