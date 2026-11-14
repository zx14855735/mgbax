package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicSkipCountDownContainer extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.w {
    private int hf;
    private int jk;
    private int xj;

    public DynamicSkipCountDownContainer(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        setTag(Integer.valueOf(getClickArea()));
        dynamicRootView.setTimeOutListener(this);
        d();
    }

    private void d() {
        List<f> p = this.g.p();
        if (p == null || p.size() <= 0) {
            return;
        }
        for (f fVar : p) {
            if (fVar.tf().xj() == 21) {
                this.xj = (int) (this.c - com.bytedance.sdk.component.adexpress.u.f.xj(this.p, fVar.f()));
            }
            if (fVar.tf().xj() == 20) {
                this.hf = (int) (this.c - com.bytedance.sdk.component.adexpress.u.f.xj(this.p, fVar.f()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        setBackground(getBackgroundDrawable());
        setPadding((int) com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), this.f10177pl.w()), (int) com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), this.f10177pl.hf()), (int) com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), this.f10177pl.u()), (int) com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), this.f10177pl.xj()));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void kd() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i = this.d;
        layoutParams.leftMargin = i;
        layoutParams.topMargin = this.tf;
        layoutParams.setMarginStart(i);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.jk == 0) {
            setMeasuredDimension(this.hf, this.f);
        } else {
            setMeasuredDimension(this.xj, this.f);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.w
    public void xj(CharSequence charSequence, boolean z, int i, boolean z2) {
        this.jk = i;
    }
}
