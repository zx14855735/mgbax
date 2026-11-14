package androidx.activity;

import android.window.BackEvent;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final float f7935A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final float f7936A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final float f7937A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final int f7938ADYaiT;

    public A4TApA(BackEvent backEvent) {
        RXb0Sz.ARc23Z.AMqCpz(backEvent, "backEvent");
        A2egSU a2egSU = A2egSU.f7934A2egSU;
        float ADYaiT2 = a2egSU.ADYaiT(backEvent);
        float AMqCpz = a2egSU.AMqCpz(backEvent);
        float A4TApA2 = a2egSU.A4TApA(backEvent);
        int A5SV6n2 = a2egSU.A5SV6n(backEvent);
        this.f7935A2egSU = ADYaiT2;
        this.f7936A4TApA = AMqCpz;
        this.f7937A5SV6n = A4TApA2;
        this.f7938ADYaiT = A5SV6n2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BackEventCompat{touchX=");
        sb.append(this.f7935A2egSU);
        sb.append(", touchY=");
        sb.append(this.f7936A4TApA);
        sb.append(", progress=");
        sb.append(this.f7937A5SV6n);
        sb.append(", swipeEdge=");
        return J3FDQU.A2egSU.B2KMhB(sb, this.f7938ADYaiT, '}');
    }
}
