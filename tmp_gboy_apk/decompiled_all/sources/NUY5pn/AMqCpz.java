package NUY5pn;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz implements ASJ6gh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public IBinder f5945A2egSU;

    public final void A2egSU(AzWtSf azWtSf, BI9f7h bI9f7h) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(azWtSf);
            obtain.writeInt(1);
            bI9f7h.writeToParcel(obtain, 0);
            this.f5945A2egSU.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f5945A2egSU;
    }
}
