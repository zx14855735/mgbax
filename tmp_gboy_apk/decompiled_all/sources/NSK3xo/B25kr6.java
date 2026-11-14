package NSK3xo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class B25kr6 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int AlLFFp2 = com.bumptech.glide.AMqCpz.AlLFFp(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < AlLFFp2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = com.bumptech.glide.AMqCpz.BI9f7h(parcel, readInt);
            } else if (i2 != 2) {
                com.bumptech.glide.AMqCpz.AmA8tU(parcel, readInt);
            } else {
                str = com.bumptech.glide.AMqCpz.BpkvW3(parcel, readInt);
            }
        }
        if (parcel.dataPosition() == AlLFFp2) {
            return new A2egSU(i, str);
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
