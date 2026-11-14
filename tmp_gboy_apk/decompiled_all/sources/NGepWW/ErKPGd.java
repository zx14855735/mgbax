package NGepWW;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ErKPGd extends BroadcastReceiver {

    /* renamed from: A2egSU, reason: collision with root package name */
    public Context f5845A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final EGM26s f5846A4TApA;

    public ErKPGd(EGM26s eGM26s) {
        this.f5846A4TApA = eGM26s;
    }

    public final void A2egSU() {
        synchronized (this) {
            try {
                Context context = this.f5845A2egSU;
                if (context != null) {
                    context.unregisterReceiver(this);
                }
                this.f5845A2egSU = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f5846A4TApA.A2egSU();
            A2egSU();
        }
    }
}
