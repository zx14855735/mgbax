package androidx.lifecycle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class SavedStateHandleController implements B4ZgIw {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final String f9056AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final COJEAR f9057AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f9058AmA8tU;

    public SavedStateHandleController(String str, COJEAR cojear) {
        this.f9056AcNBzu = str;
        this.f9057AlLFFp = cojear;
    }

    public final void A2egSU(DV2E8K.ADYaiT aDYaiT, AzWtSf azWtSf) {
        RXb0Sz.ARc23Z.AMqCpz(aDYaiT, "registry");
        RXb0Sz.ARc23Z.AMqCpz(azWtSf, "lifecycle");
        if (this.f9058AmA8tU) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f9058AmA8tU = true;
        azWtSf.A2egSU(this);
        aDYaiT.A5SV6n(this.f9056AcNBzu, this.f9057AlLFFp.AMqCpz);
    }

    @Override // androidx.lifecycle.B4ZgIw
    public final void onStateChanged(B9tovu b9tovu, AlLFFp alLFFp) {
        if (alLFFp == AlLFFp.ON_DESTROY) {
            this.f9058AmA8tU = false;
            b9tovu.getLifecycle().A5SV6n(this);
        }
    }
}
