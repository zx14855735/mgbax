package com.bytedance.sdk.component.y.w.xj.hf;

import com.bytedance.sdk.component.y.ai;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements ai {
    private int hf;
    private com.bytedance.sdk.component.y.w.xj.w<String, byte[]> w;
    private int xj;

    public w(int i, int i2) {
        this.hf = i;
        this.xj = i2;
        this.w = new com.bytedance.sdk.component.y.w.xj.w<String, byte[]>(i) { // from class: com.bytedance.sdk.component.y.w.xj.hf.w.1
            @Override // com.bytedance.sdk.component.y.w.xj.w
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public int hf(String str, byte[] bArr) {
                if (bArr == null) {
                    return 0;
                }
                return bArr.length;
            }
        };
    }

    @Override // com.bytedance.sdk.component.y.xj
    public boolean hf(String str) {
        return this.w.xj((com.bytedance.sdk.component.y.w.xj.w<String, byte[]>) str) != null;
    }

    @Override // com.bytedance.sdk.component.y.xj
    public boolean xj(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return false;
        }
        this.w.xj(str, bArr);
        return true;
    }

    @Override // com.bytedance.sdk.component.y.xj
    public byte[] xj(String str) {
        return this.w.xj((com.bytedance.sdk.component.y.w.xj.w<String, byte[]>) str);
    }

    @Override // com.bytedance.sdk.component.y.xj
    public void xj(double d) {
        this.w.xj((int) (this.hf * d));
    }
}
