package Oay4Bh;

import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BNL6CD implements TimeInterpolator {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Interpolator f6575A2egSU;

    public BNL6CD(Interpolator interpolator) {
        this.f6575A2egSU = interpolator;
    }

    public static TimeInterpolator A2egSU(boolean z, Interpolator interpolator) {
        return z ? interpolator : new BNL6CD(interpolator);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        return 1.0f - this.f6575A2egSU.getInterpolation(f);
    }
}
