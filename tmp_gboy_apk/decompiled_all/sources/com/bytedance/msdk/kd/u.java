package com.bytedance.msdk.kd;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    public int am;
    public String c;
    public long d;
    public int e;
    public String f;
    public String g;
    public String hf;
    public String kd;
    public String p;

    /* renamed from: pl, reason: collision with root package name */
    public String f10147pl;
    public String pz;
    public String qt;
    public String tf;
    public String u;
    public String w;
    public String xj;
    public String y;
    public long yo;
    public String zg;
    public int v = -1;
    public int jk = -1;
    public Map<String, Object> ht = new ConcurrentHashMap();
    private long ra = -1;

    public u c(String str) {
        this.kd = str;
        return this;
    }

    public u d(String str) {
        this.c = str;
        return this;
    }

    public u f(String str) {
        this.y = str;
        return this;
    }

    public u hf(String str) {
        this.f = str;
        return this;
    }

    public u kd(String str) {
        this.w = str;
        return this;
    }

    public u p(String str) {
        this.pz = str;
        return this;
    }

    public u setResult(int i) {
        this.v = i;
        return this;
    }

    public u tf(String str) {
        this.p = str;
        return this;
    }

    public u u(String str) {
        this.hf = str;
        return this;
    }

    public u w(String str) {
        this.tf = str;
        return this;
    }

    public u xj(int i) {
        this.g = String.valueOf(i);
        return this;
    }

    public u y(String str) {
        this.u = str;
        return this;
    }

    public u hf(long j) {
        this.d = j;
        return this;
    }

    public u kd(int i) {
        this.e = i;
        return this;
    }

    public u u(int i) {
        this.zg = String.valueOf(i);
        return this;
    }

    public u w(int i) {
        this.qt = String.valueOf(i);
        return this;
    }

    public u xj(long j) {
        this.yo = j;
        return this;
    }

    public u y(int i) {
        this.jk = i;
        return this;
    }

    public u hf(int i) {
        this.am = i;
        return this;
    }

    public u w(long j) {
        this.ra = j;
        return this;
    }

    public u xj(String str) {
        this.xj = str;
        return this;
    }

    public static u hf() {
        return new u();
    }

    public static u w() {
        u uVar = new u();
        uVar.w(System.currentTimeMillis());
        return uVar;
    }

    public u xj(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.ht.put(str, obj);
        }
        return this;
    }

    public u xj(Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            this.ht.putAll(map);
        }
        return this;
    }

    public long xj() {
        return this.ra;
    }
}
