package MOpbMP;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA implements LlW7FF.AMqCpz {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4988AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ARc23Z f4989AlLFFp;

    public /* synthetic */ A4TApA(ARc23Z aRc23Z, int i) {
        this.f4988AcNBzu = i;
        this.f4989AlLFFp = aRc23Z;
    }

    @Override // LlW7FF.AMqCpz
    public final void ARc23Z(String str) {
        switch (this.f4988AcNBzu) {
            case 0:
                this.f4989AlLFFp.AzWtSf(new A2egSU(this, 0, str));
                break;
            default:
                this.f4989AlLFFp.AzWtSf(new A2egSU(this, 4, str));
                break;
        }
    }

    @Override // LlW7FF.AMqCpz
    public final void onSuccess(Object obj) {
        switch (this.f4988AcNBzu) {
            case 0:
                this.f4989AlLFFp.AzWtSf(new C4FrIb.A2egSU(this, (MTKlkd.AZkASS) obj, 29, false));
                break;
            default:
                this.f4989AlLFFp.AzWtSf(new A2egSU(this, 3, (MTKlkd.A2egSU) obj));
                break;
        }
    }
}
