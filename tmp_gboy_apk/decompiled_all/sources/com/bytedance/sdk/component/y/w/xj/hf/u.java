package com.bytedance.sdk.component.y.w.xj.hf;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.y.x;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements x {
    private final com.bytedance.sdk.component.y.w.xj.hf hf;
    private final x xj;

    public u(x xVar) {
        this(xVar, null);
    }

    public u(x xVar, com.bytedance.sdk.component.y.w.xj.hf hfVar) {
        this.xj = xVar;
        this.hf = hfVar;
    }

    @Override // com.bytedance.sdk.component.y.xj
    public boolean hf(String str) {
        return this.xj.hf(str);
    }

    @Override // com.bytedance.sdk.component.y.xj
    public boolean xj(String str, Bitmap bitmap) {
        return this.xj.xj(str, bitmap);
    }

    @Override // com.bytedance.sdk.component.y.xj
    public Bitmap xj(String str) {
        return this.xj.xj((x) str);
    }

    @Override // com.bytedance.sdk.component.y.xj
    public void xj(double d) {
        this.xj.xj(d);
    }
}
