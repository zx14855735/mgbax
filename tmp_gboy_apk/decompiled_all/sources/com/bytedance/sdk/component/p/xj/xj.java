package com.bytedance.sdk.component.p.xj;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.p.u.kd;
import com.bytedance.sdk.component.p.u.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private u c;
    private Map<String, Object> d;
    private String f;
    private Map<String, Object> hf;
    private String kd;
    private com.bytedance.sdk.component.p.u.hf p;
    private int tf = 1;
    private String u;
    private com.bytedance.sdk.component.p.w.xj w;
    private JSONObject xj;
    private u y;

    public xj(com.bytedance.sdk.component.p.w.xj xjVar, JSONObject jSONObject, Map<String, Object> map) {
        this.w = xjVar;
        this.xj = jSONObject;
        this.hf = map;
    }

    private void f() {
        if (this.tf != 2) {
            com.bytedance.sdk.component.p.w.xj xjVar = this.w;
            if (xjVar == null) {
                return;
            } else {
                this.f = xjVar.hf();
            }
        }
        if (!TextUtils.isEmpty(this.f)) {
            this.u = Uri.parse(this.f).getHost();
        }
        if (!TextUtils.isEmpty(this.u)) {
            String str = this.u.split("/")[0];
            this.u = str;
            int indexOf = str.indexOf(":");
            if (indexOf == -1) {
                indexOf = this.u.length();
            }
            this.u = this.u.substring(0, indexOf);
        }
        hf(this.f);
    }

    public com.bytedance.sdk.component.p.w.xj c() {
        return this.w;
    }

    public Map<String, Object> hf() {
        return this.d;
    }

    public u kd() {
        return this.y;
    }

    public String u() {
        return this.kd;
    }

    public JSONObject w() {
        return this.xj;
    }

    public Map<String, Object> xj() {
        return this.hf;
    }

    public void y() {
        f();
        com.bytedance.sdk.component.p.u.hf hfVar = this.p;
        if (hfVar != null) {
            hfVar.xj();
        } else {
            com.bytedance.sdk.component.p.c.xj.xj().xj(this.u, this, new com.bytedance.sdk.component.p.u.xj() { // from class: com.bytedance.sdk.component.p.xj.xj.1
            });
        }
    }

    private void hf(String str) {
        JSONObject xj = com.bytedance.sdk.component.p.f.hf.xj(str);
        if (xj == null) {
            return;
        }
        Iterator<String> keys = xj.keys();
        this.d = new HashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                Object opt = xj.opt(next);
                if (opt instanceof String) {
                    opt = xj((String) opt, this.xj);
                }
                this.d.put(next, opt);
            }
        }
    }

    public void xj(String str) {
        this.kd = str;
    }

    public void xj(u uVar) {
        if (uVar instanceof hf) {
            this.y = uVar;
        } else {
            this.c = uVar;
        }
    }

    public xj(StringBuilder sb, JSONObject jSONObject, Map<String, Object> map) {
        this.xj = jSONObject;
        this.hf = map;
    }

    private static Object xj(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return str;
        }
        try {
            return (str.startsWith("${") && str.endsWith("}")) ? com.bytedance.adsdk.hf.hf.xj.xj(str.substring(2, str.length() - 1)).xj(jSONObject) : str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public void xj(com.bytedance.sdk.component.p.u.hf hfVar) {
        this.p = hfVar;
    }

    public void hf(Map<String, Object> map) {
        kd hf;
        kd hf2;
        u uVar = this.y;
        if (uVar != null && (hf2 = uVar.hf()) != null) {
            hf2.hf(this, this.hf);
        }
        u uVar2 = this.c;
        if (uVar2 == null || (hf = uVar2.hf()) == null) {
            return;
        }
        hf.hf(this, map);
    }

    public void xj(Map<String, Object> map) {
        kd hf;
        kd hf2;
        u uVar = this.y;
        if (uVar != null && (hf2 = uVar.hf()) != null) {
            hf2.xj(this, map);
        }
        u uVar2 = this.c;
        if (uVar2 == null || (hf = uVar2.hf()) == null) {
            return;
        }
        hf.xj(this, map);
    }
}
