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

public class GameView extends SurfaceView {
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

    public void setBrightness(int percent) {
        if (percent < 50) {
            percent = 50;
        }
        if (percent > 150) {
            percent = 150;
        }
        brightness = percent;
        if (percent == 100) {
            paint.setColorFilter(null);
            return;
        }
        float scale = percent / 100f;
        paint.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{
                scale, 0, 0, 0, 0,
                0, scale, 0, 0, 0,
                0, 0, scale, 0, 0,
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
        SurfaceHolder holder = getHolder();
        Canvas canvas = holder.lockCanvas();
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
