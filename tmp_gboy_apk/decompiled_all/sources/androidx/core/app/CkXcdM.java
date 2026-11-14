package androidx.core.app;

import android.app.NotificationManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class CkXcdM {
    public static boolean A2egSU(NotificationManager notificationManager) {
        return notificationManager.areNotificationsEnabled();
    }

    public static int A4TApA(NotificationManager notificationManager) {
        return notificationManager.getImportance();
    }
}
