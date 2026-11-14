package com.ss.android.downloadlib.xj.xj;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf implements Parcelable {
    public static final Parcelable.Creator<hf> CREATOR = new Parcelable.Creator<hf>() { // from class: com.ss.android.downloadlib.xj.xj.hf.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public hf createFromParcel(Parcel parcel) {
            return new hf(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public hf[] newArray(int i) {
            return new hf[i];
        }
    };
    public int hf;
    public String kd;
    public int u;
    public String w;
    public int xj;
    public String y;

    static {
        nnYAfWx();
    }

    public hf() {
        this.w = "";
        this.kd = "";
        this.y = "";
    }

    private static /* synthetic */ void nnYAfWx() {
        char[] charArray = "°¼¾ý´²¾¶ý±¼ªý »¶¿¿ý\u0099½º\u0091¡º·´¶".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 211);
        }
        String str = new String(charArray);
        char[] charArray2 = "°¿º½º§".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 211);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            hf hfVar = (hf) obj;
            if (this.xj == hfVar.xj && this.hf == hfVar.hf) {
                String str = this.w;
                if (str != null) {
                    return str.equals(hfVar.w);
                }
                if (hfVar.w == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.xj * 31) + this.hf) * 31;
        String str = this.w;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.xj);
        parcel.writeInt(this.hf);
        parcel.writeString(this.w);
        parcel.writeString(this.kd);
        parcel.writeString(this.y);
        parcel.writeInt(this.u);
    }

    public hf(Parcel parcel) {
        this.w = "";
        this.kd = "";
        this.y = "";
        this.xj = parcel.readInt();
        this.hf = parcel.readInt();
        this.w = parcel.readString();
        this.kd = parcel.readString();
        this.y = parcel.readString();
        this.u = parcel.readInt();
    }
}
