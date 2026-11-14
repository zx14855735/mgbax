package androidx.fragment.app;

import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class B7CMnp implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f8763AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f8764AlLFFp;

    public /* synthetic */ B7CMnp(int i, Object obj) {
        this.f8763AcNBzu = i;
        this.f8764AlLFFp = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8763AcNBzu) {
            case 0:
                Fragment fragment = (Fragment) this.f8764AlLFFp;
                DuwtYk duwtYk = fragment.mViewLifecycleOwner;
                duwtYk.f8949B2KMhB.A4TApA(fragment.mSavedViewRegistryState);
                fragment.mSavedViewRegistryState = null;
                break;
            default:
                DaOi9o.A5SV6n((ArrayList) this.f8764AlLFFp, 4);
                break;
        }
    }
}
