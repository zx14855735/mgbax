package com.bytedance.adsdk.lottie.xj.hf;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f {
    private final List<xj<Integer, Integer>> hf;
    private final List<com.bytedance.adsdk.lottie.model.hf.f> w;
    private final List<xj<com.bytedance.adsdk.lottie.model.hf.am, Path>> xj;

    public f(List<com.bytedance.adsdk.lottie.model.hf.f> list) {
        this.w = list;
        this.xj = new ArrayList(list.size());
        this.hf = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.xj.add(list.get(i).hf().xj());
            this.hf.add(list.get(i).w().xj());
        }
    }

    public List<xj<com.bytedance.adsdk.lottie.model.hf.am, Path>> hf() {
        return this.xj;
    }

    public List<xj<Integer, Integer>> w() {
        return this.hf;
    }

    public List<com.bytedance.adsdk.lottie.model.hf.f> xj() {
        return this.w;
    }
}
