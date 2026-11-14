package com.bytedance.sdk.component.w.hf;

import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class x {
    public static x xj(pz pzVar, String str) {
        Charset charset = com.bytedance.sdk.component.w.hf.xj.w.kd;
        if (pzVar != null) {
            Charset w = pzVar.w();
            if (w == null) {
                pzVar = pz.xj(pzVar + "; charset=utf-8");
            } else {
                charset = w;
            }
        }
        return xj(pzVar, str.getBytes(charset));
    }

    public long hf() {
        return -1L;
    }

    public abstract pz xj();

    public abstract void xj(com.bytedance.sdk.component.w.xj.u uVar);

    public static x xj(pz pzVar, byte[] bArr) {
        return xj(pzVar, bArr, 0, bArr.length);
    }

    public static x xj(final pz pzVar, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            com.bytedance.sdk.component.w.hf.xj.w.xj(bArr.length, i, i2);
            return new x() { // from class: com.bytedance.sdk.component.w.hf.x.1
                @Override // com.bytedance.sdk.component.w.hf.x
                public long hf() {
                    return i2;
                }

                @Override // com.bytedance.sdk.component.w.hf.x
                public pz xj() {
                    return pz.this;
                }

                @Override // com.bytedance.sdk.component.w.hf.x
                public void xj(com.bytedance.sdk.component.w.xj.u uVar) {
                    uVar.w(bArr, i, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
