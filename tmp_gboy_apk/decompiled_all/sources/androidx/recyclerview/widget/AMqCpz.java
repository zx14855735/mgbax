package androidx.recyclerview.widget;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public long f9174A2egSU = 0;

    /* renamed from: A4TApA, reason: collision with root package name */
    public AMqCpz f9175A4TApA;

    public final void A2egSU(int i) {
        if (i < 64) {
            this.f9174A2egSU &= ~(1 << i);
            return;
        }
        AMqCpz aMqCpz = this.f9175A4TApA;
        if (aMqCpz != null) {
            aMqCpz.A2egSU(i - 64);
        }
    }

    public final int A4TApA(int i) {
        AMqCpz aMqCpz = this.f9175A4TApA;
        if (aMqCpz == null) {
            return i >= 64 ? Long.bitCount(this.f9174A2egSU) : Long.bitCount(this.f9174A2egSU & ((1 << i) - 1));
        }
        if (i < 64) {
            return Long.bitCount(this.f9174A2egSU & ((1 << i) - 1));
        }
        return Long.bitCount(this.f9174A2egSU) + aMqCpz.A4TApA(i - 64);
    }

    public final void A5SV6n() {
        if (this.f9175A4TApA == null) {
            this.f9175A4TApA = new AMqCpz();
        }
    }

    public final boolean ADYaiT(int i) {
        if (i < 64) {
            return (this.f9174A2egSU & (1 << i)) != 0;
        }
        A5SV6n();
        return this.f9175A4TApA.ADYaiT(i - 64);
    }

    public final boolean AMqCpz(int i) {
        if (i >= 64) {
            A5SV6n();
            return this.f9175A4TApA.AMqCpz(i - 64);
        }
        long j = 1 << i;
        long j2 = this.f9174A2egSU;
        boolean z = (j2 & j) != 0;
        long j3 = j2 & (~j);
        this.f9174A2egSU = j3;
        long j4 = j - 1;
        this.f9174A2egSU = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
        AMqCpz aMqCpz = this.f9175A4TApA;
        if (aMqCpz != null) {
            if (aMqCpz.ADYaiT(0)) {
                ASJ6gh(63);
            }
            this.f9175A4TApA.AMqCpz(0);
        }
        return z;
    }

    public final void ARc23Z() {
        this.f9174A2egSU = 0L;
        AMqCpz aMqCpz = this.f9175A4TApA;
        if (aMqCpz != null) {
            aMqCpz.ARc23Z();
        }
    }

    public final void ASJ6gh(int i) {
        if (i < 64) {
            this.f9174A2egSU |= 1 << i;
        } else {
            A5SV6n();
            this.f9175A4TApA.ASJ6gh(i - 64);
        }
    }

    public void insert(int i, boolean z) {
        if (i >= 64) {
            A5SV6n();
            this.f9175A4TApA.insert(i - 64, z);
            return;
        }
        long j = this.f9174A2egSU;
        boolean z2 = (Long.MIN_VALUE & j) != 0;
        long j2 = (1 << i) - 1;
        this.f9174A2egSU = ((j & (~j2)) << 1) | (j & j2);
        if (z) {
            ASJ6gh(i);
        } else {
            A2egSU(i);
        }
        if (z2 || this.f9175A4TApA != null) {
            A5SV6n();
            this.f9175A4TApA.insert(0, z2);
        }
    }

    public final String toString() {
        if (this.f9175A4TApA == null) {
            return Long.toBinaryString(this.f9174A2egSU);
        }
        return this.f9175A4TApA.toString() + "xx" + Long.toBinaryString(this.f9174A2egSU);
    }
}
