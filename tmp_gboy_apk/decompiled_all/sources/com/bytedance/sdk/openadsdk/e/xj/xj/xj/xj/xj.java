package com.bytedance.sdk.openadsdk.e.xj.xj.xj.xj;

import IzHBwY.ARc23Z;
import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements TTRewardVideoAd.RewardAdPlayAgainController.Callback {
    private final Function<SparseArray<Object>, Object> xj;

    public xj(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? ARc23Z.f4112ADYaiT : function;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdPlayAgainController.Callback
    public void onConditionReturn(Bundle bundle) {
        SparseArray sparseArray = new SparseArray(3);
        A2egSU.B2KMhB(123101, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, bundle);
        this.xj.apply(sparseArray);
    }
}
