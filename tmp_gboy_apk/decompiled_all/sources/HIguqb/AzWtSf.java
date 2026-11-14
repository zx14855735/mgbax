package HIguqb;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf extends B2KMhB {
    public static final Parcelable.Creator<AzWtSf> CREATOR = new AaHO0E.AlLFFp(12);

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final SparseArray f3376AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final SparseArray f3377AzWtSf;

    static {
        USrX();
    }

    public AzWtSf(Parcel parcel) {
        super(parcel);
        int readInt = parcel.readInt();
        this.f3376AmA8tU = new SparseArray(readInt);
        for (int i = 0; i < readInt; i++) {
            this.f3376AmA8tU.put(parcel.readInt(), Float.valueOf(parcel.readFloat()));
        }
        this.f3377AzWtSf = new SparseArray(parcel.readInt());
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f3377AzWtSf.put(parcel.readInt(), Float.valueOf(parcel.readFloat()));
        }
    }

    private static /* synthetic */ void USrX() {
        char[] charArray = "ÝÑÓ\u0090ÙßÓÛ\u0090ÜÑÇ\u0090ÍÖÛÒÒ\u0090ôÐ×üÌ×ÚÙÛ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 190);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÝÒ×Ð×Ê".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 190);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // HIguqb.B2KMhB, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // HIguqb.B2KMhB, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        SparseArray sparseArray = this.f3376AmA8tU;
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeFloat(((Float) sparseArray.valueAt(i2)).floatValue());
        }
        SparseArray sparseArray2 = this.f3377AzWtSf;
        int size2 = sparseArray2.size();
        parcel.writeInt(size2);
        for (int i3 = 0; i3 < size2; i3++) {
            parcel.writeInt(sparseArray2.keyAt(i3));
            parcel.writeFloat(((Float) sparseArray2.valueAt(i3)).floatValue());
        }
    }
}
