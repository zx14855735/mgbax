package NGepWW;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class C4FrIb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int AlLFFp2 = com.bumptech.glide.AMqCpz.AlLFFp(parcel);
        int i = 0;
        NUY5pn.AZOQYO azoqyo = null;
        while (parcel.dataPosition() < AlLFFp2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = com.bumptech.glide.AMqCpz.BI9f7h(parcel, readInt);
            } else if (i2 != 2) {
                com.bumptech.glide.AMqCpz.AmA8tU(parcel, readInt);
            } else {
                azoqyo = (NUY5pn.AZOQYO) com.bumptech.glide.AMqCpz.A5SV6n(parcel, readInt, NUY5pn.AZOQYO.CREATOR);
            }
        }
        if (parcel.dataPosition() == AlLFFp2) {
            return new C2rE4F(i, azoqyo);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(AlLFFp2);
        throw new DXnQ0V.A5SV6n(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new C2rE4F[i];
    }
}
