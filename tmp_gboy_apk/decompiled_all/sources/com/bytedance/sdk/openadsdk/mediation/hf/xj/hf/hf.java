package com.bytedance.sdk.openadsdk.mediation.hf.xj.hf;

import IzHBwY.ADYaiT;
import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements Function<SparseArray<Object>, Object> {
    private final IMediationInterstitialFullAdListener xj;

    public hf(IMediationInterstitialFullAdListener iMediationInterstitialFullAdListener) {
        this.xj = iMediationInterstitialFullAdListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 131101:
                    this.xj.onAdShow();
                    break;
                case 131102:
                    this.xj.onAdVideoBarClick();
                    break;
                case 131103:
                    this.xj.onAdClose();
                    break;
                case 131104:
                    this.xj.onVideoComplete();
                    break;
                case 131105:
                    this.xj.onSkippedVideo();
                    break;
                case 131106:
                    this.xj.onInterstitialFullShowFail(AMqCpz.intValue(0, 0), AMqCpz.stringValue(1, null));
                    break;
                case 131107:
                    this.xj.onVideoError();
                    break;
                case 131108:
                    this.xj.onAdOpened();
                    break;
                case 131109:
                    this.xj.onAdLeftApplication();
                    break;
                case 131110:
                    this.xj.onRewardVerify((Bundle) AMqCpz.objectValue(0, Bundle.class));
                    break;
            }
        }
        return null;
    }
}
