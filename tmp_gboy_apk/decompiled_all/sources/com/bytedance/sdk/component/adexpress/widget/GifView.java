package com.bytedance.sdk.component.adexpress.widget;

import I3HV03.ADYaiT;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.u.kd;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.y;
import java.io.File;
import java.io.FileOutputStream;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class GifView extends ImageView {
    private boolean am;
    private boolean c;
    private float d;
    private float f;
    private volatile boolean g;
    private Movie hf;
    private AnimatedImageDrawable kd;
    private int p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10197pl;
    private boolean qt;
    private float tf;
    private int u;
    private long w;
    private int xj;
    private boolean y;

    public interface xj {
        void xj(Drawable drawable);
    }

    public GifView(Context context) {
        super(context);
        this.y = Build.VERSION.SDK_INT >= 28;
        this.c = false;
        this.am = true;
        this.qt = true;
        xj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageDecoder.Source hf(byte[] bArr) {
        FileOutputStream fileOutputStream;
        File xj2;
        ImageDecoder.Source createSource;
        try {
            try {
                xj2 = xj(getContext(), com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().pl() ? "GIF_AD_CACHE/" : "/GIF_CACHE/", "TT_GIF_FILE");
                fileOutputStream = new FileOutputStream(xj2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                if (Build.VERSION.SDK_INT < 28) {
                    fileOutputStream.close();
                    return null;
                }
                createSource = ImageDecoder.createSource(xj2);
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
                return createSource;
            } catch (Throwable th2) {
                th = th2;
                try {
                    pl.w("GifView", "GifView  getSourceByFile fail : ", th);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Throwable th3) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable unused3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setImageDrawable(drawable);
        if (Build.VERSION.SDK_INT >= 28 && ADYaiT.BI9f7h(drawable)) {
            AnimatedImageDrawable AaHO0E2 = ADYaiT.AaHO0E(drawable);
            this.kd = AaHO0E2;
            if (!this.g) {
                AaHO0E2.start();
            }
            if (!this.qt) {
                AaHO0E2.setRepeatCount(0);
            }
        }
        w();
    }

    private void u() {
        if (this.hf == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.w == 0) {
            this.w = uptimeMillis;
        }
        int duration = this.hf.duration();
        if (duration == 0) {
            duration = 1000;
        }
        if (this.qt || Math.abs(duration - this.u) >= 60) {
            this.u = (int) ((uptimeMillis - this.w) % duration);
        } else {
            this.u = duration;
            this.g = true;
        }
    }

    private void w() {
        if (this.hf == null || this.y || !this.am) {
            return;
        }
        postInvalidateOnAnimation();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.hf == null || this.y) {
            super.onDraw(canvas);
            return;
        }
        try {
            if (this.g) {
                xj(canvas);
                return;
            }
            u();
            xj(canvas);
            w();
        } catch (Throwable th) {
            pl.w("GifView", "onDraw->Throwable->", th);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.hf != null && !this.y) {
            this.f = (getWidth() - this.p) / 2.0f;
            this.d = (getHeight() - this.f10197pl) / 2.0f;
        }
        this.am = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i, i2);
        if (this.y || (movie = this.hf) == null) {
            return;
        }
        int width = movie.width();
        int height = this.hf.height();
        float max = 1.0f / Math.max((View.MeasureSpec.getMode(i) == 0 || width <= (size2 = View.MeasureSpec.getSize(i))) ? 1.0f : width / size2, (View.MeasureSpec.getMode(i2) == 0 || height <= (size = View.MeasureSpec.getSize(i2))) ? 1.0f : height / size);
        this.tf = max;
        int i3 = (int) (width * max);
        this.p = i3;
        int i4 = (int) (height * max);
        this.f10197pl = i4;
        setMeasuredDimension(i3, i4);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (this.hf != null) {
            this.am = i == 1;
            w();
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.hf != null) {
            this.am = i == 0;
            w();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.hf != null) {
            this.am = i == 0;
            w();
        }
    }

    public void setRepeatConfig(boolean z) {
        AnimatedImageDrawable animatedImageDrawable;
        this.qt = z;
        if (z) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 28 || (animatedImageDrawable = this.kd) == null) {
                return;
            }
            animatedImageDrawable.setRepeatCount(0);
        } catch (Exception e) {
            pl.w("GifView", "setRepeatConfig error", e);
        }
    }

    public void xj() {
        if (this.y) {
            return;
        }
        setLayerType(1, null);
    }

    public void xj(int i, boolean z) {
        this.g = z;
        this.xj = i;
        if (i == -1) {
            return;
        }
        if (!this.y) {
            this.hf = xj(i);
        } else {
            xj(i, new xj() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.1
                @Override // com.bytedance.sdk.component.adexpress.widget.GifView.xj
                public void xj(final Drawable drawable) {
                    GifView.this.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GifView.this.setDrawable(drawable);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageDecoder.Source hf(int i) {
        ImageDecoder.Source createSource;
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        createSource = ImageDecoder.createSource(jk.xj(getContext()), i);
        return createSource;
    }

    public void xj(byte[] bArr, boolean z) {
        this.g = z;
        if (bArr == null) {
            return;
        }
        if (!this.y) {
            this.hf = xj(bArr);
        } else {
            xj(bArr, new xj() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.2
                @Override // com.bytedance.sdk.component.adexpress.widget.GifView.xj
                public void xj(final Drawable drawable) {
                    GifView.this.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GifView.this.setDrawable(drawable);
                        }
                    });
                }
            });
        }
    }

    public void hf() {
        boolean isRunning;
        if (this.hf == null || !this.g) {
            return;
        }
        this.g = false;
        if (!this.y) {
            this.w = SystemClock.uptimeMillis() - this.u;
            invalidate();
            return;
        }
        AnimatedImageDrawable animatedImageDrawable = this.kd;
        if (animatedImageDrawable != null) {
            isRunning = animatedImageDrawable.isRunning();
            if (isRunning) {
                return;
            }
            this.kd.start();
        }
    }

    private Movie xj(int i) {
        try {
            return Movie.decodeStream(jk.xj(getContext()).openRawResource(i));
        } catch (Throwable unused) {
            return null;
        }
    }

    private Movie xj(byte[] bArr) {
        try {
            return Movie.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void xj(final int i, final xj xjVar) {
        if (i == -1) {
            return;
        }
        kd.xj(new d("createGifApi28WithByteArrayBySafely") { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.3
            @Override // java.lang.Runnable
            public void run() {
                xj xjVar2 = xjVar;
                if (xjVar2 != null) {
                    GifView gifView = GifView.this;
                    xjVar2.xj(gifView.xj(gifView.hf(i)));
                }
            }
        }, 5);
    }

    private void xj(final byte[] bArr, final xj xjVar) {
        if (bArr == null) {
            return;
        }
        kd.xj(new d("createGifApi28WithByteArrayBySafely") { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.4
            @Override // java.lang.Runnable
            public void run() {
                xj xjVar2 = xjVar;
                if (xjVar2 != null) {
                    GifView gifView = GifView.this;
                    xjVar2.xj(gifView.xj(gifView.hf(bArr)));
                }
            }
        }, 5);
    }

    public static File xj(Context context, String str, String str2) {
        int p = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().p();
        boolean pl2 = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().pl();
        if (p == 1) {
            pl.u("splashLoadAd", "视频存储使用内部存储");
            return y.hf(context, pl2, str, str2);
        }
        pl.u("splashLoadAd", "视频存储使用外存储");
        return y.xj(context, pl2, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable xj(ImageDecoder.Source source) {
        Drawable decodeDrawable;
        try {
            if (Build.VERSION.SDK_INT < 28) {
                return null;
            }
            decodeDrawable = ImageDecoder.decodeDrawable(source);
            return decodeDrawable;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void xj(Canvas canvas) {
        Movie movie = this.hf;
        if (movie == null) {
            return;
        }
        movie.setTime(this.u);
        float f = this.tf;
        if (f == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.hf.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f, f);
            Movie movie2 = this.hf;
            float f2 = this.f;
            float f3 = this.tf;
            movie2.draw(canvas, f2 / f3, this.d / f3);
        }
        canvas.restore();
    }
}
