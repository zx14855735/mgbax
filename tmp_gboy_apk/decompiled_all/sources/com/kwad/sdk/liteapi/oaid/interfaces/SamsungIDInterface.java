package com.kwad.sdk.liteapi.oaid.interfaces;

import A5SV6n.A2egSU;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.sdk.liteapi.LiteApiLogger;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface SamsungIDInterface extends IInterface {

    public static class a implements SamsungIDInterface {
        private IBinder aKP;

        public a(IBinder iBinder) {
            this.aKP = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aKP;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.SamsungIDInterface
        public final String getID() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    this.aKP.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Exception e) {
                    LiteApiLogger.printStackTrace(e);
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

    String getID();
}
