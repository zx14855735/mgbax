package com.bytedance.sdk.openadsdk.core.u;

import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private String hf;
    private Runnable u;
    private long w;
    private int xj = 10000;

    public hf(String str) {
        this.hf = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public void hf(final Runnable runnable) {
        this.w = System.currentTimeMillis();
        if (!xj.kd()) {
            hf(1);
            w(runnable);
        } else if (f.zg().z()) {
            hf(2);
            xj();
        } else if (xj.xj()) {
            com.bytedance.sdk.component.utils.f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.hf.1
                @Override // java.lang.Runnable
                public void run() {
                    if (f.zg().z()) {
                        hf.this.hf(2);
                        hf.this.xj();
                    } else {
                        hf.this.hf(1);
                        hf.this.w(runnable);
                    }
                }
            }, this.xj);
        } else {
            hf(1);
            w(runnable);
        }
    }

    public hf xj(int i) {
        this.xj = i <= 0 ? 10000 : i * 1000;
        return this;
    }

    public hf xj(Runnable runnable) {
        this.u = runnable;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj() {
        Runnable runnable = this.u;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(int i) {
        StringBuilder sb = new StringBuilder(">> tk: ");
        sb.append(this.hf);
        sb.append(i == 1 ? " run" : " cancel");
        sb.append(", isBst: true, tmgap: ");
        sb.append((System.currentTimeMillis() - this.w) / 1000);
        if (i == 1) {
            pl.xj("bstsdk", sb.toString());
        } else {
            pl.hf("bstsdk", sb.toString());
        }
    }
}
