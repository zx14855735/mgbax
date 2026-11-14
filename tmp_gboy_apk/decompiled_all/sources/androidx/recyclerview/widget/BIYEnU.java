package androidx.recyclerview.widget;

import android.animation.ValueAnimator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BIYEnU implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ BJ7GGh f9247A2egSU;

    public BIYEnU(BJ7GGh bJ7GGh) {
        this.f9247A2egSU = bJ7GGh;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        BJ7GGh bJ7GGh = this.f9247A2egSU;
        bJ7GGh.f9252A5SV6n.setAlpha(floatValue);
        bJ7GGh.f9253ADYaiT.setAlpha(floatValue);
        bJ7GGh.f9267B4ZgIw.invalidate();
    }
}
