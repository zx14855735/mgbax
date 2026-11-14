package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class ah {
    private final SharedPreferences xj;

    public ah(Context context) {
        this.xj = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(context, "device_register_oaid_refine", 0);
    }

    public void xj(lx lxVar) {
        if (lxVar == null) {
            return;
        }
        this.xj.edit().putString("oaid", lxVar.hf().toString()).apply();
    }

    public lx xj() {
        return lx.xj(this.xj.getString("oaid", ""));
    }
}
