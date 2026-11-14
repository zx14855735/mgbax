package com.kwad.sdk.b;

import android.content.Context;
import com.kuaishou.weapon.p0.WeaponHI;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {
    public static void init(Context context) {
        if (com.kwad.framework.a.a.Nr.booleanValue()) {
            try {
                WeaponHI.init(context, new b());
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }
}
