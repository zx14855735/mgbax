package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class EdQ5bb implements Parcelable.Creator {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f9386A2egSU;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f9386A2egSU) {
            case 0:
                EdhSi6 edhSi6 = new EdhSi6();
                edhSi6.f9387AcNBzu = parcel.readInt();
                edhSi6.f9388AlLFFp = parcel.readInt();
                edhSi6.f9390AzWtSf = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    edhSi6.f9389AmA8tU = iArr;
                    parcel.readIntArray(iArr);
                }
                return edhSi6;
            case 1:
                return new androidx.swiperefreshlayout.widget.AZkASS(parcel);
            case 2:
                return new com.google.android.material.datepicker.A4TApA((com.google.android.material.datepicker.B2KMhB) parcel.readParcelable(com.google.android.material.datepicker.B2KMhB.class.getClassLoader()), (com.google.android.material.datepicker.B2KMhB) parcel.readParcelable(com.google.android.material.datepicker.B2KMhB.class.getClassLoader()), (com.google.android.material.datepicker.AMqCpz) parcel.readParcelable(com.google.android.material.datepicker.AMqCpz.class.getClassLoader()), (com.google.android.material.datepicker.B2KMhB) parcel.readParcelable(com.google.android.material.datepicker.B2KMhB.class.getClassLoader()), parcel.readInt());
            case 3:
                return new com.google.android.material.datepicker.AMqCpz(parcel.readLong());
            default:
                return com.google.android.material.datepicker.B2KMhB.A2egSU(parcel.readInt(), parcel.readInt());
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f9386A2egSU) {
            case 0:
                return new EdhSi6[i];
            case 1:
                return new androidx.swiperefreshlayout.widget.AZkASS[i];
            case 2:
                return new com.google.android.material.datepicker.A4TApA[i];
            case 3:
                return new com.google.android.material.datepicker.AMqCpz[i];
            default:
                return new com.google.android.material.datepicker.B2KMhB[i];
        }
    }
}
