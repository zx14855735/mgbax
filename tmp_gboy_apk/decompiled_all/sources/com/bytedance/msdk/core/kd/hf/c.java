package com.bytedance.msdk.core.kd.hf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c implements Comparable<c> {
    private long hf;
    private com.bytedance.msdk.api.xj.hf u;
    private boolean w = false;
    public com.bytedance.msdk.hf.w xj;

    public c(com.bytedance.msdk.hf.w wVar, long j, com.bytedance.msdk.api.xj.hf hfVar) {
        this.xj = wVar;
        this.hf = j;
        this.u = hfVar;
    }

    public boolean c() {
        com.bytedance.msdk.hf.w wVar = this.xj;
        if (wVar == null) {
            return false;
        }
        return wVar.ht();
    }

    public String hf() {
        com.bytedance.msdk.hf.w wVar = this.xj;
        if (wVar == null) {
            return null;
        }
        return wVar.cy();
    }

    public boolean kd() {
        com.bytedance.msdk.hf.w wVar = this.xj;
        return (wVar == null || this.u == null || wVar.tu() || !this.xj.ff(this.u.ra())) ? false : true;
    }

    public com.bytedance.msdk.api.xj.hf u() {
        return this.u;
    }

    public boolean w() {
        return this.w;
    }

    @Override // java.lang.Comparable
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        return this.xj.compareTo(cVar.xj);
    }

    public String y() {
        com.bytedance.msdk.api.xj.hf hfVar = this.u;
        if (hfVar == null) {
            return null;
        }
        return hfVar.ra();
    }

    public long xj() {
        return this.hf;
    }

    public void hf(boolean z) {
        com.bytedance.msdk.hf.w wVar = this.xj;
        if (wVar == null) {
            return;
        }
        wVar.xj(z);
    }

    public void xj(boolean z) {
        this.w = z;
    }
}
