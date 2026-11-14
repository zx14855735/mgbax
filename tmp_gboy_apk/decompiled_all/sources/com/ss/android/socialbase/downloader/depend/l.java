package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface l extends IInterface {
    long xj(int i, int i2);

    public static abstract class xj extends Binder implements l {

        /* renamed from: com.ss.android.socialbase.downloader.depend.l$xj$xj, reason: collision with other inner class name */
        public static class C0489xj implements l {
            public static l xj;
            private IBinder hf;

            public C0489xj(IBinder iBinder) {
                this.hf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hf;
            }

            @Override // com.ss.android.socialbase.downloader.depend.l
            public long xj(int i, int i2) {
                long readLong;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.hf.transact(1, obtain, obtain2, 0) || xj.xj() == null) {
                        obtain2.readException();
                        readLong = obtain2.readLong();
                    } else {
                        readLong = xj.xj().xj(i, i2);
                    }
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public xj() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
        }

        public static l xj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof l)) ? new C0489xj(iBinder) : (l) queryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            long xj = xj(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(xj);
            return true;
        }

        public static l xj() {
            return C0489xj.xj;
        }
    }
}
