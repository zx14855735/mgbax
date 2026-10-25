/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private final Paint paint = new Paint();
    private final Paint scanPaint = new Paint();
    private final Rect src = new Rect();
    private final Rect dst = new Rect();
    private Bitmap last;
    private int srcW = 240;
    private int srcH = 160;
    private boolean bilinear = true;
    private boolean lockAspect = true;
    private boolean integerScale;
    private boolean scanlines;
    private int brightness = 100;
    private int contrast = 100;
    private int filter = Shaders.FILTER_NONE;
    /** GL path for screen filters; the software path stays as the fallback. */
    private final ShaderRenderer renderer = new ShaderRenderer();

    public GameView(Context context) {
        this(context, null);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setFilterBitmap(true);
        paint.setDither(false);
        scanPaint.setColor(0x66000000);
        scanPaint.setStrokeWidth(1f);
        getHolder().setFormat(PixelFormat.OPAQUE);
        getHolder().addCallback(this);
        setFocusable(true);
    }

    public void setBilinear(boolean enabled) {
        bilinear = enabled;
        paint.setFilterBitmap(enabled);
    }

    public void setLockAspect(boolean enabled) {
        if (lockAspect == enabled) {
            return;
        }
        lockAspect = enabled;
        requestLayout();
    }

    public void setIntegerScale(boolean enabled) {
        if (integerScale == enabled) {
            return;
        }
        integerScale = enabled;
        requestLayout();
    }

    public void setScanlines(boolean enabled) {
        scanlines = enabled;
    }

    /** Selects a screen filter; {@link Shaders#FILTER_NONE} uses the plain GL blit. */
    public void setFilter(int filterId) {
        if (filter != filterId) {
            filter = filterId;
            renderer.setFilter(filterId);
        }
    }

    /** True when what is on screen differs from the raw core frame. */
    public boolean screenFiltered() {
        return filter != Shaders.FILTER_NONE || scanlines;
    }

    public void setBrightness(int percent) {
        if (percent < 50) {
            percent = 50;
        }
        if (percent > 150) {
            percent = 150;
        }
        brightness = percent;
        updateColorFilter();
    }

    /** Contrast around the mid gray, 50-150 percent; 100 leaves colors as-is. */
    public void setContrast(int percent) {
        if (percent < 50) {
            percent = 50;
        }
        if (percent > 150) {
            percent = 150;
        }
        contrast = percent;
        updateColorFilter();
    }

    private void updateColorFilter() {
        if (brightness == 100 && contrast == 100) {
            paint.setColorFilter(null);
            return;
        }
        float b = brightness / 100f;
        float c = contrast / 100f;
        float lift = 128 * (1 - c);
        paint.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{
                b * c, 0, 0, 0, lift,
                0, b * c, 0, 0, lift,
                0, 0, b * c, 0, lift,
                0, 0, 0, 1, 0
        })));
    }

    public synchronized Bitmap copyLast() {
        if (last == null) {
            return null;
        }
        return last.copy(Bitmap.Config.ARGB_8888, false);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        renderer.releaseSurface();
    }

    @Override
    protected void onDetachedFromWindow() {
        renderer.release();
        super.onDetachedFromWindow();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        if (w <= 0 || h <= 0 || !lockAspect) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int outW;
        int outH;
        if (integerScale && w >= srcW && h >= srcH) {
            int scale = Math.min(w / srcW, h / srcH);
            outW = srcW * scale;
            outH = srcH * scale;
        } else {
            float scale = Math.min(w / (float) srcW, h / (float) srcH);
            outW = Math.max(1, Math.round(srcW * scale));
            outH = Math.max(1, Math.round(srcH * scale));
        }
        setMeasuredDimension(outW, outH);
    }

    public synchronized void present(Bitmap bitmap) {
        if (bitmap != null && (bitmap.getWidth() != srcW || bitmap.getHeight() != srcH)) {
            srcW = Math.max(1, bitmap.getWidth());
            srcH = Math.max(1, bitmap.getHeight());
            post(this::requestLayout);
        }
        boolean drawn = false;
        // Once the GL environment is up it owns the surface for good, from the
        // first presented frame on, even without a filter. A hardware Canvas
        // that ever touches the surface makes every later
        // eglCreateWindowSurface fail with EGL_BAD_ALLOC, which used to kill
        // all filters silently whenever a filter was picked mid-run. The
        // Canvas path only runs while GL is (still considered) unavailable.
        if (renderer.envAlive() && getWidth() > 0 && getHeight() > 0) {
            place(getWidth(), getHeight(), bitmap == null ? srcW : bitmap.getWidth(),
                    bitmap == null ? srcH : bitmap.getHeight(), dst);
            try {
                drawn = renderer.present(getHolder().getSurface(), bitmap, dst,
                        getWidth(), getHeight(), filter, brightness / 100f, contrast / 100f,
                        bilinear, scanlines);
            } catch (Exception e) {
                // GL owns the surface; a failed frame just keeps the last one.
                drawn = true;
            }
        }
        if (drawn) {
            keepLast(bitmap);
            return;
        }
        SurfaceHolder holder = getHolder();
        Canvas canvas = holder.lockHardwareCanvas();
        if (canvas == null) {
            canvas = holder.lockCanvas();
        }
        if (canvas != null) {
            try {
                canvas.drawColor(Color.BLACK);
                if (bitmap != null) {
                    src.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    place(canvas.getWidth(), canvas.getHeight(), bitmap.getWidth(), bitmap.getHeight(), dst);
                    canvas.drawBitmap(bitmap, src, dst, paint);
                    if (scanlines && dst.height() > 2) {
                        for (int y = dst.top + 1; y < dst.bottom; y += 2) {
                            canvas.drawLine(dst.left, y, dst.right, y, scanPaint);
                        }
                    }
                }
            } finally {
                holder.unlockCanvasAndPost(canvas);
            }
        }
        keepLast(bitmap);
    }

    private void keepLast(Bitmap bitmap) {
        if (last != null && last != bitmap) {
            last.recycle();
        }
        last = bitmap;
    }

    private void place(int viewW, int viewH, int bmpW, int bmpH, Rect out) {
        if (viewW <= 0 || viewH <= 0 || bmpW <= 0 || bmpH <= 0) {
            out.set(0, 0, 0, 0);
            return;
        }
        if (!lockAspect) {
            out.set(0, 0, viewW, viewH);
            return;
        }
        if (integerScale && viewW >= bmpW && viewH >= bmpH) {
            int scale = Math.min(viewW / bmpW, viewH / bmpH);
            int w = bmpW * scale;
            int h = bmpH * scale;
            int left = (viewW - w) / 2;
            int top = (viewH - h) / 2;
            out.set(left, top, left + w, top + h);
            return;
        }
        float scale = Math.min(viewW / (float) bmpW, viewH / (float) bmpH);
        int w = Math.max(1, Math.round(bmpW * scale));
        int h = Math.max(1, Math.round(bmpH * scale));
        int left = (viewW - w) / 2;
        int top = (viewH - h) / 2;
        out.set(left, top, left + w, top + h);
    }
}
