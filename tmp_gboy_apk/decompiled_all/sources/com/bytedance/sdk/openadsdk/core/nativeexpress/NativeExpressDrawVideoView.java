package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class NativeExpressDrawVideoView extends NativeExpressVideoView {
    private int ht;

    public NativeExpressDrawVideoView(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, String str) {
        super(context, wsVar, hfVar, str);
        this.ht = getResources().getConfiguration().orientation;
    }

    private void ra() {
        int i = getResources().getConfiguration().orientation;
        if (this.ht != i) {
            this.ht = i;
            r.xj(this, new r.xj() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressDrawVideoView.1
                @Override // com.bytedance.sdk.openadsdk.core.a.r.xj
                public void xj(View view) {
                    int width = NativeExpressDrawVideoView.this.getWidth();
                    int height = NativeExpressDrawVideoView.this.getHeight();
                    NativeExpressDrawVideoView nativeExpressDrawVideoView = NativeExpressDrawVideoView.this;
                    nativeExpressDrawVideoView.xj(nativeExpressDrawVideoView.am, width, height);
                    View findViewById = NativeExpressDrawVideoView.this.am.findViewById(2114387714);
                    NativeExpressDrawVideoView.this.xj(findViewById, width, height);
                    if (findViewById != null) {
                        findViewById.requestLayout();
                    }
                    NativeExpressDrawVideoView nativeExpressDrawVideoView2 = NativeExpressDrawVideoView.this;
                    nativeExpressDrawVideoView2.xj(nativeExpressDrawVideoView2.getWebView(), width, height);
                    ExpressVideoView expressVideoView = NativeExpressDrawVideoView.this.p;
                    if (expressVideoView != null) {
                        expressVideoView.xj(width, height);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView, com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ra();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ra();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        ra();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView
    public ExpressVideoView xj(Context context, ws wsVar, String str) {
        return new ExpressVideoView(context, wsVar, str, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }
}
