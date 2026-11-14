package com.bytedance.sdk.openadsdk.core.live.kd;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.j;
import com.bytedance.sdk.openadsdk.core.f;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private static com.bytedance.sdk.component.u.hf.w xj;

    private static void hf() {
        if (xj == null) {
            xj = j.xj("csj_live");
        }
    }

    public static void u(String str) {
        xj();
        hf(str);
    }

    public static boolean w(String str) {
        hf();
        com.bytedance.sdk.component.u.hf.w wVar = xj;
        return (wVar != null ? wVar.get("live_init_".concat(String.valueOf(str)), 0) : 0) < 5;
    }

    public static void xj(String str) {
        hf();
        try {
            com.bytedance.sdk.component.u.hf.w wVar = xj;
            if (wVar != null) {
                xj.put("live_init_".concat(String.valueOf(str)), wVar.get("live_init_".concat(String.valueOf(str)), 0) + 1);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public static void hf(String str) {
        hf();
        try {
            com.bytedance.sdk.component.u.hf.w wVar = xj;
            if (wVar != null) {
                wVar.put("live_init_".concat(String.valueOf(str)), 0);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public static void xj() {
        try {
            Function<SparseArray<Object>, Object> y = f.zg().y(4);
            if (y != null) {
                y.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(100).xj(Void.class).xj(0, "com.byted.live.lite").hf());
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }
}
