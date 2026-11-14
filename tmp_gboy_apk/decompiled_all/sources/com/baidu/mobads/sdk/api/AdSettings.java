package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.co;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AdSettings {
    public static String getSDKVersion() {
        return co.c() + "";
    }

    public static void setNotificationChannel(String str) {
        CustomNotification.setNotificationChannel(str);
    }

    public static void setNotificationIcon(int i) {
        CustomNotification.setNotificationIcon(i);
    }
}
