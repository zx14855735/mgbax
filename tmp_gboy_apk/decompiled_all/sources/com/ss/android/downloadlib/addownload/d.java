package com.ss.android.downloadlib.addownload;

import B4ZgIw.AYUAbz;
import android.content.Intent;
import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d {
    public static boolean hf(int i) {
        return i == 2 || i == 1;
    }

    public static String u(DownloadModel downloadModel) {
        try {
            if (TextUtils.isEmpty(downloadModel.getLogExtra())) {
                return null;
            }
            return new JSONObject(downloadModel.getLogExtra()).optString(AdBaseConstants.MARKET_OPEN_INTENT_EXTRA);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    public static String w(DownloadModel downloadModel) {
        try {
            if (TextUtils.isEmpty(downloadModel.getLogExtra())) {
                return null;
            }
            return new JSONObject(downloadModel.getLogExtra()).optString("clickid");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    public static boolean xj(int i) {
        return i == 0 || i == 1;
    }

    public static boolean hf(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }

    public static boolean xj(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean xj(DownloadModel downloadModel, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return downloadModel.isAd() && iDownloadButtonClickListener != null;
    }

    public static int xj(com.ss.android.downloadlib.addownload.hf.kd kdVar, boolean z, com.ss.android.socialbase.appdownloader.y yVar) {
        int i;
        if (yVar == null || TextUtils.isEmpty(yVar.xj()) || yVar.getContext() == null) {
            return 0;
        }
        try {
            i = xj(yVar, yVar.xj());
        } catch (Throwable th) {
            pl.jk().xj(th, "redirectSavePathIfPossible");
            i = 4;
        }
        yVar.xj(i);
        if (i == 0) {
            yVar.xj(new com.ss.android.downloadlib.w.xj());
        }
        if (!yVar.bl()) {
            yVar.xj(new com.ss.android.downloadlib.w.hf());
        }
        int xj = com.ss.android.socialbase.appdownloader.u.p().xj(yVar);
        com.ss.android.downloadad.api.xj.hf xj2 = xj(kdVar, xj);
        com.ss.android.downloadlib.addownload.hf.y.xj().xj(xj2);
        xj2.c(xj);
        xj2.f(System.currentTimeMillis());
        xj2.d(0L);
        com.ss.android.socialbase.downloader.f.xj xj3 = com.ss.android.socialbase.downloader.f.xj.xj(yVar.op());
        if (!xj(yVar, xj3, xj) && kdVar.hf.isShowToast()) {
            String startToast = kdVar.hf.getStartToast();
            if (TextUtils.isEmpty(startToast)) {
                startToast = xj3.w("download_start_toast_text");
            }
            if (TextUtils.isEmpty(startToast)) {
                startToast = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            pl.w().xj(2, yVar.getContext(), kdVar.hf, startToast, null, 0);
        }
        return xj;
    }

    private static com.ss.android.downloadad.api.xj.hf xj(com.ss.android.downloadlib.addownload.hf.kd kdVar, int i) {
        com.ss.android.downloadad.api.xj.hf hfVar = new com.ss.android.downloadad.api.xj.hf(kdVar.hf, kdVar.w, kdVar.u, i);
        boolean z = true;
        if (com.ss.android.socialbase.downloader.f.xj.xj(i).xj("download_event_opt", 1) > 1) {
            try {
                String packageName = kdVar.hf.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (pl.getContext().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z = false;
                    }
                    hfVar.f(z);
                }
            } catch (Throwable unused) {
            }
        }
        return hfVar;
    }

    private static boolean xj(com.ss.android.socialbase.appdownloader.y yVar, com.ss.android.socialbase.downloader.f.xj xjVar, int i) {
        String optString;
        JSONArray kd = xjVar.kd("ah_plans");
        if (kd != null && kd.length() != 0) {
            int length = kd.length();
            JSONObject jSONObject = null;
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = kd.optJSONObject(i2);
                if (optJSONObject != null && ((optString = optJSONObject.optString(PointParamKey.TYPE)) == "plan_c" || com.ss.android.socialbase.appdownloader.y.xj.xj(optJSONObject))) {
                    optString.getClass();
                    switch (optString) {
                        case "plan_a":
                        case "plan_b":
                        case "plan_e":
                        case "plan_f":
                            if (com.ss.android.socialbase.appdownloader.hf.xj(optJSONObject, xjVar).hf == 0) {
                                break;
                            } else {
                                break;
                            }
                        case "plan_c":
                            jSONObject = optJSONObject;
                            break;
                        case "plan_g":
                            if (com.ss.android.socialbase.appdownloader.hf.hf(optJSONObject, xjVar).hf == 0) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
            if (jSONObject != null && jSONObject.optInt("show_unknown_source_on_startup") == 1) {
                return com.ss.android.socialbase.appdownloader.hf.xj(com.ss.android.socialbase.downloader.downloader.w.tj(), (Intent) null, jSONObject, i, new com.ss.android.socialbase.appdownloader.xj());
            }
        }
        return false;
    }

    public static String xj(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        return null;
    }

    private static int xj(com.ss.android.socialbase.appdownloader.y yVar, String str) {
        com.ss.android.socialbase.downloader.f.xj xj = com.ss.android.socialbase.downloader.f.xj.xj(yVar.op());
        JSONObject u = xj.u("download_dir");
        if (u == null || TextUtils.isEmpty(u.optString("dir_name"))) {
            return -1;
        }
        String hf = yVar.hf();
        String b = yVar.b();
        if (TextUtils.isEmpty(b)) {
            b = com.ss.android.socialbase.appdownloader.w.xj(str, hf, yVar.pl(), true);
        }
        if (b.length() > 255) {
            b = b.substring(b.length() - 255);
        }
        if (TextUtils.isEmpty(hf)) {
            hf = b;
        }
        String w = yVar.w();
        if (TextUtils.isEmpty(w)) {
            w = com.ss.android.socialbase.appdownloader.w.hf();
        }
        StringBuilder A4TApA2 = AYUAbz.A4TApA(w);
        A4TApA2.append(File.separator);
        A4TApA2.append(com.ss.android.socialbase.appdownloader.w.xj(hf, xj));
        String sb = A4TApA2.toString();
        DownloadInfo xj2 = com.ss.android.socialbase.appdownloader.u.p().xj(yVar.getContext(), str);
        if (xj2 != null && xj2.isSavePathRedirected()) {
            yVar.w(xj2.getSavePath());
            try {
                yVar.xj(new JSONObject(xj2.getDownloadSettingString()));
                return 0;
            } catch (Throwable unused) {
                return 0;
            }
        }
        if (xj2 != null || !AdBaseConstants.MIME_APK.equalsIgnoreCase(com.ss.android.socialbase.appdownloader.u.p().xj(b, yVar.pl()))) {
            return xj2 != null ? 8 : 9;
        }
        int xj3 = com.ss.android.socialbase.appdownloader.hf.xj(xj);
        if (xj3 == 0) {
            yVar.w(sb);
        }
        return xj3;
    }
}
