package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AcNBzu {
    public static <T> T A2egSU(Context context, Class<T> cls) {
        return (T) context.getSystemService(cls);
    }

    public static int A4TApA(AppOpsManager appOpsManager, String str, String str2) {
        return appOpsManager.noteProxyOp(str, str2);
    }

    public static int A5SV6n(AppOpsManager appOpsManager, String str, String str2) {
        return appOpsManager.noteProxyOpNoThrow(str, str2);
    }

    public static String ADYaiT(String str) {
        return AppOpsManager.permissionToOp(str);
    }
}
