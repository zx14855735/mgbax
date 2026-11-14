package com.bytedance.sdk.openadsdk.core.nativeexpress.hf;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.u.tf;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.czhj.sdk.common.Constants;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class xj {

    /* renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.hf.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0174xj {
        com.bytedance.sdk.component.adexpress.xj.hf.xj xj(String str, tf.xj xjVar, String str2);

        boolean xj();
    }

    public static com.bytedance.sdk.component.adexpress.xj.hf.xj xj(WebView webView, ws wsVar, String str, InterfaceC0174xj interfaceC0174xj) {
        z zVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        tf.xj xj = tf.xj(str);
        boolean z = interfaceC0174xj != null && interfaceC0174xj.xj();
        if (xj != tf.xj.IMAGE && z && wsVar != null) {
            Iterator<z> it = wsVar.lx().iterator();
            while (it.hasNext()) {
                zVar = it.next();
                if (!TextUtils.isEmpty(zVar.xj()) && !TextUtils.isEmpty(str)) {
                    String xj2 = zVar.xj();
                    if (xj2.startsWith("https")) {
                        xj2 = xj2.replaceFirst("https", Constants.HTTP);
                    }
                    if ((str.startsWith("https") ? str.replaceFirst("https", Constants.HTTP) : str).equals(xj2)) {
                        break;
                    }
                }
            }
        }
        zVar = null;
        if (xj == tf.xj.IMAGE) {
            com.bytedance.sdk.component.adexpress.xj.hf.xj xjVar = new com.bytedance.sdk.component.adexpress.xj.hf.xj();
            xjVar.xj(5);
            xjVar.xj(xj(str, hf.hf(wsVar, str)));
            return xjVar;
        }
        if (zVar == null) {
            if (interfaceC0174xj == null) {
                return null;
            }
            return interfaceC0174xj.xj(str, xj, "");
        }
        com.bytedance.sdk.component.adexpress.xj.hf.xj xjVar2 = new com.bytedance.sdk.component.adexpress.xj.hf.xj();
        xjVar2.xj(xj(str, zVar.c()));
        xjVar2.xj(5);
        return xjVar2;
    }

    private static WebResourceResponse xj(String str, String str2) {
        WebResourceResponse webResourceResponse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream xj = com.bytedance.sdk.openadsdk.f.hf.xj(str, str2);
            if (xj == null) {
                return null;
            }
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(tf.xj.IMAGE.getType(), "utf-8", xj);
            try {
                Map<String, String> responseHeaders = webResourceResponse2.getResponseHeaders();
                if (responseHeaders == null) {
                    responseHeaders = new HashMap<>();
                }
                responseHeaders.put("Access-Control-Allow-Origin", "*");
                webResourceResponse2.setResponseHeaders(responseHeaders);
                return webResourceResponse2;
            } catch (Throwable th) {
                th = th;
                webResourceResponse = webResourceResponse2;
                pl.w("CacheInterceptUtil", "get image WebResourceResponse error", th);
                return webResourceResponse;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
