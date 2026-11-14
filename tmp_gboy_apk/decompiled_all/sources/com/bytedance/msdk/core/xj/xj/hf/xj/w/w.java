package com.bytedance.msdk.core.xj.xj.hf.xj.w;

import P8ccfD.AaHO0E;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.xj.c.f;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.zg.u;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends com.bytedance.msdk.hf.w {
    private Function<SparseArray<Object>, Object> d;
    private com.bytedance.msdk.core.xj.xj.hf.xj p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.msdk.api.xj.hf f10139pl;
    private tf tf;

    public w(com.bytedance.msdk.core.xj.xj.hf.xj xjVar, Function<SparseArray<Object>, Object> function) {
        this.d = function;
        this.p = xjVar;
        this.tf = xjVar.hf;
        this.f10139pl = xjVar.xj;
        ka();
        if (jb() == 2) {
            p(5);
            jq();
        } else if (jb() == 1 || jb() == 4) {
            p(3);
        } else if (jb() == 3) {
            p(4);
        } else {
            p(3);
        }
        c(true);
        j(zf());
        en(mq());
        pl(3);
        tf tfVar = this.tf;
        if (tfVar != null) {
            if (tfVar.j()) {
                xj(rx());
            } else if (this.tf.l()) {
                am(it());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String az() {
        Object apply;
        Object obj;
        if (this.d == null) {
            return "";
        }
        apply = this.d.apply(A2egSU.ARc23Z(40015, Map.class));
        return (!(apply instanceof Map) || (obj = ((Map) apply).get(PointParamKey.REQUEST_ID)) == null) ? "" : obj.toString();
    }

    private String ct() {
        try {
            String str = (String) y.xj(new Callable<String>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.w.2
                @Override // java.util.concurrent.Callable
                public String call() {
                    return w.this.it();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            pl.xj(e);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(int i) {
        if (this.d != null) {
            this.d.apply(A2egSU.AZOQYO(40013, Void.class).xj(50007, Integer.valueOf(i)).hf());
        }
    }

    private void et(int i) {
        if (this.d != null) {
            this.d.apply(u.xj().xj(40007).xj(50007, Integer.valueOf(i)).xj(Void.class).hf());
        }
    }

    private boolean fc() {
        Object apply;
        if (this.d == null) {
            return false;
        }
        apply = this.d.apply(A2egSU.ARc23Z(40012, Boolean.class));
        return (apply instanceof Boolean) && ((Boolean) apply).booleanValue();
    }

    private String ha() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return "";
        }
        apply = function.apply(u.xj().xj(40004).xj(String.class).hf());
        if (apply instanceof String) {
            return apply.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hx() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return 0;
        }
        apply = function.apply(u.xj().xj(40003).xj(Integer.class).hf());
        if (!(apply instanceof Integer)) {
            return 0;
        }
        Integer num = (Integer) apply;
        if (num.intValue() != -1) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String it() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? ha() : ct();
    }

    private int jb() {
        Object apply;
        if (this.d == null) {
            return 0;
        }
        apply = this.d.apply(A2egSU.ARc23Z(40021, Integer.class));
        if (apply instanceof Integer) {
            return ((Integer) apply).intValue();
        }
        return 0;
    }

    private void jq() {
        if (this.d != null) {
            this.d.apply(A2egSU.ARc23Z(40022, Void.class));
        }
    }

    private void ka() {
        if (this.d != null) {
            this.d.apply(u.xj().xj(40009).xj(Void.class).xj(50009, this).hf());
        }
    }

    private String mq() {
        Object apply;
        if (this.d == null) {
            return "";
        }
        apply = this.d.apply(A2egSU.ARc23Z(40033, String.class));
        return apply instanceof String ? (String) apply : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nu() {
        if (this.d != null) {
            this.d.apply(A2egSU.ARc23Z(40011, Void.class));
        }
    }

    private int o() {
        try {
            Integer num = (Integer) y.xj(new Callable<Integer>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.w.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return Integer.valueOf(w.this.hx());
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        } catch (Exception e) {
            pl.xj(e);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oe() {
        if (this.d != null) {
            this.d.apply(A2egSU.ARc23Z(40034, Void.class));
        }
    }

    private View ps() {
        Object apply;
        if (this.d == null) {
            return null;
        }
        apply = this.d.apply(A2egSU.ARc23Z(40035, View.class));
        if (apply instanceof View) {
            return (View) apply;
        }
        return null;
    }

    private String qa() {
        try {
            return (String) y.xj(new Callable<String>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.w.6
                @Override // java.util.concurrent.Callable
                public String call() {
                    return w.this.az();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            pl.xj(th);
            return null;
        }
    }

    private double rx() {
        if (this.d == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? hx() : o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Map<String, Object> map) {
        if (this.d != null) {
            this.d.apply(u.xj().xj(40014).xj(Void.class).xj(50010, map).hf());
        }
    }

    private String zf() {
        Object apply;
        if (this.d == null) {
            return "";
        }
        apply = this.d.apply(A2egSU.ARc23Z(40032, String.class));
        return apply instanceof String ? (String) apply : "";
    }

    @Override // com.bytedance.msdk.hf.w, com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60016) {
            View view = (View) pluginValueSet.objectValue(8042, View.class);
            if (tj() == 5) {
                com.bytedance.msdk.api.u.xj.w.xj xjVar = this.y;
                if (xjVar instanceof com.bytedance.msdk.api.u.xj.w.u) {
                    ((com.bytedance.msdk.api.u.xj.w.u) xjVar).xj(view, "渲染失败", MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL);
                    return null;
                }
            } else {
                com.bytedance.msdk.api.u.xj.c.hf hfVar = this.xj;
                if (hfVar instanceof com.bytedance.msdk.api.u.xj.c.y) {
                    ((com.bytedance.msdk.api.u.xj.c.y) hfVar).xj(view, "渲染失败", MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL);
                    return null;
                }
            }
        } else if (i == 60017) {
            int intValue = pluginValueSet.intValue(50014);
            int intValue2 = pluginValueSet.intValue(50016);
            if (tj() == 5) {
                com.bytedance.msdk.api.u.xj.w.xj xjVar2 = this.y;
                if (xjVar2 instanceof com.bytedance.msdk.api.u.xj.w.u) {
                    ((com.bytedance.msdk.api.u.xj.w.u) xjVar2).xj(intValue, intValue2);
                    return null;
                }
            } else {
                com.bytedance.msdk.api.u.xj.c.hf hfVar2 = this.xj;
                if (hfVar2 instanceof com.bytedance.msdk.api.u.xj.c.y) {
                    ((com.bytedance.msdk.api.u.xj.c.y) hfVar2).xj(intValue, intValue2);
                    return null;
                }
            }
        } else if (i == 60009) {
            if (tj() == 5) {
                com.bytedance.msdk.api.u.xj.w.xj xjVar3 = this.y;
                if (xjVar3 != null) {
                    xjVar3.xj();
                    return null;
                }
            } else {
                com.bytedance.msdk.api.u.xj.c.hf hfVar3 = this.xj;
                if (hfVar3 != null) {
                    hfVar3.xj();
                    return null;
                }
            }
        } else if (i == 60004) {
            if (tj() == 5) {
                com.bytedance.msdk.api.u.xj.w.xj xjVar4 = this.y;
                if (xjVar4 != null) {
                    xjVar4.xj(null);
                    return null;
                }
            } else {
                com.bytedance.msdk.api.u.xj.c.hf hfVar4 = this.xj;
                if (hfVar4 != null) {
                    hfVar4.xj(null);
                    return null;
                }
            }
        } else if (i == 60005) {
            f fVar = this.hf;
            if (fVar != null) {
                fVar.kd();
                return null;
            }
        } else if (i == 60006) {
            com.bytedance.msdk.kd.y.xj(this, this.f10139pl, "gdt信息流模板dislike接口无关闭原因");
            com.bytedance.msdk.core.hf.xj.xj(this.f10139pl.ra());
            if (v() != null) {
                v().xj(-1, "gdt信息流模板dislike接口无关闭原因", false);
                return null;
            }
        } else if (i == 60010) {
            com.bytedance.msdk.core.xj.xj.hf.xj.y.hf hfVar5 = new com.bytedance.msdk.core.xj.xj.hf.xj.y.hf(AaHO0E.AYUAbz(pluginValueSet.objectValue(50006, AaHO0E.ARc23Z())));
            f fVar2 = this.hf;
            if (fVar2 != null) {
                fVar2.xj(new com.bytedance.msdk.api.xj(hfVar5.xj(), hfVar5.hf()));
            }
        }
        return null;
    }

    @Override // com.bytedance.msdk.hf.w
    public View d() {
        tf tfVar = this.tf;
        if (tfVar != null && tfVar.z()) {
            et(hx());
        }
        return ps();
    }

    @Override // com.bytedance.msdk.hf.w
    public boolean ew() {
        return fc();
    }

    @Override // com.bytedance.msdk.hf.w
    public String ir() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? az() : qa();
    }

    @Override // com.bytedance.msdk.hf.w
    public void p() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar == null || !xjVar.w()) {
            oe();
        } else {
            y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.w.7
                @Override // java.lang.Runnable
                public void run() {
                    w.this.oe();
                }
            });
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void yo() {
        super.yo();
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar == null || !xjVar.w()) {
            nu();
        } else {
            y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.w.3
                @Override // java.lang.Runnable
                public void run() {
                    w.this.nu();
                }
            });
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void hf(Map<String, Object> map) {
        tf tfVar = this.tf;
        if (tfVar != null && tfVar.j()) {
            final int da = (int) da();
            com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
            if (xjVar == null || !xjVar.w()) {
                dk(da);
            } else {
                y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.w.4
                    @Override // java.lang.Runnable
                    public void run() {
                        w.this.dk(da);
                    }
                });
            }
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public boolean kd() {
        Object apply;
        if (this.d == null) {
            return false;
        }
        apply = this.d.apply(A2egSU.ARc23Z(40012, Boolean.class));
        return (apply instanceof Boolean) && ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(final Map<String, Object> map) {
        tf tfVar = this.tf;
        if (tfVar == null || !tfVar.j() || map == null) {
            return;
        }
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar != null && xjVar.w()) {
            y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.w.5
                @Override // java.lang.Runnable
                public void run() {
                    w.this.y((Map<String, Object>) map);
                }
            });
        } else {
            y(map);
        }
    }
}
