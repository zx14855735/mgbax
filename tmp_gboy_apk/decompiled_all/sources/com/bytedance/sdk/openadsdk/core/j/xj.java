package com.bytedance.sdk.openadsdk.core.j;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public int dk;
    public List<String> e;
    public int et;
    public String xj;
    public int hf = 1;
    public int w = 1;
    public int u = 2;
    public int kd = 1;
    public int y = 0;
    public int c = 1;
    public int f = 3;
    public int d = 0;
    public int tf = 0;
    public int p = 0;

    /* renamed from: pl, reason: collision with root package name */
    public int f10366pl = 1;
    public int g = 0;
    public int am = TTAdConstant.STYLE_SIZE_RADIO_3_2;
    public int qt = 2000;
    public boolean zg = false;
    public int yo = 2;
    public int v = 100;
    public int jk = 0;
    public boolean pz = false;
    public boolean ht = false;
    public long ra = 0;

    private xj() {
    }

    public static xj xj() {
        return new xj();
    }

    public xj am(int i) {
        this.c = i;
        return this;
    }

    public xj c(int i) {
        this.d = i;
        return this;
    }

    public xj d(int i) {
        this.hf = i;
        return this;
    }

    public xj e(int i) {
        this.v = i;
        return this;
    }

    public xj f(int i) {
        this.tf = i;
        return this;
    }

    public xj g(int i) {
        this.y = i;
        return this;
    }

    public int hf() {
        return this.et;
    }

    public xj kd(int i) {
        this.am = i;
        return this;
    }

    public xj p(int i) {
        this.u = i;
        return this;
    }

    public xj pl(int i) {
        this.kd = i;
        return this;
    }

    public xj qt(int i) {
        this.f10366pl = i;
        return this;
    }

    public xj tf(int i) {
        this.w = i;
        return this;
    }

    public xj u(int i) {
        this.g = i;
        return this;
    }

    public int w() {
        return this.dk;
    }

    public xj y(int i) {
        this.p = i;
        return this;
    }

    public xj yo(int i) {
        this.jk = i;
        return this;
    }

    public xj zg(int i) {
        this.yo = i;
        return this;
    }

    public xj hf(int i) {
        this.dk = i;
        return this;
    }

    public xj w(int i) {
        this.qt = i;
        return this;
    }

    public xj xj(int i) {
        this.et = i;
        return this;
    }

    public xj hf(boolean z) {
        this.ht = z;
        return this;
    }

    public xj w(boolean z) {
        this.zg = z;
        return this;
    }

    public xj xj(boolean z) {
        this.pz = z;
        return this;
    }

    public xj xj(long j) {
        this.ra = j;
        return this;
    }

    public xj xj(String str) {
        this.xj = str;
        return this;
    }
}
