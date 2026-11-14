package com.ss.android.downloadlib.addownload.w;

import ADYaiT.CtFAbx;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.sdk.component.utils.pl;
import com.ss.android.downloadlib.c.g;
import com.ss.android.downloadlib.c.p;
import com.ss.android.socialbase.downloader.depend.e;
import com.ss.android.socialbase.downloader.depend.yo;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj implements yo {
    private int xj;

    private long hf(com.ss.android.socialbase.downloader.f.xj xjVar) {
        long xj = xjVar.xj("clear_space_sleep_time", 0L);
        if (xj <= 0) {
            return 0L;
        }
        if (xj > PushUIConfig.dismissTime) {
            xj = 5000;
        }
        p.hf("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = ".concat(String.valueOf(xj)), null);
        try {
            Thread.sleep(xj);
        } catch (InterruptedException e) {
            pl.xj(e);
        }
        p.hf("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return xj;
    }

    public void xj(int i) {
        this.xj = i;
    }

    @Override // com.ss.android.socialbase.downloader.depend.yo
    public boolean xj(long j, long j2, e eVar) {
        com.ss.android.socialbase.downloader.f.xj xj = com.ss.android.socialbase.downloader.f.xj.xj(this.xj);
        if (!xj(xj)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        u.xj().w();
        long j3 = 0;
        long hf = g.hf(0L);
        xj();
        long hf2 = g.hf(0L);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (hf2 < j2) {
            long hf3 = hf(xj);
            if (hf3 > 0) {
                hf2 = g.hf(0L);
            }
            j3 = hf3;
        }
        long j4 = hf2;
        StringBuilder B2KMhB2 = CtFAbx.B2KMhB("cleanUpDisk, byteRequired = ", j2, ", byteAvailableAfter = ");
        B2KMhB2.append(j4);
        B2KMhB2.append(", cleaned = ");
        B2KMhB2.append(j4 - hf);
        p.hf("AppDownloadDiskSpaceHandler", B2KMhB2.toString(), null);
        xj(hf, j4, j2, currentTimeMillis2, j3);
        if (j4 < j2) {
            return false;
        }
        if (eVar == null) {
            return true;
        }
        eVar.xj();
        return true;
    }

    private boolean xj(com.ss.android.socialbase.downloader.f.xj xjVar) {
        if (xjVar.xj("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - u.xj().hf() >= xjVar.xj("clear_space_min_time_interval", 600000L);
    }

    private void xj() {
        com.ss.android.downloadlib.addownload.pl.zg();
        w.xj();
        w.hf();
    }

    private void xj(long j, long j2, long j3, long j4, long j5) {
        DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.pl.getContext()).getDownloadInfo(this.xj);
        if (downloadInfo == null) {
            return;
        }
        try {
            com.ss.android.downloadlib.xj.xj().xj(downloadInfo, j, j2, j3, j4, j5, j2 > j3);
        } catch (Exception e) {
            pl.xj(e);
        }
    }
}
