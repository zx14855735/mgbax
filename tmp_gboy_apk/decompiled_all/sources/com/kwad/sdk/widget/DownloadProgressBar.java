package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DownloadProgressBar extends View {
    Paint bhV;
    Paint bhW;
    Paint bhX;
    private String bhY;
    private float bhZ;
    private Rect bia;
    private LinearGradient bib;
    private LinearGradient bic;
    private LinearGradient bid;
    private Runnable bie;
    private Matrix mMatrix;
    private Path mPath;
    private RectF mRectF;
    private long mStartTime;

    public DownloadProgressBar(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.bie);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.clipPath(this.mPath);
        this.bhV.setShader(this.bib);
        canvas.drawRect(this.mRectF, this.bhV);
        this.bhV.setShader(this.bic);
        canvas.drawRect(0.0f, 0.0f, (getWidth() * this.bhZ) / 100.0f, getHeight(), this.bhV);
        float f = this.bhZ;
        float f2 = 0.0f;
        if (f > 0.0f && f < 100.0f) {
            long elapsedRealtime = (SystemClock.elapsedRealtime() - this.mStartTime) % 2500;
            float f3 = elapsedRealtime >= 1500 ? 0.0f : elapsedRealtime / 1500.0f;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f3);
            this.bid.setLocalMatrix(this.mMatrix);
            this.bhW.setShader(this.bid);
            canvas.drawRect(0.0f, 0.0f, ((getWidth() * this.bhZ) / 100.0f) * f3, getHeight(), this.bhW);
            if (elapsedRealtime > 500 && elapsedRealtime <= 1500) {
                f2 = (elapsedRealtime - 500) / 1000.0f;
            }
            float width = ((getWidth() * this.bhZ) / 100.0f) * f2;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f3);
            this.bid.setLocalMatrix(this.mMatrix);
            this.bhW.setShader(this.bid);
            canvas.drawRect(0.0f, 0.0f, width, getHeight(), this.bhW);
        }
        String str = this.bhY;
        if (str != null) {
            this.bhX.getTextBounds(str, 0, str.length(), this.bia);
            Rect rect = this.bia;
            canvas.drawText(this.bhY, getWidth() / 2.0f, (getHeight() / 2.0f) - ((rect.top + rect.bottom) / 2.0f), this.bhX);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.bib = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{1291525714, 1291569420}, new float[]{0.0f, 1.0f}, tileMode);
        this.bic = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{-319918, -276212}, new float[]{0.0f, 1.0f}, tileMode);
        this.bhV.setShader(this.bib);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{16501004, -276212}, new float[]{0.0f, 1.0f}, tileMode);
        this.bid = linearGradient;
        this.bhW.setShader(linearGradient);
        float f = i;
        this.mRectF.set(0.0f, 0.0f, f, i2);
        this.mPath.reset();
        float f2 = f / 2.0f;
        this.mPath.addRoundRect(this.mRectF, f2, f2, Path.Direction.CW);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            removeCallbacks(this.bie);
            return;
        }
        float f = this.bhZ;
        if (f <= 0.0f || f >= 100.0f) {
            return;
        }
        this.mStartTime = SystemClock.elapsedRealtime();
        post(this.bie);
    }

    public void setProgress(float f) {
        this.bhZ = f;
        invalidate();
        if (f == 0.0f || f == 100.0f) {
            removeCallbacks(this.bie);
        } else if (getWindowVisibility() == 0 && this.mStartTime == 0) {
            post(this.bie);
        }
    }

    public void setText(String str) {
        this.bhY = str;
        invalidate();
    }

    public DownloadProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bie = new Runnable() { // from class: com.kwad.sdk.widget.DownloadProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                DownloadProgressBar.this.invalidate();
                if (DownloadProgressBar.this.getWindowVisibility() == 0) {
                    DownloadProgressBar.this.postDelayed(this, 34L);
                }
            }
        };
        this.bhV = new Paint(1);
        this.bhW = new Paint(1);
        this.mRectF = new RectF();
        Paint paint = new Paint(1);
        this.bhX = paint;
        paint.setTextSize(com.kwad.sdk.c.a.a.a(context, 16.0f));
        this.bhX.setColor(-1);
        this.bhX.setTextAlign(Paint.Align.CENTER);
        this.bia = new Rect();
        this.mMatrix = new Matrix();
        this.mPath = new Path();
    }
}
