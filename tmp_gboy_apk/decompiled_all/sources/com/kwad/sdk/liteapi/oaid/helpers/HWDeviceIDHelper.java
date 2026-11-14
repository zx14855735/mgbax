package com.kwad.sdk.liteapi.oaid.helpers;

import A5SV6n.A2egSU;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.oaid.interfaces.HWIDInterface;
import java.util.concurrent.LinkedBlockingQueue;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class HWDeviceIDHelper {
    private static final String TAG = "HWDeviceIDHelper";
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> mLinkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.liteapi.oaid.helpers.HWDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                LiteApiLogger.i(HWDeviceIDHelper.TAG, "onServiceConnected");
                HWDeviceIDHelper.this.mLinkedBlockingQueue.put(iBinder);
            } catch (Exception e) {
                LiteApiLogger.printStackTrace(e);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public HWDeviceIDHelper(Context context) {
        this.mContext = context;
    }

    public String getOAID() {
        String str = "";
        try {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            try {
                if (!this.mContext.bindService(intent, this.serviceConnection, 1)) {
                    return "";
                }
                try {
                    HWIDInterface.a aVar = new HWIDInterface.a(this.mLinkedBlockingQueue.take());
                    str = aVar.getIDs();
                    LiteApiLogger.i(TAG, "getOAID oaid:" + str + "--boos:" + aVar.getBoos());
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
            LiteApiLogger.i(TAG, "getOAID hw service not found");
            LiteApiLogger.printStackTraceOnly(e2);
        }
    }
}
