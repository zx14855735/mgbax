package com.ss.android.downloadlib.xj.xj;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.downloadlib.xj.xj.u;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface w extends IInterface {

    public static abstract class xj extends Binder implements w {
        private static String xj = "";

        /* renamed from: com.ss.android.downloadlib.xj.xj.w$xj$xj, reason: collision with other inner class name */
        public static class C0476xj implements w {
            private IBinder xj;

            public C0476xj(IBinder iBinder) {
                if (TextUtils.isEmpty(xj.xj)) {
                    JSONObject d = pl.d();
                    String unused = xj.xj = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString(t.k), d.optString("s"));
                }
                this.xj = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xj;
            }

            @Override // com.ss.android.downloadlib.xj.xj.w
            public void xj(hf hfVar, u uVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(xj.xj);
                    if (hfVar != null) {
                        obtain.writeInt(1);
                        hfVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(uVar != null ? uVar.asBinder() : null);
                    this.xj.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        @Override // android.os.Binder
        @SuppressLint({"WrongConstant"})
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(xj);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(xj);
            xj(parcel.readInt() != 0 ? hf.CREATOR.createFromParcel(parcel) : null, u.xj.xj(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static w xj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(xj);
            if (queryLocalInterface != null && (queryLocalInterface instanceof w)) {
                return (w) queryLocalInterface;
            }
            return new C0476xj(iBinder);
        }
    }

    void xj(hf hfVar, u uVar);
}
