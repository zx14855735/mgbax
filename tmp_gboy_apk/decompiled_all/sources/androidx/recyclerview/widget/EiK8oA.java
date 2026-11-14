package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class EiK8oA implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        StaggeredGridLayoutManager.A2egSU a2egSU = new StaggeredGridLayoutManager.A2egSU();
        a2egSU.f9474AcNBzu = parcel.readInt();
        a2egSU.f9475AlLFFp = parcel.readInt();
        int readInt = parcel.readInt();
        a2egSU.f9476AmA8tU = readInt;
        if (readInt > 0) {
            int[] iArr = new int[readInt];
            a2egSU.f9477AzWtSf = iArr;
            parcel.readIntArray(iArr);
        }
        int readInt2 = parcel.readInt();
        a2egSU.f9478B25kr6 = readInt2;
        if (readInt2 > 0) {
            int[] iArr2 = new int[readInt2];
            a2egSU.f9479B2KMhB = iArr2;
            parcel.readIntArray(iArr2);
        }
        a2egSU.f9481B4ZgIw = parcel.readInt() == 1;
        a2egSU.f9482B7CMnp = parcel.readInt() == 1;
        a2egSU.f9483B9tovu = parcel.readInt() == 1;
        a2egSU.f9480B3GDIM = parcel.readArrayList(EdhSi6.class.getClassLoader());
        return a2egSU;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new StaggeredGridLayoutManager.A2egSU[i];
    }
}
