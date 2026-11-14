package com.ss.android.downloadlib.w;

import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.sdk.component.utils.pl;
import com.ss.android.downloadlib.addownload.hf.d;
import com.ss.android.downloadlib.c.g;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u implements com.ss.android.socialbase.appdownloader.w.f, p {
    @Override // com.ss.android.socialbase.appdownloader.w.f
    public void xj(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        xj(downloadInfo, downloadInfo.getRealStatus(), z);
    }

    public void xj(DownloadInfo downloadInfo, int i, boolean z) {
        com.ss.android.downloadlib.addownload.hf.y.xj().hf();
        com.ss.android.downloadad.api.xj.hf xj = com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadInfo);
        if (xj == null) {
            return;
        }
        try {
            if (z) {
                xj.w(downloadInfo.getFailedResumeCount());
            } else if (xj.z() == -1) {
                return;
            } else {
                xj.w(-1);
            }
            d.xj().xj(xj);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
            jSONObject.put("url", downloadInfo.getUrl());
            jSONObject.put("download_time", downloadInfo.getDownloadTime());
            jSONObject.put("download_status", i);
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            int i2 = 1;
            jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
            jSONObject.put("chunk_count", downloadInfo.getChunkCount());
            if (!z) {
                i2 = 2;
            }
            jSONObject.put("launch_resumed", i2);
            jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
            com.ss.android.downloadlib.u.xj.xj().xj("embeded_ad", "download_uncompleted", jSONObject, xj);
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.p
    public void xj() {
        com.ss.android.downloadlib.kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.w.u.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo;
                int spIntVal;
                com.ss.android.downloadlib.addownload.hf.y.xj().hf();
                for (com.ss.android.downloadad.api.xj.hf hfVar : com.ss.android.downloadlib.addownload.hf.y.xj().w().values()) {
                    int v = hfVar.v();
                    if (v != 0) {
                        com.ss.android.socialbase.downloader.f.xj xj = com.ss.android.socialbase.downloader.f.xj.xj(v);
                        if (xj.hf("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.pl.getContext()).getDownloadInfo(v)) != null) {
                            if (g.hf(hfVar) && !g.w(hfVar.kd())) {
                                int spIntVal2 = downloadInfo.getSpIntVal("restart_notify_open_app_count");
                                if (spIntVal2 < xj.xj("noti_open_restart_times", 1)) {
                                    f.xj().kd(hfVar);
                                    downloadInfo.setSpValue("restart_notify_open_app_count", String.valueOf(spIntVal2 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -2) {
                                int spIntVal3 = downloadInfo.getSpIntVal("restart_notify_continue_count");
                                if (spIntVal3 < xj.xj("noti_continue_restart_times", 1)) {
                                    f.xj().xj(hfVar);
                                    downloadInfo.setSpValue("restart_notify_continue_count", String.valueOf(spIntVal3 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -3 && com.ss.android.socialbase.downloader.tf.y.w(downloadInfo) && !g.hf(hfVar) && (spIntVal = downloadInfo.getSpIntVal("restart_notify_install_count")) < xj.xj("noti_install_restart_times", 1)) {
                                f.xj().w(hfVar);
                                downloadInfo.setSpValue("restart_notify_install_count", String.valueOf(spIntVal + 1));
                            }
                        }
                    }
                }
            }
        }, PushUIConfig.dismissTime);
    }
}
