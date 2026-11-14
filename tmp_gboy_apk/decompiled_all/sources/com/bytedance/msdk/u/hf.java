package com.bytedance.msdk.u;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.f.u.w;
import com.bytedance.sdk.component.d.xj;
import com.bytedance.sdk.component.hf.xj.u;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile hf xj;
    private Context hf;
    private final com.bytedance.sdk.component.d.xj w;

    private hf(Context context) {
        Map<String, Object> map;
        this.hf = context == null ? com.bytedance.msdk.core.hf.getContext() : context.getApplicationContext();
        xj.C0109xj c0109xj = new xj.C0109xj();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        xj.C0109xj xj2 = c0109xj.xj(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).hf(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).w(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).xj(true);
        if (w.xj() && (map = w.xj) != null) {
            Object obj = map.get("case_id");
            if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                xj2.xj(new w.xj());
            }
        }
        com.bytedance.sdk.component.d.xj xj3 = xj2.xj();
        this.w = xj3;
        u xj4 = xj3.y().xj();
        if (xj4 != null) {
            xj4.xj(16);
        }
    }

    public static hf xj() {
        if (xj == null) {
            synchronized (hf.class) {
                try {
                    if (xj == null) {
                        xj = new hf(com.bytedance.msdk.core.hf.getContext());
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public com.bytedance.sdk.component.d.xj hf() {
        return this.w;
    }
}
