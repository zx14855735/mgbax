package com.bytedance.msdk.api.u.xj.hf.w;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.zg.u;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class w {
    private final String hf;
    private final String kd;
    private final int u;
    private final int w;
    private final String xj;

    public w(String str, String str2, int i, int i2, String str3) {
        this.xj = str;
        this.hf = str2;
        this.w = i;
        this.u = i2;
        this.kd = str3;
    }

    public int hf() {
        return this.w;
    }

    public SparseArray<Object> xj() {
        u xj = u.xj();
        xj.xj(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec, this.xj);
        xj.xj(2, this.hf);
        xj.xj(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes, Integer.valueOf(this.w));
        xj.xj(8094, Integer.valueOf(this.u));
        xj.xj(8547, this.kd);
        if (com.bytedance.msdk.core.xj.p().r() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("live_ad_custom_config", com.bytedance.msdk.core.xj.p().r());
            xj.xj(8075, hashMap);
        }
        return xj.hf();
    }
}
