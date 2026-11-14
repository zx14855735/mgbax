package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.hf;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.downloadlib.c.g;
import com.ss.android.downloadlib.c.p;
import com.ss.android.downloadlib.kd.hf;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf implements com.ss.android.downloadad.api.hf {
    private static volatile hf hf = null;
    private static String xj = "hf";
    private tf w = tf.xj(pl.getContext());

    private hf() {
    }

    public static DownloadEventConfig w() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag("landing_h5_download_ad_button").setClickItemTag("landing_h5_download_ad_button").setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build();
    }

    public Dialog hf(Context context, String str, boolean z, final DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2, IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (xj(downloadModel.getId())) {
            if (z2) {
                xj(downloadModel.getId(), downloadEventConfig, downloadController);
            } else {
                hf(downloadModel.getId());
            }
            return null;
        }
        if (context == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return null;
        }
        this.w.xj(context, i, downloadStatusChangeListener, downloadModel);
        final DownloadEventConfig downloadEventConfig2 = (DownloadEventConfig) g.xj(downloadEventConfig, w());
        final DownloadController downloadController2 = (DownloadController) g.xj(downloadController, hf());
        downloadEventConfig2.setDownloadScene(1);
        if ((downloadController2.enableShowComplianceDialog() && com.ss.android.downloadlib.addownload.compliance.hf.xj().xj(downloadModel)) ? true : (pl.d().optInt("disable_lp_dialog", 0) == 1) | z) {
            this.w.xj(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2, iDownloadButtonClickListener);
            return null;
        }
        p.xj(xj, "tryStartDownload show dialog appName:" + downloadModel.getDownloadUrl(), null);
        Dialog hf2 = pl.w().hf(new hf.xj(context).xj(downloadModel.getName()).hf("确认要下载此应用吗？").w("确认").u("取消").xj(new hf.InterfaceC0464hf() { // from class: com.ss.android.downloadlib.hf.2
            @Override // com.ss.android.download.api.model.hf.InterfaceC0464hf
            public void hf(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.u.xj.xj().xj("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.hf.InterfaceC0464hf
            public void w(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.u.xj.xj().xj("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
            }

            @Override // com.ss.android.download.api.model.hf.InterfaceC0464hf
            public void xj(DialogInterface dialogInterface) {
                hf.this.w.xj(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                com.ss.android.downloadlib.u.xj.xj().xj("landing_download_dialog_confirm", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }
        }).xj(0).xj());
        com.ss.android.downloadlib.u.xj.xj().xj("landing_download_dialog_show", downloadModel, downloadEventConfig2, downloadController2);
        return hf2;
    }

    public static hf xj() {
        if (hf == null) {
            synchronized (hf.class) {
                try {
                    if (hf == null) {
                        hf = new hf();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    @Override // com.ss.android.downloadad.api.hf
    public Dialog xj(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        return xj(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false);
    }

    @Override // com.ss.android.downloadad.api.hf
    public Dialog xj(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return xj(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false, iDownloadButtonClickListener);
    }

    public Dialog xj(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2) {
        return xj(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2, null);
    }

    public Dialog xj(final Context context, final String str, final boolean z, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final DownloadStatusChangeListener downloadStatusChangeListener, final int i, final boolean z2, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return (Dialog) com.ss.android.downloadlib.kd.hf.xj(new hf.xj<Dialog>() { // from class: com.ss.android.downloadlib.hf.1
            @Override // com.ss.android.downloadlib.kd.hf.xj
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Dialog hf() {
                return hf.this.hf(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2, iDownloadButtonClickListener);
            }
        });
    }

    @Override // com.ss.android.downloadad.api.hf
    public boolean xj(Context context, long j, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        com.ss.android.downloadad.api.xj.hf u = com.ss.android.downloadlib.addownload.hf.y.xj().u(j);
        if (u != null) {
            this.w.xj(context, i, downloadStatusChangeListener, u.gj());
            return true;
        }
        DownloadModel xj2 = com.ss.android.downloadlib.addownload.hf.y.xj().xj(j);
        if (xj2 == null) {
            return false;
        }
        this.w.xj(context, i, downloadStatusChangeListener, xj2);
        return true;
    }

    @Override // com.ss.android.downloadad.api.hf
    public boolean xj(long j, int i) {
        DownloadModel xj2 = com.ss.android.downloadlib.addownload.hf.y.xj().xj(j);
        if (xj2 == null) {
            return false;
        }
        this.w.xj(xj2.getDownloadUrl(), i);
        return true;
    }

    public void xj(long j, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadModel xj2 = com.ss.android.downloadlib.addownload.hf.y.xj().xj(j);
        com.ss.android.downloadad.api.xj.hf u = com.ss.android.downloadlib.addownload.hf.y.xj().u(j);
        if (xj2 == null && u != null) {
            xj2 = u.gj();
        }
        if (xj2 == null) {
            return;
        }
        if (downloadEventConfig != null && downloadController != null && !(downloadEventConfig instanceof com.ss.android.download.api.download.w) && !(downloadController instanceof com.ss.android.download.api.download.hf)) {
            downloadEventConfig.setDownloadScene(1);
            this.w.xj(xj2.getDownloadUrl(), j, 2, downloadEventConfig, downloadController);
        } else {
            hf(j);
        }
    }

    public void hf(long j) {
        DownloadModel xj2 = com.ss.android.downloadlib.addownload.hf.y.xj().xj(j);
        com.ss.android.downloadad.api.xj.hf u = com.ss.android.downloadlib.addownload.hf.y.xj().u(j);
        if (xj2 == null && u != null) {
            xj2 = u.gj();
        }
        if (xj2 == null) {
            return;
        }
        DownloadEventConfig hf2 = com.ss.android.downloadlib.addownload.hf.y.xj().hf(j);
        DownloadController w = com.ss.android.downloadlib.addownload.hf.y.xj().w(j);
        if (hf2 instanceof com.ss.android.download.api.download.w) {
            hf2 = null;
        }
        if (w instanceof com.ss.android.download.api.download.hf) {
            w = null;
        }
        if (u == null) {
            if (hf2 == null) {
                hf2 = w();
            }
            if (w == null) {
                w = hf();
            }
        } else {
            if (hf2 == null) {
                hf2 = new AdDownloadEventConfig.Builder().setClickButtonTag(u.tf()).setRefer(u.d()).setIsEnableV3Event(u.g()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
            }
            if (w == null) {
                w = u.xv();
            }
        }
        DownloadEventConfig downloadEventConfig = hf2;
        DownloadController downloadController = w;
        downloadEventConfig.setDownloadScene(1);
        this.w.xj(xj2.getDownloadUrl(), j, 2, downloadEventConfig, downloadController);
    }

    @Override // com.ss.android.downloadad.api.hf
    public boolean xj(long j) {
        return (com.ss.android.downloadlib.addownload.hf.y.xj().xj(j) == null && com.ss.android.downloadlib.addownload.hf.y.xj().u(j) == null) ? false : true;
    }

    @Override // com.ss.android.downloadad.api.hf
    public boolean xj(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return xj(context, uri, downloadModel, downloadEventConfig, downloadController, null);
    }

    @Override // com.ss.android.downloadad.api.hf
    public boolean xj(final Context context, final Uri uri, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ((Boolean) com.ss.android.downloadlib.kd.hf.xj(new hf.xj<Boolean>() { // from class: com.ss.android.downloadlib.hf.3
            @Override // com.ss.android.downloadlib.kd.hf.xj
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean hf() {
                return Boolean.valueOf(hf.this.hf(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener));
            }
        })).booleanValue();
    }

    public static DownloadController xj(boolean z) {
        AdDownloadController.Builder shouldUseNewWebView = new AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
        if (z) {
            shouldUseNewWebView.setDownloadMode(2);
        } else {
            shouldUseNewWebView.setDownloadMode(0);
        }
        return shouldUseNewWebView.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hf(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        DownloadController downloadController2 = downloadController;
        if (!com.ss.android.download.api.w.xj.xj(uri) || pl.d().optInt("disable_market") == 1) {
            return false;
        }
        if (context == null) {
            context = pl.getContext();
        }
        String hf2 = com.ss.android.download.api.w.xj.hf(uri);
        if (downloadModel == null) {
            return com.ss.android.downloadlib.c.d.xj(context, hf2).getType() == 5;
        }
        if (!TextUtils.isEmpty(hf2) && (downloadModel instanceof AdDownloadModel)) {
            ((AdDownloadModel) downloadModel).setPackageName(hf2);
        }
        if (downloadController2 != null) {
            downloadController2.setDownloadMode(2);
        } else if ((downloadModel instanceof AdDownloadModel) && TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            ((AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
            downloadController2 = xj(true);
        } else if (downloadModel.getDownloadUrl().startsWith(BaseConstants.SCHEME_MARKET)) {
            downloadController2 = xj(true);
        } else {
            downloadController2 = hf();
        }
        com.ss.android.downloadlib.addownload.hf.kd kdVar = new com.ss.android.downloadlib.addownload.hf.kd(downloadModel.getId(), downloadModel, (DownloadEventConfig) g.xj(downloadEventConfig, w()), downloadController2);
        com.ss.android.downloadlib.addownload.hf.y.xj().xj(kdVar.hf);
        com.ss.android.downloadlib.addownload.hf.y.xj().xj(kdVar.xj, kdVar.w);
        com.ss.android.downloadlib.addownload.hf.y.xj().xj(kdVar.xj, kdVar.u);
        if (g.xj(downloadModel) && com.ss.android.socialbase.downloader.f.xj.w().hf("app_link_opt") == 1 && com.ss.android.downloadlib.hf.xj.xj(kdVar)) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        g.xj(jSONObject, "market_url", uri.toString());
        g.xj(jSONObject, "download_scene", (Object) 1);
        com.ss.android.downloadlib.u.xj.xj().hf("market_click_open", jSONObject, kdVar);
        com.ss.android.downloadlib.addownload.hf.c xj2 = com.ss.android.downloadlib.c.d.xj(context, kdVar, hf2);
        String xj3 = g.xj(xj2.hf(), PointCategory.OPEN_MARKET);
        if (xj2.getType() == 5) {
            com.ss.android.downloadlib.hf.xj.xj(xj3, jSONObject, kdVar, true);
            return true;
        }
        if (xj2.getType() != 6) {
            return true;
        }
        g.xj(jSONObject, "error_code", Integer.valueOf(xj2.xj()));
        com.ss.android.downloadlib.u.xj.xj().hf("market_open_failed", jSONObject, kdVar);
        if (com.ss.android.downloadlib.addownload.d.xj(downloadModel, iDownloadButtonClickListener)) {
            iDownloadButtonClickListener.handleMarketFailedComplianceDialog();
        }
        return false;
    }

    public static DownloadController hf() {
        return xj(false);
    }
}
