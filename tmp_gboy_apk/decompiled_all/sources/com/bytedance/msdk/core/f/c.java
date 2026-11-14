package com.bytedance.msdk.core.f;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c extends u {
    private String c;
    private final String d;
    private final String f;
    private xj tf;
    private List<kd> y;

    public static class xj {
        public String hf;
        public String w;
        public String xj;

        public xj(String str, String str2, String str3) {
            this.xj = str;
            this.hf = str2;
            this.w = str3;
        }
    }

    public c(String str, String str2, String str3, String str4, int i, String str5) {
        super(str, str2, str3, str4, i);
        this.f = "count";
        this.d = "effective_time";
        this.c = str5;
        if (TextUtils.isEmpty(str2)) {
            this.tf = new xj("waterfall_show_freq", "waterfall_show_span", "waterfall_show_rule_id");
        } else {
            this.tf = new xj("freq", "span", "rule_id");
        }
    }

    public String d() {
        try {
            JSONArray jSONArray = new JSONArray(this.c);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                jSONObject.put("count", 0);
                jSONObject.put("effective_time", y.xj(jSONObject.getLong(this.tf.hf)));
            }
            this.c = jSONArray.toString();
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        return this.c;
    }

    public synchronized List<kd> p() {
        c tf;
        List<kd> list = this.y;
        if (list != null && list.size() != 0) {
            return this.y;
        }
        this.y = new ArrayList();
        if (this.c == null && (tf = g.xj().tf(this.xj)) != null) {
            this.c = tf.c;
        }
        if (TextUtils.isEmpty(this.c)) {
            return this.y;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.c);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                kd kdVar = new kd();
                String string = jSONObject.getString(this.tf.w);
                if (!TextUtils.isEmpty(string)) {
                    kdVar.xj(jSONObject.optInt(this.tf.xj));
                    kdVar.xj(jSONObject.optLong(this.tf.hf));
                    kdVar.xj(string);
                    if (jSONObject.has("count")) {
                        kdVar.hf(jSONObject.optInt("count"));
                    }
                    if (jSONObject.has("effective_time")) {
                        kdVar.hf(jSONObject.optLong("effective_time"));
                    }
                    this.y.add(kdVar);
                }
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        if (this.y.size() > 0) {
            Collections.sort(this.y, new Comparator<kd>() { // from class: com.bytedance.msdk.core.f.c.1
                @Override // java.util.Comparator
                /* renamed from: xj, reason: merged with bridge method [inline-methods] */
                public int compare(kd kdVar2, kd kdVar3) {
                    long hf = kdVar2.hf() - kdVar3.hf();
                    if (hf == 0) {
                        return 0;
                    }
                    return hf > 0 ? 1 : -1;
                }
            });
        }
        return this.y;
    }

    public String tf() {
        try {
            JSONArray jSONArray = new JSONArray();
            for (kd kdVar : p()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(this.tf.xj, kdVar.xj());
                jSONObject.put(this.tf.hf, kdVar.hf());
                jSONObject.put(this.tf.w, kdVar.w());
                jSONObject.put("count", kdVar.kd());
                jSONObject.put("effective_time", kdVar.u());
                jSONArray.put(jSONObject);
            }
            this.c = jSONArray.toString();
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        return this.c;
    }

    @Override // com.bytedance.msdk.core.f.u
    public String toString() {
        StringBuilder sb = new StringBuilder("BaseIntervalBean{waterfallId='");
        sb.append(this.xj);
        sb.append("', showRulesVersion='");
        sb.append(this.w);
        sb.append("', timingMode=");
        sb.append(this.kd);
        sb.append("}IntervalFreqctlBean{freqctlRules=");
        sb.append(this.y);
        sb.append(", freqctlRulesJson='");
        return CtFAbx.B25kr6(sb, this.c, "'}");
    }

    public void xj(String str, int i) {
        for (kd kdVar : p()) {
            if (TextUtils.equals(kdVar.w(), str)) {
                kdVar.hf(i);
                return;
            }
        }
    }

    public void xj(String str, long j) {
        for (kd kdVar : p()) {
            if (TextUtils.equals(kdVar.w(), str)) {
                kdVar.hf(j);
                return;
            }
        }
    }
}
