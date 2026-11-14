package com.bytedance.sdk.openadsdk.core.tf;

import android.annotation.SuppressLint;
import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends hf {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile xj xj;

    private xj(Context context) {
        super(context, "ttopensdk2.db");
    }

    public static xj xj(Context context) {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj(context);
                    }
                } finally {
                }
            }
        }
        return xj;
    }
}
