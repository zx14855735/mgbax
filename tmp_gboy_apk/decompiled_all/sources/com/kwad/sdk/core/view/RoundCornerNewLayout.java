package com.kwad.sdk.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class RoundCornerNewLayout extends FrameLayout {
    private Path aQI;
    private int aQJ;
    private int aQK;
    private int aQL;
    private int aQM;
    private boolean aQN;

    public RoundCornerNewLayout(Context context) {
        this(context, null);
    }

    private void MB() {
        if (this.aQN) {
            int max = Math.max(this.aQJ, this.aQK);
            int max2 = Math.max(this.aQL, this.aQM);
            setOutlineProvider(new a(Math.max(max, max2), 0, max == max2 ? 0 : -max2, getWidth(), max == max2 ? getHeight() : max + getHeight()));
            setClipToOutline(true);
        } else {
            setOutlineProvider(new a(this.aQJ, 0, 0, getWidth(), getHeight() + this.aQJ));
        }
        setClipToOutline(true);
    }

    private static Path a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Path path = new Path();
        path.moveTo(0.0f, i5);
        if (i5 >= 0) {
            float f = i5 * 2;
            path.arcTo(new RectF(0.0f, 0.0f, f, f), -180.0f, 90.0f);
        }
        path.lineTo(i3 - i6, 0.0f);
        if (i6 >= 0) {
            path.arcTo(new RectF(i3 - r8, 0.0f, i3, i6 * 2), -90.0f, 90.0f);
        }
        float f2 = i3;
        path.lineTo(f2, i4 - i7);
        if (i7 != 0) {
            int i9 = i7 * 2;
            path.arcTo(new RectF(i3 - i9, i4 - i9, f2, i4), 0.0f, 90.0f);
        }
        float f3 = i4;
        path.lineTo(i8, f3);
        if (i8 != 0) {
            path.arcTo(new RectF(0.0f, i4 - r10, i8 * 2, f3), 90.0f, 90.0f);
        }
        path.close();
        path.offset(0.0f, 0.0f);
        return path;
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"ObsoleteSdkInt"})
    public void dispatchDraw(Canvas canvas) {
        MB();
        Path path = this.aQI;
        if (path != null) {
            canvas.clipPath(path);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    @SuppressLint({"ObsoleteSdkInt"})
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        MB();
    }

    public void setCalculateRadius(boolean z) {
        this.aQN = z;
    }

    public void setTopRadius(int i) {
        this.aQJ = i;
        this.aQK = i;
        invalidate();
    }

    public RoundCornerNewLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerNewLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aQN = false;
    }
}
