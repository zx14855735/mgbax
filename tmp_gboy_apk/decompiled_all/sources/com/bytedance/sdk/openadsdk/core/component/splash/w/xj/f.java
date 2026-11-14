package com.bytedance.sdk.openadsdk.core.component.splash.w.xj;

import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f extends xj {
    private boolean am;
    private long d;
    private String e;
    private String g;
    private long p;

    /* renamed from: pl, reason: collision with root package name */
    private Map<String, String> f10339pl;
    private boolean qt;
    private long tf;
    private com.bytedance.sdk.openadsdk.core.et.xj.hf u;
    private com.bytedance.sdk.component.d.hf y;
    private long yo;
    private com.bytedance.sdk.openadsdk.zg.w.hf.hf zg;
    private boolean kd = false;
    private boolean c = false;
    private boolean f = false;
    private AtomicBoolean v = new AtomicBoolean(false);

    public f(ws wsVar, boolean z) {
        this.hf = wsVar;
        this.am = z;
    }

    public long am() {
        return this.yo;
    }

    public long c() {
        return this.d;
    }

    public Map<String, String> d() {
        return this.f10339pl;
    }

    public long f() {
        return this.p;
    }

    public String g() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xj.xj
    public ws hf() {
        return this.hf;
    }

    public boolean kd() {
        return this.kd;
    }

    public boolean p() {
        return this.am;
    }

    public com.bytedance.sdk.openadsdk.zg.w.hf.hf pl() {
        return this.zg;
    }

    public boolean qt() {
        return this.v.get();
    }

    public boolean tf() {
        return this.f;
    }

    public com.bytedance.sdk.openadsdk.core.et.xj.hf u() {
        return this.u;
    }

    public void w(long j) {
        this.tf = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xj.xj
    public int xj() {
        return this.xj;
    }

    public boolean y() {
        return this.c;
    }

    public void hf(boolean z) {
        this.c = z;
    }

    public void kd(long j) {
        this.yo = j;
    }

    public void u(long j) {
        this.p = j;
    }

    public void w(boolean z) {
        this.f = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xj.xj
    public void xj(int i) {
        this.xj = i;
    }

    public void hf(long j) {
        this.d = j;
    }

    public void kd(boolean z) {
        this.v.set(z);
    }

    public void u(boolean z) {
        this.qt = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xj.xj
    public void xj(ws wsVar) {
        this.hf = wsVar;
    }

    public void hf(String str) {
        this.e = str;
    }

    public void xj(boolean z) {
        this.kd = z;
    }

    public void xj(com.bytedance.sdk.component.d.hf hfVar) {
        this.y = hfVar;
    }

    public void xj(Map<String, String> map) {
        this.f10339pl = map;
    }

    public void xj(String str) {
        this.g = str;
    }

    public f(com.bytedance.sdk.openadsdk.core.et.xj.hf hfVar, ws wsVar, boolean z) {
        this.u = hfVar;
        this.hf = wsVar;
        this.am = z;
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar) {
        this.zg = hfVar;
    }
}
