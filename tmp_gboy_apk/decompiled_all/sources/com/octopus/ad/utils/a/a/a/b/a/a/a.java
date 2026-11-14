package com.octopus.ad.utils.a.a.a.b.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface a extends IInterface {

    /* renamed from: com.octopus.ad.utils.a.a.a.b.a.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0428a extends Binder implements a {

        /* renamed from: com.octopus.ad.utils.a.a.a.b.a.a.a$a$a, reason: collision with other inner class name */
        public static class C0429a implements a {

            /* renamed from: a, reason: collision with root package name */
            public static a f12667a;
            private IBinder b;

            public C0429a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.octopus.ad.utils.a.a.a.b.a.a.a
            public boolean a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (!this.b.transact(1, obtain, obtain2, 0) && AbstractBinderC0428a.f() != null) {
                        return AbstractBinderC0428a.f().a();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.octopus.ad.utils.a.a.a.b.a.a.a
            public String b() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (this.b.transact(2, obtain, obtain2, 0) || AbstractBinderC0428a.f() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = AbstractBinderC0428a.f().b();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.octopus.ad.utils.a.a.a.b.a.a.a
            public String c() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (this.b.transact(3, obtain, obtain2, 0) || AbstractBinderC0428a.f() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = AbstractBinderC0428a.f().c();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.octopus.ad.utils.a.a.a.b.a.a.a
            public String d() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (this.b.transact(4, obtain, obtain2, 0) || AbstractBinderC0428a.f() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = AbstractBinderC0428a.f().d();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.octopus.ad.utils.a.a.a.b.a.a.a
            public String e() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (this.b.transact(5, obtain, obtain2, 0) || AbstractBinderC0428a.f() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = AbstractBinderC0428a.f().e();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0429a(iBinder) : (a) queryLocalInterface;
        }

        public static a f() {
            return C0429a.f12667a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                boolean a2 = a();
                parcel2.writeNoException();
                parcel2.writeInt(a2 ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                String b = b();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                String c = c();
                parcel2.writeNoException();
                parcel2.writeString(c);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                String d = d();
                parcel2.writeNoException();
                parcel2.writeString(d);
                return true;
            }
            if (i != 5) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                return true;
            }
            parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            String e = e();
            parcel2.writeNoException();
            parcel2.writeString(e);
            return true;
        }
    }

    boolean a();

    String b();

    String c();

    String d();

    String e();
}
