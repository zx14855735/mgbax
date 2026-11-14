package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.widget.w;
import com.sigmob.sdk.base.n;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class g extends w {
    private volatile boolean c;
    private boolean f;
    private JSONObject kd;
    private com.bytedance.sdk.openadsdk.core.ugeno.c.c u;
    Window w;
    private com.bytedance.sdk.openadsdk.core.ugeno.f y;

    public g(Activity activity, JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.ugeno.c.c cVar) {
        super(activity);
        this.w = activity == null ? null : activity.getWindow();
        this.kd = jSONObject;
        this.u = cVar;
        this.y = new com.bytedance.sdk.openadsdk.core.ugeno.f(activity);
    }

    private void c() {
        JSONObject jSONObject = this.kd;
        if (jSONObject == null) {
            return;
        }
        xj(jSONObject.optString("app_name"));
        kd(this.kd.optString(n.r));
        y(this.kd.optString("reg_number"));
        c(this.kd.optString("reg_url"));
        hf(this.kd.optString("icon_url"));
        f(this.kd.optString("developer_name"));
        xj(this.kd.optInt("score"));
        xj(this.kd.optJSONArray("creative_tags"));
        u(this.kd.optString("description"));
    }

    private void kd() {
        if (this.w != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            this.w.setBackgroundDrawable(gradientDrawable);
            WindowManager.LayoutParams attributes = this.w.getAttributes();
            attributes.alpha = 1.0f;
            this.w.setAttributes(attributes);
        }
    }

    private void y() {
        JSONObject jSONObject = this.kd;
        if (jSONObject == null || this.u == null) {
            return;
        }
        JSONObject xj = com.bytedance.sdk.openadsdk.core.ugeno.tf.xj(jSONObject.remove("ugen_url").toString(), this.kd.remove("ugen_md5").toString(), (com.bytedance.sdk.openadsdk.core.ugeno.w) null);
        if (xj == null) {
            this.u.xj(11, "uegnTemplate is empty");
            this.c = true;
        } else {
            final FrameLayout frameLayout = new FrameLayout(this.xj);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.y.xj(xj, this.kd, new com.bytedance.sdk.openadsdk.core.ugeno.c.c() { // from class: com.bytedance.sdk.openadsdk.core.widget.g.1
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.c
                public void xj(int i, String str) {
                    g.this.c = true;
                    if (g.this.u != null) {
                        FrameLayout frameLayout2 = frameLayout;
                        if (frameLayout2 != null) {
                            frameLayout2.removeAllViews();
                        }
                        g.this.u.xj(i, str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.c
                public void xj(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
                    g.this.c = false;
                    if (g.this.u != null) {
                        g.this.u.xj(null);
                    }
                    frameLayout.addView(wVar.d(), new FrameLayout.LayoutParams(wVar.l(), wVar.ff()));
                    g.this.setContentView(frameLayout);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.w
    public void hf() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.w, android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.w, android.app.Dialog
    public void show() {
        super.show();
        if (this.c) {
            hide();
            dismiss();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.w
    public void w() {
        if (this.f) {
            super.w();
        }
    }

    public void hf(w.xj xjVar) {
        super.xj(xjVar);
        com.bytedance.sdk.openadsdk.core.ugeno.f fVar = this.y;
        if (fVar != null) {
            fVar.xj(xjVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.w
    public void xj() {
        if (this.xj == null) {
            this.xj = pz.getContext();
        }
        if (this.xj.getResources().getConfiguration().orientation != 1) {
            this.f = true;
            super.xj();
            super.hf();
            c();
            return;
        }
        kd();
        y();
    }
}
