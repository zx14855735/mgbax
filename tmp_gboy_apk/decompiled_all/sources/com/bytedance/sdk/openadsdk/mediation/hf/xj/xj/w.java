package com.bytedance.sdk.openadsdk.mediation.hf.xj.xj;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements IMediationNativeTokenInfo {
    private final Function<SparseArray<Object>, Object> xj;

    public w(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? ARc23Z.f4112ADYaiT : function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo
    public void loadNativeAdByAdm(String str, TTAdNative.FeedAdListener feedAdListener) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, str);
        sparseArray.put(1, new com.bytedance.sdk.openadsdk.jk.xj.xj.xj.hf(feedAdListener));
        sparseArray.put(-99999987, 270028);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
