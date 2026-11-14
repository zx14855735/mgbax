package OpB85q;

import android.animation.ValueAnimator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ float f6663A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ ARc23Z f6664A4TApA;

    public ADYaiT(ARc23Z aRc23Z, float f) {
        this.f6664A4TApA = aRc23Z;
        this.f6663A2egSU = f;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f6664A4TApA.ADYaiT(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f6663A2egSU);
    }
}
