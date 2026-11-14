package com.bytedance.pangle;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.pangle.u;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface w extends IInterface {
    int hf(String str);

    void xj(int i);

    void xj(int i, u uVar);

    boolean xj(String str);

    boolean xj(String str, String str2);

    public static abstract class xj extends Binder implements w {
        public xj() {
            attachInterface(this, "com.bytedance.pangle.IPackageManager");
        }

        public static w xj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPackageManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof w)) ? new C0096xj(iBinder) : (w) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean xj = xj(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(xj ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                int hf = hf(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(hf);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean xj2 = xj(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(xj2 ? 1 : 0);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                xj(parcel.readInt(), u.xj.xj(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 5) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.bytedance.pangle.IPackageManager");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
            xj(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        public static w xj() {
            return C0096xj.xj;
        }

        /* renamed from: com.bytedance.pangle.w$xj$xj, reason: collision with other inner class name */
        public static class C0096xj implements w {
            public static w xj;
            private IBinder hf;

            public C0096xj(IBinder iBinder) {
                this.hf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hf;
            }

            @Override // com.bytedance.pangle.w
            public int hf(String str) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    if (this.hf.transact(2, obtain, obtain2, 0) || xj.xj() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = xj.xj().hf(str);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.w
            public boolean xj(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    if (!this.hf.transact(1, obtain, obtain2, 0) && xj.xj() != null) {
                        return xj.xj().xj(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.w
            public boolean xj(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.hf.transact(3, obtain, obtain2, 0) && xj.xj() != null) {
                        return xj.xj().xj(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.w
            public void xj(int i, u uVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(uVar != null ? uVar.asBinder() : null);
                    if (!this.hf.transact(4, obtain, obtain2, 0) && xj.xj() != null) {
                        xj.xj().xj(i, uVar);
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

            @Override // com.bytedance.pangle.w
            public void xj(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeInt(i);
                    if (!this.hf.transact(5, obtain, obtain2, 0) && xj.xj() != null) {
                        xj.xj().xj(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
