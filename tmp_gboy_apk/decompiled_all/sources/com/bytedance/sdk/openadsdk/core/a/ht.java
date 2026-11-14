package com.bytedance.sdk.openadsdk.core.a;

import com.bytedance.sdk.openadsdk.core.ra.tu;
import com.bytedance.sdk.openadsdk.core.ra.vm;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ht {
    public static boolean c(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        return f(wsVar) == 3;
    }

    private static int f(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (com.bytedance.sdk.openadsdk.core.ra.v.xj(wsVar)) {
            return 3;
        }
        return tu.xj(wsVar) ? 4 : 0;
    }

    public static boolean hf(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        return (wsVar == null || f(wsVar) == 0) ? false : true;
    }

    public static int kd(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (wsVar != null && f(wsVar) == 3) {
            return com.bytedance.sdk.openadsdk.core.ra.v.d(wsVar);
        }
        return 0;
    }

    public static boolean u(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        return wsVar != null && f(wsVar) == 4;
    }

    public static boolean w(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (wsVar == null || vm.xj(wsVar) || f(wsVar) != 3) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.core.ra.v.xj(wsVar);
    }

    public static String xj(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (wsVar == null) {
            return "";
        }
        int f = f(wsVar);
        return f != 3 ? f != 4 ? "" : tu.kd(wsVar) : com.bytedance.sdk.openadsdk.core.ra.v.y(wsVar);
    }

    public static int y(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (wsVar == null) {
            return -1;
        }
        if (f(wsVar) != 3) {
            return 0;
        }
        return com.bytedance.sdk.openadsdk.core.ra.v.tf(wsVar);
    }
}
