package com.bytedance.sdk.component.adexpress.dynamic.u;

import com.bytedance.sdk.component.adexpress.hf.g;
import com.bytedance.sdk.component.utils.pl;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c implements f {
    private com.bytedance.sdk.component.adexpress.dynamic.kd.hf xj;

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(g gVar) {
        try {
            JSONObject kd = gVar.kd();
            JSONObject jSONObject = new JSONObject(kd.optString("template_Plugin"));
            JSONObject optJSONObject = kd.optJSONObject("creative");
            com.bytedance.sdk.component.adexpress.dynamic.w.f xj = new y(jSONObject, optJSONObject, kd.optJSONObject("AdSize"), new JSONObject(kd.optString("diff_template_Plugin"))).xj(gVar.u(), gVar.g(), optJSONObject.optDouble("score_exact_i18n"), optJSONObject.optString("comment_num_i18n"), gVar);
            try {
                JSONObject jSONObject2 = new JSONObject(optJSONObject.optString("dynamic_creative"));
                xj.xj(jSONObject2.optString("color"));
                xj.xj(jSONObject2.optJSONArray("material_center"));
            } catch (Throwable unused) {
            }
            this.xj.xj(xj);
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.u.f
    public void xj(com.bytedance.sdk.component.adexpress.dynamic.kd.hf hfVar) {
        this.xj = hfVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.u.f
    public void xj(final g gVar) {
        if (gVar.qt() == 1) {
            hf(gVar);
        } else {
            com.bytedance.sdk.component.adexpress.u.kd.xj(new com.bytedance.sdk.component.tf.d("dynamicparse") { // from class: com.bytedance.sdk.component.adexpress.dynamic.u.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.hf(gVar);
                }
            }, 5);
        }
    }
}
