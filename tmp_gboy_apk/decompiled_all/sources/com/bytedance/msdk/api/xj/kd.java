package com.bytedance.msdk.api.xj;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd implements u {
    private com.bytedance.sdk.openadsdk.mediation.hf.hf.hf hf;
    private PluginValueSet kd;
    private int u;
    private Map<String, Object> w;
    private com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xj;
    private int y = -1;
    private String c = "";

    public kd(int i, PluginValueSet pluginValueSet) {
        if (pluginValueSet == null) {
            com.bytedance.msdk.xj.kd.w.hf("AdLinkInfo", "valueset is null");
            return;
        }
        this.kd = pluginValueSet;
        this.u = i;
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar = new com.bytedance.sdk.openadsdk.mediation.hf.hf.xj(pluginValueSet.sparseArray());
        this.xj = xjVar;
        this.hf = xjVar.ai();
    }

    @Override // com.bytedance.msdk.api.xj.u
    public String a() {
        Map<String, Object> y;
        com.bytedance.sdk.openadsdk.mediation.hf.hf.hf hfVar = this.hf;
        if (hfVar == null || (y = hfVar.y()) == null) {
            return "";
        }
        Object obj = y.get("testToolSlotId");
        return obj instanceof String ? (String) obj : "";
    }

    @Override // com.bytedance.msdk.api.xj.u
    public boolean ai() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.tf();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public float am() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.f();
        }
        return 0.0f;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public SparseArray<Object> b() {
        PluginValueSet pluginValueSet = this.kd;
        if (pluginValueSet != null) {
            return pluginValueSet.sparseArray();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public void d(int i) {
        this.u = i;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public String dk() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.hf hfVar = this.hf;
        return hfVar != null ? hfVar.f() : "";
    }

    @Override // com.bytedance.msdk.api.xj.u
    public int e() {
        return this.y;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public String en() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar = this.xj;
        return xjVar != null ? xjVar.am() : "";
    }

    @Override // com.bytedance.msdk.api.xj.u
    public int et() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.y();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public String eu() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.q();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public void f(int i) {
        this.y = i;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public boolean ff() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.hf hfVar = this.hf;
        if (hfVar != null) {
            return hfVar.w();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public int ht() {
        return this.u;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public int io() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.c();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public String j() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar = this.xj;
        return xjVar != null ? xjVar.g() : "";
    }

    @Override // com.bytedance.msdk.api.xj.u
    public boolean jk() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.hf hfVar = this.hf;
        if (hfVar != null) {
            return hfVar.hf();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public int l() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.qt();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public com.bytedance.sdk.openadsdk.mediation.hf.hf.xj pz() {
        return this.xj;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public String q() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.hf hfVar;
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar = this.xj;
        String dk = xjVar != null ? xjVar.dk() : "";
        return (!TextUtils.isEmpty(dk) || (hfVar = this.hf) == null) ? dk : hfVar.am();
    }

    @Override // com.bytedance.msdk.api.xj.u
    public float qt() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.d();
        }
        return 0.0f;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public Map<String, Object> r() {
        Map<String, Object> map = this.w;
        if (map != null) {
            return map;
        }
        if (this.hf != null) {
            this.w = new ConcurrentHashMap();
            Map<String, Object> y = this.hf.y();
            if (y != null && y.size() > 0) {
                for (Map.Entry<String, Object> entry : y.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        this.w.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        if (this.w == null) {
            this.w = new ConcurrentHashMap();
        }
        return this.w;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public String ra() {
        if (!TextUtils.isEmpty(this.c)) {
            return this.c;
        }
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar = this.xj;
        return xjVar != null ? xjVar.u() : "";
    }

    @Override // com.bytedance.msdk.api.xj.u
    public boolean tj() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.x();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public void u(String str) {
        this.c = str;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public boolean v() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.hf hfVar = this.hf;
        if (hfVar != null) {
            return hfVar.xj();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public boolean wo() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.hf hfVar = this.hf;
        if (hfVar != null) {
            return hfVar.c();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public int x() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.pl();
        }
        return 1;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public boolean yo() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.hf hfVar = this.hf;
        if (hfVar != null) {
            return hfVar.d();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.xj.u
    public int z() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.hf hfVar;
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar = this.xj;
        int et = xjVar != null ? xjVar.et() : 0;
        return (et != 0 || (hfVar = this.hf) == null) ? et : hfVar.qt();
    }

    @Override // com.bytedance.msdk.api.xj.u
    public boolean zg() {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.p();
        }
        return false;
    }
}
