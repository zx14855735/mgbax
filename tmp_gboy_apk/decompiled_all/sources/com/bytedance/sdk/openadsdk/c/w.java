package com.bytedance.sdk.openadsdk.c;

import android.text.TextUtils;
import com.bytedance.sdk.component.d.hf.u;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class w extends xj {
    public static hf xj;

    public static void hf(JSONObject jSONObject, int i) {
        try {
            hf xj2 = com.bytedance.sdk.openadsdk.core.wo.xj.w.xj(TKDownloadReason.KSAD_TK_NET);
            if (xj2 != null && jSONObject != null) {
                String jSONObject2 = com.bytedance.sdk.component.utils.xj.xj(jSONObject.toString()).toString();
                HashMap hashMap = new HashMap();
                hashMap.put("body", jSONObject2);
                hashMap.put(PointParamKey.TYPE, Integer.valueOf(i));
                xj2.call(3, hashMap);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.xj
    public String xj() {
        return TKDownloadReason.KSAD_TK_NET;
    }

    public static String xj(u uVar, String str) {
        Map map;
        hf xj2 = com.bytedance.sdk.openadsdk.core.wo.xj.w.xj(TKDownloadReason.KSAD_TK_NET);
        if (xj2 == null || (map = (Map) xj2.call(1, str)) == null) {
            return str;
        }
        String str2 = (String) map.get("url");
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        Map map2 = (Map) map.get("header");
        if (map2 != null) {
            for (String str3 : map2.keySet()) {
                uVar.hf(str3, (String) map2.get(str3));
            }
        }
        return str;
    }

    public static void xj(JSONObject jSONObject, int i) {
        try {
            hf xj2 = com.bytedance.sdk.openadsdk.core.wo.xj.w.xj(TKDownloadReason.KSAD_TK_NET);
            if (xj2 == null) {
                return;
            }
            String jSONObject2 = com.bytedance.sdk.component.utils.xj.xj(jSONObject.toString()).toString();
            HashMap hashMap = new HashMap();
            hashMap.put("body", jSONObject2);
            hashMap.put(PointParamKey.TYPE, Integer.valueOf(i));
            xj2.call(2, hashMap);
        } catch (Throwable unused) {
        }
    }
}
