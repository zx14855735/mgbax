package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.utils.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicLogoUnion extends DynamicBaseWidgetImp {
    public DynamicLogoUnion(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        ImageView imageView = new ImageView(context);
        this.qt = imageView;
        imageView.setTag(Integer.valueOf(getClickArea()));
        if (com.bytedance.sdk.component.adexpress.u.xj()) {
            this.f = Math.max(dynamicRootView.getLogoUnionHeight(), this.f);
        }
        addView(this.qt, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        super.f();
        if (com.bytedance.sdk.component.adexpress.u.xj()) {
            ((ImageView) this.qt).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        ((ImageView) this.qt).setImageResource(jk.kd(getContext(), "tt_ad_logo"));
        ((ImageView) this.qt).setColorFilter(this.f10177pl.c(), PorterDuff.Mode.SRC_IN);
        return true;
    }
}
