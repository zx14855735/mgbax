package com.bytedance.sdk.openadsdk.core;

import ADYaiT.BpkvW3;
import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.mobads.sdk.internal.bn;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.live.EcBackUpWebView;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.model.AdnName;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class q implements Function<SparseArray<Object>, Object> {
    private final PluginValueSet xj;

    public q() {
        AYUAbz A4TApA2 = AYUAbz.A4TApA();
        Object xj = com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.core.q.1
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(f.zg().wn());
            }
        });
        SparseArray sparseArray = A4TApA2.f4119A2egSU;
        sparseArray.put(11, xj);
        sparseArray.put(12, "7.1.3.2");
        this.xj = A4TApA2.A2egSU();
    }

    public void hf(Object obj) {
        if ((ai.c() || wo.d().equals("com.pangolin_demo.toutiao")) && obj != null) {
            com.bytedance.sdk.openadsdk.core.wo.xj.w.w(obj);
        }
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        String str;
        String str2;
        String str3 = null;
        if (sparseArray != null) {
            ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
            int intValue = ADYaiT2.intValue(-99999987, 0);
            if (intValue != -99999986) {
                if (intValue == -999800) {
                    return new z((Context) ADYaiT2.objectValue(-998000, Context.class));
                }
                if (intValue == 16) {
                    f.zg().xj(ADYaiT2.booleanValue(17, false), (SparseArray<Object>) ADYaiT2.objectValue(21, SparseArray.class));
                    return null;
                }
                if (intValue == 19) {
                    Bundle bundle = (Bundle) ADYaiT2.objectValue(20, Bundle.class);
                    if (bundle == null) {
                        return new Bundle();
                    }
                    int i = bundle.getInt("event_id", -1);
                    int i2 = bundle.getInt("event_type", -1);
                    String string = bundle.getString(n.p);
                    try {
                        JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.xj.w(bundle.getString("event_token")));
                        str = jSONObject.optString("tag");
                        try {
                            str2 = jSONObject.optString("value");
                            try {
                                str3 = jSONObject.optString("log_extra");
                            } catch (JSONException unused) {
                            }
                        } catch (JSONException unused2) {
                            str2 = null;
                        }
                    } catch (JSONException unused3) {
                        str = null;
                        str2 = null;
                    }
                    return com.bytedance.sdk.openadsdk.core.pl.u.qt.xj(i, i2, string, str, str2, str3);
                }
                if (intValue == 999801) {
                    return this;
                }
                switch (intValue) {
                    case 1:
                        xj(ADYaiT2.intValue(11, 0));
                        return null;
                    case 2:
                        return xj(AYUAbz.A5SV6n(ADYaiT2).A2egSU(), ADYaiT2.booleanValue(13, false), ADYaiT2.intValue(14, 0));
                    case 3:
                        hf((Context) ADYaiT2.objectValue(7, Context.class));
                        return null;
                    case 4:
                        xj(ADYaiT2.objectValue(8, Object.class));
                        return null;
                    case 5:
                        hf(ADYaiT2.objectValue(8, AaHO0E.ARc23Z()));
                        return null;
                    case 6:
                        return xj((Class) ADYaiT2.objectValue(9, Class.class), (Bundle) ADYaiT2.objectValue(10, Bundle.class));
                }
            }
            PluginValueSet pluginValueSet = this.xj;
            if (pluginValueSet != null) {
                return pluginValueSet.sparseArray();
            }
        }
        return null;
    }

    public void hf(Context context) {
        if (context == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.zg.w.w.u v = f.zg().v();
        if (v != null) {
            boolean xj = v.xj();
            boolean w = v.w();
            boolean kd = v.kd();
            if (!xj && !w && !kd) {
                return;
            }
        }
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra(PointParamKey.TYPE, 2);
        com.bytedance.sdk.component.utils.hf.xj(context, intent, null);
    }

    public void hf() {
        com.bytedance.sdk.openadsdk.core.a.j.xj("open_ad_sdk_meta_cache_kv").clear();
        com.bytedance.sdk.openadsdk.core.a.j.xj("tt_materialMeta").clear();
        com.bytedance.sdk.openadsdk.core.a.j.xj("tt_splash").clear();
    }

    public void xj(Object obj) {
        if (obj instanceof Bundle) {
            Bundle bundle = (Bundle) obj;
            if (bundle.containsKey(PluginConstants.KEY_PL_CONFIG_INFO)) {
                f.zg().xj(bundle.getBundle(PluginConstants.KEY_PL_CONFIG_INFO));
                if (f.zg().en().length() == 0 || com.bytedance.sdk.openadsdk.core.a.zg.hf()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.ai.xj.xj.xj().hf();
                return;
            }
            return;
        }
        if (BpkvW3.BmvVmW(obj) && !com.bytedance.sdk.openadsdk.core.wo.xj.w.hf(obj)) {
            xj(AaHO0E.AYUAbz(obj));
            return;
        }
        if (obj instanceof PluginValueSet) {
            PluginValueSet pluginValueSet = (PluginValueSet) obj;
            try {
                if (pluginValueSet.intValue(0) == 1) {
                    xj((ClassLoader) pluginValueSet.objectValue(2, ClassLoader.class), pluginValueSet.stringValue(1));
                }
            } catch (Throwable unused) {
            }
        }
        if ((ai.c() || wo.d().equals("com.pangolin_demo.toutiao")) && obj != null) {
            com.bytedance.sdk.openadsdk.core.wo.xj.w.xj(obj);
        }
        if (obj instanceof TTAdInteractionListener) {
            f.zg().r().apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(162).xj(0, new com.bytedance.sdk.openadsdk.core.a.en().xj("listener", obj)).xj(Void.class).hf());
        }
    }

    private void xj(ClassLoader classLoader, String str) {
        ZipFile zipFile;
        getClass().getClassLoader();
        if (classLoader == null || TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(ai.xj(str, com.bytedance.sdk.openadsdk.x.p.w(str)), "apk/base-1.apk");
        String str2 = null;
        if (file.exists() && file.canRead()) {
            try {
                zipFile = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    while (true) {
                        if (!entries.hasMoreElements()) {
                            break;
                        }
                        ZipEntry nextElement = entries.nextElement();
                        if (nextElement.getName().startsWith("ats")) {
                            str2 = nextElement.getName().substring(3);
                            break;
                        }
                    }
                    if (str2 != null) {
                        Constructor<?> declaredConstructor = classLoader.loadClass(str2).getDeclaredConstructor(new Class[0]);
                        declaredConstructor.setAccessible(true);
                        new com.bytedance.sdk.openadsdk.ats.w().apply(declaredConstructor.newInstance(new Object[0]));
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("class", str2);
                        jSONObject.put("pkg", str);
                        com.bytedance.sdk.openadsdk.core.ht.am.xj().xj("ats_reg", jSONObject, th);
                    } finally {
                        com.bytedance.sdk.component.y.w.w.hf.xj(zipFile);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                zipFile = null;
            }
        } else {
            com.bytedance.sdk.openadsdk.core.ht.am.xj().xj("ats_reg", (JSONObject) null, (Throwable) null);
        }
    }

    public z xj(Context context) {
        return new z(context);
    }

    public SparseArray<Object> xj() {
        return this.xj.sparseArray();
    }

    private void xj(Function<SparseArray<Object>, Object> function) {
        if (function != null && new AYUAbz(com.bytedance.sdk.openadsdk.zg.w.xj(function)).A2egSU().intValue(10000, 0) == 1 && ai.c()) {
            com.bytedance.sdk.openadsdk.core.live.hf.xj().xj(function);
        }
    }

    /* JADX WARN: Type inference failed for: r8v13, types: [T, java.util.HashMap] */
    public <T> T xj(Class<T> cls, Bundle bundle) {
        boolean z = false;
        int i = bundle != null ? bundle.getInt(PointParamKey.TYPE) : 0;
        if (com.bytedance.sdk.openadsdk.core.wo.xj.u.xj(cls, bundle)) {
            return (T) com.bytedance.sdk.openadsdk.core.wo.xj.u.xj(com.bytedance.sdk.openadsdk.core.multipro.y.xj(pz.getContext()), cls, bundle);
        }
        if (cls != SparseArray.class && (cls == null || !"com.bytedance.sdk.openadsdk.AdConfig".equals(cls.getName()))) {
            if (!com.bytedance.sdk.openadsdk.zg.w.u.hf(ai.w) && i == 1 && cls == ITTDownloadVisitor.class) {
                return (T) com.bytedance.sdk.openadsdk.core.pl.xj.tf.create();
            }
            if (cls == Bundle.class) {
                if (bundle != null) {
                    int i2 = bundle.getInt("action", 0);
                    if (i2 == 0) {
                        f.zg().xj(bundle.getString("plugin_pkg_name"), bundle.getString(PluginConstants.KEY_PLUGIN_VERSION));
                        return null;
                    }
                    if (i2 == 1) {
                        com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(bundle.getString("event_name"), bundle.getString("event_extra"));
                        return null;
                    }
                    if (i2 == 2) {
                        hf();
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(MediationConstant.RIT_TYPE_SPLASH, 0);
                            jSONObject.put("reward", 0);
                            jSONObject.put(bn.j, 0);
                            jSONObject.put(AdnName.OTHER, 0);
                            com.bykv.vk.openvk.component.video.xj.xj.xj(jSONObject);
                            com.bytedance.sdk.openadsdk.x.d.xj(0).kd();
                            com.bykv.vk.openvk.component.video.xj.xj.xj(pz.hf().ic());
                            return null;
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.pl.w(th.getMessage());
                        }
                    } else if (i2 == 3) {
                        com.bytedance.sdk.component.tf.c.xj(-1);
                        return null;
                    }
                }
            } else if (cls == ExecutorService.class) {
                if (bundle != null) {
                    int i3 = bundle.getInt("action", 0);
                    if (i3 == 1) {
                        return (T) com.bytedance.sdk.component.tf.p.hf.tf();
                    }
                    if (i3 == 2) {
                        return (T) com.bytedance.sdk.component.tf.p.hf.d();
                    }
                    if (i3 != 3) {
                        return (T) com.bytedance.sdk.component.tf.p.hf.g();
                    }
                    return (T) com.bytedance.sdk.component.tf.p.hf.pl();
                }
            } else if (cls == Handler.class) {
                if (bundle != null && bundle.getInt("action", 0) == 1) {
                    return (T) com.bytedance.sdk.component.utils.f.xj();
                }
            } else {
                if (cls == View.class) {
                    return (T) new EcBackUpWebView(pz.getContext());
                }
                if (cls == Map.class) {
                    ?? r8 = (T) new HashMap();
                    if (bundle != null && bundle.getString("extra_name").equals("use_mediation_map")) {
                        if (AdSdkInitializerHolder.isSdkInitSuccess() && pz.hf().zm() && AdSdkInitializerHolder.hasDispatchAdSdkInitializer()) {
                            z = true;
                        }
                        r8.put("use_mediation_map", Boolean.valueOf(z));
                    }
                    return r8;
                }
                if (cls == AaHO0E.ARc23Z() && bundle != null && bundle.getInt("action", 0) == 4) {
                    return (T) com.bytedance.sdk.openadsdk.tools.w.xj();
                }
            }
        } else if (bundle != null && !bundle.keySet().isEmpty()) {
            if (bundle.containsKey("is_paid")) {
                f.zg().kd(bundle.getBoolean("is_paid"));
            }
            if (bundle.containsKey("extra_data")) {
                f.zg().c(bundle.getString("extra_data"));
            }
            if (bundle.containsKey("keywords")) {
                f.zg().f(bundle.getString("keywords"));
            }
            if (bundle.containsKey("quit_work")) {
                f.zg().xj(bundle.getBoolean("quit_work", false), (SparseArray<Object>) null);
            }
        }
        return null;
    }

    public String xj(PluginValueSet pluginValueSet, boolean z, int i) {
        if (pluginValueSet == null || pz.xj() == null) {
            return null;
        }
        return pz.xj().xj(new com.bytedance.sdk.openadsdk.zg.w.w.hf(pluginValueSet.sparseArray()), z, i);
    }

    public void xj(int i) {
        if (i != f.zg().wn()) {
            f.zg().kd(i);
            Intent intent = new Intent();
            intent.setAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
            intent.putExtra("theme_status_change", i);
            pz.getContext().sendBroadcast(intent, wo.io());
        }
    }
}
