package com.bytedance.msdk.f;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f {
    private static volatile f w;
    private volatile String xj = "";
    private volatile ExecutorService hf = com.bytedance.msdk.xj.kd.y.xj("gaid", 2, new RejectedExecutionHandler() { // from class: com.bytedance.msdk.f.f.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    });

    public class xj implements Callable<String> {
        private xj() {
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(com.bytedance.msdk.core.hf.getContext());
                if (advertisingIdInfo != null) {
                    String id = advertisingIdInfo.getId();
                    com.bytedance.msdk.xj.kd.w.xj("gaid-", "getAdvertisingId: ".concat(String.valueOf(id)));
                    f.hf(id);
                }
            } catch (Throwable unused) {
            }
            try {
                AdvertisingIdClient.Info advertisingIdInfo2 = AdvertisingIdClient.getAdvertisingIdInfo(com.bytedance.msdk.core.hf.getContext());
                if (advertisingIdInfo2 != null) {
                    f.this.xj = advertisingIdInfo2.getId();
                    advertisingIdInfo2.isLimitAdTrackingEnabled();
                }
            } catch (Throwable unused2) {
            }
            com.bytedance.msdk.xj.kd.w.xj("AdvertisingIdHelper", "mGAId:" + f.this.xj + " , get gaid consume time :" + (System.currentTimeMillis() - currentTimeMillis));
            return f.this.xj;
        }
    }

    private f() {
    }

    public String hf() {
        try {
            this.xj = ai.xj("tt_device_info", com.bytedance.msdk.core.hf.getContext()).hf("gaid", "");
            com.bytedance.msdk.xj.kd.w.xj("gaid", "--==-- getGAIdTimeOut-mGAId = " + this.xj);
            if (TextUtils.isEmpty(this.xj)) {
                synchronized (this) {
                    try {
                        if (this.hf != null) {
                            FutureTask futureTask = new FutureTask(new xj());
                            this.hf.execute(futureTask);
                            this.xj = (String) futureTask.get(1L, TimeUnit.MICROSECONDS);
                            if (!TextUtils.isEmpty(this.xj)) {
                                this.hf.shutdown();
                                this.hf = null;
                            }
                        }
                    } finally {
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return this.xj;
    }

    public synchronized void w() {
        try {
            this.xj = ai.xj("tt_device_info", com.bytedance.msdk.core.hf.getContext()).hf("gaid", "");
            com.bytedance.msdk.xj.kd.w.xj("gaid", "--==-- initGAIdByAsyc-mGAId = " + this.xj);
            if (TextUtils.isEmpty(this.xj) && this.hf != null) {
                this.hf.execute(new FutureTask(new xj()));
            }
        } catch (Throwable unused) {
        }
    }

    public static f xj() {
        if (w == null) {
            synchronized (f.class) {
                try {
                    if (w == null) {
                        w = new f();
                    }
                } finally {
                }
            }
        }
        return w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ai.xj("tt_device_info", com.bytedance.msdk.core.hf.getContext()).xj("gaid", str);
    }
}
