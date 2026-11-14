package com.bytedance.sdk.openadsdk.ht.xj.xj.xj;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements TTFeedAd.CustomizeVideo {
    private final Function<SparseArray<Object>, Object> xj;

    public xj(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? ARc23Z.f4112ADYaiT : function;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public String getVideoUrl() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(162101, sparseArray, -99999987, -99999985, String.class);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoAutoStart() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(162107, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoBreak(long j) {
        SparseArray sparseArray = new SparseArray(3);
        A2egSU.B2KMhB(162106, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, Long.valueOf(j));
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoContinue(long j) {
        SparseArray sparseArray = new SparseArray(3);
        A2egSU.B2KMhB(162104, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, Long.valueOf(j));
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoError(long j, int i, int i2) {
        SparseArray sparseArray = new SparseArray(4);
        A2egSU.B2KMhB(162109, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, Long.valueOf(j));
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, Integer.valueOf(i2));
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoFinish() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(162105, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoPause(long j) {
        SparseArray sparseArray = new SparseArray(3);
        A2egSU.B2KMhB(162103, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, Long.valueOf(j));
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStart() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 162102);
        sparseArray.put(-99999985, Void.TYPE);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStartError(int i, int i2) {
        SparseArray sparseArray = new SparseArray(4);
        A2egSU.B2KMhB(162108, sparseArray, -99999987, -99999985, Void.class);
        A2egSU.B25kr6(i, sparseArray, 0, i2, 1);
        this.xj.apply(sparseArray);
    }
}
