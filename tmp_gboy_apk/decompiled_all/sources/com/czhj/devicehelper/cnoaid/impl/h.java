package com.czhj.devicehelper.cnoaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.text.TextUtils;
import com.czhj.sdk.logger.SigmobLog;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class h implements com.czhj.devicehelper.cnoaid.d {
    private final Context b;
    private final Handler c = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f10502a = new LinkedBlockingQueue<>(1);

    public static final class a implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        private final IBinder f10507a;

        private a(IBinder iBinder) {
            this.f10507a = iBinder;
        }

        public String a() {
            String str = null;
            try {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.f10507a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return str;
            } catch (Throwable th) {
                SigmobLog.e("getOAID", th);
                return str;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f10507a;
        }
    }

    public h(Context context) {
        this.b = context;
    }

    private String a(String str) {
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(str);
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.czhj.devicehelper.cnoaid.impl.h.2
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    h.this.f10502a.put(iBinder);
                } catch (Exception e) {
                    SigmobLog.e(e.getMessage());
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }
        };
        try {
            if (this.b.bindService(intent, serviceConnection, 1)) {
                return new a(this.f10502a.take()).a();
            }
        } catch (Exception e) {
            SigmobLog.e(e.getMessage());
        } finally {
            this.b.unbindService(serviceConnection);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.czhj.devicehelper.cnoaid.c cVar) {
        if (!a()) {
            SigmobLog.e("huawei OAID not Support");
            a(cVar, new com.czhj.devicehelper.cnoaid.f("huawei OAID not support"));
            return;
        }
        String str = null;
        try {
            Object invoke = Class.forName("com.huawei.hms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, this.b);
            if (invoke != null) {
                Object invoke2 = invoke.getClass().getDeclaredMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
                if (invoke2 instanceof String) {
                    a(cVar, (String) invoke2);
                    return;
                }
                return;
            }
            SigmobLog.e("huawei OAID info is null");
            String[] strArr = {"com.huawei.hwid", "com.huawei.hwid.tv", "com.huawei.hms"};
            String str2 = null;
            for (int i = 0; i < 3; i++) {
                String str3 = strArr[i];
                if (!TextUtils.isEmpty(str2)) {
                    a(cVar, str2);
                    return;
                }
                str2 = a(str3);
            }
            a(cVar, new com.czhj.devicehelper.cnoaid.f("huawei OAID info is null"));
        } catch (Throwable th) {
            try {
                String[] strArr2 = {"com.huawei.hwid", "com.huawei.hwid.tv", "com.huawei.hms"};
                for (int i2 = 0; i2 < 3; i2++) {
                    String str4 = strArr2[i2];
                    if (!TextUtils.isEmpty(str)) {
                        a(cVar, str);
                        return;
                    }
                    str = a(str4);
                }
                SigmobLog.e("HWDeviceIDHelper error, will retry", th);
                a(cVar, new com.czhj.devicehelper.cnoaid.f(th));
            } catch (Throwable th2) {
                SigmobLog.e("HWDeviceIDHelper error ", th2);
                a(cVar, new com.czhj.devicehelper.cnoaid.f(th2));
            }
        }
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public void a(final com.czhj.devicehelper.cnoaid.c cVar) {
        if (this.b == null || cVar == null) {
            return;
        }
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.czhj.devicehelper.cnoaid.impl.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.b(cVar);
            }
        });
    }

    private void a(final com.czhj.devicehelper.cnoaid.c cVar, final com.czhj.devicehelper.cnoaid.f fVar) {
        this.c.post(new Runnable() { // from class: com.czhj.devicehelper.cnoaid.impl.h.4
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(fVar);
            }
        });
    }

    private void a(final com.czhj.devicehelper.cnoaid.c cVar, final String str) {
        this.c.post(new Runnable() { // from class: com.czhj.devicehelper.cnoaid.impl.h.3
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(str);
            }
        });
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public boolean a() {
        PackageManager packageManager;
        if (this.b == null) {
            return false;
        }
        try {
            Object invoke = Class.forName("com.huawei.hms.ads.identifier.AdvertisingIdClient").getMethod("isAdvertisingIdAvailable", Context.class).invoke(null, this.b);
            if (invoke instanceof Boolean) {
                return ((Boolean) invoke).booleanValue();
            }
        } catch (Throwable th) {
            SigmobLog.e("hw oaid support", th);
        }
        try {
            packageManager = this.b.getPackageManager();
        } catch (Throwable unused) {
        }
        if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null && packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
            return packageManager.getPackageInfo("com.huawei.hms", 0) != null;
        }
        return true;
    }
}
