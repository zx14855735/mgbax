package com.bykv.vk.component.ttvideo.utils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class LiveUtils {
    public static int versionStringToInt(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String[] split = str.split("\\.");
        if (split.length <= 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < split.length; i2++) {
            i = i2 == 0 ? Integer.parseInt(split[i2]) : (i * 100) + Integer.parseInt(split[i2]);
        }
        return i;
    }
}
