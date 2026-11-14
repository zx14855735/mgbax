package com.kwad.sdk.utils;

import BPw6Q8.ASJ6gh;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class x {
    private static boolean beo;
    private static com.kwad.sdk.utils.c.a bep = new com.kwad.sdk.utils.c.a();

    static {
        nNMkv();
    }

    @SuppressLint({"MissingPermission"})
    private static com.kwad.sdk.internal.api.a a(Context context, LocationManager locationManager) {
        try {
            if (ASJ6gh.A2egSU(context, com.kuaishou.weapon.p0.g.g) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
            if (lastKnownLocation == null) {
                beo = true;
            }
            return com.kwad.sdk.internal.api.a.a(lastKnownLocation);
        } catch (Exception e) {
            beo = true;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    private static com.kwad.sdk.internal.api.a b(Context context, LocationManager locationManager) {
        try {
            if (ASJ6gh.A2egSU(context, com.kuaishou.weapon.p0.g.g) != 0 && ASJ6gh.A2egSU(context, com.kuaishou.weapon.p0.g.h) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("network");
            if (lastKnownLocation == null) {
                beo = true;
            }
            return com.kwad.sdk.internal.api.a.a(lastKnownLocation);
        } catch (Exception e) {
            beo = true;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    private static com.kwad.sdk.internal.api.a c(Context context, LocationManager locationManager) {
        try {
            if (ASJ6gh.A2egSU(context, com.kuaishou.weapon.p0.g.h) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
            if (lastKnownLocation == null) {
                beo = true;
            }
            return com.kwad.sdk.internal.api.a.a(lastKnownLocation);
        } catch (Exception e) {
            beo = true;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    public static com.kwad.sdk.utils.c.a cU(Context context) {
        com.kwad.sdk.utils.c.a aVar;
        com.kwad.sdk.internal.api.a Tf;
        com.kwad.sdk.utils.c.a aVar2 = new com.kwad.sdk.utils.c.a();
        if (bc.readLocationDisable() && (Tf = bc.Tf()) != null) {
            aVar2.bhT = Tf;
            aVar2.type = 1;
            return aVar2;
        }
        if (beo || (!((aVar = bep) == null || aVar.bhT == null) || context == null)) {
            return bep;
        }
        if (!bc.readLocationDisable() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(64L)) {
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager.isProviderEnabled("gps")) {
                    bep.bhT = a(context, locationManager);
                }
                if (bep == null && locationManager.isProviderEnabled("network")) {
                    bep.bhT = b(context, locationManager);
                }
                if (bep == null && locationManager.isProviderEnabled("passive")) {
                    bep.bhT = c(context, locationManager);
                }
                com.kwad.sdk.utils.c.a aVar3 = bep;
                aVar3.type = 0;
                return aVar3;
            } catch (Exception e) {
                beo = true;
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        }
        return null;
    }

    private static /* synthetic */ void nNMkv() {
        char[] charArray = "õùû¸ñ÷ûó¸ôùï¸åþóúú¸ÜøÿÔäÿòñó".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 150);
        }
        String str = new String(charArray);
        char[] charArray2 = "õúÿøÿâ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 150);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
