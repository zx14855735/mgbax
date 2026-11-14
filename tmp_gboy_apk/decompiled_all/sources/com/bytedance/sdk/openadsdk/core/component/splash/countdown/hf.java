package com.bytedance.sdk.openadsdk.core.component.splash.countdown;

import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.component.utils.ai;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements ai.xj {
    private xj hf;
    private AtomicBoolean w = new AtomicBoolean(true);
    protected final ai xj = new ai(Looper.getMainLooper(), this);
    private int u = 5;
    private int kd = 1;

    public interface xj {
        void xj();

        void xj(int i);
    }

    private void kd() {
        try {
            this.xj.sendEmptyMessage(1);
        } catch (Throwable unused) {
        }
    }

    private void u() {
        try {
            this.xj.removeMessages(1);
        } catch (Throwable unused) {
        }
    }

    private void w() {
        this.xj.removeMessages(1);
        this.kd = 1;
    }

    private void y() {
        try {
            int i = this.kd;
            if (i >= this.u + 1) {
                xj xjVar = this.hf;
                if (xjVar != null) {
                    xjVar.xj();
                    return;
                }
                return;
            }
            int i2 = i + 1;
            this.kd = i2;
            xj xjVar2 = this.hf;
            if (xjVar2 != null) {
                xjVar2.xj(i2);
            }
            this.xj.sendEmptyMessageDelayed(1, 1000L);
        } catch (Exception unused) {
        }
    }

    public void hf() {
        w();
        this.xj.sendEmptyMessage(1);
    }

    public void xj() {
        w();
    }

    public void xj(boolean z) {
        this.w.set(z);
        if (this.w.get()) {
            kd();
        } else {
            u();
        }
    }

    public void xj(xj xjVar) {
        this.hf = xjVar;
    }

    public void xj(int i) {
        this.u = i;
        w();
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        if (message.what == 1) {
            y();
        }
    }
}
