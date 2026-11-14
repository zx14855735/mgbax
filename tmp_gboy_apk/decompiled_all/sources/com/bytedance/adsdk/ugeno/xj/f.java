package com.bytedance.adsdk.ugeno.xj;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f implements c {
    private float hf;
    private float kd;
    private float u;
    private float w;
    private View xj;
    private float y;

    public f(View view) {
        this.xj = view;
    }

    @Override // com.bytedance.adsdk.ugeno.xj.c
    public float getRipple() {
        return this.w;
    }

    @Override // com.bytedance.adsdk.ugeno.xj.c
    public float getRubIn() {
        return this.y;
    }

    @Override // com.bytedance.adsdk.ugeno.xj.c
    public float getShine() {
        return this.u;
    }

    @Override // com.bytedance.adsdk.ugeno.xj.c
    public float getStretch() {
        return this.kd;
    }

    public void hf(float f) {
        View view = this.xj;
        if (view == null) {
            return;
        }
        this.w = f;
        view.postInvalidate();
    }

    public void kd(float f) {
        this.y = f;
        this.xj.postInvalidate();
    }

    public void u(float f) {
        this.kd = f;
        this.xj.postInvalidate();
    }

    public void w(float f) {
        View view = this.xj;
        if (view == null) {
            return;
        }
        this.u = f;
        view.postInvalidate();
    }

    public void xj(float f) {
        View view = this.xj;
        if (view == null) {
            return;
        }
        this.hf = f;
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(f);
        }
    }

    public float xj() {
        return this.hf;
    }

    public void xj(int i) {
        View view = this.xj;
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(i);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background.mutate()).setColor(i);
        }
    }
}
