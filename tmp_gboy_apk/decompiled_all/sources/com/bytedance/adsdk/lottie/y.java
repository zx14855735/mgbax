package com.bytedance.adsdk.lottie;

import android.graphics.Rect;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {
    private boolean am;
    private SparseArray<com.bytedance.adsdk.lottie.model.u> c;
    private List<com.bytedance.adsdk.lottie.model.layer.f> d;
    private LongSparseArray<com.bytedance.adsdk.lottie.model.layer.f> f;
    private float g;
    private xj jk;
    private Map<String, com.bytedance.adsdk.lottie.model.w> kd;
    private float p;

    /* renamed from: pl, reason: collision with root package name */
    private float f10063pl;
    private Rect tf;
    private Map<String, d> u;
    private w v;
    private Map<String, List<com.bytedance.adsdk.lottie.model.layer.f>> w;
    private List<com.bytedance.adsdk.lottie.model.y> y;
    private hf yo;
    private u zg;
    private final yo xj = new yo();
    private final HashSet<String> hf = new HashSet<>();
    private int qt = 0;
    private String e = "";

    public static class hf {
        public JSONArray c;
        public Map<String, Object> hf;
        public int kd;
        public int u;
        public Map<String, Object> w;
        public int xj;
        public String y;
    }

    public static class u {
        public JSONArray c;
        public int d;
        public int f;
        public String hf;
        public int[] kd;
        public String[] tf;
        public String u;
        public String w;
        public int xj;
        public String y;
    }

    public static class w {
        public int[][] hf;
        public JSONArray w;
        public String xj;
    }

    public static class xj {
        public String hf;
        public String u;
        public String w;
        public String xj;
        public float kd = -1.0f;
        public float y = -1.0f;
        public float c = -1.0f;
        public float f = -1.0f;

        public String toString() {
            return "area[" + this.xj + "," + this.hf + "," + this.w + "," + this.u + "]->[" + this.kd + "," + this.y + "," + this.c + "," + this.f + "]";
        }
    }

    public List<com.bytedance.adsdk.lottie.model.layer.f> am() {
        return this.d;
    }

    public float c() {
        return this.f10063pl;
    }

    public String d() {
        return this.e;
    }

    public Map<String, d> e() {
        return this.u;
    }

    public u f() {
        return this.zg;
    }

    public float g() {
        return this.g;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int hf() {
        return this.qt;
    }

    public float kd() {
        return (long) ((yo() / this.g) * 1000.0f);
    }

    public w p() {
        return this.v;
    }

    public hf pl() {
        return this.yo;
    }

    public SparseArray<com.bytedance.adsdk.lottie.model.u> qt() {
        return this.c;
    }

    public xj tf() {
        return this.jk;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.bytedance.adsdk.lottie.model.layer.f> it = this.d.iterator();
        while (it.hasNext()) {
            sb.append(it.next().xj("\t"));
        }
        return sb.toString();
    }

    public Rect u() {
        return this.tf;
    }

    public yo w() {
        return this.xj;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void xj(Rect rect, float f, float f2, float f3, List<com.bytedance.adsdk.lottie.model.layer.f> list, LongSparseArray<com.bytedance.adsdk.lottie.model.layer.f> longSparseArray, Map<String, List<com.bytedance.adsdk.lottie.model.layer.f>> map, Map<String, d> map2, SparseArray<com.bytedance.adsdk.lottie.model.u> sparseArray, Map<String, com.bytedance.adsdk.lottie.model.w> map3, List<com.bytedance.adsdk.lottie.model.y> list2, u uVar, String str, hf hfVar, w wVar, xj xjVar) {
        this.tf = rect;
        this.p = f;
        this.f10063pl = f2;
        this.g = f3;
        this.d = list;
        this.f = longSparseArray;
        this.w = map;
        this.u = map2;
        this.c = sparseArray;
        this.kd = map3;
        this.y = list2;
        this.zg = uVar;
        this.e = str;
        this.yo = hfVar;
        this.v = wVar;
        this.jk = xjVar;
    }

    public float y() {
        return this.p;
    }

    public float yo() {
        return this.f10063pl - this.p;
    }

    public Map<String, com.bytedance.adsdk.lottie.model.w> zg() {
        return this.kd;
    }

    public void hf(boolean z) {
        this.xj.xj(z);
    }

    public com.bytedance.adsdk.lottie.model.y w(String str) {
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            com.bytedance.adsdk.lottie.model.y yVar = this.y.get(i);
            if (yVar.xj(str)) {
                return yVar;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<com.bytedance.adsdk.lottie.model.layer.f> hf(String str) {
        return this.w.get(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void xj(String str) {
        com.bytedance.adsdk.lottie.kd.kd.hf(str);
        this.hf.add(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void xj(boolean z) {
        this.am = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void xj(int i) {
        this.qt += i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean xj() {
        return this.am;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public com.bytedance.adsdk.lottie.model.layer.f xj(long j) {
        return this.f.get(j);
    }

    public float xj(float f) {
        return com.bytedance.adsdk.lottie.kd.f.xj(this.p, this.f10063pl, f);
    }
}
