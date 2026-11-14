package com.sigmob.sdk.base.services;

import android.annotation.SuppressLint;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.services.f;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e implements f.a {
    private static volatile LocationManager b;
    private g d = g.STOP;

    /* renamed from: a, reason: collision with root package name */
    private static final LocationListener f13210a = new LocationListener() { // from class: com.sigmob.sdk.base.services.e.1
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (ClientMetadata.getInstance() == null) {
                return;
            }
            ClientMetadata.getInstance().setLocation(location);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    };
    private static String c = "network";

    static {
        Spxwp();
    }

    public e() {
        LocationManager a2;
        if (ClientMetadata.getInstance() == null || (a2 = a()) == null) {
            return;
        }
        Criteria criteria = new Criteria();
        criteria.setAccuracy(2);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(false);
        criteria.setPowerRequirement(1);
        c = a2.getBestProvider(criteria, false);
    }

    private static /* synthetic */ void Spxwp() {
        char[] charArray = "\u0086\u008a\u0088Ë\u0082\u0084\u0088\u0080Ë\u0087\u008a\u009cË\u0096\u008d\u0080\u0089\u0089Ë¯\u008b\u008c§\u0097\u008c\u0081\u0082\u0080".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 229);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0086\u0089\u008c\u008b\u008c\u0091".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 229);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static LocationManager a() {
        if (b == null) {
            synchronized (e.class) {
                try {
                    if (b == null) {
                        b = ClientMetadata.getInstance().getLocationManager();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    @SuppressLint({"MissingPermission"})
    private void b() {
        try {
            if (b != null) {
                b.removeUpdates(f13210a);
            }
            b = null;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    @SuppressLint({"MissingPermission"})
    private void c() {
        String str;
        try {
            LocationManager a2 = a();
            if (a2 == null || (str = c) == null || !a2.isProviderEnabled(str)) {
                return;
            }
            SigmobLog.d("private :use_location ");
            a2.requestLocationUpdates(c, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 10.0f, f13210a);
            this.d = g.RUNNING;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public boolean e() {
        if (this.d == g.RUNNING) {
            return false;
        }
        c();
        return true;
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public g f() {
        return this.d;
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public void g() {
        if (this.d == g.RUNNING) {
            b();
            this.d = g.STOP;
        }
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public Error h() {
        return null;
    }
}
