package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.depend.qt;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface zg extends IInterface {
    boolean xj(long j, long j2, qt qtVar);

    public static abstract class xj extends Binder implements zg {

        /* renamed from: com.ss.android.socialbase.downloader.depend.zg$xj$xj, reason: collision with other inner class name */
        public static class C0496xj implements zg {
            public static zg xj;
            private IBinder hf;

            public C0496xj(IBinder iBinder) {
                this.hf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hf;
            }

            @Override // com.ss.android.socialbase.downloader.depend.zg
            public boolean xj(long j, long j2, qt qtVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeStrongBinder(qtVar != null ? qtVar.asBinder() : null);
                    if (!this.hf.transact(1, obtain, obtain2, 0) && xj.xj() != null) {
                        boolean xj2 = xj.xj().xj(j, j2, qtVar);
                        obtain2.recycle();
                        obtain.recycle();
                        return xj2;
                    }
                    obtain2.readException();
                    boolean z = obtain2.readInt() != 0;
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public xj() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
        }

        public static zg xj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zg)) ? new C0496xj(iBinder) : (zg) queryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            boolean xj = xj(parcel.readLong(), parcel.readLong(), qt.xj.xj(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(xj ? 1 : 0);
            return true;
        }

        public static zg xj() {
            return C0496xj.xj;
        }
    }
}
