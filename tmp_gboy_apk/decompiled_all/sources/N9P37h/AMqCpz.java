package N9P37h;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AMqCpz implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int AlLFFp2 = com.bumptech.glide.AMqCpz.AlLFFp(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < AlLFFp2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.bumptech.glide.AMqCpz.BI9f7h(parcel, readInt);
                    break;
                case 2:
                    str = com.bumptech.glide.AMqCpz.BpkvW3(parcel, readInt);
                    break;
                case 3:
                    str2 = com.bumptech.glide.AMqCpz.BpkvW3(parcel, readInt);
                    break;
                case 4:
                    str3 = com.bumptech.glide.AMqCpz.BpkvW3(parcel, readInt);
                    break;
                case 5:
                    str4 = com.bumptech.glide.AMqCpz.BpkvW3(parcel, readInt);
                    break;
                case 6:
                    uri = (Uri) com.bumptech.glide.AMqCpz.A5SV6n(parcel, readInt, Uri.CREATOR);
                    break;
                case 7:
                    str5 = com.bumptech.glide.AMqCpz.BpkvW3(parcel, readInt);
                    break;
                case 8:
                    com.bumptech.glide.AMqCpz.AYUAbz(parcel, readInt, 8);
                    j = parcel.readLong();
                    break;
                case 9:
                    str6 = com.bumptech.glide.AMqCpz.BpkvW3(parcel, readInt);
                    break;
                case 10:
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
                case 11:
                    str7 = com.bumptech.glide.AMqCpz.BpkvW3(parcel, readInt);
                    break;
                case 12:
                    str8 = com.bumptech.glide.AMqCpz.BpkvW3(parcel, readInt);
                    break;
                default:
                    com.bumptech.glide.AMqCpz.AmA8tU(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == AlLFFp2) {
            return new A2egSU(i, str, str2, str3, str4, uri, str5, j, str6, arrayList, str7, str8);
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
