package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import IzHBwY.ARc23Z;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;
import com.bytedance.sdk.openadsdk.mediation.xj.xj;
import com.bytedance.sdk.openadsdk.zg.xj.w.hf;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class MediationCustomAdBaseLoader extends xj {
    public Function<SparseArray<Object>, Object> mGmAdLoader;

    private void xj() {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(8405, this);
            A2egSU.B2KMhB(8221, sparseArray, -99999987, -99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xj.xj
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8241) {
            load((Context) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class), new ARc23Z((SparseArray) valueSet.objectValue(8424, SparseArray.class)).A2egSU());
        } else if (i == 8225) {
            y.w(MediationConstant.TAG, "MediationCustomBaseLoader receiveBidResult");
            receiveBidResult(valueSet.booleanValue(8406), valueSet.doubleValue(8407), valueSet.intValue(8408), (Map) valueSet.objectValue(8075, Map.class));
        } else if (i == 8149) {
            y.w(MediationConstant.TAG, "MediationCustomBaseLoader onPause");
            onPause();
        } else if (i == 8148) {
            y.w(MediationConstant.TAG, "MediationCustomBaseLoader onPause");
            onResume();
        } else if (i == 8109) {
            y.w(MediationConstant.TAG, "MediationCustomBaseLoader onDestroy");
            onDestroy();
        }
        return (T) callMethod(i, valueSet, cls);
    }

    public final void callLoadFail(int i, String str) {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B3GDIM(i, sparseArray, 8014, 8015, str);
            A2egSU.B2KMhB(8123, sparseArray, -99999987, -99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public abstract <T> T callMethod(int i, ValueSet valueSet, Class<T> cls);

    @Override // com.bytedance.sdk.openadsdk.mediation.xj.xj
    public SparseArray<Object> get() {
        return null;
    }

    public final String getAdm() {
        Object apply;
        if (this.mGmAdLoader == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(8137, sparseArray, -99999987, -99999985, String.class);
        apply = this.mGmAdLoader.apply(sparseArray);
        return (String) apply;
    }

    public final int getBiddingType() {
        Object apply;
        if (this.mGmAdLoader == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(8226, sparseArray, -99999987, -99999985, Integer.class);
        apply = this.mGmAdLoader.apply(sparseArray);
        Integer num = (Integer) apply;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final Object getExtraDataNoParse() {
        Object apply;
        if (this.mGmAdLoader == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(8224, sparseArray, -99999987, -99999985, Object.class);
        apply = this.mGmAdLoader.apply(sparseArray);
        return apply;
    }

    public final Bridge getGMBridge() {
        Object apply;
        if (this.mGmAdLoader == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(8127, sparseArray, -99999987, -99999985, Bridge.class);
        apply = this.mGmAdLoader.apply(sparseArray);
        return (Bridge) apply;
    }

    public final void load(Context context, ValueSet valueSet) {
        MediationLoaderConfig create = MediationLoaderConfig.create(valueSet);
        ValueSet adSlotValueSet = create.getAdSlotValueSet();
        loadInner(context, hf.xj(adSlotValueSet != null ? adSlotValueSet.sparseArray() : new SparseArray<>()), new com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig(create.getMediationCustomServiceConfigValue()), create.getGMCustomAdLoader());
    }

    public abstract void load(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig mediationCustomServiceConfig);

    public final void loadInner(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig mediationCustomServiceConfig, Function<SparseArray<Object>, Object> function) {
        this.mGmAdLoader = function;
        xj();
        if (adSlot == null) {
            try {
                adSlot = new AdSlot.Builder().build();
            } catch (Exception e) {
                y.xj(e);
                return;
            }
        }
        load(context, adSlot, mediationCustomServiceConfig);
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
    }

    public final void setMediaExtraInfo(Map<String, Object> map) {
        if (this.mGmAdLoader == null || map == null) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(8075, map);
        A2egSU.B2KMhB(8227, sparseArray, -99999987, -99999985, Void.class);
        this.mGmAdLoader.apply(sparseArray);
    }

    public Integer xj(MediationConstant.AdIsReadyStatus adIsReadyStatus) {
        if (adIsReadyStatus == MediationConstant.AdIsReadyStatus.ADN_NO_READY_API) {
            return 1;
        }
        if (adIsReadyStatus == MediationConstant.AdIsReadyStatus.AD_IS_READY) {
            return 2;
        }
        if (adIsReadyStatus == MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED) {
            return 3;
        }
        if (adIsReadyStatus != MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY) {
            return 1;
        }
        return 4;
    }
}
