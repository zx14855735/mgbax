package com.octopus.ad.b.h;

import android.content.Context;
import com.octopus.ad.b.h.a;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e {
    public static void a(Context context) {
        b.b = a.C0402a.f12371a.a(context.getApplicationContext());
        b.f12372a = true;
    }

    public static String b(Context context) {
        if (b.f12372a) {
            return a.C0402a.f12371a.b(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static boolean a() {
        if (b.f12372a) {
            return b.b;
        }
        throw new RuntimeException();
    }
}
