package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ai extends Handler {
    protected WeakReference<xj> xj;

    public interface xj {
        void xj(Message message);
    }

    public ai(xj xjVar) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (xjVar != null) {
            this.xj = new WeakReference<>(xjVar);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        xj xjVar;
        WeakReference<xj> weakReference = this.xj;
        if (weakReference == null || (xjVar = weakReference.get()) == null || message == null) {
            return;
        }
        xjVar.xj(message);
    }

    public ai(Looper looper, xj xjVar) {
        super(looper);
        if (xjVar != null) {
            this.xj = new WeakReference<>(xjVar);
        }
    }
}
