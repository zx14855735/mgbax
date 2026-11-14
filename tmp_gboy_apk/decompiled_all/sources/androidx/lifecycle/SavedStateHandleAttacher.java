package androidx.lifecycle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class SavedStateHandleAttacher implements B4ZgIw {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final CSDoyG f9055AcNBzu;

    public SavedStateHandleAttacher(CSDoyG cSDoyG) {
        this.f9055AcNBzu = cSDoyG;
    }

    @Override // androidx.lifecycle.B4ZgIw
    public final void onStateChanged(B9tovu b9tovu, AlLFFp alLFFp) {
        if (alLFFp == AlLFFp.ON_CREATE) {
            b9tovu.getLifecycle().A5SV6n(this);
            this.f9055AcNBzu.A2egSU();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + alLFFp).toString());
        }
    }
}
