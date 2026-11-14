package com.bytedance.adsdk.lottie.model.xj;

import java.util.Arrays;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
abstract class am<V, O> implements g<V, O> {
    final List<com.bytedance.adsdk.lottie.y.xj<V>> xj;

    public am(List<com.bytedance.adsdk.lottie.y.xj<V>> list) {
        this.xj = list;
    }

    @Override // com.bytedance.adsdk.lottie.model.xj.g
    public boolean hf() {
        return this.xj.isEmpty() || (this.xj.size() == 1 && this.xj.get(0).kd());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.xj.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.xj.toArray()));
        }
        return sb.toString();
    }

    @Override // com.bytedance.adsdk.lottie.model.xj.g
    public List<com.bytedance.adsdk.lottie.y.xj<V>> w() {
        return this.xj;
    }
}
