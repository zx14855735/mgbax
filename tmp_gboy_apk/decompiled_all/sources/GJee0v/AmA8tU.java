package GJee0v;

import android.content.SharedPreferences;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AmA8tU {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static AmA8tU f3052A4TApA;

    /* renamed from: A2egSU, reason: collision with root package name */
    public SharedPreferences f3053A2egSU;

    public static synchronized AmA8tU A2egSU() {
        AmA8tU amA8tU;
        synchronized (AmA8tU.class) {
            try {
                if (f3052A4TApA == null) {
                    f3052A4TApA = new AmA8tU();
                }
                amA8tU = f3052A4TApA;
            } catch (Throwable th) {
                throw th;
            }
        }
        return amA8tU;
    }
}
