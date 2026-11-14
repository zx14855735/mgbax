package com.bytedance.adsdk.lottie.xj.hf;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.xj.hf.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class zg {
    private xj<?, Float> am;
    private xj<?, PointF> c;
    private xj<Float, Float> d;
    private xj<com.bytedance.adsdk.lottie.y.u, com.bytedance.adsdk.lottie.y.u> f;
    private xj<?, Float> g;
    private final Matrix hf;
    private final float[] kd;
    private u p;

    /* renamed from: pl, reason: collision with root package name */
    private u f10057pl;
    private xj<Integer, Integer> tf;
    private final Matrix u;
    private final Matrix w;
    private final Matrix xj = new Matrix();
    private xj<PointF, PointF> y;

    public zg(com.bytedance.adsdk.lottie.model.xj.pl plVar) {
        this.y = plVar.xj() == null ? null : plVar.xj().xj();
        this.c = plVar.hf() == null ? null : plVar.hf().xj();
        this.f = plVar.w() == null ? null : plVar.w().xj();
        this.d = plVar.u() == null ? null : plVar.u().xj();
        u uVar = plVar.f() == null ? null : (u) plVar.f().xj();
        this.p = uVar;
        if (uVar != null) {
            this.hf = new Matrix();
            this.w = new Matrix();
            this.u = new Matrix();
            this.kd = new float[9];
        } else {
            this.hf = null;
            this.w = null;
            this.u = null;
            this.kd = null;
        }
        this.f10057pl = plVar.d() == null ? null : (u) plVar.d().xj();
        if (plVar.kd() != null) {
            this.tf = plVar.kd().xj();
        }
        if (plVar.y() != null) {
            this.g = plVar.y().xj();
        } else {
            this.g = null;
        }
        if (plVar.c() != null) {
            this.am = plVar.c().xj();
        } else {
            this.am = null;
        }
    }

    private void kd() {
        for (int i = 0; i < 9; i++) {
            this.kd[i] = 0.0f;
        }
    }

    public xj<?, Float> hf() {
        return this.g;
    }

    public Matrix u() {
        PointF c;
        PointF c2;
        this.xj.reset();
        xj<?, PointF> xjVar = this.c;
        if (xjVar != null && (c2 = xjVar.c()) != null) {
            float f = c2.x;
            if (f != 0.0f || c2.y != 0.0f) {
                this.xj.preTranslate(f, c2.y);
            }
        }
        xj<Float, Float> xjVar2 = this.d;
        if (xjVar2 != null) {
            float floatValue = xjVar2 instanceof e ? xjVar2.c().floatValue() : ((u) xjVar2).d();
            if (floatValue != 0.0f) {
                this.xj.preRotate(floatValue);
            }
        }
        if (this.p != null) {
            float cos = this.f10057pl == null ? 0.0f : (float) Math.cos(Math.toRadians((-r3.d()) + 90.0f));
            float sin = this.f10057pl == null ? 1.0f : (float) Math.sin(Math.toRadians((-r5.d()) + 90.0f));
            float tan = (float) Math.tan(Math.toRadians(r0.d()));
            kd();
            float[] fArr = this.kd;
            fArr[0] = cos;
            fArr[1] = sin;
            float f2 = -sin;
            fArr[3] = f2;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.hf.setValues(fArr);
            kd();
            float[] fArr2 = this.kd;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.w.setValues(fArr2);
            kd();
            float[] fArr3 = this.kd;
            fArr3[0] = cos;
            fArr3[1] = f2;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.u.setValues(fArr3);
            this.w.preConcat(this.hf);
            this.u.preConcat(this.w);
            this.xj.preConcat(this.u);
        }
        xj<com.bytedance.adsdk.lottie.y.u, com.bytedance.adsdk.lottie.y.u> xjVar3 = this.f;
        if (xjVar3 != null) {
            com.bytedance.adsdk.lottie.y.u c3 = xjVar3.c();
            if (c3.xj() != 1.0f || c3.hf() != 1.0f) {
                this.xj.preScale(c3.xj(), c3.hf());
            }
        }
        xj<PointF, PointF> xjVar4 = this.y;
        if (xjVar4 != null && (((c = xjVar4.c()) != null && c.x != 0.0f) || c.y != 0.0f)) {
            this.xj.preTranslate(-c.x, -c.y);
        }
        return this.xj;
    }

    public xj<?, Float> w() {
        return this.am;
    }

    public void xj(com.bytedance.adsdk.lottie.model.layer.w wVar) {
        wVar.xj(this.tf);
        wVar.xj(this.g);
        wVar.xj(this.am);
        wVar.xj(this.y);
        wVar.xj(this.c);
        wVar.xj(this.f);
        wVar.xj(this.d);
        wVar.xj(this.p);
        wVar.xj(this.f10057pl);
    }

    public Matrix hf(float f) {
        xj<?, PointF> xjVar = this.c;
        PointF c = xjVar == null ? null : xjVar.c();
        xj<com.bytedance.adsdk.lottie.y.u, com.bytedance.adsdk.lottie.y.u> xjVar2 = this.f;
        com.bytedance.adsdk.lottie.y.u c2 = xjVar2 == null ? null : xjVar2.c();
        this.xj.reset();
        if (c != null) {
            this.xj.preTranslate(c.x * f, c.y * f);
        }
        if (c2 != null) {
            double d = f;
            this.xj.preScale((float) Math.pow(c2.xj(), d), (float) Math.pow(c2.hf(), d));
        }
        xj<Float, Float> xjVar3 = this.d;
        if (xjVar3 != null) {
            float floatValue = xjVar3.c().floatValue();
            xj<PointF, PointF> xjVar4 = this.y;
            PointF c3 = xjVar4 != null ? xjVar4.c() : null;
            this.xj.preRotate(floatValue * f, c3 == null ? 0.0f : c3.x, c3 != null ? c3.y : 0.0f);
        }
        return this.xj;
    }

    public void xj(xj.InterfaceC0024xj interfaceC0024xj) {
        xj<Integer, Integer> xjVar = this.tf;
        if (xjVar != null) {
            xjVar.xj(interfaceC0024xj);
        }
        xj<?, Float> xjVar2 = this.g;
        if (xjVar2 != null) {
            xjVar2.xj(interfaceC0024xj);
        }
        xj<?, Float> xjVar3 = this.am;
        if (xjVar3 != null) {
            xjVar3.xj(interfaceC0024xj);
        }
        xj<PointF, PointF> xjVar4 = this.y;
        if (xjVar4 != null) {
            xjVar4.xj(interfaceC0024xj);
        }
        xj<?, PointF> xjVar5 = this.c;
        if (xjVar5 != null) {
            xjVar5.xj(interfaceC0024xj);
        }
        xj<com.bytedance.adsdk.lottie.y.u, com.bytedance.adsdk.lottie.y.u> xjVar6 = this.f;
        if (xjVar6 != null) {
            xjVar6.xj(interfaceC0024xj);
        }
        xj<Float, Float> xjVar7 = this.d;
        if (xjVar7 != null) {
            xjVar7.xj(interfaceC0024xj);
        }
        u uVar = this.p;
        if (uVar != null) {
            uVar.xj(interfaceC0024xj);
        }
        u uVar2 = this.f10057pl;
        if (uVar2 != null) {
            uVar2.xj(interfaceC0024xj);
        }
    }

    public void xj(float f) {
        xj<Integer, Integer> xjVar = this.tf;
        if (xjVar != null) {
            xjVar.xj(f);
        }
        xj<?, Float> xjVar2 = this.g;
        if (xjVar2 != null) {
            xjVar2.xj(f);
        }
        xj<?, Float> xjVar3 = this.am;
        if (xjVar3 != null) {
            xjVar3.xj(f);
        }
        xj<PointF, PointF> xjVar4 = this.y;
        if (xjVar4 != null) {
            xjVar4.xj(f);
        }
        xj<?, PointF> xjVar5 = this.c;
        if (xjVar5 != null) {
            xjVar5.xj(f);
        }
        xj<com.bytedance.adsdk.lottie.y.u, com.bytedance.adsdk.lottie.y.u> xjVar6 = this.f;
        if (xjVar6 != null) {
            xjVar6.xj(f);
        }
        xj<Float, Float> xjVar7 = this.d;
        if (xjVar7 != null) {
            xjVar7.xj(f);
        }
        u uVar = this.p;
        if (uVar != null) {
            uVar.xj(f);
        }
        u uVar2 = this.f10057pl;
        if (uVar2 != null) {
            uVar2.xj(f);
        }
    }

    public xj<?, Integer> xj() {
        return this.tf;
    }
}
