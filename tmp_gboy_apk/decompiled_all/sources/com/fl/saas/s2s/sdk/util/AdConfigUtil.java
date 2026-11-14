package com.fl.saas.s2s.sdk.util;

import android.content.Context;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.util.FLUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdConfigUtil {
    public static int getClickType(Context context, AdInfoPoJo adInfoPoJo) {
        if (context != null && adInfoPoJo != null) {
            FLUtils.TypeBean type = FLUtils.getType(context, adInfoPoJo.click_value);
            adInfoPoJo.cbr = type.getReason();
            return type.getType();
        }
        if (adInfoPoJo == null) {
            return 1;
        }
        adInfoPoJo.cbr = "empty";
        return 1;
    }
}
