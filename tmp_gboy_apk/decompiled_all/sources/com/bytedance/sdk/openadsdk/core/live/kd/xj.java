package com.bytedance.sdk.openadsdk.core.live.kd;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.zg;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public static boolean xj(ws wsVar) {
        if (wsVar == null) {
            return false;
        }
        return xj(wsVar.yt());
    }

    public static boolean xj(zg zgVar) {
        if (zgVar == null) {
            return false;
        }
        String hf = zgVar.hf();
        if (TextUtils.isEmpty(hf)) {
            return false;
        }
        return hf.startsWith("snssdk2329") || hf.startsWith("snssdk1128");
    }

    public static boolean xj(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith("snssdk1128")) {
            return wo.xj("com.ss.android.ugc.aweme");
        }
        if (str.startsWith("snssdk2329")) {
            return wo.xj("com.ss.android.ugc.aweme.lite");
        }
        return false;
    }
}
