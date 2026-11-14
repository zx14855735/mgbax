package com.kwad.sdk.core.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.b.h;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class n {
    public Context mContext;
    private final LinkedBlockingQueue<IBinder> mLinkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.core.e.a.n.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                com.kwad.sdk.core.d.c.i("ZTEDeviceIDHelper", "onServiceConnected");
                n.this.mLinkedBlockingQueue.put(iBinder);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public n(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.setAction("com.bun.msa.action.bindto.service");
            intent.putExtra("com.bun.msa.param.pkgname", this.mContext.getPackageName());
            boolean bindService = this.mContext.bindService(intent, this.serviceConnection, 1);
            com.kwad.sdk.core.d.c.i("ZTEDeviceIDHelper", "getOAID isBind=" + bindService);
            if (!bindService) {
                return "";
            }
            try {
                try {
                    str = new h.a(this.mLinkedBlockingQueue.take()).getOAID();
                    com.kwad.sdk.core.d.c.i("ZTEDeviceIDHelper", "getOAID oaid:" + str);
                    return str;
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                    this.mContext.unbindService(this.serviceConnection);
                    return str;
                }
            } finally {
                this.mContext.unbindService(this.serviceConnection);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.c.i("ZTEDeviceIDHelper", "getOAID hw service not found");
            com.kwad.sdk.core.d.c.printStackTrace(e2);
            return str;
        }
    }
}
