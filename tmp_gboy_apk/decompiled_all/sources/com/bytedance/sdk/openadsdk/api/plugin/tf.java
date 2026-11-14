package com.bytedance.sdk.openadsdk.api.plugin;

import ADYaiT.CtFAbx;
import IzHBwY.A4TApA;
import IzHBwY.ADYaiT;
import IzHBwY.ARc23Z;
import P8ccfD.AaHO0E;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.openliveplugin.process.LiveProcessUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.component.tf.p;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.plugin.d;
import com.bytedance.sdk.openadsdk.api.xj;
import com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.download.api.constant.BaseConstants;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class tf extends com.bytedance.sdk.openadsdk.api.xj {
    private static final xj xj = new xj();
    private boolean c;
    private SharedPreferences kd;
    private c u;
    private volatile Initializer hf = kd();
    private volatile Initializer w = null;
    private boolean y = false;
    private com.bytedance.sdk.openadsdk.w.w f = new com.bytedance.sdk.openadsdk.w.w() { // from class: com.bytedance.sdk.openadsdk.api.plugin.tf.1
        @Override // com.bytedance.sdk.openadsdk.w.w
        public Function<SparseArray<Object>, Object> xj(int i) {
            return tf.this.xj(i);
        }
    };

    public static final class w {
        private static final w xj = new w();
        private volatile Initializer hf;

        static {
            XYTgod();
        }

        private w() {
        }

        private static /* synthetic */ void XYTgod() {
            char[] charArray = "ÐÜÞ\u009dÔÒÞÖ\u009dÑÜÊ\u009dÀÛÖßß\u009dùÝÚñÁÚ×ÔÖ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 179);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÐßÚÝÚÇ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 179);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        private static Initializer hf(c cVar) {
            try {
                cVar.hf("call_create_initializer");
                BaseDexClassLoader xj2 = d.xj(TTAppContextHolder.getContext()).xj(cVar, BaseConstants.Time.MINUTE);
                if (xj2 == null) {
                    throw new u(4205, "Get initializer failed");
                }
                Class<?> loadClass = xj2.loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
                cVar.hf("get_init_class_cost");
                Bundle bundle = new Bundle();
                bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new d.w());
                bundle.putInt("api_sdk_version", 7132);
                cVar.hf("create_bundle_cost");
                Method declaredMethod = loadClass.getDeclaredMethod("getNewInstance", Bundle.class);
                cVar.hf("get_init_method_cost");
                try {
                    com.bytedance.sdk.openadsdk.api.u uVar = new com.bytedance.sdk.openadsdk.api.u(AaHO0E.AYUAbz(declaredMethod.invoke(null, bundle)));
                    cVar.hf("get_init_instance_cost");
                    com.bytedance.sdk.openadsdk.api.y.hf("TTPluginManager", "Create initializer success");
                    return uVar;
                } catch (Throwable th) {
                    Zeus.unInstallPlugin("com.byted.pangle");
                    throw th;
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.openadsdk.api.y.u("TTPluginManager", "Create initializer failed");
                if (th2 instanceof u) {
                    throw th2;
                }
                com.bytedance.sdk.openadsdk.api.y.xj(th2);
                throw new u(4206, th2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Initializer xj(c cVar) {
            if (this.hf == null) {
                synchronized (this) {
                    try {
                        if (this.hf == null) {
                            this.hf = hf(cVar);
                        }
                    } finally {
                    }
                }
            }
            return this.hf;
        }
    }

    public static final class xj extends xj.w {
        private xj() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.xj.w
        public void xj(Throwable th) {
            d.xj(th);
        }

        @Override // com.bytedance.sdk.openadsdk.api.xj.w
        public Object xj(Object obj) {
            boolean z = obj instanceof TTPluginListener;
            if (z) {
                d.xj(TTAppContextHolder.getContext()).xj((TTPluginListener) obj);
            }
            if (!z) {
                return obj instanceof ILiveAdCustomConfig ? com.bytedance.sdk.openadsdk.live.w.xj((ILiveAdCustomConfig) obj) : com.bytedance.sdk.openadsdk.ai.hf.xj(obj) ? new com.bytedance.sdk.openadsdk.ai.hf(obj) : obj;
            }
            TTPluginListener tTPluginListener = (TTPluginListener) obj;
            return d.xj(TTAppContextHolder.getContext()).xj(tTPluginListener.packageName(), tTPluginListener.config());
        }
    }

    static {
        ShaHox();
    }

    private static /* synthetic */ void ShaHox() {
        char[] charArray = "öúø»òôøð»÷úì»æýðùù»ßûü×çüñòð".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 149);
        }
        String str = new String(charArray);
        char[] charArray2 = "öùüûüá".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 149);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static Initializer kd() {
        try {
            Class<?> loadClass = TTAdSdk.class.getClassLoader().loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
            Bundle bundle = new Bundle();
            bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new d.w());
            bundle.putInt("api_sdk_version", 7132);
            return new com.bytedance.sdk.openadsdk.api.u(AaHO0E.AYUAbz(loadClass.getDeclaredMethod("getNewInstance", Bundle.class).invoke(null, bundle)));
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.y.xj(th);
            com.bytedance.sdk.openadsdk.api.y.kd("_tt_ad_sdk_", "Get direct initializer failed");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        ExecutorService executorService = (ExecutorService) xj(ExecutorService.class, 1);
        if (executorService != null && (executorService instanceof ThreadPoolExecutor)) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
            p.hf.xj(threadPoolExecutor);
            com.bytedance.sdk.openadsdk.yo.xj.xj().xj(threadPoolExecutor);
        }
        ExecutorService executorService2 = (ExecutorService) xj(ExecutorService.class, 2);
        if (executorService2 != null) {
            p.hf.hf((ThreadPoolExecutor) executorService2);
        }
        ExecutorService executorService3 = (ExecutorService) xj(ExecutorService.class, 3);
        if (executorService3 != null) {
            p.hf.xj((ScheduledExecutorService) executorService3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.xj
    public boolean hf(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        boolean z = false;
        super.hf(context, adConfig, initCallback);
        this.u = c.xj(MediationConstant.EXTRA_DURATION);
        try {
            if (LiveProcessUtils.inLiveProcess(TTAppContextHolder.getContext()).booleanValue()) {
                return false;
            }
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.y.hf("_tt_ad_sdk_", e);
        }
        if (com.bytedance.sdk.openadsdk.api.kd.xj()) {
            A4TApA ADYaiT2 = A4TApA.ADYaiT();
            ADYaiT2.f4105A5SV6n = false;
            ADYaiT2.f4104A4TApA = 4204;
            ADYaiT2.f4106ADYaiT = "Only support >= 7.0";
            hf(ADYaiT2.A5SV6n());
            return false;
        }
        if (adConfig != null && adConfig.isDebug()) {
            z = true;
        }
        this.c = z;
        y.xj(adConfig);
        return true;
    }

    public boolean u() {
        if (this.kd == null) {
            this.kd = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(TTAppContextHolder.getContext(), "sp_bidding_opt_libra", 0);
        }
        return this.kd.getInt("_use_pl_", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.api.xj
    public com.bytedance.sdk.openadsdk.w.w w() {
        return this.f;
    }

    @Override // com.bytedance.sdk.openadsdk.api.xj
    public void xj(Result result) {
        super.xj(result);
        y.xj();
    }

    @Override // com.bytedance.sdk.openadsdk.api.xj
    public boolean xj(Context context, ARc23Z aRc23Z) {
        if (xj(context) && u()) {
            com.bytedance.sdk.openadsdk.api.y.w("_tt_ad_sdk_", "use pl Init");
            return false;
        }
        if (com.bytedance.sdk.openadsdk.api.plugin.w.w.hf()) {
            com.bytedance.sdk.openadsdk.api.y.kd("_tt_ad_sdk_", "this device does not support arm64-v8a abi");
            return false;
        }
        if (this.hf != null) {
            this.y = true;
            xj(this.hf.getManager(), false);
            this.hf.init(context, aRc23Z.A2egSU());
            return false;
        }
        A4TApA ADYaiT2 = A4TApA.ADYaiT();
        ADYaiT2.f4105A5SV6n = false;
        ADYaiT2.f4104A4TApA = 4206;
        hf(ADYaiT2.A5SV6n());
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.xj
    public void hf(Context context, ARc23Z aRc23Z) {
        com.bytedance.sdk.openadsdk.api.y.w("_tt_ad_sdk_", "async init");
        if (this.y && Build.VERSION.SDK_INT < 26) {
            com.bytedance.sdk.openadsdk.api.y.u("_tt_ad_sdk_", "lower 26");
            return;
        }
        this.u.hf("wait_asyn_cost");
        d.xj(TTAppContextHolder.getContext());
        if (!com.bytedance.sdk.openadsdk.api.plugin.w.w.hf() && !xj(context)) {
            com.bytedance.sdk.openadsdk.api.y.u("_tt_ad_sdk_", "no pl");
        } else {
            com.bytedance.sdk.openadsdk.api.y.u("_tt_ad_sdk_", "start pl load");
            xj(this.u, aRc23Z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.xj
    public boolean xj() {
        return (com.bytedance.sdk.openadsdk.api.kd.xj() || this.hf == null || !this.hf.isInitSuccess()) ? false : true;
    }

    private boolean xj(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.hf.u(context);
    }

    @Override // com.bytedance.sdk.openadsdk.api.xj
    public xj.w hf() {
        return xj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Function<SparseArray<Object>, Object> xj(int i) {
        if (i == 2) {
            return com.bytedance.sdk.openadsdk.live.w.xj();
        }
        if (i == 3) {
            return com.bytedance.sdk.openadsdk.downloadnew.w.xj(TTAppContextHolder.getContext());
        }
        if (i != 4) {
            return null;
        }
        return com.bytedance.sdk.openadsdk.api.plugin.xj.xj.xj();
    }

    public class hf implements Function<SparseArray<Object>, Object> {
        private hf() {
        }

        @Override // java.util.function.Function
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            if (sparseArray != null) {
                ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
                int intValue = AMqCpz.intValue(-99999987, 0);
                SparseArray sparseArray2 = (SparseArray) AMqCpz.objectValue(-99999979, SparseArray.class);
                if (sparseArray2 != null) {
                    ADYaiT AMqCpz2 = A2egSU.AMqCpz(sparseArray2);
                    A4TApA ADYaiT2 = A4TApA.ADYaiT();
                    ADYaiT2.f4104A4TApA = AMqCpz2.intValue(-999900, 0);
                    ADYaiT2.f4106ADYaiT = AMqCpz2.stringValue(-999901, null);
                    ADYaiT2.f4105A5SV6n = AMqCpz2.booleanValue(-999903, false);
                    ADYaiT2.AMqCpz = A2egSU.AMqCpz((SparseArray) AMqCpz2.objectValue(-999902, SparseArray.class));
                    xj(intValue, ADYaiT2.A5SV6n());
                }
            }
            return null;
        }

        public ValueSet xj(int i, Result result) {
            com.bytedance.sdk.openadsdk.api.y.w("bstsdk", "Load p_init: " + result.code() + ", message: " + result.message());
            if (result.isSuccess() && tf.this.w != null) {
                if (tf.this.y && tf.this.hf != null && tf.this.hf.isInitSuccess()) {
                    tf tfVar = tf.this;
                    tfVar.xj(tfVar.hf.getManager(), result);
                }
                tf tfVar2 = tf.this;
                tfVar2.hf = tfVar2.w;
                tf tfVar3 = tf.this;
                tfVar3.xj(tfVar3.hf.getManager(), true);
            }
            if (!tf.this.y) {
                tf.this.hf(result);
            }
            if (!result.isSuccess() || tf.this.w == null) {
                return null;
            }
            tf.this.y();
            return null;
        }
    }

    private void xj(c cVar, ARc23Z aRc23Z) {
        if (this.w == null || !this.w.isInitSuccess()) {
            ARc23Z aRc23Z2 = new ARc23Z(aRc23Z.A2egSU().sparseArray());
            aRc23Z2.AMqCpz(15, new hf());
            try {
                if (this.w == null) {
                    synchronized (w.class) {
                        try {
                            if (this.w == null) {
                                Initializer xj2 = w.xj.xj(cVar);
                                this.w = xj2;
                                xj(xj2, cVar, aRc23Z2);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (u e) {
                com.bytedance.sdk.openadsdk.api.y.u("bstsdk", "Load p_init failed: " + e.xj() + ", message: " + e.getMessage());
                y.xj(e.xj(), e.getMessage(), 0L);
                if (this.y) {
                    return;
                }
                com.bytedance.sdk.openadsdk.api.y.kd("bstsdk", "finishInit, pl_error: " + e.getMessage());
                A4TApA ADYaiT2 = A4TApA.ADYaiT();
                ADYaiT2.f4105A5SV6n = false;
                ADYaiT2.f4104A4TApA = e.xj();
                ADYaiT2.f4106ADYaiT = e.getMessage();
                hf(ADYaiT2.A5SV6n());
            } catch (Exception e2) {
                y.xj(4206, CtFAbx.AZOQYO(e2, new StringBuilder("Load p_init failed: ")), 0L);
                com.bytedance.sdk.openadsdk.api.y.u("_tt_ad_sdk_", "Load p_init failed: " + e2.getMessage());
                if (this.y) {
                    return;
                }
                com.bytedance.sdk.openadsdk.api.y.kd("bstsdk", "finishInit, error: " + e2.getMessage());
                A4TApA ADYaiT3 = A4TApA.ADYaiT();
                ADYaiT3.f4105A5SV6n = false;
                ADYaiT3.f4104A4TApA = 4206;
                ADYaiT3.f4106ADYaiT = e2.getMessage();
                hf(ADYaiT3.A5SV6n());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Manager manager, Result result) {
        if (manager == null || !(manager instanceof com.bytedance.sdk.openadsdk.api.w)) {
            return;
        }
        Function<SparseArray<Object>, Object> xj2 = ((com.bytedance.sdk.openadsdk.api.w) manager).xj(1);
        if (CtFAbx.B9tovu(xj2)) {
            SparseArray<Object> sparseArray = result.values() == null ? null : result.values().sparseArray();
            ARc23Z A5SV6n2 = ARc23Z.A5SV6n(1);
            A5SV6n2.ADYaiT(-99999987, 16);
            SparseArray sparseArray2 = A5SV6n2.f4113A2egSU;
            sparseArray2.put(-99999985, Void.class);
            A5SV6n2.ASJ6gh(17, true);
            sparseArray2.put(21, sparseArray);
            AaHO0E.AYUAbz(xj2).apply(A5SV6n2.A2egSU().sparseArray());
        }
    }

    private <T> T xj(Class<T> cls, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", i);
        return (T) hf().getExtra(cls, bundle);
    }

    private static void xj(Initializer initializer, c cVar, ARc23Z aRc23Z) {
        if (initializer != null) {
            try {
                cVar.xj();
                JSONObject jSONObject = new JSONObject();
                cVar.xj(jSONObject, 20L);
                jSONObject.put("zeus", d.xj(TTAppContextHolder.getContext()).xj());
                aRc23Z.AMqCpz(17, com.bytedance.sdk.openadsdk.yo.xj.xj().hf());
                p pVar = p.hf;
                aRc23Z.AMqCpz(20, pVar.d());
                aRc23Z.AMqCpz(19, pVar.tf());
                aRc23Z.AMqCpz(21, pVar.pl());
                aRc23Z.AMqCpz(22, new com.bytedance.sdk.openadsdk.ats.w());
                Context context = TTAppContextHolder.getContext();
                aRc23Z.f4113A2egSU.put(9, jSONObject);
                initializer.init(context, aRc23Z.A2egSU());
                if (TTAppContextHolder.getContext() != null) {
                    Zeus.hookHuaWeiVerifier((Application) TTAppContextHolder.getContext().getApplicationContext());
                }
                com.bytedance.sdk.openadsdk.api.y.hf("_tt_ad_sdk_", "Initialized done");
                return;
            } catch (Exception e) {
                Zeus.unInstallPlugin("com.byted.pangle");
                throw new u(4207, CtFAbx.AZOQYO(e, new StringBuilder("Init error: ")));
            }
        }
        throw new u(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED, "Init error");
    }
}
