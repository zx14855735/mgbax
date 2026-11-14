package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.a.ff;
import com.bytedance.sdk.openadsdk.core.ra.io;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y extends hf {
    private final c c;
    private PlayableFeedWebView kd;
    private final com.bytedance.sdk.openadsdk.core.dk.hf y;

    public y(ws wsVar, boolean z, xj xjVar, w wVar) {
        super(wsVar, xjVar, wVar);
        this.c = new c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.y.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void hf() {
                if (y.this.kd != null) {
                    y.this.kd.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void kd() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void u() {
                if (io.xj() && y.this.y != null) {
                    y.this.y.xj(y.this.xj);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void w() {
                y.this.kd.f();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void xj() {
                if (y.this.kd != null) {
                    y.this.kd.y();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void xj(boolean z2) {
                if (y.this.kd != null) {
                    y.this.kd.xj(z2);
                }
            }
        };
        this.y = new com.bytedance.sdk.openadsdk.core.dk.hf(wsVar);
        this.u = z;
    }

    public void u() {
        PlayableFeedWebView playableFeedWebView = this.kd;
        if (playableFeedWebView != null) {
            playableFeedWebView.destroy();
        }
    }

    public boolean w() {
        return io.hf(this.xj);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.hf
    public int xj() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.hf
    public c hf() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.hf
    public boolean xj(int i, int i2) {
        return true;
    }

    public void xj(final ViewGroup viewGroup, final View view, final boolean z) {
        if (viewGroup == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("render_type", Integer.valueOf(xj()));
            hashMap.put("error_code", 100);
            this.w.xj(false, (Map<String, Object>) hashMap);
            return;
        }
        this.w.xj(xj());
        PlayableFeedWebView playableFeedWebView = new PlayableFeedWebView(this.y, viewGroup);
        this.kd = playableFeedWebView;
        this.y.xj(playableFeedWebView);
        this.kd.setMaterialMeta(ff.xj(this.xj));
        this.kd.setEasyPlayableListener(this.hf);
        viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.y.2
            @Override // java.lang.Runnable
            public void run() {
                y yVar = y.this;
                yVar.xj(viewGroup, view, yVar.kd, z, false, null, null);
            }
        });
    }

    public void xj(com.bytedance.sdk.openadsdk.dk.xj.hf.xj.hf hfVar) {
        this.y.xj(hfVar);
    }
}
