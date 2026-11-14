package com.sigmob.sdk.base.utils;

import java.util.Collection;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e {
    public static boolean a(int i, int i2) {
        return i >= 0 && i < i2;
    }

    public static boolean b(Collection<?> collection) {
        return !a(collection);
    }

    public static boolean a(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean b(Map<?, ?> map) {
        return !a(map);
    }

    public static boolean a(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean b(Object[] objArr) {
        return !a(objArr);
    }

    public static boolean a(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }
}
