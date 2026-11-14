package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.widget.c;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f extends AlertDialog {
    private com.bytedance.sdk.openadsdk.core.ugeno.c.c c;
    private boolean f;
    private JSONObject hf;
    private String kd;
    private c.xj u;
    private Context w;
    private JSONObject xj;
    private com.bytedance.sdk.openadsdk.core.ugeno.xj y;

    public f(String str, Context context, JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.sdk.openadsdk.core.ugeno.c.c cVar, ws wsVar) {
        super(context, jk.f(context, "tt_dialog_full"));
        this.c = cVar;
        this.w = context;
        this.xj = jSONObject;
        this.kd = str;
        this.hf = jSONObject2;
        this.y = new com.bytedance.sdk.openadsdk.core.ugeno.xj(context, wsVar);
    }

    private void hf() {
        if (this.xj == null || this.hf == null || this.y == null) {
            return;
        }
        this.f = false;
        final FrameLayout frameLayout = new FrameLayout(this.w);
        this.y.xj(this.xj, this.hf, new com.bytedance.sdk.openadsdk.core.ugeno.c.c() { // from class: com.bytedance.sdk.openadsdk.core.widget.f.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.c
            public void xj(int i, String str) {
                f.this.f = true;
                if (f.this.c != null) {
                    FrameLayout frameLayout2 = frameLayout;
                    if (frameLayout2 != null) {
                        frameLayout2.removeAllViews();
                    }
                    f.this.c.xj(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.c
            public void xj(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
                f.this.f = false;
                if (f.this.c != null) {
                    f.this.c.xj(null);
                }
                frameLayout.addView(wVar.d(), new FrameLayout.LayoutParams(wVar.l(), wVar.ff()));
                f.this.setContentView(frameLayout);
            }
        });
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        c.xj xjVar = this.u;
        if (xjVar != null) {
            xjVar.w(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hf();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.f) {
            hide();
            dismiss();
        }
    }

    public String xj() {
        return this.kd;
    }

    public void xj(c.xj xjVar) {
        this.u = xjVar;
        com.bytedance.sdk.openadsdk.core.ugeno.xj xjVar2 = this.y;
        if (xjVar2 != null) {
            xjVar2.xj(xjVar);
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.core.ugeno.c.c cVar) {
        this.c = cVar;
    }
}
