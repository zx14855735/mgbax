package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebSettings;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class l extends g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13304a = "l";
    private float b;
    private int c;
    private int d;
    private int e;
    private int f;
    private Paint g;
    private Paint h;

    public l(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        Paint paint = new Paint();
        this.g = paint;
        paint.setColor(-1);
        this.g.setAntiAlias(true);
        this.g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.h = paint2;
        paint2.setXfermode(null);
    }

    private void b(Canvas canvas) {
        Path path = new Path();
        path.moveTo(this.e + this.c, this.f + this.b);
        path.lineTo(this.e + this.c, this.f);
        path.lineTo((this.e + this.c) - this.b, this.f);
        int i = this.e;
        int i2 = this.c;
        float f = this.b;
        int i3 = this.f;
        path.arcTo(new RectF((i + i2) - (f * 2.0f), i3, i + i2, (f * 2.0f) + i3), -90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.g);
    }

    private void c(Canvas canvas) {
        Path path = new Path();
        path.moveTo(this.e, (this.f + this.d) - this.b);
        path.lineTo(this.e, this.f + this.d);
        path.lineTo(this.e + this.b, this.f + this.d);
        int i = this.e;
        int i2 = this.f;
        int i3 = this.d;
        float f = this.b;
        path.arcTo(new RectF(i, (i2 + i3) - (f * 2.0f), (f * 2.0f) + i, i2 + i3), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.g);
    }

    private void d(Canvas canvas) {
        Path path = new Path();
        path.moveTo((this.e + this.c) - this.b, this.f + this.d);
        path.lineTo(this.e + this.c, this.f + this.d);
        path.lineTo(this.e + this.c, (this.f + this.d) - this.b);
        int i = this.e;
        int i2 = this.c;
        float f = this.b;
        int i3 = this.f;
        int i4 = this.d;
        path.arcTo(new RectF((i + i2) - (f * 2.0f), (i3 + i4) - (f * 2.0f), i + i2, i3 + i4), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.g);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.e = getScrollX();
        int scrollY = getScrollY();
        this.f = scrollY;
        Bitmap createBitmap = Bitmap.createBitmap(this.e + this.c, scrollY + this.d, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        super.draw(canvas2);
        a(canvas2);
        b(canvas2);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, this.h);
        createBitmap.recycle();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.c = getMeasuredWidth();
        this.d = getMeasuredHeight();
    }

    public void setRadius(float f) {
        this.b = f;
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Canvas canvas) {
        Path path = new Path();
        path.moveTo(this.e, this.b);
        path.lineTo(this.e, this.f);
        path.lineTo(this.b, this.f);
        int i = this.e;
        int i2 = this.f;
        float f = this.b;
        path.arcTo(new RectF(i, i2, (f * 2.0f) + i, (f * 2.0f) + i2), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.g);
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context);
        this.b = 40.0f;
        a(getSettings());
        a(context);
    }

    private void a(WebSettings webSettings) {
        com.sigmob.sdk.base.utils.h.a(f13304a, webSettings);
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setBlockNetworkImage(false);
        webSettings.setBlockNetworkLoads(false);
        webSettings.setCacheMode(-1);
        int i = Build.VERSION.SDK_INT;
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setAllowContentAccess(true);
        if (i >= 26) {
            try {
                webSettings.setSafeBrowsingEnabled(false);
            } catch (Throwable unused) {
            }
        }
        try {
            webSettings.setMixedContentMode(0);
        } catch (Throwable unused2) {
        }
    }

    @Override // com.sigmob.sdk.base.views.g
    public void a(boolean z) {
    }
}
