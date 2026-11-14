package com.bytedance.sdk.openadsdk.core.playable;

import com.bytedance.sdk.component.utils.y;
import java.io.File;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends com.bytedance.sdk.openadsdk.core.p.hf {
    public u(int i, int i2) {
        super(i, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.hf, com.bytedance.sdk.openadsdk.core.p.xj
    public void xj(List<File> list) {
        int size = list.size();
        if (xj(0L, size)) {
            return;
        }
        for (File file : list) {
            y.w(file);
            size--;
            if (xj(file, 0L, size)) {
                return;
            }
        }
    }
}
