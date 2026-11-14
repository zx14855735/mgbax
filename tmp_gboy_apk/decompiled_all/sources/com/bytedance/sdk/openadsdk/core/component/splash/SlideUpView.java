package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.pz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SlideUpView extends RelativeLayout {
    private AnimatorSet c;
    private AnimatorSet f;
    private ImageView hf;
    private AnimatorSet kd;
    private ImageView u;
    private ImageView w;
    private ImageView xj;
    private AnimatorSet y;

    public SlideUpView(Context context) {
        super(context);
        hf(context);
    }

    private void hf(Context context) {
        if (context == null) {
            context = pz.getContext();
        }
        View xj = xj(context);
        if (xj == null) {
            return;
        }
        addView(xj);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.kd;
    }

    private View xj(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setGravity(16);
        relativeLayout.setClipChildren(false);
        relativeLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(context);
        this.w = imageView;
        imageView.setId(2114387639);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        layoutParams2.addRule(14);
        layoutParams2.addRule(8, 2114387761);
        layoutParams2.bottomMargin = r.w(context, -24.0f);
        jk.xj(context, "tt_splash_slide_up_circle", (View) this.w);
        this.w.setAlpha(0.0f);
        this.w.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.w);
        ImageView imageView2 = new ImageView(context);
        this.hf = imageView2;
        imageView2.setId(2114387939);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 0.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(14);
        layoutParams3.addRule(1, 2114387761);
        layoutParams3.addRule(8, 2114387761);
        jk.xj(context, "tt_splash_slide_up_bg", (View) this.hf);
        layoutParams3.leftMargin = r.w(context, -7.0f);
        this.hf.setLayoutParams(layoutParams3);
        relativeLayout.addView(this.hf);
        ImageView imageView3 = new ImageView(context);
        this.xj = imageView3;
        imageView3.setId(2114387644);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 91.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 68.0f, resources.getDisplayMetrics()));
        layoutParams4.addRule(14);
        layoutParams4.addRule(1, 2114387761);
        layoutParams4.addRule(8, 2114387761);
        jk.xj(context, "tt_splash_slide_up_finger", (View) this.xj);
        layoutParams4.leftMargin = r.w(context, -7.0f);
        layoutParams4.bottomMargin = r.w(context, -20.0f);
        this.xj.setAlpha(0.0f);
        this.xj.setLayoutParams(layoutParams4);
        relativeLayout.addView(this.xj);
        ImageView imageView4 = new ImageView(context);
        this.u = imageView4;
        imageView4.setId(2114387761);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 124.0f, resources.getDisplayMetrics()));
        layoutParams5.addRule(14);
        jk.xj(context, "tt_splash_slide_up_arrow", (View) this.u);
        this.u.setLayoutParams(layoutParams5);
        relativeLayout.addView(this.u);
        return relativeLayout;
    }

    public void hf() {
        AnimatorSet animatorSet = this.kd;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.c;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.y;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        AnimatorSet animatorSet4 = this.f;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
    }

    public void xj() {
        this.y = new AnimatorSet();
        this.c = new AnimatorSet();
        this.f = new AnimatorSet();
        this.kd = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.xj, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.xj, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.xj, "translationY", 0.0f, r.w(getContext(), -110.0f));
        ofFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, r.w(getContext(), 110.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SlideUpView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.hf.getLayoutParams();
                layoutParams.height = num.intValue();
                SlideUpView.this.hf.setLayoutParams(layoutParams);
            }
        });
        ofInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hf, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hf, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.w, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.w, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.w, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.w, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.w, "translationY", 0.0f, r.w(getContext(), -110.0f));
        ofFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.y.setDuration(50L);
        this.f.setDuration(1500L);
        this.c.setDuration(50L);
        this.y.playTogether(ofFloat2, ofFloat7, ofFloat5);
        this.c.playTogether(ofFloat, ofFloat6, ofFloat8, ofFloat9, ofFloat4);
        this.f.playTogether(ofFloat3, ofInt, ofFloat10);
        this.kd.playSequentially(this.c, this.f, this.y);
    }
}
