package NUY5pn;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BIYEnU implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Object[] objArr;
        int AlLFFp2 = com.bumptech.glide.AMqCpz.AlLFFp(parcel);
        String str = null;
        IBinder iBinder = null;
        NSK3xo.A2egSU[] a2egSUArr = null;
        Bundle bundle = null;
        Account account = null;
        long j = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < AlLFFp2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.bumptech.glide.AMqCpz.BI9f7h(parcel, readInt);
                    break;
                case 2:
                    i2 = com.bumptech.glide.AMqCpz.BI9f7h(parcel, readInt);
                    break;
                case 3:
                    i3 = com.bumptech.glide.AMqCpz.BI9f7h(parcel, readInt);
                    break;
                case 4:
                    str = com.bumptech.glide.AMqCpz.BpkvW3(parcel, readInt);
                    break;
                case 5:
                    int A2egSU2 = com.bumptech.glide.AMqCpz.A2egSU(parcel, readInt);
                    int dataPosition = parcel.dataPosition();
                    if (A2egSU2 != 0) {
                        IBinder readStrongBinder = parcel.readStrongBinder();
                        parcel.setDataPosition(A2egSU2 + dataPosition);
                        iBinder = readStrongBinder;
                        break;
                    } else {
                        iBinder = null;
                        break;
                    }
                case 6:
                    Parcelable.Creator<NSK3xo.A2egSU> creator = NSK3xo.A2egSU.CREATOR;
                    int A2egSU3 = com.bumptech.glide.AMqCpz.A2egSU(parcel, readInt);
                    int dataPosition2 = parcel.dataPosition();
                    if (A2egSU3 == 0) {
                        objArr = null;
                    } else {
                        Object[] createTypedArray = parcel.createTypedArray(creator);
                        parcel.setDataPosition(A2egSU3 + dataPosition2);
                        objArr = createTypedArray;
                    }
                    a2egSUArr = (NSK3xo.A2egSU[]) objArr;
                    break;
                case 7:
                    int A2egSU4 = com.bumptech.glide.AMqCpz.A2egSU(parcel, readInt);
                    int dataPosition3 = parcel.dataPosition();
                    if (A2egSU4 != 0) {
                        Bundle readBundle = parcel.readBundle();
                        parcel.setDataPosition(A2egSU4 + dataPosition3);
                        bundle = readBundle;
                        break;
                    } else {
                        bundle = null;
                        break;
                    }
                case 8:
                    account = (Account) com.bumptech.glide.AMqCpz.A5SV6n(parcel, readInt, Account.CREATOR);
                    break;
                case 9:
                    com.bumptech.glide.AMqCpz.AYUAbz(parcel, readInt, 8);
                    j = parcel.readLong();
                    break;
                default:
                    com.bumptech.glide.AMqCpz.AmA8tU(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == AlLFFp2) {
            return new BI9f7h(i, i2, i3, str, iBinder, a2egSUArr, bundle, account, j);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(AlLFFp2);
        throw new DXnQ0V.A5SV6n(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new BI9f7h[i];
    }
}
