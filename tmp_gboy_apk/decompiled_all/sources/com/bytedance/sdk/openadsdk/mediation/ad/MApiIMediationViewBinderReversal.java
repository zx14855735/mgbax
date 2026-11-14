package com.bytedance.sdk.openadsdk.mediation.ad;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MApiIMediationViewBinderReversal implements IMediationViewBinderReversal {
    private final Function<SparseArray<Object>, Object> xj;

    public MApiIMediationViewBinderReversal(Function<SparseArray<Object>, Object> function) {
        this.xj = function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getCallToActionId() {
        Object apply;
        if (this.xj == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 271024);
        sparseArray.put(-99999985, Integer.TYPE);
        apply = this.xj.apply(sparseArray);
        Integer num = (Integer) apply;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getDecriptionTextId() {
        Object apply;
        if (this.xj == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 271023);
        sparseArray.put(-99999985, Integer.TYPE);
        apply = this.xj.apply(sparseArray);
        Integer num = (Integer) apply;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public Map<String, Integer> getExtras() {
        Object apply;
        if (this.xj == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(271034, sparseArray, -99999987, -99999985, Map.class);
        apply = this.xj.apply(sparseArray);
        return (Map) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage1Id() {
        Object apply;
        if (this.xj == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 271029);
        sparseArray.put(-99999985, Integer.TYPE);
        apply = this.xj.apply(sparseArray);
        Integer num = (Integer) apply;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage2Id() {
        Object apply;
        if (this.xj == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 271030);
        sparseArray.put(-99999985, Integer.TYPE);
        apply = this.xj.apply(sparseArray);
        Integer num = (Integer) apply;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage3Id() {
        Object apply;
        if (this.xj == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 271031);
        sparseArray.put(-99999985, Integer.TYPE);
        apply = this.xj.apply(sparseArray);
        Integer num = (Integer) apply;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getIconImageId() {
        Object apply;
        if (this.xj == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 271025);
        sparseArray.put(-99999985, Integer.TYPE);
        apply = this.xj.apply(sparseArray);
        Integer num = (Integer) apply;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getLayoutId() {
        Object apply;
        if (this.xj == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 271021);
        sparseArray.put(-99999985, Integer.TYPE);
        apply = this.xj.apply(sparseArray);
        Integer num = (Integer) apply;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getLogoLayoutId() {
        Object apply;
        if (this.xj == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 271032);
        sparseArray.put(-99999985, Integer.TYPE);
        apply = this.xj.apply(sparseArray);
        Integer num = (Integer) apply;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getMainImageId() {
        Object apply;
        if (this.xj == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 271026);
        sparseArray.put(-99999985, Integer.TYPE);
        apply = this.xj.apply(sparseArray);
        Integer num = (Integer) apply;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getMediaViewId() {
        Object apply;
        if (this.xj == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 271027);
        sparseArray.put(-99999985, Integer.TYPE);
        apply = this.xj.apply(sparseArray);
        Integer num = (Integer) apply;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getShakeViewContainerId() {
        Object apply;
        if (this.xj == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 271033);
        sparseArray.put(-99999985, Integer.TYPE);
        apply = this.xj.apply(sparseArray);
        Integer num = (Integer) apply;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getSourceId() {
        Object apply;
        if (this.xj == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 271028);
        sparseArray.put(-99999985, Integer.TYPE);
        apply = this.xj.apply(sparseArray);
        Integer num = (Integer) apply;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getTitleId() {
        Object apply;
        if (this.xj == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 271022);
        sparseArray.put(-99999985, Integer.TYPE);
        apply = this.xj.apply(sparseArray);
        Integer num = (Integer) apply;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
