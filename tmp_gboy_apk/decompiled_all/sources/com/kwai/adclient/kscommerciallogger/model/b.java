package com.kwai.adclient.kscommerciallogger.model;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b extends d {
    public static final d bjG = new d("NETWORK_NO_BODY");
    public static final d bjH = new d("NETWORK_FORMAT_ERROR");
    public static final d bjI = new d("NETWORK_INFO_INCOMPLETE");
    public static final d bjJ = new d("NETWORK_BUSINESS_ERROR");
    public static final d bjK = new d("NETWORK_ERROR");
    public static final d bjL = new d("METHOD_PARAM_ILLEGAL");
    public static final d bjM = new d("METHOD_LONG_TIME");
    public static final d bjN = new d("METHOD_ERROR");
    public static final d bjO = new d("PAGE_RENDER_FAIL");
    public static final d bjP = new d("VIEW_RENDER_FAIL");
    public static final d bjQ = new d("RENDER_ERROR");
    public static final d bjR = new d("MATERIAL_LOAD_FAIL");
    public static final d bjS = new d("EXCEPTION");

    static {
        qzHm();
    }

    public b(String str) {
        super(str);
    }

    private static /* synthetic */ void qzHm() {
        char[] charArray = "&*(k\"$( k'*<k6- ))k\u000f+,\u00077,!\" ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'E');
        }
        String str = new String(charArray);
        char[] charArray2 = "&),+,1".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'E');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
