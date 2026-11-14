package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends e<ClickSlideUpView> {
    public u(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.w.c cVar) {
        super(context, dynamicBaseWidget, cVar);
        xj(cVar);
    }

    private void xj(com.bytedance.sdk.component.adexpress.dynamic.w.c cVar) {
        this.xj = new ClickSlideUpView(this.hf);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.u.f.xj(this.hf, cVar.hl());
        this.xj.setLayoutParams(layoutParams);
        this.xj.setSlideText(this.u.aq());
        SlideUpView slideUpView = this.xj;
        if (slideUpView instanceof ClickSlideUpView) {
            ((ClickSlideUpView) slideUpView).setButtonText(this.u.tf());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e, com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public void hf() {
        this.xj.hf();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public void u() {
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e, com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public void xj() {
        this.xj.xj();
    }
}
