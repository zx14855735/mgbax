package HIguqb;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E implements AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public IBinder f3372A2egSU;

    @Override // HIguqb.AlLFFp
    public final int A5SV6n(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.bda.controller.IControllerService");
            obtain.writeInt(1);
            obtain.writeInt(i);
            this.f3372A2egSU.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // HIguqb.AlLFFp
    public final void AMqCpz(A2egSU a2egSU, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.bda.controller.IControllerService");
            if (a2egSU == null) {
                a2egSU = null;
            }
            obtain.writeStrongBinder(a2egSU);
            obtain.writeInt(i);
            this.f3372A2egSU.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // HIguqb.AlLFFp
    public final void ARc23Z() {
        throw null;
    }

    @Override // HIguqb.AlLFFp
    public final void AcNBzu(A4TApA a4TApA, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.bda.controller.IControllerService");
            if (a4TApA == null) {
                a4TApA = null;
            }
            obtain.writeStrongBinder(a4TApA);
            obtain.writeInt(i);
            this.f3372A2egSU.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // HIguqb.AlLFFp
    public final void AmA8tU(A2egSU a2egSU, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.bda.controller.IControllerService");
            if (a2egSU == null) {
                a2egSU = null;
            }
            obtain.writeStrongBinder(a2egSU);
            obtain.writeInt(i);
            this.f3372A2egSU.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // HIguqb.AlLFFp
    public final void B25kr6(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.bda.controller.IControllerService");
            obtain.writeInt(1);
            obtain.writeInt(i);
            this.f3372A2egSU.transact(9, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // HIguqb.AlLFFp
    public final int B2KMhB(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.bda.controller.IControllerService");
            obtain.writeInt(1);
            obtain.writeInt(i);
            this.f3372A2egSU.transact(11, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // HIguqb.AlLFFp
    public final void B3GDIM(A2egSU a2egSU, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.bda.controller.IControllerService");
            if (a2egSU == null) {
                a2egSU = null;
            }
            obtain.writeStrongBinder(a2egSU);
            obtain.writeInt(i);
            this.f3372A2egSU.transact(10, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3372A2egSU;
    }
}
