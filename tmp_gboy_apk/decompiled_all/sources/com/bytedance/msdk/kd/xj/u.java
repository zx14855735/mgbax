package com.bytedance.msdk.kd.xj;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.core.f.d;
import com.bytedance.msdk.f.ai;
import com.bytedance.sdk.component.utils.pl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements w<d> {
    private Context xj;

    public u(Context context) {
        if (context != null) {
            this.xj = context.getApplicationContext();
        }
    }

    @Override // com.bytedance.msdk.kd.xj.kd
    public synchronized void delete(String str) {
        if (str.contains("_")) {
            throw new RuntimeException(" has slotId");
        }
        if (this.xj != null && !TextUtils.isEmpty(str)) {
            ai.xj("pacing_".concat(str), this.xj).y(str);
        }
    }

    @Override // com.bytedance.msdk.kd.xj.kd
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public synchronized void hf(d dVar) {
        try {
            if (this.xj != null && dVar != null) {
                ai xj = ai.xj("pacing_" + dVar.hf(), this.xj);
                String u = dVar.u();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("unity_id", dVar.u());
                    if (!dVar.xj()) {
                        jSONObject.put("waterfall_show_rules_version", dVar.kd());
                        jSONObject.put("adn_rit_show_rules_version", dVar.y());
                    }
                    jSONObject.put("timing_mode", dVar.c());
                    StringBuilder sb = new StringBuilder();
                    sb.append(dVar.d());
                    jSONObject.put("show_pacing", sb.toString());
                    jSONObject.put("show_pacing_rule_id", dVar.tf());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(dVar.p());
                    jSONObject.put("show_time", sb2.toString());
                    xj.xj(u, jSONObject.toString());
                } catch (JSONException e) {
                    pl.xj(e);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bytedance.msdk.kd.xj.kd
    public synchronized d query(String str) {
        if (!str.contains("_")) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return xj(ai.xj("pacing_".concat(str), this.xj).hf(str, ""), false);
        }
        throw new RuntimeException(" has slotId");
    }

    @Override // com.bytedance.msdk.kd.xj.kd
    public synchronized void delete(String str, String str2) {
        if (!str.contains("_")) {
            if (this.xj != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                ai.xj("pacing_".concat(str), this.xj).y(str + "_" + str2);
            }
        } else {
            throw new RuntimeException(" has slotId");
        }
    }

    @Override // com.bytedance.msdk.kd.xj.kd
    public synchronized d query(String str, String str2) {
        if (!str.contains("_")) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return xj(ai.xj("pacing_".concat(str), this.xj).hf(str + "_" + str2, ""), true);
        }
        throw new RuntimeException(" has slotId");
    }

    private d xj(String str, boolean z) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String[] split = jSONObject.getString("unity_id").split("_");
            String str4 = split.length > 0 ? split[0] : "";
            String str5 = split.length > 1 ? split[1] : "";
            if (z) {
                str2 = "";
                str3 = str2;
            } else {
                String string = jSONObject.getString("waterfall_show_rules_version");
                str3 = jSONObject.getString("adn_rit_show_rules_version");
                str2 = string;
            }
            return new d(str4, str5, str2, str3, jSONObject.getInt("timing_mode"), jSONObject.getString("show_pacing"), jSONObject.getString("show_pacing_rule_id"), jSONObject.getString("show_time"));
        } catch (JSONException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.bytedance.msdk.kd.xj.w
    public synchronized void xj(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d query = query(str);
        if (query != null) {
            query.xj(j);
            hf(query);
        }
    }

    @Override // com.bytedance.msdk.kd.xj.w
    public synchronized void xj(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            d query = query(str, str2);
            if (query != null) {
                query.xj(j);
                hf(query);
            }
        }
    }
}
