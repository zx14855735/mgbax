package com.octopus.ad.utils.b;

import android.content.Context;
import android.text.TextUtils;
import com.octopus.ad.Octopus;
import com.octopus.ad.internal.utilities.SPUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g {
    public static String a(Context context) {
        String b;
        return (context == null || (b = com.octopus.ad.utils.a.b.b(context)) == null) ? "" : b;
    }

    public static String b(Context context) {
        String c;
        return (context == null || !(Octopus.getCustomController() == null || Octopus.getCustomController().isCanUseOaid()) || (c = com.octopus.ad.utils.a.b.c(context)) == null) ? "" : c;
    }

    public static String c(Context context) {
        String str;
        return (context == null || Octopus.isLimitPersonalAds() || (str = (String) SPUtils.getFromGroupSdk(context, "__GAID__", com.octopus.ad.utils.a.b.d(context))) == null) ? "" : str;
    }

    public static String a() {
        if (Octopus.getCustomController() != null) {
            String oaid = Octopus.getCustomController().getOaid();
            if (!TextUtils.isEmpty(oaid)) {
                com.octopus.ad.utils.a.f.b("Oaid is Outside Input: " + oaid);
                return oaid;
            }
            return "";
        }
        return "";
    }
}
