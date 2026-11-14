package com.bytedance.sdk.openadsdk.core.et;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.d.xj;
import com.bytedance.sdk.openadsdk.core.et.xj;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.en;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile kd xj;
    private Context hf;
    private final com.bytedance.sdk.component.d.xj u;
    private com.bytedance.sdk.openadsdk.g.xj.xj w;

    private kd(Context context) {
        this.hf = context == null ? pz.getContext() : context.getApplicationContext();
        xj.C0109xj c0109xj = new xj.C0109xj();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        com.bytedance.sdk.component.d.xj xj2 = c0109xj.xj(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).hf(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).w(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).xj(new xj.C0164xj()).xj(en.xj()).xj(en.hf()).xj(true).xj();
        this.u = xj2;
        com.bytedance.sdk.component.hf.xj.u xj3 = xj2.y().xj();
        if (xj3 != null) {
            xj3.xj(32);
            xj3.hf(com.bytedance.sdk.openadsdk.core.w.w.xj().kd());
        }
    }

    private void u() {
        if (this.w == null) {
            this.w = new com.bytedance.sdk.openadsdk.g.xj.xj();
        }
    }

    public static kd xj() {
        if (xj == null) {
            synchronized (kd.class) {
                try {
                    if (xj == null) {
                        com.bytedance.sdk.component.hf.xj.xj.xj.xj().xj(com.bytedance.sdk.openadsdk.core.w.w.xj().y() != 2);
                        xj = new kd(pz.getContext());
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public com.bytedance.sdk.component.d.xj hf() {
        return this.u;
    }

    public com.bytedance.sdk.openadsdk.g.xj.xj w() {
        u();
        return this.w;
    }
}
