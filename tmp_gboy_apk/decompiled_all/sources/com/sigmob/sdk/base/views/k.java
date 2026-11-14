package com.sigmob.sdk.base.views;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import com.sigmob.sdk.base.views.r;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class k extends h {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f13303a;
    private final float b;

    public k() {
        this(8.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int width = getBounds().width();
        int height = getBounds().height();
        float f = this.b;
        float f2 = height;
        float f3 = width;
        canvas.drawLine(f + 0.0f, f2 - f, f3 - f, f + 0.0f, this.f13303a);
        float f4 = this.b;
        canvas.drawLine(f4 + 0.0f, f4 + 0.0f, f3 - f4, f2 - f4, this.f13303a);
    }

    @Override // com.sigmob.sdk.base.views.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.sigmob.sdk.base.views.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // com.sigmob.sdk.base.views.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    private k(float f) {
        this.b = f / 2.0f;
        Paint paint = new Paint();
        this.f13303a = paint;
        paint.setColor(-1);
        paint.setStrokeWidth(f);
        paint.setStrokeCap(r.a.f);
    }
}
