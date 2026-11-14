package com.bykv.vk.openvk.component.video.xj;

import android.content.Context;
import android.os.Build;
import com.baidu.mobads.sdk.internal.bn;
import com.bykv.vk.openvk.component.video.api.xj.hf;
import com.bykv.vk.openvk.component.video.api.y.w;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.model.AdnName;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public static int hf = 10;
    private static hf kd = null;
    public static int u = 10;
    public static int w = 10;
    public static int xj = 10;

    public static int hf() {
        return xj;
    }

    public static int kd() {
        return u;
    }

    public static int u() {
        return w;
    }

    public static int w() {
        return hf;
    }

    public static void xj(Context context) {
        com.bykv.vk.openvk.component.video.api.y.xj.xj(context);
        if (Build.VERSION.SDK_INT < 23) {
            com.bykv.vk.openvk.component.video.xj.hf.y.xj.xj();
        }
    }

    public static void xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            xj = jSONObject.optInt(MediationConstant.RIT_TYPE_SPLASH, 10);
            hf = jSONObject.optInt("reward", 10);
            w = jSONObject.optInt(bn.j, 10);
            int optInt = jSONObject.optInt(AdnName.OTHER, 10);
            u = optInt;
            if (xj < 0) {
                xj = 10;
            }
            if (hf < 0) {
                hf = 10;
            }
            if (w < 0) {
                w = 10;
            }
            if (optInt < 0) {
                u = 10;
            }
            w.xj("MediaConfig", "splash=", Integer.valueOf(xj), ",reward=", Integer.valueOf(hf), ",brand=", Integer.valueOf(w), ",other=", Integer.valueOf(u));
        } catch (Throwable th) {
            w.w("MediaConfig", th.getMessage());
        }
    }

    public static void xj(hf hfVar) {
        kd = hfVar;
    }

    public static void xj() {
        hf hfVar = kd;
        if (hfVar != null) {
            hfVar.kd();
        }
    }
}
