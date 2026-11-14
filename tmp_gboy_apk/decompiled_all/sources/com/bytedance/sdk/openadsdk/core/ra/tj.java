package com.bytedance.sdk.openadsdk.core.ra;

import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class tj {
    public long d;
    public String hf;
    public long p;
    public Bundle qt;
    public long tf;
    public int u;
    public int w;
    private String zg = com.bytedance.sdk.openadsdk.core.a.wo.f();
    public int xj = -1;
    public JSONArray kd = null;
    public int y = 1;
    public long c = System.currentTimeMillis();
    public long f = System.currentTimeMillis();

    /* renamed from: pl, reason: collision with root package name */
    public JSONObject f10415pl = null;
    public int g = -1;
    public com.bytedance.sdk.openadsdk.core.ra am = com.bytedance.sdk.openadsdk.core.ra.xj("");

    public String hf() {
        return this.zg;
    }

    public tj xj() {
        tj tjVar = new tj();
        tjVar.xj = this.xj;
        tjVar.kd = this.kd;
        tjVar.y = this.y;
        tjVar.c = this.c;
        tjVar.d = this.d;
        tjVar.tf = this.tf;
        tjVar.p = this.p;
        tjVar.g = this.g;
        return tjVar;
    }

    public void xj(String str) {
        this.zg = str;
    }

    public void xj(String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.ra raVar;
        if (!z || (raVar = this.am) == null || str == null) {
            return;
        }
        raVar.hf("cst_".concat(str));
    }

    public void xj(String str, long j, boolean z) {
        com.bytedance.sdk.openadsdk.core.ra raVar;
        if (!z || (raVar = this.am) == null || str == null) {
            return;
        }
        raVar.xj("cst_".concat(str), j);
    }
}
