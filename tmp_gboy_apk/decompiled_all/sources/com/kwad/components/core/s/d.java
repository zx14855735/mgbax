package com.kwad.components.core.s;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.z;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class d {
    public static void a(Activity activity, int i, boolean z) {
        a(activity, 0, true, true);
    }

    private static void b(Activity activity, int i, boolean z) {
        int i2;
        Window window = activity.getWindow();
        int i3 = Build.VERSION.SDK_INT;
        if (!z || i3 < 23) {
            i2 = 1280;
        } else {
            window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
            window.addFlags(Integer.MIN_VALUE);
            if (bb.Tb()) {
                a(activity, true);
            } else if (bb.Tc()) {
                p.b(activity, true);
            }
            i2 = 9472;
        }
        window.getDecorView().setSystemUiVisibility(i2);
        window.setStatusBarColor(i);
        window.setNavigationBarColor(window.getNavigationBarColor());
    }

    public static boolean ux() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static void a(Activity activity, int i, boolean z, boolean z2) {
        if (ux()) {
            b(activity, i, z);
            if (z2) {
                return;
            }
            activity.findViewById(R.id.content).setPadding(0, com.kwad.sdk.c.a.a.getStatusBarHeight(activity), 0, 0);
        }
    }

    private static boolean a(Activity activity, boolean z) {
        try {
            Integer num = (Integer) z.as("android.view.MiuiWindowManager$LayoutParams", "EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            num.intValue();
            z.callMethod(activity.getWindow(), "setExtraFlags", num, num);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
