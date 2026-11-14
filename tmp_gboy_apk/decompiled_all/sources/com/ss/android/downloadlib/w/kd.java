package com.ss.android.downloadlib.w;

import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.downloadlib.c.g;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class kd implements com.ss.android.socialbase.downloader.u.w {
    @Override // com.ss.android.socialbase.downloader.u.w
    public void hf(int i, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.xj.hf xj;
        DownloadInfo downloadInfo = Downloader.getInstance(pl.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (xj = com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadInfo)) == null) {
            return;
        }
        com.ss.android.downloadlib.u.xj.xj().xj(str, jSONObject, xj);
    }

    @Override // com.ss.android.socialbase.downloader.u.w
    public void xj(int i, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.xj.hf xj;
        DownloadInfo downloadInfo = Downloader.getInstance(pl.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (xj = com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadInfo)) == null) {
            return;
        }
        if ("install_view_result".equals(str)) {
            jSONObject = g.xj(jSONObject);
            com.ss.android.downloadlib.xj.xj(jSONObject, downloadInfo);
            g.xj(jSONObject, "model_id", Long.valueOf(xj.hf()));
        }
        com.ss.android.downloadlib.u.xj.xj().hf(str, jSONObject, xj);
    }
}
