package ARc23Z;

import android.animation.TimeInterpolator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT implements TimeInterpolator {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int[] f280A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f281A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f282A5SV6n;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        int i = (int) ((f * this.f282A5SV6n) + 0.5f);
        int i2 = this.f281A4TApA;
        int[] iArr = this.f280A2egSU;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = iArr[i3];
            if (i < i4) {
                break;
            }
            i -= i4;
            i3++;
        }
        return (i3 / i2) + (i3 < i2 ? i / this.f282A5SV6n : 0.0f);
    }
}
