package HIguqb;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AcNBzu extends Binder implements AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final /* synthetic */ int f3373A2egSU = 0;

    public AcNBzu() {
        attachInterface(this, "com.bda.controller.IControllerService");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        IInterface queryLocalInterface;
        if (i == 1598968902) {
            parcel2.writeString("com.bda.controller.IControllerService");
            return true;
        }
        IInterface iInterface = null;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.bda.controller.IControllerService");
                AMqCpz((A2egSU) ARc23Z.A2egSU(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.bda.controller.IControllerService");
                AmA8tU((A2egSU) ARc23Z.A2egSU(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.bda.controller.IControllerService");
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null && (queryLocalInterface = readStrongBinder.queryLocalInterface("com.bda.controller.IControllerMonitor")) != null && (queryLocalInterface instanceof AZkASS)) {
                }
                parcel.readInt();
                ARc23Z();
                throw null;
            case 4:
                parcel.enforceInterface("com.bda.controller.IControllerService");
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.bda.controller.IControllerMonitor");
                    if (queryLocalInterface2 == null || !(queryLocalInterface2 instanceof AZkASS)) {
                        AYUAbz aYUAbz = new AYUAbz();
                        aYUAbz.f3371A2egSU = readStrongBinder2;
                        iInterface = aYUAbz;
                    } else {
                        iInterface = (AZkASS) queryLocalInterface2;
                    }
                }
                AcNBzu((A4TApA) iInterface, parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.bda.controller.IControllerService");
                parcel.readInt();
                int AzWtSf2 = AzWtSf();
                parcel2.writeNoException();
                parcel2.writeInt(AzWtSf2);
                return true;
            case 6:
                parcel.enforceInterface("com.bda.controller.IControllerService");
                parcel.readInt();
                int A5SV6n2 = A5SV6n(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(A5SV6n2);
                return true;
            case 7:
                parcel.enforceInterface("com.bda.controller.IControllerService");
                parcel.readInt();
                parcel.readInt();
                float AYUAbz2 = AYUAbz();
                parcel2.writeNoException();
                parcel2.writeFloat(AYUAbz2);
                return true;
            case 8:
                parcel.enforceInterface("com.bda.controller.IControllerService");
                parcel.readInt();
                parcel.readInt();
                int state = getState();
                parcel2.writeNoException();
                parcel2.writeInt(state);
                return true;
            case 9:
                parcel.enforceInterface("com.bda.controller.IControllerService");
                parcel.readInt();
                B25kr6(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 10:
                parcel.enforceInterface("com.bda.controller.IControllerService");
                B3GDIM((A2egSU) ARc23Z.A2egSU(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.bda.controller.IControllerService");
                parcel.readInt();
                int B2KMhB2 = B2KMhB(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(B2KMhB2);
                return true;
            case 12:
                parcel.enforceInterface("com.bda.controller.IControllerService");
                AlLFFp();
                parcel2.writeNoException();
                return true;
            case 13:
                parcel.enforceInterface("com.bda.controller.IControllerService");
                ASJ6gh();
                parcel2.writeNoException();
                return true;
            case 14:
                parcel.enforceInterface("com.bda.controller.IControllerService");
                boolean AaHO0E2 = AaHO0E();
                parcel2.writeNoException();
                parcel2.writeInt(AaHO0E2 ? 1 : 0);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
