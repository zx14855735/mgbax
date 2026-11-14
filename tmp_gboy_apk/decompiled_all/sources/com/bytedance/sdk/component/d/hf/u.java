package com.bytedance.sdk.component.d.hf;

import android.text.TextUtils;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.pl;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class u {
    private Object hf;
    protected pl w;
    private Map<String, Object> xj;
    protected String u = null;
    protected final Map<String, String> kd = new HashMap();
    protected String y = null;
    protected boolean c = false;

    public u(pl plVar) {
        this.w = plVar;
        hf(UUID.randomUUID().toString());
    }

    public void hf(String str, String str2) {
        this.kd.put(str, str2);
    }

    public void kd(Map<String, Object> map) {
        this.xj = map;
    }

    public void u(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.kd.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public Map<String, Object> w() {
        return this.xj;
    }

    public abstract com.bytedance.sdk.component.d.hf xj();

    public void xj(String str) {
        this.y = str;
    }

    public void hf(String str) {
        this.u = str;
    }

    public void xj(am.xj xjVar) {
        if (xjVar != null && this.kd.size() > 0) {
            for (Map.Entry<String, String> entry : this.kd.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    xjVar.hf(key, value);
                }
            }
        }
    }

    public String hf() {
        return this.u;
    }

    public Object u() {
        return this.hf;
    }

    public void xj(boolean z) {
        this.c = z;
    }
}
