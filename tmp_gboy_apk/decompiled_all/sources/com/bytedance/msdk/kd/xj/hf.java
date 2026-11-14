package com.bytedance.msdk.kd.xj;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.f.ai;
import com.bytedance.sdk.component.utils.pl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements xj<com.bytedance.msdk.core.f.c> {
    private Context xj;

    public hf(Context context) {
        if (context != null) {
            this.xj = context.getApplicationContext();
        }
    }

    private void w(com.bytedance.msdk.core.f.c cVar) {
        if (this.xj == null || cVar == null) {
            return;
        }
        ai xj = ai.xj("freqctl_" + cVar.hf(), this.xj);
        JSONObject xj2 = xj(cVar, false);
        if (xj2 != null) {
            xj.xj(cVar.u(), xj2.toString());
        }
    }

    @Override // com.bytedance.msdk.kd.xj.kd
    public synchronized void delete(String str) {
        if (this.xj != null && !TextUtils.isEmpty(str)) {
            ai.xj("freqctl_".concat(String.valueOf(str)), this.xj).y(str);
        }
    }

    @Override // com.bytedance.msdk.kd.xj.xj
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public synchronized void xj(com.bytedance.msdk.core.f.c cVar) {
        if (cVar != null) {
            w(cVar);
        }
    }

    @Override // com.bytedance.msdk.kd.xj.kd
    /* renamed from: xj, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public synchronized void hf(com.bytedance.msdk.core.f.c cVar) {
        if (this.xj != null && cVar != null) {
            ai xj = ai.xj("freqctl_" + cVar.hf(), this.xj);
            String u = cVar.u();
            JSONObject xj2 = xj(cVar, true);
            if (xj2 != null) {
                xj.xj(u, xj2.toString());
            }
        }
    }

    @Override // com.bytedance.msdk.kd.xj.kd
    public synchronized com.bytedance.msdk.core.f.c query(String str) {
        if (this.xj == null) {
            return null;
        }
        return xj(ai.xj("freqctl_".concat(String.valueOf(str)), this.xj).hf(str, ""), false);
    }

    @Override // com.bytedance.msdk.kd.xj.kd
    public synchronized void delete(String str, String str2) {
        if (this.xj != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ai.xj("freqctl_".concat(String.valueOf(str)), this.xj).y(str + "_" + str2);
        }
    }

    @Override // com.bytedance.msdk.kd.xj.kd
    public synchronized com.bytedance.msdk.core.f.c query(String str, String str2) {
        if (this.xj == null) {
            return null;
        }
        return xj(ai.xj("freqctl_".concat(String.valueOf(str)), this.xj).hf(str + "_" + str2, ""), true);
    }

    private JSONObject xj(com.bytedance.msdk.core.f.c cVar, boolean z) {
        if (cVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("unity_id", cVar.u());
            if (cVar.xj()) {
                jSONObject.put("adn_rit_show_rules_version", cVar.y());
            } else {
                jSONObject.put("waterfall_show_rules_version", cVar.kd());
            }
            jSONObject.put("timing_mode", cVar.c());
            jSONObject.put("show_freqctl_rules", z ? cVar.d() : cVar.tf());
            return jSONObject;
        } catch (JSONException e) {
            pl.xj(e);
            return null;
        }
    }

    private com.bytedance.msdk.core.f.c xj(String str, boolean z) {
        String string;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String[] split = jSONObject.getString("unity_id").split("_");
            String str3 = split.length > 0 ? split[0] : "";
            String str4 = split.length > 1 ? split[1] : "";
            if (z) {
                str2 = jSONObject.getString("adn_rit_show_rules_version");
                string = "";
            } else {
                string = jSONObject.getString("waterfall_show_rules_version");
                str2 = "";
            }
            return new com.bytedance.msdk.core.f.c(str3, str4, string, str2, jSONObject.getInt("timing_mode"), jSONObject.getString("show_freqctl_rules"));
        } catch (JSONException e) {
            pl.xj(e);
            return null;
        }
    }
}
