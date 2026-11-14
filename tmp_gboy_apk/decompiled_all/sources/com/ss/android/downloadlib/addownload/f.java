package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.download.api.config.pz;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.c.am;
import com.ss.android.downloadlib.c.tf;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f implements am.xj {
    private long hf;
    private hf kd;
    private kd u;
    private boolean w = false;
    public com.ss.android.downloadlib.addownload.hf.kd xj;

    public interface hf {
        void xj(DownloadInfo downloadInfo);
    }

    public static class xj extends com.ss.android.socialbase.downloader.depend.xj {
        private com.ss.android.downloadlib.c.am xj;

        public xj(com.ss.android.downloadlib.c.am amVar) {
            this.xj = amVar;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            xj(downloadInfo, -4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            xj(downloadInfo, -1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            xj(downloadInfo, -2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            xj(downloadInfo, 1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            xj(downloadInfo, 4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            xj(downloadInfo, 2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            xj(downloadInfo, -3);
        }

        @Override // com.ss.android.socialbase.downloader.depend.xj, com.ss.android.socialbase.downloader.depend.v
        public void xj(DownloadInfo downloadInfo) {
            xj(downloadInfo, 11);
        }

        private void xj(DownloadInfo downloadInfo, int i) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = downloadInfo;
            obtain.arg1 = i;
            this.xj.sendMessage(obtain);
        }
    }

    public f(kd kdVar) {
        this.u = kdVar;
    }

    private boolean kd() {
        return this.xj.u.isAddToDownloadManage();
    }

    private boolean u() {
        DownloadModel downloadModel = this.xj.hf;
        return (downloadModel == null || TextUtils.isEmpty(downloadModel.getPackageName()) || TextUtils.isEmpty(this.xj.hf.getDownloadUrl())) ? false : true;
    }

    private boolean w() {
        return u() && kd();
    }

    private boolean y() {
        return com.ss.android.downloadlib.c.g.xj(this.xj.hf) && d.xj(this.xj.u.getLinkMode());
    }

    public void hf(DownloadInfo downloadInfo) {
        hf hfVar = this.kd;
        if (hfVar != null) {
            hfVar.xj(downloadInfo);
            this.kd = null;
        }
    }

    @Override // com.ss.android.downloadlib.c.am.xj
    public void xj(Message message) {
    }

    private boolean kd(DownloadInfo downloadInfo) {
        return !com.ss.android.downloadlib.c.g.xj(this.xj.hf) && y(downloadInfo);
    }

    private boolean y(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && com.ss.android.socialbase.downloader.tf.y.u(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    public void w(DownloadInfo downloadInfo) {
        if (!d.xj(this.xj.hf) || this.w) {
            return;
        }
        com.ss.android.downloadlib.u.xj.xj().xj("file_status", (downloadInfo == null || !com.ss.android.downloadlib.c.g.hf(downloadInfo.getTargetFilePath())) ? 2 : 1, this.xj);
        this.w = true;
    }

    public void xj(long j) {
        this.hf = j;
        com.ss.android.downloadlib.addownload.hf.kd kd = com.ss.android.downloadlib.addownload.hf.y.xj().kd(j);
        this.xj = kd;
        if (kd.dk()) {
            com.ss.android.downloadlib.kd.w.xj().xj("setAdId ModelBox notValid");
        }
    }

    private void hf(final pz pzVar) {
        String str;
        if (com.ss.android.downloadlib.c.tf.hf(com.kuaishou.weapon.p0.g.j)) {
            if (pzVar != null) {
                pzVar.xj();
                return;
            }
            return;
        }
        if (com.ss.android.downloadlib.c.g.xj()) {
            str = "android.permission.READ_MEDIA_IMAGES";
            if (com.ss.android.downloadlib.c.tf.hf("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.c.tf.hf("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.c.tf.hf("android.permission.READ_MEDIA_VIDEO")) {
                if (pzVar != null) {
                    pzVar.xj();
                    return;
                }
                return;
            }
        } else {
            str = com.kuaishou.weapon.p0.g.i;
        }
        com.ss.android.downloadlib.c.tf.xj(new String[]{str}, new tf.xj() { // from class: com.ss.android.downloadlib.addownload.f.2
            @Override // com.ss.android.downloadlib.c.tf.xj
            public void xj() {
                pz pzVar2 = pzVar;
                if (pzVar2 != null) {
                    pzVar2.xj();
                }
            }

            @Override // com.ss.android.downloadlib.c.tf.xj
            public void xj(String str2) {
                pz pzVar2 = pzVar;
                if (pzVar2 != null) {
                    pzVar2.xj(str2);
                }
            }
        });
    }

    public boolean u(DownloadInfo downloadInfo) {
        return y() || kd(downloadInfo);
    }

    public void xj(DownloadInfo downloadInfo) {
        this.w = false;
        hf(downloadInfo);
    }

    public boolean xj(Context context, int i, boolean z) {
        if (com.ss.android.downloadlib.c.g.xj(this.xj.hf)) {
            com.ss.android.downloadad.api.xj.hf u = com.ss.android.downloadlib.addownload.hf.y.xj().u(this.xj.xj);
            if (u != null) {
                com.ss.android.socialbase.downloader.notification.hf.xj().y(u.v());
            }
            return com.ss.android.downloadlib.hf.xj.xj(this.xj);
        }
        if (xj(i) && !TextUtils.isEmpty(this.xj.hf.getPackageName()) && pl.d().optInt("disable_market") != 1) {
            if (com.ss.android.downloadlib.hf.xj.xj(this.xj, i)) {
                return true;
            }
            return this.u.d() && this.u.u(true);
        }
        if (!z || this.xj.u.getDownloadMode() != 4 || this.u.kd()) {
            return false;
        }
        this.u.w(true);
        return true;
    }

    public String hf() {
        File externalFilesDir = pl.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        if (externalFilesDir.exists()) {
            return externalFilesDir.getAbsolutePath();
        }
        return null;
    }

    public static List<com.ss.android.download.api.download.xj> hf(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.download.api.download.xj) {
                    arrayList.add((com.ss.android.download.api.download.xj) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.xj) {
                            arrayList.add((com.ss.android.download.api.download.xj) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof com.ss.android.download.api.download.xj) {
                            arrayList.add((com.ss.android.download.api.download.xj) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean xj(int i) {
        if (this.xj.u.getDownloadMode() == 2 && i == 2) {
            return true;
        }
        return this.xj.u.getDownloadMode() == 2 && i == 1 && pl.d().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean xj(int i, DownloadModel downloadModel) {
        return com.ss.android.socialbase.appdownloader.y.kd.w() && xj(i) && !com.ss.android.downloadlib.c.g.xj(downloadModel);
    }

    public boolean xj(boolean z) {
        return !z && this.xj.u.getDownloadMode() == 1;
    }

    public void xj(final pz pzVar) {
        if (!TextUtils.isEmpty(this.xj.hf.getFilePath())) {
            String filePath = this.xj.hf.getFilePath();
            if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                pzVar.xj();
                return;
            }
            try {
                String parent = pl.getContext().getExternalCacheDir().getParent();
                if (parent.endsWith("/cache")) {
                    parent = parent.substring(0, parent.indexOf("/cache"));
                }
                if (filePath.startsWith(parent)) {
                    pzVar.xj();
                    return;
                }
            } catch (Exception unused) {
            }
        }
        hf(new pz() { // from class: com.ss.android.downloadlib.addownload.f.1
            @Override // com.ss.android.download.api.config.pz
            public void xj() {
                pzVar.xj();
            }

            @Override // com.ss.android.download.api.config.pz
            public void xj(String str) {
                pl.w().xj(1, pl.getContext(), f.this.xj.hf, "您已禁止使用存储权限，请授权后再下载", null, 1);
                com.ss.android.downloadlib.u.xj.xj().hf(f.this.hf, 1);
                pzVar.xj(str);
            }
        });
    }

    public void xj(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        hf hfVar;
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        int i = message.arg1;
        if (i != 1 && i != 6 && i == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.ss.android.downloadlib.f xj2 = com.ss.android.downloadlib.f.xj();
                com.ss.android.downloadlib.addownload.hf.kd kdVar = this.xj;
                xj2.xj(kdVar.hf, kdVar.u, kdVar.w);
                downloadInfo.setFirstDownload(false);
            }
            com.ss.android.downloadlib.u.xj.xj().xj(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        tf.xj(downloadShortInfo);
        int xj3 = com.ss.android.socialbase.appdownloader.w.xj(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int curBytes = totalBytes > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((totalBytes > 0 || com.ss.android.socialbase.downloader.f.xj.w().xj("fix_click_start")) && (hfVar = this.kd) != null) {
            hfVar.xj(downloadInfo);
            this.kd = null;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : xj(map)) {
            if (xj3 != 1) {
                if (xj3 == 2) {
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, tf.xj(downloadInfo.getId(), curBytes));
                } else if (xj3 == 3) {
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (com.ss.android.downloadlib.c.g.xj(this.xj.hf)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                }
            } else if (downloadInfo.getStatus() != 11) {
                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, tf.xj(downloadInfo.getId(), curBytes));
            } else {
                Iterator<com.ss.android.download.api.download.xj> it = hf(map).iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    public void xj() {
        if (this.kd == null) {
            this.kd = new hf() { // from class: com.ss.android.downloadlib.addownload.f.3
                @Override // com.ss.android.downloadlib.addownload.f.hf
                public void xj(DownloadInfo downloadInfo) {
                    com.ss.android.downloadlib.u.xj.xj().xj(f.this.hf, 2, downloadInfo);
                }
            };
        }
    }

    public int xj(Context context, IDownloadListener iDownloadListener) {
        com.ss.android.downloadlib.addownload.w.xj xjVar;
        com.ss.android.socialbase.downloader.model.w xj2;
        if (context == null) {
            return 0;
        }
        Map<String, String> headers = this.xj.hf.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (pl.d().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.xj.hf.getLogExtra()) && (xj2 = xj(this.xj.hf.getLogExtra())) != null) {
            arrayList.add(xj2);
        }
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.w(entry.getKey(), entry.getValue()));
                }
            }
        }
        String xj3 = com.ss.android.downloadlib.c.u.xj(String.valueOf(this.xj.hf.getId()), this.xj.hf.getNotificationJumpUrl(), this.xj.hf.isShowToast(), String.valueOf(this.xj.hf.getModelType()));
        com.ss.android.socialbase.downloader.f.xj hf2 = com.ss.android.downloadlib.c.kd.hf(this.xj.hf);
        JSONObject xj4 = com.ss.android.downloadlib.c.kd.xj(this.xj.hf);
        if (!this.xj.u.enableAH()) {
            xj4 = com.ss.android.downloadlib.c.g.xj(xj4);
            com.ss.android.downloadlib.c.g.xj(xj4, "ah_plans", new JSONArray());
        }
        int executorGroup = this.xj.hf.getExecutorGroup();
        if (this.xj.hf.isAd() || d.hf(this.xj.hf)) {
            executorGroup = 4;
        }
        String xj5 = xj(hf2);
        DownloadInfo downloadInfo = Downloader.getInstance(pl.getContext()).getDownloadInfo(com.ss.android.socialbase.downloader.downloader.w.xj(this.xj.hf.getDownloadUrl(), xj5));
        if (downloadInfo != null && 3 == this.xj.hf.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.ss.android.socialbase.appdownloader.y qt = new com.ss.android.socialbase.appdownloader.y(context, this.xj.hf.getDownloadUrl()).hf(this.xj.hf.getBackupUrls()).xj(this.xj.hf.getName()).kd(xj3).xj(arrayList).xj(this.xj.hf.isShowNotification()).w(this.xj.hf.isNeedWifi()).hf(this.xj.hf.getFileName()).w(xj5).p(this.xj.hf.getAppIcon()).f(this.xj.hf.getMd5()).tf(this.xj.hf.getSdkMonitorScene()).xj(this.xj.hf.getExpectFileLength()).xj(iDownloadListener).pl(this.xj.hf.needIndependentProcess() || hf2.xj("need_independent_process", 0) == 1).xj(this.xj.hf.getDownloadFileUriProvider()).hf(this.xj.hf.autoInstallWithoutNotification()).c(this.xj.hf.getPackageName()).u(1000).kd(100).xj(xj4).d(true).tf(true).hf(hf2.xj("retry_count", 5)).w(hf2.xj("backup_url_retry_count", 0)).tf(true).g(hf2.xj("need_head_connection", 0) == 1).u(hf2.xj("need_https_to_http_retry", 0) == 1).f(hf2.xj("need_chunk_downgrade_retry", 1) == 1).c(hf2.xj("need_retry_delay", 0) == 1).d(hf2.w("retry_delay_time_array")).p(hf2.xj("need_reuse_runnable", 0) == 1).y(executorGroup).zg(this.xj.hf.isAutoInstall()).qt(this.xj.hf.distinctDir());
        if (!TextUtils.isEmpty(this.xj.hf.getMimeType())) {
            qt.y(this.xj.hf.getMimeType());
        } else {
            qt.y(AdBaseConstants.MIME_APK);
        }
        if (hf2.xj("notification_opt_2", 0) == 1) {
            qt.xj(false);
            qt.hf(true);
        }
        if (hf2.xj("clear_space_use_disk_handler", 0) == 1) {
            xjVar = new com.ss.android.downloadlib.addownload.w.xj();
            qt.xj(xjVar);
        } else {
            xjVar = null;
        }
        DownloadModel downloadModel = this.xj.hf;
        if ((downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(((AdDownloadModel) downloadModel).getTaskKey())) {
            qt.u(((AdDownloadModel) this.xj.hf).getTaskKey());
        }
        int xj6 = d.xj(this.xj, w(), qt);
        if (xjVar != null) {
            xjVar.xj(xj6);
        }
        return xj6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:
    
        if (r4.startsWith(r3) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String xj(com.ss.android.socialbase.downloader.f.xj r9) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.f.xj(com.ss.android.socialbase.downloader.f.xj):java.lang.String");
    }

    public void xj(DownloadInfo downloadInfo, boolean z) {
        if (this.xj.hf == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status != -1 && status != -4) {
            if (d.xj(this.xj.hf) || (z && com.ss.android.downloadlib.u.w.xj().w() && (status == -2 || status == -3))) {
                com.ss.android.downloadlib.u.xj.xj().xj(this.hf, 2);
            }
        } else {
            com.ss.android.downloadlib.u.xj.xj().xj(this.hf, 2);
        }
        switch (status) {
            case -4:
            case -1:
                xj();
                com.ss.android.downloadlib.addownload.hf.y xj2 = com.ss.android.downloadlib.addownload.hf.y.xj();
                com.ss.android.downloadlib.addownload.hf.kd kdVar = this.xj;
                xj2.xj(new com.ss.android.downloadad.api.xj.hf(kdVar.hf, kdVar.w, kdVar.u, downloadInfo.getId()));
                break;
            case -3:
                if (com.ss.android.downloadlib.c.g.xj(this.xj.hf)) {
                    com.ss.android.downloadlib.kd.w.xj().hf("SUCCESSED isInstalledApp");
                    break;
                } else {
                    com.ss.android.downloadlib.u.xj.xj().xj(this.hf, 5, downloadInfo);
                    if (z && com.ss.android.downloadlib.u.w.xj().hf() && !com.ss.android.downloadlib.u.w.xj().hf(this.hf, this.xj.hf.getLogExtra())) {
                        com.ss.android.downloadlib.u.xj.xj().xj(this.hf, 2);
                        break;
                    }
                }
                break;
            case -2:
                com.ss.android.downloadlib.u.xj.xj().xj(this.hf, 4, downloadInfo);
                if (z && com.ss.android.downloadlib.u.w.xj().hf() && !com.ss.android.downloadlib.u.w.xj().hf(this.hf, this.xj.hf.getLogExtra())) {
                    com.ss.android.downloadlib.u.xj.xj().xj(this.hf, 2);
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                com.ss.android.downloadlib.u.xj.xj().xj(this.hf, 3, downloadInfo);
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(com.ss.android.socialbase.downloader.model.DownloadInfo r7, com.ss.android.download.api.model.DownloadShortInfo r8, java.util.List<com.ss.android.download.api.download.DownloadStatusChangeListener> r9, boolean r10) {
        /*
            r6 = this;
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L8
            goto Lae
        L8:
            if (r7 == 0) goto L9a
            if (r8 != 0) goto Le
            goto L9a
        Le:
            r0 = 0
            long r1 = r7.getTotalBytes()     // Catch: java.lang.Exception -> L28
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L2c
            long r1 = r7.getCurBytes()     // Catch: java.lang.Exception -> L28
            r3 = 100
            long r1 = r1 * r3
            long r3 = r7.getTotalBytes()     // Catch: java.lang.Exception -> L28
            long r1 = r1 / r3
            int r2 = (int) r1
            goto L2d
        L28:
            r1 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r1)
        L2c:
            r2 = 0
        L2d:
            if (r2 >= 0) goto L30
            goto L31
        L30:
            r0 = r2
        L31:
            r8.updateFromNewDownloadInfo(r7)
            com.ss.android.downloadlib.addownload.tf.xj(r8)
            java.util.Iterator r9 = r9.iterator()
        L3b:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto Lae
            java.lang.Object r1 = r9.next()
            com.ss.android.download.api.download.DownloadStatusChangeListener r1 = (com.ss.android.download.api.download.DownloadStatusChangeListener) r1
            int r2 = r7.getStatus()
            switch(r2) {
                case -4: goto L85;
                case -3: goto L7b;
                case -2: goto L6f;
                case -1: goto L6b;
                case 0: goto L85;
                case 1: goto L5f;
                case 2: goto L5f;
                case 3: goto L5f;
                case 4: goto L5f;
                case 5: goto L5f;
                case 6: goto L4e;
                case 7: goto L5f;
                case 8: goto L5f;
                case 9: goto L4e;
                case 10: goto L4e;
                case 11: goto L4f;
                default: goto L4e;
            }
        L4e:
            goto L3b
        L4f:
            boolean r2 = r1 instanceof com.ss.android.download.api.download.xj
            if (r2 != 0) goto L3b
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.tf.xj(r2, r0)
            r1.onDownloadActive(r8, r2)
            goto L3b
        L5f:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.tf.xj(r2, r0)
            r1.onDownloadActive(r8, r2)
            goto L3b
        L6b:
            r1.onDownloadFailed(r8)
            goto L3b
        L6f:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.tf.xj(r2, r0)
            r1.onDownloadPaused(r8, r2)
            goto L3b
        L7b:
            if (r10 == 0) goto L81
            r1.onInstalled(r8)
            goto L3b
        L81:
            r1.onDownloadFinished(r8)
            goto L3b
        L85:
            com.ss.android.downloadlib.addownload.hf.kd r2 = r6.xj
            com.ss.android.download.api.download.DownloadModel r2 = r2.hf
            boolean r2 = com.ss.android.downloadlib.c.g.xj(r2)
            if (r2 == 0) goto L96
            r2 = -3
            r8.status = r2
            r1.onInstalled(r8)
            goto L3b
        L96:
            r1.onIdle()
            goto L3b
        L9a:
            java.util.Iterator r7 = r9.iterator()
        L9e:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Lae
            java.lang.Object r8 = r7.next()
            com.ss.android.download.api.download.DownloadStatusChangeListener r8 = (com.ss.android.download.api.download.DownloadStatusChangeListener) r8
            r8.onIdle()
            goto L9e
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.f.xj(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.download.api.model.DownloadShortInfo, java.util.List, boolean):void");
    }

    public static List<DownloadStatusChangeListener> xj(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof DownloadStatusChangeListener) {
                    arrayList.add((DownloadStatusChangeListener) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private com.ss.android.socialbase.downloader.model.w xj(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new com.ss.android.socialbase.downloader.model.w("clickid", new JSONObject(str).optString("clickid"));
        } catch (JSONException e) {
            pl.jk().xj(e, "parseLogExtra Error");
            return null;
        }
    }
}
