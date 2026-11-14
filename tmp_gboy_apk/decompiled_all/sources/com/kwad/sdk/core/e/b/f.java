package com.kwad.sdk.core.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface f extends IInterface {

    public static final class a implements f {
        private IBinder aKO;

        public a(IBinder iBinder) {
            this.aKO = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aKO;
        }

        @Override // com.kwad.sdk.core.e.b.f
        public final String getSerID(String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.aKO.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                    obtain.recycle();
                    obtain2.recycle();
                    return null;
                }
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }
    }

    String getSerID(String str, String str2, String str3);
}
