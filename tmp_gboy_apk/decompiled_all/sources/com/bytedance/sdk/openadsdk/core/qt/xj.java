package com.bytedance.sdk.openadsdk.core.qt;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements Comparable {
    private static int e = 0;
    public static int hf = 2;
    public static int kd = 1;
    private static long qt = 0;
    public static int u = 0;
    public static int w = 3;
    public static int xj = 1;
    public static int y = 2;
    private static long zg;
    private long am;
    private long c;
    private long d;
    private long f;
    private int g;
    private long p;

    /* renamed from: pl, reason: collision with root package name */
    private long f10394pl;
    private long tf;

    public static long c() {
        long p = w.kd().p();
        if (w.kd().tf() > p) {
            return 0L;
        }
        long currentTimeMillis = System.currentTimeMillis() - p;
        if (p == 0) {
            return 0L;
        }
        return currentTimeMillis;
    }

    public static int kd() {
        int i = e;
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public static long u() {
        return zg + c();
    }

    public static long w() {
        return qt + y();
    }

    public static long y() {
        long tf = w.kd().tf();
        long currentTimeMillis = System.currentTimeMillis() - tf;
        if (w.kd().p() > tf) {
            return 0L;
        }
        return tf == 0 ? System.currentTimeMillis() - w.kd().w() : currentTimeMillis;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj == null) {
            return 1;
        }
        xj xjVar = (xj) obj;
        return (this.c <= xjVar.c && this.d <= xjVar.d && this.tf <= xjVar.tf) ? 0 : 1;
    }

    public long d() {
        return this.c;
    }

    public long f() {
        return this.am;
    }

    public int g() {
        return this.g;
    }

    public long hf() {
        return this.f10394pl;
    }

    public long p() {
        return this.d;
    }

    public long pl() {
        return this.tf;
    }

    public long tf() {
        return this.f;
    }

    public long xj() {
        return this.p;
    }

    public void hf(long j) {
        this.f10394pl = j;
    }

    public void kd(long j) {
        this.f = j;
    }

    public void xj(long j) {
        this.p = j;
    }

    public static void xj(int i) {
        hf hfVar = new hf();
        long d = w.kd().d();
        List<xj> xj2 = hfVar.xj(d);
        Collections.sort(xj2);
        HashSet hashSet = new HashSet();
        if (xj2 != null && !xj2.isEmpty()) {
            qt = 0L;
            zg = 0L;
            e = 0;
            for (xj xjVar : xj2) {
                if (xjVar.g() == hf) {
                    zg += xj(xjVar, d);
                } else if (xjVar.g() == w) {
                    qt = xjVar.xj() + qt;
                } else if (xjVar.g() == xj && xjVar.c == d) {
                    hashSet.add(Long.valueOf(xjVar.tf()));
                }
            }
        }
        e = hashSet.size();
        if (i == kd) {
            e = 1;
        }
        hfVar.xj();
    }

    public void hf(int i) {
        this.g = i;
    }

    public void u(long j) {
        this.c = j;
    }

    public void w(long j) {
        this.am = j;
    }

    public void c(long j) {
        this.tf = j;
    }

    public void y(long j) {
        this.d = j;
    }

    private static long xj(xj xjVar, long j) {
        long j2 = j - 518400000;
        long f = xjVar.f();
        if (f - xjVar.hf() >= j2) {
            return xjVar.hf();
        }
        long j3 = f - j2;
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public static void xj(int i, long j, long j2) {
        xj xjVar = new xj();
        long currentTimeMillis = System.currentTimeMillis();
        long w2 = w.kd().w();
        xjVar.u(w.kd().d());
        xjVar.kd(w2);
        xjVar.hf(i);
        xjVar.w(currentTimeMillis);
        if (i == xj) {
            xjVar.xj(0L);
            xjVar.hf(0L);
            xjVar.c(0L);
            xjVar.y(0L);
        } else if (i == hf) {
            xjVar.xj(0L);
            xjVar.hf(j2);
            xjVar.c(0L);
            xjVar.y(currentTimeMillis);
        } else if (i == w) {
            xjVar.xj(j);
            xjVar.hf(0L);
            xjVar.c(currentTimeMillis);
            xjVar.y(0L);
        }
        new hf().insert(xjVar);
    }
}
