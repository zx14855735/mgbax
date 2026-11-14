package com.bytedance.sdk.openadsdk.core;

import ADYaiT.BpkvW3;
import ADYaiT.CtFAbx;
import J3EcKw.A2egSU;
import P8ccfD.AaHO0E;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class en {
    private Function<SparseArray<Object>, Object> f;
    private static final en u = new en();
    private static int c = -1;
    private static String d = "ext_plugin";
    private volatile Function<SparseArray<Object>, Object> xj = null;
    private volatile Function<SparseArray<Object>, Object> hf = null;
    private volatile Function<SparseArray<Object>, Object> w = null;
    private AtomicBoolean kd = new AtomicBoolean(false);
    private AtomicBoolean y = new AtomicBoolean(false);

    static {
        tFjB();
    }

    private en() {
    }

    private Function<SparseArray<Object>, Object> c() {
        Object apply;
        com.bytedance.sdk.openadsdk.core.x.w wVar = (com.bytedance.sdk.openadsdk.core.x.w) com.bytedance.sdk.openadsdk.ats.w.xj("pitaya");
        if (wVar == null || !wVar.isPitayaEnvAvailable()) {
            com.bytedance.sdk.component.utils.pl.u(d, "can use pitaya false");
            return null;
        }
        if (!u() || y().intValue() < 1100) {
            return null;
        }
        if (this.w == null) {
            synchronized (en.class) {
                try {
                    if (this.w == null) {
                        Function<SparseArray<Object>, Object> pl2 = pl();
                        if (pl2 != null) {
                            apply = pl2.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(AVMDLDataLoader.KeyIsStoRingBufferSizeKB).xj(AaHO0E.ARc23Z()).hf());
                            if (BpkvW3.BmvVmW(apply)) {
                                this.w = AaHO0E.AYUAbz(apply);
                            }
                        }
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.pl.u(d, "getBridge:" + th.getMessage());
                } finally {
                }
            }
        }
        return this.w;
    }

    private static String d() {
        Object apply;
        apply = f.zg().aq().apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8).xj(String.class).xj(0, "com.byted.csj.ext").hf());
        return (String) apply;
    }

    private static String f() {
        int i = ai.w;
        return (i == 5001 || i == 5002) ? tf() : d();
    }

    public static int hf() {
        if (c == -1) {
            c = xj().y().intValue();
        }
        return c;
    }

    private static String p() {
        try {
            Integer y = xj().y();
            if (y.intValue() != -1) {
                return hf(y.intValue());
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            return null;
        }
    }

    private Function<SparseArray<Object>, Object> pl() {
        Object apply;
        try {
            if (this.f == null) {
                apply = f.zg().aq().apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(4).xj(ClassLoader.class).xj(0, "com.byted.csj.ext").hf());
                ClassLoader classLoader = (ClassLoader) apply;
                if (classLoader != null) {
                    this.f = AaHO0E.AYUAbz(classLoader.loadClass("com.byted.csj.ext_impl.ServiceManager").getConstructor(new Class[0]).newInstance(new Object[0]));
                }
            }
            return this.f;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.u(d, "getServiceManager:" + th.getMessage());
            return null;
        }
    }

    private static /* synthetic */ void tFjB() {
        char[] charArray = "\u0017\u001b\u0019Z\u0013\u0015\u0019\u0011Z\u0016\u001b\rZ\u0007\u001c\u0011\u0018\u0018Z>\u001a\u001d6\u0006\u001d\u0010\u0013\u0011".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 't');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0017\u0018\u001d\u001a\u001d\u0000".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 't');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static String tf() {
        Object apply;
        try {
            Function<SparseArray<Object>, Object> aq = f.zg().aq();
            JSONObject optJSONObject = f.zg().en().optJSONObject("com.byted.csj.ext");
            apply = aq.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(6).xj(Boolean.class).xj(0, "com.byted.csj.ext").hf());
            if (!(apply != null ? ((Boolean) apply).booleanValue() : false)) {
                return optJSONObject == null ? "0.0.0.0" : (String) optJSONObject.opt(PluginConstants.KEY_PLUGIN_VERSION);
            }
            if (xj().u()) {
                return p();
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.u(d, "ignore:" + th.getMessage());
            com.bytedance.sdk.component.utils.pl.xj(th);
            return "0.0.0.0";
        }
    }

    public static void w() {
        if (ai.w < 5001) {
            return;
        }
        if (!pz.hf().et()) {
            JSONObject en = f.zg().en();
            if (en != null) {
                en.remove("com.byted.csj.ext");
                return;
            }
            return;
        }
        Bundle bundle = new Bundle();
        Bundle xj = xj(f.zg().pz());
        if (xj != null) {
            bundle.putBundle("com.byted.csj.ext", xj);
        }
        f.zg().xj(bundle);
    }

    public static en xj() {
        return u;
    }

    private Integer y() {
        Object apply;
        Function<SparseArray<Object>, Object> pl2 = pl();
        if (pl2 != null) {
            apply = pl2.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(PluginConstants.ERROR_PLUGIN_DOWNLOAD).xj(Integer.class).hf());
            if (apply instanceof Integer) {
                return (Integer) apply;
            }
        }
        return -1;
    }

    public A2egSU kd() {
        if (ai.w >= 5001 && com.bytedance.sdk.openadsdk.core.pz.hf.xj(pz.hf().j()) && u() && com.bytedance.sdk.openadsdk.ats.w.xj("alog") != null) {
            throw new ClassCastException();
        }
        return null;
    }

    public boolean u() {
        Object apply;
        Object apply2;
        try {
            if (ai.w >= 5001 && pz.hf().et()) {
                if (this.kd.get()) {
                    return true;
                }
                if (this.y.compareAndSet(false, true)) {
                    final Function<SparseArray<Object>, Object> aq = f.zg().aq();
                    apply = aq.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(6).xj(Boolean.class).xj(0, "com.byted.csj.ext").hf());
                    if (!(apply != null ? ((Boolean) apply).booleanValue() : false)) {
                        this.y.set(false);
                        return false;
                    }
                    apply2 = aq.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(7).xj(Boolean.class).xj(0, "com.byted.csj.ext").hf());
                    if (!(apply2 != null ? ((Boolean) apply2).booleanValue() : false)) {
                        com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.en.1
                            @Override // java.lang.Runnable
                            public void run() {
                                en.this.xj(aq, true);
                            }
                        });
                        return false;
                    }
                    this.kd.set(true);
                    this.y.set(false);
                    return false;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.u(d, "pit_ext_error:" + th.getMessage());
        }
        return false;
    }

    public Function<SparseArray<Object>, Object> xj(int i) {
        try {
            if (ai.xj() && i == 10003) {
                return c();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
        return null;
    }

    public static String hf(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(".");
            }
        }
        String sb2 = sb.toString();
        return (i < 100 || i >= 1000) ? sb2 : CtFAbx.BChYOn("0.", sb2);
    }

    private static Bundle xj(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString(PluginConstants.KEY_APP_ID, str);
            String f = f();
            if (TextUtils.isEmpty(f)) {
                return null;
            }
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, f);
            bundle.putString(PluginConstants.KEY_SDK_VERSION, hf(ai.kd));
            return bundle;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.u(d, "error:" + th.getMessage());
            com.bytedance.sdk.component.utils.pl.xj(th);
            return null;
        }
    }

    public boolean xj(Function<SparseArray<Object>, Object> function, boolean z) {
        Object apply;
        try {
            if (this.kd.get()) {
                return true;
            }
            if (!z) {
                this.y.set(true);
            }
            apply = function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(5).xj(Boolean.class).xj(0, "com.byted.csj.ext").hf());
            boolean booleanValue = apply != null ? ((Boolean) apply).booleanValue() : false;
            this.kd.set(booleanValue);
            this.y.set(false);
            return booleanValue;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.u(d, ":" + th.getMessage());
            return false;
        }
    }
}
