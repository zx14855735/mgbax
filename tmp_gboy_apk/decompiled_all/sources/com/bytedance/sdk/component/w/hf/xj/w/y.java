package com.bytedance.sdk.component.w.hf.xj.w;

import com.baidu.mobads.sdk.internal.an;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class y {
    public static boolean hf(String str) {
        return str.equals(an.b) || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean kd(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean u(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean w(String str) {
        return hf(str) || str.equals("OPTIONS") || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }

    public static boolean xj(String str) {
        return str.equals(an.b) || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }
}
