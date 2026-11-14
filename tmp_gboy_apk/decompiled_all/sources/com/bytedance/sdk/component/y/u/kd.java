package com.bytedance.sdk.component.y.u;

import J3FDQU.A2egSU;
import android.graphics.Bitmap;
import com.bytedance.sdk.component.y.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends xj {
    private com.bytedance.sdk.component.y.c hf;
    private byte[] xj;

    public kd(byte[] bArr, com.bytedance.sdk.component.y.c cVar) {
        this.xj = bArr;
        this.hf = cVar;
    }

    @Override // com.bytedance.sdk.component.y.u.d
    public void xj(com.bytedance.sdk.component.y.w.w wVar) {
        com.bytedance.sdk.component.y.w.y pl2 = wVar.pl();
        com.bytedance.sdk.component.y.w.hf.xj xj = pl2.xj(wVar);
        try {
            jk qt = wVar.qt();
            if (qt != null) {
                qt.onStep(10, null);
            }
            Bitmap xj2 = xj.xj(this.xj);
            if (xj2 != null) {
                wVar.xj(new g(xj2, this.xj, this.hf, false));
                pl2.xj(wVar.g()).xj(wVar.getMemoryCacheKey(), xj2);
            } else {
                xj(1002, "decode failed bitmap null", null, wVar);
            }
            if (qt != null) {
                qt.onStep(11, xj2);
            }
        } catch (Throwable th) {
            xj(1002, A2egSU.B4ZgIw(th, new StringBuilder("decode failed:")), th, wVar);
        }
    }

    private void xj(int i, String str, Throwable th, com.bytedance.sdk.component.y.w.w wVar) {
        if (this.hf == null) {
            wVar.xj(new p());
        } else {
            wVar.xj(new f(i, str, th));
        }
    }

    @Override // com.bytedance.sdk.component.y.u.d
    public String xj() {
        return "decode";
    }
}
