package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class op extends n {
    private final wn kd;

    public op(wn wnVar) {
        super(true, false, false);
        this.kd = wnVar;
    }

    @Override // com.bytedance.embedapplog.n
    public boolean xj(JSONObject jSONObject) {
        SharedPreferences kd = this.kd.kd();
        String string = kd.getString("install_id", null);
        String string2 = kd.getString("device_id", null);
        String string3 = kd.getString("ssid", null);
        aq.xj(jSONObject, "install_id", string);
        aq.xj(jSONObject, "device_id", string2);
        aq.xj(jSONObject, "ssid", string3);
        long j = 0;
        long j2 = kd.getLong("register_time", 0L);
        if ((aq.hf(string) && aq.hf(string2)) || j2 == 0) {
            j = j2;
        } else {
            kd.edit().putLong("register_time", 0L).apply();
        }
        jSONObject.put("register_time", j);
        return true;
    }
}
