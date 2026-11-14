package com.bytedance.msdk.api.u.xj.c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf {
    public final Map<String, Integer> am;
    public final int c;
    public final int d;
    public final int f;
    public final int g;
    public final int hf;
    public final int kd;
    public final int p;

    /* renamed from: pl, reason: collision with root package name */
    public final int f10113pl;
    public final int tf;
    public final int u;
    public final int w;
    public final int xj;
    public final int y;

    public static class xj {
        protected Map<String, Integer> am;
        protected int c;
        protected int d;
        protected int f;
        protected int g;
        protected int hf;
        protected int kd;
        protected int p;

        /* renamed from: pl, reason: collision with root package name */
        protected int f10114pl;
        protected int tf;
        protected int u;
        protected int w;
        protected int xj;
        protected int y;

        public xj(int i) {
            this.am = Collections.EMPTY_MAP;
            this.xj = i;
            this.am = new HashMap();
        }

        public xj c(int i) {
            this.f = i;
            return this;
        }

        public xj d(int i) {
            this.w = i;
            return this;
        }

        public xj f(int i) {
            this.c = i;
            return this;
        }

        public xj hf(int i) {
            this.d = i;
            return this;
        }

        public xj kd(int i) {
            this.f10114pl = i;
            return this;
        }

        public xj p(int i) {
            this.kd = i;
            return this;
        }

        public xj tf(int i) {
            this.u = i;
            return this;
        }

        public xj u(int i) {
            this.p = i;
            return this;
        }

        public xj w(int i) {
            this.tf = i;
            return this;
        }

        public xj xj(int i) {
            this.hf = i;
            return this;
        }

        public xj y(int i) {
            this.y = i;
            return this;
        }

        public xj xj(Map<String, Integer> map) {
            this.am = new HashMap(map);
            return this;
        }

        public tf xj() {
            return new tf(this);
        }
    }

    public tf(xj xjVar) {
        this.xj = xjVar.xj;
        this.hf = xjVar.hf;
        this.w = xjVar.w;
        this.u = xjVar.u;
        this.kd = xjVar.kd;
        this.y = xjVar.y;
        this.c = xjVar.c;
        this.f = xjVar.f;
        this.am = xjVar.am;
        this.d = xjVar.tf;
        this.tf = xjVar.p;
        this.p = xjVar.f10114pl;
        this.f10113pl = xjVar.d;
        this.g = xjVar.g;
    }

    public static tf xj(com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.u uVar) {
        if (uVar == null) {
            return null;
        }
        xj xjVar = new xj(uVar.xj());
        xjVar.xj(uVar.hf()).tf(uVar.u()).d(uVar.w()).w(uVar.d()).u(uVar.tf()).kd(uVar.p()).y(uVar.y()).f(uVar.c()).p(uVar.kd()).hf(uVar.pl()).c(uVar.f()).xj(uVar.g());
        return xjVar.xj();
    }

    public static com.bytedance.msdk.xj.u.hf.xj xj(tf tfVar) {
        if (tfVar != null) {
            return new com.bytedance.msdk.xj.u.hf.xj(tfVar);
        }
        return null;
    }
}
