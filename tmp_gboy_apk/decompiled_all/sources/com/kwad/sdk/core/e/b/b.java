package com.kwad.sdk.core.e.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.sdk.core.e.b.c;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface b extends IInterface {

    public static class a extends Binder implements b {
        private IBinder aKO;

        public a(IBinder iBinder) {
            this.aKO = iBinder;
        }

        public final void a(c cVar) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                obtain.writeStrongBinder(cVar != null ? (c.a) cVar : null);
                this.aKO.transact(2, obtain, obtain2, 0);
                com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "gets + " + this.aKO);
                obtain2.readException();
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aKO;
        }

        public final void b(c cVar) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                obtain.writeStrongBinder(cVar != null ? (c.a) cVar : null);
                this.aKO.transact(3, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                try {
                } finally {
                }
            }
        }
    }
}
