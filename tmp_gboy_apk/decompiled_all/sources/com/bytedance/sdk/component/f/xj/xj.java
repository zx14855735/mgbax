package com.bytedance.sdk.component.f.xj;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements kd {
    private int am;
    private com.bytedance.sdk.component.f.hf.u.hf.xj c;
    private com.bytedance.sdk.component.f.hf.u.hf.xj d;
    private com.bytedance.sdk.component.f.hf.u.hf.xj f;
    private int g;
    private p hf;
    private com.bytedance.sdk.component.f.hf.u.hf.xj kd;
    private u p;

    /* renamed from: pl, reason: collision with root package name */
    private AtomicBoolean f10207pl;
    private boolean tf;
    private Context u;
    private String w;
    private y xj;
    private com.bytedance.sdk.component.f.hf.u.hf.xj y;

    /* renamed from: com.bytedance.sdk.component.f.xj.xj$xj, reason: collision with other inner class name */
    public static class C0111xj {
        private u c;
        private y f;
        private Context g;
        private com.bytedance.sdk.component.f.hf.u.hf.xj hf;
        private com.bytedance.sdk.component.f.hf.u.hf.xj kd;

        /* renamed from: pl, reason: collision with root package name */
        private String f10208pl;
        private com.bytedance.sdk.component.f.hf.u.hf.xj u;
        private com.bytedance.sdk.component.f.hf.u.hf.xj w;
        private p xj;
        private boolean y;
        private final AtomicBoolean d = new AtomicBoolean(false);
        private int tf = 5000;
        private int p = 10;

        public C0111xj hf(boolean z) {
            this.y = z;
            return this;
        }

        public C0111xj w(com.bytedance.sdk.component.f.hf.u.hf.xj xjVar) {
            this.u = xjVar;
            return this;
        }

        public C0111xj xj(Context context) {
            this.g = context;
            return this;
        }

        public C0111xj hf(com.bytedance.sdk.component.f.hf.u.hf.xj xjVar) {
            this.w = xjVar;
            return this;
        }

        public C0111xj xj(String str) {
            this.f10208pl = str;
            return this;
        }

        public C0111xj xj(boolean z) {
            this.d.set(z);
            return this;
        }

        public C0111xj xj(y yVar) {
            this.f = yVar;
            return this;
        }

        public C0111xj xj(u uVar) {
            this.c = uVar;
            return this;
        }

        public C0111xj xj(com.bytedance.sdk.component.f.hf.u.hf.xj xjVar) {
            this.hf = xjVar;
            return this;
        }

        public C0111xj xj(p pVar) {
            this.xj = pVar;
            return this;
        }

        public xj xj() {
            xj xjVar = new xj();
            xjVar.hf = this.xj;
            xjVar.kd = this.hf;
            xjVar.y = this.w;
            xjVar.c = this.u;
            xjVar.f = this.kd;
            xjVar.tf = this.y;
            xjVar.p = this.c;
            xjVar.xj = this.f;
            xjVar.f10207pl = this.d;
            xjVar.w = this.f10208pl;
            xjVar.u = this.g;
            xjVar.am = this.p;
            xjVar.g = this.tf;
            return xjVar;
        }
    }

    @Override // com.bytedance.sdk.component.f.xj.kd
    public com.bytedance.sdk.component.f.hf.u.hf.xj c() {
        return this.kd;
    }

    @Override // com.bytedance.sdk.component.f.xj.kd
    public com.bytedance.sdk.component.f.hf.u.hf.xj d() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.f.xj.kd
    public com.bytedance.sdk.component.f.hf.u.hf.xj f() {
        return this.y;
    }

    @Override // com.bytedance.sdk.component.f.xj.kd
    public Context getContext() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.f.xj.kd
    public String kd() {
        return this.w;
    }

    @Override // com.bytedance.sdk.component.f.xj.kd
    public boolean p() {
        return this.tf;
    }

    @Override // com.bytedance.sdk.component.f.xj.kd
    public p tf() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.f.xj.kd
    public com.bytedance.sdk.component.f.hf.u.hf.xj y() {
        return this.d;
    }

    private xj() {
        this.f10207pl = new AtomicBoolean(false);
        this.g = 200;
        this.am = 10;
    }

    @Override // com.bytedance.sdk.component.f.xj.kd
    public u u() {
        return this.p;
    }

    @Override // com.bytedance.sdk.component.f.xj.kd
    public boolean w() {
        return this.f10207pl.get();
    }

    @Override // com.bytedance.sdk.component.f.xj.kd
    public y hf() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.component.f.xj.kd
    public com.bytedance.sdk.component.f.hf.u.hf.xj xj() {
        return this.f;
    }

    @Override // com.bytedance.sdk.component.f.xj.kd
    public void xj(y yVar) {
        this.xj = yVar;
    }

    @Override // com.bytedance.sdk.component.f.xj.kd
    public void xj(boolean z) {
        this.f10207pl.set(z);
    }
}
