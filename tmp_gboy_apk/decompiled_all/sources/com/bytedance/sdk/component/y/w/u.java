package com.bytedance.sdk.component.y.w;

import com.bytedance.sdk.component.y.zg;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u<T> implements zg {
    private Map<String, String> c;
    private boolean d;
    private boolean f;
    private String hf;
    private int kd;
    private int p;
    private com.bytedance.sdk.component.y.f tf;
    private T u;
    private T w;
    private String xj;
    private int y;

    @Override // com.bytedance.sdk.component.y.zg
    public String getCacheKey() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.component.y.zg
    public int getFileSize() {
        return this.p;
    }

    @Override // com.bytedance.sdk.component.y.zg
    public Map<String, String> getHeaders() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.y.zg
    public int getHeight() {
        return this.y;
    }

    @Override // com.bytedance.sdk.component.y.zg
    public com.bytedance.sdk.component.y.f getHttpTime() {
        return this.tf;
    }

    @Override // com.bytedance.sdk.component.y.zg
    public T getOriginResult() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.y.zg
    public T getResult() {
        return this.w;
    }

    @Override // com.bytedance.sdk.component.y.zg
    public String getUrl() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.y.zg
    public int getWidth() {
        return this.kd;
    }

    @Override // com.bytedance.sdk.component.y.zg
    public boolean isGif() {
        return this.f;
    }

    @Override // com.bytedance.sdk.component.y.zg
    public boolean isLocal() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.y.zg
    public void setResult(Object obj) {
        this.u = this.w;
        this.w = obj;
    }

    public u xj(w wVar, T t) {
        this.w = t;
        this.xj = wVar.getMemoryCacheKey();
        this.hf = wVar.getUrl();
        this.kd = wVar.getWidth();
        this.y = wVar.getHeight();
        this.d = wVar.f();
        this.tf = wVar.d();
        this.p = wVar.tf();
        return this;
    }

    public u xj(w wVar, T t, Map<String, String> map, boolean z) {
        this.c = map;
        this.f = z;
        return xj(wVar, t);
    }
}
