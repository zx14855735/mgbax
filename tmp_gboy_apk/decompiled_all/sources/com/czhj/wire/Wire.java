package com.czhj.wire;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Wire {
    private Wire() {
    }

    public static <T> T get(T t, T t2) {
        return t != null ? t : t2;
    }
}
