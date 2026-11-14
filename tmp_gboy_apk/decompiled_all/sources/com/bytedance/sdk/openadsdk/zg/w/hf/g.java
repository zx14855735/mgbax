package com.bytedance.sdk.openadsdk.zg.w.hf;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class g extends f {
    private SparseArray<Object> xj;

    public abstract pl am();

    public abstract String c();

    public abstract String d();

    public abstract void dk();

    public abstract int e();

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.kd et();

    public abstract String f();

    public abstract String g();

    public abstract void hf(Activity activity);

    public abstract void hf(Dialog dialog, Integer[] numArr);

    public abstract Map<String, Object> ht();

    public abstract kd jk();

    public abstract pl kd();

    public abstract int p();

    public abstract int pl();

    public abstract View pz();

    public abstract List<pl> qt();

    public abstract void ra();

    public abstract int tf();

    public SparseArray<Object> u_() {
        SparseArray<Object> sparseArray = this.xj;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> xj = xj();
        this.xj = xj;
        return xj;
    }

    public abstract w v();

    public abstract c xj(Activity activity);

    public abstract c xj(Dialog dialog, Integer[] numArr);

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f, java.util.function.Function
    /* renamed from: xj */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        int intValue = ADYaiT2.intValue(-99999987, 0);
        ADYaiT2.objectValue(-99999985, Class.class);
        if (intValue == -99999986) {
            return u_();
        }
        switch (intValue) {
            case 140101:
                return xj((Activity) ADYaiT2.objectValue(0, Activity.class));
            case 140102:
                Dialog dialog = (Dialog) ADYaiT2.objectValue(0, Dialog.class);
                Integer[] numArr = (Integer[]) ADYaiT2.arrayValue(1, Integer.class);
                if (numArr == null) {
                    numArr = new Integer[0];
                }
                return xj(dialog, numArr);
            case 140103:
                xj((ViewGroup) ADYaiT2.objectValue(0, ViewGroup.class), (View) ADYaiT2.objectValue(1, View.class), new com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(2, AaHO0E.ARc23Z()))));
                return null;
            case 140104:
                xj((ViewGroup) ADYaiT2.objectValue(0, ViewGroup.class), (List) ADYaiT2.objectValue(1, List.class), (List) ADYaiT2.objectValue(2, List.class), new com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(3, AaHO0E.ARc23Z()))));
                return null;
            case 140105:
                xj((ViewGroup) ADYaiT2.objectValue(0, ViewGroup.class), (List) ADYaiT2.objectValue(1, List.class), (List) ADYaiT2.objectValue(2, List.class), (View) ADYaiT2.objectValue(3, View.class), new com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(4, AaHO0E.ARc23Z()))));
                return null;
            case 140106:
                xj((ViewGroup) ADYaiT2.objectValue(0, ViewGroup.class), (List) ADYaiT2.objectValue(1, List.class), (List) ADYaiT2.objectValue(2, List.class), (List) ADYaiT2.objectValue(3, List.class), (View) ADYaiT2.objectValue(4, View.class), new com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(5, AaHO0E.ARc23Z()))));
                return null;
            case 140107:
                xj((ViewGroup) ADYaiT2.objectValue(0, ViewGroup.class), (List<View>) ADYaiT2.objectValue(1, List.class), (List<View>) ADYaiT2.objectValue(2, List.class), (List<View>) ADYaiT2.objectValue(3, List.class), (List<View>) ADYaiT2.objectValue(4, List.class), (View) ADYaiT2.objectValue(5, View.class), new com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(6, AaHO0E.ARc23Z()))));
                return null;
            case 140108:
                xj(new com.bytedance.sdk.openadsdk.zg.w.xj.w(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                return null;
            case 140109:
                hf((Activity) ADYaiT2.objectValue(0, Activity.class));
                return null;
            case 140110:
                ra();
                return null;
            case 140111:
                xj(new com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                return null;
            case 140112:
                xj((Activity) ADYaiT2.objectValue(0, Activity.class), new com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(1, AaHO0E.ARc23Z()))));
                return null;
            case 140113:
                Dialog dialog2 = (Dialog) ADYaiT2.objectValue(0, Dialog.class);
                Integer[] numArr2 = (Integer[]) ADYaiT2.arrayValue(1, Integer.class);
                if (numArr2 == null) {
                    numArr2 = new Integer[0];
                }
                hf(dialog2, numArr2);
                return null;
            case 140114:
                dk();
                return null;
            case 140115:
                ADYaiT2.objectValue(0, Activity.class);
                return null;
            case 140116:
                return et();
            case 140117:
                xj((Activity) ADYaiT2.objectValue(0, Activity.class), (ViewGroup) ADYaiT2.objectValue(1, ViewGroup.class), (List<View>) ADYaiT2.objectValue(2, List.class), (List<View>) ADYaiT2.objectValue(3, List.class), (List<View>) ADYaiT2.objectValue(4, List.class), new com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(5, AaHO0E.ARc23Z()))), new com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.u(AaHO0E.AYUAbz(ADYaiT2.objectValue(6, AaHO0E.ARc23Z()))));
                return null;
            case 140118:
                xj((String) ADYaiT2.objectValue(0, String.class));
                return null;
            case 140119:
                xj(new com.bytedance.sdk.openadsdk.dk.xj.hf.xj.hf(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                return null;
            default:
                return super.apply(sparseArray);
        }
    }

    public abstract void xj(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar, com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.u uVar);

    public abstract void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar);

    public abstract void xj(ViewGroup viewGroup, View view, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar);

    public abstract void xj(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar);

    public abstract void xj(ViewGroup viewGroup, List<View> list, List<View> list2, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar);

    public abstract void xj(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar);

    public abstract void xj(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar);

    public abstract void xj(com.bytedance.sdk.openadsdk.dk.xj.hf.xj.hf hfVar);

    public abstract void xj(com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w wVar);

    public abstract void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar);

    public abstract void xj(String str);

    public abstract Bitmap y();

    public abstract u yo();

    public abstract int zg();

    private SparseArray<Object> xj() {
        com.bytedance.sdk.openadsdk.zg.u xj = com.bytedance.sdk.openadsdk.zg.u.xj();
        xj.xj(140001, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<pl>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.g.1
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public pl get() {
                return g.this.kd();
            }
        }));
        xj.xj(140002, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.g.11
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Bitmap get() {
                return g.this.y();
            }
        }));
        xj.xj(140003, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.g.12
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return g.this.c();
            }
        }));
        xj.xj(140004, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.g.13
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return g.this.f();
            }
        }));
        xj.xj(140018, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.g.14
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return g.this.d();
            }
        }));
        xj.xj(140005, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.g.15
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(g.this.tf());
            }
        }));
        xj.xj(140006, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.g.16
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(g.this.p());
            }
        }));
        xj.xj(140007, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.g.17
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(g.this.pl());
            }
        }));
        xj.xj(140008, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.g.18
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return g.this.g();
            }
        }));
        xj.xj(140009, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<pl>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.g.2
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public pl get() {
                return g.this.am();
            }
        }));
        xj.xj(140010, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<List<pl>>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.g.3
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public List<pl> get() {
                return g.this.qt();
            }
        }));
        xj.xj(140011, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.g.4
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(g.this.zg());
            }
        }));
        xj.xj(140012, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.g.5
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(g.this.e());
            }
        }));
        xj.xj(140013, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<u>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.g.6
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public u get() {
                return g.this.yo();
            }
        }));
        xj.xj(140014, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<w>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.g.7
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public w get() {
                return g.this.v();
            }
        }));
        xj.xj(140015, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<kd>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.g.8
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public kd get() {
                return g.this.jk();
            }
        }));
        xj.xj(140016, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<View>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.g.9
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public View get() {
                return g.this.pz();
            }
        }));
        xj.xj(140017, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.g.10
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return g.this.ht();
            }
        }));
        return xj.hf();
    }
}
