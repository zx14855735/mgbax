package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadlib.addownload.am;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class tf {
    private static volatile tf xj;
    private final com.ss.android.download.api.xj hf;
    private com.ss.android.downloadad.api.hf kd;
    private final com.ss.android.downloadad.api.xj u;
    private final f w;
    private long y;

    /* JADX INFO: Access modifiers changed from: private */
    public f f() {
        return this.w;
    }

    public void c() {
        kd.xj().y();
    }

    public com.ss.android.downloadad.api.hf kd() {
        if (this.kd == null) {
            this.kd = hf.xj();
        }
        return this.kd;
    }

    public com.ss.android.downloadad.api.xj u() {
        return this.u;
    }

    public void w() {
        this.y = System.currentTimeMillis();
    }

    public String y() {
        return pl.am();
    }

    private tf(Context context) {
        this.w = f.xj();
        this.hf = new y();
        this.y = System.currentTimeMillis();
        hf(context);
        this.u = xj.xj();
    }

    private void hf(Context context) {
        pl.xj(context);
        Downloader.getInstance(pl.getContext());
        com.ss.android.downloadlib.addownload.hf.y.xj().hf();
        com.ss.android.socialbase.appdownloader.u.p().xj(pl.getContext(), "misc_config", new com.ss.android.downloadlib.w.c(), new com.ss.android.downloadlib.w.y(context), new w());
        com.ss.android.downloadlib.w.u uVar = new com.ss.android.downloadlib.w.u();
        com.ss.android.socialbase.appdownloader.u.p().xj(uVar);
        Downloader.getInstance(context).registerDownloadCacheSyncListener(uVar);
        com.ss.android.socialbase.appdownloader.u.p().xj(new am());
        com.ss.android.socialbase.downloader.downloader.w.xj(new com.ss.android.downloadlib.w.kd());
        com.ss.android.socialbase.appdownloader.u.p().xj(com.ss.android.downloadlib.y.w.xj());
    }

    public static tf xj(final Context context) {
        if (xj == null) {
            synchronized (tf.class) {
                try {
                    if (xj == null) {
                        com.ss.android.downloadlib.kd.hf.xj(new Runnable() { // from class: com.ss.android.downloadlib.tf.1
                            @Override // java.lang.Runnable
                            public void run() {
                                tf unused = tf.xj = new tf(context);
                            }
                        });
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public com.ss.android.download.api.xj xj() {
        return this.hf;
    }

    public com.ss.android.download.api.xj xj(String str) {
        com.ss.android.download.api.config.y hf = c.xj().hf();
        if (hf != null && hf.xj(str)) {
            return hf.hf(str);
        }
        return this.hf;
    }

    public long hf() {
        return this.y;
    }

    public DownloadInfo hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.socialbase.appdownloader.u.p().xj(pl.getContext(), str);
    }

    public void xj(final Context context, final int i, final DownloadStatusChangeListener downloadStatusChangeListener, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.kd.hf.xj(new Runnable() { // from class: com.ss.android.downloadlib.tf.4
            @Override // java.lang.Runnable
            public void run() {
                tf.this.f().xj(context, i, downloadStatusChangeListener, downloadModel);
            }
        });
    }

    public void xj(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final OnItemClickListener onItemClickListener, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.kd.hf.xj(new Runnable() { // from class: com.ss.android.downloadlib.tf.5
            @Override // java.lang.Runnable
            public void run() {
                tf.this.f().xj(str, j, i, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener);
            }
        });
    }

    public void xj(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController) {
        com.ss.android.downloadlib.kd.hf.xj(new Runnable() { // from class: com.ss.android.downloadlib.tf.6
            @Override // java.lang.Runnable
            public void run() {
                tf.this.f().xj(str, j, i, downloadEventConfig, downloadController);
            }
        });
    }

    public void xj(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.kd.hf.xj(new Runnable() { // from class: com.ss.android.downloadlib.tf.7
            @Override // java.lang.Runnable
            public void run() {
                tf.this.f().xj(str, j, i, downloadEventConfig, downloadController, iDownloadButtonClickListener);
            }
        });
    }

    public void xj(final String str, final int i) {
        com.ss.android.downloadlib.kd.hf.xj(new Runnable() { // from class: com.ss.android.downloadlib.tf.2
            @Override // java.lang.Runnable
            public void run() {
                tf.this.f().xj(str, i);
            }
        });
    }

    public void xj(final String str, final boolean z) {
        com.ss.android.downloadlib.kd.hf.xj(new Runnable() { // from class: com.ss.android.downloadlib.tf.3
            @Override // java.lang.Runnable
            public void run() {
                tf.this.f().xj(str, z);
            }
        });
    }

    public void xj(com.ss.android.download.api.download.xj.xj xjVar) {
        f().xj(xjVar);
    }

    public DownloadInfo xj(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2) && z) {
            return hf(str);
        }
        return Downloader.getInstance(pl.getContext()).getDownloadInfo(str, str2);
    }
}
