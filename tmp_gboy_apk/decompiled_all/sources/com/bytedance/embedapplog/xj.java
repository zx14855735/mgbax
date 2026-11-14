package com.bytedance.embedapplog;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.embedapplog.collector.Collector;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class xj {
    private static boolean c = false;
    private static volatile u f = null;
    public static boolean hf = true;

    @SuppressLint({"StaticFieldLeak"})
    private static volatile wn kd = null;
    public static hf u = null;
    public static ConcurrentHashMap<String, String> w = new ConcurrentHashMap<>(4);

    @SuppressLint({"StaticFieldLeak"})
    public static aq xj = null;
    private static boolean y = true;

    static {
        hySDklx();
    }

    public static String c() {
        aq aqVar = xj;
        return aqVar != null ? aqVar.f() : "";
    }

    public static String d() {
        aq aqVar = xj;
        return aqVar != null ? aqVar.c() : "";
    }

    public static boolean f() {
        return true;
    }

    public static f g() {
        if (kd != null) {
            return kd.hl();
        }
        return null;
    }

    public static void hf() {
        a.xj();
    }

    private static /* synthetic */ void hySDklx() {
        char[] charArray = "ñýÿ¼õóÿ÷¼ðýë¼áú÷þþ¼ØüûÐàûöõ÷".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 146);
        }
        String str = new String(charArray);
        char[] charArray2 = "ñþûüûæ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 146);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String kd() {
        aq aqVar = xj;
        if (aqVar != null) {
            return aqVar.am();
        }
        return null;
    }

    public static String p() {
        aq aqVar = xj;
        return aqVar != null ? aqVar.p() : "";
    }

    public static w pl() {
        return zb.xj();
    }

    public static String tf() {
        aq aqVar = xj;
        return aqVar != null ? aqVar.tf() : "";
    }

    public static hf u() {
        return u;
    }

    public static u w() {
        return f;
    }

    public static void xj(Context context, f fVar) {
        if (kd != null) {
            cu.hf(new RuntimeException("Init Twice!"));
            return;
        }
        if (fVar.en() == null) {
            cu.hf(new RuntimeException("need to involve setSensitiveInfoProvider!"));
            return;
        }
        Application application = (Application) context.getApplicationContext();
        a y2 = a.y();
        wn wnVar = new wn(application, fVar);
        kd = wnVar;
        aq aqVar = new aq(application, wnVar);
        y2.xj(application, wnVar, aqVar, new yo(fVar.tf()));
        xj = aqVar;
        if (kd.yo()) {
            application.registerReceiver(new Collector(), new IntentFilter());
        }
        cu.u("Inited", null);
    }

    public static JSONObject y() {
        if (kd != null) {
            return kd.pz();
        }
        return null;
    }

    public static void hf(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
            cu.hf("call onEventData with invalid params, return", null);
            return;
        }
        try {
            a.xj(new se(str, jSONObject));
        } catch (Exception e) {
            cu.w("call onEventData get exception: ", e);
        }
    }

    public static void xj(boolean z) {
        hf = z;
    }

    public static void xj() {
        aq aqVar;
        if (!hf || (aqVar = xj) == null) {
            return;
        }
        aqVar.u();
    }

    public static void xj(HashMap<String, Object> hashMap) {
        aq aqVar = xj;
        if (aqVar != null) {
            aqVar.xj(hashMap);
        }
    }

    public static <T> T xj(String str, T t) {
        aq aqVar = xj;
        if (aqVar != null) {
            return (T) aqVar.xj(str, t);
        }
        return null;
    }

    public static void xj(String str, JSONObject jSONObject) {
        a.xj(new ft(str, false, jSONObject != null ? jSONObject.toString() : null));
    }

    public static void xj(String str, JSONObject jSONObject, int i) {
        a.xj(new ft(str, false, jSONObject != null ? jSONObject.toString() : null, i));
    }

    public static void xj(String str, Bundle bundle) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        cu.hf(th);
                        xj(str, jSONObject);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        xj(str, jSONObject);
    }

    public static void xj(String str, Bundle bundle, int i) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        cu.hf(th);
                        xj(str, jSONObject, i);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        xj(str, jSONObject, i);
    }

    public static void xj(kd kdVar) {
        zm.xj(kdVar);
    }
}
