package com.fl.saas.config.oaid;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class OAIDLog {
    private static final String TAG = "OAID";
    private static boolean enable;

    private OAIDLog() {
    }

    public static void enable() {
        enable = true;
    }

    public static void print(Object obj) {
        if (enable) {
            if (obj == null) {
                obj = "<null>";
            }
            obj.toString();
        }
    }
}
