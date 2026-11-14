package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.u;
import com.bytedance.sdk.component.adexpress.u.f;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class SlideUpView extends RelativeLayout {
    private AnimatorSet c;
    private AnimatorSet d;
    private AnimatorSet f;
    private ImageView hf;
    private TextView kd;
    private int p;
    private String tf;
    private TextView u;
    private ImageView w;
    private ImageView xj;
    private AnimatorSet y;

    public SlideUpView(Context context) {
        super(context);
        this.y = new AnimatorSet();
        this.c = new AnimatorSet();
        this.f = new AnimatorSet();
        this.d = new AnimatorSet();
        this.p = 100;
        xj(context);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.y;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hf();
    }

    public void setGuideText(String str) {
        TextView textView = this.u;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSlideText(String str) {
        if (this.kd != null) {
            if (TextUtils.isEmpty(str)) {
                this.kd.setText("");
            } else {
                this.kd.setText(str);
            }
        }
    }

    public void w() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.xj, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.xj, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.xj, "translationY", 0.0f, f.xj(getContext(), -this.p));
        ofFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) f.xj(getContext(), this.p));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (SlideUpView.this.w != null) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.w.getLayoutParams();
                    layoutParams.height = num.intValue();
                    SlideUpView.this.w.setLayoutParams(layoutParams);
                }
            }
        });
        ofInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.w, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.w, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hf, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.hf, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.hf, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.hf, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.hf, "translationY", 0.0f, f.xj(getContext(), -this.p));
        ofFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.c.setDuration(50L);
        this.d.setDuration(1500L);
        this.f.setDuration(50L);
        this.c.playTogether(ofFloat2, ofFloat7, ofFloat5);
        this.f.playTogether(ofFloat, ofFloat6, ofFloat8, ofFloat9, ofFloat4);
        this.d.playTogether(ofFloat3, ofInt, ofFloat10);
        this.y.playSequentially(this.f, this.d, this.c);
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
            AnimatorSet animatorSet3 = this.c;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.d;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Exception e) {
            pl.w(e.getMessage());
        }
    }

    public void xj(Context context) {
        if (context == null) {
            context = u.getContext();
        }
        if ("5".equals(this.tf)) {
            addView(com.bytedance.sdk.component.adexpress.w.xj.y(context));
            this.p = (int) (this.p * 1.25d);
        } else {
            addView(com.bytedance.sdk.component.adexpress.w.xj.kd(context));
        }
        this.xj = (ImageView) findViewById(2097610734);
        this.hf = (ImageView) findViewById(2097610735);
        this.u = (TextView) findViewById(2097610730);
        this.w = (ImageView) findViewById(2097610733);
        this.kd = (TextView) findViewById(2097610731);
    }

    public SlideUpView(Context context, String str) {
        super(context);
        this.y = new AnimatorSet();
        this.c = new AnimatorSet();
        this.f = new AnimatorSet();
        this.d = new AnimatorSet();
        this.p = 100;
        setClipChildren(false);
        this.tf = str;
        xj(context);
    }

    public void xj() {
        w();
        this.y.start();
        this.y.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideUpView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideUpView.this.y.start();
                    }
                }, 200L);
            }
        });
    }
}
