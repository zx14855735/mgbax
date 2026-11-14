package com.bytedance.sdk.openadsdk.res.layout.video;

import J3FDQU.A2egSU;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y implements com.bytedance.sdk.openadsdk.res.layout.xj {
    private View u(Context context) {
        RelativeLayout AYUAbz2 = A2egSU.AYUAbz(context, 2114387674);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        AYUAbz2.setLayoutParams(layoutParams);
        AYUAbz2.setVisibility(8);
        TextView AZOQYO2 = A2egSU.AZOQYO(context, 2114387868);
        RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(580, 98, 14, 15);
        BTvldC2.setMargins(0, r.w(context, 20.0f), 0, 0);
        AZOQYO2.setLayoutParams(BTvldC2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#D33F57"));
        gradientDrawable.setCornerRadius(4.0f);
        AZOQYO2.setBackground(gradientDrawable);
        AZOQYO2.setGravity(17);
        AZOQYO2.setPadding(r.w(context, 2.0f), r.w(context, 2.0f), r.w(context, 2.0f), r.w(context, 2.0f));
        AZOQYO2.setTextColor(-1);
        AZOQYO2.setTextSize(0, 34.0f);
        AZOQYO2.setText(jk.xj(context, "tt_download"));
        AZOQYO2.setVisibility(8);
        AYUAbz2.addView(AZOQYO2);
        TextView textView = new TextView(context);
        textView.setId(2114387842);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 2114387868);
        layoutParams2.addRule(14);
        layoutParams2.setMargins(0, 60, 0, 0);
        textView.setLayoutParams(layoutParams2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        textView.setText(jk.xj(context, "tt_click_replay"));
        textView.setTextColor(-1);
        textView.setTextSize(0, 34.0f);
        AYUAbz2.addView(textView);
        return AYUAbz2;
    }

    private View w(Context context) {
        RelativeLayout AYUAbz2 = A2egSU.AYUAbz(context, 2114387961);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        AYUAbz2.setLayoutParams(layoutParams);
        RoundImageView roundImageView = new RoundImageView(context);
        roundImageView.setId(2114387664);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(r.w(context, 44.0f), r.w(context, 44.0f));
        layoutParams2.addRule(14);
        roundImageView.setLayoutParams(layoutParams2);
        roundImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        AYUAbz2.addView(roundImageView);
        TextView textView = new TextView(context);
        textView.setId(2114387957);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(r.w(context, 44.0f), r.w(context, 44.0f));
        layoutParams3.addRule(8, 2114387664);
        layoutParams3.addRule(19, 2114387664);
        layoutParams3.addRule(5, 2114387664);
        layoutParams3.addRule(7, 2114387664);
        layoutParams3.addRule(18, 2114387664);
        layoutParams3.addRule(14);
        textView.setLayoutParams(layoutParams3);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(Color.parseColor("#E0E0E0"));
        textView.setBackground(shapeDrawable);
        textView.setGravity(17);
        textView.setTextColor(-1);
        textView.setTextSize(2, 19.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setVisibility(8);
        AYUAbz2.addView(textView);
        TextView AZOQYO2 = A2egSU.AZOQYO(context, 2114387764);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, 2114387664);
        layoutParams4.addRule(14);
        layoutParams4.setMargins(0, r.w(context, 6.0f), 0, r.w(context, 20.0f));
        AZOQYO2.setLayoutParams(layoutParams4);
        AZOQYO2.setEllipsize(TextUtils.TruncateAt.END);
        AZOQYO2.setMaxLines(1);
        AZOQYO2.setTextColor(-1);
        AZOQYO2.setTextSize(2, 12.0f);
        AYUAbz2.addView(AZOQYO2);
        TextView AZOQYO3 = A2egSU.AZOQYO(context, 2114387686);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, r.w(context, 28.0f));
        layoutParams5.addRule(3, 2114387764);
        layoutParams5.addRule(14);
        layoutParams5.addRule(15);
        layoutParams5.setMargins(0, 0, 0, 0);
        AZOQYO3.setLayoutParams(layoutParams5);
        AZOQYO3.setMinWidth(r.w(context, 72.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.bykv.vk.component.ttvideo.player.A2egSU.A4TApA("#2A90D7", gradientDrawable, context, 6.0f));
        AZOQYO3.setBackground(gradientDrawable);
        AZOQYO3.setGravity(17);
        AZOQYO3.setPadding(r.w(context, 2.0f), r.w(context, 2.0f), r.w(context, 2.0f), r.w(context, 2.0f));
        AZOQYO3.setTextColor(-1);
        AZOQYO3.setTextSize(2, 14.0f);
        AZOQYO3.setVisibility(8);
        AYUAbz2.addView(AZOQYO3);
        return AYUAbz2;
    }

    private View xj(Context context) {
        ImageView AMqCpz = A2egSU.AMqCpz(context, 2114387804);
        AMqCpz.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        AMqCpz.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int parseColor = Color.parseColor("#7f000000");
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_OVER;
        AMqCpz.setColorFilter(parseColor, mode);
        AMqCpz.setImageTintMode(mode);
        return AMqCpz;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.xj
    public View hf(Context context) {
        RelativeLayout AYUAbz2 = A2egSU.AYUAbz(context, 2114387744);
        AYUAbz2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        AYUAbz2.setBackgroundColor(jk.tf(context, "tt_trans_half_black"));
        AYUAbz2.addView(xj(context));
        AYUAbz2.addView(w(context));
        AYUAbz2.addView(u(context));
        return AYUAbz2;
    }
}
