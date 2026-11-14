package com.bytedance.msdk.c.xj;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.msdk.f.ai;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.msdk.xj.xj.u;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static volatile hf xj;
    private Map<String, com.bytedance.msdk.core.tf.xj> w = new ConcurrentHashMap();
    private ai hf = com.bytedance.msdk.c.xj.u();

    private hf() {
    }

    private Set<String> c() {
        HashSet hashSet = new HashSet();
        if (this.w.size() != 0) {
            for (Map.Entry<String, com.bytedance.msdk.core.tf.xj> entry : this.w.entrySet()) {
                com.bytedance.msdk.core.tf.xj value = entry.getValue();
                if (value != null && !value.kd()) {
                    hashSet.add(entry.getKey());
                }
            }
        }
        return hashSet;
    }

    private void hf(JSONObject jSONObject) {
        this.w.clear();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            com.bytedance.msdk.core.tf.xj xj2 = com.bytedance.msdk.core.tf.xj.xj(next, optJSONObject);
            if (optJSONObject != null && xj2 != null) {
                this.w.put(next, xj2);
            }
        }
    }

    private void w(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        y.u(new Runnable() { // from class: com.bytedance.msdk.c.xj.hf.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.c.hf.hf.xj().xj(jSONObject);
            }
        });
    }

    public static hf xj() {
        if (xj == null) {
            synchronized (hf.class) {
                try {
                    if (xj == null) {
                        xj = new hf();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    private void y() {
        String hf = this.hf.hf("adn_init_config");
        if (TextUtils.isEmpty(hf)) {
            return;
        }
        if (!hf.startsWith("[") && !hf.startsWith("{")) {
            hf = com.bytedance.msdk.f.xj.hf(hf, com.bytedance.msdk.f.hf.xj());
        }
        if (TextUtils.isEmpty(hf)) {
            return;
        }
        try {
            hf(new JSONObject(hf));
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public synchronized void kd() {
        List<String> xj2;
        try {
            Context context = com.bytedance.msdk.core.hf.getContext();
            if (context == null) {
                return;
            }
            Set<String> c = c();
            if (c.size() == 0) {
                return;
            }
            int i = context.getApplicationInfo().targetSdkVersion;
            com.bytedance.msdk.xj.kd.w.hf("TTMediationSDK_SDK_Init", "------------------ 聚合 接入信息 start ---------------------");
            com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_SDK_Init", "当前接入的聚合 SDK版本是：" + com.bytedance.msdk.hf.hf.hf());
            if ((Build.VERSION.SDK_INT >= 24 || i >= 24) && (xj2 = xj(context)) != null) {
                for (String str : c) {
                    if (!MediationConstant.ADN_UNITY.equals(str) && !MediationConstant.ADN_XIAOMI.equals(str)) {
                        if (xj2.contains(str)) {
                            com.bytedance.msdk.xj.kd.w.hf("TTMediationSDK_SDK_Init", "已按要求接入三方广告sdk【" + str + "】");
                        } else {
                            com.bytedance.msdk.xj.kd.w.u("TTMediationSDK_SDK_Init", "未按要求接入三方广告sdk【" + str + "】，请检查接入配置");
                        }
                    }
                }
            }
            com.bytedance.msdk.xj.kd.w.hf("TTMediationSDK_SDK_Init", "------------------ GroMore 接入信息 end ---------------------");
            com.bytedance.msdk.xj.kd.w.hf("TTMediationSDK_SDK_Init", "------------------ GroMore 版本信息 start ---------------------");
            for (String str2 : c) {
                if (!TextUtils.equals(str2, MediationConstant.ADN_PANGLE)) {
                    u xj3 = com.bytedance.msdk.y.hf.hf.xj().xj(str2);
                    if (xj3 != null) {
                        xj3.u();
                    } else {
                        com.bytedance.msdk.xj.kd.w.u("TTMediationSDK_InitChecker", "没有引入" + str2 + "Adapter,请检查相关引入情况");
                    }
                }
            }
            com.bytedance.msdk.xj.kd.w.hf("TTMediationSDK_SDK_Init", "------------------ GroMore 版本信息 end ---------------------");
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean u() {
        if (this.w.size() == 0) {
            y();
        }
        return this.w.isEmpty();
    }

    public Map<String, com.bytedance.msdk.core.tf.xj> w() {
        if (this.w.size() == 0) {
            y();
        }
        return new ConcurrentHashMap(this.w);
    }

    public void xj(JSONObject jSONObject) {
        if (jSONObject != null) {
            hf(jSONObject);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                this.hf.xj("adn_init_config", jSONObject2);
            }
        }
        w(jSONObject);
    }

    public List<com.bytedance.msdk.core.tf.xj> hf() {
        if (this.w.size() == 0) {
            y();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, com.bytedance.msdk.core.tf.xj>> it = this.w.entrySet().iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.core.tf.xj value = it.next().getValue();
            if (value != null && value.kd()) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public com.bytedance.msdk.core.tf.xj xj(String str) {
        if (this.w.size() == 0) {
            y();
        }
        return this.w.get(str);
    }

    private List<String> xj(Context context) {
        List<ProviderInfo> queryContentProviders = context.getPackageManager().queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        if (queryContentProviders == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        context.getPackageName();
        Iterator<ProviderInfo> it = queryContentProviders.iterator();
        while (it.hasNext()) {
            String str = it.next().name;
            str.getClass();
            switch (str) {
                case "com.baidu.mobads.sdk.api.BdFileProvider":
                    arrayList.add("baidu");
                    break;
                case "com.mbridge.msdk.foundation.tools.MBFileProvider":
                    arrayList.add(MediationConstant.ADN_MINTEGRAL);
                    break;
                case "com.sigmob.sdk.SigmobFileProvider":
                case "com.sigmob.sdk.SigmobFileV4Provider":
                    arrayList.add("sigmob");
                    break;
                case "com.tencent.klevin.utils.FileProvider":
                    arrayList.add(MediationConstant.ADN_KLEVIN);
                    break;
                case "com.google.android.gms.ads.MobileAdsInitProvider":
                    arrayList.add(MediationConstant.ADN_ADMOB);
                    break;
                case "com.bykv.vk.openvk.TTFileProvider":
                case "com.bytedance.sdk.openadsdk.TTFileProvider":
                    arrayList.add(MediationConstant.ADN_PANGLE);
                    break;
                case "com.kwad.sdk.api.proxy.app.AdSdkFileProvider":
                    arrayList.add("ks");
                    break;
                case "com.unity":
                    arrayList.add(MediationConstant.ADN_UNITY);
                    break;
                case "com.qq.e.comm.GDTFileProvider":
                    arrayList.add("gdt");
                    break;
            }
        }
        return arrayList;
    }

    public boolean hf(String str) {
        com.bytedance.msdk.core.tf.xj xjVar;
        if (this.w.size() == 0) {
            y();
        }
        Map<String, com.bytedance.msdk.core.tf.xj> map = this.w;
        return (map == null || (xjVar = map.get(str)) == null || !xjVar.kd()) ? false : true;
    }
}
