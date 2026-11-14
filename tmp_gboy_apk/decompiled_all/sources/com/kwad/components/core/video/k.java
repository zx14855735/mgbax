package com.kwad.components.core.video;

import ADYaiT.CtFAbx;
import android.content.Context;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.al;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class k {
    private static Map<String, Integer> afd = new ConcurrentHashMap();

    static {
        wWyZ();
    }

    public static boolean a(String str, String str2, a.C0366a c0366a) {
        String md5 = al.md5(str2);
        long currentTimeMillis = System.currentTimeMillis();
        com.kwad.sdk.core.d.c.i("VideoCacheHelper", "start cache video key:" + md5 + "--url:" + str);
        boolean b = com.kwad.sdk.core.diskcache.b.a.IJ().b(str, str2, c0366a);
        long currentTimeMillis2 = System.currentTimeMillis();
        StringBuilder B3GDIM2 = CtFAbx.B3GDIM("finish cache video key:", md5, "--cache time:");
        B3GDIM2.append(currentTimeMillis2 - currentTimeMillis);
        B3GDIM2.append("--success:");
        B3GDIM2.append(b);
        com.kwad.sdk.core.d.c.i("VideoCacheHelper", B3GDIM2.toString());
        return b;
    }

    public static boolean aO(AdTemplate adTemplate) {
        File cr = com.kwad.sdk.core.diskcache.b.a.IJ().cr(com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.er(adTemplate)));
        return cr != null && cr.exists();
    }

    private static int aY(String str) {
        Integer num = afd.get(str);
        return num != null ? num.intValue() : com.kwad.sdk.core.config.e.Dz();
    }

    public static String j(Context context, AdTemplate adTemplate) {
        return a(context, com.kwad.sdk.core.response.b.e.eH(adTemplate), com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.er(adTemplate)));
    }

    public static void n(String str, int i) {
        afd.put(str, Integer.valueOf(i));
    }

    private static /* synthetic */ void wWyZ() {
        char[] charArray = "/#!b+-!)b.#5b?$)  b\u0006\"%\u000e>%(+)".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'L');
        }
        String str = new String(charArray);
        char[] charArray2 = "/ %\"%8".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'L');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String j(Context context, String str) {
        return a(context, aY(str), str);
    }

    private static String a(Context context, int i, String str) {
        if (i < 0) {
            File cr = com.kwad.sdk.core.diskcache.b.a.IJ().cr(str);
            if (cr != null && cr.exists()) {
                return cr.getAbsolutePath();
            }
        } else if (i > 0) {
            return com.kwad.sdk.core.videocache.c.a.ca(context).eZ(str);
        }
        return str;
    }
}
