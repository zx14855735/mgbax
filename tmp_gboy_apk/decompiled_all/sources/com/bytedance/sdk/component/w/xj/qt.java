package com.bytedance.sdk.component.w.xj;

import com.fl.saas.videocache.ProxyCacheUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class qt {
    qt c;
    int hf;
    boolean kd;
    boolean u;
    int w;
    final byte[] xj;
    qt y;

    public qt() {
        this.xj = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
        this.kd = true;
        this.u = false;
    }

    public final qt hf() {
        qt qtVar = this.y;
        qt qtVar2 = qtVar != this ? qtVar : null;
        qt qtVar3 = this.c;
        if (qtVar3 != null) {
            qtVar3.y = qtVar;
        }
        qt qtVar4 = this.y;
        if (qtVar4 != null) {
            qtVar4.c = qtVar3;
        }
        this.y = null;
        this.c = null;
        return qtVar2;
    }

    public final void w() {
        qt qtVar = this.c;
        if (qtVar == this) {
            throw new IllegalStateException();
        }
        if (qtVar.kd) {
            int i = this.w - this.hf;
            if (i > (8192 - qtVar.w) + (qtVar.u ? 0 : qtVar.hf)) {
                return;
            }
            xj(qtVar, i);
            hf();
            zg.xj(this);
        }
    }

    public final qt xj() {
        this.u = true;
        return new qt(this.xj, this.hf, this.w, true, false);
    }

    public final qt xj(qt qtVar) {
        qtVar.c = this;
        qtVar.y = this.y;
        this.y.c = qtVar;
        this.y = qtVar;
        return qtVar;
    }

    public qt(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.xj = bArr;
        this.hf = i;
        this.w = i2;
        this.u = z;
        this.kd = z2;
    }

    public final qt xj(int i) {
        qt xj;
        if (i > 0 && i <= this.w - this.hf) {
            if (i >= 1024) {
                xj = xj();
            } else {
                xj = zg.xj();
                System.arraycopy(this.xj, this.hf, xj.xj, 0, i);
            }
            xj.w = xj.hf + i;
            this.hf += i;
            this.c.xj(xj);
            return xj;
        }
        throw new IllegalArgumentException();
    }

    public final void xj(qt qtVar, int i) {
        if (qtVar.kd) {
            int i2 = qtVar.w;
            if (i2 + i > 8192) {
                if (!qtVar.u) {
                    int i3 = qtVar.hf;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = qtVar.xj;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        qtVar.w -= qtVar.hf;
                        qtVar.hf = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.xj, this.hf, qtVar.xj, qtVar.w, i);
            qtVar.w += i;
            this.hf += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
