package com.czhj.sdk.common.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.czhj.sdk.logger.SigmobLog;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class PlayServicesUtil {

    public static final class AdvertisingConnection implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        boolean f10605a;
        private final LinkedBlockingQueue<IBinder> b;

        private AdvertisingConnection() {
            this.f10605a = false;
            this.b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() {
            if (this.f10605a) {
                throw new IllegalStateException();
            }
            this.f10605a = true;
            return this.b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static class AdvertisingInfo {
        public final String advertisingId;
        public final boolean limitAdTracking;

        public AdvertisingInfo(String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTracking = z;
        }
    }

    public static final class AdvertisingInterface implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        private final IBinder f10606a;

        public AdvertisingInterface(IBinder iBinder) {
            this.f10606a = iBinder;
        }

        public String a() {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f10606a;
        }

        public boolean b() {
            return false;
        }
    }

    public static AdvertisingInfo getAdvertisingIdInfo(Context context) {
        Looper.myLooper();
        Looper.getMainLooper();
        return null;
    }
}
