package com.ss.android.downloadlib.addownload;

import com.ss.android.socialbase.downloader.downloader.yo;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class am implements yo {
    @Override // com.ss.android.socialbase.downloader.downloader.yo
    public void xj(DownloadInfo downloadInfo, int i, int i2) {
        com.ss.android.downloadad.api.xj.hf xj = com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reserve_wifi_source", Integer.valueOf(i2));
            jSONObject.putOpt("reserve_wifi_status", Integer.valueOf(i));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        com.ss.android.downloadlib.u.xj.xj().xj("pause_reserve_wifi", jSONObject, xj);
    }
}
