package com.bytedance.pangle.util.hf;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.u.hf;
import com.bytedance.sdk.openadsdk.api.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    public static boolean xj(String str, boolean z, boolean z2, String str2, int i, int i2) {
        Throwable th;
        int i3;
        int i4;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            new xj(new com.bytedance.pangle.util.hf.xj.xj().xj(str)).xj(z, z2);
            if (i2 != 0) {
                if (i2 == 1) {
                    i4 = hf.xj.xj;
                } else if (i2 == 2) {
                    i4 = hf.xj.hf;
                } else {
                    i3 = 0;
                    String str3 = "rmSo:" + z2 + " rmDex:" + z;
                    ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str3)));
                    xj(i3, str2, i, System.currentTimeMillis() - currentTimeMillis, (Throwable) null, str3);
                }
                i3 = i4;
                String str32 = "rmSo:" + z2 + " rmDex:" + z;
                ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str32)));
                xj(i3, str2, i, System.currentTimeMillis() - currentTimeMillis, (Throwable) null, str32);
            }
            return true;
        } catch (Throwable th2) {
            try {
                try {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "rmEntries failed. zipFile:" + str + " rmDex:" + z + " rmSO:" + z2, th2);
                    if (i2 != 0) {
                        int i5 = i2 == 1 ? hf.xj.w : i2 == 2 ? hf.xj.u : 0;
                        String str4 = "rmSo:" + z2 + " rmDex:" + z;
                        ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str4)));
                        xj(i5, str2, i, System.currentTimeMillis() - currentTimeMillis, th2, str4);
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    th = th2;
                    Throwable th4 = th;
                    if (i2 == 0) {
                        throw th4;
                    }
                    int i6 = i2 != 1 ? i2 == 2 ? hf.xj.u : 0 : hf.xj.w;
                    String str5 = "rmSo:" + z2 + " rmDex:" + z;
                    ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str5)));
                    xj(i6, str2, i, System.currentTimeMillis() - currentTimeMillis, th, str5);
                    throw th4;
                }
            } catch (Throwable th5) {
                th = th5;
                th = th2;
            }
        }
    }

    private static void xj(int i, String str, int i2, long j, Throwable th, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.hf.xj(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.hf.xj(str));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.hf.xj(Integer.valueOf(i2)));
            jSONObject3.putOpt(MediationConstant.EXTRA_DURATION, Integer.valueOf(com.bytedance.pangle.log.hf.hf(Long.valueOf(j))));
            jSONObject2.putOpt("message", str2 + com.bytedance.pangle.log.hf.xj(th));
        } catch (JSONException e) {
            y.xj(e);
        }
        com.bytedance.pangle.u.hf.xj().xj(com.bytedance.pangle.u.hf.tf, jSONObject, jSONObject3, jSONObject2);
    }
}
