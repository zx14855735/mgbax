package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import J3FDQU.A2egSU;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.f.w;
import com.bytedance.sdk.openadsdk.core.ra.r;
import com.bytedance.sdk.openadsdk.f.hf;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import com.czhj.sdk.common.Constants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SaasAuthProductEnvelope extends BaseSaasEnvelope {
    public SaasAuthProductEnvelope(Context context, r.xj xjVar) {
        super(context);
        xj(context, xjVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void hf() {
        super.hf();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void xj() {
    }

    private void xj(Context context, r.xj xjVar) {
        if (xjVar == null) {
            setVisibility(8);
            return;
        }
        RelativeLayout xj = xj(context);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        try {
            hf.xj(w.xj("saas_reward_goods_bg.webp")).to(imageView);
        } catch (Error unused) {
        }
        xj.addView(imageView);
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        textView.setId(2114387802);
        layoutParams.topMargin = com.bytedance.sdk.openadsdk.core.a.r.w(context, 20.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 16.0f);
        textView.setGravity(17);
        textView.setText("超值好物");
        textView.setTextColor(Color.parseColor("#A9512C"));
        textView.setTypeface(null, 1);
        xj.addView(textView);
        TextView textView2 = new TextView(context);
        RelativeLayout.LayoutParams ASJ6gh2 = A2egSU.ASJ6gh(-2, -2, 14);
        ASJ6gh2.addRule(3, textView.getId());
        ASJ6gh2.topMargin = com.bytedance.sdk.openadsdk.core.a.r.w(context, 20.0f);
        textView2.setId(2114387462);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setMaxWidth(com.bytedance.sdk.openadsdk.core.a.r.w(context, 200.0f));
        textView2.setLayoutParams(ASJ6gh2);
        textView2.setTextSize(2, 12.0f);
        textView2.setGravity(17);
        textView2.setText(xjVar.xj());
        textView2.setTextColor(Color.parseColor("#161823"));
        xj.addView(textView2);
        int w = com.bytedance.sdk.openadsdk.core.a.r.w(context, 80.0f);
        int w2 = com.bytedance.sdk.openadsdk.core.a.r.w(context, 10.0f);
        ImageView tTRoundRectImageView = new TTRoundRectImageView(context, w2, w2);
        tTRoundRectImageView.setId(2114387456);
        RelativeLayout.LayoutParams ASJ6gh3 = A2egSU.ASJ6gh(w, w, 14);
        ASJ6gh3.addRule(3, textView2.getId());
        ASJ6gh3.topMargin = com.bytedance.sdk.openadsdk.core.a.r.w(context, 12.0f);
        hf.xj(xjVar.hf()).width(w).height(w).to(tTRoundRectImageView);
        tTRoundRectImageView.setLayoutParams(ASJ6gh3);
        xj.addView(tTRoundRectImageView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387457);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams ASJ6gh4 = A2egSU.ASJ6gh(-2, -2, 14);
        ASJ6gh4.addRule(3, tTRoundRectImageView.getId());
        ASJ6gh4.topMargin = com.bytedance.sdk.openadsdk.core.a.r.w(context, 12.0f);
        linearLayout.setLayoutParams(ASJ6gh4);
        TextView textView3 = new TextView(context);
        textView3.setTextSize(2, 11.0f);
        textView3.setTypeface(null, 1);
        textView3.setTextColor(Color.parseColor("#F93F3F"));
        textView3.setText("¥");
        linearLayout.addView(textView3);
        double u = xjVar.u();
        int floor = (int) Math.floor(u);
        int i = (int) ((u - floor) * 100.0d);
        TextView textView4 = new TextView(context);
        textView4.setTextSize(2, 16.0f);
        textView4.setTypeface(null, 1);
        textView4.setTextColor(Color.parseColor("#F93F3F"));
        textView4.setText(String.valueOf(floor));
        linearLayout.addView(textView4);
        TextView textView5 = new TextView(context);
        textView5.setTextSize(2, 11.0f);
        textView5.setTypeface(null, 1);
        textView5.setTextColor(Color.parseColor("#F93F3F"));
        StringBuilder sb = new StringBuilder(".");
        sb.append(i);
        sb.append(i >= 10 ? "" : Constants.FAIL);
        textView5.setText(sb.toString());
        linearLayout.addView(textView5);
        TextView textView6 = new TextView(context);
        textView6.getPaint().setFlags(16);
        textView6.setTextSize(2, 11.0f);
        textView6.setTextColor(Color.parseColor("#161823"));
        textView6.setText("￥" + xjVar.w());
        linearLayout.addView(textView6);
        xj.addView(linearLayout);
        xj(context, "一键关联抖音购买", xj);
        addView(xj);
    }
}
