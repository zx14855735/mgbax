package com.bytedance.sdk.openadsdk.ats;

import J3FDQU.A2egSU;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.br;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.ht.am;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y implements kd {
    private Map<String, Object> xj;

    @Override // com.bytedance.sdk.openadsdk.ats.kd
    public void hf(String str, Object obj) {
        Map<String, Object> map;
        pl.xj("AutoService", "onReuseServiceRegister key:" + str + " ,obj=" + obj);
        if (TextUtils.isEmpty(str) || obj == null || (map = this.xj) == null) {
            return;
        }
        map.put(str, obj);
    }

    @Override // com.bytedance.sdk.openadsdk.ats.kd
    public void xj(String str, Throwable th) {
        pl.xj("AutoService", "onServiceCreateFailed:".concat(String.valueOf(str)));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(br.c, "ser create failed ".concat(String.valueOf(str)));
        } catch (JSONException unused) {
        }
        am.xj().xj("ats", jSONObject, th);
    }

    @Override // com.bytedance.sdk.openadsdk.ats.kd
    public void xj(String str, String str2, String str3, Throwable th) {
        StringBuilder BChYOn2 = A2egSU.BChYOn("onReuseFailed--:", str, " ", str2, " ");
        BChYOn2.append(str3);
        BChYOn2.append(",");
        pl.xj("AutoService", BChYOn2.toString(), th);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(br.c, str3);
            jSONObject.put("api", str);
            jSONObject.put("impl", str2);
        } catch (JSONException unused) {
        }
        am.xj().xj("ats", jSONObject, th);
    }

    @Override // com.bytedance.sdk.openadsdk.ats.kd
    public void xj(String str, Object obj) {
        pl.xj("AutoService", "onServiceReused key:" + str + " ,obj=" + obj);
    }

    public Map<String, Object> xj() {
        return this.xj;
    }
}
