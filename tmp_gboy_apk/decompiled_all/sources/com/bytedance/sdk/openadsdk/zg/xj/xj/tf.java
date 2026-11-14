package com.bytedance.sdk.openadsdk.zg.xj.xj;

import IzHBwY.ARc23Z;
import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class tf implements TTFullScreenVideoAd {
    private ValueSet hf;
    private final Function<SparseArray<Object>, Object> xj;

    public tf(Function<SparseArray<Object>, Object> function) {
        Object apply;
        this.hf = ARc23Z.f4110A4TApA;
        function = function == null ? ARc23Z.f4112ADYaiT : function;
        this.xj = function;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(-99999986, sparseArray, -99999987, -99999985, SparseArray.class);
        apply = function.apply(sparseArray);
        if (apply instanceof SparseArray) {
            this.hf = A2egSU.AMqCpz((SparseArray) apply);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public long getExpirationTimestamp() {
        return this.hf.longValue(130004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        return this.hf.intValue(130003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        return this.hf.intValue(130001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.hf.objectValue(130002, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public MediationFullScreenManager getMediationManager() {
        Object apply;
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 130106);
        sparseArray.put(-99999985, Object.class);
        apply = this.xj.apply(sparseArray);
        return new com.bytedance.sdk.openadsdk.mediation.manager.xj.xj.xj.w(qt.xj(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d, String str, String str2) {
        SparseArray sparseArray = new SparseArray(5);
        A2egSU.B2KMhB(210102, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, d);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 210104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.zg.xj.hf.hf(tTAdInteractionListener));
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 130102);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.zg.xj.hf.w(tTAppDownloadListener));
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        SparseArray sparseArray = new SparseArray(4);
        A2egSU.B2KMhB(130101, sparseArray, -99999987, -99999985, Void.class);
        if (fullScreenVideoAdInteractionListener instanceof IMediationInterstitialFullAdListener) {
            sparseArray.put(0, new com.bytedance.sdk.openadsdk.mediation.hf.xj.hf.hf((IMediationInterstitialFullAdListener) fullScreenVideoAdInteractionListener));
            sparseArray.put(1, 1);
        } else {
            sparseArray.put(0, new com.bytedance.sdk.openadsdk.ra.xj.xj.xj.xj(fullScreenVideoAdInteractionListener));
            sparseArray.put(1, 0);
        }
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d) {
        SparseArray sparseArray = new SparseArray(3);
        A2egSU.B2KMhB(210103, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, d);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity) {
        SparseArray sparseArray = new SparseArray(3);
        A2egSU.B2KMhB(130103, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, activity);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d) {
        SparseArray sparseArray = new SparseArray(3);
        A2egSU.B2KMhB(210101, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, d);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        SparseArray sparseArray = new SparseArray(5);
        A2egSU.B2KMhB(130104, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, activity);
        sparseArray.put(1, ritScenes == null ? null : ritScenes.getScenesName());
        sparseArray.put(2, str);
        this.xj.apply(sparseArray);
    }
}
