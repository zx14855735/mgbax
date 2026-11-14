package com.bytedance.sdk.component.y;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.Map;
import java.util.function.Function;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class e implements zg, Function {
    zg hf;
    Function xj;

    public e(zg zgVar) {
        this.hf = zgVar;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return this.hf.getCacheKey();
            case 2:
                return this.hf.getUrl();
            case 3:
                return this.hf.getResult();
            case 4:
                return this.hf.getOriginResult();
            case 5:
                this.hf.setResult(sparseArray.get(1));
                return null;
            case 6:
                return Integer.valueOf(this.hf.getWidth());
            case 7:
                return Integer.valueOf(this.hf.getHeight());
            case 8:
                return this.hf.getHeaders();
            case 9:
                return Boolean.valueOf(this.hf.isGif());
            case 10:
                return Boolean.valueOf(this.hf.isLocal());
            case 11:
                f httpTime = this.hf.getHttpTime();
                return httpTime != null ? new d(httpTime) : httpTime;
            case 12:
                return Integer.valueOf(this.hf.getFileSize());
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.component.y.zg
    public String getCacheKey() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.y.zg
    public int getFileSize() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    @Override // com.bytedance.sdk.component.y.zg
    public Map getHeaders() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        apply = this.xj.apply(sparseArray);
        return (Map) apply;
    }

    @Override // com.bytedance.sdk.component.y.zg
    public int getHeight() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    @Override // com.bytedance.sdk.component.y.zg
    public f getHttpTime() {
        ?? apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        apply = this.xj.apply(sparseArray);
        d dVar = apply;
        if (apply != 0) {
            dVar = new d((Function) apply);
        }
        return dVar;
    }

    @Override // com.bytedance.sdk.component.y.zg
    public Object getOriginResult() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        apply = this.xj.apply(sparseArray);
        return apply;
    }

    @Override // com.bytedance.sdk.component.y.zg
    public Object getResult() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        apply = this.xj.apply(sparseArray);
        return apply;
    }

    @Override // com.bytedance.sdk.component.y.zg
    public String getUrl() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.y.zg
    public int getWidth() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    @Override // com.bytedance.sdk.component.y.zg
    public boolean isGif() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.component.y.zg
    public boolean isLocal() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.component.y.zg
    public void setResult(Object obj) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, obj);
        this.xj.apply(sparseArray);
    }

    public e(Function function) {
        this.xj = function;
    }
}
