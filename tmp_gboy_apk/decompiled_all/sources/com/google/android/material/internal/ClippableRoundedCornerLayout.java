package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ClippableRoundedCornerLayout extends FrameLayout {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Path f11691AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public float[] f11692AlLFFp;

    public ClippableRoundedCornerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11692AlLFFp = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public final void A2egSU(float f, float f2, float f3, float f4, float[] fArr) {
        RectF rectF = new RectF(f, f2, f3, f4);
        if (this.f11691AcNBzu == null) {
            this.f11691AcNBzu = new Path();
        }
        this.f11692AlLFFp = fArr;
        this.f11691AcNBzu.reset();
        this.f11691AcNBzu.addRoundRect(rectF, fArr, Path.Direction.CW);
        this.f11691AcNBzu.close();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (this.f11691AcNBzu == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.clipPath(this.f11691AcNBzu);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public float[] getCornerRadii() {
        return this.f11692AlLFFp;
    }
}
