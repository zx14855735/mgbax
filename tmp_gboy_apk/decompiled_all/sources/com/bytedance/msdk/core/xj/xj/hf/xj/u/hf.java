package com.bytedance.msdk.core.xj.xj.hf.xj.u;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.hf.w;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.zg.u;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends w {
    private Function<SparseArray<Object>, Object> d;
    private com.bytedance.msdk.core.xj.xj.hf.xj p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.msdk.api.xj.hf f10137pl;
    private tf tf;

    public hf(com.bytedance.msdk.core.xj.xj.hf.xj xjVar, Function<SparseArray<Object>, Object> function) {
        this.d = function;
        this.p = xjVar;
        this.tf = xjVar.hf;
        this.f10137pl = xjVar.xj;
        jb();
        tf tfVar = this.tf;
        if (tfVar != null) {
            if (tfVar.j()) {
                xj(ka());
            } else if (this.tf.l()) {
                am(hx());
            }
        }
        if (jq() == 2) {
            p(5);
            zf();
            mq();
        }
    }

    private String az() {
        try {
            return (String) y.xj(new Callable<String>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.u.hf.8
                @Override // java.util.concurrent.Callable
                public String call() {
                    return hf.this.fc();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            pl.xj(th);
            return null;
        }
    }

    private String ct() {
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
    public void dk(int i) {
        if (this.d != null) {
            this.d.apply(A2egSU.AZOQYO(40013, Void.class).xj(50007, Integer.valueOf(i)).hf());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fc() {
        Object apply;
        Object obj;
        if (this.d == null) {
            return "";
        }
        apply = this.d.apply(A2egSU.ARc23Z(40015, Map.class));
        return (!(apply instanceof Map) || (obj = ((Map) apply).get(PointParamKey.REQUEST_ID)) == null) ? "" : obj.toString();
    }

    private Integer ha() {
        try {
            Integer num = (Integer) y.xj(new Callable<Integer>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.u.hf.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return hf.this.nu();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (num != null) {
                return num;
            }
            return 4;
        } catch (Exception e) {
            pl.xj(e);
            return 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hx() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? ct() : it();
    }

    private String it() {
        try {
            String str = (String) y.xj(new Callable<String>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.u.hf.2
                @Override // java.util.concurrent.Callable
                public String call() {
                    return hf.this.hx();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            pl.xj(e);
            return "";
        }
    }

    private void jb() {
        if (this.d != null) {
            this.d.apply(u.xj().xj(40009).xj(50009, this).xj(Void.class).hf());
        }
    }

    private int jq() {
        Object apply;
        if (this.d == null) {
            return 0;
        }
        apply = this.d.apply(A2egSU.ARc23Z(40021, Void.class));
        if (apply instanceof Integer) {
            return ((Integer) apply).intValue();
        }
        return 0;
    }

    private double ka() {
        if (this.d == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? rx() : o();
    }

    private void mq() {
        if (this.d != null) {
            this.d.apply(A2egSU.ARc23Z(40023, Void.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer nu() {
        Object apply;
        if (this.d != null) {
            apply = this.d.apply(A2egSU.ARc23Z(40010, Boolean.class));
            if ((apply instanceof Boolean) && ((Boolean) apply).booleanValue()) {
                return 2;
            }
        }
        return 4;
    }

    private int o() {
        try {
            Integer num = (Integer) y.xj(new Callable<Integer>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.u.hf.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return Integer.valueOf(hf.this.rx());
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

    private com.bytedance.msdk.api.u.xj.u.xj oe() {
        return (com.bytedance.msdk.api.u.xj.u.xj) this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa() {
        if (this.d != null) {
            this.d.apply(A2egSU.ARc23Z(40011, Void.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rx() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function != null) {
            apply = function.apply(u.xj().xj(40003).xj(Integer.class).hf());
            int intValue = apply instanceof Integer ? ((Integer) apply).intValue() : 0;
            if (intValue != -1) {
                return intValue;
            }
        }
        return 0;
    }

    private void zf() {
        if (this.d != null) {
            this.d.apply(A2egSU.ARc23Z(40022, Void.class));
        }
    }

    @Override // com.bytedance.msdk.hf.w, com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        return (T) call(i, pluginValueSet, cls);
    }

    public <T> T call(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60009) {
            if (oe() == null) {
                return null;
            }
            oe().g_();
            return null;
        }
        if (i == 60004) {
            if (oe() == null) {
                return null;
            }
            oe().h_();
            return null;
        }
        if (i == 60005) {
            if (oe() == null) {
                return null;
            }
            oe().u();
            return null;
        }
        if (i == 60006) {
            if (oe() == null) {
                return null;
            }
            oe().w();
            return null;
        }
        if (i == 60010) {
            if (oe() == null) {
                return null;
            }
            oe().kd();
            return null;
        }
        if (i != 60007) {
            return null;
        }
        Map map = (Map) pluginValueSet.objectValue(50010, Map.class);
        if (oe() == null) {
            return null;
        }
        final HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        oe().xj(new com.bytedance.msdk.api.w.xj() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.u.hf.9
            @Override // com.bytedance.msdk.api.w.xj
            public float hf() {
                if (hf.this.f10137pl != null) {
                    return hf.this.f10137pl.z();
                }
                return 0.0f;
            }

            @Override // com.bytedance.msdk.api.w.xj
            public Map<String, Object> u() {
                return hashMap;
            }

            @Override // com.bytedance.msdk.api.w.xj
            public String w() {
                return hf.this.f10137pl != null ? hf.this.f10137pl.q() : "";
            }

            @Override // com.bytedance.msdk.api.w.xj
            public boolean xj() {
                return true;
            }
        });
        return null;
    }

    @Override // com.bytedance.msdk.hf.w
    public boolean ew() {
        return true;
    }

    @Override // com.bytedance.msdk.hf.w
    public String ir() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? fc() : az();
    }

    @Override // com.bytedance.msdk.hf.w
    public void yo() {
        super.yo();
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar == null || !xjVar.w()) {
            qa();
        } else {
            y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.u.hf.5
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.qa();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Activity activity) {
        w(activity);
    }

    private void w(Activity activity) {
        Function<SparseArray<Object>, Object> function = this.d;
        if (function != null) {
            function.apply(u.xj().xj(40008).xj(50008, activity).xj(String.class).hf());
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
                y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.u.hf.6
                    @Override // java.lang.Runnable
                    public void run() {
                        hf.this.dk(da);
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
    public Integer y() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? nu() : ha();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Map<String, Object> map) {
        if (this.d != null) {
            this.d.apply(u.xj().xj(40014).xj(Void.class).xj(50010, map).hf());
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(final Activity activity, Object obj, String str) {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar != null && xjVar.w()) {
            y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.u.hf.3
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.u(activity);
                }
            });
        } else {
            u(activity);
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(final Map<String, Object> map) {
        tf tfVar = this.tf;
        if (tfVar == null || !tfVar.j() || map == null) {
            return;
        }
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar != null && xjVar.w()) {
            y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.u.hf.7
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.y((Map<String, Object>) map);
                }
            });
        } else {
            y(map);
        }
    }
}
