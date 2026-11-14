package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BookPageView extends View {
    Point c;
    Paint hf;
    Point kd;
    Point u;
    Point w;
    Paint xj;
    Point y;

    public BookPageView(Context context) {
        super(context);
        this.xj = new Paint();
        this.hf = new Paint();
        this.w = new Point();
        this.u = new Point();
        this.kd = new Point();
        this.y = new Point();
        this.c = new Point();
        this.xj.setColor(-16711936);
        this.xj.setTextSize(25.0f);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.BookPageView.1
            @Override // java.lang.Runnable
            public void run() {
                BookPageView.this.w.x = r0.getWidth() - 10;
                BookPageView.this.w.y = r0.getHeight() - 10;
                BookPageView.this.hf.setShader(new LinearGradient(0.0f, 0.0f, BookPageView.this.getWidth(), BookPageView.this.getHeight(), -7829368, -12303292, Shader.TileMode.MIRROR));
                BookPageView.this.hf.setStyle(Paint.Style.FILL_AND_STROKE);
                BookPageView.this.hf.setStrokeWidth(6.0f);
                BookPageView.this.hf.setShadowLayer(10.0f, 5.0f, 5.0f, -1);
            }
        });
    }

    public Path getFilterAreaPath() {
        Path path = new Path();
        Point point = this.u;
        path.moveTo(point.x, point.y);
        Point point2 = this.y;
        path.lineTo(point2.x, point2.y);
        Point point3 = this.c;
        path.lineTo(point3.x, point3.y);
        path.close();
        return path;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        xj();
        Path path = new Path();
        Point point = this.y;
        path.moveTo(point.x, point.y);
        Point point2 = this.w;
        path.lineTo(point2.x, point2.y);
        Point point3 = this.c;
        path.lineTo(point3.x, point3.y);
        path.close();
        canvas.drawPath(path, this.hf);
    }

    public void xj(Point point) {
        Point point2 = this.w;
        point2.x = point.x;
        point2.y = point.y;
        invalidate();
    }

    private void xj() {
        this.u.x = getWidth();
        this.u.y = getHeight();
        Point point = this.kd;
        Point point2 = this.w;
        int i = point2.x;
        Point point3 = this.u;
        int i2 = (i + point3.x) / 2;
        point.x = i2;
        int i3 = (point2.y + point3.y) / 2;
        point.y = i3;
        Point point4 = this.y;
        int i4 = point3.y;
        point4.x = i2 - (((i4 - i3) * (i4 - i3)) / (point3.x - i2));
        point4.y = i4;
        Point point5 = this.c;
        point5.x = point3.x;
        int i5 = point.y;
        int i6 = point3.x;
        int i7 = point.x;
        point5.y = i5 - (((i6 - i7) * (i6 - i7)) / (point3.y - i5));
    }
}
