package com.bytedance.msdk.core.xj.xj.hf.xj.kd;

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
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends w {
    private Function<SparseArray<Object>, Object> d;
    private com.bytedance.msdk.core.xj.xj.hf.xj p;
    private tf tf;

    public hf(com.bytedance.msdk.core.xj.xj.hf.xj xjVar, Function<SparseArray<Object>, Object> function) {
        this.d = function;
        this.p = xjVar;
        this.tf = xjVar.hf;
        zf();
        tf tfVar = this.tf;
        if (tfVar != null) {
            if (tfVar.j()) {
                xj(jq());
            } else if (this.tf.l()) {
                am(rx());
            }
        }
        if (mq() == 2) {
            p(5);
        } else {
            p(3);
        }
    }

    private com.bytedance.msdk.api.u.xj.kd.xj az() {
        return (com.bytedance.msdk.api.u.xj.kd.xj) this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer ct() {
        Object apply;
        if (this.d != null) {
            apply = this.d.apply(A2egSU.ARc23Z(40010, Boolean.class));
            if ((apply instanceof Boolean) && ((Boolean) apply).booleanValue()) {
                return 2;
            }
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(int i) {
        if (this.d != null) {
            this.d.apply(A2egSU.AZOQYO(40013, Void.class).xj(50007, Integer.valueOf(i)).hf());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha() {
        if (this.d != null) {
            this.d.apply(A2egSU.ARc23Z(40011, Void.class));
        }
    }

    private String hx() {
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

    private Integer it() {
        try {
            Integer num = (Integer) y.xj(new Callable<Integer>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.kd.hf.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return hf.this.ct();
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
    public int jb() {
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

    private double jq() {
        if (this.d == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? jb() : ka();
    }

    private int ka() {
        try {
            Integer num = (Integer) y.xj(new Callable<Integer>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.kd.hf.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return Integer.valueOf(hf.this.jb());
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

    private int mq() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return 0;
        }
        apply = function.apply(u.xj().xj(40021).xj(Integer.class).hf());
        if (apply instanceof Integer) {
            return ((Integer) apply).intValue();
        }
        return 0;
    }

    private String nu() {
        try {
            return (String) y.xj(new Callable<String>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.kd.hf.8
                @Override // java.util.concurrent.Callable
                public String call() {
                    return hf.this.qa();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            pl.xj(th);
            return null;
        }
    }

    private String o() {
        try {
            String str = (String) y.xj(new Callable<String>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.kd.hf.2
                @Override // java.util.concurrent.Callable
                public String call() {
                    return hf.this.rx();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            pl.xj(e);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String qa() {
        Object apply;
        Object obj;
        if (this.d == null) {
            return "";
        }
        apply = this.d.apply(A2egSU.ARc23Z(40015, Map.class));
        return (!(apply instanceof Map) || (obj = ((Map) apply).get(PointParamKey.REQUEST_ID)) == null) ? "" : obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String rx() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? hx() : o();
    }

    private void zf() {
        Function<SparseArray<Object>, Object> function = this.d;
        if (function != null) {
            function.apply(u.xj().xj(40009).xj(50009, this).xj(Integer.class).hf());
        }
    }

    @Override // com.bytedance.msdk.hf.w, com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60011) {
            if (az() == null) {
                return null;
            }
            az().u();
            return null;
        }
        if (i == 60009) {
            if (az() == null) {
                return null;
            }
            az().xj();
            return null;
        }
        if (i == 60004) {
            if (az() == null) {
                return null;
            }
            az().hf();
            return null;
        }
        if (i == 60012) {
            if (az() == null) {
                return null;
            }
            az().kd();
            return null;
        }
        if (i != 60006 || az() == null) {
            return null;
        }
        az().w();
        return null;
    }

    @Override // com.bytedance.msdk.hf.w
    public boolean ew() {
        return true;
    }

    @Override // com.bytedance.msdk.hf.w
    public String ir() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? qa() : nu();
    }

    @Override // com.bytedance.msdk.hf.w
    public Integer y() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? ct() : it();
    }

    @Override // com.bytedance.msdk.hf.w
    public void yo() {
        super.yo();
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar == null || !xjVar.w()) {
            ha();
        } else {
            y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.kd.hf.5
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.ha();
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
            function.apply(u.xj().xj(40008).xj(50008, activity).xj(Void.class).hf());
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
                y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.kd.hf.6
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

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Map<String, Object> map) {
        if (this.d != null) {
            this.d.apply(u.xj().xj(40014).xj(Void.class).xj(50010, map).hf());
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(final Activity activity, Object obj, String str) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar != null && xjVar.w()) {
            y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.kd.hf.3
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
            y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.kd.hf.7
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
