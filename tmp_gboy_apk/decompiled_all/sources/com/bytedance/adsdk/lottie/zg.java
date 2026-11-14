package com.bytedance.adsdk.lottie;

import ADYaiT.CtFAbx;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class zg implements Interpolator {
    private final float[] hf;
    private final float[] xj;

    public zg(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = (int) (length / 0.002f);
        int i2 = i + 1;
        this.xj = new float[i2];
        this.hf = new float[i2];
        float[] fArr = new float[2];
        for (int i3 = 0; i3 < i2; i3++) {
            pathMeasure.getPosTan((i3 * length) / i, fArr, null);
            this.xj[i3] = fArr[0];
            this.hf[i3] = fArr[1];
        }
    }

    private static Path xj(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.xj.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.xj[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.xj;
        float f2 = fArr[length];
        float f3 = fArr[i];
        float f4 = f2 - f3;
        if (f4 == 0.0f) {
            return this.hf[i];
        }
        float f5 = (f - f3) / f4;
        float[] fArr2 = this.hf;
        float f6 = fArr2[i];
        return CtFAbx.A4TApA(fArr2[length], f6, f5, f6);
    }

    public zg(float f, float f2, float f3, float f4) {
        this(xj(f, f2, f3, f4));
    }
}
