package androidx.core.graphics.drawable;

import DdagTj.A2egSU;
import DdagTj.A4TApA;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import org.apache.commons.codec.CharEncoding;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(A2egSU a2egSU) {
        IconCompat iconCompat = new IconCompat();
        int i = iconCompat.f8574A2egSU;
        if (a2egSU.AMqCpz(1)) {
            i = ((A4TApA) a2egSU).AMqCpz.readInt();
        }
        iconCompat.f8574A2egSU = i;
        byte[] bArr = iconCompat.f8576A5SV6n;
        if (a2egSU.AMqCpz(2)) {
            Parcel parcel = ((A4TApA) a2egSU).AMqCpz;
            int readInt = parcel.readInt();
            if (readInt < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[readInt];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f8576A5SV6n = bArr;
        iconCompat.f8577ADYaiT = a2egSU.ARc23Z(iconCompat.f8577ADYaiT, 3);
        int i2 = iconCompat.AMqCpz;
        if (a2egSU.AMqCpz(4)) {
            i2 = ((A4TApA) a2egSU).AMqCpz.readInt();
        }
        iconCompat.AMqCpz = i2;
        int i3 = iconCompat.f8578ARc23Z;
        if (a2egSU.AMqCpz(5)) {
            i3 = ((A4TApA) a2egSU).AMqCpz.readInt();
        }
        iconCompat.f8578ARc23Z = i3;
        iconCompat.f8579ASJ6gh = (ColorStateList) a2egSU.ARc23Z(iconCompat.f8579ASJ6gh, 6);
        String str = iconCompat.f8581AZOQYO;
        if (a2egSU.AMqCpz(7)) {
            str = ((A4TApA) a2egSU).AMqCpz.readString();
        }
        iconCompat.f8581AZOQYO = str;
        String str2 = iconCompat.f8582AZkASS;
        if (a2egSU.AMqCpz(8)) {
            str2 = ((A4TApA) a2egSU).AMqCpz.readString();
        }
        iconCompat.f8582AZkASS = str2;
        iconCompat.f8580AYUAbz = PorterDuff.Mode.valueOf(iconCompat.f8581AZOQYO);
        switch (iconCompat.f8574A2egSU) {
            case -1:
                Parcelable parcelable = iconCompat.f8577ADYaiT;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f8575A4TApA = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f8577ADYaiT;
                if (parcelable2 != null) {
                    iconCompat.f8575A4TApA = parcelable2;
                    return iconCompat;
                }
                byte[] bArr3 = iconCompat.f8576A5SV6n;
                iconCompat.f8575A4TApA = bArr3;
                iconCompat.f8574A2egSU = 3;
                iconCompat.AMqCpz = 0;
                iconCompat.f8578ARc23Z = bArr3.length;
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str3 = new String(iconCompat.f8576A5SV6n, Charset.forName(CharEncoding.UTF_16));
                iconCompat.f8575A4TApA = str3;
                if (iconCompat.f8574A2egSU == 2 && iconCompat.f8582AZkASS == null) {
                    iconCompat.f8582AZkASS = str3.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f8575A4TApA = iconCompat.f8576A5SV6n;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, A2egSU a2egSU) {
        a2egSU.getClass();
        iconCompat.f8581AZOQYO = iconCompat.f8580AYUAbz.name();
        switch (iconCompat.f8574A2egSU) {
            case -1:
                iconCompat.f8577ADYaiT = (Parcelable) iconCompat.f8575A4TApA;
                break;
            case 1:
            case 5:
                iconCompat.f8577ADYaiT = (Parcelable) iconCompat.f8575A4TApA;
                break;
            case 2:
                iconCompat.f8576A5SV6n = ((String) iconCompat.f8575A4TApA).getBytes(Charset.forName(CharEncoding.UTF_16));
                break;
            case 3:
                iconCompat.f8576A5SV6n = (byte[]) iconCompat.f8575A4TApA;
                break;
            case 4:
            case 6:
                iconCompat.f8576A5SV6n = iconCompat.f8575A4TApA.toString().getBytes(Charset.forName(CharEncoding.UTF_16));
                break;
        }
        int i = iconCompat.f8574A2egSU;
        if (-1 != i) {
            a2egSU.AYUAbz(1);
            ((A4TApA) a2egSU).AMqCpz.writeInt(i);
        }
        byte[] bArr = iconCompat.f8576A5SV6n;
        if (bArr != null) {
            a2egSU.AYUAbz(2);
            int length = bArr.length;
            Parcel parcel = ((A4TApA) a2egSU).AMqCpz;
            parcel.writeInt(length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f8577ADYaiT;
        if (parcelable != null) {
            a2egSU.AYUAbz(3);
            ((A4TApA) a2egSU).AMqCpz.writeParcelable(parcelable, 0);
        }
        int i2 = iconCompat.AMqCpz;
        if (i2 != 0) {
            a2egSU.AYUAbz(4);
            ((A4TApA) a2egSU).AMqCpz.writeInt(i2);
        }
        int i3 = iconCompat.f8578ARc23Z;
        if (i3 != 0) {
            a2egSU.AYUAbz(5);
            ((A4TApA) a2egSU).AMqCpz.writeInt(i3);
        }
        ColorStateList colorStateList = iconCompat.f8579ASJ6gh;
        if (colorStateList != null) {
            a2egSU.AYUAbz(6);
            ((A4TApA) a2egSU).AMqCpz.writeParcelable(colorStateList, 0);
        }
        String str = iconCompat.f8581AZOQYO;
        if (str != null) {
            a2egSU.AYUAbz(7);
            ((A4TApA) a2egSU).AMqCpz.writeString(str);
        }
        String str2 = iconCompat.f8582AZkASS;
        if (str2 != null) {
            a2egSU.AYUAbz(8);
            ((A4TApA) a2egSU).AMqCpz.writeString(str2);
        }
    }
}
