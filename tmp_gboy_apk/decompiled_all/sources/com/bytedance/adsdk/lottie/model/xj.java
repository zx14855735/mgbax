package com.bytedance.adsdk.lottie.model;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import com.bytedance.component.sdk.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private final PointF hf;
    private final PointF w;
    private final PointF xj;

    public xj() {
        this.xj = new PointF();
        this.hf = new PointF();
        this.w = new PointF();
    }

    public void hf(float f, float f2) {
        this.hf.set(f, f2);
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.w.x), Float.valueOf(this.w.y), Float.valueOf(this.xj.x), Float.valueOf(this.xj.y), Float.valueOf(this.hf.x), Float.valueOf(this.hf.y));
    }

    public void w(float f, float f2) {
        this.w.set(f, f2);
    }

    public void xj(float f, float f2) {
        this.xj.set(f, f2);
    }

    public PointF hf() {
        return this.hf;
    }

    public PointF w() {
        return this.w;
    }

    public PointF xj() {
        return this.xj;
    }

    public xj(PointF pointF, PointF pointF2, PointF pointF3) {
        this.xj = pointF;
        this.hf = pointF2;
        this.w = pointF3;
    }
}
