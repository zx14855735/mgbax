package com.bytedance.msdk.core.xj.xj.hf.xj.xj;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends com.bytedance.msdk.hf.w {
    private Function<SparseArray<Object>, Object> d;
    private com.bytedance.msdk.core.xj.xj.hf.xj p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.msdk.api.xj.hf f10141pl;
    private tf tf;

    public u(com.bytedance.msdk.core.xj.xj.hf.xj xjVar, Function<SparseArray<Object>, Object> function) {
        this.d = function;
        this.p = xjVar;
        this.tf = xjVar.hf;
        this.f10141pl = xjVar.xj;
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
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40015, sparseArray, -99999987, -99999985, Map.class);
        apply = this.d.apply(sparseArray);
        return (!(apply instanceof Map) || (obj = ((Map) apply).get(PointParamKey.REQUEST_ID)) == null) ? "" : obj.toString();
    }

    private String ct() {
        try {
            String str = (String) y.xj(new Callable<String>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.u.2
                @Override // java.util.concurrent.Callable
                public String call() {
                    return u.this.it();
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
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40013, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(50007, Integer.valueOf(i));
            this.d.apply(sparseArray);
        }
    }

    private void et(int i) {
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40007, sparseArray, -99999987, -99999985, Boolean.class);
            sparseArray.put(50007, Integer.valueOf(i));
            this.d.apply(sparseArray);
        }
    }

    private boolean fc() {
        Object apply;
        if (this.d == null) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40012, sparseArray, -99999987, -99999985, Boolean.class);
        apply = this.d.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    private String ha() {
        Object apply;
        if (this.d == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40004, sparseArray, -99999987, -99999985, String.class);
        apply = this.d.apply(sparseArray);
        return (String) apply;
    }

    private int hx() {
        try {
            Integer num = (Integer) y.xj(new Callable<Integer>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.u.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return Integer.valueOf(u.this.o());
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
    public String it() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? ha() : ct();
    }

    private int jb() {
        Object apply;
        if (this.d == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40021, sparseArray, -99999987, -99999985, Integer.class);
        apply = this.d.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    private void jq() {
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40022, sparseArray, -99999987, -99999985, Void.class);
            this.d.apply(sparseArray);
        }
    }

    private com.bytedance.msdk.api.u.xj.xj.xj js() {
        return (com.bytedance.msdk.api.u.xj.xj.xj) this.c;
    }

    private void ka() {
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40009, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(50009, this);
            this.d.apply(sparseArray);
        }
    }

    private String mq() {
        Object apply;
        if (this.d == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40033, sparseArray, -99999987, -99999985, String.class);
        apply = this.d.apply(sparseArray);
        return (String) apply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nu() {
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40011, sparseArray, -99999987, -99999985, Void.class);
            this.d.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o() {
        Object apply;
        if (this.d == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40003, sparseArray, -99999987, -99999985, Integer.class);
        apply = this.d.apply(sparseArray);
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
    public void oe() {
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40034, sparseArray, -99999987, -99999985, Boolean.class);
            this.d.apply(sparseArray);
        }
    }

    private View ps() {
        Object apply;
        if (this.d == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40035, sparseArray, -99999987, -99999985, View.class);
        apply = this.d.apply(sparseArray);
        if (apply != null) {
            return (View) apply;
        }
        return null;
    }

    private String qa() {
        try {
            return (String) y.xj(new Callable<String>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.u.6
                @Override // java.util.concurrent.Callable
                public String call() {
                    return u.this.az();
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
        return (xjVar == null || !xjVar.w()) ? o() : hx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Map<String, Object> map) {
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40014, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(50010, map);
            this.d.apply(sparseArray);
        }
    }

    private String zf() {
        Object apply;
        if (this.d == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40032, sparseArray, -99999987, -99999985, String.class);
        apply = this.d.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.msdk.hf.w, com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60009) {
            if (this.c instanceof com.bytedance.msdk.api.u.xj.xj.xj) {
                js().hf(null);
            }
        } else if (i == 60004) {
            if (this.c instanceof com.bytedance.msdk.api.u.xj.xj.xj) {
                js().xj((View) null);
            }
        } else if (i == 60006 && (this.c instanceof com.bytedance.msdk.api.u.xj.xj.xj)) {
            com.bytedance.msdk.api.xj.hf hfVar = this.f10141pl;
            if (hfVar != null) {
                com.bytedance.msdk.core.hf.xj.xj(hfVar.ra());
            }
            js().f_();
        }
        return null;
    }

    @Override // com.bytedance.msdk.hf.w
    public View d() {
        tf tfVar = this.tf;
        if (tfVar != null && tfVar.z()) {
            et(o());
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
            y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.u.7
                @Override // java.lang.Runnable
                public void run() {
                    u.this.oe();
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
            y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.u.3
                @Override // java.lang.Runnable
                public void run() {
                    u.this.nu();
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
                y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.u.4
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.dk(da);
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
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40012, sparseArray, -99999987, -99999985, Boolean.class);
        apply = this.d.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(final Map<String, Object> map) {
        tf tfVar = this.tf;
        if (tfVar == null || !tfVar.j() || map == null) {
            return;
        }
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar != null && xjVar.w()) {
            y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.u.5
                @Override // java.lang.Runnable
                public void run() {
                    u.this.y((Map<String, Object>) map);
                }
            });
        } else {
            y(map);
        }
    }
}
