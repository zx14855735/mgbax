package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y {
    private HashMap<String, String> am = new HashMap<>();
    private String c;
    private JSONArray d;
    private String f;
    private JSONArray g;
    private String hf;
    private String kd;
    private String p;

    /* renamed from: pl, reason: collision with root package name */
    private float f10425pl;
    private String tf;
    private String u;
    private String w;
    private String xj;
    private String y;

    public String am() {
        return this.p;
    }

    public String c() {
        return this.w;
    }

    public String d() {
        return this.y;
    }

    public String f() {
        return this.u;
    }

    public String g() {
        return this.tf;
    }

    public String hf() {
        return this.kd;
    }

    public String kd() {
        return this.xj;
    }

    public String p() {
        return this.f;
    }

    public JSONArray pl() {
        return this.d;
    }

    public String tf() {
        return this.c;
    }

    public JSONArray u() {
        return this.g;
    }

    public float w() {
        return this.f10425pl;
    }

    public void xj(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.am.put(str, str2);
    }

    public String y() {
        return this.hf;
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.tf = str;
    }

    public void f(String str) {
        this.f = str;
    }

    public void hf(String str) {
        this.xj = str;
    }

    public void kd(String str) {
        this.u = str;
    }

    public void tf(String str) {
        this.p = str;
    }

    public void u(String str) {
        this.w = str;
    }

    public void w(String str) {
        this.hf = str;
    }

    public void y(String str) {
        this.y = str;
    }

    public void hf(JSONArray jSONArray) {
        this.d = jSONArray;
    }

    public HashMap<String, String> xj() {
        return this.am;
    }

    public void xj(String str) {
        this.kd = str;
    }

    public void xj(float f) {
        this.f10425pl = f;
    }

    public void xj(JSONArray jSONArray) {
        this.g = jSONArray;
    }
}
