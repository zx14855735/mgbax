package androidx.core.app;

import android.app.Notification;
import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class CSDoyG {
    public static Notification.Builder A2egSU(Context context, String str) {
        return new Notification.Builder(context, str);
    }

    public static Notification.Builder A4TApA(Notification.Builder builder, int i) {
        return builder.setBadgeIconType(i);
    }

    public static Notification.Builder A5SV6n(Notification.Builder builder, boolean z) {
        return builder.setColorized(z);
    }

    public static Notification.Builder ADYaiT(Notification.Builder builder, int i) {
        return builder.setGroupAlertBehavior(i);
    }

    public static Notification.Builder AMqCpz(Notification.Builder builder, CharSequence charSequence) {
        return builder.setSettingsText(charSequence);
    }

    public static Notification.Builder ARc23Z(Notification.Builder builder, String str) {
        return builder.setShortcutId(str);
    }

    public static Notification.Builder ASJ6gh(Notification.Builder builder, long j) {
        return builder.setTimeoutAfter(j);
    }
}
