package com.sigmob.sdk.base.utils;

import ADYaiT.CtFAbx;
import android.util.Base64;
import android.webkit.WebSettings;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLogger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class h {
    public static void a(String str, WebSettings webSettings) {
        a(str, webSettings, com.sigmob.sdk.base.n.D);
        a(str, webSettings, com.sigmob.sdk.base.n.F);
    }

    public static void a(String str, WebSettings webSettings, String str2) {
        try {
            ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(webSettings, new String(Base64.decode(str2, 2)));
            methodBuilder.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder.execute();
        } catch (Exception e) {
            SigmobLogger.e(str, CtFAbx.AZOQYO(e, new StringBuilder("executeJsMethod: error = ")), new Object[0]);
        }
    }
}
