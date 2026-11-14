package com.ss.android.downloadlib;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.component.utils.pl;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.kwad.library.solder.lib.ext.PluginError;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.sigmob.sdk.base.common.a;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.hf.u;
import com.ss.android.downloadlib.addownload.p;
import com.ss.android.downloadlib.c.g;
import com.ss.android.socialbase.appdownloader.hf;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.en;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.xj.xj;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj implements com.ss.android.downloadad.api.xj, hf.w, en, xj.InterfaceC0510xj {
    private static volatile xj u = null;
    private static String xj = "xj";
    private long hf;
    private hf w;

    public static class hf implements Runnable {
        private int hf;
        private long kd;
        private int u;
        private long w;
        private long xj;

        /* JADX INFO: Access modifiers changed from: private */
        public void hf() {
            this.kd = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (xj()) {
                    xj.xj().xj(this.xj, this.hf);
                }
            } catch (Throwable th) {
                pl.xj(th);
            }
        }

        private hf(long j, int i, long j2, int i2) {
            this.xj = j;
            this.hf = i;
            this.w = j2;
            this.u = i2;
        }

        public boolean xj() {
            DownloadInfo downloadInfo;
            com.ss.android.downloadad.api.xj.hf u = com.ss.android.downloadlib.addownload.hf.y.xj().u(this.xj);
            if (u == null || g.hf(u) || u.w.get() || (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.pl.getContext()).getDownloadInfo(u.v())) == null) {
                return false;
            }
            long ws = u.ws();
            long xj = g.xj(Environment.getDataDirectory());
            long min = Math.min(524288000L, xj / 10);
            long totalBytes = downloadInfo.getTotalBytes();
            double d = totalBytes;
            boolean z = ws <= -1 || totalBytes <= -1 || ((double) ws) >= (2.5d * d) + ((double) min);
            boolean xj2 = com.ss.android.socialbase.appdownloader.hf.xj(com.ss.android.downloadlib.addownload.pl.getContext());
            JSONObject jSONObject = new JSONObject();
            int xj3 = xj(z, u, downloadInfo, xj2, jSONObject);
            this.u = xj3;
            try {
                jSONObject.putOpt("fail_status", Integer.valueOf(xj3));
                jSONObject.putOpt("available_space", Long.valueOf(ws / BaseConstants.MB_VALUE));
                jSONObject.putOpt("total_space", Long.valueOf(xj / BaseConstants.MB_VALUE));
                if (totalBytes > 0) {
                    jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE, Long.valueOf(totalBytes / BaseConstants.MB_VALUE));
                }
                jSONObject.putOpt("space_enough", Integer.valueOf(z ? 1 : 2));
                if (ws > 0 && totalBytes > 0) {
                    jSONObject.put("available_space_ratio", ws / d);
                }
                jSONObject.putOpt("permission_unknown_source_install", Integer.valueOf(xj2 ? 1 : 2));
                jSONObject.put("is_update_download", u.aq() ? 1 : 2);
            } catch (Exception e) {
                pl.xj(e);
            }
            com.ss.android.downloadlib.u.xj.xj().hf("install_failed", jSONObject, u);
            return true;
        }

        private int xj(boolean z, com.ss.android.downloadad.api.xj.hf hfVar, DownloadInfo downloadInfo, boolean z2, JSONObject jSONObject) {
            com.ss.android.socialbase.downloader.f.xj xj = com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId());
            int i = 1;
            if (xj.xj("install_failed_check_ttmd5", 1) == 1) {
                int checkMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put("ttmd5_status", checkMd5Status);
                } catch (Throwable unused) {
                }
                if (!com.ss.android.socialbase.downloader.tf.y.xj(checkMd5Status)) {
                    return PluginError.ERROR_UPD_CAPACITY;
                }
            }
            int i2 = this.u;
            if (i2 != 2000) {
                return i2;
            }
            if (xj.xj("install_failed_check_signature", 1) == 1 && g.kd(com.ss.android.downloadlib.addownload.pl.getContext(), hfVar.kd())) {
                if (!g.xj(g.d(com.ss.android.downloadlib.addownload.pl.getContext(), downloadInfo.getTargetFilePath()), g.f(com.ss.android.downloadlib.addownload.pl.getContext(), hfVar.kd()))) {
                    return PluginError.ERROR_UPD_REQUEST;
                }
            }
            if (!z) {
                return 2002;
            }
            long j = this.kd;
            long j2 = this.w;
            if (j <= j2) {
                return 2000;
            }
            try {
                jSONObject.put("install_time", j - j2);
                if (hfVar.q() <= this.w) {
                    i = 0;
                }
                jSONObject.put("install_again", i);
            } catch (Throwable unused2) {
            }
            if (z2) {
                return PluginError.ERROR_UPD_EXTRACT;
            }
            return 2003;
        }
    }

    /* renamed from: com.ss.android.downloadlib.xj$xj, reason: collision with other inner class name */
    public class RunnableC0474xj implements Runnable {
        private final int hf;

        public RunnableC0474xj(int i) {
            this.hf = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.addownload.hf.y.xj().hf();
                ConcurrentHashMap<Long, com.ss.android.downloadad.api.xj.hf> w = com.ss.android.downloadlib.addownload.hf.y.xj().w();
                if (w == null || w.isEmpty()) {
                    return;
                }
                xj.this.xj(w, this.hf);
            } catch (Exception e) {
                pl.xj(e);
            }
        }
    }

    private xj() {
        com.ss.android.socialbase.appdownloader.hf.xj(this);
        com.ss.android.socialbase.downloader.xj.xj.xj().xj(this);
    }

    public static JSONObject hf(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null && com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("download_event_opt", 1) != 0) {
            try {
                long hf2 = g.hf(0L);
                double d = hf2;
                jSONObject.put("available_space", d / 1048576.0d);
                long totalBytes = downloadInfo.getTotalBytes();
                double d2 = totalBytes;
                jSONObject.put("apk_size", d2 / 1048576.0d);
                if (hf2 > 0 && totalBytes > 0) {
                    jSONObject.put("available_space_ratio", d / d2);
                    return jSONObject;
                }
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
        return jSONObject;
    }

    public static String w(DownloadInfo downloadInfo, com.ss.android.downloadad.api.xj.hf hfVar) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = com.ss.android.downloadlib.addownload.pl.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.w.xj());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e) {
                pl.xj(e);
            }
        }
        if (TextUtils.isEmpty(str) || str.equals(downloadInfo.getPackageName())) {
            return downloadInfo.getPackageName();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("real_package_name", str);
            jSONObject.put("input_package_name", downloadInfo.getPackageName());
        } catch (JSONException e2) {
            pl.xj(e2);
        }
        com.ss.android.downloadlib.u.xj.xj().xj("embeded_ad", "package_name_error", jSONObject, hfVar);
        return str;
    }

    public synchronized void u() {
        hf hfVar = this.w;
        if (hfVar != null) {
            hfVar.hf();
            this.w = null;
        }
    }

    public static xj xj() {
        if (u == null) {
            synchronized (xj.class) {
                try {
                    if (u == null) {
                        u = new xj();
                    }
                } finally {
                }
            }
        }
        return u;
    }

    public static synchronized void xj(DownloadInfo downloadInfo, com.ss.android.downloadad.api.xj.hf hfVar) {
        synchronized (xj.class) {
            if (downloadInfo == null) {
                com.ss.android.downloadlib.kd.w.xj().xj("onDownloadFinish info null");
                return;
            }
            if (hfVar == null) {
                com.ss.android.downloadlib.kd.w.xj().xj("onDownloadFinish nativeModel null");
                return;
            }
            if (hfVar.l() != 1) {
                return;
            }
            com.ss.android.downloadlib.w.f.xj().u(hfVar);
            String w = w(downloadInfo, hfVar);
            com.ss.android.downloadlib.addownload.hf.y.xj().hf(downloadInfo.getUrl(), w);
            Map<Long, com.ss.android.downloadad.api.xj.hf> xj2 = com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadInfo.getUrl(), w);
            hfVar.y(System.currentTimeMillis());
            hfVar.kd(2);
            hfVar.hf(w);
            xj2.put(Long.valueOf(hfVar.hf()), hfVar);
            com.ss.android.downloadlib.addownload.hf.d.xj().xj(xj2.values());
            xj(hfVar);
            p.xj().hf(hfVar.pz(), downloadInfo);
            hfVar.pl(System.currentTimeMillis());
            f.xj().xj(downloadInfo, w);
            if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
                if (com.ss.android.downloadlib.c.kd.xj((com.ss.android.downloadad.api.xj.xj) hfVar).xj("enable_app_install_receiver", 1) != 1 && com.ss.android.downloadlib.addownload.pl.d().optInt("enable_app_install_receiver", 1) != 1) {
                    com.ss.android.downloadlib.addownload.g.xj().xj(hfVar);
                }
                xj().hf(downloadInfo, hfVar);
                if (hfVar.b()) {
                    com.ss.android.downloadlib.addownload.xj.xj.xj().xj(downloadInfo.getId(), hfVar.hf(), hfVar.pl(), w, downloadInfo.getTitle(), hfVar.u(), downloadInfo.getTargetFilePath());
                }
                hfVar.hf();
                hfVar.u();
            }
        }
    }

    public void hf(DownloadInfo downloadInfo, final com.ss.android.downloadad.api.xj.hf hfVar) {
        if (downloadInfo == null || hfVar == null || com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        final String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        kd.xj().hf(new Runnable() { // from class: com.ss.android.downloadlib.xj.3
            @Override // java.lang.Runnable
            public void run() {
                String xj2 = com.ss.android.downloadlib.c.xj.xj(targetFilePath);
                if (TextUtils.isEmpty(xj2)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.ats.u.xj(com.ss.android.downloadlib.addownload.pl.getContext(), "sp_ttdownloader_md5", 0).edit().putString(String.valueOf(hfVar.hf()), xj2).apply();
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.xj.xj.InterfaceC0510xj
    public void hf() {
        com.ss.android.socialbase.downloader.w.xj.hf(xj, "onAppForeground()");
        u();
        xj(5);
    }

    @Override // com.ss.android.socialbase.downloader.xj.xj.InterfaceC0510xj
    public void w() {
        com.ss.android.socialbase.downloader.w.xj.hf(xj, "onAppBackground()");
        xj(6);
    }

    private int hf(com.ss.android.downloadad.api.xj.hf hfVar) {
        int realStatus;
        double xj2 = com.ss.android.socialbase.downloader.f.xj.xj(hfVar.v()).xj("download_failed_finally_hours", 48.0d);
        if (xj2 <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - hfVar.ff() < xj2 * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (hfVar.u.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.pl.getContext()).getDownloadInfo(hfVar.v());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && hfVar.u.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                xj(jSONObject, downloadInfo);
                jSONObject.putOpt("download_status", Integer.valueOf(realStatus));
                jSONObject.putOpt("fail_status", Integer.valueOf(hfVar.j()));
                jSONObject.putOpt("fail_msg", hfVar.en());
                jSONObject.put("download_failed_times", hfVar.dk());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                }
                jSONObject.put("is_update_download", hfVar.aq() ? 1 : 2);
                com.ss.android.downloadlib.u.xj.xj().xj(hfVar.tf(), "download_failed_finally", jSONObject, hfVar);
                com.ss.android.downloadlib.addownload.hf.d.xj().xj(hfVar);
                return 0;
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
        return 1;
    }

    private JSONObject hf(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.xj xjVar) {
        com.ss.android.downloadad.api.xj.hf xj2 = com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadInfo);
        if (xj2 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        xjVar.xj(jSONObject);
        try {
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
        } catch (Throwable th) {
            pl.xj(th);
        }
        com.ss.android.downloadlib.c.y.xj(jSONObject, downloadInfo.getId());
        com.ss.android.downloadlib.u.xj.xj().xj("embeded_ad", "ah_result", jSONObject, xj2);
        return jSONObject;
    }

    public synchronized void xj(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!g.hf()) {
            final com.ss.android.downloadad.api.xj.hf xj2 = com.ss.android.downloadlib.addownload.hf.y.xj().xj(str);
            if (xj2 == null) {
                com.ss.android.downloadlib.addownload.hf.u.xj().xj(str);
                return;
            }
            com.ss.android.downloadlib.addownload.kd xj3 = f.xj().xj(xj2.xj());
            if (xj3 != null) {
                xj3.y();
            }
            if (xj2.w.get()) {
                return;
            }
            if (com.ss.android.socialbase.downloader.f.xj.xj(xj2.v()).hf("notification_opt_2") == 1) {
                com.ss.android.socialbase.downloader.notification.hf.xj().y(xj2.v());
            }
            new com.ss.android.downloadlib.hf.hf().xj(xj2, new com.ss.android.downloadlib.hf.c() { // from class: com.ss.android.downloadlib.xj.1
                @Override // com.ss.android.downloadlib.hf.c
                public void xj(boolean z) {
                    com.ss.android.socialbase.downloader.w.xj.hf(xj.xj, "appBackForeground->".concat(String.valueOf(z)));
                    if (!z) {
                        if (com.ss.android.downloadlib.hf.xj.xj(str, xj2) || xj2.r() != 4) {
                            return;
                        }
                        com.ss.android.downloadlib.addownload.xj.xj.xj().xj(xj2);
                        return;
                    }
                    if (!(com.ss.android.downloadlib.hf.y.w(xj2) ? com.ss.android.downloadlib.hf.xj.xj(str, xj2) : false) && com.ss.android.downloadlib.hf.y.u(xj2) && xj2.r() == 4) {
                        com.ss.android.downloadlib.addownload.xj.xj.xj().xj(xj2);
                    }
                }
            }, com.ss.android.downloadlib.c.kd.xj((com.ss.android.downloadad.api.xj.xj) xj2).xj("try_applink_delay_after_installed", 0));
            com.ss.android.downloadlib.w.f.xj().y(xj2);
            xj(str, xj2);
            com.ss.android.downloadlib.addownload.xj.xj.xj().hf(str);
            DownloadInfo xj4 = xj((List<DownloadInfo>) Downloader.getInstance(com.ss.android.downloadlib.addownload.pl.getContext()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK), str);
            if (xj4 != null) {
                if (com.ss.android.socialbase.downloader.f.xj.xj(xj4.getId()).hf("no_hide_notification") != 1) {
                    com.ss.android.socialbase.downloader.notification.hf.xj().xj(xj4.getId());
                }
                f.xj().hf(xj4, str);
                com.ss.android.downloadlib.addownload.w.u.xj(xj4);
                return;
            }
            f.xj().hf(null, str);
            return;
        }
        throw new RuntimeException("handleAppInstalled in main thread.");
    }

    public void xj(DownloadInfo downloadInfo, com.ss.android.downloadad.api.xj.hf hfVar, int i) {
        long max;
        if (downloadInfo == null || hfVar == null) {
            return;
        }
        u();
        long currentTimeMillis = System.currentTimeMillis();
        hfVar.hf(currentTimeMillis);
        hfVar.c(g.xj(Environment.getDataDirectory(), -1L));
        if (i != 2000) {
            max = 2000;
        } else {
            long xj2 = com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("check_install_failed_delay_time", 120000L);
            if (xj2 < 0) {
                return;
            } else {
                max = Math.max(xj2, 30000L);
            }
        }
        long j = max;
        hf hfVar2 = new hf(hfVar.hf(), downloadInfo.getId(), currentTimeMillis, i);
        kd.xj().xj(hfVar2, j);
        this.w = hfVar2;
        com.ss.android.downloadlib.addownload.hf.d.xj().xj(hfVar);
    }

    public void xj(final long j, int i) {
        long xj2 = com.ss.android.socialbase.downloader.f.xj.xj(i).xj("check_install_finish_hijack_delay_time", 900000L);
        if (xj2 < 0) {
            return;
        }
        kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.xj.2
            @Override // java.lang.Runnable
            public void run() {
                xj.xj().xj(j);
            }
        }, Math.max(xj2, 300000L));
    }

    public void xj(long j) {
        u.xj xj2;
        int i;
        try {
            com.ss.android.downloadad.api.xj.hf u2 = com.ss.android.downloadlib.addownload.hf.y.xj().u(j);
            if (u2 != null && !g.hf(u2) && !u2.w.get()) {
                Pair<u.xj, Integer> hf2 = com.ss.android.downloadlib.addownload.hf.u.xj().hf(u2);
                if (hf2 != null) {
                    xj2 = (u.xj) hf2.first;
                    i = ((Integer) hf2.second).intValue();
                } else {
                    xj2 = com.ss.android.downloadlib.addownload.hf.u.xj().xj(u2);
                    i = -1;
                }
                if (xj2 == null) {
                    return;
                }
                com.ss.android.downloadlib.addownload.hf.u.xj().hf(xj2.xj);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", xj2.u);
                jSONObject.put("installed_pkg_name", xj2.xj);
                if (i != -1) {
                    jSONObject.put("error_code", i);
                    com.ss.android.downloadlib.c.y.xj(jSONObject, u2.v());
                    com.ss.android.downloadlib.u.xj.xj().hf("install_finish_hijack", jSONObject, u2);
                    return;
                }
                com.ss.android.downloadlib.u.xj.xj().hf("install_finish_may_hijack", jSONObject, u2);
            }
        } catch (Throwable th) {
            com.ss.android.downloadlib.kd.w.xj().xj(th, "trySendInstallFinishHijack");
        }
    }

    public void xj(String str, com.ss.android.downloadad.api.xj.hf hfVar) {
        if (hfVar != null && g.hf(hfVar) && hfVar.w.compareAndSet(false, true)) {
            int i = 4;
            if (hfVar.r() == 4) {
                com.ss.android.download.api.config.tf ht = com.ss.android.downloadlib.addownload.pl.ht();
                if (ht != null) {
                    ht.xj(hfVar.pz());
                }
            } else {
                i = 3;
            }
            com.ss.android.downloadlib.u.xj.xj().xj(hfVar.tf(), a.F, xj(hfVar, str, i), hfVar);
            com.ss.android.downloadlib.addownload.hf.d.xj().xj(hfVar);
        }
    }

    private static DownloadInfo xj(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (!str.equals(downloadInfo.getPackageName())) {
                        if (g.xj(com.ss.android.downloadlib.addownload.pl.getContext(), downloadInfo.getTargetFilePath(), str)) {
                        }
                    }
                    return downloadInfo;
                }
            }
        }
        return null;
    }

    public static JSONObject xj(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null) {
            int i = 1;
            if (com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("download_event_opt", 1) != 0) {
                try {
                    jSONObject.put("download_id", downloadInfo.getId());
                    jSONObject.put("name", downloadInfo.getName());
                    jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                    jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                    jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                    jSONObject.put("current_network_quality", com.ss.android.socialbase.downloader.network.p.xj().hf().name());
                    jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                    jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                    jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                    jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                    jSONObject.put("retry_count", downloadInfo.getRetryCount());
                    jSONObject.put("cur_retry_time", downloadInfo.getCurRetryTime());
                    jSONObject.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                    jSONObject.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                    jSONObject.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                    jSONObject.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                    jSONObject.put("total_retry_count", downloadInfo.getTotalRetryCount());
                    jSONObject.put("cur_retry_time_in_total", downloadInfo.getCurRetryTimeInTotal());
                    jSONObject.put("real_download_time", downloadInfo.getRealDownloadTime());
                    jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
                    jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
                    jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
                    jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
                    jSONObject.put("chunk_downgrade_retry_used", downloadInfo.isChunkDowngradeRetryUsed() ? 1 : 0);
                    jSONObject.put("need_chunk_downgrade_retry", downloadInfo.isNeedChunkDowngradeRetry() ? 1 : 0);
                    jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                    jSONObject.put("preconnect_level", downloadInfo.getPreconnectLevel());
                    jSONObject.put(TKDownloadReason.KSAD_TK_MD5, downloadInfo.getMd5());
                    jSONObject.put("expect_file_length", downloadInfo.getExpectFileLength());
                    jSONObject.put("retry_schedule_count", downloadInfo.getRetryScheduleCount());
                    jSONObject.put("rw_concurrent", downloadInfo.isRwConcurrent() ? 1 : 0);
                    double curBytes = downloadInfo.getCurBytes() / 1048576.0d;
                    double realDownloadTime = downloadInfo.getRealDownloadTime() / 1000.0d;
                    if (curBytes > 0.0d && realDownloadTime > 0.0d) {
                        double d = curBytes / realDownloadTime;
                        try {
                            jSONObject.put("download_speed", d);
                        } catch (Exception unused) {
                        }
                        com.ss.android.socialbase.downloader.w.xj.hf(xj, "download speed : " + d + "MB/s");
                    }
                    try {
                        jSONObject.put("is_download_service_foreground", Downloader.getInstance(com.ss.android.downloadlib.addownload.pl.getContext()).isDownloadServiceForeground(downloadInfo.getId()) ? 1 : 0);
                    } catch (Exception e) {
                        pl.xj(e);
                    }
                    if (downloadInfo.getBackUpUrls() != null) {
                        jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls().size());
                        jSONObject.put("cur_backup_url_index", downloadInfo.getCurBackUpUrlIndex());
                    }
                    jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.addownload.w.u.xj().hf(downloadInfo.getUrl()));
                    jSONObject.put("mime_type", downloadInfo.getMimeType());
                    if (!com.ss.android.socialbase.downloader.tf.y.w(com.ss.android.downloadlib.addownload.pl.getContext())) {
                        i = 2;
                    }
                    jSONObject.put("network_available", i);
                    jSONObject.put("status_code", downloadInfo.getHttpStatusCode());
                    hf(jSONObject, downloadInfo);
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        }
        return jSONObject;
    }

    private static void xj(com.ss.android.downloadad.api.xj.hf hfVar) {
        if (hfVar == null) {
            return;
        }
        String n = TextUtils.isEmpty(hfVar.n()) ? "" : hfVar.n();
        DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.pl.getContext()).getDownloadInfo(hfVar.v());
        hfVar.pl("");
        com.ss.android.downloadlib.addownload.hf.d.xj().xj(hfVar);
        JSONObject xj2 = xj(new JSONObject(), downloadInfo);
        int i = 1;
        try {
            xj2.putOpt("finish_reason", n);
            xj2.putOpt("finish_from_reserve_wifi", Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException e) {
            pl.xj(e);
        }
        com.ss.android.downloadad.api.xj.hf xj3 = com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadInfo);
        com.ss.android.downloadlib.c.y.xj(xj2, downloadInfo.getId());
        try {
            xj2.put("download_failed_times", xj3.dk());
            xj2.put("can_show_notification", com.ss.android.socialbase.appdownloader.kd.u.xj() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                xj2.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            xj2.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
            xj2.put("has_send_download_failed_finally", xj3.u.get() ? 1 : 2);
            if (!xj3.aq()) {
                i = 2;
            }
            xj2.put("is_update_download", i);
            com.ss.android.downloadlib.c.y.xj(xj3, xj2);
        } catch (Throwable th) {
            pl.xj(th);
        }
        com.ss.android.downloadlib.u.xj.xj().hf(a.D, xj2, hfVar);
    }

    private int xj(com.ss.android.downloadad.api.xj.hf hfVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int hf2 = com.ss.android.socialbase.appdownloader.w.hf(com.ss.android.downloadlib.addownload.pl.getContext(), downloadInfo);
        int hf3 = g.hf(com.ss.android.downloadlib.addownload.pl.getContext(), str);
        if (hf2 > 0 && hf3 > 0 && hf2 != hf3) {
            return hf3 > hf2 ? 3011 : 3010;
        }
        if (com.ss.android.socialbase.downloader.f.xj.xj(hfVar.v()).xj("install_finish_check_ttmd5", 1) != 1) {
            return 3001;
        }
        String string = com.bytedance.sdk.openadsdk.ats.u.xj(com.ss.android.downloadlib.addownload.pl.getContext(), "sp_ttdownloader_md5", 0).getString(String.valueOf(hfVar.hf()), null);
        if (TextUtils.isEmpty(string) && downloadInfo != null) {
            string = com.ss.android.downloadlib.c.xj.xj(downloadInfo.getTargetFilePath());
        }
        int xj2 = com.ss.android.downloadlib.c.xj.xj(string, com.ss.android.downloadlib.c.xj.hf(str));
        try {
            jSONObject.put("ttmd5_status", xj2);
        } catch (Throwable unused) {
        }
        if (xj2 == 0) {
            return 3000;
        }
        return xj2 == 1 ? 3002 : 3001;
    }

    @Override // com.ss.android.downloadad.api.xj
    public void xj(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.hf < 120000) {
            return;
        }
        kd.xj().xj(new RunnableC0474xj(i), this.hf > 0 ? 2000L : 8000L);
        this.hf = currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(ConcurrentHashMap<Long, com.ss.android.downloadad.api.xj.hf> concurrentHashMap, int i) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.downloadad.api.xj.hf hfVar : concurrentHashMap.values()) {
            if (hfVar.w.get()) {
                if (currentTimeMillis - hfVar.ff() >= com.ss.android.socialbase.downloader.f.xj.xj(hfVar.v()).xj("start_event_expire_hours", 168) * BaseConstants.Time.HOUR) {
                    arrayList.add(Long.valueOf(hfVar.hf()));
                }
            } else if (hfVar.l() == 1) {
                if (hf(hfVar) <= 0 && currentTimeMillis - hfVar.ff() >= com.ss.android.socialbase.downloader.f.xj.xj(hfVar.v()).xj("start_event_expire_hours", 168) * BaseConstants.Time.HOUR) {
                    arrayList.add(Long.valueOf(hfVar.hf()));
                }
            } else if (hfVar.l() == 2) {
                if (!hfVar.dq()) {
                    if (g.hf(hfVar)) {
                        if (hfVar.r() == 4) {
                            i = hfVar.r();
                            com.ss.android.download.api.config.tf ht = com.ss.android.downloadlib.addownload.pl.ht();
                            if (ht != null) {
                                ht.xj(hfVar.pz());
                            }
                        }
                        hfVar.tf(false);
                        com.ss.android.downloadlib.u.xj.xj().xj(xj(hfVar, hfVar.kd(), i), hfVar);
                        arrayList.add(Long.valueOf(hfVar.hf()));
                        com.ss.android.downloadlib.addownload.w.u.xj(hfVar);
                    } else if (hfVar.dq() && hfVar.r() == 4 && i == 1 && !g.hf(hfVar)) {
                        com.ss.android.downloadlib.c.pl.xj().xj(xj, "trySendAndRefreshAdEvent", "命中兜底逻辑,尝试对广播监听执行冷启兜底逻辑");
                        d.xj().xj(hfVar);
                    } else if (currentTimeMillis - hfVar.ff() >= com.ss.android.socialbase.downloader.f.xj.xj(hfVar.v()).xj("finish_event_expire_hours", 168) * BaseConstants.Time.HOUR) {
                        arrayList.add(Long.valueOf(hfVar.hf()));
                    } else if (TextUtils.isEmpty(hfVar.kd())) {
                        arrayList.add(Long.valueOf(hfVar.hf()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(hfVar.hf()));
            }
        }
        com.ss.android.downloadlib.addownload.hf.y.xj().xj(arrayList);
    }

    @Override // com.ss.android.socialbase.appdownloader.hf.w
    public void xj(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.xj xjVar) {
        JSONObject hf2;
        if (downloadInfo == null || xjVar == null) {
            return;
        }
        JSONArray kd = com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).kd("ah_report_config");
        if (xjVar.hf != 0) {
            downloadInfo.getTempCacheData().remove("intent");
        }
        if (kd == null || (hf2 = hf(downloadInfo, xjVar)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", hf2);
    }

    @Override // com.ss.android.socialbase.downloader.depend.en
    public void xj(final DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.kd.w.xj().xj("info is null");
        } else if ((com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo).hf("check_applink_mode") & 2) != 0) {
            final JSONObject jSONObject = (JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json");
            com.ss.android.downloadlib.hf.kd.xj().hf(new com.ss.android.downloadlib.hf.u() { // from class: com.ss.android.downloadlib.xj.4
                @Override // com.ss.android.downloadlib.hf.u
                public void xj(boolean z) {
                    if (!z) {
                        Intent intent = (Intent) downloadInfo.getTempCacheData().get("intent");
                        if (intent != null) {
                            downloadInfo.getTempCacheData().remove("intent");
                            com.ss.android.socialbase.appdownloader.w.xj(com.ss.android.downloadlib.addownload.pl.getContext(), intent);
                            g.xj(jSONObject, LiveConfigKey.BACKUP, (Object) 1);
                        } else {
                            g.xj(jSONObject, LiveConfigKey.BACKUP, (Object) 2);
                        }
                    }
                    com.ss.android.downloadad.api.xj.hf xj2 = com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadInfo);
                    if (xj2 != null) {
                        com.ss.android.downloadlib.u.xj.xj().xj(z ? "installer_delay_success" : "installer_delay_failed", jSONObject, xj2);
                    } else {
                        com.ss.android.downloadlib.kd.w.xj().hf("ah nativeModel=null");
                    }
                    if (z) {
                        com.ss.android.downloadlib.addownload.pl.pz();
                        com.ss.android.downloadlib.addownload.pl.getContext();
                    }
                }
            });
        }
    }

    private JSONObject xj(com.ss.android.downloadad.api.xj.hf hfVar, String str, int i) {
        com.ss.android.socialbase.appdownloader.xj xj2;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.pl.getContext()).getDownloadInfo(hfVar.v());
            jSONObject.putOpt("scene", Integer.valueOf(i));
            com.ss.android.downloadlib.c.y.xj(jSONObject, hfVar.v());
            com.ss.android.downloadlib.c.y.xj(hfVar, jSONObject);
            jSONObject.put("is_update_download", hfVar.aq() ? 1 : 2);
            jSONObject.put("install_after_back_app", hfVar.lw() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", hfVar.hl() ? "1" : "2");
            if (downloadInfo != null) {
                xj(jSONObject, downloadInfo);
                try {
                    jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                    if (hfVar.q() > 0) {
                        long currentTimeMillis = System.currentTimeMillis() - hfVar.q();
                        jSONObject.put("install_time", currentTimeMillis);
                        if (currentTimeMillis > com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("check_install_finish_expired_duration", 86400000L)) {
                            jSONObject.put("install_expired", 1);
                        } else {
                            jSONObject.put("install_expired", 0);
                        }
                    }
                } catch (Throwable unused) {
                }
                String xj3 = com.ss.android.socialbase.downloader.tf.y.xj(downloadInfo.getTempCacheData().get("ah_attempt"), (String) null);
                if (!TextUtils.isEmpty(xj3) && (xj2 = com.ss.android.socialbase.appdownloader.xj.xj(xj3)) != null) {
                    xj2.xj(jSONObject);
                }
            }
            int xj4 = xj(hfVar, downloadInfo, str, jSONObject);
            jSONObject.put("fail_status", xj4);
            if (xj4 == 3000) {
                jSONObject.put("hijack", 2);
            } else if (xj4 == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        return jSONObject;
    }

    public void xj(DownloadInfo downloadInfo, long j, long j2, long j3, long j4, long j5, boolean z) {
        com.ss.android.downloadad.api.xj.hf xj2 = com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadInfo);
        if (xj2 == null) {
            com.ss.android.downloadlib.kd.w.xj().xj("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("space_before", Double.valueOf(j / 1048576.0d));
            jSONObject.putOpt("space_cleaned", Double.valueOf((j2 - j) / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j4));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j3));
            jSONObject.putOpt("byte_required_after", Double.valueOf((j3 - j2) / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j5));
            com.ss.android.downloadlib.c.y.w(downloadInfo, jSONObject);
            com.ss.android.downloadlib.u.xj.xj().xj("cleanup", jSONObject, xj2);
        } catch (Exception e) {
            pl.xj(e);
        }
    }
}
