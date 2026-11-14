package com.ss.android.socialbase.downloader.kd;

import com.ss.android.socialbase.downloader.tf.y;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w implements hf {
    private final com.ss.android.socialbase.downloader.y.xj hf;
    private final InputStream xj;

    public w(InputStream inputStream, int i) {
        this.xj = inputStream;
        this.hf = new com.ss.android.socialbase.downloader.y.xj(i);
    }

    @Override // com.ss.android.socialbase.downloader.kd.hf
    public void hf() {
        y.xj(this.xj);
    }

    @Override // com.ss.android.socialbase.downloader.kd.hf
    public void xj(com.ss.android.socialbase.downloader.y.xj xjVar) {
    }

    @Override // com.ss.android.socialbase.downloader.kd.hf
    public com.ss.android.socialbase.downloader.y.xj xj() {
        com.ss.android.socialbase.downloader.y.xj xjVar = this.hf;
        xjVar.w = this.xj.read(xjVar.xj);
        return this.hf;
    }
}
