package com.bytedance.adsdk.ugeno.viewpager;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj implements Parcelable {
    private final Parcelable hf;
    public static final xj xj = new xj() { // from class: com.bytedance.adsdk.ugeno.viewpager.xj.1
    };
    public static final Parcelable.Creator<xj> CREATOR = new Parcelable.ClassLoaderCreator<xj>() { // from class: com.bytedance.adsdk.ugeno.viewpager.xj.2
        @Override // android.os.Parcelable.Creator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public xj createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public xj createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return xj.xj;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public xj[] newArray(int i) {
            return new xj[i];
        }
    };

    static {
        ojjgW();
    }

    private static /* synthetic */ void ojjgW() {
        char[] charArray = "\u0097\u009b\u0099Ú\u0093\u0095\u0099\u0091Ú\u0096\u009b\u008dÚ\u0087\u009c\u0091\u0098\u0098Ú¾\u009a\u009d¶\u0086\u009d\u0090\u0093\u0091".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 244);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0097\u0098\u009d\u009a\u009d\u0080".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 244);
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
        parcel.writeParcelable(this.hf, i);
    }

    public final Parcelable xj() {
        return this.hf;
    }

    private xj() {
        this.hf = null;
    }

    public xj(Parcelable parcelable) {
        if (parcelable != null) {
            this.hf = parcelable == xj ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public xj(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.hf = readParcelable == null ? xj : readParcelable;
    }
}
