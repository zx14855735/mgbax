package com.ss.android.downloadlib.u;

import android.os.Build;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.base.common.a;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.n;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.w;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.hf.d;
import com.ss.android.downloadlib.addownload.hf.kd;
import com.ss.android.downloadlib.addownload.hf.y;
import com.ss.android.downloadlib.c.g;
import com.ss.android.socialbase.appdownloader.kd.u;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj {

    /* renamed from: com.ss.android.downloadlib.u.xj$xj, reason: collision with other inner class name */
    public static class C0472xj {
        private static xj xj = new xj();

        static {
            KjCKnf();
        }

        private static /* synthetic */ void KjCKnf() {
            char[] charArray = "ßÓÑ\u0092ÛÝÑÙ\u0092ÞÓÅ\u0092ÏÔÙÐÐ\u0092öÒÕþÎÕØÛÙ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 188);
            }
            String str = new String(charArray);
            char[] charArray2 = "ßÐÕÒÕÈ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 188);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static xj xj() {
        return C0472xj.xj;
    }

    public void hf(long j, int i) {
        xj(j, i, (DownloadInfo) null);
    }

    private xj() {
    }

    public void hf(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadad.api.xj.hf xj = y.xj().xj(downloadInfo);
        if (xj == null) {
            com.ss.android.downloadlib.kd.w.xj().xj("sendDownloadFailedEvent nativeModel null");
            return;
        }
        if (xj.w.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.c.y.w(downloadInfo, jSONObject);
            com.ss.android.downloadlib.xj.xj(jSONObject, downloadInfo);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                xj.u(baseException.getErrorCode());
                xj.xj(baseException.getErrorMessage());
            }
            xj.et();
            jSONObject.put("download_failed_times", xj.dk());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            jSONObject.put("has_send_download_failed_finally", xj.u.get() ? 1 : 2);
            com.ss.android.downloadlib.c.y.xj(xj, jSONObject);
            jSONObject.put("is_update_download", xj.aq() ? 1 : 2);
        } catch (JSONException e) {
            pl.xj(e);
        }
        xj(xj.tf(), PointCategory.DOWNLOAD_FAILED, jSONObject, xj);
        d.xj().xj(xj);
    }

    public void xj(long j, int i) {
        kd kd = y.xj().kd(j);
        if (kd.dk()) {
            com.ss.android.downloadlib.kd.w.xj().xj("sendClickEvent ModelBox notValid");
            return;
        }
        if (kd.w.isEnableClickEvent()) {
            int i2 = 1;
            DownloadEventConfig downloadEventConfig = kd.w;
            String clickItemTag = i == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
            String xj = g.xj(kd.w.getClickLabel(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i));
                jSONObject.putOpt("permission_notification", Integer.valueOf(u.xj() ? 1 : 2));
                if (!com.ss.android.socialbase.downloader.tf.y.w(com.ss.android.downloadlib.addownload.pl.getContext())) {
                    i2 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i2));
            } catch (JSONException e) {
                pl.xj(e);
            }
            xj(clickItemTag, xj, jSONObject, kd);
            if (!"click".equals(xj) || kd.hf == null) {
                return;
            }
            w.xj().xj(j, kd.hf.getLogExtra());
        }
    }

    public void xj(long j, int i, DownloadInfo downloadInfo) {
        String xj;
        kd kd = y.xj().kd(j);
        if (kd.dk()) {
            com.ss.android.downloadlib.kd.w.xj().xj("sendEvent ModelBox notValid");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        g.xj(jSONObject, "download_scene", Integer.valueOf(kd.jk()));
        if (i == 1) {
            xj = g.xj(kd.w.getStorageDenyLabel(), "storage_deny");
        } else if (i == 2) {
            xj = g.xj(kd.w.getClickStartLabel(), "click_start");
            com.ss.android.downloadlib.c.y.xj(downloadInfo, jSONObject);
        } else if (i == 3) {
            xj = g.xj(kd.w.getClickPauseLabel(), "click_pause");
            com.ss.android.downloadlib.c.y.hf(downloadInfo, jSONObject);
        } else if (i == 4) {
            xj = g.xj(kd.w.getClickContinueLabel(), "click_continue");
            com.ss.android.downloadlib.c.y.w(downloadInfo, jSONObject);
        } else if (i != 5) {
            xj = null;
        } else {
            if (downloadInfo != null) {
                try {
                    com.ss.android.downloadlib.c.y.xj(jSONObject, downloadInfo.getId());
                    com.ss.android.downloadlib.xj.hf(jSONObject, downloadInfo);
                } catch (Throwable unused) {
                }
            }
            xj = g.xj(kd.w.getClickInstallLabel(), "click_install");
        }
        xj(null, xj, jSONObject, 0L, 1, kd);
    }

    public void hf(String str, long j) {
        com.ss.android.downloadad.api.xj.hf u = y.xj().u(j);
        if (u != null) {
            hf(str, u);
        } else {
            hf(str, y.xj().kd(j));
        }
    }

    public void hf(String str, com.ss.android.downloadad.api.xj.xj xjVar) {
        xj((String) null, str, xjVar);
    }

    public void hf(String str, JSONObject jSONObject, com.ss.android.downloadad.api.xj.xj xjVar) {
        xj((String) null, str, jSONObject, xjVar);
    }

    public void xj(String str, int i, kd kdVar) {
        xj(null, str, null, i, 0, kdVar);
    }

    public void xj(long j, boolean z, int i) {
        kd kd = y.xj().kd(j);
        if (kd.dk()) {
            com.ss.android.downloadlib.kd.w.xj().xj("sendQuickAppEvent ModelBox notValid");
            return;
        }
        if (kd.hf.getQuickAppModel() == null) {
            return;
        }
        DownloadModel downloadModel = kd.hf;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_click_type", Integer.valueOf(i));
        } catch (JSONException e) {
            pl.xj(e);
        }
        hf(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, kd);
    }

    public void xj(long j, BaseException baseException) {
        kd kd = y.xj().kd(j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
            }
        } catch (JSONException e) {
            pl.xj(e);
        }
        hf(PointCategory.DOWNLOAD_FAILED, jSONObject, kd);
    }

    public void xj(DownloadInfo downloadInfo) {
        com.ss.android.downloadad.api.xj.hf xj = y.xj().xj(downloadInfo);
        if (xj == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.c.y.w(downloadInfo, jSONObject);
            xj.xj(System.currentTimeMillis());
            xj(xj.tf(), "download_resume", jSONObject, xj);
            d.xj().xj(xj);
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public void xj(JSONObject jSONObject, com.ss.android.downloadad.api.xj.hf hfVar) {
        xj(hfVar.tf(), a.F, jSONObject, hfVar);
    }

    public void xj(DownloadInfo downloadInfo, BaseException baseException) {
        com.ss.android.downloadad.api.xj.hf xj;
        if (downloadInfo == null || (xj = y.xj().xj(downloadInfo)) == null || xj.w.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.xj.xj(jSONObject, downloadInfo);
            jSONObject.putOpt("fail_status", Integer.valueOf(xj.j()));
            jSONObject.putOpt("fail_msg", xj.en());
            jSONObject.put("download_failed_times", xj.dk());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            if (xj.ff() > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - xj.ff());
            }
            if (xj.ai() > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - xj.ai());
            }
            jSONObject.put("is_update_download", xj.aq() ? 1 : 2);
            jSONObject.put("can_show_notification", u.xj() ? 1 : 2);
            jSONObject.put("has_send_download_failed_finally", xj.u.get() ? 1 : 2);
        } catch (JSONException e) {
            pl.xj(e);
        }
        xj(xj.tf(), "download_cancel", jSONObject, xj);
    }

    public void xj(String str, long j) {
        xj(str, (JSONObject) null, j);
    }

    public void xj(String str, com.ss.android.downloadad.api.xj.xj xjVar) {
        xj(str, (JSONObject) null, xjVar);
    }

    public void xj(String str, JSONObject jSONObject, long j) {
        com.ss.android.downloadad.api.xj.xj u = y.xj().u(j);
        if (u != null) {
            xj(str, jSONObject, u);
            return;
        }
        kd kd = y.xj().kd(j);
        if (kd.dk()) {
            com.ss.android.downloadlib.kd.w.xj().xj("sendUnityEvent ModelBox notValid");
        } else {
            xj(str, jSONObject, kd);
        }
    }

    public void xj(String str, JSONObject jSONObject, com.ss.android.downloadad.api.xj.xj xjVar) {
        JSONObject jSONObject2 = new JSONObject();
        g.xj(jSONObject2, "unity_label", str);
        xj("embeded_ad", "ttdownloader_unity", g.xj(jSONObject, jSONObject2), xjVar);
    }

    public void xj(String str, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        hf(str, new kd(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void xj(String str, String str2, com.ss.android.downloadad.api.xj.xj xjVar) {
        xj(str, str2, (JSONObject) null, xjVar);
    }

    public void xj(String str, String str2, JSONObject jSONObject, com.ss.android.downloadad.api.xj.xj xjVar) {
        xj(str, str2, jSONObject, 0L, 0, xjVar);
    }

    private void xj(String str, String str2, JSONObject jSONObject, long j, int i, com.ss.android.downloadad.api.xj.xj xjVar) {
        if (xjVar == null) {
            com.ss.android.downloadlib.kd.w.xj().xj("onEvent data null");
            return;
        }
        if ((xjVar instanceof kd) && ((kd) xjVar).dk()) {
            com.ss.android.downloadlib.kd.w.xj().xj("onEvent ModelBox notValid");
            return;
        }
        try {
            w.xj w = new w.xj().xj(g.xj(str, xjVar.tf(), "embeded_ad")).hf(str2).hf(xjVar.w()).xj(xjVar.hf()).w(xjVar.u());
            if (j <= 0) {
                j = xjVar.pl();
            }
            w.xj xj = w.hf(j).u(xjVar.d()).xj(xjVar.am()).xj(g.xj(xj(xjVar), jSONObject)).hf(xjVar.p()).xj(xjVar.qt());
            if (i <= 0) {
                i = 2;
            }
            xj(xj.xj(i).xj(xjVar.g()).xj());
        } catch (Exception e) {
            com.ss.android.downloadlib.kd.w.xj().xj(e, "onEvent");
        }
    }

    private JSONObject xj(com.ss.android.downloadad.api.xj.xj xjVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            g.xj(xjVar.c(), jSONObject);
            g.xj(xjVar.zg(), jSONObject);
            jSONObject.putOpt("download_url", xjVar.xj());
            jSONObject.putOpt(n.p, xjVar.kd());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.ss.android.socialbase.appdownloader.y.kd.f());
            jSONObject.putOpt("rom_version", com.ss.android.socialbase.appdownloader.y.kd.d());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(xjVar.f()));
            if (xjVar.f() == 2) {
                com.ss.android.downloadlib.c.y.hf(jSONObject, xjVar);
            }
            if (com.ss.android.socialbase.appdownloader.y.kd.zg()) {
                com.ss.android.downloadlib.c.y.xj(jSONObject);
                return jSONObject;
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.addownload.pl.jk().xj(e, "getBaseJson");
        }
        return jSONObject;
    }

    private void xj(com.ss.android.download.api.model.w wVar) {
        if (com.ss.android.downloadlib.addownload.pl.xj() == null) {
            return;
        }
        if (wVar.g()) {
            com.ss.android.downloadlib.addownload.pl.xj().xj(wVar);
        } else {
            com.ss.android.downloadlib.addownload.pl.xj().hf(wVar);
        }
    }
}
