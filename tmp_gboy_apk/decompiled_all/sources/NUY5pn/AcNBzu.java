package NUY5pn;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AcNBzu implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int AlLFFp2 = com.bumptech.glide.AMqCpz.AlLFFp(parcel);
        IBinder iBinder = null;
        NOd7IU.A2egSU a2egSU = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < AlLFFp2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = com.bumptech.glide.AMqCpz.BI9f7h(parcel, readInt);
            } else if (i2 == 2) {
                int A2egSU2 = com.bumptech.glide.AMqCpz.A2egSU(parcel, readInt);
                int dataPosition = parcel.dataPosition();
                if (A2egSU2 == 0) {
                    iBinder = null;
                } else {
                    iBinder = parcel.readStrongBinder();
                    parcel.setDataPosition(A2egSU2 + dataPosition);
                }
            } else if (i2 == 3) {
                a2egSU = (NOd7IU.A2egSU) com.bumptech.glide.AMqCpz.A5SV6n(parcel, readInt, NOd7IU.A2egSU.CREATOR);
            } else if (i2 == 4) {
                z = com.bumptech.glide.AMqCpz.AzWtSf(parcel, readInt);
            } else if (i2 != 5) {
                com.bumptech.glide.AMqCpz.AmA8tU(parcel, readInt);
            } else {
                z2 = com.bumptech.glide.AMqCpz.AzWtSf(parcel, readInt);
            }
        }
        if (parcel.dataPosition() == AlLFFp2) {
            return new AaHO0E(i, iBinder, a2egSU, z, z2);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(AlLFFp2);
        throw new DXnQ0V.A5SV6n(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new AaHO0E[i];
    }
}
