package BNL6CD;

import AaHO0E.H0qugq;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA extends CmUvjW.A4TApA {
    public static final Parcelable.Creator<A4TApA> CREATOR = new H0qugq(1);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public SparseArray f1425AcNBzu;

    static {
        RgMX();
    }

    public A4TApA(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        int[] iArr = new int[readInt];
        parcel.readIntArray(iArr);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
        this.f1425AcNBzu = new SparseArray(readInt);
        for (int i = 0; i < readInt; i++) {
            this.f1425AcNBzu.append(iArr[i], readParcelableArray[i]);
        }
    }

    private static /* synthetic */ void RgMX() {
        char[] charArray = "%)+h!'+#h$)?h5.#**h\f(/\u00044/\"!#".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'F');
        }
        String str = new String(charArray);
        char[] charArray2 = "%*/(/2".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'F');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // CmUvjW.A4TApA, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        SparseArray sparseArray = this.f1425AcNBzu;
        int size = sparseArray != null ? sparseArray.size() : 0;
        parcel.writeInt(size);
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = this.f1425AcNBzu.keyAt(i2);
            parcelableArr[i2] = (Parcelable) this.f1425AcNBzu.valueAt(i2);
        }
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i);
    }
}
