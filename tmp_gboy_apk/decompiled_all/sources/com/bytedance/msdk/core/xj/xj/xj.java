package com.bytedance.msdk.core.xj.xj;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static y hf;
    private static y w;
    private static y xj;

    public static boolean hf(String str) {
        return TextUtils.equals(str, "gdt") || TextUtils.equals(str, "ks") || TextUtils.equals(str, MediationConstant.ADN_XIAOMI);
    }

    public static y xj(String str) {
        if (TextUtils.equals(str, "gdt")) {
            if (xj == null) {
                xj = new hf();
            }
            return xj;
        }
        if (TextUtils.equals(str, "ks")) {
            if (hf == null) {
                hf = new w();
            }
            return hf;
        }
        if (!TextUtils.equals(str, MediationConstant.ADN_XIAOMI)) {
            return null;
        }
        if (w == null) {
            w = new u();
        }
        return w;
    }

    public static void xj(Map<String, Object> map) {
        if (map != null) {
            y yVar = xj;
            if (yVar != null && !TextUtils.isEmpty(yVar.c())) {
                map.put("unsupported_gdt_version", xj.c());
                xj.xj((String) null);
            }
            y yVar2 = hf;
            if (yVar2 != null && !TextUtils.isEmpty(yVar2.c())) {
                map.put("unsupported_ks_version", hf.c());
                hf.xj((String) null);
            }
            y yVar3 = w;
            if (yVar3 == null || TextUtils.isEmpty(yVar3.c())) {
                return;
            }
            map.put("unsupported_xiaomi_version", w.c());
            w.xj((String) null);
        }
    }
}
