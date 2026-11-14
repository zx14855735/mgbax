package com.ss.android.downloadlib.y;

import com.ss.android.downloadlib.addownload.hf.y;
import com.ss.android.socialbase.appdownloader.w.p;
import com.ss.android.socialbase.appdownloader.w.tf;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf implements p {
    @Override // com.ss.android.socialbase.appdownloader.w.p
    public void xj(DownloadInfo downloadInfo, tf tfVar) {
        com.ss.android.downloadad.api.xj.hf xj;
        if (downloadInfo != null && (xj = y.xj().xj(downloadInfo)) != null) {
            downloadInfo.setLinkMode(xj.tj());
        }
        if (tfVar != null) {
            tfVar.xj();
        }
    }
}
