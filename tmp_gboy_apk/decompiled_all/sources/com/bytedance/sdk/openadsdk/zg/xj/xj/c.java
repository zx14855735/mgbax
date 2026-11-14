package com.bytedance.sdk.openadsdk.zg.xj.xj;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c implements TTAdDislike {
    private final Function<SparseArray<Object>, Object> xj;

    public c(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? ARc23Z.f4112ADYaiT : function;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public boolean isShow() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(240105, sparseArray, -99999987, -99999985, Boolean.class);
        apply = this.xj.apply(sparseArray);
        Boolean bool = (Boolean) apply;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void resetDislikeStatus() {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(240104, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 240102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.v.xj.xj.xj.xj(dislikeInteractionCallback));
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeSource(String str) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(240103, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, str);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(240101, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
