package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class yo implements c<DynamicUnlockView> {
    private final DynamicUnlockView xj;

    public yo(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.w.c cVar) {
        DynamicUnlockView dynamicUnlockView = new DynamicUnlockView(context);
        this.xj = dynamicUnlockView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.u.f.xj(context, cVar.hl() > 0 ? cVar.hl() : com.bytedance.sdk.component.adexpress.u.xj() ? 0 : AVMDLDataLoaderConfigure.DEFAULT_SOCKET_IDLE_TIMEOUT);
        dynamicUnlockView.setLayoutParams(layoutParams);
        dynamicUnlockView.setClipChildren(false);
        dynamicUnlockView.setText(cVar.aq());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public void hf() {
        DynamicUnlockView dynamicUnlockView = this.xj;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.hf();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public DynamicUnlockView w() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.c
    public void xj() {
        DynamicUnlockView dynamicUnlockView = this.xj;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.xj();
        }
    }
}
