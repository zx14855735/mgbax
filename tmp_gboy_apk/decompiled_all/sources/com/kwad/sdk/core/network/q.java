package com.kwad.sdk.core.network;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class q {
    private static volatile q aJX;
    private final Map<String, String> aIE = new ConcurrentHashMap();

    private q() {
    }

    public static q Jv() {
        if (aJX == null) {
            synchronized (q.class) {
                try {
                    if (aJX == null) {
                        aJX = new q();
                    }
                } finally {
                }
            }
        }
        return aJX;
    }

    public final void V(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.aIE.put(str, str2);
    }

    public final String en(String str) {
        return this.aIE.get(str);
    }
}
