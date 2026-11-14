package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.CtxOCS;
import androidx.fragment.app.Fragment;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends CtxOCS.A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ Fragment f9543A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f9544A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ AYUAbz f9545A5SV6n;

    public A2egSU(AYUAbz aYUAbz, Fragment fragment, FrameLayout frameLayout) {
        this.f9545A5SV6n = aYUAbz;
        this.f9543A2egSU = fragment;
        this.f9544A4TApA = frameLayout;
    }

    @Override // androidx.fragment.app.CtxOCS.A2egSU
    public final void onFragmentViewCreated(CtxOCS ctxOCS, Fragment fragment, View view, Bundle bundle) {
        if (fragment == this.f9543A2egSU) {
            ctxOCS.DG07BK(this);
            this.f9545A5SV6n.getClass();
            AYUAbz.A2egSU(view, this.f9544A4TApA);
        }
    }
}
