package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class tf<SERVICE, RESULT> {
    private final Intent hf;
    private final Context u;
    private final hf<SERVICE, RESULT> w;
    private final CountDownLatch xj = new CountDownLatch(1);

    public interface hf<T, RESULT> {
        T xj(IBinder iBinder);

        RESULT xj(T t);
    }

    public class xj implements ServiceConnection {
        private final hf<SERVICE, RESULT> u;
        private final CountDownLatch w;
        SERVICE xj;

        public xj(CountDownLatch countDownLatch, hf<SERVICE, RESULT> hfVar) {
            this.w = countDownLatch;
            this.u = hfVar;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            cu.xj("ServiceBlockBinder#onServiceConnected ".concat(String.valueOf(componentName)));
            try {
                this.xj = this.u.xj(iBinder);
            } catch (Throwable th) {
                try {
                    cu.w("ServiceBlockBinder#onServiceConnected", th);
                    try {
                        this.w.countDown();
                    } catch (Exception e) {
                        cu.xj(e);
                    }
                } finally {
                    try {
                        this.w.countDown();
                    } catch (Exception e2) {
                        cu.xj(e2);
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            cu.xj("ServiceBlockBinder#onServiceDisconnected".concat(String.valueOf(componentName)));
            try {
                this.w.countDown();
            } catch (Exception e) {
                cu.xj(e);
            }
        }
    }

    public tf(Context context, Intent intent, hf<SERVICE, RESULT> hfVar) {
        this.u = context;
        this.hf = intent;
        this.w = hfVar;
    }

    public RESULT xj() {
        tf<SERVICE, RESULT>.xj xjVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            cu.w("Don't do this in ui thread.", null);
            return null;
        }
        try {
            xjVar = new xj(this.xj, this.w);
            this.u.bindService(this.hf, xjVar, 1);
            this.xj.await();
            try {
                return this.w.xj((hf<SERVICE, RESULT>) xjVar.xj);
            } catch (Throwable th) {
                th = th;
                try {
                    cu.xj(th);
                    return null;
                } finally {
                    xj(xjVar);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            xjVar = null;
        }
    }

    private void xj(tf<SERVICE, RESULT>.xj xjVar) {
        if (xjVar != null) {
            try {
                this.u.unbindService(xjVar);
            } catch (Throwable th) {
                cu.xj(th);
            }
        }
    }
}
