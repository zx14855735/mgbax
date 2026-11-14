package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.utils.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicTimeOuterSkip extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.w {
    private boolean xj;

    public DynamicTimeOuterSkip(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null) {
            this.xj = dynamicRootView.getRenderRequest().zg();
        }
    }

    private String xj(boolean z) {
        String xj = jk.xj(com.bytedance.sdk.component.adexpress.u.getContext(), "tt_reward_screen_skip_tx");
        if (!"skip-with-time-skip-btn".equals(this.g.tf().getType())) {
            return xj;
        }
        if (com.bytedance.sdk.component.adexpress.u.xj() && this.xj) {
            xj = "X";
        }
        return z ? xj : "| ".concat(String.valueOf(xj));
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        super.f();
        if (!A2egSU.BNL6CD(this.g, "skip-with-time-skip-btn")) {
            return true;
        }
        ((TextView) this.qt).setText("");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void kd() {
        if (TextUtils.equals("skip-with-time-skip-btn", this.g.tf().getType())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.c, this.f);
            layoutParams.gravity = 8388629;
            setLayoutParams(layoutParams);
            this.qt.setTextAlignment(1);
            ((TextView) this.qt).setGravity(17);
        } else {
            super.kd();
        }
        if (!"skip-with-time-skip-btn".equals(this.g.tf().getType())) {
            this.qt.setTextAlignment(1);
            ((TextView) this.qt).setGravity(17);
        }
        setVisibility(8);
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
        int i2 = 0;
        if (z) {
            ((TextView) this.qt).setText(xj(z2));
        } else {
            if (z2) {
                ((TextView) this.qt).setText(xj(z2));
            }
            if (!z2) {
                i2 = 8;
            }
        }
        setVisibility(i2);
    }
}
