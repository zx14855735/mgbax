package com.kwad.components.core.webview.tachikoma;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class h {
    private final Map<String, HashMap<Integer, String>> aja = new ConcurrentHashMap();
    private Map<String, Integer> ajb = new ConcurrentSkipListMap();
    private int ajc = 0;

    public static class a {
        private static final h ajd = new h();

        static {
            bGBfHk();
        }

        private static /* synthetic */ void bGBfHk() {
            char[] charArray = "bnl/f`ld/cnx/ridmm/KohCshefd".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 1);
            }
            String str = new String(charArray);
            char[] charArray2 = "bmhohu".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 1);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private static int bm(String str) {
        return ((str.length() * 2) + 44) / 1024;
    }

    private void bz(int i) {
        try {
            if (this.ajc + i > com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aGd)) {
                ArrayList arrayList = new ArrayList();
                Iterator<Map.Entry<String, Integer>> it = this.ajb.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, Integer> next = it.next();
                    arrayList.add(next.getKey());
                    this.ajc -= next.getValue().intValue();
                    it.remove();
                    if (this.ajc <= com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aGd) - i) {
                        break;
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    this.aja.remove((String) it2.next());
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    private void r(String str, String str2) {
        int bm = bm(str2);
        this.ajc += bm;
        this.ajb.put(str, Integer.valueOf(bm));
    }

    public static h wt() {
        return a.ajd;
    }

    public final void b(String str, int i, String str2) {
        if (TextUtils.isEmpty(str2) || com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aGd) == 0) {
            return;
        }
        if (this.aja.containsKey(str)) {
            HashMap<Integer, String> hashMap = this.aja.get(str);
            if (hashMap != null && hashMap.containsKey(Integer.valueOf(i))) {
                return;
            } else {
                this.aja.remove(str);
            }
        }
        bz(bm(str2));
        HashMap<Integer, String> hashMap2 = new HashMap<>();
        hashMap2.put(Integer.valueOf(i), str2);
        this.aja.put(str, hashMap2);
        r(str, str2);
    }

    public final String o(String str, int i) {
        HashMap<Integer, String> hashMap;
        return (com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aGd) != 0 && this.aja.containsKey(str) && (hashMap = this.aja.get(str)) != null && hashMap.containsKey(Integer.valueOf(i))) ? hashMap.get(Integer.valueOf(i)) : "";
    }
}
