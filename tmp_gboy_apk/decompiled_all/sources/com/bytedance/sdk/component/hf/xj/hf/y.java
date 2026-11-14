package com.bytedance.sdk.component.hf.xj.hf;

import com.fl.saas.videocache.ProxyCacheUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class y {
    y c;
    int hf;
    boolean kd;
    boolean u;
    int w;
    final byte[] xj;
    y y;

    public y() {
        this.xj = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
        this.kd = true;
        this.u = false;
    }

    public final y hf() {
        y yVar = this.y;
        y yVar2 = yVar != this ? yVar : null;
        y yVar3 = this.c;
        if (yVar3 != null) {
            yVar3.y = yVar;
        }
        y yVar4 = this.y;
        if (yVar4 != null) {
            yVar4.c = yVar3;
        }
        this.y = null;
        this.c = null;
        return yVar2;
    }

    public final y xj() {
        this.u = true;
        return new y(this.xj, this.hf, this.w, true, false);
    }

    public final y xj(y yVar) {
        yVar.c = this;
        yVar.y = this.y;
        this.y.c = yVar;
        this.y = yVar;
        return yVar;
    }

    public y(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.xj = bArr;
        this.hf = i;
        this.w = i2;
        this.u = z;
        this.kd = z2;
    }
}
