package Oay4Bh;

import AaHO0E.H0qugq;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends CmUvjW.A4TApA {
    public static final Parcelable.Creator<A4TApA> CREATOR = new H0qugq(8);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f6456AcNBzu;

    static {
        hbpXwaT();
    }

    public A4TApA(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f6456AcNBzu = parcel.readInt() == 1;
    }

    private static /* synthetic */ void hbpXwaT() {
        char[] charArray = "»·µö¿¹µ½öº·¡ö«°½´´ö\u0092¶±\u009aª±¼¿½".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 216);
        }
        String str = new String(charArray);
        char[] charArray2 = "»´±¶±¬".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 216);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // CmUvjW.A4TApA, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f6456AcNBzu ? 1 : 0);
    }
}
