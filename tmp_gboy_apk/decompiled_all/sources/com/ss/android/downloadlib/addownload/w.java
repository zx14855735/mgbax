package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w {
    private static volatile w hf = null;
    private static String xj = "w";
    private ConcurrentHashMap<Long, Runnable> w;

    public w() {
        this.w = null;
        this.w = new ConcurrentHashMap<>();
    }

    public static w xj() {
        if (hf == null) {
            synchronized (w.class) {
                try {
                    if (hf == null) {
                        hf = new w();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    public long hf() {
        return pl.d().optLong("quick_app_check_internal", 1200L);
    }

    public void xj(kd kdVar, boolean z, int i, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id = downloadModel.getId();
        if (i == 4) {
            if (!z) {
                xj(id, false, 2);
                kdVar.hf(false);
                return;
            } else {
                xj(id, true, 2);
                return;
            }
        }
        if (i == 5) {
            if (!z) {
                xj(id, false, 1);
                kdVar.w(false);
                return;
            } else {
                xj(id, true, 1);
                return;
            }
        }
        if (i != 7) {
            return;
        }
        Runnable remove = this.w.remove(Long.valueOf(id));
        if (z) {
            com.ss.android.downloadlib.u.xj.xj().xj(id, 1);
            xj(id, true, 1);
        } else {
            if (remove != null) {
                com.ss.android.downloadlib.f.xj().hf().post(remove);
            }
            xj(id, false, 1);
        }
    }

    private void xj(long j, boolean z, int i) {
        com.ss.android.downloadlib.u.xj.xj().xj(j, z, i);
        if (z) {
            pl.pz();
        }
    }

    public void xj(final kd kdVar, final int i, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.hf.kd.xj().xj(new com.ss.android.downloadlib.hf.u() { // from class: com.ss.android.downloadlib.addownload.w.1
            @Override // com.ss.android.downloadlib.hf.u
            public void xj(boolean z) {
                w.this.xj(kdVar, z, i, downloadModel);
            }
        }, hf());
    }

    public static boolean xj(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }
}
