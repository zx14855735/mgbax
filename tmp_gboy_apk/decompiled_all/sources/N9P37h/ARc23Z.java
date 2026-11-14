package N9P37h;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ARc23Z implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int AlLFFp2 = com.bumptech.glide.AMqCpz.AlLFFp(parcel);
        ArrayList arrayList = null;
        Account account = null;
        String str = null;
        String str2 = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < AlLFFp2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.bumptech.glide.AMqCpz.BI9f7h(parcel, readInt);
                    break;
                case 2:
                    Parcelable.Creator<NSK3xo.A2egSU> creator = NSK3xo.A2egSU.CREATOR;
                    int A2egSU2 = com.bumptech.glide.AMqCpz.A2egSU(parcel, readInt);
                    int dataPosition = parcel.dataPosition();
                    if (A2egSU2 != 0) {
                        ArrayList createTypedArrayList = parcel.createTypedArrayList(creator);
                        parcel.setDataPosition(A2egSU2 + dataPosition);
                        arrayList = createTypedArrayList;
                        break;
                    } else {
                        arrayList = null;
                        break;
                    }
                case 3:
                    account = (Account) com.bumptech.glide.AMqCpz.A5SV6n(parcel, readInt, Account.CREATOR);
                    break;
                case 4:
                    z = com.bumptech.glide.AMqCpz.AzWtSf(parcel, readInt);
                    break;
                case 5:
                    z2 = com.bumptech.glide.AMqCpz.AzWtSf(parcel, readInt);
                    break;
                case 6:
                    z3 = com.bumptech.glide.AMqCpz.AzWtSf(parcel, readInt);
                    break;
                case 7:
                    str = com.bumptech.glide.AMqCpz.BpkvW3(parcel, readInt);
                    break;
                case 8:
                    str2 = com.bumptech.glide.AMqCpz.BpkvW3(parcel, readInt);
                    break;
                default:
                    com.bumptech.glide.AMqCpz.AmA8tU(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == AlLFFp2) {
            return new A5SV6n(i, arrayList, account, z, z2, z3, str, str2);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(AlLFFp2);
        throw new DXnQ0V.A5SV6n(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new A5SV6n[i];
    }
}
