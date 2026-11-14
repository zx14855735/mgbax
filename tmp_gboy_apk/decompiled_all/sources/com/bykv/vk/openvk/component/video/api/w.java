package com.bykv.vk.openvk.component.video.api;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.hf.xj.pl;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static Context hf = null;
    private static pl kd = null;
    private static boolean u = false;
    private static String w = null;
    public static boolean xj = false;
    private static int y = 1;

    public static Context getContext() {
        return hf;
    }

    public static boolean hf() {
        return u;
    }

    public static int kd() {
        return y;
    }

    public static boolean u() {
        return xj;
    }

    public static pl w() {
        if (kd == null) {
            pl.xj xjVar = new pl.xj("v_config");
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            kd = xjVar.xj(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).hf(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).w(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).xj();
        }
        return kd;
    }

    public static String xj() {
        if (TextUtils.isEmpty(w)) {
            try {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.hf.xj(getContext()), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                w = file.getAbsolutePath();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.xj(th);
            }
        }
        return w;
    }

    public static void xj(Context context, String str) {
        hf = context;
        w = str;
    }

    public static void xj(boolean z) {
        u = z;
    }

    public static void xj(pl plVar) {
        kd = plVar;
    }
}
