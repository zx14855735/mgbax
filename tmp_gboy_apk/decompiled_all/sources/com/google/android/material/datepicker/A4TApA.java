package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.EdQ5bb;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA implements Parcelable {
    public static final Parcelable.Creator<A4TApA> CREATOR = new EdQ5bb(2);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final B2KMhB f11575AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final B2KMhB f11576AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final AMqCpz f11577AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final B2KMhB f11578AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final int f11579B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final int f11580B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final int f11581B3GDIM;

    static {
        HNLnRvZ();
    }

    public A4TApA(B2KMhB b2KMhB, B2KMhB b2KMhB2, AMqCpz aMqCpz, B2KMhB b2KMhB3, int i) {
        Objects.requireNonNull(b2KMhB, "start cannot be null");
        Objects.requireNonNull(b2KMhB2, "end cannot be null");
        Objects.requireNonNull(aMqCpz, "validator cannot be null");
        this.f11575AcNBzu = b2KMhB;
        this.f11576AlLFFp = b2KMhB2;
        this.f11578AzWtSf = b2KMhB3;
        this.f11579B25kr6 = i;
        this.f11577AmA8tU = aMqCpz;
        if (b2KMhB3 != null && b2KMhB.f11638AcNBzu.compareTo(b2KMhB3.f11638AcNBzu) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (b2KMhB3 != null && b2KMhB3.f11638AcNBzu.compareTo(b2KMhB2.f11638AcNBzu) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i < 0 || i > BTvldC.A5SV6n(null).getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.f11581B3GDIM = b2KMhB.ADYaiT(b2KMhB2) + 1;
        this.f11580B2KMhB = (b2KMhB2.f11640AmA8tU - b2KMhB.f11640AmA8tU) + 1;
    }

    private static /* synthetic */ void HNLnRvZ() {
        char[] charArray = "úöô·þøôü·ûöà·êñüõõ·Ó÷ðÛëðýþü".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 153);
        }
        String str = new String(charArray);
        char[] charArray2 = "úõð÷ðí".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 153);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A4TApA)) {
            return false;
        }
        A4TApA a4TApA = (A4TApA) obj;
        return this.f11575AcNBzu.equals(a4TApA.f11575AcNBzu) && this.f11576AlLFFp.equals(a4TApA.f11576AlLFFp) && Objects.equals(this.f11578AzWtSf, a4TApA.f11578AzWtSf) && this.f11579B25kr6 == a4TApA.f11579B25kr6 && this.f11577AmA8tU.equals(a4TApA.f11577AmA8tU);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11575AcNBzu, this.f11576AlLFFp, this.f11578AzWtSf, Integer.valueOf(this.f11579B25kr6), this.f11577AmA8tU});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f11575AcNBzu, 0);
        parcel.writeParcelable(this.f11576AlLFFp, 0);
        parcel.writeParcelable(this.f11578AzWtSf, 0);
        parcel.writeParcelable(this.f11577AmA8tU, 0);
        parcel.writeInt(this.f11579B25kr6);
    }
}
