package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.reflect.Method;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class t {
    private static String aME = Kx();
    private static long aMF = 0;
    private static Context aMG;

    static {
        rcDCFnv();
    }

    public static String Kt() {
        com.kwad.sdk.core.d.c.d("ReportIdManager", ">> updateSessionId");
        String Kx = Kx();
        aME = Kx;
        return Kx;
    }

    public static String Ku() {
        return aME;
    }

    public static long Kv() {
        long bN = bN(aMG);
        b(aMG, 1 + bN);
        return bN;
    }

    public static long Kw() {
        return aMF;
    }

    private static String Kx() {
        return UUID.randomUUID().toString();
    }

    private static boolean b(Context context, long j) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
        edit.putLong("seq", j);
        return edit.commit();
    }

    private static long bN(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("seq", 1L);
    }

    public static void init(Context context) {
        aMG = context;
    }

    private static /* synthetic */ void rcDCFnv() {
        char[] charArray = "\u0098\u0094\u0096Õ\u009c\u009a\u0096\u009eÕ\u0099\u0094\u0082Õ\u0088\u0093\u009e\u0097\u0097Õ±\u0095\u0092¹\u0089\u0092\u009f\u009c\u009e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 251);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0098\u0097\u0092\u0095\u0092\u008f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 251);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
