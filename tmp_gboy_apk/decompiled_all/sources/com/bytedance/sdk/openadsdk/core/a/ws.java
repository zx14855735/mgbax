package com.bytedance.sdk.openadsdk.core.a;

import android.util.Pair;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ws extends com.bytedance.sdk.component.d.hf.kd {
    public ws(com.bytedance.sdk.component.hf.xj.pl plVar) {
        super(plVar);
    }

    public void hf(JSONObject jSONObject, String str) {
        if (com.bytedance.sdk.openadsdk.core.pz.hf().ua()) {
            xj(jSONObject, str);
        } else {
            w(com.bytedance.sdk.component.utils.xj.xj(jSONObject).toString());
        }
    }

    public void w(JSONObject jSONObject, String str) {
        if (com.bytedance.sdk.openadsdk.core.pz.hf().le()) {
            xj(jSONObject, str);
        } else {
            w(com.bytedance.sdk.component.utils.xj.xj(jSONObject).toString());
        }
    }

    public void xj(JSONObject jSONObject, String str) {
        Pair<Integer, ?> pair;
        Object obj;
        try {
            pair = com.bytedance.sdk.openadsdk.core.w.y.xj().xj(jSONObject.toString(), str);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.w(th.getMessage());
            pair = null;
        }
        if (pair == null || (obj = pair.first) == null) {
            w(com.bytedance.sdk.component.utils.xj.xj(jSONObject).toString());
        } else {
            if (((Integer) obj).intValue() != 4) {
                xj((JSONObject) pair.second);
                return;
            }
            xj("application/octet-stream", (byte[]) pair.second);
            xj(true);
            hf("x-pglcypher", String.valueOf(pair.first));
        }
    }
}
