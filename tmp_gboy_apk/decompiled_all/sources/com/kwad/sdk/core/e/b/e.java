package com.kwad.sdk.core.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface e extends IInterface {

    public static final class a implements e {
        private IBinder aKO;

        public a(IBinder iBinder) {
            this.aKO = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aKO;
        }

        @Override // com.kwad.sdk.core.e.b.e
        public final String getOaid() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.aKO.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                    obtain2.recycle();
                    obtain.recycle();
                    return null;
                }
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    String getOaid();
}
