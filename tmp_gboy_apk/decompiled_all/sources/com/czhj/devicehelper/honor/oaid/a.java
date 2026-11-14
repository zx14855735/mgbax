package com.czhj.devicehelper.honor.oaid;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface a extends IInterface {

    /* renamed from: com.czhj.devicehelper.honor.oaid.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0215a extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        private static final String f10531a = "com.hihonor.cloudservice.oaid.IOAIDCallBack";

        public AbstractBinderC0215a() {
            attachInterface(this, f10531a);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(f10531a);
                int readInt = parcel.readInt();
                long readLong = parcel.readLong();
                boolean z = parcel.readInt() != 0;
                a(readInt, readLong, z, parcel.readFloat(), parcel.readDouble(), parcel.readString());
            } else {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(f10531a);
                    return true;
                }
                parcel.enforceInterface(f10531a);
                a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i, long j, boolean z, float f, double d, String str);

    void a(int i, Bundle bundle);
}
