package com.bytedance.sdk.openadsdk.mediation.ad.xj.xj.hf;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd implements Function<SparseArray<Object>, Object> {
    private final IMediationViewBinder xj;

    public kd(IMediationViewBinder iMediationViewBinder) {
        this.xj = iMediationViewBinder;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Object apply;
        if (this.xj == null) {
            return null;
        }
        switch (new ARc23Z(sparseArray).A2egSU().intValue(-99999987, 0)) {
            case 271021:
                return Integer.class.cast(Integer.valueOf(this.xj.getLayoutId()));
            case 271022:
                return Integer.class.cast(Integer.valueOf(this.xj.getTitleId()));
            case 271023:
                return Integer.class.cast(Integer.valueOf(this.xj.getDecriptionTextId()));
            case 271024:
                return Integer.class.cast(Integer.valueOf(this.xj.getCallToActionId()));
            case 271025:
                return Integer.class.cast(Integer.valueOf(this.xj.getIconImageId()));
            case 271026:
                return Integer.class.cast(Integer.valueOf(this.xj.getMainImageId()));
            case 271027:
                return Integer.class.cast(Integer.valueOf(this.xj.getMediaViewId()));
            case 271028:
                return Integer.class.cast(Integer.valueOf(this.xj.getSourceId()));
            case 271029:
                return Integer.class.cast(Integer.valueOf(this.xj.getGroupImage1Id()));
            case 271030:
                return Integer.class.cast(Integer.valueOf(this.xj.getGroupImage2Id()));
            case 271031:
                return Integer.class.cast(Integer.valueOf(this.xj.getGroupImage3Id()));
            case 271032:
                return Integer.class.cast(Integer.valueOf(this.xj.getLogoLayoutId()));
            case 271033:
                return Integer.class.cast(Integer.valueOf(this.xj.getShakeViewContainerId()));
            case 271034:
                return this.xj.getExtras();
            default:
                apply = ARc23Z.f4112ADYaiT.apply(sparseArray);
                return apply;
        }
    }
}
