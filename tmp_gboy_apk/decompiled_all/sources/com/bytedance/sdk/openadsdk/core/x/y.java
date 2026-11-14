package com.bytedance.sdk.openadsdk.core.x;

import IzHBwY.AYUAbz;
import P8ccfD.AaHO0E;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mobads.sdk.internal.aw;
import com.baidu.mobads.sdk.internal.cb;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.xj;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.pz;
import com.sigmob.sdk.base.n;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y implements xj.hf, w, Function {
    private Function<SparseArray<Object>, Object> w;
    private AtomicBoolean xj = new AtomicBoolean(false);
    private AtomicBoolean hf = new AtomicBoolean(false);

    private Function<SparseArray<Object>, Object> kd() {
        Function<SparseArray<Object>, Object> xj = pz.xj(AVMDLDataLoader.KeyIsStoRingBufferSizeKB);
        if (xj != null && isPitayaInitSuccess()) {
            return xj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        com.bytedance.sdk.openadsdk.core.a.xj u = com.bytedance.sdk.openadsdk.core.f.zg().u();
        if (u != null) {
            u.xj(this);
        }
    }

    private void y() {
        if (this.w == null) {
            this.w = new f() { // from class: com.bytedance.sdk.openadsdk.core.x.y.2
                @Override // com.bytedance.sdk.openadsdk.core.x.f, com.bytedance.sdk.openadsdk.core.wo.u
                public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
                    com.bytedance.sdk.openadsdk.zg.xj xjVar = new com.bytedance.sdk.openadsdk.zg.xj((SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class));
                    try {
                        if (i == 1) {
                            JSONObject jSONObject = (JSONObject) xjVar.u().objectValue(10, JSONObject.class);
                            xj.xj().xj(jSONObject.optString("module"), jSONObject.optString("key"), jSONObject.optString("value"));
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(cb.o, true);
                            return (T) com.bytedance.sdk.openadsdk.zg.u.xj().xj(37, jSONObject2).hf();
                        }
                        if (i != 2) {
                            return (T) super.applyFunction(i, pluginValueSet, cls);
                        }
                        JSONObject jSONObject3 = (JSONObject) xjVar.u().objectValue(10, JSONObject.class);
                        String optString = jSONObject3.optString("module");
                        String optString2 = jSONObject3.optString("key");
                        String xj = xj.xj().xj(optString, optString2);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put(optString2, xj);
                        return (T) com.bytedance.sdk.openadsdk.zg.u.xj().xj(37, jSONObject4).hf();
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.pl.xj(e);
                        return (T) com.bytedance.sdk.openadsdk.zg.u.xj().xj(37, new JSONObject()).hf();
                    }
                }
            };
        }
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int intValue = ((Integer) sparseArray.get(0)).intValue();
        if (intValue == 1) {
            init((Context) sparseArray.get(1), AaHO0E.AYUAbz(sparseArray.get(2)));
            return null;
        }
        if (intValue == 2) {
            return Boolean.valueOf(isPitayaEnvAvailable());
        }
        if (intValue == 3) {
            return Boolean.valueOf(isPitayaInitSuccess());
        }
        if (intValue == 4) {
            runTask((String) sparseArray.get(1), (JSONObject) sparseArray.get(2), AaHO0E.AYUAbz(sparseArray.get(3)));
            return null;
        }
        if (intValue != 6) {
            return null;
        }
        queryPackage((String) sparseArray.get(1), AaHO0E.AYUAbz(sparseArray.get(2)));
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.w
    public void init(Context context, final Function<SparseArray<Object>, Object> function) {
        final long currentTimeMillis = System.currentTimeMillis();
        if (pz.xj(AVMDLDataLoader.KeyIsStoRingBufferSizeKB) == null) {
            if (function != null) {
                function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(-1).xj(Void.class).hf());
                return;
            }
            return;
        }
        if (isPitayaInitSuccess()) {
            if (function != null) {
                function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(0).xj(Void.class).hf());
                return;
            }
            return;
        }
        try {
            if (this.xj.compareAndSet(false, true)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("aid", "1371");
                jSONObject.put("channel", ai.c);
                jSONObject.put("core_api_version", ai.u);
                jSONObject.put("core_plugin_version", "7.1.3.2");
                jSONObject.put(aw.f9748a, false);
                jSONObject.put(n.q, true);
                jSONObject.put("download_concurrency", 2);
                jSONObject.put("py_concurrency", 2);
                jSONObject.put("provide_applog", true);
                jSONObject.put("sdk_session_id", com.bytedance.sdk.openadsdk.core.ht.hf.xj);
                y();
                AYUAbz A4TApA2 = AYUAbz.A4TApA();
                SparseArray sparseArray = A4TApA2.f4119A2egSU;
                sparseArray.put(21, jSONObject);
                sparseArray.put(22, context);
                sparseArray.put(38, this.w);
                sparseArray.put(1, new f() { // from class: com.bytedance.sdk.openadsdk.core.x.y.1
                    @Override // com.bytedance.sdk.openadsdk.core.x.f
                    public PluginValueSet xj(int i, kd kdVar) {
                        y.this.hf.set(kdVar.xj());
                        if (kdVar.xj()) {
                            Function function2 = function;
                            if (function2 != null) {
                                function2.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(0).xj(Void.class).hf());
                            }
                            y.this.u();
                        } else {
                            if (kdVar.hf() != null) {
                                com.bytedance.sdk.component.utils.pl.u("pitaya_ext_plugin", "pit error:" + kdVar.hf().toString());
                            }
                            Function function3 = function;
                            if (function3 != null) {
                                function3.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(-1).xj(Void.class).hf());
                            }
                        }
                        y.this.xj(System.currentTimeMillis() - currentTimeMillis, kdVar);
                        return super.xj(i, kdVar);
                    }
                });
                sparseArray.put(13, com.bytedance.sdk.component.tf.c.xj());
                function.apply(com.bytedance.sdk.openadsdk.zg.u.xj((SparseArray<Object>) A4TApA2.A2egSU().sparseArray()).xj(1001).xj(Void.class).hf());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.u("pitaya_ext_plugin", "pit#initPit:" + th.getMessage());
            if (function != null) {
                function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(-1).xj(Void.class).hf());
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.w
    public boolean isPitayaEnvAvailable() {
        int i;
        if (!ai.xj() || ai.w < 5003 || (i = Build.VERSION.SDK_INT) < 28) {
            return false;
        }
        if (w() && i == 29) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.core.pz.hf.hf(pz.hf().j());
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.w
    public boolean isPitayaInitSuccess() {
        return this.hf.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.w
    public void queryPackage(String str, Function<SparseArray<Object>, Object> function) {
        Function<SparseArray<Object>, Object> xj = pz.xj(AVMDLDataLoader.KeyIsStoRingBufferSizeKB);
        if (xj != null) {
            AYUAbz A4TApA2 = AYUAbz.A4TApA();
            A4TApA2.ARc23Z(1, function);
            A4TApA2.ASJ6gh(25, str);
            xj.apply(com.bytedance.sdk.openadsdk.zg.u.xj((SparseArray<Object>) A4TApA2.A2egSU().sparseArray()).xj(PluginConstants.ERROR_PLUGIN_DOWNLOAD).xj(Void.class).hf());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.w
    public void runTask(String str, JSONObject jSONObject, Function<SparseArray<Object>, Object> function) {
        Function<SparseArray<Object>, Object> xj = pz.xj(AVMDLDataLoader.KeyIsStoRingBufferSizeKB);
        if (xj == null) {
            if (function != null) {
                function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8).xj(Void.class).xj(-99999979, com.bytedance.sdk.openadsdk.zg.kd.xj().xj(-6).xj(false).xj("predict bridge is null").xj(com.bytedance.sdk.openadsdk.zg.u.xj().xj(5, str).hf()).hf()).hf());
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("run_package_start", System.currentTimeMillis());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        xj.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(1003).xj(Void.class).xj(25, str).xj(26, jSONObject).xj(1, function).xj(37, jSONObject2).hf());
    }

    public boolean w() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.xj.hf
    public void hf() {
        Function<SparseArray<Object>, Object> kd;
        try {
            if (com.bytedance.sdk.openadsdk.core.f.zg().z() || (kd = kd()) == null) {
                return;
            }
            kd.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(1008).xj(Void.class).xj(36, 1).hf());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(long j, kd kdVar) {
        com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(j, kdVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.xj.hf
    public void xj() {
        Function<SparseArray<Object>, Object> kd;
        try {
            if (com.bytedance.sdk.openadsdk.core.f.zg().z() || (kd = kd()) == null) {
                return;
            }
            kd.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(1008).xj(Void.class).xj(36, 0).hf());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }
}
