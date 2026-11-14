package NGepWW;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class BPw6Q8 extends Binder implements BTvldC {
    public BPw6Q8() {
        attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 3) {
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (parcel.readInt() != 0) {
                NOd7IU.A2egSU.CREATOR.createFromParcel(parcel);
            }
            if (parcel.readInt() != 0) {
                BIYEnU.CREATOR.createFromParcel(parcel);
            }
            parcel2.writeNoException();
            return true;
        }
        if (i == 4) {
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (parcel.readInt() != 0) {
                NSK3xo.A4TApA.CREATOR.createFromParcel(parcel);
            }
            parcel2.writeNoException();
            return true;
        }
        if (i == 6) {
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (parcel.readInt() != 0) {
                NSK3xo.A4TApA.CREATOR.createFromParcel(parcel);
            }
            parcel2.writeNoException();
            return true;
        }
        if (i == 7) {
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (parcel.readInt() != 0) {
                NSK3xo.A4TApA.CREATOR.createFromParcel(parcel);
            }
            if (parcel.readInt() != 0) {
                N9P37h.A2egSU.CREATOR.createFromParcel(parcel);
            }
            parcel2.writeNoException();
            return true;
        }
        if (i != 8) {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString("com.google.android.gms.signin.internal.ISignInCallbacks");
            return true;
        }
        parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
        AZOQYO(parcel.readInt() != 0 ? CASmeH.CREATOR.createFromParcel(parcel) : null);
        parcel2.writeNoException();
        return true;
    }
}
