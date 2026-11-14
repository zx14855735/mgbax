package com.bytedance.sdk.component.y.hf;

import com.bytedance.sdk.component.y.jk;
import com.bytedance.sdk.component.y.y;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements y {
    private boolean hf;
    private jk u;
    private boolean w;
    private String xj;

    public w(String str, boolean z, boolean z2, jk jkVar) {
        this.xj = str;
        this.hf = z;
        this.w = z2;
        this.u = jkVar;
    }

    @Override // com.bytedance.sdk.component.y.y
    public boolean hf() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.y.y
    public jk u() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.y.y
    public boolean w() {
        return this.w;
    }

    @Override // com.bytedance.sdk.component.y.y
    public String xj() {
        return this.xj;
    }
}
