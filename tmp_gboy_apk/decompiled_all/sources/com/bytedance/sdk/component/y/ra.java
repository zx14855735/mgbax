package com.bytedance.sdk.component.y;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.io.InputStream;
import java.util.function.Function;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ra implements ht {
    Function xj;

    public ra(Function function) {
        this.xj = function;
    }

    public void clearAllCache() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        this.xj.apply(sparseArray);
    }

    public void clearCache(double d) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Double.valueOf(d));
        this.xj.apply(sparseArray);
    }

    public void clearDiskCache(double d) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Double.valueOf(d));
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.y.ht
    public void clearMemoryCache(double d) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Double.valueOf(d));
        this.xj.apply(sparseArray);
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.function.Function] */
    @Override // com.bytedance.sdk.component.y.ht
    public am from(String str) {
        ?? apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(1, sparseArray, 0, 1, str);
        apply = this.xj.apply(sparseArray);
        qt qtVar = apply;
        if (apply != 0) {
            qtVar = new qt((Function) apply);
        }
        return qtVar;
    }

    @Override // com.bytedance.sdk.component.y.ht
    public InputStream getCacheStream(String str, String str2) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(6, sparseArray, 0, 1, str);
        sparseArray.put(2, str2);
        apply = this.xj.apply(sparseArray);
        return (InputStream) apply;
    }

    public InputStream getDiskCacheStream(String str, String str2, String str3) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(7, sparseArray, 0, 1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, str3);
        apply = this.xj.apply(sparseArray);
        return (InputStream) apply;
    }

    public boolean hasDiskCache(String str, String str2, String str3) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(8, sparseArray, 0, 1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, str3);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }
}
