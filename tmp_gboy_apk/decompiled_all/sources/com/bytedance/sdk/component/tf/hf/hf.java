package com.bytedance.sdk.component.tf.hf;

import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.ai;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends ai implements w {
    private final HandlerThread hf;

    public hf(HandlerThread handlerThread, ai.xj xjVar) {
        super(handlerThread.getLooper(), xjVar);
        this.hf = handlerThread;
    }

    public void hf() {
        HandlerThread handlerThread = this.hf;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    @Override // com.bytedance.sdk.component.tf.hf.w
    public void xj() {
        removeCallbacksAndMessages(null);
        WeakReference<ai.xj> weakReference = this.xj;
        if (weakReference != null) {
            weakReference.clear();
            this.xj = null;
        }
    }

    public void xj(ai.xj xjVar) {
        this.xj = new WeakReference<>(xjVar);
    }
}
