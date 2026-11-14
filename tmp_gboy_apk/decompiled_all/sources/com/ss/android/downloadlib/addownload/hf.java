package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf {
    private static volatile hf xj;
    private Handler hf = null;

    public static hf xj() {
        if (xj == null) {
            synchronized (hf.class) {
                try {
                    if (xj == null) {
                        xj = new hf();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public boolean hf() {
        return pl.d().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }

    public void xj(Context context, DownloadInfo downloadInfo) {
        if (hf() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
            if (this.hf == null) {
                this.hf = new Handler(Looper.getMainLooper());
            }
            final String url = downloadInfo.getUrl();
            Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
            this.hf.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.hf.1
                @Override // java.lang.Runnable
                public void run() {
                    pl.w().xj(3, pl.getContext(), null, "下载失败，请重试！", null, 0);
                    kd xj2 = com.ss.android.downloadlib.f.xj().xj(url);
                    if (xj2 != null) {
                        xj2.c();
                    }
                }
            });
        }
    }
}
