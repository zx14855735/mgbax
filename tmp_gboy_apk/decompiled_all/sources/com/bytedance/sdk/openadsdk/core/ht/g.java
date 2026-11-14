package com.bytedance.sdk.openadsdk.core.ht;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.lang.reflect.Method;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class g implements com.bytedance.sdk.openadsdk.core.ht.w.xj {
    public static final g xj = new g();

    static {
        sojeyBz();
    }

    private g() {
    }

    private static /* synthetic */ void sojeyBz() {
        char[] charArray = "ðüþ½ôòþö½ñüê½àûöÿÿ½ÙýúÑáú÷ôö".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 147);
        }
        String str = new String(charArray);
        char[] charArray2 = "ðÿúýúç".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 147);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ht.w.xj
    public void xj(final com.bytedance.sdk.openadsdk.p.xj.xj xjVar, final String str, final boolean z) {
        com.bytedance.sdk.openadsdk.x.c.hf(new com.bytedance.sdk.component.tf.d("uploadLogEvent") { // from class: com.bytedance.sdk.openadsdk.core.ht.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (kd.xj(str, 1.0d) || !z) {
                    g.this.xj(xjVar, z);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.p.xj.xj xjVar, boolean z) {
        JSONObject jSONObject;
        try {
            JSONObject xj2 = xjVar.xj().xj();
            if (xj2 != null) {
                String optString = xj2.optString("event_extra");
                if (TextUtils.isEmpty(optString)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(optString);
                }
                int incrementAndGet = hf.hf.incrementAndGet();
                jSONObject.put("stats_index", incrementAndGet);
                jSONObject.put("sdk_session_id", hf.xj);
                jSONObject.put("csj_type", com.bytedance.sdk.openadsdk.core.f.zg().ws() ? 1 : 0);
                if (!TextUtils.isEmpty(wo.d)) {
                    jSONObject.put("wrong_stats_url", wo.d);
                }
                if (!TextUtils.isEmpty(wo.tf)) {
                    jSONObject.put("wrong_applog_url", wo.tf);
                }
                try {
                    jSONObject.put("device_score", Double.parseDouble(com.bytedance.sdk.openadsdk.core.x.xj.xj().xj("DeviceRate", "bytebench_value")));
                } catch (Exception unused) {
                }
                try {
                    jSONObject.put("abtest_version", com.bytedance.sdk.openadsdk.core.f.zg().bl());
                } catch (Exception unused2) {
                }
                if (com.bytedance.sdk.openadsdk.core.f.zg().c()) {
                    jSONObject.putOpt("first_of_two", 1);
                }
                xj2.put("event_extra", jSONObject.toString());
                com.bytedance.sdk.component.f.hf.u.xj.xj xjVar2 = new com.bytedance.sdk.component.f.hf.u.xj.xj(UUID.randomUUID().toString(), xj2);
                xjVar2.w((byte) 0);
                xjVar2.hf((byte) 3);
                xjVar2.xj((byte) 1);
                hf.xj(xjVar2, xj2.optString(PointParamKey.TYPE), incrementAndGet);
            }
        } catch (Throwable unused3) {
        }
    }
}
