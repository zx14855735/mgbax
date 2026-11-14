package com.bytedance.sdk.gromore.xj.hf;

import ADYaiT.BpkvW3;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.w;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private com.bytedance.sdk.openadsdk.zg.w.w.xj hf;
    private com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.xj w;
    private PluginValueSet xj;

    private xj(PluginValueSet pluginValueSet) {
        this.xj = pluginValueSet;
        if (pluginValueSet != null) {
            com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar = new com.bytedance.sdk.openadsdk.zg.w.w.xj(pluginValueSet.sparseArray());
            this.hf = xjVar;
            this.w = xjVar.qt();
        }
    }

    public static xj xj(PluginValueSet pluginValueSet) {
        return new xj(pluginValueSet);
    }

    public Function<SparseArray<Object>, Object> ai() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.xj xjVar = this.w;
        if (xjVar == null || xjVar.u() == null) {
            return null;
        }
        Object obj = this.w.u().get("qa_preview_tool");
        if (BpkvW3.BmvVmW(obj)) {
            return AaHO0E.AYUAbz(obj);
        }
        return null;
    }

    public Map<String, Object> am() {
        com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar = this.hf;
        if (xjVar != null) {
            return xjVar.e();
        }
        return null;
    }

    public boolean c() {
        com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar = this.hf;
        if (xjVar != null) {
            return xjVar.w();
        }
        return false;
    }

    public String d() {
        com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar = this.hf;
        if (xjVar != null) {
            return xjVar.kd();
        }
        return null;
    }

    public boolean dk() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.xj xjVar = this.w;
        if (xjVar != null) {
            return xjVar.tf();
        }
        return false;
    }

    public w e() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.xj xjVar = this.w;
        if (xjVar != null) {
            return xjVar.w();
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> et() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.xj xjVar = this.w;
        if (xjVar == null || xjVar.u() == null) {
            return null;
        }
        Object obj = this.w.u().get("qa_config_tool");
        if (BpkvW3.BmvVmW(obj)) {
            return AaHO0E.AYUAbz(obj);
        }
        return null;
    }

    public String f() {
        com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar = this.hf;
        if (xjVar != null) {
            return xjVar.u();
        }
        return null;
    }

    public int[] g() {
        com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar = this.hf;
        if (xjVar != null) {
            return xjVar.d();
        }
        return null;
    }

    public PluginValueSet hf() {
        return this.xj;
    }

    public boolean ht() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.xj xjVar = this.w;
        if (xjVar != null) {
            return xjVar.f();
        }
        return false;
    }

    public Function<SparseArray<Object>, Object> io() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.xj xjVar = this.w;
        if (xjVar == null || xjVar.u() == null) {
            return null;
        }
        Object obj = this.w.u().get("qa_event_tool");
        if (BpkvW3.BmvVmW(obj)) {
            return AaHO0E.AYUAbz(obj);
        }
        return null;
    }

    public JSONObject jk() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.xj xjVar = this.w;
        if (xjVar != null) {
            return xjVar.y();
        }
        return null;
    }

    public String kd() {
        com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar = this.hf;
        if (xjVar != null) {
            return xjVar.xj();
        }
        return null;
    }

    public boolean p() {
        com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar = this.hf;
        if (xjVar != null) {
            return xjVar.c();
        }
        return false;
    }

    public boolean pl() {
        com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar = this.hf;
        if (xjVar != null) {
            return xjVar.tf();
        }
        return false;
    }

    public String pz() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.xj xjVar = this.w;
        return xjVar != null ? xjVar.c() : "";
    }

    public String qt() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.xj xjVar = this.w;
        if (xjVar != null) {
            return xjVar.xj();
        }
        return null;
    }

    public boolean ra() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.xj xjVar = this.w;
        if (xjVar != null) {
            return xjVar.d();
        }
        return false;
    }

    public int tf() {
        com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar = this.hf;
        if (xjVar != null) {
            return xjVar.y();
        }
        return 0;
    }

    public boolean u() {
        com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar = this.hf;
        if (xjVar != null) {
            return xjVar.f();
        }
        return false;
    }

    public boolean v() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.xj xjVar = this.w;
        if (xjVar != null) {
            return xjVar.kd();
        }
        return false;
    }

    public Function<SparseArray<Object>, Object> w() {
        PluginValueSet pluginValueSet = this.xj;
        if (pluginValueSet != null) {
            return AaHO0E.AYUAbz(pluginValueSet.objectValue(15, AaHO0E.ARc23Z()));
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> x() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.xj xjVar = this.w;
        if (xjVar == null || xjVar.u() == null) {
            return null;
        }
        Object obj = this.w.u().get("qa_onetap_tool");
        if (BpkvW3.BmvVmW(obj)) {
            return AaHO0E.AYUAbz(obj);
        }
        return null;
    }

    public String y() {
        com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar = this.hf;
        if (xjVar != null) {
            return xjVar.hf();
        }
        return null;
    }

    public Map<String, Object> yo() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.xj xjVar = this.w;
        if (xjVar != null) {
            return xjVar.u();
        }
        return null;
    }

    public boolean zg() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.xj xjVar = this.w;
        if (xjVar != null) {
            return xjVar.hf();
        }
        return false;
    }

    public boolean xj() {
        com.bytedance.sdk.openadsdk.zg.w.w.xj xjVar = this.hf;
        if (xjVar != null) {
            return xjVar.zg();
        }
        return false;
    }
}
