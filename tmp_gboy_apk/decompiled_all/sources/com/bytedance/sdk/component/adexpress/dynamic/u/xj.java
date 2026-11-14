package com.bytedance.sdk.component.adexpress.dynamic.u;

import ADYaiT.CtFAbx;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public static String xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/images/");
        if (str.indexOf(".") <= 0) {
            return CtFAbx.B25kr6(sb, str, ".png");
        }
        sb.append(str);
        return sb.toString();
    }
}
