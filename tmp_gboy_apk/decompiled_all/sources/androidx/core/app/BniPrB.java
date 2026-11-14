package androidx.core.app;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BniPrB extends C4FrIb {
    @Override // androidx.core.app.C4FrIb
    public final void A2egSU(Bundle bundle) {
        super.A2egSU(bundle);
        bundle.putInt("android.callType", 0);
        bundle.putBoolean("android.callIsVideo", false);
        bundle.putCharSequence("android.verificationText", null);
        bundle.putParcelable("android.answerIntent", null);
        bundle.putParcelable("android.declineIntent", null);
        bundle.putParcelable("android.hangUpIntent", null);
    }

    @Override // androidx.core.app.C4FrIb
    public final void A4TApA(CikNvS cikNvS) {
        if (Build.VERSION.SDK_INT >= 31) {
            if (Log.isLoggable("NotifCompat", 3)) {
                String.valueOf(0);
            }
        } else {
            Notification.Builder builder = cikNvS.f8556A4TApA;
            builder.setContentTitle(null);
            Bundle bundle = this.f8553A2egSU.f8538BV3sI0;
            CharSequence charSequence = (bundle == null || !bundle.containsKey("android.text")) ? null : this.f8553A2egSU.f8538BV3sI0.getCharSequence("android.text");
            builder.setContentText(charSequence != null ? charSequence : null);
            BmvVmW.A4TApA(builder, "call");
        }
    }

    @Override // androidx.core.app.C4FrIb
    public final String AMqCpz() {
        return "androidx.core.app.NotificationCompat$CallStyle";
    }
}
