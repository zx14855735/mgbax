package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.sdk.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KsRotateView extends c {
    private static int KA = -12;
    private static int KB = -25;
    private static int KC = 12;
    private static int KD = 25;
    private static int Kz = 50;
    private int Ky;
    private ImageView ig;
    private ImageView qf;

    public KsRotateView(Context context) {
        super(context);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i, 0);
        this.Ky = obtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_ic_rotate_phone);
        obtainStyledAttributes.recycle();
        ImageView imageView = new ImageView(getContext());
        this.qf = imageView;
        imageView.setImageResource(R.drawable.ksad_ic_rotate_line);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        addView(this.qf, layoutParams);
        this.ig = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.kwad.sdk.c.a.a.a(context, 22.0f);
        layoutParams2.gravity = 1;
        addView(this.ig, layoutParams2);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final Animator fO() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        interactionView.setPivotX(interactionView.getWidth() / 2.0f);
        interactionView.setPivotY(interactionView.getHeight() / 2.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(interactionView, com.sigmob.sdk.base.common.a.B, 0.0f, KB).setDuration(500L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(340L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(interactionView, com.sigmob.sdk.base.common.a.B, KB, 0.0f).setDuration(Kz);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(interactionView, com.sigmob.sdk.base.common.a.B, 0.0f, KC).setDuration(Kz);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(interactionView, com.sigmob.sdk.base.common.a.B, KC, 0.0f).setDuration(Kz);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(interactionView, com.sigmob.sdk.base.common.a.B, 0.0f, KA).setDuration(Kz);
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(interactionView, com.sigmob.sdk.base.common.a.B, KA, 0.0f).setDuration(Kz);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        ofFloat2.setDuration(500L);
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(interactionView, com.sigmob.sdk.base.common.a.B, 0.0f, KD).setDuration(500L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(340L);
        animatorSet.playSequentially(duration, ofFloat, duration2, duration3, duration4, duration5, duration6, ofFloat2, duration7, ofFloat3, ObjectAnimator.ofFloat(interactionView, com.sigmob.sdk.base.common.a.B, KD, 0.0f).setDuration(Kz), ObjectAnimator.ofFloat(interactionView, com.sigmob.sdk.base.common.a.B, 0.0f, KA).setDuration(Kz), ObjectAnimator.ofFloat(interactionView, com.sigmob.sdk.base.common.a.B, KA, 0.0f).setDuration(Kz), ObjectAnimator.ofFloat(interactionView, com.sigmob.sdk.base.common.a.B, 0.0f, KC).setDuration(Kz), ObjectAnimator.ofFloat(interactionView, com.sigmob.sdk.base.common.a.B, KC, 0.0f).setDuration(Kz));
        return animatorSet;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public int getAnimationDelayTime() {
        return 500;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public View getInteractionView() {
        return this.ig;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final void nF() {
        this.ig.setImageResource(this.Ky);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final void nG() {
        getInteractionView().setRotation(0.0f);
    }

    public KsRotateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsRotateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
