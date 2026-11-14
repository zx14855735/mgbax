package com.kwad.sdk.core.webview.b.c;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.utils.aa;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    public static final Map<String, JSONObject> aSA = new HashMap();
    public static boolean aSB = true;

    public static class a {
        public String msg;
    }

    static {
        VECdB();
    }

    private static /* synthetic */ void VECdB() {
        char[] charArray = "\u0086\u008a\u0088Ë\u0082\u0084\u0088\u0080Ë\u0087\u008a\u009cË\u0096\u008d\u0080\u0089\u0089Ë¯\u008b\u008c§\u0097\u008c\u0081\u0082\u0080".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 229);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0086\u0089\u008c\u008b\u008c\u0091".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 229);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void a(com.kwad.sdk.h.a.b bVar, int i) {
        com.kwad.sdk.commercial.c.a(ILoggerReporter.Category.APM_LOG, new HybridLoadMsg().setSceneId(bVar.aWm).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(i).setPackageUrl(bVar.packageUrl).setInterval(String.valueOf(System.currentTimeMillis() - bVar.Ok())));
    }

    public static void af(String str, String str2) {
        aa.putValue(ft(str), CtFAbx.BChYOn("c_", str2), System.currentTimeMillis());
    }

    private static void ag(String str, String str2) {
        a(str, str2, 1, "");
    }

    public static void ah(String str, String str2) {
        a(str, "", 2, str2);
    }

    public static void c(String str, String str2, String str3) {
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        aa.putValue(ft(str), CtFAbx.AmA8tU("c_responseStart_", str2, "_", str3), System.currentTimeMillis());
    }

    public static void d(String str, String str2, String str3) {
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        aa.putValue(ft(str), CtFAbx.AmA8tU("c_responseEnd_", str2, "_", str3), System.currentTimeMillis());
    }

    private static JSONObject ft(String str) {
        Map<String, JSONObject> map = aSA;
        JSONObject jSONObject = map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        map.put(str, jSONObject2);
        return jSONObject2;
    }

    private static void fu(String str) {
        aSA.remove(str);
    }

    public static void fv(String str) {
        JSONObject ft = ft(str);
        long uB = com.kwad.sdk.core.webview.b.a.MN().uB();
        long currentTimeMillis = uB <= 0 ? -1L : System.currentTimeMillis() - uB;
        aa.putValue(ft, "c_loadUrl", System.currentTimeMillis());
        aa.putValue(ft, "c_init_interval", currentTimeMillis);
        aa.putValue(ft, "c_init_state", aSB ? 1 : 2);
        aSB = false;
    }

    public static void a(com.kwad.sdk.h.a.b bVar, int i, int i2, String str) {
        com.kwad.sdk.commercial.c.a(ILoggerReporter.Category.ERROR_LOG, new HybridLoadMsg().setSceneId(bVar.aWm).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(0).setPackageUrl(bVar.packageUrl).setFailState(i2).setInterval(String.valueOf(System.currentTimeMillis() - bVar.Ok())).setFailReason(str));
    }

    public static void a(String str, String str2, int i, String str3, long j) {
        String str4;
        if (i == 2) {
            str4 = ILoggerReporter.Category.ERROR_LOG;
        } else {
            str4 = ILoggerReporter.Category.APM_LOG;
        }
        if (j > 60000 || j < 0) {
            j = -1;
        }
        com.kwad.sdk.commercial.c.b(str4, new HybridLoadMsg().setSceneId(str2).setUrl(str).setState(i).setInterval(String.valueOf(j)).setFailReason(str3));
    }

    public static void a(String str, String str2, String str3, String str4) {
        JSONObject ft = ft(str2);
        aa.putValue(ft, CtFAbx.BChYOn("c_", str3), System.currentTimeMillis());
        if (str3.equals("pageStatus")) {
            try {
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    int optInt = jSONObject.optInt("status");
                    String optString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG, "");
                    String optString2 = jSONObject.optString("webViewCostParams", "");
                    if (!TextUtils.isEmpty(optString2)) {
                        JSONObject jSONObject2 = new JSONObject(optString2);
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            ft.put(next, jSONObject2.opt(next));
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        if (optInt == 1) {
                            ag(str, str2);
                        } else {
                            ah(str, optString);
                        }
                    }
                    fu(str2);
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                    fu(str2);
                }
            } catch (Throwable th) {
                fu(str2);
                throw th;
            }
        }
    }

    private static void a(String str, String str2, int i, String str3) {
        long currentTimeMillis;
        String str4;
        JSONObject jSONObject = aSA.get(str2);
        if (jSONObject == null) {
            currentTimeMillis = -3;
        } else {
            long optLong = jSONObject.optLong("c_loadUrl");
            if (optLong <= 0) {
                currentTimeMillis = -2;
            } else {
                currentTimeMillis = System.currentTimeMillis() - optLong;
                if (currentTimeMillis > 100000 || currentTimeMillis < 0) {
                    currentTimeMillis = -1;
                }
            }
        }
        if (i == 2) {
            str4 = ILoggerReporter.Category.ERROR_LOG;
        } else {
            str4 = ILoggerReporter.Category.APM_LOG;
        }
        com.kwad.sdk.commercial.c.a(str4, new WebViewLoadMsg().setUrl(str).setState(i).setCostTime(jSONObject != null ? jSONObject.toString() : "").setInterval(String.valueOf(currentTimeMillis)).setFailReason(str3));
        fu(str2);
    }
}
