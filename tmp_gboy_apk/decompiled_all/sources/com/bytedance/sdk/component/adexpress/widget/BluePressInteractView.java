package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.jk;
import com.sigmob.sdk.base.common.a;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BluePressInteractView extends FrameLayout {
    private ImageView c;
    private int d;
    private int f;
    private ObjectAnimator hf;
    private View kd;
    private Context tf;
    private View u;
    private boolean w;
    private AnimatorSet xj;
    private View y;

    public BluePressInteractView(Context context, int i, int i2) {
        super(context);
        this.w = false;
        this.xj = new AnimatorSet();
        this.f = i;
        this.d = i2;
        this.tf = context;
        w();
        u();
    }

    private void u() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.u, "scaleX", 1.0f, 2.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.u, "scaleY", 1.0f, 2.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.kd, "scaleX", 1.0f, 2.5f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.kd, "scaleY", 1.0f, 2.5f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.y, "scaleX", 1.0f, 1.5f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.y, "scaleY", 1.0f, 1.5f, 1.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.c, a.B, 0.0f, -20.0f, 0.0f);
        this.hf = ofFloat7;
        ofFloat7.setDuration(1000L);
        this.xj.setDuration(1500L);
        this.xj.setInterpolator(new AccelerateDecelerateInterpolator());
        this.xj.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.xj.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.BluePressInteractView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                BluePressInteractView.this.w = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (BluePressInteractView.this.w) {
                    return;
                }
                BluePressInteractView.this.hf.start();
                BluePressInteractView.this.xj.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
    }

    private void w() {
        View view = new View(this.tf);
        this.u = view;
        view.setBackground(xj("#1A7BBEFF", "#337BBEFF"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (this.f * 0.45d), (int) (this.d * 0.45d));
        layoutParams.gravity = 17;
        this.u.setLayoutParams(layoutParams);
        addView(this.u);
        View view2 = new View(this.tf);
        this.kd = view2;
        view2.setBackground(xj("#337BBEFF", "#807BBEFF"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (this.f * 0.25d), (int) (this.d * 0.25d));
        layoutParams2.gravity = 17;
        this.kd.setLayoutParams(layoutParams2);
        addView(this.kd);
        View view3 = new View(this.tf);
        this.y = view3;
        view3.setBackground(xj("#807BBEFF", "#FF7BBEFF"));
        int i = this.f;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (i * 0.25d), (int) (i * 0.25d));
        layoutParams3.gravity = 17;
        this.y.setLayoutParams(layoutParams3);
        addView(this.y);
        ImageView imageView = new ImageView(this.tf);
        this.c = imageView;
        imageView.setImageResource(jk.kd(getContext(), "tt_blue_hand"));
        this.c.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams((int) (this.f * 0.62d), (int) (this.d * 0.53d));
        layoutParams4.gravity = 17;
        layoutParams4.topMargin = (layoutParams4.width / 2) - 5;
        layoutParams4.leftMargin = (layoutParams4.height / 2) - 5;
        this.c.setLayoutParams(layoutParams4);
        addView(this.c);
    }

    public void hf() {
        this.w = true;
        ObjectAnimator objectAnimator = this.hf;
        if (objectAnimator == null || this.xj == null) {
            return;
        }
        objectAnimator.cancel();
        this.xj.cancel();
    }

    private GradientDrawable xj(String str, String str2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setStroke(1, Color.parseColor(str2));
        return gradientDrawable;
    }

    public void xj() {
        this.w = false;
        ObjectAnimator objectAnimator = this.hf;
        if (objectAnimator == null || this.xj == null) {
            return;
        }
        objectAnimator.start();
        this.xj.start();
    }
}
