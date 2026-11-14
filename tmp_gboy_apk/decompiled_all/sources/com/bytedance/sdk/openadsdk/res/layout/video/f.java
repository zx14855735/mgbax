package com.bytedance.sdk.openadsdk.res.layout.video;

import J3FDQU.A2egSU;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f implements com.bytedance.sdk.openadsdk.res.layout.xj {
    @Override // com.bytedance.sdk.openadsdk.res.layout.xj
    public View hf(Context context) {
        RelativeLayout AYUAbz2 = A2egSU.AYUAbz(context, 2114387870);
        AYUAbz2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        AYUAbz2.setBackgroundColor(Color.parseColor("#00000000"));
        AYUAbz2.setGravity(16);
        AYUAbz2.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387817);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14, -1);
        textView.setLayoutParams(layoutParams);
        textView.setIncludeFontPadding(false);
        textView.setText(jk.xj(context, "tt_video_without_wifi_tips"));
        textView.setTextColor(jk.tf(context, "tt_ssxinzi9"));
        textView.setTextSize(2, 14.0f);
        textView.setVisibility(8);
        AYUAbz2.addView(textView);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387880);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 2114387817);
        layoutParams2.addRule(13, -1);
        relativeLayout.setLayoutParams(layoutParams2);
        ImageView AMqCpz = A2egSU.AMqCpz(context, 2114387800);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(r.w(context, 44.0f), r.w(context, 44.0f));
        layoutParams3.addRule(15, -1);
        layoutParams3.addRule(14, -1);
        AMqCpz.setLayoutParams(layoutParams3);
        AMqCpz.setScaleType(ImageView.ScaleType.FIT_XY);
        jk.xj(context, "tt_new_play_video", AMqCpz);
        relativeLayout.addView(AMqCpz);
        AYUAbz2.addView(relativeLayout);
        return AYUAbz2;
    }
}
