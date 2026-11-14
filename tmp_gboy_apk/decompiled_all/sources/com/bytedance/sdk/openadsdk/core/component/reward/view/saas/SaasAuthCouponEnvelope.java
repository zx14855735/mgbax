package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import J3FDQU.A2egSU;
import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.f.w;
import com.bytedance.sdk.openadsdk.core.ra.r;
import com.bytedance.sdk.openadsdk.f.hf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SaasAuthCouponEnvelope extends BaseSaasEnvelope {
    private TextView xj;

    public SaasAuthCouponEnvelope(Context context, r.hf hfVar) {
        super(context);
        xj(context, hfVar);
    }

    private void xj(Context context, r.hf hfVar) {
        if (hfVar == null) {
            setVisibility(8);
            return;
        }
        RelativeLayout xj = xj(context);
        ImageView imageView = new ImageView(context);
        try {
            hf.xj(w.xj("saas_reward_coupon_bg.webp")).to(imageView);
        } catch (Error unused) {
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        xj.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(context);
        textView.setId(2114387802);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        textView.setLayoutParams(layoutParams);
        layoutParams.topMargin = com.bytedance.sdk.openadsdk.core.a.r.w(context, 20.0f);
        textView.setText("优惠券");
        textView.setTextColor(Color.parseColor("#A9512C"));
        textView.setTextSize(2, 16.0f);
        xj.addView(textView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387461);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams ASJ6gh2 = A2egSU.ASJ6gh(-2, -2, 14);
        ASJ6gh2.addRule(3, textView.getId());
        linearLayout.setLayoutParams(ASJ6gh2);
        TextView textView2 = new TextView(context);
        this.xj = textView2;
        textView2.setId(2114387460);
        this.xj.setText(String.valueOf(hfVar.xj()));
        this.xj.setTextColor(Color.parseColor("#F93F3F"));
        this.xj.setTextSize(2, 60.0f);
        linearLayout.addView(this.xj, new RelativeLayout.LayoutParams(-2, -2));
        TextView textView3 = new TextView(context);
        textView3.setText("元");
        textView3.setTextColor(Color.parseColor("#F93F3F"));
        textView3.setTextSize(2, 20.0f);
        linearLayout.addView(textView3, new RelativeLayout.LayoutParams(-2, -2));
        xj.addView(linearLayout);
        TextView textView4 = new TextView(context);
        textView4.setId(2114387459);
        textView4.setText("满" + hfVar.hf() + "元可用");
        textView4.setTextColor(Color.parseColor("#F93F3F"));
        textView4.setTextSize(2, 16.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, linearLayout.getId());
        layoutParams2.topMargin = com.bytedance.sdk.openadsdk.core.a.r.w(context, -4.0f);
        xj.addView(textView4, layoutParams2);
        TextView textView5 = new TextView(context);
        textView5.setText("领取后30分钟内有效");
        textView5.setTextColor(Color.parseColor("#894200"));
        textView5.setTextSize(2, 14.0f);
        RelativeLayout.LayoutParams ASJ6gh3 = A2egSU.ASJ6gh(-2, -2, 14);
        ASJ6gh3.addRule(3, textView4.getId());
        ASJ6gh3.topMargin = com.bytedance.sdk.openadsdk.core.a.r.w(context, 8.0f);
        xj.addView(textView5, ASJ6gh3);
        xj(context, "一键关联抖音领取", xj);
        addView(xj);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void hf() {
        setVisibility(8);
        super.hf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void xj() {
        setVisibility(0);
    }
}
