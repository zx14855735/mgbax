package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import com.bumptech.glide.request.RequestOptions;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z extends ContextWrapper {

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static final A2egSU f9918AaHO0E = new A2egSU();

    /* renamed from: A2egSU, reason: collision with root package name */
    public final HZUvgL.AaHO0E f9919A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AaHO0E f9920A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final IlwJBd.ARc23Z f9921A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final OLy1FW.AzWtSf f9922ADYaiT;
    public final List AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final B25kr6.ADYaiT f9923ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final HXc4pW.AzWtSf f9924ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final NGepWW.A2egSU f9925AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final int f9926AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public RequestOptions f9927AZkASS;

    static {
        SjBa();
    }

    public ARc23Z(Context context, HZUvgL.AaHO0E aaHO0E, AaHO0E aaHO0E2, IlwJBd.ARc23Z aRc23Z, OLy1FW.AzWtSf azWtSf, B25kr6.ADYaiT aDYaiT, List list, HXc4pW.AzWtSf azWtSf2, NGepWW.A2egSU a2egSU, int i) {
        super(context.getApplicationContext());
        this.f9919A2egSU = aaHO0E;
        this.f9920A4TApA = aaHO0E2;
        this.f9921A5SV6n = aRc23Z;
        this.f9922ADYaiT = azWtSf;
        this.AMqCpz = list;
        this.f9923ARc23Z = aDYaiT;
        this.f9924ASJ6gh = azWtSf2;
        this.f9925AYUAbz = a2egSU;
        this.f9926AZOQYO = i;
    }

    private static /* synthetic */ void SjBa() {
        char[] charArray = "\n\u0006\u0004G\u000e\b\u0004\fG\u000b\u0006\u0010G\u001a\u0001\f\u0005\u0005G#\u0007\u0000+\u001b\u0000\r\u000e\f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'i');
        }
        String str = new String(charArray);
        char[] charArray2 = "\n\u0005\u0000\u0007\u0000\u001d".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'i');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
