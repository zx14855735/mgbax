package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.utils.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicDislikeFeedBack extends DynamicBaseWidgetImp {
    public DynamicDislikeFeedBack(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        if (com.bytedance.sdk.component.adexpress.u.xj()) {
            ImageView imageView = new ImageView(context);
            this.qt = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.c = this.f;
        } else {
            this.qt = new TextView(context);
        }
        this.qt.setTag(3);
        addView(this.qt, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.qt);
        if (dynamicRootView.getRenderRequest() != null) {
            if (dynamicRootView.getRenderRequest().p() && dynamicRootView.getRenderRequest().ai()) {
                return;
            }
            this.qt.setVisibility(8);
            setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        super.f();
        if (com.bytedance.sdk.component.adexpress.u.xj()) {
            Drawable xj = com.bytedance.sdk.component.adexpress.u.u.xj(getContext(), this.f10177pl);
            if (xj != null) {
                ((ImageView) this.qt).setBackground(xj);
            }
            ((ImageView) this.qt).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int kd = jk.kd(getContext(), "tt_reward_full_feedback");
            if (kd > 0) {
                ((ImageView) this.qt).setImageResource(kd);
            }
            return true;
        }
        ((TextView) this.qt).setText(getText());
        this.qt.setTextAlignment(this.f10177pl.f());
        ((TextView) this.qt).setTextColor(this.f10177pl.c());
        ((TextView) this.qt).setTextSize(this.f10177pl.kd());
        this.qt.setBackground(getBackgroundDrawable());
        if (this.f10177pl.ht()) {
            int ra = this.f10177pl.ra();
            if (ra > 0) {
                ((TextView) this.qt).setLines(ra);
                ((TextView) this.qt).setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            ((TextView) this.qt).setMaxLines(1);
            ((TextView) this.qt).setGravity(17);
            ((TextView) this.qt).setEllipsize(TextUtils.TruncateAt.END);
        }
        this.qt.setPadding((int) com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), this.f10177pl.w()), (int) com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), this.f10177pl.hf()), (int) com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), this.f10177pl.u()), (int) com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), this.f10177pl.xj()));
        ((TextView) this.qt).setGravity(17);
        return true;
    }

    public String getText() {
        return jk.xj(com.bytedance.sdk.component.adexpress.u.getContext(), "tt_reward_feedback");
    }
}
