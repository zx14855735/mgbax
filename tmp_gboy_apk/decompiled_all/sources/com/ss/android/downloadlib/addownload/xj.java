package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.c.am;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj implements am.xj {
    private static xj hf = null;
    private static final String xj = "xj";
    private long u;
    private com.ss.android.downloadlib.c.am w = new com.ss.android.downloadlib.c.am(Looper.getMainLooper(), this);

    private xj() {
    }

    public static xj xj() {
        if (hf == null) {
            synchronized (xj.class) {
                try {
                    if (hf == null) {
                        hf = new xj();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    public void xj(DownloadInfo downloadInfo, long j, long j2, String str, String str2, String str3, String str4) {
        int i;
        com.ss.android.downloadlib.addownload.hf.xj xjVar = new com.ss.android.downloadlib.addownload.hf.xj(downloadInfo.getId(), j, j2, str, str2, str3, str4);
        if (com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.appdownloader.y.kd.g() || com.ss.android.socialbase.appdownloader.y.kd.am()) && com.ss.android.socialbase.downloader.tf.tf.xj(pl.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (com.ss.android.socialbase.downloader.tf.y.xj(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                Message obtainMessage = this.w.obtainMessage(200, xjVar);
                obtainMessage.arg1 = 2;
                this.w.sendMessageDelayed(obtainMessage, r13.xj("check_silent_install_interval", BaseConstants.Time.MINUTE));
                return;
            }
            com.ss.android.downloadad.api.xj.hf u = com.ss.android.downloadlib.addownload.hf.y.xj().u(xjVar.hf);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i = 5;
            } catch (Exception unused) {
                i = -1;
            }
            pl.y().xj(null, new BaseException(i, jSONObject.toString()), i);
            com.ss.android.downloadlib.u.xj.xj().xj("embeded_ad", "ah_result", jSONObject, u);
        }
        if (com.ss.android.downloadlib.c.kd.w()) {
            long currentTimeMillis = System.currentTimeMillis() - this.u;
            long u2 = com.ss.android.downloadlib.c.kd.u();
            if (currentTimeMillis < com.ss.android.downloadlib.c.kd.kd()) {
                long kd = com.ss.android.downloadlib.c.kd.kd() - currentTimeMillis;
                u2 += kd;
                this.u = System.currentTimeMillis() + kd;
            } else {
                this.u = System.currentTimeMillis();
            }
            com.ss.android.downloadlib.c.am amVar = this.w;
            amVar.sendMessageDelayed(amVar.obtainMessage(200, xjVar), u2);
        }
    }

    private void xj(com.ss.android.downloadlib.addownload.hf.xj xjVar, int i) {
        int i2;
        if (pl.pl() == null || pl.pl().xj() || xjVar == null) {
            return;
        }
        if (2 == i) {
            com.ss.android.downloadad.api.xj.hf u = com.ss.android.downloadlib.addownload.hf.y.xj().u(xjVar.hf);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (com.ss.android.downloadlib.c.g.kd(pl.getContext(), xjVar.u)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i2 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i2 = 5;
                }
            } catch (Exception unused) {
                i2 = -1;
            }
            pl.y().xj(null, new BaseException(i2, jSONObject.toString()), i2);
            com.ss.android.downloadlib.u.xj.xj().xj("embeded_ad", "ah_result", jSONObject, u);
        }
        if (com.ss.android.downloadlib.c.g.kd(pl.getContext(), xjVar.u)) {
            com.ss.android.downloadlib.u.xj.xj().hf("delayinstall_installed", xjVar.hf);
            return;
        }
        if (!com.ss.android.downloadlib.c.g.xj(xjVar.c)) {
            com.ss.android.downloadlib.u.xj.xj().hf("delayinstall_file_lost", xjVar.hf);
        } else if (com.ss.android.downloadlib.addownload.xj.xj.xj().xj(xjVar.u)) {
            com.ss.android.downloadlib.u.xj.xj().hf("delayinstall_conflict_with_back_dialog", xjVar.hf);
        } else {
            com.ss.android.downloadlib.u.xj.xj().hf("delayinstall_install_start", xjVar.hf);
            com.ss.android.socialbase.appdownloader.u.xj(pl.getContext(), (int) xjVar.xj);
        }
    }

    @Override // com.ss.android.downloadlib.c.am.xj
    public void xj(Message message) {
        if (message.what != 200) {
            return;
        }
        xj((com.ss.android.downloadlib.addownload.hf.xj) message.obj, message.arg1);
    }
}
