package com.bytedance.sdk.openadsdk.core.pl;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    private JSONObject xj;

    public w(JSONObject jSONObject) {
        this.xj = jSONObject;
    }

    public int c() {
        JSONObject jSONObject = this.xj;
        if (jSONObject == null) {
            return 1;
        }
        return jSONObject.optInt("max_interface", 1);
    }

    public boolean hf() {
        JSONObject jSONObject = this.xj;
        return jSONObject == null || jSONObject.optInt("enable_active_notification", 1) == 1;
    }

    public long kd() {
        JSONObject jSONObject = this.xj;
        if (jSONObject == null) {
            return 1800L;
        }
        return jSONObject.optLong("notification_internal", 1800L);
    }

    public long u() {
        JSONObject jSONObject = this.xj;
        if (jSONObject == null) {
            return 300L;
        }
        return jSONObject.optLong("uninstall_delay", 300L);
    }

    public boolean w() {
        JSONObject jSONObject = this.xj;
        return jSONObject != null && jSONObject.optInt("enable_install_interface", 0) == 1;
    }

    public boolean xj() {
        JSONObject jSONObject = this.xj;
        return jSONObject == null || jSONObject.optInt("enable_install_notification", 1) == 1;
    }

    public int y() {
        JSONObject jSONObject = this.xj;
        if (jSONObject == null) {
            return 1;
        }
        return jSONObject.optInt("max_notification", 1);
    }
}
