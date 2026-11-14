package com.octopus.ad.b.i;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface a extends IInterface {
    String a();

    String a(String str);

    String b(String str);

    /* renamed from: com.octopus.ad.b.i.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0404a extends Binder implements a {
        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0405a(iBinder) : (a) queryLocalInterface;
        }

        public static a b() {
            return C0405a.f12377a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                String a2 = a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                String a3 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a3);
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
                return true;
            }
            parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            String b = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(b);
            return true;
        }

        /* renamed from: com.octopus.ad.b.i.a$a$a, reason: collision with other inner class name */
        public static class C0405a implements a {

            /* renamed from: a, reason: collision with root package name */
            public static a f12377a;
            private IBinder b;

            public C0405a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.octopus.ad.b.i.a
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    if (!this.b.transact(1, obtain, obtain2, 0) && AbstractBinderC0404a.b() != null) {
                        String a2 = AbstractBinderC0404a.b().a();
                        obtain2.recycle();
                        obtain.recycle();
                        return a2;
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.octopus.ad.b.i.a
            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    if (!this.b.transact(3, obtain, obtain2, 0) && AbstractBinderC0404a.b() != null) {
                        String b = AbstractBinderC0404a.b().b(str);
                        obtain2.recycle();
                        obtain.recycle();
                        return b;
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.octopus.ad.b.i.a
            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    if (!this.b.transact(2, obtain, obtain2, 0) && AbstractBinderC0404a.b() != null) {
                        String a2 = AbstractBinderC0404a.b().a(str);
                        obtain2.recycle();
                        obtain.recycle();
                        return a2;
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }
    }
}
