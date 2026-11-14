package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class nb extends n {
    private final Context kd;

    public nb(Context context) {
        super(true, false);
        this.kd = context;
    }

    @Override // com.bytedance.embedapplog.n
    public boolean xj(JSONObject jSONObject) {
        aq.xj(jSONObject, "sim_region", ((TelephonyManager) this.kd.getSystemService("phone")).getSimCountryIso());
        return true;
    }
}
