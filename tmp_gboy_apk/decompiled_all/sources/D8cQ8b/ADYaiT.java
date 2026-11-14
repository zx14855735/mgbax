package D8cQ8b;

import ADYaiT.CtFAbx;
import android.view.animation.Interpolator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ADYaiT implements Interpolator {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final float[] f2049A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final float f2050A4TApA;

    public ADYaiT(float[] fArr) {
        this.f2049A2egSU = fArr;
        this.f2050A4TApA = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f2049A2egSU;
        int min = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f2 = this.f2050A4TApA;
        float f3 = (f - (min * f2)) / f2;
        float f4 = fArr[min];
        return CtFAbx.A4TApA(fArr[min + 1], f4, f3, f4);
    }
}
