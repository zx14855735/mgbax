package com.ss.android.downloadlib.addownload.hf;

import com.bytedance.sdk.component.utils.pl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f {
    private static volatile f xj;

    private f() {
    }

    public static f xj() {
        if (xj == null) {
            synchronized (u.class) {
                try {
                    if (xj == null) {
                        xj = new f();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void xj(int i, int i2, com.ss.android.downloadad.api.xj.hf hfVar) {
        if (hfVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.f.xj xj2 = com.ss.android.socialbase.downloader.f.xj.xj(hfVar.v());
        if (xj2.xj("report_api_hijack", 0) == 0) {
            return;
        }
        int i3 = i2 - i;
        if (i <= 0 || i3 <= xj2.xj("check_api_hijack_version_code_diff", 500)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version_code_diff", i3);
            jSONObject.put("installed_version_code", i2);
            jSONObject.put("hijack_type", 1);
        } catch (JSONException e) {
            pl.xj(e);
        }
        com.ss.android.downloadlib.u.xj.xj().hf("api_hijack", jSONObject, hfVar);
    }
}
