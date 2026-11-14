package com.czhj.devicehelper.honor.oaid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.czhj.devicehelper.honor.oaid.a;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* renamed from: a, reason: collision with root package name */
        private static final String f10532a = "com.hihonor.cloudservice.oaid.IOAIDService";

        /* renamed from: com.czhj.devicehelper.honor.oaid.b$a$a, reason: collision with other inner class name */
        public static class C0216a implements b {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f10533a;

            public C0216a(IBinder iBinder) {
                this.f10533a = iBinder;
            }

            @Override // com.czhj.devicehelper.honor.oaid.b
            public void a(a.AbstractBinderC0215a abstractBinderC0215a) {
                Parcel obtain = Parcel.obtain();
                Parcel parcel = null;
                try {
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain2.writeInterfaceToken(a.f10532a);
                        if (abstractBinderC0215a == null) {
                            abstractBinderC0215a = null;
                        }
                        obtain2.writeStrongBinder(abstractBinderC0215a);
                        this.f10533a.transact(2, obtain2, obtain, 0);
                        obtain.readException();
                        obtain.recycle();
                        obtain2.recycle();
                    } catch (Throwable th) {
                        th = th;
                        parcel = obtain2;
                        obtain.recycle();
                        parcel.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10533a;
            }

            @Override // com.czhj.devicehelper.honor.oaid.b
            public void b(a.AbstractBinderC0215a abstractBinderC0215a) {
                Parcel obtain = Parcel.obtain();
                Parcel parcel = null;
                try {
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain2.writeInterfaceToken(a.f10532a);
                        if (abstractBinderC0215a == null) {
                            abstractBinderC0215a = null;
                        }
                        obtain2.writeStrongBinder(abstractBinderC0215a);
                        this.f10533a.transact(3, obtain2, obtain, 0);
                        obtain.readException();
                        obtain.recycle();
                        obtain2.recycle();
                    } catch (Throwable th) {
                        th = th;
                        parcel = obtain2;
                        obtain.recycle();
                        parcel.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
    }

    void a(a.AbstractBinderC0215a abstractBinderC0215a);

    void b(a.AbstractBinderC0215a abstractBinderC0215a);
}
