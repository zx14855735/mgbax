package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.component.sdk.annotation.ColorInt;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicRoot extends DynamicBaseWidgetImp {
    public hf xj;

    public DynamicRoot(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        return super.f();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public GradientDrawable getDrawable() {
        hf hfVar = new hf();
        this.xj = hfVar;
        return hfVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public hf xj(Bitmap bitmap) {
        xj xjVar = new xj(bitmap, this.xj);
        this.xj = xjVar;
        return xjVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public GradientDrawable xj(GradientDrawable.Orientation orientation, @ColorInt int[] iArr) {
        hf hfVar = new hf(orientation, iArr);
        this.xj = hfVar;
        return hfVar;
    }
}
