package com.bytedance.msdk.core.xj;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.msdk.api.u.xj.w.w;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public static w xj(final Function<SparseArray<Object>, Object> function) {
        if (function != null) {
            return new w() { // from class: com.bytedance.msdk.core.xj.xj.1
                @Override // com.bytedance.msdk.api.u.xj.c.kd
                public void hf(long j) {
                    function.apply(A2egSU.AZOQYO(8167, Void.class).xj(8074, Long.valueOf(j)).hf());
                }

                @Override // com.bytedance.msdk.api.u.xj.c.kd
                public void w(long j) {
                    function.apply(A2egSU.AZOQYO(8169, Void.class).xj(8074, Long.valueOf(j)).hf());
                }

                @Override // com.bytedance.msdk.api.u.xj.c.kd
                public void xj(long j) {
                    function.apply(A2egSU.AZOQYO(8166, Void.class).xj(8074, Long.valueOf(j)).hf());
                }

                @Override // com.bytedance.msdk.api.u.xj.c.kd
                public void hf() {
                    function.apply(A2egSU.ARc23Z(8170, Void.class));
                }

                @Override // com.bytedance.msdk.api.u.xj.c.kd
                public void xj() {
                    function.apply(A2egSU.ARc23Z(8168, Void.class));
                }

                @Override // com.bytedance.msdk.api.u.xj.c.kd
                public void xj(int i, int i2) {
                    function.apply(A2egSU.AZOQYO(8171, Void.class).xj(8014, Integer.valueOf(i)).xj(8075, Integer.valueOf(i2)).hf());
                }

                @Override // com.bytedance.msdk.api.u.xj.c.kd
                public void xj(long j, int i, int i2) {
                    function.apply(A2egSU.AZOQYO(8172, Void.class).xj(8014, Integer.valueOf(i)).xj(8075, Integer.valueOf(i2)).xj(8074, Long.valueOf(j)).hf());
                }
            };
        }
        return null;
    }
}
