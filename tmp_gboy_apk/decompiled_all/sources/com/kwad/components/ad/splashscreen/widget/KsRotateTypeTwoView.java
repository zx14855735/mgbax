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
public class KsRotateTypeTwoView extends c {
    private ImageView Kw;
    private ImageView Kx;
    private int Ky;
    private ImageView ig;

    public KsRotateTypeTwoView(Context context) {
        super(context);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i, 0);
        this.Ky = obtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_splash_rotate_combo_phone);
        obtainStyledAttributes.recycle();
        ImageView imageView = new ImageView(getContext());
        this.Kw = imageView;
        imageView.setImageResource(R.drawable.ksad_splash_rotate_combo_left_arrow);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.kwad.sdk.c.a.a.a(context, 5.0f), com.kwad.sdk.c.a.a.a(context, 14.0f));
        layoutParams.leftMargin = com.kwad.sdk.c.a.a.a(context, 2.0f);
        layoutParams.gravity = 16;
        addView(this.Kw, layoutParams);
        this.ig = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.kwad.sdk.c.a.a.a(context, 15.0f), com.kwad.sdk.c.a.a.a(context, 23.0f));
        layoutParams2.leftMargin = com.kwad.sdk.c.a.a.a(context, 9.0f);
        layoutParams2.gravity = 16;
        addView(this.ig, layoutParams2);
        ImageView imageView2 = new ImageView(getContext());
        this.Kx = imageView2;
        imageView2.setImageResource(R.drawable.ksad_splash_rotate_combo_right_arrow);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(com.kwad.sdk.c.a.a.a(context, 5.0f), com.kwad.sdk.c.a.a.a(context, 14.0f));
        layoutParams3.leftMargin = com.kwad.sdk.c.a.a.a(context, 26.0f);
        layoutParams3.gravity = 16;
        addView(this.Kx, layoutParams3);
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
        animatorSet.playSequentially(ObjectAnimator.ofFloat(interactionView, com.sigmob.sdk.base.common.a.B, 0.0f, -25.0f).setDuration(500L), ObjectAnimator.ofFloat(interactionView, com.sigmob.sdk.base.common.a.B, -25.0f, 25.0f).setDuration(500L), ObjectAnimator.ofFloat(interactionView, com.sigmob.sdk.base.common.a.B, 25.0f, -12.0f).setDuration(200L), ObjectAnimator.ofFloat(interactionView, com.sigmob.sdk.base.common.a.B, -12.0f, 0.0f).setDuration(100L));
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
        ImageView imageView = this.ig;
        if (imageView != null) {
            imageView.setImageResource(this.Ky);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final void nG() {
        getInteractionView().setRotation(0.0f);
    }

    public KsRotateTypeTwoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsRotateTypeTwoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
