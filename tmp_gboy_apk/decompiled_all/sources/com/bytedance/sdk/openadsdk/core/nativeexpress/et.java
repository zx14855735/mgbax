package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class et implements SSWebView.hf {
    private ws hf;
    private j w;
    private SSWebView xj;

    public et(SSWebView sSWebView, j jVar, ws wsVar) {
        this.xj = sSWebView;
        this.hf = wsVar;
        this.w = jVar;
    }

    private boolean xj() {
        SSWebView sSWebView = this.xj;
        if (sSWebView == null) {
            return false;
        }
        return l.hf(sSWebView, 50, wo.f(this.hf));
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView.hf
    public void xj(final int i) {
        boolean xj = xj();
        com.bytedance.sdk.component.utils.pl.hf("xeasy", "wv:".concat(String.valueOf(xj)));
        if (xj) {
            if (com.bytedance.sdk.openadsdk.core.pz.hf().d()) {
                SSWebView sSWebView = this.xj;
                if (sSWebView != null) {
                    com.bytedance.sdk.openadsdk.core.a.l.xj((WeakReference<ViewGroup>) new WeakReference((ViewGroup) sSWebView.getParent()), new com.bytedance.sdk.openadsdk.core.hf.w() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.et.1
                        @Override // com.bytedance.sdk.openadsdk.core.hf.w
                        public void xj() {
                            if (et.this.w != null) {
                                et.this.w.xj(i);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            j jVar = this.w;
            if (jVar != null) {
                jVar.xj(i);
            }
        }
    }
}
