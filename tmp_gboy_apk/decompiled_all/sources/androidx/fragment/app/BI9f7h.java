package androidx.fragment.app;

import android.os.Bundle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BI9f7h extends BTvldC {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ Fragment f8768A2egSU;

    public BI9f7h(Fragment fragment) {
        this.f8768A2egSU = fragment;
    }

    @Override // androidx.fragment.app.BTvldC
    public final void A2egSU() {
        Fragment fragment = this.f8768A2egSU;
        fragment.mSavedStateRegistryController.A2egSU();
        androidx.lifecycle.CQhlFr.ADYaiT(fragment);
        Bundle bundle = fragment.mSavedFragmentState;
        fragment.mSavedStateRegistryController.A4TApA(bundle != null ? bundle.getBundle("registryState") : null);
    }
}
