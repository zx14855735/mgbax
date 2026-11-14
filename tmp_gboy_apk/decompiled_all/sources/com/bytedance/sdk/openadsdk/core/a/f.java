package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f {
    public static boolean xj() {
        if (com.bytedance.sdk.openadsdk.core.f.zg().hl()) {
            return true;
        }
        Context context = com.bytedance.sdk.openadsdk.core.pz.getContext();
        if (context.getApplicationInfo() != null) {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    public static void xj(com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar) {
        try {
            if (!xjVar.f() || com.bytedance.sdk.component.utils.pl.xj()) {
                return;
            }
            System.currentTimeMillis();
            if (Boolean.parseBoolean(new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop debug.ttcsj.debugmode").getInputStream())).readLine())) {
                com.bytedance.sdk.component.utils.pl.hf();
                com.bykv.vk.openvk.component.video.api.y.w.xj();
                com.bytedance.sdk.component.d.xj.xj();
                com.bytedance.sdk.openadsdk.tools.hf.hf();
                com.bytedance.sdk.component.pl.hf.xj.xj(true);
            }
        } catch (Exception unused) {
        }
    }
}
