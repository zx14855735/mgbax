package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.utils.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicTimeOuterRewardFullSkip extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.w {
    private boolean xj;

    public DynamicTimeOuterRewardFullSkip(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        if (dynamicRootView.getRenderRequest() != null) {
            this.xj = dynamicRootView.getRenderRequest().zg();
        }
        this.c = this.f;
        ImageView imageView = new ImageView(context);
        this.qt = imageView;
        imageView.setTag(Integer.valueOf(getClickArea()));
        addView(this.qt, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().ai()) {
            return;
        }
        this.qt.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        Drawable w;
        super.f();
        ((ImageView) this.qt).setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable xj = com.bytedance.sdk.component.adexpress.u.u.xj(getContext(), this.f10177pl);
        if (xj != null) {
            ((ImageView) this.qt).setBackground(xj);
        }
        if (this.xj) {
            w = jk.w(getContext(), "tt_close_btn");
        } else {
            w = jk.w(getContext(), "tt_skip_btn");
            if (w != null) {
                w.setAutoMirrored(true);
            }
        }
        if (w != null) {
            ((ImageView) this.qt).setImageDrawable(w);
        }
        setVisibility(8);
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.w
    public void xj(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (!z && !z2) {
            i2 = 8;
        }
        setVisibility(i2);
    }
}
