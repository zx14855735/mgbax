package com.bytedance.msdk.w.w.hf.xj.xj;

import P8ccfD.AaHO0E;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.xj.hf.hf.xj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class hf extends com.bytedance.msdk.w.w.hf.xj.hf {
    protected int c;
    private String d;
    protected int f;
    protected com.bytedance.msdk.api.u.xj.hf.w.w hf;
    protected Map<String, Object> kd;
    private com.bytedance.msdk.api.xj.hf p;
    private String tf;
    protected com.bytedance.msdk.w.y.hf.hf u;
    protected Function<SparseArray<Object>, Object> w;
    protected boolean y;

    public hf(String str, com.bytedance.msdk.w.xj.hf hfVar) {
        super(hfVar);
        this.kd = new ConcurrentHashMap();
        this.y = false;
        this.c = 0;
        this.f = 0;
        this.tf = str;
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.hf, com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8221) {
            this.w = AaHO0E.AYUAbz(pluginValueSet.objectValue(8405, AaHO0E.ARc23Z()));
        } else {
            if (i == 8137) {
                T t = (T) c();
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom loader : getAdm = ".concat(String.valueOf(t)));
                return t;
            }
            if (i == 8224) {
                T t2 = (T) f();
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom loader : getExtraDataNoParse = ".concat(String.valueOf(t2)));
                return t2;
            }
            if (i == 8226) {
                T t3 = (T) Integer.valueOf(d());
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom loader : getBiddingType = ".concat(String.valueOf(t3)));
                return t3;
            }
            if (i == 8227 && pluginValueSet != null) {
                Map<String, Object> map = (Map) pluginValueSet.objectValue(8075, Map.class);
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom loader : setExtraInfo map =".concat(String.valueOf(map)));
                xj(map);
            }
        }
        return (T) xj(i, pluginValueSet, cls);
    }

    public String c() {
        com.bytedance.msdk.w.y.hf.hf hfVar = this.u;
        return hfVar != null ? hfVar.et() : "";
    }

    public int d() {
        com.bytedance.msdk.w.y.hf.hf hfVar = this.u;
        if (hfVar != null) {
            return hfVar.v();
        }
        return 0;
    }

    public Object f() {
        com.bytedance.msdk.w.y.hf.hf hfVar = this.u;
        return hfVar != null ? hfVar.a() : "";
    }

    public void g() {
        if (this.w != null) {
            this.w.apply(A2egSU.ARc23Z(8109, Void.class));
        }
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.hf
    public final void hf(Context context, com.bytedance.msdk.w.y.hf.hf hfVar, com.bytedance.msdk.api.xj.hf hfVar2, Map<String, Object> map) {
        this.u = hfVar;
        this.p = hfVar2;
        this.hf = new com.bytedance.msdk.api.u.xj.hf.w.w(hfVar.ht(), hfVar.pl(), hfVar.am(), hfVar.qt(), hfVar.ff());
        com.bytedance.msdk.api.u.xj.hf.y.xj xj = com.bytedance.msdk.y.hf.xj.xj(hfVar.g());
        this.d = xj != null ? xj.w() : "";
        com.bytedance.sdk.openadsdk.zg.u xj2 = com.bytedance.sdk.openadsdk.zg.u.xj();
        xj2.xj(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, this);
        if (com.bytedance.sdk.gromore.init.xj.xj() >= 5900) {
            xj2.xj(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.bytedance.msdk.xj.kd.xj.xj(context));
        } else {
            xj2.xj(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context);
        }
        xj2.xj(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, this.tf);
        xj2.xj(8546, com.bytedance.sdk.openadsdk.zg.w.u.xj(this.hf.xj()));
        if (hfVar2.b() != null) {
            xj2.xj(8548, com.bytedance.sdk.openadsdk.zg.w.u.xj(hfVar2.b()));
        }
        Function<SparseArray<Object>, Object> c = com.bytedance.msdk.core.p.xj.xj().c();
        if (c == null) {
            xj(new com.bytedance.msdk.api.xj("Adn custom class loader is null"));
            return;
        }
        xj2.xj(Void.class);
        xj2.xj(8106);
        c.apply(xj2.hf());
    }

    public void p() {
        if (this.w != null) {
            this.w.apply(A2egSU.ARc23Z(8149, Void.class));
        }
    }

    public void pl() {
        if (this.w != null) {
            this.w.apply(A2egSU.ARc23Z(8148, Void.class));
        }
    }

    public Integer tf() {
        Object apply;
        if (this.w != null) {
            apply = this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8121).xj(Object.class).xj(20068, 1).hf());
            Integer xj = com.bytedance.sdk.openadsdk.core.wo.xj.xj.xj(apply);
            if (xj != null) {
                return xj;
            }
        }
        return 1;
    }

    public final void w(xj.InterfaceC0050xj interfaceC0050xj) {
        int i = this.f;
        if (i >= 60) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "自定义Adapter click方法回调次数需要小于60次");
            return;
        }
        this.f = i + 1;
        if (interfaceC0050xj != null) {
            interfaceC0050xj.xj();
        }
    }

    public abstract <T> T xj(int i, PluginValueSet pluginValueSet, Class<T> cls);

    public void xj(int i, String str) {
        xj(new com.bytedance.msdk.api.xj(i, str));
    }

    public void y() {
        this.y = true;
    }

    @Override // com.bytedance.msdk.w.xj.xj
    public String xj(String str) {
        return this.d;
    }

    public void xj(Map<String, Object> map) {
        if (map != null) {
            this.kd.clear();
            this.kd.putAll(map);
        }
    }

    public void xj(boolean z, double d, int i, Map<String, Object> map) {
        if (this.w != null) {
            this.w.apply(A2egSU.AZOQYO(8225, Void.class).xj(8406, Boolean.valueOf(z)).xj(8407, Double.valueOf(d)).xj(8408, Integer.valueOf(i)).xj(8075, map).hf());
        }
    }

    public final void xj(xj.InterfaceC0050xj interfaceC0050xj) {
        if (!hf()) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "自定义Adapter 调用错误需要在load成功之后才可以调用");
        } else if (interfaceC0050xj != null) {
            interfaceC0050xj.xj();
        }
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.hf
    public void xj(com.bytedance.msdk.hf.w wVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(wVar);
        xj(arrayList);
    }

    public void xj(com.bytedance.msdk.hf.w wVar, double d, Map<String, Object> map) {
        if (d > 0.0d && d() == 1) {
            wVar.xj(d);
        }
        if (map != null) {
            this.kd.putAll(map);
        }
        wVar.u(this.kd);
        xj(wVar);
    }

    public final void hf(xj.InterfaceC0050xj interfaceC0050xj) {
        if (this.y) {
            int i = this.c;
            if (i < 2) {
                this.c = i + 1;
                if (interfaceC0050xj != null) {
                    interfaceC0050xj.xj();
                    return;
                }
                return;
            }
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "自定义Adapter show方法回调次数需要小于2次");
            return;
        }
        com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "自定义Adapter show方法回调必须由GroMore触发show时才会生效");
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.hf, com.bytedance.msdk.w.xj.hf
    public void xj(List<com.bytedance.msdk.hf.w> list) {
        for (com.bytedance.msdk.hf.w wVar : list) {
            wVar.w(this.kd);
            wVar.am(this.u.io());
        }
        super.xj(list);
    }
}
