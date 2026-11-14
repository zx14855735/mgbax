package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BNL6CD {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Bundle f8503A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public IconCompat f8504A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final CtxOCS[] f8505A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final boolean f8506ADYaiT;
    public final boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final int f8507ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final CharSequence f8508ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final PendingIntent f8509AYUAbz;

    public BNL6CD(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        this(i != 0 ? IconCompat.A4TApA(null, "", i) : null, charSequence, pendingIntent, new Bundle(), null, null);
    }

    public final IconCompat A2egSU() {
        int i;
        if (this.f8504A4TApA == null && (i = this.f8507ARc23Z) != 0) {
            this.f8504A4TApA = IconCompat.A4TApA(null, "", i);
        }
        return this.f8504A4TApA;
    }

    public BNL6CD(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, CtxOCS[] ctxOCSArr, CtxOCS[] ctxOCSArr2) {
        this.AMqCpz = true;
        this.f8504A4TApA = iconCompat;
        if (iconCompat != null && iconCompat.getType() == 2) {
            this.f8507ARc23Z = iconCompat.A5SV6n();
        }
        this.f8508ASJ6gh = BV3sI0.A4TApA(charSequence);
        this.f8509AYUAbz = pendingIntent;
        this.f8503A2egSU = bundle;
        this.f8505A5SV6n = ctxOCSArr;
        this.f8506ADYaiT = true;
        this.AMqCpz = true;
    }
}
