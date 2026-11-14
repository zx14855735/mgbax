package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f11267A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f11268A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f11269A5SV6n;

    public A2egSU(CoordinatorLayout coordinatorLayout, AppBarLayout.BaseBehavior baseBehavior, AppBarLayout appBarLayout) {
        this.f11269A5SV6n = baseBehavior;
        this.f11267A2egSU = coordinatorLayout;
        this.f11268A4TApA = appBarLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f11269A5SV6n.AlLFFp(this.f11267A2egSU, this.f11268A4TApA, intValue);
    }
}
