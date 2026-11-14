package MOpbMP;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n implements LlW7FF.AMqCpz {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4990AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ARc23Z f4991AlLFFp;

    public /* synthetic */ A5SV6n(ARc23Z aRc23Z, int i) {
        this.f4990AcNBzu = i;
        this.f4991AlLFFp = aRc23Z;
    }

    @Override // LlW7FF.AMqCpz
    public final void ARc23Z(String str) {
        switch (this.f4990AcNBzu) {
            case 0:
                this.f4991AlLFFp.AzWtSf(new A2egSU(this, 2, str));
                break;
            default:
                this.f4991AlLFFp.AzWtSf(new A2egSU(this, 7, str));
                break;
        }
    }

    @Override // LlW7FF.AMqCpz
    public final void onSuccess(Object obj) {
        switch (this.f4990AcNBzu) {
            case 0:
                this.f4991AlLFFp.AzWtSf(new A2egSU(this, 1, (MTKlkd.A2egSU) obj));
                break;
            default:
                this.f4991AlLFFp.AzWtSf(new A2egSU(this, 6, (MTKlkd.AZkASS) obj));
                break;
        }
    }
}
