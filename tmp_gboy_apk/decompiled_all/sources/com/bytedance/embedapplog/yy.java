package com.bytedance.embedapplog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class yy extends n {
    private final Context kd;
    private final wn y;

    public yy(Context context, wn wnVar) {
        super(true, false);
        this.kd = context;
        this.y = wnVar;
    }

    @Override // com.bytedance.embedapplog.n
    @SuppressLint({"MissingPermission"})
    public boolean xj(JSONObject jSONObject) {
        jSONObject.put("os", "Android");
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        jSONObject.put("device_model", no.w());
        jSONObject.put("device_brand", Build.BRAND);
        jSONObject.put("device_manufacturer", Build.MANUFACTURER);
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", this.y.tj() ? xj(this.kd) : this.y.eu());
        return true;
    }

    private static String xj(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            try {
                str = Build.getSerial();
            } catch (Throwable unused) {
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, MediationConfigUserInfoForSegment.GENDER_UNKNOWN)) {
            str = Build.SERIAL;
        }
        return (TextUtils.isEmpty(str) || TextUtils.equals(str, MediationConfigUserInfoForSegment.GENDER_UNKNOWN)) ? "" : str;
    }
}
