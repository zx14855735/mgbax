package com.sigmob.sdk.manager;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c extends ThreadPoolExecutor {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f13440a;

    public c() {
        super(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue());
    }

    public static c a() {
        if (f13440a == null) {
            synchronized (c.class) {
                try {
                    if (f13440a == null) {
                        f13440a = new c();
                    }
                } finally {
                }
            }
        }
        return f13440a;
    }
}
