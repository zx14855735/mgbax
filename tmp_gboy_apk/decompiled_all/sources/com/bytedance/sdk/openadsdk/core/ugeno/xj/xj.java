package com.bytedance.sdk.openadsdk.core.ugeno.xj;

import com.bytedance.sdk.component.adexpress.hf.g;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj implements hf {
    public static boolean hf(ws wsVar) {
        return wsVar != null && hl.w(wsVar) == 2 && w(wsVar);
    }

    private static int kd(ws wsVar) {
        int f;
        if (wsVar == null) {
            return -1;
        }
        com.bytedance.sdk.openadsdk.zg.w.w.hf gh = wsVar.gh();
        int jk = gh != null ? gh.jk() : -1;
        return ((jk <= 0 || jk >= 10) && (f = wo.f(wsVar)) > 0 && f < 10) ? f : jk;
    }

    private int u(ws wsVar) {
        if (wsVar == null) {
            return -1;
        }
        return wsVar.rx();
    }

    public static boolean w(ws wsVar) {
        return kd(wsVar) == 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.xj.hf
    public String xj(ws wsVar) {
        int kd = kd(wsVar);
        int u = u(wsVar);
        if (kd <= 0 || kd > 9 || u == -1) {
            return null;
        }
        return xj(wsVar, kd, u);
    }

    public abstract String xj(ws wsVar, int i, int i2);

    public static hf xj(ws wsVar, g gVar) {
        if (wsVar == null || kd(wsVar) != 5) {
            return null;
        }
        if ((gVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.hf) && ((com.bytedance.sdk.openadsdk.core.ugeno.express.hf) gVar).ff()) {
            return new com.bytedance.sdk.openadsdk.core.ugeno.xj.hf.xj();
        }
        return new com.bytedance.sdk.openadsdk.core.ugeno.xj.xj.xj();
    }
}
