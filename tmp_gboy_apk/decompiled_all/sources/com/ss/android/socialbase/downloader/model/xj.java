package com.ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.depend.c;
import com.ss.android.socialbase.downloader.depend.d;
import com.ss.android.socialbase.downloader.depend.et;
import com.ss.android.socialbase.downloader.depend.f;
import com.ss.android.socialbase.downloader.depend.kd;
import com.ss.android.socialbase.downloader.depend.l;
import com.ss.android.socialbase.downloader.depend.pl;
import com.ss.android.socialbase.downloader.depend.pz;
import com.ss.android.socialbase.downloader.depend.tf;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.depend.zg;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface xj extends IInterface {
    pz c();

    zg d();

    l f();

    d hf(int i);

    com.ss.android.socialbase.downloader.depend.kd hf();

    f kd();

    c p();

    int pl();

    tf tf();

    z u();

    et w();

    pl w(int i);

    int xj(int i);

    d xj(int i, int i2);

    DownloadInfo xj();

    y y();

    /* renamed from: com.ss.android.socialbase.downloader.model.xj$xj, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0503xj extends Binder implements xj {
        public AbstractBinderC0503xj() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        public static xj g() {
            return C0504xj.xj;
        }

        public static xj xj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof xj)) ? new C0504xj(iBinder) : (xj) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    DownloadInfo xj = xj();
                    parcel2.writeNoException();
                    if (xj != null) {
                        parcel2.writeInt(1);
                        xj.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    com.ss.android.socialbase.downloader.depend.kd hf = hf();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(hf != null ? hf.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int xj2 = xj(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(xj2);
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    d xj3 = xj(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(xj3 != null ? xj3.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    d hf2 = hf(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(hf2 != null ? hf2.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    et w = w();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(w != null ? w.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    z u = u();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(u != null ? u.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    f kd = kd();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(kd != null ? kd.asBinder() : null);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    y y = y();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(y != null ? y.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    pz c = c();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(c != null ? c.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    l f = f();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(f != null ? f.asBinder() : null);
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    zg d = d();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(d != null ? d.asBinder() : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    tf tf = tf();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(tf != null ? tf.asBinder() : null);
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    c p = p();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(p != null ? p.asBinder() : null);
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int pl2 = pl();
                    parcel2.writeNoException();
                    parcel2.writeInt(pl2);
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    pl w2 = w(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(w2 != null ? w2.asBinder() : null);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.model.xj$xj$xj, reason: collision with other inner class name */
        public static class C0504xj implements xj {
            public static xj xj;
            private IBinder hf;

            public C0504xj(IBinder iBinder) {
                this.hf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hf;
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public pz c() {
                pz xj2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (this.hf.transact(10, obtain, obtain2, 0) || AbstractBinderC0503xj.g() == null) {
                        obtain2.readException();
                        xj2 = pz.xj.xj(obtain2.readStrongBinder());
                    } else {
                        xj2 = AbstractBinderC0503xj.g().c();
                    }
                    return xj2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public zg d() {
                zg xj2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (this.hf.transact(12, obtain, obtain2, 0) || AbstractBinderC0503xj.g() == null) {
                        obtain2.readException();
                        xj2 = zg.xj.xj(obtain2.readStrongBinder());
                    } else {
                        xj2 = AbstractBinderC0503xj.g().d();
                    }
                    return xj2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public l f() {
                l xj2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (this.hf.transact(11, obtain, obtain2, 0) || AbstractBinderC0503xj.g() == null) {
                        obtain2.readException();
                        xj2 = l.xj.xj(obtain2.readStrongBinder());
                    } else {
                        xj2 = AbstractBinderC0503xj.g().f();
                    }
                    return xj2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public com.ss.android.socialbase.downloader.depend.kd hf() {
                com.ss.android.socialbase.downloader.depend.kd xj2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (this.hf.transact(2, obtain, obtain2, 0) || AbstractBinderC0503xj.g() == null) {
                        obtain2.readException();
                        xj2 = kd.xj.xj(obtain2.readStrongBinder());
                    } else {
                        xj2 = AbstractBinderC0503xj.g().hf();
                    }
                    return xj2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public f kd() {
                f xj2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (this.hf.transact(8, obtain, obtain2, 0) || AbstractBinderC0503xj.g() == null) {
                        obtain2.readException();
                        xj2 = f.xj.xj(obtain2.readStrongBinder());
                    } else {
                        xj2 = AbstractBinderC0503xj.g().kd();
                    }
                    return xj2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public c p() {
                c xj2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (this.hf.transact(14, obtain, obtain2, 0) || AbstractBinderC0503xj.g() == null) {
                        obtain2.readException();
                        xj2 = c.xj.xj(obtain2.readStrongBinder());
                    } else {
                        xj2 = AbstractBinderC0503xj.g().p();
                    }
                    return xj2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public int pl() {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (this.hf.transact(15, obtain, obtain2, 0) || AbstractBinderC0503xj.g() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = AbstractBinderC0503xj.g().pl();
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public tf tf() {
                tf xj2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (this.hf.transact(13, obtain, obtain2, 0) || AbstractBinderC0503xj.g() == null) {
                        obtain2.readException();
                        xj2 = tf.xj.xj(obtain2.readStrongBinder());
                    } else {
                        xj2 = AbstractBinderC0503xj.g().tf();
                    }
                    return xj2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public z u() {
                z xj2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (this.hf.transact(7, obtain, obtain2, 0) || AbstractBinderC0503xj.g() == null) {
                        obtain2.readException();
                        xj2 = z.xj.xj(obtain2.readStrongBinder());
                    } else {
                        xj2 = AbstractBinderC0503xj.g().u();
                    }
                    return xj2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public et w() {
                et xj2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (this.hf.transact(6, obtain, obtain2, 0) || AbstractBinderC0503xj.g() == null) {
                        obtain2.readException();
                        xj2 = et.xj.xj(obtain2.readStrongBinder());
                    } else {
                        xj2 = AbstractBinderC0503xj.g().w();
                    }
                    return xj2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public DownloadInfo xj() {
                DownloadInfo createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (this.hf.transact(1, obtain, obtain2, 0) || AbstractBinderC0503xj.g() == null) {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } else {
                        createFromParcel = AbstractBinderC0503xj.g().xj();
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public y y() {
                y xj2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (this.hf.transact(9, obtain, obtain2, 0) || AbstractBinderC0503xj.g() == null) {
                        obtain2.readException();
                        xj2 = y.xj.xj(obtain2.readStrongBinder());
                    } else {
                        xj2 = AbstractBinderC0503xj.g().y();
                    }
                    return xj2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public d hf(int i) {
                d xj2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    if (!this.hf.transact(5, obtain, obtain2, 0) && AbstractBinderC0503xj.g() != null) {
                        xj2 = AbstractBinderC0503xj.g().hf(i);
                    } else {
                        obtain2.readException();
                        xj2 = d.xj.xj(obtain2.readStrongBinder());
                    }
                    return xj2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public pl w(int i) {
                pl xj2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    if (!this.hf.transact(16, obtain, obtain2, 0) && AbstractBinderC0503xj.g() != null) {
                        xj2 = AbstractBinderC0503xj.g().w(i);
                    } else {
                        obtain2.readException();
                        xj2 = pl.xj.xj(obtain2.readStrongBinder());
                    }
                    return xj2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public int xj(int i) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    if (!this.hf.transact(3, obtain, obtain2, 0) && AbstractBinderC0503xj.g() != null) {
                        readInt = AbstractBinderC0503xj.g().xj(i);
                    } else {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public d xj(int i, int i2) {
                d xj2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.hf.transact(4, obtain, obtain2, 0) && AbstractBinderC0503xj.g() != null) {
                        xj2 = AbstractBinderC0503xj.g().xj(i, i2);
                    } else {
                        obtain2.readException();
                        xj2 = d.xj.xj(obtain2.readStrongBinder());
                    }
                    return xj2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
