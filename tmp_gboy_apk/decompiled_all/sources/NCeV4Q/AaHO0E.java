package NCeV4Q;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AaHO0E extends Binder implements AcNBzu {
    public AaHO0E() {
        attachInterface(this, "com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1598968902) {
            parcel2.writeString("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
            return true;
        }
        switch (i) {
            case 101:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                if (parcel.readInt() != 0) {
                    N9P37h.A2egSU.CREATOR.createFromParcel(parcel);
                }
                if (parcel.readInt() != 0) {
                    NSK3xo.A4TApA.CREATOR.createFromParcel(parcel);
                }
                throw new UnsupportedOperationException();
            case 102:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                if (parcel.readInt() != 0) {
                    NSK3xo.A4TApA.CREATOR.createFromParcel(parcel);
                }
                throw new UnsupportedOperationException();
            case 103:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                AZkASS(parcel.readInt() != 0 ? NSK3xo.A4TApA.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
