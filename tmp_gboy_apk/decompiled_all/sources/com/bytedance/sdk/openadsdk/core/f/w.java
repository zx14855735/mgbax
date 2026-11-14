package com.bytedance.sdk.openadsdk.core.f;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.pz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    public static String xj(String str) {
        String zg = pz.hf().zg();
        return TextUtils.isEmpty(zg) ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/".concat(String.valueOf(str)) : CtFAbx.AcNBzu(zg, str);
    }
}
