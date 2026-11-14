package androidx.lifecycle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DefaultLifecycleObserverAdapter implements B4ZgIw {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AMqCpz f9040AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final B4ZgIw f9041AlLFFp;

    public DefaultLifecycleObserverAdapter(AMqCpz aMqCpz, B4ZgIw b4ZgIw) {
        this.f9040AcNBzu = aMqCpz;
        this.f9041AlLFFp = b4ZgIw;
    }

    @Override // androidx.lifecycle.B4ZgIw
    public final void onStateChanged(B9tovu b9tovu, AlLFFp alLFFp) {
        int i = ARc23Z.f8975A2egSU[alLFFp.ordinal()];
        AMqCpz aMqCpz = this.f9040AcNBzu;
        if (i == 3) {
            aMqCpz.onResume();
        } else if (i == 7) {
            throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        B4ZgIw b4ZgIw = this.f9041AlLFFp;
        if (b4ZgIw != null) {
            b4ZgIw.onStateChanged(b9tovu, alLFFp);
        }
    }
}
