package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.u.p;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.adexpress.u.c;
import com.bytedance.sdk.component.utils.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicTimeOuter extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.w {
    private boolean hf;
    private boolean jk;
    private boolean xj;

    public DynamicTimeOuter(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        dynamicRootView.setTimeOutListener(this);
        if ("timedown".equals(fVar.tf().getType())) {
            dynamicRootView.setTimedown(this.f);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        super.f();
        if (c.hf(this.am.getRenderRequest().y())) {
            setVisibility(8);
        }
        if ("timedown".equals(this.g.tf().getType())) {
            ((TextView) this.qt).setText(String.valueOf((int) Double.parseDouble(this.f10177pl.tf())));
            return true;
        }
        ((TextView) this.qt).setText(((int) Double.parseDouble(this.f10177pl.tf())) + "s");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void kd() {
        if (!TextUtils.equals("skip-with-countdowns-video-countdown", this.g.tf().getType()) && !TextUtils.equals("skip-with-time-countdown", this.g.tf().getType())) {
            super.kd();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.c, this.f);
        layoutParams.gravity = 8388627;
        if (com.bytedance.sdk.component.adexpress.u.xj()) {
            layoutParams.leftMargin = this.d;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.qt).getText())) {
            setMeasuredDimension(0, this.f);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.w
    public void xj(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 || this.jk) {
            ((TextView) this.qt).setText("");
            setVisibility(8);
            return;
        }
        try {
            if (Integer.parseInt((String) charSequence) <= 0) {
                setVisibility(8);
                return;
            }
        } catch (Exception unused) {
        }
        setVisibility(0);
        if (!z && this.am.getRenderRequest().w() && c.hf(this.am.getRenderRequest().y())) {
            if (com.bytedance.sdk.component.adexpress.u.xj()) {
                ((TextView) this.qt).setText(i + "s");
            } else {
                ((TextView) this.qt).setText(String.format(jk.xj(com.bytedance.sdk.component.adexpress.u.getContext(), "tt_reward_full_skip"), Integer.valueOf(i)));
            }
            this.xj = true;
            return;
        }
        if (com.bytedance.sdk.component.adexpress.u.xj() && !"open_ad".equals(this.am.getRenderRequest().y()) && this.am.getRenderRequest().w()) {
            this.jk = true;
            setVisibility(8);
            return;
        }
        if ("timedown".equals(this.g.tf().getType())) {
            ((TextView) this.qt).setText(charSequence);
            return;
        }
        ((TextView) this.qt).setText(((Object) charSequence) + "s");
        this.hf = true;
        if (this.xj) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), this.f10177pl.u() + this.f10177pl.w()) + p.hf(((TextView) this.qt).getText() != null ? r5.toString() : "", this.f10177pl.kd(), true)[0]), this.f);
            layoutParams.gravity = 8388629;
            this.qt.setLayoutParams(layoutParams);
            this.xj = false;
            requestLayout();
        }
    }
}
