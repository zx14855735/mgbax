package com.bytedance.msdk.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class u {
    private static Toast xj;

    public static void xj(Context context, String str) {
        xj(context, str, 0);
    }

    public static void xj(Context context, String str, int i) {
        Toast xj2 = xj(context);
        if (xj2 == null) {
            com.bytedance.msdk.xj.kd.w.hf("TToast", "toast msg: ".concat(String.valueOf(str)));
            return;
        }
        xj2.setDuration(i);
        xj2.setText(String.valueOf(str));
        xj2.show();
    }

    @SuppressLint({"ShowToast"})
    private static Toast xj(Context context) {
        if (context == null) {
            return xj;
        }
        Toast makeText = Toast.makeText(context.getApplicationContext(), "", 0);
        xj = makeText;
        return makeText;
    }
}
