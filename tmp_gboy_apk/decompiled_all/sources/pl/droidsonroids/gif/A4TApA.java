package pl.droidsonroids.gif;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A4TApA extends AMqCpz {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ int f14073AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ A5SV6n f14074AmA8tU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A4TApA(A5SV6n a5SV6n, A5SV6n a5SV6n2, int i) {
        super(a5SV6n2);
        this.f14074AmA8tU = a5SV6n;
        this.f14073AlLFFp = i;
    }

    @Override // pl.droidsonroids.gif.AMqCpz
    public final void A2egSU() {
        A5SV6n a5SV6n = this.f14074AmA8tU;
        int i = this.f14073AlLFFp;
        a5SV6n.f14081B3GDIM.AzWtSf(a5SV6n.f14080B2KMhB, i);
        this.f14093AcNBzu.f14087BIYEnU.sendEmptyMessageAtTime(-1, 0L);
    }
}
