package com.bytedance.msdk.xj.w;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private PluginValueSet hf;
    private Function<SparseArray<Object>, Object> kd;
    private com.bytedance.sdk.openadsdk.zg.w.w.xj u = new com.bytedance.sdk.openadsdk.zg.w.w.xj(com.bytedance.msdk.core.xj.p().a().sparseArray());
    private PluginValueSet w;
    private PluginValueSet xj;

    private w(SparseArray<Object> sparseArray) {
        this.kd = null;
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        this.xj = ADYaiT2;
        this.w = com.bytedance.sdk.openadsdk.zg.w.u.xj(8457, ADYaiT2);
        PluginValueSet xj = com.bytedance.sdk.openadsdk.zg.w.u.xj(8475, this.xj);
        this.hf = xj;
        if (xj != null) {
            this.kd = AaHO0E.AYUAbz(xj.objectValue(8311, AaHO0E.ARc23Z()));
        }
        yy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double aq() {
        Function AYUAbz2;
        PluginValueSet hf;
        PluginValueSet pluginValueSet = this.hf;
        if (pluginValueSet == null || (AYUAbz2 = AaHO0E.AYUAbz(pluginValueSet.objectValue(8312, AaHO0E.ARc23Z()))) == null || (hf = com.bytedance.sdk.openadsdk.zg.w.hf(AYUAbz2)) == null) {
            return -1.0d;
        }
        return hf.doubleValue(8481);
    }

    private void dc() {
        com.bytedance.msdk.xj.kd.w.hf("---------  sdk 隐私设置 start ----");
        com.bytedance.msdk.xj.kd.w.hf("isCanUseLocation：" + d());
        u qt = qt();
        com.bytedance.msdk.xj.kd.w.hf("getLocation：".concat(String.valueOf(qt)));
        if (qt != null) {
            com.bytedance.msdk.xj.kd.w.hf("getLocation getLatitude：" + qt.xj());
            com.bytedance.msdk.xj.kd.w.hf("getLocation getLongitude：" + qt.hf());
        }
        com.bytedance.msdk.xj.kd.w.hf("appList：" + p());
        com.bytedance.msdk.xj.kd.w.hf("isCanUsePhoneState：" + f());
        com.bytedance.msdk.xj.kd.w.hf("isLimitPersonalAds：" + c());
        com.bytedance.msdk.xj.kd.w.hf("getDevImei：" + zg());
        com.bytedance.msdk.xj.kd.w.hf("isCanUseWifiState：" + ra());
        com.bytedance.msdk.xj.kd.w.hf("getMacAddress：" + pz());
        com.bytedance.msdk.xj.kd.w.hf("userPrivacyConfig：" + ht());
        com.bytedance.msdk.xj.kd.w.hf("isCanUseWriteExternal：" + tf());
        com.bytedance.msdk.xj.kd.w.hf("isCanUseAndroidId：" + g());
        com.bytedance.msdk.xj.kd.w.hf("getAndroidId：" + yo());
        List<String> dk = dk();
        com.bytedance.msdk.xj.kd.w.hf("getAppList：".concat(String.valueOf(dk)));
        if (dk != null) {
            Iterator<String> it = dk.iterator();
            while (it.hasNext()) {
                com.bytedance.msdk.xj.kd.w.hf("getAppList item: ".concat(String.valueOf(it.next())));
            }
        }
        List<String> e = e();
        com.bytedance.msdk.xj.kd.w.hf("getDevImeis：".concat(String.valueOf(e)));
        if (e != null) {
            Iterator<String> it2 = e.iterator();
            while (it2.hasNext()) {
                com.bytedance.msdk.xj.kd.w.hf("getDevImeis item: ".concat(String.valueOf(it2.next())));
            }
        }
        com.bytedance.msdk.xj.kd.w.hf("getDevOaid：" + jk());
        com.bytedance.msdk.xj.kd.w.hf("isCanUseOaid：" + v());
        com.bytedance.msdk.xj.kd.w.hf("isCanUseMacAddress：" + pl());
        com.bytedance.msdk.xj.kd.w.hf("isProgrammaticRecommend：" + am());
        com.bytedance.msdk.xj.kd.w.hf("---------  sdk 隐私设置 end ----");
    }

    private void hl() {
        com.bytedance.msdk.xj.kd.w.hf("---------  sdk 聚合信息 start ----");
        com.bytedance.msdk.xj.kd.w.hf("getHttps：" + en());
        com.bytedance.msdk.xj.kd.w.hf("getWxAppId：" + l());
        com.bytedance.msdk.xj.kd.w.hf("getPublisherDid：" + ff());
        com.bytedance.msdk.xj.kd.w.hf("isOpenAdnTest：" + a());
        com.bytedance.msdk.xj.kd.w.hf("getMediationConfigUserInfoForSegment：" + wo());
        com.bytedance.msdk.xj.kd.w.hf("getLocalExtra：" + r());
        com.bytedance.msdk.xj.kd.w.hf("getCustomLocalConfig：" + b());
        com.bytedance.msdk.xj.kd.w.hf("getOpensdkVer：" + ws());
        com.bytedance.msdk.xj.kd.w.hf("isWxInstalled：" + eu());
        com.bytedance.msdk.xj.kd.w.hf("isSupportH265：" + tj());
        com.bytedance.msdk.xj.kd.w.hf("isSupportSplashZoomout：" + n());
        com.bytedance.msdk.xj.kd.w.hf("---------  sdk 聚合信息 end ----");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double tu() {
        Function AYUAbz2;
        PluginValueSet hf;
        PluginValueSet pluginValueSet = this.hf;
        if (pluginValueSet == null || (AYUAbz2 = AaHO0E.AYUAbz(pluginValueSet.objectValue(8312, AaHO0E.ARc23Z()))) == null || (hf = com.bytedance.sdk.openadsdk.zg.w.hf(AYUAbz2)) == null) {
            return -1.0d;
        }
        return hf.doubleValue(8482);
    }

    private void vm() {
        com.bytedance.msdk.xj.kd.w.hf("---------  sdk 初始化信息 start ----");
        com.bytedance.msdk.xj.kd.w.hf("isDebug：" + q());
        com.bytedance.msdk.xj.kd.w.hf("getClassName：" + xj());
        com.bytedance.msdk.xj.kd.w.hf("getAppId：" + hf());
        com.bytedance.msdk.xj.kd.w.hf("getAppName：" + w());
        com.bytedance.msdk.xj.kd.w.hf("getADNName：" + u());
        com.bytedance.msdk.xj.kd.w.hf("getAppKey：" + kd());
        com.bytedance.msdk.xj.kd.w.hf("getInitCallback：" + y());
        com.bytedance.msdk.xj.kd.w.hf("getAgeGroup：" + et());
        com.bytedance.msdk.xj.kd.w.hf("isCustom：" + io());
        com.bytedance.msdk.xj.kd.w.hf("getCustomInitMap：" + x());
        com.bytedance.msdk.xj.kd.w.hf("getCustomGMConfiguration：" + ai());
        com.bytedance.msdk.xj.kd.w.hf("getGromoreVersion：" + z());
        com.bytedance.msdk.xj.kd.w.hf("getMap：" + j());
        com.bytedance.msdk.xj.kd.w.hf("---------  sdk 初始化信息 end ----");
    }

    private boolean wn() {
        PluginValueSet pluginValueSet = this.xj;
        return (pluginValueSet == null || pluginValueSet.isEmpty()) ? false : true;
    }

    private void yy() {
        vm();
        dc();
        hl();
    }

    public boolean a() {
        PluginValueSet pluginValueSet = this.w;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8461);
        }
        return false;
    }

    public Function<SparseArray<Object>, Object> ai() {
        if (wn()) {
            return AaHO0E.AYUAbz(this.xj.objectValue(8401, AaHO0E.ARc23Z()));
        }
        return null;
    }

    public boolean am() {
        PluginValueSet hf;
        Function<SparseArray<Object>, Object> function = this.kd;
        if (function == null || (hf = com.bytedance.sdk.openadsdk.zg.w.hf(function)) == null) {
            return true;
        }
        return hf.booleanValue(8028);
    }

    public JSONObject b() {
        PluginValueSet pluginValueSet = this.w;
        if (pluginValueSet != null) {
            return (JSONObject) pluginValueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public boolean c() {
        PluginValueSet hf;
        Function<SparseArray<Object>, Object> function = this.kd;
        if (function == null || (hf = com.bytedance.sdk.openadsdk.zg.w.hf(function)) == null) {
            return false;
        }
        return hf.booleanValue(8027);
    }

    public boolean d() {
        PluginValueSet pluginValueSet = this.hf;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8024);
        }
        return true;
    }

    public List<String> dk() {
        PluginValueSet hf;
        Function<SparseArray<Object>, Object> function = this.kd;
        return (function == null || (hf = com.bytedance.sdk.openadsdk.zg.w.hf(function)) == null) ? new LinkedList() : (List) hf.objectValue(8476, List.class);
    }

    public List<String> e() {
        PluginValueSet hf;
        Function<SparseArray<Object>, Object> function = this.kd;
        return (function == null || (hf = com.bytedance.sdk.openadsdk.zg.w.hf(function)) == null) ? new LinkedList() : (List) hf.objectValue(8477, List.class);
    }

    public boolean en() {
        PluginValueSet pluginValueSet = this.w;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8458);
        }
        return false;
    }

    public int et() {
        return this.u.g();
    }

    public boolean eu() {
        PluginValueSet pluginValueSet = this.w;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8465);
        }
        return false;
    }

    public boolean f() {
        PluginValueSet pluginValueSet = this.hf;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8023);
        }
        return true;
    }

    public String ff() {
        PluginValueSet pluginValueSet = this.w;
        return pluginValueSet != null ? pluginValueSet.stringValue(8460) : "";
    }

    public boolean g() {
        PluginValueSet pluginValueSet = this.hf;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8479);
        }
        return true;
    }

    public void hf(SparseArray<Object> sparseArray) {
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        this.hf = ADYaiT2;
        this.kd = AaHO0E.AYUAbz(ADYaiT2.objectValue(8311, AaHO0E.ARc23Z()));
        dc();
    }

    public Map<String, Object> ht() {
        PluginValueSet pluginValueSet = this.hf;
        if (pluginValueSet != null) {
            return (Map) pluginValueSet.objectValue(8554, Map.class);
        }
        return null;
    }

    public boolean io() {
        if (wn()) {
            return this.xj.booleanValue(8098);
        }
        return false;
    }

    public Map j() {
        PluginValueSet pluginValueSet = this.xj;
        return pluginValueSet != null ? (Map) pluginValueSet.objectValue(8425, Map.class) : new HashMap();
    }

    public String jk() {
        PluginValueSet pluginValueSet = this.hf;
        return pluginValueSet != null ? pluginValueSet.stringValue(8486) : "";
    }

    public String kd() {
        return wn() ? this.xj.stringValue(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold) : "";
    }

    public String l() {
        PluginValueSet pluginValueSet = this.w;
        return pluginValueSet != null ? pluginValueSet.stringValue(8459) : "";
    }

    public boolean n() {
        PluginValueSet pluginValueSet = this.w;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8467);
        }
        return false;
    }

    public boolean p() {
        PluginValueSet pluginValueSet = this.hf;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8026);
        }
        return true;
    }

    public boolean pl() {
        return ra();
    }

    public String pz() {
        PluginValueSet pluginValueSet = this.hf;
        return pluginValueSet != null ? pluginValueSet.stringValue(8487) : "";
    }

    public boolean q() {
        PluginValueSet pluginValueSet = this.xj;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(1);
        }
        return false;
    }

    public u qt() {
        if (aq() == -1.0d || aq() == -1.0d) {
            return null;
        }
        return new u() { // from class: com.bytedance.msdk.xj.w.w.1
            @Override // com.bytedance.msdk.xj.w.u
            public double hf() {
                return w.this.tu();
            }

            @Override // com.bytedance.msdk.xj.w.u
            public double xj() {
                return w.this.aq();
            }
        };
    }

    public Map r() {
        PluginValueSet pluginValueSet = this.w;
        return pluginValueSet != null ? (Map) pluginValueSet.objectValue(8462, Map.class) : new HashMap();
    }

    public boolean ra() {
        PluginValueSet pluginValueSet = this.hf;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8480);
        }
        return true;
    }

    public boolean tf() {
        PluginValueSet pluginValueSet = this.hf;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean tj() {
        PluginValueSet pluginValueSet = this.w;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8466);
        }
        return false;
    }

    public String u() {
        return wn() ? this.xj.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec) : "";
    }

    public boolean v() {
        PluginValueSet hf;
        Function<SparseArray<Object>, Object> function = this.kd;
        if (function == null || (hf = com.bytedance.sdk.openadsdk.zg.w.hf(function)) == null) {
            return true;
        }
        return hf.booleanValue(8478);
    }

    public String w() {
        return wn() ? this.xj.stringValue(8) : "";
    }

    public Function<SparseArray<Object>, Object> wo() {
        PluginValueSet pluginValueSet = this.w;
        if (pluginValueSet != null) {
            return AaHO0E.AYUAbz(pluginValueSet.objectValue(8310, AaHO0E.ARc23Z()));
        }
        return null;
    }

    public String ws() {
        PluginValueSet pluginValueSet = this.w;
        return pluginValueSet != null ? pluginValueSet.stringValue(8464) : "";
    }

    public Map x() {
        if (wn()) {
            return (Map) this.xj.objectValue(8400, Map.class);
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> y() {
        if (wn()) {
            return AaHO0E.AYUAbz(this.xj.objectValue(8300, AaHO0E.ARc23Z()));
        }
        return null;
    }

    public String yo() {
        PluginValueSet pluginValueSet = this.hf;
        return pluginValueSet != null ? pluginValueSet.stringValue(8485) : "";
    }

    public String z() {
        PluginValueSet pluginValueSet = this.xj;
        return pluginValueSet != null ? pluginValueSet.stringValue(8411) : "";
    }

    public String zg() {
        PluginValueSet pluginValueSet = this.hf;
        return pluginValueSet != null ? pluginValueSet.stringValue(8484) : "";
    }

    public static w xj(SparseArray<Object> sparseArray) {
        return new w(sparseArray);
    }

    public String xj() {
        return wn() ? this.xj.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public String hf() {
        if (wn()) {
            return this.xj.stringValue(3);
        }
        return null;
    }
}
