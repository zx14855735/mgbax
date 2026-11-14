package com.ss.android.socialbase.downloader.y;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class pl implements kd {
    private final com.ss.android.socialbase.downloader.model.kd hf;
    private final kd w;
    private final d xj;

    public pl(DownloadInfo downloadInfo, hf hfVar, d dVar) {
        this.xj = dVar;
        this.hf = xj(downloadInfo, dVar);
        this.w = new f(hfVar, this);
    }

    @Override // com.ss.android.socialbase.downloader.y.kd
    public void hf(xj xjVar) {
        this.hf.xj(xjVar.xj, 0, xjVar.w);
        this.xj.hf(xjVar.w);
    }

    public d kd() {
        return this.xj;
    }

    public void u() {
        com.ss.android.socialbase.downloader.tf.y.xj(this.hf);
    }

    public void w() {
        this.hf.w();
    }

    public kd xj() {
        return this.w;
    }

    private com.ss.android.socialbase.downloader.model.kd xj(DownloadInfo downloadInfo, d dVar) {
        com.ss.android.socialbase.downloader.model.kd xj = com.ss.android.socialbase.downloader.tf.y.xj(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("flush_buffer_size_byte", -1));
        try {
            xj.xj(dVar.kd());
            return xj;
        } catch (IOException e) {
            throw new BaseException(1054, e);
        }
    }

    public void hf() {
        this.hf.hf();
    }
}
