package com.bytedance.sdk.openadsdk.core;

import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.a.wo;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class z implements Function<SparseArray<Object>, Object> {
    private volatile Context xj;

    public z(Context context) {
        this.xj = (context == null ? pz.getContext() : context).getApplicationContext();
    }

    private void d(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        xj(com.bytedance.sdk.openadsdk.core.a.ai.xj(7, pluginValueSet), new com.bytedance.sdk.openadsdk.core.xj.d(function));
    }

    private void f(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        xj(com.bytedance.sdk.openadsdk.core.a.ai.xj(5, pluginValueSet), new com.bytedance.sdk.openadsdk.core.xj.kd(function));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        if (this.xj == null) {
            this.xj = pz.getContext();
        }
        return this.xj;
    }

    public void c(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        w(com.bytedance.sdk.openadsdk.core.a.ai.xj(1, pluginValueSet), new com.bytedance.sdk.openadsdk.core.xj.f(function));
    }

    public void hf(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final com.bytedance.sdk.openadsdk.jk.xj.hf.xj.w wVar) {
        if (!com.bytedance.sdk.openadsdk.core.j.d.xj()) {
            wVar.xj(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.tf.d dVar = new com.bytedance.sdk.component.tf.d("loadStream") { // from class: com.bytedance.sdk.openadsdk.core.z.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.u.xj.hf().xj(hfVar, (com.bytedance.sdk.openadsdk.zg.w.w.hf) wVar, currentTimeMillis);
                } catch (Throwable th) {
                    wVar.xj(TTAdConstant.INIT_LOCAL_FAIL_CODE, "feed component maybe not exist, pls check1, msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.pl.w("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
                }
            }
        };
        if (v.xj) {
            xj(dVar, 6);
            com.bytedance.sdk.openadsdk.core.y.xj.w().xj(6, hfVar);
        } else {
            com.bytedance.sdk.component.utils.pl.u("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            wVar.xj(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        }
    }

    public void kd(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        xj(com.bytedance.sdk.openadsdk.core.a.ai.xj(5, pluginValueSet), new com.bytedance.sdk.openadsdk.core.xj.f(function));
    }

    public void u(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        xj(com.bytedance.sdk.openadsdk.core.a.ai.xj(8, pluginValueSet), new com.bytedance.sdk.openadsdk.core.xj.y(function));
    }

    public void w(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        xj(1, com.bytedance.sdk.openadsdk.core.a.ai.xj(1, pluginValueSet), new com.bytedance.sdk.openadsdk.core.xj.c(function));
    }

    public void y(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        hf(com.bytedance.sdk.openadsdk.core.a.ai.xj(9, pluginValueSet), new com.bytedance.sdk.openadsdk.core.xj.f(function));
    }

    public void w(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final com.bytedance.sdk.openadsdk.jk.xj.hf.xj.y yVar) {
        if (!com.bytedance.sdk.openadsdk.core.j.d.xj()) {
            yVar.xj(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.tf.d dVar = new com.bytedance.sdk.component.tf.d("loadBannerExpressAd") { // from class: com.bytedance.sdk.openadsdk.core.z.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (z.this.xj(hfVar, false)) {
                        com.bytedance.sdk.openadsdk.core.component.xj.xj.hf().xj(hfVar, yVar, currentTimeMillis);
                    } else {
                        yVar.xj(110, c.xj(110));
                    }
                } catch (Throwable th) {
                    yVar.xj(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.pl.w("TTAdNativeImpl", "Banner express error, pls check", th);
                }
            }
        };
        if (!v.xj) {
            com.bytedance.sdk.component.utils.pl.u("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            yVar.xj(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            xj(dVar, 1);
            com.bytedance.sdk.openadsdk.core.y.xj.w().xj(1, hfVar);
        }
    }

    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final com.bytedance.sdk.openadsdk.jk.xj.hf.xj.w wVar) {
        if (!com.bytedance.sdk.openadsdk.core.j.d.xj()) {
            wVar.xj(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.tf.d dVar = new com.bytedance.sdk.component.tf.d("loadFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.z.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.w.xj.hf().xj(hfVar, (com.bytedance.sdk.openadsdk.zg.w.w.hf) wVar, currentTimeMillis);
                } catch (Throwable th) {
                    wVar.xj(TTAdConstant.INIT_LOCAL_FAIL_CODE, "feed component maybe not exist, pls check1, msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.pl.w("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
                }
            }
        };
        if (!v.xj) {
            com.bytedance.sdk.component.utils.pl.u("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            wVar.xj(10000, "Please exec  TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            xj(dVar, 5);
            com.bytedance.sdk.openadsdk.core.y.xj.w().xj(5, hfVar);
        }
    }

    public void hf(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        xj(com.bytedance.sdk.openadsdk.core.a.ai.xj(9, pluginValueSet), new com.bytedance.sdk.openadsdk.core.xj.u(function));
    }

    public void hf(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final com.bytedance.sdk.openadsdk.jk.xj.hf.xj.y yVar) {
        if (!com.bytedance.sdk.openadsdk.core.j.d.xj()) {
            yVar.xj(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.tf.d dVar = new com.bytedance.sdk.component.tf.d("loadExpressDrawFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.z.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (z.this.xj(hfVar, false)) {
                        com.bytedance.sdk.openadsdk.core.component.hf.xj.hf().xj(hfVar, yVar, currentTimeMillis);
                    } else {
                        yVar.xj(110, c.xj(110));
                    }
                } catch (Throwable th) {
                    yVar.xj(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.pl.w("TTAdNativeImpl", "Error msg =", th);
                }
            }
        };
        if (!v.xj) {
            com.bytedance.sdk.component.utils.pl.u("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            yVar.xj(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            xj(dVar, 9);
            com.bytedance.sdk.openadsdk.core.y.xj.w().xj(9, hfVar);
        }
    }

    public void xj(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        hf(com.bytedance.sdk.openadsdk.core.a.ai.xj(6, pluginValueSet), new com.bytedance.sdk.openadsdk.core.xj.kd(function));
    }

    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final com.bytedance.sdk.openadsdk.jk.xj.hf.xj.hf hfVar2) {
        if (!com.bytedance.sdk.openadsdk.core.j.d.xj()) {
            hfVar2.xj(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.tf.d dVar = new com.bytedance.sdk.component.tf.d("loadDrawFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.z.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    z.this.xj(hfVar);
                    com.bytedance.sdk.openadsdk.core.component.hf.xj.hf().xj(hfVar, (com.bytedance.sdk.openadsdk.zg.w.w.hf) hfVar2, currentTimeMillis);
                } catch (Throwable th) {
                    hfVar2.xj(TTAdConstant.INIT_LOCAL_FAIL_CODE, "feed component maybe not exist, pls check2, msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.pl.w("TTAdNativeImpl", "feed component maybe not exist, pls check2", th);
                }
            }
        };
        if (!v.xj) {
            com.bytedance.sdk.component.utils.pl.u("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            hfVar2.xj(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            xj(dVar, 9);
            com.bytedance.sdk.openadsdk.core.y.xj.w().xj(9, hfVar);
        }
    }

    public void xj(int i, final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final com.bytedance.sdk.openadsdk.jk.xj.hf.xj.kd kdVar) {
        if (!com.bytedance.sdk.openadsdk.core.j.d.xj()) {
            kdVar.xj(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.tf.d dVar = new com.bytedance.sdk.component.tf.d("loadNativeAd") { // from class: com.bytedance.sdk.openadsdk.core.z.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.xj.xj.hf().xj(hfVar, (com.bytedance.sdk.openadsdk.zg.w.w.hf) kdVar, currentTimeMillis);
                } catch (Throwable th) {
                    kdVar.xj(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.pl.w("TTAdNativeImpl", "Error msg = ", th.getMessage());
                }
            }
        };
        if (!v.xj) {
            com.bytedance.sdk.component.utils.pl.u("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            kdVar.xj(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            xj(dVar, i);
            com.bytedance.sdk.openadsdk.core.y.xj.w().xj(i, hfVar.u());
        }
    }

    public void xj(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function, int i) {
        xj(com.bytedance.sdk.openadsdk.core.a.ai.xj(3, pluginValueSet), new com.bytedance.sdk.openadsdk.core.xj.w(function), i);
    }

    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj xjVar, final int i) {
        if (!com.bytedance.sdk.openadsdk.core.j.d.xj()) {
            xjVar.xj(new com.bytedance.sdk.openadsdk.zg.w.w(1000, "广告请求开关已关闭,请联系穿山甲管理员"));
            return;
        }
        int d = pz.hf().d(wo.hf(hfVar));
        com.bytedance.sdk.component.tf.d dVar = new com.bytedance.sdk.component.tf.d("loadSplashAd b") { // from class: com.bytedance.sdk.openadsdk.core.z.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    f.zg().c(1);
                    com.bytedance.sdk.openadsdk.core.component.splash.kd.xj(z.this.getContext()).xj(hfVar, xjVar, i);
                } catch (Throwable th) {
                    xjVar.xj(new com.bytedance.sdk.openadsdk.zg.w.w(TTAdConstant.INIT_LOCAL_FAIL_CODE, A2egSU.B4ZgIw(th, new StringBuilder(" msg = "))));
                    com.bytedance.sdk.component.utils.pl.w("TTAdNativeImpl", "splash component maybe not exist, pls check1", th);
                }
            }
        };
        if (!v.xj) {
            com.bytedance.sdk.component.utils.pl.u("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            xjVar.xj(new com.bytedance.sdk.openadsdk.zg.w.w(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad"));
            return;
        }
        if (AdSdkInitializerHolder.isSdkInitSuccess() && (d == 4 || com.bytedance.sdk.openadsdk.core.component.splash.kd.xj(hfVar))) {
            dVar.run();
        } else if (xj()) {
            com.bytedance.sdk.component.tf.c.kd(dVar);
        } else {
            com.bytedance.sdk.component.tf.p.hf.pl().execute(dVar);
        }
        com.bytedance.sdk.openadsdk.core.y.xj.w().xj(3, hfVar);
    }

    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c cVar) {
        if (!com.bytedance.sdk.openadsdk.core.j.d.xj()) {
            cVar.xj(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.tf.d dVar = new com.bytedance.sdk.component.tf.d("loadRewardVideoAd") { // from class: com.bytedance.sdk.openadsdk.core.z.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.reward.xj.f.xj().xj(hfVar, new com.bytedance.sdk.openadsdk.core.component.reward.xj.u(cVar));
                } catch (Throwable th) {
                    cVar.xj(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.pl.w("TTAdNativeImpl", "reward  component maybe not exist, pls check1", th);
                }
            }
        };
        if (!v.xj) {
            com.bytedance.sdk.component.utils.pl.u("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            cVar.xj(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            xj(dVar, 7);
            com.bytedance.sdk.openadsdk.core.y.xj.w().xj(7, hfVar);
        }
    }

    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u uVar) {
        if (!com.bytedance.sdk.openadsdk.core.j.d.xj()) {
            uVar.xj(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.tf.d dVar = new com.bytedance.sdk.component.tf.d("loadFullScreenVideoAd") { // from class: com.bytedance.sdk.openadsdk.core.z.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.reward.xj.hf.xj().xj(hfVar, new com.bytedance.sdk.openadsdk.core.component.reward.xj.u(uVar));
                } catch (Throwable th) {
                    uVar.xj(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.pl.hf("TTAdNativeImpl", "reward component maybe not exist, pls check2", th);
                }
            }
        };
        if (!v.xj) {
            com.bytedance.sdk.component.utils.pl.u("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            uVar.xj(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            xj(dVar, 8);
            com.bytedance.sdk.openadsdk.core.y.xj.w().xj(8, hfVar);
        }
    }

    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final com.bytedance.sdk.openadsdk.jk.xj.hf.xj.y yVar) {
        if (!com.bytedance.sdk.openadsdk.core.j.d.xj()) {
            yVar.xj(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.tf.d dVar = new com.bytedance.sdk.component.tf.d("loadNativeExpressAd") { // from class: com.bytedance.sdk.openadsdk.core.z.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (z.this.xj(hfVar, false)) {
                        com.bytedance.sdk.openadsdk.core.component.w.xj.hf().xj(hfVar, yVar, currentTimeMillis);
                    } else {
                        yVar.xj(110, c.xj(110));
                    }
                } catch (Throwable th) {
                    yVar.xj(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.pl.w("TTAdNativeImpl", "Error msg = ", th);
                }
            }
        };
        if (!v.xj) {
            com.bytedance.sdk.component.utils.pl.u("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            yVar.xj(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            xj(dVar, 5);
            com.bytedance.sdk.openadsdk.core.y.xj.w().xj(5, hfVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        com.bytedance.sdk.component.utils.zg.xj(hfVar.y() > 0, "必须设置图片素材尺寸");
        com.bytedance.sdk.component.utils.zg.xj(hfVar.c() > 0, "必须设置图片素材尺寸");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, boolean z) {
        if (hfVar == null) {
            return false;
        }
        return (z && !pz.hf().tf(hfVar.u())) || hfVar.f() > 0.0f;
    }

    private boolean xj() {
        return AdSdkInitializerHolder.isSdkInitSuccess();
    }

    private void xj(com.bytedance.sdk.component.tf.d dVar, int i) {
        if (xj()) {
            com.bytedance.sdk.component.tf.c.kd(dVar);
        } else {
            com.bytedance.sdk.component.tf.p.hf.pl().execute(dVar);
        }
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            com.bytedance.sdk.component.utils.pl.w("apply->load with null ->SparseArray");
            return null;
        }
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        int intValue = ADYaiT2.intValue(-99999982, 0);
        Function<SparseArray<Object>, Object> AYUAbz2 = AaHO0E.AYUAbz(ADYaiT2.objectValue(1, AaHO0E.ARc23Z()));
        if (AYUAbz2 == null) {
            com.bytedance.sdk.component.utils.pl.w("apply->load with null callback");
            return null;
        }
        xj(intValue, ADYaiT2, AYUAbz2);
        return null;
    }

    public void xj(int i, PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        AYUAbz A5SV6n2 = AYUAbz.A5SV6n(pluginValueSet);
        A5SV6n2.AMqCpz(1, 0);
        ASJ6gh A2egSU2 = A5SV6n2.A2egSU();
        if (i == 1) {
            if (A2egSU2.booleanValue(2, false)) {
                c(A2egSU2, function);
                return;
            } else {
                w(A2egSU2, function);
                return;
            }
        }
        if (i != 3) {
            switch (i) {
                case 5:
                    if (A2egSU2.booleanValue(2, false)) {
                        kd(A2egSU2, function);
                        break;
                    } else {
                        f(A2egSU2, function);
                        break;
                    }
                case 6:
                    xj(A2egSU2, function);
                    break;
                case 7:
                    d(A2egSU2, function);
                    break;
                case 8:
                    u(A2egSU2, function);
                    break;
                case 9:
                    if (A2egSU2.booleanValue(2, false)) {
                        y(A2egSU2, function);
                        break;
                    } else {
                        hf(A2egSU2, function);
                        break;
                    }
            }
            return;
        }
        xj(A2egSU2, function, A2egSU2.intValue(3, 0));
    }
}
