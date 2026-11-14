package com.bytedance.sdk.openadsdk.res.layout.video;

import J3FDQU.A2egSU;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj implements com.bytedance.sdk.openadsdk.res.layout.xj {
    public View hf(Context context, int i) {
        RelativeLayout AYUAbz2 = A2egSU.AYUAbz(context, 2114387911);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(r.w(context, 66.0f), r.w(context, 66.0f));
        layoutParams.addRule(14);
        if (i != 0) {
            layoutParams.setMargins(0, r.w(context, i), 0, 0);
        }
        AYUAbz2.setLayoutParams(layoutParams);
        jk.xj(context, "tt_live_avatar_bg", AYUAbz2);
        View roundImageView = new RoundImageView(context);
        roundImageView.setId(2114387831);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(r.w(context, 65.0f), r.w(context, 65.0f));
        layoutParams2.addRule(14);
        layoutParams2.addRule(10);
        roundImageView.setLayoutParams(layoutParams2);
        AYUAbz2.addView(roundImageView);
        View imageView = new ImageView(context);
        imageView.setId(2114387608);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(r.w(context, 42.0f), r.w(context, 18.0f));
        layoutParams3.addRule(13);
        layoutParams3.addRule(12);
        imageView.setLayoutParams(layoutParams3);
        jk.xj(context, "tt_live_ad_status_icon", imageView);
        AYUAbz2.addView(imageView);
        return AYUAbz2;
    }

    public View xj(Context context, int i, int i2) {
        RelativeLayout AYUAbz2 = A2egSU.AYUAbz(context, 2114387693);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, r.w(context, 44.0f));
        layoutParams.addRule(12);
        layoutParams.setMargins(r.w(context, 40.0f), 0, r.w(context, 40.0f), r.w(context, i));
        AYUAbz2.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.bykv.vk.component.ttvideo.player.A2egSU.A4TApA("#F93F3F", gradientDrawable, context, 5.0f));
        AYUAbz2.setBackground(gradientDrawable);
        AYUAbz2.setGravity(17);
        View AMqCpz = A2egSU.AMqCpz(context, 2114387876);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(r.w(context, 14.0f), r.w(context, 16.0f));
        layoutParams2.addRule(15);
        layoutParams2.setMargins(0, 0, r.w(context, i2), 0);
        AMqCpz.setLayoutParams(layoutParams2);
        jk.xj(context, "tt_live_ad_loading_btn_status", AMqCpz);
        AYUAbz2.addView(AMqCpz);
        TextView AZOQYO2 = A2egSU.AZOQYO(context, 2114387752);
        RelativeLayout.LayoutParams AYUAbz3 = com.bykv.vk.component.ttvideo.player.A2egSU.AYUAbz(-2, -1, 1, 2114387876);
        AYUAbz3.addRule(17, 2114387876);
        AYUAbz3.addRule(15);
        AZOQYO2.setLayoutParams(AYUAbz3);
        AZOQYO2.setGravity(16);
        AZOQYO2.setSingleLine(true);
        AZOQYO2.setText(jk.xj(context, "tt_live_loading_btn"));
        AZOQYO2.setTextColor(-1);
        AYUAbz2.addView(AZOQYO2);
        View imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(r.w(context, 14.0f), r.w(context, 16.0f));
        layoutParams3.addRule(1, 2114387752);
        layoutParams3.addRule(13);
        layoutParams3.setMargins(0, 0, r.w(context, 6.0f), 0);
        imageView.setLayoutParams(layoutParams3);
        jk.xj(context, "tt_splash_click_bar_go", imageView);
        AYUAbz2.addView(imageView);
        return AYUAbz2;
    }

    public RelativeLayout xj(Context context, int i) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(Color.parseColor("#99000000"));
        if (i != 0) {
            relativeLayout.setId(i);
        }
        return relativeLayout;
    }
}
