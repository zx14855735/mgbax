package com.bytedance.sdk.openadsdk.core.x.u;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.w.u;
import com.bytedance.sdk.openadsdk.core.x.hf;
import com.bytedance.sdk.openadsdk.core.x.p;
import com.bytedance.sdk.openadsdk.core.x.tf;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends tf implements hf {
    private static volatile xj hf;
    private AtomicBoolean xj = new AtomicBoolean(false);

    private xj() {
    }

    public static void kd() {
        w().u();
    }

    public static xj w() {
        if (hf == null) {
            synchronized (xj.class) {
                try {
                    if (hf == null) {
                        hf = new xj();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        try {
            AtomicBoolean atomicBoolean = this.xj;
            if (atomicBoolean == null || atomicBoolean.getAndSet(true)) {
                return;
            }
            xj(pz.getContext());
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.tf
    public JSONObject hf(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("business_name", "common");
            jSONObject.put("business_type", 2);
            jSONObject.put("general_params", new JSONObject());
            return jSONObject;
        } catch (Exception e) {
            e.getMessage();
            return jSONObject;
        }
    }

    public void u() {
        c.hf(new d("pity_splopt") { // from class: com.bytedance.sdk.openadsdk.core.x.u.xj.1
            @Override // java.lang.Runnable
            public void run() {
                xj.this.y();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.tf
    public void xj(int i, com.bytedance.sdk.openadsdk.core.x.d dVar) {
        if (f.zg().hl()) {
            try {
                Field[] declaredFields = dVar.w().getClass().getDeclaredFields();
                for (int i2 = 0; i2 < declaredFields.length; i2++) {
                    declaredFields[i2].setAccessible(true);
                    declaredFields[i2].get(dVar.w());
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.hf
    public String hf() {
        return MediationConstant.RIT_TYPE_SPLASH;
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.tf
    public boolean xj() {
        return p.w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.hf
    public String xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if ("spl_load_strategy".equalsIgnoreCase(str)) {
            return u.xj().ht();
        }
        return com.bytedance.sdk.openadsdk.ats.u.xj(hf()).get(str, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.hf
    public void xj(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("spl_load_strategy".equalsIgnoreCase(str)) {
            u.xj().zg(str2);
        } else {
            com.bytedance.sdk.openadsdk.ats.u.xj(hf()).put(str, str2);
        }
    }
}
