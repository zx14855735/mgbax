package com.bytedance.msdk.core.xj.xj.hf.xj.w;

import P8ccfD.AaHO0E;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.xj.c.f;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.zg.u;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends com.bytedance.msdk.hf.w {
    private Function<SparseArray<Object>, Object> d;
    private Context g;
    private com.bytedance.msdk.core.xj.xj.hf.xj p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.msdk.api.xj.hf f10138pl;
    private tf tf;

    public hf(Context context, com.bytedance.msdk.core.xj.xj.hf.xj xjVar, Function<SparseArray<Object>, Object> function) {
        this.g = context;
        this.d = function;
        this.p = xjVar;
        this.tf = xjVar.hf;
        this.f10138pl = xjVar.xj;
        pn();
        ht(rq());
        ra(js());
        hf(ps());
        jk((int) ps());
        dk(oe());
        et(fc());
        io(az());
        pl(qa());
        j(nu());
        en(ha());
        q(ct());
        x(it());
        ai(hx());
        yo(o());
        yo(rx());
        xj(ka());
        u(jb());
        l(nu());
        f(jq());
        tf tfVar = this.tf;
        if (tfVar != null) {
            if (tfVar.j()) {
                xj(m4if());
            } else if (this.tf.l()) {
                am(ta());
            }
        }
        if (pu() == 2) {
            p(5);
        } else if (pu() == 1 || pu() == 4) {
            p(3);
        } else if (pu() == 3) {
            p(4);
        } else {
            p(3);
        }
        if (jq()) {
            pl(4);
        } else {
            pl(3);
        }
        c(false);
    }

    private String az() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return "";
        }
        apply = function.apply(u.xj().xj(40043).xj(String.class).hf());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co() {
        if (this.d != null) {
            this.d.apply(A2egSU.ARc23Z(40011, Void.class));
        }
    }

    private String ct() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return "";
        }
        apply = function.apply(u.xj().xj(40045).xj(String.class).hf());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private Integer dj() {
        try {
            Integer num = (Integer) y.xj(new Callable<Integer>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.hf.11
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return hf.this.ie();
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

    private void dk(int i) {
        if (this.d != null) {
            this.d.apply(u.xj().xj(40007).xj(50007, Integer.valueOf(i)).xj(Void.class).hf());
        }
    }

    private String eb() {
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
    public void et(int i) {
        if (this.d != null) {
            this.d.apply(A2egSU.AZOQYO(40013, Void.class).xj(50007, Integer.valueOf(i)).hf());
        }
    }

    private String fc() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return "";
        }
        apply = function.apply(u.xj().xj(40042).xj(String.class).hf());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private void fh() {
        Function<SparseArray<Object>, Object> function = this.d;
        if (function != null) {
            function.apply(u.xj().xj(40060).xj(Void.class).hf());
        }
    }

    private String ha() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return "";
        }
        apply = function.apply(u.xj().xj(40033).xj(String.class).hf());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private String hx() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return "";
        }
        apply = function.apply(u.xj().xj(40047).xj(String.class).hf());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer ie() {
        Object apply;
        if (this.d != null) {
            apply = this.d.apply(A2egSU.ARc23Z(40010, Boolean.class));
            if ((apply instanceof Boolean) && ((Boolean) apply).booleanValue()) {
                return 2;
            }
        }
        return 4;
    }

    /* renamed from: if, reason: not valid java name */
    private double m4if() {
        if (this.d == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? lp() : su();
    }

    private String it() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return "";
        }
        apply = function.apply(u.xj().xj(40046).xj(String.class).hf());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private double jb() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return 0.0d;
        }
        apply = function.apply(u.xj().xj(40051).xj(Integer.class).hf());
        if (apply instanceof Integer) {
            return ((Double) apply).doubleValue();
        }
        return 0.0d;
    }

    private boolean jq() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return false;
        }
        apply = function.apply(u.xj().xj(40052).xj(Boolean.class).hf());
        return (apply instanceof Boolean) && ((Boolean) apply).booleanValue();
    }

    private String js() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return "";
        }
        apply = function.apply(u.xj().xj(40039).xj(Long.class).hf());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private List<String> ka() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return null;
        }
        apply = function.apply(u.xj().xj(40050).xj(List.class).hf());
        if (apply instanceof List) {
            return (List) apply;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lp() {
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
    public void lt() {
        if (this.d != null) {
            this.d.apply(A2egSU.ARc23Z(40064, Void.class));
        }
    }

    private int mq() {
        try {
            Integer num = (Integer) y.xj(new Callable<Integer>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.hf.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return Integer.valueOf(hf.this.zf());
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (num != null) {
                return num.intValue();
            }
            return 1;
        } catch (Exception e) {
            pl.xj(e);
            return 1;
        }
    }

    private String nu() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return "";
        }
        apply = function.apply(u.xj().xj(40032).xj(String.class).hf());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private int o() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return 0;
        }
        apply = function.apply(u.xj().xj(40048).xj(Integer.class).hf());
        if (apply instanceof Integer) {
            return ((Integer) apply).intValue();
        }
        return 0;
    }

    private String oe() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return "";
        }
        apply = function.apply(u.xj().xj(40041).xj(String.class).hf());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void og() {
        if (this.d != null) {
            this.d.apply(A2egSU.ARc23Z(40061, Void.class));
        }
    }

    private void pn() {
        Function<SparseArray<Object>, Object> function = this.d;
        if (function != null) {
            function.apply(u.xj().xj(40009).xj(50009, this).xj(Integer.class).hf());
        }
    }

    private long ps() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return 0L;
        }
        apply = function.apply(u.xj().xj(40040).xj(Long.class).hf());
        if (apply instanceof Long) {
            return ((Long) apply).longValue();
        }
        return 0L;
    }

    private int pu() {
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

    private String qa() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return "";
        }
        apply = function.apply(u.xj().xj(40044).xj(String.class).hf());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    private String rq() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return "";
        }
        apply = function.apply(u.xj().xj(40038).xj(Long.class).hf());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rs() {
        if (this.d != null) {
            this.d.apply(A2egSU.ARc23Z(40062, Void.class));
        }
    }

    private int rx() {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null) {
            return 0;
        }
        apply = function.apply(u.xj().xj(40049).xj(Integer.class).hf());
        if (apply instanceof Integer) {
            return ((Integer) apply).intValue();
        }
        return 0;
    }

    private int su() {
        try {
            Integer num = (Integer) y.xj(new Callable<Integer>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.hf.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return Integer.valueOf(hf.this.lp());
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
    public String ta() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? eb() : xe();
    }

    private String xe() {
        try {
            String str = (String) y.xj(new Callable<String>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.hf.8
                @Override // java.util.concurrent.Callable
                public String call() {
                    return hf.this.ta();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            pl.xj(e);
            return "";
        }
    }

    private String xk() {
        try {
            return (String) y.xj(new Callable<String>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.hf.2
                @Override // java.util.concurrent.Callable
                public String call() {
                    return hf.this.xw();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            pl.xj(th);
            return null;
        }
    }

    private FrameLayout.LayoutParams xl() {
        com.bytedance.msdk.api.xj.hf hfVar = this.f10138pl;
        if (hfVar == null || hfVar.r() == null) {
            return null;
        }
        Object obj = this.f10138pl.r().get(MediationConstant.KEY_GDT_NATIVE_LOGO_PARAMS);
        if (obj instanceof FrameLayout.LayoutParams) {
            return (FrameLayout.LayoutParams) obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String xw() {
        Object apply;
        Object obj;
        if (this.d == null) {
            return "";
        }
        apply = this.d.apply(A2egSU.ARc23Z(40015, Map.class));
        return (!(apply instanceof Map) || (obj = ((Map) apply).get(PointParamKey.REQUEST_ID)) == null) ? "" : obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yq() {
        if (this.d != null) {
            this.d.apply(A2egSU.ARc23Z(40063, Void.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zf() {
        Object apply;
        if (this.d != null) {
            apply = this.d.apply(A2egSU.ARc23Z(40053, Void.class));
            int intValue = apply instanceof Integer ? ((Integer) apply).intValue() : -1;
            if (intValue == 0) {
                return 0;
            }
            if (intValue == 1) {
                return 6;
            }
            if (intValue == 2) {
                return 8;
            }
            if (intValue == 4) {
                return 2;
            }
            if (intValue == 8) {
                return 5;
            }
            if (intValue == 16) {
                return 4;
            }
            if (intValue == 32) {
                return 3;
            }
            if (intValue == 64) {
                return 7;
            }
        }
        return 1;
    }

    @Override // com.bytedance.msdk.hf.w, com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60018) {
            f fVar = this.hf;
            if (fVar != null) {
                fVar.hf();
                return null;
            }
        } else if (i == 60019) {
            f fVar2 = this.hf;
            if (fVar2 != null) {
                fVar2.w();
                return null;
            }
        } else if (i == 60020) {
            f fVar3 = this.hf;
            if (fVar3 != null) {
                fVar3.u();
                return null;
            }
        } else if (i == 60005) {
            f fVar4 = this.hf;
            if (fVar4 != null) {
                fVar4.kd();
                return null;
            }
        } else if (i == 60010) {
            com.bytedance.msdk.core.xj.xj.hf.xj.y.hf hfVar = new com.bytedance.msdk.core.xj.xj.hf.xj.y.hf(AaHO0E.AYUAbz(pluginValueSet.objectValue(50006, AaHO0E.ARc23Z())));
            f fVar5 = this.hf;
            if (fVar5 != null) {
                fVar5.xj(new com.bytedance.msdk.api.xj(hfVar.xj(), hfVar.hf()));
                return null;
            }
        } else if (i == 60004) {
            if (tj() == 5) {
                com.bytedance.msdk.api.u.xj.w.xj xjVar = this.y;
                if (xjVar != null) {
                    xjVar.xj(null);
                    return null;
                }
            } else {
                com.bytedance.msdk.api.u.xj.c.hf hfVar2 = this.xj;
                if (hfVar2 != null) {
                    hfVar2.xj(null);
                    return null;
                }
            }
        } else if (i == 60009) {
            if (tj() == 5) {
                com.bytedance.msdk.api.u.xj.w.xj xjVar2 = this.y;
                if (xjVar2 != null) {
                    xjVar2.xj();
                    return null;
                }
            } else {
                com.bytedance.msdk.api.u.xj.c.hf hfVar3 = this.xj;
                if (hfVar3 != null) {
                    hfVar3.xj();
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.msdk.hf.w
    public void e() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar == null || !xjVar.w()) {
            og();
        } else {
            y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.hf.3
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.og();
                }
            });
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public boolean ew() {
        return true;
    }

    @Override // com.bytedance.msdk.hf.w
    public String ir() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? xw() : xk();
    }

    @Override // com.bytedance.msdk.hf.w
    public void yo() {
        super.yo();
        y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.hf.12
            @Override // java.lang.Runnable
            public void run() {
                hf.this.co();
            }
        });
    }

    @Override // com.bytedance.msdk.hf.w
    public void zg() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar == null || !xjVar.w()) {
            rs();
        } else {
            y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.hf.4
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.rs();
                }
            });
        }
    }

    private void hf(List<View> list) {
        if (TextUtils.isEmpty(ct())) {
            return;
        }
        w(list);
    }

    private void w(List<View> list) {
        Function<SparseArray<Object>, Object> function = this.d;
        if (function != null) {
            function.apply(u.xj().xj(40059).xj(50021, list).xj(Void.class).hf());
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
    public View tf() {
        if (!(com.bytedance.msdk.xj.kd.xj.xj(this.g) instanceof Context)) {
            return null;
        }
        final FrameLayout xj = xj(this.g);
        if (xj != null) {
            xj.removeAllViews();
            xj.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            if (xj.getViewTreeObserver() != null) {
                xj.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.hf.10
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (xj.getVisibility() == 0) {
                            hf.this.xj(xj);
                            if (xj.getViewTreeObserver() != null) {
                                xj.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                        }
                    }
                });
            }
        }
        return xj;
    }

    @Override // com.bytedance.msdk.hf.w
    public int u() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? zf() : mq();
    }

    @Override // com.bytedance.msdk.hf.w
    public Integer y() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? ie() : dj();
    }

    private ViewGroup hf(Context context) {
        Object apply;
        if (this.d == null || context == null) {
            return null;
        }
        apply = this.d.apply(u.xj().xj(40055).xj(10000, context).xj(ViewGroup.class).hf());
        if (apply instanceof ViewGroup) {
            return (ViewGroup) apply;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Map<String, Object> map) {
        if (this.d != null) {
            this.d.apply(u.xj().xj(40014).xj(Void.class).xj(50010, map).hf());
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(final Activity activity, final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final com.bytedance.msdk.api.u.xj.c.tf tfVar, List<View> list4) {
        super.xj(activity, viewGroup, list, list2, list3, tfVar, list4);
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar != null && xjVar.w()) {
            y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.hf.9
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.xj(activity, viewGroup, (List<View>) list, (List<View>) list2, (List<View>) list3, tfVar);
                }
            });
        } else {
            xj(activity, viewGroup, list, list2, list3, tfVar);
        }
    }

    private boolean w(View view) {
        Object apply;
        if (this.d == null) {
            return false;
        }
        apply = this.d.apply(u.xj().xj(40054).xj(50013, view).xj(Boolean.class).hf());
        return (apply instanceof Boolean) && ((Boolean) apply).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.u.xj.c.tf tfVar) {
        ViewGroup hf;
        Object tag;
        if (list3 != null) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            list2.addAll(list3);
        }
        List<View> list4 = list2;
        tf tfVar2 = this.tf;
        if (tfVar2 != null && tfVar2.z()) {
            dk(lp());
        }
        if (context == null) {
            context = viewGroup.getContext();
        }
        Context context2 = context;
        int i = 0;
        if (viewGroup.getChildCount() != 0 && w(viewGroup.getChildAt(0))) {
            hf = (ViewGroup) viewGroup.getChildAt(0);
            while (i < hf.getChildCount()) {
                View childAt = hf.getChildAt(i);
                if (childAt == null || ((tag = childAt.getTag(2131298152)) != null && (tag instanceof String) && ((String) tag).equals(MediationConstant.TT_GDT_NATIVE_VIEW_TAG))) {
                    i++;
                } else {
                    hf.removeView(childAt);
                }
            }
        } else {
            hf = hf(context2);
            if (hf != null) {
                hf.setTag(2131298151, MediationConstant.TT_GDT_NATIVE_ROOT_VIEW_TAG);
                while (viewGroup.getChildCount() > 0) {
                    View childAt2 = viewGroup.getChildAt(0);
                    childAt2.setTag(2131298152, MediationConstant.TT_GDT_NATIVE_VIEW_TAG);
                    viewGroup.removeViewInLayout(childAt2);
                    hf.addView(childAt2, childAt2.getLayoutParams());
                }
                viewGroup.removeAllViews();
                viewGroup.addView(hf, -1, -1);
            }
        }
        xj(context2, hf, xl(), list, list4);
        if (tfVar != null) {
            xj(context2, viewGroup, tfVar);
        } else {
            hf(list4);
        }
        fh();
    }

    @Override // com.bytedance.msdk.hf.w
    public void hf(Map<String, Object> map) {
        tf tfVar = this.tf;
        if (tfVar != null && tfVar.j()) {
            final int da = (int) da();
            com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
            if (xjVar != null && xjVar.w()) {
                y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.hf.13
                    @Override // java.lang.Runnable
                    public void run() {
                        hf.this.et(da);
                    }
                });
            } else {
                et(da);
            }
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void hf() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar != null && xjVar.w()) {
            y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.hf.6
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.lt();
                }
            });
        } else {
            lt();
        }
    }

    private void xj(Context context, ViewGroup viewGroup, com.bytedance.msdk.api.u.xj.c.tf tfVar) {
        FrameLayout xj;
        if (viewGroup == null || tfVar == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(tfVar.c);
        if (frameLayout != null && ss() == 5 && (xj = xj(context)) != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(xj, -1, -1);
            xj(xj);
        }
        if (TextUtils.isEmpty(ct())) {
            return;
        }
        View findViewById = viewGroup.findViewById(tfVar.u);
        ArrayList arrayList = new ArrayList();
        arrayList.add(findViewById);
        w(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(FrameLayout frameLayout) {
        Object obj;
        if (this.d != null) {
            u xj = u.xj().xj(40058).xj(50013, frameLayout).xj(Void.class);
            com.bytedance.msdk.api.xj.hf hfVar = this.f10138pl;
            if (hfVar != null && hfVar.r() != null && (obj = this.f10138pl.r().get(MediationConstant.KEY_GDT_VIDEO_OPTION)) != null) {
                xj.xj(50020, obj);
            }
            this.d.apply(xj.hf());
        }
    }

    private FrameLayout xj(Context context) {
        Object apply;
        Function<SparseArray<Object>, Object> function = this.d;
        if (function == null || context == null) {
            return null;
        }
        apply = function.apply(u.xj().xj(40057).xj(10000, context).xj(FrameLayout.class).hf());
        if (apply instanceof FrameLayout) {
            return (FrameLayout) apply;
        }
        return null;
    }

    private void xj(Context context, ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        if (this.d == null || context == null) {
            return;
        }
        u.xj().xj(40056).xj(Void.class).xj(10000, context).xj(50013, viewGroup).xj(50017, layoutParams).xj(50018, list).xj(50019, list2);
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(final Map<String, Object> map) {
        tf tfVar = this.tf;
        if (tfVar == null || !tfVar.j() || map == null) {
            return;
        }
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar != null && xjVar.w()) {
            y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.hf.14
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.y((Map<String, Object>) map);
                }
            });
        } else {
            y(map);
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar != null && xjVar.w()) {
            y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.hf.5
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.yq();
                }
            });
        } else {
            yq();
        }
    }
}
