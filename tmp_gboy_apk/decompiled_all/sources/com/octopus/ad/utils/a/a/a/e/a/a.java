package com.octopus.ad.utils.a.a.a.e.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface a extends IInterface {
    String a(String str, String str2, String str3);

    /* renamed from: com.octopus.ad.utils.a.a.a.e.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0434a extends Binder implements a {

        /* renamed from: com.octopus.ad.utils.a.a.a.e.a.a$a$a, reason: collision with other inner class name */
        public static class C0435a implements a {

            /* renamed from: a, reason: collision with root package name */
            public static a f12670a;
            private IBinder b;

            public C0435a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.octopus.ad.utils.a.a.a.e.a.a
            public String a(String str, String str2, String str3) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (this.b.transact(1, obtain, obtain2, 0) || AbstractBinderC0434a.a() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = AbstractBinderC0434a.a().a(str, str2, str3);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0435a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.heytap.openid.IOpenID");
                return true;
            }
            parcel.enforceInterface("com.heytap.openid.IOpenID");
            String a2 = a(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(a2);
            return true;
        }

        public static a a() {
            return C0435a.f12670a;
        }
    }
}
