package PCV8se;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA implements ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ADYaiT f7016A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final float f7017A4TApA;

    public A4TApA(float f, ADYaiT aDYaiT) {
        while (aDYaiT instanceof A4TApA) {
            aDYaiT = ((A4TApA) aDYaiT).f7016A2egSU;
            f += ((A4TApA) aDYaiT).f7017A4TApA;
        }
        this.f7016A2egSU = aDYaiT;
        this.f7017A4TApA = f;
    }

    @Override // PCV8se.ADYaiT
    public final float A2egSU(RectF rectF) {
        return Math.max(0.0f, this.f7016A2egSU.A2egSU(rectF) + this.f7017A4TApA);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A4TApA)) {
            return false;
        }
        A4TApA a4TApA = (A4TApA) obj;
        return this.f7016A2egSU.equals(a4TApA.f7016A2egSU) && this.f7017A4TApA == a4TApA.f7017A4TApA;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7016A2egSU, Float.valueOf(this.f7017A4TApA)});
    }
}
