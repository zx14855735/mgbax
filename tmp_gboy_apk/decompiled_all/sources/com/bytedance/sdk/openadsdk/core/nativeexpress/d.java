package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.bytedance.sdk.openadsdk.core.ra.ws;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d implements com.bytedance.adsdk.ugeno.w.ht, com.bytedance.sdk.component.adexpress.hf.d {
    private com.bytedance.sdk.openadsdk.am.f c;
    private String hf;
    private long kd;
    private String u;
    private ws w;
    private com.bytedance.sdk.openadsdk.y.xj xj;
    private long y;

    public d(com.bytedance.sdk.openadsdk.y.xj xjVar, String str, ws wsVar, String str2) {
        this.xj = xjVar;
        this.hf = str;
        this.u = str2;
        this.w = wsVar;
    }

    public void am() {
        this.xj.qt();
        this.xj.zg();
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.d
    public void c() {
        com.bytedance.sdk.openadsdk.am.f fVar = this.c;
        if (fVar == null) {
            return;
        }
        fVar.y(dk.xj(this.w));
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.d
    public void d() {
        this.xj.w();
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.d
    public void f() {
        this.xj.hf();
        com.bytedance.sdk.openadsdk.am.f fVar = this.c;
        if (fVar == null) {
            return;
        }
        fVar.c(dk.xj(this.w));
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.d
    public void g() {
        this.xj.hf();
    }

    @Override // com.bytedance.adsdk.ugeno.w.ht
    public void kd() {
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.d
    public void p() {
        this.xj.xj(true);
        this.xj.g();
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.d
    public void pl() {
        this.xj.am();
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.d
    public void tf() {
        this.xj.xj(true);
        this.xj.kd();
        com.bytedance.sdk.component.tf.c.w(new com.bytedance.sdk.component.tf.d("native_success") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.d.2
            @Override // java.lang.Runnable
            public void run() {
                f.xj(d.this.hf, d.this.u, d.this.w);
                com.bytedance.sdk.openadsdk.core.am.u.c(d.this.w, d.this.hf, "dynamic_backup_render", null);
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.w.ht
    public void u() {
    }

    @Override // com.bytedance.adsdk.ugeno.w.ht
    public void xj(boolean z) {
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.d
    public void y() {
        this.xj.xj();
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.d
    public void hf(boolean z) {
        this.xj.xj(z ? 1 : 0);
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.d
    public void kd(int i) {
        if (i == 3) {
            this.xj.hf("dynamic_sub_render2_end");
        } else {
            this.xj.hf("dynamic_sub_render_end");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.d
    public void u(int i) {
        if (i == 3) {
            this.xj.hf("dynamic_sub_render2_start");
        } else {
            this.xj.hf("dynamic_sub_render_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.d
    public void w(int i) {
        if (i == 3) {
            this.xj.hf("dynamic_sub_analysis2_end");
        } else {
            this.xj.hf("dynamic_sub_analysis_end");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.d
    public void y(int i) {
        final String str;
        this.y = System.currentTimeMillis();
        if (i == 3) {
            this.xj.w("dynamic_render2_success");
            str = "dynamic2_render";
        } else {
            this.xj.w("dynamic_render_success");
            str = "dynamic_backup_native_render";
        }
        this.xj.xj(true);
        com.bytedance.sdk.component.tf.c.w(new com.bytedance.sdk.component.tf.d("dynamic_success") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.am.u.c(d.this.w, d.this.hf, str, null);
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.d
    public void hf(int i) {
        if (i == 3) {
            this.xj.hf("dynamic_sub_analysis2_start");
        } else {
            this.xj.hf("dynamic_sub_analysis_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.d
    public void xj(int i, String str) {
        this.xj.xj(i, str);
        f.xj(i, this.hf, this.u, this.w);
        com.bytedance.sdk.openadsdk.am.f fVar = this.c;
        if (fVar == null) {
            return;
        }
        fVar.xj(true, dk.xj(this.w), 105);
    }

    @Override // com.bytedance.adsdk.ugeno.w.ht
    public void w() {
        this.xj.u("ugen_sub_render_start");
    }

    @Override // com.bytedance.adsdk.ugeno.w.ht
    public void hf() {
        this.xj.u("ugen_sub_analysis_end");
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.d
    public void xj(int i) {
        this.kd = System.currentTimeMillis();
        if (i == 3) {
            this.xj.xj("dynamic_render2_start");
        } else {
            this.xj.xj("dynamic_render_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.d
    public void xj(int i, int i2, String str, boolean z) {
        this.xj.xj(true);
        if (i == 3) {
            this.xj.hf(i2, "dynamic_render2_error");
        } else {
            this.xj.hf(i2, "dynamic_render_error");
        }
        f.xj(i2, this.hf, this.u, this.w);
    }

    public void xj(com.bytedance.sdk.openadsdk.am.f fVar) {
        this.c = fVar;
    }

    @Override // com.bytedance.adsdk.ugeno.w.ht
    public void xj() {
        this.xj.u("ugen_render_start");
        this.xj.u("ugen_sub_analysis_start");
    }

    @Override // com.bytedance.adsdk.ugeno.w.ht
    public void xj(com.bytedance.adsdk.ugeno.w.pz pzVar) {
        if (pzVar.xj() == 0) {
            this.xj.u("ugen_sub_render_end");
            this.xj.kd("ugen_render_success");
        } else {
            this.xj.w(pzVar.xj(), "ugen_render_error");
        }
        this.xj.xj(true);
    }

    @Override // com.bytedance.adsdk.ugeno.w.ht
    public void xj(JSONObject jSONObject) {
        this.xj.xj(jSONObject);
    }
}
