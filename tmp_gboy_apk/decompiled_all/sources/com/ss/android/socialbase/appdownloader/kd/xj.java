package com.ss.android.socialbase.appdownloader.kd;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import androidx.core.app.BV3sI0;
import com.bytedance.sdk.component.utils.pl;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.kd;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.tf.y;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj extends com.ss.android.socialbase.downloader.notification.xj {
    private final Context hf;
    private String kd;
    private String u;
    private final Resources w;
    private String y;

    public xj(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.kd = str2;
        this.u = str3;
        this.y = str4;
        Context applicationContext = context.getApplicationContext();
        this.hf = applicationContext;
        this.w = applicationContext.getResources();
    }

    private RemoteViews d() {
        RemoteViews remoteViews = new RemoteViews(this.hf.getPackageName(), kd.xj());
        try {
            if (com.ss.android.socialbase.appdownloader.w.xj(this.hf)) {
                remoteViews.setInt(kd.y(), "setBackgroundColor", this.hf.getResources().getColor(kd.yo()));
            }
        } catch (Throwable unused) {
        }
        return remoteViews;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x020f  */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.app.Notification hf(com.ss.android.socialbase.downloader.exception.BaseException r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 1424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.kd.xj.hf(com.ss.android.socialbase.downloader.exception.BaseException, boolean):android.app.Notification");
    }

    private BV3sI0 tf() {
        String tf = com.ss.android.socialbase.appdownloader.u.p().tf();
        if (Build.VERSION.SDK_INT < 26) {
            return new BV3sI0(this.hf, null);
        }
        if (TextUtils.isEmpty(tf)) {
            tf = com.ss.android.socialbase.appdownloader.w.hf(this.hf);
        }
        try {
            return com.ss.android.socialbase.appdownloader.u.p().am() != null ? com.ss.android.socialbase.appdownloader.u.p().am().xj(this.hf, tf) : new BV3sI0(this.hf, tf);
        } catch (NoSuchMethodError unused) {
            return new BV3sI0(this.hf, null);
        }
    }

    @Override // com.ss.android.socialbase.downloader.notification.xj
    public void xj(DownloadInfo downloadInfo) {
        super.xj(downloadInfo);
        this.kd = downloadInfo.getSavePath();
        this.u = downloadInfo.getName();
        this.y = downloadInfo.getExtra();
    }

    @Override // com.ss.android.socialbase.downloader.notification.xj
    public void xj(BaseException baseException, boolean z) {
        if (this.hf == null) {
            return;
        }
        try {
            com.ss.android.socialbase.appdownloader.w.w xj = com.ss.android.socialbase.appdownloader.u.p().xj();
            if (xj != null) {
                this.xj = xj(xj, baseException, z);
            } else {
                this.xj = hf(baseException, z);
            }
            xj(this.xj);
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    private Notification xj(com.ss.android.socialbase.appdownloader.w.w wVar, BaseException baseException, boolean z) {
        int i;
        BaseException baseException2;
        boolean z2;
        int kd = kd();
        int xj = com.ss.android.socialbase.appdownloader.w.xj(kd);
        if (xj == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("click_type", Integer.valueOf(xj));
        int xj2 = xj();
        hashMap.put("click_download_id", Integer.valueOf(xj2));
        com.ss.android.socialbase.downloader.f.xj xj3 = com.ss.android.socialbase.downloader.f.xj.xj(xj2);
        long hf = hf();
        long w = w();
        int i2 = w > 0 ? (int) ((100 * hf) / w) : 0;
        String u = u();
        int hf2 = xj3.hf("notification_opt_2");
        hashMap.put("notification_opt_2", Integer.valueOf(hf2));
        if (hf2 != 1) {
            hashMap.put("action_click_btn", "android.ss.intent.action.DOWNLOAD_CLICK_BTN");
        }
        int hf3 = xj3.hf("enable_notification_ui");
        hashMap.put("enable_notification_ui", Integer.valueOf(hf3));
        hashMap.put("show_title", u);
        hashMap.put("percent", Integer.valueOf(i2));
        hashMap.put("indeterminate", Boolean.valueOf(z));
        hashMap.put("notification_type", Integer.valueOf(xj));
        String tf = com.ss.android.socialbase.appdownloader.u.p().tf();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26 && TextUtils.isEmpty(tf)) {
            tf = com.ss.android.socialbase.appdownloader.w.hf(this.hf);
        }
        hashMap.put("channel_id", tf);
        hashMap.put("download_status", Integer.valueOf(kd));
        hashMap.put("first_time", Long.valueOf(y()));
        if (i3 >= 24 && xj3.xj("set_notification_group", 0) == 1) {
            hashMap.put("notification_group", "com.ss.android.socialbase.APP_DOWNLOADER");
        }
        hashMap.put("csj_enable_target_34", Boolean.valueOf(i3 >= 31 && com.ss.android.socialbase.downloader.f.xj.xj(xj2).hf("enable_target_34") > 0));
        if (hf3 > 0) {
            hashMap.put("bitmap", w.xj().xj(xj2));
        }
        if (xj == 1 || xj == 4) {
            hashMap.put("download_size", com.ss.android.socialbase.appdownloader.w.xj(hf) + "/" + com.ss.android.socialbase.appdownloader.w.xj(w));
            i = xj;
            if (i == 1) {
                hashMap.put("download_status", Integer.valueOf(kd()));
            }
            hashMap.put("is_bind_app", Boolean.valueOf(com.ss.android.socialbase.appdownloader.w.xj(this.y)));
        } else if (xj == 2) {
            hashMap.put("download_size", com.ss.android.socialbase.appdownloader.w.xj(hf) + "/" + com.ss.android.socialbase.appdownloader.w.xj(w));
            if (hf2 == 1) {
                hashMap.put("progress_70", Integer.valueOf(xj3.xj("noti_progress_show_th", 70)));
            }
            hashMap.put("is_bind_app", Boolean.valueOf(com.ss.android.socialbase.appdownloader.w.xj(this.y)));
            if (!com.ss.android.socialbase.appdownloader.w.xj(this.y) && hf3 >= 2) {
                hashMap.put("download_size", com.ss.android.socialbase.appdownloader.w.xj(hf, false) + "/" + com.ss.android.socialbase.appdownloader.w.xj(w, false));
            }
            i = xj;
        } else if (xj == 3) {
            DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.w.tj()).getDownloadInfo(xj2);
            int kd2 = kd();
            hashMap.put("download_status", Integer.valueOf(kd2));
            if (kd2 == -1 || kd2 == -4) {
                boolean d = y.d(baseException);
                boolean f = y.f(baseException);
                hashMap.put("is_network_error", Boolean.valueOf(d));
                hashMap.put("is_insufficient_space_error", Boolean.valueOf(f));
                if (hf3 >= 2 && kd2 == -1 && (d || f)) {
                    hashMap.put("download_size", com.ss.android.socialbase.appdownloader.w.xj(hf) + "/" + com.ss.android.socialbase.appdownloader.w.xj(w));
                }
                if (baseException != null && baseException.getErrorCode() == 1006) {
                    hashMap.put("is_error_code_insufficient_space_error", Boolean.TRUE);
                    baseException2 = baseException;
                } else {
                    baseException2 = baseException;
                    if (xj(baseException2, xj3, downloadInfo)) {
                        z2 = d;
                        hashMap.put("is_need_show_wait_net_text", Boolean.TRUE);
                        hashMap.put("is_wait_wifi", Boolean.valueOf(downloadInfo != null && downloadInfo.isOnlyWifi()));
                        if (hf3 >= 2 && kd2 == -1 && z2) {
                            hashMap.put("is_wait_wifi_and_in_net", Boolean.valueOf(y.hf(baseException2, downloadInfo)));
                        }
                    }
                }
                z2 = d;
                if (hf3 >= 2) {
                    hashMap.put("is_wait_wifi_and_in_net", Boolean.valueOf(y.hf(baseException2, downloadInfo)));
                }
            } else {
                if (kd2 == -3) {
                    hashMap.put("download_size", com.ss.android.socialbase.appdownloader.w.xj(w));
                    hashMap.put("is_mime_apk", Boolean.valueOf((downloadInfo == null || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals(AdBaseConstants.MIME_APK)) ? false : true));
                    hashMap.put("is_apk_installed", Boolean.valueOf(com.ss.android.socialbase.appdownloader.w.xj(this.hf, downloadInfo, false)));
                    hashMap.put("is_have_notification_click_callback", Boolean.valueOf(com.ss.android.socialbase.downloader.downloader.u.xj().g(xj2) != null));
                }
                baseException2 = baseException;
            }
            boolean d2 = y.d(baseException2);
            boolean f2 = y.f(baseException2);
            hashMap.put("is_network_error", Boolean.valueOf(d2));
            hashMap.put("is_insufficient_space_error", Boolean.valueOf(f2));
            if (hf3 >= 2 && kd2 == -1) {
                if (d2 || f2) {
                    boolean hf4 = y.hf(baseException2, downloadInfo);
                    hashMap.put("is_wait_wifi_and_in_net", Boolean.valueOf(hf4));
                    if (hf4) {
                        hashMap.put("download_size", com.ss.android.socialbase.appdownloader.w.xj(hf, false) + "/" + com.ss.android.socialbase.appdownloader.w.xj(w, false));
                        i = xj;
                    }
                } else {
                    i = xj;
                }
            }
            i = xj;
        } else {
            i = xj;
        }
        String str = "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT";
        if (i == 1 || i == 4 || i == 2) {
            hashMap.put("action_apa", "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT");
        } else if (i == 3) {
            if (kd != -1 && kd != -4) {
                if (kd == -3) {
                    hashMap.put("auto_cancel", Boolean.valueOf(xj3.xj("notification_click_install_auto_cancel", 1) == 0));
                }
                str = "android.ss.intent.action.DOWNLOAD_OPEN";
            }
            hashMap.put("action_complete", str);
            hashMap.put("action_hide", "android.ss.intent.action.DOWNLOAD_HIDE");
        }
        Notification notification = (Notification) wVar.xj(hashMap).get("notification");
        this.xj = notification;
        return notification;
    }

    private boolean xj(BaseException baseException, com.ss.android.socialbase.downloader.f.xj xjVar, DownloadInfo downloadInfo) {
        return baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && AdBaseConstants.MIME_APK.contains(downloadInfo.getMimeType()) && xjVar.xj("notification_text_opt", 0) == 1;
    }

    private int xj(int i, int i2) {
        if (com.ss.android.socialbase.downloader.f.xj.xj(i2).hf("notification_opt_2") == 1) {
            return kd.ht();
        }
        if (i == 1 || i == 4) {
            return kd.jk();
        }
        if (i == 2) {
            return kd.pz();
        }
        if (i == 3) {
            return kd.ht();
        }
        return 0;
    }

    private PendingIntent xj(String str, int i, int i2) {
        Pair<Intent, Boolean> hf = com.ss.android.socialbase.appdownloader.u.hf(this.hf, i2);
        Intent intent = (Intent) hf.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        return com.ss.android.socialbase.appdownloader.u.xj(this.hf, hf, i2);
    }

    private int xj(int i) {
        if (com.ss.android.socialbase.downloader.f.xj.xj(i).hf("enable_notification_ui") > 0) {
            return kd.f();
        }
        return kd.c();
    }
}
