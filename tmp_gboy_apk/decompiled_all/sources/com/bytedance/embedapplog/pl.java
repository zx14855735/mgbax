package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface pl extends IInterface {
    String hf();

    String hf(String str);

    String kd(String str);

    String u(String str);

    String w(String str);

    String xj(String str);

    boolean xj();

    public static abstract class xj extends Binder implements pl {
        public static pl w() {
            return C0044xj.xj;
        }

        public static pl xj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof pl)) ? new C0044xj(iBinder) : (pl) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.coolpad.deviceidsupport.IDeviceIdManager");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String xj = xj(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(xj);
                    return true;
                case 2:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String hf = hf(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(hf);
                    return true;
                case 3:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String w = w(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(w);
                    return true;
                case 4:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String u = u(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(u);
                    return true;
                case 5:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String kd = kd(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(kd);
                    return true;
                case 6:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    boolean xj2 = xj();
                    parcel2.writeNoException();
                    parcel2.writeInt(xj2 ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String hf2 = hf();
                    parcel2.writeNoException();
                    parcel2.writeString(hf2);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: com.bytedance.embedapplog.pl$xj$xj, reason: collision with other inner class name */
        public static class C0044xj implements pl {
            public static pl xj;
            private IBinder hf;

            public C0044xj(IBinder iBinder) {
                this.hf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hf;
            }

            @Override // com.bytedance.embedapplog.pl
            public String hf(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (this.hf.transact(2, obtain, obtain2, 0) || xj.w() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = xj.w().hf(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.pl
            public String kd(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (this.hf.transact(5, obtain, obtain2, 0) || xj.w() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = xj.w().kd(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.pl
            public String u(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (this.hf.transact(4, obtain, obtain2, 0) || xj.w() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = xj.w().u(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.pl
            public String w(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (this.hf.transact(3, obtain, obtain2, 0) || xj.w() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = xj.w().w(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.pl
            public String xj(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (this.hf.transact(1, obtain, obtain2, 0) || xj.w() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = xj.w().xj(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.pl
            public String hf() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.hf.transact(7, obtain, obtain2, 0) && xj.w() != null) {
                        readString = xj.w().hf();
                    } else {
                        obtain2.readException();
                        readString = obtain2.readString();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.pl
            public boolean xj() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.hf.transact(6, obtain, obtain2, 0) && xj.w() != null) {
                        return xj.w().xj();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
