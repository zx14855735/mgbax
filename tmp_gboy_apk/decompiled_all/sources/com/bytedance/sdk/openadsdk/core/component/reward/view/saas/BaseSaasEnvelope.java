package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.f.w;
import com.bytedance.sdk.openadsdk.f.hf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class BaseSaasEnvelope extends RelativeLayout {
    private ImageView hf;
    private AnimatorSet w;
    private View xj;

    public BaseSaasEnvelope(Context context) {
        super(context);
    }

    private View hf(Context context) {
        String kd = wo.kd(getContext());
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams BTvldC2 = A2egSU.BTvldC(-2, -2, 14, 12);
        BTvldC2.bottomMargin = r.w(context, 80.0f);
        textView.setLayoutParams(BTvldC2);
        textView.setTextSize(2, 10.0f);
        textView.setGravity(17);
        textView.setText("关联后" + kd + "将获取你的抖音头像和昵称");
        textView.setTextColor(Color.parseColor("#AAFFFFFF"));
        return textView;
    }

    public void setOnButtonClickListener(final View.OnClickListener onClickListener) {
        View view = this.xj;
        if (view == null || onClickListener == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BaseSaasEnvelope.this.hf();
                onClickListener.onClick(view2);
            }
        });
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.hf;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public abstract void xj();

    public void xj(Context context, String str, RelativeLayout relativeLayout) {
        View xj = xj(context, str);
        this.xj = xj;
        relativeLayout.addView(xj);
        relativeLayout.addView(hf(context));
        this.xj.setTag(TTAdConstant.KEY_CLICK_AREA, 2917);
        addView(xj(context, relativeLayout));
        ImageView imageView = new ImageView(context);
        this.hf = imageView;
        imageView.setImageResource(jk.kd(context, "tt_saas_close"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(3, relativeLayout.getId());
        layoutParams.topMargin = r.w(context, 25.0f);
        addView(this.hf, layoutParams);
    }

    public void hf() {
        AnimatorSet animatorSet = this.w;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.w = null;
        }
    }

    private View xj(Context context, String str) {
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(r.w(context, 166.0f), r.w(context, 40.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = r.w(context, 26.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 16.0f);
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(Color.parseColor("#9D301A"));
        textView.setTypeface(null, 1);
        int w = r.w(context, 40.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float f = w;
        gradientDrawable.setCornerRadii(new float[]{f, f, f, f, f, f, f, f});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{Color.parseColor("#F2AC5F"), Color.parseColor("#FFEECC")});
        textView.setBackground(gradientDrawable);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, "scaleX", 1.0f, 1.05f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ofFloat.setDuration(800L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, "scaleY", 1.0f, 1.05f, 1.0f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setDuration(800L);
        AnimatorSet animatorSet = new AnimatorSet();
        this.w = animatorSet;
        animatorSet.play(ofFloat).with(ofFloat2);
        this.w.start();
        return textView;
    }

    public RelativeLayout xj(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(r.w(getContext(), 301.0f), r.w(getContext(), 344.0f));
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setId(2114387458);
        return relativeLayout;
    }

    private View xj(Context context, View view) {
        ImageView imageView = new ImageView(context);
        hf.xj(w.xj("saas_reward_title.webp")).to(imageView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, view.getId());
        layoutParams.setMargins(0, 0, 0, r.w(context, 20.0f));
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }
}
