package com.bytedance.sdk.openadsdk.core.kd.hf;

import com.sigmob.sdk.base.n;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    public static JSONObject xj(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            String upperCase = com.bytedance.sdk.component.utils.kd.hf("id=" + str + "&timestamp=" + currentTimeMillis + "&ext=" + str2).toUpperCase();
            jSONObject.put(f.f13353a, str);
            jSONObject.put("timestamp", currentTimeMillis);
            jSONObject.put("sign", upperCase);
            jSONObject.put(n.m, str2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
