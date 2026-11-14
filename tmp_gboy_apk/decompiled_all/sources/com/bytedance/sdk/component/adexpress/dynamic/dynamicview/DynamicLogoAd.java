package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.u.p;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.utils.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicLogoAd extends DynamicBaseWidgetImp {
    public DynamicLogoAd(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        TextView textView = new TextView(context);
        this.qt = textView;
        textView.setTag(Integer.valueOf(getClickArea()));
        addView(this.qt, getWidgetLayoutParams());
    }

    private boolean d() {
        if (com.bytedance.sdk.component.adexpress.u.xj()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.f10177pl.hf) && this.f10177pl.hf.contains("adx:")) || p.hf();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        super.f();
        this.qt.setTextAlignment(this.f10177pl.f());
        ((TextView) this.qt).setTextColor(this.f10177pl.c());
        ((TextView) this.qt).setTextSize(this.f10177pl.kd());
        if (com.bytedance.sdk.component.adexpress.u.xj()) {
            ((TextView) this.qt).setIncludeFontPadding(false);
            ((TextView) this.qt).setTextSize(Math.min(((com.bytedance.sdk.component.adexpress.u.f.hf(com.bytedance.sdk.component.adexpress.u.getContext(), this.f) - this.f10177pl.hf()) - this.f10177pl.xj()) - 0.5f, this.f10177pl.kd()));
            ((TextView) this.qt).setText(jk.xj(getContext(), "tt_logo_en"));
            return true;
        }
        if (!d()) {
            ((TextView) this.qt).setText(jk.hf(getContext(), "tt_logo_cn"));
            return true;
        }
        if (p.hf()) {
            ((TextView) this.qt).setText(p.xj());
            return true;
        }
        ((TextView) this.qt).setText(p.xj(this.f10177pl.hf));
        return true;
    }
}
