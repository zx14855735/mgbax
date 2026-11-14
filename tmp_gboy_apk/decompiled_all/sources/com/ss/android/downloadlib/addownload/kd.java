package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.config.pz;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.download.w;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.f;
import com.ss.android.downloadlib.c.am;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class kd implements c, am.xj {
    private static final String xj = "kd";
    private long am;
    private DownloadShortInfo c;
    private w d;
    private DownloadController e;
    private DownloadInfo f;
    private String g;
    private final com.ss.android.downloadlib.c.am hf;
    private final boolean jk;
    private WeakReference<Context> kd;
    private boolean p;

    /* renamed from: pl, reason: collision with root package name */
    private long f13833pl;
    private SoftReference<IDownloadButtonClickListener> pz;
    private DownloadModel qt;
    private final IDownloadListener tf;
    private u u;
    private boolean v;
    private f w;
    private final Map<Integer, Object> y;
    private SoftReference<OnItemClickListener> yo;
    private DownloadEventConfig zg;

    public interface hf {
        void xj(long j);
    }

    public interface xj {
        void xj();
    }

    public kd() {
        com.ss.android.downloadlib.c.am amVar = new com.ss.android.downloadlib.c.am(Looper.getMainLooper(), this);
        this.hf = amVar;
        this.y = new ConcurrentHashMap();
        this.tf = new f.xj(amVar);
        this.am = -1L;
        this.qt = null;
        this.zg = null;
        this.e = null;
        this.w = new f(this);
        this.u = new u(amVar);
        this.jk = com.ss.android.socialbase.downloader.f.xj.w().xj("ttdownloader_callback_twice");
    }

    private void am() {
        String str = xj;
        com.ss.android.downloadlib.c.p.xj(str, "pICD", null);
        if (this.w.u(this.f)) {
            com.ss.android.downloadlib.c.p.xj(str, "pICD BC", null);
            y(false);
        } else {
            com.ss.android.downloadlib.c.p.xj(str, "pICD IC", null);
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadShortInfo e() {
        if (this.c == null) {
            this.c = new DownloadShortInfo();
        }
        return this.c;
    }

    private DownloadController g() {
        if (this.e == null) {
            this.e = new com.ss.android.download.api.download.hf();
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.kd;
        return (weakReference == null || weakReference.get() == null) ? pl.getContext() : this.kd.get();
    }

    private void p() {
        SoftReference<OnItemClickListener> softReference = this.yo;
        if (softReference != null && softReference.get() != null) {
            this.yo.get().onItemClick(this.qt, pl(), g());
            this.yo = null;
        } else {
            pl.hf();
            getContext();
            g();
            pl();
        }
    }

    private DownloadEventConfig pl() {
        DownloadEventConfig downloadEventConfig = this.zg;
        return downloadEventConfig == null ? new w.xj().xj() : downloadEventConfig;
    }

    private boolean qt() {
        if (!com.ss.android.socialbase.downloader.f.xj.w().xj("fix_click_start")) {
            DownloadInfo downloadInfo = this.f;
            if (downloadInfo == null) {
                return true;
            }
            return !(downloadInfo.getStatus() == -3 || Downloader.getInstance(pl.getContext()).canResume(this.f.getId())) || this.f.getStatus() == 0;
        }
        DownloadInfo downloadInfo2 = this.f;
        if (downloadInfo2 == null) {
            return true;
        }
        if ((downloadInfo2.getStatus() == -3 && this.f.getCurBytes() <= 0) || this.f.getStatus() == 0 || this.f.getStatus() == -4) {
            return true;
        }
        return com.ss.android.socialbase.downloader.tf.y.xj(this.f.getStatus(), this.f.getSavePath(), this.f.getName());
    }

    private void zg() {
        w wVar = this.d;
        if (wVar != null && wVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.d.cancel(true);
        }
        this.d = new w();
        if (TextUtils.isEmpty(this.g)) {
            com.ss.android.downloadlib.c.hf.xj(this.d, this.qt.getDownloadUrl(), this.qt.getPackageName());
        } else {
            com.ss.android.downloadlib.c.hf.xj(this.d, this.qt.getDownloadUrl(), this.qt.getPackageName(), this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final boolean z) {
        this.u.xj(new com.ss.android.downloadlib.addownload.hf.kd(this.am, this.qt, pl(), g()));
        this.u.xj(0, 0L, 0L, new xj() { // from class: com.ss.android.downloadlib.addownload.kd.9
            @Override // com.ss.android.downloadlib.addownload.kd.xj
            public void xj() {
                if (kd.this.u.xj()) {
                    return;
                }
                kd.this.f(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z) {
        Iterator<DownloadStatusChangeListener> it = f.xj(this.y).iterator();
        while (it.hasNext()) {
            it.next().onDownloadStart(this.qt, g());
        }
        int xj2 = this.w.xj(pl.getContext(), this.tf);
        String str = xj;
        com.ss.android.downloadlib.c.p.xj(str, "beginDown id:" + xj2, null);
        if (xj2 == 0) {
            DownloadInfo xj3 = new DownloadInfo.xj(this.qt.getDownloadUrl()).xj();
            xj3.setStatus(-1);
            xj(xj3);
            com.ss.android.downloadlib.u.xj.xj().xj(this.am, new BaseException(2, "start download failed, id=0"));
            com.ss.android.downloadlib.kd.w.xj().hf("beginDown");
        } else if (this.f != null && !com.ss.android.socialbase.downloader.f.xj.w().xj("fix_click_start")) {
            this.w.xj(this.f, false);
        } else if (z) {
            this.w.xj();
        }
        if (this.w.xj(w())) {
            com.ss.android.downloadlib.c.p.xj(str, "beginDown IC id:" + xj2, null);
            p();
        }
    }

    public boolean d() {
        SoftReference<IDownloadButtonClickListener> softReference = this.pz;
        if (softReference == null) {
            return false;
        }
        return d.xj(this.qt, softReference.get());
    }

    public boolean kd() {
        return pl.d().optInt("quick_app_enable_switch", 0) == 0 && this.qt.getQuickAppModel() != null && !TextUtils.isEmpty(this.qt.getQuickAppModel().xj()) && com.ss.android.downloadlib.addownload.w.xj(this.f) && com.ss.android.downloadlib.c.g.xj(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.qt.getQuickAppModel().xj())));
    }

    @Override // com.ss.android.downloadlib.addownload.c
    public long u() {
        return this.f13833pl;
    }

    public boolean w() {
        DownloadInfo downloadInfo = this.f;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    public void y() {
        this.hf.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.kd.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator<DownloadStatusChangeListener> it = f.xj((Map<Integer, Object>) kd.this.y).iterator();
                while (it.hasNext()) {
                    it.next().onInstalled(kd.this.e());
                }
            }
        });
    }

    private boolean w(int i) {
        if (!kd()) {
            return false;
        }
        String xj2 = this.qt.getQuickAppModel().xj();
        int i2 = i != 1 ? i != 2 ? -1 : 4 : 5;
        DownloadModel downloadModel = this.qt;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        boolean w2 = com.ss.android.downloadlib.c.d.w(pl.getContext(), xj2);
        if (w2) {
            com.ss.android.downloadlib.u.xj.xj().xj(this.am, i);
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.obj = Long.valueOf(this.qt.getId());
            com.ss.android.downloadlib.addownload.w.xj().xj(this, i2, this.qt);
            return w2;
        }
        com.ss.android.downloadlib.u.xj.xj().xj(this.am, false, 0);
        return w2;
    }

    private void y(final boolean z) {
        DownloadModel downloadModel;
        DownloadController downloadController;
        DownloadController downloadController2;
        String str = xj;
        com.ss.android.downloadlib.c.p.xj(str, "pBCD", null);
        if (qt()) {
            com.ss.android.downloadlib.addownload.hf.kd kd = com.ss.android.downloadlib.addownload.hf.y.xj().kd(this.am);
            if (this.v) {
                if (d()) {
                    if (u(false) && (downloadController2 = kd.u) != null && downloadController2.isAutoDownloadOnCardShow()) {
                        xj(z, true);
                        return;
                    }
                    return;
                }
                xj(z, true);
                return;
            }
            if (this.qt.isAd() && (downloadController = kd.u) != null && downloadController.enableShowComplianceDialog() && kd.hf != null && com.ss.android.downloadlib.addownload.compliance.hf.xj().xj(kd.hf) && com.ss.android.downloadlib.addownload.compliance.hf.xj().xj(kd)) {
                return;
            }
            xj(z, true);
            return;
        }
        com.ss.android.downloadlib.c.p.xj(str, "pBCD continue download, status:" + this.f.getStatus(), null);
        DownloadInfo downloadInfo = this.f;
        if (downloadInfo != null && (downloadModel = this.qt) != null) {
            downloadInfo.setOnlyWifi(downloadModel.isNeedWifi());
        }
        final int status = this.f.getStatus();
        final int id = this.f.getId();
        final com.ss.android.downloadad.api.xj.hf xj2 = com.ss.android.downloadlib.addownload.hf.y.xj().xj(this.f);
        if (status != -2 && status != -1) {
            if (qt.xj(status)) {
                if (this.qt.enablePause()) {
                    this.u.xj(true);
                    com.ss.android.downloadlib.w.f.xj().hf(com.ss.android.downloadlib.addownload.hf.y.xj().u(this.am));
                    if (com.ss.android.downloadlib.c.kd.xj((com.ss.android.downloadad.api.xj.xj) xj2).xj("cancel_pause_optimise_switch", 0) == 1) {
                        com.ss.android.downloadlib.addownload.u.u.xj().xj(xj2, status, new com.ss.android.downloadlib.addownload.u.f() { // from class: com.ss.android.downloadlib.addownload.kd.6
                            @Override // com.ss.android.downloadlib.addownload.u.f
                            public void xj(com.ss.android.downloadad.api.xj.hf hfVar) {
                                if (kd.this.f == null && com.ss.android.socialbase.downloader.f.xj.w().xj("fix_handle_pause")) {
                                    kd.this.f = Downloader.getInstance(pl.getContext()).getDownloadInfo(id);
                                }
                                kd.this.w.xj(kd.this.f, z);
                                if (kd.this.f != null && com.ss.android.socialbase.downloader.tf.y.hf(pl.getContext()) && kd.this.f.isPauseReserveOnWifi()) {
                                    kd.this.f.stopPauseReserveOnWifi();
                                    com.ss.android.downloadlib.u.xj.xj().xj("cancel_pause_reserve_wifi_cancel_on_wifi", xj2);
                                } else {
                                    p.xj().xj(kd.this.qt, kd.this.f);
                                    hfVar.p(System.currentTimeMillis());
                                    kd kdVar = kd.this;
                                    kdVar.xj(id, status, kdVar.f);
                                }
                            }
                        }, new com.ss.android.downloadlib.addownload.xj.w() { // from class: com.ss.android.downloadlib.addownload.kd.5
                            @Override // com.ss.android.downloadlib.addownload.xj.w
                            public void delete() {
                                kd.this.xj(true);
                            }
                        });
                        return;
                    } else {
                        com.ss.android.downloadlib.addownload.u.p.xj().xj(xj2, status, new com.ss.android.downloadlib.addownload.u.f() { // from class: com.ss.android.downloadlib.addownload.kd.7
                            @Override // com.ss.android.downloadlib.addownload.u.f
                            public void xj(com.ss.android.downloadad.api.xj.hf hfVar) {
                                if (kd.this.f == null && com.ss.android.socialbase.downloader.f.xj.w().xj("fix_handle_pause")) {
                                    kd.this.f = Downloader.getInstance(pl.getContext()).getDownloadInfo(id);
                                }
                                kd.this.w.xj(kd.this.f, z);
                                if (kd.this.f != null && com.ss.android.socialbase.downloader.tf.y.hf(pl.getContext()) && kd.this.f.isPauseReserveOnWifi()) {
                                    kd.this.f.stopPauseReserveOnWifi();
                                    com.ss.android.downloadlib.u.xj.xj().hf("pause_reserve_wifi_cancel_on_wifi", xj2);
                                } else {
                                    p.xj().xj(kd.this.qt, kd.this.f);
                                    hfVar.p(System.currentTimeMillis());
                                    kd kdVar = kd.this;
                                    kdVar.xj(id, status, kdVar.f);
                                }
                            }
                        });
                        return;
                    }
                }
                return;
            }
            this.w.xj(this.f, z);
            xj(id, status, this.f);
            return;
        }
        this.w.xj(this.f, z);
        if (xj2 != null) {
            xj2.f(System.currentTimeMillis());
            xj2.d(this.f.getCurBytes());
        }
        this.f.setDownloadFromReserveWifi(false);
        this.u.xj(new com.ss.android.downloadlib.addownload.hf.kd(this.am, this.qt, pl(), g()));
        this.u.xj(id, this.f.getCurBytes(), this.f.getTotalBytes(), new xj() { // from class: com.ss.android.downloadlib.addownload.kd.3
            @Override // com.ss.android.downloadlib.addownload.kd.xj
            public void xj() {
                if (kd.this.u.xj()) {
                    return;
                }
                kd kdVar = kd.this;
                kdVar.xj(id, status, kdVar.f);
            }
        });
        if (status == -2 && com.ss.android.downloadlib.c.kd.xj((com.ss.android.downloadad.api.xj.xj) xj2).xj("show_pause_continue_toast", 0) == 1) {
            com.ss.android.downloadlib.f.xj().hf().postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.kd.4
                @Override // java.lang.Runnable
                public void run() {
                    pl.w().xj(13, pl.getContext(), kd.this.qt, "已恢复下载", null, 0);
                }
            }, 500L);
        }
    }

    public boolean u(boolean z) {
        SoftReference<IDownloadButtonClickListener> softReference = this.pz;
        if (softReference != null && softReference.get() != null) {
            try {
                if (!z) {
                    this.pz.get().handleComplianceDialog(true);
                } else {
                    this.pz.get().handleMarketFailedComplianceDialog();
                }
                this.pz = null;
                return true;
            } catch (Exception unused) {
                com.ss.android.downloadlib.kd.w.xj().hf("mDownloadButtonClickListener has recycled");
                return false;
            }
        }
        com.ss.android.downloadlib.kd.w.xj().hf("mDownloadButtonClickListener has recycled");
        return false;
    }

    public void c() {
        if (this.y.size() == 0) {
            return;
        }
        Iterator<DownloadStatusChangeListener> it = f.xj(this.y).iterator();
        while (it.hasNext()) {
            it.next().onIdle();
        }
        DownloadInfo downloadInfo = this.f;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.c
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public kd hf(Context context) {
        if (context != null) {
            this.kd = new WeakReference<>(context);
        }
        pl.hf(context);
        return this;
    }

    private void kd(boolean z) {
        if (com.ss.android.downloadlib.c.kd.hf(this.qt).hf("notification_opt_2") == 1 && this.f != null) {
            com.ss.android.socialbase.downloader.notification.hf.xj().y(this.f.getId());
        }
        y(z);
    }

    @Override // com.ss.android.downloadlib.addownload.c
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public kd hf(int i, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (pl.d().optInt("back_use_softref_listener") == 1) {
                this.y.put(Integer.valueOf(i), downloadStatusChangeListener);
                return this;
            }
            if (pl.d().optInt("use_weakref_listener") == 1) {
                this.y.put(Integer.valueOf(i), new WeakReference(downloadStatusChangeListener));
                return this;
            }
            this.y.put(Integer.valueOf(i), new SoftReference(downloadStatusChangeListener));
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.c
    public boolean hf() {
        return this.p;
    }

    @Override // com.ss.android.downloadlib.addownload.c
    public void hf(final int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.w.xj(this.am);
        if (!com.ss.android.downloadlib.addownload.hf.y.xj().kd(this.am).et()) {
            com.ss.android.downloadlib.kd.w.xj().xj("handleDownload ModelBox !isStrictValid");
        }
        if (this.w.xj(i, this.qt)) {
            com.ss.android.downloadlib.addownload.compliance.y.xj().xj(this.w.xj, new com.ss.android.downloadlib.addownload.compliance.f() { // from class: com.ss.android.downloadlib.addownload.kd.1
                @Override // com.ss.android.downloadlib.addownload.compliance.f
                public void xj(String str) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("download_miui_new_market", 1);
                        jSONObject.putOpt("download_miui_market_deeplink", str);
                        if (com.ss.android.downloadlib.c.f.xj(kd.this.getContext(), kd.this.w.xj, str, jSONObject, true, i)) {
                            jSONObject.putOpt("download_miui_jump_market_success", 1);
                            com.ss.android.downloadlib.addownload.compliance.y.xj().xj(0, kd.this.w.xj, jSONObject);
                            return;
                        }
                        jSONObject.putOpt("download_miui_jump_market_success", 0);
                        com.ss.android.downloadlib.addownload.compliance.y.xj().xj(1, kd.this.w.xj, jSONObject);
                        int i2 = i;
                        if (i2 == 1) {
                            com.ss.android.socialbase.downloader.w.xj.xj(kd.xj, "miui new rollback fail: handleDownload id:" + kd.this.am + ",tryPerformButtonClick:", null);
                            kd.this.w(true);
                            return;
                        }
                        if (i2 != 2) {
                            return;
                        }
                        com.ss.android.socialbase.downloader.w.xj.xj(kd.xj, "miui new rollback fail: handleDownload id:" + kd.this.am + ",tryPerformButtonClick:", null);
                        kd.this.hf(true);
                    } catch (Exception e) {
                        com.ss.android.downloadlib.kd.w.xj().xj(e, "generate miui new market param error");
                    }
                }

                @Override // com.ss.android.downloadlib.addownload.compliance.f
                public void xj() {
                    int i2 = i;
                    if (i2 == 1) {
                        com.ss.android.socialbase.downloader.w.xj.xj(kd.xj, "miui new get miui deeplink fail: handleDownload id:" + kd.this.am + ",tryPerformButtonClick:", null);
                        kd.this.w(true);
                        return;
                    }
                    if (i2 != 2) {
                        return;
                    }
                    com.ss.android.socialbase.downloader.w.xj.xj(kd.xj, "miui new get miui deeplink fail: handleDownload id:" + kd.this.am + ",tryPerformButtonClick:", null);
                    kd.this.hf(true);
                }
            });
            return;
        }
        if (this.w.xj(getContext(), i, this.v)) {
            return;
        }
        boolean w2 = w(i);
        if (i == 1) {
            if (w2) {
                return;
            }
            com.ss.android.downloadlib.c.p.xj(xj, "handleDownload id:" + this.am + ",pIC:", null);
            w(true);
            return;
        }
        if (i == 2 && !w2) {
            com.ss.android.downloadlib.c.p.xj(xj, "handleDownload id:" + this.am + ",pBC:", null);
            hf(true);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.c
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public kd hf(DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    com.ss.android.downloadlib.kd.w.xj().xj("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                com.ss.android.downloadlib.kd.w.xj().xj(false, "setDownloadModel id=0");
                if (com.ss.android.socialbase.downloader.f.xj.w().xj("fix_model_id")) {
                    ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadModel);
            this.am = downloadModel.getId();
            this.qt = downloadModel;
            if (d.xj(downloadModel)) {
                ((AdDownloadModel) downloadModel).setExtraValue(3L);
                com.ss.android.downloadad.api.xj.hf u = com.ss.android.downloadlib.addownload.hf.y.xj().u(this.am);
                if (u != null && u.pl() != 3) {
                    u.kd(3L);
                    com.ss.android.downloadlib.addownload.hf.d.xj().xj(u);
                }
            }
        }
        return this;
    }

    public class w extends com.bytedance.sdk.component.tf.u.hf<String, Void, DownloadInfo> {
        private w() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo downloadInfo = null;
            if (strArr != null && (strArr.length <= 0 || !TextUtils.isEmpty(strArr[0]))) {
                String str = (strArr.length < 3 || TextUtils.isEmpty(strArr[2])) ? "" : strArr[2];
                String str2 = strArr[0];
                if (kd.this.qt != null && !TextUtils.isEmpty(kd.this.qt.getFilePath())) {
                    downloadInfo = !TextUtils.isEmpty(str) ? Downloader.getInstance(pl.getContext()).getDownloadInfo(Downloader.getInstance(pl.getContext()).getDownloadId(str, kd.this.qt.getFilePath())) : Downloader.getInstance(pl.getContext()).getDownloadInfo(str2, kd.this.qt.getFilePath());
                }
                if (downloadInfo == null) {
                    return !TextUtils.isEmpty(str) ? com.ss.android.socialbase.appdownloader.u.p().xj(pl.getContext(), str) : com.ss.android.socialbase.appdownloader.u.p().xj(pl.getContext(), str2);
                }
            }
            return downloadInfo;
        }

        @Override // android.os.AsyncTask
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (isCancelled() || kd.this.qt == null) {
                return;
            }
            try {
                com.ss.android.downloadlib.addownload.hf.w xj = com.ss.android.downloadlib.c.g.xj(kd.this.qt.getPackageName(), kd.this.qt.getVersionCode(), kd.this.qt.getVersionName());
                com.ss.android.downloadlib.addownload.hf.f.xj().xj(kd.this.qt.getVersionCode(), xj.hf(), com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadInfo));
                boolean xj2 = xj.xj();
                if (downloadInfo == null || downloadInfo.getId() == 0 || (!xj2 && Downloader.getInstance(pl.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                    if (downloadInfo != null && Downloader.getInstance(pl.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                        com.ss.android.socialbase.downloader.notification.hf.xj().y(downloadInfo.getId());
                        kd.this.f = null;
                    }
                    if (kd.this.f != null) {
                        Downloader.getInstance(pl.getContext()).removeTaskMainListener(kd.this.f.getId());
                        if (kd.this.jk) {
                            Downloader.getInstance(kd.this.getContext()).setMainThreadListener(kd.this.f.getId(), kd.this.tf, false);
                        } else {
                            Downloader.getInstance(kd.this.getContext()).setMainThreadListener(kd.this.f.getId(), kd.this.tf);
                        }
                    }
                    if (!xj2) {
                        Iterator<DownloadStatusChangeListener> it = f.xj((Map<Integer, Object>) kd.this.y).iterator();
                        while (it.hasNext()) {
                            it.next().onIdle();
                        }
                        kd.this.f = null;
                    } else {
                        kd kdVar = kd.this;
                        kdVar.f = new DownloadInfo.xj(kdVar.qt.getDownloadUrl()).xj();
                        kd.this.f.setStatus(-3);
                        kd.this.w.xj(kd.this.f, kd.this.e(), f.xj((Map<Integer, Object>) kd.this.y), xj2);
                    }
                    kd.this.w.w(kd.this.f);
                }
                Downloader.getInstance(pl.getContext()).removeTaskMainListener(downloadInfo.getId());
                if (kd.this.f == null || kd.this.f.getStatus() != -4) {
                    kd.this.f = downloadInfo;
                    if (kd.this.jk) {
                        Downloader.getInstance(pl.getContext()).setMainThreadListener(kd.this.f.getId(), kd.this.tf, false);
                    } else {
                        Downloader.getInstance(pl.getContext()).setMainThreadListener(kd.this.f.getId(), kd.this.tf);
                    }
                } else {
                    kd.this.f = null;
                }
                kd.this.w.xj(kd.this.f, kd.this.e(), f.xj((Map<Integer, Object>) kd.this.y), xj2);
                kd.this.w.w(kd.this.f);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
    }

    public void w(boolean z) {
        if (z) {
            com.ss.android.downloadlib.u.xj.xj().xj(this.am, 1);
        }
        am();
    }

    @Override // com.ss.android.downloadlib.addownload.c
    public void f() {
        com.ss.android.downloadlib.addownload.hf.y.xj().y(this.am);
    }

    public void hf(boolean z) {
        kd(z);
    }

    @Override // com.ss.android.downloadlib.addownload.c
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public kd hf(DownloadController downloadController) {
        JSONObject extra;
        this.e = downloadController;
        if (com.ss.android.downloadlib.c.kd.hf(this.qt).hf("force_auto_open") == 1) {
            g().setLinkMode(1);
        }
        if (com.ss.android.socialbase.downloader.f.xj.w().xj("fix_show_dialog") && (extra = this.qt.getExtra()) != null && extra.optInt("subprocess") > 0) {
            g().setEnableNewActivity(false);
        }
        com.ss.android.downloadlib.addownload.hf.y.xj().xj(this.am, g());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.c
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public kd hf(DownloadEventConfig downloadEventConfig) {
        this.zg = downloadEventConfig;
        this.v = pl().getDownloadScene() == 0;
        com.ss.android.downloadlib.addownload.hf.y.xj().xj(this.am, pl());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.c
    public c xj(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.yo = null;
            return this;
        }
        this.yo = new SoftReference<>(onItemClickListener);
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.c
    public void xj() {
        this.p = true;
        com.ss.android.downloadlib.addownload.hf.y.xj().xj(this.am, pl());
        com.ss.android.downloadlib.addownload.hf.y.xj().xj(this.am, g());
        this.w.xj(this.am);
        zg();
        if (pl.d().optInt("enable_empty_listener", 1) == 1 && this.y.get(Integer.MIN_VALUE) == null) {
            hf(Integer.MIN_VALUE, new com.ss.android.download.api.config.xj());
        }
    }

    @Override // com.ss.android.downloadlib.addownload.c
    public boolean xj(int i) {
        if (i == 0) {
            this.y.clear();
        } else {
            this.y.remove(Integer.valueOf(i));
        }
        if (this.y.isEmpty()) {
            this.p = false;
            this.f13833pl = System.currentTimeMillis();
            if (this.f != null) {
                Downloader.getInstance(pl.getContext()).removeTaskMainListener(this.f.getId());
            }
            w wVar = this.d;
            if (wVar != null && wVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.d.cancel(true);
            }
            this.w.xj(this.f);
            String str = xj;
            StringBuilder sb = new StringBuilder("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.f;
            sb.append(downloadInfo == null ? "" : downloadInfo.getUrl());
            com.ss.android.downloadlib.c.p.xj(str, sb.toString(), null);
            this.hf.removeCallbacksAndMessages(null);
            this.c = null;
            this.f = null;
            return true;
        }
        if (this.y.size() == 1 && this.y.containsKey(Integer.MIN_VALUE)) {
            this.w.hf(this.f);
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.addownload.c
    public void xj(boolean z) {
        if (this.f != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.w.kd w2 = com.ss.android.socialbase.appdownloader.u.p().w();
                if (w2 != null) {
                    w2.xj(this.f);
                }
                Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.w.tj()).cancel(this.f.getId(), true);
                return;
            }
            Intent intent = new Intent(pl.getContext(), (Class<?>) DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.f.getId());
            pl.getContext().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.c
    public c xj(long j) {
        if (j != 0) {
            DownloadModel xj2 = com.ss.android.downloadlib.addownload.hf.y.xj().xj(j);
            if (xj2 != null) {
                this.qt = xj2;
                this.am = j;
                this.w.xj(j);
            }
            return this;
        }
        com.ss.android.downloadlib.kd.w.xj().xj(false, "setModelId");
        return this;
    }

    @Override // com.ss.android.downloadlib.c.am.xj
    public void xj(Message message) {
        if (message != null && this.p && message.what == 3) {
            this.f = (DownloadInfo) message.obj;
            this.w.xj(message, e(), this.y);
        }
    }

    public void xj(boolean z, final boolean z2) {
        if (z) {
            com.ss.android.downloadlib.u.xj.xj().xj(this.am, 2);
        }
        if (!com.ss.android.downloadlib.c.g.xj()) {
            if (!com.ss.android.downloadlib.c.tf.hf(com.kuaishou.weapon.p0.g.j) && !g().enableNewActivity()) {
                this.qt.setFilePath(this.w.hf());
            }
        } else if (!com.ss.android.downloadlib.c.tf.hf("android.permission.READ_MEDIA_IMAGES") && !com.ss.android.downloadlib.c.tf.hf("android.permission.READ_MEDIA_AUDIO") && !com.ss.android.downloadlib.c.tf.hf("android.permission.READ_MEDIA_VIDEO") && !g().enableNewActivity()) {
            this.qt.setFilePath(this.w.hf());
        }
        if (com.ss.android.downloadlib.c.kd.w(this.qt) == 0) {
            com.ss.android.downloadlib.c.p.xj(xj, "pBCD not start", null);
            this.w.xj(new pz() { // from class: com.ss.android.downloadlib.addownload.kd.8
                @Override // com.ss.android.download.api.config.pz
                public void xj() {
                    com.ss.android.downloadlib.c.p.xj(kd.xj, "pBCD start download", null);
                    kd.this.c(z2);
                }

                @Override // com.ss.android.download.api.config.pz
                public void xj(String str) {
                    com.ss.android.downloadlib.c.p.xj(kd.xj, "pBCD onDenied", null);
                }
            });
        } else {
            c(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, int i2, DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.f.xj.w().xj("fix_click_start")) {
            if (i2 != -3 && !com.ss.android.socialbase.downloader.downloader.u.xj().kd(i)) {
                xj(false, false);
                return;
            } else {
                com.ss.android.socialbase.appdownloader.u.p().xj(pl.getContext(), i, i2);
                return;
            }
        }
        com.ss.android.socialbase.appdownloader.u.p().xj(pl.getContext(), i, i2);
    }

    private void xj(DownloadInfo downloadInfo) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = downloadInfo;
        this.hf.sendMessage(obtain);
    }

    @Override // com.ss.android.downloadlib.addownload.c
    public c xj(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.g = str;
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.c
    public c xj(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.pz = null;
            return this;
        }
        this.pz = new SoftReference<>(iDownloadButtonClickListener);
        return this;
    }
}
