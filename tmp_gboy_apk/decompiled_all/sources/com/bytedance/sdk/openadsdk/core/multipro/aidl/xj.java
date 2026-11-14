package com.bytedance.sdk.openadsdk.core.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.c;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.hf;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.kd;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.u;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.w;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.y;
import com.bytedance.sdk.openadsdk.core.tf;
import java.util.concurrent.CountDownLatch;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static volatile xj w;
    private tf hf;
    private CountDownLatch u;
    private Context xj;
    private final Object kd = new Object();
    private long y = 0;
    private ServiceConnection c = new ServiceConnection() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            xj.this.hf = tf.xj.xj(iBinder);
            try {
                xj.this.hf.asBinder().linkToDeath(xj.this.f, 0);
            } catch (RemoteException e) {
                pl.w("MultiProcess", "onServiceConnected throws :", e);
            }
            xj.this.u.countDown();
            System.currentTimeMillis();
            long unused = xj.this.y;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            pl.xj("MultiProcess", "BinderPool......onServiceDisconnected");
        }
    };
    private IBinder.DeathRecipient f = new IBinder.DeathRecipient() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            pl.hf("MultiProcess", "binder died.");
            xj.this.hf.asBinder().unlinkToDeath(xj.this.f, 0);
            xj.this.hf = null;
            xj.this.xj();
        }
    };

    /* renamed from: com.bytedance.sdk.openadsdk.core.multipro.aidl.xj$xj, reason: collision with other inner class name */
    public static class BinderC0172xj extends tf.xj {
        @Override // com.bytedance.sdk.openadsdk.core.tf
        public IBinder xj(int i) {
            if (i == 0) {
                return c.hf();
            }
            if (i == 1) {
                return kd.hf();
            }
            if (i == 2) {
                return w.hf();
            }
            if (i == 3) {
                return hf.hf();
            }
            if (i == 4) {
                return u.hf();
            }
            if (i != 5) {
                return null;
            }
            return y.hf();
        }
    }

    private xj(Context context) {
        this.xj = context.getApplicationContext();
        xj();
    }

    public static xj xj(Context context) {
        if (w == null) {
            synchronized (xj.class) {
                try {
                    if (w == null) {
                        w = new xj(context);
                    }
                } finally {
                }
            }
        }
        return w;
    }

    public IBinder xj(int i) {
        try {
            tf tfVar = this.hf;
            if (tfVar != null) {
                return tfVar.xj(i);
            }
            return null;
        } catch (RemoteException e) {
            pl.xj(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void xj() {
        pl.xj("MultiProcess", "BinderPool......connectBinderPoolService");
        this.u = new CountDownLatch(1);
        try {
            this.xj.bindService(new Intent(this.xj, (Class<?>) BinderPoolService.class), this.c, 1);
            this.y = System.currentTimeMillis();
            this.u.await();
        } catch (Exception e) {
            pl.w("MultiProcess", "connectBinderPoolService throws: ", e);
        }
    }
}
