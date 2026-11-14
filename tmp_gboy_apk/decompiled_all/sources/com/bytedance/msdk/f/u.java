package com.bytedance.msdk.f;

import android.content.Context;
import android.content.Intent;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {

    public interface xj {
    }

    public static void xj(Context context, Intent intent, xj xjVar) {
        if (context == null || intent == null) {
            return;
        }
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
        }
    }
}
