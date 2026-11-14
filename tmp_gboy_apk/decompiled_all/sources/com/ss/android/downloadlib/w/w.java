package com.ss.android.downloadlib.w;

import ADYaiT.CtFAbx;
import com.ss.android.download.api.config.am;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w implements g {
    @Override // com.ss.android.socialbase.downloader.depend.g
    public boolean hf(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.download.api.w.hf.xj(com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()), downloadInfo.getMimeType());
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.depend.g
    public void xj(DownloadInfo downloadInfo) {
        am p = pl.p();
        if (downloadInfo == null || p == null) {
            return;
        }
        File xj = xj(downloadInfo.getPackageName(), downloadInfo.getTargetFilePath());
        com.ss.android.downloadad.api.xj.hf xj2 = com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadInfo);
        if (xj2 != null) {
            com.ss.android.downloadlib.c.g.xj(xj2.c());
        }
        downloadInfo.setMimeType(AdBaseConstants.MIME_APK);
        downloadInfo.setName(xj.getName());
        downloadInfo.setMd5(null);
    }

    private File xj(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str = name.substring(0, lastIndexOf);
        }
        return new File(file.getParent(), CtFAbx.AcNBzu(str, ".apk"));
    }
}
