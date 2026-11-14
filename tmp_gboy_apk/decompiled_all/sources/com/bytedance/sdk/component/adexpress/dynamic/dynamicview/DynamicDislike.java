package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.adexpress.widget.DislikeView;
import com.bytedance.sdk.component.utils.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicDislike extends DynamicBaseWidgetImp {
    public DynamicDislike(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        if (com.bytedance.sdk.component.adexpress.u.xj()) {
            this.qt = new ImageView(context);
        } else {
            this.qt = new DislikeView(context);
        }
        this.qt.setTag(3);
        addView(this.qt, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.qt);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        super.f();
        if (com.bytedance.sdk.component.adexpress.u.xj()) {
            Drawable xj = com.bytedance.sdk.component.adexpress.u.u.xj(getContext(), this.f10177pl);
            if (xj != null) {
                this.qt.setBackground(xj);
            }
            int kd = jk.kd(getContext(), "tt_close_btn");
            if (kd > 0) {
                ((ImageView) this.qt).setImageResource(kd);
            }
            ((ImageView) this.qt).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        int xj2 = (int) com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.e());
        View view = this.qt;
        if (view instanceof DislikeView) {
            ((DislikeView) view).setRadius((int) com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.qt()));
            ((DislikeView) this.qt).setStrokeWidth(xj2);
            ((DislikeView) this.qt).setStrokeColor(this.f10177pl.zg());
            ((DislikeView) this.qt).setBgColor(this.f10177pl.ai());
            ((DislikeView) this.qt).setDislikeColor(this.f10177pl.c());
            ((DislikeView) this.qt).setDislikeWidth((int) com.bytedance.sdk.component.adexpress.u.f.xj(this.p, 1.0f));
        }
        return true;
    }
}
