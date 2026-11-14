package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.f.w;
import com.bytedance.sdk.openadsdk.f.hf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SaasAuthEnvelope extends RelativeLayout {
    private ImageView hf;
    private ImageView w;
    private AnimationSet xj;

    public SaasAuthEnvelope(Context context) {
        super(context);
        xj(context);
        setVisibility(8);
    }

    private void xj(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setId(2114387464);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        addView(linearLayout);
        this.w = new ImageView(context);
        try {
            hf.xj(w.xj("saas_red_envelope.webp")).to(this.w);
        } catch (Error unused) {
        }
        linearLayout.addView(this.w, new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(context);
        this.hf = imageView;
        try {
            imageView.setImageResource(jk.kd(context, "tt_saas_close"));
        } catch (Error unused2) {
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = r.w(context, 25.0f);
        linearLayout.addView(this.hf, layoutParams2);
    }

    public void hf() {
        AnimationSet animationSet = this.xj;
        if (animationSet != null) {
            animationSet.cancel();
            this.xj = null;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hf();
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.hf;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void xj() {
        setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(800L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        alphaAnimation.setDuration(800L);
        AnimationSet animationSet = new AnimationSet(true);
        this.xj = animationSet;
        animationSet.addAnimation(alphaAnimation);
        this.xj.addAnimation(scaleAnimation);
        startAnimation(this.xj);
    }
}
