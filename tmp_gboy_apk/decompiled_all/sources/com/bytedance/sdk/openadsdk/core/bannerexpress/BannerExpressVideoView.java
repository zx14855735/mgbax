package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BannerExpressVideoView extends xj {
    public BannerExpressVideoView(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        super(context, wsVar, hfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.xj
    public /* bridge */ /* synthetic */ NativeExpressView getCurView() {
        return super.getCurView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.xj
    public /* bridge */ /* synthetic */ NativeExpressView getNextView() {
        return super.getNextView();
    }

    public com.bytedance.sdk.openadsdk.core.multipro.hf.xj getVideoModel() {
        NativeExpressView nativeExpressView = this.hf;
        if (nativeExpressView != null) {
            return ((NativeExpressVideoView) nativeExpressView).getVideoModel();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.xj
    public /* bridge */ /* synthetic */ boolean hf() {
        return super.hf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.xj
    public /* bridge */ /* synthetic */ void kd() {
        super.kd();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.xj
    public /* bridge */ /* synthetic */ void setDuration(int i) {
        super.setDuration(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.xj
    public /* bridge */ /* synthetic */ void setExpressInteractionListener(com.bytedance.sdk.openadsdk.core.nativeexpress.xj xjVar) {
        super.setExpressInteractionListener(xjVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.xj
    public /* bridge */ /* synthetic */ void setVideoAdListener(com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar) {
        super.setVideoAdListener(wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.xj
    public /* bridge */ /* synthetic */ void u() {
        super.u();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.xj
    public /* bridge */ /* synthetic */ void w() {
        super.w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.xj
    public void xj() {
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(this.xj, this.u, this.kd, this.tf);
        this.hf = nativeExpressVideoView;
        addView(nativeExpressVideoView, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.xj
    public void xj(ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(this.xj, wsVar, hfVar, this.tf);
        this.w = nativeExpressVideoView;
        nativeExpressVideoView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.xj() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressVideoView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
            public void xj(View view, int i) {
                BannerExpressVideoView bannerExpressVideoView = BannerExpressVideoView.this;
                com.bytedance.sdk.openadsdk.core.nativeexpress.xj xjVar = bannerExpressVideoView.y;
                if (xjVar != null) {
                    xjVar.xj(bannerExpressVideoView, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
            public void xj(View view, float f, float f2) {
                BannerExpressVideoView.this.xj(f, f2);
                BannerExpressVideoView.this.y();
            }
        });
        r.xj((View) this.w, 8);
        addView(this.w, new ViewGroup.LayoutParams(-1, -1));
    }
}
