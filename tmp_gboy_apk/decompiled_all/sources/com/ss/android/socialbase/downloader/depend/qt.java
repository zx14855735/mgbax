package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface qt extends IInterface {

    public static abstract class xj extends Binder implements qt {

        /* renamed from: com.ss.android.socialbase.downloader.depend.qt$xj$xj, reason: collision with other inner class name */
        public static class C0492xj implements qt {
            public static qt xj;
            private IBinder hf;

            public C0492xj(IBinder iBinder) {
                this.hf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hf;
            }

            @Override // com.ss.android.socialbase.downloader.depend.qt
            public void xj() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                    if (this.hf.transact(1, obtain, obtain2, 0) || xj.hf() == null) {
                        obtain2.readException();
                    } else {
                        xj.hf().xj();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public xj() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
        }

        public static qt hf() {
            return C0492xj.xj;
        }

        public static qt xj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof qt)) ? new C0492xj(iBinder) : (qt) queryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            xj();
            parcel2.writeNoException();
            return true;
        }
    }

    void xj();
}
