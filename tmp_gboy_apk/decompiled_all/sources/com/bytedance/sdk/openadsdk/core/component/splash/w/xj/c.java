package com.bytedance.sdk.openadsdk.core.component.splash.w.xj;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c extends xj {
    private int c;
    private com.bytedance.sdk.openadsdk.zg.w.hf.hf d;
    private boolean f;
    private String kd;
    private int p;
    private long tf;
    private int u;
    private boolean y;

    public c() {
        this.u = -1;
        this.kd = MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
        this.y = false;
        this.f = false;
        this.p = -1;
    }

    public int c() {
        return this.c;
    }

    public com.bytedance.sdk.openadsdk.zg.w.hf.hf d() {
        return this.d;
    }

    public boolean f() {
        return this.f;
    }

    public void hf(int i) {
        this.u = i;
    }

    public String kd() {
        return TextUtils.isEmpty(this.kd) ? MediationConfigUserInfoForSegment.GENDER_UNKNOWN : this.kd;
    }

    public int u() {
        return this.u;
    }

    public void w(int i) {
        this.p = i;
    }

    public void xj(String str) {
        this.kd = str;
    }

    public boolean y() {
        return this.y;
    }

    public void hf(boolean z) {
        this.f = z;
    }

    public void u(int i) {
        this.c = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xj.xj
    public long w() {
        return this.tf;
    }

    public void xj(boolean z) {
        this.y = z;
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar) {
        this.d = hfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xj.xj
    public void xj(long j) {
        this.tf = j;
    }

    public c(int i, String str, boolean z) {
        this.y = false;
        this.p = -1;
        this.u = i;
        this.kd = str;
        this.f = z;
    }
}
