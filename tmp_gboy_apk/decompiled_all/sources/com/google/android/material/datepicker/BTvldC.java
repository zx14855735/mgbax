package com.google.android.material.datepicker;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class BTvldC {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final AtomicReference f11658A2egSU = new AtomicReference();

    static {
        SAmeyNn();
    }

    public static Calendar A2egSU(Calendar calendar) {
        Calendar A5SV6n2 = A5SV6n(calendar);
        Calendar A5SV6n3 = A5SV6n(null);
        A5SV6n3.set(A5SV6n2.get(1), A5SV6n2.get(2), A5SV6n2.get(5));
        return A5SV6n3;
    }

    public static Calendar A4TApA() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        return calendar;
    }

    public static Calendar A5SV6n(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        if (calendar == null) {
            calendar2.clear();
            return calendar2;
        }
        calendar2.setTimeInMillis(calendar.getTimeInMillis());
        return calendar2;
    }

    private static /* synthetic */ void SAmeyNn() {
        char[] charArray = "ÁÍÏ\u008cÅÃÏÇ\u008cÀÍÛ\u008cÑÊÇÎÎ\u008cèÌËàÐËÆÅÇ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 162);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÁÎËÌËÖ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 162);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
