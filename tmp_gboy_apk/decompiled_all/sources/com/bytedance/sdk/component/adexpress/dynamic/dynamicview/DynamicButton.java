package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.AnimationButton;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicButton extends DynamicBaseWidgetImp {
    public DynamicButton(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        AnimationButton animationButton = new AnimationButton(context);
        this.qt = animationButton;
        animationButton.setTag(Integer.valueOf(getClickArea()));
        addView(this.qt, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        super.f();
        if (TextUtils.equals("download-progress-button", this.g.tf().getType()) && TextUtils.isEmpty(this.f10177pl.tf())) {
            this.qt.setVisibility(4);
            return true;
        }
        this.qt.setTextAlignment(this.f10177pl.f());
        ((TextView) this.qt).setText(this.f10177pl.tf());
        ((TextView) this.qt).setTextColor(this.f10177pl.c());
        ((TextView) this.qt).setTextSize(this.f10177pl.kd());
        ((TextView) this.qt).setGravity(17);
        ((TextView) this.qt).setIncludeFontPadding(false);
        if ("fillButton".equals(this.g.tf().getType())) {
            this.qt.setPadding(0, 0, 0, 0);
        } else {
            this.qt.setPadding(this.f10177pl.w(), this.f10177pl.hf(), this.f10177pl.u(), this.f10177pl.xj());
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        if (!com.bytedance.sdk.component.adexpress.u.xj() || !"fillButton".equals(this.g.tf().getType())) {
            return super.getWidgetLayoutParams();
        }
        ((TextView) this.qt).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView) this.qt).setMaxLines(1);
        FrameLayout.LayoutParams widgetLayoutParams = super.getWidgetLayoutParams();
        widgetLayoutParams.width -= this.f10177pl.yo() * 2;
        widgetLayoutParams.height -= this.f10177pl.yo() * 2;
        widgetLayoutParams.topMargin = this.f10177pl.yo() + widgetLayoutParams.topMargin;
        int yo = this.f10177pl.yo() + widgetLayoutParams.leftMargin;
        widgetLayoutParams.leftMargin = yo;
        widgetLayoutParams.setMarginStart(yo);
        widgetLayoutParams.setMarginEnd(widgetLayoutParams.rightMargin);
        return widgetLayoutParams;
    }
}
