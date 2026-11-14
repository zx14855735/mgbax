package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class ss extends n {
    private final Context kd;
    private final wn y;

    public ss(Context context, wn wnVar) {
        super(true, false);
        this.kd = context;
        this.y = wnVar;
    }

    @Override // com.bytedance.embedapplog.n
    public boolean xj(JSONObject jSONObject) {
        TelephonyManager telephonyManager = (TelephonyManager) this.kd.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                aq.xj(jSONObject, "carrier", telephonyManager.getNetworkOperatorName());
                aq.xj(jSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
                aq.xj(jSONObject, "udid", this.y.tj() ? si.xj(telephonyManager) : this.y.ws());
                return true;
            } catch (Exception e) {
                cu.hf(e);
            }
        }
        return false;
    }
}
