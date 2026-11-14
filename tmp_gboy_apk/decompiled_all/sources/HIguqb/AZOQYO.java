package HIguqb;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AZOQYO extends Binder implements AZkASS {
    public AZOQYO() {
        attachInterface(this, "com.bda.controller.IControllerMonitor");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString("com.bda.controller.IControllerMonitor");
            return true;
        }
        parcel.enforceInterface("com.bda.controller.IControllerMonitor");
        parcel.readInt();
        parcel.readInt();
        parcel.readString();
        ((A4TApA) this).f3360A2egSU.getClass();
        parcel2.writeNoException();
        return true;
    }
}
