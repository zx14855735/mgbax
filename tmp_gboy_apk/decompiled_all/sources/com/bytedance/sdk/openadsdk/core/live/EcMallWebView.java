package com.bytedance.sdk.openadsdk.core.live;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.am.kd;
import com.bytedance.sdk.openadsdk.core.ht;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.jk.u;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.x.c;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class EcMallWebView extends SSWebView {
    private u c;
    j kd;
    private final ws y;

    public EcMallWebView(final Context context, ws wsVar, final int i) {
        super(context);
        this.y = wsVar;
        c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.EcMallWebView.1
            @Override // java.lang.Runnable
            public void run() {
                EcMallWebView.this.xj(context, i);
            }
        });
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, android.view.View, com.bytedance.sdk.component.g.w
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        j jVar = this.kd;
        if (jVar != null) {
            jVar.p(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Context context, int i) {
        this.kd = new j(context);
        final String xj = wo.xj(i);
        this.c = new u() { // from class: com.bytedance.sdk.openadsdk.core.live.EcMallWebView.2
            @Override // com.bytedance.sdk.openadsdk.core.jk.u
            public void hf() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jk.u
            public void xj() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jk.u
            public void xj(int i2) {
                if (EcMallWebView.this.y != null) {
                    com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar = (com.bytedance.sdk.openadsdk.zg.w.xj.hf) ht.xj(EcMallWebView.this.y.ke(), com.bytedance.sdk.openadsdk.zg.w.xj.hf.class);
                    if (hfVar != null) {
                        hfVar.xj(2, null);
                    }
                } else {
                    pl.xj("EcMallWebView", "onSendReward failed meta null");
                }
                com.bytedance.sdk.openadsdk.core.am.u.xj(xj, EcMallWebView.this.y);
            }
        };
        this.kd.hf(this).xj(this.y).hf(this.y.ho()).u(this.y.jf()).w(i).kd(wo.zg(this.y)).xj((SSWebView) this).xj(xj).xj(this.c).xj(true);
        setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.xj.u(context, this.kd, this.y.ho(), new kd(this.y, this).hf(true)));
        setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.xj.w(this.kd));
        String y = v.y(this.y);
        if (TextUtils.isEmpty(y)) {
            y = this.y.ol();
        }
        if (TextUtils.isEmpty(y)) {
            return;
        }
        loadUrl(y);
    }
}
