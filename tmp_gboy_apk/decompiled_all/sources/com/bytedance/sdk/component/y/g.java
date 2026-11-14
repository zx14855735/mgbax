package com.bytedance.sdk.component.y;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class g implements pl, Function {
    pl hf;
    Function xj;

    public g(pl plVar) {
        this.hf = plVar;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Boolean.valueOf(this.hf.cancelRequest());
            case 2:
                return this.hf.getUrl();
            case 3:
                return Integer.valueOf(this.hf.getWidth());
            case 4:
                return Integer.valueOf(this.hf.getHeight());
            case 5:
                return this.hf.getScaleType();
            case 6:
                return this.hf.getRawCacheKey();
            case 7:
                return this.hf.getMemoryCacheKey();
            case 8:
                return this.hf.getBitmapConfig();
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.component.y.pl
    public boolean cancelRequest() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.component.y.pl
    public Bitmap.Config getBitmapConfig() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        apply = this.xj.apply(sparseArray);
        return (Bitmap.Config) apply;
    }

    @Override // com.bytedance.sdk.component.y.pl
    public int getHeight() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    @Override // com.bytedance.sdk.component.y.pl
    public String getMemoryCacheKey() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.y.pl
    public String getRawCacheKey() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.y.pl
    public ImageView.ScaleType getScaleType() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        apply = this.xj.apply(sparseArray);
        return (ImageView.ScaleType) apply;
    }

    @Override // com.bytedance.sdk.component.y.pl
    public String getUrl() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.y.pl
    public int getWidth() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    public g(Function function) {
        this.xj = function;
    }
}
