package NGepWW;

import android.os.RemoteException;
import android.os.TransactionTooLargeException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class D8MqeW {
    public static NSK3xo.A4TApA A2egSU(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (remoteException instanceof TransactionTooLargeException) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new NSK3xo.A4TApA(8, sb.toString());
    }

    public abstract void A4TApA(DXuj49 dXuj49, boolean z);

    public abstract void A5SV6n(EdhSi6 edhSi6);

    public abstract void ADYaiT(NSK3xo.A4TApA a4TApA);
}
