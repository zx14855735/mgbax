package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.adexpress.u.c;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicTimeOuterContainerWidgetImp extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.w {
    boolean hf;
    private boolean ht;
    private int jk;
    private int pz;
    int xj;

    public DynamicTimeOuterContainerWidgetImp(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        this.pz = 0;
        setTag(Integer.valueOf(getClickArea()));
        d();
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().ai()) {
            return;
        }
        View view = this.qt;
        if (view != null) {
            view.setVisibility(8);
        }
        setVisibility(8);
    }

    private void d() {
        List<f> p = this.g.p();
        if (p == null || p.size() <= 0) {
            return;
        }
        Iterator<f> it = p.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            f next = it.next();
            if (TextUtils.equals("skip-with-time-skip-btn", next.tf().getType())) {
                int xj = (int) com.bytedance.sdk.component.adexpress.u.f.xj(this.p, next.f() + (com.bytedance.sdk.component.adexpress.u.xj() ? next.g() : 0));
                this.jk = xj;
                this.xj = this.c - xj;
            }
        }
        this.pz = this.c - this.xj;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        if (c.hf(this.am.getRenderRequest().y())) {
            return true;
        }
        super.f();
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
        if (this.hf) {
            layoutParams.leftMargin = this.d;
        } else {
            layoutParams.leftMargin = this.d + this.pz;
        }
        if (this.ht && this.f10177pl != null) {
            layoutParams.leftMargin = ((this.d + this.pz) - ((int) com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), this.f10177pl.w()))) - ((int) com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), this.f10177pl.u()));
        }
        if (com.bytedance.sdk.component.adexpress.u.xj()) {
            layoutParams.topMargin = this.tf - ((int) com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), this.f10177pl.hf()));
        } else {
            layoutParams.topMargin = this.tf;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ht && this.f10177pl != null) {
            setMeasuredDimension(this.jk + ((int) com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), this.f10177pl.w())) + ((int) com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), this.f10177pl.u())), this.f);
        } else if (this.hf) {
            setMeasuredDimension(this.c, this.f);
        } else {
            setMeasuredDimension(this.xj, this.f);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.w
    public void xj(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 && this.ht != z2) {
            this.ht = z2;
            kd();
            return;
        }
        if (z && this.hf != z) {
            this.hf = z;
            kd();
        }
        this.hf = z;
    }
}
