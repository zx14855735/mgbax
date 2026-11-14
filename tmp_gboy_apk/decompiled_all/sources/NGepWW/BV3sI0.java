package NGepWW;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BV3sI0 implements BniPrB {

    /* renamed from: A2egSU, reason: collision with root package name */
    public IBinder f5701A2egSU;

    public final void A2egSU(C2rE4F c2rE4F, BNL6CD bnl6cd) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            obtain.writeInt(1);
            c2rE4F.writeToParcel(obtain, 0);
            obtain.writeStrongBinder(bnl6cd.asBinder());
            this.f5701A2egSU.transact(12, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void A4TApA(NUY5pn.C4FrIb c4FrIb, int i, boolean z) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            obtain.writeStrongBinder(c4FrIb != null ? ((NUY5pn.C2rE4F) c4FrIb).asBinder() : null);
            obtain.writeInt(i);
            obtain.writeInt(z ? 1 : 0);
            this.f5701A2egSU.transact(9, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f5701A2egSU;
    }
}
