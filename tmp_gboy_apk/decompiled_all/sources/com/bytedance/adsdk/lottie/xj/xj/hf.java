package com.bytedance.adsdk.lottie.xj.xj;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private final List<pz> xj = new ArrayList();

    public void xj(pz pzVar) {
        this.xj.add(pzVar);
    }

    public void xj(Path path) {
        for (int size = this.xj.size() - 1; size >= 0; size--) {
            com.bytedance.adsdk.lottie.kd.d.xj(path, this.xj.get(size));
        }
    }
}
