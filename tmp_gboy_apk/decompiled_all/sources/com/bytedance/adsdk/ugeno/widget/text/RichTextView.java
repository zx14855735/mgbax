package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.text.Html;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.w;
import com.bytedance.adsdk.ugeno.xj.c;
import com.bytedance.adsdk.ugeno.xj.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class RichTextView extends TextView implements c {
    private f hf;
    private w xj;

    public RichTextView(Context context) {
        super(context);
        this.hf = new f(this);
    }

    public float getBorderRadius() {
        return this.hf.xj();
    }

    @Override // com.bytedance.adsdk.ugeno.xj.c
    public float getRipple() {
        return this.hf.getRipple();
    }

    @Override // com.bytedance.adsdk.ugeno.xj.c
    public float getRubIn() {
        return this.hf.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.xj.c
    public float getShine() {
        return this.hf.getShine();
    }

    @Override // com.bytedance.adsdk.ugeno.xj.c
    public float getStretch() {
        return this.hf.getStretch();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        w wVar = this.xj;
        if (wVar != null) {
            wVar.kd();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w wVar = this.xj;
        if (wVar != null) {
            wVar.y();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        w wVar = this.xj;
        if (wVar != null) {
            wVar.xj(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        w wVar = this.xj;
        if (wVar != null) {
            wVar.xj(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        w wVar = this.xj;
        if (wVar != null) {
            int[] xj = wVar.xj(i, i2);
            super.onMeasure(xj[0], xj[1]);
        } else {
            super.onMeasure(i, i2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        w wVar = this.xj;
        if (wVar != null) {
            wVar.hf(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        w wVar = this.xj;
        if (wVar != null) {
            wVar.xj(z);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.hf.xj(i);
    }

    public void setBorderRadius(float f) {
        f fVar = this.hf;
        if (fVar != null) {
            fVar.xj(f);
        }
    }

    public void setRichText(String str) {
        setText(Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(str, 0) : Html.fromHtml(str));
    }

    public void setRipple(float f) {
        f fVar = this.hf;
        if (fVar != null) {
            fVar.hf(f);
        }
    }

    public void setRubIn(float f) {
        f fVar = this.hf;
        if (fVar != null) {
            fVar.kd(f);
        }
    }

    public void setShine(float f) {
        f fVar = this.hf;
        if (fVar != null) {
            fVar.w(f);
        }
    }

    public void setStretch(float f) {
        f fVar = this.hf;
        if (fVar != null) {
            fVar.u(f);
        }
    }

    public void xj(w wVar) {
        this.xj = wVar;
    }
}
