package com.bytedance.sdk.openadsdk.mediation.ad.xj.xj.hf;

import IzHBwY.ADYaiT;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements Function<SparseArray<Object>, Object> {
    private final IMediationDislikeCallback xj;

    public hf(IMediationDislikeCallback iMediationDislikeCallback) {
        this.xj = iMediationDislikeCallback;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 268013:
                    this.xj.onSelected(AMqCpz.intValue(0, 0), AMqCpz.stringValue(1, null));
                    break;
                case 268014:
                    this.xj.onCancel();
                    break;
                case 268015:
                    this.xj.onShow();
                    break;
            }
        }
        return null;
    }
}
