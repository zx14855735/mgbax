package com.bytedance.sdk.openadsdk.mediation.ad.xj.xj.hf;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u implements Function<SparseArray<Object>, Object> {
    private final IMediationSplashRequestInfo xj;

    public u(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        this.xj = iMediationSplashRequestInfo;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        String str = "";
        switch (new ARc23Z(sparseArray).A2egSU().intValue(-99999987, 0)) {
            case 267001:
                IMediationSplashRequestInfo iMediationSplashRequestInfo = this.xj;
                if (iMediationSplashRequestInfo != null && iMediationSplashRequestInfo.getAdnName() != null) {
                    str = this.xj.getAdnName();
                }
                return String.valueOf(str);
            case 267002:
                IMediationSplashRequestInfo iMediationSplashRequestInfo2 = this.xj;
                if (iMediationSplashRequestInfo2 != null && iMediationSplashRequestInfo2.getAdnSlotId() != null) {
                    str = this.xj.getAdnSlotId();
                }
                return String.valueOf(str);
            case 267003:
                IMediationSplashRequestInfo iMediationSplashRequestInfo3 = this.xj;
                if (iMediationSplashRequestInfo3 != null && iMediationSplashRequestInfo3.getAppId() != null) {
                    str = this.xj.getAppId();
                }
                return String.valueOf(str);
            case 267004:
                IMediationSplashRequestInfo iMediationSplashRequestInfo4 = this.xj;
                if (iMediationSplashRequestInfo4 != null && iMediationSplashRequestInfo4.getAppkey() != null) {
                    str = this.xj.getAppkey();
                }
                return String.valueOf(str);
            default:
                return null;
        }
    }
}
