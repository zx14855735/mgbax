package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ApiDownloadHandlerService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        w xj = w.xj();
        if (xj != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("s", this);
            xj.xj(hashMap, 157);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        w xj = w.xj();
        if (xj != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("i", intent);
            hashMap.put("c", this);
            xj.xj(hashMap, 158);
        }
        stopSelf();
        return 2;
    }
}
