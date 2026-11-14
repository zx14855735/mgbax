package com.google.android.material.bottomappbar;

import android.view.View;
import com.google.android.material.bottomappbar.BottomAppBar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements View.OnLayoutChangeListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar.Behavior f11350AcNBzu;

    public A2egSU(BottomAppBar.Behavior behavior) {
        this.f11350AcNBzu = behavior;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        view.removeOnLayoutChangeListener(this);
    }
}
