package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;

@SuppressLint({"ViewConstructor"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SlideUpLoadMoreArrow extends LinearLayout {
    private final AnimatorSet hf;
    private final int xj;

    public static class xj implements Interpolator {
        private xj() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.38f ? f * 2.631579f : (f * (-1.6129032f)) + 1.6129032f;
        }
    }

    public SlideUpLoadMoreArrow(Context context, int i, boolean z) {
        super(context);
        this.hf = new AnimatorSet();
        if (z) {
            w();
        }
        this.xj = i;
        u();
    }

    private void u() {
        Context context = getContext();
        setOrientation(1);
        setClipChildren(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = r.w(context, 80.0f);
        layoutParams.gravity = 1;
        addView(xj(getContext()), layoutParams);
        TextView textView = new TextView(context);
        textView.setTextColor(-1);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(r.w(context, 17.0f));
        }
        textView.setTextSize(2, 12.0f);
        textView.setText(jk.xj(context, "tt_reward_slip_up_lp_tip"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = r.w(context, 6.0f);
        layoutParams2.bottomMargin = r.w(context, this.xj);
        layoutParams2.gravity = 1;
        addView(textView, layoutParams2);
    }

    private void w() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.parseColor("#DD000000"), 0});
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        setBackground(gradientDrawable);
    }

    private View xj(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setClipChildren(false);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(context);
        jk.xj(context, "tt_ic_back_light", imageView);
        imageView.setAlpha(0.0f);
        linearLayout.addView(imageView, -1, -2);
        ImageView imageView2 = new ImageView(context);
        jk.xj(context, "tt_ic_back_light", imageView2);
        imageView2.setAlpha(0.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = r.w(context, -8.0f);
        linearLayout.addView(imageView2, layoutParams);
        setClipChildren(false);
        xj(imageView, imageView2);
        return linearLayout;
    }

    public void hf() {
        if (this.hf.isRunning()) {
            this.hf.cancel();
        }
    }

    private void xj(View view, View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(new xj());
        ofFloat.setDuration(1300L);
        ofFloat.setStartDelay(700L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, r.w(getContext(), -5.0f));
        ofFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ofFloat2.setDuration(1300L);
        ofFloat2.setStartDelay(700L);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(1);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        ofFloat3.setInterpolator(new xj());
        ofFloat3.setDuration(1300L);
        ofFloat3.setStartDelay(500L);
        ofFloat3.setRepeatCount(-1);
        ofFloat3.setRepeatMode(1);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view2, "translationY", r.w(getContext(), -6.0f));
        ofFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ofFloat4.setDuration(1300L);
        ofFloat4.setStartDelay(500L);
        ofFloat4.setRepeatCount(-1);
        ofFloat4.setRepeatMode(1);
        this.hf.playTogether(ofFloat, ofFloat3, ofFloat2, ofFloat4);
    }

    public void xj() {
        if (this.hf.isStarted()) {
            return;
        }
        this.hf.start();
    }
}
