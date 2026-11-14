package com.ss.android.downloadlib.w;

import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.downloadlib.c.g;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f {

    public static class xj {
        private static f xj = new f();

        static {
            hWSud();
        }

        private static /* synthetic */ void hWSud() {
            char[] charArray = "\u009f\u0093\u0091Ò\u009b\u009d\u0091\u0099Ò\u009e\u0093\u0085Ò\u008f\u0094\u0099\u0090\u0090Ò¶\u0092\u0095¾\u008e\u0095\u0098\u009b\u0099".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 252);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u009f\u0090\u0095\u0092\u0095\u0088".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 252);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public void hf(com.ss.android.downloadad.api.xj.hf hfVar) {
        if (hfVar == null) {
            return;
        }
        hf(hfVar, com.ss.android.socialbase.downloader.f.xj.xj(hfVar.v()).xj("noti_continue_delay_secs", 5));
    }

    public void kd(com.ss.android.downloadad.api.xj.hf hfVar) {
        xj(hfVar, 5L);
    }

    public void u(com.ss.android.downloadad.api.xj.hf hfVar) {
        w(hfVar, com.ss.android.socialbase.downloader.f.xj.xj(hfVar.v()).xj("noti_install_delay_secs", 5));
    }

    public void w(com.ss.android.downloadad.api.xj.hf hfVar) {
        w(hfVar, 5L);
    }

    public void y(com.ss.android.downloadad.api.xj.hf hfVar) {
        xj(hfVar, com.ss.android.socialbase.downloader.f.xj.xj(hfVar.v()).xj("noti_open_delay_secs", 5));
    }

    private f() {
    }

    private void hf(final com.ss.android.downloadad.api.xj.hf hfVar, long j) {
        final int v = hfVar.v();
        if (com.ss.android.socialbase.downloader.f.xj.xj(v).hf("notification_opt_2") != 1) {
            return;
        }
        xj(v);
        com.ss.android.downloadlib.kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.w.f.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(pl.getContext()).getDownloadInfo(v);
                JSONObject jSONObject = new JSONObject();
                g.xj(jSONObject, "ttdownloader_type", (Object) 1);
                com.ss.android.downloadlib.c.y.w(downloadInfo, jSONObject);
                if (downloadInfo == null || -2 != downloadInfo.getRealStatus() || downloadInfo.isPauseReserveOnWifi()) {
                    g.xj(jSONObject, "error_code", (Object) 1001);
                } else {
                    f.this.xj(v, hfVar, jSONObject);
                }
                com.ss.android.downloadlib.u.xj.xj().hf("download_notification_try_show", jSONObject, hfVar);
            }
        }, j * 1000);
    }

    private void w(final com.ss.android.downloadad.api.xj.hf hfVar, long j) {
        final int v = hfVar.v();
        if (com.ss.android.socialbase.downloader.f.xj.xj(v).hf("notification_opt_2") != 1) {
            return;
        }
        xj(v);
        com.ss.android.downloadlib.kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.w.f.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(pl.getContext()).getDownloadInfo(v);
                JSONObject jSONObject = new JSONObject();
                g.xj(jSONObject, "ttdownloader_type", (Object) 2);
                com.ss.android.downloadlib.c.y.w(downloadInfo, jSONObject);
                if (g.hf(hfVar)) {
                    g.xj(jSONObject, "error_code", (Object) 1002);
                } else {
                    f.this.xj(v, hfVar, jSONObject);
                }
                com.ss.android.downloadlib.u.xj.xj().hf("download_notification_try_show", jSONObject, hfVar);
            }
        }, j * 1000);
    }

    public static f xj() {
        return xj.xj;
    }

    public void xj(com.ss.android.downloadad.api.xj.hf hfVar) {
        hf(hfVar, 5L);
    }

    public void xj(final com.ss.android.downloadad.api.xj.hf hfVar, long j) {
        final int v = hfVar.v();
        if (com.ss.android.socialbase.downloader.f.xj.xj(v).hf("notification_opt_2") != 1) {
            return;
        }
        xj(v);
        com.ss.android.downloadlib.kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.w.f.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(pl.getContext()).getDownloadInfo(v);
                JSONObject jSONObject = new JSONObject();
                g.xj(jSONObject, "ttdownloader_type", (Object) 3);
                com.ss.android.downloadlib.c.y.w(downloadInfo, jSONObject);
                if (g.w(hfVar.kd())) {
                    g.xj(jSONObject, "error_code", (Object) 1003);
                } else {
                    f.this.xj(v, hfVar, jSONObject);
                }
                com.ss.android.downloadlib.u.xj.xj().hf("download_notification_try_show", jSONObject, hfVar);
            }
        }, j * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, com.ss.android.downloadad.api.xj.hf hfVar, JSONObject jSONObject) {
        if (!com.ss.android.socialbase.appdownloader.kd.u.xj()) {
            g.xj(jSONObject, "error_code", Integer.valueOf(PluginConstants.ERROR_PLUGIN_DOWNLOAD));
            return;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(pl.getContext()).getDownloadInfo(i);
        if (downloadInfo == null) {
            g.xj(jSONObject, "error_code", (Object) 1005);
            return;
        }
        if (com.ss.android.socialbase.downloader.notification.hf.xj().kd(i) != null) {
            com.ss.android.socialbase.downloader.notification.hf.xj().y(i);
        }
        com.ss.android.socialbase.appdownloader.kd.xj xjVar = new com.ss.android.socialbase.appdownloader.kd.xj(pl.getContext(), i, downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
        xjVar.xj(downloadInfo.getCurBytes());
        xjVar.hf(downloadInfo.getTotalBytes());
        xjVar.xj(downloadInfo.getStatus(), null, false, false);
        com.ss.android.socialbase.downloader.notification.hf.xj().xj(xjVar);
        xjVar.xj((BaseException) null, false);
        com.ss.android.downloadlib.u.xj.xj().hf("download_notification_show", jSONObject, hfVar);
    }

    public void xj(int i) {
        DownloadInfo downloadInfo;
        if (com.ss.android.socialbase.appdownloader.kd.w.xj().xj(i) != null || (downloadInfo = Downloader.getInstance(pl.getContext()).getDownloadInfo(i)) == null) {
            return;
        }
        com.ss.android.socialbase.appdownloader.kd.w.xj().xj(i, downloadInfo.getIconUrl());
    }
}
