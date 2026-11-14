package com.bytedance.sdk.openadsdk.core.ai.xj;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.d.hf.u;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.kd;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.tf;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.sigmob.sdk.base.n;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends d {

    /* renamed from: com.bytedance.sdk.openadsdk.core.ai.xj.xj$xj, reason: collision with other inner class name */
    public static class C0136xj {
        private static final xj xj = new xj();

        static {
            XLbNWzV();
        }

        private static /* synthetic */ void XLbNWzV() {
            char[] charArray = "\f\u0000\u0002A\b\u000e\u0002\nA\r\u0000\u0016A\u001c\u0007\n\u0003\u0003A%\u0001\u0006-\u001d\u0006\u000b\b\n".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'o');
            }
            String str = new String(charArray);
            char[] charArray2 = "\f\u0003\u0006\u0001\u0006\u001b".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'o');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        JSONObject en = f.zg().en();
        boolean jw = pz.hf().jw();
        if (en != null) {
            Iterator<String> keys = en.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    JSONObject optJSONObject = en.optJSONObject(next);
                    if (optJSONObject != null) {
                        optJSONObject.put("plugin_update_network", f.zg().et().xj(next));
                    }
                    if (jw && next.equals("com.byted.live.lite")) {
                        jSONObject.putOpt(hf.hf(), optJSONObject);
                    } else {
                        jSONObject.putOpt(next, optJSONObject);
                    }
                }
            }
        }
        return jSONObject;
    }

    private JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oaid", tf.w(false));
            jSONObject.put("conn_type", am.hf(pz.getContext()));
            jSONObject.put("os", 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(PluginConstants.KEY_SDK_VERSION, ai.u);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.3.2");
            jSONObject.put(n.p, wo.d());
            jSONObject.put(n.r, wo.p());
            jSONObject.put("app_code", wo.tf());
            jSONObject.put("vendor", Build.MANUFACTURER);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String pz = f.zg().pz();
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put(PluginConstants.KEY_APP_ID, pz);
            jSONObject.put("req_sign", kd.hf(pz != null ? pz.concat(String.valueOf(currentTimeMillis)).concat(ai.u) : ""));
            jSONObject.put("channel", ai.c);
            jSONObject.put("applog_did", tf.e());
            jSONObject.put("imei", tf.f());
            jSONObject.put(n.l, 1);
            jSONObject.put("device_abi", Build.SUPPORTED_ABIS[0]);
            jSONObject.put("plugins", u());
            jSONObject.put("csj_type", f.zg().ws() ? 1 : 0);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static xj xj() {
        return C0136xj.xj;
    }

    public void hf() {
        if (am.xj(pz.getContext())) {
            c.hf(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bytedance.sdk.component.d.hf.kd hf = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().hf();
        hf.xj(wo.f("/api/ad/union/sdk/settings/plugins"));
        hf.hf("User-Agent", tf.g());
        hf.xj(com.bytedance.sdk.component.utils.xj.xj(w()));
        hf.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ai.xj.xj.1
            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                if (hfVar == null || !hfVar.f() || TextUtils.isEmpty(hfVar.u())) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(hfVar.u());
                    if (jSONObject.optInt("cypher") == 3) {
                        String w = com.bytedance.sdk.component.utils.xj.w(jSONObject.optString("message"));
                        if (TextUtils.isEmpty(w)) {
                            return;
                        }
                        hf.xj().xj(new JSONObject(w).optJSONArray("plugins"));
                    }
                } catch (JSONException unused) {
                }
            }

            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(u uVar, IOException iOException) {
                try {
                    Iterator<String> keys = f.zg().en().keys();
                    while (keys.hasNext()) {
                        hf.xj().xj(keys.next(), PluginConstants.ERROR_PLUGIN_FETCH);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private xj() {
        super("PluginSettingsFetchTask");
    }
}
