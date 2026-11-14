package QgOIY0;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public Notification f7487A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public ArrayList f7488A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Context f7489A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public CharSequence f7490ADYaiT;
    public CharSequence AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public PendingIntent f7491ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public A2egSU f7492ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public ArrayList f7493AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public boolean f7494AZOQYO;

    public static CharSequence A4TApA(String str) {
        return (str != null && str.length() > 5120) ? str.subSequence(0, 5120) : str;
    }

    public final void A2egSU(A2egSU a2egSU) {
        if (this.f7492ASJ6gh != a2egSU) {
            this.f7492ASJ6gh = a2egSU;
            if (a2egSU.f7497A2egSU != this) {
                a2egSU.f7497A2egSU = this;
                A2egSU(a2egSU);
            }
        }
    }
}
