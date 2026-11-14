package com.bytedance.pangle.kd;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static Object hf;
    private static Class xj;

    public static final Object xj() {
        if (hf == null) {
            try {
                synchronized (xj.class) {
                    try {
                        if (hf == null) {
                            if (xj == null) {
                                xj = Class.forName("android.app.ActivityThread");
                            }
                            hf = MethodUtils.invokeStaticMethod(xj, "currentActivityThread", new Object[0]);
                        }
                        if (hf == null && Looper.myLooper() != Looper.getMainLooper()) {
                            final Object obj = new Object();
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.pangle.kd.xj.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        try {
                                            Object unused = xj.hf = MethodUtils.invokeStaticMethod(xj.xj, "currentActivityThread", new Object[0]);
                                            synchronized (obj) {
                                                obj.notify();
                                            }
                                        } catch (Exception e) {
                                            ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e);
                                            synchronized (obj) {
                                                obj.notify();
                                            }
                                        }
                                    } catch (Throwable th) {
                                        synchronized (obj) {
                                            obj.notify();
                                            throw th;
                                        }
                                    }
                                }
                            });
                            if (hf == null) {
                                synchronized (obj) {
                                    try {
                                        obj.wait(PushUIConfig.dismissTime);
                                    } catch (InterruptedException e) {
                                        ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e);
                                    }
                                }
                            }
                        }
                    } finally {
                    }
                }
            } catch (Exception e2) {
                ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread failed.", e2);
            }
        }
        return hf;
    }
}
