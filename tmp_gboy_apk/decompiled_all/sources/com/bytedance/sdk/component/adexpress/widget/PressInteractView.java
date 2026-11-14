package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.u.f;
import com.bytedance.sdk.component.utils.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class PressInteractView extends FrameLayout {
    private ImageView hf;
    private boolean kd;
    private AnimatorSet u;
    private SplashDiffuseView w;
    private Context xj;
    private TextView y;

    public PressInteractView(Context context) {
        super(context);
        this.kd = true;
        this.xj = context;
        this.u = new AnimatorSet();
        w();
        u();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.PressInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                int xj = (int) f.xj(PressInteractView.this.xj, 50.0f);
                int xj2 = (int) f.xj(PressInteractView.this.xj, 50.0f);
                if (PressInteractView.this.w.getMeasuredHeight() > 0) {
                    xj = PressInteractView.this.w.getMeasuredHeight();
                }
                if (PressInteractView.this.w.getMeasuredWidth() > 0) {
                    xj2 = PressInteractView.this.w.getMeasuredWidth();
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressInteractView.this.hf.getLayoutParams();
                layoutParams.topMargin = ((int) ((xj / 2.0f) - f.xj(PressInteractView.this.getContext(), 5.0f))) + ((int) f.xj(PressInteractView.this.xj, 40.0f));
                layoutParams.leftMargin = ((int) ((xj2 / 2.0f) - f.xj(PressInteractView.this.getContext(), 5.0f))) + ((int) f.xj(PressInteractView.this.xj, 20.0f));
                layoutParams.bottomMargin = (int) (f.xj(PressInteractView.this.getContext(), 5.0f) + ((-xj) / 2.0f));
                layoutParams.rightMargin = (int) (f.xj(PressInteractView.this.getContext(), 5.0f) + ((-xj2) / 2.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                PressInteractView.this.hf.setLayoutParams(layoutParams);
            }
        });
    }

    public void setGuideText(String str) {
        this.y.setVisibility(0);
        this.y.setText(str);
    }

    public void setGuideTextColor(int i) {
        this.y.setTextColor(i);
    }

    private void u() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hf, "scaleX", 1.0f, 1.0f, 1.0f, 0.9f);
        ofFloat.setDuration(600L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.PressInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressInteractView.this.kd) {
                    PressInteractView.this.w.xj();
                }
                PressInteractView.this.kd = !r2.kd;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(PressInteractView.this.hf, "alpha", 0.0f, 1.0f);
                ofFloat2.setDuration(200L);
                ofFloat2.setInterpolator(new LinearInterpolator());
                ofFloat2.start();
                PressInteractView.this.hf.setVisibility(0);
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hf, "scaleY", 1.0f, 1.0f, 1.0f, 0.9f);
        ofFloat2.setDuration(600L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        this.u.playTogether(ofFloat, ofFloat2);
    }

    private void w() {
        this.w = new SplashDiffuseView(this.xj);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) f.xj(this.xj, 50.0f), (int) f.xj(this.xj, 50.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) f.xj(this.xj, 40.0f);
        int xj = (int) f.xj(this.xj, 20.0f);
        layoutParams.leftMargin = xj;
        layoutParams.setMarginStart(xj);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.w, layoutParams);
        this.hf = new ImageView(this.xj);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) f.xj(this.xj, 78.0f), (int) f.xj(this.xj, 78.0f));
        this.hf.setImageResource(jk.kd(this.xj, "tt_splash_hand"));
        addView(this.hf, layoutParams2);
        TextView textView = new TextView(this.xj);
        this.y = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) f.xj(this.xj, 10.0f);
        addView(this.y, layoutParams3);
        this.y.setVisibility(8);
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
