package com.bytedance.sdk.openadsdk.core.tf;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.pz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class hf {
    private Context hf;
    private u xj;

    public hf(Context context, String str) {
        try {
            Context context2 = context == null ? pz.getContext() : context.getApplicationContext();
            this.hf = context2;
            if (this.xj == null) {
                this.xj = new u(context2, str);
            }
        } catch (Throwable unused) {
        }
    }

    public u xj() {
        return this.xj;
    }

    public static boolean xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.getClass();
        return str.equals("sdk_launch");
    }
}
