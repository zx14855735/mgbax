package NGepWW;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BJ7GGh implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int AlLFFp2 = com.bumptech.glide.AMqCpz.AlLFFp(parcel);
        Intent intent = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < AlLFFp2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = com.bumptech.glide.AMqCpz.BI9f7h(parcel, readInt);
            } else if (i3 == 2) {
                i2 = com.bumptech.glide.AMqCpz.BI9f7h(parcel, readInt);
            } else if (i3 != 3) {
                com.bumptech.glide.AMqCpz.AmA8tU(parcel, readInt);
            } else {
                intent = (Intent) com.bumptech.glide.AMqCpz.A5SV6n(parcel, readInt, Intent.CREATOR);
            }
        }
        if (parcel.dataPosition() == AlLFFp2) {
            return new BIYEnU(i, i2, intent);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(AlLFFp2);
        throw new DXnQ0V.A5SV6n(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new BIYEnU[i];
    }
}
