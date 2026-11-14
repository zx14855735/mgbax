package com.bytedance.sdk.openadsdk.res.layout.video;

import J3FDQU.A2egSU;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c implements com.bytedance.sdk.openadsdk.res.layout.xj {
    @Override // com.bytedance.sdk.openadsdk.res.layout.xj
    public View hf(Context context) {
        RelativeLayout AYUAbz2 = A2egSU.AYUAbz(context, 2114387674);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        AYUAbz2.setLayoutParams(layoutParams);
        AYUAbz2.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387868);
        RelativeLayout.LayoutParams AYUAbz3 = com.bykv.vk.component.ttvideo.player.A2egSU.AYUAbz(580, 98, 14, -1);
        AYUAbz3.addRule(15, -1);
        AYUAbz3.setMargins(0, r.w(context, 20.0f), 0, 0);
        textView.setLayoutParams(AYUAbz3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#D33F57"));
        gradientDrawable.setCornerRadius(4.0f);
        textView.setBackground(gradientDrawable);
        textView.setGravity(17);
        textView.setPadding(r.w(context, 2.0f), r.w(context, 2.0f), r.w(context, 2.0f), r.w(context, 2.0f));
        textView.setTextColor(-1);
        textView.setTextSize(0, 34.0f);
        textView.setText(jk.xj(context, "tt_download"));
        textView.setVisibility(8);
        AYUAbz2.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387842);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 2114387868);
        layoutParams2.addRule(14, -1);
        layoutParams2.setMargins(0, 60, 0, 0);
        textView2.setLayoutParams(layoutParams2);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setText(jk.xj(context, "tt_click_replay"));
        textView2.setTextColor(-1);
        textView2.setTextSize(0, 34.0f);
        AYUAbz2.addView(textView2);
        return AYUAbz2;
    }
}
