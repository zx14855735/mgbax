package NUY5pn;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AZkASS implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int AlLFFp2 = com.bumptech.glide.AMqCpz.AlLFFp(parcel);
        Account account = null;
        N9P37h.A2egSU a2egSU = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < AlLFFp2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = com.bumptech.glide.AMqCpz.BI9f7h(parcel, readInt);
            } else if (i3 == 2) {
                account = (Account) com.bumptech.glide.AMqCpz.A5SV6n(parcel, readInt, Account.CREATOR);
            } else if (i3 == 3) {
                i2 = com.bumptech.glide.AMqCpz.BI9f7h(parcel, readInt);
            } else if (i3 != 4) {
                com.bumptech.glide.AMqCpz.AmA8tU(parcel, readInt);
            } else {
                a2egSU = (N9P37h.A2egSU) com.bumptech.glide.AMqCpz.A5SV6n(parcel, readInt, N9P37h.A2egSU.CREATOR);
            }
        }
        if (parcel.dataPosition() == AlLFFp2) {
            return new AZOQYO(i, account, i2, a2egSU);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(AlLFFp2);
        throw new DXnQ0V.A5SV6n(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new AZOQYO[i];
    }
}
