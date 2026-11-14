package com.bytedance.sdk.openadsdk.mediation.hf.xj.hf;

import IzHBwY.ADYaiT;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.mediation.MediationAppDialogClickListener;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd implements Function<SparseArray<Object>, Object> {
    private final MediationAppDialogClickListener xj;

    public kd(MediationAppDialogClickListener mediationAppDialogClickListener) {
        this.xj = mediationAppDialogClickListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            if (AMqCpz.intValue(-99999987, 0) == 270025) {
                this.xj.onButtonClick(AMqCpz.intValue(0, 0));
                return null;
            }
        }
        return null;
    }
}
