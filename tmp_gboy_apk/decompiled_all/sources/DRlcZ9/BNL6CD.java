package DRlcZ9;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceScreen;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BNL6CD {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Context f2127A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public long f2128A4TApA = 0;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public SharedPreferences f2129A5SV6n = null;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public SharedPreferences.Editor f2130ADYaiT;
    public boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final String f2131ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public PreferenceScreen f2132ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public B4ZgIw f2133AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public B4ZgIw f2134AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public B4ZgIw f2135AZkASS;

    public BNL6CD(Context context) {
        this.f2127A2egSU = context;
        this.f2131ARc23Z = A2egSU(context);
    }

    public static String A2egSU(Context context) {
        return context.getPackageName() + "_preferences";
    }

    public final SharedPreferences.Editor A4TApA() {
        if (!this.AMqCpz) {
            return ADYaiT().edit();
        }
        if (this.f2130ADYaiT == null) {
            this.f2130ADYaiT = ADYaiT().edit();
        }
        return this.f2130ADYaiT;
    }

    public final long A5SV6n() {
        long j;
        synchronized (this) {
            j = this.f2128A4TApA;
            this.f2128A4TApA = 1 + j;
        }
        return j;
    }

    public final SharedPreferences ADYaiT() {
        if (this.f2129A5SV6n == null) {
            this.f2129A5SV6n = this.f2127A2egSU.getSharedPreferences(this.f2131ARc23Z, 0);
        }
        return this.f2129A5SV6n;
    }

    public Context getContext() {
        return this.f2127A2egSU;
    }
}
