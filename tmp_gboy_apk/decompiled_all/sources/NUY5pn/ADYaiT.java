package NUY5pn;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.util.Log;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class ADYaiT extends Binder implements IInterface {
    public ADYaiT() {
        attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.google.android.gms.common.internal.IGmsCallbacks");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
            parcel.readInt();
            if (parcel.readInt() != 0) {
            }
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
            parcel2.writeNoException();
            return true;
        }
        parcel.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
        int readInt = parcel.readInt();
        IBinder readStrongBinder = parcel.readStrongBinder();
        Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
        AzWtSf azWtSf = (AzWtSf) this;
        AYUAbz.A5SV6n(azWtSf.f5964A2egSU, "onPostInitComplete can be called only once per call to getRemoteService");
        BJ7GGh bJ7GGh = azWtSf.f5964A2egSU;
        DG07BK.A2egSU a2egSU = bJ7GGh.f5984A2egSU;
        a2egSU.sendMessage(a2egSU.obtainMessage(1, azWtSf.f5965A4TApA, -1, new B3GDIM(bJ7GGh, readInt, readStrongBinder, bundle)));
        azWtSf.f5964A2egSU = null;
        parcel2.writeNoException();
        return true;
    }
}
