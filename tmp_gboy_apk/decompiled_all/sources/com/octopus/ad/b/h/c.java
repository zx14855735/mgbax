package com.octopus.ad.b.h;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* renamed from: com.octopus.ad.b.h.c$a$a, reason: collision with other inner class name */
        public static class C0403a implements c {
            public static c b;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f12373a;

            public C0403a(IBinder iBinder) {
                this.f12373a = iBinder;
            }

            @Override // com.octopus.ad.b.h.c
            public String a(String str, String str2, String str3) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (this.f12373a.transact(1, obtain, obtain2, 0) || a.a() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = a.a().a(str, str2, str3);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12373a;
            }
        }

        public static c a() {
            return C0403a.b;
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new C0403a(iBinder) : (c) queryLocalInterface;
        }
    }

    String a(String str, String str2, String str3);
}
