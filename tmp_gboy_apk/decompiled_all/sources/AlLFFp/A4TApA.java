package AlLFFp;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA extends AMqCpz {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ int f943AmA8tU;

    public A4TApA(A5SV6n a5SV6n, A5SV6n a5SV6n2, int i) {
        this.f943AmA8tU = i;
        this.f951AcNBzu = a5SV6n2;
        this.f952AlLFFp = a5SV6n;
    }

    @Override // AlLFFp.AMqCpz
    public final A5SV6n A4TApA(A5SV6n a5SV6n) {
        switch (this.f943AmA8tU) {
            case 0:
                return a5SV6n.f947AzWtSf;
            default:
                return a5SV6n.f946AmA8tU;
        }
    }

    @Override // AlLFFp.AMqCpz
    public final A5SV6n A5SV6n(A5SV6n a5SV6n) {
        switch (this.f943AmA8tU) {
            case 0:
                return a5SV6n.f946AmA8tU;
            default:
                return a5SV6n.f947AzWtSf;
        }
    }
}
