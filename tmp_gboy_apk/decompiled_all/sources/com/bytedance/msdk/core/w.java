package com.bytedance.msdk.core;

import android.text.TextUtils;
import com.bytedance.msdk.f.en;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static String hf;
    private static String xj;

    public static String hf() {
        return en.xj("https://" + hf.hf().p());
    }

    private static String kd() {
        String y = y();
        return !TextUtils.isEmpty(y) ? y : "https://gromore.pangolin-sdk-toutiao.com";
    }

    public static String u() {
        return en.xj(kd() + "/api/ad/union/mediation/reward_video/reward/");
    }

    public static String w() {
        return en.xj(kd() + "/api/ad/union/mediation/exchange/");
    }

    public static String xj() {
        return en.xj(kd() + "/api/ad/union/mediation/config/");
    }

    private static String y() {
        String hf2 = com.bytedance.msdk.c.xj.xj().hf("server_dist_host");
        if (TextUtils.isEmpty(hf2)) {
            return null;
        }
        if (TextUtils.equals(hf2, xj) && !TextUtils.isEmpty(hf)) {
            return hf;
        }
        xj = hf2;
        hf = null;
        if (!TextUtils.isEmpty(hf2)) {
            hf = com.bytedance.msdk.f.xj.hf(xj, com.bytedance.msdk.f.hf.xj());
        }
        if (TextUtils.isEmpty(hf)) {
            return null;
        }
        String str = "https://" + hf;
        hf = str;
        return str;
    }
}
