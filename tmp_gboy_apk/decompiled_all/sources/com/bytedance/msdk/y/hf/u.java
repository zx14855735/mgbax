package com.bytedance.msdk.y.hf;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.am;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends com.bytedance.sdk.openadsdk.core.wo.u implements com.bytedance.msdk.xj.xj.u {
    private Function<SparseArray<Object>, Object> hf;
    private Function<SparseArray<Object>, Object> kd;
    private String w;
    private w xj;
    private com.bytedance.msdk.api.u.w y;
    private List<com.bytedance.msdk.xj.xj.w> u = new CopyOnWriteArrayList();
    private long c = 0;
    private int f = 0;

    public u() {
        w xj = w.xj(com.bytedance.msdk.core.xj.p().a());
        this.xj = xj;
        this.hf = xj.xj();
    }

    private int d() {
        com.bytedance.msdk.xj.w.w hf = com.bytedance.msdk.core.xj.p().hf();
        if (hf != null) {
            return hf.et();
        }
        return 0;
    }

    public static String hf(String str) {
        str.getClass();
        switch (str) {
            case "sigmob":
                return "a.b.c.d.e.f.sob.SobFunction";
            case "xiaomi":
                return "a.b.c.d.e.f.xmi.XmiFunction";
            case "ks":
                return "a.b.c.d.e.f.kou.KouFunction";
            case "gdt":
                return "a.b.c.d.e.f.gng.GngFunction";
            case "admob":
                return "a.b.c.d.e.f.aob.AobFunction";
            case "baidu":
                return "a.b.c.d.e.f.bdu.BduFunction";
            case "unity":
                return "a.b.c.d.e.f.uty.UtyFunction";
            case "mintegral":
                return "a.b.c.d.e.f.mal.MalFunction";
            default:
                return null;
        }
    }

    private void p() {
        String w = com.bytedance.sdk.gromore.init.xj.w();
        if (TextUtils.isEmpty(xj())) {
            com.bytedance.msdk.xj.kd.w.u("TTMediationSDK_SDK_Init", f() + "版本号：" + hf() + " , ***" + f() + "Adapter未接入，请检查***, 聚合版本号：" + w);
            return;
        }
        com.bytedance.msdk.xj.kd.w.hf("TTMediationSDK_SDK_Init", f() + "版本号：" + hf() + " , " + f() + "Adapter版本号：" + xj() + " , 聚合版本号：" + w);
    }

    private void pl() {
        Iterator<com.bytedance.msdk.xj.xj.w> it = this.u.iterator();
        while (it.hasNext()) {
            it.next().xj();
        }
        this.u.clear();
    }

    private void tf() {
        com.bytedance.msdk.xj.kd.w.hf("TTMediationSDK_SDK_Init", f() + "版本号：" + hf() + " , 聚合版本号：" + com.bytedance.sdk.gromore.init.xj.w());
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8122) {
            this.kd = AaHO0E.AYUAbz(pluginValueSet.objectValue(AVMDLDataLoader.KeyIsLiveContainerString, AaHO0E.ARc23Z()));
            pl();
            return null;
        }
        if (i == 8123) {
            SparseArray sparseArray = (SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class);
            if (sparseArray == null) {
                sparseArray = (SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class);
            }
            if (sparseArray == null) {
                sparseArray = (SparseArray) pluginValueSet.objectValue(8022, SparseArray.class);
            }
            if (sparseArray != null) {
                ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
                xj(new com.bytedance.msdk.api.xj(ADYaiT2.intValue(-999900, 0), ADYaiT2.stringValue(-999901, null)));
                return null;
            }
        } else if (i == 8212) {
            if (this.y != null) {
                this.y.xj(pluginValueSet.intValue(8095));
                return null;
            }
        } else {
            if (i == 8266) {
                this.kd = AaHO0E.AYUAbz(pluginValueSet.objectValue(AVMDLDataLoader.KeyIsLiveContainerString, AaHO0E.ARc23Z()));
                return null;
            }
            if (i == 8270) {
                this.f = pluginValueSet.intValue(8557);
                this.c = pluginValueSet.longValue(8556) - pluginValueSet.longValue(8555);
            }
        }
        return null;
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public void c() {
        this.f = 0;
        this.c = 0L;
    }

    public String f() {
        return this.w;
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public long kd() {
        return this.c;
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public void u() {
        try {
            if (com.bytedance.msdk.core.xj.xj.kd.w(f()) != null) {
                tf();
            } else {
                p();
            }
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public String w() {
        return null;
    }

    @Override // com.bytedance.msdk.xj.xj.hf
    public void xj(Context context, Map<String, Object> map, com.bytedance.msdk.xj.xj.w wVar) {
        if (!this.u.contains(wVar)) {
            this.u.add(wVar);
        }
        com.bytedance.sdk.openadsdk.zg.u xj = com.bytedance.sdk.openadsdk.zg.u.xj();
        kd.xj(xj);
        xj.xj(3, map.get(PluginConstants.KEY_APP_ID));
        xj.xj(8550, Boolean.valueOf(com.bytedance.msdk.core.xj.p().jk()));
        xj.xj(8, com.bytedance.msdk.core.xj.p().yo());
        xj.xj(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold, map.get("app_key"));
        String str = (String) map.get(MediationConstant.EXTRA_ADN_NAME);
        this.w = str;
        xj.xj(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, xj(str));
        xj.xj(8560, hf(this.w));
        xj.xj(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec, map.get(MediationConstant.EXTRA_ADN_NAME));
        xj.xj(8410, "4.6.30.1.0");
        xj.xj(8411, com.bytedance.msdk.hf.hf.w());
        xj.xj(8412, "17.2.0.71");
        xj.xj(8413, "9.3941.0");
        xj.xj(8414, "4.642.1512.0");
        xj.xj(8415, "2.11.0.3.32");
        xj.xj(8417, "4.24.0.0");
        xj.xj(8418, "4.3.0.38");
        xj.xj(8416, "16.6.57.14");
        xj.xj(8558, "2.11.0.3.32");
        xj.xj(7, Integer.valueOf(d()));
        xj.xj(8425, map);
        xj.xj(8300, this);
        try {
            Function<SparseArray<Object>, Object> w = com.bytedance.msdk.core.xj.xj.kd.w(this.w);
            if (w != null) {
                this.kd = w;
                w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8240).xj(Void.class).xj(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).xj(8424, xj.hf()).hf());
            } else {
                xj.xj(AVMDLDataLoader.KeyIsLiveLoaderEnable).xj(Void.class);
                this.hf.apply(xj.hf());
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public int y() {
        return this.f;
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public Map<String, Object> hf(Context context, Map<String, Object> map) {
        Object apply;
        if (this.kd == null) {
            return null;
        }
        apply = this.kd.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(AVMDLDataLoader.KeyIsLiveGetLoaderType).xj(String.class).xj(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).xj(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).hf());
        if (apply instanceof Map) {
            return (Map) apply;
        }
        return null;
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public String hf() {
        Object apply;
        try {
            Function<SparseArray<Object>, Object> function = this.kd;
            if (function != null) {
                apply = function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8104).xj(String.class).hf());
                return apply instanceof String ? (String) apply : "";
            }
            return "";
        } catch (Throwable th) {
            pl.xj(th);
            return "";
        }
    }

    public static String xj(String str) {
        str.getClass();
        switch (str) {
            case "klevin":
                return MediationConstant.KLEVIN_ADN_CLASS_NAME;
            case "sigmob":
                return MediationConstant.SIGMOB_ADN_CLASS_NAME;
            case "xiaomi":
                return MediationConstant.XIAOMI_ADN_CLASS_NAME;
            case "ks":
                return MediationConstant.KS_ADN_CLASS_NAME;
            case "gdt":
                return MediationConstant.GDT_ADN_CLASS_NAME;
            case "admob":
                return MediationConstant.ADMOB_ADN_CLASS_NAME;
            case "baidu":
                return MediationConstant.BAIDU_ADN_CLASS_NAME;
            case "unity":
                return MediationConstant.UNITY_ADN_CLASS_NAME;
            case "mintegral":
                return MediationConstant.MINTEGRAL_ADN_CLASS_NAME;
            default:
                return null;
        }
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public String xj() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.kd;
        if (function == null) {
            return "";
        }
        apply = function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable).xj(String.class).hf());
        return apply instanceof String ? (String) apply : "";
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public String xj(Context context, Map<String, Object> map) {
        Object apply;
        if (this.kd == null) {
            return null;
        }
        apply = this.kd.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8102).xj(String.class).xj(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).xj(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).hf());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public void xj(Map<String, Object> map) {
        Function<SparseArray<Object>, Object> function = this.kd;
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8242).xj(Void.class).xj(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).hf());
        }
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public int xj(com.bytedance.msdk.api.u.w wVar) {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.kd;
        if (function == null) {
            return 0;
        }
        this.y = wVar;
        apply = function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8126).xj(Integer.class).hf());
        if (apply != null) {
            return ((Integer) apply).intValue();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public void xj(am amVar, SparseArray<Object> sparseArray) {
        Function<SparseArray<Object>, Object> function = this.kd;
        if (function == null || amVar == null) {
            return;
        }
        function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8124).xj(Void.class).xj(8517, sparseArray).hf());
    }

    private void xj(com.bytedance.msdk.api.xj xjVar) {
        Iterator<com.bytedance.msdk.xj.xj.w> it = this.u.iterator();
        while (it.hasNext()) {
            it.next().xj(xjVar);
        }
        this.u.clear();
    }
}
