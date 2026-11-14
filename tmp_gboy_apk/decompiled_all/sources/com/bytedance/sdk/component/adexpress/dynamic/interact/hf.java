package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.CircleLongPressView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements c {
    private CircleLongPressView xj;

    public hf(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.w.c cVar) {
        this.xj = new CircleLongPressView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.u.f.xj(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.u.f.xj(context, 180.0f));
        layoutParams.gravity = 17;
        this.xj.setLayoutParams(layoutParams);
        this.xj.setGuideText(cVar.aq());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public void hf() {
        this.xj.hf();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public CircleLongPressView w() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public void xj() {
        this.xj.xj();
    }
}
