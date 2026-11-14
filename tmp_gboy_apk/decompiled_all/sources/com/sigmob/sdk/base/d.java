package com.sigmob.sdk.base;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.baidu.mobads.sdk.internal.an;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.logger.SigmobLogger;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    static e f13168a = null;
    private static final String b = "d";

    static {
        try {
            if (o.a().ac()) {
                f13168a = new f();
            }
        } catch (Throwable unused) {
        }
        if (f13168a == null) {
            f13168a = new e();
        }
    }

    public static WebResourceResponse a(Uri uri) {
        return null;
    }

    public static WebResourceResponse a(String str, String str2, Map<String, String> map) {
        e eVar;
        if ((!URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str)) || str2.equals(an.b) || (eVar = f13168a) == null) {
            return null;
        }
        try {
            return eVar.a(str, str2, map);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean a(String str) {
        Uri parse;
        String host;
        String scheme;
        String lastPathSegment;
        try {
            parse = Uri.parse(str);
            host = parse.getHost();
            scheme = parse.getScheme();
            lastPathSegment = parse.getLastPathSegment();
        } catch (Throwable th) {
            SigmobLogger.e(b, J3FDQU.A2egSU.B4ZgIw(th, new StringBuilder("filterUrl: error = ")), new Object[0]);
        }
        if (host == null || l.a(str) || !scheme.startsWith(Constants.HTTP) || host.equals("localhost") || host.equals("127.0.0.1") || !TextUtils.isEmpty(parse.getQueryParameter("no-cache"))) {
            return true;
        }
        if (!lastPathSegment.endsWith(".js")) {
            if (!lastPathSegment.endsWith(".css")) {
                return true;
            }
        }
        return false;
    }
}
