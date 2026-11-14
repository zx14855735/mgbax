package com.bykv.vk.component.ttvideo.utils;

import com.bytedance.sdk.component.tf.tf;
import com.bytedance.sdk.component.tf.u.u;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class EngineThreadPool {

    /* renamed from: a, reason: collision with root package name */
    private static ThreadPoolExecutor f10020a;

    public static ExecutorService a() {
        if (f10020a == null) {
            synchronized (EngineThreadPool.class) {
                try {
                    if (f10020a == null) {
                        u uVar = new u(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new tf("EngineThreadPool"));
                        f10020a = uVar;
                        uVar.allowCoreThreadTimeOut(true);
                    }
                } finally {
                }
            }
        }
        return f10020a;
    }

    public static void setExcutorInstance(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (EngineThreadPool.class) {
            f10020a = threadPoolExecutor;
        }
    }
}
