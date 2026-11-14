package com.kwad.sdk.liteapi.oaid.interfaces;

import A5SV6n.A2egSU;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.sdk.liteapi.LiteApiLogger;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface LenovoIDInterface extends IInterface {

    public static final class a implements LenovoIDInterface {
        private IBinder aKO;

        public a(IBinder iBinder) {
            this.aKO = iBinder;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.LenovoIDInterface
        public final String a(String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.aKO.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Exception e) {
                    LiteApiLogger.printStackTrace(e);
                    obtain2.recycle();
                    obtain.recycle();
                    return null;
                }
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aKO;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.LenovoIDInterface
        public final boolean c() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                this.aKO.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } catch (Exception e) {
                LiteApiLogger.printStackTrace(e);
                return false;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.LenovoIDInterface
        public final String getId(String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.aKO.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Exception e) {
                    LiteApiLogger.printStackTrace(e);
                    obtain2.recycle();
                    obtain.recycle();
                    return null;
                }
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.LenovoIDInterface
        public final String getOaid() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.aKO.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Exception e) {
                    LiteApiLogger.printStackTrace(e);
                    obtain2.recycle();
                    obtain.recycle();
                    return null;
                }
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.LenovoIDInterface
        public final String getUdid() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.aKO.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Exception e) {
                    LiteApiLogger.printStackTrace(e);
                    obtain2.recycle();
                    obtain.recycle();
                    return null;
                }
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    String a(String str);

    boolean c();

    String getId(String str);

    String getOaid();

    String getUdid();
}
