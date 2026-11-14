package com.bytedance.sdk.component.tf.hf;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.MessageQueue;
import com.bytedance.sdk.component.utils.ai;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private Handler hf;
    private Handler w;
    private final u<hf> xj;

    /* renamed from: com.bytedance.sdk.component.tf.hf.xj$xj, reason: collision with other inner class name */
    public static class C0118xj {
        private static final xj xj = new xj();

        static {
            pmrnzT();
        }

        private static /* synthetic */ void pmrnzT() {
            char[] charArray = "846u<:6>u94\"u(3>77u\u001152\u0019)2?<>".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '[');
            }
            String str = new String(charArray);
            char[] charArray2 = "87252/".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '[');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public Handler hf() {
        if (this.hf == null) {
            synchronized (xj.class) {
                try {
                    if (this.hf == null) {
                        this.hf = xj("csj_io_handler");
                    }
                } finally {
                }
            }
        }
        return this.hf;
    }

    public Handler w() {
        if (this.w == null) {
            synchronized (xj.class) {
                try {
                    if (this.w == null) {
                        this.w = xj("csj_main_handler");
                    }
                } finally {
                }
            }
        }
        return this.w;
    }

    private xj() {
        this.xj = u.xj(2);
    }

    public static xj xj() {
        return C0118xj.xj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final Handler handler, final Handler handler2) {
        MessageQueue queue;
        boolean isIdle;
        if (Build.VERSION.SDK_INT >= 23) {
            queue = handler.getLooper().getQueue();
            isIdle = queue.isIdle();
            if (isIdle) {
                handler.removeCallbacksAndMessages(null);
                handler.getLooper().quit();
            } else {
                handler2.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.tf.hf.xj.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xj.this.xj(handler, handler2);
                    }
                }, 1000L);
            }
        }
    }

    private hf hf(ai.xj xjVar, String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return new hf(handlerThread, xjVar);
    }

    public ai xj(ai.xj xjVar, final String str) {
        hf xj = this.xj.xj();
        if (xj != null) {
            xj.xj(xjVar);
            xj.post(new Runnable() { // from class: com.bytedance.sdk.component.tf.hf.xj.2
                @Override // java.lang.Runnable
                public void run() {
                    Thread.currentThread().setName(str);
                }
            });
            return xj;
        }
        return hf(xjVar, str);
    }

    public ai xj(String str) {
        return xj((ai.xj) null, str);
    }

    public boolean xj(ai aiVar) {
        if (!(aiVar instanceof hf)) {
            return false;
        }
        hf hfVar = (hf) aiVar;
        if (this.xj.xj((u<hf>) hfVar)) {
            return true;
        }
        hfVar.hf();
        return true;
    }
}
