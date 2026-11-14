package com.bytedance.sdk.openadsdk.core.dk;

import android.content.Context;
import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.io;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.tf;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private JSONObject hf;
    private ws kd;
    private final Context u = pz.getContext();
    private w w;
    private com.bytedance.sdk.openadsdk.dk.xj.hf.xj.hf xj;

    public hf(ws wsVar) {
        this.kd = wsVar;
    }

    public Context getContext() {
        return this.u;
    }

    public JSONObject hf() {
        JSONObject jSONObject = new JSONObject();
        if (io.xj()) {
            try {
                com.bytedance.sdk.openadsdk.dk.xj.hf.xj.hf hfVar = this.xj;
                if (hfVar != null) {
                    JSONObject xj = hfVar.xj();
                    this.hf = xj;
                    return xj;
                }
            } catch (Exception e) {
                pl.hf("xeasy", e.getMessage());
            }
        }
        return jSONObject;
    }

    public void w() {
        if (io.xj()) {
            pl.xj("xeasy", "oc");
            com.bytedance.sdk.openadsdk.dk.xj.hf.xj.hf hfVar = this.xj;
            if (hfVar != null) {
                hfVar.hf();
            }
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.dk.xj.hf.xj.hf hfVar) {
        this.xj = hfVar;
    }

    public void xj(w wVar) {
        this.w = wVar;
    }

    public ws xj() {
        return this.kd;
    }

    public void xj(ws wsVar) {
        if (this.xj != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style_category", String.valueOf(io.u(wsVar)));
            } catch (JSONException e) {
                pl.xj(e);
            }
            this.xj.xj(jSONObject);
        }
    }

    public void xj(boolean z, JSONObject jSONObject) {
        if (io.xj()) {
            pl.xj("xeasy", "er:".concat(String.valueOf(z)));
            com.bytedance.sdk.openadsdk.dk.xj.hf.xj.hf hfVar = this.xj;
            if (hfVar != null) {
                if (z) {
                    hfVar.hf(jSONObject);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(cb.o, 0);
                hashMap.put("estimatedArea", this.hf);
                hashMap.put("realArea", this.w.getMaxRectJson());
                hashMap.put("exceedAreaRate", Double.valueOf(this.w.getExceedAreaRate()));
                hashMap.put("widgetArea", this.w.getActualRectJson());
                tf.xj(this.kd, false, io.w(this.kd), 2, (Map<String, Object>) hashMap);
                this.xj.w(jSONObject);
            }
        }
    }

    public static void xj(ws wsVar, float f, float f2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("convert", 0);
            jSONObject.put("down_x", f);
            jSONObject.put("down_y", f2);
        } catch (Exception e) {
            pl.xj("xeasy", "e:" + e.getMessage());
        }
        tf.xj(wsVar, false, io.w(wsVar), i, jSONObject);
    }
}
