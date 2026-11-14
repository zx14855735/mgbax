package com.bytedance.pangle.servermanager;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements Parcelable {
    public static final Parcelable.Creator<xj> CREATOR = new Parcelable.Creator<xj>() { // from class: com.bytedance.pangle.servermanager.xj.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public xj createFromParcel(Parcel parcel) {
            return new xj(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public xj[] newArray(int i) {
            return new xj[i];
        }
    };
    private final IBinder xj;

    static {
        JmTaOQg();
    }

    public xj(Parcel parcel) {
        this.xj = parcel.readStrongBinder();
    }

    private static /* synthetic */ void JmTaOQg() {
        char[] charArray = "q}\u007f<us\u007fw<p}k<azw~~<X|{P`{vuw".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 18);
        }
        String str = new String(charArray);
        char[] charArray2 = "q~{|{f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 18);
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
        parcel.writeStrongBinder(this.xj);
    }

    public IBinder xj() {
        return this.xj;
    }

    public xj(IBinder iBinder) {
        this.xj = iBinder;
    }
}
