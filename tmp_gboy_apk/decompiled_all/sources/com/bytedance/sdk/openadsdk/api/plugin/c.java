package com.bytedance.sdk.openadsdk.api.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c {
    private long hf;
    private Map<String, Long> u = new HashMap();
    private long w;
    private String xj;

    private c(String str, long j) {
        this.xj = str;
        this.hf = j;
        this.w = j;
    }

    public static c xj(String str) {
        return new c(str, SystemClock.elapsedRealtime());
    }

    public long hf(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.w;
        this.w = SystemClock.elapsedRealtime();
        this.u.put(str, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public long xj() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.hf;
        this.u.put(this.xj, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public void xj(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.u.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value.longValue() > j) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }
}
