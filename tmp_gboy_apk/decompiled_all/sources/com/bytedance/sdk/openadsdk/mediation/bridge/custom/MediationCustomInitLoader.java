package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import IzHBwY.ARc23Z;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.api.y;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig;
import com.bytedance.sdk.openadsdk.mediation.xj.xj;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class MediationCustomInitLoader extends xj {
    private Function<SparseArray<Object>, Object> xj;

    private void xj() {
        if (this.xj != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(AVMDLDataLoader.KeyIsLoaderFactoryP2PLevel, sparseArray, -99999987, -99999985, String.class);
            sparseArray.put(8402, this);
            this.xj.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xj.xj
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8240) {
            initAdn((Context) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class), new ARc23Z((SparseArray) valueSet.objectValue(8424, SparseArray.class)).A2egSU());
        } else {
            if (i == 8139) {
                return (T) getBiddingToken((Context) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class), (Map) valueSet.objectValue(8075, Map.class));
            }
            if (i == 8217) {
                return (T) getSdkInfo((Context) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class), (Map) valueSet.objectValue(8075, Map.class));
            }
            if (i == 8218) {
                return (T) getNetworkSdkVersion();
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public final void callInitSuccess() {
        if (this.xj != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(AVMDLDataLoader.KeyIsEnableEarlyData, sparseArray, -99999987, -99999985, String.class);
            this.xj.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xj.xj
    public SparseArray<Object> get() {
        return null;
    }

    public String getBiddingToken(Context context, Map<String, Object> map) {
        return null;
    }

    public abstract String getNetworkSdkVersion();

    public String getSdkInfo(Context context, Map<String, Object> map) {
        return null;
    }

    public final void initAdn(Context context, ValueSet valueSet) {
        MediationInitConfig create = MediationInitConfig.create(valueSet);
        TTCustomController xj = xj(create);
        Map customInitMap = create.getCustomInitMap();
        if (customInitMap == null) {
            customInitMap = new HashMap();
        }
        customInitMap.put("custom_controller", xj);
        initInnerADN(context, new com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig(create.getCustomInitConfigValueSet()), customInitMap, create.getCustomGMConfiguration());
    }

    public final void initInnerADN(Context context, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig mediationCustomInitConfig, Map<String, Object> map, Function<SparseArray<Object>, Object> function) {
        this.xj = function;
        xj();
        try {
            initializeADN(context, mediationCustomInitConfig, map);
        } catch (Exception e) {
            y.xj(e);
        }
    }

    public abstract void initializeADN(Context context, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig mediationCustomInitConfig, Map<String, Object> map);

    public final boolean isInit() {
        Object apply;
        if (this.xj == null) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(8220, sparseArray, -99999987, -99999985, Boolean.class);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) MediationValueUtil.objectValue(apply, Boolean.class, Boolean.FALSE)).booleanValue();
    }

    public void notifyInitDuration(boolean z, long j) {
        if (this.xj != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8270, sparseArray, -99999987, -99999985, String.class);
            sparseArray.put(8073, Long.valueOf(j));
            sparseArray.put(8557, Integer.valueOf(z ? 1 : 0));
            this.xj.apply(sparseArray);
        }
    }

    private TTCustomController xj(final MediationInitConfig mediationInitConfig) {
        return new TTCustomController() { // from class: com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader.1
            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean alist() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                return mediationInitConfig2 != null ? mediationInitConfig2.appList() : super.alist();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getAndroidId() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                return mediationInitConfig2 != null ? mediationInitConfig2.getAndroidId() : super.getAndroidId();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getDevImei() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                return mediationInitConfig2 != null ? mediationInitConfig2.getDevImei() : super.getDevImei();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getDevOaid() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                return mediationInitConfig2 != null ? mediationInitConfig2.getDevOaid() : super.getDevOaid();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getMacAddress() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                return mediationInitConfig2 != null ? mediationInitConfig2.getMacAddress() : super.getMacAddress();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public LocationProvider getTTLocation() {
                IMediationLocation location;
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                if (mediationInitConfig2 == null || (location = mediationInitConfig2.getLocation()) == null) {
                    return super.getTTLocation();
                }
                final double latitude = location.getLatitude();
                final double longitude = location.getLongitude();
                return new LocationProvider() { // from class: com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader.1.1
                    @Override // com.bytedance.sdk.openadsdk.LocationProvider
                    public double getLatitude() {
                        return latitude;
                    }

                    @Override // com.bytedance.sdk.openadsdk.LocationProvider
                    public double getLongitude() {
                        return longitude;
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseAndroidId() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                return mediationInitConfig2 != null ? mediationInitConfig2.isCanUseAndroidId() : super.isCanUseAndroidId();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseLocation() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                return mediationInitConfig2 != null ? mediationInitConfig2.isCanUseLocation() : super.isCanUseLocation();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePermissionRecordAudio() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                return mediationInitConfig2 != null ? mediationInitConfig2.isCanUsePermissionRecordAudio() : super.isCanUsePermissionRecordAudio();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePhoneState() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                return mediationInitConfig2 != null ? mediationInitConfig2.isCanUsePhoneState() : super.isCanUsePhoneState();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWifiState() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                return mediationInitConfig2 != null ? mediationInitConfig2.isCanUseWifiState() : super.isCanUseWifiState();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWriteExternal() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                return mediationInitConfig2 != null ? mediationInitConfig2.isCanUseWriteExternal() : super.isCanUseWriteExternal();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public Map<String, Object> userPrivacyConfig() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                return mediationInitConfig2 != null ? mediationInitConfig2.userPrivacyConfig() : super.userPrivacyConfig();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public MediationPrivacyConfig getMediationPrivacyConfig() {
                return new MediationPrivacyConfig() { // from class: com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader.1.2
                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public List<String> getCustomAppList() {
                        MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                        return mediationInitConfig2 != null ? mediationInitConfig2.getAppList() : super.getCustomAppList();
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public List<String> getCustomDevImeis() {
                        MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                        return mediationInitConfig2 != null ? mediationInitConfig2.getDevImeis() : super.getCustomDevImeis();
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public boolean isCanUseOaid() {
                        MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                        return mediationInitConfig2 != null ? mediationInitConfig2.isCanUseOaid() : super.isCanUseOaid();
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public boolean isLimitPersonalAds() {
                        MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                        return mediationInitConfig2 != null ? mediationInitConfig2.isLimitPersonalAds() : super.isLimitPersonalAds();
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public boolean isProgrammaticRecommend() {
                        MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                        return mediationInitConfig2 != null ? mediationInitConfig2.isProgrammaticRecommend() : super.isProgrammaticRecommend();
                    }
                };
            }
        };
    }
}
