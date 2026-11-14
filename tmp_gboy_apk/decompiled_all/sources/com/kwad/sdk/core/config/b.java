package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bo;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    public static final Map<String, Set<com.kwad.sdk.core.config.item.b>> aDd = new ConcurrentHashMap();
    private static SharedPreferences aDe = null;

    static {
        BZnMxgd();
    }

    private static /* synthetic */ void BZnMxgd() {
        char[] charArray = "\u0095\u0099\u009bØ\u0091\u0097\u009b\u0093Ø\u0094\u0099\u008fØ\u0085\u009e\u0093\u009a\u009aØ¼\u0098\u009f´\u0084\u009f\u0092\u0091\u0093".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 246);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0095\u009a\u009f\u0098\u009f\u0082".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 246);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static SharedPreferences GC() {
        if (aDe == null) {
            aDe = bo.hF("ksadsdk_config");
        }
        return aDe;
    }

    public static <T> void a(com.kwad.sdk.core.config.item.b<T> bVar) {
        String key = bVar.getKey();
        if (TextUtils.isEmpty(key)) {
            return;
        }
        Set<com.kwad.sdk.core.config.item.b> dL = dL(key);
        if (dL == null) {
            dL = new CopyOnWriteArraySet<>();
            aDd.put(key, dL);
        }
        dL.add(bVar);
    }

    public static synchronized void bA(Context context) {
        synchronized (b.class) {
            SharedPreferences GC = GC();
            if (GC != null) {
                a(GC);
            }
        }
    }

    public static synchronized void bz(Context context) {
        synchronized (b.class) {
            try {
                SharedPreferences GC = GC();
                if (GC != null) {
                    SharedPreferences.Editor edit = GC.edit();
                    a(edit);
                    edit.commit();
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    private static Set<com.kwad.sdk.core.config.item.b> dL(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return aDd.get(str);
    }

    public static void k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : aDd.keySet()) {
            Set<com.kwad.sdk.core.config.item.b> set = aDd.get(str);
            if (set != null && !set.isEmpty() && jSONObject.has(str)) {
                for (com.kwad.sdk.core.config.item.b bVar : set) {
                    if (bVar != null) {
                        bVar.l(jSONObject);
                    }
                }
            }
        }
    }

    private static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            Iterator<String> it = aDd.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = aDd.get(it.next());
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            bVar.b(editor);
                        }
                    }
                }
            }
        }
    }

    private static void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            Iterator<String> it = aDd.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = aDd.get(it.next());
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            try {
                                bVar.a(sharedPreferences);
                            } catch (Exception e) {
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void a(Context context, com.kwad.sdk.core.config.item.b<?> bVar) {
        SharedPreferences GC;
        if (bVar == null || (GC = GC()) == null) {
            return;
        }
        try {
            bVar.a(GC);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }
}
