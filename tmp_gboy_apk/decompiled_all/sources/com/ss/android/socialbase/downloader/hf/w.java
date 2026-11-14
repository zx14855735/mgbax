package com.ss.android.socialbase.downloader.hf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.hf.hf;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface w extends IInterface {
    DownloadInfo c(int i);

    DownloadInfo d(int i);

    DownloadInfo f(int i);

    DownloadInfo hf(int i);

    DownloadInfo hf(int i, long j);

    List<DownloadInfo> hf();

    List<DownloadInfo> hf(String str);

    void hf(int i, List<com.ss.android.socialbase.downloader.model.hf> list);

    void hf(DownloadInfo downloadInfo);

    void hf(com.ss.android.socialbase.downloader.model.hf hfVar);

    DownloadInfo kd(int i, long j);

    boolean kd();

    boolean kd(int i);

    DownloadInfo tf(int i);

    DownloadInfo u(int i, long j);

    List<DownloadInfo> u(String str);

    void u(int i);

    boolean u();

    DownloadInfo w(int i, long j);

    List<com.ss.android.socialbase.downloader.model.hf> w(int i);

    List<DownloadInfo> w(String str);

    void w();

    DownloadInfo xj(int i, int i2);

    DownloadInfo xj(int i, long j);

    DownloadInfo xj(int i, long j, String str, String str2);

    List<DownloadInfo> xj(String str);

    void xj();

    void xj(int i, int i2, int i3, int i4);

    void xj(int i, int i2, int i3, long j);

    void xj(int i, int i2, long j);

    void xj(int i, List<com.ss.android.socialbase.downloader.model.hf> list);

    void xj(hf hfVar);

    void xj(com.ss.android.socialbase.downloader.model.hf hfVar);

    boolean xj(int i);

    boolean xj(DownloadInfo downloadInfo);

    boolean y(int i);

    public static abstract class xj extends Binder implements w {
        public xj() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        }

        public static w xj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof w)) ? new C0500xj(iBinder) : (w) queryLocalInterface;
        }

        public static w y() {
            return C0500xj.xj;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    xj();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean xj = xj(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(xj ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo hf = hf(parcel.readInt());
                    parcel2.writeNoException();
                    if (hf != null) {
                        parcel2.writeInt(1);
                        hf.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> xj2 = xj(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(xj2);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> hf2 = hf(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(hf2);
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> w = w(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(w);
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> u = u(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(u);
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> hf3 = hf();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(hf3);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<com.ss.android.socialbase.downloader.model.hf> w2 = w(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(w2);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    u(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    xj(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.hf.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    hf(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.hf.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    xj(parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    xj(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    xj(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo xj3 = xj(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (xj3 != null) {
                        parcel2.writeInt(1);
                        xj3.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 17:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean xj4 = xj(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(xj4 ? 1 : 0);
                    return true;
                case 18:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean kd = kd(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(kd ? 1 : 0);
                    return true;
                case 19:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean y = y(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(y ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    w();
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo c = c(parcel.readInt());
                    parcel2.writeNoException();
                    if (c != null) {
                        parcel2.writeInt(1);
                        c.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 22:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo xj5 = xj(parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (xj5 != null) {
                        parcel2.writeInt(1);
                        xj5.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 23:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo xj6 = xj(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (xj6 != null) {
                        parcel2.writeInt(1);
                        xj6.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 24:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo hf4 = hf(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (hf4 != null) {
                        parcel2.writeInt(1);
                        hf4.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 25:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo f = f(parcel.readInt());
                    parcel2.writeNoException();
                    if (f != null) {
                        parcel2.writeInt(1);
                        f.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 26:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo w3 = w(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (w3 != null) {
                        parcel2.writeInt(1);
                        w3.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 27:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo u2 = u(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (u2 != null) {
                        parcel2.writeInt(1);
                        u2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 28:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo kd2 = kd(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (kd2 != null) {
                        parcel2.writeInt(1);
                        kd2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 29:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo d = d(parcel.readInt());
                    parcel2.writeNoException();
                    if (d != null) {
                        parcel2.writeInt(1);
                        d.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 30:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo tf = tf(parcel.readInt());
                    parcel2.writeNoException();
                    if (tf != null) {
                        parcel2.writeInt(1);
                        tf.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 31:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean u3 = u();
                    parcel2.writeNoException();
                    parcel2.writeInt(u3 ? 1 : 0);
                    return true;
                case 32:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean kd3 = kd();
                    parcel2.writeNoException();
                    parcel2.writeInt(kd3 ? 1 : 0);
                    return true;
                case 33:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    hf(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    xj(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.hf.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    hf(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.hf.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    xj(hf.xj.xj(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.hf.w$xj$xj, reason: collision with other inner class name */
        public static class C0500xj implements w {
            public static w xj;
            private IBinder hf;

            public C0500xj(IBinder iBinder) {
                this.hf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hf;
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public DownloadInfo c(int i) {
                DownloadInfo createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (this.hf.transact(21, obtain, obtain2, 0) || xj.y() == null) {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } else {
                        createFromParcel = xj.y().c(i);
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public DownloadInfo d(int i) {
                DownloadInfo createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (this.hf.transact(29, obtain, obtain2, 0) || xj.y() == null) {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } else {
                        createFromParcel = xj.y().d(i);
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public DownloadInfo f(int i) {
                DownloadInfo createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (this.hf.transact(25, obtain, obtain2, 0) || xj.y() == null) {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } else {
                        createFromParcel = xj.y().f(i);
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public DownloadInfo hf(int i) {
                DownloadInfo createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (this.hf.transact(3, obtain, obtain2, 0) || xj.y() == null) {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } else {
                        createFromParcel = xj.y().hf(i);
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public boolean kd(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (!this.hf.transact(18, obtain, obtain2, 0) && xj.y() != null) {
                        return xj.y().kd(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public DownloadInfo tf(int i) {
                DownloadInfo createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (this.hf.transact(30, obtain, obtain2, 0) || xj.y() == null) {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    } else {
                        createFromParcel = xj.y().tf(i);
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public List<DownloadInfo> u(String str) {
                List<DownloadInfo> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (this.hf.transact(7, obtain, obtain2, 0) || xj.y() == null) {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                    } else {
                        createTypedArrayList = xj.y().u(str);
                    }
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public List<DownloadInfo> w(String str) {
                List<DownloadInfo> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (this.hf.transact(6, obtain, obtain2, 0) || xj.y() == null) {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                    } else {
                        createTypedArrayList = xj.y().w(str);
                    }
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w
            public void xj() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (this.hf.transact(1, obtain, obtain2, 0) || xj.y() == null) {
                        obtain2.readException();
                    } else {
                        xj.y().xj();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public boolean y(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (!this.hf.transact(19, obtain, obtain2, 0) && xj.y() != null) {
                        return xj.y().y(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w
            public boolean xj(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (!this.hf.transact(2, obtain, obtain2, 0) && xj.y() != null) {
                        return xj.y().xj(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public void u(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (!this.hf.transact(10, obtain, obtain2, 0) && xj.y() != null) {
                        xj.y().u(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public List<com.ss.android.socialbase.downloader.model.hf> w(int i) {
                List<com.ss.android.socialbase.downloader.model.hf> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (!this.hf.transact(9, obtain, obtain2, 0) && xj.y() != null) {
                        createTypedArrayList = xj.y().w(i);
                    } else {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.hf.CREATOR);
                    }
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public List<DownloadInfo> hf(String str) {
                List<DownloadInfo> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (!this.hf.transact(5, obtain, obtain2, 0) && xj.y() != null) {
                        createTypedArrayList = xj.y().hf(str);
                    } else {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                    }
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w
            public DownloadInfo kd(int i, long j) {
                DownloadInfo createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.hf.transact(28, obtain, obtain2, 0) && xj.y() != null) {
                        createFromParcel = xj.y().kd(i, j);
                    } else {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public DownloadInfo u(int i, long j) {
                DownloadInfo createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.hf.transact(27, obtain, obtain2, 0) && xj.y() != null) {
                        createFromParcel = xj.y().u(i, j);
                    } else {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public void w() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.hf.transact(20, obtain, obtain2, 0) && xj.y() != null) {
                        xj.y().w();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public List<DownloadInfo> xj(String str) {
                List<DownloadInfo> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (!this.hf.transact(4, obtain, obtain2, 0) && xj.y() != null) {
                        createTypedArrayList = xj.y().xj(str);
                    } else {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                    }
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public List<DownloadInfo> hf() {
                List<DownloadInfo> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.hf.transact(8, obtain, obtain2, 0) && xj.y() != null) {
                        createTypedArrayList = xj.y().hf();
                    } else {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                    }
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public boolean kd() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.hf.transact(32, obtain, obtain2, 0) && xj.y() != null) {
                        return xj.y().kd();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public DownloadInfo w(int i, long j) {
                DownloadInfo createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.hf.transact(26, obtain, obtain2, 0) && xj.y() != null) {
                        createFromParcel = xj.y().w(i, j);
                    } else {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public void hf(com.ss.android.socialbase.downloader.model.hf hfVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (hfVar != null) {
                        obtain.writeInt(1);
                        hfVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.hf.transact(12, obtain, obtain2, 0) && xj.y() != null) {
                        xj.y().hf(hfVar);
                    } else {
                        obtain2.readException();
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public void xj(com.ss.android.socialbase.downloader.model.hf hfVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (hfVar != null) {
                        obtain.writeInt(1);
                        hfVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.hf.transact(11, obtain, obtain2, 0) && xj.y() != null) {
                        xj.y().xj(hfVar);
                    } else {
                        obtain2.readException();
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public boolean u() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.hf.transact(31, obtain, obtain2, 0) && xj.y() != null) {
                        return xj.y().u();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public DownloadInfo hf(int i, long j) {
                DownloadInfo createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.hf.transact(24, obtain, obtain2, 0) && xj.y() != null) {
                        createFromParcel = xj.y().hf(i, j);
                    } else {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public void xj(int i, int i2, long j) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    if (!this.hf.transact(13, obtain, obtain2, 0) && xj.y() != null) {
                        xj.y().xj(i, i2, j);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public void xj(int i, int i2, int i3, long j) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j);
                    if (!this.hf.transact(14, obtain, obtain2, 0) && xj.y() != null) {
                        xj.y().xj(i, i2, i3, j);
                    } else {
                        obtain2.readException();
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public void hf(DownloadInfo downloadInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.hf.transact(33, obtain, obtain2, 0) && xj.y() != null) {
                        xj.y().hf(downloadInfo);
                    } else {
                        obtain2.readException();
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public void hf(int i, List<com.ss.android.socialbase.downloader.model.hf> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    if (!this.hf.transact(35, obtain, obtain2, 0) && xj.y() != null) {
                        xj.y().hf(i, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public void xj(int i, int i2, int i3, int i4) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    if (!this.hf.transact(15, obtain, obtain2, 0) && xj.y() != null) {
                        xj.y().xj(i, i2, i3, i4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public DownloadInfo xj(int i, int i2) {
                DownloadInfo createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.hf.transact(16, obtain, obtain2, 0) && xj.y() != null) {
                        createFromParcel = xj.y().xj(i, i2);
                    } else {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public boolean xj(DownloadInfo downloadInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.hf.transact(17, obtain, obtain2, 0) && xj.y() != null) {
                        boolean xj2 = xj.y().xj(downloadInfo);
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

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public DownloadInfo xj(int i, long j, String str, String str2) {
                DownloadInfo createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.hf.transact(22, obtain, obtain2, 0) && xj.y() != null) {
                        createFromParcel = xj.y().xj(i, j, str, str2);
                    } else {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public DownloadInfo xj(int i, long j) {
                DownloadInfo createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.hf.transact(23, obtain, obtain2, 0) && xj.y() != null) {
                        createFromParcel = xj.y().xj(i, j);
                    } else {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w, com.ss.android.socialbase.downloader.downloader.tf
            public void xj(int i, List<com.ss.android.socialbase.downloader.model.hf> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    if (!this.hf.transact(34, obtain, obtain2, 0) && xj.y() != null) {
                        xj.y().xj(i, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.hf.w
            public void xj(hf hfVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeStrongBinder(hfVar != null ? hfVar.asBinder() : null);
                    if (!this.hf.transact(36, obtain, obtain2, 0) && xj.y() != null) {
                        xj.y().xj(hfVar);
                    } else {
                        obtain2.readException();
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }
    }
}
