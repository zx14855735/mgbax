package D8MqeW;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B2KMhB {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final float f2031A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AYUAbz f2032A4TApA;

    public B2KMhB(float f, AYUAbz aYUAbz) {
        RXb0Sz.ARc23Z.AMqCpz(aYUAbz, "feature");
        this.f2031A2egSU = f;
        this.f2032A4TApA = aYUAbz;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B2KMhB)) {
            return false;
        }
        B2KMhB b2KMhB = (B2KMhB) obj;
        return Float.compare(this.f2031A2egSU, b2KMhB.f2031A2egSU) == 0 && RXb0Sz.ARc23Z.A2egSU(this.f2032A4TApA, b2KMhB.f2032A4TApA);
    }

    public final int hashCode() {
        return this.f2032A4TApA.hashCode() + (Float.floatToIntBits(this.f2031A2egSU) * 31);
    }

    public final String toString() {
        return "ProgressableFeature(progress=" + this.f2031A2egSU + ", feature=" + this.f2032A4TApA + ')';
    }
}
