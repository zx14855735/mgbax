package com.ss.android.downloadlib.addownload.xj;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.ss.android.download.api.model.hf;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.hf.y;
import com.ss.android.downloadlib.c.g;
import com.ss.android.downloadlib.c.p;
import com.ss.android.downloadlib.tf;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj {
    private static xj hf = null;
    private static final String xj = "xj";
    private String kd;
    private boolean u = false;
    private CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.hf.xj> w;
    private hf y;

    /* renamed from: com.ss.android.downloadlib.addownload.xj.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0467xj {
        void xj();
    }

    private xj() {
        hf hfVar = new hf();
        this.y = hfVar;
        this.w = hfVar.xj("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static xj xj() {
        if (hf == null) {
            hf = new xj();
        }
        return hf;
    }

    public void hf(String str) {
        if (TextUtils.isEmpty(str)) {
            this.kd = "";
        } else if (TextUtils.equals(this.kd, str)) {
            this.kd = "";
        }
    }

    private boolean xj(Activity activity, DownloadInfo downloadInfo, boolean z, InterfaceC0467xj interfaceC0467xj) {
        if (downloadInfo == null) {
            try {
                if (this.w.isEmpty()) {
                    return false;
                }
            } catch (Exception e) {
                pl.xj(e);
            }
        }
        if (activity != null && !activity.isFinishing()) {
            boolean z2 = true;
            if (downloadInfo != null && this.w.isEmpty()) {
                xj(activity, new com.ss.android.downloadlib.addownload.hf.xj(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0467xj);
                return true;
            }
            long lastModified = downloadInfo != null ? new File(downloadInfo.getTargetFilePath()).lastModified() : 0L;
            CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.hf.xj> copyOnWriteArrayList = this.w;
            ListIterator<com.ss.android.downloadlib.addownload.hf.xj> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    z2 = false;
                    break;
                }
                com.ss.android.downloadlib.addownload.hf.xj previous = listIterator.previous();
                if (previous != null && !g.kd(com.ss.android.downloadlib.addownload.pl.getContext(), previous.u) && g.xj(previous.c)) {
                    if (new File(previous.c).lastModified() >= lastModified) {
                        xj(activity, previous, z, interfaceC0467xj);
                    } else {
                        xj(activity, new com.ss.android.downloadlib.addownload.hf.xj(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0467xj);
                    }
                }
            }
            p.xj(xj, "tryShowInstallDialog isShow:".concat(String.valueOf(z2)), null);
            return z2;
        }
        return false;
    }

    public boolean xj(Activity activity, boolean z, InterfaceC0467xj interfaceC0467xj) {
        if (com.ss.android.downloadlib.addownload.pl.d().optInt("disable_install_app_dialog") == 1 || this.u) {
            return false;
        }
        return xj(activity, xj(activity), z, interfaceC0467xj);
    }

    public void xj(Context context, com.ss.android.downloadlib.addownload.hf.xj xjVar, boolean z, InterfaceC0467xj interfaceC0467xj) {
        this.w.clear();
        xj(context, xjVar, interfaceC0467xj, z);
        this.u = true;
        tf.xj(context).w();
        this.y.hf("sp_ad_install_back_dialog", "key_uninstalled_list");
        p.xj(xj, "tryShowInstallDialog isShow:true", null);
    }

    public DownloadInfo xj(Context context) {
        long hf2;
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo = null;
        try {
            hf2 = tf.xj(context).hf();
        } catch (Exception e) {
            pl.xj(e);
        }
        if (com.ss.android.downloadlib.addownload.pl.d().optInt("enable_miniapp_dialog", 0) != 0 && (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK)) != null && !successedDownloadInfosWithMimeType.isEmpty()) {
            long j = 0;
            for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                if (downloadInfo2 != null && !g.kd(context, downloadInfo2.getPackageName()) && g.xj(downloadInfo2.getTargetFilePath())) {
                    long lastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                    if (lastModified >= hf2 && downloadInfo2.getExtra() != null) {
                        try {
                            if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j == 0 || lastModified > j)) {
                                downloadInfo = downloadInfo2;
                                j = lastModified;
                            }
                        } catch (Exception e2) {
                            pl.xj(e2);
                        }
                    }
                }
            }
            return downloadInfo;
        }
        return null;
    }

    public void xj(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        for (int i = 0; i < this.w.size(); i++) {
            com.ss.android.downloadlib.addownload.hf.xj xjVar = this.w.get(i);
            if (xjVar != null && xjVar.hf == j2) {
                this.w.set(i, new com.ss.android.downloadlib.addownload.hf.xj(j, j2, j3, str, str2, str3, str4));
                this.y.xj("sp_ad_install_back_dialog", "key_uninstalled_list", this.w);
                return;
            }
        }
        this.w.add(new com.ss.android.downloadlib.addownload.hf.xj(j, j2, j3, str, str2, str3, str4));
        this.y.xj("sp_ad_install_back_dialog", "key_uninstalled_list", this.w);
    }

    private void xj(final Context context, final com.ss.android.downloadlib.addownload.hf.xj xjVar, final InterfaceC0467xj interfaceC0467xj, boolean z) {
        final com.ss.android.downloadad.api.xj.hf u = y.xj().u(xjVar.hf);
        if (u == null) {
            com.ss.android.downloadlib.kd.w.xj().xj("showBackInstallDialog nativeModel null");
            return;
        }
        com.ss.android.downloadlib.addownload.pl.w().hf(new hf.xj(context).xj(z ? "应用安装确认" : "退出确认").hf(String.format("%1$s下载完成，是否立即安装？", TextUtils.isEmpty(xjVar.kd) ? "刚刚下载的应用" : xjVar.kd)).w("立即安装").u(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).xj(false).xj(g.xj(context, xjVar.c)).xj(new hf.InterfaceC0464hf() { // from class: com.ss.android.downloadlib.addownload.xj.xj.1
            @Override // com.ss.android.download.api.model.hf.InterfaceC0464hf
            public void hf(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.u.xj.xj().hf("backdialog_exit", u);
                InterfaceC0467xj interfaceC0467xj2 = interfaceC0467xj;
                if (interfaceC0467xj2 != null) {
                    interfaceC0467xj2.xj();
                }
                xj.this.hf("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.hf.InterfaceC0464hf
            public void w(DialogInterface dialogInterface) {
                xj.this.hf("");
            }

            @Override // com.ss.android.download.api.model.hf.InterfaceC0464hf
            public void xj(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.u.xj.xj().hf("backdialog_install", u);
                com.ss.android.socialbase.appdownloader.u.xj(context, (int) xjVar.xj);
                dialogInterface.dismiss();
            }
        }).xj(1).xj());
        com.ss.android.downloadlib.u.xj.xj().hf("backdialog_show", u);
        this.kd = xjVar.u;
    }

    public boolean xj(String str) {
        return TextUtils.equals(this.kd, str);
    }

    public void xj(com.ss.android.downloadad.api.xj.hf hfVar) {
        if (com.ss.android.downloadlib.addownload.pl.d().optInt("enable_open_app_dialog", 0) == 1 && !hfVar.qd() && hfVar.e() && Build.VERSION.SDK_INT < 34) {
            hfVar.p(true);
            TTDelegateActivity.xj(hfVar);
        }
    }
}
