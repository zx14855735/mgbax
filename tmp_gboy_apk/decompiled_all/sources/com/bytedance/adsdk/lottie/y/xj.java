package com.bytedance.adsdk.lottie.y;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.bytedance.adsdk.lottie.y;
import com.bytedance.component.sdk.annotation.FloatRange;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj<T> {
    private int am;
    public Float c;
    public PointF d;
    public PointF f;
    private int g;
    public T hf;
    public final Interpolator kd;
    private float p;

    /* renamed from: pl, reason: collision with root package name */
    private float f10064pl;
    private float qt;
    private final y tf;
    public final Interpolator u;
    public final Interpolator w;
    public final T xj;
    public final float y;
    private float zg;

    public xj(y yVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.p = -3987645.8f;
        this.f10064pl = -3987645.8f;
        this.g = 784923401;
        this.am = 784923401;
        this.qt = Float.MIN_VALUE;
        this.zg = Float.MIN_VALUE;
        this.f = null;
        this.d = null;
        this.tf = yVar;
        this.xj = t;
        this.hf = t2;
        this.w = interpolator;
        this.u = null;
        this.kd = null;
        this.y = f;
        this.c = f2;
    }

    public float c() {
        if (this.f10064pl == -3987645.8f) {
            this.f10064pl = ((Float) this.hf).floatValue();
        }
        return this.f10064pl;
    }

    public int d() {
        if (this.am == 784923401) {
            this.am = ((Integer) this.hf).intValue();
        }
        return this.am;
    }

    public int f() {
        if (this.g == 784923401) {
            this.g = ((Integer) this.xj).intValue();
        }
        return this.g;
    }

    public boolean kd() {
        return this.w == null && this.u == null && this.kd == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.xj + ", endValue=" + this.hf + ", startFrame=" + this.y + ", endFrame=" + this.c + ", interpolator=" + this.w + '}';
    }

    public float u() {
        if (this.tf == null) {
            return 1.0f;
        }
        if (this.zg == Float.MIN_VALUE) {
            if (this.c == null) {
                this.zg = 1.0f;
            } else {
                this.zg = ((this.c.floatValue() - this.y) / this.tf.yo()) + w();
            }
        }
        return this.zg;
    }

    public float w() {
        y yVar = this.tf;
        if (yVar == null) {
            return 0.0f;
        }
        if (this.qt == Float.MIN_VALUE) {
            this.qt = (this.y - yVar.y()) / this.tf.yo();
        }
        return this.qt;
    }

    public xj<T> xj(T t, T t2) {
        return new xj<>(t, t2);
    }

    public float y() {
        if (this.p == -3987645.8f) {
            this.p = ((Float) this.xj).floatValue();
        }
        return this.p;
    }

    public boolean xj(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= w() && f < u();
    }

    public xj(y yVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, float f, Float f2) {
        this.p = -3987645.8f;
        this.f10064pl = -3987645.8f;
        this.g = 784923401;
        this.am = 784923401;
        this.qt = Float.MIN_VALUE;
        this.zg = Float.MIN_VALUE;
        this.f = null;
        this.d = null;
        this.tf = yVar;
        this.xj = t;
        this.hf = t2;
        this.w = null;
        this.u = interpolator;
        this.kd = interpolator2;
        this.y = f;
        this.c = f2;
    }

    public xj(y yVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f2) {
        this.p = -3987645.8f;
        this.f10064pl = -3987645.8f;
        this.g = 784923401;
        this.am = 784923401;
        this.qt = Float.MIN_VALUE;
        this.zg = Float.MIN_VALUE;
        this.f = null;
        this.d = null;
        this.tf = yVar;
        this.xj = t;
        this.hf = t2;
        this.w = interpolator;
        this.u = interpolator2;
        this.kd = interpolator3;
        this.y = f;
        this.c = f2;
    }

    public xj(T t) {
        this.p = -3987645.8f;
        this.f10064pl = -3987645.8f;
        this.g = 784923401;
        this.am = 784923401;
        this.qt = Float.MIN_VALUE;
        this.zg = Float.MIN_VALUE;
        this.f = null;
        this.d = null;
        this.tf = null;
        this.xj = t;
        this.hf = t;
        this.w = null;
        this.u = null;
        this.kd = null;
        this.y = Float.MIN_VALUE;
        this.c = Float.valueOf(Float.MAX_VALUE);
    }

    private xj(T t, T t2) {
        this.p = -3987645.8f;
        this.f10064pl = -3987645.8f;
        this.g = 784923401;
        this.am = 784923401;
        this.qt = Float.MIN_VALUE;
        this.zg = Float.MIN_VALUE;
        this.f = null;
        this.d = null;
        this.tf = null;
        this.xj = t;
        this.hf = t2;
        this.w = null;
        this.u = null;
        this.kd = null;
        this.y = Float.MIN_VALUE;
        this.c = Float.valueOf(Float.MAX_VALUE);
    }
}
