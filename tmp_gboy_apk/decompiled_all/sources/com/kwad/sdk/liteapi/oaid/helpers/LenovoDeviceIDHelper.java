package com.kwad.sdk.liteapi.oaid.helpers;

import A5SV6n.A2egSU;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.oaid.interfaces.LenovoIDInterface;
import java.util.concurrent.LinkedBlockingQueue;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class LenovoDeviceIDHelper {
    private static final String TAG = "LenovoDeviceIDHelper";
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> mLinkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.liteapi.oaid.helpers.LenovoDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                LiteApiLogger.i(LenovoDeviceIDHelper.TAG, "onServiceConnected");
                LenovoDeviceIDHelper.this.mLinkedBlockingQueue.put(iBinder);
            } catch (Exception e) {
                LiteApiLogger.printStackTrace(e);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public LenovoDeviceIDHelper(Context context) {
        this.mContext = context;
    }

    public String getOAID() {
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (!this.mContext.bindService(intent, this.serviceConnection, 1)) {
                return "";
            }
            try {
                try {
                    str = new LenovoIDInterface.a(this.mLinkedBlockingQueue.take()).getOaid();
                    LiteApiLogger.i(TAG, "getOAID oaid:" + str);
                    return str;
                } catch (Exception e) {
                    LiteApiLogger.printStackTrace(e);
                    this.mContext.unbindService(this.serviceConnection);
                    return str;
                }
            } finally {
                this.mContext.unbindService(this.serviceConnection);
            }
        } catch (Exception e2) {
            LiteApiLogger.i(TAG, "getOAID Lenovo service not found");
            LiteApiLogger.printStackTrace(e2);
            return str;
        }
    }
}
