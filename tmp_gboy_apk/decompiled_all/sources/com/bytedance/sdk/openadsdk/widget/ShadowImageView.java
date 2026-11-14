package com.bytedance.sdk.openadsdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ShadowImageView extends ImageView {
    private RectF hf;
    private Paint xj;

    public ShadowImageView(Context context) {
        super(context);
        xj();
    }

    private void xj() {
        Paint paint = new Paint();
        this.xj = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.xj.setColor(Color.parseColor("#99333333"));
        this.xj.setAntiAlias(true);
        this.xj.setStrokeWidth(0.0f);
        this.hf = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.hf;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, rectF.bottom / 2.0f, this.xj);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.hf.right == getMeasuredWidth() && this.hf.bottom == getMeasuredHeight()) {
            return;
        }
        this.hf.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }
}
