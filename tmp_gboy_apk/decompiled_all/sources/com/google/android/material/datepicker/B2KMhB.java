package com.google.android.material.datepicker;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import androidx.recyclerview.widget.EdQ5bb;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B2KMhB implements Comparable, Parcelable {
    public static final Parcelable.Creator<B2KMhB> CREATOR = new EdQ5bb(4);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Calendar f11638AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f11639AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f11640AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final int f11641AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final int f11642B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final long f11643B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public String f11644B3GDIM;

    static {
        fubCZA();
    }

    public B2KMhB(Calendar calendar) {
        calendar.set(5, 1);
        Calendar A2egSU2 = BTvldC.A2egSU(calendar);
        this.f11638AcNBzu = A2egSU2;
        this.f11639AlLFFp = A2egSU2.get(2);
        this.f11640AmA8tU = A2egSU2.get(1);
        this.f11641AzWtSf = A2egSU2.getMaximum(7);
        this.f11642B25kr6 = A2egSU2.getActualMaximum(5);
        this.f11643B2KMhB = A2egSU2.getTimeInMillis();
    }

    public static B2KMhB A2egSU(int i, int i2) {
        Calendar A5SV6n2 = BTvldC.A5SV6n(null);
        A5SV6n2.set(1, i);
        A5SV6n2.set(2, i2);
        return new B2KMhB(A5SV6n2);
    }

    public static B2KMhB A4TApA(long j) {
        Calendar A5SV6n2 = BTvldC.A5SV6n(null);
        A5SV6n2.setTimeInMillis(j);
        return new B2KMhB(A5SV6n2);
    }

    private static /* synthetic */ void fubCZA() {
        char[] charArray = "amo,ecog,`m{,qjgnn,Hlk@pkfeg".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 2);
        }
        String str = new String(charArray);
        char[] charArray2 = "anklkv".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 2);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final String A5SV6n() {
        String formatDateTime;
        DateFormat instanceForSkeleton;
        TimeZone timeZone;
        DisplayContext unused;
        if (this.f11644B3GDIM == null) {
            long timeInMillis = this.f11638AcNBzu.getTimeInMillis();
            if (Build.VERSION.SDK_INT >= 24) {
                Locale locale = Locale.getDefault();
                AtomicReference atomicReference = BTvldC.f11658A2egSU;
                instanceForSkeleton = DateFormat.getInstanceForSkeleton("yMMMM", locale);
                timeZone = TimeZone.getTimeZone("UTC");
                instanceForSkeleton.setTimeZone(timeZone);
                unused = DisplayContext.CAPITALIZATION_FOR_STANDALONE;
                instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
                formatDateTime = instanceForSkeleton.format(new Date(timeInMillis));
            } else {
                formatDateTime = DateUtils.formatDateTime(null, timeInMillis, 8228);
            }
            this.f11644B3GDIM = formatDateTime;
        }
        return this.f11644B3GDIM;
    }

    public final int ADYaiT(B2KMhB b2KMhB) {
        if (!(this.f11638AcNBzu instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (b2KMhB.f11639AlLFFp - this.f11639AlLFFp) + ((b2KMhB.f11640AmA8tU - this.f11640AmA8tU) * 12);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f11638AcNBzu.compareTo(((B2KMhB) obj).f11638AcNBzu);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B2KMhB)) {
            return false;
        }
        B2KMhB b2KMhB = (B2KMhB) obj;
        return this.f11639AlLFFp == b2KMhB.f11639AlLFFp && this.f11640AmA8tU == b2KMhB.f11640AmA8tU;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f11639AlLFFp), Integer.valueOf(this.f11640AmA8tU)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11640AmA8tU);
        parcel.writeInt(this.f11639AlLFFp);
    }
}
