package D8MqeW;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final float f2012A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final B2KMhB f2013A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final B2KMhB f2014A5SV6n;

    public A5SV6n(float f, B2KMhB b2KMhB, B2KMhB b2KMhB2) {
        this.f2012A2egSU = f;
        this.f2013A4TApA = b2KMhB;
        this.f2014A5SV6n = b2KMhB2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A5SV6n)) {
            return false;
        }
        A5SV6n a5SV6n = (A5SV6n) obj;
        return Float.compare(this.f2012A2egSU, a5SV6n.f2012A2egSU) == 0 && RXb0Sz.ARc23Z.A2egSU(this.f2013A4TApA, a5SV6n.f2013A4TApA) && RXb0Sz.ARc23Z.A2egSU(this.f2014A5SV6n, a5SV6n.f2014A5SV6n);
    }

    public final int hashCode() {
        return this.f2014A5SV6n.hashCode() + ((this.f2013A4TApA.hashCode() + (Float.floatToIntBits(this.f2012A2egSU) * 31)) * 31);
    }

    public final String toString() {
        return "DistanceVertex(distance=" + this.f2012A2egSU + ", f1=" + this.f2013A4TApA + ", f2=" + this.f2014A5SV6n + ')';
    }
}
