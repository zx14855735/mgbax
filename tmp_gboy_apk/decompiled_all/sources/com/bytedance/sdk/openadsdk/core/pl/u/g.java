package com.bytedance.sdk.openadsdk.core.pl.u;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.pl.u.d;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.n;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class g implements u {
    private g() {
    }

    public static u u() {
        return new g();
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u.u
    public c hf() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u.u
    public boolean w() {
        return com.bytedance.sdk.openadsdk.core.f.zg().xj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u.u
    public boolean xj(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u.u
    public void hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.y.w(new File(str));
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u.u
    public void xj(JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.pl.w.hf.xj xj;
        ws wsVar;
        JSONObject optJSONObject = jSONObject.optJSONObject(com.bytedance.sdk.openadsdk.core.pl.xj.tf.EXTRA_DOWN_INFO_KEY);
        if (optJSONObject == null || !r.xj() || (xj = com.bytedance.sdk.openadsdk.core.pl.w.hf.xj.xj(optJSONObject)) == null || (wsVar = xj.xj) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.pl.d.xj(str, wsVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u.u
    public boolean hf(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        String str;
        String str2;
        String str3;
        int i;
        JSONObject optJSONObject;
        if (downloadModel == null || downloadInfo == null) {
            return false;
        }
        String logExtra = downloadModel.getLogExtra();
        String appIcon = downloadModel.getAppIcon();
        String name = downloadModel.getName();
        String packageName = downloadModel.getPackageName();
        String targetFilePath = downloadInfo.getTargetFilePath();
        long id = downloadModel.getId();
        int id2 = downloadInfo.getId();
        JSONObject c = com.ss.android.downloadlib.addownload.hf.y.xj().u(id).c();
        String str4 = null;
        if (c == null || (optJSONObject = c.optJSONObject(com.bytedance.sdk.openadsdk.core.pl.xj.tf.EXTRA_DOWN_INFO_KEY)) == null) {
            str = logExtra;
            str2 = null;
            str3 = null;
            i = 0;
        } else {
            String optString = optJSONObject.optString("tag");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("material_meta");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("download_conf");
                r0 = optJSONObject3 != null ? optJSONObject3.optInt("enable_notification", 0) : 0;
                str4 = optJSONObject2.optString(MediationConstant.EXTRA_ADID);
            }
            if (TextUtils.isEmpty(logExtra)) {
                logExtra = optJSONObject2.optString(n.m);
            }
            i = r0;
            str = logExtra;
            str3 = str4;
            str2 = optString;
        }
        return new com.bytedance.sdk.openadsdk.core.pl.y().xj(name, appIcon, packageName, id2, str, targetFilePath, i, str2, str3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u.u
    public JSONObject xj() {
        JSONObject hf = com.bytedance.sdk.openadsdk.core.pl.d.hf();
        try {
            if (!pz.hf().x()) {
                hf.put("enable_app_install_receiver", 0);
            }
            if (hf.optInt("enable_target_34", -1) == -1) {
                hf.put("enable_target_34", pz.hf().mq());
            }
        } catch (Exception unused) {
        }
        return hf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u.u
    public String xj(boolean z) {
        return com.bytedance.sdk.openadsdk.core.pl.d.xj(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u.u
    public void xj(Activity activity, String[] strArr, y yVar) {
        pl.xj(activity, strArr, yVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u.u
    public boolean xj(Context context, String str) {
        return pl.xj(context, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u.u
    public void xj(int i, String str, Map<String, Object> map, kd kdVar) {
        tf.xj(i, str, map, kdVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u.u
    public void xj(String str, byte[] bArr, String str2, kd kdVar) {
        tf.xj(str, bArr, str2, 0, kdVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u.u
    public AlertDialog xj(Activity activity, boolean z, xj xjVar) {
        return p.xj(activity, z, xjVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u.u
    public void xj(WeakReference<Context> weakReference, boolean z, xj xjVar) {
        p.xj(weakReference, z, xjVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u.u
    public boolean xj(String str) {
        return d.xj(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u.u
    public void xj(f fVar, boolean z) {
        if (xj(fVar)) {
            try {
                com.bytedance.sdk.component.tf.c.xj(d.xj.xj(fVar, z), 5);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u.u
    public boolean xj(DownloadModel downloadModel) {
        String str;
        String str2;
        String str3;
        int i;
        JSONObject optJSONObject;
        if (downloadModel == null) {
            return true;
        }
        String logExtra = downloadModel.getLogExtra();
        String appIcon = downloadModel.getAppIcon();
        String name = downloadModel.getName();
        String packageName = downloadModel.getPackageName();
        JSONObject c = com.ss.android.downloadlib.addownload.hf.y.xj().u(downloadModel.getId()).c();
        String str4 = null;
        if (c == null || (optJSONObject = c.optJSONObject(com.bytedance.sdk.openadsdk.core.pl.xj.tf.EXTRA_DOWN_INFO_KEY)) == null) {
            str = logExtra;
            str2 = null;
            str3 = null;
            i = 0;
        } else {
            String optString = optJSONObject.optString("tag");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("material_meta");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("download_conf");
                r5 = optJSONObject3 != null ? optJSONObject3.optInt("enable_notification", 0) : 0;
                str4 = optJSONObject2.optString(MediationConstant.EXTRA_ADID);
            }
            if (TextUtils.isEmpty(logExtra)) {
                logExtra = optJSONObject2.optString(n.m);
            }
            str3 = str4;
            str2 = optString;
            i = r5;
            str = logExtra;
        }
        return new com.bytedance.sdk.openadsdk.core.pl.y().xj(name, appIcon, packageName, str, i, str2, str3);
    }

    private boolean xj(f fVar) {
        JSONObject u;
        if (fVar == null || (u = fVar.u()) == null) {
            return false;
        }
        String optString = u.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
        if (TextUtils.isEmpty(optString)) {
            return false;
        }
        try {
            return new JSONObject(optString).optJSONObject(com.bytedance.sdk.openadsdk.core.pl.xj.tf.EXTRA_DOWN_INFO_KEY) != null;
        } catch (Throwable unused) {
            return false;
        }
    }
}
