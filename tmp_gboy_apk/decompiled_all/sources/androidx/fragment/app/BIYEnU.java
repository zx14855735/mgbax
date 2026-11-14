package androidx.fragment.app;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BIYEnU extends CNPG0E {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ Fragment f8769AcNBzu;

    public BIYEnU(Fragment fragment) {
        this.f8769AcNBzu = fragment;
    }

    @Override // androidx.fragment.app.CNPG0E
    public final View A4TApA(int i) {
        Fragment fragment = this.f8769AcNBzu;
        View view = fragment.mView;
        if (view != null) {
            return view.findViewById(i);
        }
        throw new IllegalStateException("Fragment " + fragment + " does not have a view");
    }

    @Override // androidx.fragment.app.CNPG0E
    public final boolean A5SV6n() {
        return this.f8769AcNBzu.mView != null;
    }
}
