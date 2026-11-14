package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.adexpress.widget.TTRatingBar2;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicStarView extends DynamicBaseWidgetImp {
    private int xj;

    public DynamicStarView(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        this.xj = 0;
        TTRatingBar2 tTRatingBar2 = new TTRatingBar2(context, null);
        this.qt = tTRatingBar2;
        tTRatingBar2.setTag(Integer.valueOf(getClickArea()));
        addView(this.qt, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        DynamicRootView dynamicRootView;
        super.f();
        double g = this.f10177pl.g();
        if (com.bytedance.sdk.component.adexpress.u.xj() && (g < 0.0d || g > 5.0d || ((dynamicRootView = this.am) != null && dynamicRootView.getRenderRequest() != null && this.am.getRenderRequest().g() != 4))) {
            this.qt.setVisibility(8);
            return true;
        }
        double d = (g < 0.0d || g > 5.0d) ? 5.0d : g;
        this.qt.setVisibility(0);
        ((TTRatingBar2) this.qt).xj(d, this.f10177pl.c(), (int) this.f10177pl.kd(), ((int) com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.hf())) + ((int) com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.xj())) + ((int) com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.kd())));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        int xj = (int) (com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), this.f10177pl.u()) + this.f10177pl.w()) + (com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), this.f10177pl.kd()) * 5.0f));
        if (this.c > xj && 4 == this.f10177pl.f()) {
            this.xj = (this.c - xj) / 2;
        }
        this.c = xj;
        return new FrameLayout.LayoutParams(this.c, this.f);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void kd() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.c, this.f);
        layoutParams.topMargin = this.tf;
        int i = this.d + this.xj;
        layoutParams.leftMargin = i;
        layoutParams.setMarginStart(i);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }
}
