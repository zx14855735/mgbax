package com.bytedance.msdk.api.xj;

import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements u, w {
    private com.bytedance.msdk.core.tf.hf hf;
    private boolean u;
    private w w;
    private u xj;

    public hf() {
    }

    private void xj(int i, PluginValueSet pluginValueSet, w wVar) {
        this.xj = new kd(i, pluginValueSet);
        xj xjVar = new xj();
        this.w = xjVar;
        if (wVar != null) {
            xjVar.kd(wVar.f());
        }
    }

    @Override // com.bytedance.msdk.api.xj.u
    public String a() {
        u uVar = this.xj;
        return uVar != null ? uVar.a() : "";
    }

    @Override // com.bytedance.msdk.api.xj.u
    public boolean ai() {
        u uVar = this.xj;
        if (uVar != null) {
            return uVar.ai();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public float am() {
        u uVar = this.xj;
        if (uVar != null) {
            return uVar.am();
        }
        return 0.0f;
    }

    public int aq() {
        com.bytedance.msdk.core.tf.hf hfVar = this.hf;
        if (hfVar != null) {
            return hfVar.ai();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public SparseArray<Object> b() {
        u uVar = this.xj;
        return uVar != null ? uVar.b() : AYUAbz.f4117A5SV6n.sparseArray();
    }

    @Override // com.bytedance.msdk.api.xj.w
    public void c(int i) {
        w wVar = this.w;
        if (wVar != null) {
            wVar.c(i);
        }
    }

    @Override // com.bytedance.msdk.api.xj.w
    public int d() {
        w wVar = this.w;
        if (wVar != null) {
            return wVar.d();
        }
        return 0;
    }

    public int dc() {
        com.bytedance.msdk.core.tf.hf hfVar = this.hf;
        if (hfVar != null) {
            return hfVar.dc();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public String dk() {
        u uVar = this.xj;
        return uVar != null ? uVar.dk() : "";
    }

    public boolean dq() {
        int ht = ht();
        Map<String, Object> r = r();
        if (r == null) {
            return false;
        }
        Object obj = r.get("use_share_cache");
        return (obj instanceof Boolean) && (ht == 1 || ht == 5 || ht == 10 || ht == 7) && ((Boolean) obj).booleanValue();
    }

    @Override // com.bytedance.msdk.api.xj.u
    public int e() {
        u uVar = this.xj;
        if (uVar != null) {
            return uVar.e();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public String en() {
        u uVar = this.xj;
        return uVar != null ? uVar.en() : "";
    }

    @Override // com.bytedance.msdk.api.xj.u
    public int et() {
        u uVar = this.xj;
        if (uVar != null) {
            return uVar.et();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public String eu() {
        u uVar = this.xj;
        if (uVar != null) {
            return uVar.eu();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public void f(int i) {
        u uVar = this.xj;
        if (uVar != null) {
            uVar.f(i);
        }
    }

    @Override // com.bytedance.msdk.api.xj.u
    public boolean ff() {
        u uVar = this.xj;
        if (uVar != null) {
            return uVar.ff();
        }
        return false;
    }

    public w g() {
        return this.w;
    }

    @Override // com.bytedance.msdk.api.xj.w
    public int hf() {
        w wVar = this.w;
        if (wVar != null) {
            return wVar.hf();
        }
        return 0;
    }

    public double hl() {
        com.bytedance.msdk.core.tf.hf hfVar = this.hf;
        if (hfVar != null) {
            return hfVar.v();
        }
        return 0.0d;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public int ht() {
        u uVar = this.xj;
        if (uVar != null) {
            return uVar.ht();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public int io() {
        u uVar = this.xj;
        if (uVar != null) {
            return uVar.io();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public String j() {
        u uVar = this.xj;
        return uVar != null ? uVar.j() : "";
    }

    @Override // com.bytedance.msdk.api.xj.u
    public boolean jk() {
        u uVar = this.xj;
        if (uVar == null) {
            return false;
        }
        uVar.jk();
        return false;
    }

    @Override // com.bytedance.msdk.api.xj.w
    public int kd() {
        w wVar = this.w;
        if (wVar != null) {
            return wVar.kd();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public int l() {
        u uVar = this.xj;
        if (uVar != null) {
            return uVar.l();
        }
        return 0;
    }

    public long n() {
        com.bytedance.msdk.core.tf.hf hfVar = this.hf;
        if (hfVar != null) {
            return hfVar.x();
        }
        return 0L;
    }

    @Override // com.bytedance.msdk.api.xj.w
    public int p() {
        w wVar = this.w;
        if (wVar != null) {
            return wVar.p();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.xj.w
    public String pl() {
        w wVar = this.w;
        if (wVar != null) {
            return wVar.pl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public com.bytedance.sdk.openadsdk.mediation.hf.hf.xj pz() {
        u uVar = this.xj;
        if (uVar != null) {
            return uVar.pz();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public String q() {
        u uVar = this.xj;
        return uVar != null ? uVar.q() : "";
    }

    public boolean qd() {
        return this.u;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public float qt() {
        u uVar = this.xj;
        if (uVar != null) {
            return uVar.qt();
        }
        return 0.0f;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public Map<String, Object> r() {
        u uVar = this.xj;
        return uVar != null ? uVar.r() : new ConcurrentHashMap();
    }

    @Override // com.bytedance.msdk.api.xj.u
    public String ra() {
        u uVar = this.xj;
        return uVar != null ? uVar.ra() : "";
    }

    public String s() {
        com.bytedance.msdk.core.tf.hf hfVar = this.hf;
        return hfVar != null ? hfVar.jk() : "";
    }

    @Override // com.bytedance.msdk.api.xj.w
    public JSONObject tf() {
        w wVar = this.w;
        if (wVar != null) {
            return wVar.tf();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public boolean tj() {
        u uVar = this.xj;
        if (uVar != null) {
            return uVar.tj();
        }
        return false;
    }

    public String tu() {
        com.bytedance.msdk.core.tf.hf hfVar = this.hf;
        return hfVar != null ? hfVar.q() : "";
    }

    @Override // com.bytedance.msdk.api.xj.u
    public void u(String str) {
        u uVar = this.xj;
        if (uVar != null) {
            uVar.u(str);
        }
    }

    @Override // com.bytedance.msdk.api.xj.u
    public boolean v() {
        u uVar = this.xj;
        if (uVar == null) {
            return false;
        }
        uVar.v();
        return false;
    }

    public int vm() {
        com.bytedance.msdk.core.tf.hf hfVar = this.hf;
        if (hfVar != null) {
            return hfVar.vm();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.xj.w
    public void w(String str) {
        w wVar = this.w;
        if (wVar != null) {
            wVar.w(str);
        }
    }

    public String wn() {
        com.bytedance.msdk.core.tf.hf hfVar = this.hf;
        return hfVar != null ? hfVar.hl() : "";
    }

    @Override // com.bytedance.msdk.api.xj.u
    public boolean wo() {
        u uVar = this.xj;
        if (uVar != null) {
            return uVar.wo();
        }
        return false;
    }

    public com.bytedance.msdk.core.tf.hf ws() {
        return this.hf;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public int x() {
        u uVar;
        if (5 != ht() && 9 != ht()) {
            return 1;
        }
        com.bytedance.msdk.core.tf.hf hfVar = this.hf;
        int yo = hfVar != null ? hfVar.yo() : 0;
        if (yo == 0 && (uVar = this.xj) != null) {
            yo = uVar.x();
        }
        if (yo <= 0) {
            return 1;
        }
        if (yo >= 3) {
            return 3;
        }
        return yo;
    }

    @Override // com.bytedance.msdk.api.xj.w
    public void y(int i) {
        w wVar = this.w;
        if (wVar != null) {
            wVar.y(i);
        }
    }

    @Override // com.bytedance.msdk.api.xj.u
    public boolean yo() {
        u uVar = this.xj;
        if (uVar != null) {
            return uVar.yo();
        }
        return false;
    }

    public String yy() {
        com.bytedance.msdk.core.tf.hf hfVar = this.hf;
        return hfVar != null ? hfVar.en() : "";
    }

    @Override // com.bytedance.msdk.api.xj.u
    public int z() {
        u uVar = this.xj;
        if (uVar != null) {
            return uVar.z();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public boolean zg() {
        u uVar = this.xj;
        if (uVar != null) {
            return uVar.zg();
        }
        return false;
    }

    public hf(int i, PluginValueSet pluginValueSet) {
        xj(i, pluginValueSet, null);
    }

    @Override // com.bytedance.msdk.api.xj.w
    public boolean c() {
        w wVar = this.w;
        if (wVar != null) {
            return wVar.c();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public void d(int i) {
        u uVar = this.xj;
        if (uVar != null) {
            uVar.d(i);
        }
    }

    @Override // com.bytedance.msdk.api.xj.w
    public int f() {
        w wVar = this.w;
        if (wVar != null) {
            return wVar.f();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.xj.w
    public void hf(int i) {
        w wVar = this.w;
        if (wVar != null) {
            wVar.hf(i);
        }
    }

    @Override // com.bytedance.msdk.api.xj.w
    public void kd(int i) {
        w wVar = this.w;
        if (wVar != null) {
            wVar.kd(i);
        }
    }

    @Override // com.bytedance.msdk.api.xj.w
    public int u() {
        w wVar = this.w;
        if (wVar != null) {
            return wVar.u();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.xj.w
    public int w() {
        w wVar = this.w;
        if (wVar != null) {
            return wVar.w();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.xj.w
    public String y() {
        w wVar = this.w;
        if (wVar != null) {
            return wVar.y();
        }
        return "";
    }

    public hf(hf hfVar) {
        if (hfVar != null) {
            xj(hfVar.ht(), A2egSU.ADYaiT(hfVar.b()), hfVar.g());
        }
    }

    @Override // com.bytedance.msdk.api.xj.w
    public void xj(JSONObject jSONObject) {
        w wVar = this.w;
        if (wVar != null) {
            wVar.xj(jSONObject);
        }
    }

    @Override // com.bytedance.msdk.api.xj.w
    public void hf(String str) {
        w wVar = this.w;
        if (wVar != null) {
            wVar.hf(str);
        }
    }

    @Override // com.bytedance.msdk.api.xj.w
    public void u(int i) {
        w wVar = this.w;
        if (wVar != null) {
            wVar.u(i);
        }
    }

    @Override // com.bytedance.msdk.api.xj.w
    public void w(int i) {
        w wVar = this.w;
        if (wVar != null) {
            wVar.w(i);
        }
    }

    public void xj(com.bytedance.msdk.core.tf.hf hfVar) {
        this.hf = hfVar;
    }

    @Override // com.bytedance.msdk.api.xj.w
    public String xj() {
        w wVar = this.w;
        if (wVar != null) {
            return wVar.xj();
        }
        return "";
    }

    @Override // com.bytedance.msdk.api.xj.w
    public void xj(String str) {
        w wVar = this.w;
        if (wVar != null) {
            wVar.xj(str);
        }
    }

    @Override // com.bytedance.msdk.api.xj.w
    public void xj(int i) {
        w wVar = this.w;
        if (wVar != null) {
            wVar.xj(i);
        }
    }

    public void xj(PluginValueSet pluginValueSet) {
        if (this.xj == null || pluginValueSet == null) {
            return;
        }
        this.xj = new kd(ht(), pluginValueSet);
    }

    public void xj(boolean z) {
        this.u = z;
    }
}
