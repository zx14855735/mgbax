package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(DdagTj.A2egSU a2egSU) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        DdagTj.A5SV6n a5SV6n = remoteActionCompat.f8567A2egSU;
        boolean z = true;
        if (a2egSU.AMqCpz(1)) {
            a5SV6n = a2egSU.ASJ6gh();
        }
        remoteActionCompat.f8567A2egSU = (IconCompat) a5SV6n;
        CharSequence charSequence = remoteActionCompat.f8568A4TApA;
        if (a2egSU.AMqCpz(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((DdagTj.A4TApA) a2egSU).AMqCpz);
        }
        remoteActionCompat.f8568A4TApA = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f8569A5SV6n;
        if (a2egSU.AMqCpz(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((DdagTj.A4TApA) a2egSU).AMqCpz);
        }
        remoteActionCompat.f8569A5SV6n = charSequence2;
        remoteActionCompat.f8570ADYaiT = (PendingIntent) a2egSU.ARc23Z(remoteActionCompat.f8570ADYaiT, 4);
        boolean z2 = remoteActionCompat.AMqCpz;
        if (a2egSU.AMqCpz(5)) {
            z2 = ((DdagTj.A4TApA) a2egSU).AMqCpz.readInt() != 0;
        }
        remoteActionCompat.AMqCpz = z2;
        boolean z3 = remoteActionCompat.f8571ARc23Z;
        if (!a2egSU.AMqCpz(6)) {
            z = z3;
        } else if (((DdagTj.A4TApA) a2egSU).AMqCpz.readInt() == 0) {
            z = false;
        }
        remoteActionCompat.f8571ARc23Z = z;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, DdagTj.A2egSU a2egSU) {
        a2egSU.getClass();
        IconCompat iconCompat = remoteActionCompat.f8567A2egSU;
        a2egSU.AYUAbz(1);
        a2egSU.AZOQYO(iconCompat);
        CharSequence charSequence = remoteActionCompat.f8568A4TApA;
        a2egSU.AYUAbz(2);
        Parcel parcel = ((DdagTj.A4TApA) a2egSU).AMqCpz;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f8569A5SV6n;
        a2egSU.AYUAbz(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        PendingIntent pendingIntent = remoteActionCompat.f8570ADYaiT;
        a2egSU.AYUAbz(4);
        parcel.writeParcelable(pendingIntent, 0);
        boolean z = remoteActionCompat.AMqCpz;
        a2egSU.AYUAbz(5);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = remoteActionCompat.f8571ARc23Z;
        a2egSU.AYUAbz(6);
        parcel.writeInt(z2 ? 1 : 0);
    }
}
