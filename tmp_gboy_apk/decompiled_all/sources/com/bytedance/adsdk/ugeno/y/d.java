package com.bytedance.adsdk.ugeno.y;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d extends Handler {
    private final WeakReference<xj> xj;

    public interface xj {
        void xj(Message message);
    }

    public d(Looper looper, xj xjVar) {
        super(looper);
        this.xj = new WeakReference<>(xjVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        xj xjVar = this.xj.get();
        if (xjVar == null || message == null) {
            return;
        }
        xjVar.xj(message);
    }
}
