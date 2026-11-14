package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.adexpress.u.d;
import com.bytedance.sdk.component.utils.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicMutedView extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.hf {
    public DynamicMutedView(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        ImageView imageView = new ImageView(context);
        this.qt = imageView;
        imageView.setTag(5);
        addView(this.qt, getWidgetLayoutParams());
        dynamicRootView.setMuteListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().ai()) {
            return;
        }
        this.qt.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        super.f();
        if (com.bytedance.sdk.component.adexpress.u.xj()) {
            ((ImageView) this.qt).setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            ((ImageView) this.qt).setScaleType(ImageView.ScaleType.CENTER);
        }
        setSoundMute(this.am.hf);
        if (!com.bytedance.sdk.component.adexpress.u.xj()) {
            ((ImageView) this.qt).setBackgroundDrawable(d.xj(0, Integer.valueOf(this.f10177pl.ai()), new int[]{this.f / 2}, null, null, null));
            return true;
        }
        Drawable xj = com.bytedance.sdk.component.adexpress.u.u.xj(getContext(), this.f10177pl);
        if (xj == null) {
            return true;
        }
        ((ImageView) this.qt).setBackground(xj);
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.hf
    public void setSoundMute(boolean z) {
        ((ImageView) this.qt).setImageResource(com.bytedance.sdk.component.adexpress.u.xj() ? z ? jk.kd(getContext(), "tt_reward_full_mute") : jk.kd(getContext(), "tt_reward_full_unmute") : z ? jk.kd(getContext(), "tt_mute") : jk.kd(getContext(), "tt_unmute"));
        if (((ImageView) this.qt).getDrawable() != null) {
            ((ImageView) this.qt).getDrawable().setAutoMirrored(true);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public boolean u() {
        return true;
    }
}
