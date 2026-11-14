package com.sigmob.sdk.base.utils;

import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13225a = "^((?!^10\\.)((?!^127\\.)((?!^192\\.168\\.)((?!^172\\.1[6-9]\\.)((?!^172\\.2[0-9]\\.)((?!^172\\.3[0-1]\\.)[0-9]{1,3}\\.){3}[0-9]{1,3}|^::1$|^([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}$)))))";

    public static boolean a(Boolean bool) {
        return b((Object) bool) && bool.booleanValue();
    }

    public static boolean b(Boolean bool) {
        return b((Object) bool) && !bool.booleanValue();
    }

    public static boolean c(Object obj) {
        if (obj != null) {
            return (obj instanceof String) && o.a((CharSequence) obj);
        }
        return true;
    }

    public static boolean d(Object obj) {
        return !c(obj);
    }

    public static boolean a(Number number) {
        return b(number) && number.intValue() > 0;
    }

    public static boolean b(Object obj) {
        return obj != null;
    }

    public static boolean a(Object obj) {
        return obj == null;
    }

    public static boolean a(String str) {
        if (a((Object) str)) {
            return false;
        }
        return Pattern.compile(f13225a).matcher(str).matches();
    }
}
