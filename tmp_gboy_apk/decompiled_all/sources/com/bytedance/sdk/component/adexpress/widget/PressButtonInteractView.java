package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.u.f;
import com.bytedance.sdk.component.utils.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class PressButtonInteractView extends FrameLayout {
    private ImageView hf;
    private boolean kd;
    private AnimatorSet u;
    private SplashDiffuseView w;
    private Context xj;

    public PressButtonInteractView(Context context) {
        super(context);
        this.kd = true;
        this.xj = context;
        this.u = new AnimatorSet();
        w();
        u();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressButtonInteractView.this.hf.getLayoutParams();
                layoutParams.topMargin = (int) ((PressButtonInteractView.this.w.getMeasuredHeight() / 2.0f) - f.xj(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.leftMargin = (int) ((PressButtonInteractView.this.w.getMeasuredWidth() / 2.0f) - f.xj(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.bottomMargin = (int) (f.xj(PressButtonInteractView.this.getContext(), 5.0f) + ((-PressButtonInteractView.this.w.getMeasuredHeight()) / 2.0f));
                layoutParams.rightMargin = (int) (f.xj(PressButtonInteractView.this.getContext(), 5.0f) + ((-PressButtonInteractView.this.w.getMeasuredWidth()) / 2.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                PressButtonInteractView.this.hf.setLayoutParams(layoutParams);
            }
        });
    }

    private void u() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hf, "scaleX", 1.0f, 0.9f);
        ofFloat.setDuration(800L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressButtonInteractView.this.kd) {
                    PressButtonInteractView.this.w.xj();
                }
                PressButtonInteractView.this.kd = !r2.kd;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(PressButtonInteractView.this.hf, "alpha", 0.0f, 1.0f);
                ofFloat2.setDuration(200L);
                ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat2.start();
                PressButtonInteractView.this.hf.setVisibility(0);
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hf, "scaleY", 1.0f, 0.9f);
        ofFloat2.setDuration(800L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.u.playTogether(ofFloat, ofFloat2);
    }

    private void w() {
        this.w = new SplashDiffuseView(this.xj);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) f.xj(this.xj, 40.0f), (int) f.xj(this.xj, 40.0f));
        layoutParams.gravity = 8388627;
        addView(this.w, layoutParams);
        this.hf = new ImageView(this.xj);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) f.xj(this.xj, 62.0f), (int) f.xj(this.xj, 62.0f));
        layoutParams2.gravity = 16;
        this.hf.setImageResource(jk.kd(this.xj, "tt_splash_hand"));
        addView(this.hf, layoutParams2);
    }

    public void hf() {
        AnimatorSet animatorSet = this.u;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        SplashDiffuseView splashDiffuseView = this.w;
        if (splashDiffuseView != null) {
            splashDiffuseView.hf();
        }
        ImageView imageView = this.hf;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    public void xj() {
        this.u.start();
    }
}
