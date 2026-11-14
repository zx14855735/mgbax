package com.bykv.vk.openvk.component.video.api.w;

import android.os.Build;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements Serializable {
    private List<String> am;
    private int c;
    private boolean e;
    private int g;
    public int hf;
    private int jk;
    private w kd;
    private String p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10023pl;
    private String qt;
    private w u;
    private int v;
    public String xj;
    private String y;
    private boolean yo;
    private long zg;
    private int f = 204800;
    private int d = 0;
    private int tf = 0;
    public final HashMap<String, Object> w = new HashMap<>();
    private int pz = 10000;
    private int ht = 10000;
    private int ra = 10000;
    private int dk = 0;
    private JSONObject et = new JSONObject();

    public u(String str, w wVar, w wVar2, int i, int i2) {
        this.v = 0;
        this.jk = 0;
        this.y = str;
        this.u = wVar;
        this.kd = wVar2;
        this.v = i;
        this.jk = i2;
    }

    public boolean am() {
        w wVar;
        if (this.jk != 1 || (wVar = this.kd) == null || TextUtils.isEmpty(wVar.pl())) {
            return false;
        }
        return com.bykv.vk.openvk.component.video.api.w.kd() == 2 ? Build.VERSION.SDK_INT >= 26 : this.v == 1;
    }

    public boolean c() {
        return this.yo;
    }

    public int d() {
        return this.g;
    }

    public w dk() {
        return this.kd;
    }

    public String e() {
        if (am()) {
            return this.kd.qt();
        }
        w wVar = this.u;
        if (wVar != null) {
            return wVar.qt();
        }
        return null;
    }

    public w et() {
        if (am()) {
            return this.kd;
        }
        w wVar = this.u;
        if (wVar != null) {
            return wVar;
        }
        return null;
    }

    public int f() {
        return this.f10023pl;
    }

    public boolean g() {
        if (am()) {
            return this.kd.ra();
        }
        w wVar = this.u;
        if (wVar != null) {
            return wVar.ra();
        }
        return true;
    }

    public int hf() {
        return this.et.optInt("pitaya_cache_size", 0);
    }

    public int ht() {
        return this.dk;
    }

    public int jk() {
        return this.ht;
    }

    public String kd() {
        return this.y;
    }

    public boolean p() {
        return this.e;
    }

    public long pl() {
        if (am()) {
            return this.kd.kd();
        }
        w wVar = this.u;
        if (wVar != null) {
            return wVar.kd();
        }
        return 0L;
    }

    public int pz() {
        return this.ra;
    }

    public float qt() {
        if (am()) {
            return this.kd.f();
        }
        w wVar = this.u;
        if (wVar != null) {
            return wVar.f();
        }
        return -1.0f;
    }

    public w ra() {
        return this.u;
    }

    public long tf() {
        return this.zg;
    }

    public String u() {
        return this.et.optString("pitaya_msg");
    }

    public int v() {
        return this.pz;
    }

    public int w() {
        return this.et.optInt("pitaya_code", 0);
    }

    public JSONObject xj() {
        return this.et;
    }

    public int y() {
        if (am()) {
            return this.kd.zg();
        }
        w wVar = this.u;
        if (wVar != null) {
            return wVar.zg();
        }
        return 0;
    }

    public int yo() {
        return this.v;
    }

    public String zg() {
        if (am()) {
            return this.kd.pl();
        }
        w wVar = this.u;
        if (wVar != null) {
            return wVar.pl();
        }
        return null;
    }

    public void c(int i) {
        this.ht = i;
    }

    public void d(int i) {
        this.dk = i;
    }

    public void f(int i) {
        this.ra = i;
    }

    public void hf(String str) {
        this.p = str;
    }

    public void kd(int i) {
        this.v = i;
    }

    public void u(String str) {
        this.xj = str;
    }

    public void w(int i) {
        this.g = i;
    }

    public void xj(String str) {
        this.y = str;
    }

    public void hf(int i) {
        this.f10023pl = i;
    }

    public synchronized Object kd(String str) {
        return this.w.get(str);
    }

    public void u(int i) {
        this.hf = i;
    }

    public void w(String str) {
        this.qt = str;
    }

    public void xj(int i) {
        this.c = i;
    }

    public void hf(boolean z) {
        this.e = z;
    }

    public void xj(boolean z) {
        this.yo = z;
    }

    public void xj(List<String> list) {
        this.am = list;
    }

    public void y(int i) {
        this.pz = i;
    }

    public void xj(long j) {
        this.zg = j;
    }

    public synchronized void xj(String str, Object obj) {
        this.w.put(str, obj);
    }
}
