package com.ss.android.downloadlib;

import android.text.TextUtils;
import com.ss.android.download.api.config.g;
import com.ss.android.download.api.config.ht;
import com.ss.android.download.api.config.p;
import com.ss.android.download.api.config.yo;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.xj.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class y implements com.ss.android.download.api.xj {
    @Override // com.ss.android.download.api.xj
    public com.ss.android.download.api.xj xj(com.ss.android.download.api.config.d dVar) {
        pl.xj(dVar);
        return this;
    }

    @Override // com.ss.android.download.api.xj
    public com.ss.android.download.api.xj xj(com.ss.android.download.api.config.c cVar) {
        pl.xj(cVar);
        return this;
    }

    @Override // com.ss.android.download.api.xj
    public com.ss.android.download.api.xj xj(g gVar) {
        pl.xj(gVar);
        return this;
    }

    @Override // com.ss.android.download.api.xj
    public com.ss.android.download.api.xj xj(com.ss.android.download.api.config.f fVar) {
        pl.xj(fVar);
        return this;
    }

    @Override // com.ss.android.download.api.xj
    public com.ss.android.download.api.xj xj(p pVar) {
        pl.xj(pVar);
        return this;
    }

    @Override // com.ss.android.download.api.xj
    public com.ss.android.download.api.xj xj(com.ss.android.download.api.model.xj xjVar) {
        pl.xj(xjVar);
        return this;
    }

    @Override // com.ss.android.download.api.xj
    public com.ss.android.download.api.xj xj(String str) {
        pl.xj(str);
        return this;
    }

    @Override // com.ss.android.download.api.xj
    public com.ss.android.download.api.xj xj(com.ss.android.socialbase.appdownloader.w.w wVar) {
        pl.xj(wVar);
        return this;
    }

    @Override // com.ss.android.download.api.xj
    public com.ss.android.download.api.xj xj(final com.ss.android.download.api.config.hf hfVar) {
        pl.xj(hfVar);
        com.ss.android.socialbase.downloader.xj.xj.xj().xj(new xj.w() { // from class: com.ss.android.downloadlib.y.1
        });
        return this;
    }

    @Override // com.ss.android.download.api.xj
    public com.ss.android.download.api.xj xj(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new j() { // from class: com.ss.android.downloadlib.y.2
                private boolean u(DownloadInfo downloadInfo) {
                    ht v = pl.v();
                    if (v == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.xj.hf xj = com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadInfo);
                    String xj2 = (xj == null || !xj.w()) ? com.ss.android.downloadlib.addownload.d.xj(downloadInfo) : com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("ad_notification_jump_url", (String) null);
                    if (TextUtils.isEmpty(xj2)) {
                        return false;
                    }
                    return v.xj(pl.getContext(), xj2);
                }

                @Override // com.ss.android.socialbase.downloader.depend.j
                public boolean hf(DownloadInfo downloadInfo) {
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.j
                public boolean w(DownloadInfo downloadInfo) {
                    if (downloadInfo == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.xj.hf xj = com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadInfo);
                    if (xj != null) {
                        com.ss.android.downloadlib.hf.xj.xj(xj);
                    } else {
                        com.ss.android.downloadlib.c.d.hf(pl.getContext(), downloadInfo.getPackageName());
                    }
                    com.ss.android.socialbase.downloader.notification.hf.xj().y(downloadInfo.getId());
                    return true;
                }

                @Override // com.ss.android.socialbase.downloader.depend.j
                public boolean xj(DownloadInfo downloadInfo) {
                    com.ss.android.socialbase.downloader.f.xj xj = com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId());
                    if (xj.hf("notification_opt_2") != 1) {
                        boolean u = u(downloadInfo);
                        if (xj.xj("disable_delete_dialog", 0) == 1) {
                            return true;
                        }
                        return u;
                    }
                    if (downloadInfo.getStatus() == -2) {
                        DownloadHandlerService.xj(pl.getContext(), downloadInfo, com.ss.android.socialbase.appdownloader.u.p().w(), Downloader.getInstance(pl.getContext()).getDownloadNotificationEventListener(downloadInfo.getId()));
                    }
                    return true;
                }
            });
        }
        downloaderBuilder.addDownloadCompleteHandler(new com.ss.android.downloadlib.w.w());
        Downloader.initOrCover(downloaderBuilder, true);
        return this;
    }

    @Override // com.ss.android.download.api.xj
    public com.ss.android.download.api.xj xj(com.ss.android.socialbase.appdownloader.w.c cVar) {
        com.ss.android.socialbase.appdownloader.u.p().xj(cVar);
        return this;
    }

    @Override // com.ss.android.download.api.xj
    public com.ss.android.download.api.xj xj(yo yoVar) {
        pl.xj(yoVar);
        return this;
    }

    @Override // com.ss.android.download.api.xj
    public com.ss.android.download.api.xj xj(com.ss.android.download.api.config.tf tfVar) {
        pl.xj(tfVar);
        return this;
    }

    @Override // com.ss.android.download.api.xj
    public void xj() {
        if (!pl.dk()) {
            com.ss.android.downloadlib.kd.w.xj().xj("ttdownloader init error");
        }
        pl.xj(com.ss.android.downloadlib.kd.w.xj());
        try {
            com.ss.android.socialbase.appdownloader.u.p().hf(pl.ra());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        com.ss.android.socialbase.appdownloader.u.p().xj(xj.xj());
        kd.xj().hf(new Runnable() { // from class: com.ss.android.downloadlib.y.3
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.y.kd.xj("");
                if (com.ss.android.socialbase.appdownloader.y.kd.qt()) {
                    com.ss.android.socialbase.downloader.downloader.w.xj(true);
                }
                if (com.ss.android.socialbase.downloader.f.xj.w().xj("disable_security_init", 1) == 1) {
                    com.ss.android.socialbase.appdownloader.y.y.xj(pl.getContext());
                }
            }
        });
    }
}
