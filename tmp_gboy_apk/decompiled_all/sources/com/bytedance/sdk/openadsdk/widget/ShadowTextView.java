package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.sigmob.sdk.archives.tar.e;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ShadowTextView extends TextView {
    private RectF hf;
    private int w;
    private Paint xj;

    public ShadowTextView(Context context) {
        this(context, null);
    }

    private void xj() {
        setTextColor(-1);
        Paint paint = new Paint();
        this.xj = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.xj.setColor(Color.parseColor("#99333333"));
        this.xj.setAntiAlias(true);
        this.xj.setStrokeWidth(0.0f);
        this.hf = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.hf;
        float f = rectF.bottom;
        canvas.drawRoundRect(rectF, f / 2.0f, f / 2.0f, this.xj);
        canvas.translate((this.hf.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            this.hf.set(0.0f, 0.0f, 0.0f, 0.0f);
            return;
        }
        int measureText = (int) getPaint().measureText(e.V);
        this.w = measureText;
        if (measuredWidth < measureText) {
            measuredWidth = measureText;
        }
        int i3 = ((measuredHeight / 2) * 2) + measuredWidth;
        setMeasuredDimension(i3, measuredHeight);
        this.hf.set(0.0f, 0.0f, i3, measuredHeight);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w = 0;
        xj();
    }
}
