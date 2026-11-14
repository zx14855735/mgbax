package LSQ6IS;

import com.sigmob.sdk.base.views.r;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends A4TApA {
    public boolean AMqCpz;

    @Override // LSQ6IS.A4TApA
    public final int A2egSU(float f, float f2) {
        int i = 16;
        if (this.AMqCpz) {
            if (Math.abs(f) >= Math.abs(f2)) {
                return f < 0.0f ? 32 : 16;
            }
            if (f2 < 0.0f) {
                return r.b.d;
            }
            return 64;
        }
        if (f < -0.33333334f) {
            i = 32;
        } else if (f <= 0.33333334f) {
            i = 0;
        }
        return f2 < -0.33333334f ? i | r.b.d : f2 > 0.33333334f ? i | 64 : i;
    }
}
