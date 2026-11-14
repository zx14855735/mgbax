package com.bytedance.sdk.openadsdk.mediation.ad.xj.xj.hf;

import IzHBwY.ADYaiT;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;
import com.bytedance.sdk.openadsdk.zg.xj.xj.qt;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements Function<SparseArray<Object>, Object> {
    private final IMediationNativeToBannerListener xj;

    public w(IMediationNativeToBannerListener iMediationNativeToBannerListener) {
        this.xj = iMediationNativeToBannerListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj == null) {
            return null;
        }
        ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
        if (AMqCpz.intValue(-99999987, 0) != 266013) {
            return null;
        }
        return this.xj.getMediationBannerViewFromNativeAd(new com.bytedance.sdk.openadsdk.mediation.ad.xj.xj.xj.xj(qt.xj(AMqCpz.objectValue(0, Object.class))));
    }
}
