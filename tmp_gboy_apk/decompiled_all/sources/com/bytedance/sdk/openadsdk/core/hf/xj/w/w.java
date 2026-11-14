package com.bytedance.sdk.openadsdk.core.hf.xj.w;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.am.u;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends hf {
    private Map<String, Object> c;
    private EmptyView d;
    private Double f;
    xj kd;
    private String y;

    public interface xj {
        boolean xj();
    }

    public w() {
    }

    public void xj(xj xjVar) {
        this.kd = xjVar;
    }

    public w(ws wsVar, Context context) {
        this.xj = wsVar;
        this.hf = context;
        this.c = new HashMap();
    }

    public void xj(String str) {
        this.y = str;
    }

    public void xj(EmptyView emptyView) {
        this.d = emptyView;
    }

    public void xj(Map<String, Object> map) {
        Map<String, Object> map2 = this.c;
        if (map2 == null) {
            this.c = map;
        } else {
            map2.putAll(map);
        }
    }

    public void xj(Double d) {
        this.f = d;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hf.xj.w.hf, com.bytedance.sdk.openadsdk.core.hf.xj.xj
    public int xj(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.hf.xj.w wVar) {
        xj xjVar;
        if (!pz.hf().ee() || (xjVar = this.kd) == null || xjVar.xj()) {
            return 0;
        }
        EmptyView emptyView = this.d;
        if (emptyView == null) {
            this.c.put("show_send_type", 1);
            u.xj(this.xj, this.y, this.c, this.f);
        } else {
            emptyView.xj("checkWhenClicked");
        }
        return 0;
    }
}
