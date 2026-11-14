package com.bytedance.embedapplog;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class lx {
    final Long c;
    final String hf;
    final Long kd;
    final Long u;
    final Boolean w;
    final String xj;
    final Integer y;

    public lx(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
        this.xj = str;
        this.hf = str2;
        this.w = bool;
        this.u = l;
        this.kd = l2;
        this.y = num;
        this.c = l3;
    }

    public JSONObject hf() {
        JSONObject jSONObject = new JSONObject();
        db.xj(jSONObject, com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, this.xj);
        db.xj(jSONObject, "req_id", this.hf);
        db.xj(jSONObject, "is_track_limited", this.w);
        db.xj(jSONObject, "take_ms", this.u);
        db.xj(jSONObject, "time", this.kd);
        db.xj(jSONObject, "query_times", this.y);
        db.xj(jSONObject, "hw_id_version_code", this.c);
        return jSONObject;
    }

    public String toString() {
        return hf().toString();
    }

    public Map<String, String> xj() {
        HashMap hashMap = new HashMap();
        db.xj(hashMap, com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, this.xj);
        db.xj(hashMap, "req_id", this.hf);
        db.xj(hashMap, "is_track_limited", String.valueOf(this.w));
        db.xj(hashMap, "take_ms", String.valueOf(this.u));
        db.xj(hashMap, "time", String.valueOf(this.kd));
        db.xj(hashMap, "query_times", String.valueOf(this.y));
        db.xj(hashMap, "hw_id_version_code", String.valueOf(this.c));
        return hashMap;
    }

    public static lx xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new lx(jSONObject.optString(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, null), jSONObject.optString("req_id", null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (JSONException e) {
            cu.xj(e);
            return null;
        }
    }
}
