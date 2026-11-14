package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface e extends IInterface {

    public static abstract class xj extends Binder implements e {

        /* renamed from: com.bytedance.embedapplog.e$xj$xj, reason: collision with other inner class name */
        public static class C0040xj implements e {
            public static e xj;
            private IBinder hf;

            public C0040xj(IBinder iBinder) {
                this.hf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hf;
            }

            @Override // com.bytedance.embedapplog.e
            public String hf() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (this.hf.transact(2, obtain, obtain2, 0) || xj.c() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = xj.c().hf();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.e
            public boolean kd() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.hf.transact(5, obtain, obtain2, 0) && xj.c() != null) {
                        return xj.c().kd();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.e
            public boolean u() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.hf.transact(4, obtain, obtain2, 0) && xj.c() != null) {
                        return xj.c().u();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.e
            public String w() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (this.hf.transact(3, obtain, obtain2, 0) || xj.c() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = xj.c().w();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.e
            public String xj() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (this.hf.transact(1, obtain, obtain2, 0) || xj.c() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = xj.c().xj();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.e
            public void y() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (this.hf.transact(6, obtain, obtain2, 0) || xj.c() == null) {
                        obtain2.readException();
                    } else {
                        xj.c().y();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static e c() {
            return C0040xj.xj;
        }

        public static e xj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof e)) ? new C0040xj(iBinder) : (e) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.bun.lib.MsaIdInterface");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    String xj = xj();
                    parcel2.writeNoException();
                    parcel2.writeString(xj);
                    return true;
                case 2:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    String hf = hf();
                    parcel2.writeNoException();
                    parcel2.writeString(hf);
                    return true;
                case 3:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    String w = w();
                    parcel2.writeNoException();
                    parcel2.writeString(w);
                    return true;
                case 4:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    boolean u = u();
                    parcel2.writeNoException();
                    parcel2.writeInt(u ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    boolean kd = kd();
                    parcel2.writeNoException();
                    parcel2.writeInt(kd ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    y();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String hf();

    boolean kd();

    boolean u();

    String w();

    String xj();

    void y();
}
