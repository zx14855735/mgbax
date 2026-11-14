package com.octopus.ad.b;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static c f12367a;
    private static String b;
    private static boolean c;

    public static synchronized String a(Context context) {
        synchronized (f.class) {
            if (context != null) {
                try {
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        if (f12367a == null) {
                            f12367a = a.a();
                        }
                        c cVar = f12367a;
                        if (cVar == null) {
                            return null;
                        }
                        try {
                            String a2 = cVar.a(context);
                            if (!TextUtils.isEmpty(a2)) {
                                b = a2;
                            }
                            c = true;
                            return b;
                        } catch (Throwable unused) {
                            return null;
                        }
                    }
                } finally {
                }
            }
            return null;
        }
    }

    public static String b(Context context) {
        return c ? b : a(context);
    }
}
