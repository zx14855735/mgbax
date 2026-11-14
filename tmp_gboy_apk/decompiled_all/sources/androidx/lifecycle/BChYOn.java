package androidx.lifecycle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BChYOn {

    /* renamed from: A2egSU, reason: collision with root package name */
    public AmA8tU f8984A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public B4ZgIw f8985A4TApA;

    public final void A2egSU(B9tovu b9tovu, AlLFFp alLFFp) {
        AmA8tU A2egSU2 = alLFFp.A2egSU();
        AmA8tU amA8tU = this.f8984A2egSU;
        RXb0Sz.ARc23Z.AMqCpz(amA8tU, "state1");
        if (A2egSU2.compareTo(amA8tU) < 0) {
            amA8tU = A2egSU2;
        }
        this.f8984A2egSU = amA8tU;
        this.f8985A4TApA.onStateChanged(b9tovu, alLFFp);
        this.f8984A2egSU = A2egSU2;
    }
}
