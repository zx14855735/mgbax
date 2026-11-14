package androidx.core.app;

import android.app.Notification;
import android.media.AudioAttributes;
import android.net.Uri;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class CNPG0E {
    public static Notification.Builder A2egSU(Notification.Builder builder, String str) {
        return builder.addPerson(str);
    }

    public static Notification.Builder A4TApA(Notification.Builder builder, String str) {
        return builder.setCategory(str);
    }

    public static Notification.Builder A5SV6n(Notification.Builder builder, int i) {
        return builder.setColor(i);
    }

    public static Notification.Builder ADYaiT(Notification.Builder builder, Notification notification) {
        return builder.setPublicVersion(notification);
    }

    public static Notification.Builder AMqCpz(Notification.Builder builder, Uri uri, Object obj) {
        return builder.setSound(uri, (AudioAttributes) obj);
    }

    public static Notification.Builder ARc23Z(Notification.Builder builder, int i) {
        return builder.setVisibility(i);
    }
}
