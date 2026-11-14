package com.bytedance.adsdk.lottie.xj.xj;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d extends xj {
    private com.bytedance.adsdk.lottie.xj.hf.e am;
    private final LongSparseArray<RadialGradient> c;
    private final com.bytedance.adsdk.lottie.model.hf.c d;
    private final RectF f;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<PointF, PointF> g;
    private final boolean kd;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<com.bytedance.adsdk.lottie.model.hf.u, com.bytedance.adsdk.lottie.model.hf.u> p;

    /* renamed from: pl, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xj.hf.xj<PointF, PointF> f10060pl;
    private final int tf;
    private final String u;
    private final LongSparseArray<LinearGradient> y;

    public d(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.model.layer.w wVar, com.bytedance.adsdk.lottie.model.hf.y yVar) {
        super(fVar, wVar, yVar.f().xj(), yVar.d().xj(), yVar.pl(), yVar.u(), yVar.c(), yVar.tf(), yVar.p());
        this.y = new LongSparseArray<>();
        this.c = new LongSparseArray<>();
        this.f = new RectF();
        this.u = yVar.xj();
        this.d = yVar.hf();
        this.kd = yVar.g();
        this.tf = (int) (fVar.x().kd() / 32.0f);
        com.bytedance.adsdk.lottie.xj.hf.xj<com.bytedance.adsdk.lottie.model.hf.u, com.bytedance.adsdk.lottie.model.hf.u> xj = yVar.w().xj();
        this.p = xj;
        xj.xj(this);
        wVar.xj(xj);
        com.bytedance.adsdk.lottie.xj.hf.xj<PointF, PointF> xj2 = yVar.kd().xj();
        this.f10060pl = xj2;
        xj2.xj(this);
        wVar.xj(xj2);
        com.bytedance.adsdk.lottie.xj.hf.xj<PointF, PointF> xj3 = yVar.y().xj();
        this.g = xj3;
        xj3.xj(this);
        wVar.xj(xj3);
    }

    private LinearGradient hf() {
        long u = u();
        LinearGradient linearGradient = this.y.get(u);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF c = this.f10060pl.c();
        PointF c2 = this.g.c();
        com.bytedance.adsdk.lottie.model.hf.u c3 = this.p.c();
        LinearGradient linearGradient2 = new LinearGradient(c.x, c.y, c2.x, c2.y, xj(c3.hf()), c3.xj(), Shader.TileMode.CLAMP);
        this.y.put(u, linearGradient2);
        return linearGradient2;
    }

    private int u() {
        int round = Math.round(this.f10060pl.f() * this.tf);
        int round2 = Math.round(this.g.f() * this.tf);
        int round3 = Math.round(this.p.f() * this.tf);
        int i = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    private RadialGradient w() {
        long u = u();
        RadialGradient radialGradient = this.c.get(u);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF c = this.f10060pl.c();
        PointF c2 = this.g.c();
        com.bytedance.adsdk.lottie.model.hf.u c3 = this.p.c();
        int[] xj = xj(c3.hf());
        float[] xj2 = c3.xj();
        RadialGradient radialGradient2 = new RadialGradient(c.x, c.y, (float) Math.hypot(c2.x - r7, c2.y - r8), xj, xj2, Shader.TileMode.CLAMP);
        this.c.put(u, radialGradient2);
        return radialGradient2;
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.xj, com.bytedance.adsdk.lottie.xj.xj.kd
    public void xj(Canvas canvas, Matrix matrix, int i) {
        if (this.kd) {
            return;
        }
        xj(this.f, matrix, false);
        Shader hf = this.d == com.bytedance.adsdk.lottie.model.hf.c.LINEAR ? hf() : w();
        hf.setLocalMatrix(matrix);
        this.hf.setShader(hf);
        super.xj(canvas, matrix, i);
    }

    private int[] xj(int[] iArr) {
        com.bytedance.adsdk.lottie.xj.hf.e eVar = this.am;
        if (eVar != null) {
            Integer[] numArr = (Integer[]) eVar.c();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }
}
