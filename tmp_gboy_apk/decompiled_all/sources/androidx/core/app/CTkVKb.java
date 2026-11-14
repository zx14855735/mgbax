package androidx.core.app;

import android.app.Notification;
import android.app.Person;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class CTkVKb {
    public static Notification.Builder A2egSU(Notification.Builder builder, Person person) {
        return builder.addPerson(person);
    }

    public static Notification.Action.Builder A4TApA(Notification.Action.Builder builder, int i) {
        return builder.setSemanticAction(i);
    }
}
