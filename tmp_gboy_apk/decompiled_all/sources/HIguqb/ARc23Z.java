package HIguqb;

import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ARc23Z extends Binder implements ASJ6gh {
    public ARc23Z() {
        attachInterface(this, "com.bda.controller.IControllerListener");
    }

    public static ASJ6gh A2egSU(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bda.controller.IControllerListener");
        if (queryLocalInterface != null && (queryLocalInterface instanceof ASJ6gh)) {
            return (ASJ6gh) queryLocalInterface;
        }
        AMqCpz aMqCpz = new AMqCpz();
        aMqCpz.f3370A2egSU = iBinder;
        return aMqCpz;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        AmA8tU createFromParcel;
        if (i == 1) {
            parcel.enforceInterface("com.bda.controller.IControllerListener");
            createFromParcel = parcel.readInt() != 0 ? AmA8tU.CREATOR.createFromParcel(parcel) : null;
            A2egSU a2egSU = (A2egSU) this;
            if (createFromParcel.f3381AlLFFp == 1) {
                ADYaiT aDYaiT = a2egSU.f3359A2egSU;
                if (aDYaiT.AMqCpz != null) {
                    C4FrIb.A2egSU a2egSU2 = new C4FrIb.A2egSU(aDYaiT, createFromParcel, 7, false);
                    Handler handler = aDYaiT.f3364A5SV6n;
                    if (handler != null) {
                        handler.post(a2egSU2);
                    } else {
                        a2egSU2.run();
                    }
                }
            }
            parcel2.writeNoException();
            return true;
        }
        if (i == 2) {
            parcel.enforceInterface("com.bda.controller.IControllerListener");
            createFromParcel = parcel.readInt() != 0 ? AzWtSf.CREATOR.createFromParcel(parcel) : null;
            A2egSU a2egSU3 = (A2egSU) this;
            if (createFromParcel.f3381AlLFFp == 1) {
                ADYaiT aDYaiT2 = a2egSU3.f3359A2egSU;
                if (aDYaiT2.AMqCpz != null) {
                    C4FrIb.A2egSU a2egSU4 = new C4FrIb.A2egSU(aDYaiT2, createFromParcel, 8, false);
                    Handler handler2 = aDYaiT2.f3364A5SV6n;
                    if (handler2 != null) {
                        handler2.post(a2egSU4);
                    } else {
                        a2egSU4.run();
                    }
                }
            }
            parcel2.writeNoException();
            return true;
        }
        if (i != 3) {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString("com.bda.controller.IControllerListener");
            return true;
        }
        parcel.enforceInterface("com.bda.controller.IControllerListener");
        createFromParcel = parcel.readInt() != 0 ? B25kr6.CREATOR.createFromParcel(parcel) : null;
        A2egSU a2egSU5 = (A2egSU) this;
        if (createFromParcel.f3381AlLFFp == 1) {
            ADYaiT aDYaiT3 = a2egSU5.f3359A2egSU;
            if (aDYaiT3.AMqCpz != null) {
                C4FrIb.A2egSU a2egSU6 = new C4FrIb.A2egSU(aDYaiT3, createFromParcel, 9, false);
                Handler handler3 = aDYaiT3.f3364A5SV6n;
                if (handler3 != null) {
                    handler3.post(a2egSU6);
                } else {
                    a2egSU6.run();
                }
            }
        }
        parcel2.writeNoException();
        return true;
    }
}
