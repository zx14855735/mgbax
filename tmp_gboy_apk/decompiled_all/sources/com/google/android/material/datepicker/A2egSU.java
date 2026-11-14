package com.google.android.material.datepicker;

import com.bytedance.pangle.ZeusPluginEventCallback;
import java.lang.reflect.Method;
import java.util.Calendar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final /* synthetic */ int f11573A4TApA = 0;

    /* renamed from: A2egSU, reason: collision with root package name */
    public Long f11574A2egSU;

    static {
        B2KMhB A2egSU2 = B2KMhB.A2egSU(1900, 0);
        Calendar A5SV6n2 = BTvldC.A5SV6n(null);
        A5SV6n2.setTimeInMillis(A2egSU2.f11643B2KMhB);
        BTvldC.A2egSU(A5SV6n2).getTimeInMillis();
        B2KMhB A2egSU3 = B2KMhB.A2egSU(ZeusPluginEventCallback.EVENT_FINISH_LOAD, 11);
        Calendar A5SV6n3 = BTvldC.A5SV6n(null);
        A5SV6n3.setTimeInMillis(A2egSU3.f11643B2KMhB);
        BTvldC.A2egSU(A5SV6n3).getTimeInMillis();
        mULa();
    }

    private static /* synthetic */ void mULa() {
        char[] charArray = "áíï¬åãïç¬àíû¬ñêçîî¬ÈìëÀðëæåç".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 130);
        }
        String str = new String(charArray);
        char[] charArray2 = "áîëìëö".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 130);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
