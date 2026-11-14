package com.bytedance.sdk.openadsdk.core.v.xj;

import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class v extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private final String hf;
    private final WeakReference<com.bytedance.sdk.openadsdk.core.j> xj;

    public v(com.bytedance.sdk.openadsdk.core.j jVar, String str) {
        this.xj = new WeakReference<>(jVar);
        this.hf = str;
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, com.bytedance.sdk.openadsdk.core.j jVar) {
        eVar.xj("interactiveStart", (com.bytedance.sdk.component.xj.kd<?, ?>) new v(jVar, "interactiveStart"));
        eVar.xj("interactiveFinish", (com.bytedance.sdk.component.xj.kd<?, ?>) new v(jVar, "interactiveFinish"));
        eVar.xj("interactiveEnd", (com.bytedance.sdk.component.xj.kd<?, ?>) new v(jVar, "interactiveEnd"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        char c;
        boolean z = true;
        int i = 0;
        JSONObject jSONObject2 = new JSONObject();
        if (this.xj.get() != null) {
            com.bytedance.sdk.openadsdk.core.j jVar = this.xj.get();
            ws f = jVar.f();
            String str = this.hf;
            str.getClass();
            switch (str.hashCode()) {
                case -1055587680:
                    if (str.equals("interactiveStart")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 803356313:
                    if (str.equals("interactiveEnd")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1254561301:
                    if (str.equals("interactiveFinish")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    jVar.zg();
                    return jSONObject2;
                case 1:
                    jVar.e();
                    return jSONObject2;
                case 2:
                    try {
                        if (jSONObject.optInt("finish", 1) != 1) {
                            z = false;
                        }
                        int xj = xj(f, jSONObject.optInt("reduce_duration", -1));
                        if (z) {
                            jVar.u(xj);
                        } else {
                            i = -1;
                        }
                        jSONObject2.put(PluginConstants.KEY_ERROR_CODE, i);
                        jSONObject2.put("reduce_duration", xj);
                        return jSONObject2;
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.pl.xj(e);
                    }
                default:
                    return jSONObject2;
            }
        }
        return jSONObject2;
    }

    public static int xj(ws wsVar, int i) {
        int kf = wsVar != null ? wsVar.kf() : 0;
        if (i >= 0 && kf >= 0) {
            i = Math.min(i, kf);
        } else if (i < 0) {
            i = kf >= 0 ? kf : 0;
        }
        if (aq.kd(wsVar)) {
            return 0;
        }
        return i;
    }
}
