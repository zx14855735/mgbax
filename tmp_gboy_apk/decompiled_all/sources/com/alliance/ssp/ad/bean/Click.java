package com.alliance.ssp.ad.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

@A5SV6n.A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class Click implements Parcelable {
    public static final Parcelable.Creator<Click> CREATOR = new A2egSU();
    public Float clickCountdownTime;
    public int clickTimes;
    public String limitation;
    public Float probability;

    public class A2egSU implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return new Click(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new Click[i];
        }
    }

    static {
        mwHRYVJ();
    }

    public Click(Parcel parcel) {
        try {
            this.limitation = parcel.readString();
            this.probability = Float.valueOf(parcel.readFloat());
            if (this.clickCountdownTime != null) {
                this.clickCountdownTime = Float.valueOf(parcel.readFloat());
            }
            this.clickTimes = parcel.readInt();
        } catch (Exception unused) {
        }
    }

    private static /* synthetic */ void mwHRYVJ() {
        char[] charArray = "ª¦¤ç®¨¤¬ç«¦°çº¡¬¥¥ç\u0083§ \u008b» \u00ad®¬".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 201);
        }
        String str = new String(charArray);
        char[] charArray2 = "ª¥ § ½".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 201);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.limitation);
        parcel.writeFloat(this.probability.floatValue());
        Float f = this.clickCountdownTime;
        if (f != null) {
            parcel.writeFloat(f.floatValue());
        }
        parcel.writeInt(this.clickTimes);
    }
}
