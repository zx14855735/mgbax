package androidx.core.app;

import android.app.Notification;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class Cd8JRx {
    public static Notification.Action.Builder A2egSU(Notification.Action.Builder builder, boolean z) {
        return builder.setAuthenticationRequired(z);
    }

    public static Notification.Builder A4TApA(Notification.Builder builder, int i) {
        return builder.setForegroundServiceBehavior(i);
    }
}
