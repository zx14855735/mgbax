package NUY5pn;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B4ZgIw extends AlLFFp {

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final BJ7GGh f5971ASJ6gh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B4ZgIw(BJ7GGh bJ7GGh, int i) {
        super(bJ7GGh, i, null);
        this.f5971ASJ6gh = bJ7GGh;
    }

    @Override // NUY5pn.AlLFFp
    public final void A2egSU(NOd7IU.A2egSU a2egSU) {
        BJ7GGh bJ7GGh = this.f5971ASJ6gh;
        bJ7GGh.f5985A4TApA.A4TApA(a2egSU);
        bJ7GGh.f5989ASJ6gh = a2egSU.f5854AlLFFp;
        bJ7GGh.f5990AYUAbz = System.currentTimeMillis();
    }

    @Override // NUY5pn.AlLFFp
    public final boolean A4TApA() {
        this.f5971ASJ6gh.f5985A4TApA.A4TApA(NOd7IU.A2egSU.f5852B25kr6);
        return true;
    }
}
