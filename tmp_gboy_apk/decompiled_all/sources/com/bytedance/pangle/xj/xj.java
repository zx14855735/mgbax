package com.bytedance.pangle.xj;

import com.bytedance.pangle.kd.kd;
import java.util.concurrent.CountDownLatch;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private final CountDownLatch hf;
    Throwable xj;

    /* renamed from: com.bytedance.pangle.xj.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0097xj {
        void xj();
    }

    private xj(boolean z, InterfaceC0097xj[] interfaceC0097xjArr) {
        this.hf = new CountDownLatch(interfaceC0097xjArr.length);
        for (final InterfaceC0097xj interfaceC0097xj : interfaceC0097xjArr) {
            kd.xj(new Runnable() { // from class: com.bytedance.pangle.xj.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        interfaceC0097xj.xj();
                    } catch (Throwable th) {
                        xj.this.xj = th;
                    }
                    xj.this.hf.countDown();
                }
            }, z);
        }
    }

    public static void xj(boolean z, InterfaceC0097xj... interfaceC0097xjArr) {
        new xj(z, interfaceC0097xjArr).xj();
    }

    private void xj() {
        try {
            this.hf.await();
            Throwable th = this.xj;
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
