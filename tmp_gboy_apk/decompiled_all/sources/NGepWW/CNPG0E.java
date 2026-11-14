package NGepWW;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CNPG0E implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int AlLFFp2 = com.bumptech.glide.AMqCpz.AlLFFp(parcel);
        int i = 0;
        NOd7IU.A2egSU a2egSU = null;
        NUY5pn.AaHO0E aaHO0E = null;
        while (parcel.dataPosition() < AlLFFp2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = com.bumptech.glide.AMqCpz.BI9f7h(parcel, readInt);
            } else if (i2 == 2) {
                a2egSU = (NOd7IU.A2egSU) com.bumptech.glide.AMqCpz.A5SV6n(parcel, readInt, NOd7IU.A2egSU.CREATOR);
            } else if (i2 != 3) {
                com.bumptech.glide.AMqCpz.AmA8tU(parcel, readInt);
            } else {
                aaHO0E = (NUY5pn.AaHO0E) com.bumptech.glide.AMqCpz.A5SV6n(parcel, readInt, NUY5pn.AaHO0E.CREATOR);
            }
        }
        if (parcel.dataPosition() == AlLFFp2) {
            return new CASmeH(i, a2egSU, aaHO0E);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(AlLFFp2);
        throw new DXnQ0V.A5SV6n(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new CASmeH[i];
    }
}
