package com.bytedance.sdk.openadsdk.mediation.hf.xj.hf;

import IzHBwY.ADYaiT;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import com.bytedance.sdk.openadsdk.zg.xj.xj.qt;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements Function<SparseArray<Object>, Object> {
    private final IMediationNativeAdTokenCallback xj;

    public w(IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        this.xj = iMediationNativeAdTokenCallback;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 270026:
                    this.xj.onAdTokenLoaded(AMqCpz.stringValue(0, null), new com.bytedance.sdk.openadsdk.mediation.hf.xj.xj.w(qt.xj(AMqCpz.objectValue(1, Object.class))));
                    break;
                case 270027:
                    this.xj.onAdTokenLoadedFail(AMqCpz.intValue(0, 0), AMqCpz.stringValue(1, null));
                    break;
            }
        }
        return null;
    }
}
