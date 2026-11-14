package com.baidu.mobads.sdk.internal;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f9776a;

    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f9777a = "remote_adserv";
        public static final String b = "remote_novel";
    }

    private c() {
    }

    public static c a() {
        if (f9776a == null) {
            synchronized (c.class) {
                try {
                    if (f9776a == null) {
                        f9776a = new c();
                    }
                } finally {
                }
            }
        }
        return f9776a;
    }

    public as a(String str) {
        return new as(str);
    }
}
