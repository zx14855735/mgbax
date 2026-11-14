package com.bytedance.sdk.openadsdk.core.pl.w;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class tf {
    public static String hf(ws wsVar) {
        if (wsVar == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.ra.kd vh = wsVar.vh();
        return (vh == null || TextUtils.isEmpty(vh.w())) ? !TextUtils.isEmpty(wsVar.ci()) ? wsVar.ci() : !TextUtils.isEmpty(wsVar.uj()) ? wsVar.uj() : !TextUtils.isEmpty(wsVar.fh()) ? wsVar.fh() : "" : vh.w();
    }

    public static boolean u(ws wsVar) {
        com.bytedance.sdk.openadsdk.core.ra.y ut = wsVar.ut();
        return (ut == null || TextUtils.isEmpty(ut.am()) || TextUtils.isEmpty(ut.kd()) || TextUtils.isEmpty(ut.c()) || ut.xj() == null || ut.xj().size() <= 0 || TextUtils.isEmpty(ut.f()) || TextUtils.isEmpty(ut.d())) ? false : true;
    }

    public static boolean w(ws wsVar) {
        if (wsVar == null) {
            return false;
        }
        return u(wsVar);
    }

    public static int xj(ws wsVar) {
        if (wsVar == null || wsVar.ey() != 1) {
            return 0;
        }
        if (wsVar.zm() == 0) {
            return 1;
        }
        return wsVar.zm() == 1 ? w(wsVar) ? 0 : 1 : wsVar.zm() == 2 ? 2 : 1;
    }

    public static void xj(final Context context) {
        if (context == null) {
            context = pz.getContext();
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            x.xj(context, "应用信息缺失，暂无法响应下载", 1);
        } else {
            v.y().post(new com.bytedance.sdk.component.tf.d("tt_download_toast") { // from class: com.bytedance.sdk.openadsdk.core.pl.w.tf.1
                @Override // java.lang.Runnable
                public void run() {
                    x.xj(context, "应用信息缺失，暂无法响应下载", 1);
                }
            });
        }
    }
}
