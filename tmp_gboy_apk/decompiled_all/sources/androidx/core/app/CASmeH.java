package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.os.Bundle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class CASmeH {
    public static Notification.Builder A2egSU(Notification.Builder builder, Notification.Action action) {
        return builder.addAction(action);
    }

    public static Notification.Action.Builder A4TApA(Notification.Action.Builder builder, Bundle bundle) {
        return builder.addExtras(bundle);
    }

    public static Notification.Action.Builder A5SV6n(Notification.Action.Builder builder, RemoteInput remoteInput) {
        return builder.addRemoteInput(remoteInput);
    }

    public static Notification.Action ADYaiT(Notification.Action.Builder builder) {
        return builder.build();
    }

    public static Notification.Action.Builder AMqCpz(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        return new Notification.Action.Builder(i, charSequence, pendingIntent);
    }

    public static String ARc23Z(Notification notification) {
        return notification.getGroup();
    }

    public static Notification.Builder ASJ6gh(Notification.Builder builder, String str) {
        return builder.setGroup(str);
    }

    public static Notification.Builder AYUAbz(Notification.Builder builder, boolean z) {
        return builder.setGroupSummary(z);
    }

    public static Notification.Builder AZOQYO(Notification.Builder builder, boolean z) {
        return builder.setLocalOnly(z);
    }

    public static Notification.Builder AZkASS(Notification.Builder builder, String str) {
        return builder.setSortKey(str);
    }
}
