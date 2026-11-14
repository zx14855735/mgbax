package com.kwad.sdk.core.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface d extends IInterface {

    public static final class a implements d {
        private IBinder aKO;

        public a(IBinder iBinder) {
            this.aKO = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aKO;
        }

        public final boolean getBoos() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.aKO.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() == 0;
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
                return false;
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }

        public final String getIDs() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
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
}
