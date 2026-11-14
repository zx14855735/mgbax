package com.bytedance.sdk.component.y.w.xj.hf;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.y.x;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements x {
    private int hf;
    private com.bytedance.sdk.component.y.w.xj.w<String, Bitmap> w;
    private int xj;

    public hf(int i, int i2) {
        this.hf = i;
        this.xj = i2;
        this.w = new com.bytedance.sdk.component.y.w.xj.w<String, Bitmap>(i) { // from class: com.bytedance.sdk.component.y.w.xj.hf.hf.1
            @Override // com.bytedance.sdk.component.y.w.xj.w
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public int hf(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    return 0;
                }
                return hf.xj(bitmap);
            }
        };
    }

    @Override // com.bytedance.sdk.component.y.xj
    public boolean hf(String str) {
        return this.w.xj((com.bytedance.sdk.component.y.w.xj.w<String, Bitmap>) str) != null;
    }

    @Override // com.bytedance.sdk.component.y.xj
    public boolean xj(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return false;
        }
        this.w.xj(str, bitmap);
        return true;
    }

    @Override // com.bytedance.sdk.component.y.xj
    public Bitmap xj(String str) {
        return this.w.xj((com.bytedance.sdk.component.y.w.xj.w<String, Bitmap>) str);
    }

    @Override // com.bytedance.sdk.component.y.xj
    public void xj(double d) {
        this.w.xj((int) (this.hf * d));
    }

    public static int xj(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getAllocationByteCount();
    }
}
