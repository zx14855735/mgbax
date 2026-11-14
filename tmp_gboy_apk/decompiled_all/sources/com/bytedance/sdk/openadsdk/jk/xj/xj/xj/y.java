package com.bytedance.sdk.openadsdk.jk.xj.xj.xj;

import IzHBwY.ADYaiT;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.zg.xj.xj.am;
import com.bytedance.sdk.openadsdk.zg.xj.xj.qt;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y implements Function<SparseArray<Object>, Object> {
    private final TTAdNative.RewardVideoAdListener xj;

    public y(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.xj = rewardVideoAdListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 124101:
                    this.xj.onError(AMqCpz.intValue(0, 0), AMqCpz.stringValue(1, null));
                    break;
                case 124102:
                    this.xj.onRewardVideoAdLoad(new am(qt.xj(AMqCpz.objectValue(0, Object.class))));
                    break;
                case 124103:
                    this.xj.onRewardVideoCached(new am(qt.xj(AMqCpz.objectValue(0, Object.class))));
                    break;
                case 124104:
                    this.xj.onRewardVideoCached();
                    break;
            }
        }
        return null;
    }
}
