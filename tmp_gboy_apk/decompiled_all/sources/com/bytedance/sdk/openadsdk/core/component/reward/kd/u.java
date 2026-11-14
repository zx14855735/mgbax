package com.bytedance.sdk.openadsdk.core.component.reward.kd;

import com.bytedance.sdk.openadsdk.core.a.xj;
import com.bytedance.sdk.openadsdk.core.f;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u implements xj.hf {
    private long hf;
    private long w;
    long xj;

    public u() {
        f.zg().xj(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.xj.hf
    public void hf() {
        u();
    }

    public void kd() {
        this.hf = 0L;
        this.w = 0L;
        this.xj = 0L;
    }

    public void u() {
        if (this.hf == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.xj = (currentTimeMillis - this.hf) + this.xj;
        this.hf = 0L;
        this.w = 0L;
    }

    public void w() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.hf;
        if (j != 0) {
            this.xj = (currentTimeMillis - j) + this.xj;
        }
        this.hf = currentTimeMillis;
    }

    public long xj(TimeUnit timeUnit) {
        return timeUnit != null ? timeUnit.convert(this.xj, TimeUnit.MILLISECONDS) : this.xj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.xj.hf
    public void xj() {
        w();
    }
}
