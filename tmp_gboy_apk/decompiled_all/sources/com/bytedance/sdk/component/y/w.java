package com.bytedance.sdk.component.y;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.io.File;
import java.util.function.Function;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements hf, Function {
    hf hf;
    Function xj;

    public w(hf hfVar) {
        this.hf = hfVar;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Long.valueOf(this.hf.getFileCacheSize());
            case 2:
                return Integer.valueOf(this.hf.getMemoryCacheSize());
            case 3:
                return Boolean.valueOf(this.hf.isMemoryCache());
            case 4:
                return Boolean.valueOf(this.hf.isDiskCache());
            case 5:
                return this.hf.getCacheDir();
            case 6:
                return Boolean.valueOf(this.hf.isQueryAll());
            case 7:
                return Integer.valueOf(this.hf.getRawMemoryCacheSize());
            case 8:
                return Boolean.valueOf(this.hf.isRawMemoryCache());
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.component.y.hf
    public File getCacheDir() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        apply = this.xj.apply(sparseArray);
        return (File) apply;
    }

    @Override // com.bytedance.sdk.component.y.hf
    public long getFileCacheSize() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        apply = this.xj.apply(sparseArray);
        return ((Long) apply).longValue();
    }

    @Override // com.bytedance.sdk.component.y.hf
    public int getMemoryCacheSize() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    @Override // com.bytedance.sdk.component.y.hf
    public int getRawMemoryCacheSize() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    @Override // com.bytedance.sdk.component.y.hf
    public boolean isDiskCache() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.component.y.hf
    public boolean isMemoryCache() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.component.y.hf
    public boolean isQueryAll() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.component.y.hf
    public boolean isRawMemoryCache() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    public w(Function function) {
        this.xj = function;
    }
}
