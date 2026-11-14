package NGepWW;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AlLFFp extends Binder implements AmA8tU {
    public AlLFFp() {
        attachInterface(this, "com.google.android.gms.common.internal.service.ICommonCallbacks");
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
            parcel2.writeString("com.google.android.gms.common.internal.service.ICommonCallbacks");
            return true;
        }
        parcel.enforceInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
        a(parcel.readInt());
        parcel2.writeNoException();
        return true;
    }
}
