package com.bytedance.sdk.gromore.init;

import android.os.Bundle;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.q;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public static q hf() {
        return DispatchAdSdkInitializerHolder.getCsjManger();
    }

    public static boolean kd() {
        return DispatchAdSdkInitializerHolder.isInitSuccess();
    }

    public static String u() {
        return "7.1.3.2";
    }

    public static String w() {
        return ai.u;
    }

    public static int xj() {
        return ai.w;
    }

    public static void xj(int i) {
        q hf = hf();
        if (hf != null) {
            hf.xj(i);
        }
    }

    public static void xj(boolean z) {
        q hf = hf();
        if (hf == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        hf.xj(SparseArray.class, bundle);
    }
}
