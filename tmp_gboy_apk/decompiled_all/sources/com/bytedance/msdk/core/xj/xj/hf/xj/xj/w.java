package com.bytedance.msdk.core.xj.xj.hf.xj.xj;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends com.bytedance.msdk.hf.w {
    private Function<SparseArray<Object>, Object> d;
    private com.bytedance.msdk.core.xj.xj.hf.xj p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.msdk.api.xj.hf f10142pl;
    private tf tf;

    public w(com.bytedance.msdk.core.xj.xj.hf.xj xjVar, Function<SparseArray<Object>, Object> function) {
        this.d = function;
        this.p = xjVar;
        this.tf = xjVar.hf;
        this.f10142pl = xjVar.xj;
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
                xj(m5if());
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
        if (this.d == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40043, sparseArray, -99999987, -99999985, String.class);
        apply = this.d.apply(sparseArray);
        return (String) apply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co() {
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40011, sparseArray, -99999987, -99999985, Void.class);
            this.d.apply(sparseArray);
        }
    }

    private String ct() {
        Object apply;
        if (this.d == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40045, sparseArray, -99999987, -99999985, String.class);
        apply = this.d.apply(sparseArray);
        return (String) apply;
    }

    private Integer dj() {
        try {
            Integer num = (Integer) y.xj(new Callable<Integer>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.w.9
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return w.this.ie();
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
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40007, sparseArray, -99999987, -99999985, Boolean.class);
            sparseArray.put(50007, Integer.valueOf(i));
            this.d.apply(sparseArray);
        }
    }

    private String eb() {
        Object apply;
        if (this.d == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40004, sparseArray, -99999987, -99999985, String.class);
        apply = this.d.apply(sparseArray);
        return (String) apply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void et(int i) {
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40013, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(50007, Integer.valueOf(i));
            this.d.apply(sparseArray);
        }
    }

    private com.bytedance.msdk.api.u.xj.xj.xj fa() {
        return (com.bytedance.msdk.api.u.xj.xj.xj) this.c;
    }

    private String fc() {
        Object apply;
        if (this.d == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40042, sparseArray, -99999987, -99999985, String.class);
        apply = this.d.apply(sparseArray);
        return (String) apply;
    }

    private void fh() {
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40060, sparseArray, -99999987, -99999985, Void.class);
            this.d.apply(sparseArray);
        }
    }

    private String ha() {
        Object apply;
        if (this.d == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40033, sparseArray, -99999987, -99999985, String.class);
        apply = this.d.apply(sparseArray);
        return (String) apply;
    }

    private String hx() {
        Object apply;
        if (this.d == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40047, sparseArray, -99999987, -99999985, String.class);
        apply = this.d.apply(sparseArray);
        return (String) apply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer ie() {
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

    /* renamed from: if, reason: not valid java name */
    private double m5if() {
        if (this.d == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? lp() : su();
    }

    private String it() {
        Object apply;
        if (this.d == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40046, sparseArray, -99999987, -99999985, String.class);
        apply = this.d.apply(sparseArray);
        return (String) apply;
    }

    private double jb() {
        Object apply;
        if (this.d == null) {
            return 0.0d;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40051, sparseArray, -99999987, -99999985, Integer.class);
        apply = this.d.apply(sparseArray);
        if (apply instanceof Integer) {
            return ((Double) apply).doubleValue();
        }
        return 0.0d;
    }

    private boolean jq() {
        Object apply;
        if (this.d == null) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40052, sparseArray, -99999987, -99999985, Boolean.class);
        apply = this.d.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    private String js() {
        Object apply;
        if (this.d == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40039, sparseArray, -99999987, -99999985, String.class);
        apply = this.d.apply(sparseArray);
        return (String) apply;
    }

    private List<String> ka() {
        Object apply;
        if (this.d == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40050, sparseArray, -99999987, -99999985, List.class);
        apply = this.d.apply(sparseArray);
        if (apply instanceof List) {
            return (List) apply;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lp() {
        Object apply;
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40003, sparseArray, -99999987, -99999985, Integer.class);
            apply = this.d.apply(sparseArray);
            int intValue = ((Integer) apply).intValue();
            if (intValue != -1) {
                return intValue;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt() {
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40064, sparseArray, -99999987, -99999985, Void.class);
            this.d.apply(sparseArray);
        }
    }

    private int mq() {
        try {
            Integer num = (Integer) y.xj(new Callable<Integer>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.w.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return Integer.valueOf(w.this.zf());
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
        if (this.d == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40032, sparseArray, -99999987, -99999985, String.class);
        apply = this.d.apply(sparseArray);
        return (String) apply;
    }

    private int o() {
        Object apply;
        if (this.d == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40048, sparseArray, -99999987, -99999985, Integer.class);
        apply = this.d.apply(sparseArray);
        if (apply instanceof Integer) {
            return ((Integer) apply).intValue();
        }
        return 0;
    }

    private String oe() {
        Object apply;
        if (this.d == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40041, sparseArray, -99999987, -99999985, String.class);
        apply = this.d.apply(sparseArray);
        return (String) apply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void og() {
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40061, sparseArray, -99999987, -99999985, Void.class);
            this.d.apply(sparseArray);
        }
    }

    private void pn() {
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40009, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(50009, this);
            this.d.apply(sparseArray);
        }
    }

    private long ps() {
        Object apply;
        if (this.d == null) {
            return 0L;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40040, sparseArray, -99999987, -99999985, Long.class);
        apply = this.d.apply(sparseArray);
        return ((Long) apply).longValue();
    }

    private int pu() {
        Object apply;
        if (this.d == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40021, sparseArray, -99999987, -99999985, Integer.class);
        apply = this.d.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    private String qa() {
        Object apply;
        if (this.d == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40044, sparseArray, -99999987, -99999985, String.class);
        apply = this.d.apply(sparseArray);
        return (String) apply;
    }

    private String rq() {
        Object apply;
        if (this.d == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40038, sparseArray, -99999987, -99999985, String.class);
        apply = this.d.apply(sparseArray);
        return (String) apply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rs() {
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40062, sparseArray, -99999987, -99999985, Void.class);
            this.d.apply(sparseArray);
        }
    }

    private int rx() {
        Object apply;
        if (this.d == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40049, sparseArray, -99999987, -99999985, Integer.class);
        apply = this.d.apply(sparseArray);
        if (apply instanceof Integer) {
            return ((Integer) apply).intValue();
        }
        return 0;
    }

    private int su() {
        try {
            Integer num = (Integer) y.xj(new Callable<Integer>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.w.6
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return Integer.valueOf(w.this.lp());
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
            String str = (String) y.xj(new Callable<String>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.w.7
                @Override // java.util.concurrent.Callable
                public String call() {
                    return w.this.ta();
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
            return (String) y.xj(new Callable<String>() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.w.13
                @Override // java.util.concurrent.Callable
                public String call() {
                    return w.this.xw();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            pl.xj(th);
            return null;
        }
    }

    private FrameLayout.LayoutParams xl() {
        com.bytedance.msdk.api.xj.hf hfVar = this.f10142pl;
        if (hfVar == null || hfVar.r() == null) {
            return null;
        }
        Object obj = this.f10142pl.r().get(MediationConstant.KEY_GDT_NATIVE_LOGO_PARAMS);
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
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40015, sparseArray, -99999987, -99999985, Map.class);
        apply = this.d.apply(sparseArray);
        return (!(apply instanceof Map) || (obj = ((Map) apply).get(PointParamKey.REQUEST_ID)) == null) ? "" : obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yq() {
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40063, sparseArray, -99999987, -99999985, Void.class);
            this.d.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zf() {
        Object apply;
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40053, sparseArray, -99999987, -99999985, Integer.class);
            apply = this.d.apply(sparseArray);
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
        if (i == 60004) {
            if (this.c instanceof com.bytedance.msdk.api.u.xj.xj.xj) {
                fa().xj((View) null);
            }
        } else if (i == 60009 && (this.c instanceof com.bytedance.msdk.api.u.xj.xj.xj)) {
            fa().hf(null);
        }
        return null;
    }

    @Override // com.bytedance.msdk.hf.w
    public void e() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar == null || !xjVar.w()) {
            og();
        } else {
            y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.w.2
                @Override // java.lang.Runnable
                public void run() {
                    w.this.og();
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
        y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.w.10
            @Override // java.lang.Runnable
            public void run() {
                w.this.co();
            }
        });
    }

    @Override // com.bytedance.msdk.hf.w
    public void zg() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar == null || !xjVar.w()) {
            rs();
        } else {
            y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.w.3
                @Override // java.lang.Runnable
                public void run() {
                    w.this.rs();
                }
            });
        }
    }

    private void hf(List<View> list) {
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40059, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(50021, list);
            this.d.apply(sparseArray);
        }
    }

    private boolean w(View view) {
        Object apply;
        if (this.d == null) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40055, sparseArray, -99999987, -99999985, Boolean.class);
        sparseArray.put(50013, view);
        apply = this.d.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
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
    public int u() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? zf() : mq();
    }

    @Override // com.bytedance.msdk.hf.w
    public Integer y() {
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        return (xjVar == null || !xjVar.w()) ? ie() : dj();
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
    public void xj(final Activity activity, final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final com.bytedance.msdk.api.u.xj.c.tf tfVar, List<View> list4) {
        super.xj(activity, viewGroup, list, list2, list3, tfVar, list4);
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar != null && xjVar.w()) {
            y.w(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.w.8
                @Override // java.lang.Runnable
                public void run() {
                    w.this.xj(activity, viewGroup, (List<View>) list, (List<View>) list2, (List<View>) list3, tfVar);
                }
            });
        } else {
            xj(activity, viewGroup, list, list2, list3, tfVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.u.xj.c.tf tfVar) {
        ViewGroup hf;
        FrameLayout xj;
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
        ViewGroup viewGroup2 = hf;
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(tfVar.c);
        xj(context2, viewGroup2, xl(), list, list4);
        if (frameLayout != null && ss() == 5 && (xj = xj(context2)) != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(xj, -1, -1);
            xj(xj);
        }
        if (!TextUtils.isEmpty(ct())) {
            View findViewById = viewGroup.findViewById(tfVar.u);
            ArrayList arrayList = new ArrayList();
            arrayList.add(findViewById);
            hf(arrayList);
        }
        fh();
    }

    private ViewGroup hf(Context context) {
        Object apply;
        if (this.d == null || context == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40055, sparseArray, -99999987, -99999985, ViewGroup.class);
        sparseArray.put(10000, context);
        apply = this.d.apply(sparseArray);
        return (ViewGroup) apply;
    }

    @Override // com.bytedance.msdk.hf.w
    public void hf(Map<String, Object> map) {
        tf tfVar = this.tf;
        if (tfVar != null && tfVar.j()) {
            final int da = (int) da();
            com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
            if (xjVar != null && xjVar.w()) {
                y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.w.11
                    @Override // java.lang.Runnable
                    public void run() {
                        w.this.et(da);
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
            y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.w.5
                @Override // java.lang.Runnable
                public void run() {
                    w.this.lt();
                }
            });
        } else {
            lt();
        }
    }

    private void xj(FrameLayout frameLayout) {
        Object obj;
        if (this.d != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(40058, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(50013, frameLayout);
            com.bytedance.msdk.api.xj.hf hfVar = this.f10142pl;
            if (hfVar != null && hfVar.r() != null && (obj = this.f10142pl.r().get(MediationConstant.KEY_GDT_VIDEO_OPTION)) != null) {
                sparseArray.put(50020, obj);
            }
            this.d.apply(sparseArray);
        }
    }

    private FrameLayout xj(Context context) {
        Object apply;
        if (this.d == null || context == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40057, sparseArray, -99999987, -99999985, FrameLayout.class);
        sparseArray.put(10000, context);
        apply = this.d.apply(sparseArray);
        return (FrameLayout) apply;
    }

    private void xj(Context context, ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        if (this.d == null || context == null) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40056, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(10000, context);
        sparseArray.put(50013, viewGroup);
        sparseArray.put(50017, layoutParams);
        sparseArray.put(50018, list);
        sparseArray.put(50019, list2);
        this.d.apply(sparseArray);
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(final Map<String, Object> map) {
        tf tfVar = this.tf;
        if (tfVar == null || !tfVar.j() || map == null) {
            return;
        }
        com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.p;
        if (xjVar != null && xjVar.w()) {
            y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.w.12
                @Override // java.lang.Runnable
                public void run() {
                    w.this.y((Map<String, Object>) map);
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
            y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.w.4
                @Override // java.lang.Runnable
                public void run() {
                    w.this.yq();
                }
            });
        } else {
            yq();
        }
    }
}
