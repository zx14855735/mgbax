package com.bytedance.sdk.openadsdk.mediation.hf.xj;

import IzHBwY.ADYaiT;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.zg.xj.xj.qt;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements Function<SparseArray<Object>, Object> {
    private final MediationAdDislike xj;

    public hf(MediationAdDislike mediationAdDislike) {
        this.xj = mediationAdDislike;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 270032:
                    this.xj.showDislikeDialog();
                    break;
                case 270033:
                    this.xj.setDislikeCallback(new xj(qt.xj(AMqCpz.objectValue(0, Object.class))));
                    break;
            }
        }
        return null;
    }
}
