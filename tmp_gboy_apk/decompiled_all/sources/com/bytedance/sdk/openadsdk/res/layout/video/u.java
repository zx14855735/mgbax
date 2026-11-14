package com.bytedance.sdk.openadsdk.res.layout.video;

import J3FDQU.A2egSU;
import android.R;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends xj {
    private View xj(Context context) {
        RelativeLayout AYUAbz2 = A2egSU.AYUAbz(context, 2114387693);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, r.w(context, 32.0f));
        layoutParams.addRule(3, 2114387807);
        layoutParams.addRule(14);
        layoutParams.topMargin = r.w(context, 17.0f);
        AYUAbz2.setLayoutParams(layoutParams);
        AYUAbz2.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.bykv.vk.component.ttvideo.player.A2egSU.A4TApA("#F93F3F", gradientDrawable, context, 5.0f));
        AYUAbz2.setBackground(gradientDrawable);
        AYUAbz2.setMinimumWidth(r.w(context, 110.0f));
        View imageView = new ImageView(context);
        imageView.setId(2114387876);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(r.w(context, 12.0f), r.w(context, 14.0f));
        layoutParams2.addRule(15);
        layoutParams2.rightMargin = r.w(context, 6.0f);
        imageView.setLayoutParams(layoutParams2);
        jk.xj(context, "tt_live_ad_loading_btn_status", imageView);
        TextView AZOQYO2 = A2egSU.AZOQYO(context, 2114387752);
        RelativeLayout.LayoutParams AYUAbz3 = com.bykv.vk.component.ttvideo.player.A2egSU.AYUAbz(-2, -1, 1, 2114387876);
        AYUAbz3.addRule(17, 2114387876);
        AZOQYO2.setGravity(16);
        AZOQYO2.setSingleLine(true);
        AZOQYO2.setText(jk.xj(context, "tt_live_loading_btn"));
        AZOQYO2.setTextColor(-1);
        AZOQYO2.setTextSize(2, 11.0f);
        AZOQYO2.setLayoutParams(AYUAbz3);
        View imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(r.w(context, 12.0f), r.w(context, 14.0f));
        layoutParams3.addRule(13);
        layoutParams3.addRule(1, 2114387752);
        layoutParams3.addRule(17, 2114387752);
        imageView2.setLayoutParams(layoutParams3);
        jk.xj(context, "tt_splash_click_bar_go", imageView2);
        AYUAbz2.addView(imageView);
        AYUAbz2.addView(AZOQYO2);
        AYUAbz2.addView(imageView2);
        return AYUAbz2;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.xj
    public View hf(Context context) {
        RelativeLayout xj = xj(context, 2114387616);
        xj.setVisibility(8);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        xj.addView(relativeLayout, layoutParams);
        relativeLayout.addView(hf(context, 0));
        TextView textView = new TextView(context);
        textView.setId(2114387742);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 2114387911);
        layoutParams2.addRule(14);
        layoutParams2.setMargins(0, r.w(context, 13.0f), 0, 0);
        textView.setLayoutParams(layoutParams2);
        textView.setTextColor(context.getResources().getColor(R.color.white));
        textView.setTextSize(2, 16.0f);
        relativeLayout.addView(textView);
        TextView AZOQYO2 = A2egSU.AZOQYO(context, 2114387807);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, 2114387742);
        layoutParams3.addRule(14);
        layoutParams3.setMargins(0, r.w(context, 8.0f), 0, 0);
        AZOQYO2.setLayoutParams(layoutParams3);
        AZOQYO2.setTextColor(context.getResources().getColor(R.color.white));
        AZOQYO2.setTextSize(2, 12.0f);
        AZOQYO2.setText(jk.xj(context, "tt_live_loading_text"));
        relativeLayout.addView(AZOQYO2);
        relativeLayout.addView(xj(context));
        return xj;
    }
}
