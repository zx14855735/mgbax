package COJEAR;

import android.view.animation.Interpolator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class EQurEW {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f1712A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public float f1713A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Interpolator f1714A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final long f1715ADYaiT;

    public EQurEW(int i, Interpolator interpolator, long j) {
        this.f1712A2egSU = i;
        this.f1714A5SV6n = interpolator;
        this.f1715ADYaiT = j;
    }

    public long A2egSU() {
        return this.f1715ADYaiT;
    }

    public float A4TApA() {
        Interpolator interpolator = this.f1714A5SV6n;
        return interpolator != null ? interpolator.getInterpolation(this.f1713A4TApA) : this.f1713A4TApA;
    }

    public int A5SV6n() {
        return this.f1712A2egSU;
    }

    public void ADYaiT(float f) {
        this.f1713A4TApA = f;
    }
}
