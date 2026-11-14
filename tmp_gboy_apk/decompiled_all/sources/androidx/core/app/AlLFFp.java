package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AlLFFp {
    public static int A2egSU(AppOpsManager appOpsManager, String str, int i, String str2) {
        if (appOpsManager == null) {
            return 1;
        }
        return appOpsManager.checkOpNoThrow(str, i, str2);
    }

    public static String A4TApA(Context context) {
        return context.getOpPackageName();
    }

    public static AppOpsManager A5SV6n(Context context) {
        return (AppOpsManager) context.getSystemService(AppOpsManager.class);
    }
}
