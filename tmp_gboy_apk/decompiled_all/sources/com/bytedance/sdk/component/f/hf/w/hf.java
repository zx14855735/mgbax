package com.bytedance.sdk.component.f.hf.w;

import com.bytedance.sdk.component.f.xj.kd;
import com.bytedance.sdk.component.f.xj.u;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    public static void xj(AtomicLong atomicLong, int i, kd kdVar) {
        u u = kdVar.u();
        if (u == null || !u.w() || atomicLong == null) {
            return;
        }
        atomicLong.getAndAdd(i);
    }
}
