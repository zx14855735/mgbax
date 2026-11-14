package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpShakeView;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.adexpress.widget.ShakeClickView;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y extends e<ClickSlideUpShakeView> implements qt {
    public y(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.w.c cVar, com.bytedance.sdk.component.adexpress.dynamic.w.tf tfVar, boolean z, int i) {
        super(context, dynamicBaseWidget, cVar);
        this.hf = context;
        this.u = cVar;
        this.w = dynamicBaseWidget;
        xj(tfVar, cVar, z, i);
    }

    private void xj(com.bytedance.sdk.component.adexpress.dynamic.w.tf tfVar, com.bytedance.sdk.component.adexpress.dynamic.w.c cVar, boolean z, int i) {
        this.xj = new ClickSlideUpShakeView(this.hf, tfVar, z, i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.u.f.xj(this.hf, 300.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.u.f.xj(this.hf, cVar.hl() > 0 ? cVar.hl() : com.bytedance.sdk.component.adexpress.u.xj() ? 0 : AVMDLDataLoaderConfigure.DEFAULT_SOCKET_IDLE_TIMEOUT);
        this.xj.setLayoutParams(layoutParams);
        this.xj.setClipChildren(false);
        this.xj.setSlideText(this.u.aq());
        SlideUpView slideUpView = this.xj;
        if (slideUpView instanceof ClickSlideUpShakeView) {
            ((ClickSlideUpShakeView) slideUpView).setShakeText(this.u.s());
            final ShakeClickView shakeView = ((ClickSlideUpShakeView) this.xj).getShakeView();
            if (shakeView != null) {
                shakeView.setOnShakeViewListener(new ShakeAnimationView.xj() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.y.1
                    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.xj
                    public void xj(boolean z2) {
                        if (y.this.w.getDynamicClickListener() != null) {
                            y.this.w.getDynamicClickListener().xj(z2, y.this);
                        }
                        shakeView.performClick();
                    }
                });
                shakeView.setOnClickListener((View.OnClickListener) this.w.getDynamicClickListener());
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.qt
    public void kd() {
        if (this.xj.getParent() != null) {
            ((ViewGroup) this.xj.getParent()).setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public void u() {
    }
}
