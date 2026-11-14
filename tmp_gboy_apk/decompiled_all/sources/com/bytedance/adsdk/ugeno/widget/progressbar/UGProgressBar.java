package com.bytedance.adsdk.ugeno.widget.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.w;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class UGProgressBar extends FrameLayout {
    private View hf;
    private int kd;
    private TextView u;
    private View w;
    private w xj;

    public UGProgressBar(Context context) {
        super(context);
        xj(context);
    }

    private void xj(Context context) {
        this.hf = new View(context);
        this.w = new View(context);
        addView(this.hf);
        addView(this.w);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hf.getLayoutParams();
        layoutParams.width = 0;
        layoutParams.height = -1;
        layoutParams.gravity = 3;
        this.hf.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.w.getLayoutParams();
        layoutParams2.width = this.kd;
        layoutParams2.gravity = 5;
        this.w.setLayoutParams(layoutParams2);
        TextView textView = new TextView(context);
        this.u = textView;
        textView.setTextColor(-1);
        this.u.setTextSize(16.0f);
        this.u.setGravity(17);
        addView(this.u);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        w wVar = this.xj;
        if (wVar != null) {
            wVar.kd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w wVar = this.xj;
        if (wVar != null) {
            wVar.y();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        w wVar = this.xj;
        if (wVar != null) {
            wVar.xj(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        w wVar = this.xj;
        if (wVar != null) {
            wVar.xj(i, i2);
        }
        super.onMeasure(i, i2);
        this.kd = xj(0, i);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.kd = i;
        w wVar = this.xj;
        if (wVar != null) {
            wVar.hf(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        w wVar = this.xj;
        if (wVar != null) {
            wVar.xj(z);
        }
    }

    public void setProgress(float f) {
        int width = getWidth();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hf.getLayoutParams();
        float f2 = width;
        float f3 = (f / 100.0f) * f2;
        layoutParams.width = (int) f3;
        this.hf.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.w.getLayoutParams();
        layoutParams2.width = (int) (f2 - f3);
        this.w.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.u.getLayoutParams();
        layoutParams3.width = width;
        layoutParams3.gravity = 17;
        requestLayout();
    }

    public void setProgressBgColor(int i) {
        this.w.setBackgroundColor(i);
    }

    public void setProgressColor(int i) {
        this.hf.setBackgroundColor(i);
    }

    public void setText(String str) {
        this.u.setText(str);
    }

    public void setTextColor(int i) {
        this.u.setTextColor(i);
    }

    private int xj(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i, size) : i;
    }

    public void xj(w wVar) {
        this.xj = wVar;
    }
}
