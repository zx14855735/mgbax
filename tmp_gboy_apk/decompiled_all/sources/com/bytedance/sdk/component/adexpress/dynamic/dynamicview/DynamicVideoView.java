package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.archives.tar.e;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicVideoView extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.kd {
    FrameLayout hf;
    boolean jk;
    TextView xj;

    public DynamicVideoView(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        this.jk = false;
        View view = new View(context);
        this.qt = view;
        view.setTag(Integer.valueOf(getClickArea()));
        this.xj = new TextView(context);
        this.hf = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.u.f.xj(context, 40.0f), (int) com.bytedance.sdk.component.adexpress.u.f.xj(context, 15.0f));
        layoutParams.gravity = 8388693;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        this.xj.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.xj.setBackground(gradientDrawable);
        this.xj.setTextSize(10.0f);
        this.xj.setGravity(17);
        this.xj.setTextColor(-1);
        this.xj.setVisibility(8);
        if (com.bytedance.sdk.component.adexpress.u.xj()) {
            addView(this.hf, new FrameLayout.LayoutParams(-1, -1));
        }
        addView(this.xj);
        addView(this.qt, getWidgetLayoutParams());
        if (!com.bytedance.sdk.component.adexpress.u.xj()) {
            addView(this.hf, getWidgetLayoutParams());
        }
        dynamicRootView.w = this.hf;
        dynamicRootView.setVideoListener(this);
    }

    private void w(View view) {
        if (view == this.xj || view == ((DynamicBaseWidgetImp) this).v) {
            return;
        }
        try {
            if (((Integer) view.getTag(com.bytedance.sdk.component.adexpress.dynamic.xj.y)).intValue() == 1) {
                return;
            }
        } catch (Throwable unused) {
        }
        int i = 0;
        view.setVisibility(0);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            w(viewGroup.getChildAt(i));
            i++;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        super.f();
        double d = 0.0d;
        double d2 = 0.0d;
        for (f fVar = this.g; fVar != null; fVar = fVar.pl()) {
            d2 = (d2 + fVar.y()) - fVar.u();
            d = (d + fVar.c()) - fVar.kd();
        }
        try {
            float f = (float) d2;
            int xj = (int) com.bytedance.sdk.component.adexpress.u.f.xj(getContext(), f);
            int xj2 = (int) com.bytedance.sdk.component.adexpress.u.f.xj(getContext(), f + this.kd);
            if (com.bytedance.sdk.component.adexpress.u.w.xj(getContext())) {
                int dynamicWidth = ((DynamicRoot) this.am.getChildAt(0)).getDynamicWidth();
                int i = dynamicWidth - xj2;
                xj2 = dynamicWidth - xj;
                xj = i;
            }
            if ("open_ad".equals(this.am.getRenderRequest().y())) {
                this.am.w = this.hf;
            } else {
                float f2 = (float) d;
                ((DynamicRoot) this.am.getChildAt(0)).xj.update(xj, (int) com.bytedance.sdk.component.adexpress.u.f.xj(getContext(), f2), xj2, (int) com.bytedance.sdk.component.adexpress.u.f.xj(getContext(), f2 + this.y));
            }
        } catch (Exception unused) {
        }
        this.am.xj(d2, d, this.kd, this.y, this.f10177pl.qt());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.kd
    public void setTimeUpdate(int i) {
        if (!this.g.tf().kd().he() || i <= 0 || this.jk) {
            this.jk = true;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                w(getChildAt(i2));
            }
            this.xj.setVisibility(8);
            return;
        }
        String AcNBzu2 = CtFAbx.AcNBzu(i >= 60 ? Constants.FAIL + (i / 60) : e.V, ":");
        int i3 = i % 60;
        this.xj.setText(i3 > 9 ? AcNBzu2 + i3 : AcNBzu2 + Constants.FAIL + i3);
        this.xj.setVisibility(0);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public boolean u() {
        return true;
    }
}
