package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.u.f;
import com.bytedance.sdk.component.utils.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class SlideRightView extends FrameLayout {
    private AnimatorSet c;
    private AnimatorSet d;
    private AnimatorSet f;
    private ImageView hf;
    private TextView kd;
    private ImageView u;
    private ImageView w;
    private Context xj;
    private AnimatorSet y;

    public SlideRightView(Context context) {
        super(context);
        this.y = new AnimatorSet();
        this.c = new AnimatorSet();
        this.f = new AnimatorSet();
        this.d = new AnimatorSet();
        this.xj = context;
        w();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setGuideText(String str) {
        this.kd.setText(str);
    }

    private void u() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hf, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.w, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.w, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.u, "alpha", 0.0f, 1.0f);
        this.f.setDuration(300L);
        this.f.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hf, "translationX", 0.0f, f.xj(getContext(), 90.0f));
        ofFloat5.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) f.xj(getContext(), 90.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SlideRightView.this.u.getLayoutParams();
                layoutParams.width = num.intValue();
                SlideRightView.this.u.setLayoutParams(layoutParams);
            }
        });
        ofInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.w, "translationX", 0.0f, f.xj(getContext(), 90.0f));
        ofFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.d.setDuration(1500L);
        this.d.playTogether(ofFloat5, ofInt, ofFloat6);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.hf, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.u, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.w, "alpha", 1.0f, 0.0f);
        this.c.setDuration(50L);
        this.c.playTogether(ofFloat7, ofFloat8, ofFloat9);
        this.y.playSequentially(this.f, this.d, this.c);
    }

    private void w() {
        ImageView imageView = new ImageView(this.xj);
        this.u = imageView;
        imageView.setBackgroundResource(jk.kd(this.xj, "tt_splash_slide_right_bg"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -2);
        layoutParams.gravity = 48;
        layoutParams.leftMargin = (int) f.xj(this.xj, 30.0f);
        addView(this.u, layoutParams);
        setClipChildren(false);
        setClipToPadding(false);
        ImageView imageView2 = new ImageView(this.xj);
        this.w = imageView2;
        imageView2.setImageResource(jk.kd(this.xj, "tt_splash_slide_right_circle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) f.xj(this.xj, 50.0f), (int) f.xj(this.xj, 50.0f));
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = (int) f.xj(this.xj, 30.0f);
        addView(this.w, layoutParams2);
        ImageView imageView3 = new ImageView(this.xj);
        this.hf = imageView3;
        imageView3.setImageResource(jk.kd(this.xj, "tt_splash_hand2"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) f.xj(this.xj, 80.0f), (int) f.xj(this.xj, 80.0f));
        layoutParams3.gravity = 48;
        layoutParams3.leftMargin = (int) f.xj(this.xj, 30.0f);
        addView(this.hf, layoutParams3);
        TextView textView = new TextView(this.xj);
        this.kd = textView;
        textView.setTextColor(-1);
        this.kd.setSingleLine();
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 80;
        addView(this.kd, layoutParams4);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) SlideRightView.this.hf.getLayoutParams();
                layoutParams5.topMargin = (int) ((SlideRightView.this.w.getMeasuredHeight() / 2.0f) - f.xj(SlideRightView.this.getContext(), 7.0f));
                int xj = (-SlideRightView.this.w.getMeasuredWidth()) + ((int) f.xj(SlideRightView.this.xj, 30.0f));
                layoutParams5.leftMargin = xj;
                layoutParams5.setMarginStart(xj);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                SlideRightView.this.hf.setLayoutParams(layoutParams5);
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) SlideRightView.this.u.getLayoutParams();
                layoutParams6.topMargin = (int) ((SlideRightView.this.w.getMeasuredHeight() / 2.0f) - f.xj(SlideRightView.this.getContext(), 5.0f));
                layoutParams6.leftMargin = (int) ((SlideRightView.this.w.getMeasuredWidth() / 2.0f) + ((int) f.xj(SlideRightView.this.xj, 30.0f)));
                layoutParams5.setMarginStart(layoutParams5.leftMargin);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                SlideRightView.this.u.setLayoutParams(layoutParams6);
            }
        });
    }

    public void hf() {
        try {
            AnimatorSet animatorSet = this.y;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.f;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.d;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.c;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable unused) {
        }
    }

    public void xj() {
        u();
        this.y.start();
        this.y.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideRightView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideRightView.this.y.start();
                    }
                }, 200L);
            }
        });
    }
}
