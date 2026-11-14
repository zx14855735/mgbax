package com.bytedance.sdk.openadsdk.mediation.ad.xj.xj.hf;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements Function<SparseArray<Object>, Object> {
    private final IMediationAdSlot xj;

    public xj(IMediationAdSlot iMediationAdSlot) {
        this.xj = iMediationAdSlot;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj == null) {
            return null;
        }
        int intValue = new ARc23Z(sparseArray).A2egSU().intValue(-99999987, 0);
        if (intValue == 8260031) {
            return this.xj;
        }
        switch (intValue) {
            case 266001:
                return Boolean.class.cast(Boolean.valueOf(this.xj.isSplashShakeButton()));
            case 266002:
                return Boolean.class.cast(Boolean.valueOf(this.xj.isSplashPreLoad()));
            case 266003:
                return Boolean.class.cast(Boolean.valueOf(this.xj.isMuted()));
            case 266004:
                return Float.class.cast(Float.valueOf(this.xj.getVolume()));
            case 266005:
                return Boolean.class.cast(Boolean.valueOf(this.xj.isUseSurfaceView()));
            case 266006:
                return this.xj.getExtraObject();
            case 266007:
                return Boolean.class.cast(Boolean.valueOf(this.xj.isBidNotify()));
            case 266008:
                return this.xj.getScenarioId();
            case 266009:
                return Boolean.class.cast(Boolean.valueOf(this.xj.isAllowShowCloseBtn()));
            case 266010:
                return Float.class.cast(Float.valueOf(this.xj.getShakeViewWidth()));
            case 266011:
                return Float.class.cast(Float.valueOf(this.xj.getShakeViewHeight()));
            case 266012:
                return this.xj.getWxAppId();
            default:
                switch (intValue) {
                    case 266101:
                        return new w(this.xj.getMediationNativeToBannerListener());
                    case 266102:
                        return new u(this.xj.getMediationSplashRequestInfo());
                    case 266103:
                        return this.xj.getRewardName();
                    case 266104:
                        return Integer.class.cast(Integer.valueOf(this.xj.getRewardAmount()));
                    default:
                        return null;
                }
        }
    }
}
