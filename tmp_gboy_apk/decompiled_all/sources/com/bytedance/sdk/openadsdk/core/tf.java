package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface tf extends IInterface {
    IBinder xj(int i);

    public static abstract class xj extends Binder implements tf {

        /* renamed from: com.bytedance.sdk.openadsdk.core.tf$xj$xj, reason: collision with other inner class name */
        public static class C0182xj implements tf {
            public static tf xj;
            private IBinder hf;

            public C0182xj(IBinder iBinder) {
                this.hf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hf;
            }

            @Override // com.bytedance.sdk.openadsdk.core.tf
            public IBinder xj(int i) {
                IBinder readStrongBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IBinderPool");
                    obtain.writeInt(i);
                    if (this.hf.transact(1, obtain, obtain2, 0) || xj.xj() == null) {
                        obtain2.readException();
                        readStrongBinder = obtain2.readStrongBinder();
                    } else {
                        readStrongBinder = xj.xj().xj(i);
                    }
                    return readStrongBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public xj() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IBinderPool");
        }

        public static tf xj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IBinderPool");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof tf)) ? new C0182xj(iBinder) : (tf) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.bytedance.sdk.openadsdk.core.IBinderPool");
                return true;
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IBinderPool");
            IBinder xj = xj(parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(xj);
            return true;
        }

        public static tf xj() {
            return C0182xj.xj;
        }
    }
}
