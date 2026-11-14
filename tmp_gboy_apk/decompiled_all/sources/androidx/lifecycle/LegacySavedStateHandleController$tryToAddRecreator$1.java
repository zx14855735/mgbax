package androidx.lifecycle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class LegacySavedStateHandleController$tryToAddRecreator$1 implements B4ZgIw {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ AzWtSf f9042AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ DV2E8K.ADYaiT f9043AlLFFp;

    public LegacySavedStateHandleController$tryToAddRecreator$1(DV2E8K.ADYaiT aDYaiT, AzWtSf azWtSf) {
        this.f9042AcNBzu = azWtSf;
        this.f9043AlLFFp = aDYaiT;
    }

    @Override // androidx.lifecycle.B4ZgIw
    public final void onStateChanged(B9tovu b9tovu, AlLFFp alLFFp) {
        if (alLFFp == AlLFFp.ON_START) {
            this.f9042AcNBzu.A5SV6n(this);
            this.f9043AlLFFp.ADYaiT();
        }
    }
}
