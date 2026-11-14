package com.fl.saas.common.util;

import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ListUtils {
    public static <T> T getLastElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (T) J3FDQU.A2egSU.AlLFFp(list, 1);
    }
}
