package com.bytedance.sdk.component.y.hf;

import com.bytedance.sdk.component.y.c;
import com.bytedance.sdk.component.y.f;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u<T> implements c {
    private int hf;
    private f kd;
    private String u;
    private T w;
    Map<String, String> xj;

    public u(int i, T t, String str) {
        this.hf = i;
        this.w = t;
        this.u = str;
    }

    @Override // com.bytedance.sdk.component.y.c
    public int hf() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.y.c
    public Map<String, String> kd() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.component.y.c
    public String u() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.y.c
    public T w() {
        return this.w;
    }

    @Override // com.bytedance.sdk.component.y.c
    public f xj() {
        return this.kd;
    }

    public void xj(f fVar) {
        this.kd = fVar;
    }

    public u(int i, T t, String str, Map<String, String> map) {
        this(i, t, str);
        this.xj = map;
    }
}
