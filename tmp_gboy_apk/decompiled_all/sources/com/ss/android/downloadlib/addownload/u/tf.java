package com.ss.android.downloadlib.addownload.u;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class tf implements d {
    private boolean hf(int i) {
        return com.ss.android.socialbase.downloader.f.xj.xj(i).xj("pause_optimise_mistake_click_interval_switch", 0) == 1;
    }

    @Override // com.ss.android.downloadlib.addownload.u.d
    public boolean xj(com.ss.android.downloadad.api.xj.hf hfVar, int i, f fVar) {
        if (hfVar == null || !hf(hfVar.v())) {
            return false;
        }
        if (System.currentTimeMillis() - hfVar.dc() > xj(hfVar.v())) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", "mistake_click");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        com.ss.android.downloadlib.u.xj.xj().xj("pause_optimise", jSONObject, hfVar);
        return true;
    }

    private long xj(int i) {
        return com.ss.android.socialbase.downloader.f.xj.xj(i).xj("pause_optimise_mistake_click_interval", 300);
    }
}
