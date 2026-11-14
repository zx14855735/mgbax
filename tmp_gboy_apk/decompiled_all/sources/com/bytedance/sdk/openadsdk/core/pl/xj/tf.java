package com.bytedance.sdk.openadsdk.core.pl.xj;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.pl.xj.y;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class tf implements ITTDownloadVisitor {
    public static final String EXTRA_DOWN_INFO_KEY = "open_ad_sdk_download_extra";

    private tf() {
    }

    public static ITTDownloadVisitor create() {
        return new tf();
    }

    private boolean isPangolinDownloadReport(TTDownloadEventModel tTDownloadEventModel) {
        JSONObject extJson;
        if (tTDownloadEventModel == null || (extJson = tTDownloadEventModel.getExtJson()) == null) {
            return false;
        }
        String optString = extJson.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
        if (TextUtils.isEmpty(optString)) {
            return false;
        }
        try {
            return new JSONObject(optString).optJSONObject(EXTRA_DOWN_INFO_KEY) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void checkAutoControl(JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.pl.w.hf.xj xj;
        ws wsVar;
        JSONObject optJSONObject = jSONObject.optJSONObject(EXTRA_DOWN_INFO_KEY);
        if (optJSONObject == null || !r.xj() || (xj = com.bytedance.sdk.openadsdk.core.pl.w.hf.xj.xj(optJSONObject)) == null || (wsVar = xj.xj) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.pl.d.xj(str, wsVar);
    }

    public void clearAllData(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.y.w(new File(str));
    }

    public void execute(int i, String str, Map<String, Object> map, ITTHttpCallback iTTHttpCallback) {
        c.execute(i, str, map, iTTHttpCallback);
    }

    public void executeLogUpload(TTDownloadEventModel tTDownloadEventModel, boolean z) {
        if (isPangolinDownloadReport(tTDownloadEventModel)) {
            try {
                com.bytedance.sdk.component.tf.c.xj(y.xj.build(tTDownloadEventModel, z), 5);
            } catch (Throwable unused) {
            }
        }
    }

    public boolean getAppIsBackground() {
        return com.bytedance.sdk.openadsdk.core.f.zg().xj();
    }

    public JSONObject getDownloadSettings() {
        JSONObject hf = com.bytedance.sdk.openadsdk.core.pl.d.hf();
        try {
            if (!pz.hf().x()) {
                hf.put("enable_app_install_receiver", 0);
            }
        } catch (Exception unused) {
        }
        return hf;
    }

    public TTDownloadEventLogger getTTDownloadEventLogger() {
        return null;
    }

    public boolean hasPermission(Context context, String str) {
        return d.hasPermission(context, str);
    }

    public String initPath(boolean z) {
        return com.bytedance.sdk.openadsdk.core.pl.d.xj(z);
    }

    public boolean isOpenSdkEvent(String str) {
        return com.bytedance.sdk.openadsdk.core.pl.u.d.xj(str);
    }

    public void postBody(String str, byte[] bArr, String str2, ITTHttpCallback iTTHttpCallback) {
        c.postBody(str, bArr, str2, 0, iTTHttpCallback);
    }

    public void requestPermission(Activity activity, String[] strArr, ITTPermissionCallback iTTPermissionCallback) {
        d.requestPermission(activity, strArr, iTTPermissionCallback);
    }

    public void showDialogByDelegate(WeakReference<Context> weakReference, boolean z, DialogBuilder dialogBuilder) {
        f.showDialogByDelegate(weakReference, z, dialogBuilder);
    }

    public AlertDialog showDialogBySelf(Activity activity, boolean z, DialogBuilder dialogBuilder) {
        return f.showDialogBySelf(activity, z, dialogBuilder);
    }
}
