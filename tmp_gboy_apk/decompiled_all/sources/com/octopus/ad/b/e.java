package com.octopus.ad.b;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e {
    public static void a(Context context, d dVar) {
        if (context == null) {
            if (dVar != null) {
                dVar.a("");
            }
        } else {
            String b = f.b(context.getApplicationContext());
            if (dVar != null) {
                dVar.a(b);
            }
        }
    }
}
