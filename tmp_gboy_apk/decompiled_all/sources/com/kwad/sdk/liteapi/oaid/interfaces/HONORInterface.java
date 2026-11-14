package com.kwad.sdk.liteapi.oaid.interfaces;

import A5SV6n.A2egSU;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface HONORInterface extends IInterface {

    public static class a extends Binder implements HONORInterface {
        private IBinder aKO;

        public a(IBinder iBinder) {
            this.aKO = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aKO;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORInterface
        public final void getBoos(HONORProxyInterface hONORProxyInterface) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                obtain.writeStrongBinder(hONORProxyInterface != null ? (HONORProxyInterface.a) hONORProxyInterface : null);
                this.aKO.transact(3, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORInterface
        public final void getIDs(HONORProxyInterface hONORProxyInterface) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                obtain.writeStrongBinder(hONORProxyInterface != null ? (HONORProxyInterface.a) hONORProxyInterface : null);
                this.aKO.transact(2, obtain, obtain2, 0);
                LiteApiLogger.d("HONORDeviceIDHelper", "gets + " + this.aKO);
                obtain2.readException();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    void getBoos(HONORProxyInterface hONORProxyInterface);

    void getIDs(HONORProxyInterface hONORProxyInterface);
}
