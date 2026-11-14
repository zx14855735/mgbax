package com.octopus.ad.internal.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DrawTextImageView extends AppCompatImageView {

    /* renamed from: a, reason: collision with root package name */
    private String f12586a;
    private float b;
    private float c;
    private float d;
    private int e;
    private int f;

    public DrawTextImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12586a = "";
        this.b = 30.0f;
        this.c = -1000.0f;
        this.d = -1000.0f;
        this.e = 0;
        this.f = 3;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f12586a.equals("")) {
            return;
        }
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(this.e));
        paint.setStrokeWidth(this.f);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(this.b);
        String str = this.f12586a;
        float f = this.c;
        if (f == -1000.0f) {
            f = canvas.getWidth() - (this.b * this.f12586a.length());
        }
        float f2 = this.d;
        if (f2 == -1000.0f) {
            f2 = canvas.getHeight() - 50;
        }
        canvas.drawText(str, f, f2, paint);
    }

    public void setDrawText(String str) {
        this.f12586a = str;
        drawableStateChanged();
    }

    public void setDrawTextColorResourse(int i) {
        this.e = i;
        drawableStateChanged();
    }

    public void setDrawTextSize(float f) {
        this.b = f;
        drawableStateChanged();
    }

    public void setDrawTextStrokeWidth(int i) {
        this.f = i;
        drawableStateChanged();
    }

    public DrawTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12586a = "";
        this.b = 30.0f;
        this.c = -1000.0f;
        this.d = -1000.0f;
        this.e = 0;
        this.f = 3;
    }

    public DrawTextImageView(Context context) {
        super(context, null);
        this.f12586a = "";
        this.b = 30.0f;
        this.c = -1000.0f;
        this.d = -1000.0f;
        this.e = 0;
        this.f = 3;
    }
}
