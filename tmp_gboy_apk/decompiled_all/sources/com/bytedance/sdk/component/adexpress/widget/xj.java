package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements Interpolator {
    protected PointF hf;
    protected PointF kd;
    protected PointF u;
    protected PointF w;
    protected PointF xj;

    public xj(PointF pointF, PointF pointF2) {
        this.w = new PointF();
        this.u = new PointF();
        this.kd = new PointF();
        float f = pointF.x;
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        float f2 = pointF2.x;
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        this.xj = pointF;
        this.hf = pointF2;
    }

    private float u(float f) {
        PointF pointF = this.kd;
        PointF pointF2 = this.xj;
        float f2 = pointF2.x * 3.0f;
        pointF.x = f2;
        PointF pointF3 = this.u;
        float f3 = ((this.hf.x - pointF2.x) * 3.0f) - f2;
        pointF3.x = f3;
        PointF pointF4 = this.w;
        float f4 = (1.0f - pointF.x) - f3;
        pointF4.x = f4;
        return ((((f4 * f) + pointF3.x) * f) + pointF.x) * f;
    }

    private float w(float f) {
        return (((this.w.x * 3.0f * f) + (this.u.x * 2.0f)) * f) + this.kd.x;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return xj(hf(f));
    }

    public float hf(float f) {
        float f2 = f;
        for (int i = 1; i < 14; i++) {
            float u = u(f2) - f;
            if (Math.abs(u) < 0.001d) {
                break;
            }
            f2 -= u / w(f2);
        }
        return f2;
    }

    public float xj(float f) {
        PointF pointF = this.kd;
        PointF pointF2 = this.xj;
        float f2 = pointF2.y * 3.0f;
        pointF.y = f2;
        PointF pointF3 = this.u;
        float f3 = ((this.hf.y - pointF2.y) * 3.0f) - f2;
        pointF3.y = f3;
        PointF pointF4 = this.w;
        float f4 = (1.0f - pointF.y) - f3;
        pointF4.y = f4;
        return ((((f4 * f) + pointF3.y) * f) + pointF.y) * f;
    }

    public xj(float f, float f2, float f3, float f4) {
        this(new PointF(f, f2), new PointF(f3, f4));
    }
}
