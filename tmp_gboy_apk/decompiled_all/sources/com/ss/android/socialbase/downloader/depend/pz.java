package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.depend.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface pz extends IInterface {
    boolean xj(jk jkVar);

    public static abstract class xj extends Binder implements pz {

        /* renamed from: com.ss.android.socialbase.downloader.depend.pz$xj$xj, reason: collision with other inner class name */
        public static class C0491xj implements pz {
            public static pz xj;
            private IBinder hf;

            public C0491xj(IBinder iBinder) {
                this.hf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hf;
            }

            @Override // com.ss.android.socialbase.downloader.depend.pz
            public boolean xj(jk jkVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                    obtain.writeStrongBinder(jkVar != null ? jkVar.asBinder() : null);
                    if (!this.hf.transact(1, obtain, obtain2, 0) && xj.xj() != null) {
                        boolean xj2 = xj.xj().xj(jkVar);
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
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
        }

        public static pz xj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof pz)) ? new C0491xj(iBinder) : (pz) queryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            boolean xj = xj(jk.xj.xj(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(xj ? 1 : 0);
            return true;
        }

        public static pz xj() {
            return C0491xj.xj;
        }
    }
}
