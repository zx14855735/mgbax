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
public class hf extends com.bytedance.msdk.hf.w {
    private Function<SparseArray<Object>, Object> d;
    private volatile boolean g = false;
    private com.bytedance.msdk.core.xj.xj.hf.xj p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.msdk.api.xj.hf f10140pl;
    private tf tf;

    public hf(com.bytedance.msdk.core.xj.xj.hf.xj xjVar, Function<SparseArray<Object>, Object> function) {
        this.d = function;
        this.p = xjVar;
        this.tf = xjVar.hf;
        this.f10140pl = xjVar.xj;
        mq();
        tf tfVar = this.tf;
        if (tfVar != null) {
            if (tfVar.j()) {
                xj(zf());
            } else if (this.tf.l()) {
                am(ka());
            }
        }
    }

    private View az() {
        Object apply;
        if (this.d == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40035, sparseArray, -99999987, -99999985, View.class);
        apply = this.d.apply(sparseArray);
        if (apply instanceof View) {
            return (View) apply;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct() {
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40011, sparseArray, -99999987, -99999985, Void.class);
            this.d.apply(sparseArray);
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

    private String ha() {
        try {
            return (String) y.xj(new Callable<String>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.hf.7
                @Override // java.util.concurrent.Callable
                public String call() {
                    return hf.this.nu();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    private Integer hx() {
        try {
            Integer num = (Integer) y.xj(new Callable<Integer>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.hf.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return hf.this.it();
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
    public Integer it() {
        Object apply;
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40010, sparseArray, -99999987, -99999985, Boolean.class);
            apply = this.d.apply(sparseArray);
            if (((Boolean) apply).booleanValue()) {
                return 2;
            }
        }
        return 4;
    }

    private int jb() {
        try {
            Integer num = (Integer) y.xj(new Callable<Integer>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.hf.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return Integer.valueOf(hf.this.jq());
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
    public int jq() {
        Object apply;
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40003, sparseArray, -99999987, -99999985, Integer.class);
            apply = this.d.apply(sparseArray);
            int intValue = apply instanceof Integer ? ((Integer) apply).intValue() : 0;
            if (intValue != -1) {
                return intValue;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ka() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? o() : rx();
    }

    private void mq() {
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40009, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(50009, this);
            this.d.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String nu() {
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

    private String o() {
        Object apply;
        if (this.d == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40004, sparseArray, -99999987, -99999985, String.class);
        apply = this.d.apply(sparseArray);
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private com.bytedance.msdk.api.u.xj.xj.xj qa() {
        return (com.bytedance.msdk.api.u.xj.xj.xj) this.c;
    }

    private String rx() {
        try {
            String str = (String) y.xj(new Callable<String>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.hf.2
                @Override // java.util.concurrent.Callable
                public String call() {
                    return hf.this.ka();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            pl.xj(e);
            return "";
        }
    }

    private double zf() {
        if (this.d == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? jq() : jb();
    }

    @Override // com.bytedance.msdk.hf.w, com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60009) {
            if (this.c instanceof com.bytedance.msdk.api.u.xj.xj.xj) {
                qa().hf(null);
            }
        } else if (i == 60006) {
            if (this.c instanceof com.bytedance.msdk.api.u.xj.xj.xj) {
                com.bytedance.msdk.api.xj.hf hfVar = this.f10140pl;
                if (hfVar != null) {
                    com.bytedance.msdk.core.hf.xj.xj(hfVar.ra());
                }
                qa().f_();
            }
        } else if (i == 60004 && (this.c instanceof com.bytedance.msdk.api.u.xj.xj.xj)) {
            qa().xj((View) null);
        }
        return null;
    }

    @Override // com.bytedance.msdk.hf.w
    public View d() {
        return az();
    }

    @Override // com.bytedance.msdk.hf.w
    public String ir() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? nu() : ha();
    }

    @Override // com.bytedance.msdk.hf.w
    public Integer y() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? it() : hx();
    }

    @Override // com.bytedance.msdk.hf.w
    public void yo() {
        super.yo();
        this.g = true;
        y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.hf.4
            @Override // java.lang.Runnable
            public void run() {
                hf.this.ct();
            }
        });
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
                y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.hf.5
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
        return this.g;
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

    @Override // com.bytedance.msdk.hf.w
    public void xj(final Map<String, Object> map) {
        tf tfVar = this.tf;
        if (tfVar == null || !tfVar.j() || map == null) {
            return;
        }
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar != null && xjVar.w()) {
            y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.hf.6
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
