package com.bytedance.sdk.openadsdk.io.xj.xj.xj;

import IzHBwY.ADYaiT;
import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements Function<SparseArray<Object>, Object> {
    private final TTRewardVideoAd.RewardAdInteractionListener xj;

    public xj(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.xj = rewardAdInteractionListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 121101:
                    this.xj.onAdShow();
                    break;
                case 121102:
                    this.xj.onAdVideoBarClick();
                    break;
                case 121103:
                    this.xj.onAdClose();
                    break;
                case 121104:
                    this.xj.onVideoComplete();
                    break;
                case 121105:
                    this.xj.onVideoError();
                    break;
                case 121106:
                    this.xj.onRewardVerify(AMqCpz.booleanValue(0, false), AMqCpz.intValue(1, 0), AMqCpz.stringValue(2, null), AMqCpz.intValue(3, 0), AMqCpz.stringValue(4, null));
                    break;
                case 121107:
                    this.xj.onRewardArrived(AMqCpz.booleanValue(0, false), AMqCpz.intValue(1, 0), (Bundle) AMqCpz.objectValue(2, Bundle.class));
                    break;
                case 121108:
                    this.xj.onSkippedVideo();
                    break;
            }
        }
        return null;
    }
}
