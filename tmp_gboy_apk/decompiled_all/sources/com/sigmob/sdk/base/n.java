package com.sigmob.sdk.base;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class n {
    public static final int A = 0;
    public static final int B = 2;
    public static final String C = "ratio";
    public static final String D = "c2V0SmF2YVNjcmlwdEVuYWJsZWQ=";
    public static final Boolean E;
    public static final String F = "c2V0QWxsb3dGaWxlQWNjZXNz";
    public static final boolean G = true;
    public static final String H = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlBBQ0tBR0VfUkVNT1ZFRA==";
    public static final String I = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlBBQ0tBR0VfQURERUQ=";
    public static final String J = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlBBQ0tBR0VfUkVQTEFDRUQ=";
    public static final String K = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLklOU1RBTExfUEFDS0FHRQ==";
    public static final String L = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLklOU1RBTExfRkFJTFVSRQ==";
    public static final String M = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlNDUkVFTl9PTg==";
    public static final String N = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlNDUkVFTl9PRkY=";
    public static final String O = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlVTRVJfUFJFU0VOVA==";
    public static final String P = "c.etoolads.cn/s/config";
    public static final String Q = "dc.sigmob.cn/log";
    public static final String R = "adxtool.sigmob.cn/debug/feedback";
    public static final String S = "adservice.sigmob.cn/ad/v4";
    public static final String T = "adservice.sigmob.cn/hb/v2/ad";
    public static final String U = "adservice.sigmob.cn/extconfig";

    /* renamed from: a, reason: collision with root package name */
    public static final int f13190a = 1;
    public static final String b = "last_day";
    public static final String c = "canOpen_last_day";
    public static final String d = "sigdemo_conf_url";
    public static final int e = 186;
    public static final Boolean f;
    public static final String g = "adservice.sigmob.cn/s/config";
    public static final int h = 159;
    public static final String i = "1000";
    public static final String j = "AD_UNIT_KEY";
    public static final String k = "4.24.7";
    public static final String l = "source";
    public static final String m = "ext";
    public static final String n = "app_name";
    public static final String o = "wind";
    public static final String p = "package_name";
    public static final String q = "update";
    public static final String r = "app_version";
    public static final String s = "source_type";
    public static final String t = "allow_install";
    public static final String u = "enablescreenlockdisplayad";
    public static final String v = "enablekeepon";
    public static final String w = "ready_filters";
    public static final String x = "REQUESTED_ORIENTATION";
    public static final String y = "isHalfInterstitial";
    public static final String z = "file";

    static {
        Boolean bool = Boolean.FALSE;
        f = bool;
        E = bool;
        BiMUS();
    }

    private static /* synthetic */ void BiMUS() {
        char[] charArray = "ßÓÑ\u0092ÛÝÑÙ\u0092ÞÓÅ\u0092ÏÔÙÐÐ\u0092öÒÕþÎÕØÛÙ".toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            charArray[i2] = (char) (charArray[i2] ^ 188);
        }
        String str = new String(charArray);
        char[] charArray2 = "ßÐÕÒÕÈ".toCharArray();
        int length2 = charArray2.length;
        for (int i3 = 0; i3 < length2; i3++) {
            charArray2[i3] = (char) (charArray2[i3] ^ 188);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
