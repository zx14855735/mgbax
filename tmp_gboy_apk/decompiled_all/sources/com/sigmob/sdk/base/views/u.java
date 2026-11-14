package com.sigmob.sdk.base.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.czhj.sdk.logger.SigmobLog;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private static final int f13326a = 1000;
    private int b;
    private Movie c;
    private long d;
    private int e;
    private float f;
    private float g;
    private float h;
    private float i;
    private int j;
    private int k;
    private boolean l;
    private volatile boolean m;

    public u(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        this.c.setTime(this.e);
        canvas.save();
        canvas.scale(this.h, this.i);
        this.c.draw(canvas, this.f / this.h, this.g / this.i);
        canvas.restore();
    }

    @SuppressLint({"NewApi"})
    private void b() {
        if (this.l) {
            postInvalidateOnAnimation();
        }
    }

    private void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.d == 0) {
            this.d = uptimeMillis;
        }
        int duration = this.c.duration();
        if (duration == 0) {
            duration = 1000;
        }
        this.e = (int) ((uptimeMillis - this.d) % duration);
    }

    private byte[] getGiftBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream openRawResource = getResources().openRawResource(this.b);
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    int read = openRawResource.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (Throwable th) {
                    try {
                        SigmobLog.e(th.getMessage());
                        openRawResource.close();
                    } catch (Throwable th2) {
                        try {
                            openRawResource.close();
                        } catch (Throwable th3) {
                            SigmobLog.e(th3.getMessage());
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                SigmobLog.e(th4.getMessage());
            }
        }
        byteArrayOutputStream.flush();
        openRawResource.close();
        return byteArrayOutputStream.toByteArray();
    }

    public Movie getMovie() {
        return this.c;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.c == null) {
            super.onDraw(canvas);
            return;
        }
        c();
        a(canvas);
        b();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f = (getWidth() - this.j) / 2.0f;
        this.g = (getHeight() - this.k) / 2.0f;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Movie movie = this.c;
        if (movie == null) {
            super.onMeasure(i, i2);
            return;
        }
        int width = movie.width();
        int height = this.c.height();
        int size = View.MeasureSpec.getSize(i);
        this.h = 1.0f / (width / size);
        this.i = 1.0f / (height / View.MeasureSpec.getSize(i2));
        this.j = size;
        int size2 = View.MeasureSpec.getSize(i2);
        this.k = size2;
        setMeasuredDimension(this.j, size2);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        this.l = i == 1;
        b();
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.l = i == 0;
        b();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.l = i == 0;
        b();
    }

    public void setMovie(Movie movie) {
        this.c = movie;
        requestLayout();
    }

    public void setMovieResource(int i) {
        this.b = i;
        byte[] giftBytes = getGiftBytes();
        this.c = Movie.decodeByteArray(giftBytes, 0, giftBytes.length);
        requestLayout();
    }

    public void setMovieTime(int i) {
        this.e = i;
        invalidate();
    }

    public void setPaused(boolean z) {
        this.m = z;
        if (!z) {
            this.d = SystemClock.uptimeMillis() - this.e;
        }
        invalidate();
    }

    public u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean a() {
        return this.m;
    }

    public u(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 0;
        this.l = true;
        this.m = false;
        setLayerType(1, null);
    }
}
