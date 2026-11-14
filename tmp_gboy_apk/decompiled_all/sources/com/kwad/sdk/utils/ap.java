package com.kwad.sdk.utils;

import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ap {
    public static boolean L(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean T(List<?> list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj != null && obj.equals(obj2);
    }

    public static void checkUiThread() {
        SystemUtil.checkUiThread();
    }
}
