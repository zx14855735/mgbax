package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT extends CmUvjW.A4TApA {
    public static final Parcelable.Creator<ADYaiT> CREATOR = new A5SV6n();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f11272AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f11273AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f11274AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public float f11275AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f11276B25kr6;

    static {
        VOaf();
    }

    public ADYaiT(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f11272AcNBzu = parcel.readByte() != 0;
        this.f11273AlLFFp = parcel.readByte() != 0;
        this.f11274AmA8tU = parcel.readInt();
        this.f11275AzWtSf = parcel.readFloat();
        this.f11276B25kr6 = parcel.readByte() != 0;
    }

    private static /* synthetic */ void VOaf() {
        char[] charArray = "¦ª¨ë¢¤¨ ë§ª¼ë¶\u00ad ©©ë\u008f«¬\u0087·¬¡¢ ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 197);
        }
        String str = new String(charArray);
        char[] charArray2 = "¦©¬«¬±".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 197);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // CmUvjW.A4TApA, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.f11272AcNBzu ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f11273AlLFFp ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f11274AmA8tU);
        parcel.writeFloat(this.f11275AzWtSf);
        parcel.writeByte(this.f11276B25kr6 ? (byte) 1 : (byte) 0);
    }
}
