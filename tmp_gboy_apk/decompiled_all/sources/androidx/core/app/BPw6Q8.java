package androidx.core.app;

import android.app.Notification;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BPw6Q8 extends C4FrIb {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public CharSequence f8510A5SV6n;

    @Override // androidx.core.app.C4FrIb
    public final void A4TApA(CikNvS cikNvS) {
        new Notification.BigTextStyle(cikNvS.f8556A4TApA).setBigContentTitle(this.f8554A4TApA).bigText(this.f8510A5SV6n);
    }

    @Override // androidx.core.app.C4FrIb
    public final String AMqCpz() {
        return "androidx.core.app.NotificationCompat$BigTextStyle";
    }
}
