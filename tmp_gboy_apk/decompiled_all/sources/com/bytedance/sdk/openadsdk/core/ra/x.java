package com.bytedance.sdk.openadsdk.core.ra;

import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class x {
    private long hf;
    private int w;
    private int xj;

    public static x xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        x xVar = new x();
        xVar.xj = jSONObject.optInt("refresh_control", 0);
        xVar.hf = jSONObject.optLong("refresh_imp_max_time", 0L);
        xVar.w = jSONObject.optInt("refresh_num", 0);
        return xVar;
    }

    public void hf(JSONObject jSONObject) {
        try {
            jSONObject.put("refresh_control", this.xj);
            jSONObject.put("refresh_imp_max_time", this.hf);
            jSONObject.put("refresh_num", this.w);
        } catch (JSONException unused) {
        }
    }

    public int w() {
        return this.w;
    }

    public static boolean w(ws wsVar) {
        return com.bytedance.sdk.openadsdk.core.pz.hf().zg(String.valueOf(com.bytedance.sdk.openadsdk.core.a.wo.d(wsVar))) && xj(wsVar) && !com.bytedance.sdk.openadsdk.core.zg.u.xj(String.valueOf(com.bytedance.sdk.openadsdk.core.a.wo.d(wsVar)));
    }

    public long hf() {
        return this.hf;
    }

    public static int hf(ws wsVar) {
        x lq;
        if (wsVar == null || (lq = wsVar.lq()) == null) {
            return 0;
        }
        return lq.w();
    }

    public static boolean xj(ws wsVar) {
        x lq;
        return (wsVar == null || (lq = wsVar.lq()) == null || lq.xj() != 1) ? false : true;
    }

    public int xj() {
        return this.xj;
    }

    public static boolean xj(List<ws> list) {
        Iterator<ws> it = list.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            if (it.next().yq() == 100.0f) {
                z = true;
            } else {
                z2 = true;
            }
        }
        return (z && z2) ? false : true;
    }
}
