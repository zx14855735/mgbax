package com.bytedance.sdk.openadsdk.ht.xj.xj.hf;

import IzHBwY.ADYaiT;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements Function<SparseArray<Object>, Object> {
    private final TTFeedAd.VideoRewardListener xj;

    public hf(TTFeedAd.VideoRewardListener videoRewardListener) {
        this.xj = videoRewardListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            if (AMqCpz.intValue(-99999987, 0) == 163101) {
                this.xj.onFeedRewardCountDown(AMqCpz.intValue(0, 0));
                return null;
            }
        }
        return null;
    }
}
