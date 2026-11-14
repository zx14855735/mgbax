package com.bytedance.msdk.core.tf;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c {
    private List<f> c;
    private double d;
    private JSONObject f;
    private String hf;
    private xj kd;
    private double p;
    private int tf;
    private f u;
    private String w;
    private String xj;
    private List<y> y;

    public static class xj {
        private List<tf> hf = new ArrayList();
        private String xj;

        public void xj(String str) {
            this.xj = str;
        }

        public void xj(List<tf> list) {
            this.hf = list;
        }
    }

    public JSONObject c() {
        return this.f;
    }

    public List<tf> d() {
        xj xjVar = this.kd;
        if (xjVar == null) {
            return null;
        }
        return xjVar.hf;
    }

    public boolean f() {
        xj xjVar = this.kd;
        return (xjVar == null || TextUtils.isEmpty(xjVar.xj)) ? false : true;
    }

    public int hf() {
        return this.tf;
    }

    public List<y> kd() {
        return this.y;
    }

    public List<f> u() {
        return this.c;
    }

    public double w() {
        return this.p;
    }

    public double xj() {
        return this.d;
    }

    public String y() {
        return this.w;
    }

    public void hf(String str) {
        try {
            this.p = Double.valueOf(str).doubleValue();
        } catch (Throwable unused) {
        }
    }

    public void kd(String str) {
        this.w = str;
    }

    public void u(String str) {
        this.hf = str;
    }

    public void w(String str) {
        this.xj = str;
    }

    public void xj(String str) {
        try {
            this.d = Double.valueOf(str).doubleValue();
        } catch (Throwable unused) {
        }
    }

    public void hf(List<y> list) {
        this.y = list;
    }

    public void xj(int i) {
        this.tf = i;
    }

    public void xj(List<f> list) {
        this.c = list;
    }

    public void xj(f fVar) {
        this.u = fVar;
    }

    public void xj(xj xjVar) {
        this.kd = xjVar;
    }

    public void xj(JSONObject jSONObject) {
        this.f = jSONObject;
    }
}
