package com.bytedance.adsdk.lottie.xj.xj;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.model.hf.v;
import com.bytedance.adsdk.lottie.xj.hf.xj;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class qt implements xj.InterfaceC0024xj, g, p {
    private final com.bytedance.adsdk.lottie.xj.hf.xj<?, PointF> c;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> f;
    private final com.bytedance.adsdk.lottie.f kd;
    private boolean p;
    private final boolean u;
    private final String w;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<?, PointF> y;
    private final Path xj = new Path();
    private final RectF hf = new RectF();
    private final hf d = new hf();
    private com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> tf = null;

    public qt(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.model.layer.w wVar, com.bytedance.adsdk.lottie.model.hf.p pVar) {
        this.w = pVar.xj();
        this.u = pVar.kd();
        this.kd = fVar;
        com.bytedance.adsdk.lottie.xj.hf.xj<PointF, PointF> xj = pVar.u().xj();
        this.y = xj;
        com.bytedance.adsdk.lottie.xj.hf.xj<PointF, PointF> xj2 = pVar.w().xj();
        this.c = xj2;
        com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xj3 = pVar.hf().xj();
        this.f = xj3;
        wVar.xj(xj);
        wVar.xj(xj2);
        wVar.xj(xj3);
        xj.xj(this);
        xj2.xj(this);
        xj3.xj(this);
    }

    private void hf() {
        this.p = false;
        this.kd.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.g
    public Path u() {
        com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xjVar;
        if (this.p) {
            return this.xj;
        }
        this.xj.reset();
        if (this.u) {
            this.p = true;
            return this.xj;
        }
        PointF c = this.c.c();
        float f = c.x / 2.0f;
        float f2 = c.y / 2.0f;
        com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> xjVar2 = this.f;
        float d = xjVar2 == null ? 0.0f : ((com.bytedance.adsdk.lottie.xj.hf.u) xjVar2).d();
        if (d == 0.0f && (xjVar = this.tf) != null) {
            d = Math.min(xjVar.c().floatValue(), Math.min(f, f2));
        }
        float min = Math.min(f, f2);
        if (d > min) {
            d = min;
        }
        PointF c2 = this.y.c();
        this.xj.moveTo(c2.x + f, (c2.y - f2) + d);
        this.xj.lineTo(c2.x + f, (c2.y + f2) - d);
        if (d > 0.0f) {
            RectF rectF = this.hf;
            float f3 = c2.x;
            float f4 = d * 2.0f;
            float f5 = c2.y;
            rectF.set((f3 + f) - f4, (f5 + f2) - f4, f3 + f, f5 + f2);
            this.xj.arcTo(this.hf, 0.0f, 90.0f, false);
        }
        this.xj.lineTo((c2.x - f) + d, c2.y + f2);
        if (d > 0.0f) {
            RectF rectF2 = this.hf;
            float f6 = c2.x;
            float f7 = c2.y;
            float f8 = d * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (f6 - f) + f8, f7 + f2);
            this.xj.arcTo(this.hf, 90.0f, 90.0f, false);
        }
        this.xj.lineTo(c2.x - f, (c2.y - f2) + d);
        if (d > 0.0f) {
            RectF rectF3 = this.hf;
            float f9 = c2.x;
            float f10 = c2.y;
            float f11 = d * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f9 - f) + f11, (f10 - f2) + f11);
            this.xj.arcTo(this.hf, 180.0f, 90.0f, false);
        }
        this.xj.lineTo((c2.x + f) - d, c2.y - f2);
        if (d > 0.0f) {
            RectF rectF4 = this.hf;
            float f12 = c2.x;
            float f13 = d * 2.0f;
            float f14 = c2.y;
            rectF4.set((f12 + f) - f13, f14 - f2, f12 + f, (f14 - f2) + f13);
            this.xj.arcTo(this.hf, 270.0f, 90.0f, false);
        }
        this.xj.close();
        this.d.xj(this.xj);
        this.p = true;
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
                    this.d.xj(pzVar);
                    pzVar.xj(this);
                }
            }
            if (wVar instanceof e) {
                this.tf = ((e) wVar).hf();
            }
        }
    }
}
