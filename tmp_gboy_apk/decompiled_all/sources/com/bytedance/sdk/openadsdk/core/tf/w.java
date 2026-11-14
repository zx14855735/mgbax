package com.bytedance.sdk.openadsdk.core.tf;

import android.annotation.SuppressLint;
import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends hf {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile w xj;

    private w(Context context) {
        super(context, "ttopensdk.db");
    }

    public static w xj(Context context) {
        if (xj == null) {
            synchronized (w.class) {
                try {
                    if (xj == null) {
                        xj = new w(context);
                    }
                } finally {
                }
            }
        }
        return xj;
    }
}
