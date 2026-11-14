package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import IzHBwY.ADYaiT;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.xj.hf;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MediationLoaderConfig {
    private ValueSet xj;

    private MediationLoaderConfig(ValueSet valueSet) {
        if (valueSet != null) {
            SparseArray sparseArray = (SparseArray) valueSet.objectValue(8424, SparseArray.class);
            ADYaiT AMqCpz = (sparseArray == null || sparseArray.size() <= 0) ? null : A2egSU.AMqCpz(sparseArray);
            if (AMqCpz != null) {
                this.xj = AMqCpz;
            } else {
                this.xj = valueSet;
            }
        }
    }

    public static MediationLoaderConfig create(ValueSet valueSet) {
        return new MediationLoaderConfig(valueSet);
    }

    private boolean xj() {
        ValueSet valueSet = this.xj;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public String getADNName() {
        return xj() ? this.xj.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec) : "";
    }

    public ValueSet getAdSlotValueSet() {
        if (xj()) {
            return A2egSU.AMqCpz((SparseArray) this.xj.objectValue(8548, SparseArray.class));
        }
        return null;
    }

    public int getAdType() {
        if (xj()) {
            return this.xj.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
        }
        return 0;
    }

    public String getClassName() {
        return xj() ? this.xj.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public Context getContext() {
        if (xj()) {
            return (Context) this.xj.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class);
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> getGMCustomAdLoader() {
        if (xj()) {
            return hf.xj(this.xj.objectValue(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, Object.class));
        }
        return null;
    }

    public int getManagerLoaderType() {
        if (xj()) {
            return this.xj.intValue(8561);
        }
        return 0;
    }

    public ValueSet getMediationCustomServiceConfigValue() {
        if (xj()) {
            return A2egSU.AMqCpz((SparseArray) this.xj.objectValue(8546, SparseArray.class));
        }
        return null;
    }
}
