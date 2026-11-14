package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.utils.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicSkipCountDownBtn extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.w {
    private int hf;
    private int jk;
    private int[] xj;

    public DynamicSkipCountDownBtn(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        dynamicRootView.setTimeOutListener(this);
    }

    private void d() {
        int xj = (int) com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.kd());
        this.hf = ((this.f - xj) / 2) - this.f10177pl.xj();
        this.jk = 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        super.f();
        ((TextView) this.qt).setText("");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void kd() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.c, this.f);
        layoutParams.gravity = 8388629;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.qt).getText())) {
            setMeasuredDimension(0, this.f);
        } else {
            setMeasuredDimension(this.c, this.f);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.w
    @SuppressLint({"SetTextI18n"})
    public void xj(CharSequence charSequence, boolean z, int i, boolean z2) {
        String xj = jk.xj(com.bytedance.sdk.component.adexpress.u.getContext(), "tt_reward_screen_skip_tx");
        if (i == 0) {
            this.qt.setVisibility(0);
            ((TextView) this.qt).setText("| ".concat(String.valueOf(xj)));
            this.qt.measure(-2, -2);
            this.xj = new int[]{this.qt.getMeasuredWidth() + 1, this.qt.getMeasuredHeight()};
            View view = this.qt;
            int[] iArr = this.xj;
            view.setLayoutParams(new FrameLayout.LayoutParams(iArr[0], iArr[1]));
            ((TextView) this.qt).setGravity(17);
            ((TextView) this.qt).setIncludeFontPadding(false);
            d();
            this.qt.setPadding(this.f10177pl.w(), this.hf, this.f10177pl.u(), this.jk);
        }
        requestLayout();
    }
}
