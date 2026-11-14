package COJEAR;

import android.view.WindowInsetsAnimation;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class EPdU4G extends EQurEW {
    public final WindowInsetsAnimation AMqCpz;

    public EPdU4G(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.AMqCpz = windowInsetsAnimation;
    }

    @Override // COJEAR.EQurEW
    public final long A2egSU() {
        long durationMillis;
        durationMillis = this.AMqCpz.getDurationMillis();
        return durationMillis;
    }

    @Override // COJEAR.EQurEW
    public final float A4TApA() {
        float interpolatedFraction;
        interpolatedFraction = this.AMqCpz.getInterpolatedFraction();
        return interpolatedFraction;
    }

    @Override // COJEAR.EQurEW
    public final int A5SV6n() {
        int typeMask;
        typeMask = this.AMqCpz.getTypeMask();
        return typeMask;
    }

    @Override // COJEAR.EQurEW
    public final void ADYaiT(float f) {
        this.AMqCpz.setFraction(f);
    }
}
