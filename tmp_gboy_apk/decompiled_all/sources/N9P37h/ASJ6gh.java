package N9P37h;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ASJ6gh implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int AlLFFp2 = com.bumptech.glide.AMqCpz.AlLFFp(parcel);
        int i = 0;
        A2egSU a2egSU = null;
        String str = "";
        String str2 = "";
        while (parcel.dataPosition() < AlLFFp2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = com.bumptech.glide.AMqCpz.BI9f7h(parcel, readInt);
            } else if (i2 == 4) {
                str = com.bumptech.glide.AMqCpz.BpkvW3(parcel, readInt);
            } else if (i2 == 7) {
                a2egSU = (A2egSU) com.bumptech.glide.AMqCpz.A5SV6n(parcel, readInt, A2egSU.CREATOR);
            } else if (i2 != 8) {
                com.bumptech.glide.AMqCpz.AmA8tU(parcel, readInt);
            } else {
                str2 = com.bumptech.glide.AMqCpz.BpkvW3(parcel, readInt);
            }
        }
        if (parcel.dataPosition() == AlLFFp2) {
            return new ADYaiT(i, str, a2egSU, str2);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(AlLFFp2);
        throw new DXnQ0V.A5SV6n(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new ADYaiT[i];
    }
}
