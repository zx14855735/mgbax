package com.ss.android.downloadlib.y;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.hf.y;
import com.ss.android.downloadlib.hf.d;
import com.ss.android.socialbase.appdownloader.w.p;
import com.ss.android.socialbase.appdownloader.w.tf;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj implements p {
    /* JADX INFO: Access modifiers changed from: private */
    public void hf(DownloadInfo downloadInfo, final com.ss.android.downloadlib.guide.install.xj xjVar) {
        com.ss.android.downloadad.api.xj.hf xj = y.xj().xj(downloadInfo);
        boolean xj2 = com.ss.android.downloadlib.hf.y.xj(xj);
        boolean hf = com.ss.android.downloadlib.hf.y.hf(xj);
        if (xj2 && hf) {
            com.ss.android.downloadlib.hf.w.xj(xj, new com.ss.android.downloadlib.guide.install.xj() { // from class: com.ss.android.downloadlib.y.xj.3
                @Override // com.ss.android.downloadlib.guide.install.xj
                public void xj() {
                    xjVar.xj();
                }
            });
        } else {
            xjVar.xj();
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.w.p
    public void xj(DownloadInfo downloadInfo, final tf tfVar) {
        xj(downloadInfo, new com.ss.android.downloadlib.guide.install.xj() { // from class: com.ss.android.downloadlib.y.xj.1
            @Override // com.ss.android.downloadlib.guide.install.xj
            public void xj() {
                tfVar.xj();
            }
        });
    }

    public void xj(final DownloadInfo downloadInfo, final com.ss.android.downloadlib.guide.install.xj xjVar) {
        com.ss.android.downloadad.api.xj.hf xj = y.xj().xj(downloadInfo);
        if (xj != null && d.xj(xj)) {
            TTDelegateActivity.xj(xj, new com.ss.android.downloadlib.guide.install.xj() { // from class: com.ss.android.downloadlib.y.xj.2
                @Override // com.ss.android.downloadlib.guide.install.xj
                public void xj() {
                    xj.this.hf(downloadInfo, xjVar);
                }
            });
        } else {
            hf(downloadInfo, xjVar);
        }
    }
}
