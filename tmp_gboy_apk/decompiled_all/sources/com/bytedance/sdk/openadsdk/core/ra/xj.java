package com.bytedance.sdk.openadsdk.core.ra;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private int hf;
    private JSONObject kd;
    private List<ws> u = new ArrayList();
    private String w;
    private String xj;
    private long y;

    public void hf(String str) {
        this.w = str;
    }

    public JSONObject w() {
        return this.kd;
    }

    public void xj(String str) {
        this.xj = str;
    }

    public List<ws> hf() {
        return this.u;
    }

    public int xj() {
        return this.hf;
    }

    public void xj(int i) {
        this.hf = i;
    }

    public void xj(ws wsVar) {
        this.u.add(wsVar);
    }

    public void xj(List<ws> list) {
        this.u = list;
    }

    public void xj(JSONObject jSONObject) {
        this.kd = jSONObject;
    }

    public void xj(long j) {
        this.y = j;
    }
}
