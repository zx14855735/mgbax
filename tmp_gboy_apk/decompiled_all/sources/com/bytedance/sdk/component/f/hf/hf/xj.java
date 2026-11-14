package com.bytedance.sdk.component.f.hf.hf;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.f.xj.kd;
import com.bytedance.sdk.component.f.xj.y;
import com.ss.android.download.api.constant.BaseConstants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static long hf(int i, Context context, kd kdVar) {
        if (context == null) {
            return i;
        }
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.freeMemory() / BaseConstants.MB_VALUE;
        long maxMemory = (runtime.maxMemory() / BaseConstants.MB_VALUE) - (runtime.totalMemory() / BaseConstants.MB_VALUE);
        if (maxMemory <= 0) {
            if (freeMemory <= 2) {
                return 1L;
            }
            return freeMemory <= 10 ? Math.min(i, 10) : Math.min((freeMemory / 2) * 10, i);
        }
        long j = ((freeMemory + maxMemory) - 10) / 2;
        if (j <= 2) {
            return 1L;
        }
        return j <= 10 ? Math.min(i, 10) : Math.min(j * 10, i);
    }

    public static boolean kd(kd kdVar) {
        y hf = kdVar.hf();
        return (hf == null || TextUtils.isEmpty(hf.w())) ? false : true;
    }

    public static boolean u(kd kdVar) {
        y hf = kdVar.hf();
        return (hf == null || TextUtils.isEmpty(hf.kd())) ? false : true;
    }

    public static boolean w(kd kdVar) {
        y hf = kdVar.hf();
        return (hf == null || TextUtils.isEmpty(hf.u())) ? false : true;
    }

    public static long xj(int i, Context context, kd kdVar) {
        return hf(i, context, kdVar);
    }

    public static boolean y(kd kdVar) {
        y hf = kdVar.hf();
        return (hf == null || TextUtils.isEmpty(hf.y())) ? false : true;
    }

    public static boolean xj(kd kdVar) {
        y hf = kdVar.hf();
        return (hf == null || TextUtils.isEmpty(hf.xj())) ? false : true;
    }

    public static boolean hf(kd kdVar) {
        y hf = kdVar.hf();
        return (hf == null || TextUtils.isEmpty(hf.hf())) ? false : true;
    }
}
