package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideRightView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class zg implements c {
    private Context hf;
    private com.bytedance.sdk.component.adexpress.dynamic.w.c u;
    private DynamicBaseWidget w;
    private SlideRightView xj;

    public zg(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.w.c cVar) {
        this.hf = context;
        this.w = dynamicBaseWidget;
        this.u = cVar;
        u();
    }

    private void u() {
        this.xj = new SlideRightView(this.hf);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) com.bytedance.sdk.component.adexpress.u.f.xj(this.hf, 120.0f));
        layoutParams.gravity = 17;
        this.xj.setLayoutParams(layoutParams);
        this.xj.setClipChildren(false);
        this.xj.setGuideText(this.u.aq());
        DynamicBaseWidget dynamicBaseWidget = this.w;
        if (dynamicBaseWidget != null) {
            this.xj.setOnClickListener((View.OnClickListener) dynamicBaseWidget.getDynamicClickListener());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public void hf() {
        SlideRightView slideRightView = this.xj;
        if (slideRightView != null) {
            slideRightView.hf();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public ViewGroup w() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public void xj() {
        SlideRightView slideRightView = this.xj;
        if (slideRightView != null) {
            slideRightView.xj();
        }
    }
}
