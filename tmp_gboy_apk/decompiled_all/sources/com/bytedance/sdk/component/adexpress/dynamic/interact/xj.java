package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.BluePressInteractView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements c {
    private BluePressInteractView xj;

    public xj(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.w.c cVar) {
        double gh = cVar.gh();
        gh = gh == 0.0d ? 1.0d : gh;
        double op = cVar.op();
        int dynamicWidth = (int) (dynamicBaseWidget.getDynamicWidth() * 0.32d * gh);
        int dynamicWidth2 = (int) (dynamicBaseWidget.getDynamicWidth() * 0.32d * (op != 0.0d ? op : 1.0d));
        this.xj = new BluePressInteractView(context, dynamicWidth, dynamicWidth2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicWidth, dynamicWidth2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.u.f.xj(context, cVar.lw() - 7);
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.u.f.xj(context, cVar.wa() - 3);
        this.xj.setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public void hf() {
        this.xj.hf();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public ViewGroup w() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public void xj() {
        this.xj.xj();
    }
}
