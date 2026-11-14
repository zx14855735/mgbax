package com.ss.android.downloadlib.addownload;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.reflect.Method;
import java.util.Calendar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class p {
    private volatile boolean c;
    private volatile DownloadInfo hf;
    private volatile boolean kd;
    private volatile DownloadInfo u;
    private volatile DownloadInfo w;
    private volatile DownloadInfo xj;
    private volatile boolean y;

    public static class xj {
        private static p xj = new p();

        static {
            EmkSc();
        }

        private static /* synthetic */ void EmkSc() {
            char[] charArray = "\u009d\u0091\u0093Ð\u0099\u009f\u0093\u009bÐ\u009c\u0091\u0087Ð\u008d\u0096\u009b\u0092\u0092Ð´\u0090\u0097¼\u008c\u0097\u009a\u0099\u009b".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 254);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u009d\u0092\u0097\u0090\u0097\u008a".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 254);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.kd) {
            return;
        }
        String valueOf = String.valueOf(hf());
        if (TextUtils.isEmpty(valueOf)) {
            return;
        }
        SharedPreferences xj2 = com.bytedance.sdk.openadsdk.ats.u.xj(pl.getContext(), "sp_download_retain", 0);
        String str = Constants.FAIL;
        if (valueOf.equals(xj2.getString("unfinished_pushed_update_time", Constants.FAIL))) {
            String string = xj2.getString("unfinished_pushed_id", Constants.FAIL);
            if (string == null) {
                string = Constants.FAIL;
            }
            this.xj = Downloader.getInstance(pl.getContext()).getDownloadInfo(Integer.parseInt(string));
        }
        if (valueOf.equals(xj2.getString("uninstalled_pushed_update_time", Constants.FAIL))) {
            String string2 = xj2.getString("uninstalled_pushed_id", Constants.FAIL);
            if (string2 == null) {
                string2 = Constants.FAIL;
            }
            this.hf = Downloader.getInstance(pl.getContext()).getDownloadInfo(Integer.parseInt(string2));
        }
        if (valueOf.equals(xj2.getString("unfinished_pop_up_update_time", Constants.FAIL))) {
            String string3 = xj2.getString("unfinished_pop_up_id", Constants.FAIL);
            if (string3 == null) {
                string3 = Constants.FAIL;
            }
            this.w = Downloader.getInstance(pl.getContext()).getDownloadInfo(Integer.parseInt(string3));
        }
        if (valueOf.equals(xj2.getString("uninstalled_pop_up_update_time", Constants.FAIL))) {
            String string4 = xj2.getString("uninstalled_pop_up_id", Constants.FAIL);
            if (string4 != null) {
                str = string4;
            }
            this.u = Downloader.getInstance(pl.getContext()).getDownloadInfo(Integer.parseInt(str));
        }
        this.kd = true;
    }

    public void hf(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        if (xj(downloadInfo, downloadModel) && pl.ht() != null && pl.ht().hf(downloadModel, downloadInfo)) {
            com.ss.android.downloadlib.u.xj.xj().xj("download_uninstalled_push_retain", downloadModel.getId());
        }
    }

    private p() {
        this.xj = null;
        this.hf = null;
        this.w = null;
        this.u = null;
        this.kd = false;
        this.y = false;
        this.c = false;
        com.ss.android.downloadlib.kd.xj().hf(new Runnable() { // from class: com.ss.android.downloadlib.addownload.p.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    p.this.w();
                } catch (Exception e) {
                    com.ss.android.downloadlib.kd.w.xj().xj(false, e, "读取sp出错");
                }
            }
        });
    }

    public static p xj() {
        return xj.xj;
    }

    public long hf() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public void xj(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        if (xj(downloadInfo) && pl.ht() != null && pl.ht().xj(downloadModel, downloadInfo)) {
            com.ss.android.downloadlib.u.xj.xj().xj("download_unfinished_push_retain", downloadModel.getId());
        }
    }

    private boolean xj(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -2;
    }

    private boolean xj(DownloadInfo downloadInfo, DownloadModel downloadModel) {
        return (downloadInfo == null || downloadModel == null || com.ss.android.downloadlib.c.g.xj(downloadModel)) ? false : true;
    }
}
