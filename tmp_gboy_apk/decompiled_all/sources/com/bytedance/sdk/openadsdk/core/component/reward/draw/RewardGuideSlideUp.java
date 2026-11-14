package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.pz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class RewardGuideSlideUp extends RelativeLayout {
    private final AnimatorSet c;
    private ImageView hf;
    private final AnimatorSet kd;
    private AnimatorSet u;
    private ImageView w;
    private ImageView xj;
    private final AnimatorSet y;

    public RewardGuideSlideUp(Context context) {
        super(context);
        this.kd = new AnimatorSet();
        this.y = new AnimatorSet();
        this.c = new AnimatorSet();
        xj(context);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.u;
    }

    public void hf() {
        try {
            AnimatorSet animatorSet = this.u;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.y;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.kd;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.c;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable th) {
            pl.w(th.getMessage());
        }
    }

    private void xj(Context context) {
        if (context == null) {
            context = pz.getContext();
        }
        addView(com.bytedance.sdk.openadsdk.res.kd.p(context));
        this.xj = (ImageView) findViewById(2114387644);
        this.hf = (ImageView) findViewById(2114387939);
        this.w = (ImageView) findViewById(2114387639);
    }

    public void xj() {
        this.u = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.xj, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.xj, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.xj, "translationY", 0.0f, r.w(getContext(), -110.0f));
        ofFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, r.w(getContext(), 110.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.RewardGuideSlideUp.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) RewardGuideSlideUp.this.hf.getLayoutParams();
                layoutParams.height = num.intValue();
                RewardGuideSlideUp.this.hf.setLayoutParams(layoutParams);
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
        this.kd.setDuration(50L);
        this.c.setDuration(3000L);
        this.y.setDuration(50L);
        this.kd.playTogether(ofFloat2, ofFloat7, ofFloat5);
        this.y.playTogether(ofFloat, ofFloat6, ofFloat8, ofFloat9, ofFloat4);
        this.c.playTogether(ofFloat3, ofInt, ofFloat10);
        this.u.playSequentially(this.y, this.c, this.kd);
    }
}
