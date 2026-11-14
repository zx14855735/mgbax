package com.kwai.adclient.kscommerciallogger.model;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a extends d {
    public static final d bjn = new d("DURATION_PAGE_LOAD");
    public static final d bjo = new d("DURATION_WIDGET_LOAD");
    public static final d bjp = new d("DURATION_RN_PAGE_LOAD");
    public static final d bjq = new d("DURATION_TK_PAGE_LOAD");
    public static final d bjr = new d("DURATION_WEB_PAGE_LOAD");
    public static final d bjs = new d("NETWORK_LOAD_TIME");
    public static final d bjt = new d("NETWORK_BIZ_CODE_ERROR");
    public static final d bju = new d("NETWORK_RESPONSE_ERROR");
    public static final d bjv = new d("EXECUTION_METHOD_TIME");
    public static final d bjw = new d("EXECUTION_IO_TIME");
    public static final d bjx = new d("EXECUTION_BIZ_TIME");
    public static final d bjy = new d("FPS_AVG");
    public static final d bjz = new d("FPS_LAG");
    public static final d bjA = new d("MEMORY_USAGE");
    public static final d bjB = new d("MEMORY_LEAK");
    public static final d bjC = new d("MEMORY_OOM");
    public static final d bjD = new d("CRASH_NATIVE");
    public static final d bjE = new d("CRASH_UNNATIVE");
    public static final d bjF = new d("CRASH_ANR");

    static {
        yqOgh();
    }

    private static /* synthetic */ void yqOgh() {
        char[] charArray = "ØÔÖ\u0095ÜÚÖÞ\u0095ÙÔÂ\u0095ÈÓÞ××\u0095ñÕÒùÉÒßÜÞ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 187);
        }
        String str = new String(charArray);
        char[] charArray2 = "Ø×ÒÕÒÏ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 187);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
