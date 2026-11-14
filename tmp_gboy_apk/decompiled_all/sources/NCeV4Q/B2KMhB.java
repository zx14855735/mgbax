package NCeV4Q;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class B2KMhB implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int AlLFFp2 = com.bumptech.glide.AMqCpz.AlLFFp(parcel);
        int i = 0;
        String str = null;
        N9P37h.A5SV6n a5SV6n = null;
        while (parcel.dataPosition() < AlLFFp2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = com.bumptech.glide.AMqCpz.BI9f7h(parcel, readInt);
            } else if (i2 == 2) {
                str = com.bumptech.glide.AMqCpz.BpkvW3(parcel, readInt);
            } else if (i2 != 5) {
                com.bumptech.glide.AMqCpz.AmA8tU(parcel, readInt);
            } else {
                a5SV6n = (N9P37h.A5SV6n) com.bumptech.glide.AMqCpz.A5SV6n(parcel, readInt, N9P37h.A5SV6n.CREATOR);
            }
        }
        if (parcel.dataPosition() == AlLFFp2) {
            return new A2egSU(i, str, a5SV6n);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(AlLFFp2);
        throw new DXnQ0V.A5SV6n(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new A2egSU[i];
    }
}
