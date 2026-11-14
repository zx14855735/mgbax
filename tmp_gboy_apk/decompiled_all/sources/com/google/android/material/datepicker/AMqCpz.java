package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.EdQ5bb;
import java.lang.reflect.Method;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz implements Parcelable {
    public static final Parcelable.Creator<AMqCpz> CREATOR = new EdQ5bb(3);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final long f11584AcNBzu;

    static {
        NeQb();
    }

    public AMqCpz(long j) {
        this.f11584AcNBzu = j;
    }

    private static /* synthetic */ void NeQb() {
        char[] charArray = "øôöµüúöþµùôâµèóþ÷÷µÑõòÙéòÿüþ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 155);
        }
        String str = new String(charArray);
        char[] charArray2 = "ø÷òõòï".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 155);
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
        return (obj instanceof AMqCpz) && this.f11584AcNBzu == ((AMqCpz) obj).f11584AcNBzu;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f11584AcNBzu)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f11584AcNBzu);
    }
}
