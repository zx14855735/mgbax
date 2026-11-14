package com.bytedance.sdk.openadsdk.core;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.core.content.FileProvider;
import com.baidu.mobads.sdk.api.AdSettings;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.dutexplorer.tmapcloak;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.pangle.wrapper.A5SV6n;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.kwad.sdk.api.KsAdSDK;
import com.qq.e.comm.managers.status.SDKStatus;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class w implements Function<SparseArray<Object>, Object> {
    private static Boolean hf;
    private static int xj;
    private static AtomicBoolean y;
    private com.bytedance.sdk.openadsdk.ats.y c;
    private final q w = new q();
    private volatile boolean u = false;
    private AtomicBoolean kd = new AtomicBoolean(false);

    public w(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER)) {
            return;
        }
        Serializable serializable = bundle.getSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER);
        if (A5SV6n.BNL6CD(serializable)) {
            com.bytedance.sdk.openadsdk.core.ai.xj.hf.xj().xj(A5SV6n.AzWtSf(serializable));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c() {
        if (hf == null) {
            try {
                hf = Boolean.TRUE;
            } catch (Throwable unused) {
                hf = Boolean.FALSE;
            }
        }
        return hf.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f() {
        try {
            Class.forName("com.unity3d.player.UnityPlayer");
            try {
                Class.forName("com.bytedance.android.NativeAdManager");
                return MediationConstant.ADN_UNITY;
            } catch (Throwable unused) {
                return "unity_pure";
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int y() {
        if (xj == 0) {
            try {
                try {
                    int i = FileProvider.f8572AcNBzu;
                    xj = 1;
                } catch (Throwable unused) {
                    xj = -1;
                }
            } catch (Throwable unused2) {
                int i2 = FileProvider.f8572AcNBzu;
                xj = 2;
            }
        }
        return xj;
    }

    public Map<String, Object> w() {
        com.bytedance.sdk.openadsdk.ats.y yVar = this.c;
        if (yVar == null) {
            return null;
        }
        return yVar.xj();
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        switch (ADYaiT2.intValue(-99999987, 0)) {
            case -999002:
                return Boolean.valueOf(xj());
            case -999001:
                xj((Context) ADYaiT2.objectValue(-998000, Context.class), ADYaiT2, new com.bytedance.sdk.openadsdk.core.wo.w(AaHO0E.AYUAbz(ADYaiT2.objectValue(15, AaHO0E.ARc23Z()))));
                return null;
            case -999000:
                return this.w;
            default:
                return null;
        }
    }

    public q hf() {
        return this.w;
    }

    private void hf(@ForbidWrapParam PluginValueSet pluginValueSet) {
        try {
            Boolean bool = (Boolean) pluginValueSet.objectValue(14, Boolean.class);
            if (bool != null) {
                ai.hf = bool.booleanValue();
            }
        } catch (Exception unused) {
        }
    }

    private void hf(@ForbidWrapParam com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar, @ForbidWrapParam PluginValueSet pluginValueSet) {
        if (xjVar == null) {
            return;
        }
        String hf2 = xjVar.hf();
        if (hf2 == null || hf2.isEmpty()) {
            hf2 = com.bytedance.sdk.openadsdk.core.f.xj.hf(pz.getContext());
        }
        f.zg().xj(AaHO0E.AYUAbz(pluginValueSet.objectValue(16, AaHO0E.ARc23Z())));
        f.zg().u(hf2);
        f.zg().w(xjVar.xj());
        f.zg().w(xjVar.w());
        f.zg().kd(xjVar.u());
        f.zg().y(xjVar.kd());
        f.zg().hf(xjVar.y());
        f.zg().kd(xjVar.am());
        f.zg().u(xjVar.c());
        f.zg().xj(xjVar.d());
        f.zg().y(xjVar.zg());
        f.zg().xj(xjVar.p());
        if (ai.w >= 5500) {
            f.zg().u(xjVar.g());
            f.zg().xj(xjVar.pl());
        } else {
            f.zg().u(pluginValueSet.intValue(7));
            f.zg().xj(pluginValueSet.intValue(8));
        }
        if (xj(xjVar)) {
            com.bytedance.sdk.component.utils.pl.hf();
            com.bytedance.sdk.openadsdk.tools.hf.hf();
            com.ss.android.socialbase.downloader.w.xj.xj(2);
        }
    }

    private static void xj(com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar, boolean z) {
        if (xj(xjVar)) {
            com.bytedance.sdk.openadsdk.tools.hf.w(1, z ? "1" : Constants.FAIL);
            xj(xjVar.p());
            com.bytedance.sdk.openadsdk.tools.hf.hf(2, xjVar.xj());
            try {
                Thread.currentThread().getContextClassLoader().loadClass("com.bytedance.sdk.openadsdk.core.GlobalInfo");
                com.bytedance.sdk.openadsdk.tools.hf.w(2, Constants.FAIL);
            } catch (Exception unused) {
                com.bytedance.sdk.openadsdk.tools.hf.w(2, "1");
            }
            com.bytedance.sdk.openadsdk.tools.hf.hf(0, ai.u);
        }
    }

    private static void xj(com.bytedance.sdk.openadsdk.zg.w.w.u uVar) {
        String str;
        String str2;
        String str3;
        if (uVar == null || uVar.g()) {
            uVar = f.xj;
        }
        com.bytedance.sdk.openadsdk.tools.hf.w(19, uVar.g() ? "1" : Constants.FAIL);
        com.bytedance.sdk.openadsdk.tools.hf.w(7, String.valueOf(uVar.xj() ? 1 : 0));
        com.bytedance.sdk.openadsdk.zg.w.w.w d = uVar.d();
        String str4 = "";
        if (d == null) {
            str = "";
        } else {
            str = d.xj() + "," + d.hf();
        }
        com.bytedance.sdk.openadsdk.tools.hf.w(8, str);
        com.bytedance.sdk.openadsdk.tools.hf.w(9, String.valueOf(uVar.w() ? 1 : 0));
        String tf = uVar.tf();
        if (tf == null) {
            str2 = "";
        } else {
            str2 = tf.trim();
        }
        com.bytedance.sdk.openadsdk.tools.hf.w(10, str2);
        com.bytedance.sdk.openadsdk.tools.hf.w(11, String.valueOf(uVar.u() ? 1 : 0));
        com.bytedance.sdk.openadsdk.tools.hf.w(12, String.valueOf(uVar.kd() ? 1 : 0));
        com.bytedance.sdk.openadsdk.tools.hf.w(17, String.valueOf(uVar.hf() ? 1 : 0));
        if (ai.w >= 4600) {
            com.bytedance.sdk.openadsdk.tools.hf.w(22, String.valueOf(uVar.y() ? 1 : 0));
        }
        if (ai.w >= 7000) {
            com.bytedance.sdk.openadsdk.tools.hf.w(24, String.valueOf(uVar.f() ? 1 : 0));
        }
        String p = uVar.p();
        if (p == null) {
            str3 = "";
        } else {
            str3 = p.trim();
        }
        com.bytedance.sdk.openadsdk.tools.hf.w(18, str3);
        try {
            if (uVar.pl() != null) {
                str4 = uVar.pl().trim();
            }
            com.bytedance.sdk.openadsdk.tools.hf.w(13, str4);
        } catch (Exception unused) {
            com.bytedance.sdk.component.utils.pl.w("Get oaid from controller failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(@ForbidWrapParam final Context context, final long j, final long j2, final long j3, final ra raVar, final boolean z, final com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar, final String str, final int i, @ForbidWrapParam final PluginValueSet pluginValueSet, @ForbidWrapParam final com.bytedance.sdk.openadsdk.core.j.c cVar) {
        v.w();
        if (pz.hf().gh()) {
            com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.w.6
                @Override // com.bytedance.sdk.openadsdk.p.xj.xj
                public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                    boolean jk = f.zg().jk();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MediationConstant.EXTRA_DURATION, j);
                    jSONObject.put("is_async", z);
                    jSONObject.put("is_multi_process", xjVar.tf());
                    jSONObject.put("is_debug", w.xj(xjVar));
                    jSONObject.put("is_activate_init", jk);
                    jSONObject.put("is_plugin", ai.xj());
                    jSONObject.put("has_kotlin", w.c());
                    jSONObject.put("use_mediation", xjVar.zg());
                    jSONObject.put("is_androidx", w.y());
                    jSONObject.put("host_abi", com.bytedance.sdk.openadsdk.core.ai.hf.hf.xj());
                    jSONObject.put("minSdkVersion", wo.u(context));
                    jSONObject.put("targetSdkVersion", wo.w(context));
                    jSONObject.put("ttvideo_plugin_config", true);
                    jSONObject.put("ttvideo_can_use", ai.u());
                    jSONObject.put("is_keva_init_success", com.bytedance.sdk.openadsdk.core.a.j.hf());
                    jSONObject.put("thread_name", str);
                    jSONObject.put("thread_priority", i);
                    jSONObject.put("is_boost", com.bytedance.sdk.openadsdk.core.u.xj.u());
                    jSONObject.put("opt_config", String.valueOf(cVar));
                    f.zg().hf(false);
                    Object objectValue = pluginValueSet.objectValue(9, Object.class);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("main_cost", j);
                    jSONObject2.put("callback_cost", j2);
                    jSONObject2.put("total_cost", j3);
                    if (objectValue != null) {
                        jSONObject2.put("plugin", objectValue);
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    raVar.xj(jSONObject3, 20L);
                    jSONObject2.put("init", jSONObject3);
                    jSONObject.put("cost", jSONObject2);
                    if (!xjVar.zg()) {
                        try {
                            Object invoke = AdSettings.class.getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (invoke instanceof String) {
                                jSONObject.put("baidu_version", invoke);
                            }
                        } catch (Throwable unused) {
                        }
                        try {
                            Object invoke2 = SDKStatus.class.getMethod("getIntegrationSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (invoke2 instanceof String) {
                                jSONObject.put("gdt_version", invoke2);
                            }
                        } catch (Throwable unused2) {
                        }
                        try {
                            AtomicBoolean atomicBoolean = KsAdSDK.sHasInit;
                            Object invoke3 = KsAdSDK.class.getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (invoke3 instanceof String) {
                                jSONObject.put("ks_version", invoke3);
                            }
                        } catch (Throwable unused3) {
                        }
                    }
                    Object f = w.this.f();
                    if (f != null) {
                        jSONObject.put("develop_type", f);
                    }
                    com.bytedance.sdk.openadsdk.core.ht.xj.hf hf2 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("pangle_sdk_init").hf(jSONObject.toString());
                    StringBuilder sb = new StringBuilder();
                    sb.append(j2);
                    return hf2.kd(sb.toString());
                }
            }, "pangle_sdk_init");
        }
    }

    public static boolean xj(com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar) {
        AtomicBoolean atomicBoolean = y;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        boolean z = xjVar.f() && com.bytedance.sdk.openadsdk.core.a.f.xj();
        y = new AtomicBoolean(z);
        return z;
    }

    public boolean xj() {
        return this.u;
    }

    public void xj(final Context context, @ForbidWrapParam final PluginValueSet pluginValueSet, @ForbidWrapParam final com.bytedance.sdk.openadsdk.core.wo.w wVar) {
        long elapsedRealtime;
        String name;
        int priority;
        try {
            final com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar = new com.bytedance.sdk.openadsdk.zg.w.w.xj(pluginValueSet != null ? pluginValueSet.sparseArray() : new SparseArray<>());
            pz.xj(context);
            try {
                elapsedRealtime = pluginValueSet.longValue(1, SystemClock.elapsedRealtime());
            } catch (Exception unused) {
                elapsedRealtime = SystemClock.elapsedRealtime();
            }
            if (elapsedRealtime == 0) {
                elapsedRealtime = SystemClock.elapsedRealtime();
            }
            final long j = elapsedRealtime;
            final ra xj2 = ra.xj(MediationConstant.EXTRA_DURATION);
            Thread currentThread = Thread.currentThread();
            try {
                name = pluginValueSet.stringValue(2, currentThread.getName());
            } catch (Exception unused2) {
                name = currentThread.getName();
            }
            final String str = name;
            try {
                priority = pluginValueSet.intValue(3, currentThread.getPriority());
            } catch (Exception unused3) {
                priority = currentThread.getPriority();
            }
            final int i = priority;
            hf(pluginValueSet);
            f.zg().am();
            if (this.u) {
                xj(wVar);
                return;
            }
            xj(xjVar, pluginValueSet);
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            xj(pluginValueSet);
            xj2.xj("init_thread_cost", SystemClock.elapsedRealtime() - elapsedRealtime2);
            long elapsedRealtime3 = SystemClock.elapsedRealtime();
            if (ai.hf) {
                com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
            }
            xj2.xj("init_autoservice_cost", SystemClock.elapsedRealtime() - elapsedRealtime3);
            final long elapsedRealtime4 = SystemClock.elapsedRealtime() - j;
            xj2.hf("sync_cost");
            com.bytedance.sdk.component.tf.p.hf.pl().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.w.1
                @Override // java.lang.Runnable
                public void run() {
                    xj2.hf("async_wait_cost");
                    if (w.this.xj(context, xjVar, wVar, xj2)) {
                        xj2.hf("async_done_cost");
                        long elapsedRealtime5 = SystemClock.elapsedRealtime() - j;
                        xj2.xj();
                        w.this.xj(context, elapsedRealtime4, elapsedRealtime5, SystemClock.elapsedRealtime() - j, xj2, true, xjVar, str, i, pluginValueSet, pz.hf().az());
                    }
                }
            });
            com.bytedance.sdk.component.tf.c.xj(-1);
            com.bytedance.sdk.openadsdk.xj.hf.hf.xj();
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("init Async") { // from class: com.bytedance.sdk.openadsdk.core.w.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (w.this.kd.get()) {
                            return;
                        }
                        w.this.kd.set(true);
                        y.xj();
                        com.bytedance.sdk.openadsdk.core.a.p.w();
                        com.bytedance.sdk.openadsdk.xj.xj.xj.xj(false);
                        com.bytedance.sdk.openadsdk.qt.hf.xj(context);
                        com.bytedance.sdk.openadsdk.qt.hf.hf();
                        com.bytedance.sdk.openadsdk.core.miniapp.xj.xj().registerReceiver(context);
                        com.bytedance.sdk.openadsdk.core.qt.w.kd().y();
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.pl.hf("Init sync exception: ".concat(String.valueOf(th)));
                    }
                }
            });
            v.xj = true;
        } catch (Throwable th) {
            xj(wVar, th);
            xj(new com.bytedance.sdk.openadsdk.zg.w.w.xj(pluginValueSet != null ? pluginValueSet.sparseArray() : new SparseArray<>()), this.u);
        }
    }

    private void xj(@ForbidWrapParam com.bytedance.sdk.openadsdk.core.wo.w wVar, Throwable th) {
        if (wVar != null) {
            String message = th != null ? th.getMessage() : null;
            if (message == null) {
                message = "init error";
            }
            wVar.xj(1, com.bytedance.sdk.openadsdk.zg.kd.xj().xj(false).xj(TTAdConstant.INIT_LOCAL_FAIL_CODE).xj(message).hf());
            com.bytedance.sdk.component.utils.pl.w("TTAdSdk", " init fail, msg = ", message);
        }
        this.u = false;
    }

    private void xj(@ForbidWrapParam PluginValueSet pluginValueSet) {
        try {
            com.bytedance.sdk.openadsdk.core.en.xj.xj();
        } catch (Exception unused) {
        }
    }

    private void xj(com.bytedance.sdk.openadsdk.core.wo.w wVar) {
        com.bytedance.sdk.openadsdk.core.w.xj.xj();
        if (wVar != null) {
            wVar.xj(AVMDLDataLoader.KeyIsLiveSetP2pAllow, com.bytedance.sdk.openadsdk.zg.kd.xj().xj(true).xj(com.bytedance.sdk.openadsdk.zg.u.xj().xj(20, com.bytedance.sdk.component.tf.p.hf.d()).xj(23, w()).hf()).hf());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xj(@ForbidWrapParam Context context, @ForbidWrapParam com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar, @ForbidWrapParam com.bytedance.sdk.openadsdk.core.wo.w wVar, ra raVar) {
        if (this.u) {
            xj(wVar);
            return false;
        }
        try {
            if (com.bytedance.sdk.openadsdk.core.u.xj.w()) {
                if (!tmapcloak.loadLibSuccess) {
                    xj(wVar, new Exception("load maparmor fail"));
                    return false;
                }
                raVar.hf("maparmor_load_cost");
            }
            xj(context, xjVar, raVar);
            this.u = true;
            xj(context, xjVar);
            raVar.hf("async_init_cost");
            com.bytedance.sdk.component.u.xj hf2 = com.bytedance.sdk.openadsdk.core.a.dk.hf();
            if (hf2 != null) {
                hf2.initPglCryptUtils();
            }
            raVar.hf("armor_load_cost");
            com.bytedance.sdk.component.utils.pl.u("TTAdSdk", "Init done finish: 7132");
            xj(wVar);
        } catch (Throwable th) {
            xj(wVar, th);
        }
        xj(xjVar, this.u);
        return true;
    }

    private void xj(@ForbidWrapParam Context context, @ForbidWrapParam com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar, ra raVar) {
        try {
            if (xj(xjVar)) {
                com.bytedance.sdk.openadsdk.core.a.v.xj();
                com.bykv.vk.openvk.component.video.api.y.w.xj();
                com.bytedance.sdk.component.d.xj.xj();
                com.bytedance.sdk.openadsdk.tools.hf.hf();
            }
        } catch (Throwable unused) {
        }
        raVar.hf("debug_set_cost");
        com.bytedance.sdk.openadsdk.core.multipro.u.xj(context);
        raVar.hf("web_dir_cost");
        com.bytedance.sdk.component.d.w.xj.xj((ThreadPoolExecutor) com.bytedance.sdk.component.tf.c.xj());
        raVar.hf("thread_pool_cost");
        com.bykv.vk.openvk.component.video.api.w.xj(xjVar.tf());
        if (xjVar.tf()) {
            com.bytedance.sdk.openadsdk.core.multipro.hf.xj();
            f.zg().j();
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.hf.hf();
        }
        raVar.hf("multi_cost");
        com.bykv.vk.openvk.component.video.api.w.xj(context, null);
        com.bykv.vk.openvk.component.video.xj.xj.xj(context);
        raVar.hf("video_config_cost");
        v.kd();
        raVar.hf("dyna_init_cost");
        com.bytedance.sdk.openadsdk.core.a.dk.w();
        raVar.hf("armor_init_cost");
    }

    private void xj(@ForbidWrapParam com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar, @ForbidWrapParam PluginValueSet pluginValueSet) {
        hf(xjVar, pluginValueSet);
        v.u();
        com.bytedance.sdk.openadsdk.core.ht.hf.hf();
        try {
            com.bytedance.sdk.openadsdk.core.ugeno.kd.xj();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
        if (xjVar.tf()) {
            com.bytedance.sdk.openadsdk.core.a.j.xj();
        }
        com.bytedance.sdk.openadsdk.core.w.w.xj().xj(xjVar.tf());
    }

    private void xj(@ForbidWrapParam final Context context, @ForbidWrapParam final com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar) {
        com.bytedance.sdk.component.tf.c.xj(new com.bytedance.sdk.component.tf.d("init sync") { // from class: com.bytedance.sdk.openadsdk.core.w.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.pl.d.kd();
                    com.bytedance.sdk.openadsdk.core.j.tf hf2 = pz.hf();
                    if (!hf2.yt()) {
                        synchronized (hf2) {
                            try {
                                if (!hf2.yt()) {
                                    hf2.xj();
                                }
                            } finally {
                            }
                        }
                    }
                    w.this.xj(xjVar.tf(), context, true, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                    com.bytedance.sdk.component.utils.f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.w.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.zg().z()) {
                                return;
                            }
                            com.bytedance.sdk.openadsdk.qt.hf.w();
                        }
                    }, 120000L);
                    com.bykv.vk.openvk.component.video.api.w.xj(com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().y());
                    com.bytedance.sdk.openadsdk.core.ht.hf.xj(context, xjVar.tf());
                    com.bytedance.sdk.openadsdk.core.pl.hf.w();
                    en.w();
                    com.bykv.vk.openvk.component.video.xj.xj.xj(com.bytedance.sdk.openadsdk.x.d.xj(0));
                    if (hf2.p()) {
                        final com.bykv.vk.openvk.component.video.api.xj.hf xj2 = com.bytedance.sdk.openadsdk.x.d.xj(1);
                        com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("preloadTTVideo") { // from class: com.bytedance.sdk.openadsdk.core.w.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.bytedance.sdk.component.pl.hf.hf.xj(context, xj2.u(), 52428800, com.bytedance.sdk.openadsdk.x.d.hf(), com.bytedance.sdk.openadsdk.x.d.w(), w.xj(xjVar), new VideoEventEngineUploader() { // from class: com.bytedance.sdk.openadsdk.core.w.3.2.1
                                    @Override // com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader
                                    public void onEvent(String str, JSONObject jSONObject) {
                                        y.xj().xj(str, jSONObject);
                                    }
                                });
                            }
                        });
                    }
                    com.bytedance.sdk.openadsdk.core.a.p.qt();
                    v.xj(context);
                    com.bytedance.sdk.component.tf.c.xj(true);
                    com.bytedance.sdk.component.tf.c.xj(new com.bytedance.sdk.openadsdk.core.ht.hf.xj());
                    com.bytedance.sdk.openadsdk.core.dislike.hf.xj();
                    com.bytedance.sdk.openadsdk.core.a.p.xj(context);
                    com.bytedance.sdk.openadsdk.xj.hf.hf.w(context);
                    com.bytedance.sdk.openadsdk.core.a.p.kd(context);
                    com.bytedance.sdk.openadsdk.pl.u.xj(context);
                    if (Build.VERSION.SDK_INT >= 29) {
                        try {
                            com.bytedance.sdk.component.utils.v.xj();
                            com.bytedance.sdk.component.utils.am.xj(new com.bytedance.sdk.openadsdk.x.kd());
                        } catch (Exception unused) {
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.a.am.xj();
                    com.bytedance.sdk.openadsdk.core.a.f.xj(xjVar);
                    com.bytedance.sdk.openadsdk.core.a.dk.xj();
                    com.bytedance.sdk.openadsdk.core.r.xj.xj().xj(context);
                    com.bytedance.sdk.openadsdk.core.a.ff.xj();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.pl.hf("TTAdSdk", "Unexpected asyn init error: ".concat(String.valueOf(th)));
                }
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final boolean z, @ForbidWrapParam final Context context, final boolean z2, long j) {
        com.bytedance.sdk.component.utils.f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.w.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.live.hf.xj();
                if (!z) {
                    com.bytedance.sdk.openadsdk.core.j.f.xj(pz.hf()).w();
                } else if (com.bytedance.sdk.component.utils.e.xj(context)) {
                    com.bytedance.sdk.openadsdk.core.j.f.xj(pz.hf()).w();
                    com.bytedance.sdk.component.utils.pl.xj("TTAdSdk", "Load setting in main process");
                }
                if (z2) {
                    com.bytedance.sdk.openadsdk.core.ht.hf.u();
                }
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(@ForbidWrapParam final Context context, final long j, final long j2, final long j3, final ra raVar, final boolean z, final com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar, final String str, final int i, @ForbidWrapParam final PluginValueSet pluginValueSet, @ForbidWrapParam final com.bytedance.sdk.openadsdk.core.j.c cVar) {
        com.bytedance.sdk.component.utils.f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.w.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    w.this.hf(context, j, j2, j3, raVar, z, xjVar, str, i, pluginValueSet, cVar);
                } catch (Throwable unused) {
                }
            }
        }, PushUIConfig.dismissTime);
    }
}
