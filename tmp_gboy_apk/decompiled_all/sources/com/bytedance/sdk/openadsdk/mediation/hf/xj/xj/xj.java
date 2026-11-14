package com.bytedance.sdk.openadsdk.mediation.hf.xj.xj;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawTokenInfo;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements IMediationDrawTokenInfo {
    private final Function<SparseArray<Object>, Object> xj;

    public xj(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? ARc23Z.f4112ADYaiT : function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationDrawTokenInfo
    public void loadDrawAdByAdm(String str, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        SparseArray sparseArray = new SparseArray(3);
        A2egSU.B2KMhB(270031, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, str);
        sparseArray.put(1, new com.bytedance.sdk.openadsdk.jk.xj.xj.xj.xj(drawFeedAdListener));
        this.xj.apply(sparseArray);
    }
}
