package com.bytedance.sdk.openadsdk.zg.xj.w;

import IzHBwY.ADYaiT;
import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import com.bytedance.sdk.openadsdk.zg.xj.xj.qt;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {

    public static class xj {
        private Function<SparseArray<Object>, Object> xj;

        public xj(Function<SparseArray<Object>, Object> function) {
            this.xj = function;
        }

        public IMediationAdSlot xj() {
            Object apply;
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8260031);
            apply = this.xj.apply(sparseArray);
            if (apply instanceof IMediationAdSlot) {
                return (IMediationAdSlot) apply;
            }
            return null;
        }
    }

    public static final SparseArray<Object> xj(final AdSlot adSlot) {
        if (adSlot == null) {
            return new SparseArray<>();
        }
        ARc23Z A4TApA2 = ARc23Z.A4TApA();
        A4TApA2.ARc23Z(260001, adSlot.getAdId());
        A4TApA2.ARc23Z(260002, adSlot.getCreativeId());
        A4TApA2.ARc23Z(260003, adSlot.getExt());
        A4TApA2.ARc23Z(260004, adSlot.getCodeId());
        A4TApA2.ASJ6gh(260005, adSlot.isAutoPlay());
        A4TApA2.ADYaiT(260006, adSlot.getImgAcceptedWidth());
        A4TApA2.ADYaiT(260007, adSlot.getImgAcceptedHeight());
        Float valueOf = Float.valueOf(adSlot.getExpressViewAcceptedWidth());
        SparseArray sparseArray = A4TApA2.f4113A2egSU;
        sparseArray.put(260008, valueOf);
        sparseArray.put(260009, Float.valueOf(adSlot.getExpressViewAcceptedHeight()));
        A4TApA2.ASJ6gh(260010, adSlot.isSupportDeepLink());
        A4TApA2.ASJ6gh(260011, adSlot.isSupportRenderConrol());
        A4TApA2.ADYaiT(2600012, adSlot.getAdCount());
        A4TApA2.ARc23Z(260013, adSlot.getMediaExtra());
        A4TApA2.ARc23Z(260014, adSlot.getUserID());
        A4TApA2.ADYaiT(260015, adSlot.getOrientation());
        A4TApA2.ADYaiT(260016, adSlot.getNativeAdType());
        A4TApA2.AMqCpz(260017, adSlot.getExternalABVid());
        A4TApA2.ADYaiT(260018, adSlot.getAdloadSeq());
        A4TApA2.ARc23Z(260019, adSlot.getPrimeRit());
        A4TApA2.ADYaiT(260020, adSlot.getAdType());
        A4TApA2.ARc23Z(260021, adSlot.getBidAdm());
        A4TApA2.ARc23Z(260022, adSlot.getUserData());
        A4TApA2.AMqCpz(260023, xj(adSlot.getAdLoadType()));
        A4TApA2.AMqCpz(260024, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.hf.1
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return AdSlot.this.getRewardName();
            }
        });
        A4TApA2.AMqCpz(260025, new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.hf.2
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(AdSlot.this.getRewardAmount());
            }
        });
        A4TApA2.AMqCpz(260026, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.hf.3
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(AdSlot.this.isSupportIconStyle());
            }
        });
        if (adSlot.getMediationAdSlot() != null) {
            A4TApA2.AMqCpz(8260028, new com.bytedance.sdk.openadsdk.mediation.ad.xj.xj.hf.xj(adSlot.getMediationAdSlot()));
        }
        return A4TApA2.A2egSU().sparseArray();
    }

    public static AdSlot xj(SparseArray<Object> sparseArray) {
        AdSlot.Builder builder = new AdSlot.Builder();
        ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
        builder.setAdId(AMqCpz.stringValue(260001, null)).setCodeId(AMqCpz.stringValue(260002, null)).setExt(AMqCpz.stringValue(260003, null)).setCodeId(AMqCpz.stringValue(260004, null)).setIsAutoPlay(AMqCpz.booleanValue(260005, false)).setImageAcceptedSize(AMqCpz.intValue(260006, 0), AMqCpz.intValue(260007, 0)).setExpressViewAcceptedSize(AMqCpz.floatValue(260008, 0.0f), AMqCpz.floatValue(260009, 0.0f)).setSupportDeepLink(AMqCpz.booleanValue(260010, false)).setAdCount(AMqCpz.intValue(2600012, 0)).setMediaExtra(AMqCpz.stringValue(260013, null)).setUserID(AMqCpz.stringValue(260014, null)).setExternalABVid((int[]) AMqCpz.objectValue(260017, int[].class)).setAdloadSeq(AMqCpz.intValue(260018, 0)).setPrimeRit(AMqCpz.stringValue(260019, null)).setAdType(AMqCpz.intValue(260020, 0)).withBid(AMqCpz.stringValue(260021, null)).setUserData(AMqCpz.stringValue(260022, null)).setAdLoadType(xj(AMqCpz.intValue(260023, 0))).setMediationAdSlot(new xj(qt.xj(AMqCpz.objectValue(8260028, Object.class))).xj()).setOrientation(AMqCpz.intValue(260015, 0)).setRewardName((String) AMqCpz.objectValue(260024, String.class)).setRewardAmount(AMqCpz.intValue(260025, 0));
        if (AMqCpz.booleanValue(260011, false)) {
            builder.supportRenderControl();
        }
        return builder.build();
    }

    private static Integer xj(TTAdLoadType tTAdLoadType) {
        if (tTAdLoadType == null) {
            return null;
        }
        if (tTAdLoadType == TTAdLoadType.UNKNOWN) {
            return -1;
        }
        if (tTAdLoadType == TTAdLoadType.LOAD) {
            return 3;
        }
        return tTAdLoadType == TTAdLoadType.PRELOAD ? 1 : null;
    }

    private static TTAdLoadType xj(int i) {
        if (i == 3) {
            return TTAdLoadType.LOAD;
        }
        if (i == 1) {
            return TTAdLoadType.PRELOAD;
        }
        return TTAdLoadType.UNKNOWN;
    }
}
