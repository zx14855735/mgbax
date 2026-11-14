package com.bytedance.adsdk.lottie.xj.xj;

import ADYaiT.CtFAbx;
import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.model.hf.tf;
import com.bytedance.adsdk.lottie.model.hf.v;
import com.bytedance.adsdk.lottie.xj.hf.xj;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class am implements xj.InterfaceC0024xj, g, p {
    private final com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> c;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> d;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<?, PointF> f;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> g;
    private final String hf;
    private final boolean kd;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> p;

    /* renamed from: pl, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> f10058pl;
    private boolean qt;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> tf;
    private final tf.xj u;
    private final com.bytedance.adsdk.lottie.f w;
    private final boolean y;
    private final Path xj = new Path();
    private final hf am = new hf();

    /* renamed from: com.bytedance.adsdk.lottie.xj.xj.am$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[tf.xj.values().length];
            xj = iArr;
            try {
                iArr[tf.xj.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xj[tf.xj.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public am(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.model.layer.w wVar, com.bytedance.adsdk.lottie.model.hf.tf tfVar) {
        this.w = fVar;
        this.hf = tfVar.xj();
        tf.xj type = tfVar.getType();
        this.u = type;
        this.kd = tfVar.d();
        this.y = tfVar.tf();
        com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xj = tfVar.hf().xj();
        this.c = xj;
        com.bytedance.adsdk.lottie.xj.hf.xj<PointF, PointF> xj2 = tfVar.w().xj();
        this.f = xj2;
        com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xj3 = tfVar.u().xj();
        this.d = xj3;
        com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xj4 = tfVar.y().xj();
        this.p = xj4;
        com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xj5 = tfVar.f().xj();
        this.g = xj5;
        tf.xj xjVar = tf.xj.STAR;
        if (type == xjVar) {
            this.tf = tfVar.kd().xj();
            this.f10058pl = tfVar.c().xj();
        } else {
            this.tf = null;
            this.f10058pl = null;
        }
        wVar.xj(xj);
        wVar.xj(xj2);
        wVar.xj(xj3);
        wVar.xj(xj4);
        wVar.xj(xj5);
        if (type == xjVar) {
            wVar.xj(this.tf);
            wVar.xj(this.f10058pl);
        }
        xj.xj(this);
        xj2.xj(this);
        xj3.xj(this);
        xj4.xj(this);
        xj5.xj(this);
        if (type == xjVar) {
            this.tf.xj(this);
            this.f10058pl.xj(this);
        }
    }

    private void hf() {
        this.qt = false;
        this.w.invalidateSelf();
    }

    private void kd() {
        double d;
        int floor = (int) Math.floor(this.c.c().floatValue());
        double radians = Math.toRadians((this.d == null ? 0.0d : r2.c().floatValue()) - 90.0d);
        double d2 = floor;
        float floatValue = this.g.c().floatValue() / 100.0f;
        float floatValue2 = this.p.c().floatValue();
        double d3 = floatValue2;
        float cos = (float) (Math.cos(radians) * d3);
        float sin = (float) (Math.sin(radians) * d3);
        this.xj.moveTo(cos, sin);
        double d4 = (float) (6.283185307179586d / d2);
        double d5 = radians + d4;
        double ceil = Math.ceil(d2);
        int i = 0;
        while (i < ceil) {
            float cos2 = (float) (Math.cos(d5) * d3);
            int i2 = i;
            double d6 = d5;
            float sin2 = (float) (Math.sin(d5) * d3);
            if (floatValue != 0.0f) {
                d = ceil;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f = floatValue2 * floatValue * 0.25f;
                this.xj.cubicTo(cos - (f * cos3), sin - (f * sin3), cos2 + (((float) Math.cos(atan22)) * f), sin2 + (f * ((float) Math.sin(atan22))), cos2, sin2);
                cos = cos2;
                sin = sin2;
            } else {
                sin = sin2;
                d = ceil;
                cos = cos2;
                this.xj.lineTo(cos, sin);
            }
            d5 = d6 + d4;
            i = i2 + 1;
            ceil = d;
        }
        PointF c = this.f.c();
        this.xj.offset(c.x, c.y);
        this.xj.close();
    }

    private void w() {
        int i;
        float f;
        float f2;
        float cos;
        float sin;
        float f3;
        float f4;
        double d;
        float f5;
        int i2;
        float f6;
        double d2;
        float f7;
        float f8;
        double d3;
        float f9;
        float f10;
        float floatValue = this.c.c().floatValue();
        double radians = Math.toRadians((this.d == null ? 0.0d : r2.c().floatValue()) - 90.0d);
        double d4 = floatValue;
        float f11 = (float) (6.283185307179586d / d4);
        if (this.y) {
            f11 *= -1.0f;
        }
        float f12 = f11 / 2.0f;
        float f13 = floatValue - ((int) floatValue);
        int i3 = (f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            radians += (1.0f - f13) * f12;
        }
        float floatValue2 = this.p.c().floatValue();
        float floatValue3 = this.tf.c().floatValue();
        com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> xjVar = this.f10058pl;
        float floatValue4 = xjVar != null ? xjVar.c().floatValue() / 100.0f : 0.0f;
        com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> xjVar2 = this.g;
        float floatValue5 = xjVar2 != null ? xjVar2.c().floatValue() / 100.0f : 0.0f;
        if (i3 != 0) {
            f5 = CtFAbx.A4TApA(floatValue2, floatValue3, f13, floatValue3);
            i = i3;
            f = 0.0f;
            double d5 = f5;
            f2 = 2.0f;
            float cos2 = (float) (Math.cos(radians) * d5);
            sin = (float) (Math.sin(radians) * d5);
            this.xj.moveTo(cos2, sin);
            d = radians + ((f11 * f13) / 2.0f);
            f3 = f13;
            cos = cos2;
            f4 = f12;
        } else {
            i = i3;
            f = 0.0f;
            f2 = 2.0f;
            double d6 = floatValue2;
            cos = (float) (Math.cos(radians) * d6);
            sin = (float) (d6 * Math.sin(radians));
            this.xj.moveTo(cos, sin);
            f3 = f13;
            f4 = f12;
            d = radians + f4;
            f5 = 0.0f;
        }
        double ceil = Math.ceil(d4) * 2.0d;
        int i4 = 0;
        boolean z = false;
        double d7 = d;
        float f14 = sin;
        float f15 = cos;
        double d8 = d7;
        while (true) {
            double d9 = i4;
            if (d9 >= ceil) {
                PointF c = this.f.c();
                this.xj.offset(c.x, c.y);
                this.xj.close();
                return;
            }
            float f16 = z ? floatValue2 : floatValue3;
            if (f5 == f || d9 != ceil - 2.0d) {
                i2 = i4;
                f6 = f4;
            } else {
                i2 = i4;
                f6 = (f11 * f3) / f2;
            }
            if (f5 == f || d9 != ceil - 1.0d) {
                d2 = d9;
                f7 = f16;
            } else {
                d2 = d9;
                f7 = f5;
            }
            double d10 = f7;
            float cos3 = (float) (Math.cos(d8) * d10);
            float f17 = f11;
            float sin2 = (float) (Math.sin(d8) * d10);
            if (floatValue4 == f && floatValue5 == f) {
                this.xj.lineTo(cos3, sin2);
                f10 = cos3;
                f9 = sin2;
                f8 = f4;
                d3 = d8;
            } else {
                f8 = f4;
                d3 = d8;
                double atan2 = (float) (Math.atan2(f14, f15) - 1.5707963267948966d);
                float cos4 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                float f18 = f15;
                float f19 = f14;
                f9 = sin2;
                double atan22 = (float) (Math.atan2(sin2, cos3) - 1.5707963267948966d);
                float cos5 = (float) Math.cos(atan22);
                float sin4 = (float) Math.sin(atan22);
                float f20 = z ? floatValue4 : floatValue5;
                float f21 = z ? floatValue5 : floatValue4;
                float f22 = (z ? floatValue3 : floatValue2) * f20 * 0.47829f;
                float f23 = cos4 * f22;
                float f24 = f22 * sin3;
                float f25 = (z ? floatValue2 : floatValue3) * f21 * 0.47829f;
                float f26 = cos5 * f25;
                float f27 = f25 * sin4;
                if (i != 0) {
                    if (i2 == 0) {
                        f23 *= f3;
                        f24 *= f3;
                    } else if (d2 == ceil - 1.0d) {
                        f26 *= f3;
                        f27 *= f3;
                    }
                }
                f10 = cos3;
                this.xj.cubicTo(f18 - f23, f19 - f24, cos3 + f26, f9 + f27, f10, f9);
            }
            d8 = d3 + f6;
            z = !z;
            i4 = i2 + 1;
            f4 = f8;
            f15 = f10;
            f14 = f9;
            f11 = f17;
        }
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.g
    public Path u() {
        if (this.qt) {
            return this.xj;
        }
        this.xj.reset();
        if (this.kd) {
            this.qt = true;
            return this.xj;
        }
        int i = AnonymousClass1.xj[this.u.ordinal()];
        if (i == 1) {
            w();
        } else if (i == 2) {
            kd();
        }
        this.xj.close();
        this.am.xj(this.xj);
        this.qt = true;
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
                    this.am.xj(pzVar);
                    pzVar.xj(this);
                }
            }
        }
    }
}
