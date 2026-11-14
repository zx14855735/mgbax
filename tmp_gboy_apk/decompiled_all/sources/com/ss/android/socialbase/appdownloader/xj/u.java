package com.ss.android.socialbase.appdownloader.xj;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u {
    public static xj xj(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo != null && context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (!TextUtils.isEmpty(savePath) && !TextUtils.isEmpty(str)) {
                File file = new File(savePath);
                com.ss.android.socialbase.downloader.f.xj xj = com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo);
                if (str.equals("v1")) {
                    return new tf(context, xj, downloadInfo.getTargetFilePath());
                }
                if (str.equals("v2")) {
                    return new p(context, xj, file.getAbsolutePath());
                }
                if (str.equals("v3")) {
                    return new pl(context, xj, file.getAbsolutePath());
                }
                if (str.equals("o1")) {
                    return new c(context, xj, file.getAbsolutePath());
                }
                if (str.equals("o2")) {
                    return new f(context, xj, file.getAbsolutePath());
                }
                if (str.equals("o3")) {
                    String dBJsonString = downloadInfo.getDBJsonString("file_content_uri");
                    if (!TextUtils.isEmpty(dBJsonString)) {
                        return new d(context, xj, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
                    }
                } else {
                    if (str.equals(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM)) {
                        return new w(context, xj, file.getAbsolutePath(), jSONObject);
                    }
                    if (str.equals("vbi")) {
                        return new g(context, xj, com.ss.android.socialbase.appdownloader.w.xj(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, com.ss.android.socialbase.appdownloader.u.p().kd(), new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
                    }
                }
            }
        }
        return null;
    }

    public static boolean xj(Context context, String str, JSONObject jSONObject, com.ss.android.socialbase.downloader.f.xj xjVar) {
        xj gVar;
        if (context != null && str != null) {
            String hf = com.ss.android.socialbase.appdownloader.w.hf();
            if (!TextUtils.isEmpty(hf) && !TextUtils.isEmpty(str)) {
                if (com.ss.android.socialbase.appdownloader.y.kd.u() && str.equals("v1")) {
                    gVar = new tf(context, xjVar, hf);
                } else if (com.ss.android.socialbase.appdownloader.y.kd.u() && str.equals("v2")) {
                    gVar = new p(context, xjVar, hf);
                } else if (com.ss.android.socialbase.appdownloader.y.kd.u() && str.equals("v3")) {
                    gVar = new pl(context, xjVar, hf);
                } else if (com.ss.android.socialbase.appdownloader.y.kd.kd() && str.equals("o1")) {
                    gVar = new c(context, xjVar, hf);
                } else if (com.ss.android.socialbase.appdownloader.y.kd.kd() && str.equals("o2")) {
                    gVar = new f(context, xjVar, hf);
                } else if (com.ss.android.socialbase.appdownloader.y.kd.kd() && str.equals("o3")) {
                    gVar = new d(context, xjVar, hf, hf, hf);
                } else if (com.ss.android.socialbase.appdownloader.y.kd.u() && str.equals(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM)) {
                    gVar = new w(context, xjVar, hf, jSONObject);
                } else {
                    gVar = (com.ss.android.socialbase.appdownloader.y.kd.u() && str.equals("vbi")) ? new g(context, xjVar, hf) : null;
                }
                if (gVar != null && gVar.xj()) {
                    return true;
                }
            }
        }
        return false;
    }
}
