package com.bytedance.sdk.openadsdk.core.multipro.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BinderPoolService extends Service {
    private Binder xj = new xj.BinderC0172xj();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.xj;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}
