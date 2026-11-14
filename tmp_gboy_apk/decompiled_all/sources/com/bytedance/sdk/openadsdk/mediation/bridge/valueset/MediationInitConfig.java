package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import ADYaiT.BpkvW3;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.y;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import com.bytedance.sdk.openadsdk.mediation.xj.hf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MediationInitConfig {
    private static String xj = "MEDIATION_LOG";
    private ValueSet hf;
    private ValueSet u;
    private ValueSet w;

    private MediationInitConfig(ValueSet valueSet) {
        this.hf = valueSet;
        if (valueSet != null) {
            this.u = A2egSU.AMqCpz((SparseArray) valueSet.objectValue(8457, SparseArray.class));
            this.w = A2egSU.AMqCpz((SparseArray) this.hf.objectValue(8475, SparseArray.class));
        }
        xj();
    }

    public static MediationInitConfig create(ValueSet valueSet) {
        return new MediationInitConfig(valueSet);
    }

    private void hf() {
        y.w(xj, "---------  sdk 聚合信息 start ----");
        y.w(xj, "getHttps：" + getHttps());
        y.w(xj, "getWxAppId：" + getWxAppId());
        y.w(xj, "getPublisherDid：" + getPublisherDid());
        y.w(xj, "isOpenAdnTest：" + isOpenAdnTest());
        y.w(xj, "getMediationConfigUserInfoForSegment：" + getMediationConfigUserInfoForSegment());
        y.w(xj, "getLocalExtra：" + getLocalExtra());
        y.w(xj, "getCustomLocalConfig：" + getCustomLocalConfig());
        y.w(xj, "getOpensdkVer：" + getOpensdkVer());
        y.w(xj, "isWxInstalled：" + isWxInstalled());
        y.w(xj, "isSupportH265：" + isSupportH265());
        y.w(xj, "isSupportSplashZoomout：" + isSupportSplashZoomout());
        y.w(xj, "---------  sdk 聚合信息 end ----");
    }

    private boolean kd() {
        ValueSet valueSet = this.hf;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    private void u() {
        y.w(xj, "---------  sdk 隐私设置 start ----");
        y.w(xj, "isCanUseLocation：" + isCanUseLocation());
        IMediationLocation location = getLocation();
        if (location != null) {
            y.w(xj, "getLocation getLatitude：" + location.getLatitude());
            y.w(xj, "getLocation getLongitude：" + location.getLongitude());
        } else {
            y.w(xj, "getLocation is null");
        }
        y.w(xj, "appList：" + appList());
        y.w(xj, "isCanUsePhoneState：" + isCanUsePhoneState());
        y.w(xj, "isLimitPersonalAds：" + isLimitPersonalAds());
        y.w(xj, "getDevImei：" + getDevImei());
        y.w(xj, "isCanUseWifiState：" + isCanUseWifiState());
        y.w(xj, "getMacAddress：" + getMacAddress());
        y.w(xj, "isCanUseWriteExternal：" + isCanUseWriteExternal());
        y.w(xj, "isCanUseAndroidId：" + isCanUseAndroidId());
        y.w(xj, "getAndroidId：" + getAndroidId());
        y.w(xj, "isCanUseMessage：" + isCanUseMessage());
        List<String> appList = getAppList();
        y.w(xj, "getAppList：".concat(String.valueOf(appList)));
        if (appList != null) {
            Iterator<String> it = appList.iterator();
            while (it.hasNext()) {
                y.w(xj, "getAppList item: ".concat(String.valueOf(it.next())));
            }
        }
        List<String> devImeis = getDevImeis();
        y.w(xj, "getDevImeis：".concat(String.valueOf(devImeis)));
        if (devImeis != null) {
            Iterator<String> it2 = devImeis.iterator();
            while (it2.hasNext()) {
                y.w(xj, "getDevImeis item: ".concat(String.valueOf(it2.next())));
            }
        }
        y.w(xj, "getDevOaid：" + getDevOaid());
        y.w(xj, "isCanUseOaid：" + isCanUseOaid());
        y.w(xj, "isCanUseMacAddress：" + isCanUseMacAddress());
        y.w(xj, "isProgrammaticRecommend：" + isProgrammaticRecommend());
        y.w(xj, "isCanUsePermissionRecordAudio：" + isCanUsePermissionRecordAudio());
        y.w(xj, "---------  sdk 隐私设置 end ----");
    }

    private void w() {
        y.w(xj, "---------  sdk 初始化信息 start ----");
        y.w(xj, "isDebug：" + isDebug());
        y.w(xj, "getClassName：" + getClassName());
        y.w(xj, "getAppId：" + getAppId());
        y.w(xj, "getAppName：" + getAppName());
        y.w(xj, "getADNName：" + getADNName());
        y.w(xj, "getAppKey：" + getAppKey());
        y.w(xj, "getInitCallback：" + getInitCallback());
        y.w(xj, "getAgeGroup：" + getAgeGroup());
        y.w(xj, "isCustom：" + isCustom());
        y.w(xj, "getCustomInitConfig：" + getCustomInitConfig());
        y.w(xj, "getCustomInitMap：" + getCustomInitMap());
        y.w(xj, "getCustomGMConfiguration：" + getCustomGMConfiguration());
        y.w(xj, "getKsAdapterVersion：" + getKsAdapterVersion());
        y.w(xj, "getGromoreVersion：" + getGromoreVersion());
        y.w(xj, "getAdmobAdapterVersion：" + getAdmobAdapterVersion());
        y.w(xj, "getBaiduAdapterVersion：" + getBaiduAdapterVersion());
        y.w(xj, "getGdtAdapterVersion：" + getGdtAdapterVersion());
        y.w(xj, "getKlevinAdapterVersion：" + getKlevinAdapterVersion());
        y.w(xj, "getMintegralAdapterVersion：" + getMintegralAdapterVersion());
        y.w(xj, "getSigmobAdapterVersion：" + getSigmobAdapterVersion());
        y.w(xj, "getUnityAdapterVersion：" + getUnityAdapterVersion());
        y.w(xj, "getMap：" + getInitAdnMap());
        y.w(xj, "---------  sdk 初始化信息 end ----");
    }

    private void xj() {
        w();
        u();
        hf();
    }

    public boolean appList() {
        ValueSet valueSet = this.w;
        if (valueSet != null) {
            return valueSet.booleanValue(8026);
        }
        return true;
    }

    public String getADNName() {
        return kd() ? this.hf.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec) : "";
    }

    public String getAdapterManagerClassName() {
        ValueSet valueSet = this.hf;
        if (valueSet != null) {
            return valueSet.stringValue(8560);
        }
        return null;
    }

    public String getAdmobAdapterVersion() {
        ValueSet valueSet = this.hf;
        return valueSet != null ? valueSet.stringValue(8412) : "";
    }

    public int getAgeGroup() {
        if (kd()) {
            return this.hf.intValue(7);
        }
        return 0;
    }

    public String getAndroidId() {
        ValueSet valueSet = this.w;
        return valueSet != null ? valueSet.stringValue(8485) : "";
    }

    public String getAppId() {
        if (kd()) {
            return this.hf.stringValue(3);
        }
        return null;
    }

    public String getAppKey() {
        return kd() ? this.hf.stringValue(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold) : "";
    }

    public List<String> getAppList() {
        Function<SparseArray<Object>, Object> xj2;
        ValueSet valueSet = this.w;
        if (valueSet != null && (xj2 = hf.xj(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = BpkvW3.BNL6CD(xj2) ? BpkvW3.B2KMhB(xj2).get() : null;
            if (obj instanceof SparseArray) {
                return (List) MediationValueUtil.objectValue(((SparseArray) obj).get(8476), List.class, null);
            }
        }
        return new LinkedList();
    }

    public String getAppName() {
        return kd() ? this.hf.stringValue(8) : "";
    }

    public String getBaiduAdapterVersion() {
        ValueSet valueSet = this.hf;
        return valueSet != null ? valueSet.stringValue(8413) : "";
    }

    public String getClassName() {
        return kd() ? this.hf.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public Function getCustomGMConfiguration() {
        if (kd()) {
            return hf.xj(this.hf.objectValue(8401, Object.class));
        }
        return null;
    }

    public MediationCustomInitConfig getCustomInitConfig() {
        if (kd()) {
            return (MediationCustomInitConfig) this.hf.objectValue(8099, MediationCustomInitConfig.class);
        }
        return null;
    }

    public ValueSet getCustomInitConfigValueSet() {
        if (kd()) {
            return A2egSU.AMqCpz((SparseArray) this.hf.objectValue(8545, SparseArray.class));
        }
        return null;
    }

    public Map getCustomInitMap() {
        if (kd()) {
            return (Map) this.hf.objectValue(8400, Map.class);
        }
        return null;
    }

    public JSONObject getCustomLocalConfig() {
        ValueSet valueSet = this.u;
        if (valueSet != null) {
            return (JSONObject) valueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public String getDevImei() {
        ValueSet valueSet = this.w;
        return valueSet != null ? valueSet.stringValue(8484) : "";
    }

    public List<String> getDevImeis() {
        Function<SparseArray<Object>, Object> xj2;
        ValueSet valueSet = this.w;
        if (valueSet != null && (xj2 = hf.xj(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = BpkvW3.BNL6CD(xj2) ? BpkvW3.B2KMhB(xj2).get() : null;
            if (obj instanceof SparseArray) {
                return (List) MediationValueUtil.objectValue(((SparseArray) obj).get(8477), List.class, null);
            }
        }
        return new LinkedList();
    }

    public String getDevOaid() {
        ValueSet valueSet = this.w;
        return valueSet != null ? valueSet.stringValue(8486) : "";
    }

    public String getGdtAdapterVersion() {
        ValueSet valueSet = this.hf;
        return valueSet != null ? valueSet.stringValue(8414) : "";
    }

    public String getGromoreVersion() {
        ValueSet valueSet = this.hf;
        return valueSet != null ? valueSet.stringValue(8411) : "";
    }

    public boolean getHttps() {
        ValueSet valueSet = this.u;
        if (valueSet != null) {
            return valueSet.booleanValue(8458);
        }
        return false;
    }

    public Map getInitAdnMap() {
        ValueSet valueSet = this.hf;
        return valueSet != null ? (Map) valueSet.objectValue(8425, Map.class) : new HashMap();
    }

    public Function getInitCallback() {
        if (kd()) {
            return hf.xj(this.hf.objectValue(8300, Object.class));
        }
        return null;
    }

    public String getKlevinAdapterVersion() {
        ValueSet valueSet = this.hf;
        return valueSet != null ? valueSet.stringValue(8415) : "";
    }

    public String getKsAdapterVersion() {
        ValueSet valueSet = this.hf;
        return valueSet != null ? valueSet.stringValue(8410) : "";
    }

    public Map getLocalExtra() {
        ValueSet valueSet = this.u;
        return valueSet != null ? (Map) valueSet.objectValue(8462, Map.class) : new HashMap();
    }

    public IMediationLocation getLocation() {
        Function<SparseArray<Object>, Object> xj2;
        ValueSet valueSet = this.w;
        if (valueSet != null && (xj2 = hf.xj(valueSet.objectValue(8312, Object.class))) != null) {
            Object obj = BpkvW3.BNL6CD(xj2) ? BpkvW3.B2KMhB(xj2).get() : null;
            if (obj instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) obj;
                final double doubleValue = ((Double) MediationValueUtil.objectValue(sparseArray.get(8481), Double.class, Double.valueOf(0.0d))).doubleValue();
                final double doubleValue2 = ((Double) MediationValueUtil.objectValue(sparseArray.get(8482), Double.class, Double.valueOf(0.0d))).doubleValue();
                return new IMediationLocation() { // from class: com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig.1
                    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
                    public double getLatitude() {
                        return doubleValue;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
                    public double getLongitude() {
                        return doubleValue2;
                    }
                };
            }
        }
        return null;
    }

    public String getMacAddress() {
        ValueSet valueSet = this.w;
        return valueSet != null ? valueSet.stringValue(8487) : "";
    }

    public Function getMediationConfigUserInfoForSegment() {
        ValueSet valueSet = this.u;
        if (valueSet != null) {
            return hf.xj(valueSet.objectValue(8310, Object.class));
        }
        return null;
    }

    public String getMintegralAdapterVersion() {
        ValueSet valueSet = this.hf;
        return valueSet != null ? valueSet.stringValue(8416) : "";
    }

    public String getOpensdkVer() {
        ValueSet valueSet = this.u;
        return valueSet != null ? valueSet.stringValue(8464) : "";
    }

    public String getPublisherDid() {
        ValueSet valueSet = this.u;
        return valueSet != null ? valueSet.stringValue(8460) : "";
    }

    public String getSigmobAdapterVersion() {
        ValueSet valueSet = this.hf;
        return valueSet != null ? valueSet.stringValue(8417) : "";
    }

    public String getUnityAdapterVersion() {
        ValueSet valueSet = this.hf;
        return valueSet != null ? valueSet.stringValue(8418) : "";
    }

    public ValueSet getValueSet() {
        return this.hf;
    }

    public String getWxAppId() {
        ValueSet valueSet = this.u;
        return valueSet != null ? valueSet.stringValue(8459) : "";
    }

    public boolean isCanUseAndroidId() {
        ValueSet valueSet = this.w;
        if (valueSet != null) {
            return valueSet.booleanValue(8479);
        }
        return true;
    }

    public boolean isCanUseLocation() {
        ValueSet valueSet = this.w;
        if (valueSet != null) {
            return valueSet.booleanValue(8024);
        }
        return true;
    }

    public boolean isCanUseMacAddress() {
        return isCanUseWifiState();
    }

    public boolean isCanUseMessage() {
        ValueSet valueSet = this.w;
        if (valueSet != null) {
            return valueSet.booleanValue(8562);
        }
        return true;
    }

    public boolean isCanUseOaid() {
        Function<SparseArray<Object>, Object> xj2;
        ValueSet valueSet = this.w;
        if (valueSet == null || (xj2 = hf.xj(valueSet.objectValue(8311, Object.class))) == null) {
            return true;
        }
        Object obj = BpkvW3.BNL6CD(xj2) ? BpkvW3.B2KMhB(xj2).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8478), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public boolean isCanUsePermissionRecordAudio() {
        ValueSet valueSet = this.w;
        if (valueSet != null) {
            return valueSet.booleanValue(8549);
        }
        return true;
    }

    public boolean isCanUsePhoneState() {
        ValueSet valueSet = this.w;
        if (valueSet != null) {
            return valueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean isCanUseWifiState() {
        ValueSet valueSet = this.w;
        if (valueSet != null) {
            return valueSet.booleanValue(8480);
        }
        return true;
    }

    public boolean isCanUseWriteExternal() {
        ValueSet valueSet = this.w;
        if (valueSet != null) {
            return valueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean isCustom() {
        if (kd()) {
            return this.hf.booleanValue(8098);
        }
        return false;
    }

    public boolean isDebug() {
        ValueSet valueSet = this.hf;
        if (valueSet != null) {
            return valueSet.booleanValue(1);
        }
        return false;
    }

    public boolean isLimitPersonalAds() {
        Function<SparseArray<Object>, Object> xj2;
        ValueSet valueSet = this.w;
        if (valueSet == null || (xj2 = hf.xj(valueSet.objectValue(8311, Object.class))) == null) {
            return false;
        }
        Object obj = BpkvW3.BNL6CD(xj2) ? BpkvW3.B2KMhB(xj2).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8027), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean isOpenAdnTest() {
        ValueSet valueSet = this.u;
        if (valueSet != null) {
            return valueSet.booleanValue(8461);
        }
        return false;
    }

    public boolean isProgrammaticRecommend() {
        Function<SparseArray<Object>, Object> xj2;
        ValueSet valueSet = this.w;
        if (valueSet == null || (xj2 = hf.xj(valueSet.objectValue(8311, Object.class))) == null) {
            return true;
        }
        Object obj = BpkvW3.BNL6CD(xj2) ? BpkvW3.B2KMhB(xj2).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8028), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public boolean isSupportH265() {
        ValueSet valueSet = this.u;
        if (valueSet != null) {
            return valueSet.booleanValue(8466);
        }
        return false;
    }

    public boolean isSupportSplashZoomout() {
        ValueSet valueSet = this.u;
        if (valueSet != null) {
            return valueSet.booleanValue(8467);
        }
        return false;
    }

    public boolean isWxInstalled() {
        ValueSet valueSet = this.u;
        if (valueSet != null) {
            return valueSet.booleanValue(8465);
        }
        return false;
    }

    public void setMediationCustomControllerValueSet(ValueSet valueSet) {
        this.w = valueSet;
        u();
    }

    public Map<String, Object> userPrivacyConfig() {
        ValueSet valueSet = this.w;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8554, Map.class);
        }
        return null;
    }
}
