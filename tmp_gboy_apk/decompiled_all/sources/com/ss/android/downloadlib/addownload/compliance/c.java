package com.ss.android.downloadlib.addownload.compliance;

import com.bytedance.sdk.component.utils.pl;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class c {
    public static void hf(String str, long j) {
        xj(str, null, j);
    }

    public static void xj(String str, long j) {
        com.ss.android.downloadlib.addownload.hf.kd kd = com.ss.android.downloadlib.addownload.hf.y.xj().kd(j);
        if (kd.dk()) {
            return;
        }
        kd.w.setRefer(str);
        com.ss.android.downloadlib.u.xj.xj().hf("lp_app_dialog_click", kd);
    }

    public static void xj(String str, JSONObject jSONObject, long j) {
        com.ss.android.downloadlib.u.xj.xj().hf(str, jSONObject, com.ss.android.downloadlib.addownload.hf.y.xj().kd(j));
    }

    public static void xj(String str, com.ss.android.downloadlib.addownload.hf.kd kdVar) {
        com.ss.android.downloadlib.u.xj.xj().hf(str, kdVar);
    }

    public static void xj(int i, com.ss.android.downloadlib.addownload.hf.kd kdVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            pl.xj(e);
        }
        com.ss.android.downloadlib.u.xj.xj().hf("lp_compliance_error", jSONObject, kdVar);
    }

    public static void xj(int i, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            pl.xj(e);
        }
        com.ss.android.downloadlib.u.xj.xj().hf("lp_compliance_error", jSONObject, com.ss.android.downloadlib.addownload.hf.y.xj().kd(j));
    }
}
