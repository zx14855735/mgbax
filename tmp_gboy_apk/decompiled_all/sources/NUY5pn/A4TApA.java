package NUY5pn;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A4TApA extends Binder implements A5SV6n {
    public A4TApA() {
        attachInterface(this, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            parcel.enforceInterface("com.google.android.gms.common.internal.ICertData");
            N8piWc.A4TApA a4TApA = new N8piWc.A4TApA(((NOd7IU.AZOQYO) this).A4TApA());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(a4TApA);
            return true;
        }
        if (i != 2) {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString("com.google.android.gms.common.internal.ICertData");
            return true;
        }
        parcel.enforceInterface("com.google.android.gms.common.internal.ICertData");
        parcel2.writeNoException();
        parcel2.writeInt(((NOd7IU.AZOQYO) this).f5869A2egSU);
        return true;
    }
}
