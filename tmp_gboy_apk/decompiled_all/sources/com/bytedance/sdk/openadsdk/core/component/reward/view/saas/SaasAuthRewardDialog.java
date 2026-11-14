package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import J3FDQU.A2egSU;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.zg;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.f.w;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.ra.r;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.f.hf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SaasAuthRewardDialog extends RelativeLayout implements Runnable {
    private static boolean tf;
    private ws c;
    private int d;
    private String f;
    private BaseSaasEnvelope hf;
    private ScaleAnimation kd;
    private RotateAnimation u;
    private ImageView w;
    private SaasAuthEnvelope xj;
    private boolean y;

    public static class xj implements dk {
        private xj() {
        }

        @Override // com.bytedance.sdk.component.y.dk
        public void onFailed(int i, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.component.y.dk
        public void onSuccess(zg zgVar) {
        }
    }

    public SaasAuthRewardDialog(Context context) {
        super(context);
        this.y = false;
        xj(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j.hf(false);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (getVisibility() == 0) {
            if (this.y) {
                setVisibility(8);
                return;
            } else {
                f.hf().postDelayed(this, PushUIConfig.dismissTime);
                hf();
                return;
            }
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.kd = scaleAnimation;
        scaleAnimation.setDuration(600L);
        this.kd.setFillAfter(true);
        this.kd.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SaasAuthRewardDialog.this.u = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
                SaasAuthRewardDialog.this.u.setDuration(PushUIConfig.dismissTime);
                SaasAuthRewardDialog.this.u.setRepeatCount(-1);
                SaasAuthRewardDialog.this.u.setFillAfter(true);
                SaasAuthRewardDialog.this.u.setInterpolator(new LinearInterpolator());
                SaasAuthRewardDialog.this.w.startAnimation(SaasAuthRewardDialog.this.u);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.w.startAnimation(this.kd);
        j.hf(true);
        setVisibility(0);
        this.xj.xj();
        f.hf().postDelayed(this, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf() {
        this.y = true;
        r bi = this.c.bi();
        if (bi.tf() != null) {
            this.hf = new SaasAuthCouponEnvelope(getContext(), bi.tf());
        } else if (bi.p() != null) {
            this.hf = new SaasAuthProductEnvelope(getContext(), bi.p());
        }
        BaseSaasEnvelope baseSaasEnvelope = this.hf;
        if (baseSaasEnvelope != null) {
            addView(baseSaasEnvelope, new RelativeLayout.LayoutParams(-1, -1));
            this.hf.xj();
            com.bytedance.sdk.openadsdk.core.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.hf.xj(getContext(), this.c, this.f, this.d);
            setTag(TTAdConstant.KEY_CLICK_AREA, 2917);
            com.bytedance.sdk.component.p.kd.xj.xj().xj(this.c.hashCode() + this.c.zf()).put("live_saas_interaction_type", 101);
            setOnClickListener(xjVar);
            this.hf.setOnCloseClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SaasAuthRewardDialog.this.xj();
                }
            });
            this.hf.setOnButtonClickListener(xjVar);
        }
        SaasAuthEnvelope saasAuthEnvelope = this.xj;
        if (saasAuthEnvelope != null) {
            saasAuthEnvelope.hf();
        }
        removeView(this.xj);
    }

    private void w() {
        try {
            if (tf) {
                return;
            }
            xj xjVar = new xj();
            hf.xj(w.xj("saas_light_shine.webp")).to(xjVar);
            hf.xj(w.xj("saas_red_envelope.webp")).to(xjVar);
            hf.xj(w.xj("saas_reward_goods_bg.webp")).to(xjVar);
            hf.xj(w.xj("saas_reward_coupon_bg.webp")).to(xjVar);
            hf.xj(w.xj("saas_reward_title.webp")).to(xjVar);
            tf = true;
        } catch (Throwable unused) {
        }
    }

    public void xj(ws wsVar, String str, int i) {
        if (wsVar != null && com.bytedance.sdk.openadsdk.core.live.hf.xj().w() == 2) {
            r bi = wsVar.bi();
            if (bi != null && ((bi.p() != null || bi.tf() != null) && bi.d())) {
                this.c = wsVar;
                this.f = str;
                this.d = i;
                setBackgroundColor(Color.parseColor("#aa000000"));
                f.hf().postDelayed(this, PushUIConfig.dismissTime);
                xj(getContext());
                w();
                return;
            }
            setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    private void xj(Context context) {
        this.w = new ImageView(context);
        try {
            hf.xj(w.xj("saas_light_shine.webp")).to(this.w);
            this.w.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } catch (Error unused) {
        }
        int u = com.bytedance.sdk.openadsdk.core.a.r.u(context);
        addView(this.w, A2egSU.ASJ6gh(u, u, 13));
        SaasAuthEnvelope saasAuthEnvelope = new SaasAuthEnvelope(context);
        this.xj = saasAuthEnvelope;
        saasAuthEnvelope.setId(2114387464);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.xj, layoutParams);
        this.xj.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SaasAuthRewardDialog.this.hf();
                f.hf().removeCallbacks(SaasAuthRewardDialog.this);
            }
        });
        this.xj.setOnCloseClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SaasAuthRewardDialog.this.xj();
            }
        });
    }

    public void xj() {
        SaasAuthEnvelope saasAuthEnvelope = this.xj;
        if (saasAuthEnvelope != null) {
            saasAuthEnvelope.hf();
        }
        BaseSaasEnvelope baseSaasEnvelope = this.hf;
        if (baseSaasEnvelope != null) {
            baseSaasEnvelope.hf();
        }
        RotateAnimation rotateAnimation = this.u;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
            this.u = null;
        }
        ScaleAnimation scaleAnimation = this.kd;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
            this.kd = null;
        }
        f.hf().removeCallbacks(this);
        setVisibility(8);
        j.hf(false);
    }
}
