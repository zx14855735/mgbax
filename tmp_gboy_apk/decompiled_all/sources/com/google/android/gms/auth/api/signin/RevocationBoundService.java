package com.google.android.gms.auth.api.signin;

import NCeV4Q.B25kr6;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class RevocationBoundService extends Service {
    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        if ("com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(intent.getAction())) {
            Log.isLoggable("RevocationService", 2);
            return new B25kr6(this);
        }
        String valueOf = String.valueOf(intent.getAction());
        if (valueOf.length() == 0) {
            return null;
        }
        "Unknown action sent to RevocationBoundService: ".concat(valueOf);
        return null;
    }
}
