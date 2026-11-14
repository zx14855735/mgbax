package androidx.core.app;

import android.app.Notification;
import android.content.LocusId;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class CcAIMM {
    public static Notification.Builder A2egSU(Notification.Builder builder, boolean z) {
        return builder.setAllowSystemGeneratedContextualActions(z);
    }

    public static Notification.Builder A4TApA(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
        return builder.setBubbleMetadata(bubbleMetadata);
    }

    public static Notification.Action.Builder A5SV6n(Notification.Action.Builder builder, boolean z) {
        return builder.setContextual(z);
    }

    public static Notification.Builder ADYaiT(Notification.Builder builder, Object obj) {
        return builder.setLocusId((LocusId) obj);
    }
}
