package com.bytedance.sdk.component.f.hf;

import android.text.TextUtils;
import com.bytedance.sdk.component.f.xj.c;
import com.bytedance.sdk.component.f.xj.kd;
import com.bytedance.sdk.component.f.xj.y;
import com.bytedance.sdk.component.utils.pl;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public static final ConcurrentHashMap<String, hf> xj = new ConcurrentHashMap<>();
    private static volatile List<com.bytedance.sdk.component.f.xj.w> hf = new ArrayList();
    private static ConcurrentHashMap<String, kd> w = new ConcurrentHashMap<>();

    static {
        GDlhD();
    }

    private static /* synthetic */ void GDlhD() {
        char[] charArray = "ÎÂÀ\u0083ÊÌÀÈ\u0083ÏÂÔ\u0083ÞÅÈÁÁ\u0083çÃÄïßÄÉÊÈ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 173);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÎÁÄÃÄÙ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 173);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void hf(String str) {
        xj(false, str);
        w(str).xj();
    }

    public static kd kd(String str) {
        kd kdVar = w.get(str);
        if (kdVar == null && (kdVar = w(str).w()) != null) {
            w.put(str, kdVar);
        }
        return kdVar;
    }

    public static void u(String str) {
        w(str).hf();
    }

    public static c w(String str) {
        ConcurrentHashMap<String, hf> concurrentHashMap = xj;
        hf hfVar = concurrentHashMap.get(str);
        if (hfVar != null) {
            return hfVar;
        }
        hf hfVar2 = new hf();
        concurrentHashMap.put(str, hfVar2);
        return hfVar2;
    }

    public static c xj(com.bytedance.sdk.component.f.xj.xj xjVar) {
        if (xjVar == null || TextUtils.isEmpty(xjVar.kd()) || xjVar.getContext() == null) {
            pl.u("csj_log_error", "config or adLogFrom or context is null");
            return null;
        }
        ConcurrentHashMap<String, hf> concurrentHashMap = xj;
        hf hfVar = concurrentHashMap.get(xjVar.kd());
        if (hfVar == null) {
            hfVar = new hf(xjVar);
        } else {
            hfVar.hf(xjVar);
        }
        concurrentHashMap.put(xjVar.kd(), hfVar);
        return hfVar;
    }

    public static void xj(y yVar, String str) {
        w(str).xj(yVar);
    }

    public static void xj(boolean z, String str) {
        w(str).xj(z);
    }

    public static List<com.bytedance.sdk.component.f.xj.w> xj() {
        return hf;
    }

    public static void xj(com.bytedance.sdk.component.f.xj.w wVar) {
        if (wVar != null) {
            hf.add(wVar);
        }
    }

    public static boolean xj(String str) {
        hf hfVar = xj.get(str);
        return hfVar == null || hfVar.w() == null || hfVar.u() == null || hfVar.kd() == null;
    }

    public static void xj(String str, String str2) {
        w(str).xj(str2);
    }

    public static void xj(String str, String str2, List<String> list, boolean z, Map<String, String> map, JSONObject jSONObject) {
        w(str).xj(str2, list, z, map, jSONObject);
    }

    public static void xj(com.bytedance.sdk.component.f.xj.hf hfVar, String str) {
        w(str).xj(hfVar);
    }
}
