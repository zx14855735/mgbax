package com.bytedance.msdk.api;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private String am;
    private int c;
    private String d;
    private final Map<String, String> e = new HashMap();
    private String f;
    private String g;
    private String hf;
    private String kd;
    private String p;

    /* renamed from: pl, reason: collision with root package name */
    private String f10118pl;
    private String qt;
    private String tf;
    private String u;
    private String w;
    private int xj;
    private String y;
    private String zg;

    public String am() {
        return this.kd;
    }

    public String c() {
        return this.qt;
    }

    public String d() {
        return this.hf;
    }

    public String e() {
        return this.d;
    }

    public String f() {
        return this.zg;
    }

    public String g() {
        return this.y;
    }

    public String hf() {
        return this.tf;
    }

    public String kd() {
        return this.g;
    }

    public String p() {
        return this.u;
    }

    public String pl() {
        return TextUtils.isEmpty(this.w) ? this.hf : this.w;
    }

    public int qt() {
        return this.c;
    }

    public String tf() {
        return this.w;
    }

    public String toString() {
        return "{mSdkNum='" + this.xj + "', mSlotId='" + this.u + "', mLevelTag='" + this.kd + "', mEcpm=" + this.y + ", mReqBiddingType=" + this.c + "', mRequestId=" + this.d + ", mSubRitType=" + this.p + '}';
    }

    public String u() {
        return this.f10118pl;
    }

    public String w() {
        return this.p;
    }

    public void xj(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.e.clear();
        this.e.putAll(map);
    }

    public String y() {
        return this.am;
    }

    public String zg() {
        return this.f;
    }

    public void am(String str) {
        this.d = str;
    }

    public void c(String str) {
        this.zg = str;
    }

    public void d(String str) {
        this.w = str;
    }

    public void f(String str) {
        this.hf = str;
    }

    public void g(String str) {
        this.f = str;
    }

    public void hf(String str) {
        this.p = str;
    }

    public void kd(String str) {
        this.am = str;
    }

    public void p(String str) {
        this.y = str;
    }

    public void pl(String str) {
        this.kd = str;
    }

    public void tf(String str) {
        this.u = str;
    }

    public void u(String str) {
        this.g = str;
    }

    public void w(String str) {
        this.f10118pl = str;
    }

    public void y(String str) {
        this.qt = str;
    }

    public void hf(int i) {
        this.c = i;
    }

    public Map<String, String> xj() {
        return this.e;
    }

    public void xj(String str) {
        this.tf = str;
    }

    public void xj(int i) {
        this.xj = i;
    }
}
