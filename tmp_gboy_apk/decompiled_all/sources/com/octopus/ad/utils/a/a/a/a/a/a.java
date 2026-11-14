package com.octopus.ad.utils.a.a.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface a extends IInterface {
    String a(String str);

    boolean a();

    String b();

    String b(String str);

    String c();

    /* renamed from: com.octopus.ad.utils.a.a.a.a.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0426a extends Binder implements a {
        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0427a(iBinder) : (a) queryLocalInterface;
        }

        public static a d() {
            return C0427a.f12666a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                boolean a2 = a();
                parcel2.writeNoException();
                parcel2.writeInt(a2 ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String a3 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a3);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String b = b();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String c = c();
                parcel2.writeNoException();
                parcel2.writeString(c);
                return true;
            }
            if (i != 5) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.android.creator.IdsSupplier");
                return true;
            }
            parcel.enforceInterface("com.android.creator.IdsSupplier");
            String b2 = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(b2);
            return true;
        }

        /* renamed from: com.octopus.ad.utils.a.a.a.a.a.a$a$a, reason: collision with other inner class name */
        public static class C0427a implements a {

            /* renamed from: a, reason: collision with root package name */
            public static a f12666a;
            private IBinder b;

            public C0427a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.octopus.ad.utils.a.a.a.a.a.a
            public boolean a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (!this.b.transact(1, obtain, obtain2, 0) && AbstractBinderC0426a.d() != null) {
                        return AbstractBinderC0426a.d().a();
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

            @Override // com.octopus.ad.utils.a.a.a.a.a.a
            public String b() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (this.b.transact(3, obtain, obtain2, 0) || AbstractBinderC0426a.d() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = AbstractBinderC0426a.d().b();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.octopus.ad.utils.a.a.a.a.a.a
            public String c() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (this.b.transact(4, obtain, obtain2, 0) || AbstractBinderC0426a.d() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = AbstractBinderC0426a.d().c();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.octopus.ad.utils.a.a.a.a.a.a
            public String b(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    obtain.writeString(str);
                    if (!this.b.transact(5, obtain, obtain2, 0) && AbstractBinderC0426a.d() != null) {
                        readString = AbstractBinderC0426a.d().b(str);
                    } else {
                        obtain2.readException();
                        readString = obtain2.readString();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.octopus.ad.utils.a.a.a.a.a.a
            public String a(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    obtain.writeString(str);
                    if (!this.b.transact(2, obtain, obtain2, 0) && AbstractBinderC0426a.d() != null) {
                        readString = AbstractBinderC0426a.d().a(str);
                    } else {
                        obtain2.readException();
                        readString = obtain2.readString();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
