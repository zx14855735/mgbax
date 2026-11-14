package com.bytedance.sdk.openadsdk.core;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ra {
    private long hf;
    private Map<String, Long> u = new HashMap();
    private long w;
    private String xj;

    private ra(String str, long j) {
        this.xj = str;
        this.hf = j;
        this.w = j;
    }

    public static ra xj(String str) {
        return new ra(str, SystemClock.elapsedRealtime());
    }

    public long hf(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.w;
        this.w = elapsedRealtime;
        this.u.put(str, Long.valueOf(j));
        return j;
    }

    public long xj() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.hf;
        this.u.put(this.xj, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public void xj(String str, long j) {
        this.u.put(str, Long.valueOf(j));
    }

    public long hf() {
        return SystemClock.elapsedRealtime() - this.hf;
    }

    public void xj(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.u.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && (value.longValue() > j || key.equals("armor_load_cost"))) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public JSONObject xj(long j) {
        JSONObject jSONObject = new JSONObject();
        xj(jSONObject, j);
        return jSONObject;
    }
}
