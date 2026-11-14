package com.kwad.sdk.a.a;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class d {
    public static String EM() {
        String HN = com.kwad.sdk.core.config.e.HN();
        return TextUtils.isEmpty(HN) ? "安装" : HN;
    }

    public static String EN() {
        String HO = com.kwad.sdk.core.config.e.HO();
        return TextUtils.isEmpty(HO) ? "取消" : HO;
    }

    public static String G(AdInfo adInfo) {
        return com.kwad.sdk.core.config.e.HM().replace("[appname]", adInfo.adBaseInfo.appName).replace("[appsize]", com.kwad.components.core.s.e.a(adInfo.adBaseInfo.packageSize, true)).replace("[appver]", adInfo.adBaseInfo.appVersion);
    }
}
