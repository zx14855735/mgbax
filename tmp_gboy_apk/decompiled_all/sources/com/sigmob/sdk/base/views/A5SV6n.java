package com.sigmob.sdk.base.views;

import android.animation.ValueAnimator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A5SV6n implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f13233A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ ao f13234A4TApA;

    public /* synthetic */ A5SV6n(ao aoVar, int i) {
        this.f13233A2egSU = i;
        this.f13234A4TApA = aoVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f13233A2egSU) {
            case 0:
                this.f13234A4TApA.a(valueAnimator);
                break;
            case 1:
                this.f13234A4TApA.b(valueAnimator);
                break;
            default:
                this.f13234A4TApA.c(valueAnimator);
                break;
        }
    }
}
