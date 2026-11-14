package com.kwad.sdk.core.webview.b;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import com.baidu.mobads.sdk.internal.cb;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.webview.b.c.b;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.w;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    private static final Map<String, com.kwad.sdk.core.webview.b.a.b> aSp = new ConcurrentHashMap();
    private static final Map<String, String> aSq = new ConcurrentHashMap();

    static {
        RmAtzi();
    }

    private static /* synthetic */ void RmAtzi() {
        char[] charArray = "ÝÑÓ\u0090ÙßÓÛ\u0090ÜÑÇ\u0090ÍÖÛÒÒ\u0090ôÐ×üÌ×ÚÙÛ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 190);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÝÒ×Ð×Ê".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 190);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static WebResourceResponse a(Context context, String str, com.kwad.sdk.h.a.b bVar, b.a aVar, boolean z) {
        com.kwad.sdk.core.webview.b.a.b bVar2;
        try {
            bVar2 = a(context, bVar, str, aVar);
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            aVar.msg = "获取配置文件失败 崩溃" + Log.getStackTraceString(e);
            bVar2 = null;
        }
        if (bVar2 == null) {
            b(z, aVar.msg);
            if (TextUtils.isEmpty(aVar.msg)) {
                aVar.msg = "获取配置文件失败";
            }
            return null;
        }
        if (TextUtils.isEmpty(bVar2.aSx)) {
            b(z, CtFAbx.BI9f7h("getResource [", str, "] getFilePath from url fail"));
            aVar.msg = "getFilePath from url fail";
            return null;
        }
        if (!com.kwad.sdk.core.webview.b.c.c.fw(bVar2.aSt)) {
            b(z, CtFAbx.B25kr6(new StringBuilder("mimetype为: "), bVar2.aSt, "不在拦截范围的文件"));
            aVar.msg = CtFAbx.B25kr6(new StringBuilder("mimetype为: "), bVar2.aSt, "不在拦截范围的文件");
            return null;
        }
        BufferedInputStream hf = w.hf(bVar2.aSx);
        if (hf != null) {
            return a(hf, bVar2);
        }
        b(z, CtFAbx.BI9f7h("getResource [", str, "] inputStream is null"));
        aVar.msg = "inputStream is null,本地加载路径：" + bVar2.aSx;
        return null;
    }

    private static String ad(String str, String str2) {
        StringBuilder A4TApA2 = AYUAbz.A4TApA(str);
        A4TApA2.append(Uri.parse(str2).getPath());
        return A4TApA2.toString();
    }

    private static void ae(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        aSq.put(str, str2);
    }

    private static void b(boolean z, String str) {
        if (z) {
            return;
        }
        c.d("HybridResourceManager", str);
    }

    private static com.kwad.sdk.core.webview.b.a.b fo(String str) {
        return aSp.get(String.valueOf(str.hashCode()));
    }

    private static String fp(String str) {
        return aSq.get(str);
    }

    private static WebResourceResponse a(InputStream inputStream, com.kwad.sdk.core.webview.b.a.b bVar) {
        String str = bVar.aSt;
        HashMap hashMap = new HashMap();
        hashMap.put("Access-Control-Allow-Origin", bVar.aSw.aSr);
        hashMap.put("Access-Control-Allow-Credentials", "true");
        hashMap.put("Timing-Allow-Origin", bVar.aSw.aSs);
        hashMap.put("content-type", str);
        hashMap.put("Date", bVar.aSw.aSu);
        hashMap.put("union-cache ", "1");
        return new WebResourceResponse(bVar.aSt, "", bVar.status, cb.k, hashMap, inputStream);
    }

    private static com.kwad.sdk.core.webview.b.a.b a(Context context, com.kwad.sdk.h.a.b bVar, String str, b.a aVar) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream = null;
        try {
            String fp = fp(bVar.aWm);
            com.kwad.sdk.core.webview.b.a.b fo = !TextUtils.isEmpty(fp) ? fo(ad(fp, str)) : null;
            if (fo != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return fo;
            }
            String M = com.kwad.sdk.core.webview.b.c.a.M(context, bVar.aWn);
            if (M == null) {
                aVar.msg = "获取配置文件失败 offlinepackage 为空";
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            File file = new File(M);
            if (!file.exists()) {
                aVar.msg = "获取配置文件失败 下载文件路径不存在 ".concat(M);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream2);
                try {
                    String b = h.b(inputStreamReader);
                    if (TextUtils.isEmpty(b)) {
                        aVar.msg = "获取配置文件失败 mainfest文件不存在";
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(b);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                        com.kwad.sdk.core.webview.b.a.b bVar2 = new com.kwad.sdk.core.webview.b.a.b();
                        bVar2.parseJson(jSONObject2);
                        String host = Uri.parse("https://" + next).getHost();
                        bVar2.aSy = host;
                        bVar2.aSx = com.kwad.sdk.core.webview.b.c.a.L(context, bVar.aWn) + "/" + next;
                        if (TextUtils.isEmpty(bVar2.aSt)) {
                            bVar2.aSt = URLConnection.getFileNameMap().getContentTypeFor(bVar2.aSx);
                        }
                        a(next, bVar2);
                        fp = host;
                    }
                    ae(bVar.aWm, fp);
                    com.kwad.sdk.core.webview.b.a.b fo2 = fo(ad(fp, str));
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    return fo2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }

    private static void a(String str, com.kwad.sdk.core.webview.b.a.b bVar) {
        aSp.put(String.valueOf(str.hashCode()), bVar);
    }
}
